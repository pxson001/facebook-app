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
import com.facebook.messaging.sharedimage.graphql.SharedImageHistoryQueryParsers.PhotoNodeInfoParser;
import com.facebook.messaging.sharedimage.graphql.SharedImageHistoryQueryParsers.PhotoNodeInfoParser.AdjustedSizeParser;
import com.facebook.messaging.sharedimage.graphql.SharedImageHistoryQueryParsers.PhotoNodeInfoParser.CreatorParser;
import com.facebook.messaging.sharedimage.graphql.SharedImageHistoryQueryParsers.PhotoNodeInfoParser.ImageThumbnailParser;
import com.facebook.messaging.sharedimage.graphql.SharedImageHistoryQueryParsers.PhotoNodeInfoParser.MessageObjectParser;
import com.facebook.messaging.sharedimage.graphql.SharedImageHistoryQueryParsers.PhotoNodeInfoParser.MessageObjectParser.MessageParser;
import com.facebook.messaging.sharedimage.graphql.SharedImageHistoryQueryParsers.PhotoNodeInfoParser.OriginalDimensionsParser;
import com.facebook.messaging.sharedimage.graphql.SharedImageHistoryQueryParsers.SubsequentSharedPhotosParser;
import com.facebook.messaging.sharedimage.graphql.SharedImageHistoryQueryParsers.SubsequentSharedPhotosParser.ImageCountParser;
import com.facebook.messaging.sharedimage.graphql.SharedImageHistoryQueryParsers.SubsequentSharedPhotosParser.PhotoResultParser;
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

