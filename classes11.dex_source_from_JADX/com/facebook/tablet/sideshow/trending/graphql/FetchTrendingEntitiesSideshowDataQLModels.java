package com.facebook.tablet.sideshow.trending.graphql;

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
import com.facebook.tablet.sideshow.trending.graphql.FetchTrendingEntitiesSideshowDataQLParsers.FetchTrendingEntitiesSideshowDataParser;
import com.facebook.tablet.sideshow.trending.graphql.FetchTrendingEntitiesSideshowDataQLParsers.FetchTrendingEntitiesSideshowDataParser.TrendingEntitiesParser;
import com.facebook.tablet.sideshow.trending.graphql.FetchTrendingEntitiesSideshowDataQLParsers.FetchTrendingEntitiesSideshowDataParser.TrendingEntitiesParser.EdgesParser;
import com.facebook.tablet.sideshow.trending.graphql.FetchTrendingEntitiesSideshowDataQLParsers.FetchTrendingEntitiesSideshowDataParser.TrendingEntitiesParser.EdgesParser.NodeParser;
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

/* compiled from: ofile */
public class FetchTrendingEntitiesSideshowDataQLModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1343884002)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: ofile */
    public final class FetchTrendingEntitiesSideshowDataModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private TrendingEntitiesModel f4884d;

        /* compiled from: ofile */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FetchTrendingEntitiesSideshowDataModel.class, new Deserializer());
            }

            public Object m6077a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = FetchTrendingEntitiesSideshowDataParser.m6109a(jsonParser);
                Object fetchTrendingEntitiesSideshowDataModel = new FetchTrendingEntitiesSideshowDataModel();
                ((BaseModel) fetchTrendingEntitiesSideshowDataModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (fetchTrendingEntitiesSideshowDataModel instanceof Postprocessable) {
                    return ((Postprocessable) fetchTrendingEntitiesSideshowDataModel).a();
                }
                return fetchTrendingEntitiesSideshowDataModel;
            }
        }

        /* compiled from: ofile */
        public class Serializer extends JsonSerializer<FetchTrendingEntitiesSideshowDataModel> {
            public final void m6078a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                FetchTrendingEntitiesSideshowDataModel fetchTrendingEntitiesSideshowDataModel = (FetchTrendingEntitiesSideshowDataModel) obj;
                if (fetchTrendingEntitiesSideshowDataModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(fetchTrendingEntitiesSideshowDataModel.m6100a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    fetchTrendingEntitiesSideshowDataModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = fetchTrendingEntitiesSideshowDataModel.w_();
                int u_ = fetchTrendingEntitiesSideshowDataModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("trending_entities");
                    TrendingEntitiesParser.m6108a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(FetchTrendingEntitiesSideshowDataModel.class, new Serializer());
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 449047959)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: ofile */
        public final class TrendingEntitiesModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<EdgesModel> f4883d;

            /* compiled from: ofile */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(TrendingEntitiesModel.class, new Deserializer());
                }

                public Object m6079a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(TrendingEntitiesParser.m6107a(r11, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object trendingEntitiesModel = new TrendingEntitiesModel();
                    ((BaseModel) trendingEntitiesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), r11);
                    if (trendingEntitiesModel instanceof Postprocessable) {
                        return ((Postprocessable) trendingEntitiesModel).a();
                    }
                    return trendingEntitiesModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -1315770079)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: ofile */
            public final class EdgesModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private NodeModel f4882d;

                /* compiled from: ofile */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(EdgesModel.class, new Deserializer());
                    }

                    public Object m6080a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(EdgesParser.m6105b(r11, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object edgesModel = new EdgesModel();
                        ((BaseModel) edgesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), r11);
                        if (edgesModel instanceof Postprocessable) {
                            return ((Postprocessable) edgesModel).a();
                        }
                        return edgesModel;
                    }
                }

                @JsonDeserialize(using = Deserializer.class)
                @ModelWithFlatBufferFormatHash(a = 1466415797)
                @JsonSerialize(using = Serializer.class)
                @FragmentModelWithoutBridge
                /* compiled from: ofile */
                public final class NodeModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
                    @Nullable
                    private GraphQLObjectType f4878d;
                    @Nullable
                    private String f4879e;
                    @Nullable
                    private String f4880f;
                    @Nullable
                    private String f4881g;

                    /* compiled from: ofile */
                    public class Deserializer extends FbJsonDeserializer {
                        static {
                            GlobalAutoGenDeserializerCache.a(NodeModel.class, new Deserializer());
                        }

                        public Object m6081a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(NodeParser.m6103a(r11, flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            mutableFlatBuffer.a(4, Boolean.valueOf(true));
                            MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                            Object nodeModel = new NodeModel();
                            ((BaseModel) nodeModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), r11);
                            if (nodeModel instanceof Postprocessable) {
                                return ((Postprocessable) nodeModel).a();
                            }
                            return nodeModel;
                        }
                    }

                    /* compiled from: ofile */
                    public class Serializer extends JsonSerializer<NodeModel> {
                        public final void m6082a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            NodeModel nodeModel = (NodeModel) r8;
                            if (nodeModel.w_() == null) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(nodeModel.m6084a(flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                nodeModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                            }
                            NodeParser.m6104a(nodeModel.w_(), nodeModel.u_(), r9);
                        }

                        static {
                            FbSerializerProvider.a(NodeModel.class, new Serializer());
                        }
                    }

                    public NodeModel() {
                        super(4);
                    }

                    public final void m6087a(String str, ConsistencyTuple consistencyTuple) {
                        r2.a();
                    }

                    public final void m6088a(String str, Object obj, boolean z) {
                    }

                    @Nullable
                    private GraphQLObjectType m6083m() {
                        if (this.b != null && this.f4878d == null) {
                            this.f4878d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                        }
                        return this.f4878d;
                    }

                    @Nullable
                    public final String m6089j() {
                        this.f4879e = super.a(this.f4879e, 1);
                        return this.f4879e;
                    }

                    @Nullable
                    public final String m6090k() {
                        this.f4880f = super.a(this.f4880f, 2);
                        return this.f4880f;
                    }

                    @Nullable
                    public final String m6091l() {
                        this.f4881g = super.a(this.f4881g, 3);
                        return this.f4881g;
                    }

                    @Nullable
                    public final String m6086a() {
                        return m6089j();
                    }

                    public final int jK_() {
                        return 1355227529;
                    }

                    public final GraphQLVisitableModel m6085a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                        h();
                        i();
                        return this;
                    }

                    public final int m6084a(FlatBufferBuilder flatBufferBuilder) {
                        h();
                        int a = ModelHelper.a(r6, m6083m());
                        int b = r6.b(m6089j());
                        int b2 = r6.b(m6090k());
                        int b3 = r6.b(m6091l());
                        r6.c(4);
                        r6.b(0, a);
                        r6.b(1, b);
                        r6.b(2, b2);
                        r6.b(3, b3);
                        i();
                        return r6.d();
                    }
                }

                /* compiled from: ofile */
                public class Serializer extends JsonSerializer<EdgesModel> {
                    public final void m6092a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        EdgesModel edgesModel = (EdgesModel) r8;
                        if (edgesModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(edgesModel.m6093a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            edgesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        EdgesParser.m6106b(edgesModel.w_(), edgesModel.u_(), r9, r10);
                    }

                    static {
                        FbSerializerProvider.a(EdgesModel.class, new Serializer());
                    }
                }

                public EdgesModel() {
                    super(1);
                }

                @Nullable
                public final NodeModel m6095a() {
                    this.f4882d = (NodeModel) super.a(this.f4882d, 0, NodeModel.class);
                    return this.f4882d;
                }

                public final int jK_() {
                    return -817385725;
                }

                public final GraphQLVisitableModel m6094a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m6095a() != null) {
                        NodeModel nodeModel = (NodeModel) r4.b(m6095a());
                        if (m6095a() != nodeModel) {
                            graphQLVisitableModel = (EdgesModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f4882d = nodeModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m6093a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(r3, m6095a());
                    r3.c(1);
                    r3.b(0, a);
                    i();
                    return r3.d();
                }
            }

            /* compiled from: ofile */
            public class Serializer extends JsonSerializer<TrendingEntitiesModel> {
                public final void m6096a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    TrendingEntitiesModel trendingEntitiesModel = (TrendingEntitiesModel) r8;
                    if (trendingEntitiesModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(trendingEntitiesModel.m6097a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        trendingEntitiesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    TrendingEntitiesParser.m6108a(trendingEntitiesModel.w_(), trendingEntitiesModel.u_(), r9, r10);
                }

                static {
                    FbSerializerProvider.a(TrendingEntitiesModel.class, new Serializer());
                }
            }

            public TrendingEntitiesModel() {
                super(1);
            }

            @Nonnull
            public final ImmutableList<EdgesModel> m6099a() {
                this.f4883d = super.a(this.f4883d, 0, EdgesModel.class);
                return (ImmutableList) this.f4883d;
            }

            public final int jK_() {
                return -623103068;
            }

            public final GraphQLVisitableModel m6098a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m6099a() != null) {
                    Builder a = ModelHelper.a(m6099a(), r3);
                    if (a != null) {
                        graphQLVisitableModel = (TrendingEntitiesModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f4883d = a.b();
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m6097a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(r3, m6099a());
                r3.c(1);
                r3.b(0, a);
                i();
                return r3.d();
            }
        }

        public FetchTrendingEntitiesSideshowDataModel() {
            super(1);
        }

        @Nullable
        public final TrendingEntitiesModel m6102a() {
            this.f4884d = (TrendingEntitiesModel) super.a(this.f4884d, 0, TrendingEntitiesModel.class);
            return this.f4884d;
        }

        public final int jK_() {
            return -1732764110;
        }

        public final GraphQLVisitableModel m6101a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m6102a() != null) {
                TrendingEntitiesModel trendingEntitiesModel = (TrendingEntitiesModel) graphQLModelMutatingVisitor.b(m6102a());
                if (m6102a() != trendingEntitiesModel) {
                    graphQLVisitableModel = (FetchTrendingEntitiesSideshowDataModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f4884d = trendingEntitiesModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m6100a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m6102a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }
}
