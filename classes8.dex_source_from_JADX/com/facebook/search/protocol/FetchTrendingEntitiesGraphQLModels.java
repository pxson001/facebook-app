package com.facebook.search.protocol;

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
import com.facebook.graphql.visitor.ConsistencyTuple;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.search.protocol.FetchTrendingEntitiesGraphQLParsers.FetchTrendingEntitiesParser;
import com.facebook.search.protocol.FetchTrendingEntitiesGraphQLParsers.FetchTrendingEntitiesParser.TrendingEntitiesParser;
import com.facebook.search.protocol.FetchTrendingEntitiesGraphQLParsers.FetchTrendingEntitiesParser.TrendingEntitiesParser.EdgesParser;
import com.facebook.search.protocol.FetchTrendingEntitiesGraphQLParsers.FetchTrendingEntitiesParser.TrendingEntitiesParser.EdgesParser.NodeParser;
import com.facebook.search.protocol.FetchTrendingEntitiesGraphQLParsers.FetchTrendingEntitiesParser.TrendingEntitiesParser.EdgesParser.NodeParser.TrendingTopicDataParser;
import com.facebook.search.protocol.FetchTrendingEntitiesGraphQLParsers.FetchTrendingEntitiesParser.TrendingEntitiesParser.EdgesParser.NodeParser.TrendingTopicDataParser.ContextPhotoParser;
import com.facebook.search.protocol.FetchTrendingEntitiesGraphQLParsers.FetchTrendingEntitiesParser.TrendingEntitiesParser.EdgesParser.QueryParser;
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

