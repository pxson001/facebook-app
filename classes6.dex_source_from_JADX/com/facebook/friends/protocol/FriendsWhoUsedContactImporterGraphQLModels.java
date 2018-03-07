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
import com.facebook.friends.protocol.FriendsWhoUsedContactImporterGraphQLParsers.FacepileFieldsParser;
import com.facebook.friends.protocol.FriendsWhoUsedContactImporterGraphQLParsers.FacepileFieldsParser.ProfilePictureParser;
import com.facebook.friends.protocol.FriendsWhoUsedContactImporterGraphQLParsers.FacepileFriendsConnectionParser;
import com.facebook.friends.protocol.FriendsWhoUsedContactImporterGraphQLParsers.FriendsWhoUsedContactImporterQueryParser;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.modelutil.SerializerHelpers;
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

/* compiled from: mUpdatedTime */
public class FriendsWhoUsedContactImporterGraphQLModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1544366888)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: mUpdatedTime */
    public final class FacepileFieldsModel extends BaseModel implements GraphQLVisitableConsistentModel {
        @Nullable
        private String f10818d;
        @Nullable
        private ProfilePictureModel f10819e;

        /* compiled from: mUpdatedTime */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FacepileFieldsModel.class, new Deserializer());
            }

            public Object m17368a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(FacepileFieldsParser.m17399b(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object facepileFieldsModel = new FacepileFieldsModel();
                ((BaseModel) facepileFieldsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (facepileFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) facepileFieldsModel).a();
                }
                return facepileFieldsModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 842551240)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: mUpdatedTime */
        public final class ProfilePictureModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private String f10817d;

            /* compiled from: mUpdatedTime */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(ProfilePictureModel.class, new Deserializer());
                }

                public Object m17369a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(ProfilePictureParser.m17397a(jsonParser, flatBufferBuilder));
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

            /* compiled from: mUpdatedTime */
            public class Serializer extends JsonSerializer<ProfilePictureModel> {
                public final void m17370a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    ProfilePictureModel profilePictureModel = (ProfilePictureModel) obj;
                    if (profilePictureModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(profilePictureModel.m17371a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        profilePictureModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    ProfilePictureParser.m17398a(profilePictureModel.w_(), profilePictureModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(ProfilePictureModel.class, new Serializer());
                }
            }

            public ProfilePictureModel() {
                super(1);
            }

            @Nullable
            public final String m17373a() {
                this.f10817d = super.a(this.f10817d, 0);
                return this.f10817d;
            }

            public final int jK_() {
                return 70760763;
            }

            public final GraphQLVisitableModel m17372a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m17371a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m17373a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: mUpdatedTime */
        public class Serializer extends JsonSerializer<FacepileFieldsModel> {
            public final void m17374a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                FacepileFieldsModel facepileFieldsModel = (FacepileFieldsModel) obj;
                if (facepileFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(facepileFieldsModel.m17376a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    facepileFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                FacepileFieldsParser.m17400b(facepileFieldsModel.w_(), facepileFieldsModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(FacepileFieldsModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ ProfilePictureModel m17381b() {
            return m17375j();
        }

        public FacepileFieldsModel() {
            super(2);
        }

        public final void m17379a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m17380a(String str, Object obj, boolean z) {
        }

        @Nullable
        public final String m17378a() {
            this.f10818d = super.a(this.f10818d, 0);
            return this.f10818d;
        }

        @Nullable
        private ProfilePictureModel m17375j() {
            this.f10819e = (ProfilePictureModel) super.a(this.f10819e, 1, ProfilePictureModel.class);
            return this.f10819e;
        }

        public final int jK_() {
            return 2645995;
        }

        public final GraphQLVisitableModel m17377a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m17375j() != null) {
                ProfilePictureModel profilePictureModel = (ProfilePictureModel) graphQLModelMutatingVisitor.b(m17375j());
                if (m17375j() != profilePictureModel) {
                    graphQLVisitableModel = (FacepileFieldsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f10819e = profilePictureModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m17376a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m17378a());
            int a = ModelHelper.a(flatBufferBuilder, m17375j());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, b);
            flatBufferBuilder.b(1, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1270229111)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: mUpdatedTime */
    public final class FacepileFriendsConnectionModel extends BaseModel implements GraphQLVisitableModel {
        private int f10820d;
        @Nullable
        private List<FacepileFieldsModel> f10821e;

        /* compiled from: mUpdatedTime */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FacepileFriendsConnectionModel.class, new Deserializer());
            }

            public Object m17382a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(FacepileFriendsConnectionParser.m17401a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object facepileFriendsConnectionModel = new FacepileFriendsConnectionModel();
                ((BaseModel) facepileFriendsConnectionModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (facepileFriendsConnectionModel instanceof Postprocessable) {
                    return ((Postprocessable) facepileFriendsConnectionModel).a();
                }
                return facepileFriendsConnectionModel;
            }
        }

        /* compiled from: mUpdatedTime */
        public class Serializer extends JsonSerializer<FacepileFriendsConnectionModel> {
            public final void m17383a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                FacepileFriendsConnectionModel facepileFriendsConnectionModel = (FacepileFriendsConnectionModel) obj;
                if (facepileFriendsConnectionModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(facepileFriendsConnectionModel.m17385a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    facepileFriendsConnectionModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                FacepileFriendsConnectionParser.m17402a(facepileFriendsConnectionModel.w_(), facepileFriendsConnectionModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(FacepileFriendsConnectionModel.class, new Serializer());
            }
        }

        public FacepileFriendsConnectionModel() {
            super(2);
        }

        public final int m17384a() {
            a(0, 0);
            return this.f10820d;
        }

        @Nonnull
        public final ImmutableList<FacepileFieldsModel> m17388j() {
            this.f10821e = super.a(this.f10821e, 1, FacepileFieldsModel.class);
            return (ImmutableList) this.f10821e;
        }

        public final int jK_() {
            return 569028147;
        }

        public final GraphQLVisitableModel m17386a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m17388j() != null) {
                Builder a = ModelHelper.a(m17388j(), graphQLModelMutatingVisitor);
                if (a != null) {
                    graphQLVisitableModel = (FacepileFriendsConnectionModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f10821e = a.b();
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m17385a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m17388j());
            flatBufferBuilder.c(2);
            flatBufferBuilder.a(0, this.f10820d, 0);
            flatBufferBuilder.b(1, a);
            i();
            return flatBufferBuilder.d();
        }

        public final void m17387a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f10820d = mutableFlatBuffer.a(i, 0, 0);
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1308842479)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: mUpdatedTime */
    public final class FriendsWhoUsedContactImporterQueryModel extends BaseModel implements GraphQLVisitableConsistentModel {
        @Nullable
        private GraphQLObjectType f10822d;
        @Nullable
        private FacepileFriendsConnectionModel f10823e;

        /* compiled from: mUpdatedTime */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FriendsWhoUsedContactImporterQueryModel.class, new Deserializer());
            }

            public Object m17389a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = FriendsWhoUsedContactImporterQueryParser.m17403a(jsonParser);
                Object friendsWhoUsedContactImporterQueryModel = new FriendsWhoUsedContactImporterQueryModel();
                ((BaseModel) friendsWhoUsedContactImporterQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (friendsWhoUsedContactImporterQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) friendsWhoUsedContactImporterQueryModel).a();
                }
                return friendsWhoUsedContactImporterQueryModel;
            }
        }

        /* compiled from: mUpdatedTime */
        public class Serializer extends JsonSerializer<FriendsWhoUsedContactImporterQueryModel> {
            public final void m17390a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                FriendsWhoUsedContactImporterQueryModel friendsWhoUsedContactImporterQueryModel = (FriendsWhoUsedContactImporterQueryModel) obj;
                if (friendsWhoUsedContactImporterQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(friendsWhoUsedContactImporterQueryModel.m17392a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    friendsWhoUsedContactImporterQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = friendsWhoUsedContactImporterQueryModel.w_();
                int u_ = friendsWhoUsedContactImporterQueryModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("__type__");
                    SerializerHelpers.b(mutableFlatBuffer, u_, 0, jsonGenerator);
                }
                int g = mutableFlatBuffer.g(u_, 1);
                if (g != 0) {
                    jsonGenerator.a("friends");
                    FacepileFriendsConnectionParser.m17402a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(FriendsWhoUsedContactImporterQueryModel.class, new Serializer());
            }
        }

        public FriendsWhoUsedContactImporterQueryModel() {
            super(2);
        }

        public final void m17395a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m17396a(String str, Object obj, boolean z) {
        }

        @Nullable
        private GraphQLObjectType m17391j() {
            if (this.b != null && this.f10822d == null) {
                this.f10822d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
            }
            return this.f10822d;
        }

        @Nullable
        public final FacepileFriendsConnectionModel m17393a() {
            this.f10823e = (FacepileFriendsConnectionModel) super.a(this.f10823e, 1, FacepileFriendsConnectionModel.class);
            return this.f10823e;
        }

        public final int jK_() {
            return 63093205;
        }

        public final GraphQLVisitableModel m17394a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m17393a() != null) {
                FacepileFriendsConnectionModel facepileFriendsConnectionModel = (FacepileFriendsConnectionModel) graphQLModelMutatingVisitor.b(m17393a());
                if (m17393a() != facepileFriendsConnectionModel) {
                    graphQLVisitableModel = (FriendsWhoUsedContactImporterQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f10823e = facepileFriendsConnectionModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m17392a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m17391j());
            int a2 = ModelHelper.a(flatBufferBuilder, m17393a());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            i();
            return flatBufferBuilder.d();
        }
    }
}
