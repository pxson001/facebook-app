package com.facebook.stickers.graphql;

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
import com.facebook.stickers.graphql.FetchStickersGraphQLParsers.FetchAvailableTaggedStickersQueryParser;
import com.facebook.stickers.graphql.FetchStickersGraphQLParsers.FetchAvailableTaggedStickersQueryParser.TaggedStickersParser;
import com.facebook.stickers.graphql.FetchStickersGraphQLParsers.FetchAvailableTaggedStickersWithPreviewsQueryParser;
import com.facebook.stickers.graphql.FetchStickersGraphQLParsers.FetchAvailableTaggedStickersWithPreviewsQueryParser.TaggedStickersParser.NodesParser;
import com.facebook.stickers.graphql.FetchStickersGraphQLParsers.FetchDownloadedStickerPackIdsQueryParser;
import com.facebook.stickers.graphql.FetchStickersGraphQLParsers.FetchDownloadedStickerPackIdsQueryParser.StickerStoreParser;
import com.facebook.stickers.graphql.FetchStickersGraphQLParsers.FetchDownloadedStickerPackIdsQueryParser.StickerStoreParser.TrayPacksParser;
import com.facebook.stickers.graphql.FetchStickersGraphQLParsers.FetchDownloadedStickerPacksQueryParser;
import com.facebook.stickers.graphql.FetchStickersGraphQLParsers.FetchDownloadedStickerPacksQueryParser.StickerStoreParser.TrayPacksParser.PageInfoParser;
import com.facebook.stickers.graphql.FetchStickersGraphQLParsers.FetchOwnedStickerPackIdsQueryParser;
import com.facebook.stickers.graphql.FetchStickersGraphQLParsers.FetchOwnedStickerPackIdsQueryParser.StickerStoreParser.OwnedPacksParser;
import com.facebook.stickers.graphql.FetchStickersGraphQLParsers.FetchOwnedStickerPacksQueryParser;
import com.facebook.stickers.graphql.FetchStickersGraphQLParsers.FetchStickerTagsQueryParser;
import com.facebook.stickers.graphql.FetchStickersGraphQLParsers.FetchStickerTagsQueryParser.StickerStoreParser.StickerTagsParser;
import com.facebook.stickers.graphql.FetchStickersGraphQLParsers.FetchStickerTagsQueryParser.StickerStoreParser.StickerTagsParser.NodesParser.ThumbnailImageParser;
import com.facebook.stickers.graphql.FetchStickersGraphQLParsers.FetchStickersWithPreviewsQueryParser;
import com.facebook.stickers.graphql.FetchStickersGraphQLParsers.FetchStoreStickerPackIdsQueryParser;
import com.facebook.stickers.graphql.FetchStickersGraphQLParsers.FetchStoreStickerPackIdsQueryParser.StickerStoreParser.AvailablePacksParser;
import com.facebook.stickers.graphql.FetchStickersGraphQLParsers.FetchStoreStickerPacksQueryParser;
import com.facebook.stickers.graphql.FetchStickersGraphQLParsers.FetchTaggedStickersQueryParser;
import com.facebook.stickers.graphql.FetchStickersGraphQLParsers.FetchTaggedStickersWithPreviewsQueryParser;
import com.facebook.stickers.graphql.FetchStickersGraphQLParsers.FetchTrayTaggedStickersQueryParser;
import com.facebook.stickers.graphql.FetchStickersGraphQLParsers.FetchTrayTaggedStickersWithPreviewsQueryParser;
import com.facebook.stickers.graphql.FetchStickersGraphQLParsers.PreviewFieldsParser;
import com.facebook.stickers.graphql.FetchStickersGraphQLParsers.PreviewFieldsParser.PreviewImageParser;
import com.facebook.stickers.graphql.FetchStickersGraphQLParsers.SearchTaggedStickersQueryParser;
import com.facebook.stickers.graphql.FetchStickersGraphQLParsers.SearchTaggedStickersQueryParser.StickerResultsParser;
import com.facebook.stickers.graphql.FetchStickersGraphQLParsers.SearchTaggedStickersWithPreviewsQueryParser;
import com.facebook.stickers.graphql.FetchStickersGraphQLParsers.StickerFieldsParser;
import com.facebook.stickers.graphql.FetchStickersGraphQLParsers.StickerFieldsParser.AnimatedImageParser;
import com.facebook.stickers.graphql.FetchStickersGraphQLParsers.StickerFieldsParser.PackParser;
import com.facebook.stickers.graphql.FetchStickersGraphQLParsers.StickerFieldsParser.ThreadImageParser;
import com.facebook.stickers.graphql.FetchStickersGraphQLParsers.StickerPackFieldsParser;
import com.facebook.stickers.graphql.FetchStickersGraphQLParsers.StickerPackFieldsParser.StickersParser;
import com.facebook.stickers.graphql.FetchStickersGraphQLParsers.StickerPackFieldsParser.TrayButtonParser;
import com.facebook.stickers.graphql.FetchStickersGraphQLParsers.StickerPackFieldsParser.TrayButtonParser.NormalParser;
import com.facebook.stickers.graphql.FetchStickersGraphQLParsers.StickerPackIdFieldsParser;
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