/* compiled from: network_error */
public class FetchTrendingEntitiesGraphQLModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1601219162)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: network_error */
    public final class FetchTrendingEntitiesModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private TrendingEntitiesModel f8071d;

        /* compiled from: network_error */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FetchTrendingEntitiesModel.class, new Deserializer());
            }

            public Object m8851a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = FetchTrendingEntitiesParser.m8911a(jsonParser);
                Object fetchTrendingEntitiesModel = new FetchTrendingEntitiesModel();
                ((BaseModel) fetchTrendingEntitiesModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (fetchTrendingEntitiesModel instanceof Postprocessable) {
                    return ((Postprocessable) fetchTrendingEntitiesModel).a();
                }
                return fetchTrendingEntitiesModel;
            }
        }

        /* compiled from: network_error */
        public class Serializer extends JsonSerializer<FetchTrendingEntitiesModel> {
            public final void m8852a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                FetchTrendingEntitiesModel fetchTrendingEntitiesModel = (FetchTrendingEntitiesModel) obj;
                if (fetchTrendingEntitiesModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(fetchTrendingEntitiesModel.m8897a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    fetchTrendingEntitiesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = fetchTrendingEntitiesModel.w_();
                int u_ = fetchTrendingEntitiesModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("trending_entities");
                    TrendingEntitiesParser.m8910a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(FetchTrendingEntitiesModel.class, new Serializer());
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 2139641290)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: network_error */
        public final class TrendingEntitiesModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<EdgesModel> f8070d;

            /* compiled from: network_error */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(TrendingEntitiesModel.class, new Deserializer());
                }

                public Object m8853a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(TrendingEntitiesParser.m8909a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object trendingEntitiesModel = new TrendingEntitiesModel();
                    ((BaseModel) trendingEntitiesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (trendingEntitiesModel instanceof Postprocessable) {
                        return ((Postprocessable) trendingEntitiesModel).a();
                    }
                    return trendingEntitiesModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 1867114131)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: network_error */
            public final class EdgesModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private NodeModel f8066d;
                @Nullable
                private String f8067e;
                @Nullable
                private QueryModel f8068f;
                @Nullable
                private String f8069g;

                /* compiled from: network_error */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(EdgesModel.class, new Deserializer());
                    }

                    public Object m8854a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(EdgesParser.m8907b(jsonParser, flatBufferBuilder));
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
                @ModelWithFlatBufferFormatHash(a = -1986884162)
                @JsonSerialize(using = Serializer.class)
                @FragmentModelWithoutBridge
                /* compiled from: network_error */
                public final class NodeModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
                    @Nullable
                    private GraphQLObjectType f8059d;
                    @Nullable
                    private String f8060e;
                    @Nullable
                    private String f8061f;
                    @Nullable
                    private TrendingTopicDataModel f8062g;
                    @Nullable
                    private String f8063h;
                    @Nullable
                    private String f8064i;

                    /* compiled from: network_error */
                    public class Deserializer extends FbJsonDeserializer {
                        static {
                            GlobalAutoGenDeserializerCache.a(NodeModel.class, new Deserializer());
                        }

                        public Object m8855a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(NodeParser.m8903a(jsonParser, flatBufferBuilder));
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

                    /* compiled from: network_error */
                    public class Serializer extends JsonSerializer<NodeModel> {
                        public final void m8856a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            NodeModel nodeModel = (NodeModel) obj;
                            if (nodeModel.w_() == null) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(nodeModel.m8875a(flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                nodeModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                            }
                            NodeParser.m8904a(nodeModel.w_(), nodeModel.u_(), jsonGenerator, serializerProvider);
                        }

                        static {
                            FbSerializerProvider.a(NodeModel.class, new Serializer());
                        }
                    }

                    @JsonDeserialize(using = Deserializer.class)
                    @ModelWithFlatBufferFormatHash(a = 649605281)
                    @JsonSerialize(using = Serializer.class)
                    @FragmentModelWithoutBridge
                    /* compiled from: network_error */
                    public final class TrendingTopicDataModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
                        @Nullable
                        private ContextPhotoModel f8057d;
                        @Nullable
                        private String f8058e;

                        @JsonDeserialize(using = Deserializer.class)
                        @ModelWithFlatBufferFormatHash(a = 842551240)
                        @JsonSerialize(using = Serializer.class)
                        @FragmentModelWithoutBridge
                        /* compiled from: network_error */
                        public final class ContextPhotoModel extends BaseModel implements GraphQLVisitableModel {
                            @Nullable
                            private String f8056d;

                            /* compiled from: network_error */
                            public class Deserializer extends FbJsonDeserializer {
                                static {
                                    GlobalAutoGenDeserializerCache.a(ContextPhotoModel.class, new Deserializer());
                                }

                                public Object m8857a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                    flatBufferBuilder.d(ContextPhotoParser.m8899a(jsonParser, flatBufferBuilder));
                                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                    wrap.position(0);
                                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                                    Object contextPhotoModel = new ContextPhotoModel();
                                    ((BaseModel) contextPhotoModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                                    if (contextPhotoModel instanceof Postprocessable) {
                                        return ((Postprocessable) contextPhotoModel).a();
                                    }
                                    return contextPhotoModel;
                                }
                            }

                            /* compiled from: network_error */
                            public class Serializer extends JsonSerializer<ContextPhotoModel> {
                                public final void m8858a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                                    ContextPhotoModel contextPhotoModel = (ContextPhotoModel) obj;
                                    if (contextPhotoModel.w_() == null) {
                                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                        flatBufferBuilder.d(contextPhotoModel.m8860a(flatBufferBuilder));
                                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                        wrap.position(0);
                                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                        contextPhotoModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                                    }
                                    ContextPhotoParser.m8900a(contextPhotoModel.w_(), contextPhotoModel.u_(), jsonGenerator);
                                }

                                static {
                                    FbSerializerProvider.a(ContextPhotoModel.class, new Serializer());
                                }
                            }

                            public ContextPhotoModel() {
                                super(1);
                            }

                            @Nullable
                            private String m8859a() {
                                this.f8056d = super.a(this.f8056d, 0);
                                return this.f8056d;
                            }

                            public final int jK_() {
                                return 70760763;
                            }

                            public final GraphQLVisitableModel m8861a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                                h();
                                i();
                                return this;
                            }

                            public final int m8860a(FlatBufferBuilder flatBufferBuilder) {
                                h();
                                int b = flatBufferBuilder.b(m8859a());
                                flatBufferBuilder.c(1);
                                flatBufferBuilder.b(0, b);
                                i();
                                return flatBufferBuilder.d();
                            }
                        }

                        /* compiled from: network_error */
                        public class Deserializer extends FbJsonDeserializer {
                            static {
                                GlobalAutoGenDeserializerCache.a(TrendingTopicDataModel.class, new Deserializer());
                            }

                            public Object m8862a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(TrendingTopicDataParser.m8901a(jsonParser, flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                                Object trendingTopicDataModel = new TrendingTopicDataModel();
                                ((BaseModel) trendingTopicDataModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                                if (trendingTopicDataModel instanceof Postprocessable) {
                                    return ((Postprocessable) trendingTopicDataModel).a();
                                }
                                return trendingTopicDataModel;
                            }
                        }

                        /* compiled from: network_error */
                        public class Serializer extends JsonSerializer<TrendingTopicDataModel> {
                            public final void m8863a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                                TrendingTopicDataModel trendingTopicDataModel = (TrendingTopicDataModel) obj;
                                if (trendingTopicDataModel.w_() == null) {
                                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                    flatBufferBuilder.d(trendingTopicDataModel.m8866a(flatBufferBuilder));
                                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                    wrap.position(0);
                                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                    trendingTopicDataModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                                }
                                TrendingTopicDataParser.m8902a(trendingTopicDataModel.w_(), trendingTopicDataModel.u_(), jsonGenerator, serializerProvider);
                            }

                            static {
                                FbSerializerProvider.a(TrendingTopicDataModel.class, new Serializer());
                            }
                        }

                        public TrendingTopicDataModel() {
                            super(2);
                        }

                        @Nullable
                        private ContextPhotoModel m8864j() {
                            this.f8057d = (ContextPhotoModel) super.a(this.f8057d, 0, ContextPhotoModel.class);
                            return this.f8057d;
                        }

                        @Nullable
                        private String m8865k() {
                            this.f8058e = super.a(this.f8058e, 1);
                            return this.f8058e;
                        }

                        @Nullable
                        public final String m8868a() {
                            return m8865k();
                        }

                        public final int jK_() {
                            return -1862466124;
                        }

                        public final GraphQLVisitableModel m8867a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                            GraphQLVisitableModel graphQLVisitableModel = null;
                            h();
                            if (m8864j() != null) {
                                ContextPhotoModel contextPhotoModel = (ContextPhotoModel) graphQLModelMutatingVisitor.b(m8864j());
                                if (m8864j() != contextPhotoModel) {
                                    graphQLVisitableModel = (TrendingTopicDataModel) ModelHelper.a(null, this);
                                    graphQLVisitableModel.f8057d = contextPhotoModel;
                                }
                            }
                            i();
                            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                        }

                        public final int m8866a(FlatBufferBuilder flatBufferBuilder) {
                            h();
                            int a = ModelHelper.a(flatBufferBuilder, m8864j());
                            int b = flatBufferBuilder.b(m8865k());
                            flatBufferBuilder.c(2);
                            flatBufferBuilder.b(0, a);
                            flatBufferBuilder.b(1, b);
                            i();
                            return flatBufferBuilder.d();
                        }
                    }

                    public NodeModel() {
                        super(6);
                    }

                    public final void m8878a(String str, ConsistencyTuple consistencyTuple) {
                        consistencyTuple.a();
                    }

                    public final void m8879a(String str, Object obj, boolean z) {
                    }

                    @Nullable
                    private GraphQLObjectType m8869j() {
                        if (this.b != null && this.f8059d == null) {
                            this.f8059d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                        }
                        return this.f8059d;
                    }

                    @Nullable
                    private String m8870k() {
                        this.f8060e = super.a(this.f8060e, 1);
                        return this.f8060e;
                    }

                    @Nullable
                    private String m8871l() {
                        this.f8061f = super.a(this.f8061f, 2);
                        return this.f8061f;
                    }

                    @Nullable
                    private TrendingTopicDataModel m8872m() {
                        this.f8062g = (TrendingTopicDataModel) super.a(this.f8062g, 3, TrendingTopicDataModel.class);
                        return this.f8062g;
                    }

                    @Nullable
                    private String m8873n() {
                        this.f8063h = super.a(this.f8063h, 4);
                        return this.f8063h;
                    }

                    @Nullable
                    private String m8874o() {
                        this.f8064i = super.a(this.f8064i, 5);
                        return this.f8064i;
                    }

                    @Nullable
                    public final String m8877a() {
                        return m8870k();
                    }

                    public final int jK_() {
                        return 1355227529;
                    }

                    public final GraphQLVisitableModel m8876a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                        GraphQLVisitableModel graphQLVisitableModel = null;
                        h();
                        if (m8872m() != null) {
                            TrendingTopicDataModel trendingTopicDataModel = (TrendingTopicDataModel) graphQLModelMutatingVisitor.b(m8872m());
                            if (m8872m() != trendingTopicDataModel) {
                                graphQLVisitableModel = (NodeModel) ModelHelper.a(null, this);
                                graphQLVisitableModel.f8062g = trendingTopicDataModel;
                            }
                        }
                        i();
                        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                    }

                    public final int m8875a(FlatBufferBuilder flatBufferBuilder) {
                        h();
                        int a = ModelHelper.a(flatBufferBuilder, m8869j());
                        int b = flatBufferBuilder.b(m8870k());
                        int b2 = flatBufferBuilder.b(m8871l());
                        int a2 = ModelHelper.a(flatBufferBuilder, m8872m());
                        int b3 = flatBufferBuilder.b(m8873n());
                        int b4 = flatBufferBuilder.b(m8874o());
                        flatBufferBuilder.c(6);
                        flatBufferBuilder.b(0, a);
                        flatBufferBuilder.b(1, b);
                        flatBufferBuilder.b(2, b2);
                        flatBufferBuilder.b(3, a2);
                        flatBufferBuilder.b(4, b3);
                        flatBufferBuilder.b(5, b4);
                        i();
                        return flatBufferBuilder.d();
                    }
                }

                @JsonDeserialize(using = Deserializer.class)
                @ModelWithFlatBufferFormatHash(a = 515374361)
                @JsonSerialize(using = Serializer.class)
                @FragmentModelWithoutBridge
                /* compiled from: network_error */
                public final class QueryModel extends BaseModel implements GraphQLVisitableModel {
                    @Nullable
                    private String f8065d;

                    /* compiled from: network_error */
                    public class Deserializer extends FbJsonDeserializer {
                        static {
                            GlobalAutoGenDeserializerCache.a(QueryModel.class, new Deserializer());
                        }

                        public Object m8880a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(QueryParser.m8905a(jsonParser, flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            mutableFlatBuffer.a(4, Boolean.valueOf(true));
                            MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                            Object queryModel = new QueryModel();
                            ((BaseModel) queryModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                            if (queryModel instanceof Postprocessable) {
                                return ((Postprocessable) queryModel).a();
                            }
                            return queryModel;
                        }
                    }

                    /* compiled from: network_error */
                    public class Serializer extends JsonSerializer<QueryModel> {
                        public final void m8881a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            QueryModel queryModel = (QueryModel) obj;
                            if (queryModel.w_() == null) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(queryModel.m8883a(flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                queryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                            }
                            QueryParser.m8906a(queryModel.w_(), queryModel.u_(), jsonGenerator);
                        }

                        static {
                            FbSerializerProvider.a(QueryModel.class, new Serializer());
                        }
                    }

                    public QueryModel() {
                        super(1);
                    }

                    @Nullable
                    private String m8882a() {
                        this.f8065d = super.a(this.f8065d, 0);
                        return this.f8065d;
                    }

                    public final int jK_() {
                        return -466486798;
                    }

                    public final GraphQLVisitableModel m8884a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                        h();
                        i();
                        return this;
                    }

                    public final int m8883a(FlatBufferBuilder flatBufferBuilder) {
                        h();
                        int b = flatBufferBuilder.b(m8882a());
                        flatBufferBuilder.c(1);
                        flatBufferBuilder.b(0, b);
                        i();
                        return flatBufferBuilder.d();
                    }
                }

                /* compiled from: network_error */
                public class Serializer extends JsonSerializer<EdgesModel> {
                    public final void m8885a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        EdgesModel edgesModel = (EdgesModel) obj;
                        if (edgesModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(edgesModel.m8890a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            edgesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        EdgesParser.m8908b(edgesModel.w_(), edgesModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(EdgesModel.class, new Serializer());
                    }
                }

                public EdgesModel() {
                    super(4);
                }

                @Nullable
                private NodeModel m8886a() {
                    this.f8066d = (NodeModel) super.a(this.f8066d, 0, NodeModel.class);
                    return this.f8066d;
                }

                @Nullable
                private String m8887j() {
                    this.f8067e = super.a(this.f8067e, 1);
                    return this.f8067e;
                }

                @Nullable
                private QueryModel m8888k() {
                    this.f8068f = (QueryModel) super.a(this.f8068f, 2, QueryModel.class);
                    return this.f8068f;
                }

                @Nullable
                private String m8889l() {
                    this.f8069g = super.a(this.f8069g, 3);
                    return this.f8069g;
                }

                public final int jK_() {
                    return -817385725;
                }

                public final GraphQLVisitableModel m8891a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m8886a() != null) {
                        NodeModel nodeModel = (NodeModel) graphQLModelMutatingVisitor.b(m8886a());
                        if (m8886a() != nodeModel) {
                            graphQLVisitableModel = (EdgesModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f8066d = nodeModel;
                        }
                    }
                    if (m8888k() != null) {
                        QueryModel queryModel = (QueryModel) graphQLModelMutatingVisitor.b(m8888k());
                        if (m8888k() != queryModel) {
                            graphQLVisitableModel = (EdgesModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f8068f = queryModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m8890a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m8886a());
                    int b = flatBufferBuilder.b(m8887j());
                    int a2 = ModelHelper.a(flatBufferBuilder, m8888k());
                    int b2 = flatBufferBuilder.b(m8889l());
                    flatBufferBuilder.c(4);
                    flatBufferBuilder.b(0, a);
                    flatBufferBuilder.b(1, b);
                    flatBufferBuilder.b(2, a2);
                    flatBufferBuilder.b(3, b2);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: network_error */
            public class Serializer extends JsonSerializer<TrendingEntitiesModel> {
                public final void m8892a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    TrendingEntitiesModel trendingEntitiesModel = (TrendingEntitiesModel) obj;
                    if (trendingEntitiesModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(trendingEntitiesModel.m8894a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        trendingEntitiesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    TrendingEntitiesParser.m8910a(trendingEntitiesModel.w_(), trendingEntitiesModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(TrendingEntitiesModel.class, new Serializer());
                }
            }

            public TrendingEntitiesModel() {
                super(1);
            }

            @Nonnull
            private ImmutableList<EdgesModel> m8893a() {
                this.f8070d = super.a(this.f8070d, 0, EdgesModel.class);
                return (ImmutableList) this.f8070d;
            }

            public final int jK_() {
                return -623103068;
            }

            public final GraphQLVisitableModel m8895a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m8893a() != null) {
                    Builder a = ModelHelper.a(m8893a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (TrendingEntitiesModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f8070d = a.b();
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m8894a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m8893a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        public FetchTrendingEntitiesModel() {
            super(1);
        }

        @Nullable
        private TrendingEntitiesModel m8896a() {
            this.f8071d = (TrendingEntitiesModel) super.a(this.f8071d, 0, TrendingEntitiesModel.class);
            return this.f8071d;
        }

        public final int jK_() {
            return -1732764110;
        }

        public final GraphQLVisitableModel m8898a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m8896a() != null) {
                TrendingEntitiesModel trendingEntitiesModel = (TrendingEntitiesModel) graphQLModelMutatingVisitor.b(m8896a());
                if (m8896a() != trendingEntitiesModel) {
                    graphQLVisitableModel = (FetchTrendingEntitiesModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f8071d = trendingEntitiesModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m8897a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m8896a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }
}
