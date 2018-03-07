package com.facebook.heisman.protocol.imageoverlay;

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
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.heisman.protocol.imageoverlay.ImageOverlayGraphQLParsers.ImageOverlayFieldsParser;
import com.facebook.heisman.protocol.imageoverlay.ImageOverlayGraphQLParsers.ImageOverlayFieldsParser.ImageParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

/* compiled from: TRENDING_FINITE_SERP */
public class ImageOverlayGraphQLModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1061912397)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: TRENDING_FINITE_SERP */
    public final class ImageOverlayFieldsModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
        @Nullable
        private GraphQLObjectType f13553d;
        @Nullable
        private String f13554e;
        @Nullable
        private ImageModel f13555f;

        /* compiled from: TRENDING_FINITE_SERP */
        public final class Builder {
            @Nullable
            public GraphQLObjectType f13548a;
            @Nullable
            public String f13549b;
            @Nullable
            public ImageModel f13550c;

            public final Builder m22808a(@Nullable String str) {
                this.f13549b = str;
                return this;
            }

            public final Builder m22807a(@Nullable ImageModel imageModel) {
                this.f13550c = imageModel;
                return this;
            }

            public final ImageOverlayFieldsModel m22809a() {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int a = ModelHelper.a(flatBufferBuilder, this.f13548a);
                int b = flatBufferBuilder.b(this.f13549b);
                int a2 = ModelHelper.a(flatBufferBuilder, this.f13550c);
                flatBufferBuilder.c(3);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, b);
                flatBufferBuilder.b(2, a2);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new ImageOverlayFieldsModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }
        }

        /* compiled from: TRENDING_FINITE_SERP */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(ImageOverlayFieldsModel.class, new Deserializer());
            }

            public Object m22810a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(ImageOverlayFieldsParser.m22830a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object imageOverlayFieldsModel = new ImageOverlayFieldsModel();
                ((BaseModel) imageOverlayFieldsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (imageOverlayFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) imageOverlayFieldsModel).a();
                }
                return imageOverlayFieldsModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 842551240)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: TRENDING_FINITE_SERP */
        public final class ImageModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private String f13552d;

            /* compiled from: TRENDING_FINITE_SERP */
            public final class Builder {
                @Nullable
                public String f13551a;

                public final Builder m22811a(@Nullable String str) {
                    this.f13551a = str;
                    return this;
                }

                public final ImageModel m22812a() {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    int b = flatBufferBuilder.b(this.f13551a);
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, b);
                    flatBufferBuilder.d(flatBufferBuilder.d());
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    return new ImageModel(new MutableFlatBuffer(wrap, null, null, true, null));
                }
            }

            /* compiled from: TRENDING_FINITE_SERP */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(ImageModel.class, new Deserializer());
                }

                public Object m22813a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(ImageParser.m22828a(jsonParser, flatBufferBuilder));
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

            /* compiled from: TRENDING_FINITE_SERP */
            public class Serializer extends JsonSerializer<ImageModel> {
                public final void m22814a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    ImageModel imageModel = (ImageModel) obj;
                    if (imageModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(imageModel.m22816a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        imageModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    ImageParser.m22829a(imageModel.w_(), imageModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(ImageModel.class, new Serializer());
                }
            }

            public ImageModel() {
                super(1);
            }

            public ImageModel(MutableFlatBuffer mutableFlatBuffer) {
                super(1);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            @Nullable
            public final String m22818a() {
                this.f13552d = super.a(this.f13552d, 0);
                return this.f13552d;
            }

            public static ImageModel m22815a(ImageModel imageModel) {
                if (imageModel == null) {
                    return null;
                }
                if (imageModel instanceof ImageModel) {
                    return imageModel;
                }
                Builder builder = new Builder();
                builder.f13551a = imageModel.m22818a();
                return builder.m22812a();
            }

            public final int jK_() {
                return 70760763;
            }

            public final GraphQLVisitableModel m22817a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m22816a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m22818a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: TRENDING_FINITE_SERP */
        public class Serializer extends JsonSerializer<ImageOverlayFieldsModel> {
            public final void m22819a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                ImageOverlayFieldsModel imageOverlayFieldsModel = (ImageOverlayFieldsModel) obj;
                if (imageOverlayFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(imageOverlayFieldsModel.m22821a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    imageOverlayFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                ImageOverlayFieldsParser.m22833b(imageOverlayFieldsModel.w_(), imageOverlayFieldsModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(ImageOverlayFieldsModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ ImageModel m22826d() {
            return m22827j();
        }

        public ImageOverlayFieldsModel() {
            super(3);
        }

        public ImageOverlayFieldsModel(MutableFlatBuffer mutableFlatBuffer) {
            super(3);
            a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }

        @Nullable
        public final GraphQLObjectType m22824b() {
            if (this.b != null && this.f13553d == null) {
                this.f13553d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
            }
            return this.f13553d;
        }

        @Nullable
        public final String m22825c() {
            this.f13554e = super.a(this.f13554e, 1);
            return this.f13554e;
        }

        @Nullable
        public final ImageModel m22827j() {
            this.f13555f = (ImageModel) super.a(this.f13555f, 2, ImageModel.class);
            return this.f13555f;
        }

        public static ImageOverlayFieldsModel m22820a(ImageOverlayFieldsModel imageOverlayFieldsModel) {
            if (imageOverlayFieldsModel == null) {
                return null;
            }
            if (imageOverlayFieldsModel instanceof ImageOverlayFieldsModel) {
                return imageOverlayFieldsModel;
            }
            Builder builder = new Builder();
            builder.f13548a = imageOverlayFieldsModel.m22824b();
            builder.f13549b = imageOverlayFieldsModel.m22825c();
            builder.f13550c = ImageModel.m22815a(imageOverlayFieldsModel.m22826d());
            return builder.m22809a();
        }

        @Nullable
        public final String m22823a() {
            return m22825c();
        }

        public final int jK_() {
            return -328705387;
        }

        public final GraphQLVisitableModel m22822a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m22827j() != null) {
                ImageModel imageModel = (ImageModel) graphQLModelMutatingVisitor.b(m22827j());
                if (m22827j() != imageModel) {
                    graphQLVisitableModel = (ImageOverlayFieldsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f13555f = imageModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m22821a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m22824b());
            int b = flatBufferBuilder.b(m22825c());
            int a2 = ModelHelper.a(flatBufferBuilder, m22827j());
            flatBufferBuilder.c(3);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, b);
            flatBufferBuilder.b(2, a2);
            i();
            return flatBufferBuilder.d();
        }
    }
}
