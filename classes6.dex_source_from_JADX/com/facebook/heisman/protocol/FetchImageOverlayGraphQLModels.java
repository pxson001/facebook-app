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
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.visitor.ConsistencyTuple;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.heisman.protocol.FetchImageOverlayGraphQLParsers.CameraTitleFieldsParser;
import com.facebook.heisman.protocol.FetchImageOverlayGraphQLParsers.CameraTitleFieldsParser.ProfileOverlayCategoryParser;
import com.facebook.heisman.protocol.FetchImageOverlayGraphQLParsers.CameraTitleFieldsParser.ProfileOverlayCategoryParser.PagesParser;
import com.facebook.heisman.protocol.FetchImageOverlayGraphQLParsers.ImageOverlayCameraTitleFieldsParser;
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

/* compiled from: mLinkAttachmentUrl */
public class FetchImageOverlayGraphQLModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -786585747)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: mLinkAttachmentUrl */
    public final class CameraTitleFieldsModel extends BaseModel implements GraphQLVisitableConsistentModel {
        @Nullable
        private String f11031d;
        @Nullable
        private ProfileOverlayCategoryModel f11032e;

        /* compiled from: mLinkAttachmentUrl */
        public final class Builder {
            @Nullable
            public String f11025a;
            @Nullable
            public ProfileOverlayCategoryModel f11026b;

            public final CameraTitleFieldsModel m17710a() {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int b = flatBufferBuilder.b(this.f11025a);
                int a = ModelHelper.a(flatBufferBuilder, this.f11026b);
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.b(1, a);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new CameraTitleFieldsModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }
        }

        /* compiled from: mLinkAttachmentUrl */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(CameraTitleFieldsModel.class, new Deserializer());
            }

            public Object m17711a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(CameraTitleFieldsParser.b(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object cameraTitleFieldsModel = new CameraTitleFieldsModel();
                ((BaseModel) cameraTitleFieldsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (cameraTitleFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) cameraTitleFieldsModel).a();
                }
                return cameraTitleFieldsModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 733983730)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: mLinkAttachmentUrl */
        public final class ProfileOverlayCategoryModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private PagesModel f11030d;

            /* compiled from: mLinkAttachmentUrl */
            public final class Builder {
                @Nullable
                public PagesModel f11027a;

                public final ProfileOverlayCategoryModel m17712a() {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    int a = ModelHelper.a(flatBufferBuilder, this.f11027a);
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, a);
                    flatBufferBuilder.d(flatBufferBuilder.d());
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    return new ProfileOverlayCategoryModel(new MutableFlatBuffer(wrap, null, null, true, null));
                }
            }

            /* compiled from: mLinkAttachmentUrl */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(ProfileOverlayCategoryModel.class, new Deserializer());
                }

                public Object m17713a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(ProfileOverlayCategoryParser.a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object profileOverlayCategoryModel = new ProfileOverlayCategoryModel();
                    ((BaseModel) profileOverlayCategoryModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (profileOverlayCategoryModel instanceof Postprocessable) {
                        return ((Postprocessable) profileOverlayCategoryModel).a();
                    }
                    return profileOverlayCategoryModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -1723990064)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: mLinkAttachmentUrl */
            public final class PagesModel extends BaseModel implements GraphQLVisitableModel {
                private int f11029d;

                /* compiled from: mLinkAttachmentUrl */
                public final class Builder {
                    public int f11028a;

                    public final PagesModel m17714a() {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.c(1);
                        flatBufferBuilder.a(0, this.f11028a, 0);
                        flatBufferBuilder.d(flatBufferBuilder.d());
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        return new PagesModel(new MutableFlatBuffer(wrap, null, null, true, null));
                    }
                }

                /* compiled from: mLinkAttachmentUrl */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(PagesModel.class, new Deserializer());
                    }

                    public Object m17715a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(PagesParser.a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object pagesModel = new PagesModel();
                        ((BaseModel) pagesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (pagesModel instanceof Postprocessable) {
                            return ((Postprocessable) pagesModel).a();
                        }
                        return pagesModel;
                    }
                }

                /* compiled from: mLinkAttachmentUrl */
                public class Serializer extends JsonSerializer<PagesModel> {
                    public final void m17716a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        PagesModel pagesModel = (PagesModel) obj;
                        if (pagesModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(pagesModel.m17719a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            pagesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        PagesParser.a(pagesModel.w_(), pagesModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(PagesModel.class, new Serializer());
                    }
                }

                public PagesModel() {
                    super(1);
                }

                public PagesModel(MutableFlatBuffer mutableFlatBuffer) {
                    super(1);
                    a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }

                public final int m17718a() {
                    a(0, 0);
                    return this.f11029d;
                }

                public static PagesModel m17717a(PagesModel pagesModel) {
                    if (pagesModel == null) {
                        return null;
                    }
                    if (pagesModel instanceof PagesModel) {
                        return pagesModel;
                    }
                    Builder builder = new Builder();
                    builder.f11028a = pagesModel.m17718a();
                    return builder.m17714a();
                }

                public final int jK_() {
                    return -985606563;
                }

                public final GraphQLVisitableModel m17720a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m17719a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.a(0, this.f11029d, 0);
                    i();
                    return flatBufferBuilder.d();
                }

                public final void m17721a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                    super.a(mutableFlatBuffer, i, obj);
                    this.f11029d = mutableFlatBuffer.a(i, 0, 0);
                }
            }

            /* compiled from: mLinkAttachmentUrl */
            public class Serializer extends JsonSerializer<ProfileOverlayCategoryModel> {
                public final void m17722a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    ProfileOverlayCategoryModel profileOverlayCategoryModel = (ProfileOverlayCategoryModel) obj;
                    if (profileOverlayCategoryModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(profileOverlayCategoryModel.m17725a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        profileOverlayCategoryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    ProfileOverlayCategoryParser.a(profileOverlayCategoryModel.w_(), profileOverlayCategoryModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(ProfileOverlayCategoryModel.class, new Serializer());
                }
            }

            @Nullable
            public final /* synthetic */ PagesModel m17727a() {
                return m17724j();
            }

            public ProfileOverlayCategoryModel() {
                super(1);
            }

            public ProfileOverlayCategoryModel(MutableFlatBuffer mutableFlatBuffer) {
                super(1);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            @Nullable
            private PagesModel m17724j() {
                this.f11030d = (PagesModel) super.a(this.f11030d, 0, PagesModel.class);
                return this.f11030d;
            }

            public static ProfileOverlayCategoryModel m17723a(ProfileOverlayCategoryModel profileOverlayCategoryModel) {
                if (profileOverlayCategoryModel == null) {
                    return null;
                }
                if (profileOverlayCategoryModel instanceof ProfileOverlayCategoryModel) {
                    return profileOverlayCategoryModel;
                }
                Builder builder = new Builder();
                builder.f11027a = PagesModel.m17717a(profileOverlayCategoryModel.m17727a());
                return builder.m17712a();
            }

            public final int jK_() {
                return -2042279771;
            }

            public final GraphQLVisitableModel m17726a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m17724j() != null) {
                    PagesModel pagesModel = (PagesModel) graphQLModelMutatingVisitor.b(m17724j());
                    if (m17724j() != pagesModel) {
                        graphQLVisitableModel = (ProfileOverlayCategoryModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f11030d = pagesModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m17725a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m17724j());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: mLinkAttachmentUrl */
        public class Serializer extends JsonSerializer<CameraTitleFieldsModel> {
            public final void m17728a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                CameraTitleFieldsModel cameraTitleFieldsModel = (CameraTitleFieldsModel) obj;
                if (cameraTitleFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(cameraTitleFieldsModel.m17731a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    cameraTitleFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                CameraTitleFieldsParser.b(cameraTitleFieldsModel.w_(), cameraTitleFieldsModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(CameraTitleFieldsModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ ProfileOverlayCategoryModel m17736b() {
            return m17730j();
        }

        public CameraTitleFieldsModel() {
            super(2);
        }

        public CameraTitleFieldsModel(MutableFlatBuffer mutableFlatBuffer) {
            super(2);
            a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }

        public final void m17734a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m17735a(String str, Object obj, boolean z) {
        }

        @Nullable
        public final String m17733a() {
            this.f11031d = super.a(this.f11031d, 0);
            return this.f11031d;
        }

        @Nullable
        private ProfileOverlayCategoryModel m17730j() {
            this.f11032e = (ProfileOverlayCategoryModel) super.a(this.f11032e, 1, ProfileOverlayCategoryModel.class);
            return this.f11032e;
        }

        public static CameraTitleFieldsModel m17729a(CameraTitleFieldsModel cameraTitleFieldsModel) {
            if (cameraTitleFieldsModel == null) {
                return null;
            }
            if (cameraTitleFieldsModel instanceof CameraTitleFieldsModel) {
                return cameraTitleFieldsModel;
            }
            Builder builder = new Builder();
            builder.f11025a = cameraTitleFieldsModel.m17733a();
            builder.f11026b = ProfileOverlayCategoryModel.m17723a(cameraTitleFieldsModel.m17736b());
            return builder.m17710a();
        }

        public final int jK_() {
            return 2479791;
        }

        public final GraphQLVisitableModel m17732a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m17730j() != null) {
                ProfileOverlayCategoryModel profileOverlayCategoryModel = (ProfileOverlayCategoryModel) graphQLModelMutatingVisitor.b(m17730j());
                if (m17730j() != profileOverlayCategoryModel) {
                    graphQLVisitableModel = (CameraTitleFieldsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f11032e = profileOverlayCategoryModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m17731a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m17733a());
            int a = ModelHelper.a(flatBufferBuilder, m17730j());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, b);
            flatBufferBuilder.b(1, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 940760180)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: mLinkAttachmentUrl */
    public final class ImageOverlayCameraTitleFieldsModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private GraphQLObjectType f11035d;
        @Nullable
        private List<CameraTitleFieldsModel> f11036e;

        /* compiled from: mLinkAttachmentUrl */
        public final class Builder {
            @Nullable
            public GraphQLObjectType f11033a;
            @Nullable
            public ImmutableList<CameraTitleFieldsModel> f11034b;

            public final ImageOverlayCameraTitleFieldsModel m17737a() {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int a = ModelHelper.a(flatBufferBuilder, this.f11033a);
                int a2 = ModelHelper.a(flatBufferBuilder, this.f11034b);
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, a2);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new ImageOverlayCameraTitleFieldsModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }
        }

        /* compiled from: mLinkAttachmentUrl */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(ImageOverlayCameraTitleFieldsModel.class, new Deserializer());
            }

            public Object m17738a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(ImageOverlayCameraTitleFieldsParser.a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object imageOverlayCameraTitleFieldsModel = new ImageOverlayCameraTitleFieldsModel();
                ((BaseModel) imageOverlayCameraTitleFieldsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (imageOverlayCameraTitleFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) imageOverlayCameraTitleFieldsModel).a();
                }
                return imageOverlayCameraTitleFieldsModel;
            }
        }

        public ImageOverlayCameraTitleFieldsModel() {
            super(2);
        }

        public ImageOverlayCameraTitleFieldsModel(MutableFlatBuffer mutableFlatBuffer) {
            super(2);
            a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }

        @Nullable
        public final GraphQLObjectType m17741a() {
            if (this.b != null && this.f11035d == null) {
                this.f11035d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
            }
            return this.f11035d;
        }

        @Nonnull
        public final ImmutableList<CameraTitleFieldsModel> m17743b() {
            this.f11036e = super.a(this.f11036e, 1, CameraTitleFieldsModel.class);
            return (ImmutableList) this.f11036e;
        }

        public static ImageOverlayCameraTitleFieldsModel m17739a(ImageOverlayCameraTitleFieldsModel imageOverlayCameraTitleFieldsModel) {
            if (imageOverlayCameraTitleFieldsModel == null) {
                return null;
            }
            if (imageOverlayCameraTitleFieldsModel instanceof ImageOverlayCameraTitleFieldsModel) {
                return imageOverlayCameraTitleFieldsModel;
            }
            Builder builder = new Builder();
            builder.f11033a = imageOverlayCameraTitleFieldsModel.m17741a();
            com.google.common.collect.ImmutableList.Builder builder2 = ImmutableList.builder();
            for (int i = 0; i < imageOverlayCameraTitleFieldsModel.m17743b().size(); i++) {
                builder2.c(CameraTitleFieldsModel.m17729a((CameraTitleFieldsModel) imageOverlayCameraTitleFieldsModel.m17743b().get(i)));
            }
            builder.f11034b = builder2.b();
            return builder.m17737a();
        }

        public final int jK_() {
            return -328705387;
        }

        public final GraphQLVisitableModel m17742a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m17743b() != null) {
                com.google.common.collect.ImmutableList.Builder a = ModelHelper.a(m17743b(), graphQLModelMutatingVisitor);
                if (a != null) {
                    graphQLVisitableModel = (ImageOverlayCameraTitleFieldsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f11036e = a.b();
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m17740a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m17741a());
            int a2 = ModelHelper.a(flatBufferBuilder, m17743b());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            i();
            return flatBufferBuilder.d();
        }
    }
}
