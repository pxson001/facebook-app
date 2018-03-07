package com.facebook.contacts.upload.graphql;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.contacts.upload.graphql.FetchPhonebookHashesGraphQLParsers.FetchPhonebookHashesQueryParser;
import com.facebook.contacts.upload.graphql.FetchPhonebookHashesGraphQLParsers.FetchPhonebookHashesQueryParser.AddressbooksParser;
import com.facebook.contacts.upload.graphql.FetchPhonebookHashesGraphQLParsers.FetchPhonebookHashesQueryParser.AddressbooksParser.EdgesParser;
import com.facebook.contacts.upload.graphql.FetchPhonebookHashesGraphQLParsers.FetchPhonebookHashesQueryParser.AddressbooksParser.EdgesParser.NodeParser;
import com.facebook.contacts.upload.graphql.FetchPhonebookHashesGraphQLParsers.FetchPhonebookHashesQueryParser.AddressbooksParser.EdgesParser.NodeParser.AddressbookContactsParser;
import com.facebook.contacts.upload.graphql.FetchPhonebookHashesGraphQLParsers.FetchPhonebookHashesQueryParser.AddressbooksParser.EdgesParser.NodeParser.AddressbookContactsParser.NodesParser;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
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

/* compiled from: tapped_album */
public class FetchPhonebookHashesGraphQLModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -261829824)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: tapped_album */
    public final class FetchPhonebookHashesQueryModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private AddressbooksModel f2210d;

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1666560972)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: tapped_album */
        public final class AddressbooksModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<EdgesModel> f2209d;

            /* compiled from: tapped_album */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(AddressbooksModel.class, new Deserializer());
                }

                public Object m2139a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(AddressbooksParser.m2181a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object addressbooksModel = new AddressbooksModel();
                    ((BaseModel) addressbooksModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (addressbooksModel instanceof Postprocessable) {
                        return ((Postprocessable) addressbooksModel).a();
                    }
                    return addressbooksModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 1164315323)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: tapped_album */
            public final class EdgesModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private NodeModel f2208d;

                /* compiled from: tapped_album */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(EdgesModel.class, new Deserializer());
                    }

                    public Object m2140a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(EdgesParser.m2179b(jsonParser, flatBufferBuilder));
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
                @ModelWithFlatBufferFormatHash(a = -2088229026)
                @JsonSerialize(using = Serializer.class)
                @FragmentModelWithoutBridge
                /* compiled from: tapped_album */
                public final class NodeModel extends BaseModel implements GraphQLVisitableModel {
                    @Nullable
                    private AddressbookContactsModel f2205d;
                    private boolean f2206e;
                    private int f2207f;

                    @JsonDeserialize(using = Deserializer.class)
                    @ModelWithFlatBufferFormatHash(a = 866166561)
                    @JsonSerialize(using = Serializer.class)
                    @FragmentModelWithoutBridge
                    /* compiled from: tapped_album */
                    public final class AddressbookContactsModel extends BaseModel implements GraphQLVisitableModel {
                        @Nullable
                        private List<NodesModel> f2204d;

                        /* compiled from: tapped_album */
                        public class Deserializer extends FbJsonDeserializer {
                            static {
                                GlobalAutoGenDeserializerCache.a(AddressbookContactsModel.class, new Deserializer());
                            }

                            public Object m2141a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(AddressbookContactsParser.m2175a(jsonParser, flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                                Object addressbookContactsModel = new AddressbookContactsModel();
                                ((BaseModel) addressbookContactsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                                if (addressbookContactsModel instanceof Postprocessable) {
                                    return ((Postprocessable) addressbookContactsModel).a();
                                }
                                return addressbookContactsModel;
                            }
                        }

                        @JsonDeserialize(using = Deserializer.class)
                        @ModelWithFlatBufferFormatHash(a = -935604809)
                        @JsonSerialize(using = Serializer.class)
                        @FragmentModelWithoutBridge
                        /* compiled from: tapped_album */
                        public final class NodesModel extends BaseModel implements GraphQLVisitableModel {
                            @Nullable
                            private String f2202d;
                            @Nullable
                            private String f2203e;

                            /* compiled from: tapped_album */
                            public class Deserializer extends FbJsonDeserializer {
                                static {
                                    GlobalAutoGenDeserializerCache.a(NodesModel.class, new Deserializer());
                                }

                                public Object m2142a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                    flatBufferBuilder.d(NodesParser.m2174b(jsonParser, flatBufferBuilder));
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

                            /* compiled from: tapped_album */
                            public class Serializer extends JsonSerializer<NodesModel> {
                                public final void m2143a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                                    NodesModel nodesModel = (NodesModel) obj;
                                    if (nodesModel.w_() == null) {
                                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                        flatBufferBuilder.d(nodesModel.m2144a(flatBufferBuilder));
                                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                        wrap.position(0);
                                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                        nodesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                                    }
                                    NodesParser.m2173a(nodesModel.w_(), nodesModel.u_(), jsonGenerator);
                                }

                                static {
                                    FbSerializerProvider.a(NodesModel.class, new Serializer());
                                }
                            }

                            public NodesModel() {
                                super(2);
                            }

                            @Nullable
                            public final String m2146a() {
                                this.f2202d = super.a(this.f2202d, 0);
                                return this.f2202d;
                            }

                            @Nullable
                            public final String m2147j() {
                                this.f2203e = super.a(this.f2203e, 1);
                                return this.f2203e;
                            }

                            public final int jK_() {
                                return -507076477;
                            }

                            public final GraphQLVisitableModel m2145a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                                h();
                                i();
                                return this;
                            }

                            public final int m2144a(FlatBufferBuilder flatBufferBuilder) {
                                h();
                                int b = flatBufferBuilder.b(m2146a());
                                int b2 = flatBufferBuilder.b(m2147j());
                                flatBufferBuilder.c(2);
                                flatBufferBuilder.b(0, b);
                                flatBufferBuilder.b(1, b2);
                                i();
                                return flatBufferBuilder.d();
                            }
                        }

                        /* compiled from: tapped_album */
                        public class Serializer extends JsonSerializer<AddressbookContactsModel> {
                            public final void m2148a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                                AddressbookContactsModel addressbookContactsModel = (AddressbookContactsModel) obj;
                                if (addressbookContactsModel.w_() == null) {
                                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                    flatBufferBuilder.d(addressbookContactsModel.m2149a(flatBufferBuilder));
                                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                    wrap.position(0);
                                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                    addressbookContactsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                                }
                                AddressbookContactsParser.m2176a(addressbookContactsModel.w_(), addressbookContactsModel.u_(), jsonGenerator, serializerProvider);
                            }

                            static {
                                FbSerializerProvider.a(AddressbookContactsModel.class, new Serializer());
                            }
                        }

                        public AddressbookContactsModel() {
                            super(1);
                        }

                        @Nonnull
                        public final ImmutableList<NodesModel> m2151a() {
                            this.f2204d = super.a(this.f2204d, 0, NodesModel.class);
                            return (ImmutableList) this.f2204d;
                        }

                        public final int jK_() {
                            return 1487649808;
                        }

                        public final GraphQLVisitableModel m2150a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                            GraphQLVisitableModel graphQLVisitableModel = null;
                            h();
                            if (m2151a() != null) {
                                Builder a = ModelHelper.a(m2151a(), graphQLModelMutatingVisitor);
                                if (a != null) {
                                    graphQLVisitableModel = (AddressbookContactsModel) ModelHelper.a(null, this);
                                    graphQLVisitableModel.f2204d = a.b();
                                }
                            }
                            i();
                            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                        }

                        public final int m2149a(FlatBufferBuilder flatBufferBuilder) {
                            h();
                            int a = ModelHelper.a(flatBufferBuilder, m2151a());
                            flatBufferBuilder.c(1);
                            flatBufferBuilder.b(0, a);
                            i();
                            return flatBufferBuilder.d();
                        }
                    }

                    /* compiled from: tapped_album */
                    public class Deserializer extends FbJsonDeserializer {
                        static {
                            GlobalAutoGenDeserializerCache.a(NodeModel.class, new Deserializer());
                        }

                        public Object m2152a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(NodeParser.m2177a(jsonParser, flatBufferBuilder));
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

                    /* compiled from: tapped_album */
                    public class Serializer extends JsonSerializer<NodeModel> {
                        public final void m2153a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            NodeModel nodeModel = (NodeModel) obj;
                            if (nodeModel.w_() == null) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(nodeModel.m2154a(flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                nodeModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                            }
                            NodeParser.m2178a(nodeModel.w_(), nodeModel.u_(), jsonGenerator, serializerProvider);
                        }

                        static {
                            FbSerializerProvider.a(NodeModel.class, new Serializer());
                        }
                    }

                    public NodeModel() {
                        super(3);
                    }

                    @Nullable
                    public final AddressbookContactsModel m2155a() {
                        this.f2205d = (AddressbookContactsModel) super.a(this.f2205d, 0, AddressbookContactsModel.class);
                        return this.f2205d;
                    }

                    public final boolean m2158j() {
                        a(0, 1);
                        return this.f2206e;
                    }

                    public final int m2159k() {
                        a(0, 2);
                        return this.f2207f;
                    }

                    public final int jK_() {
                        return 290052317;
                    }

                    public final GraphQLVisitableModel m2156a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                        GraphQLVisitableModel graphQLVisitableModel = null;
                        h();
                        if (m2155a() != null) {
                            AddressbookContactsModel addressbookContactsModel = (AddressbookContactsModel) graphQLModelMutatingVisitor.b(m2155a());
                            if (m2155a() != addressbookContactsModel) {
                                graphQLVisitableModel = (NodeModel) ModelHelper.a(null, this);
                                graphQLVisitableModel.f2205d = addressbookContactsModel;
                            }
                        }
                        i();
                        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                    }

                    public final int m2154a(FlatBufferBuilder flatBufferBuilder) {
                        h();
                        int a = ModelHelper.a(flatBufferBuilder, m2155a());
                        flatBufferBuilder.c(3);
                        flatBufferBuilder.b(0, a);
                        flatBufferBuilder.a(1, this.f2206e);
                        flatBufferBuilder.a(2, this.f2207f, 0);
                        i();
                        return flatBufferBuilder.d();
                    }

                    public final void m2157a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                        super.a(mutableFlatBuffer, i, obj);
                        this.f2206e = mutableFlatBuffer.a(i, 1);
                        this.f2207f = mutableFlatBuffer.a(i, 2, 0);
                    }
                }

                /* compiled from: tapped_album */
                public class Serializer extends JsonSerializer<EdgesModel> {
                    public final void m2160a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        EdgesModel edgesModel = (EdgesModel) obj;
                        if (edgesModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(edgesModel.m2161a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            edgesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        EdgesParser.m2180b(edgesModel.w_(), edgesModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(EdgesModel.class, new Serializer());
                    }
                }

                public EdgesModel() {
                    super(1);
                }

                @Nullable
                public final NodeModel m2162a() {
                    this.f2208d = (NodeModel) super.a(this.f2208d, 0, NodeModel.class);
                    return this.f2208d;
                }

                public final int jK_() {
                    return 1219976790;
                }

                public final GraphQLVisitableModel m2163a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m2162a() != null) {
                        NodeModel nodeModel = (NodeModel) graphQLModelMutatingVisitor.b(m2162a());
                        if (m2162a() != nodeModel) {
                            graphQLVisitableModel = (EdgesModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f2208d = nodeModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m2161a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m2162a());
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, a);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: tapped_album */
            public class Serializer extends JsonSerializer<AddressbooksModel> {
                public final void m2164a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    AddressbooksModel addressbooksModel = (AddressbooksModel) obj;
                    if (addressbooksModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(addressbooksModel.m2165a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        addressbooksModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    AddressbooksParser.m2182a(addressbooksModel.w_(), addressbooksModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(AddressbooksModel.class, new Serializer());
                }
            }

            public AddressbooksModel() {
                super(1);
            }

            @Nonnull
            public final ImmutableList<EdgesModel> m2167a() {
                this.f2209d = super.a(this.f2209d, 0, EdgesModel.class);
                return (ImmutableList) this.f2209d;
            }

            public final int jK_() {
                return -835594057;
            }

            public final GraphQLVisitableModel m2166a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m2167a() != null) {
                    Builder a = ModelHelper.a(m2167a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (AddressbooksModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f2209d = a.b();
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m2165a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m2167a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: tapped_album */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FetchPhonebookHashesQueryModel.class, new Deserializer());
            }

            public Object m2168a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = FetchPhonebookHashesQueryParser.m2183a(jsonParser);
                Object fetchPhonebookHashesQueryModel = new FetchPhonebookHashesQueryModel();
                ((BaseModel) fetchPhonebookHashesQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (fetchPhonebookHashesQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) fetchPhonebookHashesQueryModel).a();
                }
                return fetchPhonebookHashesQueryModel;
            }
        }

        /* compiled from: tapped_album */
        public class Serializer extends JsonSerializer<FetchPhonebookHashesQueryModel> {
            public final void m2169a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                FetchPhonebookHashesQueryModel fetchPhonebookHashesQueryModel = (FetchPhonebookHashesQueryModel) obj;
                if (fetchPhonebookHashesQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(fetchPhonebookHashesQueryModel.m2170a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    fetchPhonebookHashesQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = fetchPhonebookHashesQueryModel.w_();
                int u_ = fetchPhonebookHashesQueryModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("addressbooks");
                    AddressbooksParser.m2182a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(FetchPhonebookHashesQueryModel.class, new Serializer());
            }
        }

        public FetchPhonebookHashesQueryModel() {
            super(1);
        }

        @Nullable
        public final AddressbooksModel m2171a() {
            this.f2210d = (AddressbooksModel) super.a(this.f2210d, 0, AddressbooksModel.class);
            return this.f2210d;
        }

        public final int jK_() {
            return -1732764110;
        }

        public final GraphQLVisitableModel m2172a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m2171a() != null) {
                AddressbooksModel addressbooksModel = (AddressbooksModel) graphQLModelMutatingVisitor.b(m2171a());
                if (m2171a() != addressbooksModel) {
                    graphQLVisitableModel = (FetchPhonebookHashesQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f2210d = addressbooksModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m2170a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m2171a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }
}
