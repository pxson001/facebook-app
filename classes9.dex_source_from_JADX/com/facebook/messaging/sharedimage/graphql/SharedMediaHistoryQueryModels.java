package com.facebook.messaging.sharedimage.graphql;

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
import com.facebook.graphql.querybuilder.common.CommonGraphQL2Models.DefaultPageInfoFieldsModel;
import com.facebook.graphql.visitor.ConsistencyTuple;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.messaging.sharedimage.graphql.SharedMediaHistoryQueryParsers.MediaNodeInfoParser;
import com.facebook.messaging.sharedimage.graphql.SharedMediaHistoryQueryParsers.MediaNodeInfoParser.AdjustedSizeParser;
import com.facebook.messaging.sharedimage.graphql.SharedMediaHistoryQueryParsers.MediaNodeInfoParser.AnimatedGifParser;
import com.facebook.messaging.sharedimage.graphql.SharedMediaHistoryQueryParsers.MediaNodeInfoParser.AnimatedImageParser;
import com.facebook.messaging.sharedimage.graphql.SharedMediaHistoryQueryParsers.MediaNodeInfoParser.CreatorParser;
import com.facebook.messaging.sharedimage.graphql.SharedMediaHistoryQueryParsers.MediaNodeInfoParser.ImageThumbnailParser;
import com.facebook.messaging.sharedimage.graphql.SharedMediaHistoryQueryParsers.MediaNodeInfoParser.OriginalDimensionsParser;
import com.facebook.messaging.sharedimage.graphql.SharedMediaHistoryQueryParsers.SubsequentSharedMediaParser;
import com.facebook.messaging.sharedimage.graphql.SharedMediaHistoryQueryParsers.SubsequentSharedMediaParser.MediaCountParser;
import com.facebook.messaging.sharedimage.graphql.SharedMediaHistoryQueryParsers.SubsequentSharedMediaParser.MediaResultParser;
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

