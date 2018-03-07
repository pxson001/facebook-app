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
import com.facebook.graphql.enums.GraphQLSavedState;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.querybuilder.common.CommonGraphQLInterfaces.DefaultImageFields;
import com.facebook.graphql.querybuilder.common.CommonGraphQLModels.DefaultImageFieldsModel;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.search.protocol.FetchSimpleSearchEntitiesGraphQLParsers.FetchSimpleSearchEntitiesQueryParser;
import com.facebook.search.protocol.FetchSimpleSearchEntitiesGraphQLParsers.FetchSimpleSearchEntitiesQueryParser.SearchResultsParser;
import com.facebook.search.protocol.FetchSimpleSearchEntitiesGraphQLParsers.FetchSimpleSearchEntitiesQueryParser.SearchResultsParser.EdgesParser;
import com.facebook.search.protocol.FetchSimpleSearchEntitiesGraphQLParsers.FetchSimpleSearchEntitiesQueryParser.SearchResultsParser.EdgesParser.NodeParser;
import com.facebook.search.protocol.FetchSimpleSearchEntitiesGraphQLParsers.FetchSimpleSearchEntitiesQueryParser.SearchResultsParser.EdgesParser.NodeParser.GroupIconParser;
import com.facebook.search.protocol.FetchSimpleSearchEntitiesGraphQLParsers.FetchSimpleSearchEntitiesQueryParser.SearchResultsParser.EdgesParser.NodeParser.GroupIconParser.DarkIconParser;
import com.facebook.search.protocol.FetchSimpleSearchEntitiesGraphQLParsers.FetchSimpleSearchEntitiesQueryParser.SearchResultsParser.EdgesParser.NodeParser.GroupPhotorealisticIconParser;
import com.facebook.search.protocol.FetchSimpleSearchEntitiesGraphQLParsers.FetchSimpleSearchEntitiesQueryParser.SearchResultsParser.PageInfoParser;
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