/* compiled from: eec361561d51e5375e5cdb0a1a0c05da */
public class FetchStickersGraphQLModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 453802904)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: eec361561d51e5375e5cdb0a1a0c05da */
    public final class FetchAvailableTaggedStickersQueryModel extends BaseModel implements GraphQLVisitableConsistentModel {
        @Nullable
        private GraphQLObjectType f16495d;
        @Nullable
        private TaggedStickersModel f16496e;

        /* compiled from: eec361561d51e5375e5cdb0a1a0c05da */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FetchAvailableTaggedStickersQueryModel.class, new Deserializer());
            }

            public Object m23976a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = FetchAvailableTaggedStickersQueryParser.m24359a(jsonParser);
                Object fetchAvailableTaggedStickersQueryModel = new FetchAvailableTaggedStickersQueryModel();
                ((BaseModel) fetchAvailableTaggedStickersQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (fetchAvailableTaggedStickersQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) fetchAvailableTaggedStickersQueryModel).a();
                }
                return fetchAvailableTaggedStickersQueryModel;
            }
        }

        /* compiled from: eec361561d51e5375e5cdb0a1a0c05da */
        public class Serializer extends JsonSerializer<FetchAvailableTaggedStickersQueryModel> {
            public final void m23977a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                FetchAvailableTaggedStickersQueryModel fetchAvailableTaggedStickersQueryModel = (FetchAvailableTaggedStickersQueryModel) obj;
                if (fetchAvailableTaggedStickersQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(fetchAvailableTaggedStickersQueryModel.m23985a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    fetchAvailableTaggedStickersQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = fetchAvailableTaggedStickersQueryModel.w_();
                int u_ = fetchAvailableTaggedStickersQueryModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("__type__");
                    SerializerHelpers.b(mutableFlatBuffer, u_, 0, jsonGenerator);
                }
                int g = mutableFlatBuffer.g(u_, 1);
                if (g != 0) {
                    jsonGenerator.a("tagged_stickers");
                    TaggedStickersParser.m24358a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(FetchAvailableTaggedStickersQueryModel.class, new Serializer());
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -48884331)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: eec361561d51e5375e5cdb0a1a0c05da */
        public final class TaggedStickersModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<StickerFieldsModel> f16494d;

            /* compiled from: eec361561d51e5375e5cdb0a1a0c05da */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(TaggedStickersModel.class, new Deserializer());
                }

                public Object m23978a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(TaggedStickersParser.m24357a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object taggedStickersModel = new TaggedStickersModel();
                    ((BaseModel) taggedStickersModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (taggedStickersModel instanceof Postprocessable) {
                        return ((Postprocessable) taggedStickersModel).a();
                    }
                    return taggedStickersModel;
                }
            }

            /* compiled from: eec361561d51e5375e5cdb0a1a0c05da */
            public class Serializer extends JsonSerializer<TaggedStickersModel> {
                public final void m23979a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    TaggedStickersModel taggedStickersModel = (TaggedStickersModel) obj;
                    if (taggedStickersModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(taggedStickersModel.m23981a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        taggedStickersModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    TaggedStickersParser.m24358a(taggedStickersModel.w_(), taggedStickersModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(TaggedStickersModel.class, new Serializer());
                }
            }

            public TaggedStickersModel() {
                super(1);
            }

            @Nonnull
            private ImmutableList<StickerFieldsModel> m23980a() {
                this.f16494d = super.a(this.f16494d, 0, StickerFieldsModel.class);
                return (ImmutableList) this.f16494d;
            }

            public final int jK_() {
                return -795239780;
            }

            public final GraphQLVisitableModel m23982a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m23980a() != null) {
                    Builder a = ModelHelper.a(m23980a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (TaggedStickersModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f16494d = a.b();
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m23981a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m23980a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        public FetchAvailableTaggedStickersQueryModel() {
            super(2);
        }

        public final void m23987a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m23988a(String str, Object obj, boolean z) {
        }

        @Nullable
        private GraphQLObjectType m23983a() {
            if (this.b != null && this.f16495d == null) {
                this.f16495d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
            }
            return this.f16495d;
        }

        @Nullable
        private TaggedStickersModel m23984j() {
            this.f16496e = (TaggedStickersModel) super.a(this.f16496e, 1, TaggedStickersModel.class);
            return this.f16496e;
        }

        public final int jK_() {
            return 2433570;
        }

        public final GraphQLVisitableModel m23986a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m23984j() != null) {
                TaggedStickersModel taggedStickersModel = (TaggedStickersModel) graphQLModelMutatingVisitor.b(m23984j());
                if (m23984j() != taggedStickersModel) {
                    graphQLVisitableModel = (FetchAvailableTaggedStickersQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f16496e = taggedStickersModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m23985a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m23983a());
            int a2 = ModelHelper.a(flatBufferBuilder, m23984j());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1362900798)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: eec361561d51e5375e5cdb0a1a0c05da */
    public final class FetchAvailableTaggedStickersWithPreviewsQueryModel extends BaseModel implements GraphQLVisitableConsistentModel {
        @Nullable
        private GraphQLObjectType f16503d;
        @Nullable
        private TaggedStickersModel f16504e;

        /* compiled from: eec361561d51e5375e5cdb0a1a0c05da */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FetchAvailableTaggedStickersWithPreviewsQueryModel.class, new Deserializer());
            }

            public Object m23989a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = FetchAvailableTaggedStickersWithPreviewsQueryParser.m24364a(jsonParser);
                Object fetchAvailableTaggedStickersWithPreviewsQueryModel = new FetchAvailableTaggedStickersWithPreviewsQueryModel();
                ((BaseModel) fetchAvailableTaggedStickersWithPreviewsQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (fetchAvailableTaggedStickersWithPreviewsQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) fetchAvailableTaggedStickersWithPreviewsQueryModel).a();
                }
                return fetchAvailableTaggedStickersWithPreviewsQueryModel;
            }
        }

        /* compiled from: eec361561d51e5375e5cdb0a1a0c05da */
        public class Serializer extends JsonSerializer<FetchAvailableTaggedStickersWithPreviewsQueryModel> {
            public final void m23990a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                FetchAvailableTaggedStickersWithPreviewsQueryModel fetchAvailableTaggedStickersWithPreviewsQueryModel = (FetchAvailableTaggedStickersWithPreviewsQueryModel) obj;
                if (fetchAvailableTaggedStickersWithPreviewsQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(fetchAvailableTaggedStickersWithPreviewsQueryModel.m24008a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    fetchAvailableTaggedStickersWithPreviewsQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = fetchAvailableTaggedStickersWithPreviewsQueryModel.w_();
                int u_ = fetchAvailableTaggedStickersWithPreviewsQueryModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("__type__");
                    SerializerHelpers.b(mutableFlatBuffer, u_, 0, jsonGenerator);
                }
                int g = mutableFlatBuffer.g(u_, 1);
                if (g != 0) {
                    jsonGenerator.a("tagged_stickers");
                    FetchAvailableTaggedStickersWithPreviewsQueryParser.TaggedStickersParser.m24363a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(FetchAvailableTaggedStickersWithPreviewsQueryModel.class, new Serializer());
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 2080116559)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: eec361561d51e5375e5cdb0a1a0c05da */
        public final class TaggedStickersModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<NodesModel> f16502d;

            /* compiled from: eec361561d51e5375e5cdb0a1a0c05da */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(TaggedStickersModel.class, new Deserializer());
                }

                public Object m23991a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(FetchAvailableTaggedStickersWithPreviewsQueryParser.TaggedStickersParser.m24362a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object taggedStickersModel = new TaggedStickersModel();
                    ((BaseModel) taggedStickersModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (taggedStickersModel instanceof Postprocessable) {
                        return ((Postprocessable) taggedStickersModel).a();
                    }
                    return taggedStickersModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 75791716)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: eec361561d51e5375e5cdb0a1a0c05da */
            public final class NodesModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
                @Nullable
                private AnimatedImageModel f16497d;
                @Nullable
                private String f16498e;
                @Nullable
                private PackModel f16499f;
                @Nullable
                private PreviewImageModel f16500g;
                @Nullable
                private ThreadImageModel f16501h;

                /* compiled from: eec361561d51e5375e5cdb0a1a0c05da */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(NodesModel.class, new Deserializer());
                    }

                    public Object m23992a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(NodesParser.m24360b(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object nodesModel = new NodesModel();
                        ((BaseModel) nodesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (nodesModel instanceof Postprocessable) {
                            return ((Postprocessable) nodesModel).a();
                        }
                        return nodesModel;
                    }
                }

                /* compiled from: eec361561d51e5375e5cdb0a1a0c05da */
                public class Serializer extends JsonSerializer<NodesModel> {
                    public final void m23993a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        NodesModel nodesModel = (NodesModel) obj;
                        if (nodesModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(nodesModel.m23999a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            nodesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        NodesParser.m24361b(nodesModel.w_(), nodesModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(NodesModel.class, new Serializer());
                    }
                }

                public NodesModel() {
                    super(5);
                }

                @Nullable
                private AnimatedImageModel m23994j() {
                    this.f16497d = (AnimatedImageModel) super.a(this.f16497d, 0, AnimatedImageModel.class);
                    return this.f16497d;
                }

                @Nullable
                private String m23995k() {
                    this.f16498e = super.a(this.f16498e, 1);
                    return this.f16498e;
                }

                @Nullable
                private PackModel m23996l() {
                    this.f16499f = (PackModel) super.a(this.f16499f, 2, PackModel.class);
                    return this.f16499f;
                }

                @Nullable
                private PreviewImageModel m23997m() {
                    this.f16500g = (PreviewImageModel) super.a(this.f16500g, 3, PreviewImageModel.class);
                    return this.f16500g;
                }

                @Nullable
                private ThreadImageModel m23998n() {
                    this.f16501h = (ThreadImageModel) super.a(this.f16501h, 4, ThreadImageModel.class);
                    return this.f16501h;
                }

                @Nullable
                public final String m24001a() {
                    return m23995k();
                }

                public final int jK_() {
                    return -225599203;
                }

                public final GraphQLVisitableModel m24000a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m23994j() != null) {
                        AnimatedImageModel animatedImageModel = (AnimatedImageModel) graphQLModelMutatingVisitor.b(m23994j());
                        if (m23994j() != animatedImageModel) {
                            graphQLVisitableModel = (NodesModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f16497d = animatedImageModel;
                        }
                    }
                    if (m23996l() != null) {
                        PackModel packModel = (PackModel) graphQLModelMutatingVisitor.b(m23996l());
                        if (m23996l() != packModel) {
                            graphQLVisitableModel = (NodesModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f16499f = packModel;
                        }
                    }
                    if (m23997m() != null) {
                        PreviewImageModel previewImageModel = (PreviewImageModel) graphQLModelMutatingVisitor.b(m23997m());
                        if (m23997m() != previewImageModel) {
                            graphQLVisitableModel = (NodesModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f16500g = previewImageModel;
                        }
                    }
                    if (m23998n() != null) {
                        ThreadImageModel threadImageModel = (ThreadImageModel) graphQLModelMutatingVisitor.b(m23998n());
                        if (m23998n() != threadImageModel) {
                            graphQLVisitableModel = (NodesModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f16501h = threadImageModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m23999a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m23994j());
                    int b = flatBufferBuilder.b(m23995k());
                    int a2 = ModelHelper.a(flatBufferBuilder, m23996l());
                    int a3 = ModelHelper.a(flatBufferBuilder, m23997m());
                    int a4 = ModelHelper.a(flatBufferBuilder, m23998n());
                    flatBufferBuilder.c(5);
                    flatBufferBuilder.b(0, a);
                    flatBufferBuilder.b(1, b);
                    flatBufferBuilder.b(2, a2);
                    flatBufferBuilder.b(3, a3);
                    flatBufferBuilder.b(4, a4);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: eec361561d51e5375e5cdb0a1a0c05da */
            public class Serializer extends JsonSerializer<TaggedStickersModel> {
                public final void m24002a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    TaggedStickersModel taggedStickersModel = (TaggedStickersModel) obj;
                    if (taggedStickersModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(taggedStickersModel.m24004a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        taggedStickersModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    FetchAvailableTaggedStickersWithPreviewsQueryParser.TaggedStickersParser.m24363a(taggedStickersModel.w_(), taggedStickersModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(TaggedStickersModel.class, new Serializer());
                }
            }

            public TaggedStickersModel() {
                super(1);
            }

            @Nonnull
            private ImmutableList<NodesModel> m24003a() {
                this.f16502d = super.a(this.f16502d, 0, NodesModel.class);
                return (ImmutableList) this.f16502d;
            }

            public final int jK_() {
                return -795239780;
            }

            public final GraphQLVisitableModel m24005a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m24003a() != null) {
                    Builder a = ModelHelper.a(m24003a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (TaggedStickersModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f16502d = a.b();
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m24004a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m24003a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        public FetchAvailableTaggedStickersWithPreviewsQueryModel() {
            super(2);
        }

        public final void m24010a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m24011a(String str, Object obj, boolean z) {
        }

        @Nullable
        private GraphQLObjectType m24006a() {
            if (this.b != null && this.f16503d == null) {
                this.f16503d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
            }
            return this.f16503d;
        }

        @Nullable
        private TaggedStickersModel m24007j() {
            this.f16504e = (TaggedStickersModel) super.a(this.f16504e, 1, TaggedStickersModel.class);
            return this.f16504e;
        }

        public final int jK_() {
            return 2433570;
        }

        public final GraphQLVisitableModel m24009a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m24007j() != null) {
                TaggedStickersModel taggedStickersModel = (TaggedStickersModel) graphQLModelMutatingVisitor.b(m24007j());
                if (m24007j() != taggedStickersModel) {
                    graphQLVisitableModel = (FetchAvailableTaggedStickersWithPreviewsQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f16504e = taggedStickersModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m24008a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m24006a());
            int a2 = ModelHelper.a(flatBufferBuilder, m24007j());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -905007720)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: eec361561d51e5375e5cdb0a1a0c05da */
    public final class FetchDownloadedStickerPackIdsQueryModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private StickerStoreModel f16507d;

        /* compiled from: eec361561d51e5375e5cdb0a1a0c05da */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FetchDownloadedStickerPackIdsQueryModel.class, new Deserializer());
            }

            public Object m24012a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = FetchDownloadedStickerPackIdsQueryParser.m24369a(jsonParser);
                Object fetchDownloadedStickerPackIdsQueryModel = new FetchDownloadedStickerPackIdsQueryModel();
                ((BaseModel) fetchDownloadedStickerPackIdsQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (fetchDownloadedStickerPackIdsQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) fetchDownloadedStickerPackIdsQueryModel).a();
                }
                return fetchDownloadedStickerPackIdsQueryModel;
            }
        }

        /* compiled from: eec361561d51e5375e5cdb0a1a0c05da */
        public class Serializer extends JsonSerializer<FetchDownloadedStickerPackIdsQueryModel> {
            public final void m24013a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                FetchDownloadedStickerPackIdsQueryModel fetchDownloadedStickerPackIdsQueryModel = (FetchDownloadedStickerPackIdsQueryModel) obj;
                if (fetchDownloadedStickerPackIdsQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(fetchDownloadedStickerPackIdsQueryModel.m24025a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    fetchDownloadedStickerPackIdsQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = fetchDownloadedStickerPackIdsQueryModel.w_();
                int u_ = fetchDownloadedStickerPackIdsQueryModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("sticker_store");
                    StickerStoreParser.m24368a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(FetchDownloadedStickerPackIdsQueryModel.class, new Serializer());
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 845722937)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: eec361561d51e5375e5cdb0a1a0c05da */
        public final class StickerStoreModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private TrayPacksModel f16506d;

            /* compiled from: eec361561d51e5375e5cdb0a1a0c05da */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(StickerStoreModel.class, new Deserializer());
                }

                public Object m24014a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(StickerStoreParser.m24367a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object stickerStoreModel = new StickerStoreModel();
                    ((BaseModel) stickerStoreModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (stickerStoreModel instanceof Postprocessable) {
                        return ((Postprocessable) stickerStoreModel).a();
                    }
                    return stickerStoreModel;
                }
            }

            /* compiled from: eec361561d51e5375e5cdb0a1a0c05da */
            public class Serializer extends JsonSerializer<StickerStoreModel> {
                public final void m24015a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    StickerStoreModel stickerStoreModel = (StickerStoreModel) obj;
                    if (stickerStoreModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(stickerStoreModel.m24022a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        stickerStoreModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    StickerStoreParser.m24368a(stickerStoreModel.w_(), stickerStoreModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(StickerStoreModel.class, new Serializer());
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 651446826)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: eec361561d51e5375e5cdb0a1a0c05da */
            public final class TrayPacksModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private List<StickerPackIdFieldsModel> f16505d;

                /* compiled from: eec361561d51e5375e5cdb0a1a0c05da */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(TrayPacksModel.class, new Deserializer());
                    }

                    public Object m24016a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(TrayPacksParser.m24365a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object trayPacksModel = new TrayPacksModel();
                        ((BaseModel) trayPacksModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (trayPacksModel instanceof Postprocessable) {
                            return ((Postprocessable) trayPacksModel).a();
                        }
                        return trayPacksModel;
                    }
                }

                /* compiled from: eec361561d51e5375e5cdb0a1a0c05da */
                public class Serializer extends JsonSerializer<TrayPacksModel> {
                    public final void m24017a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        TrayPacksModel trayPacksModel = (TrayPacksModel) obj;
                        if (trayPacksModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(trayPacksModel.m24019a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            trayPacksModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        TrayPacksParser.m24366a(trayPacksModel.w_(), trayPacksModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(TrayPacksModel.class, new Serializer());
                    }
                }

                public TrayPacksModel() {
                    super(1);
                }

                @Nonnull
                private ImmutableList<StickerPackIdFieldsModel> m24018a() {
                    this.f16505d = super.a(this.f16505d, 0, StickerPackIdFieldsModel.class);
                    return (ImmutableList) this.f16505d;
                }

                public final int jK_() {
                    return 2001238195;
                }

                public final GraphQLVisitableModel m24020a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m24018a() != null) {
                        Builder a = ModelHelper.a(m24018a(), graphQLModelMutatingVisitor);
                        if (a != null) {
                            graphQLVisitableModel = (TrayPacksModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f16505d = a.b();
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m24019a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m24018a());
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, a);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            public StickerStoreModel() {
                super(1);
            }

            @Nullable
            private TrayPacksModel m24021a() {
                this.f16506d = (TrayPacksModel) super.a(this.f16506d, 0, TrayPacksModel.class);
                return this.f16506d;
            }

            public final int jK_() {
                return -1877765692;
            }

            public final GraphQLVisitableModel m24023a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m24021a() != null) {
                    TrayPacksModel trayPacksModel = (TrayPacksModel) graphQLModelMutatingVisitor.b(m24021a());
                    if (m24021a() != trayPacksModel) {
                        graphQLVisitableModel = (StickerStoreModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f16506d = trayPacksModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m24022a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m24021a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        public FetchDownloadedStickerPackIdsQueryModel() {
            super(1);
        }

        @Nullable
        private StickerStoreModel m24024a() {
            this.f16507d = (StickerStoreModel) super.a(this.f16507d, 0, StickerStoreModel.class);
            return this.f16507d;
        }

        public final int jK_() {
            return -1732764110;
        }

        public final GraphQLVisitableModel m24026a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m24024a() != null) {
                StickerStoreModel stickerStoreModel = (StickerStoreModel) graphQLModelMutatingVisitor.b(m24024a());
                if (m24024a() != stickerStoreModel) {
                    graphQLVisitableModel = (FetchDownloadedStickerPackIdsQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f16507d = stickerStoreModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m24025a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m24024a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1769831110)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: eec361561d51e5375e5cdb0a1a0c05da */
    public final class FetchDownloadedStickerPacksQueryModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private StickerStoreModel f16513d;

        /* compiled from: eec361561d51e5375e5cdb0a1a0c05da */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FetchDownloadedStickerPacksQueryModel.class, new Deserializer());
            }

            public Object m24027a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = FetchDownloadedStickerPacksQueryParser.m24376a(jsonParser);
                Object fetchDownloadedStickerPacksQueryModel = new FetchDownloadedStickerPacksQueryModel();
                ((BaseModel) fetchDownloadedStickerPacksQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (fetchDownloadedStickerPacksQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) fetchDownloadedStickerPacksQueryModel).a();
                }
                return fetchDownloadedStickerPacksQueryModel;
            }
        }

        /* compiled from: eec361561d51e5375e5cdb0a1a0c05da */
        public class Serializer extends JsonSerializer<FetchDownloadedStickerPacksQueryModel> {
            public final void m24028a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                FetchDownloadedStickerPacksQueryModel fetchDownloadedStickerPacksQueryModel = (FetchDownloadedStickerPacksQueryModel) obj;
                if (fetchDownloadedStickerPacksQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(fetchDownloadedStickerPacksQueryModel.m24047a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    fetchDownloadedStickerPacksQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = fetchDownloadedStickerPacksQueryModel.w_();
                int u_ = fetchDownloadedStickerPacksQueryModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("sticker_store");
                    FetchDownloadedStickerPacksQueryParser.StickerStoreParser.m24375a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(FetchDownloadedStickerPacksQueryModel.class, new Serializer());
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 401941541)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: eec361561d51e5375e5cdb0a1a0c05da */
        public final class StickerStoreModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private TrayPacksModel f16512d;

            /* compiled from: eec361561d51e5375e5cdb0a1a0c05da */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(StickerStoreModel.class, new Deserializer());
                }

                public Object m24029a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(FetchDownloadedStickerPacksQueryParser.StickerStoreParser.m24374a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object stickerStoreModel = new StickerStoreModel();
                    ((BaseModel) stickerStoreModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (stickerStoreModel instanceof Postprocessable) {
                        return ((Postprocessable) stickerStoreModel).a();
                    }
                    return stickerStoreModel;
                }
            }

            /* compiled from: eec361561d51e5375e5cdb0a1a0c05da */
            public class Serializer extends JsonSerializer<StickerStoreModel> {
                public final void m24030a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    StickerStoreModel stickerStoreModel = (StickerStoreModel) obj;
                    if (stickerStoreModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(stickerStoreModel.m24044a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        stickerStoreModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    FetchDownloadedStickerPacksQueryParser.StickerStoreParser.m24375a(stickerStoreModel.w_(), stickerStoreModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(StickerStoreModel.class, new Serializer());
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 61787232)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: eec361561d51e5375e5cdb0a1a0c05da */
            public final class TrayPacksModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private List<StickerPackFieldsModel> f16510d;
                @Nullable
                private PageInfoModel f16511e;

                /* compiled from: eec361561d51e5375e5cdb0a1a0c05da */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(TrayPacksModel.class, new Deserializer());
                    }

                    public Object m24031a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(FetchDownloadedStickerPacksQueryParser.StickerStoreParser.TrayPacksParser.m24372a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object trayPacksModel = new TrayPacksModel();
                        ((BaseModel) trayPacksModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (trayPacksModel instanceof Postprocessable) {
                            return ((Postprocessable) trayPacksModel).a();
                        }
                        return trayPacksModel;
                    }
                }

                @JsonDeserialize(using = Deserializer.class)
                @ModelWithFlatBufferFormatHash(a = -2005169142)
                @JsonSerialize(using = Serializer.class)
                @FragmentModelWithoutBridge
                /* compiled from: eec361561d51e5375e5cdb0a1a0c05da */
                public final class PageInfoModel extends BaseModel implements GraphQLVisitableModel {
                    @Nullable
                    private String f16508d;
                    private boolean f16509e;

                    /* compiled from: eec361561d51e5375e5cdb0a1a0c05da */
                    public class Deserializer extends FbJsonDeserializer {
                        static {
                            GlobalAutoGenDeserializerCache.a(PageInfoModel.class, new Deserializer());
                        }

                        public Object m24032a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(PageInfoParser.m24370a(jsonParser, flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            mutableFlatBuffer.a(4, Boolean.valueOf(true));
                            MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                            Object pageInfoModel = new PageInfoModel();
                            ((BaseModel) pageInfoModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                            if (pageInfoModel instanceof Postprocessable) {
                                return ((Postprocessable) pageInfoModel).a();
                            }
                            return pageInfoModel;
                        }
                    }

                    /* compiled from: eec361561d51e5375e5cdb0a1a0c05da */
                    public class Serializer extends JsonSerializer<PageInfoModel> {
                        public final void m24033a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            PageInfoModel pageInfoModel = (PageInfoModel) obj;
                            if (pageInfoModel.w_() == null) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(pageInfoModel.m24035a(flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                pageInfoModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                            }
                            PageInfoParser.m24371a(pageInfoModel.w_(), pageInfoModel.u_(), jsonGenerator);
                        }

                        static {
                            FbSerializerProvider.a(PageInfoModel.class, new Serializer());
                        }
                    }

                    public PageInfoModel() {
                        super(2);
                    }

                    @Nullable
                    private String m24034a() {
                        this.f16508d = super.a(this.f16508d, 0);
                        return this.f16508d;
                    }

                    public final int jK_() {
                        return 923779069;
                    }

                    public final GraphQLVisitableModel m24036a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                        h();
                        i();
                        return this;
                    }

                    public final int m24035a(FlatBufferBuilder flatBufferBuilder) {
                        h();
                        int b = flatBufferBuilder.b(m24034a());
                        flatBufferBuilder.c(2);
                        flatBufferBuilder.b(0, b);
                        flatBufferBuilder.a(1, this.f16509e);
                        i();
                        return flatBufferBuilder.d();
                    }

                    public final void m24037a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                        super.a(mutableFlatBuffer, i, obj);
                        this.f16509e = mutableFlatBuffer.a(i, 1);
                    }
                }

                /* compiled from: eec361561d51e5375e5cdb0a1a0c05da */
                public class Serializer extends JsonSerializer<TrayPacksModel> {
                    public final void m24038a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        TrayPacksModel trayPacksModel = (TrayPacksModel) obj;
                        if (trayPacksModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(trayPacksModel.m24041a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            trayPacksModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        FetchDownloadedStickerPacksQueryParser.StickerStoreParser.TrayPacksParser.m24373a(trayPacksModel.w_(), trayPacksModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(TrayPacksModel.class, new Serializer());
                    }
                }

                public TrayPacksModel() {
                    super(2);
                }

                @Nonnull
                private ImmutableList<StickerPackFieldsModel> m24039a() {
                    this.f16510d = super.a(this.f16510d, 0, StickerPackFieldsModel.class);
                    return (ImmutableList) this.f16510d;
                }

                @Nullable
                private PageInfoModel m24040j() {
                    this.f16511e = (PageInfoModel) super.a(this.f16511e, 1, PageInfoModel.class);
                    return this.f16511e;
                }

                public final int jK_() {
                    return 2001238195;
                }

                public final GraphQLVisitableModel m24042a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel;
                    PageInfoModel pageInfoModel;
                    h();
                    if (m24039a() != null) {
                        Builder a = ModelHelper.a(m24039a(), graphQLModelMutatingVisitor);
                        if (a != null) {
                            TrayPacksModel trayPacksModel = (TrayPacksModel) ModelHelper.a(null, this);
                            trayPacksModel.f16510d = a.b();
                            graphQLVisitableModel = trayPacksModel;
                            if (m24040j() != null) {
                                pageInfoModel = (PageInfoModel) graphQLModelMutatingVisitor.b(m24040j());
                                if (m24040j() != pageInfoModel) {
                                    graphQLVisitableModel = (TrayPacksModel) ModelHelper.a(graphQLVisitableModel, this);
                                    graphQLVisitableModel.f16511e = pageInfoModel;
                                }
                            }
                            i();
                            return graphQLVisitableModel != null ? this : graphQLVisitableModel;
                        }
                    }
                    graphQLVisitableModel = null;
                    if (m24040j() != null) {
                        pageInfoModel = (PageInfoModel) graphQLModelMutatingVisitor.b(m24040j());
                        if (m24040j() != pageInfoModel) {
                            graphQLVisitableModel = (TrayPacksModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f16511e = pageInfoModel;
                        }
                    }
                    i();
                    if (graphQLVisitableModel != null) {
                    }
                }

                public final int m24041a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m24039a());
                    int a2 = ModelHelper.a(flatBufferBuilder, m24040j());
                    flatBufferBuilder.c(2);
                    flatBufferBuilder.b(0, a);
                    flatBufferBuilder.b(1, a2);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            public StickerStoreModel() {
                super(1);
            }

            @Nullable
            private TrayPacksModel m24043a() {
                this.f16512d = (TrayPacksModel) super.a(this.f16512d, 0, TrayPacksModel.class);
                return this.f16512d;
            }

            public final int jK_() {
                return -1877765692;
            }

            public final GraphQLVisitableModel m24045a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m24043a() != null) {
                    TrayPacksModel trayPacksModel = (TrayPacksModel) graphQLModelMutatingVisitor.b(m24043a());
                    if (m24043a() != trayPacksModel) {
                        graphQLVisitableModel = (StickerStoreModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f16512d = trayPacksModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m24044a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m24043a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        public FetchDownloadedStickerPacksQueryModel() {
            super(1);
        }

        @Nullable
        private StickerStoreModel m24046a() {
            this.f16513d = (StickerStoreModel) super.a(this.f16513d, 0, StickerStoreModel.class);
            return this.f16513d;
        }

        public final int jK_() {
            return -1732764110;
        }

        public final GraphQLVisitableModel m24048a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m24046a() != null) {
                StickerStoreModel stickerStoreModel = (StickerStoreModel) graphQLModelMutatingVisitor.b(m24046a());
                if (m24046a() != stickerStoreModel) {
                    graphQLVisitableModel = (FetchDownloadedStickerPacksQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f16513d = stickerStoreModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m24047a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m24046a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1554685777)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: eec361561d51e5375e5cdb0a1a0c05da */
    public final class FetchOwnedStickerPackIdsQueryModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private StickerStoreModel f16516d;

        /* compiled from: eec361561d51e5375e5cdb0a1a0c05da */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FetchOwnedStickerPackIdsQueryModel.class, new Deserializer());
            }

            public Object m24049a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = FetchOwnedStickerPackIdsQueryParser.m24381a(jsonParser);
                Object fetchOwnedStickerPackIdsQueryModel = new FetchOwnedStickerPackIdsQueryModel();
                ((BaseModel) fetchOwnedStickerPackIdsQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (fetchOwnedStickerPackIdsQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) fetchOwnedStickerPackIdsQueryModel).a();
                }
                return fetchOwnedStickerPackIdsQueryModel;
            }
        }

        /* compiled from: eec361561d51e5375e5cdb0a1a0c05da */
        public class Serializer extends JsonSerializer<FetchOwnedStickerPackIdsQueryModel> {
            public final void m24050a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                FetchOwnedStickerPackIdsQueryModel fetchOwnedStickerPackIdsQueryModel = (FetchOwnedStickerPackIdsQueryModel) obj;
                if (fetchOwnedStickerPackIdsQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(fetchOwnedStickerPackIdsQueryModel.m24062a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    fetchOwnedStickerPackIdsQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = fetchOwnedStickerPackIdsQueryModel.w_();
                int u_ = fetchOwnedStickerPackIdsQueryModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("sticker_store");
                    FetchOwnedStickerPackIdsQueryParser.StickerStoreParser.m24380a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(FetchOwnedStickerPackIdsQueryModel.class, new Serializer());
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1736277268)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: eec361561d51e5375e5cdb0a1a0c05da */
        public final class StickerStoreModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private OwnedPacksModel f16515d;

            /* compiled from: eec361561d51e5375e5cdb0a1a0c05da */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(StickerStoreModel.class, new Deserializer());
                }

                public Object m24051a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(FetchOwnedStickerPackIdsQueryParser.StickerStoreParser.m24379a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object stickerStoreModel = new StickerStoreModel();
                    ((BaseModel) stickerStoreModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (stickerStoreModel instanceof Postprocessable) {
                        return ((Postprocessable) stickerStoreModel).a();
                    }
                    return stickerStoreModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 651446826)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: eec361561d51e5375e5cdb0a1a0c05da */
            public final class OwnedPacksModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private List<StickerPackIdFieldsModel> f16514d;

                /* compiled from: eec361561d51e5375e5cdb0a1a0c05da */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(OwnedPacksModel.class, new Deserializer());
                    }

                    public Object m24052a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(OwnedPacksParser.m24377a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object ownedPacksModel = new OwnedPacksModel();
                        ((BaseModel) ownedPacksModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (ownedPacksModel instanceof Postprocessable) {
                            return ((Postprocessable) ownedPacksModel).a();
                        }
                        return ownedPacksModel;
                    }
                }

                /* compiled from: eec361561d51e5375e5cdb0a1a0c05da */
                public class Serializer extends JsonSerializer<OwnedPacksModel> {
                    public final void m24053a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        OwnedPacksModel ownedPacksModel = (OwnedPacksModel) obj;
                        if (ownedPacksModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(ownedPacksModel.m24055a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            ownedPacksModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        OwnedPacksParser.m24378a(ownedPacksModel.w_(), ownedPacksModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(OwnedPacksModel.class, new Serializer());
                    }
                }

                public OwnedPacksModel() {
                    super(1);
                }

                @Nonnull
                private ImmutableList<StickerPackIdFieldsModel> m24054a() {
                    this.f16514d = super.a(this.f16514d, 0, StickerPackIdFieldsModel.class);
                    return (ImmutableList) this.f16514d;
                }

                public final int jK_() {
                    return 1434674656;
                }

                public final GraphQLVisitableModel m24056a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m24054a() != null) {
                        Builder a = ModelHelper.a(m24054a(), graphQLModelMutatingVisitor);
                        if (a != null) {
                            graphQLVisitableModel = (OwnedPacksModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f16514d = a.b();
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m24055a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m24054a());
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, a);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: eec361561d51e5375e5cdb0a1a0c05da */
            public class Serializer extends JsonSerializer<StickerStoreModel> {
                public final void m24057a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    StickerStoreModel stickerStoreModel = (StickerStoreModel) obj;
                    if (stickerStoreModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(stickerStoreModel.m24059a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        stickerStoreModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    FetchOwnedStickerPackIdsQueryParser.StickerStoreParser.m24380a(stickerStoreModel.w_(), stickerStoreModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(StickerStoreModel.class, new Serializer());
                }
            }

            public StickerStoreModel() {
                super(1);
            }

            @Nullable
            private OwnedPacksModel m24058a() {
                this.f16515d = (OwnedPacksModel) super.a(this.f16515d, 0, OwnedPacksModel.class);
                return this.f16515d;
            }

            public final int jK_() {
                return -1877765692;
            }

            public final GraphQLVisitableModel m24060a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m24058a() != null) {
                    OwnedPacksModel ownedPacksModel = (OwnedPacksModel) graphQLModelMutatingVisitor.b(m24058a());
                    if (m24058a() != ownedPacksModel) {
                        graphQLVisitableModel = (StickerStoreModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f16515d = ownedPacksModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m24059a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m24058a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        public FetchOwnedStickerPackIdsQueryModel() {
            super(1);
        }

        @Nullable
        private StickerStoreModel m24061a() {
            this.f16516d = (StickerStoreModel) super.a(this.f16516d, 0, StickerStoreModel.class);
            return this.f16516d;
        }

        public final int jK_() {
            return -1732764110;
        }

        public final GraphQLVisitableModel m24063a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m24061a() != null) {
                StickerStoreModel stickerStoreModel = (StickerStoreModel) graphQLModelMutatingVisitor.b(m24061a());
                if (m24061a() != stickerStoreModel) {
                    graphQLVisitableModel = (FetchOwnedStickerPackIdsQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f16516d = stickerStoreModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m24062a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m24061a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -932933836)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: eec361561d51e5375e5cdb0a1a0c05da */
    public final class FetchOwnedStickerPacksQueryModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private StickerStoreModel f16522d;

        /* compiled from: eec361561d51e5375e5cdb0a1a0c05da */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FetchOwnedStickerPacksQueryModel.class, new Deserializer());
            }

            public Object m24064a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = FetchOwnedStickerPacksQueryParser.m24388a(jsonParser);
                Object fetchOwnedStickerPacksQueryModel = new FetchOwnedStickerPacksQueryModel();
                ((BaseModel) fetchOwnedStickerPacksQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (fetchOwnedStickerPacksQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) fetchOwnedStickerPacksQueryModel).a();
                }
                return fetchOwnedStickerPacksQueryModel;
            }
        }

        /* compiled from: eec361561d51e5375e5cdb0a1a0c05da */
        public class Serializer extends JsonSerializer<FetchOwnedStickerPacksQueryModel> {
            public final void m24065a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                FetchOwnedStickerPacksQueryModel fetchOwnedStickerPacksQueryModel = (FetchOwnedStickerPacksQueryModel) obj;
                if (fetchOwnedStickerPacksQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(fetchOwnedStickerPacksQueryModel.m24084a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    fetchOwnedStickerPacksQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = fetchOwnedStickerPacksQueryModel.w_();
                int u_ = fetchOwnedStickerPacksQueryModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("sticker_store");
                    FetchOwnedStickerPacksQueryParser.StickerStoreParser.m24387a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(FetchOwnedStickerPacksQueryModel.class, new Serializer());
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 859248975)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: eec361561d51e5375e5cdb0a1a0c05da */
        public final class StickerStoreModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private OwnedPacksModel f16521d;

            /* compiled from: eec361561d51e5375e5cdb0a1a0c05da */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(StickerStoreModel.class, new Deserializer());
                }

                public Object m24066a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(FetchOwnedStickerPacksQueryParser.StickerStoreParser.m24386a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object stickerStoreModel = new StickerStoreModel();
                    ((BaseModel) stickerStoreModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (stickerStoreModel instanceof Postprocessable) {
                        return ((Postprocessable) stickerStoreModel).a();
                    }
                    return stickerStoreModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 1713111849)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: eec361561d51e5375e5cdb0a1a0c05da */
            public final class OwnedPacksModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private List<StickerPackFieldsModel> f16519d;
                @Nullable
                private PageInfoModel f16520e;

                /* compiled from: eec361561d51e5375e5cdb0a1a0c05da */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(OwnedPacksModel.class, new Deserializer());
                    }

                    public Object m24067a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(FetchOwnedStickerPacksQueryParser.StickerStoreParser.OwnedPacksParser.m24384a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object ownedPacksModel = new OwnedPacksModel();
                        ((BaseModel) ownedPacksModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (ownedPacksModel instanceof Postprocessable) {
                            return ((Postprocessable) ownedPacksModel).a();
                        }
                        return ownedPacksModel;
                    }
                }

                @JsonDeserialize(using = Deserializer.class)
                @ModelWithFlatBufferFormatHash(a = -2005169142)
                @JsonSerialize(using = Serializer.class)
                @FragmentModelWithoutBridge
                /* compiled from: eec361561d51e5375e5cdb0a1a0c05da */
                public final class PageInfoModel extends BaseModel implements GraphQLVisitableModel {
                    @Nullable
                    private String f16517d;
                    private boolean f16518e;

                    /* compiled from: eec361561d51e5375e5cdb0a1a0c05da */
                    public class Deserializer extends FbJsonDeserializer {
                        static {
                            GlobalAutoGenDeserializerCache.a(PageInfoModel.class, new Deserializer());
                        }

                        public Object m24068a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(FetchOwnedStickerPacksQueryParser.StickerStoreParser.OwnedPacksParser.PageInfoParser.m24382a(jsonParser, flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            mutableFlatBuffer.a(4, Boolean.valueOf(true));
                            MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                            Object pageInfoModel = new PageInfoModel();
                            ((BaseModel) pageInfoModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                            if (pageInfoModel instanceof Postprocessable) {
                                return ((Postprocessable) pageInfoModel).a();
                            }
                            return pageInfoModel;
                        }
                    }

                    /* compiled from: eec361561d51e5375e5cdb0a1a0c05da */
                    public class Serializer extends JsonSerializer<PageInfoModel> {
                        public final void m24069a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            PageInfoModel pageInfoModel = (PageInfoModel) obj;
                            if (pageInfoModel.w_() == null) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(pageInfoModel.m24071a(flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                pageInfoModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                            }
                            FetchOwnedStickerPacksQueryParser.StickerStoreParser.OwnedPacksParser.PageInfoParser.m24383a(pageInfoModel.w_(), pageInfoModel.u_(), jsonGenerator);
                        }

                        static {
                            FbSerializerProvider.a(PageInfoModel.class, new Serializer());
                        }
                    }

                    public PageInfoModel() {
                        super(2);
                    }

                    @Nullable
                    private String m24070a() {
                        this.f16517d = super.a(this.f16517d, 0);
                        return this.f16517d;
                    }

                    public final int jK_() {
                        return 923779069;
                    }

                    public final GraphQLVisitableModel m24072a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                        h();
                        i();
                        return this;
                    }

                    public final int m24071a(FlatBufferBuilder flatBufferBuilder) {
                        h();
                        int b = flatBufferBuilder.b(m24070a());
                        flatBufferBuilder.c(2);
                        flatBufferBuilder.b(0, b);
                        flatBufferBuilder.a(1, this.f16518e);
                        i();
                        return flatBufferBuilder.d();
                    }

                    public final void m24073a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                        super.a(mutableFlatBuffer, i, obj);
                        this.f16518e = mutableFlatBuffer.a(i, 1);
                    }
                }

                /* compiled from: eec361561d51e5375e5cdb0a1a0c05da */
                public class Serializer extends JsonSerializer<OwnedPacksModel> {
                    public final void m24074a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        OwnedPacksModel ownedPacksModel = (OwnedPacksModel) obj;
                        if (ownedPacksModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(ownedPacksModel.m24077a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            ownedPacksModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        FetchOwnedStickerPacksQueryParser.StickerStoreParser.OwnedPacksParser.m24385a(ownedPacksModel.w_(), ownedPacksModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(OwnedPacksModel.class, new Serializer());
                    }
                }

                public OwnedPacksModel() {
                    super(2);
                }

                @Nonnull
                private ImmutableList<StickerPackFieldsModel> m24075a() {
                    this.f16519d = super.a(this.f16519d, 0, StickerPackFieldsModel.class);
                    return (ImmutableList) this.f16519d;
                }

                @Nullable
                private PageInfoModel m24076j() {
                    this.f16520e = (PageInfoModel) super.a(this.f16520e, 1, PageInfoModel.class);
                    return this.f16520e;
                }

                public final int jK_() {
                    return 1434674656;
                }

                public final GraphQLVisitableModel m24078a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel;
                    PageInfoModel pageInfoModel;
                    h();
                    if (m24075a() != null) {
                        Builder a = ModelHelper.a(m24075a(), graphQLModelMutatingVisitor);
                        if (a != null) {
                            OwnedPacksModel ownedPacksModel = (OwnedPacksModel) ModelHelper.a(null, this);
                            ownedPacksModel.f16519d = a.b();
                            graphQLVisitableModel = ownedPacksModel;
                            if (m24076j() != null) {
                                pageInfoModel = (PageInfoModel) graphQLModelMutatingVisitor.b(m24076j());
                                if (m24076j() != pageInfoModel) {
                                    graphQLVisitableModel = (OwnedPacksModel) ModelHelper.a(graphQLVisitableModel, this);
                                    graphQLVisitableModel.f16520e = pageInfoModel;
                                }
                            }
                            i();
                            return graphQLVisitableModel != null ? this : graphQLVisitableModel;
                        }
                    }
                    graphQLVisitableModel = null;
                    if (m24076j() != null) {
                        pageInfoModel = (PageInfoModel) graphQLModelMutatingVisitor.b(m24076j());
                        if (m24076j() != pageInfoModel) {
                            graphQLVisitableModel = (OwnedPacksModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f16520e = pageInfoModel;
                        }
                    }
                    i();
                    if (graphQLVisitableModel != null) {
                    }
                }

                public final int m24077a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m24075a());
                    int a2 = ModelHelper.a(flatBufferBuilder, m24076j());
                    flatBufferBuilder.c(2);
                    flatBufferBuilder.b(0, a);
                    flatBufferBuilder.b(1, a2);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: eec361561d51e5375e5cdb0a1a0c05da */
            public class Serializer extends JsonSerializer<StickerStoreModel> {
                public final void m24079a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    StickerStoreModel stickerStoreModel = (StickerStoreModel) obj;
                    if (stickerStoreModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(stickerStoreModel.m24081a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        stickerStoreModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    FetchOwnedStickerPacksQueryParser.StickerStoreParser.m24387a(stickerStoreModel.w_(), stickerStoreModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(StickerStoreModel.class, new Serializer());
                }
            }

            public StickerStoreModel() {
                super(1);
            }

            @Nullable
            private OwnedPacksModel m24080a() {
                this.f16521d = (OwnedPacksModel) super.a(this.f16521d, 0, OwnedPacksModel.class);
                return this.f16521d;
            }

            public final int jK_() {
                return -1877765692;
            }

            public final GraphQLVisitableModel m24082a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m24080a() != null) {
                    OwnedPacksModel ownedPacksModel = (OwnedPacksModel) graphQLModelMutatingVisitor.b(m24080a());
                    if (m24080a() != ownedPacksModel) {
                        graphQLVisitableModel = (StickerStoreModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f16521d = ownedPacksModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m24081a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m24080a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        public FetchOwnedStickerPacksQueryModel() {
            super(1);
        }

        @Nullable
        private StickerStoreModel m24083a() {
            this.f16522d = (StickerStoreModel) super.a(this.f16522d, 0, StickerStoreModel.class);
            return this.f16522d;
        }

        public final int jK_() {
            return -1732764110;
        }

        public final GraphQLVisitableModel m24085a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m24083a() != null) {
                StickerStoreModel stickerStoreModel = (StickerStoreModel) graphQLModelMutatingVisitor.b(m24083a());
                if (m24083a() != stickerStoreModel) {
                    graphQLVisitableModel = (FetchOwnedStickerPacksQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f16522d = stickerStoreModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m24084a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m24083a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -915141732)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: eec361561d51e5375e5cdb0a1a0c05da */
    public final class FetchStickerTagsQueryModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private StickerStoreModel f16532d;

        /* compiled from: eec361561d51e5375e5cdb0a1a0c05da */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FetchStickerTagsQueryModel.class, new Deserializer());
            }

            public Object m24086a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = FetchStickerTagsQueryParser.m24397a(jsonParser);
                Object fetchStickerTagsQueryModel = new FetchStickerTagsQueryModel();
                ((BaseModel) fetchStickerTagsQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (fetchStickerTagsQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) fetchStickerTagsQueryModel).a();
                }
                return fetchStickerTagsQueryModel;
            }
        }

        /* compiled from: eec361561d51e5375e5cdb0a1a0c05da */
        public class Serializer extends JsonSerializer<FetchStickerTagsQueryModel> {
            public final void m24087a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                FetchStickerTagsQueryModel fetchStickerTagsQueryModel = (FetchStickerTagsQueryModel) obj;
                if (fetchStickerTagsQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(fetchStickerTagsQueryModel.m24114a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    fetchStickerTagsQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = fetchStickerTagsQueryModel.w_();
                int u_ = fetchStickerTagsQueryModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("sticker_store");
                    FetchStickerTagsQueryParser.StickerStoreParser.m24396a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(FetchStickerTagsQueryModel.class, new Serializer());
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 444552155)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: eec361561d51e5375e5cdb0a1a0c05da */
        public final class StickerStoreModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private StickerTagsModel f16531d;

            /* compiled from: eec361561d51e5375e5cdb0a1a0c05da */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(StickerStoreModel.class, new Deserializer());
                }

                public Object m24088a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(FetchStickerTagsQueryParser.StickerStoreParser.m24395a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object stickerStoreModel = new StickerStoreModel();
                    ((BaseModel) stickerStoreModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (stickerStoreModel instanceof Postprocessable) {
                        return ((Postprocessable) stickerStoreModel).a();
                    }
                    return stickerStoreModel;
                }
            }

            /* compiled from: eec361561d51e5375e5cdb0a1a0c05da */
            public class Serializer extends JsonSerializer<StickerStoreModel> {
                public final void m24089a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    StickerStoreModel stickerStoreModel = (StickerStoreModel) obj;
                    if (stickerStoreModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(stickerStoreModel.m24111a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        stickerStoreModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    FetchStickerTagsQueryParser.StickerStoreParser.m24396a(stickerStoreModel.w_(), stickerStoreModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(StickerStoreModel.class, new Serializer());
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 2044641663)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: eec361561d51e5375e5cdb0a1a0c05da */
            public final class StickerTagsModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private List<NodesModel> f16530d;

                /* compiled from: eec361561d51e5375e5cdb0a1a0c05da */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(StickerTagsModel.class, new Deserializer());
                    }

                    public Object m24090a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(StickerTagsParser.m24393a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object stickerTagsModel = new StickerTagsModel();
                        ((BaseModel) stickerTagsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (stickerTagsModel instanceof Postprocessable) {
                            return ((Postprocessable) stickerTagsModel).a();
                        }
                        return stickerTagsModel;
                    }
                }

                @JsonDeserialize(using = Deserializer.class)
                @ModelWithFlatBufferFormatHash(a = -1524804972)
                @JsonSerialize(using = Serializer.class)
                @FragmentModelWithoutBridge
                /* compiled from: eec361561d51e5375e5cdb0a1a0c05da */
                public final class NodesModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
                    @Nullable
                    private String f16524d;
                    @Nullable
                    private String f16525e;
                    private boolean f16526f;
                    @Nullable
                    private String f16527g;
                    private int f16528h;
                    @Nullable
                    private ThumbnailImageModel f16529i;

                    /* compiled from: eec361561d51e5375e5cdb0a1a0c05da */
                    public class Deserializer extends FbJsonDeserializer {
                        static {
                            GlobalAutoGenDeserializerCache.a(NodesModel.class, new Deserializer());
                        }

                        public Object m24091a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(StickerTagsParser.NodesParser.m24391b(jsonParser, flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            mutableFlatBuffer.a(4, Boolean.valueOf(true));
                            MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                            Object nodesModel = new NodesModel();
                            ((BaseModel) nodesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                            if (nodesModel instanceof Postprocessable) {
                                return ((Postprocessable) nodesModel).a();
                            }
                            return nodesModel;
                        }
                    }

                    /* compiled from: eec361561d51e5375e5cdb0a1a0c05da */
                    public class Serializer extends JsonSerializer<NodesModel> {
                        public final void m24092a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            NodesModel nodesModel = (NodesModel) obj;
                            if (nodesModel.w_() == null) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(nodesModel.m24102a(flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                nodesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                            }
                            StickerTagsParser.NodesParser.m24392b(nodesModel.w_(), nodesModel.u_(), jsonGenerator, serializerProvider);
                        }

                        static {
                            FbSerializerProvider.a(NodesModel.class, new Serializer());
                        }
                    }

                    @JsonDeserialize(using = Deserializer.class)
                    @ModelWithFlatBufferFormatHash(a = 842551240)
                    @JsonSerialize(using = Serializer.class)
                    @FragmentModelWithoutBridge
                    /* compiled from: eec361561d51e5375e5cdb0a1a0c05da */
                    public final class ThumbnailImageModel extends BaseModel implements GraphQLVisitableModel {
                        @Nullable
                        private String f16523d;

                        /* compiled from: eec361561d51e5375e5cdb0a1a0c05da */
                        public class Deserializer extends FbJsonDeserializer {
                            static {
                                GlobalAutoGenDeserializerCache.a(ThumbnailImageModel.class, new Deserializer());
                            }

                            public Object m24093a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(ThumbnailImageParser.m24389a(jsonParser, flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                                Object thumbnailImageModel = new ThumbnailImageModel();
                                ((BaseModel) thumbnailImageModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                                if (thumbnailImageModel instanceof Postprocessable) {
                                    return ((Postprocessable) thumbnailImageModel).a();
                                }
                                return thumbnailImageModel;
                            }
                        }

                        /* compiled from: eec361561d51e5375e5cdb0a1a0c05da */
                        public class Serializer extends JsonSerializer<ThumbnailImageModel> {
                            public final void m24094a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                                ThumbnailImageModel thumbnailImageModel = (ThumbnailImageModel) obj;
                                if (thumbnailImageModel.w_() == null) {
                                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                    flatBufferBuilder.d(thumbnailImageModel.m24096a(flatBufferBuilder));
                                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                    wrap.position(0);
                                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                    thumbnailImageModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                                }
                                ThumbnailImageParser.m24390a(thumbnailImageModel.w_(), thumbnailImageModel.u_(), jsonGenerator);
                            }

                            static {
                                FbSerializerProvider.a(ThumbnailImageModel.class, new Serializer());
                            }
                        }

                        public ThumbnailImageModel() {
                            super(1);
                        }

                        @Nullable
                        private String m24095a() {
                            this.f16523d = super.a(this.f16523d, 0);
                            return this.f16523d;
                        }

                        public final int jK_() {
                            return 70760763;
                        }

                        public final GraphQLVisitableModel m24097a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                            h();
                            i();
                            return this;
                        }

                        public final int m24096a(FlatBufferBuilder flatBufferBuilder) {
                            h();
                            int b = flatBufferBuilder.b(m24095a());
                            flatBufferBuilder.c(1);
                            flatBufferBuilder.b(0, b);
                            i();
                            return flatBufferBuilder.d();
                        }
                    }

                    public NodesModel() {
                        super(6);
                    }

                    @Nullable
                    private String m24098j() {
                        this.f16524d = super.a(this.f16524d, 0);
                        return this.f16524d;
                    }

                    @Nullable
                    private String m24099k() {
                        this.f16525e = super.a(this.f16525e, 1);
                        return this.f16525e;
                    }

                    @Nullable
                    private String m24100l() {
                        this.f16527g = super.a(this.f16527g, 3);
                        return this.f16527g;
                    }

                    @Nullable
                    private ThumbnailImageModel m24101m() {
                        this.f16529i = (ThumbnailImageModel) super.a(this.f16529i, 5, ThumbnailImageModel.class);
                        return this.f16529i;
                    }

                    @Nullable
                    public final String m24104a() {
                        return m24099k();
                    }

                    public final int jK_() {
                        return 798045501;
                    }

                    public final GraphQLVisitableModel m24103a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                        GraphQLVisitableModel graphQLVisitableModel = null;
                        h();
                        if (m24101m() != null) {
                            ThumbnailImageModel thumbnailImageModel = (ThumbnailImageModel) graphQLModelMutatingVisitor.b(m24101m());
                            if (m24101m() != thumbnailImageModel) {
                                graphQLVisitableModel = (NodesModel) ModelHelper.a(null, this);
                                graphQLVisitableModel.f16529i = thumbnailImageModel;
                            }
                        }
                        i();
                        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                    }

                    public final int m24102a(FlatBufferBuilder flatBufferBuilder) {
                        h();
                        int b = flatBufferBuilder.b(m24098j());
                        int b2 = flatBufferBuilder.b(m24099k());
                        int b3 = flatBufferBuilder.b(m24100l());
                        int a = ModelHelper.a(flatBufferBuilder, m24101m());
                        flatBufferBuilder.c(6);
                        flatBufferBuilder.b(0, b);
                        flatBufferBuilder.b(1, b2);
                        flatBufferBuilder.a(2, this.f16526f);
                        flatBufferBuilder.b(3, b3);
                        flatBufferBuilder.a(4, this.f16528h, 0);
                        flatBufferBuilder.b(5, a);
                        i();
                        return flatBufferBuilder.d();
                    }

                    public final void m24105a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                        super.a(mutableFlatBuffer, i, obj);
                        this.f16526f = mutableFlatBuffer.a(i, 2);
                        this.f16528h = mutableFlatBuffer.a(i, 4, 0);
                    }
                }

                /* compiled from: eec361561d51e5375e5cdb0a1a0c05da */
                public class Serializer extends JsonSerializer<StickerTagsModel> {
                    public final void m24106a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        StickerTagsModel stickerTagsModel = (StickerTagsModel) obj;
                        if (stickerTagsModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(stickerTagsModel.m24108a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            stickerTagsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        StickerTagsParser.m24394a(stickerTagsModel.w_(), stickerTagsModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(StickerTagsModel.class, new Serializer());
                    }
                }

                public StickerTagsModel() {
                    super(1);
                }

                @Nonnull
                private ImmutableList<NodesModel> m24107a() {
                    this.f16530d = super.a(this.f16530d, 0, NodesModel.class);
                    return (ImmutableList) this.f16530d;
                }

                public final int jK_() {
                    return -311467149;
                }

                public final GraphQLVisitableModel m24109a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m24107a() != null) {
                        Builder a = ModelHelper.a(m24107a(), graphQLModelMutatingVisitor);
                        if (a != null) {
                            graphQLVisitableModel = (StickerTagsModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f16530d = a.b();
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m24108a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m24107a());
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, a);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            public StickerStoreModel() {
                super(1);
            }

            @Nullable
            private StickerTagsModel m24110a() {
                this.f16531d = (StickerTagsModel) super.a(this.f16531d, 0, StickerTagsModel.class);
                return this.f16531d;
            }

            public final int jK_() {
                return -1877765692;
            }

            public final GraphQLVisitableModel m24112a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m24110a() != null) {
                    StickerTagsModel stickerTagsModel = (StickerTagsModel) graphQLModelMutatingVisitor.b(m24110a());
                    if (m24110a() != stickerTagsModel) {
                        graphQLVisitableModel = (StickerStoreModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f16531d = stickerTagsModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m24111a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m24110a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        public FetchStickerTagsQueryModel() {
            super(1);
        }

        @Nullable
        private StickerStoreModel m24113a() {
            this.f16532d = (StickerStoreModel) super.a(this.f16532d, 0, StickerStoreModel.class);
            return this.f16532d;
        }

        public final int jK_() {
            return -1732764110;
        }

        public final GraphQLVisitableModel m24115a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m24113a() != null) {
                StickerStoreModel stickerStoreModel = (StickerStoreModel) graphQLModelMutatingVisitor.b(m24113a());
                if (m24113a() != stickerStoreModel) {
                    graphQLVisitableModel = (FetchStickerTagsQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f16532d = stickerStoreModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m24114a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m24113a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1878666097)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: eec361561d51e5375e5cdb0a1a0c05da */
    public final class FetchStickersWithPreviewsQueryModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
        @Nullable
        private GraphQLObjectType f16533d;
        @Nullable
        private AnimatedImageModel f16534e;
        @Nullable
        private String f16535f;
        @Nullable
        private PackModel f16536g;
        @Nullable
        private PreviewImageModel f16537h;
        @Nullable
        private ThreadImageModel f16538i;

        /* compiled from: eec361561d51e5375e5cdb0a1a0c05da */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FetchStickersWithPreviewsQueryModel.class, new Deserializer());
            }

            public Object m24116a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = FetchStickersWithPreviewsQueryParser.m24398a(jsonParser);
                Object fetchStickersWithPreviewsQueryModel = new FetchStickersWithPreviewsQueryModel();
                ((BaseModel) fetchStickersWithPreviewsQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (fetchStickersWithPreviewsQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) fetchStickersWithPreviewsQueryModel).a();
                }
                return fetchStickersWithPreviewsQueryModel;
            }
        }

        /* compiled from: eec361561d51e5375e5cdb0a1a0c05da */
        public class Serializer extends JsonSerializer<FetchStickersWithPreviewsQueryModel> {
            public final void m24117a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                FetchStickersWithPreviewsQueryModel fetchStickersWithPreviewsQueryModel = (FetchStickersWithPreviewsQueryModel) obj;
                if (fetchStickersWithPreviewsQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(fetchStickersWithPreviewsQueryModel.m24124a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    fetchStickersWithPreviewsQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = fetchStickersWithPreviewsQueryModel.w_();
                int u_ = fetchStickersWithPreviewsQueryModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("__type__");
                    SerializerHelpers.b(mutableFlatBuffer, u_, 0, jsonGenerator);
                }
                int g = mutableFlatBuffer.g(u_, 1);
                if (g != 0) {
                    jsonGenerator.a("animated_image");
                    AnimatedImageParser.m24439a(mutableFlatBuffer, g, jsonGenerator);
                }
                if (mutableFlatBuffer.g(u_, 2) != 0) {
                    jsonGenerator.a("id");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 2));
                }
                g = mutableFlatBuffer.g(u_, 3);
                if (g != 0) {
                    jsonGenerator.a("pack");
                    PackParser.m24441a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(u_, 4);
                if (g != 0) {
                    jsonGenerator.a("preview_image");
                    PreviewImageParser.m24428a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(u_, 5);
                if (g != 0) {
                    jsonGenerator.a("thread_image");
                    ThreadImageParser.m24443a(mutableFlatBuffer, g, jsonGenerator);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(FetchStickersWithPreviewsQueryModel.class, new Serializer());
            }
        }

        public FetchStickersWithPreviewsQueryModel() {
            super(6);
        }

        public final void m24127a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m24128a(String str, Object obj, boolean z) {
        }

        @Nullable
        private GraphQLObjectType m24118j() {
            if (this.b != null && this.f16533d == null) {
                this.f16533d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
            }
            return this.f16533d;
        }

        @Nullable
        private AnimatedImageModel m24119k() {
            this.f16534e = (AnimatedImageModel) super.a(this.f16534e, 1, AnimatedImageModel.class);
            return this.f16534e;
        }

        @Nullable
        private String m24120l() {
            this.f16535f = super.a(this.f16535f, 2);
            return this.f16535f;
        }

        @Nullable
        private PackModel m24121m() {
            this.f16536g = (PackModel) super.a(this.f16536g, 3, PackModel.class);
            return this.f16536g;
        }

        @Nullable
        private PreviewImageModel m24122n() {
            this.f16537h = (PreviewImageModel) super.a(this.f16537h, 4, PreviewImageModel.class);
            return this.f16537h;
        }

        @Nullable
        private ThreadImageModel m24123o() {
            this.f16538i = (ThreadImageModel) super.a(this.f16538i, 5, ThreadImageModel.class);
            return this.f16538i;
        }

        @Nullable
        public final String m24126a() {
            return m24120l();
        }

        public final int jK_() {
            return 2433570;
        }

        public final GraphQLVisitableModel m24125a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m24119k() != null) {
                AnimatedImageModel animatedImageModel = (AnimatedImageModel) graphQLModelMutatingVisitor.b(m24119k());
                if (m24119k() != animatedImageModel) {
                    graphQLVisitableModel = (FetchStickersWithPreviewsQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f16534e = animatedImageModel;
                }
            }
            if (m24121m() != null) {
                PackModel packModel = (PackModel) graphQLModelMutatingVisitor.b(m24121m());
                if (m24121m() != packModel) {
                    graphQLVisitableModel = (FetchStickersWithPreviewsQueryModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f16536g = packModel;
                }
            }
            if (m24122n() != null) {
                PreviewImageModel previewImageModel = (PreviewImageModel) graphQLModelMutatingVisitor.b(m24122n());
                if (m24122n() != previewImageModel) {
                    graphQLVisitableModel = (FetchStickersWithPreviewsQueryModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f16537h = previewImageModel;
                }
            }
            if (m24123o() != null) {
                ThreadImageModel threadImageModel = (ThreadImageModel) graphQLModelMutatingVisitor.b(m24123o());
                if (m24123o() != threadImageModel) {
                    graphQLVisitableModel = (FetchStickersWithPreviewsQueryModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f16538i = threadImageModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m24124a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m24118j());
            int a2 = ModelHelper.a(flatBufferBuilder, m24119k());
            int b = flatBufferBuilder.b(m24120l());
            int a3 = ModelHelper.a(flatBufferBuilder, m24121m());
            int a4 = ModelHelper.a(flatBufferBuilder, m24122n());
            int a5 = ModelHelper.a(flatBufferBuilder, m24123o());
            flatBufferBuilder.c(6);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            flatBufferBuilder.b(2, b);
            flatBufferBuilder.b(3, a3);
            flatBufferBuilder.b(4, a4);
            flatBufferBuilder.b(5, a5);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -54660602)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: eec361561d51e5375e5cdb0a1a0c05da */
    public final class FetchStoreStickerPackIdsQueryModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private StickerStoreModel f16541d;

        /* compiled from: eec361561d51e5375e5cdb0a1a0c05da */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FetchStoreStickerPackIdsQueryModel.class, new Deserializer());
            }

            public Object m24129a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = FetchStoreStickerPackIdsQueryParser.m24403a(jsonParser);
                Object fetchStoreStickerPackIdsQueryModel = new FetchStoreStickerPackIdsQueryModel();
                ((BaseModel) fetchStoreStickerPackIdsQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (fetchStoreStickerPackIdsQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) fetchStoreStickerPackIdsQueryModel).a();
                }
                return fetchStoreStickerPackIdsQueryModel;
            }
        }

        /* compiled from: eec361561d51e5375e5cdb0a1a0c05da */
        public class Serializer extends JsonSerializer<FetchStoreStickerPackIdsQueryModel> {
            public final void m24130a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                FetchStoreStickerPackIdsQueryModel fetchStoreStickerPackIdsQueryModel = (FetchStoreStickerPackIdsQueryModel) obj;
                if (fetchStoreStickerPackIdsQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(fetchStoreStickerPackIdsQueryModel.m24142a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    fetchStoreStickerPackIdsQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = fetchStoreStickerPackIdsQueryModel.w_();
                int u_ = fetchStoreStickerPackIdsQueryModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("sticker_store");
                    FetchStoreStickerPackIdsQueryParser.StickerStoreParser.m24402a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(FetchStoreStickerPackIdsQueryModel.class, new Serializer());
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1081607229)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: eec361561d51e5375e5cdb0a1a0c05da */
        public final class StickerStoreModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private AvailablePacksModel f16540d;

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 651446826)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: eec361561d51e5375e5cdb0a1a0c05da */
            public final class AvailablePacksModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private List<StickerPackIdFieldsModel> f16539d;

                /* compiled from: eec361561d51e5375e5cdb0a1a0c05da */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(AvailablePacksModel.class, new Deserializer());
                    }

                    public Object m24131a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(AvailablePacksParser.m24399a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object availablePacksModel = new AvailablePacksModel();
                        ((BaseModel) availablePacksModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (availablePacksModel instanceof Postprocessable) {
                            return ((Postprocessable) availablePacksModel).a();
                        }
                        return availablePacksModel;
                    }
                }

                /* compiled from: eec361561d51e5375e5cdb0a1a0c05da */
                public class Serializer extends JsonSerializer<AvailablePacksModel> {
                    public final void m24132a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        AvailablePacksModel availablePacksModel = (AvailablePacksModel) obj;
                        if (availablePacksModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(availablePacksModel.m24134a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            availablePacksModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        AvailablePacksParser.m24400a(availablePacksModel.w_(), availablePacksModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(AvailablePacksModel.class, new Serializer());
                    }
                }

                public AvailablePacksModel() {
                    super(1);
                }

                @Nonnull
                private ImmutableList<StickerPackIdFieldsModel> m24133a() {
                    this.f16539d = super.a(this.f16539d, 0, StickerPackIdFieldsModel.class);
                    return (ImmutableList) this.f16539d;
                }

                public final int jK_() {
                    return -1296983292;
                }

                public final GraphQLVisitableModel m24135a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m24133a() != null) {
                        Builder a = ModelHelper.a(m24133a(), graphQLModelMutatingVisitor);
                        if (a != null) {
                            graphQLVisitableModel = (AvailablePacksModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f16539d = a.b();
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m24134a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m24133a());
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, a);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: eec361561d51e5375e5cdb0a1a0c05da */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(StickerStoreModel.class, new Deserializer());
                }

                public Object m24136a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(FetchStoreStickerPackIdsQueryParser.StickerStoreParser.m24401a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object stickerStoreModel = new StickerStoreModel();
                    ((BaseModel) stickerStoreModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (stickerStoreModel instanceof Postprocessable) {
                        return ((Postprocessable) stickerStoreModel).a();
                    }
                    return stickerStoreModel;
                }
            }

            /* compiled from: eec361561d51e5375e5cdb0a1a0c05da */
            public class Serializer extends JsonSerializer<StickerStoreModel> {
                public final void m24137a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    StickerStoreModel stickerStoreModel = (StickerStoreModel) obj;
                    if (stickerStoreModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(stickerStoreModel.m24139a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        stickerStoreModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    FetchStoreStickerPackIdsQueryParser.StickerStoreParser.m24402a(stickerStoreModel.w_(), stickerStoreModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(StickerStoreModel.class, new Serializer());
                }
            }

            public StickerStoreModel() {
                super(1);
            }

            @Nullable
            private AvailablePacksModel m24138a() {
                this.f16540d = (AvailablePacksModel) super.a(this.f16540d, 0, AvailablePacksModel.class);
                return this.f16540d;
            }

            public final int jK_() {
                return -1877765692;
            }

            public final GraphQLVisitableModel m24140a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m24138a() != null) {
                    AvailablePacksModel availablePacksModel = (AvailablePacksModel) graphQLModelMutatingVisitor.b(m24138a());
                    if (m24138a() != availablePacksModel) {
                        graphQLVisitableModel = (StickerStoreModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f16540d = availablePacksModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m24139a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m24138a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        public FetchStoreStickerPackIdsQueryModel() {
            super(1);
        }

        @Nullable
        private StickerStoreModel m24141a() {
            this.f16541d = (StickerStoreModel) super.a(this.f16541d, 0, StickerStoreModel.class);
            return this.f16541d;
        }

        public final int jK_() {
            return -1732764110;
        }

        public final GraphQLVisitableModel m24143a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m24141a() != null) {
                StickerStoreModel stickerStoreModel = (StickerStoreModel) graphQLModelMutatingVisitor.b(m24141a());
                if (m24141a() != stickerStoreModel) {
                    graphQLVisitableModel = (FetchStoreStickerPackIdsQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f16541d = stickerStoreModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m24142a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m24141a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -817773861)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: eec361561d51e5375e5cdb0a1a0c05da */
    public final class FetchStoreStickerPacksQueryModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private StickerStoreModel f16547d;

        /* compiled from: eec361561d51e5375e5cdb0a1a0c05da */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FetchStoreStickerPacksQueryModel.class, new Deserializer());
            }

            public Object m24144a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = FetchStoreStickerPacksQueryParser.m24410a(jsonParser);
                Object fetchStoreStickerPacksQueryModel = new FetchStoreStickerPacksQueryModel();
                ((BaseModel) fetchStoreStickerPacksQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (fetchStoreStickerPacksQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) fetchStoreStickerPacksQueryModel).a();
                }
                return fetchStoreStickerPacksQueryModel;
            }
        }

        /* compiled from: eec361561d51e5375e5cdb0a1a0c05da */
        public class Serializer extends JsonSerializer<FetchStoreStickerPacksQueryModel> {
            public final void m24145a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                FetchStoreStickerPacksQueryModel fetchStoreStickerPacksQueryModel = (FetchStoreStickerPacksQueryModel) obj;
                if (fetchStoreStickerPacksQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(fetchStoreStickerPacksQueryModel.m24164a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    fetchStoreStickerPacksQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = fetchStoreStickerPacksQueryModel.w_();
                int u_ = fetchStoreStickerPacksQueryModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("sticker_store");
                    FetchStoreStickerPacksQueryParser.StickerStoreParser.m24409a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(FetchStoreStickerPacksQueryModel.class, new Serializer());
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -916270601)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: eec361561d51e5375e5cdb0a1a0c05da */
        public final class StickerStoreModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private AvailablePacksModel f16546d;

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 1631551355)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: eec361561d51e5375e5cdb0a1a0c05da */
            public final class AvailablePacksModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private List<StickerPackFieldsModel> f16544d;
                @Nullable
                private PageInfoModel f16545e;

                /* compiled from: eec361561d51e5375e5cdb0a1a0c05da */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(AvailablePacksModel.class, new Deserializer());
                    }

                    public Object m24146a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(FetchStoreStickerPacksQueryParser.StickerStoreParser.AvailablePacksParser.m24406a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object availablePacksModel = new AvailablePacksModel();
                        ((BaseModel) availablePacksModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (availablePacksModel instanceof Postprocessable) {
                            return ((Postprocessable) availablePacksModel).a();
                        }
                        return availablePacksModel;
                    }
                }

                @JsonDeserialize(using = Deserializer.class)
                @ModelWithFlatBufferFormatHash(a = -2005169142)
                @JsonSerialize(using = Serializer.class)
                @FragmentModelWithoutBridge
                /* compiled from: eec361561d51e5375e5cdb0a1a0c05da */
                public final class PageInfoModel extends BaseModel implements GraphQLVisitableModel {
                    @Nullable
                    private String f16542d;
                    private boolean f16543e;

                    /* compiled from: eec361561d51e5375e5cdb0a1a0c05da */
                    public class Deserializer extends FbJsonDeserializer {
                        static {
                            GlobalAutoGenDeserializerCache.a(PageInfoModel.class, new Deserializer());
                        }

                        public Object m24147a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(FetchStoreStickerPacksQueryParser.StickerStoreParser.AvailablePacksParser.PageInfoParser.m24404a(jsonParser, flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            mutableFlatBuffer.a(4, Boolean.valueOf(true));
                            MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                            Object pageInfoModel = new PageInfoModel();
                            ((BaseModel) pageInfoModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                            if (pageInfoModel instanceof Postprocessable) {
                                return ((Postprocessable) pageInfoModel).a();
                            }
                            return pageInfoModel;
                        }
                    }

                    /* compiled from: eec361561d51e5375e5cdb0a1a0c05da */
                    public class Serializer extends JsonSerializer<PageInfoModel> {
                        public final void m24148a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            PageInfoModel pageInfoModel = (PageInfoModel) obj;
                            if (pageInfoModel.w_() == null) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(pageInfoModel.m24150a(flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                pageInfoModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                            }
                            FetchStoreStickerPacksQueryParser.StickerStoreParser.AvailablePacksParser.PageInfoParser.m24405a(pageInfoModel.w_(), pageInfoModel.u_(), jsonGenerator);
                        }

                        static {
                            FbSerializerProvider.a(PageInfoModel.class, new Serializer());
                        }
                    }

                    public PageInfoModel() {
                        super(2);
                    }

                    @Nullable
                    private String m24149a() {
                        this.f16542d = super.a(this.f16542d, 0);
                        return this.f16542d;
                    }

                    public final int jK_() {
                        return 923779069;
                    }

                    public final GraphQLVisitableModel m24151a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                        h();
                        i();
                        return this;
                    }

                    public final int m24150a(FlatBufferBuilder flatBufferBuilder) {
                        h();
                        int b = flatBufferBuilder.b(m24149a());
                        flatBufferBuilder.c(2);
                        flatBufferBuilder.b(0, b);
                        flatBufferBuilder.a(1, this.f16543e);
                        i();
                        return flatBufferBuilder.d();
                    }

                    public final void m24152a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                        super.a(mutableFlatBuffer, i, obj);
                        this.f16543e = mutableFlatBuffer.a(i, 1);
                    }
                }

                /* compiled from: eec361561d51e5375e5cdb0a1a0c05da */
                public class Serializer extends JsonSerializer<AvailablePacksModel> {
                    public final void m24153a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        AvailablePacksModel availablePacksModel = (AvailablePacksModel) obj;
                        if (availablePacksModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(availablePacksModel.m24156a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            availablePacksModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        FetchStoreStickerPacksQueryParser.StickerStoreParser.AvailablePacksParser.m24407a(availablePacksModel.w_(), availablePacksModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(AvailablePacksModel.class, new Serializer());
                    }
                }

                public AvailablePacksModel() {
                    super(2);
                }

                @Nonnull
                private ImmutableList<StickerPackFieldsModel> m24154a() {
                    this.f16544d = super.a(this.f16544d, 0, StickerPackFieldsModel.class);
                    return (ImmutableList) this.f16544d;
                }

                @Nullable
                private PageInfoModel m24155j() {
                    this.f16545e = (PageInfoModel) super.a(this.f16545e, 1, PageInfoModel.class);
                    return this.f16545e;
                }

                public final int jK_() {
                    return -1296983292;
                }

                public final GraphQLVisitableModel m24157a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel;
                    PageInfoModel pageInfoModel;
                    h();
                    if (m24154a() != null) {
                        Builder a = ModelHelper.a(m24154a(), graphQLModelMutatingVisitor);
                        if (a != null) {
                            AvailablePacksModel availablePacksModel = (AvailablePacksModel) ModelHelper.a(null, this);
                            availablePacksModel.f16544d = a.b();
                            graphQLVisitableModel = availablePacksModel;
                            if (m24155j() != null) {
                                pageInfoModel = (PageInfoModel) graphQLModelMutatingVisitor.b(m24155j());
                                if (m24155j() != pageInfoModel) {
                                    graphQLVisitableModel = (AvailablePacksModel) ModelHelper.a(graphQLVisitableModel, this);
                                    graphQLVisitableModel.f16545e = pageInfoModel;
                                }
                            }
                            i();
                            return graphQLVisitableModel != null ? this : graphQLVisitableModel;
                        }
                    }
                    graphQLVisitableModel = null;
                    if (m24155j() != null) {
                        pageInfoModel = (PageInfoModel) graphQLModelMutatingVisitor.b(m24155j());
                        if (m24155j() != pageInfoModel) {
                            graphQLVisitableModel = (AvailablePacksModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f16545e = pageInfoModel;
                        }
                    }
                    i();
                    if (graphQLVisitableModel != null) {
                    }
                }

                public final int m24156a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m24154a());
                    int a2 = ModelHelper.a(flatBufferBuilder, m24155j());
                    flatBufferBuilder.c(2);
                    flatBufferBuilder.b(0, a);
                    flatBufferBuilder.b(1, a2);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: eec361561d51e5375e5cdb0a1a0c05da */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(StickerStoreModel.class, new Deserializer());
                }

                public Object m24158a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(FetchStoreStickerPacksQueryParser.StickerStoreParser.m24408a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object stickerStoreModel = new StickerStoreModel();
                    ((BaseModel) stickerStoreModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (stickerStoreModel instanceof Postprocessable) {
                        return ((Postprocessable) stickerStoreModel).a();
                    }
                    return stickerStoreModel;
                }
            }

            /* compiled from: eec361561d51e5375e5cdb0a1a0c05da */
            public class Serializer extends JsonSerializer<StickerStoreModel> {
                public final void m24159a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    StickerStoreModel stickerStoreModel = (StickerStoreModel) obj;
                    if (stickerStoreModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(stickerStoreModel.m24161a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        stickerStoreModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    FetchStoreStickerPacksQueryParser.StickerStoreParser.m24409a(stickerStoreModel.w_(), stickerStoreModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(StickerStoreModel.class, new Serializer());
                }
            }

            public StickerStoreModel() {
                super(1);
            }

            @Nullable
            private AvailablePacksModel m24160a() {
                this.f16546d = (AvailablePacksModel) super.a(this.f16546d, 0, AvailablePacksModel.class);
                return this.f16546d;
            }

            public final int jK_() {
                return -1877765692;
            }

            public final GraphQLVisitableModel m24162a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m24160a() != null) {
                    AvailablePacksModel availablePacksModel = (AvailablePacksModel) graphQLModelMutatingVisitor.b(m24160a());
                    if (m24160a() != availablePacksModel) {
                        graphQLVisitableModel = (StickerStoreModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f16546d = availablePacksModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m24161a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m24160a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        public FetchStoreStickerPacksQueryModel() {
            super(1);
        }

        @Nullable
        private StickerStoreModel m24163a() {
            this.f16547d = (StickerStoreModel) super.a(this.f16547d, 0, StickerStoreModel.class);
            return this.f16547d;
        }

        public final int jK_() {
            return -1732764110;
        }

        public final GraphQLVisitableModel m24165a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m24163a() != null) {
                StickerStoreModel stickerStoreModel = (StickerStoreModel) graphQLModelMutatingVisitor.b(m24163a());
                if (m24163a() != stickerStoreModel) {
                    graphQLVisitableModel = (FetchStoreStickerPacksQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f16547d = stickerStoreModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m24164a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m24163a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1846445908)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: eec361561d51e5375e5cdb0a1a0c05da */
    public final class FetchTaggedStickersQueryModel extends BaseModel implements GraphQLVisitableConsistentModel {
        @Nullable
        private GraphQLObjectType f16549d;
        @Nullable
        private TaggedStickersModel f16550e;

        /* compiled from: eec361561d51e5375e5cdb0a1a0c05da */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FetchTaggedStickersQueryModel.class, new Deserializer());
            }

            public Object m24166a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = FetchTaggedStickersQueryParser.m24413a(jsonParser);
                Object fetchTaggedStickersQueryModel = new FetchTaggedStickersQueryModel();
                ((BaseModel) fetchTaggedStickersQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (fetchTaggedStickersQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) fetchTaggedStickersQueryModel).a();
                }
                return fetchTaggedStickersQueryModel;
            }
        }

        /* compiled from: eec361561d51e5375e5cdb0a1a0c05da */
        public class Serializer extends JsonSerializer<FetchTaggedStickersQueryModel> {
            public final void m24167a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                FetchTaggedStickersQueryModel fetchTaggedStickersQueryModel = (FetchTaggedStickersQueryModel) obj;
                if (fetchTaggedStickersQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(fetchTaggedStickersQueryModel.m24175a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    fetchTaggedStickersQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = fetchTaggedStickersQueryModel.w_();
                int u_ = fetchTaggedStickersQueryModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("__type__");
                    SerializerHelpers.b(mutableFlatBuffer, u_, 0, jsonGenerator);
                }
                int g = mutableFlatBuffer.g(u_, 1);
                if (g != 0) {
                    jsonGenerator.a("tagged_stickers");
                    FetchTaggedStickersQueryParser.TaggedStickersParser.m24412a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(FetchTaggedStickersQueryModel.class, new Serializer());
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -48884331)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: eec361561d51e5375e5cdb0a1a0c05da */
        public final class TaggedStickersModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<StickerFieldsModel> f16548d;

            /* compiled from: eec361561d51e5375e5cdb0a1a0c05da */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(TaggedStickersModel.class, new Deserializer());
                }

                public Object m24168a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(FetchTaggedStickersQueryParser.TaggedStickersParser.m24411a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object taggedStickersModel = new TaggedStickersModel();
                    ((BaseModel) taggedStickersModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (taggedStickersModel instanceof Postprocessable) {
                        return ((Postprocessable) taggedStickersModel).a();
                    }
                    return taggedStickersModel;
                }
            }

            /* compiled from: eec361561d51e5375e5cdb0a1a0c05da */
            public class Serializer extends JsonSerializer<TaggedStickersModel> {
                public final void m24169a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    TaggedStickersModel taggedStickersModel = (TaggedStickersModel) obj;
                    if (taggedStickersModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(taggedStickersModel.m24171a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        taggedStickersModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    FetchTaggedStickersQueryParser.TaggedStickersParser.m24412a(taggedStickersModel.w_(), taggedStickersModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(TaggedStickersModel.class, new Serializer());
                }
            }

            public TaggedStickersModel() {
                super(1);
            }

            @Nonnull
            private ImmutableList<StickerFieldsModel> m24170a() {
                this.f16548d = super.a(this.f16548d, 0, StickerFieldsModel.class);
                return (ImmutableList) this.f16548d;
            }

            public final int jK_() {
                return -795239780;
            }

            public final GraphQLVisitableModel m24172a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m24170a() != null) {
                    Builder a = ModelHelper.a(m24170a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (TaggedStickersModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f16548d = a.b();
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m24171a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m24170a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        public FetchTaggedStickersQueryModel() {
            super(2);
        }

        public final void m24177a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m24178a(String str, Object obj, boolean z) {
        }

        @Nullable
        private GraphQLObjectType m24173a() {
            if (this.b != null && this.f16549d == null) {
                this.f16549d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
            }
            return this.f16549d;
        }

        @Nullable
        private TaggedStickersModel m24174j() {
            this.f16550e = (TaggedStickersModel) super.a(this.f16550e, 1, TaggedStickersModel.class);
            return this.f16550e;
        }

        public final int jK_() {
            return 2433570;
        }

        public final GraphQLVisitableModel m24176a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m24174j() != null) {
                TaggedStickersModel taggedStickersModel = (TaggedStickersModel) graphQLModelMutatingVisitor.b(m24174j());
                if (m24174j() != taggedStickersModel) {
                    graphQLVisitableModel = (FetchTaggedStickersQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f16550e = taggedStickersModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m24175a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m24173a());
            int a2 = ModelHelper.a(flatBufferBuilder, m24174j());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -584103287)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: eec361561d51e5375e5cdb0a1a0c05da */
    public final class FetchTaggedStickersWithPreviewsQueryModel extends BaseModel implements GraphQLVisitableConsistentModel {
        @Nullable
        private GraphQLObjectType f16557d;
        @Nullable
        private TaggedStickersModel f16558e;

        /* compiled from: eec361561d51e5375e5cdb0a1a0c05da */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FetchTaggedStickersWithPreviewsQueryModel.class, new Deserializer());
            }

            public Object m24179a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = FetchTaggedStickersWithPreviewsQueryParser.m24418a(jsonParser);
                Object fetchTaggedStickersWithPreviewsQueryModel = new FetchTaggedStickersWithPreviewsQueryModel();
                ((BaseModel) fetchTaggedStickersWithPreviewsQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (fetchTaggedStickersWithPreviewsQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) fetchTaggedStickersWithPreviewsQueryModel).a();
                }
                return fetchTaggedStickersWithPreviewsQueryModel;
            }
        }

        /* compiled from: eec361561d51e5375e5cdb0a1a0c05da */
        public class Serializer extends JsonSerializer<FetchTaggedStickersWithPreviewsQueryModel> {
            public final void m24180a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                FetchTaggedStickersWithPreviewsQueryModel fetchTaggedStickersWithPreviewsQueryModel = (FetchTaggedStickersWithPreviewsQueryModel) obj;
                if (fetchTaggedStickersWithPreviewsQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(fetchTaggedStickersWithPreviewsQueryModel.m24198a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    fetchTaggedStickersWithPreviewsQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = fetchTaggedStickersWithPreviewsQueryModel.w_();
                int u_ = fetchTaggedStickersWithPreviewsQueryModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("__type__");
                    SerializerHelpers.b(mutableFlatBuffer, u_, 0, jsonGenerator);
                }
                int g = mutableFlatBuffer.g(u_, 1);
                if (g != 0) {
                    jsonGenerator.a("tagged_stickers");
                    FetchTaggedStickersWithPreviewsQueryParser.TaggedStickersParser.m24417a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(FetchTaggedStickersWithPreviewsQueryModel.class, new Serializer());
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -629462894)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: eec361561d51e5375e5cdb0a1a0c05da */
        public final class TaggedStickersModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<NodesModel> f16556d;

            /* compiled from: eec361561d51e5375e5cdb0a1a0c05da */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(TaggedStickersModel.class, new Deserializer());
                }

                public Object m24181a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(FetchTaggedStickersWithPreviewsQueryParser.TaggedStickersParser.m24416a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object taggedStickersModel = new TaggedStickersModel();
                    ((BaseModel) taggedStickersModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (taggedStickersModel instanceof Postprocessable) {
                        return ((Postprocessable) taggedStickersModel).a();
                    }
                    return taggedStickersModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 75791716)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: eec361561d51e5375e5cdb0a1a0c05da */
            public final class NodesModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
                @Nullable
                private AnimatedImageModel f16551d;
                @Nullable
                private String f16552e;
                @Nullable
                private PackModel f16553f;
                @Nullable
                private PreviewImageModel f16554g;
                @Nullable
                private ThreadImageModel f16555h;

                /* compiled from: eec361561d51e5375e5cdb0a1a0c05da */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(NodesModel.class, new Deserializer());
                    }

                    public Object m24182a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(FetchTaggedStickersWithPreviewsQueryParser.TaggedStickersParser.NodesParser.m24414b(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object nodesModel = new NodesModel();
                        ((BaseModel) nodesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (nodesModel instanceof Postprocessable) {
                            return ((Postprocessable) nodesModel).a();
                        }
                        return nodesModel;
                    }
                }

                /* compiled from: eec361561d51e5375e5cdb0a1a0c05da */
                public class Serializer extends JsonSerializer<NodesModel> {
                    public final void m24183a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        NodesModel nodesModel = (NodesModel) obj;
                        if (nodesModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(nodesModel.m24189a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            nodesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        FetchTaggedStickersWithPreviewsQueryParser.TaggedStickersParser.NodesParser.m24415b(nodesModel.w_(), nodesModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(NodesModel.class, new Serializer());
                    }
                }

                public NodesModel() {
                    super(5);
                }

                @Nullable
                private AnimatedImageModel m24184j() {
                    this.f16551d = (AnimatedImageModel) super.a(this.f16551d, 0, AnimatedImageModel.class);
                    return this.f16551d;
                }

                @Nullable
                private String m24185k() {
                    this.f16552e = super.a(this.f16552e, 1);
                    return this.f16552e;
                }

                @Nullable
                private PackModel m24186l() {
                    this.f16553f = (PackModel) super.a(this.f16553f, 2, PackModel.class);
                    return this.f16553f;
                }

                @Nullable
                private PreviewImageModel m24187m() {
                    this.f16554g = (PreviewImageModel) super.a(this.f16554g, 3, PreviewImageModel.class);
                    return this.f16554g;
                }

                @Nullable
                private ThreadImageModel m24188n() {
                    this.f16555h = (ThreadImageModel) super.a(this.f16555h, 4, ThreadImageModel.class);
                    return this.f16555h;
                }

                @Nullable
                public final String m24191a() {
                    return m24185k();
                }

                public final int jK_() {
                    return -225599203;
                }

                public final GraphQLVisitableModel m24190a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m24184j() != null) {
                        AnimatedImageModel animatedImageModel = (AnimatedImageModel) graphQLModelMutatingVisitor.b(m24184j());
                        if (m24184j() != animatedImageModel) {
                            graphQLVisitableModel = (NodesModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f16551d = animatedImageModel;
                        }
                    }
                    if (m24186l() != null) {
                        PackModel packModel = (PackModel) graphQLModelMutatingVisitor.b(m24186l());
                        if (m24186l() != packModel) {
                            graphQLVisitableModel = (NodesModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f16553f = packModel;
                        }
                    }
                    if (m24187m() != null) {
                        PreviewImageModel previewImageModel = (PreviewImageModel) graphQLModelMutatingVisitor.b(m24187m());
                        if (m24187m() != previewImageModel) {
                            graphQLVisitableModel = (NodesModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f16554g = previewImageModel;
                        }
                    }
                    if (m24188n() != null) {
                        ThreadImageModel threadImageModel = (ThreadImageModel) graphQLModelMutatingVisitor.b(m24188n());
                        if (m24188n() != threadImageModel) {
                            graphQLVisitableModel = (NodesModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f16555h = threadImageModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m24189a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m24184j());
                    int b = flatBufferBuilder.b(m24185k());
                    int a2 = ModelHelper.a(flatBufferBuilder, m24186l());
                    int a3 = ModelHelper.a(flatBufferBuilder, m24187m());
                    int a4 = ModelHelper.a(flatBufferBuilder, m24188n());
                    flatBufferBuilder.c(5);
                    flatBufferBuilder.b(0, a);
                    flatBufferBuilder.b(1, b);
                    flatBufferBuilder.b(2, a2);
                    flatBufferBuilder.b(3, a3);
                    flatBufferBuilder.b(4, a4);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: eec361561d51e5375e5cdb0a1a0c05da */
            public class Serializer extends JsonSerializer<TaggedStickersModel> {
                public final void m24192a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    TaggedStickersModel taggedStickersModel = (TaggedStickersModel) obj;
                    if (taggedStickersModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(taggedStickersModel.m24194a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        taggedStickersModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    FetchTaggedStickersWithPreviewsQueryParser.TaggedStickersParser.m24417a(taggedStickersModel.w_(), taggedStickersModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(TaggedStickersModel.class, new Serializer());
                }
            }

            public TaggedStickersModel() {
                super(1);
            }

            @Nonnull
            private ImmutableList<NodesModel> m24193a() {
                this.f16556d = super.a(this.f16556d, 0, NodesModel.class);
                return (ImmutableList) this.f16556d;
            }

            public final int jK_() {
                return -795239780;
            }

            public final GraphQLVisitableModel m24195a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m24193a() != null) {
                    Builder a = ModelHelper.a(m24193a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (TaggedStickersModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f16556d = a.b();
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m24194a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m24193a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        public FetchTaggedStickersWithPreviewsQueryModel() {
            super(2);
        }

        public final void m24200a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m24201a(String str, Object obj, boolean z) {
        }

        @Nullable
        private GraphQLObjectType m24196a() {
            if (this.b != null && this.f16557d == null) {
                this.f16557d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
            }
            return this.f16557d;
        }

        @Nullable
        private TaggedStickersModel m24197j() {
            this.f16558e = (TaggedStickersModel) super.a(this.f16558e, 1, TaggedStickersModel.class);
            return this.f16558e;
        }

        public final int jK_() {
            return 2433570;
        }

        public final GraphQLVisitableModel m24199a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m24197j() != null) {
                TaggedStickersModel taggedStickersModel = (TaggedStickersModel) graphQLModelMutatingVisitor.b(m24197j());
                if (m24197j() != taggedStickersModel) {
                    graphQLVisitableModel = (FetchTaggedStickersWithPreviewsQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f16558e = taggedStickersModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m24198a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m24196a());
            int a2 = ModelHelper.a(flatBufferBuilder, m24197j());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1782026688)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: eec361561d51e5375e5cdb0a1a0c05da */
    public final class FetchTrayTaggedStickersQueryModel extends BaseModel implements GraphQLVisitableConsistentModel {
        @Nullable
        private GraphQLObjectType f16560d;
        @Nullable
        private TaggedStickersModel f16561e;

        /* compiled from: eec361561d51e5375e5cdb0a1a0c05da */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FetchTrayTaggedStickersQueryModel.class, new Deserializer());
            }

            public Object m24202a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = FetchTrayTaggedStickersQueryParser.m24421a(jsonParser);
                Object fetchTrayTaggedStickersQueryModel = new FetchTrayTaggedStickersQueryModel();
                ((BaseModel) fetchTrayTaggedStickersQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (fetchTrayTaggedStickersQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) fetchTrayTaggedStickersQueryModel).a();
                }
                return fetchTrayTaggedStickersQueryModel;
            }
        }

        /* compiled from: eec361561d51e5375e5cdb0a1a0c05da */
        public class Serializer extends JsonSerializer<FetchTrayTaggedStickersQueryModel> {
            public final void m24203a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                FetchTrayTaggedStickersQueryModel fetchTrayTaggedStickersQueryModel = (FetchTrayTaggedStickersQueryModel) obj;
                if (fetchTrayTaggedStickersQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(fetchTrayTaggedStickersQueryModel.m24211a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    fetchTrayTaggedStickersQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = fetchTrayTaggedStickersQueryModel.w_();
                int u_ = fetchTrayTaggedStickersQueryModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("__type__");
                    SerializerHelpers.b(mutableFlatBuffer, u_, 0, jsonGenerator);
                }
                int g = mutableFlatBuffer.g(u_, 1);
                if (g != 0) {
                    jsonGenerator.a("tagged_stickers");
                    FetchTrayTaggedStickersQueryParser.TaggedStickersParser.m24420a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(FetchTrayTaggedStickersQueryModel.class, new Serializer());
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -48884331)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: eec361561d51e5375e5cdb0a1a0c05da */
        public final class TaggedStickersModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<StickerFieldsModel> f16559d;

            /* compiled from: eec361561d51e5375e5cdb0a1a0c05da */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(TaggedStickersModel.class, new Deserializer());
                }

                public Object m24204a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(FetchTrayTaggedStickersQueryParser.TaggedStickersParser.m24419a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object taggedStickersModel = new TaggedStickersModel();
                    ((BaseModel) taggedStickersModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (taggedStickersModel instanceof Postprocessable) {
                        return ((Postprocessable) taggedStickersModel).a();
                    }
                    return taggedStickersModel;
                }
            }

            /* compiled from: eec361561d51e5375e5cdb0a1a0c05da */
            public class Serializer extends JsonSerializer<TaggedStickersModel> {
                public final void m24205a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    TaggedStickersModel taggedStickersModel = (TaggedStickersModel) obj;
                    if (taggedStickersModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(taggedStickersModel.m24207a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        taggedStickersModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    FetchTrayTaggedStickersQueryParser.TaggedStickersParser.m24420a(taggedStickersModel.w_(), taggedStickersModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(TaggedStickersModel.class, new Serializer());
                }
            }

            public TaggedStickersModel() {
                super(1);
            }

            @Nonnull
            private ImmutableList<StickerFieldsModel> m24206a() {
                this.f16559d = super.a(this.f16559d, 0, StickerFieldsModel.class);
                return (ImmutableList) this.f16559d;
            }

            public final int jK_() {
                return -795239780;
            }

            public final GraphQLVisitableModel m24208a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m24206a() != null) {
                    Builder a = ModelHelper.a(m24206a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (TaggedStickersModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f16559d = a.b();
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m24207a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m24206a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        public FetchTrayTaggedStickersQueryModel() {
            super(2);
        }

        public final void m24213a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m24214a(String str, Object obj, boolean z) {
        }

        @Nullable
        private GraphQLObjectType m24209a() {
            if (this.b != null && this.f16560d == null) {
                this.f16560d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
            }
            return this.f16560d;
        }

        @Nullable
        private TaggedStickersModel m24210j() {
            this.f16561e = (TaggedStickersModel) super.a(this.f16561e, 1, TaggedStickersModel.class);
            return this.f16561e;
        }

        public final int jK_() {
            return 2433570;
        }

        public final GraphQLVisitableModel m24212a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m24210j() != null) {
                TaggedStickersModel taggedStickersModel = (TaggedStickersModel) graphQLModelMutatingVisitor.b(m24210j());
                if (m24210j() != taggedStickersModel) {
                    graphQLVisitableModel = (FetchTrayTaggedStickersQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f16561e = taggedStickersModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m24211a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m24209a());
            int a2 = ModelHelper.a(flatBufferBuilder, m24210j());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 2077239888)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: eec361561d51e5375e5cdb0a1a0c05da */
    public final class FetchTrayTaggedStickersWithPreviewsQueryModel extends BaseModel implements GraphQLVisitableConsistentModel {
        @Nullable
        private GraphQLObjectType f16568d;
        @Nullable
        private TaggedStickersModel f16569e;

        /* compiled from: eec361561d51e5375e5cdb0a1a0c05da */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FetchTrayTaggedStickersWithPreviewsQueryModel.class, new Deserializer());
            }

            public Object m24215a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = FetchTrayTaggedStickersWithPreviewsQueryParser.m24426a(jsonParser);
                Object fetchTrayTaggedStickersWithPreviewsQueryModel = new FetchTrayTaggedStickersWithPreviewsQueryModel();
                ((BaseModel) fetchTrayTaggedStickersWithPreviewsQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (fetchTrayTaggedStickersWithPreviewsQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) fetchTrayTaggedStickersWithPreviewsQueryModel).a();
                }
                return fetchTrayTaggedStickersWithPreviewsQueryModel;
            }
        }

        /* compiled from: eec361561d51e5375e5cdb0a1a0c05da */
        public class Serializer extends JsonSerializer<FetchTrayTaggedStickersWithPreviewsQueryModel> {
            public final void m24216a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                FetchTrayTaggedStickersWithPreviewsQueryModel fetchTrayTaggedStickersWithPreviewsQueryModel = (FetchTrayTaggedStickersWithPreviewsQueryModel) obj;
                if (fetchTrayTaggedStickersWithPreviewsQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(fetchTrayTaggedStickersWithPreviewsQueryModel.m24234a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    fetchTrayTaggedStickersWithPreviewsQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = fetchTrayTaggedStickersWithPreviewsQueryModel.w_();
                int u_ = fetchTrayTaggedStickersWithPreviewsQueryModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("__type__");
                    SerializerHelpers.b(mutableFlatBuffer, u_, 0, jsonGenerator);
                }
                int g = mutableFlatBuffer.g(u_, 1);
                if (g != 0) {
                    jsonGenerator.a("tagged_stickers");
                    FetchTrayTaggedStickersWithPreviewsQueryParser.TaggedStickersParser.m24425a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(FetchTrayTaggedStickersWithPreviewsQueryModel.class, new Serializer());
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1213145072)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: eec361561d51e5375e5cdb0a1a0c05da */
        public final class TaggedStickersModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<NodesModel> f16567d;

            /* compiled from: eec361561d51e5375e5cdb0a1a0c05da */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(TaggedStickersModel.class, new Deserializer());
                }

                public Object m24217a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(FetchTrayTaggedStickersWithPreviewsQueryParser.TaggedStickersParser.m24424a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object taggedStickersModel = new TaggedStickersModel();
                    ((BaseModel) taggedStickersModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (taggedStickersModel instanceof Postprocessable) {
                        return ((Postprocessable) taggedStickersModel).a();
                    }
                    return taggedStickersModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 75791716)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: eec361561d51e5375e5cdb0a1a0c05da */
            public final class NodesModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
                @Nullable
                private AnimatedImageModel f16562d;
                @Nullable
                private String f16563e;
                @Nullable
                private PackModel f16564f;
                @Nullable
                private PreviewImageModel f16565g;
                @Nullable
                private ThreadImageModel f16566h;

                /* compiled from: eec361561d51e5375e5cdb0a1a0c05da */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(NodesModel.class, new Deserializer());
                    }

                    public Object m24218a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(FetchTrayTaggedStickersWithPreviewsQueryParser.TaggedStickersParser.NodesParser.m24422b(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object nodesModel = new NodesModel();
                        ((BaseModel) nodesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (nodesModel instanceof Postprocessable) {
                            return ((Postprocessable) nodesModel).a();
                        }
                        return nodesModel;
                    }
                }

                /* compiled from: eec361561d51e5375e5cdb0a1a0c05da */
                public class Serializer extends JsonSerializer<NodesModel> {
                    public final void m24219a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        NodesModel nodesModel = (NodesModel) obj;
                        if (nodesModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(nodesModel.m24225a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            nodesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        FetchTrayTaggedStickersWithPreviewsQueryParser.TaggedStickersParser.NodesParser.m24423b(nodesModel.w_(), nodesModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(NodesModel.class, new Serializer());
                    }
                }

                public NodesModel() {
                    super(5);
                }

                @Nullable
                private AnimatedImageModel m24220j() {
                    this.f16562d = (AnimatedImageModel) super.a(this.f16562d, 0, AnimatedImageModel.class);
                    return this.f16562d;
                }

                @Nullable
                private String m24221k() {
                    this.f16563e = super.a(this.f16563e, 1);
                    return this.f16563e;
                }

                @Nullable
                private PackModel m24222l() {
                    this.f16564f = (PackModel) super.a(this.f16564f, 2, PackModel.class);
                    return this.f16564f;
                }

                @Nullable
                private PreviewImageModel m24223m() {
                    this.f16565g = (PreviewImageModel) super.a(this.f16565g, 3, PreviewImageModel.class);
                    return this.f16565g;
                }

                @Nullable
                private ThreadImageModel m24224n() {
                    this.f16566h = (ThreadImageModel) super.a(this.f16566h, 4, ThreadImageModel.class);
                    return this.f16566h;
                }

                @Nullable
                public final String m24227a() {
                    return m24221k();
                }

                public final int jK_() {
                    return -225599203;
                }

                public final GraphQLVisitableModel m24226a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m24220j() != null) {
                        AnimatedImageModel animatedImageModel = (AnimatedImageModel) graphQLModelMutatingVisitor.b(m24220j());
                        if (m24220j() != animatedImageModel) {
                            graphQLVisitableModel = (NodesModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f16562d = animatedImageModel;
                        }
                    }
                    if (m24222l() != null) {
                        PackModel packModel = (PackModel) graphQLModelMutatingVisitor.b(m24222l());
                        if (m24222l() != packModel) {
                            graphQLVisitableModel = (NodesModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f16564f = packModel;
                        }
                    }
                    if (m24223m() != null) {
                        PreviewImageModel previewImageModel = (PreviewImageModel) graphQLModelMutatingVisitor.b(m24223m());
                        if (m24223m() != previewImageModel) {
                            graphQLVisitableModel = (NodesModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f16565g = previewImageModel;
                        }
                    }
                    if (m24224n() != null) {
                        ThreadImageModel threadImageModel = (ThreadImageModel) graphQLModelMutatingVisitor.b(m24224n());
                        if (m24224n() != threadImageModel) {
                            graphQLVisitableModel = (NodesModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f16566h = threadImageModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m24225a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m24220j());
                    int b = flatBufferBuilder.b(m24221k());
                    int a2 = ModelHelper.a(flatBufferBuilder, m24222l());
                    int a3 = ModelHelper.a(flatBufferBuilder, m24223m());
                    int a4 = ModelHelper.a(flatBufferBuilder, m24224n());
                    flatBufferBuilder.c(5);
                    flatBufferBuilder.b(0, a);
                    flatBufferBuilder.b(1, b);
                    flatBufferBuilder.b(2, a2);
                    flatBufferBuilder.b(3, a3);
                    flatBufferBuilder.b(4, a4);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: eec361561d51e5375e5cdb0a1a0c05da */
            public class Serializer extends JsonSerializer<TaggedStickersModel> {
                public final void m24228a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    TaggedStickersModel taggedStickersModel = (TaggedStickersModel) obj;
                    if (taggedStickersModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(taggedStickersModel.m24230a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        taggedStickersModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    FetchTrayTaggedStickersWithPreviewsQueryParser.TaggedStickersParser.m24425a(taggedStickersModel.w_(), taggedStickersModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(TaggedStickersModel.class, new Serializer());
                }
            }

            public TaggedStickersModel() {
                super(1);
            }

            @Nonnull
            private ImmutableList<NodesModel> m24229a() {
                this.f16567d = super.a(this.f16567d, 0, NodesModel.class);
                return (ImmutableList) this.f16567d;
            }

            public final int jK_() {
                return -795239780;
            }

            public final GraphQLVisitableModel m24231a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m24229a() != null) {
                    Builder a = ModelHelper.a(m24229a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (TaggedStickersModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f16567d = a.b();
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m24230a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m24229a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        public FetchTrayTaggedStickersWithPreviewsQueryModel() {
            super(2);
        }

        public final void m24236a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m24237a(String str, Object obj, boolean z) {
        }

        @Nullable
        private GraphQLObjectType m24232a() {
            if (this.b != null && this.f16568d == null) {
                this.f16568d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
            }
            return this.f16568d;
        }

        @Nullable
        private TaggedStickersModel m24233j() {
            this.f16569e = (TaggedStickersModel) super.a(this.f16569e, 1, TaggedStickersModel.class);
            return this.f16569e;
        }

        public final int jK_() {
            return 2433570;
        }

        public final GraphQLVisitableModel m24235a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m24233j() != null) {
                TaggedStickersModel taggedStickersModel = (TaggedStickersModel) graphQLModelMutatingVisitor.b(m24233j());
                if (m24233j() != taggedStickersModel) {
                    graphQLVisitableModel = (FetchTrayTaggedStickersWithPreviewsQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f16569e = taggedStickersModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m24234a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m24232a());
            int a2 = ModelHelper.a(flatBufferBuilder, m24233j());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -929948044)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: eec361561d51e5375e5cdb0a1a0c05da */
    public final class PreviewFieldsModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private PreviewImageModel f16571d;

        /* compiled from: eec361561d51e5375e5cdb0a1a0c05da */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(PreviewFieldsModel.class, new Deserializer());
            }

            public Object m24238a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = PreviewFieldsParser.m24429a(jsonParser);
                Object previewFieldsModel = new PreviewFieldsModel();
                ((BaseModel) previewFieldsModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (previewFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) previewFieldsModel).a();
                }
                return previewFieldsModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 842551240)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: eec361561d51e5375e5cdb0a1a0c05da */
        public final class PreviewImageModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private String f16570d;

            /* compiled from: eec361561d51e5375e5cdb0a1a0c05da */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(PreviewImageModel.class, new Deserializer());
                }

                public Object m24239a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(PreviewImageParser.m24427a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object previewImageModel = new PreviewImageModel();
                    ((BaseModel) previewImageModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (previewImageModel instanceof Postprocessable) {
                        return ((Postprocessable) previewImageModel).a();
                    }
                    return previewImageModel;
                }
            }

            /* compiled from: eec361561d51e5375e5cdb0a1a0c05da */
            public class Serializer extends JsonSerializer<PreviewImageModel> {
                public final void m24240a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    PreviewImageModel previewImageModel = (PreviewImageModel) obj;
                    if (previewImageModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(previewImageModel.m24242a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        previewImageModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    PreviewImageParser.m24428a(previewImageModel.w_(), previewImageModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(PreviewImageModel.class, new Serializer());
                }
            }

            public PreviewImageModel() {
                super(1);
            }

            @Nullable
            private String m24241a() {
                this.f16570d = super.a(this.f16570d, 0);
                return this.f16570d;
            }

            public final int jK_() {
                return 70760763;
            }

            public final GraphQLVisitableModel m24243a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m24242a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m24241a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: eec361561d51e5375e5cdb0a1a0c05da */
        public class Serializer extends JsonSerializer<PreviewFieldsModel> {
            public final void m24244a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                PreviewFieldsModel previewFieldsModel = (PreviewFieldsModel) obj;
                if (previewFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(previewFieldsModel.m24246a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    previewFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = previewFieldsModel.w_();
                int u_ = previewFieldsModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("preview_image");
                    PreviewImageParser.m24428a(mutableFlatBuffer, g, jsonGenerator);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(PreviewFieldsModel.class, new Serializer());
            }
        }

        public PreviewFieldsModel() {
            super(1);
        }

        @Nullable
        private PreviewImageModel m24245a() {
            this.f16571d = (PreviewImageModel) super.a(this.f16571d, 0, PreviewImageModel.class);
            return this.f16571d;
        }

        public final int jK_() {
            return -225599203;
        }

        public final GraphQLVisitableModel m24247a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m24245a() != null) {
                PreviewImageModel previewImageModel = (PreviewImageModel) graphQLModelMutatingVisitor.b(m24245a());
                if (m24245a() != previewImageModel) {
                    graphQLVisitableModel = (PreviewFieldsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f16571d = previewImageModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m24246a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m24245a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 316390632)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: eec361561d51e5375e5cdb0a1a0c05da */
    public final class SearchTaggedStickersQueryModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private StickerResultsModel f16573d;

        /* compiled from: eec361561d51e5375e5cdb0a1a0c05da */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(SearchTaggedStickersQueryModel.class, new Deserializer());
            }

            public Object m24248a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = SearchTaggedStickersQueryParser.m24432a(jsonParser);
                Object searchTaggedStickersQueryModel = new SearchTaggedStickersQueryModel();
                ((BaseModel) searchTaggedStickersQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (searchTaggedStickersQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) searchTaggedStickersQueryModel).a();
                }
                return searchTaggedStickersQueryModel;
            }
        }

        /* compiled from: eec361561d51e5375e5cdb0a1a0c05da */
        public class Serializer extends JsonSerializer<SearchTaggedStickersQueryModel> {
            public final void m24249a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                SearchTaggedStickersQueryModel searchTaggedStickersQueryModel = (SearchTaggedStickersQueryModel) obj;
                if (searchTaggedStickersQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(searchTaggedStickersQueryModel.m24256a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    searchTaggedStickersQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = searchTaggedStickersQueryModel.w_();
                int u_ = searchTaggedStickersQueryModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("sticker_results");
                    StickerResultsParser.m24431a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(SearchTaggedStickersQueryModel.class, new Serializer());
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -48884331)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: eec361561d51e5375e5cdb0a1a0c05da */
        public final class StickerResultsModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<StickerFieldsModel> f16572d;

            /* compiled from: eec361561d51e5375e5cdb0a1a0c05da */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(StickerResultsModel.class, new Deserializer());
                }

                public Object m24250a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(StickerResultsParser.m24430a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object stickerResultsModel = new StickerResultsModel();
                    ((BaseModel) stickerResultsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (stickerResultsModel instanceof Postprocessable) {
                        return ((Postprocessable) stickerResultsModel).a();
                    }
                    return stickerResultsModel;
                }
            }

            /* compiled from: eec361561d51e5375e5cdb0a1a0c05da */
            public class Serializer extends JsonSerializer<StickerResultsModel> {
                public final void m24251a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    StickerResultsModel stickerResultsModel = (StickerResultsModel) obj;
                    if (stickerResultsModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(stickerResultsModel.m24253a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        stickerResultsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    StickerResultsParser.m24431a(stickerResultsModel.w_(), stickerResultsModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(StickerResultsModel.class, new Serializer());
                }
            }

            public StickerResultsModel() {
                super(1);
            }

            @Nonnull
            private ImmutableList<StickerFieldsModel> m24252a() {
                this.f16572d = super.a(this.f16572d, 0, StickerFieldsModel.class);
                return (ImmutableList) this.f16572d;
            }

            public final int jK_() {
                return 719044815;
            }

            public final GraphQLVisitableModel m24254a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m24252a() != null) {
                    Builder a = ModelHelper.a(m24252a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (StickerResultsModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f16572d = a.b();
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m24253a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m24252a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        public SearchTaggedStickersQueryModel() {
            super(1);
        }

        @Nullable
        private StickerResultsModel m24255a() {
            this.f16573d = (StickerResultsModel) super.a(this.f16573d, 0, StickerResultsModel.class);
            return this.f16573d;
        }

        public final int jK_() {
            return -1108070749;
        }

        public final GraphQLVisitableModel m24257a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m24255a() != null) {
                StickerResultsModel stickerResultsModel = (StickerResultsModel) graphQLModelMutatingVisitor.b(m24255a());
                if (m24255a() != stickerResultsModel) {
                    graphQLVisitableModel = (SearchTaggedStickersQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f16573d = stickerResultsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m24256a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m24255a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -274504651)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: eec361561d51e5375e5cdb0a1a0c05da */
    public final class SearchTaggedStickersWithPreviewsQueryModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private StickerResultsModel f16580d;

        /* compiled from: eec361561d51e5375e5cdb0a1a0c05da */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(SearchTaggedStickersWithPreviewsQueryModel.class, new Deserializer());
            }

            public Object m24258a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = SearchTaggedStickersWithPreviewsQueryParser.m24437a(jsonParser);
                Object searchTaggedStickersWithPreviewsQueryModel = new SearchTaggedStickersWithPreviewsQueryModel();
                ((BaseModel) searchTaggedStickersWithPreviewsQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (searchTaggedStickersWithPreviewsQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) searchTaggedStickersWithPreviewsQueryModel).a();
                }
                return searchTaggedStickersWithPreviewsQueryModel;
            }
        }

        /* compiled from: eec361561d51e5375e5cdb0a1a0c05da */
        public class Serializer extends JsonSerializer<SearchTaggedStickersWithPreviewsQueryModel> {
            public final void m24259a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                SearchTaggedStickersWithPreviewsQueryModel searchTaggedStickersWithPreviewsQueryModel = (SearchTaggedStickersWithPreviewsQueryModel) obj;
                if (searchTaggedStickersWithPreviewsQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(searchTaggedStickersWithPreviewsQueryModel.m24276a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    searchTaggedStickersWithPreviewsQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = searchTaggedStickersWithPreviewsQueryModel.w_();
                int u_ = searchTaggedStickersWithPreviewsQueryModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("sticker_results");
                    SearchTaggedStickersWithPreviewsQueryParser.StickerResultsParser.m24436a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(SearchTaggedStickersWithPreviewsQueryModel.class, new Serializer());
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1626188952)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: eec361561d51e5375e5cdb0a1a0c05da */
        public final class StickerResultsModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<NodesModel> f16579d;

            /* compiled from: eec361561d51e5375e5cdb0a1a0c05da */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(StickerResultsModel.class, new Deserializer());
                }

                public Object m24260a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(SearchTaggedStickersWithPreviewsQueryParser.StickerResultsParser.m24435a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object stickerResultsModel = new StickerResultsModel();
                    ((BaseModel) stickerResultsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (stickerResultsModel instanceof Postprocessable) {
                        return ((Postprocessable) stickerResultsModel).a();
                    }
                    return stickerResultsModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 75791716)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: eec361561d51e5375e5cdb0a1a0c05da */
            public final class NodesModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
                @Nullable
                private AnimatedImageModel f16574d;
                @Nullable
                private String f16575e;
                @Nullable
                private PackModel f16576f;
                @Nullable
                private PreviewImageModel f16577g;
                @Nullable
                private ThreadImageModel f16578h;

                /* compiled from: eec361561d51e5375e5cdb0a1a0c05da */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(NodesModel.class, new Deserializer());
                    }

                    public Object m24261a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(SearchTaggedStickersWithPreviewsQueryParser.StickerResultsParser.NodesParser.m24433b(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object nodesModel = new NodesModel();
                        ((BaseModel) nodesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (nodesModel instanceof Postprocessable) {
                            return ((Postprocessable) nodesModel).a();
                        }
                        return nodesModel;
                    }
                }

                /* compiled from: eec361561d51e5375e5cdb0a1a0c05da */
                public class Serializer extends JsonSerializer<NodesModel> {
                    public final void m24262a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        NodesModel nodesModel = (NodesModel) obj;
                        if (nodesModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(nodesModel.m24268a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            nodesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        SearchTaggedStickersWithPreviewsQueryParser.StickerResultsParser.NodesParser.m24434b(nodesModel.w_(), nodesModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(NodesModel.class, new Serializer());
                    }
                }

                public NodesModel() {
                    super(5);
                }

                @Nullable
                private AnimatedImageModel m24263j() {
                    this.f16574d = (AnimatedImageModel) super.a(this.f16574d, 0, AnimatedImageModel.class);
                    return this.f16574d;
                }

                @Nullable
                private String m24264k() {
                    this.f16575e = super.a(this.f16575e, 1);
                    return this.f16575e;
                }

                @Nullable
                private PackModel m24265l() {
                    this.f16576f = (PackModel) super.a(this.f16576f, 2, PackModel.class);
                    return this.f16576f;
                }

                @Nullable
                private PreviewImageModel m24266m() {
                    this.f16577g = (PreviewImageModel) super.a(this.f16577g, 3, PreviewImageModel.class);
                    return this.f16577g;
                }

                @Nullable
                private ThreadImageModel m24267n() {
                    this.f16578h = (ThreadImageModel) super.a(this.f16578h, 4, ThreadImageModel.class);
                    return this.f16578h;
                }

                @Nullable
                public final String m24270a() {
                    return m24264k();
                }

                public final int jK_() {
                    return -225599203;
                }

                public final GraphQLVisitableModel m24269a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m24263j() != null) {
                        AnimatedImageModel animatedImageModel = (AnimatedImageModel) graphQLModelMutatingVisitor.b(m24263j());
                        if (m24263j() != animatedImageModel) {
                            graphQLVisitableModel = (NodesModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f16574d = animatedImageModel;
                        }
                    }
                    if (m24265l() != null) {
                        PackModel packModel = (PackModel) graphQLModelMutatingVisitor.b(m24265l());
                        if (m24265l() != packModel) {
                            graphQLVisitableModel = (NodesModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f16576f = packModel;
                        }
                    }
                    if (m24266m() != null) {
                        PreviewImageModel previewImageModel = (PreviewImageModel) graphQLModelMutatingVisitor.b(m24266m());
                        if (m24266m() != previewImageModel) {
                            graphQLVisitableModel = (NodesModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f16577g = previewImageModel;
                        }
                    }
                    if (m24267n() != null) {
                        ThreadImageModel threadImageModel = (ThreadImageModel) graphQLModelMutatingVisitor.b(m24267n());
                        if (m24267n() != threadImageModel) {
                            graphQLVisitableModel = (NodesModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f16578h = threadImageModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m24268a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m24263j());
                    int b = flatBufferBuilder.b(m24264k());
                    int a2 = ModelHelper.a(flatBufferBuilder, m24265l());
                    int a3 = ModelHelper.a(flatBufferBuilder, m24266m());
                    int a4 = ModelHelper.a(flatBufferBuilder, m24267n());
                    flatBufferBuilder.c(5);
                    flatBufferBuilder.b(0, a);
                    flatBufferBuilder.b(1, b);
                    flatBufferBuilder.b(2, a2);
                    flatBufferBuilder.b(3, a3);
                    flatBufferBuilder.b(4, a4);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: eec361561d51e5375e5cdb0a1a0c05da */
            public class Serializer extends JsonSerializer<StickerResultsModel> {
                public final void m24271a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    StickerResultsModel stickerResultsModel = (StickerResultsModel) obj;
                    if (stickerResultsModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(stickerResultsModel.m24273a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        stickerResultsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    SearchTaggedStickersWithPreviewsQueryParser.StickerResultsParser.m24436a(stickerResultsModel.w_(), stickerResultsModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(StickerResultsModel.class, new Serializer());
                }
            }

            public StickerResultsModel() {
                super(1);
            }

            @Nonnull
            private ImmutableList<NodesModel> m24272a() {
                this.f16579d = super.a(this.f16579d, 0, NodesModel.class);
                return (ImmutableList) this.f16579d;
            }

            public final int jK_() {
                return 719044815;
            }

            public final GraphQLVisitableModel m24274a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m24272a() != null) {
                    Builder a = ModelHelper.a(m24272a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (StickerResultsModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f16579d = a.b();
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m24273a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m24272a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        public SearchTaggedStickersWithPreviewsQueryModel() {
            super(1);
        }

        @Nullable
        private StickerResultsModel m24275a() {
            this.f16580d = (StickerResultsModel) super.a(this.f16580d, 0, StickerResultsModel.class);
            return this.f16580d;
        }

        public final int jK_() {
            return -1108070749;
        }

        public final GraphQLVisitableModel m24277a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m24275a() != null) {
                StickerResultsModel stickerResultsModel = (StickerResultsModel) graphQLModelMutatingVisitor.b(m24275a());
                if (m24275a() != stickerResultsModel) {
                    graphQLVisitableModel = (SearchTaggedStickersWithPreviewsQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f16580d = stickerResultsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m24276a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m24275a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1935203464)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: eec361561d51e5375e5cdb0a1a0c05da */
    public final class StickerFieldsModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
        @Nullable
        private AnimatedImageModel f16588d;
        @Nullable
        private String f16589e;
        @Nullable
        private PackModel f16590f;
        @Nullable
        private ThreadImageModel f16591g;

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 842551240)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: eec361561d51e5375e5cdb0a1a0c05da */
        public final class AnimatedImageModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private String f16581d;

            /* compiled from: eec361561d51e5375e5cdb0a1a0c05da */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(AnimatedImageModel.class, new Deserializer());
                }

                public Object m24278a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(AnimatedImageParser.m24438a(jsonParser, flatBufferBuilder));
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

            /* compiled from: eec361561d51e5375e5cdb0a1a0c05da */
            public class Serializer extends JsonSerializer<AnimatedImageModel> {
                public final void m24279a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    AnimatedImageModel animatedImageModel = (AnimatedImageModel) obj;
                    if (animatedImageModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(animatedImageModel.m24281a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        animatedImageModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    AnimatedImageParser.m24439a(animatedImageModel.w_(), animatedImageModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(AnimatedImageModel.class, new Serializer());
                }
            }

            public AnimatedImageModel() {
                super(1);
            }

            @Nullable
            private String m24280a() {
                this.f16581d = super.a(this.f16581d, 0);
                return this.f16581d;
            }

            public final int jK_() {
                return 70760763;
            }

            public final GraphQLVisitableModel m24282a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m24281a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m24280a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: eec361561d51e5375e5cdb0a1a0c05da */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(StickerFieldsModel.class, new Deserializer());
            }

            public Object m24283a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(StickerFieldsParser.m24446b(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object stickerFieldsModel = new StickerFieldsModel();
                ((BaseModel) stickerFieldsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (stickerFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) stickerFieldsModel).a();
                }
                return stickerFieldsModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1362061109)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: eec361561d51e5375e5cdb0a1a0c05da */
        public final class PackModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
            @Nullable
            private String f16582d;
            private boolean f16583e;
            private boolean f16584f;
            private boolean f16585g;
            private boolean f16586h;

            /* compiled from: eec361561d51e5375e5cdb0a1a0c05da */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(PackModel.class, new Deserializer());
                }

                public Object m24284a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(PackParser.m24440a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object packModel = new PackModel();
                    ((BaseModel) packModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (packModel instanceof Postprocessable) {
                        return ((Postprocessable) packModel).a();
                    }
                    return packModel;
                }
            }

            /* compiled from: eec361561d51e5375e5cdb0a1a0c05da */
            public class Serializer extends JsonSerializer<PackModel> {
                public final void m24285a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    PackModel packModel = (PackModel) obj;
                    if (packModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(packModel.m24287a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        packModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    PackParser.m24441a(packModel.w_(), packModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(PackModel.class, new Serializer());
                }
            }

            public PackModel() {
                super(5);
            }

            @Nullable
            private String m24286j() {
                this.f16582d = super.a(this.f16582d, 0);
                return this.f16582d;
            }

            @Nullable
            public final String m24289a() {
                return m24286j();
            }

            public final int jK_() {
                return -1030512426;
            }

            public final GraphQLVisitableModel m24288a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m24287a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m24286j());
                flatBufferBuilder.c(5);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.a(1, this.f16583e);
                flatBufferBuilder.a(2, this.f16584f);
                flatBufferBuilder.a(3, this.f16585g);
                flatBufferBuilder.a(4, this.f16586h);
                i();
                return flatBufferBuilder.d();
            }

            public final void m24290a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f16583e = mutableFlatBuffer.a(i, 1);
                this.f16584f = mutableFlatBuffer.a(i, 2);
                this.f16585g = mutableFlatBuffer.a(i, 3);
                this.f16586h = mutableFlatBuffer.a(i, 4);
            }
        }

        /* compiled from: eec361561d51e5375e5cdb0a1a0c05da */
        public class Serializer extends JsonSerializer<StickerFieldsModel> {
            public final void m24291a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                StickerFieldsModel stickerFieldsModel = (StickerFieldsModel) obj;
                if (stickerFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(stickerFieldsModel.m24301a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    stickerFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                StickerFieldsParser.m24447b(stickerFieldsModel.w_(), stickerFieldsModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(StickerFieldsModel.class, new Serializer());
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 842551240)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: eec361561d51e5375e5cdb0a1a0c05da */
        public final class ThreadImageModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private String f16587d;

            /* compiled from: eec361561d51e5375e5cdb0a1a0c05da */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(ThreadImageModel.class, new Deserializer());
                }

                public Object m24292a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(ThreadImageParser.m24442a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object threadImageModel = new ThreadImageModel();
                    ((BaseModel) threadImageModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (threadImageModel instanceof Postprocessable) {
                        return ((Postprocessable) threadImageModel).a();
                    }
                    return threadImageModel;
                }
            }

            /* compiled from: eec361561d51e5375e5cdb0a1a0c05da */
            public class Serializer extends JsonSerializer<ThreadImageModel> {
                public final void m24293a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    ThreadImageModel threadImageModel = (ThreadImageModel) obj;
                    if (threadImageModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(threadImageModel.m24295a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        threadImageModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    ThreadImageParser.m24443a(threadImageModel.w_(), threadImageModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(ThreadImageModel.class, new Serializer());
                }
            }

            public ThreadImageModel() {
                super(1);
            }

            @Nullable
            private String m24294a() {
                this.f16587d = super.a(this.f16587d, 0);
                return this.f16587d;
            }

            public final int jK_() {
                return 70760763;
            }

            public final GraphQLVisitableModel m24296a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m24295a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m24294a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        public StickerFieldsModel() {
            super(4);
        }

        @Nullable
        private AnimatedImageModel m24297j() {
            this.f16588d = (AnimatedImageModel) super.a(this.f16588d, 0, AnimatedImageModel.class);
            return this.f16588d;
        }

        @Nullable
        private String m24298k() {
            this.f16589e = super.a(this.f16589e, 1);
            return this.f16589e;
        }

        @Nullable
        private PackModel m24299l() {
            this.f16590f = (PackModel) super.a(this.f16590f, 2, PackModel.class);
            return this.f16590f;
        }

        @Nullable
        private ThreadImageModel m24300m() {
            this.f16591g = (ThreadImageModel) super.a(this.f16591g, 3, ThreadImageModel.class);
            return this.f16591g;
        }

        @Nullable
        public final String m24303a() {
            return m24298k();
        }

        public final int jK_() {
            return -225599203;
        }

        public final GraphQLVisitableModel m24302a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m24297j() != null) {
                AnimatedImageModel animatedImageModel = (AnimatedImageModel) graphQLModelMutatingVisitor.b(m24297j());
                if (m24297j() != animatedImageModel) {
                    graphQLVisitableModel = (StickerFieldsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f16588d = animatedImageModel;
                }
            }
            if (m24299l() != null) {
                PackModel packModel = (PackModel) graphQLModelMutatingVisitor.b(m24299l());
                if (m24299l() != packModel) {
                    graphQLVisitableModel = (StickerFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f16590f = packModel;
                }
            }
            if (m24300m() != null) {
                ThreadImageModel threadImageModel = (ThreadImageModel) graphQLModelMutatingVisitor.b(m24300m());
                if (m24300m() != threadImageModel) {
                    graphQLVisitableModel = (StickerFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f16591g = threadImageModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m24301a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m24297j());
            int b = flatBufferBuilder.b(m24298k());
            int a2 = ModelHelper.a(flatBufferBuilder, m24299l());
            int a3 = ModelHelper.a(flatBufferBuilder, m24300m());
            flatBufferBuilder.c(4);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, b);
            flatBufferBuilder.b(2, a2);
            flatBufferBuilder.b(3, a3);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -2048467055)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: eec361561d51e5375e5cdb0a1a0c05da */
    public final class StickerPackFieldsModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
        @Nullable
        private String f16598d;
        private boolean f16599e;
        @Nullable
        private List<String> f16600f;
        @Nullable
        private String f16601g;
        @Nullable
        private String f16602h;
        private boolean f16603i;
        private boolean f16604j;
        private boolean f16605k;
        private boolean f16606l;
        private boolean f16607m;
        private boolean f16608n;
        private boolean f16609o;
        private boolean f16610p;
        private boolean f16611q;
        @Nullable
        private String f16612r;
        @Nullable
        private PreviewImageModel f16613s;
        private int f16614t;
        @Nullable
        private StickersModel f16615u;
        @Nullable
        private ThumbnailImageModel f16616v;
        @Nullable
        private TrayButtonModel f16617w;
        private long f16618x;

        /* compiled from: eec361561d51e5375e5cdb0a1a0c05da */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(StickerPackFieldsModel.class, new Deserializer());
            }

            public Object m24304a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(StickerPackFieldsParser.m24462b(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object stickerPackFieldsModel = new StickerPackFieldsModel();
                ((BaseModel) stickerPackFieldsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (stickerPackFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) stickerPackFieldsModel).a();
                }
                return stickerPackFieldsModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 842551240)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: eec361561d51e5375e5cdb0a1a0c05da */
        public final class PreviewImageModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private String f16592d;

            /* compiled from: eec361561d51e5375e5cdb0a1a0c05da */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(PreviewImageModel.class, new Deserializer());
                }

                public Object m24305a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(StickerPackFieldsParser.PreviewImageParser.m24448a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object previewImageModel = new PreviewImageModel();
                    ((BaseModel) previewImageModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (previewImageModel instanceof Postprocessable) {
                        return ((Postprocessable) previewImageModel).a();
                    }
                    return previewImageModel;
                }
            }

            /* compiled from: eec361561d51e5375e5cdb0a1a0c05da */
            public class Serializer extends JsonSerializer<PreviewImageModel> {
                public final void m24306a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    PreviewImageModel previewImageModel = (PreviewImageModel) obj;
                    if (previewImageModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(previewImageModel.m24308a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        previewImageModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    StickerPackFieldsParser.PreviewImageParser.m24449a(previewImageModel.w_(), previewImageModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(PreviewImageModel.class, new Serializer());
                }
            }

            public PreviewImageModel() {
                super(1);
            }

            @Nullable
            private String m24307a() {
                this.f16592d = super.a(this.f16592d, 0);
                return this.f16592d;
            }

            public final int jK_() {
                return 70760763;
            }

            public final GraphQLVisitableModel m24309a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m24308a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m24307a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: eec361561d51e5375e5cdb0a1a0c05da */
        public class Serializer extends JsonSerializer<StickerPackFieldsModel> {
            public final void m24310a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                StickerPackFieldsModel stickerPackFieldsModel = (StickerPackFieldsModel) obj;
                if (stickerPackFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(stickerPackFieldsModel.m24346a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    stickerPackFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                StickerPackFieldsParser.m24463b(stickerPackFieldsModel.w_(), stickerPackFieldsModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(StickerPackFieldsModel.class, new Serializer());
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 160487734)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: eec361561d51e5375e5cdb0a1a0c05da */
        public final class StickersModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<NodesModel> f16594d;

            /* compiled from: eec361561d51e5375e5cdb0a1a0c05da */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(StickersModel.class, new Deserializer());
                }

                public Object m24311a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(StickersParser.m24452a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object stickersModel = new StickersModel();
                    ((BaseModel) stickersModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (stickersModel instanceof Postprocessable) {
                        return ((Postprocessable) stickersModel).a();
                    }
                    return stickersModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 1801334754)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: eec361561d51e5375e5cdb0a1a0c05da */
            public final class NodesModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
                @Nullable
                private String f16593d;

                /* compiled from: eec361561d51e5375e5cdb0a1a0c05da */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(NodesModel.class, new Deserializer());
                    }

                    public Object m24312a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(StickersParser.NodesParser.m24451b(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object nodesModel = new NodesModel();
                        ((BaseModel) nodesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (nodesModel instanceof Postprocessable) {
                            return ((Postprocessable) nodesModel).a();
                        }
                        return nodesModel;
                    }
                }

                /* compiled from: eec361561d51e5375e5cdb0a1a0c05da */
                public class Serializer extends JsonSerializer<NodesModel> {
                    public final void m24313a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        NodesModel nodesModel = (NodesModel) obj;
                        if (nodesModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(nodesModel.m24315a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            nodesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        StickersParser.NodesParser.m24450a(nodesModel.w_(), nodesModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(NodesModel.class, new Serializer());
                    }
                }

                public NodesModel() {
                    super(1);
                }

                @Nullable
                private String m24314j() {
                    this.f16593d = super.a(this.f16593d, 0);
                    return this.f16593d;
                }

                @Nullable
                public final String m24317a() {
                    return m24314j();
                }

                public final int jK_() {
                    return -225599203;
                }

                public final GraphQLVisitableModel m24316a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m24315a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int b = flatBufferBuilder.b(m24314j());
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, b);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: eec361561d51e5375e5cdb0a1a0c05da */
            public class Serializer extends JsonSerializer<StickersModel> {
                public final void m24318a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    StickersModel stickersModel = (StickersModel) obj;
                    if (stickersModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(stickersModel.m24320a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        stickersModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    StickersParser.m24453a(stickersModel.w_(), stickersModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(StickersModel.class, new Serializer());
                }
            }

            public StickersModel() {
                super(1);
            }

            @Nonnull
            private ImmutableList<NodesModel> m24319a() {
                this.f16594d = super.a(this.f16594d, 0, NodesModel.class);
                return (ImmutableList) this.f16594d;
            }

            public final int jK_() {
                return 2060599666;
            }

            public final GraphQLVisitableModel m24321a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m24319a() != null) {
                    Builder a = ModelHelper.a(m24319a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (StickersModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f16594d = a.b();
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m24320a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m24319a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 842551240)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: eec361561d51e5375e5cdb0a1a0c05da */
        public final class ThumbnailImageModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private String f16595d;

            /* compiled from: eec361561d51e5375e5cdb0a1a0c05da */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(ThumbnailImageModel.class, new Deserializer());
                }

                public Object m24322a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(StickerPackFieldsParser.ThumbnailImageParser.m24454a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object thumbnailImageModel = new ThumbnailImageModel();
                    ((BaseModel) thumbnailImageModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (thumbnailImageModel instanceof Postprocessable) {
                        return ((Postprocessable) thumbnailImageModel).a();
                    }
                    return thumbnailImageModel;
                }
            }

            /* compiled from: eec361561d51e5375e5cdb0a1a0c05da */
            public class Serializer extends JsonSerializer<ThumbnailImageModel> {
                public final void m24323a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    ThumbnailImageModel thumbnailImageModel = (ThumbnailImageModel) obj;
                    if (thumbnailImageModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(thumbnailImageModel.m24325a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        thumbnailImageModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    StickerPackFieldsParser.ThumbnailImageParser.m24455a(thumbnailImageModel.w_(), thumbnailImageModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(ThumbnailImageModel.class, new Serializer());
                }
            }

            public ThumbnailImageModel() {
                super(1);
            }

            @Nullable
            private String m24324a() {
                this.f16595d = super.a(this.f16595d, 0);
                return this.f16595d;
            }

            public final int jK_() {
                return 70760763;
            }

            public final GraphQLVisitableModel m24326a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m24325a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m24324a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 331577082)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: eec361561d51e5375e5cdb0a1a0c05da */
        public final class TrayButtonModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private NormalModel f16597d;

            /* compiled from: eec361561d51e5375e5cdb0a1a0c05da */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(TrayButtonModel.class, new Deserializer());
                }

                public Object m24327a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(TrayButtonParser.m24458a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object trayButtonModel = new TrayButtonModel();
                    ((BaseModel) trayButtonModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (trayButtonModel instanceof Postprocessable) {
                        return ((Postprocessable) trayButtonModel).a();
                    }
                    return trayButtonModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 842551240)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: eec361561d51e5375e5cdb0a1a0c05da */
            public final class NormalModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private String f16596d;

                /* compiled from: eec361561d51e5375e5cdb0a1a0c05da */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(NormalModel.class, new Deserializer());
                    }

                    public Object m24328a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(NormalParser.m24456a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object normalModel = new NormalModel();
                        ((BaseModel) normalModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (normalModel instanceof Postprocessable) {
                            return ((Postprocessable) normalModel).a();
                        }
                        return normalModel;
                    }
                }

                /* compiled from: eec361561d51e5375e5cdb0a1a0c05da */
                public class Serializer extends JsonSerializer<NormalModel> {
                    public final void m24329a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        NormalModel normalModel = (NormalModel) obj;
                        if (normalModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(normalModel.m24331a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            normalModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        NormalParser.m24457a(normalModel.w_(), normalModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(NormalModel.class, new Serializer());
                    }
                }

                public NormalModel() {
                    super(1);
                }

                @Nullable
                private String m24330a() {
                    this.f16596d = super.a(this.f16596d, 0);
                    return this.f16596d;
                }

                public final int jK_() {
                    return 70760763;
                }

                public final GraphQLVisitableModel m24332a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m24331a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int b = flatBufferBuilder.b(m24330a());
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, b);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: eec361561d51e5375e5cdb0a1a0c05da */
            public class Serializer extends JsonSerializer<TrayButtonModel> {
                public final void m24333a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    TrayButtonModel trayButtonModel = (TrayButtonModel) obj;
                    if (trayButtonModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(trayButtonModel.m24335a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        trayButtonModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    TrayButtonParser.m24459a(trayButtonModel.w_(), trayButtonModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(TrayButtonModel.class, new Serializer());
                }
            }

            public TrayButtonModel() {
                super(1);
            }

            @Nullable
            private NormalModel m24334a() {
                this.f16597d = (NormalModel) super.a(this.f16597d, 0, NormalModel.class);
                return this.f16597d;
            }

            public final int jK_() {
                return 1403080207;
            }

            public final GraphQLVisitableModel m24336a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m24334a() != null) {
                    NormalModel normalModel = (NormalModel) graphQLModelMutatingVisitor.b(m24334a());
                    if (m24334a() != normalModel) {
                        graphQLVisitableModel = (TrayButtonModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f16597d = normalModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m24335a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m24334a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        public StickerPackFieldsModel() {
            super(21);
        }

        @Nullable
        private String m24337j() {
            this.f16598d = super.a(this.f16598d, 0);
            return this.f16598d;
        }

        @Nonnull
        private ImmutableList<String> m24338k() {
            this.f16600f = super.a(this.f16600f, 2);
            return (ImmutableList) this.f16600f;
        }

        @Nullable
        private String m24339l() {
            this.f16601g = super.a(this.f16601g, 3);
            return this.f16601g;
        }

        @Nullable
        private String m24340m() {
            this.f16602h = super.a(this.f16602h, 4);
            return this.f16602h;
        }

        @Nullable
        private String m24341n() {
            this.f16612r = super.a(this.f16612r, 14);
            return this.f16612r;
        }

        @Nullable
        private PreviewImageModel m24342o() {
            this.f16613s = (PreviewImageModel) super.a(this.f16613s, 15, PreviewImageModel.class);
            return this.f16613s;
        }

        @Nullable
        private StickersModel m24343p() {
            this.f16615u = (StickersModel) super.a(this.f16615u, 17, StickersModel.class);
            return this.f16615u;
        }

        @Nullable
        private ThumbnailImageModel m24344q() {
            this.f16616v = (ThumbnailImageModel) super.a(this.f16616v, 18, ThumbnailImageModel.class);
            return this.f16616v;
        }

        @Nullable
        private TrayButtonModel m24345r() {
            this.f16617w = (TrayButtonModel) super.a(this.f16617w, 19, TrayButtonModel.class);
            return this.f16617w;
        }

        @Nullable
        public final String m24348a() {
            return m24340m();
        }

        public final int jK_() {
            return -1030512426;
        }

        public final GraphQLVisitableModel m24347a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m24342o() != null) {
                PreviewImageModel previewImageModel = (PreviewImageModel) graphQLModelMutatingVisitor.b(m24342o());
                if (m24342o() != previewImageModel) {
                    graphQLVisitableModel = (StickerPackFieldsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f16613s = previewImageModel;
                }
            }
            if (m24343p() != null) {
                StickersModel stickersModel = (StickersModel) graphQLModelMutatingVisitor.b(m24343p());
                if (m24343p() != stickersModel) {
                    graphQLVisitableModel = (StickerPackFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f16615u = stickersModel;
                }
            }
            if (m24344q() != null) {
                ThumbnailImageModel thumbnailImageModel = (ThumbnailImageModel) graphQLModelMutatingVisitor.b(m24344q());
                if (m24344q() != thumbnailImageModel) {
                    graphQLVisitableModel = (StickerPackFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f16616v = thumbnailImageModel;
                }
            }
            if (m24345r() != null) {
                TrayButtonModel trayButtonModel = (TrayButtonModel) graphQLModelMutatingVisitor.b(m24345r());
                if (m24345r() != trayButtonModel) {
                    graphQLVisitableModel = (StickerPackFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f16617w = trayButtonModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m24346a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m24337j());
            int c = flatBufferBuilder.c(m24338k());
            int b2 = flatBufferBuilder.b(m24339l());
            int b3 = flatBufferBuilder.b(m24340m());
            int b4 = flatBufferBuilder.b(m24341n());
            int a = ModelHelper.a(flatBufferBuilder, m24342o());
            int a2 = ModelHelper.a(flatBufferBuilder, m24343p());
            int a3 = ModelHelper.a(flatBufferBuilder, m24344q());
            int a4 = ModelHelper.a(flatBufferBuilder, m24345r());
            flatBufferBuilder.c(21);
            flatBufferBuilder.b(0, b);
            flatBufferBuilder.a(1, this.f16599e);
            flatBufferBuilder.b(2, c);
            flatBufferBuilder.b(3, b2);
            flatBufferBuilder.b(4, b3);
            flatBufferBuilder.a(5, this.f16603i);
            flatBufferBuilder.a(6, this.f16604j);
            flatBufferBuilder.a(7, this.f16605k);
            flatBufferBuilder.a(8, this.f16606l);
            flatBufferBuilder.a(9, this.f16607m);
            flatBufferBuilder.a(10, this.f16608n);
            flatBufferBuilder.a(11, this.f16609o);
            flatBufferBuilder.a(12, this.f16610p);
            flatBufferBuilder.a(13, this.f16611q);
            flatBufferBuilder.b(14, b4);
            flatBufferBuilder.b(15, a);
            flatBufferBuilder.a(16, this.f16614t, 0);
            flatBufferBuilder.b(17, a2);
            flatBufferBuilder.b(18, a3);
            flatBufferBuilder.b(19, a4);
            flatBufferBuilder.a(20, this.f16618x, 0);
            i();
            return flatBufferBuilder.d();
        }

        public final void m24349a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f16599e = mutableFlatBuffer.a(i, 1);
            this.f16603i = mutableFlatBuffer.a(i, 5);
            this.f16604j = mutableFlatBuffer.a(i, 6);
            this.f16605k = mutableFlatBuffer.a(i, 7);
            this.f16606l = mutableFlatBuffer.a(i, 8);
            this.f16607m = mutableFlatBuffer.a(i, 9);
            this.f16608n = mutableFlatBuffer.a(i, 10);
            this.f16609o = mutableFlatBuffer.a(i, 11);
            this.f16610p = mutableFlatBuffer.a(i, 12);
            this.f16611q = mutableFlatBuffer.a(i, 13);
            this.f16614t = mutableFlatBuffer.a(i, 16, 0);
            this.f16618x = mutableFlatBuffer.a(i, 20, 0);
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1964678136)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: eec361561d51e5375e5cdb0a1a0c05da */
    public final class StickerPackIdFieldsModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
        @Nullable
        private String f16619d;
        private boolean f16620e;
        private boolean f16621f;
        private long f16622g;
        private long f16623h;

        /* compiled from: eec361561d51e5375e5cdb0a1a0c05da */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(StickerPackIdFieldsModel.class, new Deserializer());
            }

            public Object m24350a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(StickerPackIdFieldsParser.m24467b(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object stickerPackIdFieldsModel = new StickerPackIdFieldsModel();
                ((BaseModel) stickerPackIdFieldsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (stickerPackIdFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) stickerPackIdFieldsModel).a();
                }
                return stickerPackIdFieldsModel;
            }
        }

        /* compiled from: eec361561d51e5375e5cdb0a1a0c05da */
        public class Serializer extends JsonSerializer<StickerPackIdFieldsModel> {
            public final void m24351a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                StickerPackIdFieldsModel stickerPackIdFieldsModel = (StickerPackIdFieldsModel) obj;
                if (stickerPackIdFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(stickerPackIdFieldsModel.m24353a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    stickerPackIdFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                StickerPackIdFieldsParser.m24465a(stickerPackIdFieldsModel.w_(), stickerPackIdFieldsModel.u_(), jsonGenerator);
            }

            static {
                FbSerializerProvider.a(StickerPackIdFieldsModel.class, new Serializer());
            }
        }

        public StickerPackIdFieldsModel() {
            super(5);
        }

        @Nullable
        private String m24352j() {
            this.f16619d = super.a(this.f16619d, 0);
            return this.f16619d;
        }

        @Nullable
        public final String m24355a() {
            return m24352j();
        }

        public final int jK_() {
            return -1030512426;
        }

        public final GraphQLVisitableModel m24354a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m24353a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m24352j());
            flatBufferBuilder.c(5);
            flatBufferBuilder.b(0, b);
            flatBufferBuilder.a(1, this.f16620e);
            flatBufferBuilder.a(2, this.f16621f);
            flatBufferBuilder.a(3, this.f16622g, 0);
            flatBufferBuilder.a(4, this.f16623h, 0);
            i();
            return flatBufferBuilder.d();
        }

        public final void m24356a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f16620e = mutableFlatBuffer.a(i, 1);
            this.f16621f = mutableFlatBuffer.a(i, 2);
            this.f16622g = mutableFlatBuffer.a(i, 3, 0);
            this.f16623h = mutableFlatBuffer.a(i, 4, 0);
        }
    }
}