/* compiled from: composer_reply */
public class SharedMediaHistoryQueryModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1657447566)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: composer_reply */
    public final class MediaNodeInfoModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private GraphQLObjectType f17381d;
        @Nullable
        private AdjustedSizeModel f17382e;
        @Nullable
        private AnimatedGifModel f17383f;
        @Nullable
        private AnimatedImageModel f17384g;
        private long f17385h;
        @Nullable
        private CreatorModel f17386i;
        @Nullable
        private ImageThumbnailModel f17387j;
        @Nullable
        private String f17388k;
        @Nullable
        private String f17389l;
        @Nullable
        private OriginalDimensionsModel f17390m;

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 842551240)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: composer_reply */
        public final class AdjustedSizeModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private String f17372d;

            /* compiled from: composer_reply */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(AdjustedSizeModel.class, new Deserializer());
                }

                public Object m17287a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(AdjustedSizeParser.m17353a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object adjustedSizeModel = new AdjustedSizeModel();
                    ((BaseModel) adjustedSizeModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (adjustedSizeModel instanceof Postprocessable) {
                        return ((Postprocessable) adjustedSizeModel).a();
                    }
                    return adjustedSizeModel;
                }
            }

            /* compiled from: composer_reply */
            public class Serializer extends JsonSerializer<AdjustedSizeModel> {
                public final void m17288a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    AdjustedSizeModel adjustedSizeModel = (AdjustedSizeModel) obj;
                    if (adjustedSizeModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(adjustedSizeModel.m17290a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        adjustedSizeModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    AdjustedSizeParser.m17354a(adjustedSizeModel.w_(), adjustedSizeModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(AdjustedSizeModel.class, new Serializer());
                }
            }

            public AdjustedSizeModel() {
                super(1);
            }

            @Nullable
            private String m17289a() {
                this.f17372d = super.a(this.f17372d, 0);
                return this.f17372d;
            }

            public final int jK_() {
                return 70760763;
            }

            public final GraphQLVisitableModel m17291a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m17290a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m17289a());
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
        /* compiled from: composer_reply */
        public final class AnimatedGifModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private String f17373d;

            /* compiled from: composer_reply */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(AnimatedGifModel.class, new Deserializer());
                }

                public Object m17292a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(AnimatedGifParser.m17355a(jsonParser, flatBufferBuilder));
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

            /* compiled from: composer_reply */
            public class Serializer extends JsonSerializer<AnimatedGifModel> {
                public final void m17293a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    AnimatedGifModel animatedGifModel = (AnimatedGifModel) obj;
                    if (animatedGifModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(animatedGifModel.m17295a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        animatedGifModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    AnimatedGifParser.m17356a(animatedGifModel.w_(), animatedGifModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(AnimatedGifModel.class, new Serializer());
                }
            }

            public AnimatedGifModel() {
                super(1);
            }

            @Nullable
            private String m17294a() {
                this.f17373d = super.a(this.f17373d, 0);
                return this.f17373d;
            }

            public final int jK_() {
                return 70760763;
            }

            public final GraphQLVisitableModel m17296a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m17295a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m17294a());
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
        /* compiled from: composer_reply */
        public final class AnimatedImageModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private String f17374d;

            /* compiled from: composer_reply */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(AnimatedImageModel.class, new Deserializer());
                }

                public Object m17297a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(AnimatedImageParser.m17357a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object animatedImageModel = new AnimatedImageModel();
                    ((BaseModel) animatedImageModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (animatedImageModel instanceof Postprocessable) {
                        return ((Postprocessable) animatedImageModel).a();
                    }
                    return animatedImageModel;
                }
            }

            /* compiled from: composer_reply */
            public class Serializer extends JsonSerializer<AnimatedImageModel> {
                public final void m17298a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    AnimatedImageModel animatedImageModel = (AnimatedImageModel) obj;
                    if (animatedImageModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(animatedImageModel.m17300a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        animatedImageModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    AnimatedImageParser.m17358a(animatedImageModel.w_(), animatedImageModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(AnimatedImageModel.class, new Serializer());
                }
            }

            public AnimatedImageModel() {
                super(1);
            }

            @Nullable
            private String m17299a() {
                this.f17374d = super.a(this.f17374d, 0);
                return this.f17374d;
            }

            public final int jK_() {
                return 70760763;
            }

            public final GraphQLVisitableModel m17301a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m17300a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m17299a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1255661007)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: composer_reply */
        public final class CreatorModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
            @Nullable
            private GraphQLObjectType f17375d;
            @Nullable
            private String f17376e;
            @Nullable
            private String f17377f;

            /* compiled from: composer_reply */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(CreatorModel.class, new Deserializer());
                }

                public Object m17302a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(CreatorParser.m17359a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object creatorModel = new CreatorModel();
                    ((BaseModel) creatorModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (creatorModel instanceof Postprocessable) {
                        return ((Postprocessable) creatorModel).a();
                    }
                    return creatorModel;
                }
            }

            /* compiled from: composer_reply */
            public class Serializer extends JsonSerializer<CreatorModel> {
                public final void m17303a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    CreatorModel creatorModel = (CreatorModel) obj;
                    if (creatorModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(creatorModel.m17307a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        creatorModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    CreatorParser.m17360a(creatorModel.w_(), creatorModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(CreatorModel.class, new Serializer());
                }
            }

            public CreatorModel() {
                super(3);
            }

            public final void m17310a(String str, ConsistencyTuple consistencyTuple) {
                consistencyTuple.a();
            }

            public final void m17311a(String str, Object obj, boolean z) {
            }

            @Nullable
            private GraphQLObjectType m17304j() {
                if (this.b != null && this.f17375d == null) {
                    this.f17375d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                }
                return this.f17375d;
            }

            @Nullable
            private String m17305k() {
                this.f17376e = super.a(this.f17376e, 1);
                return this.f17376e;
            }

            @Nullable
            private String m17306l() {
                this.f17377f = super.a(this.f17377f, 2);
                return this.f17377f;
            }

            @Nullable
            public final String m17309a() {
                return m17305k();
            }

            public final int jK_() {
                return 63093205;
            }

            public final GraphQLVisitableModel m17308a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m17307a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m17304j());
                int b = flatBufferBuilder.b(m17305k());
                int b2 = flatBufferBuilder.b(m17306l());
                flatBufferBuilder.c(3);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, b);
                flatBufferBuilder.b(2, b2);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: composer_reply */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(MediaNodeInfoModel.class, new Deserializer());
            }

            public Object m17312a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(MediaNodeInfoParser.m17365b(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object mediaNodeInfoModel = new MediaNodeInfoModel();
                ((BaseModel) mediaNodeInfoModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (mediaNodeInfoModel instanceof Postprocessable) {
                    return ((Postprocessable) mediaNodeInfoModel).a();
                }
                return mediaNodeInfoModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 842551240)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: composer_reply */
        public final class ImageThumbnailModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private String f17378d;

            /* compiled from: composer_reply */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(ImageThumbnailModel.class, new Deserializer());
                }

                public Object m17313a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(ImageThumbnailParser.m17361a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object imageThumbnailModel = new ImageThumbnailModel();
                    ((BaseModel) imageThumbnailModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (imageThumbnailModel instanceof Postprocessable) {
                        return ((Postprocessable) imageThumbnailModel).a();
                    }
                    return imageThumbnailModel;
                }
            }

            /* compiled from: composer_reply */
            public class Serializer extends JsonSerializer<ImageThumbnailModel> {
                public final void m17314a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    ImageThumbnailModel imageThumbnailModel = (ImageThumbnailModel) obj;
                    if (imageThumbnailModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(imageThumbnailModel.m17316a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        imageThumbnailModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    ImageThumbnailParser.m17362a(imageThumbnailModel.w_(), imageThumbnailModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(ImageThumbnailModel.class, new Serializer());
                }
            }

            public ImageThumbnailModel() {
                super(1);
            }

            @Nullable
            private String m17315a() {
                this.f17378d = super.a(this.f17378d, 0);
                return this.f17378d;
            }

            public final int jK_() {
                return 70760763;
            }

            public final GraphQLVisitableModel m17317a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m17316a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m17315a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -496435496)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: composer_reply */
        public final class OriginalDimensionsModel extends BaseModel implements GraphQLVisitableModel {
            private double f17379d;
            private double f17380e;

            /* compiled from: composer_reply */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(OriginalDimensionsModel.class, new Deserializer());
                }

                public Object m17318a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(OriginalDimensionsParser.m17363a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object originalDimensionsModel = new OriginalDimensionsModel();
                    ((BaseModel) originalDimensionsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (originalDimensionsModel instanceof Postprocessable) {
                        return ((Postprocessable) originalDimensionsModel).a();
                    }
                    return originalDimensionsModel;
                }
            }

            /* compiled from: composer_reply */
            public class Serializer extends JsonSerializer<OriginalDimensionsModel> {
                public final void m17319a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    OriginalDimensionsModel originalDimensionsModel = (OriginalDimensionsModel) obj;
                    if (originalDimensionsModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(originalDimensionsModel.m17320a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        originalDimensionsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    OriginalDimensionsParser.m17364a(originalDimensionsModel.w_(), originalDimensionsModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(OriginalDimensionsModel.class, new Serializer());
                }
            }

            public OriginalDimensionsModel() {
                super(2);
            }

            public final int jK_() {
                return 82530482;
            }

            public final GraphQLVisitableModel m17321a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m17320a(FlatBufferBuilder flatBufferBuilder) {
                h();
                flatBufferBuilder.c(2);
                flatBufferBuilder.a(0, this.f17379d, 0.0d);
                flatBufferBuilder.a(1, this.f17380e, 0.0d);
                i();
                return flatBufferBuilder.d();
            }

            public final void m17322a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f17379d = mutableFlatBuffer.a(i, 0, 0.0d);
                this.f17380e = mutableFlatBuffer.a(i, 1, 0.0d);
            }
        }

        /* compiled from: composer_reply */
        public class Serializer extends JsonSerializer<MediaNodeInfoModel> {
            public final void m17323a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MediaNodeInfoModel mediaNodeInfoModel = (MediaNodeInfoModel) obj;
                if (mediaNodeInfoModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(mediaNodeInfoModel.m17333a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mediaNodeInfoModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                MediaNodeInfoParser.m17366b(mediaNodeInfoModel.w_(), mediaNodeInfoModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(MediaNodeInfoModel.class, new Serializer());
            }
        }

        public MediaNodeInfoModel() {
            super(10);
        }

        @Nullable
        private GraphQLObjectType m17324a() {
            if (this.b != null && this.f17381d == null) {
                this.f17381d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
            }
            return this.f17381d;
        }

        @Nullable
        private AdjustedSizeModel m17325j() {
            this.f17382e = (AdjustedSizeModel) super.a(this.f17382e, 1, AdjustedSizeModel.class);
            return this.f17382e;
        }

        @Nullable
        private AnimatedGifModel m17326k() {
            this.f17383f = (AnimatedGifModel) super.a(this.f17383f, 2, AnimatedGifModel.class);
            return this.f17383f;
        }

        @Nullable
        private AnimatedImageModel m17327l() {
            this.f17384g = (AnimatedImageModel) super.a(this.f17384g, 3, AnimatedImageModel.class);
            return this.f17384g;
        }

        @Nullable
        private CreatorModel m17328m() {
            this.f17386i = (CreatorModel) super.a(this.f17386i, 5, CreatorModel.class);
            return this.f17386i;
        }

        @Nullable
        private ImageThumbnailModel m17329n() {
            this.f17387j = (ImageThumbnailModel) super.a(this.f17387j, 6, ImageThumbnailModel.class);
            return this.f17387j;
        }

        @Nullable
        private String m17330o() {
            this.f17388k = super.a(this.f17388k, 7);
            return this.f17388k;
        }

        @Nullable
        private String m17331p() {
            this.f17389l = super.a(this.f17389l, 8);
            return this.f17389l;
        }

        @Nullable
        private OriginalDimensionsModel m17332q() {
            this.f17390m = (OriginalDimensionsModel) super.a(this.f17390m, 9, OriginalDimensionsModel.class);
            return this.f17390m;
        }

        public final int jK_() {
            return -1142246376;
        }

        public final GraphQLVisitableModel m17334a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m17325j() != null) {
                AdjustedSizeModel adjustedSizeModel = (AdjustedSizeModel) graphQLModelMutatingVisitor.b(m17325j());
                if (m17325j() != adjustedSizeModel) {
                    graphQLVisitableModel = (MediaNodeInfoModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f17382e = adjustedSizeModel;
                }
            }
            if (m17326k() != null) {
                AnimatedGifModel animatedGifModel = (AnimatedGifModel) graphQLModelMutatingVisitor.b(m17326k());
                if (m17326k() != animatedGifModel) {
                    graphQLVisitableModel = (MediaNodeInfoModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f17383f = animatedGifModel;
                }
            }
            if (m17327l() != null) {
                AnimatedImageModel animatedImageModel = (AnimatedImageModel) graphQLModelMutatingVisitor.b(m17327l());
                if (m17327l() != animatedImageModel) {
                    graphQLVisitableModel = (MediaNodeInfoModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f17384g = animatedImageModel;
                }
            }
            if (m17328m() != null) {
                CreatorModel creatorModel = (CreatorModel) graphQLModelMutatingVisitor.b(m17328m());
                if (m17328m() != creatorModel) {
                    graphQLVisitableModel = (MediaNodeInfoModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f17386i = creatorModel;
                }
            }
            if (m17329n() != null) {
                ImageThumbnailModel imageThumbnailModel = (ImageThumbnailModel) graphQLModelMutatingVisitor.b(m17329n());
                if (m17329n() != imageThumbnailModel) {
                    graphQLVisitableModel = (MediaNodeInfoModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f17387j = imageThumbnailModel;
                }
            }
            if (m17332q() != null) {
                OriginalDimensionsModel originalDimensionsModel = (OriginalDimensionsModel) graphQLModelMutatingVisitor.b(m17332q());
                if (m17332q() != originalDimensionsModel) {
                    graphQLVisitableModel = (MediaNodeInfoModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f17390m = originalDimensionsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m17333a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m17324a());
            int a2 = ModelHelper.a(flatBufferBuilder, m17325j());
            int a3 = ModelHelper.a(flatBufferBuilder, m17326k());
            int a4 = ModelHelper.a(flatBufferBuilder, m17327l());
            int a5 = ModelHelper.a(flatBufferBuilder, m17328m());
            int a6 = ModelHelper.a(flatBufferBuilder, m17329n());
            int b = flatBufferBuilder.b(m17330o());
            int b2 = flatBufferBuilder.b(m17331p());
            int a7 = ModelHelper.a(flatBufferBuilder, m17332q());
            flatBufferBuilder.c(10);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            flatBufferBuilder.b(2, a3);
            flatBufferBuilder.b(3, a4);
            flatBufferBuilder.a(4, this.f17385h, 0);
            flatBufferBuilder.b(5, a5);
            flatBufferBuilder.b(6, a6);
            flatBufferBuilder.b(7, b);
            flatBufferBuilder.b(8, b2);
            flatBufferBuilder.b(9, a7);
            i();
            return flatBufferBuilder.d();
        }

        public final void m17335a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f17385h = mutableFlatBuffer.a(i, 4, 0);
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 370811896)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: composer_reply */
    public final class SubsequentSharedMediaModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private MediaCountModel f17394d;
        @Nullable
        private MediaResultModel f17395e;

        /* compiled from: composer_reply */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(SubsequentSharedMediaModel.class, new Deserializer());
            }

            public Object m17336a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = SubsequentSharedMediaParser.m17371a(jsonParser);
                Object subsequentSharedMediaModel = new SubsequentSharedMediaModel();
                ((BaseModel) subsequentSharedMediaModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (subsequentSharedMediaModel instanceof Postprocessable) {
                    return ((Postprocessable) subsequentSharedMediaModel).a();
                }
                return subsequentSharedMediaModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1723990064)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: composer_reply */
        public final class MediaCountModel extends BaseModel implements GraphQLVisitableModel {
            private int f17391d;

            /* compiled from: composer_reply */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(MediaCountModel.class, new Deserializer());
                }

                public Object m17337a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(MediaCountParser.m17367a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object mediaCountModel = new MediaCountModel();
                    ((BaseModel) mediaCountModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (mediaCountModel instanceof Postprocessable) {
                        return ((Postprocessable) mediaCountModel).a();
                    }
                    return mediaCountModel;
                }
            }

            /* compiled from: composer_reply */
            public class Serializer extends JsonSerializer<MediaCountModel> {
                public final void m17338a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    MediaCountModel mediaCountModel = (MediaCountModel) obj;
                    if (mediaCountModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(mediaCountModel.m17339a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mediaCountModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    MediaCountParser.m17368a(mediaCountModel.w_(), mediaCountModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(MediaCountModel.class, new Serializer());
                }
            }

            public MediaCountModel() {
                super(1);
            }

            public final int jK_() {
                return 1797312790;
            }

            public final GraphQLVisitableModel m17340a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m17339a(FlatBufferBuilder flatBufferBuilder) {
                h();
                flatBufferBuilder.c(1);
                flatBufferBuilder.a(0, this.f17391d, 0);
                i();
                return flatBufferBuilder.d();
            }

            public final void m17341a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f17391d = mutableFlatBuffer.a(i, 0, 0);
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1481095804)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: composer_reply */
        public final class MediaResultModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<MediaNodeInfoModel> f17392d;
            @Nullable
            private DefaultPageInfoFieldsModel f17393e;

            /* compiled from: composer_reply */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(MediaResultModel.class, new Deserializer());
                }

                public Object m17342a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(MediaResultParser.m17369a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object mediaResultModel = new MediaResultModel();
                    ((BaseModel) mediaResultModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (mediaResultModel instanceof Postprocessable) {
                        return ((Postprocessable) mediaResultModel).a();
                    }
                    return mediaResultModel;
                }
            }

            /* compiled from: composer_reply */
            public class Serializer extends JsonSerializer<MediaResultModel> {
                public final void m17343a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    MediaResultModel mediaResultModel = (MediaResultModel) obj;
                    if (mediaResultModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(mediaResultModel.m17346a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mediaResultModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    MediaResultParser.m17370a(mediaResultModel.w_(), mediaResultModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(MediaResultModel.class, new Serializer());
                }
            }

            public MediaResultModel() {
                super(2);
            }

            @Nonnull
            private ImmutableList<MediaNodeInfoModel> m17344a() {
                this.f17392d = super.a(this.f17392d, 0, MediaNodeInfoModel.class);
                return (ImmutableList) this.f17392d;
            }

            @Nullable
            private DefaultPageInfoFieldsModel m17345j() {
                this.f17393e = (DefaultPageInfoFieldsModel) super.a(this.f17393e, 1, DefaultPageInfoFieldsModel.class);
                return this.f17393e;
            }

            public final int jK_() {
                return 1797312790;
            }

            public final GraphQLVisitableModel m17347a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel;
                DefaultPageInfoFieldsModel defaultPageInfoFieldsModel;
                h();
                if (m17344a() != null) {
                    Builder a = ModelHelper.a(m17344a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        MediaResultModel mediaResultModel = (MediaResultModel) ModelHelper.a(null, this);
                        mediaResultModel.f17392d = a.b();
                        graphQLVisitableModel = mediaResultModel;
                        if (m17345j() != null) {
                            defaultPageInfoFieldsModel = (DefaultPageInfoFieldsModel) graphQLModelMutatingVisitor.b(m17345j());
                            if (m17345j() != defaultPageInfoFieldsModel) {
                                graphQLVisitableModel = (MediaResultModel) ModelHelper.a(graphQLVisitableModel, this);
                                graphQLVisitableModel.f17393e = defaultPageInfoFieldsModel;
                            }
                        }
                        i();
                        return graphQLVisitableModel != null ? this : graphQLVisitableModel;
                    }
                }
                graphQLVisitableModel = null;
                if (m17345j() != null) {
                    defaultPageInfoFieldsModel = (DefaultPageInfoFieldsModel) graphQLModelMutatingVisitor.b(m17345j());
                    if (m17345j() != defaultPageInfoFieldsModel) {
                        graphQLVisitableModel = (MediaResultModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f17393e = defaultPageInfoFieldsModel;
                    }
                }
                i();
                if (graphQLVisitableModel != null) {
                }
            }

            public final int m17346a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m17344a());
                int a2 = ModelHelper.a(flatBufferBuilder, m17345j());
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, a2);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: composer_reply */
        public class Serializer extends JsonSerializer<SubsequentSharedMediaModel> {
            public final void m17348a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                SubsequentSharedMediaModel subsequentSharedMediaModel = (SubsequentSharedMediaModel) obj;
                if (subsequentSharedMediaModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(subsequentSharedMediaModel.m17351a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    subsequentSharedMediaModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = subsequentSharedMediaModel.w_();
                int u_ = subsequentSharedMediaModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("mediaCount");
                    MediaCountParser.m17368a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(u_, 1);
                if (g != 0) {
                    jsonGenerator.a("mediaResult");
                    MediaResultParser.m17370a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(SubsequentSharedMediaModel.class, new Serializer());
            }
        }

        public SubsequentSharedMediaModel() {
            super(2);
        }

        @Nullable
        private MediaCountModel m17349a() {
            this.f17394d = (MediaCountModel) super.a(this.f17394d, 0, MediaCountModel.class);
            return this.f17394d;
        }

        @Nullable
        private MediaResultModel m17350j() {
            this.f17395e = (MediaResultModel) super.a(this.f17395e, 1, MediaResultModel.class);
            return this.f17395e;
        }

        public final int jK_() {
            return -740570927;
        }

        public final GraphQLVisitableModel m17352a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m17349a() != null) {
                MediaCountModel mediaCountModel = (MediaCountModel) graphQLModelMutatingVisitor.b(m17349a());
                if (m17349a() != mediaCountModel) {
                    graphQLVisitableModel = (SubsequentSharedMediaModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f17394d = mediaCountModel;
                }
            }
            if (m17350j() != null) {
                MediaResultModel mediaResultModel = (MediaResultModel) graphQLModelMutatingVisitor.b(m17350j());
                if (m17350j() != mediaResultModel) {
                    graphQLVisitableModel = (SubsequentSharedMediaModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f17395e = mediaResultModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m17351a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m17349a());
            int a2 = ModelHelper.a(flatBufferBuilder, m17350j());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            i();
            return flatBufferBuilder.d();
        }
    }
}
