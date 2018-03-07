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
import com.facebook.friends.protocol.FetchFriendRequestsGraphQLParsers.FriendRequestQueryParser;
import com.facebook.friends.protocol.FetchFriendRequestsGraphQLParsers.FriendRequestQueryParser.FriendingPossibilitiesParser;
import com.facebook.friends.protocol.FetchFriendRequestsGraphQLParsers.FriendingPossibilityParser;
import com.facebook.friends.protocol.FetchFriendRequestsGraphQLParsers.FriendingPossibilityParser.SuggestersParser;
import com.facebook.friends.protocol.FetchFriendRequestsGraphQLParsers.FriendingPossibilityUserParser;
import com.facebook.friends.protocol.FetchFriendRequestsGraphQLParsers.FriendingPossibilityUserParser.ProfilePictureParser;
import com.facebook.friends.protocol.FetchFriendRequestsGraphQLParsers.FriendingPossibilityUserParser.SocialContextParser;
import com.facebook.graphql.enums.GraphQLFriendshipStatus;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.querybuilder.common.CommonGraphQL2Models.DefaultPageInfoFieldsModel;
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

/* compiled from: mapOverwrite */
public class FetchFriendRequestsGraphQLModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1896953482)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: mapOverwrite */
    public final class FriendRequestQueryModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private FriendingPossibilitiesModel f10704d;

        /* compiled from: mapOverwrite */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FriendRequestQueryModel.class, new Deserializer());
            }

            public Object m16934a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = FriendRequestQueryParser.m16986a(jsonParser);
                Object friendRequestQueryModel = new FriendRequestQueryModel();
                ((BaseModel) friendRequestQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (friendRequestQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) friendRequestQueryModel).a();
                }
                return friendRequestQueryModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -527098622)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: mapOverwrite */
        public final class FriendingPossibilitiesModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<FriendingPossibilityModel> f10702d;
            @Nullable
            private DefaultPageInfoFieldsModel f10703e;

            /* compiled from: mapOverwrite */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(FriendingPossibilitiesModel.class, new Deserializer());
                }

                public Object m16935a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(FriendingPossibilitiesParser.m16984a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object friendingPossibilitiesModel = new FriendingPossibilitiesModel();
                    ((BaseModel) friendingPossibilitiesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (friendingPossibilitiesModel instanceof Postprocessable) {
                        return ((Postprocessable) friendingPossibilitiesModel).a();
                    }
                    return friendingPossibilitiesModel;
                }
            }

            /* compiled from: mapOverwrite */
            public class Serializer extends JsonSerializer<FriendingPossibilitiesModel> {
                public final void m16936a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    FriendingPossibilitiesModel friendingPossibilitiesModel = (FriendingPossibilitiesModel) obj;
                    if (friendingPossibilitiesModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(friendingPossibilitiesModel.m16937a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        friendingPossibilitiesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    FriendingPossibilitiesParser.m16985a(friendingPossibilitiesModel.w_(), friendingPossibilitiesModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(FriendingPossibilitiesModel.class, new Serializer());
                }
            }

            public FriendingPossibilitiesModel() {
                super(2);
            }

            @Nonnull
            public final ImmutableList<FriendingPossibilityModel> m16939a() {
                this.f10702d = super.a(this.f10702d, 0, FriendingPossibilityModel.class);
                return (ImmutableList) this.f10702d;
            }

            @Nullable
            public final DefaultPageInfoFieldsModel m16940j() {
                this.f10703e = (DefaultPageInfoFieldsModel) super.a(this.f10703e, 1, DefaultPageInfoFieldsModel.class);
                return this.f10703e;
            }

            public final int jK_() {
                return 1085064779;
            }

            public final GraphQLVisitableModel m16938a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel;
                DefaultPageInfoFieldsModel defaultPageInfoFieldsModel;
                h();
                if (m16939a() != null) {
                    Builder a = ModelHelper.a(m16939a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        FriendingPossibilitiesModel friendingPossibilitiesModel = (FriendingPossibilitiesModel) ModelHelper.a(null, this);
                        friendingPossibilitiesModel.f10702d = a.b();
                        graphQLVisitableModel = friendingPossibilitiesModel;
                        if (m16940j() != null) {
                            defaultPageInfoFieldsModel = (DefaultPageInfoFieldsModel) graphQLModelMutatingVisitor.b(m16940j());
                            if (m16940j() != defaultPageInfoFieldsModel) {
                                graphQLVisitableModel = (FriendingPossibilitiesModel) ModelHelper.a(graphQLVisitableModel, this);
                                graphQLVisitableModel.f10703e = defaultPageInfoFieldsModel;
                            }
                        }
                        i();
                        return graphQLVisitableModel != null ? this : graphQLVisitableModel;
                    }
                }
                graphQLVisitableModel = null;
                if (m16940j() != null) {
                    defaultPageInfoFieldsModel = (DefaultPageInfoFieldsModel) graphQLModelMutatingVisitor.b(m16940j());
                    if (m16940j() != defaultPageInfoFieldsModel) {
                        graphQLVisitableModel = (FriendingPossibilitiesModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f10703e = defaultPageInfoFieldsModel;
                    }
                }
                i();
                if (graphQLVisitableModel != null) {
                }
            }

            public final int m16937a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m16939a());
                int a2 = ModelHelper.a(flatBufferBuilder, m16940j());
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, a2);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: mapOverwrite */
        public class Serializer extends JsonSerializer<FriendRequestQueryModel> {
            public final void m16941a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                FriendRequestQueryModel friendRequestQueryModel = (FriendRequestQueryModel) obj;
                if (friendRequestQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(friendRequestQueryModel.m16942a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    friendRequestQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = friendRequestQueryModel.w_();
                int u_ = friendRequestQueryModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("friending_possibilities");
                    FriendingPossibilitiesParser.m16985a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(FriendRequestQueryModel.class, new Serializer());
            }
        }

        public FriendRequestQueryModel() {
            super(1);
        }

        @Nullable
        public final FriendingPossibilitiesModel m16943a() {
            this.f10704d = (FriendingPossibilitiesModel) super.a(this.f10704d, 0, FriendingPossibilitiesModel.class);
            return this.f10704d;
        }

        public final int jK_() {
            return -1732764110;
        }

        public final GraphQLVisitableModel m16944a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m16943a() != null) {
                FriendingPossibilitiesModel friendingPossibilitiesModel = (FriendingPossibilitiesModel) graphQLModelMutatingVisitor.b(m16943a());
                if (m16943a() != friendingPossibilitiesModel) {
                    graphQLVisitableModel = (FriendRequestQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f10704d = friendingPossibilitiesModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m16942a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m16943a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1734088800)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: mapOverwrite */
    public final class FriendingPossibilityModel extends BaseModel implements GraphQLVisitableModel {
        private boolean f10706d;
        @Nullable
        private FriendingPossibilityUserModel f10707e;
        @Nullable
        private List<SuggestersModel> f10708f;
        @Nullable
        private String f10709g;

        /* compiled from: mapOverwrite */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FriendingPossibilityModel.class, new Deserializer());
            }

            public Object m16945a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(FriendingPossibilityParser.m16990b(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object friendingPossibilityModel = new FriendingPossibilityModel();
                ((BaseModel) friendingPossibilityModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (friendingPossibilityModel instanceof Postprocessable) {
                    return ((Postprocessable) friendingPossibilityModel).a();
                }
                return friendingPossibilityModel;
            }
        }

        /* compiled from: mapOverwrite */
        public class Serializer extends JsonSerializer<FriendingPossibilityModel> {
            public final void m16946a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                FriendingPossibilityModel friendingPossibilityModel = (FriendingPossibilityModel) obj;
                if (friendingPossibilityModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(friendingPossibilityModel.m16954a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    friendingPossibilityModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                FriendingPossibilityParser.m16991b(friendingPossibilityModel.w_(), friendingPossibilityModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(FriendingPossibilityModel.class, new Serializer());
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 273304230)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: mapOverwrite */
        public final class SuggestersModel extends BaseModel implements GraphQLVisitableConsistentModel {
            @Nullable
            private String f10705d;

            /* compiled from: mapOverwrite */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(SuggestersModel.class, new Deserializer());
                }

                public Object m16947a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(SuggestersParser.m16989b(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object suggestersModel = new SuggestersModel();
                    ((BaseModel) suggestersModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (suggestersModel instanceof Postprocessable) {
                        return ((Postprocessable) suggestersModel).a();
                    }
                    return suggestersModel;
                }
            }

            /* compiled from: mapOverwrite */
            public class Serializer extends JsonSerializer<SuggestersModel> {
                public final void m16948a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    SuggestersModel suggestersModel = (SuggestersModel) obj;
                    if (suggestersModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(suggestersModel.m16949a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        suggestersModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    SuggestersParser.m16988a(suggestersModel.w_(), suggestersModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(SuggestersModel.class, new Serializer());
                }
            }

            public SuggestersModel() {
                super(1);
            }

            public final void m16952a(String str, ConsistencyTuple consistencyTuple) {
                consistencyTuple.a();
            }

            public final void m16953a(String str, Object obj, boolean z) {
            }

            @Nullable
            public final String m16951a() {
                this.f10705d = super.a(this.f10705d, 0);
                return this.f10705d;
            }

            public final int jK_() {
                return 2645995;
            }

            public final GraphQLVisitableModel m16950a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m16949a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m16951a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        public FriendingPossibilityModel() {
            super(4);
        }

        public final boolean m16957a() {
            a(0, 0);
            return this.f10706d;
        }

        @Nullable
        public final FriendingPossibilityUserModel m16958j() {
            this.f10707e = (FriendingPossibilityUserModel) super.a(this.f10707e, 1, FriendingPossibilityUserModel.class);
            return this.f10707e;
        }

        @Nonnull
        public final ImmutableList<SuggestersModel> m16959k() {
            this.f10708f = super.a(this.f10708f, 2, SuggestersModel.class);
            return (ImmutableList) this.f10708f;
        }

        @Nullable
        public final String m16960l() {
            this.f10709g = super.a(this.f10709g, 3);
            return this.f10709g;
        }

        public final int jK_() {
            return 923339498;
        }

        public final GraphQLVisitableModel m16955a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m16958j() != null) {
                FriendingPossibilityUserModel friendingPossibilityUserModel = (FriendingPossibilityUserModel) graphQLModelMutatingVisitor.b(m16958j());
                if (m16958j() != friendingPossibilityUserModel) {
                    graphQLVisitableModel = (FriendingPossibilityModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f10707e = friendingPossibilityUserModel;
                }
            }
            if (m16959k() != null) {
                Builder a = ModelHelper.a(m16959k(), graphQLModelMutatingVisitor);
                if (a != null) {
                    FriendingPossibilityModel friendingPossibilityModel = (FriendingPossibilityModel) ModelHelper.a(graphQLVisitableModel, this);
                    friendingPossibilityModel.f10708f = a.b();
                    graphQLVisitableModel = friendingPossibilityModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m16954a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m16958j());
            int a2 = ModelHelper.a(flatBufferBuilder, m16959k());
            int b = flatBufferBuilder.b(m16960l());
            flatBufferBuilder.c(4);
            flatBufferBuilder.a(0, this.f10706d);
            flatBufferBuilder.b(1, a);
            flatBufferBuilder.b(2, a2);
            flatBufferBuilder.b(3, b);
            i();
            return flatBufferBuilder.d();
        }

        public final void m16956a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f10706d = mutableFlatBuffer.a(i, 0);
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -825890294)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: mapOverwrite */
    public final class FriendingPossibilityUserModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
        @Nullable
        private GraphQLFriendshipStatus f10712d;
        @Nullable
        private String f10713e;
        @Nullable
        private String f10714f;
        @Nullable
        private ProfilePictureModel f10715g;
        @Nullable
        private SocialContextModel f10716h;

        /* compiled from: mapOverwrite */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FriendingPossibilityUserModel.class, new Deserializer());
            }

            public Object m16961a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(FriendingPossibilityUserParser.m16996a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object friendingPossibilityUserModel = new FriendingPossibilityUserModel();
                ((BaseModel) friendingPossibilityUserModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (friendingPossibilityUserModel instanceof Postprocessable) {
                    return ((Postprocessable) friendingPossibilityUserModel).a();
                }
                return friendingPossibilityUserModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 842551240)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: mapOverwrite */
        public final class ProfilePictureModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private String f10710d;

            /* compiled from: mapOverwrite */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(ProfilePictureModel.class, new Deserializer());
                }

                public Object m16962a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(ProfilePictureParser.m16992a(jsonParser, flatBufferBuilder));
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

            /* compiled from: mapOverwrite */
            public class Serializer extends JsonSerializer<ProfilePictureModel> {
                public final void m16963a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    ProfilePictureModel profilePictureModel = (ProfilePictureModel) obj;
                    if (profilePictureModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(profilePictureModel.m16964a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        profilePictureModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    ProfilePictureParser.m16993a(profilePictureModel.w_(), profilePictureModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(ProfilePictureModel.class, new Serializer());
                }
            }

            public ProfilePictureModel() {
                super(1);
            }

            @Nullable
            public final String m16966a() {
                this.f10710d = super.a(this.f10710d, 0);
                return this.f10710d;
            }

            public final int jK_() {
                return 70760763;
            }

            public final GraphQLVisitableModel m16965a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m16964a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m16966a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: mapOverwrite */
        public class Serializer extends JsonSerializer<FriendingPossibilityUserModel> {
            public final void m16967a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                FriendingPossibilityUserModel friendingPossibilityUserModel = (FriendingPossibilityUserModel) obj;
                if (friendingPossibilityUserModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(friendingPossibilityUserModel.m16974a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    friendingPossibilityUserModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                FriendingPossibilityUserParser.m16997a(friendingPossibilityUserModel.w_(), friendingPossibilityUserModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(FriendingPossibilityUserModel.class, new Serializer());
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1352864475)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: mapOverwrite */
        public final class SocialContextModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private String f10711d;

            /* compiled from: mapOverwrite */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(SocialContextModel.class, new Deserializer());
                }

                public Object m16968a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(SocialContextParser.m16994a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object socialContextModel = new SocialContextModel();
                    ((BaseModel) socialContextModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (socialContextModel instanceof Postprocessable) {
                        return ((Postprocessable) socialContextModel).a();
                    }
                    return socialContextModel;
                }
            }

            /* compiled from: mapOverwrite */
            public class Serializer extends JsonSerializer<SocialContextModel> {
                public final void m16969a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    SocialContextModel socialContextModel = (SocialContextModel) obj;
                    if (socialContextModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(socialContextModel.m16970a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        socialContextModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    SocialContextParser.m16995a(socialContextModel.w_(), socialContextModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(SocialContextModel.class, new Serializer());
                }
            }

            public SocialContextModel() {
                super(1);
            }

            @Nullable
            public final String m16972a() {
                this.f10711d = super.a(this.f10711d, 0);
                return this.f10711d;
            }

            public final int jK_() {
                return -1919764332;
            }

            public final GraphQLVisitableModel m16971a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m16970a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m16972a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        public FriendingPossibilityUserModel() {
            super(5);
        }

        public final void m16977a(String str, ConsistencyTuple consistencyTuple) {
            if ("friendship_status".equals(str)) {
                consistencyTuple.a = m16979j();
                consistencyTuple.b = u_();
                consistencyTuple.c = 0;
                return;
            }
            consistencyTuple.a();
        }

        public final void m16978a(String str, Object obj, boolean z) {
            if ("friendship_status".equals(str)) {
                m16973a((GraphQLFriendshipStatus) obj);
            }
        }

        @Nullable
        public final GraphQLFriendshipStatus m16979j() {
            this.f10712d = (GraphQLFriendshipStatus) super.b(this.f10712d, 0, GraphQLFriendshipStatus.class, GraphQLFriendshipStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f10712d;
        }

        private void m16973a(GraphQLFriendshipStatus graphQLFriendshipStatus) {
            this.f10712d = graphQLFriendshipStatus;
            if (this.b != null && this.b.d) {
                this.b.a(this.c, 0, graphQLFriendshipStatus != null ? graphQLFriendshipStatus.name() : null);
            }
        }

        @Nullable
        public final String m16980k() {
            this.f10713e = super.a(this.f10713e, 1);
            return this.f10713e;
        }

        @Nullable
        public final String m16981l() {
            this.f10714f = super.a(this.f10714f, 2);
            return this.f10714f;
        }

        @Nullable
        public final ProfilePictureModel m16982m() {
            this.f10715g = (ProfilePictureModel) super.a(this.f10715g, 3, ProfilePictureModel.class);
            return this.f10715g;
        }

        @Nullable
        public final SocialContextModel m16983n() {
            this.f10716h = (SocialContextModel) super.a(this.f10716h, 4, SocialContextModel.class);
            return this.f10716h;
        }

        @Nullable
        public final String m16976a() {
            return m16980k();
        }

        public final int jK_() {
            return 2645995;
        }

        public final GraphQLVisitableModel m16975a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m16982m() != null) {
                ProfilePictureModel profilePictureModel = (ProfilePictureModel) graphQLModelMutatingVisitor.b(m16982m());
                if (m16982m() != profilePictureModel) {
                    graphQLVisitableModel = (FriendingPossibilityUserModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f10715g = profilePictureModel;
                }
            }
            if (m16983n() != null) {
                SocialContextModel socialContextModel = (SocialContextModel) graphQLModelMutatingVisitor.b(m16983n());
                if (m16983n() != socialContextModel) {
                    graphQLVisitableModel = (FriendingPossibilityUserModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f10716h = socialContextModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m16974a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = flatBufferBuilder.a(m16979j());
            int b = flatBufferBuilder.b(m16980k());
            int b2 = flatBufferBuilder.b(m16981l());
            int a2 = ModelHelper.a(flatBufferBuilder, m16982m());
            int a3 = ModelHelper.a(flatBufferBuilder, m16983n());
            flatBufferBuilder.c(5);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, b);
            flatBufferBuilder.b(2, b2);
            flatBufferBuilder.b(3, a2);
            flatBufferBuilder.b(4, a3);
            i();
            return flatBufferBuilder.d();
        }
    }
}
