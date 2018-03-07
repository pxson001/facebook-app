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
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLModels.DefaultTextWithEntitiesFieldsModel;
import com.facebook.graphql.visitor.ConsistencyTuple;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.heisman.protocol.ProfileOverlayCategoryGraphQLParsers.PageProfilePictureOverlaysConnectionFieldsParser;
import com.facebook.heisman.protocol.ProfileOverlayCategoryGraphQLParsers.ProfileOverlayCategoryFieldsParser;
import com.facebook.heisman.protocol.ProfileOverlayCategoryGraphQLParsers.ProfileOverlayCategoryPageFieldsParser;
import com.facebook.heisman.protocol.ProfileOverlayCategoryGraphQLParsers.ProfileOverlayCategoryPageFieldsParser.PageLogoParser;
import com.facebook.heisman.protocol.ProfileOverlayCategoryGraphQLParsers.ProfileOverlayCategoryPagesConnectionFieldsParser;
import com.facebook.heisman.protocol.imageoverlay.ImageOverlayGraphQLModels.ImageOverlayFieldsModel;
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

/* compiled from: pointSize */
public class ProfileOverlayCategoryGraphQLModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 139467847)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: pointSize */
    public final class PageProfilePictureOverlaysConnectionFieldsModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private List<ImageOverlayFieldsModel> f6124d;

        /* compiled from: pointSize */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(PageProfilePictureOverlaysConnectionFieldsModel.class, new Deserializer());
            }

            public Object m7948a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(PageProfilePictureOverlaysConnectionFieldsParser.m7984a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object pageProfilePictureOverlaysConnectionFieldsModel = new PageProfilePictureOverlaysConnectionFieldsModel();
                ((BaseModel) pageProfilePictureOverlaysConnectionFieldsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (pageProfilePictureOverlaysConnectionFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) pageProfilePictureOverlaysConnectionFieldsModel).a();
                }
                return pageProfilePictureOverlaysConnectionFieldsModel;
            }
        }

        /* compiled from: pointSize */
        public class Serializer extends JsonSerializer<PageProfilePictureOverlaysConnectionFieldsModel> {
            public final void m7949a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                PageProfilePictureOverlaysConnectionFieldsModel pageProfilePictureOverlaysConnectionFieldsModel = (PageProfilePictureOverlaysConnectionFieldsModel) obj;
                if (pageProfilePictureOverlaysConnectionFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(pageProfilePictureOverlaysConnectionFieldsModel.m7950a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    pageProfilePictureOverlaysConnectionFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                PageProfilePictureOverlaysConnectionFieldsParser.m7985a(pageProfilePictureOverlaysConnectionFieldsModel.w_(), pageProfilePictureOverlaysConnectionFieldsModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(PageProfilePictureOverlaysConnectionFieldsModel.class, new Serializer());
            }
        }

        public PageProfilePictureOverlaysConnectionFieldsModel() {
            super(1);
        }

        @Nonnull
        public final ImmutableList<ImageOverlayFieldsModel> m7952a() {
            this.f6124d = super.a(this.f6124d, 0, ImageOverlayFieldsModel.class);
            return (ImmutableList) this.f6124d;
        }

        public final int jK_() {
            return -2035491803;
        }

        public final GraphQLVisitableModel m7951a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m7952a() != null) {
                Builder a = ModelHelper.a(m7952a(), graphQLModelMutatingVisitor);
                if (a != null) {
                    graphQLVisitableModel = (PageProfilePictureOverlaysConnectionFieldsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f6124d = a.b();
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m7950a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m7952a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -483595624)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: pointSize */
    public final class ProfileOverlayCategoryFieldsModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
        @Nullable
        private String f6125d;
        @Nullable
        private ProfileOverlayCategoryPagesConnectionFieldsModel f6126e;
        @Nullable
        private DefaultTextWithEntitiesFieldsModel f6127f;

        /* compiled from: pointSize */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(ProfileOverlayCategoryFieldsModel.class, new Deserializer());
            }

            public Object m7953a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(ProfileOverlayCategoryFieldsParser.m7986a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object profileOverlayCategoryFieldsModel = new ProfileOverlayCategoryFieldsModel();
                ((BaseModel) profileOverlayCategoryFieldsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (profileOverlayCategoryFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) profileOverlayCategoryFieldsModel).a();
                }
                return profileOverlayCategoryFieldsModel;
            }
        }

        /* compiled from: pointSize */
        public class Serializer extends JsonSerializer<ProfileOverlayCategoryFieldsModel> {
            public final void m7954a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                ProfileOverlayCategoryFieldsModel profileOverlayCategoryFieldsModel = (ProfileOverlayCategoryFieldsModel) obj;
                if (profileOverlayCategoryFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(profileOverlayCategoryFieldsModel.m7956a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    profileOverlayCategoryFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                ProfileOverlayCategoryFieldsParser.m7987a(profileOverlayCategoryFieldsModel.w_(), profileOverlayCategoryFieldsModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(ProfileOverlayCategoryFieldsModel.class, new Serializer());
            }
        }

        public ProfileOverlayCategoryFieldsModel() {
            super(3);
        }

        @Nullable
        private String m7955l() {
            this.f6125d = super.a(this.f6125d, 0);
            return this.f6125d;
        }

        @Nullable
        public final ProfileOverlayCategoryPagesConnectionFieldsModel m7959j() {
            this.f6126e = (ProfileOverlayCategoryPagesConnectionFieldsModel) super.a(this.f6126e, 1, ProfileOverlayCategoryPagesConnectionFieldsModel.class);
            return this.f6126e;
        }

        @Nullable
        public final DefaultTextWithEntitiesFieldsModel m7960k() {
            this.f6127f = (DefaultTextWithEntitiesFieldsModel) super.a(this.f6127f, 2, DefaultTextWithEntitiesFieldsModel.class);
            return this.f6127f;
        }

        @Nullable
        public final String m7958a() {
            return m7955l();
        }

        public final int jK_() {
            return -2042279771;
        }

        public final GraphQLVisitableModel m7957a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m7959j() != null) {
                ProfileOverlayCategoryPagesConnectionFieldsModel profileOverlayCategoryPagesConnectionFieldsModel = (ProfileOverlayCategoryPagesConnectionFieldsModel) graphQLModelMutatingVisitor.b(m7959j());
                if (m7959j() != profileOverlayCategoryPagesConnectionFieldsModel) {
                    graphQLVisitableModel = (ProfileOverlayCategoryFieldsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f6126e = profileOverlayCategoryPagesConnectionFieldsModel;
                }
            }
            if (m7960k() != null) {
                DefaultTextWithEntitiesFieldsModel defaultTextWithEntitiesFieldsModel = (DefaultTextWithEntitiesFieldsModel) graphQLModelMutatingVisitor.b(m7960k());
                if (m7960k() != defaultTextWithEntitiesFieldsModel) {
                    graphQLVisitableModel = (ProfileOverlayCategoryFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f6127f = defaultTextWithEntitiesFieldsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m7956a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m7955l());
            int a = ModelHelper.a(flatBufferBuilder, m7959j());
            int a2 = ModelHelper.a(flatBufferBuilder, m7960k());
            flatBufferBuilder.c(3);
            flatBufferBuilder.b(0, b);
            flatBufferBuilder.b(1, a);
            flatBufferBuilder.b(2, a2);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1710291272)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: pointSize */
    public final class ProfileOverlayCategoryPageFieldsModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
        @Nullable
        private String f6129d;
        @Nullable
        private String f6130e;
        @Nullable
        private PageLogoModel f6131f;
        @Nullable
        private PageProfilePictureOverlaysConnectionFieldsModel f6132g;

        /* compiled from: pointSize */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(ProfileOverlayCategoryPageFieldsModel.class, new Deserializer());
            }

            public Object m7961a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(ProfileOverlayCategoryPageFieldsParser.m7992b(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object profileOverlayCategoryPageFieldsModel = new ProfileOverlayCategoryPageFieldsModel();
                ((BaseModel) profileOverlayCategoryPageFieldsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (profileOverlayCategoryPageFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) profileOverlayCategoryPageFieldsModel).a();
                }
                return profileOverlayCategoryPageFieldsModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 842551240)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: pointSize */
        public final class PageLogoModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private String f6128d;

            /* compiled from: pointSize */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(PageLogoModel.class, new Deserializer());
                }

                public Object m7962a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(PageLogoParser.m7988a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object pageLogoModel = new PageLogoModel();
                    ((BaseModel) pageLogoModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (pageLogoModel instanceof Postprocessable) {
                        return ((Postprocessable) pageLogoModel).a();
                    }
                    return pageLogoModel;
                }
            }

            /* compiled from: pointSize */
            public class Serializer extends JsonSerializer<PageLogoModel> {
                public final void m7963a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    PageLogoModel pageLogoModel = (PageLogoModel) obj;
                    if (pageLogoModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(pageLogoModel.m7964a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        pageLogoModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    PageLogoParser.m7989a(pageLogoModel.w_(), pageLogoModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(PageLogoModel.class, new Serializer());
                }
            }

            public PageLogoModel() {
                super(1);
            }

            @Nullable
            public final String m7966a() {
                this.f6128d = super.a(this.f6128d, 0);
                return this.f6128d;
            }

            public final int jK_() {
                return 70760763;
            }

            public final GraphQLVisitableModel m7965a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m7964a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m7966a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: pointSize */
        public class Serializer extends JsonSerializer<ProfileOverlayCategoryPageFieldsModel> {
            public final void m7967a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                ProfileOverlayCategoryPageFieldsModel profileOverlayCategoryPageFieldsModel = (ProfileOverlayCategoryPageFieldsModel) obj;
                if (profileOverlayCategoryPageFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(profileOverlayCategoryPageFieldsModel.m7971a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    profileOverlayCategoryPageFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                ProfileOverlayCategoryPageFieldsParser.m7993b(profileOverlayCategoryPageFieldsModel.w_(), profileOverlayCategoryPageFieldsModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(ProfileOverlayCategoryPageFieldsModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ PageLogoModel m7977c() {
            return m7969k();
        }

        @Nullable
        public final /* synthetic */ PageProfilePictureOverlaysConnectionFieldsModel m7978d() {
            return m7970l();
        }

        public ProfileOverlayCategoryPageFieldsModel() {
            super(4);
        }

        public final void m7974a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m7975a(String str, Object obj, boolean z) {
        }

        @Nullable
        private String m7968j() {
            this.f6129d = super.a(this.f6129d, 0);
            return this.f6129d;
        }

        @Nullable
        public final String m7976b() {
            this.f6130e = super.a(this.f6130e, 1);
            return this.f6130e;
        }

        @Nullable
        private PageLogoModel m7969k() {
            this.f6131f = (PageLogoModel) super.a(this.f6131f, 2, PageLogoModel.class);
            return this.f6131f;
        }

        @Nullable
        private PageProfilePictureOverlaysConnectionFieldsModel m7970l() {
            this.f6132g = (PageProfilePictureOverlaysConnectionFieldsModel) super.a(this.f6132g, 3, PageProfilePictureOverlaysConnectionFieldsModel.class);
            return this.f6132g;
        }

        @Nullable
        public final String m7973a() {
            return m7968j();
        }

        public final int jK_() {
            return 2479791;
        }

        public final GraphQLVisitableModel m7972a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m7969k() != null) {
                PageLogoModel pageLogoModel = (PageLogoModel) graphQLModelMutatingVisitor.b(m7969k());
                if (m7969k() != pageLogoModel) {
                    graphQLVisitableModel = (ProfileOverlayCategoryPageFieldsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f6131f = pageLogoModel;
                }
            }
            if (m7970l() != null) {
                PageProfilePictureOverlaysConnectionFieldsModel pageProfilePictureOverlaysConnectionFieldsModel = (PageProfilePictureOverlaysConnectionFieldsModel) graphQLModelMutatingVisitor.b(m7970l());
                if (m7970l() != pageProfilePictureOverlaysConnectionFieldsModel) {
                    graphQLVisitableModel = (ProfileOverlayCategoryPageFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f6132g = pageProfilePictureOverlaysConnectionFieldsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m7971a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m7968j());
            int b2 = flatBufferBuilder.b(m7976b());
            int a = ModelHelper.a(flatBufferBuilder, m7969k());
            int a2 = ModelHelper.a(flatBufferBuilder, m7970l());
            flatBufferBuilder.c(4);
            flatBufferBuilder.b(0, b);
            flatBufferBuilder.b(1, b2);
            flatBufferBuilder.b(2, a);
            flatBufferBuilder.b(3, a2);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1249418613)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: pointSize */
    public final class ProfileOverlayCategoryPagesConnectionFieldsModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private List<ProfileOverlayCategoryPageFieldsModel> f6133d;

        /* compiled from: pointSize */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(ProfileOverlayCategoryPagesConnectionFieldsModel.class, new Deserializer());
            }

            public Object m7979a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(ProfileOverlayCategoryPagesConnectionFieldsParser.m7994a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object profileOverlayCategoryPagesConnectionFieldsModel = new ProfileOverlayCategoryPagesConnectionFieldsModel();
                ((BaseModel) profileOverlayCategoryPagesConnectionFieldsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (profileOverlayCategoryPagesConnectionFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) profileOverlayCategoryPagesConnectionFieldsModel).a();
                }
                return profileOverlayCategoryPagesConnectionFieldsModel;
            }
        }

        /* compiled from: pointSize */
        public class Serializer extends JsonSerializer<ProfileOverlayCategoryPagesConnectionFieldsModel> {
            public final void m7980a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                ProfileOverlayCategoryPagesConnectionFieldsModel profileOverlayCategoryPagesConnectionFieldsModel = (ProfileOverlayCategoryPagesConnectionFieldsModel) obj;
                if (profileOverlayCategoryPagesConnectionFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(profileOverlayCategoryPagesConnectionFieldsModel.m7981a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    profileOverlayCategoryPagesConnectionFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                ProfileOverlayCategoryPagesConnectionFieldsParser.m7995a(profileOverlayCategoryPagesConnectionFieldsModel.w_(), profileOverlayCategoryPagesConnectionFieldsModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(ProfileOverlayCategoryPagesConnectionFieldsModel.class, new Serializer());
            }
        }

        public ProfileOverlayCategoryPagesConnectionFieldsModel() {
            super(1);
        }

        @Nonnull
        public final ImmutableList<ProfileOverlayCategoryPageFieldsModel> m7983a() {
            this.f6133d = super.a(this.f6133d, 0, ProfileOverlayCategoryPageFieldsModel.class);
            return (ImmutableList) this.f6133d;
        }

        public final int jK_() {
            return -985606563;
        }

        public final GraphQLVisitableModel m7982a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m7983a() != null) {
                Builder a = ModelHelper.a(m7983a(), graphQLModelMutatingVisitor);
                if (a != null) {
                    graphQLVisitableModel = (ProfileOverlayCategoryPagesConnectionFieldsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f6133d = a.b();
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m7981a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m7983a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }
}
