package com.facebook.pages.data.graphql.fragments;

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
import com.facebook.graphql.modelutil.SerializerHelpers;
import com.facebook.graphql.visitor.ConsistencyTuple;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.pages.data.graphql.fragments.PostsByOthersFragmentGraphQLParsers.PostsByOthersFragmentQueryParser;
import com.facebook.pages.data.graphql.fragments.PostsByOthersFragmentGraphQLParsers.PostsByOthersFragmentQueryParser.ProfilePictureParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.google.common.collect.ImmutableList;
import java.nio.ByteBuffer;
import java.util.List;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/* compiled from: reads */
public class PostsByOthersFragmentGraphQLModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1842533001)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: reads */
    public final class PostsByOthersFragmentQueryModel extends BaseModel implements GraphQLVisitableConsistentModel {
        private boolean f2737d;
        private boolean f2738e;
        @Nullable
        private ProfilePictureModel f2739f;
        @Nullable
        private List<String> f2740g;

        /* compiled from: reads */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(PostsByOthersFragmentQueryModel.class, new Deserializer());
            }

            public Object m3663a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(PostsByOthersFragmentQueryParser.m3681a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object postsByOthersFragmentQueryModel = new PostsByOthersFragmentQueryModel();
                ((BaseModel) postsByOthersFragmentQueryModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (postsByOthersFragmentQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) postsByOthersFragmentQueryModel).a();
                }
                return postsByOthersFragmentQueryModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 842551240)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: reads */
        public final class ProfilePictureModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private String f2736d;

            /* compiled from: reads */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(ProfilePictureModel.class, new Deserializer());
                }

                public Object m3664a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(ProfilePictureParser.m3679a(jsonParser, flatBufferBuilder));
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

            /* compiled from: reads */
            public class Serializer extends JsonSerializer<ProfilePictureModel> {
                public final void m3665a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    ProfilePictureModel profilePictureModel = (ProfilePictureModel) obj;
                    if (profilePictureModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(profilePictureModel.m3666a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        profilePictureModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    ProfilePictureParser.m3680a(profilePictureModel.w_(), profilePictureModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(ProfilePictureModel.class, new Serializer());
                }
            }

            public ProfilePictureModel() {
                super(1);
            }

            @Nullable
            public final String m3668a() {
                this.f2736d = super.a(this.f2736d, 0);
                return this.f2736d;
            }

            public final int jK_() {
                return 70760763;
            }

            public final GraphQLVisitableModel m3667a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m3666a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m3668a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: reads */
        public class Serializer extends JsonSerializer<PostsByOthersFragmentQueryModel> {
            public final void m3669a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                PostsByOthersFragmentQueryModel postsByOthersFragmentQueryModel = (PostsByOthersFragmentQueryModel) obj;
                if (postsByOthersFragmentQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(postsByOthersFragmentQueryModel.m3670a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    postsByOthersFragmentQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = postsByOthersFragmentQueryModel.w_();
                int u_ = postsByOthersFragmentQueryModel.u_();
                jsonGenerator.f();
                boolean a = mutableFlatBuffer.a(u_, 0);
                if (a) {
                    jsonGenerator.a("can_viewer_post");
                    jsonGenerator.a(a);
                }
                a = mutableFlatBuffer.a(u_, 1);
                if (a) {
                    jsonGenerator.a("can_viewer_post_photo_to_timeline");
                    jsonGenerator.a(a);
                }
                int g = mutableFlatBuffer.g(u_, 2);
                if (g != 0) {
                    jsonGenerator.a("profile_picture");
                    ProfilePictureParser.m3680a(mutableFlatBuffer, g, jsonGenerator);
                }
                if (mutableFlatBuffer.g(u_, 3) != 0) {
                    jsonGenerator.a("viewer_profile_permissions");
                    SerializerHelpers.a(mutableFlatBuffer.f(u_, 3), jsonGenerator);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(PostsByOthersFragmentQueryModel.class, new Serializer());
            }
        }

        public PostsByOthersFragmentQueryModel() {
            super(4);
        }

        public final void m3673a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m3674a(String str, Object obj, boolean z) {
        }

        public final boolean m3675a() {
            a(0, 0);
            return this.f2737d;
        }

        public final boolean m3676j() {
            a(0, 1);
            return this.f2738e;
        }

        @Nullable
        public final ProfilePictureModel m3677k() {
            this.f2739f = (ProfilePictureModel) super.a(this.f2739f, 2, ProfilePictureModel.class);
            return this.f2739f;
        }

        @Nonnull
        public final ImmutableList<String> m3678l() {
            this.f2740g = super.a(this.f2740g, 3);
            return (ImmutableList) this.f2740g;
        }

        public final int jK_() {
            return 2479791;
        }

        public final GraphQLVisitableModel m3671a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m3677k() != null) {
                ProfilePictureModel profilePictureModel = (ProfilePictureModel) graphQLModelMutatingVisitor.b(m3677k());
                if (m3677k() != profilePictureModel) {
                    graphQLVisitableModel = (PostsByOthersFragmentQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f2739f = profilePictureModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m3670a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m3677k());
            int c = flatBufferBuilder.c(m3678l());
            flatBufferBuilder.c(4);
            flatBufferBuilder.a(0, this.f2737d);
            flatBufferBuilder.a(1, this.f2738e);
            flatBufferBuilder.b(2, a);
            flatBufferBuilder.b(3, c);
            i();
            return flatBufferBuilder.d();
        }

        public final void m3672a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f2737d = mutableFlatBuffer.a(i, 0);
            this.f2738e = mutableFlatBuffer.a(i, 1);
        }
    }
}
