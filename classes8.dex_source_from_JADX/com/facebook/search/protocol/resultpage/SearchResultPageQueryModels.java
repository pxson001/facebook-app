package com.facebook.search.protocol.resultpage;

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
import com.facebook.graphql.querybuilder.common.CommonGraphQL2Models.DefaultPageInfoFieldsModel;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.search.protocol.resultpage.SearchProductItemNodeModels.SearchProductItemNodeModel;
import com.facebook.search.protocol.resultpage.SearchResultPageQueryParsers.FilteredQueryParser;
import com.facebook.search.protocol.resultpage.SearchResultPageQueryParsers.FilteredQueryParser.FilteredQueryFilteredQueryParser;
import com.facebook.search.protocol.resultpage.SearchResultPageQueryParsers.FilteredQueryParser.FilteredQueryFilteredQueryParser.ResultsParser;
import com.facebook.search.protocol.resultpage.SearchResultPageQueryParsers.FilteredQueryParser.FilteredQueryFilteredQueryParser.ResultsParser.EdgesParser;
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

/* compiled from: most_recent_user_ids */
public class SearchResultPageQueryModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -254839489)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: most_recent_user_ids */
    public final class FilteredQueryModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private FilteredQueryFilteredQueryModel f8319d;

        /* compiled from: most_recent_user_ids */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FilteredQueryModel.class, new Deserializer());
            }

            public Object m9522a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = FilteredQueryParser.m9550a(jsonParser);
                Object filteredQueryModel = new FilteredQueryModel();
                ((BaseModel) filteredQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (filteredQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) filteredQueryModel).a();
                }
                return filteredQueryModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1337238434)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: most_recent_user_ids */
        public final class FilteredQueryFilteredQueryModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private ResultsModel f8318d;

            /* compiled from: most_recent_user_ids */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(FilteredQueryFilteredQueryModel.class, new Deserializer());
                }

                public Object m9523a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(FilteredQueryFilteredQueryParser.m9548a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object filteredQueryFilteredQueryModel = new FilteredQueryFilteredQueryModel();
                    ((BaseModel) filteredQueryFilteredQueryModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (filteredQueryFilteredQueryModel instanceof Postprocessable) {
                        return ((Postprocessable) filteredQueryFilteredQueryModel).a();
                    }
                    return filteredQueryFilteredQueryModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 23729768)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: most_recent_user_ids */
            public final class ResultsModel extends BaseModel implements GraphQLVisitableModel {
                private int f8315d;
                @Nullable
                private List<EdgesModel> f8316e;
                @Nullable
                private DefaultPageInfoFieldsModel f8317f;

                /* compiled from: most_recent_user_ids */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(ResultsModel.class, new Deserializer());
                    }

                    public Object m9524a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(ResultsParser.m9546a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object resultsModel = new ResultsModel();
                        ((BaseModel) resultsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (resultsModel instanceof Postprocessable) {
                            return ((Postprocessable) resultsModel).a();
                        }
                        return resultsModel;
                    }
                }

                @JsonDeserialize(using = Deserializer.class)
                @ModelWithFlatBufferFormatHash(a = 1376493060)
                @JsonSerialize(using = Serializer.class)
                @FragmentModelWithoutBridge
                /* compiled from: most_recent_user_ids */
                public final class EdgesModel extends BaseModel implements GraphQLVisitableModel {
                    @Nullable
                    private SearchProductItemNodeModel f8314d;

                    /* compiled from: most_recent_user_ids */
                    public class Deserializer extends FbJsonDeserializer {
                        static {
                            GlobalAutoGenDeserializerCache.a(EdgesModel.class, new Deserializer());
                        }

                        public Object m9525a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(EdgesParser.m9544b(jsonParser, flatBufferBuilder));
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

                    /* compiled from: most_recent_user_ids */
                    public class Serializer extends JsonSerializer<EdgesModel> {
                        public final void m9526a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            EdgesModel edgesModel = (EdgesModel) obj;
                            if (edgesModel.w_() == null) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(edgesModel.m9528a(flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                edgesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                            }
                            EdgesParser.m9545b(edgesModel.w_(), edgesModel.u_(), jsonGenerator, serializerProvider);
                        }

                        static {
                            FbSerializerProvider.a(EdgesModel.class, new Serializer());
                        }
                    }

                    public EdgesModel() {
                        super(1);
                    }

                    @Nullable
                    private SearchProductItemNodeModel m9527a() {
                        this.f8314d = (SearchProductItemNodeModel) super.a(this.f8314d, 0, SearchProductItemNodeModel.class);
                        return this.f8314d;
                    }

                    public final int jK_() {
                        return -316863363;
                    }

                    public final GraphQLVisitableModel m9529a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                        GraphQLVisitableModel graphQLVisitableModel = null;
                        h();
                        if (m9527a() != null) {
                            SearchProductItemNodeModel searchProductItemNodeModel = (SearchProductItemNodeModel) graphQLModelMutatingVisitor.b(m9527a());
                            if (m9527a() != searchProductItemNodeModel) {
                                graphQLVisitableModel = (EdgesModel) ModelHelper.a(null, this);
                                graphQLVisitableModel.f8314d = searchProductItemNodeModel;
                            }
                        }
                        i();
                        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                    }

                    public final int m9528a(FlatBufferBuilder flatBufferBuilder) {
                        h();
                        int a = ModelHelper.a(flatBufferBuilder, m9527a());
                        flatBufferBuilder.c(1);
                        flatBufferBuilder.b(0, a);
                        i();
                        return flatBufferBuilder.d();
                    }
                }

                /* compiled from: most_recent_user_ids */
                public class Serializer extends JsonSerializer<ResultsModel> {
                    public final void m9530a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        ResultsModel resultsModel = (ResultsModel) obj;
                        if (resultsModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(resultsModel.m9533a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            resultsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        ResultsParser.m9547a(resultsModel.w_(), resultsModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(ResultsModel.class, new Serializer());
                    }
                }

                public ResultsModel() {
                    super(3);
                }

                @Nonnull
                private ImmutableList<EdgesModel> m9531a() {
                    this.f8316e = super.a(this.f8316e, 1, EdgesModel.class);
                    return (ImmutableList) this.f8316e;
                }

                @Nullable
                private DefaultPageInfoFieldsModel m9532j() {
                    this.f8317f = (DefaultPageInfoFieldsModel) super.a(this.f8317f, 2, DefaultPageInfoFieldsModel.class);
                    return this.f8317f;
                }

                public final int jK_() {
                    return 1580207518;
                }

                public final GraphQLVisitableModel m9534a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel;
                    DefaultPageInfoFieldsModel defaultPageInfoFieldsModel;
                    h();
                    if (m9531a() != null) {
                        Builder a = ModelHelper.a(m9531a(), graphQLModelMutatingVisitor);
                        if (a != null) {
                            ResultsModel resultsModel = (ResultsModel) ModelHelper.a(null, this);
                            resultsModel.f8316e = a.b();
                            graphQLVisitableModel = resultsModel;
                            if (m9532j() != null) {
                                defaultPageInfoFieldsModel = (DefaultPageInfoFieldsModel) graphQLModelMutatingVisitor.b(m9532j());
                                if (m9532j() != defaultPageInfoFieldsModel) {
                                    graphQLVisitableModel = (ResultsModel) ModelHelper.a(graphQLVisitableModel, this);
                                    graphQLVisitableModel.f8317f = defaultPageInfoFieldsModel;
                                }
                            }
                            i();
                            return graphQLVisitableModel != null ? this : graphQLVisitableModel;
                        }
                    }
                    graphQLVisitableModel = null;
                    if (m9532j() != null) {
                        defaultPageInfoFieldsModel = (DefaultPageInfoFieldsModel) graphQLModelMutatingVisitor.b(m9532j());
                        if (m9532j() != defaultPageInfoFieldsModel) {
                            graphQLVisitableModel = (ResultsModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f8317f = defaultPageInfoFieldsModel;
                        }
                    }
                    i();
                    if (graphQLVisitableModel != null) {
                    }
                }

                public final int m9533a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m9531a());
                    int a2 = ModelHelper.a(flatBufferBuilder, m9532j());
                    flatBufferBuilder.c(3);
                    flatBufferBuilder.a(0, this.f8315d, 0);
                    flatBufferBuilder.b(1, a);
                    flatBufferBuilder.b(2, a2);
                    i();
                    return flatBufferBuilder.d();
                }

                public final void m9535a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                    super.a(mutableFlatBuffer, i, obj);
                    this.f8315d = mutableFlatBuffer.a(i, 0, 0);
                }
            }

            /* compiled from: most_recent_user_ids */
            public class Serializer extends JsonSerializer<FilteredQueryFilteredQueryModel> {
                public final void m9536a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    FilteredQueryFilteredQueryModel filteredQueryFilteredQueryModel = (FilteredQueryFilteredQueryModel) obj;
                    if (filteredQueryFilteredQueryModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(filteredQueryFilteredQueryModel.m9538a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        filteredQueryFilteredQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    FilteredQueryFilteredQueryParser.m9549a(filteredQueryFilteredQueryModel.w_(), filteredQueryFilteredQueryModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(FilteredQueryFilteredQueryModel.class, new Serializer());
                }
            }

            public FilteredQueryFilteredQueryModel() {
                super(1);
            }

            @Nullable
            private ResultsModel m9537a() {
                this.f8318d = (ResultsModel) super.a(this.f8318d, 0, ResultsModel.class);
                return this.f8318d;
            }

            public final int jK_() {
                return -466486798;
            }

            public final GraphQLVisitableModel m9539a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m9537a() != null) {
                    ResultsModel resultsModel = (ResultsModel) graphQLModelMutatingVisitor.b(m9537a());
                    if (m9537a() != resultsModel) {
                        graphQLVisitableModel = (FilteredQueryFilteredQueryModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f8318d = resultsModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m9538a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m9537a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: most_recent_user_ids */
        public class Serializer extends JsonSerializer<FilteredQueryModel> {
            public final void m9540a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                FilteredQueryModel filteredQueryModel = (FilteredQueryModel) obj;
                if (filteredQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(filteredQueryModel.m9542a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    filteredQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = filteredQueryModel.w_();
                int u_ = filteredQueryModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("filtered_query");
                    FilteredQueryFilteredQueryParser.m9549a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(FilteredQueryModel.class, new Serializer());
            }
        }

        public FilteredQueryModel() {
            super(1);
        }

        @Nullable
        private FilteredQueryFilteredQueryModel m9541a() {
            this.f8319d = (FilteredQueryFilteredQueryModel) super.a(this.f8319d, 0, FilteredQueryFilteredQueryModel.class);
            return this.f8319d;
        }

        public final int jK_() {
            return -466486798;
        }

        public final GraphQLVisitableModel m9543a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m9541a() != null) {
                FilteredQueryFilteredQueryModel filteredQueryFilteredQueryModel = (FilteredQueryFilteredQueryModel) graphQLModelMutatingVisitor.b(m9541a());
                if (m9541a() != filteredQueryFilteredQueryModel) {
                    graphQLVisitableModel = (FilteredQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f8319d = filteredQueryFilteredQueryModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m9542a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m9541a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }
}
