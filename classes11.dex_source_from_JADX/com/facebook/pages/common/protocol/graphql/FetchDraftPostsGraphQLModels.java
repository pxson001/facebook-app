package com.facebook.pages.common.protocol.graphql;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.controller.connectioncontroller.pageinfo.ConnectionControllerPageInfoGraphQLModels.ConnectionControllerPageInfoGraphQLModel;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.visitor.ConsistencyTuple;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.pages.common.protocol.graphql.FetchDraftPostsGraphQLParsers.FetchDraftPostsQueryParser;
import com.facebook.pages.common.protocol.graphql.FetchDraftPostsGraphQLParsers.FetchDraftPostsQueryParser.AdminInfoParser;
import com.facebook.pages.common.protocol.graphql.FetchDraftPostsGraphQLParsers.FetchDraftPostsQueryParser.AdminInfoParser.AllDraftPostsParser;
import com.facebook.pages.common.protocol.graphql.FetchDraftPostsGraphQLParsers.FetchDraftPostsQueryParser.AdminInfoParser.AllDraftPostsParser.EdgesParser;
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

/* compiled from: setSproutsMetadataFlowState */
public class FetchDraftPostsGraphQLModels {

    @FragmentModelWithBridge
    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1952594208)
    @JsonSerialize(using = Serializer.class)
    /* compiled from: setSproutsMetadataFlowState */
    public final class FetchDraftPostsQueryModel extends BaseModel implements GraphQLVisitableConsistentModel {
        @Nullable
        private AdminInfoModel f1752d;

        @FragmentModelWithBridge
        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 2032571175)
        @JsonSerialize(using = Serializer.class)
        /* compiled from: setSproutsMetadataFlowState */
        public final class AdminInfoModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private AllDraftPostsModel f1751d;

            @FragmentModelWithBridge
            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -1479130429)
            @JsonSerialize(using = Serializer.class)
            /* compiled from: setSproutsMetadataFlowState */
            public final class AllDraftPostsModel extends BaseModel implements GraphQLVisitableModel {
                private int f1748d;
                @Nullable
                private List<EdgesModel> f1749e;
                @Nullable
                private ConnectionControllerPageInfoGraphQLModel f1750f;

                /* compiled from: setSproutsMetadataFlowState */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(AllDraftPostsModel.class, new Deserializer());
                    }

                    public Object m2561a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(AllDraftPostsParser.m2587a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object allDraftPostsModel = new AllDraftPostsModel();
                        ((BaseModel) allDraftPostsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (allDraftPostsModel instanceof Postprocessable) {
                            return ((Postprocessable) allDraftPostsModel).a();
                        }
                        return allDraftPostsModel;
                    }
                }

                @FragmentModelWithBridge
                @JsonDeserialize(using = Deserializer.class)
                @ModelWithFlatBufferFormatHash(a = -1803801802)
                @JsonSerialize(using = Serializer.class)
                /* compiled from: setSproutsMetadataFlowState */
                public final class EdgesModel extends BaseModel implements GraphQLVisitableModel {
                    @Nullable
                    private GraphQLStory f1747d;

                    /* compiled from: setSproutsMetadataFlowState */
                    public class Deserializer extends FbJsonDeserializer {
                        static {
                            GlobalAutoGenDeserializerCache.a(EdgesModel.class, new Deserializer());
                        }

                        public Object m2562a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(EdgesParser.m2585b(jsonParser, flatBufferBuilder));
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

                    /* compiled from: setSproutsMetadataFlowState */
                    public class Serializer extends JsonSerializer<EdgesModel> {
                        public final void m2563a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            EdgesModel edgesModel = (EdgesModel) obj;
                            if (edgesModel.w_() == null) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(edgesModel.m2565a(flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                edgesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                            }
                            EdgesParser.m2586b(edgesModel.w_(), edgesModel.u_(), jsonGenerator, serializerProvider);
                        }

                        static {
                            FbSerializerProvider.a(EdgesModel.class, new Serializer());
                        }
                    }

                    public EdgesModel() {
                        super(1);
                    }

                    @Nullable
                    private GraphQLStory m2564a() {
                        this.f1747d = (GraphQLStory) super.a(this.f1747d, 0, GraphQLStory.class);
                        return this.f1747d;
                    }

                    public final int jK_() {
                        return -1592934544;
                    }

                    public final GraphQLVisitableModel m2566a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                        GraphQLVisitableModel graphQLVisitableModel = null;
                        h();
                        if (m2564a() != null) {
                            GraphQLStory graphQLStory = (GraphQLStory) graphQLModelMutatingVisitor.b(m2564a());
                            if (m2564a() != graphQLStory) {
                                graphQLVisitableModel = (EdgesModel) ModelHelper.a(null, this);
                                graphQLVisitableModel.f1747d = graphQLStory;
                            }
                        }
                        i();
                        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                    }

                    public final int m2565a(FlatBufferBuilder flatBufferBuilder) {
                        h();
                        int a = ModelHelper.a(flatBufferBuilder, m2564a());
                        flatBufferBuilder.c(1);
                        flatBufferBuilder.b(0, a);
                        i();
                        return flatBufferBuilder.d();
                    }
                }

                /* compiled from: setSproutsMetadataFlowState */
                public class Serializer extends JsonSerializer<AllDraftPostsModel> {
                    public final void m2567a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        AllDraftPostsModel allDraftPostsModel = (AllDraftPostsModel) obj;
                        if (allDraftPostsModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(allDraftPostsModel.m2570a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            allDraftPostsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        AllDraftPostsParser.m2588a(allDraftPostsModel.w_(), allDraftPostsModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(AllDraftPostsModel.class, new Serializer());
                    }
                }

                public AllDraftPostsModel() {
                    super(3);
                }

                @Nonnull
                private ImmutableList<EdgesModel> m2568a() {
                    this.f1749e = super.a(this.f1749e, 1, EdgesModel.class);
                    return (ImmutableList) this.f1749e;
                }

                @Nullable
                private ConnectionControllerPageInfoGraphQLModel m2569j() {
                    this.f1750f = (ConnectionControllerPageInfoGraphQLModel) super.a(this.f1750f, 2, ConnectionControllerPageInfoGraphQLModel.class);
                    return this.f1750f;
                }

                public final int jK_() {
                    return -1445101999;
                }

                public final GraphQLVisitableModel m2571a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel;
                    ConnectionControllerPageInfoGraphQLModel connectionControllerPageInfoGraphQLModel;
                    h();
                    if (m2568a() != null) {
                        Builder a = ModelHelper.a(m2568a(), graphQLModelMutatingVisitor);
                        if (a != null) {
                            AllDraftPostsModel allDraftPostsModel = (AllDraftPostsModel) ModelHelper.a(null, this);
                            allDraftPostsModel.f1749e = a.b();
                            graphQLVisitableModel = allDraftPostsModel;
                            if (m2569j() != null) {
                                connectionControllerPageInfoGraphQLModel = (ConnectionControllerPageInfoGraphQLModel) graphQLModelMutatingVisitor.b(m2569j());
                                if (m2569j() != connectionControllerPageInfoGraphQLModel) {
                                    graphQLVisitableModel = (AllDraftPostsModel) ModelHelper.a(graphQLVisitableModel, this);
                                    graphQLVisitableModel.f1750f = connectionControllerPageInfoGraphQLModel;
                                }
                            }
                            i();
                            return graphQLVisitableModel != null ? this : graphQLVisitableModel;
                        }
                    }
                    graphQLVisitableModel = null;
                    if (m2569j() != null) {
                        connectionControllerPageInfoGraphQLModel = (ConnectionControllerPageInfoGraphQLModel) graphQLModelMutatingVisitor.b(m2569j());
                        if (m2569j() != connectionControllerPageInfoGraphQLModel) {
                            graphQLVisitableModel = (AllDraftPostsModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f1750f = connectionControllerPageInfoGraphQLModel;
                        }
                    }
                    i();
                    if (graphQLVisitableModel != null) {
                    }
                }

                public final int m2570a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m2568a());
                    int a2 = ModelHelper.a(flatBufferBuilder, m2569j());
                    flatBufferBuilder.c(3);
                    flatBufferBuilder.a(0, this.f1748d, 0);
                    flatBufferBuilder.b(1, a);
                    flatBufferBuilder.b(2, a2);
                    i();
                    return flatBufferBuilder.d();
                }

                public final void m2572a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                    super.a(mutableFlatBuffer, i, obj);
                    this.f1748d = mutableFlatBuffer.a(i, 0, 0);
                }
            }

            /* compiled from: setSproutsMetadataFlowState */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(AdminInfoModel.class, new Deserializer());
                }

                public Object m2573a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(AdminInfoParser.m2589a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object adminInfoModel = new AdminInfoModel();
                    ((BaseModel) adminInfoModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (adminInfoModel instanceof Postprocessable) {
                        return ((Postprocessable) adminInfoModel).a();
                    }
                    return adminInfoModel;
                }
            }

            /* compiled from: setSproutsMetadataFlowState */
            public class Serializer extends JsonSerializer<AdminInfoModel> {
                public final void m2574a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    AdminInfoModel adminInfoModel = (AdminInfoModel) obj;
                    if (adminInfoModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(adminInfoModel.m2576a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        adminInfoModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    AdminInfoParser.m2590a(adminInfoModel.w_(), adminInfoModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(AdminInfoModel.class, new Serializer());
                }
            }

            public AdminInfoModel() {
                super(1);
            }

            @Nullable
            private AllDraftPostsModel m2575a() {
                this.f1751d = (AllDraftPostsModel) super.a(this.f1751d, 0, AllDraftPostsModel.class);
                return this.f1751d;
            }

            public final int jK_() {
                return 888797870;
            }

            public final GraphQLVisitableModel m2577a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m2575a() != null) {
                    AllDraftPostsModel allDraftPostsModel = (AllDraftPostsModel) graphQLModelMutatingVisitor.b(m2575a());
                    if (m2575a() != allDraftPostsModel) {
                        graphQLVisitableModel = (AdminInfoModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f1751d = allDraftPostsModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m2576a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m2575a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: setSproutsMetadataFlowState */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FetchDraftPostsQueryModel.class, new Deserializer());
            }

            public Object m2578a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = FetchDraftPostsQueryParser.m2591a(jsonParser);
                Object fetchDraftPostsQueryModel = new FetchDraftPostsQueryModel();
                ((BaseModel) fetchDraftPostsQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (fetchDraftPostsQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) fetchDraftPostsQueryModel).a();
                }
                return fetchDraftPostsQueryModel;
            }
        }

        /* compiled from: setSproutsMetadataFlowState */
        public class Serializer extends JsonSerializer<FetchDraftPostsQueryModel> {
            public final void m2579a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                FetchDraftPostsQueryModel fetchDraftPostsQueryModel = (FetchDraftPostsQueryModel) obj;
                if (fetchDraftPostsQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(fetchDraftPostsQueryModel.m2581a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    fetchDraftPostsQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = fetchDraftPostsQueryModel.w_();
                int u_ = fetchDraftPostsQueryModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("admin_info");
                    AdminInfoParser.m2590a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(FetchDraftPostsQueryModel.class, new Serializer());
            }
        }

        public FetchDraftPostsQueryModel() {
            super(1);
        }

        public final void m2583a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m2584a(String str, Object obj, boolean z) {
        }

        @Nullable
        private AdminInfoModel m2580a() {
            this.f1752d = (AdminInfoModel) super.a(this.f1752d, 0, AdminInfoModel.class);
            return this.f1752d;
        }

        public final int jK_() {
            return 2479791;
        }

        public final GraphQLVisitableModel m2582a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m2580a() != null) {
                AdminInfoModel adminInfoModel = (AdminInfoModel) graphQLModelMutatingVisitor.b(m2580a());
                if (m2580a() != adminInfoModel) {
                    graphQLVisitableModel = (FetchDraftPostsQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f1752d = adminInfoModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m2581a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m2580a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }
}
