package com.facebook.pages.fb4a.videohub.graphql;

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
import com.facebook.graphql.querybuilder.common.CommonGraphQL2Models.DefaultPageInfoTailFieldsModel;
import com.facebook.graphql.visitor.ConsistencyTuple;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.pages.fb4a.videohub.graphql.VideoHubParsers.PageVideoHubQueryParser;
import com.facebook.pages.fb4a.videohub.graphql.VideoHubParsers.PageVideoHubQueryParser.UploadedVideosParser;
import com.facebook.pages.fb4a.videohub.graphql.VideoHubParsers.PageVideoListParser;
import com.facebook.pages.fb4a.videohub.graphql.VideoHubParsers.PageVideoListParser.VideoListVideosParser;
import com.facebook.pages.fb4a.videohub.graphql.VideoHubParsers.VideoCollectionFragmentParser;
import com.facebook.pages.fb4a.videohub.graphql.VideoHubParsers.VideoCollectionFragmentParser.VideoListsParser;
import com.facebook.photos.albums.protocols.VideosUploadedByUserGraphQLModels.VideoDetailFragmentModel;
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

/* compiled from: product_attachment */
public class VideoHubModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 692613312)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: product_attachment */
    public final class PageVideoHubQueryModel extends BaseModel implements GraphQLVisitableConsistentModel {
        @Nullable
        private GraphQLObjectType f3084d;
        @Nullable
        private String f3085e;
        @Nullable
        private UploadedVideosModel f3086f;
        @Nullable
        private VideoCollectionFragmentModel f3087g;

        /* compiled from: product_attachment */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(PageVideoHubQueryModel.class, new Deserializer());
            }

            public Object m4150a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = PageVideoHubQueryParser.m4198a(jsonParser);
                Object pageVideoHubQueryModel = new PageVideoHubQueryModel();
                ((BaseModel) pageVideoHubQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (pageVideoHubQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) pageVideoHubQueryModel).a();
                }
                return pageVideoHubQueryModel;
            }
        }

        /* compiled from: product_attachment */
        public class Serializer extends JsonSerializer<PageVideoHubQueryModel> {
            public final void m4151a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                PageVideoHubQueryModel pageVideoHubQueryModel = (PageVideoHubQueryModel) obj;
                if (pageVideoHubQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(pageVideoHubQueryModel.m4159a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    pageVideoHubQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = pageVideoHubQueryModel.w_();
                int u_ = pageVideoHubQueryModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("__type__");
                    SerializerHelpers.b(mutableFlatBuffer, u_, 0, jsonGenerator);
                }
                if (mutableFlatBuffer.g(u_, 1) != 0) {
                    jsonGenerator.a("name");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 1));
                }
                int g = mutableFlatBuffer.g(u_, 2);
                if (g != 0) {
                    jsonGenerator.a("uploaded_videos");
                    UploadedVideosParser.m4197a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(u_, 3);
                if (g != 0) {
                    jsonGenerator.a("video_collection");
                    VideoCollectionFragmentParser.m4206a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(PageVideoHubQueryModel.class, new Serializer());
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1723990064)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: product_attachment */
        public final class UploadedVideosModel extends BaseModel implements GraphQLVisitableModel {
            private int f3083d;

            /* compiled from: product_attachment */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(UploadedVideosModel.class, new Deserializer());
                }

                public Object m4152a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(UploadedVideosParser.m4196a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object uploadedVideosModel = new UploadedVideosModel();
                    ((BaseModel) uploadedVideosModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (uploadedVideosModel instanceof Postprocessable) {
                        return ((Postprocessable) uploadedVideosModel).a();
                    }
                    return uploadedVideosModel;
                }
            }

            /* compiled from: product_attachment */
            public class Serializer extends JsonSerializer<UploadedVideosModel> {
                public final void m4153a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    UploadedVideosModel uploadedVideosModel = (UploadedVideosModel) obj;
                    if (uploadedVideosModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(uploadedVideosModel.m4155a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        uploadedVideosModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    UploadedVideosParser.m4197a(uploadedVideosModel.w_(), uploadedVideosModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(UploadedVideosModel.class, new Serializer());
                }
            }

            public UploadedVideosModel() {
                super(1);
            }

            public final int m4154a() {
                a(0, 0);
                return this.f3083d;
            }

            public final int jK_() {
                return 2007813238;
            }

            public final GraphQLVisitableModel m4156a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m4155a(FlatBufferBuilder flatBufferBuilder) {
                h();
                flatBufferBuilder.c(1);
                flatBufferBuilder.a(0, this.f3083d, 0);
                i();
                return flatBufferBuilder.d();
            }

            public final void m4157a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f3083d = mutableFlatBuffer.a(i, 0, 0);
            }
        }

        public PageVideoHubQueryModel() {
            super(4);
        }

        public final void m4162a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m4163a(String str, Object obj, boolean z) {
        }

        @Nullable
        private GraphQLObjectType m4158l() {
            if (this.b != null && this.f3084d == null) {
                this.f3084d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
            }
            return this.f3084d;
        }

        @Nullable
        public final String m4161a() {
            this.f3085e = super.a(this.f3085e, 1);
            return this.f3085e;
        }

        @Nullable
        public final UploadedVideosModel m4164j() {
            this.f3086f = (UploadedVideosModel) super.a(this.f3086f, 2, UploadedVideosModel.class);
            return this.f3086f;
        }

        @Nullable
        public final VideoCollectionFragmentModel m4165k() {
            this.f3087g = (VideoCollectionFragmentModel) super.a(this.f3087g, 3, VideoCollectionFragmentModel.class);
            return this.f3087g;
        }

        public final int jK_() {
            return 2433570;
        }

        public final GraphQLVisitableModel m4160a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m4164j() != null) {
                UploadedVideosModel uploadedVideosModel = (UploadedVideosModel) graphQLModelMutatingVisitor.b(m4164j());
                if (m4164j() != uploadedVideosModel) {
                    graphQLVisitableModel = (PageVideoHubQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f3086f = uploadedVideosModel;
                }
            }
            if (m4165k() != null) {
                VideoCollectionFragmentModel videoCollectionFragmentModel = (VideoCollectionFragmentModel) graphQLModelMutatingVisitor.b(m4165k());
                if (m4165k() != videoCollectionFragmentModel) {
                    graphQLVisitableModel = (PageVideoHubQueryModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f3087g = videoCollectionFragmentModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m4159a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m4158l());
            int b = flatBufferBuilder.b(m4161a());
            int a2 = ModelHelper.a(flatBufferBuilder, m4164j());
            int a3 = ModelHelper.a(flatBufferBuilder, m4165k());
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
    @ModelWithFlatBufferFormatHash(a = 1920659110)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: product_attachment */
    public final class PageVideoListModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
        @Nullable
        private String f3091d;
        @Nullable
        private String f3092e;
        @Nullable
        private String f3093f;
        @Nullable
        private VideoListVideosModel f3094g;

        /* compiled from: product_attachment */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(PageVideoListModel.class, new Deserializer());
            }

            public Object m4166a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(PageVideoListParser.m4201b(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object pageVideoListModel = new PageVideoListModel();
                ((BaseModel) pageVideoListModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (pageVideoListModel instanceof Postprocessable) {
                    return ((Postprocessable) pageVideoListModel).a();
                }
                return pageVideoListModel;
            }
        }

        /* compiled from: product_attachment */
        public class Serializer extends JsonSerializer<PageVideoListModel> {
            public final void m4167a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                PageVideoListModel pageVideoListModel = (PageVideoListModel) obj;
                if (pageVideoListModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(pageVideoListModel.m4176a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    pageVideoListModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                PageVideoListParser.m4202b(pageVideoListModel.w_(), pageVideoListModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(PageVideoListModel.class, new Serializer());
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -180111079)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: product_attachment */
        public final class VideoListVideosModel extends BaseModel implements GraphQLVisitableModel {
            private int f3088d;
            @Nullable
            private List<VideoDetailFragmentModel> f3089e;
            @Nullable
            private DefaultPageInfoTailFieldsModel f3090f;

            /* compiled from: product_attachment */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(VideoListVideosModel.class, new Deserializer());
                }

                public Object m4168a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(VideoListVideosParser.m4199a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object videoListVideosModel = new VideoListVideosModel();
                    ((BaseModel) videoListVideosModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (videoListVideosModel instanceof Postprocessable) {
                        return ((Postprocessable) videoListVideosModel).a();
                    }
                    return videoListVideosModel;
                }
            }

            /* compiled from: product_attachment */
            public class Serializer extends JsonSerializer<VideoListVideosModel> {
                public final void m4169a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    VideoListVideosModel videoListVideosModel = (VideoListVideosModel) obj;
                    if (videoListVideosModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(videoListVideosModel.m4172a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        videoListVideosModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    VideoListVideosParser.m4200a(videoListVideosModel.w_(), videoListVideosModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(VideoListVideosModel.class, new Serializer());
                }
            }

            public VideoListVideosModel() {
                super(3);
            }

            public final int m4171a() {
                a(0, 0);
                return this.f3088d;
            }

            @Nonnull
            public final ImmutableList<VideoDetailFragmentModel> m4175j() {
                this.f3089e = super.a(this.f3089e, 1, VideoDetailFragmentModel.class);
                return (ImmutableList) this.f3089e;
            }

            @Nullable
            private DefaultPageInfoTailFieldsModel m4170k() {
                this.f3090f = (DefaultPageInfoTailFieldsModel) super.a(this.f3090f, 2, DefaultPageInfoTailFieldsModel.class);
                return this.f3090f;
            }

            public final int jK_() {
                return -1393239488;
            }

            public final GraphQLVisitableModel m4173a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel;
                DefaultPageInfoTailFieldsModel defaultPageInfoTailFieldsModel;
                h();
                if (m4175j() != null) {
                    Builder a = ModelHelper.a(m4175j(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        VideoListVideosModel videoListVideosModel = (VideoListVideosModel) ModelHelper.a(null, this);
                        videoListVideosModel.f3089e = a.b();
                        graphQLVisitableModel = videoListVideosModel;
                        if (m4170k() != null) {
                            defaultPageInfoTailFieldsModel = (DefaultPageInfoTailFieldsModel) graphQLModelMutatingVisitor.b(m4170k());
                            if (m4170k() != defaultPageInfoTailFieldsModel) {
                                graphQLVisitableModel = (VideoListVideosModel) ModelHelper.a(graphQLVisitableModel, this);
                                graphQLVisitableModel.f3090f = defaultPageInfoTailFieldsModel;
                            }
                        }
                        i();
                        return graphQLVisitableModel != null ? this : graphQLVisitableModel;
                    }
                }
                graphQLVisitableModel = null;
                if (m4170k() != null) {
                    defaultPageInfoTailFieldsModel = (DefaultPageInfoTailFieldsModel) graphQLModelMutatingVisitor.b(m4170k());
                    if (m4170k() != defaultPageInfoTailFieldsModel) {
                        graphQLVisitableModel = (VideoListVideosModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f3090f = defaultPageInfoTailFieldsModel;
                    }
                }
                i();
                if (graphQLVisitableModel != null) {
                }
            }

            public final int m4172a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m4175j());
                int a2 = ModelHelper.a(flatBufferBuilder, m4170k());
                flatBufferBuilder.c(3);
                flatBufferBuilder.a(0, this.f3088d, 0);
                flatBufferBuilder.b(1, a);
                flatBufferBuilder.b(2, a2);
                i();
                return flatBufferBuilder.d();
            }

            public final void m4174a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f3088d = mutableFlatBuffer.a(i, 0, 0);
            }
        }

        public PageVideoListModel() {
            super(4);
        }

        @Nullable
        public final String m4179j() {
            this.f3091d = super.a(this.f3091d, 0);
            return this.f3091d;
        }

        @Nullable
        public final String m4180k() {
            this.f3092e = super.a(this.f3092e, 1);
            return this.f3092e;
        }

        @Nullable
        public final String m4181l() {
            this.f3093f = super.a(this.f3093f, 2);
            return this.f3093f;
        }

        @Nullable
        public final VideoListVideosModel m4182m() {
            this.f3094g = (VideoListVideosModel) super.a(this.f3094g, 3, VideoListVideosModel.class);
            return this.f3094g;
        }

        @Nullable
        public final String m4178a() {
            return m4179j();
        }

        public final int jK_() {
            return -958291047;
        }

        public final GraphQLVisitableModel m4177a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m4182m() != null) {
                VideoListVideosModel videoListVideosModel = (VideoListVideosModel) graphQLModelMutatingVisitor.b(m4182m());
                if (m4182m() != videoListVideosModel) {
                    graphQLVisitableModel = (PageVideoListModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f3094g = videoListVideosModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m4176a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m4179j());
            int b2 = flatBufferBuilder.b(m4180k());
            int b3 = flatBufferBuilder.b(m4181l());
            int a = ModelHelper.a(flatBufferBuilder, m4182m());
            flatBufferBuilder.c(4);
            flatBufferBuilder.b(0, b);
            flatBufferBuilder.b(1, b2);
            flatBufferBuilder.b(2, b3);
            flatBufferBuilder.b(3, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1451318987)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: product_attachment */
    public final class VideoCollectionFragmentModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
        @Nullable
        private String f3097d;
        @Nullable
        private VideoListsModel f3098e;

        /* compiled from: product_attachment */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(VideoCollectionFragmentModel.class, new Deserializer());
            }

            public Object m4183a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(VideoCollectionFragmentParser.m4205a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object videoCollectionFragmentModel = new VideoCollectionFragmentModel();
                ((BaseModel) videoCollectionFragmentModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (videoCollectionFragmentModel instanceof Postprocessable) {
                    return ((Postprocessable) videoCollectionFragmentModel).a();
                }
                return videoCollectionFragmentModel;
            }
        }

        /* compiled from: product_attachment */
        public class Serializer extends JsonSerializer<VideoCollectionFragmentModel> {
            public final void m4184a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                VideoCollectionFragmentModel videoCollectionFragmentModel = (VideoCollectionFragmentModel) obj;
                if (videoCollectionFragmentModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(videoCollectionFragmentModel.m4192a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    videoCollectionFragmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                VideoCollectionFragmentParser.m4206a(videoCollectionFragmentModel.w_(), videoCollectionFragmentModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(VideoCollectionFragmentModel.class, new Serializer());
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 2107267667)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: product_attachment */
        public final class VideoListsModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<PageVideoListModel> f3095d;
            @Nullable
            private DefaultPageInfoTailFieldsModel f3096e;

            /* compiled from: product_attachment */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(VideoListsModel.class, new Deserializer());
                }

                public Object m4185a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(VideoListsParser.m4203a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object videoListsModel = new VideoListsModel();
                    ((BaseModel) videoListsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (videoListsModel instanceof Postprocessable) {
                        return ((Postprocessable) videoListsModel).a();
                    }
                    return videoListsModel;
                }
            }

            /* compiled from: product_attachment */
            public class Serializer extends JsonSerializer<VideoListsModel> {
                public final void m4186a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    VideoListsModel videoListsModel = (VideoListsModel) obj;
                    if (videoListsModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(videoListsModel.m4187a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        videoListsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    VideoListsParser.m4204a(videoListsModel.w_(), videoListsModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(VideoListsModel.class, new Serializer());
                }
            }

            public VideoListsModel() {
                super(2);
            }

            @Nonnull
            public final ImmutableList<PageVideoListModel> m4189a() {
                this.f3095d = super.a(this.f3095d, 0, PageVideoListModel.class);
                return (ImmutableList) this.f3095d;
            }

            @Nullable
            public final DefaultPageInfoTailFieldsModel m4190j() {
                this.f3096e = (DefaultPageInfoTailFieldsModel) super.a(this.f3096e, 1, DefaultPageInfoTailFieldsModel.class);
                return this.f3096e;
            }

            public final int jK_() {
                return -1464360025;
            }

            public final GraphQLVisitableModel m4188a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel;
                DefaultPageInfoTailFieldsModel defaultPageInfoTailFieldsModel;
                h();
                if (m4189a() != null) {
                    Builder a = ModelHelper.a(m4189a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        VideoListsModel videoListsModel = (VideoListsModel) ModelHelper.a(null, this);
                        videoListsModel.f3095d = a.b();
                        graphQLVisitableModel = videoListsModel;
                        if (m4190j() != null) {
                            defaultPageInfoTailFieldsModel = (DefaultPageInfoTailFieldsModel) graphQLModelMutatingVisitor.b(m4190j());
                            if (m4190j() != defaultPageInfoTailFieldsModel) {
                                graphQLVisitableModel = (VideoListsModel) ModelHelper.a(graphQLVisitableModel, this);
                                graphQLVisitableModel.f3096e = defaultPageInfoTailFieldsModel;
                            }
                        }
                        i();
                        return graphQLVisitableModel != null ? this : graphQLVisitableModel;
                    }
                }
                graphQLVisitableModel = null;
                if (m4190j() != null) {
                    defaultPageInfoTailFieldsModel = (DefaultPageInfoTailFieldsModel) graphQLModelMutatingVisitor.b(m4190j());
                    if (m4190j() != defaultPageInfoTailFieldsModel) {
                        graphQLVisitableModel = (VideoListsModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f3096e = defaultPageInfoTailFieldsModel;
                    }
                }
                i();
                if (graphQLVisitableModel != null) {
                }
            }

            public final int m4187a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m4189a());
                int a2 = ModelHelper.a(flatBufferBuilder, m4190j());
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, a2);
                i();
                return flatBufferBuilder.d();
            }
        }

        public VideoCollectionFragmentModel() {
            super(2);
        }

        @Nullable
        private String m4191k() {
            this.f3097d = super.a(this.f3097d, 0);
            return this.f3097d;
        }

        @Nullable
        public final VideoListsModel m4195j() {
            this.f3098e = (VideoListsModel) super.a(this.f3098e, 1, VideoListsModel.class);
            return this.f3098e;
        }

        @Nullable
        public final String m4194a() {
            return m4191k();
        }

        public final int jK_() {
            return -645050678;
        }

        public final GraphQLVisitableModel m4193a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m4195j() != null) {
                VideoListsModel videoListsModel = (VideoListsModel) graphQLModelMutatingVisitor.b(m4195j());
                if (m4195j() != videoListsModel) {
                    graphQLVisitableModel = (VideoCollectionFragmentModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f3098e = videoListsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m4192a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m4191k());
            int a = ModelHelper.a(flatBufferBuilder, m4195j());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, b);
            flatBufferBuilder.b(1, a);
            i();
            return flatBufferBuilder.d();
        }
    }
}