/* compiled from: network_fetch_time_limit */
public class FetchSimpleSearchEntitiesGraphQLModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1704817075)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: network_fetch_time_limit */
    public final class FetchSimpleSearchEntitiesQueryModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private SearchResultsModel f8055d;

        /* compiled from: network_fetch_time_limit */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FetchSimpleSearchEntitiesQueryModel.class, new Deserializer());
            }

            public Object m8778a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = FetchSimpleSearchEntitiesQueryParser.m8850a(jsonParser);
                Object fetchSimpleSearchEntitiesQueryModel = new FetchSimpleSearchEntitiesQueryModel();
                ((BaseModel) fetchSimpleSearchEntitiesQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (fetchSimpleSearchEntitiesQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) fetchSimpleSearchEntitiesQueryModel).a();
                }
                return fetchSimpleSearchEntitiesQueryModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1206010985)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: network_fetch_time_limit */
        public final class SearchResultsModel extends BaseModel implements GraphQLVisitableModel {
            private int f8052d;
            @Nullable
            private List<EdgesModel> f8053e;
            @Nullable
            private PageInfoModel f8054f;

            /* compiled from: network_fetch_time_limit */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(SearchResultsModel.class, new Deserializer());
                }

                public Object m8779a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(SearchResultsParser.m8848a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object searchResultsModel = new SearchResultsModel();
                    ((BaseModel) searchResultsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (searchResultsModel instanceof Postprocessable) {
                        return ((Postprocessable) searchResultsModel).a();
                    }
                    return searchResultsModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -886773270)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: network_fetch_time_limit */
            public final class EdgesModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private String f8045d;
                @Nullable
                private NodeModel f8046e;
                @Nullable
                private String f8047f;

                /* compiled from: network_fetch_time_limit */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(EdgesModel.class, new Deserializer());
                    }

                    public Object m8780a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(EdgesParser.m8844b(jsonParser, flatBufferBuilder));
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
                @ModelWithFlatBufferFormatHash(a = -117307219)
                @JsonSerialize(using = Serializer.class)
                @FragmentModelWithoutBridge
                /* compiled from: network_fetch_time_limit */
                public final class NodeModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
                    @Nullable
                    private GraphQLObjectType f8037d;
                    @Nullable
                    private GroupIconModel f8038e;
                    @Nullable
                    private GroupPhotorealisticIconModel f8039f;
                    @Nullable
                    private String f8040g;
                    private boolean f8041h;
                    @Nullable
                    private String f8042i;
                    @Nullable
                    private DefaultImageFieldsModel f8043j;
                    @Nullable
                    private GraphQLSavedState f8044k;

                    /* compiled from: network_fetch_time_limit */
                    public class Deserializer extends FbJsonDeserializer {
                        static {
                            GlobalAutoGenDeserializerCache.a(NodeModel.class, new Deserializer());
                        }

                        public Object m8781a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(NodeParser.m8842a(jsonParser, flatBufferBuilder));
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

                    @JsonDeserialize(using = Deserializer.class)
                    @ModelWithFlatBufferFormatHash(a = 1978355995)
                    @JsonSerialize(using = Serializer.class)
                    @FragmentModelWithoutBridge
                    /* compiled from: network_fetch_time_limit */
                    public final class GroupIconModel extends BaseModel implements GraphQLVisitableModel {
                        @Nullable
                        private DarkIconModel f8035d;

                        @JsonDeserialize(using = Deserializer.class)
                        @ModelWithFlatBufferFormatHash(a = 842551240)
                        @JsonSerialize(using = Serializer.class)
                        @FragmentModelWithoutBridge
                        /* compiled from: network_fetch_time_limit */
                        public final class DarkIconModel extends BaseModel implements GraphQLVisitableModel {
                            @Nullable
                            private String f8034d;

                            /* compiled from: network_fetch_time_limit */
                            public class Deserializer extends FbJsonDeserializer {
                                static {
                                    GlobalAutoGenDeserializerCache.a(DarkIconModel.class, new Deserializer());
                                }

                                public Object m8782a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                    flatBufferBuilder.d(DarkIconParser.m8836a(jsonParser, flatBufferBuilder));
                                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                    wrap.position(0);
                                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                                    Object darkIconModel = new DarkIconModel();
                                    ((BaseModel) darkIconModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                                    if (darkIconModel instanceof Postprocessable) {
                                        return ((Postprocessable) darkIconModel).a();
                                    }
                                    return darkIconModel;
                                }
                            }

                            /* compiled from: network_fetch_time_limit */
                            public class Serializer extends JsonSerializer<DarkIconModel> {
                                public final void m8783a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                                    DarkIconModel darkIconModel = (DarkIconModel) obj;
                                    if (darkIconModel.w_() == null) {
                                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                        flatBufferBuilder.d(darkIconModel.m8785a(flatBufferBuilder));
                                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                        wrap.position(0);
                                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                        darkIconModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                                    }
                                    DarkIconParser.m8837a(darkIconModel.w_(), darkIconModel.u_(), jsonGenerator);
                                }

                                static {
                                    FbSerializerProvider.a(DarkIconModel.class, new Serializer());
                                }
                            }

                            public DarkIconModel() {
                                super(1);
                            }

                            @Nullable
                            private String m8784a() {
                                this.f8034d = super.a(this.f8034d, 0);
                                return this.f8034d;
                            }

                            public final int jK_() {
                                return 2273433;
                            }

                            public final GraphQLVisitableModel m8786a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                                h();
                                i();
                                return this;
                            }

                            public final int m8785a(FlatBufferBuilder flatBufferBuilder) {
                                h();
                                int b = flatBufferBuilder.b(m8784a());
                                flatBufferBuilder.c(1);
                                flatBufferBuilder.b(0, b);
                                i();
                                return flatBufferBuilder.d();
                            }
                        }

                        /* compiled from: network_fetch_time_limit */
                        public class Deserializer extends FbJsonDeserializer {
                            static {
                                GlobalAutoGenDeserializerCache.a(GroupIconModel.class, new Deserializer());
                            }

                            public Object m8787a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(GroupIconParser.m8838a(jsonParser, flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                                Object groupIconModel = new GroupIconModel();
                                ((BaseModel) groupIconModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                                if (groupIconModel instanceof Postprocessable) {
                                    return ((Postprocessable) groupIconModel).a();
                                }
                                return groupIconModel;
                            }
                        }

                        /* compiled from: network_fetch_time_limit */
                        public class Serializer extends JsonSerializer<GroupIconModel> {
                            public final void m8788a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                                GroupIconModel groupIconModel = (GroupIconModel) obj;
                                if (groupIconModel.w_() == null) {
                                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                    flatBufferBuilder.d(groupIconModel.m8790a(flatBufferBuilder));
                                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                    wrap.position(0);
                                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                    groupIconModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                                }
                                GroupIconParser.m8839a(groupIconModel.w_(), groupIconModel.u_(), jsonGenerator, serializerProvider);
                            }

                            static {
                                FbSerializerProvider.a(GroupIconModel.class, new Serializer());
                            }
                        }

                        public GroupIconModel() {
                            super(1);
                        }

                        @Nullable
                        private DarkIconModel m8789a() {
                            this.f8035d = (DarkIconModel) super.a(this.f8035d, 0, DarkIconModel.class);
                            return this.f8035d;
                        }

                        public final int jK_() {
                            return -452718528;
                        }

                        public final GraphQLVisitableModel m8791a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                            GraphQLVisitableModel graphQLVisitableModel = null;
                            h();
                            if (m8789a() != null) {
                                DarkIconModel darkIconModel = (DarkIconModel) graphQLModelMutatingVisitor.b(m8789a());
                                if (m8789a() != darkIconModel) {
                                    graphQLVisitableModel = (GroupIconModel) ModelHelper.a(null, this);
                                    graphQLVisitableModel.f8035d = darkIconModel;
                                }
                            }
                            i();
                            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                        }

                        public final int m8790a(FlatBufferBuilder flatBufferBuilder) {
                            h();
                            int a = ModelHelper.a(flatBufferBuilder, m8789a());
                            flatBufferBuilder.c(1);
                            flatBufferBuilder.b(0, a);
                            i();
                            return flatBufferBuilder.d();
                        }
                    }

                    @JsonDeserialize(using = Deserializer.class)
                    @ModelWithFlatBufferFormatHash(a = 842551240)
                    @JsonSerialize(using = Serializer.class)
                    @FragmentModelWithoutBridge
                    /* compiled from: network_fetch_time_limit */
                    public final class GroupPhotorealisticIconModel extends BaseModel implements GraphQLVisitableModel {
                        @Nullable
                        private String f8036d;

                        /* compiled from: network_fetch_time_limit */
                        public class Deserializer extends FbJsonDeserializer {
                            static {
                                GlobalAutoGenDeserializerCache.a(GroupPhotorealisticIconModel.class, new Deserializer());
                            }

                            public Object m8792a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(GroupPhotorealisticIconParser.m8840a(jsonParser, flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                                Object groupPhotorealisticIconModel = new GroupPhotorealisticIconModel();
                                ((BaseModel) groupPhotorealisticIconModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                                if (groupPhotorealisticIconModel instanceof Postprocessable) {
                                    return ((Postprocessable) groupPhotorealisticIconModel).a();
                                }
                                return groupPhotorealisticIconModel;
                            }
                        }

                        /* compiled from: network_fetch_time_limit */
                        public class Serializer extends JsonSerializer<GroupPhotorealisticIconModel> {
                            public final void m8793a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                                GroupPhotorealisticIconModel groupPhotorealisticIconModel = (GroupPhotorealisticIconModel) obj;
                                if (groupPhotorealisticIconModel.w_() == null) {
                                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                    flatBufferBuilder.d(groupPhotorealisticIconModel.m8794a(flatBufferBuilder));
                                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                    wrap.position(0);
                                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                    groupPhotorealisticIconModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                                }
                                GroupPhotorealisticIconParser.m8841a(groupPhotorealisticIconModel.w_(), groupPhotorealisticIconModel.u_(), jsonGenerator);
                            }

                            static {
                                FbSerializerProvider.a(GroupPhotorealisticIconModel.class, new Serializer());
                            }
                        }

                        public GroupPhotorealisticIconModel() {
                            super(1);
                        }

                        @Nullable
                        public final String m8796a() {
                            this.f8036d = super.a(this.f8036d, 0);
                            return this.f8036d;
                        }

                        public final int jK_() {
                            return 70760763;
                        }

                        public final GraphQLVisitableModel m8795a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                            h();
                            i();
                            return this;
                        }

                        public final int m8794a(FlatBufferBuilder flatBufferBuilder) {
                            h();
                            int b = flatBufferBuilder.b(m8796a());
                            flatBufferBuilder.c(1);
                            flatBufferBuilder.b(0, b);
                            i();
                            return flatBufferBuilder.d();
                        }
                    }

                    /* compiled from: network_fetch_time_limit */
                    public class Serializer extends JsonSerializer<NodeModel> {
                        public final void m8797a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            NodeModel nodeModel = (NodeModel) obj;
                            if (nodeModel.w_() == null) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(nodeModel.m8802a(flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                nodeModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                            }
                            NodeParser.m8843a(nodeModel.w_(), nodeModel.u_(), jsonGenerator, serializerProvider);
                        }

                        static {
                            FbSerializerProvider.a(NodeModel.class, new Serializer());
                        }
                    }

                    @Nullable
                    public final /* synthetic */ GroupPhotorealisticIconModel m8807c() {
                        return m8799k();
                    }

                    @Nullable
                    public final /* synthetic */ DefaultImageFields jE_() {
                        return m8800l();
                    }

                    public NodeModel() {
                        super(8);
                    }

                    @Nullable
                    public final GraphQLObjectType m8806b() {
                        if (this.b != null && this.f8037d == null) {
                            this.f8037d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                        }
                        return this.f8037d;
                    }

                    @Nullable
                    private GroupIconModel m8798j() {
                        this.f8038e = (GroupIconModel) super.a(this.f8038e, 1, GroupIconModel.class);
                        return this.f8038e;
                    }

                    @Nullable
                    private GroupPhotorealisticIconModel m8799k() {
                        this.f8039f = (GroupPhotorealisticIconModel) super.a(this.f8039f, 2, GroupPhotorealisticIconModel.class);
                        return this.f8039f;
                    }

                    @Nullable
                    public final String m8808d() {
                        this.f8040g = super.a(this.f8040g, 3);
                        return this.f8040g;
                    }

                    public final boolean jD_() {
                        a(0, 4);
                        return this.f8041h;
                    }

                    @Nullable
                    public final String m8809g() {
                        this.f8042i = super.a(this.f8042i, 5);
                        return this.f8042i;
                    }

                    @Nullable
                    private DefaultImageFieldsModel m8800l() {
                        this.f8043j = (DefaultImageFieldsModel) super.a(this.f8043j, 6, DefaultImageFieldsModel.class);
                        return this.f8043j;
                    }

                    @Nullable
                    private GraphQLSavedState m8801m() {
                        this.f8044k = (GraphQLSavedState) super.b(this.f8044k, 7, GraphQLSavedState.class, GraphQLSavedState.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                        return this.f8044k;
                    }

                    @Nullable
                    public final String m8804a() {
                        return m8808d();
                    }

                    public final int jK_() {
                        return 1283375906;
                    }

                    public final GraphQLVisitableModel m8803a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                        GraphQLVisitableModel graphQLVisitableModel = null;
                        h();
                        if (m8798j() != null) {
                            GroupIconModel groupIconModel = (GroupIconModel) graphQLModelMutatingVisitor.b(m8798j());
                            if (m8798j() != groupIconModel) {
                                graphQLVisitableModel = (NodeModel) ModelHelper.a(null, this);
                                graphQLVisitableModel.f8038e = groupIconModel;
                            }
                        }
                        if (m8799k() != null) {
                            GroupPhotorealisticIconModel groupPhotorealisticIconModel = (GroupPhotorealisticIconModel) graphQLModelMutatingVisitor.b(m8799k());
                            if (m8799k() != groupPhotorealisticIconModel) {
                                graphQLVisitableModel = (NodeModel) ModelHelper.a(graphQLVisitableModel, this);
                                graphQLVisitableModel.f8039f = groupPhotorealisticIconModel;
                            }
                        }
                        if (m8800l() != null) {
                            DefaultImageFieldsModel defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m8800l());
                            if (m8800l() != defaultImageFieldsModel) {
                                graphQLVisitableModel = (NodeModel) ModelHelper.a(graphQLVisitableModel, this);
                                graphQLVisitableModel.f8043j = defaultImageFieldsModel;
                            }
                        }
                        i();
                        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                    }

                    public final int m8802a(FlatBufferBuilder flatBufferBuilder) {
                        h();
                        int a = ModelHelper.a(flatBufferBuilder, m8806b());
                        int a2 = ModelHelper.a(flatBufferBuilder, m8798j());
                        int a3 = ModelHelper.a(flatBufferBuilder, m8799k());
                        int b = flatBufferBuilder.b(m8808d());
                        int b2 = flatBufferBuilder.b(m8809g());
                        int a4 = ModelHelper.a(flatBufferBuilder, m8800l());
                        int a5 = flatBufferBuilder.a(m8801m());
                        flatBufferBuilder.c(8);
                        flatBufferBuilder.b(0, a);
                        flatBufferBuilder.b(1, a2);
                        flatBufferBuilder.b(2, a3);
                        flatBufferBuilder.b(3, b);
                        flatBufferBuilder.a(4, this.f8041h);
                        flatBufferBuilder.b(5, b2);
                        flatBufferBuilder.b(6, a4);
                        flatBufferBuilder.b(7, a5);
                        i();
                        return flatBufferBuilder.d();
                    }

                    public final void m8805a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                        super.a(mutableFlatBuffer, i, obj);
                        this.f8041h = mutableFlatBuffer.a(i, 4);
                    }
                }

                /* compiled from: network_fetch_time_limit */
                public class Serializer extends JsonSerializer<EdgesModel> {
                    public final void m8810a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        EdgesModel edgesModel = (EdgesModel) obj;
                        if (edgesModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(edgesModel.m8812a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            edgesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        EdgesParser.m8845b(edgesModel.w_(), edgesModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(EdgesModel.class, new Serializer());
                    }
                }

                @Nullable
                public final /* synthetic */ NodeModel m8815b() {
                    return m8811j();
                }

                public EdgesModel() {
                    super(3);
                }

                @Nullable
                public final String m8814a() {
                    this.f8045d = super.a(this.f8045d, 0);
                    return this.f8045d;
                }

                @Nullable
                private NodeModel m8811j() {
                    this.f8046e = (NodeModel) super.a(this.f8046e, 1, NodeModel.class);
                    return this.f8046e;
                }

                @Nullable
                public final String m8816c() {
                    this.f8047f = super.a(this.f8047f, 2);
                    return this.f8047f;
                }

                public final int jK_() {
                    return 867970641;
                }

                public final GraphQLVisitableModel m8813a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m8811j() != null) {
                        NodeModel nodeModel = (NodeModel) graphQLModelMutatingVisitor.b(m8811j());
                        if (m8811j() != nodeModel) {
                            graphQLVisitableModel = (EdgesModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f8046e = nodeModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m8812a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int b = flatBufferBuilder.b(m8814a());
                    int a = ModelHelper.a(flatBufferBuilder, m8811j());
                    int b2 = flatBufferBuilder.b(m8816c());
                    flatBufferBuilder.c(3);
                    flatBufferBuilder.b(0, b);
                    flatBufferBuilder.b(1, a);
                    flatBufferBuilder.b(2, b2);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 921619519)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: network_fetch_time_limit */
            public final class PageInfoModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private String f8048d;
                private boolean f8049e;
                private boolean f8050f;
                @Nullable
                private String f8051g;

                /* compiled from: network_fetch_time_limit */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(PageInfoModel.class, new Deserializer());
                    }

                    public Object m8817a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(PageInfoParser.m8846a(jsonParser, flatBufferBuilder));
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

                /* compiled from: network_fetch_time_limit */
                public class Serializer extends JsonSerializer<PageInfoModel> {
                    public final void m8818a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        PageInfoModel pageInfoModel = (PageInfoModel) obj;
                        if (pageInfoModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(pageInfoModel.m8820a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            pageInfoModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        PageInfoParser.m8847a(pageInfoModel.w_(), pageInfoModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(PageInfoModel.class, new Serializer());
                    }
                }

                public PageInfoModel() {
                    super(4);
                }

                @Nullable
                public final String m8822a() {
                    this.f8048d = super.a(this.f8048d, 0);
                    return this.f8048d;
                }

                public final boolean m8824j() {
                    a(0, 1);
                    return this.f8049e;
                }

                public final boolean m8825k() {
                    a(0, 2);
                    return this.f8050f;
                }

                @Nullable
                private String m8819l() {
                    this.f8051g = super.a(this.f8051g, 3);
                    return this.f8051g;
                }

                public final int jK_() {
                    return 923779069;
                }

                public final GraphQLVisitableModel m8821a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m8820a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int b = flatBufferBuilder.b(m8822a());
                    int b2 = flatBufferBuilder.b(m8819l());
                    flatBufferBuilder.c(4);
                    flatBufferBuilder.b(0, b);
                    flatBufferBuilder.a(1, this.f8049e);
                    flatBufferBuilder.a(2, this.f8050f);
                    flatBufferBuilder.b(3, b2);
                    i();
                    return flatBufferBuilder.d();
                }

                public final void m8823a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                    super.a(mutableFlatBuffer, i, obj);
                    this.f8049e = mutableFlatBuffer.a(i, 1);
                    this.f8050f = mutableFlatBuffer.a(i, 2);
                }
            }

            /* compiled from: network_fetch_time_limit */
            public class Serializer extends JsonSerializer<SearchResultsModel> {
                public final void m8826a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    SearchResultsModel searchResultsModel = (SearchResultsModel) obj;
                    if (searchResultsModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(searchResultsModel.m8827a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        searchResultsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    SearchResultsParser.m8849a(searchResultsModel.w_(), searchResultsModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(SearchResultsModel.class, new Serializer());
                }
            }

            public SearchResultsModel() {
                super(3);
            }

            @Nonnull
            public final ImmutableList<EdgesModel> m8829a() {
                this.f8053e = super.a(this.f8053e, 1, EdgesModel.class);
                return (ImmutableList) this.f8053e;
            }

            @Nullable
            public final PageInfoModel m8831j() {
                this.f8054f = (PageInfoModel) super.a(this.f8054f, 2, PageInfoModel.class);
                return this.f8054f;
            }

            public final int jK_() {
                return 1843101810;
            }

            public final GraphQLVisitableModel m8828a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel;
                PageInfoModel pageInfoModel;
                h();
                if (m8829a() != null) {
                    Builder a = ModelHelper.a(m8829a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        SearchResultsModel searchResultsModel = (SearchResultsModel) ModelHelper.a(null, this);
                        searchResultsModel.f8053e = a.b();
                        graphQLVisitableModel = searchResultsModel;
                        if (m8831j() != null) {
                            pageInfoModel = (PageInfoModel) graphQLModelMutatingVisitor.b(m8831j());
                            if (m8831j() != pageInfoModel) {
                                graphQLVisitableModel = (SearchResultsModel) ModelHelper.a(graphQLVisitableModel, this);
                                graphQLVisitableModel.f8054f = pageInfoModel;
                            }
                        }
                        i();
                        return graphQLVisitableModel != null ? this : graphQLVisitableModel;
                    }
                }
                graphQLVisitableModel = null;
                if (m8831j() != null) {
                    pageInfoModel = (PageInfoModel) graphQLModelMutatingVisitor.b(m8831j());
                    if (m8831j() != pageInfoModel) {
                        graphQLVisitableModel = (SearchResultsModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f8054f = pageInfoModel;
                    }
                }
                i();
                if (graphQLVisitableModel != null) {
                }
            }

            public final int m8827a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m8829a());
                int a2 = ModelHelper.a(flatBufferBuilder, m8831j());
                flatBufferBuilder.c(3);
                flatBufferBuilder.a(0, this.f8052d, 0);
                flatBufferBuilder.b(1, a);
                flatBufferBuilder.b(2, a2);
                i();
                return flatBufferBuilder.d();
            }

            public final void m8830a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f8052d = mutableFlatBuffer.a(i, 0, 0);
            }
        }

        /* compiled from: network_fetch_time_limit */
        public class Serializer extends JsonSerializer<FetchSimpleSearchEntitiesQueryModel> {
            public final void m8832a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                FetchSimpleSearchEntitiesQueryModel fetchSimpleSearchEntitiesQueryModel = (FetchSimpleSearchEntitiesQueryModel) obj;
                if (fetchSimpleSearchEntitiesQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(fetchSimpleSearchEntitiesQueryModel.m8833a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    fetchSimpleSearchEntitiesQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = fetchSimpleSearchEntitiesQueryModel.w_();
                int u_ = fetchSimpleSearchEntitiesQueryModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("search_results");
                    SearchResultsParser.m8849a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(FetchSimpleSearchEntitiesQueryModel.class, new Serializer());
            }
        }

        public FetchSimpleSearchEntitiesQueryModel() {
            super(1);
        }

        @Nullable
        public final SearchResultsModel m8835a() {
            this.f8055d = (SearchResultsModel) super.a(this.f8055d, 0, SearchResultsModel.class);
            return this.f8055d;
        }

        public final int jK_() {
            return 332244357;
        }

        public final GraphQLVisitableModel m8834a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m8835a() != null) {
                SearchResultsModel searchResultsModel = (SearchResultsModel) graphQLModelMutatingVisitor.b(m8835a());
                if (m8835a() != searchResultsModel) {
                    graphQLVisitableModel = (FetchSimpleSearchEntitiesQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f8055d = searchResultsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m8833a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m8835a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }
}
