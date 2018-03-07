package com.facebook.video.videohome.protocol;

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
import com.facebook.graphql.querybuilder.common.CommonGraphQLInterfaces.DefaultImageFields;
import com.facebook.graphql.querybuilder.common.CommonGraphQLModels.DefaultImageFieldsModel;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLInterfaces.DefaultTextWithEntitiesFields;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLModels.DefaultTextWithEntitiesFieldsModel;
import com.facebook.graphql.visitor.ConsistencyTuple;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.video.videohome.protocol.VideoHomeQueryParsers.VideoHomeBadgeQueryParser;
import com.facebook.video.videohome.protocol.VideoHomeQueryParsers.VideoHomeCreatorYouShouldFollowParser;
import com.facebook.video.videohome.protocol.VideoHomeQueryParsers.VideoHomeCreatorYouShouldFollowParser.PageLikersParser;
import com.facebook.video.videohome.protocol.VideoHomeQueryParsers.VideoHomeCreatorYouShouldFollowParser.VideoChannelCuratorProfileParser;
import com.facebook.video.videohome.protocol.VideoHomeQueryParsers.VideoHomePrefetchMetadataNoBadgingQueryParser;
import com.facebook.video.videohome.protocol.VideoHomeQueryParsers.VideoHomePrefetchMetadataQueryParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

