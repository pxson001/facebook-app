package com.facebook.api.graphql.privacyoptions;

import com.facebook.api.graphql.privacyoptions.NewsFeedPrivacyOptionsGraphQLParsers.PrivacyOptionsFieldsParser;
import com.facebook.api.graphql.privacyoptions.NewsFeedPrivacyOptionsGraphQLParsers.PrivacyOptionsFieldsParser.EdgesParser;
import com.facebook.api.graphql.privacyoptions.NewsFeedPrivacyOptionsGraphQLParsers.PrivacyOptionsFieldsParser.EdgesParser.NodeParser;
import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLPrivacyOptionTagExpansionType;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.privacy.protocol.options.PrivacyOptionsGraphQLInterfaces.PrivacyIconFields;
import com.facebook.privacy.protocol.options.PrivacyOptionsGraphQLInterfaces.PrivacyOptionWithIconFields;
import com.facebook.privacy.protocol.options.PrivacyOptionsGraphQLInterfaces.PrivacyOptionWithLegacyJsonFields;
import com.facebook.privacy.protocol.options.PrivacyOptionsGraphQLModels.PrivacyIconFieldsModel;
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

/* compiled from: tcp_bytes_recvd */
public class NewsFeedPrivacyOptionsGraphQLModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1736792902)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: tcp_bytes_recvd */
    public final class PrivacyOptionsFieldsModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private List<EdgesModel> f2122d;

        /* compiled from: tcp_bytes_recvd */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(PrivacyOptionsFieldsModel.class, new Deserializer());
            }

            public Object m2854a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(PrivacyOptionsFieldsParser.m2878a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object privacyOptionsFieldsModel = new PrivacyOptionsFieldsModel();
                ((BaseModel) privacyOptionsFieldsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (privacyOptionsFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) privacyOptionsFieldsModel).a();
                }
                return privacyOptionsFieldsModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 461030547)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: tcp_bytes_recvd */
        public final class EdgesModel extends BaseModel implements GraphQLVisitableModel {
            private boolean f2120d;
            @Nullable
            private NodeModel f2121e;

            /* compiled from: tcp_bytes_recvd */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(EdgesModel.class, new Deserializer());
                }

                public Object m2855a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(EdgesParser.m2876b(jsonParser, flatBufferBuilder));
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
            @ModelWithFlatBufferFormatHash(a = -600301719)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: tcp_bytes_recvd */
            public final class NodeModel extends BaseModel implements GraphQLVisitableModel, PrivacyOptionWithIconFields, PrivacyOptionWithLegacyJsonFields {
                @Nullable
                private GraphQLPrivacyOptionTagExpansionType f2116d;
                @Nullable
                private PrivacyIconFieldsModel f2117e;
                @Nullable
                private String f2118f;
                @Nullable
                private String f2119g;

                /* compiled from: tcp_bytes_recvd */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(NodeModel.class, new Deserializer());
                    }

                    public Object m2856a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(NodeParser.m2874a(jsonParser, flatBufferBuilder));
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

                /* compiled from: tcp_bytes_recvd */
                public class Serializer extends JsonSerializer<NodeModel> {
                    public final void m2857a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        NodeModel nodeModel = (NodeModel) obj;
                        if (nodeModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(nodeModel.m2861a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            nodeModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        NodeParser.m2875a(nodeModel.w_(), nodeModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(NodeModel.class, new Serializer());
                    }
                }

                @Nullable
                public final /* synthetic */ PrivacyIconFields m2863b() {
                    return m2859j();
                }

                public NodeModel() {
                    super(4);
                }

                @Nullable
                private GraphQLPrivacyOptionTagExpansionType m2858a() {
                    this.f2116d = (GraphQLPrivacyOptionTagExpansionType) super.b(this.f2116d, 0, GraphQLPrivacyOptionTagExpansionType.class, GraphQLPrivacyOptionTagExpansionType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                    return this.f2116d;
                }

                @Nullable
                private PrivacyIconFieldsModel m2859j() {
                    this.f2117e = (PrivacyIconFieldsModel) super.a(this.f2117e, 1, PrivacyIconFieldsModel.class);
                    return this.f2117e;
                }

                @Nullable
                public final String m2864c() {
                    this.f2118f = super.a(this.f2118f, 2);
                    return this.f2118f;
                }

                @Nullable
                private String m2860k() {
                    this.f2119g = super.a(this.f2119g, 3);
                    return this.f2119g;
                }

                public final int jK_() {
                    return -1984364035;
                }

                public final GraphQLVisitableModel m2862a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m2859j() != null) {
                        PrivacyIconFieldsModel privacyIconFieldsModel = (PrivacyIconFieldsModel) graphQLModelMutatingVisitor.b(m2859j());
                        if (m2859j() != privacyIconFieldsModel) {
                            graphQLVisitableModel = (NodeModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f2117e = privacyIconFieldsModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m2861a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = flatBufferBuilder.a(m2858a());
                    int a2 = ModelHelper.a(flatBufferBuilder, m2859j());
                    int b = flatBufferBuilder.b(m2864c());
                    int b2 = flatBufferBuilder.b(m2860k());
                    flatBufferBuilder.c(4);
                    flatBufferBuilder.b(0, a);
                    flatBufferBuilder.b(1, a2);
                    flatBufferBuilder.b(2, b);
                    flatBufferBuilder.b(3, b2);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: tcp_bytes_recvd */
            public class Serializer extends JsonSerializer<EdgesModel> {
                public final void m2865a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    EdgesModel edgesModel = (EdgesModel) obj;
                    if (edgesModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(edgesModel.m2867a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        edgesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    EdgesParser.m2877b(edgesModel.w_(), edgesModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(EdgesModel.class, new Serializer());
                }
            }

            public EdgesModel() {
                super(2);
            }

            @Nullable
            private NodeModel m2866a() {
                this.f2121e = (NodeModel) super.a(this.f2121e, 1, NodeModel.class);
                return this.f2121e;
            }

            public final int jK_() {
                return -1212476960;
            }

            public final GraphQLVisitableModel m2868a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m2866a() != null) {
                    NodeModel nodeModel = (NodeModel) graphQLModelMutatingVisitor.b(m2866a());
                    if (m2866a() != nodeModel) {
                        graphQLVisitableModel = (EdgesModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f2121e = nodeModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m2867a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m2866a());
                flatBufferBuilder.c(2);
                flatBufferBuilder.a(0, this.f2120d);
                flatBufferBuilder.b(1, a);
                i();
                return flatBufferBuilder.d();
            }

            public final void m2869a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f2120d = mutableFlatBuffer.a(i, 0);
            }
        }

        /* compiled from: tcp_bytes_recvd */
        public class Serializer extends JsonSerializer<PrivacyOptionsFieldsModel> {
            public final void m2870a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                PrivacyOptionsFieldsModel privacyOptionsFieldsModel = (PrivacyOptionsFieldsModel) obj;
                if (privacyOptionsFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(privacyOptionsFieldsModel.m2872a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    privacyOptionsFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                PrivacyOptionsFieldsParser.m2879a(privacyOptionsFieldsModel.w_(), privacyOptionsFieldsModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(PrivacyOptionsFieldsModel.class, new Serializer());
            }
        }

        public PrivacyOptionsFieldsModel() {
            super(1);
        }

        @Nonnull
        private ImmutableList<EdgesModel> m2871a() {
            this.f2122d = super.a(this.f2122d, 0, EdgesModel.class);
            return (ImmutableList) this.f2122d;
        }

        public final int jK_() {
            return 780090561;
        }

        public final GraphQLVisitableModel m2873a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m2871a() != null) {
                Builder a = ModelHelper.a(m2871a(), graphQLModelMutatingVisitor);
                if (a != null) {
                    graphQLVisitableModel = (PrivacyOptionsFieldsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f2122d = a.b();
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m2872a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m2871a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }
}
