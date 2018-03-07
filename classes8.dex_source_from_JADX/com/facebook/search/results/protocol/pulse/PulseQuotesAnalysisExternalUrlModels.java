package com.facebook.search.results.protocol.pulse;

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
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.search.results.protocol.pulse.PulseQuotesAnalysisExternalUrlInterfaces.PulseQuotesAnalysisExternalUrl;
import com.facebook.search.results.protocol.pulse.PulseQuotesAnalysisExternalUrlParsers.PulseQuotesAnalysisExternalUrlParser;
import com.facebook.search.results.protocol.pulse.PulseQuotesAnalysisExternalUrlParsers.PulseQuotesAnalysisExternalUrlParser.QuotesAnalysisParser;
import com.facebook.search.results.protocol.pulse.PulseQuotesAnalysisExternalUrlParsers.PulseQuotesAnalysisExternalUrlParser.QuotesAnalysisParser.QuotesParser;
import com.facebook.search.results.protocol.pulse.PulseQuotesAnalysisExternalUrlParsers.PulseQuotesAnalysisExternalUrlParser.QuotesAnalysisParser.QuotesParser.EdgesParser;
import com.facebook.search.results.protocol.pulse.PulseQuotesAnalysisExternalUrlParsers.PulseQuotesAnalysisExternalUrlParser.QuotesAnalysisParser.QuotesParser.EdgesParser.NodeParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.google.common.collect.ImmutableList;
import java.nio.ByteBuffer;
import java.util.List;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/* compiled from: messenger_content_page_subscribe */
public class PulseQuotesAnalysisExternalUrlModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1757882259)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: messenger_content_page_subscribe */
    public final class PulseQuotesAnalysisExternalUrlModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel, PulseQuotesAnalysisExternalUrl {
        @Nullable
        private String f8799d;
        @Nullable
        private QuotesAnalysisModel f8800e;

        /* compiled from: messenger_content_page_subscribe */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(PulseQuotesAnalysisExternalUrlModel.class, new Deserializer());
            }

            public Object m10373a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = PulseQuotesAnalysisExternalUrlParser.m10416a(jsonParser);
                Object pulseQuotesAnalysisExternalUrlModel = new PulseQuotesAnalysisExternalUrlModel();
                ((BaseModel) pulseQuotesAnalysisExternalUrlModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (pulseQuotesAnalysisExternalUrlModel instanceof Postprocessable) {
                    return ((Postprocessable) pulseQuotesAnalysisExternalUrlModel).a();
                }
                return pulseQuotesAnalysisExternalUrlModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -785593383)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: messenger_content_page_subscribe */
        public final class QuotesAnalysisModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private QuotesModel f8798d;

            /* compiled from: messenger_content_page_subscribe */
            public final class Builder {
                @Nullable
                public QuotesModel f8789a;
            }

            /* compiled from: messenger_content_page_subscribe */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(QuotesAnalysisModel.class, new Deserializer());
                }

                public Object m10374a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(QuotesAnalysisParser.m10414a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object quotesAnalysisModel = new QuotesAnalysisModel();
                    ((BaseModel) quotesAnalysisModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (quotesAnalysisModel instanceof Postprocessable) {
                        return ((Postprocessable) quotesAnalysisModel).a();
                    }
                    return quotesAnalysisModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 472427140)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: messenger_content_page_subscribe */
            public final class QuotesModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private List<EdgesModel> f8797d;

                /* compiled from: messenger_content_page_subscribe */
                public final class Builder {
                    @Nullable
                    public ImmutableList<EdgesModel> f8790a;
                }

                /* compiled from: messenger_content_page_subscribe */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(QuotesModel.class, new Deserializer());
                    }

                    public Object m10375a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(QuotesParser.m10412a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object quotesModel = new QuotesModel();
                        ((BaseModel) quotesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (quotesModel instanceof Postprocessable) {
                            return ((Postprocessable) quotesModel).a();
                        }
                        return quotesModel;
                    }
                }

                @JsonDeserialize(using = Deserializer.class)
                @ModelWithFlatBufferFormatHash(a = 972524935)
                @JsonSerialize(using = Serializer.class)
                @FragmentModelWithoutBridge
                /* compiled from: messenger_content_page_subscribe */
                public final class EdgesModel extends BaseModel implements GraphQLVisitableModel {
                    @Nullable
                    private NodeModel f8796d;

                    /* compiled from: messenger_content_page_subscribe */
                    public final class Builder {
                        @Nullable
                        public NodeModel f8791a;
                    }

                    /* compiled from: messenger_content_page_subscribe */
                    public class Deserializer extends FbJsonDeserializer {
                        static {
                            GlobalAutoGenDeserializerCache.a(EdgesModel.class, new Deserializer());
                        }

                        public Object m10376a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(EdgesParser.m10410b(jsonParser, flatBufferBuilder));
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
                    @ModelWithFlatBufferFormatHash(a = 773897974)
                    @JsonSerialize(using = Serializer.class)
                    @FragmentModelWithoutBridge
                    /* compiled from: messenger_content_page_subscribe */
                    public final class NodeModel extends BaseModel implements GraphQLVisitableModel {
                        private int f8794d;
                        @Nullable
                        private String f8795e;

                        /* compiled from: messenger_content_page_subscribe */
                        public final class Builder {
                            public int f8792a;
                            @Nullable
                            public String f8793b;
                        }

                        /* compiled from: messenger_content_page_subscribe */
                        public class Deserializer extends FbJsonDeserializer {
                            static {
                                GlobalAutoGenDeserializerCache.a(NodeModel.class, new Deserializer());
                            }

                            public Object m10377a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(NodeParser.m10408a(jsonParser, flatBufferBuilder));
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

                        /* compiled from: messenger_content_page_subscribe */
                        public class Serializer extends JsonSerializer<NodeModel> {
                            public final void m10378a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                                NodeModel nodeModel = (NodeModel) obj;
                                if (nodeModel.w_() == null) {
                                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                    flatBufferBuilder.d(nodeModel.m10381a(flatBufferBuilder));
                                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                    wrap.position(0);
                                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                    nodeModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                                }
                                NodeParser.m10409a(nodeModel.w_(), nodeModel.u_(), jsonGenerator);
                            }

                            static {
                                FbSerializerProvider.a(NodeModel.class, new Serializer());
                            }
                        }

                        public NodeModel() {
                            super(2);
                        }

                        public NodeModel(MutableFlatBuffer mutableFlatBuffer) {
                            super(2);
                            a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }

                        public final int m10380a() {
                            a(0, 0);
                            return this.f8794d;
                        }

                        @Nullable
                        public final String m10384b() {
                            this.f8795e = super.a(this.f8795e, 1);
                            return this.f8795e;
                        }

                        public static NodeModel m10379a(NodeModel nodeModel) {
                            if (nodeModel == null) {
                                return null;
                            }
                            if (nodeModel instanceof NodeModel) {
                                return nodeModel;
                            }
                            Builder builder = new Builder();
                            builder.f8792a = nodeModel.m10380a();
                            builder.f8793b = nodeModel.m10384b();
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            int b = flatBufferBuilder.b(builder.f8793b);
                            flatBufferBuilder.c(2);
                            flatBufferBuilder.a(0, builder.f8792a, 0);
                            flatBufferBuilder.b(1, b);
                            flatBufferBuilder.d(flatBufferBuilder.d());
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            return new NodeModel(new MutableFlatBuffer(wrap, null, null, true, null));
                        }

                        public final int jK_() {
                            return 2019851078;
                        }

                        public final GraphQLVisitableModel m10382a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                            h();
                            i();
                            return this;
                        }

                        public final int m10381a(FlatBufferBuilder flatBufferBuilder) {
                            h();
                            int b = flatBufferBuilder.b(m10384b());
                            flatBufferBuilder.c(2);
                            flatBufferBuilder.a(0, this.f8794d, 0);
                            flatBufferBuilder.b(1, b);
                            i();
                            return flatBufferBuilder.d();
                        }

                        public final void m10383a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                            super.a(mutableFlatBuffer, i, obj);
                            this.f8794d = mutableFlatBuffer.a(i, 0, 0);
                        }
                    }

                    /* compiled from: messenger_content_page_subscribe */
                    public class Serializer extends JsonSerializer<EdgesModel> {
                        public final void m10385a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            EdgesModel edgesModel = (EdgesModel) obj;
                            if (edgesModel.w_() == null) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(edgesModel.m10388a(flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                edgesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                            }
                            EdgesParser.m10411b(edgesModel.w_(), edgesModel.u_(), jsonGenerator, serializerProvider);
                        }

                        static {
                            FbSerializerProvider.a(EdgesModel.class, new Serializer());
                        }
                    }

                    @Nullable
                    public final /* synthetic */ NodeModel m10390a() {
                        return m10387j();
                    }

                    public EdgesModel() {
                        super(1);
                    }

                    public EdgesModel(MutableFlatBuffer mutableFlatBuffer) {
                        super(1);
                        a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }

                    @Nullable
                    private NodeModel m10387j() {
                        this.f8796d = (NodeModel) super.a(this.f8796d, 0, NodeModel.class);
                        return this.f8796d;
                    }

                    public static EdgesModel m10386a(EdgesModel edgesModel) {
                        if (edgesModel == null) {
                            return null;
                        }
                        if (edgesModel instanceof EdgesModel) {
                            return edgesModel;
                        }
                        Builder builder = new Builder();
                        builder.f8791a = NodeModel.m10379a(edgesModel.m10390a());
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        int a = ModelHelper.a(flatBufferBuilder, builder.f8791a);
                        flatBufferBuilder.c(1);
                        flatBufferBuilder.b(0, a);
                        flatBufferBuilder.d(flatBufferBuilder.d());
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        return new EdgesModel(new MutableFlatBuffer(wrap, null, null, true, null));
                    }

                    public final int jK_() {
                        return -2011623094;
                    }

                    public final GraphQLVisitableModel m10389a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                        GraphQLVisitableModel graphQLVisitableModel = null;
                        h();
                        if (m10387j() != null) {
                            NodeModel nodeModel = (NodeModel) graphQLModelMutatingVisitor.b(m10387j());
                            if (m10387j() != nodeModel) {
                                graphQLVisitableModel = (EdgesModel) ModelHelper.a(null, this);
                                graphQLVisitableModel.f8796d = nodeModel;
                            }
                        }
                        i();
                        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                    }

                    public final int m10388a(FlatBufferBuilder flatBufferBuilder) {
                        h();
                        int a = ModelHelper.a(flatBufferBuilder, m10387j());
                        flatBufferBuilder.c(1);
                        flatBufferBuilder.b(0, a);
                        i();
                        return flatBufferBuilder.d();
                    }
                }

                /* compiled from: messenger_content_page_subscribe */
                public class Serializer extends JsonSerializer<QuotesModel> {
                    public final void m10391a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        QuotesModel quotesModel = (QuotesModel) obj;
                        if (quotesModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(quotesModel.m10393a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            quotesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        QuotesParser.m10413a(quotesModel.w_(), quotesModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(QuotesModel.class, new Serializer());
                    }
                }

                public QuotesModel() {
                    super(1);
                }

                public QuotesModel(MutableFlatBuffer mutableFlatBuffer) {
                    super(1);
                    a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }

                @Nonnull
                public final ImmutableList<EdgesModel> m10395a() {
                    this.f8797d = super.a(this.f8797d, 0, EdgesModel.class);
                    return (ImmutableList) this.f8797d;
                }

                public static QuotesModel m10392a(QuotesModel quotesModel) {
                    if (quotesModel == null) {
                        return null;
                    }
                    if (quotesModel instanceof QuotesModel) {
                        return quotesModel;
                    }
                    Builder builder = new Builder();
                    com.google.common.collect.ImmutableList.Builder builder2 = ImmutableList.builder();
                    for (int i = 0; i < quotesModel.m10395a().size(); i++) {
                        builder2.c(EdgesModel.m10386a((EdgesModel) quotesModel.m10395a().get(i)));
                    }
                    builder.f8790a = builder2.b();
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    int a = ModelHelper.a(flatBufferBuilder, builder.f8790a);
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, a);
                    flatBufferBuilder.d(flatBufferBuilder.d());
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    return new QuotesModel(new MutableFlatBuffer(wrap, null, null, true, null));
                }

                public final int jK_() {
                    return -1049197397;
                }

                public final GraphQLVisitableModel m10394a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m10395a() != null) {
                        com.google.common.collect.ImmutableList.Builder a = ModelHelper.a(m10395a(), graphQLModelMutatingVisitor);
                        if (a != null) {
                            graphQLVisitableModel = (QuotesModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f8797d = a.b();
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m10393a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m10395a());
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, a);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: messenger_content_page_subscribe */
            public class Serializer extends JsonSerializer<QuotesAnalysisModel> {
                public final void m10396a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    QuotesAnalysisModel quotesAnalysisModel = (QuotesAnalysisModel) obj;
                    if (quotesAnalysisModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(quotesAnalysisModel.m10399a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        quotesAnalysisModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    QuotesAnalysisParser.m10415a(quotesAnalysisModel.w_(), quotesAnalysisModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(QuotesAnalysisModel.class, new Serializer());
                }
            }

            @Nullable
            public final /* synthetic */ QuotesModel m10401a() {
                return m10398j();
            }

            public QuotesAnalysisModel() {
                super(1);
            }

            public QuotesAnalysisModel(MutableFlatBuffer mutableFlatBuffer) {
                super(1);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            @Nullable
            private QuotesModel m10398j() {
                this.f8798d = (QuotesModel) super.a(this.f8798d, 0, QuotesModel.class);
                return this.f8798d;
            }

            public static QuotesAnalysisModel m10397a(QuotesAnalysisModel quotesAnalysisModel) {
                if (quotesAnalysisModel == null) {
                    return null;
                }
                if (quotesAnalysisModel instanceof QuotesAnalysisModel) {
                    return quotesAnalysisModel;
                }
                Builder builder = new Builder();
                builder.f8789a = QuotesModel.m10392a(quotesAnalysisModel.m10401a());
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int a = ModelHelper.a(flatBufferBuilder, builder.f8789a);
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new QuotesAnalysisModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }

            public final int jK_() {
                return 154701203;
            }

            public final GraphQLVisitableModel m10400a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m10398j() != null) {
                    QuotesModel quotesModel = (QuotesModel) graphQLModelMutatingVisitor.b(m10398j());
                    if (m10398j() != quotesModel) {
                        graphQLVisitableModel = (QuotesAnalysisModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f8798d = quotesModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m10399a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m10398j());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: messenger_content_page_subscribe */
        public class Serializer extends JsonSerializer<PulseQuotesAnalysisExternalUrlModel> {
            public final void m10402a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                PulseQuotesAnalysisExternalUrlModel pulseQuotesAnalysisExternalUrlModel = (PulseQuotesAnalysisExternalUrlModel) obj;
                if (pulseQuotesAnalysisExternalUrlModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(pulseQuotesAnalysisExternalUrlModel.m10405a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    pulseQuotesAnalysisExternalUrlModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = pulseQuotesAnalysisExternalUrlModel.w_();
                int u_ = pulseQuotesAnalysisExternalUrlModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("id");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 0));
                }
                int g = mutableFlatBuffer.g(u_, 1);
                if (g != 0) {
                    jsonGenerator.a("quotes_analysis");
                    QuotesAnalysisParser.m10415a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(PulseQuotesAnalysisExternalUrlModel.class, new Serializer());
            }
        }

        public PulseQuotesAnalysisExternalUrlModel() {
            super(2);
        }

        @Nullable
        private String m10403j() {
            this.f8799d = super.a(this.f8799d, 0);
            return this.f8799d;
        }

        @Nullable
        private QuotesAnalysisModel m10404k() {
            this.f8800e = (QuotesAnalysisModel) super.a(this.f8800e, 1, QuotesAnalysisModel.class);
            return this.f8800e;
        }

        @Nullable
        public final String m10407a() {
            return m10403j();
        }

        public final int jK_() {
            return 514783620;
        }

        public final GraphQLVisitableModel m10406a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m10404k() != null) {
                QuotesAnalysisModel quotesAnalysisModel = (QuotesAnalysisModel) graphQLModelMutatingVisitor.b(m10404k());
                if (m10404k() != quotesAnalysisModel) {
                    graphQLVisitableModel = (PulseQuotesAnalysisExternalUrlModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f8800e = quotesAnalysisModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m10405a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m10403j());
            int a = ModelHelper.a(flatBufferBuilder, m10404k());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, b);
            flatBufferBuilder.b(1, a);
            i();
            return flatBufferBuilder.d();
        }
    }
}
