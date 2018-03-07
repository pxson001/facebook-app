package com.facebook.greetingcards.create;

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
import com.facebook.graphql.modelutil.SerializerHelpers;
import com.facebook.graphql.visitor.ConsistencyTuple;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.greetingcards.create.FetchThemePreviewGraphQLParsers.FetchThemePreviewQueryParser;
import com.facebook.greetingcards.create.FetchThemePreviewGraphQLParsers.FetchThemePreviewQueryParser.TemplatePreviewImagesParser;
import com.facebook.greetingcards.create.FetchThemePreviewGraphQLParsers.FetchThemePreviewQueryParser.TemplatePreviewImagesParser.ImageParser;
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

/* compiled from: {name} */
public class FetchThemePreviewGraphQLModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 170977295)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: {name} */
    public final class FetchThemePreviewQueryModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
        @Nullable
        private GraphQLObjectType f53d;
        @Nullable
        private String f54e;
        @Nullable
        private List<TemplatePreviewImagesModel> f55f;

        /* compiled from: {name} */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FetchThemePreviewQueryModel.class, new Deserializer());
            }

            public Object m27a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(FetchThemePreviewQueryParser.m52a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object fetchThemePreviewQueryModel = new FetchThemePreviewQueryModel();
                ((BaseModel) fetchThemePreviewQueryModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (fetchThemePreviewQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) fetchThemePreviewQueryModel).a();
                }
                return fetchThemePreviewQueryModel;
            }
        }

        /* compiled from: {name} */
        public class Serializer extends JsonSerializer<FetchThemePreviewQueryModel> {
            public final void m28a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                FetchThemePreviewQueryModel fetchThemePreviewQueryModel = (FetchThemePreviewQueryModel) obj;
                if (fetchThemePreviewQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(fetchThemePreviewQueryModel.m41a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    fetchThemePreviewQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = fetchThemePreviewQueryModel.w_();
                int u_ = fetchThemePreviewQueryModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("__type__");
                    SerializerHelpers.b(mutableFlatBuffer, u_, 0, jsonGenerator);
                }
                if (mutableFlatBuffer.g(u_, 1) != 0) {
                    jsonGenerator.a("id");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 1));
                }
                int g = mutableFlatBuffer.g(u_, 2);
                if (g != 0) {
                    jsonGenerator.a("template_preview_images");
                    jsonGenerator.d();
                    for (int i = 0; i < mutableFlatBuffer.c(g); i++) {
                        TemplatePreviewImagesParser.m51b(mutableFlatBuffer, mutableFlatBuffer.m(g, i), jsonGenerator, serializerProvider);
                    }
                    jsonGenerator.e();
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(FetchThemePreviewQueryModel.class, new Serializer());
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1714333749)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: {name} */
        public final class TemplatePreviewImagesModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private ImageModel f51d;
            @Nullable
            private String f52e;

            /* compiled from: {name} */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(TemplatePreviewImagesModel.class, new Deserializer());
                }

                public Object m29a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(TemplatePreviewImagesParser.m50b(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object templatePreviewImagesModel = new TemplatePreviewImagesModel();
                    ((BaseModel) templatePreviewImagesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (templatePreviewImagesModel instanceof Postprocessable) {
                        return ((Postprocessable) templatePreviewImagesModel).a();
                    }
                    return templatePreviewImagesModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 842551240)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: {name} */
            public final class ImageModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private String f50d;

                /* compiled from: {name} */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(ImageModel.class, new Deserializer());
                    }

                    public Object m30a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(ImageParser.m48a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object imageModel = new ImageModel();
                        ((BaseModel) imageModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (imageModel instanceof Postprocessable) {
                            return ((Postprocessable) imageModel).a();
                        }
                        return imageModel;
                    }
                }

                /* compiled from: {name} */
                public class Serializer extends JsonSerializer<ImageModel> {
                    public final void m31a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        ImageModel imageModel = (ImageModel) obj;
                        if (imageModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(imageModel.m32a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            imageModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        ImageParser.m49a(imageModel.w_(), imageModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(ImageModel.class, new Serializer());
                    }
                }

                public ImageModel() {
                    super(1);
                }

                @Nullable
                public final String m34a() {
                    this.f50d = super.a(this.f50d, 0);
                    return this.f50d;
                }

                public final int jK_() {
                    return 70760763;
                }

                public final GraphQLVisitableModel m33a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m32a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int b = flatBufferBuilder.b(m34a());
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, b);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: {name} */
            public class Serializer extends JsonSerializer<TemplatePreviewImagesModel> {
                public final void m35a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    TemplatePreviewImagesModel templatePreviewImagesModel = (TemplatePreviewImagesModel) obj;
                    if (templatePreviewImagesModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(templatePreviewImagesModel.m36a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        templatePreviewImagesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    TemplatePreviewImagesParser.m51b(templatePreviewImagesModel.w_(), templatePreviewImagesModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(TemplatePreviewImagesModel.class, new Serializer());
                }
            }

            public TemplatePreviewImagesModel() {
                super(2);
            }

            @Nullable
            public final ImageModel m38a() {
                this.f51d = (ImageModel) super.a(this.f51d, 0, ImageModel.class);
                return this.f51d;
            }

            @Nullable
            public final String m39j() {
                this.f52e = super.a(this.f52e, 1);
                return this.f52e;
            }

            public final int jK_() {
                return 1027553035;
            }

            public final GraphQLVisitableModel m37a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m38a() != null) {
                    ImageModel imageModel = (ImageModel) graphQLModelMutatingVisitor.b(m38a());
                    if (m38a() != imageModel) {
                        graphQLVisitableModel = (TemplatePreviewImagesModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f51d = imageModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m36a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m38a());
                int b = flatBufferBuilder.b(m39j());
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        public FetchThemePreviewQueryModel() {
            super(3);
        }

        public final void m44a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m45a(String str, Object obj, boolean z) {
        }

        @Nullable
        private GraphQLObjectType m40l() {
            if (this.b != null && this.f53d == null) {
                this.f53d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
            }
            return this.f53d;
        }

        @Nullable
        public final String m46j() {
            this.f54e = super.a(this.f54e, 1);
            return this.f54e;
        }

        @Nonnull
        public final ImmutableList<TemplatePreviewImagesModel> m47k() {
            this.f55f = super.a(this.f55f, 2, TemplatePreviewImagesModel.class);
            return (ImmutableList) this.f55f;
        }

        @Nullable
        public final String m43a() {
            return m46j();
        }

        public final int jK_() {
            return 2433570;
        }

        public final GraphQLVisitableModel m42a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m47k() != null) {
                Builder a = ModelHelper.a(m47k(), graphQLModelMutatingVisitor);
                if (a != null) {
                    graphQLVisitableModel = (FetchThemePreviewQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f55f = a.b();
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m41a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m40l());
            int b = flatBufferBuilder.b(m46j());
            int a2 = ModelHelper.a(flatBufferBuilder, m47k());
            flatBufferBuilder.c(3);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, b);
            flatBufferBuilder.b(2, a2);
            i();
            return flatBufferBuilder.d();
        }
    }
}
