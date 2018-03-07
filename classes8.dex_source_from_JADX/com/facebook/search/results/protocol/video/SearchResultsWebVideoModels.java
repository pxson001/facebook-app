package com.facebook.search.results.protocol.video;

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
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLInterfaces.DefaultTextWithEntitiesLongFields;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLModels.DefaultTextWithEntitiesLongFieldsModel;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.search.results.protocol.video.SearchResultsWebVideoInterfaces.SearchResultsWebVideo;
import com.facebook.search.results.protocol.video.SearchResultsWebVideoInterfaces.SearchResultsWebVideo.AllShareStories;
import com.facebook.search.results.protocol.video.SearchResultsWebVideoInterfaces.SearchResultsWebVideo.LinkMedia;
import com.facebook.search.results.protocol.video.SearchResultsWebVideoInterfaces.SearchResultsWebVideo.VideoShare;
import com.facebook.search.results.protocol.video.SearchResultsWebVideoParsers.SearchResultsWebVideoParser;
import com.facebook.search.results.protocol.video.SearchResultsWebVideoParsers.SearchResultsWebVideoParser.AllShareStoriesParser;
import com.facebook.search.results.protocol.video.SearchResultsWebVideoParsers.SearchResultsWebVideoParser.LinkMediaParser;
import com.facebook.search.results.protocol.video.SearchResultsWebVideoParsers.SearchResultsWebVideoParser.VideoShareParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

