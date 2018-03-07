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
import com.facebook.graphql.enums.GraphQLGraphSearchResultsDisplayStyle;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.enums.GraphQLSavedState;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.querybuilder.common.CommonGraphQLModels.DefaultImageFieldsModel;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.search.graphql.SearchEntityInterfaces.SearchEntityFragment;
import com.facebook.search.graphql.SearchEntityModels.SearchEntityFragmentModel.GroupIconModel;
import com.facebook.search.protocol.FetchTypeaheadSuggestionsGraphQLParsers.FetchTypeaheadSuggestionsParser;
import com.facebook.search.protocol.FetchTypeaheadSuggestionsGraphQLParsers.SearchSuggestionUnitParser;
import com.facebook.search.protocol.FetchTypeaheadSuggestionsGraphQLParsers.SearchSuggestionUnitParser.QueryTitleParser;
import com.facebook.search.protocol.FetchTypeaheadSuggestionsGraphQLParsers.SearchSuggestionsEdgeFragmentParser;
import com.facebook.search.protocol.FetchTypeaheadSuggestionsGraphQLParsers.SearchSuggestionsEdgeFragmentParser.EdgesParser;
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

/* compiled from: nearby_search */
public class FetchTypeaheadSuggestionsGraphQLModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 517342581)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: nearby_search */
    public final class FetchTypeaheadSuggestionsModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private SearchSuggestionsEdgeFragmentModel f8081d;

        /* compiled from: nearby_search */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FetchTypeaheadSuggestionsModel.class, new Deserializer());
            }

            public Object m8940a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = FetchTypeaheadSuggestionsParser.m8978a(jsonParser);
                Object fetchTypeaheadSuggestionsModel = new FetchTypeaheadSuggestionsModel();
                ((BaseModel) fetchTypeaheadSuggestionsModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (fetchTypeaheadSuggestionsModel instanceof Postprocessable) {
                    return ((Postprocessable) fetchTypeaheadSuggestionsModel).a();
                }
                return fetchTypeaheadSuggestionsModel;
            }
        }

        /* compiled from: nearby_search */
        public class Serializer extends JsonSerializer<FetchTypeaheadSuggestionsModel> {
            public final void m8941a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                FetchTypeaheadSuggestionsModel fetchTypeaheadSuggestionsModel = (FetchTypeaheadSuggestionsModel) obj;
                if (fetchTypeaheadSuggestionsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(fetchTypeaheadSuggestionsModel.m8943a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    fetchTypeaheadSuggestionsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = fetchTypeaheadSuggestionsModel.w_();
                int u_ = fetchTypeaheadSuggestionsModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("suggestions");
                    SearchSuggestionsEdgeFragmentParser.m8986a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(FetchTypeaheadSuggestionsModel.class, new Serializer());
            }
        }

        public FetchTypeaheadSuggestionsModel() {
            super(1);
        }

        @Nullable
        private SearchSuggestionsEdgeFragmentModel m8942a() {
            this.f8081d = (SearchSuggestionsEdgeFragmentModel) super.a(this.f8081d, 0, SearchSuggestionsEdgeFragmentModel.class);
            return this.f8081d;
        }

        public final int jK_() {
            return -1505489194;
        }

        public final GraphQLVisitableModel m8944a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m8942a() != null) {
                SearchSuggestionsEdgeFragmentModel searchSuggestionsEdgeFragmentModel = (SearchSuggestionsEdgeFragmentModel) graphQLModelMutatingVisitor.b(m8942a());
                if (m8942a() != searchSuggestionsEdgeFragmentModel) {
                    graphQLVisitableModel = (FetchTypeaheadSuggestionsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f8081d = searchSuggestionsEdgeFragmentModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m8943a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m8942a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 71141903)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: nearby_search */
    public final class SearchSuggestionUnitModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel, SearchEntityFragment {
        @Nullable
        private GraphQLObjectType f8083d;
        private boolean f8084e;
        @Nullable
        private GroupIconModel f8085f;
        @Nullable
        private DefaultImageFieldsModel f8086g;
        @Nullable
        private String f8087h;
        private boolean f8088i;
        private boolean f8089j;
        @Nullable
        private String f8090k;
        @Nullable
        private DefaultImageFieldsModel f8091l;
        @Nullable
        private QueryTitleModel f8092m;
        @Nullable
        private List<GraphQLGraphSearchResultsDisplayStyle> f8093n;
        @Nullable
        private String f8094o;
        @Nullable
        private GraphQLSavedState f8095p;

        /* compiled from: nearby_search */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(SearchSuggestionUnitModel.class, new Deserializer());
            }

            public Object m8945a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(SearchSuggestionUnitParser.m8981a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object searchSuggestionUnitModel = new SearchSuggestionUnitModel();
                ((BaseModel) searchSuggestionUnitModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (searchSuggestionUnitModel instanceof Postprocessable) {
                    return ((Postprocessable) searchSuggestionUnitModel).a();
                }
                return searchSuggestionUnitModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1352864475)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: nearby_search */
        public final class QueryTitleModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private String f8082d;

            /* compiled from: nearby_search */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(QueryTitleModel.class, new Deserializer());
                }

                public Object m8946a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(QueryTitleParser.m8979a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object queryTitleModel = new QueryTitleModel();
                    ((BaseModel) queryTitleModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (queryTitleModel instanceof Postprocessable) {
                        return ((Postprocessable) queryTitleModel).a();
                    }
                    return queryTitleModel;
                }
            }

            /* compiled from: nearby_search */
            public class Serializer extends JsonSerializer<QueryTitleModel> {
                public final void m8947a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    QueryTitleModel queryTitleModel = (QueryTitleModel) obj;
                    if (queryTitleModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(queryTitleModel.m8949a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        queryTitleModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    QueryTitleParser.m8980a(queryTitleModel.w_(), queryTitleModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(QueryTitleModel.class, new Serializer());
                }
            }

            public QueryTitleModel() {
                super(1);
            }

            @Nullable
            private String m8948a() {
                this.f8082d = super.a(this.f8082d, 0);
                return this.f8082d;
            }

            public final int jK_() {
                return -1696096378;
            }

            public final GraphQLVisitableModel m8950a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m8949a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m8948a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: nearby_search */
        public class Serializer extends JsonSerializer<SearchSuggestionUnitModel> {
            public final void m8951a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                SearchSuggestionUnitModel searchSuggestionUnitModel = (SearchSuggestionUnitModel) obj;
                if (searchSuggestionUnitModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(searchSuggestionUnitModel.m8962a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    searchSuggestionUnitModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                SearchSuggestionUnitParser.m8982a(searchSuggestionUnitModel.w_(), searchSuggestionUnitModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(SearchSuggestionUnitModel.class, new Serializer());
            }
        }

        public SearchSuggestionUnitModel() {
            super(13);
        }

        @Nullable
        private GraphQLObjectType m8952j() {
            if (this.b != null && this.f8083d == null) {
                this.f8083d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
            }
            return this.f8083d;
        }

        @Nullable
        private GroupIconModel m8953k() {
            this.f8085f = (GroupIconModel) super.a(this.f8085f, 2, GroupIconModel.class);
            return this.f8085f;
        }

        @Nullable
        private DefaultImageFieldsModel m8954l() {
            this.f8086g = (DefaultImageFieldsModel) super.a(this.f8086g, 3, DefaultImageFieldsModel.class);
            return this.f8086g;
        }

        @Nullable
        private String m8955m() {
            this.f8087h = super.a(this.f8087h, 4);
            return this.f8087h;
        }

        @Nullable
        private String m8956n() {
            this.f8090k = super.a(this.f8090k, 7);
            return this.f8090k;
        }

        @Nullable
        private DefaultImageFieldsModel m8957o() {
            this.f8091l = (DefaultImageFieldsModel) super.a(this.f8091l, 8, DefaultImageFieldsModel.class);
            return this.f8091l;
        }

        @Nullable
        private QueryTitleModel m8958p() {
            this.f8092m = (QueryTitleModel) super.a(this.f8092m, 9, QueryTitleModel.class);
            return this.f8092m;
        }

        @Nonnull
        private ImmutableList<GraphQLGraphSearchResultsDisplayStyle> m8959q() {
            this.f8093n = super.c(this.f8093n, 10, GraphQLGraphSearchResultsDisplayStyle.class);
            return (ImmutableList) this.f8093n;
        }

        @Nullable
        private String m8960r() {
            this.f8094o = super.a(this.f8094o, 11);
            return this.f8094o;
        }

        @Nullable
        private GraphQLSavedState m8961s() {
            this.f8095p = (GraphQLSavedState) super.b(this.f8095p, 12, GraphQLSavedState.class, GraphQLSavedState.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f8095p;
        }

        @Nullable
        public final String m8964a() {
            return m8955m();
        }

        public final int jK_() {
            return 574543248;
        }

        public final GraphQLVisitableModel m8963a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            DefaultImageFieldsModel defaultImageFieldsModel;
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m8953k() != null) {
                GroupIconModel groupIconModel = (GroupIconModel) graphQLModelMutatingVisitor.b(m8953k());
                if (m8953k() != groupIconModel) {
                    graphQLVisitableModel = (SearchSuggestionUnitModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f8085f = groupIconModel;
                }
            }
            if (m8954l() != null) {
                defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m8954l());
                if (m8954l() != defaultImageFieldsModel) {
                    graphQLVisitableModel = (SearchSuggestionUnitModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f8086g = defaultImageFieldsModel;
                }
            }
            if (m8957o() != null) {
                defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m8957o());
                if (m8957o() != defaultImageFieldsModel) {
                    graphQLVisitableModel = (SearchSuggestionUnitModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f8091l = defaultImageFieldsModel;
                }
            }
            if (m8958p() != null) {
                QueryTitleModel queryTitleModel = (QueryTitleModel) graphQLModelMutatingVisitor.b(m8958p());
                if (m8958p() != queryTitleModel) {
                    graphQLVisitableModel = (SearchSuggestionUnitModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f8092m = queryTitleModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m8962a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m8952j());
            int a2 = ModelHelper.a(flatBufferBuilder, m8953k());
            int a3 = ModelHelper.a(flatBufferBuilder, m8954l());
            int b = flatBufferBuilder.b(m8955m());
            int b2 = flatBufferBuilder.b(m8956n());
            int a4 = ModelHelper.a(flatBufferBuilder, m8957o());
            int a5 = ModelHelper.a(flatBufferBuilder, m8958p());
            int d = flatBufferBuilder.d(m8959q());
            int b3 = flatBufferBuilder.b(m8960r());
            int a6 = flatBufferBuilder.a(m8961s());
            flatBufferBuilder.c(13);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.a(1, this.f8084e);
            flatBufferBuilder.b(2, a2);
            flatBufferBuilder.b(3, a3);
            flatBufferBuilder.b(4, b);
            flatBufferBuilder.a(5, this.f8088i);
            flatBufferBuilder.a(6, this.f8089j);
            flatBufferBuilder.b(7, b2);
            flatBufferBuilder.b(8, a4);
            flatBufferBuilder.b(9, a5);
            flatBufferBuilder.b(10, d);
            flatBufferBuilder.b(11, b3);
            flatBufferBuilder.b(12, a6);
            i();
            return flatBufferBuilder.d();
        }

        public final void m8965a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f8084e = mutableFlatBuffer.a(i, 1);
            this.f8088i = mutableFlatBuffer.a(i, 5);
            this.f8089j = mutableFlatBuffer.a(i, 6);
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1669705891)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: nearby_search */
    public final class SearchSuggestionsEdgeFragmentModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private List<EdgesModel> f8099d;

        /* compiled from: nearby_search */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(SearchSuggestionsEdgeFragmentModel.class, new Deserializer());
            }

            public Object m8966a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(SearchSuggestionsEdgeFragmentParser.m8985a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object searchSuggestionsEdgeFragmentModel = new SearchSuggestionsEdgeFragmentModel();
                ((BaseModel) searchSuggestionsEdgeFragmentModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (searchSuggestionsEdgeFragmentModel instanceof Postprocessable) {
                    return ((Postprocessable) searchSuggestionsEdgeFragmentModel).a();
                }
                return searchSuggestionsEdgeFragmentModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -825591838)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: nearby_search */
        public final class EdgesModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private String f8096d;
            @Nullable
            private SearchSuggestionUnitModel f8097e;
            @Nullable
            private String f8098f;

            /* compiled from: nearby_search */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(EdgesModel.class, new Deserializer());
                }

                public Object m8967a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(EdgesParser.m8983b(jsonParser, flatBufferBuilder));
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

            /* compiled from: nearby_search */
            public class Serializer extends JsonSerializer<EdgesModel> {
                public final void m8968a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    EdgesModel edgesModel = (EdgesModel) obj;
                    if (edgesModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(edgesModel.m8972a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        edgesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    EdgesParser.m8984b(edgesModel.w_(), edgesModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(EdgesModel.class, new Serializer());
                }
            }

            public EdgesModel() {
                super(3);
            }

            @Nullable
            private String m8969a() {
                this.f8096d = super.a(this.f8096d, 0);
                return this.f8096d;
            }

            @Nullable
            private SearchSuggestionUnitModel m8970j() {
                this.f8097e = (SearchSuggestionUnitModel) super.a(this.f8097e, 1, SearchSuggestionUnitModel.class);
                return this.f8097e;
            }

            @Nullable
            private String m8971k() {
                this.f8098f = super.a(this.f8098f, 2);
                return this.f8098f;
            }

            public final int jK_() {
                return 657450596;
            }

            public final GraphQLVisitableModel m8973a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m8970j() != null) {
                    SearchSuggestionUnitModel searchSuggestionUnitModel = (SearchSuggestionUnitModel) graphQLModelMutatingVisitor.b(m8970j());
                    if (m8970j() != searchSuggestionUnitModel) {
                        graphQLVisitableModel = (EdgesModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f8097e = searchSuggestionUnitModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m8972a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m8969a());
                int a = ModelHelper.a(flatBufferBuilder, m8970j());
                int b2 = flatBufferBuilder.b(m8971k());
                flatBufferBuilder.c(3);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.b(1, a);
                flatBufferBuilder.b(2, b2);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: nearby_search */
        public class Serializer extends JsonSerializer<SearchSuggestionsEdgeFragmentModel> {
            public final void m8974a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                SearchSuggestionsEdgeFragmentModel searchSuggestionsEdgeFragmentModel = (SearchSuggestionsEdgeFragmentModel) obj;
                if (searchSuggestionsEdgeFragmentModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(searchSuggestionsEdgeFragmentModel.m8976a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    searchSuggestionsEdgeFragmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                SearchSuggestionsEdgeFragmentParser.m8986a(searchSuggestionsEdgeFragmentModel.w_(), searchSuggestionsEdgeFragmentModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(SearchSuggestionsEdgeFragmentModel.class, new Serializer());
            }
        }

        public SearchSuggestionsEdgeFragmentModel() {
            super(1);
        }

        @Nonnull
        private ImmutableList<EdgesModel> m8975a() {
            this.f8099d = super.a(this.f8099d, 0, EdgesModel.class);
            return (ImmutableList) this.f8099d;
        }

        public final int jK_() {
            return 649829957;
        }

        public final GraphQLVisitableModel m8977a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m8975a() != null) {
                Builder a = ModelHelper.a(m8975a(), graphQLModelMutatingVisitor);
                if (a != null) {
                    graphQLVisitableModel = (SearchSuggestionsEdgeFragmentModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f8099d = a.b();
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m8976a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m8975a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }
}
