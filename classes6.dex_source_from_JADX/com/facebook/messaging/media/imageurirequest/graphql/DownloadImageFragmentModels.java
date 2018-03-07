package com.facebook.messaging.media.imageurirequest.graphql;

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
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.messaging.media.imageurirequest.graphql.DownloadImageFragmentParsers.DownloadImageFragmentParser;
import com.facebook.messaging.media.imageurirequest.graphql.DownloadImageFragmentParsers.DownloadImageFragmentParser.AnimatedGifParser;
import com.facebook.messaging.media.imageurirequest.graphql.DownloadImageFragmentParsers.DownloadImageFragmentParser.ImageParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

/* compiled from: is_fire_and_forget */
public class DownloadImageFragmentModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1541581272)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: is_fire_and_forget */
    public final class DownloadImageFragmentModel extends BaseModel implements GraphQLVisitableConsistentModel {
        @Nullable
        private GraphQLObjectType f12079d;
        @Nullable
        private AnimatedGifModel f12080e;
        @Nullable
        private ImageModel f12081f;

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 842551240)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: is_fire_and_forget */
        public final class AnimatedGifModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private String f12077d;

            /* compiled from: is_fire_and_forget */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(AnimatedGifModel.class, new Deserializer());
                }

                public Object m18999a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(AnimatedGifParser.m19020a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object animatedGifModel = new AnimatedGifModel();
                    ((BaseModel) animatedGifModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (animatedGifModel instanceof Postprocessable) {
                        return ((Postprocessable) animatedGifModel).a();
                    }
                    return animatedGifModel;
                }
            }

            /* compiled from: is_fire_and_forget */
            public class Serializer extends JsonSerializer<AnimatedGifModel> {
                public final void m19000a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    AnimatedGifModel animatedGifModel = (AnimatedGifModel) obj;
                    if (animatedGifModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(animatedGifModel.m19001a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        animatedGifModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    AnimatedGifParser.m19021a(animatedGifModel.w_(), animatedGifModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(AnimatedGifModel.class, new Serializer());
                }
            }

            public AnimatedGifModel() {
                super(1);
            }

            @Nullable
            public final String m19003a() {
                this.f12077d = super.a(this.f12077d, 0);
                return this.f12077d;
            }

            public final int jK_() {
                return 70760763;
            }

            public final GraphQLVisitableModel m19002a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m19001a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m19003a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: is_fire_and_forget */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(DownloadImageFragmentModel.class, new Deserializer());
            }

            public Object m19004a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = DownloadImageFragmentParser.m19024a(jsonParser);
                Object downloadImageFragmentModel = new DownloadImageFragmentModel();
                ((BaseModel) downloadImageFragmentModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (downloadImageFragmentModel instanceof Postprocessable) {
                    return ((Postprocessable) downloadImageFragmentModel).a();
                }
                return downloadImageFragmentModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 842551240)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: is_fire_and_forget */
        public final class ImageModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private String f12078d;

            /* compiled from: is_fire_and_forget */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(ImageModel.class, new Deserializer());
                }

                public Object m19005a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(ImageParser.m19022a(jsonParser, flatBufferBuilder));
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

            /* compiled from: is_fire_and_forget */
            public class Serializer extends JsonSerializer<ImageModel> {
                public final void m19006a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    ImageModel imageModel = (ImageModel) obj;
                    if (imageModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(imageModel.m19007a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        imageModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    ImageParser.m19023a(imageModel.w_(), imageModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(ImageModel.class, new Serializer());
                }
            }

            public ImageModel() {
                super(1);
            }

            @Nullable
            public final String m19009a() {
                this.f12078d = super.a(this.f12078d, 0);
                return this.f12078d;
            }

            public final int jK_() {
                return 70760763;
            }

            public final GraphQLVisitableModel m19008a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m19007a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m19009a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: is_fire_and_forget */
        public class Serializer extends JsonSerializer<DownloadImageFragmentModel> {
            public final void m19010a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                DownloadImageFragmentModel downloadImageFragmentModel = (DownloadImageFragmentModel) obj;
                if (downloadImageFragmentModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(downloadImageFragmentModel.m19014a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    downloadImageFragmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = downloadImageFragmentModel.w_();
                int u_ = downloadImageFragmentModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("__type__");
                    SerializerHelpers.b(mutableFlatBuffer, u_, 0, jsonGenerator);
                }
                int g = mutableFlatBuffer.g(u_, 1);
                if (g != 0) {
                    jsonGenerator.a("animated_gif");
                    AnimatedGifParser.m19021a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(u_, 2);
                if (g != 0) {
                    jsonGenerator.a("image");
                    ImageParser.m19023a(mutableFlatBuffer, g, jsonGenerator);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(DownloadImageFragmentModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ AnimatedGifModel m19016a() {
            return m19012k();
        }

        @Nullable
        public final /* synthetic */ ImageModel m19019b() {
            return m19013l();
        }

        public DownloadImageFragmentModel() {
            super(3);
        }

        public final void m19017a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m19018a(String str, Object obj, boolean z) {
        }

        @Nullable
        private GraphQLObjectType m19011j() {
            if (this.b != null && this.f12079d == null) {
                this.f12079d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
            }
            return this.f12079d;
        }

        @Nullable
        private AnimatedGifModel m19012k() {
            this.f12080e = (AnimatedGifModel) super.a(this.f12080e, 1, AnimatedGifModel.class);
            return this.f12080e;
        }

        @Nullable
        private ImageModel m19013l() {
            this.f12081f = (ImageModel) super.a(this.f12081f, 2, ImageModel.class);
            return this.f12081f;
        }

        public final int jK_() {
            return 2433570;
        }

        public final GraphQLVisitableModel m19015a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m19012k() != null) {
                AnimatedGifModel animatedGifModel = (AnimatedGifModel) graphQLModelMutatingVisitor.b(m19012k());
                if (m19012k() != animatedGifModel) {
                    graphQLVisitableModel = (DownloadImageFragmentModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f12080e = animatedGifModel;
                }
            }
            if (m19013l() != null) {
                ImageModel imageModel = (ImageModel) graphQLModelMutatingVisitor.b(m19013l());
                if (m19013l() != imageModel) {
                    graphQLVisitableModel = (DownloadImageFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f12081f = imageModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m19014a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m19011j());
            int a2 = ModelHelper.a(flatBufferBuilder, m19012k());
            int a3 = ModelHelper.a(flatBufferBuilder, m19013l());
            flatBufferBuilder.c(3);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            flatBufferBuilder.b(2, a3);
            i();
            return flatBufferBuilder.d();
        }
    }
}
