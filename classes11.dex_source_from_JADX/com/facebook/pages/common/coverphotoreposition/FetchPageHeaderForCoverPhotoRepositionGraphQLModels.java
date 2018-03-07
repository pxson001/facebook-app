package com.facebook.pages.common.coverphotoreposition;

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
import com.facebook.pages.common.coverphotoreposition.FetchPageHeaderForCoverPhotoRepositionGraphQLParsers.FetchPageHeaderForCoverPhotoRepositionQueryParser;
import com.facebook.pages.common.coverphotoreposition.FetchPageHeaderForCoverPhotoRepositionGraphQLParsers.FetchPageHeaderForCoverPhotoRepositionQueryParser.ProfilePictureParser;
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

/* compiled from: source_photos_tab */
public class FetchPageHeaderForCoverPhotoRepositionGraphQLModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1987499528)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: source_photos_tab */
    public final class FetchPageHeaderForCoverPhotoRepositionQueryModel extends BaseModel implements GraphQLVisitableConsistentModel {
        @Nullable
        private List<String> f1498d;
        @Nullable
        private String f1499e;
        @Nullable
        private ProfilePictureModel f1500f;

        /* compiled from: source_photos_tab */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FetchPageHeaderForCoverPhotoRepositionQueryModel.class, new Deserializer());
            }

            public Object m2185a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = FetchPageHeaderForCoverPhotoRepositionQueryParser.m2201a(jsonParser);
                Object fetchPageHeaderForCoverPhotoRepositionQueryModel = new FetchPageHeaderForCoverPhotoRepositionQueryModel();
                ((BaseModel) fetchPageHeaderForCoverPhotoRepositionQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (fetchPageHeaderForCoverPhotoRepositionQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) fetchPageHeaderForCoverPhotoRepositionQueryModel).a();
                }
                return fetchPageHeaderForCoverPhotoRepositionQueryModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 842551240)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: source_photos_tab */
        public final class ProfilePictureModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private String f1497d;

            /* compiled from: source_photos_tab */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(ProfilePictureModel.class, new Deserializer());
                }

                public Object m2186a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(ProfilePictureParser.m2199a(jsonParser, flatBufferBuilder));
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

            /* compiled from: source_photos_tab */
            public class Serializer extends JsonSerializer<ProfilePictureModel> {
                public final void m2187a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    ProfilePictureModel profilePictureModel = (ProfilePictureModel) obj;
                    if (profilePictureModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(profilePictureModel.m2188a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        profilePictureModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    ProfilePictureParser.m2200a(profilePictureModel.w_(), profilePictureModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(ProfilePictureModel.class, new Serializer());
                }
            }

            public ProfilePictureModel() {
                super(1);
            }

            @Nullable
            public final String m2190a() {
                this.f1497d = super.a(this.f1497d, 0);
                return this.f1497d;
            }

            public final int jK_() {
                return 70760763;
            }

            public final GraphQLVisitableModel m2189a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m2188a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m2190a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: source_photos_tab */
        public class Serializer extends JsonSerializer<FetchPageHeaderForCoverPhotoRepositionQueryModel> {
            public final void m2191a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                FetchPageHeaderForCoverPhotoRepositionQueryModel fetchPageHeaderForCoverPhotoRepositionQueryModel = (FetchPageHeaderForCoverPhotoRepositionQueryModel) obj;
                if (fetchPageHeaderForCoverPhotoRepositionQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(fetchPageHeaderForCoverPhotoRepositionQueryModel.m2192a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    fetchPageHeaderForCoverPhotoRepositionQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = fetchPageHeaderForCoverPhotoRepositionQueryModel.w_();
                int u_ = fetchPageHeaderForCoverPhotoRepositionQueryModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("category_names");
                    SerializerHelpers.a(mutableFlatBuffer.f(u_, 0), jsonGenerator);
                }
                if (mutableFlatBuffer.g(u_, 1) != 0) {
                    jsonGenerator.a("name");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 1));
                }
                int g = mutableFlatBuffer.g(u_, 2);
                if (g != 0) {
                    jsonGenerator.a("profile_picture");
                    ProfilePictureParser.m2200a(mutableFlatBuffer, g, jsonGenerator);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(FetchPageHeaderForCoverPhotoRepositionQueryModel.class, new Serializer());
            }
        }

        public FetchPageHeaderForCoverPhotoRepositionQueryModel() {
            super(3);
        }

        public final void m2195a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m2196a(String str, Object obj, boolean z) {
        }

        @Nonnull
        public final ImmutableList<String> m2194a() {
            this.f1498d = super.a(this.f1498d, 0);
            return (ImmutableList) this.f1498d;
        }

        @Nullable
        public final String m2197j() {
            this.f1499e = super.a(this.f1499e, 1);
            return this.f1499e;
        }

        @Nullable
        public final ProfilePictureModel m2198k() {
            this.f1500f = (ProfilePictureModel) super.a(this.f1500f, 2, ProfilePictureModel.class);
            return this.f1500f;
        }

        public final int jK_() {
            return 2479791;
        }

        public final GraphQLVisitableModel m2193a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m2198k() != null) {
                ProfilePictureModel profilePictureModel = (ProfilePictureModel) graphQLModelMutatingVisitor.b(m2198k());
                if (m2198k() != profilePictureModel) {
                    graphQLVisitableModel = (FetchPageHeaderForCoverPhotoRepositionQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f1500f = profilePictureModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m2192a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int c = flatBufferBuilder.c(m2194a());
            int b = flatBufferBuilder.b(m2197j());
            int a = ModelHelper.a(flatBufferBuilder, m2198k());
            flatBufferBuilder.c(3);
            flatBufferBuilder.b(0, c);
            flatBufferBuilder.b(1, b);
            flatBufferBuilder.b(2, a);
            i();
            return flatBufferBuilder.d();
        }
    }
}
