package com.facebook.search.protocol.feedstory;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithBridge;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLGraphSearchResultsDisplayStyle;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.model.GraphQLComment;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.querybuilder.common.CommonGraphQL2Models.DefaultPageInfoFieldsModel;
import com.facebook.graphql.visitor.ConsistencyTuple;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.search.protocol.feedstory.FetchGraphSearchFeedDataGraphQLParsers.FetchGraphSearchForSalePostsWithFiltersParser;
import com.facebook.search.protocol.feedstory.FetchGraphSearchFeedDataGraphQLParsers.FetchGraphSearchForSalePostsWithFiltersParser.FilteredQueryParser;
import com.facebook.search.protocol.feedstory.FetchGraphSearchFeedDataGraphQLParsers.ForSalePostSearchResultParser;
import com.facebook.search.protocol.feedstory.FetchGraphSearchFeedDataGraphQLParsers.ForSalePostSearchResultParser.ResultsParser;
import com.facebook.search.protocol.feedstory.FetchGraphSearchFeedDataGraphQLParsers.ForSalePostSearchResultParser.ResultsParser.EdgesParser;
import com.facebook.search.protocol.feedstory.FetchGraphSearchFeedDataGraphQLParsers.PostSearchResultDecorationParser;
import com.facebook.search.protocol.feedstory.FetchGraphSearchFeedDataGraphQLParsers.PostSearchResultDecorationParser.LineageSnippetsParser;
import com.facebook.search.protocol.feedstory.FetchGraphSearchFeedDataGraphQLParsers.PostSearchResultDecorationParser.LineageSnippetsParser.DetailSentencesParser;
import com.facebook.search.protocol.feedstory.FetchGraphSearchFeedDataGraphQLParsers.VideoSearchResultParser;
import com.facebook.search.protocol.feedstory.FetchGraphSearchFeedDataGraphQLParsers.VideoSearchResultParser.ResultsParser.EdgesParser.NodeParser;
import com.facebook.search.protocol.feedstory.FetchGraphSearchResultDataGraphQLModels.FBGraphSearchQueryDetailsFragmentModel.ModulesModel;
import com.facebook.search.protocol.feedstory.FetchGraphSearchResultDataGraphQLModels.FBGraphSearchQueryDetailsFragmentModel.QueryTitleModel;
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

/* compiled from: nearby_places_location_id */
public class FetchGraphSearchFeedDataGraphQLModels {

