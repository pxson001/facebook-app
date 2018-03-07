package com.facebook.heisman.protocol;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.visitor.ConsistencyTuple;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.heisman.protocol.HeismanSelfProfilePictureGraphQLParsers.SelfProfilePictureFieldsParser;
import com.facebook.heisman.protocol.HeismanSelfProfilePictureGraphQLParsers.SelfProfilePictureFieldsParser.ProfilePhotoParser;
import com.facebook.heisman.protocol.HeismanSelfProfilePictureGraphQLParsers.SelfProfilePictureFieldsParser.ProfilePictureParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

/* compiled from: position_ms */
public class HeismanSelfProfilePictureGraphQLModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -238267862)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: position_ms */
    public final class SelfProfilePictureFieldsModel extends BaseModel implements GraphQLVisitableConsistentModel {
        @Nullable
        private ProfilePhotoModel f6122d;
        @Nullable
        private ProfilePictureModel f6123e;

        /* compiled from: position_ms */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(SelfProfilePictureFieldsModel.class, new Deserializer());
            }

            public Object m7923a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = SelfProfilePictureFieldsParser.m7946a(jsonParser);
                Object selfProfilePictureFieldsModel = new SelfProfilePictureFieldsModel();
                ((BaseModel) selfProfilePictureFieldsModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (selfProfilePictureFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) selfProfilePictureFieldsModel).a();
                }
                return selfProfilePictureFieldsModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1801334754)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: position_ms */
        public final class ProfilePhotoModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
            @Nullable
            private String f6120d;

            /* compiled from: position_ms */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(ProfilePhotoModel.class, new Deserializer());
                }

                public Object m7924a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(ProfilePhotoParser.m7942a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object profilePhotoModel = new ProfilePhotoModel();
                    ((BaseModel) profilePhotoModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (profilePhotoModel instanceof Postprocessable) {
                        return ((Postprocessable) profilePhotoModel).a();
                    }
                    return profilePhotoModel;
                }
            }

            /* compiled from: position_ms */
            public class Serializer extends JsonSerializer<ProfilePhotoModel> {
                public final void m7925a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    ProfilePhotoModel profilePhotoModel = (ProfilePhotoModel) obj;
                    if (profilePhotoModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(profilePhotoModel.m7926a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        profilePhotoModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    ProfilePhotoParser.m7943a(profilePhotoModel.w_(), profilePhotoModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(ProfilePhotoModel.class, new Serializer());
                }
            }

            public ProfilePhotoModel() {
                super(1);
            }

            @Nullable
            public final String m7929j() {
                this.f6120d = super.a(this.f6120d, 0);
                return this.f6120d;
            }

            @Nullable
            public final String m7928a() {
                return m7929j();
            }

            public final int jK_() {
                return 77090322;
            }

            public final GraphQLVisitableModel m7927a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m7926a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m7929j());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 842551240)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: position_ms */
        public final class ProfilePictureModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private String f6121d;

            /* compiled from: position_ms */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(ProfilePictureModel.class, new Deserializer());
                }

                public Object m7930a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(ProfilePictureParser.m7944a(jsonParser, flatBufferBuilder));
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

            /* compiled from: position_ms */
            public class Serializer extends JsonSerializer<ProfilePictureModel> {
                public final void m7931a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    ProfilePictureModel profilePictureModel = (ProfilePictureModel) obj;
                    if (profilePictureModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(profilePictureModel.m7932a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        profilePictureModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    ProfilePictureParser.m7945a(profilePictureModel.w_(), profilePictureModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(ProfilePictureModel.class, new Serializer());
                }
            }

            public ProfilePictureModel() {
                super(1);
            }

            @Nullable
            public final String m7934a() {
                this.f6121d = super.a(this.f6121d, 0);
                return this.f6121d;
            }

            public final int jK_() {
                return 70760763;
            }

            public final GraphQLVisitableModel m7933a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m7932a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m7934a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: position_ms */
        public class Serializer extends JsonSerializer<SelfProfilePictureFieldsModel> {
            public final void m7935a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                SelfProfilePictureFieldsModel selfProfilePictureFieldsModel = (SelfProfilePictureFieldsModel) obj;
                if (selfProfilePictureFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(selfProfilePictureFieldsModel.m7936a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    selfProfilePictureFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = selfProfilePictureFieldsModel.w_();
                int u_ = selfProfilePictureFieldsModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("profile_photo");
                    ProfilePhotoParser.m7943a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(u_, 1);
                if (g != 0) {
                    jsonGenerator.a("profile_picture");
                    ProfilePictureParser.m7945a(mutableFlatBuffer, g, jsonGenerator);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(SelfProfilePictureFieldsModel.class, new Serializer());
            }
        }

        public SelfProfilePictureFieldsModel() {
            super(2);
        }

        public final void m7939a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m7940a(String str, Object obj, boolean z) {
        }

        @Nullable
        public final ProfilePhotoModel m7938a() {
            this.f6122d = (ProfilePhotoModel) super.a(this.f6122d, 0, ProfilePhotoModel.class);
            return this.f6122d;
        }

        @Nullable
        public final ProfilePictureModel m7941j() {
            this.f6123e = (ProfilePictureModel) super.a(this.f6123e, 1, ProfilePictureModel.class);
            return this.f6123e;
        }

        public final int jK_() {
            return 2645995;
        }

        public final GraphQLVisitableModel m7937a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m7938a() != null) {
                ProfilePhotoModel profilePhotoModel = (ProfilePhotoModel) graphQLModelMutatingVisitor.b(m7938a());
                if (m7938a() != profilePhotoModel) {
                    graphQLVisitableModel = (SelfProfilePictureFieldsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f6122d = profilePhotoModel;
                }
            }
            if (m7941j() != null) {
                ProfilePictureModel profilePictureModel = (ProfilePictureModel) graphQLModelMutatingVisitor.b(m7941j());
                if (m7941j() != profilePictureModel) {
                    graphQLVisitableModel = (SelfProfilePictureFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f6123e = profilePictureModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m7936a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m7938a());
            int a2 = ModelHelper.a(flatBufferBuilder, m7941j());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            i();
            return flatBufferBuilder.d();
        }
    }
}