/* compiled from: didCropKey */
public class VideoHomeQueryModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1521306644)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: didCropKey */
    public final class VideoHomeBadgeQueryModel extends BaseModel implements GraphQLVisitableModel {
        private int f15762d;
        private int f15763e;
        private int f15764f;

        /* compiled from: didCropKey */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(VideoHomeBadgeQueryModel.class, new Deserializer());
            }

            public Object m19685a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = VideoHomeBadgeQueryParser.m19743a(jsonParser);
                Object videoHomeBadgeQueryModel = new VideoHomeBadgeQueryModel();
                ((BaseModel) videoHomeBadgeQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (videoHomeBadgeQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) videoHomeBadgeQueryModel).a();
                }
                return videoHomeBadgeQueryModel;
            }
        }

        /* compiled from: didCropKey */
        public class Serializer extends JsonSerializer<VideoHomeBadgeQueryModel> {
            public final void m19686a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                VideoHomeBadgeQueryModel videoHomeBadgeQueryModel = (VideoHomeBadgeQueryModel) obj;
                if (videoHomeBadgeQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(videoHomeBadgeQueryModel.m19688a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    videoHomeBadgeQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = videoHomeBadgeQueryModel.w_();
                int u_ = videoHomeBadgeQueryModel.u_();
                jsonGenerator.f();
                int a = mutableFlatBuffer.a(u_, 0, 0);
                if (a != 0) {
                    jsonGenerator.a("video_home_badge_check_interval_s");
                    jsonGenerator.b(a);
                }
                a = mutableFlatBuffer.a(u_, 1, 0);
                if (a != 0) {
                    jsonGenerator.a("video_home_badge_count");
                    jsonGenerator.b(a);
                }
                a = mutableFlatBuffer.a(u_, 2, 0);
                if (a != 0) {
                    jsonGenerator.a("video_home_max_badge_count");
                    jsonGenerator.b(a);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(VideoHomeBadgeQueryModel.class, new Serializer());
            }
        }

        public VideoHomeBadgeQueryModel() {
            super(3);
        }

        public final int m19687a() {
            a(0, 0);
            return this.f15762d;
        }

        public final int m19691j() {
            a(0, 1);
            return this.f15763e;
        }

        public final int m19692k() {
            a(0, 2);
            return this.f15764f;
        }

        public final int jK_() {
            return -1732764110;
        }

        public final GraphQLVisitableModel m19689a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m19688a(FlatBufferBuilder flatBufferBuilder) {
            h();
            flatBufferBuilder.c(3);
            flatBufferBuilder.a(0, this.f15762d, 0);
            flatBufferBuilder.a(1, this.f15763e, 0);
            flatBufferBuilder.a(2, this.f15764f, 0);
            i();
            return flatBufferBuilder.d();
        }

        public final void m19690a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f15762d = mutableFlatBuffer.a(i, 0, 0);
            this.f15763e = mutableFlatBuffer.a(i, 1, 0);
            this.f15764f = mutableFlatBuffer.a(i, 2, 0);
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1075701455)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: didCropKey */
    public final class VideoHomeCreatorYouShouldFollowModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
        @Nullable
        private GraphQLObjectType f15778d;
        @Nullable
        private String f15779e;
        @Nullable
        private PageLikersModel f15780f;
        private boolean f15781g;
        @Nullable
        private VideoChannelCuratorProfileModel f15782h;
        private boolean f15783i;
        @Nullable
        private DefaultTextWithEntitiesFieldsModel f15784j;

        /* compiled from: didCropKey */
        public final class Builder {
            @Nullable
            public GraphQLObjectType f15765a;
            @Nullable
            public String f15766b;
            @Nullable
            public PageLikersModel f15767c;
            public boolean f15768d;
            @Nullable
            public VideoChannelCuratorProfileModel f15769e;
            public boolean f15770f;
            @Nullable
            public DefaultTextWithEntitiesFieldsModel f15771g;
        }

        /* compiled from: didCropKey */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(VideoHomeCreatorYouShouldFollowModel.class, new Deserializer());
            }

            public Object m19693a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(VideoHomeCreatorYouShouldFollowParser.m19748a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object videoHomeCreatorYouShouldFollowModel = new VideoHomeCreatorYouShouldFollowModel();
                ((BaseModel) videoHomeCreatorYouShouldFollowModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (videoHomeCreatorYouShouldFollowModel instanceof Postprocessable) {
                    return ((Postprocessable) videoHomeCreatorYouShouldFollowModel).a();
                }
                return videoHomeCreatorYouShouldFollowModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1723990064)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: didCropKey */
        public final class PageLikersModel extends BaseModel implements GraphQLVisitableModel {
            private int f15773d;

            /* compiled from: didCropKey */
            public final class Builder {
                public int f15772a;
            }

            /* compiled from: didCropKey */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(PageLikersModel.class, new Deserializer());
                }

                public Object m19694a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(PageLikersParser.m19744a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object pageLikersModel = new PageLikersModel();
                    ((BaseModel) pageLikersModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (pageLikersModel instanceof Postprocessable) {
                        return ((Postprocessable) pageLikersModel).a();
                    }
                    return pageLikersModel;
                }
            }

            /* compiled from: didCropKey */
            public class Serializer extends JsonSerializer<PageLikersModel> {
                public final void m19695a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    PageLikersModel pageLikersModel = (PageLikersModel) obj;
                    if (pageLikersModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(pageLikersModel.m19698a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        pageLikersModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    PageLikersParser.m19745a(pageLikersModel.w_(), pageLikersModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(PageLikersModel.class, new Serializer());
                }
            }

            public PageLikersModel() {
                super(1);
            }

            public PageLikersModel(MutableFlatBuffer mutableFlatBuffer) {
                super(1);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            public final int m19697a() {
                a(0, 0);
                return this.f15773d;
            }

            public static PageLikersModel m19696a(PageLikersModel pageLikersModel) {
                if (pageLikersModel == null) {
                    return null;
                }
                if (pageLikersModel instanceof PageLikersModel) {
                    return pageLikersModel;
                }
                Builder builder = new Builder();
                builder.f15772a = pageLikersModel.m19697a();
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.c(1);
                flatBufferBuilder.a(0, builder.f15772a, 0);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new PageLikersModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }

            public final int jK_() {
                return 637021669;
            }

            public final GraphQLVisitableModel m19699a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m19698a(FlatBufferBuilder flatBufferBuilder) {
                h();
                flatBufferBuilder.c(1);
                flatBufferBuilder.a(0, this.f15773d, 0);
                i();
                return flatBufferBuilder.d();
            }

            public final void m19700a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f15773d = mutableFlatBuffer.a(i, 0, 0);
            }
        }

        /* compiled from: didCropKey */
        public class Serializer extends JsonSerializer<VideoHomeCreatorYouShouldFollowModel> {
            public final void m19701a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                VideoHomeCreatorYouShouldFollowModel videoHomeCreatorYouShouldFollowModel = (VideoHomeCreatorYouShouldFollowModel) obj;
                if (videoHomeCreatorYouShouldFollowModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(videoHomeCreatorYouShouldFollowModel.m19717a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    videoHomeCreatorYouShouldFollowModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                VideoHomeCreatorYouShouldFollowParser.m19749a(videoHomeCreatorYouShouldFollowModel.w_(), videoHomeCreatorYouShouldFollowModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(VideoHomeCreatorYouShouldFollowModel.class, new Serializer());
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1084932536)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: didCropKey */
        public final class VideoChannelCuratorProfileModel extends BaseModel implements GraphQLVisitableConsistentModel {
            @Nullable
            private GraphQLObjectType f15776d;
            @Nullable
            private DefaultImageFieldsModel f15777e;

            /* compiled from: didCropKey */
            public final class Builder {
                @Nullable
                public GraphQLObjectType f15774a;
                @Nullable
                public DefaultImageFieldsModel f15775b;
            }

            /* compiled from: didCropKey */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(VideoChannelCuratorProfileModel.class, new Deserializer());
                }

                public Object m19702a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(VideoChannelCuratorProfileParser.m19746a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object videoChannelCuratorProfileModel = new VideoChannelCuratorProfileModel();
                    ((BaseModel) videoChannelCuratorProfileModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (videoChannelCuratorProfileModel instanceof Postprocessable) {
                        return ((Postprocessable) videoChannelCuratorProfileModel).a();
                    }
                    return videoChannelCuratorProfileModel;
                }
            }

            /* compiled from: didCropKey */
            public class Serializer extends JsonSerializer<VideoChannelCuratorProfileModel> {
                public final void m19703a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    VideoChannelCuratorProfileModel videoChannelCuratorProfileModel = (VideoChannelCuratorProfileModel) obj;
                    if (videoChannelCuratorProfileModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(videoChannelCuratorProfileModel.m19706a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        videoChannelCuratorProfileModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    VideoChannelCuratorProfileParser.m19747a(videoChannelCuratorProfileModel.w_(), videoChannelCuratorProfileModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(VideoChannelCuratorProfileModel.class, new Serializer());
                }
            }

            @Nullable
            public final /* synthetic */ DefaultImageFields m19711b() {
                return m19705j();
            }

            public VideoChannelCuratorProfileModel() {
                super(2);
            }

            public VideoChannelCuratorProfileModel(MutableFlatBuffer mutableFlatBuffer) {
                super(2);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            public final void m19709a(String str, ConsistencyTuple consistencyTuple) {
                consistencyTuple.a();
            }

            public final void m19710a(String str, Object obj, boolean z) {
            }

            @Nullable
            public final GraphQLObjectType m19707a() {
                if (this.b != null && this.f15776d == null) {
                    this.f15776d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                }
                return this.f15776d;
            }

            @Nullable
            private DefaultImageFieldsModel m19705j() {
                this.f15777e = (DefaultImageFieldsModel) super.a(this.f15777e, 1, DefaultImageFieldsModel.class);
                return this.f15777e;
            }

            public static VideoChannelCuratorProfileModel m19704a(VideoChannelCuratorProfileModel videoChannelCuratorProfileModel) {
                if (videoChannelCuratorProfileModel == null) {
                    return null;
                }
                if (videoChannelCuratorProfileModel instanceof VideoChannelCuratorProfileModel) {
                    return videoChannelCuratorProfileModel;
                }
                Builder builder = new Builder();
                builder.f15774a = videoChannelCuratorProfileModel.m19707a();
                builder.f15775b = DefaultImageFieldsModel.a(videoChannelCuratorProfileModel.m19711b());
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int a = ModelHelper.a(flatBufferBuilder, builder.f15774a);
                int a2 = ModelHelper.a(flatBufferBuilder, builder.f15775b);
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, a2);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new VideoChannelCuratorProfileModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }

            public final int jK_() {
                return 1355227529;
            }

            public final GraphQLVisitableModel m19708a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m19705j() != null) {
                    DefaultImageFieldsModel defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m19705j());
                    if (m19705j() != defaultImageFieldsModel) {
                        graphQLVisitableModel = (VideoChannelCuratorProfileModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f15777e = defaultImageFieldsModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m19706a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m19707a());
                int a2 = ModelHelper.a(flatBufferBuilder, m19705j());
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, a2);
                i();
                return flatBufferBuilder.d();
            }
        }

        @Nullable
        public final /* synthetic */ PageLikersModel m19725d() {
            return m19714j();
        }

        @Nullable
        public final /* synthetic */ DefaultTextWithEntitiesFields fp_() {
            return m19716l();
        }

        @Nullable
        public final /* synthetic */ VideoChannelCuratorProfileModel m19726g() {
            return m19715k();
        }

        public VideoHomeCreatorYouShouldFollowModel() {
            super(7);
        }

        public VideoHomeCreatorYouShouldFollowModel(MutableFlatBuffer mutableFlatBuffer) {
            super(7);
            a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }

        public final void m19721a(String str, ConsistencyTuple consistencyTuple) {
            if ("video_channel_has_viewer_subscribed".equals(str)) {
                consistencyTuple.a = Boolean.valueOf(fo_());
                consistencyTuple.b = u_();
                consistencyTuple.c = 5;
                return;
            }
            consistencyTuple.a();
        }

        public final void m19722a(String str, Object obj, boolean z) {
            if ("video_channel_has_viewer_subscribed".equals(str)) {
                m19713a(((Boolean) obj).booleanValue());
            }
        }

        @Nullable
        public final GraphQLObjectType m19723b() {
            if (this.b != null && this.f15778d == null) {
                this.f15778d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
            }
            return this.f15778d;
        }

        @Nullable
        public final String m19724c() {
            this.f15779e = super.a(this.f15779e, 1);
            return this.f15779e;
        }

        @Nullable
        private PageLikersModel m19714j() {
            this.f15780f = (PageLikersModel) super.a(this.f15780f, 2, PageLikersModel.class);
            return this.f15780f;
        }

        public final boolean fn_() {
            a(0, 3);
            return this.f15781g;
        }

        @Nullable
        private VideoChannelCuratorProfileModel m19715k() {
            this.f15782h = (VideoChannelCuratorProfileModel) super.a(this.f15782h, 4, VideoChannelCuratorProfileModel.class);
            return this.f15782h;
        }

        public final boolean fo_() {
            a(0, 5);
            return this.f15783i;
        }

        private void m19713a(boolean z) {
            this.f15783i = z;
            if (this.b != null && this.b.d) {
                this.b.a(this.c, 5, z);
            }
        }

        @Nullable
        private DefaultTextWithEntitiesFieldsModel m19716l() {
            this.f15784j = (DefaultTextWithEntitiesFieldsModel) super.a(this.f15784j, 6, DefaultTextWithEntitiesFieldsModel.class);
            return this.f15784j;
        }

        public static VideoHomeCreatorYouShouldFollowModel m19712a(VideoHomeCreatorYouShouldFollowModel videoHomeCreatorYouShouldFollowModel) {
            if (videoHomeCreatorYouShouldFollowModel == null) {
                return null;
            }
            if (videoHomeCreatorYouShouldFollowModel instanceof VideoHomeCreatorYouShouldFollowModel) {
                return videoHomeCreatorYouShouldFollowModel;
            }
            Builder builder = new Builder();
            builder.f15765a = videoHomeCreatorYouShouldFollowModel.m19723b();
            builder.f15766b = videoHomeCreatorYouShouldFollowModel.m19724c();
            builder.f15767c = PageLikersModel.m19696a(videoHomeCreatorYouShouldFollowModel.m19725d());
            builder.f15768d = videoHomeCreatorYouShouldFollowModel.fn_();
            builder.f15769e = VideoChannelCuratorProfileModel.m19704a(videoHomeCreatorYouShouldFollowModel.m19726g());
            builder.f15770f = videoHomeCreatorYouShouldFollowModel.fo_();
            builder.f15771g = DefaultTextWithEntitiesFieldsModel.a(videoHomeCreatorYouShouldFollowModel.fp_());
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            int a = ModelHelper.a(flatBufferBuilder, builder.f15765a);
            int b = flatBufferBuilder.b(builder.f15766b);
            int a2 = ModelHelper.a(flatBufferBuilder, builder.f15767c);
            int a3 = ModelHelper.a(flatBufferBuilder, builder.f15769e);
            int a4 = ModelHelper.a(flatBufferBuilder, builder.f15771g);
            flatBufferBuilder.c(7);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, b);
            flatBufferBuilder.b(2, a2);
            flatBufferBuilder.a(3, builder.f15768d);
            flatBufferBuilder.b(4, a3);
            flatBufferBuilder.a(5, builder.f15770f);
            flatBufferBuilder.b(6, a4);
            flatBufferBuilder.d(flatBufferBuilder.d());
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            return new VideoHomeCreatorYouShouldFollowModel(new MutableFlatBuffer(wrap, null, null, true, null));
        }

        @Nullable
        public final String m19719a() {
            return m19724c();
        }

        public final int jK_() {
            return 756114472;
        }

        public final GraphQLVisitableModel m19718a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m19714j() != null) {
                PageLikersModel pageLikersModel = (PageLikersModel) graphQLModelMutatingVisitor.b(m19714j());
                if (m19714j() != pageLikersModel) {
                    graphQLVisitableModel = (VideoHomeCreatorYouShouldFollowModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f15780f = pageLikersModel;
                }
            }
            if (m19715k() != null) {
                VideoChannelCuratorProfileModel videoChannelCuratorProfileModel = (VideoChannelCuratorProfileModel) graphQLModelMutatingVisitor.b(m19715k());
                if (m19715k() != videoChannelCuratorProfileModel) {
                    graphQLVisitableModel = (VideoHomeCreatorYouShouldFollowModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f15782h = videoChannelCuratorProfileModel;
                }
            }
            if (m19716l() != null) {
                DefaultTextWithEntitiesFieldsModel defaultTextWithEntitiesFieldsModel = (DefaultTextWithEntitiesFieldsModel) graphQLModelMutatingVisitor.b(m19716l());
                if (m19716l() != defaultTextWithEntitiesFieldsModel) {
                    graphQLVisitableModel = (VideoHomeCreatorYouShouldFollowModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f15784j = defaultTextWithEntitiesFieldsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m19717a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m19723b());
            int b = flatBufferBuilder.b(m19724c());
            int a2 = ModelHelper.a(flatBufferBuilder, m19714j());
            int a3 = ModelHelper.a(flatBufferBuilder, m19715k());
            int a4 = ModelHelper.a(flatBufferBuilder, m19716l());
            flatBufferBuilder.c(7);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, b);
            flatBufferBuilder.b(2, a2);
            flatBufferBuilder.a(3, this.f15781g);
            flatBufferBuilder.b(4, a3);
            flatBufferBuilder.a(5, this.f15783i);
            flatBufferBuilder.b(6, a4);
            i();
            return flatBufferBuilder.d();
        }

        public final void m19720a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f15781g = mutableFlatBuffer.a(i, 3);
            this.f15783i = mutableFlatBuffer.a(i, 5);
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 2057271707)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: didCropKey */
    public final class VideoHomePrefetchMetadataNoBadgingQueryModel extends BaseModel implements GraphQLVisitableModel {
        private int f15785d;
        private int f15786e;
        private int f15787f;

        /* compiled from: didCropKey */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(VideoHomePrefetchMetadataNoBadgingQueryModel.class, new Deserializer());
            }

            public Object m19727a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = VideoHomePrefetchMetadataNoBadgingQueryParser.m19750a(jsonParser);
                Object videoHomePrefetchMetadataNoBadgingQueryModel = new VideoHomePrefetchMetadataNoBadgingQueryModel();
                ((BaseModel) videoHomePrefetchMetadataNoBadgingQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (videoHomePrefetchMetadataNoBadgingQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) videoHomePrefetchMetadataNoBadgingQueryModel).a();
                }
                return videoHomePrefetchMetadataNoBadgingQueryModel;
            }
        }

        /* compiled from: didCropKey */
        public class Serializer extends JsonSerializer<VideoHomePrefetchMetadataNoBadgingQueryModel> {
            public final void m19728a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                VideoHomePrefetchMetadataNoBadgingQueryModel videoHomePrefetchMetadataNoBadgingQueryModel = (VideoHomePrefetchMetadataNoBadgingQueryModel) obj;
                if (videoHomePrefetchMetadataNoBadgingQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(videoHomePrefetchMetadataNoBadgingQueryModel.m19730a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    videoHomePrefetchMetadataNoBadgingQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = videoHomePrefetchMetadataNoBadgingQueryModel.w_();
                int u_ = videoHomePrefetchMetadataNoBadgingQueryModel.u_();
                jsonGenerator.f();
                int a = mutableFlatBuffer.a(u_, 0, 0);
                if (a != 0) {
                    jsonGenerator.a("video_home_badge_check_interval_s");
                    jsonGenerator.b(a);
                }
                a = mutableFlatBuffer.a(u_, 1, 0);
                if (a != 0) {
                    jsonGenerator.a("video_home_prefetch_unit_count");
                    jsonGenerator.b(a);
                }
                a = mutableFlatBuffer.a(u_, 2, 0);
                if (a != 0) {
                    jsonGenerator.a("video_home_stale_data_interval_s");
                    jsonGenerator.b(a);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(VideoHomePrefetchMetadataNoBadgingQueryModel.class, new Serializer());
            }
        }

        public VideoHomePrefetchMetadataNoBadgingQueryModel() {
            super(3);
        }

        public final int m19729a() {
            a(0, 0);
            return this.f15785d;
        }

        public final int m19733j() {
            a(0, 1);
            return this.f15786e;
        }

        public final int m19734k() {
            a(0, 2);
            return this.f15787f;
        }

        public final int jK_() {
            return -1732764110;
        }

        public final GraphQLVisitableModel m19731a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m19730a(FlatBufferBuilder flatBufferBuilder) {
            h();
            flatBufferBuilder.c(3);
            flatBufferBuilder.a(0, this.f15785d, 0);
            flatBufferBuilder.a(1, this.f15786e, 0);
            flatBufferBuilder.a(2, this.f15787f, 0);
            i();
            return flatBufferBuilder.d();
        }

        public final void m19732a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f15785d = mutableFlatBuffer.a(i, 0, 0);
            this.f15786e = mutableFlatBuffer.a(i, 1, 0);
            this.f15787f = mutableFlatBuffer.a(i, 2, 0);
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 3941614)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: didCropKey */
    public final class VideoHomePrefetchMetadataQueryModel extends BaseModel implements GraphQLVisitableModel {
        private int f15788d;
        private int f15789e;
        private int f15790f;

        /* compiled from: didCropKey */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(VideoHomePrefetchMetadataQueryModel.class, new Deserializer());
            }

            public Object m19735a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = VideoHomePrefetchMetadataQueryParser.m19751a(jsonParser);
                Object videoHomePrefetchMetadataQueryModel = new VideoHomePrefetchMetadataQueryModel();
                ((BaseModel) videoHomePrefetchMetadataQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (videoHomePrefetchMetadataQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) videoHomePrefetchMetadataQueryModel).a();
                }
                return videoHomePrefetchMetadataQueryModel;
            }
        }

        /* compiled from: didCropKey */
        public class Serializer extends JsonSerializer<VideoHomePrefetchMetadataQueryModel> {
            public final void m19736a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                VideoHomePrefetchMetadataQueryModel videoHomePrefetchMetadataQueryModel = (VideoHomePrefetchMetadataQueryModel) obj;
                if (videoHomePrefetchMetadataQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(videoHomePrefetchMetadataQueryModel.m19738a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    videoHomePrefetchMetadataQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = videoHomePrefetchMetadataQueryModel.w_();
                int u_ = videoHomePrefetchMetadataQueryModel.u_();
                jsonGenerator.f();
                int a = mutableFlatBuffer.a(u_, 0, 0);
                if (a != 0) {
                    jsonGenerator.a("video_home_badge_count");
                    jsonGenerator.b(a);
                }
                a = mutableFlatBuffer.a(u_, 1, 0);
                if (a != 0) {
                    jsonGenerator.a("video_home_prefetch_unit_count");
                    jsonGenerator.b(a);
                }
                a = mutableFlatBuffer.a(u_, 2, 0);
                if (a != 0) {
                    jsonGenerator.a("video_home_stale_data_interval_s");
                    jsonGenerator.b(a);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(VideoHomePrefetchMetadataQueryModel.class, new Serializer());
            }
        }

        public VideoHomePrefetchMetadataQueryModel() {
            super(3);
        }

        public final int m19737a() {
            a(0, 0);
            return this.f15788d;
        }

        public final int m19741j() {
            a(0, 1);
            return this.f15789e;
        }

        public final int m19742k() {
            a(0, 2);
            return this.f15790f;
        }

        public final int jK_() {
            return -1732764110;
        }

        public final GraphQLVisitableModel m19739a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m19738a(FlatBufferBuilder flatBufferBuilder) {
            h();
            flatBufferBuilder.c(3);
            flatBufferBuilder.a(0, this.f15788d, 0);
            flatBufferBuilder.a(1, this.f15789e, 0);
            flatBufferBuilder.a(2, this.f15790f, 0);
            i();
            return flatBufferBuilder.d();
        }

        public final void m19740a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f15788d = mutableFlatBuffer.a(i, 0, 0);
            this.f15789e = mutableFlatBuffer.a(i, 1, 0);
            this.f15790f = mutableFlatBuffer.a(i, 2, 0);
        }
    }
}
