package com.facebook.photos.albums.protocols;

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
import com.facebook.graphql.querybuilder.common.CommonGraphQL2Models.DefaultPageInfoFieldsModel;
import com.facebook.graphql.visitor.ConsistencyTuple;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.photos.albums.protocols.VideoListVideosGraphQLParsers.VideosInVideoListDetailQueryParser;
import com.facebook.photos.albums.protocols.VideoListVideosGraphQLParsers.VideosInVideoListDetailQueryParser.VideoListVideosParser;
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

/* compiled from: interstitial_install_only */
public class VideoListVideosGraphQLModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1005038844)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: interstitial_install_only */
    public final class VideosInVideoListDetailQueryModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
        @Nullable
        private GraphQLObjectType f12394d;
        @Nullable
        private String f12395e;
        @Nullable
        private String f12396f;
        @Nullable
        private String f12397g;
        @Nullable
        private VideoListVideosModel f12398h;

        /* compiled from: interstitial_install_only */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(VideosInVideoListDetailQueryModel.class, new Deserializer());
            }

            public Object m19524a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = VideosInVideoListDetailQueryParser.m19545a(jsonParser);
                Object videosInVideoListDetailQueryModel = new VideosInVideoListDetailQueryModel();
                ((BaseModel) videosInVideoListDetailQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (videosInVideoListDetailQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) videosInVideoListDetailQueryModel).a();
                }
                return videosInVideoListDetailQueryModel;
            }
        }

        /* compiled from: interstitial_install_only */
        public class Serializer extends JsonSerializer<VideosInVideoListDetailQueryModel> {
            public final void m19525a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                VideosInVideoListDetailQueryModel videosInVideoListDetailQueryModel = (VideosInVideoListDetailQueryModel) obj;
                if (videosInVideoListDetailQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(videosInVideoListDetailQueryModel.m19537a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    videosInVideoListDetailQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = videosInVideoListDetailQueryModel.w_();
                int u_ = videosInVideoListDetailQueryModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("__type__");
                    SerializerHelpers.b(mutableFlatBuffer, u_, 0, jsonGenerator);
                }
                if (mutableFlatBuffer.g(u_, 1) != 0) {
                    jsonGenerator.a("id");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 1));
                }
                if (mutableFlatBuffer.g(u_, 2) != 0) {
                    jsonGenerator.a("video_list_description");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 2));
                }
                if (mutableFlatBuffer.g(u_, 3) != 0) {
                    jsonGenerator.a("video_list_title");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 3));
                }
                int g = mutableFlatBuffer.g(u_, 4);
                if (g != 0) {
                    jsonGenerator.a("video_list_videos");
                    VideoListVideosParser.m19544a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(VideosInVideoListDetailQueryModel.class, new Serializer());
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 2099558532)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: interstitial_install_only */
        public final class VideoListVideosModel extends BaseModel implements GraphQLVisitableModel {
            private int f12391d;
            @Nullable
            private List<VideoDetailFragmentModel> f12392e;
            @Nullable
            private DefaultPageInfoFieldsModel f12393f;

            /* compiled from: interstitial_install_only */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(VideoListVideosModel.class, new Deserializer());
                }

                public Object m19526a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(VideoListVideosParser.m19543a(jsonParser, flatBufferBuilder));
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

            /* compiled from: interstitial_install_only */
            public class Serializer extends JsonSerializer<VideoListVideosModel> {
                public final void m19527a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    VideoListVideosModel videoListVideosModel = (VideoListVideosModel) obj;
                    if (videoListVideosModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(videoListVideosModel.m19529a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        videoListVideosModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    VideoListVideosParser.m19544a(videoListVideosModel.w_(), videoListVideosModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(VideoListVideosModel.class, new Serializer());
                }
            }

            public VideoListVideosModel() {
                super(3);
            }

            @Nonnull
            public final ImmutableList<VideoDetailFragmentModel> m19531a() {
                this.f12392e = super.a(this.f12392e, 1, VideoDetailFragmentModel.class);
                return (ImmutableList) this.f12392e;
            }

            @Nullable
            private DefaultPageInfoFieldsModel m19528j() {
                this.f12393f = (DefaultPageInfoFieldsModel) super.a(this.f12393f, 2, DefaultPageInfoFieldsModel.class);
                return this.f12393f;
            }

            public final int jK_() {
                return -1393239488;
            }

            public final GraphQLVisitableModel m19530a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel;
                DefaultPageInfoFieldsModel defaultPageInfoFieldsModel;
                h();
                if (m19531a() != null) {
                    Builder a = ModelHelper.a(m19531a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        VideoListVideosModel videoListVideosModel = (VideoListVideosModel) ModelHelper.a(null, this);
                        videoListVideosModel.f12392e = a.b();
                        graphQLVisitableModel = videoListVideosModel;
                        if (m19528j() != null) {
                            defaultPageInfoFieldsModel = (DefaultPageInfoFieldsModel) graphQLModelMutatingVisitor.b(m19528j());
                            if (m19528j() != defaultPageInfoFieldsModel) {
                                graphQLVisitableModel = (VideoListVideosModel) ModelHelper.a(graphQLVisitableModel, this);
                                graphQLVisitableModel.f12393f = defaultPageInfoFieldsModel;
                            }
                        }
                        i();
                        return graphQLVisitableModel != null ? this : graphQLVisitableModel;
                    }
                }
                graphQLVisitableModel = null;
                if (m19528j() != null) {
                    defaultPageInfoFieldsModel = (DefaultPageInfoFieldsModel) graphQLModelMutatingVisitor.b(m19528j());
                    if (m19528j() != defaultPageInfoFieldsModel) {
                        graphQLVisitableModel = (VideoListVideosModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f12393f = defaultPageInfoFieldsModel;
                    }
                }
                i();
                if (graphQLVisitableModel != null) {
                }
            }

            public final int m19529a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m19531a());
                int a2 = ModelHelper.a(flatBufferBuilder, m19528j());
                flatBufferBuilder.c(3);
                flatBufferBuilder.a(0, this.f12391d, 0);
                flatBufferBuilder.b(1, a);
                flatBufferBuilder.b(2, a2);
                i();
                return flatBufferBuilder.d();
            }

            public final void m19532a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f12391d = mutableFlatBuffer.a(i, 0, 0);
            }
        }

        public VideosInVideoListDetailQueryModel() {
            super(5);
        }

        public final void m19540a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m19541a(String str, Object obj, boolean z) {
        }

        @Nullable
        private GraphQLObjectType m19533k() {
            if (this.b != null && this.f12394d == null) {
                this.f12394d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
            }
            return this.f12394d;
        }

        @Nullable
        private String m19534l() {
            this.f12395e = super.a(this.f12395e, 1);
            return this.f12395e;
        }

        @Nullable
        private String m19535m() {
            this.f12396f = super.a(this.f12396f, 2);
            return this.f12396f;
        }

        @Nullable
        private String m19536n() {
            this.f12397g = super.a(this.f12397g, 3);
            return this.f12397g;
        }

        @Nullable
        public final VideoListVideosModel m19542j() {
            this.f12398h = (VideoListVideosModel) super.a(this.f12398h, 4, VideoListVideosModel.class);
            return this.f12398h;
        }

        @Nullable
        public final String m19539a() {
            return m19534l();
        }

        public final int jK_() {
            return 2433570;
        }

        public final GraphQLVisitableModel m19538a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m19542j() != null) {
                VideoListVideosModel videoListVideosModel = (VideoListVideosModel) graphQLModelMutatingVisitor.b(m19542j());
                if (m19542j() != videoListVideosModel) {
                    graphQLVisitableModel = (VideosInVideoListDetailQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f12398h = videoListVideosModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m19537a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m19533k());
            int b = flatBufferBuilder.b(m19534l());
            int b2 = flatBufferBuilder.b(m19535m());
            int b3 = flatBufferBuilder.b(m19536n());
            int a2 = ModelHelper.a(flatBufferBuilder, m19542j());
            flatBufferBuilder.c(5);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, b);
            flatBufferBuilder.b(2, b2);
            flatBufferBuilder.b(3, b3);
            flatBufferBuilder.b(4, a2);
            i();
            return flatBufferBuilder.d();
        }
    }
}
