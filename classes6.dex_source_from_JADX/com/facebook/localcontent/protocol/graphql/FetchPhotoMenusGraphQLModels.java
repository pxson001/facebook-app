package com.facebook.localcontent.protocol.graphql;

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
import com.facebook.graphql.querybuilder.common.CommonGraphQLInterfaces.DefaultImageFields;
import com.facebook.graphql.querybuilder.common.CommonGraphQLModels.DefaultImageFieldsModel;
import com.facebook.graphql.visitor.ConsistencyTuple;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.localcontent.protocol.graphql.FetchPhotoMenusGraphQLParsers.PhotoMenusDataParser;
import com.facebook.localcontent.protocol.graphql.FetchPhotoMenusGraphQLParsers.PhotoMenusDataParser.PagePhotoMenusParser;
import com.facebook.localcontent.protocol.graphql.FetchPhotoMenusGraphQLParsers.PhotoMenusDataParser.PagePhotoMenusParser.NodesParser;
import com.facebook.localcontent.protocol.graphql.FetchPhotoMenusGraphQLParsers.PhotoMenusDataParser.PagePhotoMenusParser.NodesParser.PagePhotoMenuPhotosParser;
import com.facebook.localcontent.protocol.graphql.FetchPhotoMenusGraphQLParsers.PhotoMenusDataParser.PagePhotoMenusParser.NodesParser.PagePhotoMenuPhotosParser.EdgesParser;
import com.facebook.localcontent.protocol.graphql.FetchPhotoMenusGraphQLParsers.PhotoMenusDataParser.PagePhotoMenusParser.NodesParser.PagePhotoMenuPhotosParser.EdgesParser.NodeParser;
import com.facebook.localcontent.protocol.graphql.FetchPhotoMenusGraphQLParsers.PhotoMenusDataParser.PagePhotoMenusParser.NodesParser.PagePhotoMenuPhotosParser.PageInfoParser;
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