/* compiled from: config_type */
public class SharedImageHistoryQueryModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1478171198)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: config_type */
    public final class PhotoNodeInfoModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private AdjustedSizeModel f17359d;
        private long f17360e;
        @Nullable
        private CreatorModel f17361f;
        @Nullable
        private String f17362g;
        @Nullable
        private ImageThumbnailModel f17363h;
        @Nullable
        private String f17364i;
        @Nullable
        private MessageObjectModel f17365j;
        @Nullable
        private OriginalDimensionsModel f17366k;

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 842551240)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: config_type */
        public final class AdjustedSizeModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private String f17348d;

            /* compiled from: config_type */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(AdjustedSizeModel.class, new Deserializer());
                }

                public Object m17197a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(AdjustedSizeParser.m17268a(jsonParser, flatBufferBuilder));
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

            /* compiled from: config_type */
            public class Serializer extends JsonSerializer<AdjustedSizeModel> {
                public final void m17198a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    AdjustedSizeModel adjustedSizeModel = (AdjustedSizeModel) obj;
                    if (adjustedSizeModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(adjustedSizeModel.m17199a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        adjustedSizeModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    AdjustedSizeParser.m17269a(adjustedSizeModel.w_(), adjustedSizeModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(AdjustedSizeModel.class, new Serializer());
                }
            }

            public AdjustedSizeModel() {
                super(1);
            }

            @Nullable
            public final String m17201a() {
                this.f17348d = super.a(this.f17348d, 0);
                return this.f17348d;
            }

            public final int jK_() {
                return 70760763;
            }

            public final GraphQLVisitableModel m17200a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m17199a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m17201a());
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
        /* compiled from: config_type */
        public final class CreatorModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
            @Nullable
            private GraphQLObjectType f17349d;
            @Nullable
            private String f17350e;
            @Nullable
            private String f17351f;

            /* compiled from: config_type */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(CreatorModel.class, new Deserializer());
                }

                public Object m17202a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(CreatorParser.m17270a(jsonParser, flatBufferBuilder));
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

            /* compiled from: config_type */
            public class Serializer extends JsonSerializer<CreatorModel> {
                public final void m17203a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    CreatorModel creatorModel = (CreatorModel) obj;
                    if (creatorModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(creatorModel.m17205a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        creatorModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    CreatorParser.m17271a(creatorModel.w_(), creatorModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(CreatorModel.class, new Serializer());
                }
            }

            public CreatorModel() {
                super(3);
            }

            public final void m17208a(String str, ConsistencyTuple consistencyTuple) {
                consistencyTuple.a();
            }

            public final void m17209a(String str, Object obj, boolean z) {
            }

            @Nullable
            private GraphQLObjectType m17204l() {
                if (this.b != null && this.f17349d == null) {
                    this.f17349d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                }
                return this.f17349d;
            }

            @Nullable
            public final String m17210j() {
                this.f17350e = super.a(this.f17350e, 1);
                return this.f17350e;
            }

            @Nullable
            public final String m17211k() {
                this.f17351f = super.a(this.f17351f, 2);
                return this.f17351f;
            }

            @Nullable
            public final String m17207a() {
                return m17210j();
            }

            public final int jK_() {
                return 63093205;
            }

            public final GraphQLVisitableModel m17206a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m17205a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m17204l());
                int b = flatBufferBuilder.b(m17210j());
                int b2 = flatBufferBuilder.b(m17211k());
                flatBufferBuilder.c(3);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, b);
                flatBufferBuilder.b(2, b2);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: config_type */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(PhotoNodeInfoModel.class, new Deserializer());
            }

            public Object m17212a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(PhotoNodeInfoParser.m17280b(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object photoNodeInfoModel = new PhotoNodeInfoModel();
                ((BaseModel) photoNodeInfoModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (photoNodeInfoModel instanceof Postprocessable) {
                    return ((Postprocessable) photoNodeInfoModel).a();
                }
                return photoNodeInfoModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 842551240)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: config_type */
        public final class ImageThumbnailModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private String f17352d;

            /* compiled from: config_type */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(ImageThumbnailModel.class, new Deserializer());
                }

                public Object m17213a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(ImageThumbnailParser.m17272a(jsonParser, flatBufferBuilder));
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

            /* compiled from: config_type */
            public class Serializer extends JsonSerializer<ImageThumbnailModel> {
                public final void m17214a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    ImageThumbnailModel imageThumbnailModel = (ImageThumbnailModel) obj;
                    if (imageThumbnailModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(imageThumbnailModel.m17215a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        imageThumbnailModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    ImageThumbnailParser.m17273a(imageThumbnailModel.w_(), imageThumbnailModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(ImageThumbnailModel.class, new Serializer());
                }
            }

            public ImageThumbnailModel() {
                super(1);
            }

            @Nullable
            public final String m17217a() {
                this.f17352d = super.a(this.f17352d, 0);
                return this.f17352d;
            }

            public final int jK_() {
                return 70760763;
            }

            public final GraphQLVisitableModel m17216a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m17215a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m17217a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 642614897)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: config_type */
        public final class MessageObjectModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
            @Nullable
            private GraphQLObjectType f17354d;
            @Nullable
            private String f17355e;
            @Nullable
            private MessageModel f17356f;

            /* compiled from: config_type */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(MessageObjectModel.class, new Deserializer());
                }

                public Object m17218a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(MessageObjectParser.m17276a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object messageObjectModel = new MessageObjectModel();
                    ((BaseModel) messageObjectModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (messageObjectModel instanceof Postprocessable) {
                        return ((Postprocessable) messageObjectModel).a();
                    }
                    return messageObjectModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -1352864475)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: config_type */
            public final class MessageModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private String f17353d;

                /* compiled from: config_type */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(MessageModel.class, new Deserializer());
                    }

                    public Object m17219a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(MessageParser.m17274a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object messageModel = new MessageModel();
                        ((BaseModel) messageModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (messageModel instanceof Postprocessable) {
                            return ((Postprocessable) messageModel).a();
                        }
                        return messageModel;
                    }
                }

                /* compiled from: config_type */
                public class Serializer extends JsonSerializer<MessageModel> {
                    public final void m17220a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        MessageModel messageModel = (MessageModel) obj;
                        if (messageModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(messageModel.m17221a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            messageModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        MessageParser.m17275a(messageModel.w_(), messageModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(MessageModel.class, new Serializer());
                    }
                }

                public MessageModel() {
                    super(1);
                }

                @Nullable
                public final String m17223a() {
                    this.f17353d = super.a(this.f17353d, 0);
                    return this.f17353d;
                }

                public final int jK_() {
                    return -1919764332;
                }

                public final GraphQLVisitableModel m17222a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m17221a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int b = flatBufferBuilder.b(m17223a());
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, b);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: config_type */
            public class Serializer extends JsonSerializer<MessageObjectModel> {
                public final void m17224a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    MessageObjectModel messageObjectModel = (MessageObjectModel) obj;
                    if (messageObjectModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(messageObjectModel.m17226a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        messageObjectModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    MessageObjectParser.m17277a(messageObjectModel.w_(), messageObjectModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(MessageObjectModel.class, new Serializer());
                }
            }

            public MessageObjectModel() {
                super(3);
            }

            @Nullable
            private GraphQLObjectType m17225l() {
                if (this.b != null && this.f17354d == null) {
                    this.f17354d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                }
                return this.f17354d;
            }

            @Nullable
            public final String m17229j() {
                this.f17355e = super.a(this.f17355e, 1);
                return this.f17355e;
            }

            @Nullable
            public final MessageModel m17230k() {
                this.f17356f = (MessageModel) super.a(this.f17356f, 2, MessageModel.class);
                return this.f17356f;
            }

            @Nullable
            public final String m17228a() {
                return m17229j();
            }

            public final int jK_() {
                return -1675388953;
            }

            public final GraphQLVisitableModel m17227a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m17230k() != null) {
                    MessageModel messageModel = (MessageModel) graphQLModelMutatingVisitor.b(m17230k());
                    if (m17230k() != messageModel) {
                        graphQLVisitableModel = (MessageObjectModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f17356f = messageModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m17226a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m17225l());
                int b = flatBufferBuilder.b(m17229j());
                int a2 = ModelHelper.a(flatBufferBuilder, m17230k());
                flatBufferBuilder.c(3);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, b);
                flatBufferBuilder.b(2, a2);
                i();
                return flatBufferBuilder.d();
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -496435496)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: config_type */
        public final class OriginalDimensionsModel extends BaseModel implements GraphQLVisitableModel {
            private double f17357d;
            private double f17358e;

            /* compiled from: config_type */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(OriginalDimensionsModel.class, new Deserializer());
                }

                public Object m17231a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(OriginalDimensionsParser.m17278a(jsonParser, flatBufferBuilder));
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

            /* compiled from: config_type */
            public class Serializer extends JsonSerializer<OriginalDimensionsModel> {
                public final void m17232a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    OriginalDimensionsModel originalDimensionsModel = (OriginalDimensionsModel) obj;
                    if (originalDimensionsModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(originalDimensionsModel.m17234a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        originalDimensionsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    OriginalDimensionsParser.m17279a(originalDimensionsModel.w_(), originalDimensionsModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(OriginalDimensionsModel.class, new Serializer());
                }
            }

            public OriginalDimensionsModel() {
                super(2);
            }

            public final double m17233a() {
                a(0, 0);
                return this.f17357d;
            }

            public final double m17237j() {
                a(0, 1);
                return this.f17358e;
            }

            public final int jK_() {
                return 82530482;
            }

            public final GraphQLVisitableModel m17235a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m17234a(FlatBufferBuilder flatBufferBuilder) {
                h();
                flatBufferBuilder.c(2);
                flatBufferBuilder.a(0, this.f17357d, 0.0d);
                flatBufferBuilder.a(1, this.f17358e, 0.0d);
                i();
                return flatBufferBuilder.d();
            }

            public final void m17236a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f17357d = mutableFlatBuffer.a(i, 0, 0.0d);
                this.f17358e = mutableFlatBuffer.a(i, 1, 0.0d);
            }
        }

        /* compiled from: config_type */
        public class Serializer extends JsonSerializer<PhotoNodeInfoModel> {
            public final void m17238a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                PhotoNodeInfoModel photoNodeInfoModel = (PhotoNodeInfoModel) obj;
                if (photoNodeInfoModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(photoNodeInfoModel.m17240a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    photoNodeInfoModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                PhotoNodeInfoParser.m17281b(photoNodeInfoModel.w_(), photoNodeInfoModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(PhotoNodeInfoModel.class, new Serializer());
            }
        }

        public PhotoNodeInfoModel() {
            super(8);
        }

        @Nullable
        public final AdjustedSizeModel m17242a() {
            this.f17359d = (AdjustedSizeModel) super.a(this.f17359d, 0, AdjustedSizeModel.class);
            return this.f17359d;
        }

        public final long m17244j() {
            a(0, 1);
            return this.f17360e;
        }

        @Nullable
        public final CreatorModel m17245k() {
            this.f17361f = (CreatorModel) super.a(this.f17361f, 2, CreatorModel.class);
            return this.f17361f;
        }

        @Nullable
        private String m17239p() {
            this.f17362g = super.a(this.f17362g, 3);
            return this.f17362g;
        }

        @Nullable
        public final ImageThumbnailModel m17246l() {
            this.f17363h = (ImageThumbnailModel) super.a(this.f17363h, 4, ImageThumbnailModel.class);
            return this.f17363h;
        }

        @Nullable
        public final String m17247m() {
            this.f17364i = super.a(this.f17364i, 5);
            return this.f17364i;
        }

        @Nullable
        public final MessageObjectModel m17248n() {
            this.f17365j = (MessageObjectModel) super.a(this.f17365j, 6, MessageObjectModel.class);
            return this.f17365j;
        }

        @Nullable
        public final OriginalDimensionsModel m17249o() {
            this.f17366k = (OriginalDimensionsModel) super.a(this.f17366k, 7, OriginalDimensionsModel.class);
            return this.f17366k;
        }

        public final int jK_() {
            return -1142294092;
        }

        public final GraphQLVisitableModel m17241a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m17242a() != null) {
                AdjustedSizeModel adjustedSizeModel = (AdjustedSizeModel) graphQLModelMutatingVisitor.b(m17242a());
                if (m17242a() != adjustedSizeModel) {
                    graphQLVisitableModel = (PhotoNodeInfoModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f17359d = adjustedSizeModel;
                }
            }
            if (m17245k() != null) {
                CreatorModel creatorModel = (CreatorModel) graphQLModelMutatingVisitor.b(m17245k());
                if (m17245k() != creatorModel) {
                    graphQLVisitableModel = (PhotoNodeInfoModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f17361f = creatorModel;
                }
            }
            if (m17246l() != null) {
                ImageThumbnailModel imageThumbnailModel = (ImageThumbnailModel) graphQLModelMutatingVisitor.b(m17246l());
                if (m17246l() != imageThumbnailModel) {
                    graphQLVisitableModel = (PhotoNodeInfoModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f17363h = imageThumbnailModel;
                }
            }
            if (m17248n() != null) {
                MessageObjectModel messageObjectModel = (MessageObjectModel) graphQLModelMutatingVisitor.b(m17248n());
                if (m17248n() != messageObjectModel) {
                    graphQLVisitableModel = (PhotoNodeInfoModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f17365j = messageObjectModel;
                }
            }
            if (m17249o() != null) {
                OriginalDimensionsModel originalDimensionsModel = (OriginalDimensionsModel) graphQLModelMutatingVisitor.b(m17249o());
                if (m17249o() != originalDimensionsModel) {
                    graphQLVisitableModel = (PhotoNodeInfoModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f17366k = originalDimensionsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m17240a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m17242a());
            int a2 = ModelHelper.a(flatBufferBuilder, m17245k());
            int b = flatBufferBuilder.b(m17239p());
            int a3 = ModelHelper.a(flatBufferBuilder, m17246l());
            int b2 = flatBufferBuilder.b(m17247m());
            int a4 = ModelHelper.a(flatBufferBuilder, m17248n());
            int a5 = ModelHelper.a(flatBufferBuilder, m17249o());
            flatBufferBuilder.c(8);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.a(1, this.f17360e, 0);
            flatBufferBuilder.b(2, a2);
            flatBufferBuilder.b(3, b);
            flatBufferBuilder.b(4, a3);
            flatBufferBuilder.b(5, b2);
            flatBufferBuilder.b(6, a4);
            flatBufferBuilder.b(7, a5);
            i();
            return flatBufferBuilder.d();
        }

        public final void m17243a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f17360e = mutableFlatBuffer.a(i, 1, 0);
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1403769663)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: config_type */
    public final class SubsequentSharedPhotosModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private ImageCountModel f17370d;
        @Nullable
        private PhotoResultModel f17371e;

        /* compiled from: config_type */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(SubsequentSharedPhotosModel.class, new Deserializer());
            }

            public Object m17250a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = SubsequentSharedPhotosParser.m17286a(jsonParser);
                Object subsequentSharedPhotosModel = new SubsequentSharedPhotosModel();
                ((BaseModel) subsequentSharedPhotosModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (subsequentSharedPhotosModel instanceof Postprocessable) {
                    return ((Postprocessable) subsequentSharedPhotosModel).a();
                }
                return subsequentSharedPhotosModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1723990064)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: config_type */
        public final class ImageCountModel extends BaseModel implements GraphQLVisitableModel {
            private int f17367d;

            /* compiled from: config_type */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(ImageCountModel.class, new Deserializer());
                }

                public Object m17251a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(ImageCountParser.m17282a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object imageCountModel = new ImageCountModel();
                    ((BaseModel) imageCountModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (imageCountModel instanceof Postprocessable) {
                        return ((Postprocessable) imageCountModel).a();
                    }
                    return imageCountModel;
                }
            }

            /* compiled from: config_type */
            public class Serializer extends JsonSerializer<ImageCountModel> {
                public final void m17252a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    ImageCountModel imageCountModel = (ImageCountModel) obj;
                    if (imageCountModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(imageCountModel.m17254a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        imageCountModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    ImageCountParser.m17283a(imageCountModel.w_(), imageCountModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(ImageCountModel.class, new Serializer());
                }
            }

            public ImageCountModel() {
                super(1);
            }

            public final int m17253a() {
                a(0, 0);
                return this.f17367d;
            }

            public final int jK_() {
                return 1183536509;
            }

            public final GraphQLVisitableModel m17255a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m17254a(FlatBufferBuilder flatBufferBuilder) {
                h();
                flatBufferBuilder.c(1);
                flatBufferBuilder.a(0, this.f17367d, 0);
                i();
                return flatBufferBuilder.d();
            }

            public final void m17256a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f17367d = mutableFlatBuffer.a(i, 0, 0);
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1797339070)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: config_type */
        public final class PhotoResultModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<PhotoNodeInfoModel> f17368d;
            @Nullable
            private DefaultPageInfoFieldsModel f17369e;

            /* compiled from: config_type */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(PhotoResultModel.class, new Deserializer());
                }

                public Object m17257a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(PhotoResultParser.m17284a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object photoResultModel = new PhotoResultModel();
                    ((BaseModel) photoResultModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (photoResultModel instanceof Postprocessable) {
                        return ((Postprocessable) photoResultModel).a();
                    }
                    return photoResultModel;
                }
            }

            /* compiled from: config_type */
            public class Serializer extends JsonSerializer<PhotoResultModel> {
                public final void m17258a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    PhotoResultModel photoResultModel = (PhotoResultModel) obj;
                    if (photoResultModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(photoResultModel.m17259a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        photoResultModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    PhotoResultParser.m17285a(photoResultModel.w_(), photoResultModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(PhotoResultModel.class, new Serializer());
                }
            }

            public PhotoResultModel() {
                super(2);
            }

            @Nonnull
            public final ImmutableList<PhotoNodeInfoModel> m17261a() {
                this.f17368d = super.a(this.f17368d, 0, PhotoNodeInfoModel.class);
                return (ImmutableList) this.f17368d;
            }

            @Nullable
            public final DefaultPageInfoFieldsModel m17262j() {
                this.f17369e = (DefaultPageInfoFieldsModel) super.a(this.f17369e, 1, DefaultPageInfoFieldsModel.class);
                return this.f17369e;
            }

            public final int jK_() {
                return 1183536509;
            }

            public final GraphQLVisitableModel m17260a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel;
                DefaultPageInfoFieldsModel defaultPageInfoFieldsModel;
                h();
                if (m17261a() != null) {
                    Builder a = ModelHelper.a(m17261a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        PhotoResultModel photoResultModel = (PhotoResultModel) ModelHelper.a(null, this);
                        photoResultModel.f17368d = a.b();
                        graphQLVisitableModel = photoResultModel;
                        if (m17262j() != null) {
                            defaultPageInfoFieldsModel = (DefaultPageInfoFieldsModel) graphQLModelMutatingVisitor.b(m17262j());
                            if (m17262j() != defaultPageInfoFieldsModel) {
                                graphQLVisitableModel = (PhotoResultModel) ModelHelper.a(graphQLVisitableModel, this);
                                graphQLVisitableModel.f17369e = defaultPageInfoFieldsModel;
                            }
                        }
                        i();
                        return graphQLVisitableModel != null ? this : graphQLVisitableModel;
                    }
                }
                graphQLVisitableModel = null;
                if (m17262j() != null) {
                    defaultPageInfoFieldsModel = (DefaultPageInfoFieldsModel) graphQLModelMutatingVisitor.b(m17262j());
                    if (m17262j() != defaultPageInfoFieldsModel) {
                        graphQLVisitableModel = (PhotoResultModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f17369e = defaultPageInfoFieldsModel;
                    }
                }
                i();
                if (graphQLVisitableModel != null) {
                }
            }

            public final int m17259a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m17261a());
                int a2 = ModelHelper.a(flatBufferBuilder, m17262j());
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, a2);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: config_type */
        public class Serializer extends JsonSerializer<SubsequentSharedPhotosModel> {
            public final void m17263a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                SubsequentSharedPhotosModel subsequentSharedPhotosModel = (SubsequentSharedPhotosModel) obj;
                if (subsequentSharedPhotosModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(subsequentSharedPhotosModel.m17264a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    subsequentSharedPhotosModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = subsequentSharedPhotosModel.w_();
                int u_ = subsequentSharedPhotosModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("imageCount");
                    ImageCountParser.m17283a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(u_, 1);
                if (g != 0) {
                    jsonGenerator.a("photoResult");
                    PhotoResultParser.m17285a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(SubsequentSharedPhotosModel.class, new Serializer());
            }
        }

        public SubsequentSharedPhotosModel() {
            super(2);
        }

        @Nullable
        public final ImageCountModel m17266a() {
            this.f17370d = (ImageCountModel) super.a(this.f17370d, 0, ImageCountModel.class);
            return this.f17370d;
        }

        @Nullable
        public final PhotoResultModel m17267j() {
            this.f17371e = (PhotoResultModel) super.a(this.f17371e, 1, PhotoResultModel.class);
            return this.f17371e;
        }

        public final int jK_() {
            return -740570927;
        }

        public final GraphQLVisitableModel m17265a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m17266a() != null) {
                ImageCountModel imageCountModel = (ImageCountModel) graphQLModelMutatingVisitor.b(m17266a());
                if (m17266a() != imageCountModel) {
                    graphQLVisitableModel = (SubsequentSharedPhotosModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f17370d = imageCountModel;
                }
            }
            if (m17267j() != null) {
                PhotoResultModel photoResultModel = (PhotoResultModel) graphQLModelMutatingVisitor.b(m17267j());
                if (m17267j() != photoResultModel) {
                    graphQLVisitableModel = (SubsequentSharedPhotosModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f17371e = photoResultModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m17264a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m17266a());
            int a2 = ModelHelper.a(flatBufferBuilder, m17267j());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            i();
            return flatBufferBuilder.d();
        }
    }
}