    @FragmentModelWithBridge
    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1429823910)
    @JsonSerialize(using = Serializer.class)
    /* compiled from: nearby_places_location_id */
    public final class FetchGraphSearchForSalePostsWithFiltersModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private FilteredQueryModel f8186d;

        /* compiled from: nearby_places_location_id */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FetchGraphSearchForSalePostsWithFiltersModel.class, new Deserializer());
            }

            public Object m9084a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = FetchGraphSearchForSalePostsWithFiltersParser.m9164a(jsonParser);
                Object fetchGraphSearchForSalePostsWithFiltersModel = new FetchGraphSearchForSalePostsWithFiltersModel();
                ((BaseModel) fetchGraphSearchForSalePostsWithFiltersModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (fetchGraphSearchForSalePostsWithFiltersModel instanceof Postprocessable) {
                    return ((Postprocessable) fetchGraphSearchForSalePostsWithFiltersModel).a();
                }
                return fetchGraphSearchForSalePostsWithFiltersModel;
            }
        }

        @FragmentModelWithBridge
        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 34936102)
        @JsonSerialize(using = Serializer.class)
        /* compiled from: nearby_places_location_id */
        public final class FilteredQueryModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
            @Nullable
            private String f8180d;
            @Nullable
            private ModulesModel f8181e;
            @Nullable
            private String f8182f;
            @Nullable
            private QueryTitleModel f8183g;
            @Nullable
            private ResultsModel f8184h;
            @Nullable
            private List<GraphQLGraphSearchResultsDisplayStyle> f8185i;

            /* compiled from: nearby_places_location_id */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(FilteredQueryModel.class, new Deserializer());
                }

                public Object m9085a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(FilteredQueryParser.m9162a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object filteredQueryModel = new FilteredQueryModel();
                    ((BaseModel) filteredQueryModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (filteredQueryModel instanceof Postprocessable) {
                        return ((Postprocessable) filteredQueryModel).a();
                    }
                    return filteredQueryModel;
                }
            }

            /* compiled from: nearby_places_location_id */
            public class Serializer extends JsonSerializer<FilteredQueryModel> {
                public final void m9086a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    FilteredQueryModel filteredQueryModel = (FilteredQueryModel) obj;
                    if (filteredQueryModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(filteredQueryModel.m9093a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        filteredQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    FilteredQueryParser.m9163a(filteredQueryModel.w_(), filteredQueryModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(FilteredQueryModel.class, new Serializer());
                }
            }

            public FilteredQueryModel() {
                super(6);
            }

            @Nullable
            private String m9087j() {
                this.f8180d = super.a(this.f8180d, 0);
                return this.f8180d;
            }

            @Nullable
            private ModulesModel m9088k() {
                this.f8181e = (ModulesModel) super.a(this.f8181e, 1, ModulesModel.class);
                return this.f8181e;
            }

            @Nullable
            private String m9089l() {
                this.f8182f = super.a(this.f8182f, 2);
                return this.f8182f;
            }

            @Nullable
            private QueryTitleModel m9090m() {
                this.f8183g = (QueryTitleModel) super.a(this.f8183g, 3, QueryTitleModel.class);
                return this.f8183g;
            }

            @Nullable
            private ResultsModel m9091n() {
                this.f8184h = (ResultsModel) super.a(this.f8184h, 4, ResultsModel.class);
                return this.f8184h;
            }

            @Nonnull
            private ImmutableList<GraphQLGraphSearchResultsDisplayStyle> m9092o() {
                this.f8185i = super.c(this.f8185i, 5, GraphQLGraphSearchResultsDisplayStyle.class);
                return (ImmutableList) this.f8185i;
            }

            @Nullable
            public final String m9095a() {
                return m9087j();
            }

            public final int jK_() {
                return -466486798;
            }

            public final GraphQLVisitableModel m9094a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m9088k() != null) {
                    ModulesModel modulesModel = (ModulesModel) graphQLModelMutatingVisitor.b(m9088k());
                    if (m9088k() != modulesModel) {
                        graphQLVisitableModel = (FilteredQueryModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f8181e = modulesModel;
                    }
                }
                if (m9090m() != null) {
                    QueryTitleModel queryTitleModel = (QueryTitleModel) graphQLModelMutatingVisitor.b(m9090m());
                    if (m9090m() != queryTitleModel) {
                        graphQLVisitableModel = (FilteredQueryModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f8183g = queryTitleModel;
                    }
                }
                if (m9091n() != null) {
                    ResultsModel resultsModel = (ResultsModel) graphQLModelMutatingVisitor.b(m9091n());
                    if (m9091n() != resultsModel) {
                        graphQLVisitableModel = (FilteredQueryModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f8184h = resultsModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m9093a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m9087j());
                int a = ModelHelper.a(flatBufferBuilder, m9088k());
                int b2 = flatBufferBuilder.b(m9089l());
                int a2 = ModelHelper.a(flatBufferBuilder, m9090m());
                int a3 = ModelHelper.a(flatBufferBuilder, m9091n());
                int d = flatBufferBuilder.d(m9092o());
                flatBufferBuilder.c(6);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.b(1, a);
                flatBufferBuilder.b(2, b2);
                flatBufferBuilder.b(3, a2);
                flatBufferBuilder.b(4, a3);
                flatBufferBuilder.b(5, d);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: nearby_places_location_id */
        public class Serializer extends JsonSerializer<FetchGraphSearchForSalePostsWithFiltersModel> {
            public final void m9096a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                FetchGraphSearchForSalePostsWithFiltersModel fetchGraphSearchForSalePostsWithFiltersModel = (FetchGraphSearchForSalePostsWithFiltersModel) obj;
                if (fetchGraphSearchForSalePostsWithFiltersModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(fetchGraphSearchForSalePostsWithFiltersModel.m9098a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    fetchGraphSearchForSalePostsWithFiltersModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = fetchGraphSearchForSalePostsWithFiltersModel.w_();
                int u_ = fetchGraphSearchForSalePostsWithFiltersModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("filtered_query");
                    FilteredQueryParser.m9163a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(FetchGraphSearchForSalePostsWithFiltersModel.class, new Serializer());
            }
        }

        public FetchGraphSearchForSalePostsWithFiltersModel() {
            super(1);
        }

        @Nullable
        private FilteredQueryModel m9097a() {
            this.f8186d = (FilteredQueryModel) super.a(this.f8186d, 0, FilteredQueryModel.class);
            return this.f8186d;
        }

        public final int jK_() {
            return -466486798;
        }

        public final GraphQLVisitableModel m9099a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m9097a() != null) {
                FilteredQueryModel filteredQueryModel = (FilteredQueryModel) graphQLModelMutatingVisitor.b(m9097a());
                if (m9097a() != filteredQueryModel) {
                    graphQLVisitableModel = (FetchGraphSearchForSalePostsWithFiltersModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f8186d = filteredQueryModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m9098a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m9097a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @FragmentModelWithBridge
    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 56382132)
    @JsonSerialize(using = Serializer.class)
    /* compiled from: nearby_places_location_id */
    public final class ForSalePostSearchResultModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private ResultsModel f8193d;

        /* compiled from: nearby_places_location_id */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(ForSalePostSearchResultModel.class, new Deserializer());
            }

            public Object m9100a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = ForSalePostSearchResultParser.m9169a(jsonParser);
                Object forSalePostSearchResultModel = new ForSalePostSearchResultModel();
                ((BaseModel) forSalePostSearchResultModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (forSalePostSearchResultModel instanceof Postprocessable) {
                    return ((Postprocessable) forSalePostSearchResultModel).a();
                }
                return forSalePostSearchResultModel;
            }
        }

        @FragmentModelWithBridge
        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -2119290014)
        @JsonSerialize(using = Serializer.class)
        /* compiled from: nearby_places_location_id */
        public final class ResultsModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<EdgesModel> f8191d;
            @Nullable
            private DefaultPageInfoFieldsModel f8192e;

            /* compiled from: nearby_places_location_id */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(ResultsModel.class, new Deserializer());
                }

                public Object m9101a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(ResultsParser.m9167a(jsonParser, flatBufferBuilder));
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

            @FragmentModelWithBridge
            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 134283745)
            @JsonSerialize(using = Serializer.class)
            /* compiled from: nearby_places_location_id */
            public final class EdgesModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private String f8187d;
                @Nullable
                private GraphQLStory f8188e;
                @Nullable
                private PostSearchResultDecorationModel f8189f;
                @Nullable
                private String f8190g;

                /* compiled from: nearby_places_location_id */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(EdgesModel.class, new Deserializer());
                    }

                    public Object m9102a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(EdgesParser.m9165b(jsonParser, flatBufferBuilder));
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

                /* compiled from: nearby_places_location_id */
                public class Serializer extends JsonSerializer<EdgesModel> {
                    public final void m9103a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        EdgesModel edgesModel = (EdgesModel) obj;
                        if (edgesModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(edgesModel.m9108a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            edgesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        EdgesParser.m9166b(edgesModel.w_(), edgesModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(EdgesModel.class, new Serializer());
                    }
                }

                public EdgesModel() {
                    super(4);
                }

                @Nullable
                private String m9104a() {
                    this.f8187d = super.a(this.f8187d, 0);
                    return this.f8187d;
                }

                @Nullable
                private GraphQLStory m9105j() {
                    this.f8188e = (GraphQLStory) super.a(this.f8188e, 1, GraphQLStory.class);
                    return this.f8188e;
                }

                @Nullable
                private PostSearchResultDecorationModel m9106k() {
                    this.f8189f = (PostSearchResultDecorationModel) super.a(this.f8189f, 2, PostSearchResultDecorationModel.class);
                    return this.f8189f;
                }

                @Nullable
                private String m9107l() {
                    this.f8190g = super.a(this.f8190g, 3);
                    return this.f8190g;
                }

                public final int jK_() {
                    return -316863363;
                }

                public final GraphQLVisitableModel m9109a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m9105j() != null) {
                        GraphQLStory graphQLStory = (GraphQLStory) graphQLModelMutatingVisitor.b(m9105j());
                        if (m9105j() != graphQLStory) {
                            graphQLVisitableModel = (EdgesModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f8188e = graphQLStory;
                        }
                    }
                    if (m9106k() != null) {
                        PostSearchResultDecorationModel postSearchResultDecorationModel = (PostSearchResultDecorationModel) graphQLModelMutatingVisitor.b(m9106k());
                        if (m9106k() != postSearchResultDecorationModel) {
                            graphQLVisitableModel = (EdgesModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f8189f = postSearchResultDecorationModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m9108a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int b = flatBufferBuilder.b(m9104a());
                    int a = ModelHelper.a(flatBufferBuilder, m9105j());
                    int a2 = ModelHelper.a(flatBufferBuilder, m9106k());
                    int b2 = flatBufferBuilder.b(m9107l());
                    flatBufferBuilder.c(4);
                    flatBufferBuilder.b(0, b);
                    flatBufferBuilder.b(1, a);
                    flatBufferBuilder.b(2, a2);
                    flatBufferBuilder.b(3, b2);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: nearby_places_location_id */
            public class Serializer extends JsonSerializer<ResultsModel> {
                public final void m9110a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    ResultsModel resultsModel = (ResultsModel) obj;
                    if (resultsModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(resultsModel.m9113a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        resultsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    ResultsParser.m9168a(resultsModel.w_(), resultsModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(ResultsModel.class, new Serializer());
                }
            }

            public ResultsModel() {
                super(2);
            }

            @Nonnull
            private ImmutableList<EdgesModel> m9111a() {
                this.f8191d = super.a(this.f8191d, 0, EdgesModel.class);
                return (ImmutableList) this.f8191d;
            }

            @Nullable
            private DefaultPageInfoFieldsModel m9112j() {
                this.f8192e = (DefaultPageInfoFieldsModel) super.a(this.f8192e, 1, DefaultPageInfoFieldsModel.class);
                return this.f8192e;
            }

            public final int jK_() {
                return 1580207518;
            }

            public final GraphQLVisitableModel m9114a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel;
                DefaultPageInfoFieldsModel defaultPageInfoFieldsModel;
                h();
                if (m9111a() != null) {
                    Builder a = ModelHelper.a(m9111a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        ResultsModel resultsModel = (ResultsModel) ModelHelper.a(null, this);
                        resultsModel.f8191d = a.b();
                        graphQLVisitableModel = resultsModel;
                        if (m9112j() != null) {
                            defaultPageInfoFieldsModel = (DefaultPageInfoFieldsModel) graphQLModelMutatingVisitor.b(m9112j());
                            if (m9112j() != defaultPageInfoFieldsModel) {
                                graphQLVisitableModel = (ResultsModel) ModelHelper.a(graphQLVisitableModel, this);
                                graphQLVisitableModel.f8192e = defaultPageInfoFieldsModel;
                            }
                        }
                        i();
                        return graphQLVisitableModel != null ? this : graphQLVisitableModel;
                    }
                }
                graphQLVisitableModel = null;
                if (m9112j() != null) {
                    defaultPageInfoFieldsModel = (DefaultPageInfoFieldsModel) graphQLModelMutatingVisitor.b(m9112j());
                    if (m9112j() != defaultPageInfoFieldsModel) {
                        graphQLVisitableModel = (ResultsModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f8192e = defaultPageInfoFieldsModel;
                    }
                }
                i();
                if (graphQLVisitableModel != null) {
                }
            }

            public final int m9113a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m9111a());
                int a2 = ModelHelper.a(flatBufferBuilder, m9112j());
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, a2);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: nearby_places_location_id */
        public class Serializer extends JsonSerializer<ForSalePostSearchResultModel> {
            public final void m9115a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                ForSalePostSearchResultModel forSalePostSearchResultModel = (ForSalePostSearchResultModel) obj;
                if (forSalePostSearchResultModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(forSalePostSearchResultModel.m9117a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    forSalePostSearchResultModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = forSalePostSearchResultModel.w_();
                int u_ = forSalePostSearchResultModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("results");
                    ResultsParser.m9168a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(ForSalePostSearchResultModel.class, new Serializer());
            }
        }

        public ForSalePostSearchResultModel() {
            super(1);
        }

        @Nullable
        private ResultsModel m9116a() {
            this.f8193d = (ResultsModel) super.a(this.f8193d, 0, ResultsModel.class);
            return this.f8193d;
        }

        public final int jK_() {
            return -466486798;
        }

        public final GraphQLVisitableModel m9118a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m9116a() != null) {
                ResultsModel resultsModel = (ResultsModel) graphQLModelMutatingVisitor.b(m9116a());
                if (m9116a() != resultsModel) {
                    graphQLVisitableModel = (ForSalePostSearchResultModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f8193d = resultsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m9117a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m9116a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @FragmentModelWithBridge
    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 306576320)
    @JsonSerialize(using = Serializer.class)
    /* compiled from: nearby_places_location_id */
    public final class PostSearchResultDecorationModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private List<GraphQLComment> f8196d;
        @Nullable
        private List<LineageSnippetsModel> f8197e;
        @Nullable
        private List<String> f8198f;

        /* compiled from: nearby_places_location_id */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(PostSearchResultDecorationModel.class, new Deserializer());
            }

            public Object m9119a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(PostSearchResultDecorationParser.m9174a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object postSearchResultDecorationModel = new PostSearchResultDecorationModel();
                ((BaseModel) postSearchResultDecorationModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (postSearchResultDecorationModel instanceof Postprocessable) {
                    return ((Postprocessable) postSearchResultDecorationModel).a();
                }
                return postSearchResultDecorationModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 2144985678)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: nearby_places_location_id */
        public final class LineageSnippetsModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<DetailSentencesModel> f8195d;

            /* compiled from: nearby_places_location_id */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(LineageSnippetsModel.class, new Deserializer());
                }

                public Object m9120a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(LineageSnippetsParser.m9172b(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object lineageSnippetsModel = new LineageSnippetsModel();
                    ((BaseModel) lineageSnippetsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (lineageSnippetsModel instanceof Postprocessable) {
                        return ((Postprocessable) lineageSnippetsModel).a();
                    }
                    return lineageSnippetsModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -1352864475)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: nearby_places_location_id */
            public final class DetailSentencesModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private String f8194d;

                /* compiled from: nearby_places_location_id */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(DetailSentencesModel.class, new Deserializer());
                    }

                    public Object m9121a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(DetailSentencesParser.m9171b(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object detailSentencesModel = new DetailSentencesModel();
                        ((BaseModel) detailSentencesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (detailSentencesModel instanceof Postprocessable) {
                            return ((Postprocessable) detailSentencesModel).a();
                        }
                        return detailSentencesModel;
                    }
                }

                /* compiled from: nearby_places_location_id */
                public class Serializer extends JsonSerializer<DetailSentencesModel> {
                    public final void m9122a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        DetailSentencesModel detailSentencesModel = (DetailSentencesModel) obj;
                        if (detailSentencesModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(detailSentencesModel.m9124a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            detailSentencesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        DetailSentencesParser.m9170a(detailSentencesModel.w_(), detailSentencesModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(DetailSentencesModel.class, new Serializer());
                    }
                }

                public DetailSentencesModel() {
                    super(1);
                }

                @Nullable
                private String m9123a() {
                    this.f8194d = super.a(this.f8194d, 0);
                    return this.f8194d;
                }

                public final int jK_() {
                    return -1919764332;
                }

                public final GraphQLVisitableModel m9125a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m9124a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int b = flatBufferBuilder.b(m9123a());
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, b);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: nearby_places_location_id */
            public class Serializer extends JsonSerializer<LineageSnippetsModel> {
                public final void m9126a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    LineageSnippetsModel lineageSnippetsModel = (LineageSnippetsModel) obj;
                    if (lineageSnippetsModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(lineageSnippetsModel.m9128a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        lineageSnippetsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    LineageSnippetsParser.m9173b(lineageSnippetsModel.w_(), lineageSnippetsModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(LineageSnippetsModel.class, new Serializer());
                }
            }

            public LineageSnippetsModel() {
                super(1);
            }

            @Nonnull
            private ImmutableList<DetailSentencesModel> m9127a() {
                this.f8195d = super.a(this.f8195d, 0, DetailSentencesModel.class);
                return (ImmutableList) this.f8195d;
            }

            public final int jK_() {
                return -38981689;
            }

            public final GraphQLVisitableModel m9129a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m9127a() != null) {
                    Builder a = ModelHelper.a(m9127a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (LineageSnippetsModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f8195d = a.b();
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m9128a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m9127a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: nearby_places_location_id */
        public class Serializer extends JsonSerializer<PostSearchResultDecorationModel> {
            public final void m9130a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                PostSearchResultDecorationModel postSearchResultDecorationModel = (PostSearchResultDecorationModel) obj;
                if (postSearchResultDecorationModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(postSearchResultDecorationModel.m9134a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    postSearchResultDecorationModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                PostSearchResultDecorationParser.m9175a(postSearchResultDecorationModel.w_(), postSearchResultDecorationModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(PostSearchResultDecorationModel.class, new Serializer());
            }
        }

        public PostSearchResultDecorationModel() {
            super(3);
        }

        @Nonnull
        private ImmutableList<GraphQLComment> m9131a() {
            this.f8196d = super.a(this.f8196d, 0, GraphQLComment.class);
            return (ImmutableList) this.f8196d;
        }

        @Nonnull
        private ImmutableList<LineageSnippetsModel> m9132j() {
            this.f8197e = super.a(this.f8197e, 1, LineageSnippetsModel.class);
            return (ImmutableList) this.f8197e;
        }

        @Nonnull
        private ImmutableList<String> m9133k() {
            this.f8198f = super.a(this.f8198f, 2);
            return (ImmutableList) this.f8198f;
        }

        public final int jK_() {
            return 379010371;
        }

        public final GraphQLVisitableModel m9135a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            Builder a;
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m9131a() != null) {
                a = ModelHelper.a(m9131a(), graphQLModelMutatingVisitor);
                if (a != null) {
                    graphQLVisitableModel = (PostSearchResultDecorationModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f8196d = a.b();
                }
            }
            if (m9132j() != null) {
                a = ModelHelper.a(m9132j(), graphQLModelMutatingVisitor);
                if (a != null) {
                    graphQLVisitableModel = (PostSearchResultDecorationModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f8197e = a.b();
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m9134a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m9131a());
            int a2 = ModelHelper.a(flatBufferBuilder, m9132j());
            int c = flatBufferBuilder.c(m9133k());
            flatBufferBuilder.c(3);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            flatBufferBuilder.b(2, c);
            i();
            return flatBufferBuilder.d();
        }
    }

    @FragmentModelWithBridge
    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -2084604658)
    @JsonSerialize(using = Serializer.class)
    /* compiled from: nearby_places_location_id */
    public final class VideoSearchResultModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private ResultsModel f8206d;

        /* compiled from: nearby_places_location_id */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(VideoSearchResultModel.class, new Deserializer());
            }

            public Object m9136a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = VideoSearchResultParser.m9182a(jsonParser);
                Object videoSearchResultModel = new VideoSearchResultModel();
                ((BaseModel) videoSearchResultModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (videoSearchResultModel instanceof Postprocessable) {
                    return ((Postprocessable) videoSearchResultModel).a();
                }
                return videoSearchResultModel;
            }
        }

        @FragmentModelWithBridge
        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1484602526)
        @JsonSerialize(using = Serializer.class)
        /* compiled from: nearby_places_location_id */
        public final class ResultsModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<EdgesModel> f8204d;
            @Nullable
            private DefaultPageInfoFieldsModel f8205e;

            /* compiled from: nearby_places_location_id */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(ResultsModel.class, new Deserializer());
                }

                public Object m9137a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(VideoSearchResultParser.ResultsParser.m9180a(jsonParser, flatBufferBuilder));
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

            @FragmentModelWithBridge
            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -114920754)
            @JsonSerialize(using = Serializer.class)
            /* compiled from: nearby_places_location_id */
            public final class EdgesModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private String f8201d;
                @Nullable
                private NodeModel f8202e;
                @Nullable
                private String f8203f;

                /* compiled from: nearby_places_location_id */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(EdgesModel.class, new Deserializer());
                    }

                    public Object m9138a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(VideoSearchResultParser.ResultsParser.EdgesParser.m9178b(jsonParser, flatBufferBuilder));
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

                @FragmentModelWithBridge
                @JsonDeserialize(using = Deserializer.class)
                @ModelWithFlatBufferFormatHash(a = 250138693)
                @JsonSerialize(using = Serializer.class)
                /* compiled from: nearby_places_location_id */
                public final class NodeModel extends BaseModel implements GraphQLVisitableConsistentModel {
                    @Nullable
                    private GraphQLObjectType f8199d;
                    @Nullable
                    private GraphQLStory f8200e;

                    /* compiled from: nearby_places_location_id */
                    public class Deserializer extends FbJsonDeserializer {
                        static {
                            GlobalAutoGenDeserializerCache.a(NodeModel.class, new Deserializer());
                        }

                        public Object m9139a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(NodeParser.m9176a(jsonParser, flatBufferBuilder));
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

                    /* compiled from: nearby_places_location_id */
                    public class Serializer extends JsonSerializer<NodeModel> {
                        public final void m9140a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            NodeModel nodeModel = (NodeModel) obj;
                            if (nodeModel.w_() == null) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(nodeModel.m9143a(flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                nodeModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                            }
                            NodeParser.m9177a(nodeModel.w_(), nodeModel.u_(), jsonGenerator, serializerProvider);
                        }

                        static {
                            FbSerializerProvider.a(NodeModel.class, new Serializer());
                        }
                    }

                    public NodeModel() {
                        super(2);
                    }

                    public final void m9145a(String str, ConsistencyTuple consistencyTuple) {
                        consistencyTuple.a();
                    }

                    public final void m9146a(String str, Object obj, boolean z) {
                    }

                    @Nullable
                    private GraphQLObjectType m9141a() {
                        if (this.b != null && this.f8199d == null) {
                            this.f8199d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                        }
                        return this.f8199d;
                    }

                    @Nullable
                    private GraphQLStory m9142j() {
                        this.f8200e = (GraphQLStory) super.a(this.f8200e, 1, GraphQLStory.class);
                        return this.f8200e;
                    }

                    public final int jK_() {
                        return 2433570;
                    }

                    public final GraphQLVisitableModel m9144a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                        GraphQLVisitableModel graphQLVisitableModel = null;
                        h();
                        if (m9142j() != null) {
                            GraphQLStory graphQLStory = (GraphQLStory) graphQLModelMutatingVisitor.b(m9142j());
                            if (m9142j() != graphQLStory) {
                                graphQLVisitableModel = (NodeModel) ModelHelper.a(null, this);
                                graphQLVisitableModel.f8200e = graphQLStory;
                            }
                        }
                        i();
                        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                    }

                    public final int m9143a(FlatBufferBuilder flatBufferBuilder) {
                        h();
                        int a = ModelHelper.a(flatBufferBuilder, m9141a());
                        int a2 = ModelHelper.a(flatBufferBuilder, m9142j());
                        flatBufferBuilder.c(2);
                        flatBufferBuilder.b(0, a);
                        flatBufferBuilder.b(1, a2);
                        i();
                        return flatBufferBuilder.d();
                    }
                }

                /* compiled from: nearby_places_location_id */
                public class Serializer extends JsonSerializer<EdgesModel> {
                    public final void m9147a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        EdgesModel edgesModel = (EdgesModel) obj;
                        if (edgesModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(edgesModel.m9151a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            edgesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        VideoSearchResultParser.ResultsParser.EdgesParser.m9179b(edgesModel.w_(), edgesModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(EdgesModel.class, new Serializer());
                    }
                }

                public EdgesModel() {
                    super(3);
                }

                @Nullable
                private String m9148a() {
                    this.f8201d = super.a(this.f8201d, 0);
                    return this.f8201d;
                }

                @Nullable
                private NodeModel m9149j() {
                    this.f8202e = (NodeModel) super.a(this.f8202e, 1, NodeModel.class);
                    return this.f8202e;
                }

                @Nullable
                private String m9150k() {
                    this.f8203f = super.a(this.f8203f, 2);
                    return this.f8203f;
                }

                public final int jK_() {
                    return -316863363;
                }

                public final GraphQLVisitableModel m9152a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m9149j() != null) {
                        NodeModel nodeModel = (NodeModel) graphQLModelMutatingVisitor.b(m9149j());
                        if (m9149j() != nodeModel) {
                            graphQLVisitableModel = (EdgesModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f8202e = nodeModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m9151a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int b = flatBufferBuilder.b(m9148a());
                    int a = ModelHelper.a(flatBufferBuilder, m9149j());
                    int b2 = flatBufferBuilder.b(m9150k());
                    flatBufferBuilder.c(3);
                    flatBufferBuilder.b(0, b);
                    flatBufferBuilder.b(1, a);
                    flatBufferBuilder.b(2, b2);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: nearby_places_location_id */
            public class Serializer extends JsonSerializer<ResultsModel> {
                public final void m9153a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    ResultsModel resultsModel = (ResultsModel) obj;
                    if (resultsModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(resultsModel.m9156a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        resultsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    VideoSearchResultParser.ResultsParser.m9181a(resultsModel.w_(), resultsModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(ResultsModel.class, new Serializer());
                }
            }

            public ResultsModel() {
                super(2);
            }

            @Nonnull
            private ImmutableList<EdgesModel> m9154a() {
                this.f8204d = super.a(this.f8204d, 0, EdgesModel.class);
                return (ImmutableList) this.f8204d;
            }

            @Nullable
            private DefaultPageInfoFieldsModel m9155j() {
                this.f8205e = (DefaultPageInfoFieldsModel) super.a(this.f8205e, 1, DefaultPageInfoFieldsModel.class);
                return this.f8205e;
            }

            public final int jK_() {
                return 1580207518;
            }

            public final GraphQLVisitableModel m9157a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel;
                DefaultPageInfoFieldsModel defaultPageInfoFieldsModel;
                h();
                if (m9154a() != null) {
                    Builder a = ModelHelper.a(m9154a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        ResultsModel resultsModel = (ResultsModel) ModelHelper.a(null, this);
                        resultsModel.f8204d = a.b();
                        graphQLVisitableModel = resultsModel;
                        if (m9155j() != null) {
                            defaultPageInfoFieldsModel = (DefaultPageInfoFieldsModel) graphQLModelMutatingVisitor.b(m9155j());
                            if (m9155j() != defaultPageInfoFieldsModel) {
                                graphQLVisitableModel = (ResultsModel) ModelHelper.a(graphQLVisitableModel, this);
                                graphQLVisitableModel.f8205e = defaultPageInfoFieldsModel;
                            }
                        }
                        i();
                        return graphQLVisitableModel != null ? this : graphQLVisitableModel;
                    }
                }
                graphQLVisitableModel = null;
                if (m9155j() != null) {
                    defaultPageInfoFieldsModel = (DefaultPageInfoFieldsModel) graphQLModelMutatingVisitor.b(m9155j());
                    if (m9155j() != defaultPageInfoFieldsModel) {
                        graphQLVisitableModel = (ResultsModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f8205e = defaultPageInfoFieldsModel;
                    }
                }
                i();
                if (graphQLVisitableModel != null) {
                }
            }

            public final int m9156a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m9154a());
                int a2 = ModelHelper.a(flatBufferBuilder, m9155j());
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, a2);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: nearby_places_location_id */
        public class Serializer extends JsonSerializer<VideoSearchResultModel> {
            public final void m9158a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                VideoSearchResultModel videoSearchResultModel = (VideoSearchResultModel) obj;
                if (videoSearchResultModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(videoSearchResultModel.m9160a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    videoSearchResultModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = videoSearchResultModel.w_();
                int u_ = videoSearchResultModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("results");
                    VideoSearchResultParser.ResultsParser.m9181a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(VideoSearchResultModel.class, new Serializer());
            }
        }

        public VideoSearchResultModel() {
            super(1);
        }

        @Nullable
        private ResultsModel m9159a() {
            this.f8206d = (ResultsModel) super.a(this.f8206d, 0, ResultsModel.class);
            return this.f8206d;
        }

        public final int jK_() {
            return -466486798;
        }

        public final GraphQLVisitableModel m9161a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m9159a() != null) {
                ResultsModel resultsModel = (ResultsModel) graphQLModelMutatingVisitor.b(m9159a());
                if (m9159a() != resultsModel) {
                    graphQLVisitableModel = (VideoSearchResultModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f8206d = resultsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m9160a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m9159a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }
}