/* compiled from: last_second_autofocus_count */
public class FetchPhotoMenusGraphQLModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 278396029)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: last_second_autofocus_count */
    public final class PhotoMenusDataModel extends BaseModel implements GraphQLVisitableConsistentModel {
        @Nullable
        private PagePhotoMenusModel f11746d;

        /* compiled from: last_second_autofocus_count */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(PhotoMenusDataModel.class, new Deserializer());
            }

            public Object m18394a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = PhotoMenusDataParser.m18452a(jsonParser);
                Object photoMenusDataModel = new PhotoMenusDataModel();
                ((BaseModel) photoMenusDataModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (photoMenusDataModel instanceof Postprocessable) {
                    return ((Postprocessable) photoMenusDataModel).a();
                }
                return photoMenusDataModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1848926704)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: last_second_autofocus_count */
        public final class PagePhotoMenusModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<NodesModel> f11745d;

            /* compiled from: last_second_autofocus_count */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(PagePhotoMenusModel.class, new Deserializer());
                }

                public Object m18395a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(PagePhotoMenusParser.m18450a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object pagePhotoMenusModel = new PagePhotoMenusModel();
                    ((BaseModel) pagePhotoMenusModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (pagePhotoMenusModel instanceof Postprocessable) {
                        return ((Postprocessable) pagePhotoMenusModel).a();
                    }
                    return pagePhotoMenusModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 18791346)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: last_second_autofocus_count */
            public final class NodesModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private PagePhotoMenuPhotosModel f11744d;

                /* compiled from: last_second_autofocus_count */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(NodesModel.class, new Deserializer());
                    }

                    public Object m18396a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(NodesParser.m18448b(jsonParser, flatBufferBuilder));
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

                @JsonDeserialize(using = Deserializer.class)
                @ModelWithFlatBufferFormatHash(a = -2016476223)
                @JsonSerialize(using = Serializer.class)
                @FragmentModelWithoutBridge
                /* compiled from: last_second_autofocus_count */
                public final class PagePhotoMenuPhotosModel extends BaseModel implements GraphQLVisitableModel {
                    @Nullable
                    private List<EdgesModel> f11742d;
                    @Nullable
                    private PageInfoModel f11743e;

                    /* compiled from: last_second_autofocus_count */
                    public class Deserializer extends FbJsonDeserializer {
                        static {
                            GlobalAutoGenDeserializerCache.a(PagePhotoMenuPhotosModel.class, new Deserializer());
                        }

                        public Object m18397a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(PagePhotoMenuPhotosParser.m18446a(jsonParser, flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            mutableFlatBuffer.a(4, Boolean.valueOf(true));
                            MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                            Object pagePhotoMenuPhotosModel = new PagePhotoMenuPhotosModel();
                            ((BaseModel) pagePhotoMenuPhotosModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                            if (pagePhotoMenuPhotosModel instanceof Postprocessable) {
                                return ((Postprocessable) pagePhotoMenuPhotosModel).a();
                            }
                            return pagePhotoMenuPhotosModel;
                        }
                    }

                    @JsonDeserialize(using = Deserializer.class)
                    @ModelWithFlatBufferFormatHash(a = -115905078)
                    @JsonSerialize(using = Serializer.class)
                    @FragmentModelWithoutBridge
                    /* compiled from: last_second_autofocus_count */
                    public final class EdgesModel extends BaseModel implements GraphQLVisitableModel {
                        @Nullable
                        private NodeModel f11738d;
                        @Nullable
                        private String f11739e;

                        /* compiled from: last_second_autofocus_count */
                        public class Deserializer extends FbJsonDeserializer {
                            static {
                                GlobalAutoGenDeserializerCache.a(EdgesModel.class, new Deserializer());
                            }

                            public Object m18398a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(EdgesParser.m18442b(jsonParser, flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                                Object edgesModel = new EdgesModel();
                                ((BaseModel) edgesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                                if (edgesModel instanceof Postprocessable) {
                                    return ((Postprocessable) edgesModel).a();
                                }
                                return edgesModel;
                            }
                        }

                        @JsonDeserialize(using = Deserializer.class)
                        @ModelWithFlatBufferFormatHash(a = 1795437614)
                        @JsonSerialize(using = Serializer.class)
                        @FragmentModelWithoutBridge
                        /* compiled from: last_second_autofocus_count */
                        public final class NodeModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
                            @Nullable
                            private String f11735d;
                            @Nullable
                            private DefaultImageFieldsModel f11736e;
                            private long f11737f;

                            /* compiled from: last_second_autofocus_count */
                            public class Deserializer extends FbJsonDeserializer {
                                static {
                                    GlobalAutoGenDeserializerCache.a(NodeModel.class, new Deserializer());
                                }

                                public Object m18399a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                    flatBufferBuilder.d(NodeParser.m18440a(jsonParser, flatBufferBuilder));
                                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                    wrap.position(0);
                                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                                    Object nodeModel = new NodeModel();
                                    ((BaseModel) nodeModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                                    if (nodeModel instanceof Postprocessable) {
                                        return ((Postprocessable) nodeModel).a();
                                    }
                                    return nodeModel;
                                }
                            }

                            /* compiled from: last_second_autofocus_count */
                            public class Serializer extends JsonSerializer<NodeModel> {
                                public final void m18400a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                                    NodeModel nodeModel = (NodeModel) obj;
                                    if (nodeModel.w_() == null) {
                                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                        flatBufferBuilder.d(nodeModel.m18402a(flatBufferBuilder));
                                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                        wrap.position(0);
                                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                        nodeModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                                    }
                                    NodeParser.m18441a(nodeModel.w_(), nodeModel.u_(), jsonGenerator, serializerProvider);
                                }

                                static {
                                    FbSerializerProvider.a(NodeModel.class, new Serializer());
                                }
                            }

                            @Nullable
                            public final /* synthetic */ DefaultImageFields m18407c() {
                                return m18401j();
                            }

                            public NodeModel() {
                                super(3);
                            }

                            @Nullable
                            public final String m18406b() {
                                this.f11735d = super.a(this.f11735d, 0);
                                return this.f11735d;
                            }

                            @Nullable
                            private DefaultImageFieldsModel m18401j() {
                                this.f11736e = (DefaultImageFieldsModel) super.a(this.f11736e, 1, DefaultImageFieldsModel.class);
                                return this.f11736e;
                            }

                            public final long m18408d() {
                                a(0, 2);
                                return this.f11737f;
                            }

                            @Nullable
                            public final String m18404a() {
                                return m18406b();
                            }

                            public final int jK_() {
                                return 77090322;
                            }

                            public final GraphQLVisitableModel m18403a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                                GraphQLVisitableModel graphQLVisitableModel = null;
                                h();
                                if (m18401j() != null) {
                                    DefaultImageFieldsModel defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m18401j());
                                    if (m18401j() != defaultImageFieldsModel) {
                                        graphQLVisitableModel = (NodeModel) ModelHelper.a(null, this);
                                        graphQLVisitableModel.f11736e = defaultImageFieldsModel;
                                    }
                                }
                                i();
                                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                            }

                            public final int m18402a(FlatBufferBuilder flatBufferBuilder) {
                                h();
                                int b = flatBufferBuilder.b(m18406b());
                                int a = ModelHelper.a(flatBufferBuilder, m18401j());
                                flatBufferBuilder.c(3);
                                flatBufferBuilder.b(0, b);
                                flatBufferBuilder.b(1, a);
                                flatBufferBuilder.a(2, this.f11737f, 0);
                                i();
                                return flatBufferBuilder.d();
                            }

                            public final void m18405a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                                super.a(mutableFlatBuffer, i, obj);
                                this.f11737f = mutableFlatBuffer.a(i, 2, 0);
                            }
                        }

                        /* compiled from: last_second_autofocus_count */
                        public class Serializer extends JsonSerializer<EdgesModel> {
                            public final void m18409a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                                EdgesModel edgesModel = (EdgesModel) obj;
                                if (edgesModel.w_() == null) {
                                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                    flatBufferBuilder.d(edgesModel.m18411a(flatBufferBuilder));
                                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                    wrap.position(0);
                                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                    edgesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                                }
                                EdgesParser.m18443b(edgesModel.w_(), edgesModel.u_(), jsonGenerator, serializerProvider);
                            }

                            static {
                                FbSerializerProvider.a(EdgesModel.class, new Serializer());
                            }
                        }

                        @Nullable
                        public final /* synthetic */ NodeModel m18413a() {
                            return m18410j();
                        }

                        public EdgesModel() {
                            super(2);
                        }

                        @Nullable
                        private NodeModel m18410j() {
                            this.f11738d = (NodeModel) super.a(this.f11738d, 0, NodeModel.class);
                            return this.f11738d;
                        }

                        @Nullable
                        public final String m18414b() {
                            this.f11739e = super.a(this.f11739e, 1);
                            return this.f11739e;
                        }

                        public final int jK_() {
                            return -1597222848;
                        }

                        public final GraphQLVisitableModel m18412a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                            GraphQLVisitableModel graphQLVisitableModel = null;
                            h();
                            if (m18410j() != null) {
                                NodeModel nodeModel = (NodeModel) graphQLModelMutatingVisitor.b(m18410j());
                                if (m18410j() != nodeModel) {
                                    graphQLVisitableModel = (EdgesModel) ModelHelper.a(null, this);
                                    graphQLVisitableModel.f11738d = nodeModel;
                                }
                            }
                            i();
                            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                        }

                        public final int m18411a(FlatBufferBuilder flatBufferBuilder) {
                            h();
                            int a = ModelHelper.a(flatBufferBuilder, m18410j());
                            int b = flatBufferBuilder.b(m18414b());
                            flatBufferBuilder.c(2);
                            flatBufferBuilder.b(0, a);
                            flatBufferBuilder.b(1, b);
                            i();
                            return flatBufferBuilder.d();
                        }
                    }

                    @JsonDeserialize(using = Deserializer.class)
                    @ModelWithFlatBufferFormatHash(a = -2005169142)
                    @JsonSerialize(using = Serializer.class)
                    @FragmentModelWithoutBridge
                    /* compiled from: last_second_autofocus_count */
                    public final class PageInfoModel extends BaseModel implements GraphQLVisitableModel {
                        @Nullable
                        private String f11740d;
                        private boolean f11741e;

                        /* compiled from: last_second_autofocus_count */
                        public class Deserializer extends FbJsonDeserializer {
                            static {
                                GlobalAutoGenDeserializerCache.a(PageInfoModel.class, new Deserializer());
                            }

                            public Object m18415a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(PageInfoParser.m18444a(jsonParser, flatBufferBuilder));
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

                        /* compiled from: last_second_autofocus_count */
                        public class Serializer extends JsonSerializer<PageInfoModel> {
                            public final void m18416a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                                PageInfoModel pageInfoModel = (PageInfoModel) obj;
                                if (pageInfoModel.w_() == null) {
                                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                    flatBufferBuilder.d(pageInfoModel.m18418a(flatBufferBuilder));
                                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                    wrap.position(0);
                                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                    pageInfoModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                                }
                                PageInfoParser.m18445a(pageInfoModel.w_(), pageInfoModel.u_(), jsonGenerator);
                            }

                            static {
                                FbSerializerProvider.a(PageInfoModel.class, new Serializer());
                            }
                        }

                        public PageInfoModel() {
                            super(2);
                        }

                        @Nullable
                        private String m18417a() {
                            this.f11740d = super.a(this.f11740d, 0);
                            return this.f11740d;
                        }

                        public final int jK_() {
                            return 923779069;
                        }

                        public final GraphQLVisitableModel m18419a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                            h();
                            i();
                            return this;
                        }

                        public final int m18418a(FlatBufferBuilder flatBufferBuilder) {
                            h();
                            int b = flatBufferBuilder.b(m18417a());
                            flatBufferBuilder.c(2);
                            flatBufferBuilder.b(0, b);
                            flatBufferBuilder.a(1, this.f11741e);
                            i();
                            return flatBufferBuilder.d();
                        }

                        public final void m18420a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                            super.a(mutableFlatBuffer, i, obj);
                            this.f11741e = mutableFlatBuffer.a(i, 1);
                        }
                    }

                    /* compiled from: last_second_autofocus_count */
                    public class Serializer extends JsonSerializer<PagePhotoMenuPhotosModel> {
                        public final void m18421a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            PagePhotoMenuPhotosModel pagePhotoMenuPhotosModel = (PagePhotoMenuPhotosModel) obj;
                            if (pagePhotoMenuPhotosModel.w_() == null) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(pagePhotoMenuPhotosModel.m18423a(flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                pagePhotoMenuPhotosModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                            }
                            PagePhotoMenuPhotosParser.m18447a(pagePhotoMenuPhotosModel.w_(), pagePhotoMenuPhotosModel.u_(), jsonGenerator, serializerProvider);
                        }

                        static {
                            FbSerializerProvider.a(PagePhotoMenuPhotosModel.class, new Serializer());
                        }
                    }

                    public PagePhotoMenuPhotosModel() {
                        super(2);
                    }

                    @Nonnull
                    public final ImmutableList<EdgesModel> m18425a() {
                        this.f11742d = super.a(this.f11742d, 0, EdgesModel.class);
                        return (ImmutableList) this.f11742d;
                    }

                    @Nullable
                    private PageInfoModel m18422j() {
                        this.f11743e = (PageInfoModel) super.a(this.f11743e, 1, PageInfoModel.class);
                        return this.f11743e;
                    }

                    public final int jK_() {
                        return -545246431;
                    }

                    public final GraphQLVisitableModel m18424a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                        GraphQLVisitableModel graphQLVisitableModel;
                        PageInfoModel pageInfoModel;
                        h();
                        if (m18425a() != null) {
                            Builder a = ModelHelper.a(m18425a(), graphQLModelMutatingVisitor);
                            if (a != null) {
                                PagePhotoMenuPhotosModel pagePhotoMenuPhotosModel = (PagePhotoMenuPhotosModel) ModelHelper.a(null, this);
                                pagePhotoMenuPhotosModel.f11742d = a.b();
                                graphQLVisitableModel = pagePhotoMenuPhotosModel;
                                if (m18422j() != null) {
                                    pageInfoModel = (PageInfoModel) graphQLModelMutatingVisitor.b(m18422j());
                                    if (m18422j() != pageInfoModel) {
                                        graphQLVisitableModel = (PagePhotoMenuPhotosModel) ModelHelper.a(graphQLVisitableModel, this);
                                        graphQLVisitableModel.f11743e = pageInfoModel;
                                    }
                                }
                                i();
                                return graphQLVisitableModel != null ? this : graphQLVisitableModel;
                            }
                        }
                        graphQLVisitableModel = null;
                        if (m18422j() != null) {
                            pageInfoModel = (PageInfoModel) graphQLModelMutatingVisitor.b(m18422j());
                            if (m18422j() != pageInfoModel) {
                                graphQLVisitableModel = (PagePhotoMenuPhotosModel) ModelHelper.a(graphQLVisitableModel, this);
                                graphQLVisitableModel.f11743e = pageInfoModel;
                            }
                        }
                        i();
                        if (graphQLVisitableModel != null) {
                        }
                    }

                    public final int m18423a(FlatBufferBuilder flatBufferBuilder) {
                        h();
                        int a = ModelHelper.a(flatBufferBuilder, m18425a());
                        int a2 = ModelHelper.a(flatBufferBuilder, m18422j());
                        flatBufferBuilder.c(2);
                        flatBufferBuilder.b(0, a);
                        flatBufferBuilder.b(1, a2);
                        i();
                        return flatBufferBuilder.d();
                    }
                }

                /* compiled from: last_second_autofocus_count */
                public class Serializer extends JsonSerializer<NodesModel> {
                    public final void m18426a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        NodesModel nodesModel = (NodesModel) obj;
                        if (nodesModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(nodesModel.m18427a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            nodesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        NodesParser.m18449b(nodesModel.w_(), nodesModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(NodesModel.class, new Serializer());
                    }
                }

                public NodesModel() {
                    super(1);
                }

                @Nullable
                public final PagePhotoMenuPhotosModel m18429a() {
                    this.f11744d = (PagePhotoMenuPhotosModel) super.a(this.f11744d, 0, PagePhotoMenuPhotosModel.class);
                    return this.f11744d;
                }

                public final int jK_() {
                    return 19053762;
                }

                public final GraphQLVisitableModel m18428a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m18429a() != null) {
                        PagePhotoMenuPhotosModel pagePhotoMenuPhotosModel = (PagePhotoMenuPhotosModel) graphQLModelMutatingVisitor.b(m18429a());
                        if (m18429a() != pagePhotoMenuPhotosModel) {
                            graphQLVisitableModel = (NodesModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f11744d = pagePhotoMenuPhotosModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m18427a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m18429a());
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, a);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: last_second_autofocus_count */
            public class Serializer extends JsonSerializer<PagePhotoMenusModel> {
                public final void m18430a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    PagePhotoMenusModel pagePhotoMenusModel = (PagePhotoMenusModel) obj;
                    if (pagePhotoMenusModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(pagePhotoMenusModel.m18431a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        pagePhotoMenusModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    PagePhotoMenusParser.m18451a(pagePhotoMenusModel.w_(), pagePhotoMenusModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(PagePhotoMenusModel.class, new Serializer());
                }
            }

            public PagePhotoMenusModel() {
                super(1);
            }

            @Nonnull
            public final ImmutableList<NodesModel> m18433a() {
                this.f11745d = super.a(this.f11745d, 0, NodesModel.class);
                return (ImmutableList) this.f11745d;
            }

            public final int jK_() {
                return -889078353;
            }

            public final GraphQLVisitableModel m18432a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m18433a() != null) {
                    Builder a = ModelHelper.a(m18433a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (PagePhotoMenusModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f11745d = a.b();
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m18431a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m18433a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: last_second_autofocus_count */
        public class Serializer extends JsonSerializer<PhotoMenusDataModel> {
            public final void m18434a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                PhotoMenusDataModel photoMenusDataModel = (PhotoMenusDataModel) obj;
                if (photoMenusDataModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(photoMenusDataModel.m18435a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    photoMenusDataModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = photoMenusDataModel.w_();
                int u_ = photoMenusDataModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("page_photo_menus");
                    PagePhotoMenusParser.m18451a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(PhotoMenusDataModel.class, new Serializer());
            }
        }

        public PhotoMenusDataModel() {
            super(1);
        }

        public final void m18438a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m18439a(String str, Object obj, boolean z) {
        }

        @Nullable
        public final PagePhotoMenusModel m18437a() {
            this.f11746d = (PagePhotoMenusModel) super.a(this.f11746d, 0, PagePhotoMenusModel.class);
            return this.f11746d;
        }

        public final int jK_() {
            return 2479791;
        }

        public final GraphQLVisitableModel m18436a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m18437a() != null) {
                PagePhotoMenusModel pagePhotoMenusModel = (PagePhotoMenusModel) graphQLModelMutatingVisitor.b(m18437a());
                if (m18437a() != pagePhotoMenusModel) {
                    graphQLVisitableModel = (PhotoMenusDataModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f11746d = pagePhotoMenusModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m18435a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m18437a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }
}
