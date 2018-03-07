package com.facebook.groupcommerce.protocol;

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
import com.facebook.groupcommerce.protocol.FetchGroupCommercePreferredMarketplaceInfoParsers.PreferredMarketplaceQueryParser;
import com.facebook.groupcommerce.protocol.FetchGroupCommercePreferredMarketplaceInfoParsers.PreferredMarketplaceQueryParser.PreferredMarketplacesParser;
import com.facebook.groupcommerce.protocol.FetchGroupCommercePreferredMarketplaceInfoParsers.PreferredMarketplaceQueryParser.PreferredMarketplacesParser.EdgesParser;
import com.facebook.groupcommerce.protocol.FetchGroupCommercePreferredMarketplaceInfoParsers.PreferredMarketplaceQueryParser.PreferredMarketplacesParser.EdgesParser.NodeParser;
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

/* compiled from: recorded_audio_duration */
public class FetchGroupCommercePreferredMarketplaceInfoModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1574884755)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: recorded_audio_duration */
    public final class PreferredMarketplaceQueryModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private PreferredMarketplacesModel f5381d;

        /* compiled from: recorded_audio_duration */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(PreferredMarketplaceQueryModel.class, new Deserializer());
            }

            public Object m5833a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = PreferredMarketplaceQueryParser.m5861a(jsonParser);
                Object preferredMarketplaceQueryModel = new PreferredMarketplaceQueryModel();
                ((BaseModel) preferredMarketplaceQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (preferredMarketplaceQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) preferredMarketplaceQueryModel).a();
                }
                return preferredMarketplaceQueryModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1903903640)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: recorded_audio_duration */
        public final class PreferredMarketplacesModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<EdgesModel> f5380d;

            /* compiled from: recorded_audio_duration */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(PreferredMarketplacesModel.class, new Deserializer());
                }

                public Object m5834a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(PreferredMarketplacesParser.m5859a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object preferredMarketplacesModel = new PreferredMarketplacesModel();
                    ((BaseModel) preferredMarketplacesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (preferredMarketplacesModel instanceof Postprocessable) {
                        return ((Postprocessable) preferredMarketplacesModel).a();
                    }
                    return preferredMarketplacesModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -1197611445)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: recorded_audio_duration */
            public final class EdgesModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private NodeModel f5379d;

                /* compiled from: recorded_audio_duration */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(EdgesModel.class, new Deserializer());
                    }

                    public Object m5835a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(EdgesParser.m5857b(jsonParser, flatBufferBuilder));
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
                @ModelWithFlatBufferFormatHash(a = -1185712657)
                @JsonSerialize(using = Serializer.class)
                @FragmentModelWithoutBridge
                /* compiled from: recorded_audio_duration */
                public final class NodeModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
                    @Nullable
                    private String f5377d;
                    @Nullable
                    private String f5378e;

                    /* compiled from: recorded_audio_duration */
                    public class Deserializer extends FbJsonDeserializer {
                        static {
                            GlobalAutoGenDeserializerCache.a(NodeModel.class, new Deserializer());
                        }

                        public Object m5836a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(NodeParser.m5855a(jsonParser, flatBufferBuilder));
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

                    /* compiled from: recorded_audio_duration */
                    public class Serializer extends JsonSerializer<NodeModel> {
                        public final void m5837a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            NodeModel nodeModel = (NodeModel) obj;
                            if (nodeModel.w_() == null) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(nodeModel.m5838a(flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                nodeModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                            }
                            NodeParser.m5856a(nodeModel.w_(), nodeModel.u_(), jsonGenerator);
                        }

                        static {
                            FbSerializerProvider.a(NodeModel.class, new Serializer());
                        }
                    }

                    public NodeModel() {
                        super(2);
                    }

                    @Nullable
                    public final String m5841j() {
                        this.f5377d = super.a(this.f5377d, 0);
                        return this.f5377d;
                    }

                    @Nullable
                    public final String m5842k() {
                        this.f5378e = super.a(this.f5378e, 1);
                        return this.f5378e;
                    }

                    @Nullable
                    public final String m5840a() {
                        return m5841j();
                    }

                    public final int jK_() {
                        return 1968779819;
                    }

                    public final GraphQLVisitableModel m5839a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                        h();
                        i();
                        return this;
                    }

                    public final int m5838a(FlatBufferBuilder flatBufferBuilder) {
                        h();
                        int b = flatBufferBuilder.b(m5841j());
                        int b2 = flatBufferBuilder.b(m5842k());
                        flatBufferBuilder.c(2);
                        flatBufferBuilder.b(0, b);
                        flatBufferBuilder.b(1, b2);
                        i();
                        return flatBufferBuilder.d();
                    }
                }

                /* compiled from: recorded_audio_duration */
                public class Serializer extends JsonSerializer<EdgesModel> {
                    public final void m5843a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        EdgesModel edgesModel = (EdgesModel) obj;
                        if (edgesModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(edgesModel.m5844a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            edgesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        EdgesParser.m5858b(edgesModel.w_(), edgesModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(EdgesModel.class, new Serializer());
                    }
                }

                public EdgesModel() {
                    super(1);
                }

                @Nullable
                public final NodeModel m5846a() {
                    this.f5379d = (NodeModel) super.a(this.f5379d, 0, NodeModel.class);
                    return this.f5379d;
                }

                public final int jK_() {
                    return -951964698;
                }

                public final GraphQLVisitableModel m5845a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m5846a() != null) {
                        NodeModel nodeModel = (NodeModel) graphQLModelMutatingVisitor.b(m5846a());
                        if (m5846a() != nodeModel) {
                            graphQLVisitableModel = (EdgesModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f5379d = nodeModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m5844a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m5846a());
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, a);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: recorded_audio_duration */
            public class Serializer extends JsonSerializer<PreferredMarketplacesModel> {
                public final void m5847a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    PreferredMarketplacesModel preferredMarketplacesModel = (PreferredMarketplacesModel) obj;
                    if (preferredMarketplacesModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(preferredMarketplacesModel.m5848a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        preferredMarketplacesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    PreferredMarketplacesParser.m5860a(preferredMarketplacesModel.w_(), preferredMarketplacesModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(PreferredMarketplacesModel.class, new Serializer());
                }
            }

            public PreferredMarketplacesModel() {
                super(1);
            }

            @Nonnull
            public final ImmutableList<EdgesModel> m5850a() {
                this.f5380d = super.a(this.f5380d, 0, EdgesModel.class);
                return (ImmutableList) this.f5380d;
            }

            public final int jK_() {
                return -600819129;
            }

            public final GraphQLVisitableModel m5849a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m5850a() != null) {
                    Builder a = ModelHelper.a(m5850a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (PreferredMarketplacesModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f5380d = a.b();
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m5848a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m5850a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: recorded_audio_duration */
        public class Serializer extends JsonSerializer<PreferredMarketplaceQueryModel> {
            public final void m5851a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                PreferredMarketplaceQueryModel preferredMarketplaceQueryModel = (PreferredMarketplaceQueryModel) obj;
                if (preferredMarketplaceQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(preferredMarketplaceQueryModel.m5852a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    preferredMarketplaceQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = preferredMarketplaceQueryModel.w_();
                int u_ = preferredMarketplaceQueryModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("preferred_marketplaces");
                    PreferredMarketplacesParser.m5860a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(PreferredMarketplaceQueryModel.class, new Serializer());
            }
        }

        public PreferredMarketplaceQueryModel() {
            super(1);
        }

        @Nullable
        public final PreferredMarketplacesModel m5854a() {
            this.f5381d = (PreferredMarketplacesModel) super.a(this.f5381d, 0, PreferredMarketplacesModel.class);
            return this.f5381d;
        }

        public final int jK_() {
            return -1732764110;
        }

        public final GraphQLVisitableModel m5853a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m5854a() != null) {
                PreferredMarketplacesModel preferredMarketplacesModel = (PreferredMarketplacesModel) graphQLModelMutatingVisitor.b(m5854a());
                if (m5854a() != preferredMarketplacesModel) {
                    graphQLVisitableModel = (PreferredMarketplaceQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f5381d = preferredMarketplacesModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m5852a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m5854a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }
}
