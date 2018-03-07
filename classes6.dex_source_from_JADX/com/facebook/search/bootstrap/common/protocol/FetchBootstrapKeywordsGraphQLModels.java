package com.facebook.search.bootstrap.common.protocol;

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
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.search.bootstrap.common.protocol.FetchBootstrapKeywordsGraphQLParsers.BootstrapKeywordsEdgeFragmentParser;
import com.facebook.search.bootstrap.common.protocol.FetchBootstrapKeywordsGraphQLParsers.BootstrapKeywordsEdgeFragmentParser.EdgesParser;
import com.facebook.search.bootstrap.common.protocol.FetchBootstrapKeywordsGraphQLParsers.BootstrapKeywordsEdgeFragmentParser.EdgesParser.NodeParser;
import com.facebook.search.bootstrap.common.protocol.FetchBootstrapKeywordsGraphQLParsers.FetchBootstrapKeywordsParser;
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

/* compiled from: extra_category_level */
public class FetchBootstrapKeywordsGraphQLModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1060757179)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: extra_category_level */
    public final class BootstrapKeywordsEdgeFragmentModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private List<EdgesModel> f15627d;

        /* compiled from: extra_category_level */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(BootstrapKeywordsEdgeFragmentModel.class, new Deserializer());
            }

            public Object m23310a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(BootstrapKeywordsEdgeFragmentParser.m23340a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object bootstrapKeywordsEdgeFragmentModel = new BootstrapKeywordsEdgeFragmentModel();
                ((BaseModel) bootstrapKeywordsEdgeFragmentModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (bootstrapKeywordsEdgeFragmentModel instanceof Postprocessable) {
                    return ((Postprocessable) bootstrapKeywordsEdgeFragmentModel).a();
                }
                return bootstrapKeywordsEdgeFragmentModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1450561074)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: extra_category_level */
        public final class EdgesModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private NodeModel f15626d;

            /* compiled from: extra_category_level */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(EdgesModel.class, new Deserializer());
                }

                public Object m23311a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(EdgesParser.m23338b(jsonParser, flatBufferBuilder));
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
            @ModelWithFlatBufferFormatHash(a = 1457738825)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: extra_category_level */
            public final class NodeModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private String f15619d;
                @Nullable
                private String f15620e;
                private double f15621f;
                @Nullable
                private String f15622g;
                @Nullable
                private String f15623h;
                @Nullable
                private String f15624i;
                @Nullable
                private String f15625j;

                /* compiled from: extra_category_level */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(NodeModel.class, new Deserializer());
                    }

                    public Object m23312a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(NodeParser.m23336a(jsonParser, flatBufferBuilder));
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

                /* compiled from: extra_category_level */
                public class Serializer extends JsonSerializer<NodeModel> {
                    public final void m23313a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        NodeModel nodeModel = (NodeModel) obj;
                        if (nodeModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(nodeModel.m23314a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            nodeModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        NodeParser.m23337a(nodeModel.w_(), nodeModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(NodeModel.class, new Serializer());
                    }
                }

                public NodeModel() {
                    super(7);
                }

                @Nullable
                public final String m23316a() {
                    this.f15619d = super.a(this.f15619d, 0);
                    return this.f15619d;
                }

                @Nullable
                public final String m23318b() {
                    this.f15620e = super.a(this.f15620e, 1);
                    return this.f15620e;
                }

                public final double m23319c() {
                    a(0, 2);
                    return this.f15621f;
                }

                @Nullable
                public final String m23320d() {
                    this.f15622g = super.a(this.f15622g, 3);
                    return this.f15622g;
                }

                @Nullable
                public final String cG_() {
                    this.f15623h = super.a(this.f15623h, 4);
                    return this.f15623h;
                }

                @Nullable
                public final String m23321g() {
                    this.f15624i = super.a(this.f15624i, 5);
                    return this.f15624i;
                }

                @Nullable
                public final String cH_() {
                    this.f15625j = super.a(this.f15625j, 6);
                    return this.f15625j;
                }

                public final int jK_() {
                    return -1371131893;
                }

                public final GraphQLVisitableModel m23315a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m23314a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int b = flatBufferBuilder.b(m23316a());
                    int b2 = flatBufferBuilder.b(m23318b());
                    int b3 = flatBufferBuilder.b(m23320d());
                    int b4 = flatBufferBuilder.b(cG_());
                    int b5 = flatBufferBuilder.b(m23321g());
                    int b6 = flatBufferBuilder.b(cH_());
                    flatBufferBuilder.c(7);
                    flatBufferBuilder.b(0, b);
                    flatBufferBuilder.b(1, b2);
                    flatBufferBuilder.a(2, this.f15621f, 0.0d);
                    flatBufferBuilder.b(3, b3);
                    flatBufferBuilder.b(4, b4);
                    flatBufferBuilder.b(5, b5);
                    flatBufferBuilder.b(6, b6);
                    i();
                    return flatBufferBuilder.d();
                }

                public final void m23317a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                    super.a(mutableFlatBuffer, i, obj);
                    this.f15621f = mutableFlatBuffer.a(i, 2, 0.0d);
                }
            }

            /* compiled from: extra_category_level */
            public class Serializer extends JsonSerializer<EdgesModel> {
                public final void m23322a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    EdgesModel edgesModel = (EdgesModel) obj;
                    if (edgesModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(edgesModel.m23324a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        edgesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    EdgesParser.m23339b(edgesModel.w_(), edgesModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(EdgesModel.class, new Serializer());
                }
            }

            @Nullable
            public final /* synthetic */ NodeModel m23326a() {
                return m23323j();
            }

            public EdgesModel() {
                super(1);
            }

            @Nullable
            private NodeModel m23323j() {
                this.f15626d = (NodeModel) super.a(this.f15626d, 0, NodeModel.class);
                return this.f15626d;
            }

            public final int jK_() {
                return -31598091;
            }

            public final GraphQLVisitableModel m23325a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m23323j() != null) {
                    NodeModel nodeModel = (NodeModel) graphQLModelMutatingVisitor.b(m23323j());
                    if (m23323j() != nodeModel) {
                        graphQLVisitableModel = (EdgesModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f15626d = nodeModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m23324a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m23323j());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: extra_category_level */
        public class Serializer extends JsonSerializer<BootstrapKeywordsEdgeFragmentModel> {
            public final void m23327a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                BootstrapKeywordsEdgeFragmentModel bootstrapKeywordsEdgeFragmentModel = (BootstrapKeywordsEdgeFragmentModel) obj;
                if (bootstrapKeywordsEdgeFragmentModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(bootstrapKeywordsEdgeFragmentModel.m23328a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    bootstrapKeywordsEdgeFragmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                BootstrapKeywordsEdgeFragmentParser.m23341a(bootstrapKeywordsEdgeFragmentModel.w_(), bootstrapKeywordsEdgeFragmentModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(BootstrapKeywordsEdgeFragmentModel.class, new Serializer());
            }
        }

        public BootstrapKeywordsEdgeFragmentModel() {
            super(1);
        }

        @Nonnull
        public final ImmutableList<EdgesModel> m23330a() {
            this.f15627d = super.a(this.f15627d, 0, EdgesModel.class);
            return (ImmutableList) this.f15627d;
        }

        public final int jK_() {
            return -661724906;
        }

        public final GraphQLVisitableModel m23329a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m23330a() != null) {
                Builder a = ModelHelper.a(m23330a(), graphQLModelMutatingVisitor);
                if (a != null) {
                    graphQLVisitableModel = (BootstrapKeywordsEdgeFragmentModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f15627d = a.b();
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m23328a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m23330a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -113592307)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: extra_category_level */
    public final class FetchBootstrapKeywordsModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private BootstrapKeywordsEdgeFragmentModel f15628d;

        /* compiled from: extra_category_level */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FetchBootstrapKeywordsModel.class, new Deserializer());
            }

            public Object m23331a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = FetchBootstrapKeywordsParser.m23342a(jsonParser);
                Object fetchBootstrapKeywordsModel = new FetchBootstrapKeywordsModel();
                ((BaseModel) fetchBootstrapKeywordsModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (fetchBootstrapKeywordsModel instanceof Postprocessable) {
                    return ((Postprocessable) fetchBootstrapKeywordsModel).a();
                }
                return fetchBootstrapKeywordsModel;
            }
        }

        /* compiled from: extra_category_level */
        public class Serializer extends JsonSerializer<FetchBootstrapKeywordsModel> {
            public final void m23332a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                FetchBootstrapKeywordsModel fetchBootstrapKeywordsModel = (FetchBootstrapKeywordsModel) obj;
                if (fetchBootstrapKeywordsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(fetchBootstrapKeywordsModel.m23333a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    fetchBootstrapKeywordsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = fetchBootstrapKeywordsModel.w_();
                int u_ = fetchBootstrapKeywordsModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("bootstrap_keywords");
                    BootstrapKeywordsEdgeFragmentParser.m23341a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(FetchBootstrapKeywordsModel.class, new Serializer());
            }
        }

        public FetchBootstrapKeywordsModel() {
            super(1);
        }

        @Nullable
        public final BootstrapKeywordsEdgeFragmentModel m23335a() {
            this.f15628d = (BootstrapKeywordsEdgeFragmentModel) super.a(this.f15628d, 0, BootstrapKeywordsEdgeFragmentModel.class);
            return this.f15628d;
        }

        public final int jK_() {
            return -1732764110;
        }

        public final GraphQLVisitableModel m23334a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m23335a() != null) {
                BootstrapKeywordsEdgeFragmentModel bootstrapKeywordsEdgeFragmentModel = (BootstrapKeywordsEdgeFragmentModel) graphQLModelMutatingVisitor.b(m23335a());
                if (m23335a() != bootstrapKeywordsEdgeFragmentModel) {
                    graphQLVisitableModel = (FetchBootstrapKeywordsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f15628d = bootstrapKeywordsEdgeFragmentModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m23333a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m23335a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }
}