/* compiled from: menu_management_save_link_menu_failure */
public class SearchResultsWebVideoModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -170069224)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: menu_management_save_link_menu_failure */
    public final class SearchResultsWebVideoModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel, SearchResultsWebVideo {
        @Nullable
        private AllShareStoriesModel f8884d;
        private long f8885e;
        @Nullable
        private String f8886f;
        @Nullable
        private String f8887g;
        @Nullable
        private LinkMediaModel f8888h;
        @Nullable
        private DefaultTextWithEntitiesLongFieldsModel f8889i;
        @Nullable
        private DefaultTextWithEntitiesLongFieldsModel f8890j;
        @Nullable
        private String f8891k;
        @Nullable
        private VideoShareModel f8892l;

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1723990064)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: menu_management_save_link_menu_failure */
        public final class AllShareStoriesModel extends BaseModel implements GraphQLVisitableModel, AllShareStories {
            private int f8875d;

            /* compiled from: menu_management_save_link_menu_failure */
            public final class Builder {
                public int f8874a;
            }

            /* compiled from: menu_management_save_link_menu_failure */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(AllShareStoriesModel.class, new Deserializer());
                }

                public Object m10572a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(AllShareStoriesParser.m10612a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object allShareStoriesModel = new AllShareStoriesModel();
                    ((BaseModel) allShareStoriesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (allShareStoriesModel instanceof Postprocessable) {
                        return ((Postprocessable) allShareStoriesModel).a();
                    }
                    return allShareStoriesModel;
                }
            }

            /* compiled from: menu_management_save_link_menu_failure */
            public class Serializer extends JsonSerializer<AllShareStoriesModel> {
                public final void m10573a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    AllShareStoriesModel allShareStoriesModel = (AllShareStoriesModel) obj;
                    if (allShareStoriesModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(allShareStoriesModel.m10576a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        allShareStoriesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    AllShareStoriesParser.m10613a(allShareStoriesModel.w_(), allShareStoriesModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(AllShareStoriesModel.class, new Serializer());
                }
            }

            public AllShareStoriesModel() {
                super(1);
            }

            public AllShareStoriesModel(MutableFlatBuffer mutableFlatBuffer) {
                super(1);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            public final int mo564a() {
                a(0, 0);
                return this.f8875d;
            }

            public static AllShareStoriesModel m10574a(AllShareStories allShareStories) {
                if (allShareStories == null) {
                    return null;
                }
                if (allShareStories instanceof AllShareStoriesModel) {
                    return (AllShareStoriesModel) allShareStories;
                }
                Builder builder = new Builder();
                builder.f8874a = allShareStories.mo564a();
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.c(1);
                flatBufferBuilder.a(0, builder.f8874a, 0);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new AllShareStoriesModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }

            public final int jK_() {
                return -1051680685;
            }

            public final GraphQLVisitableModel m10577a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m10576a(FlatBufferBuilder flatBufferBuilder) {
                h();
                flatBufferBuilder.c(1);
                flatBufferBuilder.a(0, this.f8875d, 0);
                i();
                return flatBufferBuilder.d();
            }

            public final void m10578a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f8875d = mutableFlatBuffer.a(i, 0, 0);
            }
        }

        /* compiled from: menu_management_save_link_menu_failure */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(SearchResultsWebVideoModel.class, new Deserializer());
            }

            public Object m10579a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(SearchResultsWebVideoParser.m10618a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object searchResultsWebVideoModel = new SearchResultsWebVideoModel();
                ((BaseModel) searchResultsWebVideoModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (searchResultsWebVideoModel instanceof Postprocessable) {
                    return ((Postprocessable) searchResultsWebVideoModel).a();
                }
                return searchResultsWebVideoModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1915099230)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: menu_management_save_link_menu_failure */
        public final class LinkMediaModel extends BaseModel implements GraphQLVisitableModel, LinkMedia {
            @Nullable
            private GraphQLObjectType f8878d;
            @Nullable
            private DefaultImageFieldsModel f8879e;

            /* compiled from: menu_management_save_link_menu_failure */
            public final class Builder {
                @Nullable
                public GraphQLObjectType f8876a;
                @Nullable
                public DefaultImageFieldsModel f8877b;
            }

            /* compiled from: menu_management_save_link_menu_failure */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(LinkMediaModel.class, new Deserializer());
                }

                public Object m10580a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(LinkMediaParser.m10614a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object linkMediaModel = new LinkMediaModel();
                    ((BaseModel) linkMediaModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (linkMediaModel instanceof Postprocessable) {
                        return ((Postprocessable) linkMediaModel).a();
                    }
                    return linkMediaModel;
                }
            }

            /* compiled from: menu_management_save_link_menu_failure */
            public class Serializer extends JsonSerializer<LinkMediaModel> {
                public final void m10581a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    LinkMediaModel linkMediaModel = (LinkMediaModel) obj;
                    if (linkMediaModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(linkMediaModel.m10584a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        linkMediaModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    LinkMediaParser.m10615a(linkMediaModel.w_(), linkMediaModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(LinkMediaModel.class, new Serializer());
                }
            }

            @Nullable
            public final /* synthetic */ DefaultImageFields mo567j() {
                return m10583k();
            }

            public LinkMediaModel() {
                super(2);
            }

            public LinkMediaModel(MutableFlatBuffer mutableFlatBuffer) {
                super(2);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            @Nullable
            public final GraphQLObjectType mo565a() {
                if (this.b != null && this.f8878d == null) {
                    this.f8878d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                }
                return this.f8878d;
            }

            @Nullable
            private DefaultImageFieldsModel m10583k() {
                this.f8879e = (DefaultImageFieldsModel) super.a(this.f8879e, 1, DefaultImageFieldsModel.class);
                return this.f8879e;
            }

            public static LinkMediaModel m10582a(LinkMedia linkMedia) {
                if (linkMedia == null) {
                    return null;
                }
                if (linkMedia instanceof LinkMediaModel) {
                    return (LinkMediaModel) linkMedia;
                }
                Builder builder = new Builder();
                builder.f8876a = linkMedia.mo565a();
                builder.f8877b = DefaultImageFieldsModel.a(linkMedia.mo567j());
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int a = ModelHelper.a(flatBufferBuilder, builder.f8876a);
                int a2 = ModelHelper.a(flatBufferBuilder, builder.f8877b);
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, a2);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new LinkMediaModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }

            public final int jK_() {
                return 74219460;
            }

            public final GraphQLVisitableModel m10586a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m10583k() != null) {
                    DefaultImageFieldsModel defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m10583k());
                    if (m10583k() != defaultImageFieldsModel) {
                        graphQLVisitableModel = (LinkMediaModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f8879e = defaultImageFieldsModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m10584a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, mo565a());
                int a2 = ModelHelper.a(flatBufferBuilder, m10583k());
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, a2);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: menu_management_save_link_menu_failure */
        public class Serializer extends JsonSerializer<SearchResultsWebVideoModel> {
            public final void m10588a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                SearchResultsWebVideoModel searchResultsWebVideoModel = (SearchResultsWebVideoModel) obj;
                if (searchResultsWebVideoModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(searchResultsWebVideoModel.m10605a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    searchResultsWebVideoModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                SearchResultsWebVideoParser.m10619a(searchResultsWebVideoModel.w_(), searchResultsWebVideoModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(SearchResultsWebVideoModel.class, new Serializer());
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1861438057)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: menu_management_save_link_menu_failure */
        public final class VideoShareModel extends BaseModel implements GraphQLVisitableModel, VideoShare {
            @Nullable
            private String f8882d;
            private int f8883e;

            /* compiled from: menu_management_save_link_menu_failure */
            public final class Builder {
                @Nullable
                public String f8880a;
                public int f8881b;
            }

            /* compiled from: menu_management_save_link_menu_failure */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(VideoShareModel.class, new Deserializer());
                }

                public Object m10589a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(VideoShareParser.m10616a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object videoShareModel = new VideoShareModel();
                    ((BaseModel) videoShareModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (videoShareModel instanceof Postprocessable) {
                        return ((Postprocessable) videoShareModel).a();
                    }
                    return videoShareModel;
                }
            }

            /* compiled from: menu_management_save_link_menu_failure */
            public class Serializer extends JsonSerializer<VideoShareModel> {
                public final void m10590a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    VideoShareModel videoShareModel = (VideoShareModel) obj;
                    if (videoShareModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(videoShareModel.m10592a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        videoShareModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    VideoShareParser.m10617a(videoShareModel.w_(), videoShareModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(VideoShareModel.class, new Serializer());
                }
            }

            public VideoShareModel() {
                super(2);
            }

            public VideoShareModel(MutableFlatBuffer mutableFlatBuffer) {
                super(2);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            @Nullable
            public final String mo569a() {
                this.f8882d = super.a(this.f8882d, 0);
                return this.f8882d;
            }

            public final int mo570b() {
                a(0, 1);
                return this.f8883e;
            }

            public static VideoShareModel m10591a(VideoShare videoShare) {
                if (videoShare == null) {
                    return null;
                }
                if (videoShare instanceof VideoShareModel) {
                    return (VideoShareModel) videoShare;
                }
                Builder builder = new Builder();
                builder.f8880a = videoShare.mo569a();
                builder.f8881b = videoShare.mo570b();
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int b = flatBufferBuilder.b(builder.f8880a);
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.a(1, builder.f8881b, 0);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new VideoShareModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }

            public final int jK_() {
                return 364166212;
            }

            public final GraphQLVisitableModel m10593a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m10592a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(mo569a());
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.a(1, this.f8883e, 0);
                i();
                return flatBufferBuilder.d();
            }

            public final void m10595a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f8883e = mutableFlatBuffer.a(i, 1, 0);
            }
        }

        @Nullable
        public final /* synthetic */ LinkMedia mo577N() {
            return m10598k();
        }

        @Nullable
        public final /* synthetic */ DefaultTextWithEntitiesLongFields al() {
            return m10599l();
        }

        @Nullable
        public final /* synthetic */ DefaultTextWithEntitiesLongFields at() {
            return m10600m();
        }

        @Nullable
        public final /* synthetic */ VideoShare av() {
            return m10602o();
        }

        @Nullable
        public final /* synthetic */ AllShareStories mo588d() {
            return m10597j();
        }

        public SearchResultsWebVideoModel() {
            super(9);
        }

        @Nullable
        private AllShareStoriesModel m10597j() {
            this.f8884d = (AllShareStoriesModel) super.a(this.f8884d, 0, AllShareStoriesModel.class);
            return this.f8884d;
        }

        public final long mo592q() {
            a(0, 1);
            return this.f8885e;
        }

        @Nullable
        public final String mo593v() {
            this.f8886f = super.a(this.f8886f, 2);
            return this.f8886f;
        }

        @Nullable
        public final String mo572C() {
            this.f8887g = super.a(this.f8887g, 3);
            return this.f8887g;
        }

        @Nullable
        private LinkMediaModel m10598k() {
            this.f8888h = (LinkMediaModel) super.a(this.f8888h, 4, LinkMediaModel.class);
            return this.f8888h;
        }

        @Nullable
        private DefaultTextWithEntitiesLongFieldsModel m10599l() {
            this.f8889i = (DefaultTextWithEntitiesLongFieldsModel) super.a(this.f8889i, 5, DefaultTextWithEntitiesLongFieldsModel.class);
            return this.f8889i;
        }

        @Nullable
        private DefaultTextWithEntitiesLongFieldsModel m10600m() {
            this.f8890j = (DefaultTextWithEntitiesLongFieldsModel) super.a(this.f8890j, 6, DefaultTextWithEntitiesLongFieldsModel.class);
            return this.f8890j;
        }

        @Nullable
        private String m10601n() {
            this.f8891k = super.a(this.f8891k, 7);
            return this.f8891k;
        }

        @Nullable
        private VideoShareModel m10602o() {
            this.f8892l = (VideoShareModel) super.a(this.f8892l, 8, VideoShareModel.class);
            return this.f8892l;
        }

        @Nullable
        public final String m10607a() {
            return mo572C();
        }

        public final int jK_() {
            return 514783620;
        }

        public final GraphQLVisitableModel m10606a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            DefaultTextWithEntitiesLongFieldsModel defaultTextWithEntitiesLongFieldsModel;
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m10597j() != null) {
                AllShareStoriesModel allShareStoriesModel = (AllShareStoriesModel) graphQLModelMutatingVisitor.b(m10597j());
                if (m10597j() != allShareStoriesModel) {
                    graphQLVisitableModel = (SearchResultsWebVideoModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f8884d = allShareStoriesModel;
                }
            }
            if (m10598k() != null) {
                LinkMediaModel linkMediaModel = (LinkMediaModel) graphQLModelMutatingVisitor.b(m10598k());
                if (m10598k() != linkMediaModel) {
                    graphQLVisitableModel = (SearchResultsWebVideoModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f8888h = linkMediaModel;
                }
            }
            if (m10599l() != null) {
                defaultTextWithEntitiesLongFieldsModel = (DefaultTextWithEntitiesLongFieldsModel) graphQLModelMutatingVisitor.b(m10599l());
                if (m10599l() != defaultTextWithEntitiesLongFieldsModel) {
                    graphQLVisitableModel = (SearchResultsWebVideoModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f8889i = defaultTextWithEntitiesLongFieldsModel;
                }
            }
            if (m10600m() != null) {
                defaultTextWithEntitiesLongFieldsModel = (DefaultTextWithEntitiesLongFieldsModel) graphQLModelMutatingVisitor.b(m10600m());
                if (m10600m() != defaultTextWithEntitiesLongFieldsModel) {
                    graphQLVisitableModel = (SearchResultsWebVideoModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f8890j = defaultTextWithEntitiesLongFieldsModel;
                }
            }
            if (m10602o() != null) {
                VideoShareModel videoShareModel = (VideoShareModel) graphQLModelMutatingVisitor.b(m10602o());
                if (m10602o() != videoShareModel) {
                    graphQLVisitableModel = (SearchResultsWebVideoModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f8892l = videoShareModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m10605a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m10597j());
            int b = flatBufferBuilder.b(mo593v());
            int b2 = flatBufferBuilder.b(mo572C());
            int a2 = ModelHelper.a(flatBufferBuilder, m10598k());
            int a3 = ModelHelper.a(flatBufferBuilder, m10599l());
            int a4 = ModelHelper.a(flatBufferBuilder, m10600m());
            int b3 = flatBufferBuilder.b(m10601n());
            int a5 = ModelHelper.a(flatBufferBuilder, m10602o());
            flatBufferBuilder.c(9);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.a(1, this.f8885e, 0);
            flatBufferBuilder.b(2, b);
            flatBufferBuilder.b(3, b2);
            flatBufferBuilder.b(4, a2);
            flatBufferBuilder.b(5, a3);
            flatBufferBuilder.b(6, a4);
            flatBufferBuilder.b(7, b3);
            flatBufferBuilder.b(8, a5);
            i();
            return flatBufferBuilder.d();
        }

        public final void m10608a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f8885e = mutableFlatBuffer.a(i, 1, 0);
        }
    }
}
