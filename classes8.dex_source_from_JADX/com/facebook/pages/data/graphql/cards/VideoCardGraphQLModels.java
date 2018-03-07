package com.facebook.pages.data.graphql.cards;

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
import com.facebook.graphql.visitor.ConsistencyTuple;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.pages.data.graphql.cards.VideoCardGraphQLParsers.VideoCardQueryParser;
import com.facebook.pages.data.graphql.cards.VideoCardGraphQLParsers.VideoCardQueryParser.UploadedVideosParser;
import com.facebook.pages.data.graphql.cards.VideoCardGraphQLParsers.VideoCardQueryParser.VideoCollectionParser;
import com.facebook.pages.data.graphql.cards.VideoCardGraphQLParsers.VideoCardQueryParser.VideoCollectionParser.VideoListsParser;
import com.facebook.photos.albums.protocols.VideosUploadedByUserGraphQLModels.VideoDetailFragmentModel;
import com.facebook.photos.albums.protocols.VideosUploadedByUserGraphQLParsers.VideoDetailFragmentParser;
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

/* compiled from: confirmation_failure */
public class VideoCardGraphQLModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -640828112)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: confirmation_failure */
    public final class VideoCardQueryModel extends BaseModel implements GraphQLVisitableConsistentModel {
        @Nullable
        private VideoDetailFragmentModel f17075d;
        private boolean f17076e;
        @Nullable
        private UploadedVideosModel f17077f;
        @Nullable
        private VideoCollectionModel f17078g;

        /* compiled from: confirmation_failure */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(VideoCardQueryModel.class, new Deserializer());
            }

            public Object m20832a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(VideoCardQueryParser.m20869a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object videoCardQueryModel = new VideoCardQueryModel();
                ((BaseModel) videoCardQueryModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (videoCardQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) videoCardQueryModel).a();
                }
                return videoCardQueryModel;
            }
        }

        /* compiled from: confirmation_failure */
        public class Serializer extends JsonSerializer<VideoCardQueryModel> {
            public final void m20833a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                VideoCardQueryModel videoCardQueryModel = (VideoCardQueryModel) obj;
                if (videoCardQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(videoCardQueryModel.m20854a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    videoCardQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = videoCardQueryModel.w_();
                int u_ = videoCardQueryModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("featured_video");
                    VideoDetailFragmentParser.b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                boolean a = mutableFlatBuffer.a(u_, 1);
                if (a) {
                    jsonGenerator.a("show_video_hub");
                    jsonGenerator.a(a);
                }
                g = mutableFlatBuffer.g(u_, 2);
                if (g != 0) {
                    jsonGenerator.a("uploaded_videos");
                    UploadedVideosParser.m20864a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(u_, 3);
                if (g != 0) {
                    jsonGenerator.a("video_collection");
                    VideoCollectionParser.m20868a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(VideoCardQueryModel.class, new Serializer());
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -612504631)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: confirmation_failure */
        public final class UploadedVideosModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<VideoDetailFragmentModel> f17072d;

            /* compiled from: confirmation_failure */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(UploadedVideosModel.class, new Deserializer());
                }

                public Object m20834a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(UploadedVideosParser.m20863a(jsonParser, flatBufferBuilder));
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

            /* compiled from: confirmation_failure */
            public class Serializer extends JsonSerializer<UploadedVideosModel> {
                public final void m20835a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    UploadedVideosModel uploadedVideosModel = (UploadedVideosModel) obj;
                    if (uploadedVideosModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(uploadedVideosModel.m20836a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        uploadedVideosModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    UploadedVideosParser.m20864a(uploadedVideosModel.w_(), uploadedVideosModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(UploadedVideosModel.class, new Serializer());
                }
            }

            public UploadedVideosModel() {
                super(1);
            }

            @Nonnull
            public final ImmutableList<VideoDetailFragmentModel> m20838a() {
                this.f17072d = super.a(this.f17072d, 0, VideoDetailFragmentModel.class);
                return (ImmutableList) this.f17072d;
            }

            public final int jK_() {
                return 2007813238;
            }

            public final GraphQLVisitableModel m20837a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m20838a() != null) {
                    Builder a = ModelHelper.a(m20838a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (UploadedVideosModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f17072d = a.b();
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m20836a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m20838a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1845281954)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: confirmation_failure */
        public final class VideoCollectionModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private VideoListsModel f17074d;

            /* compiled from: confirmation_failure */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(VideoCollectionModel.class, new Deserializer());
                }

                public Object m20839a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(VideoCollectionParser.m20867a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object videoCollectionModel = new VideoCollectionModel();
                    ((BaseModel) videoCollectionModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (videoCollectionModel instanceof Postprocessable) {
                        return ((Postprocessable) videoCollectionModel).a();
                    }
                    return videoCollectionModel;
                }
            }

            /* compiled from: confirmation_failure */
            public class Serializer extends JsonSerializer<VideoCollectionModel> {
                public final void m20840a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    VideoCollectionModel videoCollectionModel = (VideoCollectionModel) obj;
                    if (videoCollectionModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(videoCollectionModel.m20848a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        videoCollectionModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    VideoCollectionParser.m20868a(videoCollectionModel.w_(), videoCollectionModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(VideoCollectionModel.class, new Serializer());
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -1723990064)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: confirmation_failure */
            public final class VideoListsModel extends BaseModel implements GraphQLVisitableModel {
                private int f17073d;

                /* compiled from: confirmation_failure */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(VideoListsModel.class, new Deserializer());
                    }

                    public Object m20841a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(VideoListsParser.m20865a(jsonParser, flatBufferBuilder));
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

                /* compiled from: confirmation_failure */
                public class Serializer extends JsonSerializer<VideoListsModel> {
                    public final void m20842a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        VideoListsModel videoListsModel = (VideoListsModel) obj;
                        if (videoListsModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(videoListsModel.m20844a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            videoListsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        VideoListsParser.m20866a(videoListsModel.w_(), videoListsModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(VideoListsModel.class, new Serializer());
                    }
                }

                public VideoListsModel() {
                    super(1);
                }

                public final int m20843a() {
                    a(0, 0);
                    return this.f17073d;
                }

                public final int jK_() {
                    return -1464360025;
                }

                public final GraphQLVisitableModel m20845a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m20844a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.a(0, this.f17073d, 0);
                    i();
                    return flatBufferBuilder.d();
                }

                public final void m20846a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                    super.a(mutableFlatBuffer, i, obj);
                    this.f17073d = mutableFlatBuffer.a(i, 0, 0);
                }
            }

            @Nullable
            public final /* synthetic */ VideoListsModel m20850a() {
                return m20847j();
            }

            public VideoCollectionModel() {
                super(1);
            }

            @Nullable
            private VideoListsModel m20847j() {
                this.f17074d = (VideoListsModel) super.a(this.f17074d, 0, VideoListsModel.class);
                return this.f17074d;
            }

            public final int jK_() {
                return -645050678;
            }

            public final GraphQLVisitableModel m20849a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m20847j() != null) {
                    VideoListsModel videoListsModel = (VideoListsModel) graphQLModelMutatingVisitor.b(m20847j());
                    if (m20847j() != videoListsModel) {
                        graphQLVisitableModel = (VideoCollectionModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f17074d = videoListsModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m20848a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m20847j());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        @Nullable
        public final /* synthetic */ VideoDetailFragmentModel m20856a() {
            return m20851j();
        }

        @Nullable
        public final /* synthetic */ UploadedVideosModel m20861c() {
            return m20852k();
        }

        @Nullable
        public final /* synthetic */ VideoCollectionModel m20862d() {
            return m20853l();
        }

        public VideoCardQueryModel() {
            super(4);
        }

        public final void m20858a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m20859a(String str, Object obj, boolean z) {
        }

        @Nullable
        private VideoDetailFragmentModel m20851j() {
            this.f17075d = (VideoDetailFragmentModel) super.a(this.f17075d, 0, VideoDetailFragmentModel.class);
            return this.f17075d;
        }

        public final boolean m20860b() {
            a(0, 1);
            return this.f17076e;
        }

        @Nullable
        private UploadedVideosModel m20852k() {
            this.f17077f = (UploadedVideosModel) super.a(this.f17077f, 2, UploadedVideosModel.class);
            return this.f17077f;
        }

        @Nullable
        private VideoCollectionModel m20853l() {
            this.f17078g = (VideoCollectionModel) super.a(this.f17078g, 3, VideoCollectionModel.class);
            return this.f17078g;
        }

        public final int jK_() {
            return 2479791;
        }

        public final GraphQLVisitableModel m20855a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m20851j() != null) {
                VideoDetailFragmentModel videoDetailFragmentModel = (VideoDetailFragmentModel) graphQLModelMutatingVisitor.b(m20851j());
                if (m20851j() != videoDetailFragmentModel) {
                    graphQLVisitableModel = (VideoCardQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f17075d = videoDetailFragmentModel;
                }
            }
            if (m20852k() != null) {
                UploadedVideosModel uploadedVideosModel = (UploadedVideosModel) graphQLModelMutatingVisitor.b(m20852k());
                if (m20852k() != uploadedVideosModel) {
                    graphQLVisitableModel = (VideoCardQueryModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f17077f = uploadedVideosModel;
                }
            }
            if (m20853l() != null) {
                VideoCollectionModel videoCollectionModel = (VideoCollectionModel) graphQLModelMutatingVisitor.b(m20853l());
                if (m20853l() != videoCollectionModel) {
                    graphQLVisitableModel = (VideoCardQueryModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f17078g = videoCollectionModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m20854a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m20851j());
            int a2 = ModelHelper.a(flatBufferBuilder, m20852k());
            int a3 = ModelHelper.a(flatBufferBuilder, m20853l());
            flatBufferBuilder.c(4);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.a(1, this.f17076e);
            flatBufferBuilder.b(2, a2);
            flatBufferBuilder.b(3, a3);
            i();
            return flatBufferBuilder.d();
        }

        public final void m20857a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f17076e = mutableFlatBuffer.a(i, 1);
        }
    }
}
