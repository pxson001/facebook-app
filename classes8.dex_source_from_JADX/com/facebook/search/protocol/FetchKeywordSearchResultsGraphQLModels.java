package com.facebook.search.protocol;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.feed.protocol.FetchNewsFeedGraphQLModels.DefaultPageInfoFieldsStreamingModel;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithBridge;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLGraphSearchResultRole;
import com.facebook.graphql.enums.GraphQLGraphSearchResultsDisplayStyle;
import com.facebook.graphql.enums.GraphQLGraphSearchSpellerConfidence;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.model.GraphQLNode;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.querybuilder.common.CommonGraphQLInterfaces.DefaultImageFields;
import com.facebook.graphql.querybuilder.common.CommonGraphQLModels.DefaultImageFieldsModel;
import com.facebook.graphql.visitor.ConsistencyTuple;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLInterfaces.ReactionUnitFragment;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLModels.ReactionUnitFragmentModel;
import com.facebook.search.protocol.FetchKeywordSearchResultsGraphQLParsers.KeywordSearchModuleFragmentParser;
import com.facebook.search.protocol.FetchKeywordSearchResultsGraphQLParsers.KeywordSearchModuleFragmentParser.ResultsParser;
import com.facebook.search.protocol.FetchKeywordSearchResultsGraphQLParsers.KeywordSearchModuleFragmentParser.SeeMoreQueryParser;
import com.facebook.search.protocol.FetchKeywordSearchResultsGraphQLParsers.KeywordSearchModuleFragmentParser.SeeMoreQueryParser.QueryTitleParser;
import com.facebook.search.protocol.FetchKeywordSearchResultsGraphQLParsers.KeywordSearchQueryParser;
import com.facebook.search.protocol.FetchKeywordSearchResultsGraphQLParsers.KeywordSearchQueryParser.FilteredQueryParser;
import com.facebook.search.protocol.FetchKeywordSearchResultsGraphQLParsers.KeywordSearchQueryParser.FilteredQueryParser.ModulesParser;
import com.facebook.search.protocol.FetchKeywordSearchResultsGraphQLParsers.KeywordSearchQueryParser.FilteredQueryParser.ModulesParser.CorrectedQueryParser;
import com.facebook.search.protocol.FetchKeywordSearchResultsGraphQLParsers.KeywordSearchQueryParser.FilteredQueryParser.ModulesParser.EdgesParser;
import com.facebook.search.protocol.FetchKeywordSearchResultsGraphQLParsers.KeywordSearchQueryParser.SearchPivotsParser;
import com.facebook.search.protocol.FetchKeywordSearchResultsGraphQLParsers.KeywordSearchQueryParser.SearchPivotsParser.NodesParser;
import com.facebook.search.protocol.FetchKeywordSearchResultsGraphQLParsers.KeywordSearchQueryParser.SearchPivotsParser.NodesParser.UnderlyingEntityParser;
import com.facebook.search.protocol.FetchKeywordSearchResultsGraphQLParsers.KeywordSearchQueryParser.SearchPivotsParser.NodesParser.UnderlyingEntityParser.TrendingTopicDataParser;
import com.facebook.search.protocol.FetchKeywordSearchResultsGraphQLParsers.KeywordSearchResultDecorationParser;
import com.facebook.search.protocol.FetchKeywordSearchResultsGraphQLParsers.KeywordSearchResultDecorationParser.OrderedSnippetsParser;
import com.facebook.search.protocol.FetchKeywordSearchResultsGraphQLParsers.KeywordSearchResultDecorationParser.OrderedSnippetsParser.SentenceParser;
import com.facebook.search.protocol.FetchKeywordSearchResultsGraphQLParsers.ModuleResultEdgeParser;
import com.facebook.search.protocol.FetchKeywordSearchResultsGraphQLParsers.ModuleResultEdgeParser.AboutInformationParser;
import com.facebook.search.results.protocol.filters.SearchResultPageFilterFragmentsModels.SearchResultPageFiltersFragmentModel;
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

/* compiled from: new_password */
public class FetchKeywordSearchResultsGraphQLModels {

    @FragmentModelWithBridge
    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 736272721)
    @JsonSerialize(using = Serializer.class)
    /* compiled from: new_password */
    public final class KeywordSearchModuleFragmentModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private List<GraphQLGraphSearchResultsDisplayStyle> f7949d;
        private int f7950e;
        @Nullable
        private String f7951f;
        private boolean f7952g;
        private int f7953h;
        @Nullable
        private ReactionUnitFragmentModel f7954i;
        @Nullable
        private ResultsModel f7955j;
        @Nullable
        private GraphQLGraphSearchResultRole f7956k;
        @Nullable
        private SeeMoreQueryModel f7957l;
        @Nullable
        private List<String> f7958m;
        @Nullable
        private String f7959n;
        @Nullable
        private String f7960o;

        /* compiled from: new_password */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(KeywordSearchModuleFragmentModel.class, new Deserializer());
            }

            public Object m8510a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(KeywordSearchModuleFragmentParser.m8676a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object keywordSearchModuleFragmentModel = new KeywordSearchModuleFragmentModel();
                ((BaseModel) keywordSearchModuleFragmentModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (keywordSearchModuleFragmentModel instanceof Postprocessable) {
                    return ((Postprocessable) keywordSearchModuleFragmentModel).a();
                }
                return keywordSearchModuleFragmentModel;
            }
        }

        @FragmentModelWithBridge
        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1129594027)
        @JsonSerialize(using = Serializer.class)
        /* compiled from: new_password */
        public final class ResultsModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<ModuleResultEdgeModel> f7944d;

            /* compiled from: new_password */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(ResultsModel.class, new Deserializer());
                }

                public Object m8511a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(ResultsParser.m8670a(jsonParser, flatBufferBuilder));
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

            /* compiled from: new_password */
            public class Serializer extends JsonSerializer<ResultsModel> {
                public final void m8512a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    ResultsModel resultsModel = (ResultsModel) obj;
                    if (resultsModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(resultsModel.m8513a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        resultsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    ResultsParser.m8671a(resultsModel.w_(), resultsModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(ResultsModel.class, new Serializer());
                }
            }

            public ResultsModel() {
                super(1);
            }

            @Nonnull
            public final ImmutableList<ModuleResultEdgeModel> m8515a() {
                this.f7944d = super.a(this.f7944d, 0, ModuleResultEdgeModel.class);
                return (ImmutableList) this.f7944d;
            }

            public final int jK_() {
                return 199404631;
            }

            public final GraphQLVisitableModel m8514a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m8515a() != null) {
                    Builder a = ModelHelper.a(m8515a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (ResultsModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f7944d = a.b();
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m8513a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m8515a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1396625669)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: new_password */
        public final class SeeMoreQueryModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private String f7946d;
            @Nullable
            private QueryTitleModel f7947e;
            @Nullable
            private List<GraphQLGraphSearchResultsDisplayStyle> f7948f;

            /* compiled from: new_password */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(SeeMoreQueryModel.class, new Deserializer());
                }

                public Object m8516a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(SeeMoreQueryParser.m8674a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object seeMoreQueryModel = new SeeMoreQueryModel();
                    ((BaseModel) seeMoreQueryModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (seeMoreQueryModel instanceof Postprocessable) {
                        return ((Postprocessable) seeMoreQueryModel).a();
                    }
                    return seeMoreQueryModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -1352864475)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: new_password */
            public final class QueryTitleModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private String f7945d;

                /* compiled from: new_password */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(QueryTitleModel.class, new Deserializer());
                    }

                    public Object m8517a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(QueryTitleParser.m8672a(jsonParser, flatBufferBuilder));
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

                /* compiled from: new_password */
                public class Serializer extends JsonSerializer<QueryTitleModel> {
                    public final void m8518a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        QueryTitleModel queryTitleModel = (QueryTitleModel) obj;
                        if (queryTitleModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(queryTitleModel.m8519a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            queryTitleModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        QueryTitleParser.m8673a(queryTitleModel.w_(), queryTitleModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(QueryTitleModel.class, new Serializer());
                    }
                }

                public QueryTitleModel() {
                    super(1);
                }

                @Nullable
                public final String m8521a() {
                    this.f7945d = super.a(this.f7945d, 0);
                    return this.f7945d;
                }

                public final int jK_() {
                    return -1696096378;
                }

                public final GraphQLVisitableModel m8520a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m8519a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int b = flatBufferBuilder.b(m8521a());
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, b);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: new_password */
            public class Serializer extends JsonSerializer<SeeMoreQueryModel> {
                public final void m8522a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    SeeMoreQueryModel seeMoreQueryModel = (SeeMoreQueryModel) obj;
                    if (seeMoreQueryModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(seeMoreQueryModel.m8524a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        seeMoreQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    SeeMoreQueryParser.m8675a(seeMoreQueryModel.w_(), seeMoreQueryModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(SeeMoreQueryModel.class, new Serializer());
                }
            }

            @Nullable
            public final /* synthetic */ QueryTitleModel m8527b() {
                return m8523j();
            }

            public SeeMoreQueryModel() {
                super(3);
            }

            @Nullable
            public final String m8526a() {
                this.f7946d = super.a(this.f7946d, 0);
                return this.f7946d;
            }

            @Nullable
            private QueryTitleModel m8523j() {
                this.f7947e = (QueryTitleModel) super.a(this.f7947e, 1, QueryTitleModel.class);
                return this.f7947e;
            }

            @Nonnull
            public final ImmutableList<GraphQLGraphSearchResultsDisplayStyle> m8528c() {
                this.f7948f = super.c(this.f7948f, 2, GraphQLGraphSearchResultsDisplayStyle.class);
                return (ImmutableList) this.f7948f;
            }

            public final int jK_() {
                return -466486798;
            }

            public final GraphQLVisitableModel m8525a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m8523j() != null) {
                    QueryTitleModel queryTitleModel = (QueryTitleModel) graphQLModelMutatingVisitor.b(m8523j());
                    if (m8523j() != queryTitleModel) {
                        graphQLVisitableModel = (SeeMoreQueryModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f7947e = queryTitleModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m8524a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m8526a());
                int a = ModelHelper.a(flatBufferBuilder, m8523j());
                int d = flatBufferBuilder.d(m8528c());
                flatBufferBuilder.c(3);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.b(1, a);
                flatBufferBuilder.b(2, d);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: new_password */
        public class Serializer extends JsonSerializer<KeywordSearchModuleFragmentModel> {
            public final void m8529a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                KeywordSearchModuleFragmentModel keywordSearchModuleFragmentModel = (KeywordSearchModuleFragmentModel) obj;
                if (keywordSearchModuleFragmentModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(keywordSearchModuleFragmentModel.m8534a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    keywordSearchModuleFragmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                KeywordSearchModuleFragmentParser.m8677a(keywordSearchModuleFragmentModel.w_(), keywordSearchModuleFragmentModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(KeywordSearchModuleFragmentModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ ResultsModel m8541g() {
            return m8531m();
        }

        @Nullable
        public final /* synthetic */ SeeMoreQueryModel jy_() {
            return m8532n();
        }

        @Nullable
        public final /* synthetic */ ReactionUnitFragment jz_() {
            return m8530l();
        }

        public KeywordSearchModuleFragmentModel() {
            super(12);
        }

        @Nonnull
        public final ImmutableList<GraphQLGraphSearchResultsDisplayStyle> m8536a() {
            this.f7949d = super.c(this.f7949d, 0, GraphQLGraphSearchResultsDisplayStyle.class);
            return (ImmutableList) this.f7949d;
        }

        public final int m8538b() {
            a(0, 1);
            return this.f7950e;
        }

        @Nullable
        public final String m8539c() {
            this.f7951f = super.a(this.f7951f, 2);
            return this.f7951f;
        }

        public final int m8540d() {
            a(0, 4);
            return this.f7953h;
        }

        @Nullable
        private ReactionUnitFragmentModel m8530l() {
            this.f7954i = (ReactionUnitFragmentModel) super.a(this.f7954i, 5, ReactionUnitFragmentModel.class);
            return this.f7954i;
        }

        @Nullable
        private ResultsModel m8531m() {
            this.f7955j = (ResultsModel) super.a(this.f7955j, 6, ResultsModel.class);
            return this.f7955j;
        }

        @Nullable
        public final GraphQLGraphSearchResultRole jx_() {
            this.f7956k = (GraphQLGraphSearchResultRole) super.b(this.f7956k, 7, GraphQLGraphSearchResultRole.class, GraphQLGraphSearchResultRole.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f7956k;
        }

        @Nullable
        private SeeMoreQueryModel m8532n() {
            this.f7957l = (SeeMoreQueryModel) super.a(this.f7957l, 8, SeeMoreQueryModel.class);
            return this.f7957l;
        }

        @Nonnull
        private ImmutableList<String> m8533o() {
            this.f7958m = super.a(this.f7958m, 9);
            return (ImmutableList) this.f7958m;
        }

        @Nullable
        public final String m8542j() {
            this.f7959n = super.a(this.f7959n, 10);
            return this.f7959n;
        }

        @Nullable
        public final String m8543k() {
            this.f7960o = super.a(this.f7960o, 11);
            return this.f7960o;
        }

        public final int jK_() {
            return -1696273790;
        }

        public final GraphQLVisitableModel m8535a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m8530l() != null) {
                ReactionUnitFragmentModel reactionUnitFragmentModel = (ReactionUnitFragmentModel) graphQLModelMutatingVisitor.b(m8530l());
                if (m8530l() != reactionUnitFragmentModel) {
                    graphQLVisitableModel = (KeywordSearchModuleFragmentModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f7954i = reactionUnitFragmentModel;
                }
            }
            if (m8531m() != null) {
                ResultsModel resultsModel = (ResultsModel) graphQLModelMutatingVisitor.b(m8531m());
                if (m8531m() != resultsModel) {
                    graphQLVisitableModel = (KeywordSearchModuleFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f7955j = resultsModel;
                }
            }
            if (m8532n() != null) {
                SeeMoreQueryModel seeMoreQueryModel = (SeeMoreQueryModel) graphQLModelMutatingVisitor.b(m8532n());
                if (m8532n() != seeMoreQueryModel) {
                    graphQLVisitableModel = (KeywordSearchModuleFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f7957l = seeMoreQueryModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m8534a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int d = flatBufferBuilder.d(m8536a());
            int b = flatBufferBuilder.b(m8539c());
            int a = ModelHelper.a(flatBufferBuilder, m8530l());
            int a2 = ModelHelper.a(flatBufferBuilder, m8531m());
            int a3 = flatBufferBuilder.a(jx_());
            int a4 = ModelHelper.a(flatBufferBuilder, m8532n());
            int c = flatBufferBuilder.c(m8533o());
            int b2 = flatBufferBuilder.b(m8542j());
            int b3 = flatBufferBuilder.b(m8543k());
            flatBufferBuilder.c(12);
            flatBufferBuilder.b(0, d);
            flatBufferBuilder.a(1, this.f7950e, 0);
            flatBufferBuilder.b(2, b);
            flatBufferBuilder.a(3, this.f7952g);
            flatBufferBuilder.a(4, this.f7953h, 0);
            flatBufferBuilder.b(5, a);
            flatBufferBuilder.b(6, a2);
            flatBufferBuilder.b(7, a3);
            flatBufferBuilder.b(8, a4);
            flatBufferBuilder.b(9, c);
            flatBufferBuilder.b(10, b2);
            flatBufferBuilder.b(11, b3);
            i();
            return flatBufferBuilder.d();
        }

        public final void m8537a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f7950e = mutableFlatBuffer.a(i, 1, 0);
            this.f7952g = mutableFlatBuffer.a(i, 3);
            this.f7953h = mutableFlatBuffer.a(i, 4, 0);
        }
    }

    @FragmentModelWithBridge
    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1921648778)
    @JsonSerialize(using = Serializer.class)
    /* compiled from: new_password */
    public final class KeywordSearchQueryModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private FilteredQueryModel f7991d;
        @Nullable
        private SearchPivotsModel f7992e;

        /* compiled from: new_password */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(KeywordSearchQueryModel.class, new Deserializer());
            }

            public Object m8544a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = KeywordSearchQueryParser.m8701a(jsonParser);
                Object keywordSearchQueryModel = new KeywordSearchQueryModel();
                ((BaseModel) keywordSearchQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (keywordSearchQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) keywordSearchQueryModel).a();
                }
                return keywordSearchQueryModel;
            }
        }

        @FragmentModelWithBridge
        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1075284401)
        @JsonSerialize(using = Serializer.class)
        /* compiled from: new_password */
        public final class FilteredQueryModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
            @Nullable
            private List<SearchResultPageFiltersFragmentModel> f7974d;
            @Nullable
            private String f7975e;
            @Nullable
            private ModulesModel f7976f;
            @Nullable
            private String f7977g;
            @Nullable
            private String f7978h;
            @Nullable
            private QueryTitleModel f7979i;

            /* compiled from: new_password */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(FilteredQueryModel.class, new Deserializer());
                }

                public Object m8545a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(FilteredQueryParser.m8689a(jsonParser, flatBufferBuilder));
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

            @FragmentModelWithBridge
            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -1884306343)
            @JsonSerialize(using = Serializer.class)
            /* compiled from: new_password */
            public final class ModulesModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private CorrectedQueryModel f7965d;
                private int f7966e;
                private boolean f7967f;
                @Nullable
                private List<EdgesModel> f7968g;
                @Nullable
                private DefaultPageInfoFieldsStreamingModel f7969h;
                @Nullable
                private String f7970i;
                @Nullable
                private GraphQLGraphSearchSpellerConfidence f7971j;
                @Nullable
                private String f7972k;

                @JsonDeserialize(using = Deserializer.class)
                @ModelWithFlatBufferFormatHash(a = 1671640533)
                @JsonSerialize(using = Serializer.class)
                @FragmentModelWithoutBridge
                /* compiled from: new_password */
                public final class CorrectedQueryModel extends BaseModel implements GraphQLVisitableModel {
                    @Nullable
                    private String f7962d;
                    @Nullable
                    private QueryTitleModel f7963e;

                    /* compiled from: new_password */
                    public class Deserializer extends FbJsonDeserializer {
                        static {
                            GlobalAutoGenDeserializerCache.a(CorrectedQueryModel.class, new Deserializer());
                        }

                        public Object m8546a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(CorrectedQueryParser.m8680a(jsonParser, flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            mutableFlatBuffer.a(4, Boolean.valueOf(true));
                            MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                            Object correctedQueryModel = new CorrectedQueryModel();
                            ((BaseModel) correctedQueryModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                            if (correctedQueryModel instanceof Postprocessable) {
                                return ((Postprocessable) correctedQueryModel).a();
                            }
                            return correctedQueryModel;
                        }
                    }

                    @JsonDeserialize(using = Deserializer.class)
                    @ModelWithFlatBufferFormatHash(a = -1352864475)
                    @JsonSerialize(using = Serializer.class)
                    @FragmentModelWithoutBridge
                    /* compiled from: new_password */
                    public final class QueryTitleModel extends BaseModel implements GraphQLVisitableModel {
                        @Nullable
                        private String f7961d;

                        /* compiled from: new_password */
                        public class Deserializer extends FbJsonDeserializer {
                            static {
                                GlobalAutoGenDeserializerCache.a(QueryTitleModel.class, new Deserializer());
                            }

                            public Object m8547a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(CorrectedQueryParser.QueryTitleParser.m8678a(jsonParser, flatBufferBuilder));
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

                        /* compiled from: new_password */
                        public class Serializer extends JsonSerializer<QueryTitleModel> {
                            public final void m8548a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                                QueryTitleModel queryTitleModel = (QueryTitleModel) obj;
                                if (queryTitleModel.w_() == null) {
                                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                    flatBufferBuilder.d(queryTitleModel.m8549a(flatBufferBuilder));
                                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                    wrap.position(0);
                                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                    queryTitleModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                                }
                                CorrectedQueryParser.QueryTitleParser.m8679a(queryTitleModel.w_(), queryTitleModel.u_(), jsonGenerator);
                            }

                            static {
                                FbSerializerProvider.a(QueryTitleModel.class, new Serializer());
                            }
                        }

                        public QueryTitleModel() {
                            super(1);
                        }

                        @Nullable
                        public final String m8551a() {
                            this.f7961d = super.a(this.f7961d, 0);
                            return this.f7961d;
                        }

                        public final int jK_() {
                            return -1696096378;
                        }

                        public final GraphQLVisitableModel m8550a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                            h();
                            i();
                            return this;
                        }

                        public final int m8549a(FlatBufferBuilder flatBufferBuilder) {
                            h();
                            int b = flatBufferBuilder.b(m8551a());
                            flatBufferBuilder.c(1);
                            flatBufferBuilder.b(0, b);
                            i();
                            return flatBufferBuilder.d();
                        }
                    }

                    /* compiled from: new_password */
                    public class Serializer extends JsonSerializer<CorrectedQueryModel> {
                        public final void m8552a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            CorrectedQueryModel correctedQueryModel = (CorrectedQueryModel) obj;
                            if (correctedQueryModel.w_() == null) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(correctedQueryModel.m8554a(flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                correctedQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                            }
                            CorrectedQueryParser.m8681a(correctedQueryModel.w_(), correctedQueryModel.u_(), jsonGenerator, serializerProvider);
                        }

                        static {
                            FbSerializerProvider.a(CorrectedQueryModel.class, new Serializer());
                        }
                    }

                    @Nullable
                    public final /* synthetic */ QueryTitleModel m8557b() {
                        return m8553j();
                    }

                    public CorrectedQueryModel() {
                        super(2);
                    }

                    @Nullable
                    public final String m8556a() {
                        this.f7962d = super.a(this.f7962d, 0);
                        return this.f7962d;
                    }

                    @Nullable
                    private QueryTitleModel m8553j() {
                        this.f7963e = (QueryTitleModel) super.a(this.f7963e, 1, QueryTitleModel.class);
                        return this.f7963e;
                    }

                    public final int jK_() {
                        return -466486798;
                    }

                    public final GraphQLVisitableModel m8555a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                        GraphQLVisitableModel graphQLVisitableModel = null;
                        h();
                        if (m8553j() != null) {
                            QueryTitleModel queryTitleModel = (QueryTitleModel) graphQLModelMutatingVisitor.b(m8553j());
                            if (m8553j() != queryTitleModel) {
                                graphQLVisitableModel = (CorrectedQueryModel) ModelHelper.a(null, this);
                                graphQLVisitableModel.f7963e = queryTitleModel;
                            }
                        }
                        i();
                        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                    }

                    public final int m8554a(FlatBufferBuilder flatBufferBuilder) {
                        h();
                        int b = flatBufferBuilder.b(m8556a());
                        int a = ModelHelper.a(flatBufferBuilder, m8553j());
                        flatBufferBuilder.c(2);
                        flatBufferBuilder.b(0, b);
                        flatBufferBuilder.b(1, a);
                        i();
                        return flatBufferBuilder.d();
                    }
                }

                /* compiled from: new_password */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(ModulesModel.class, new Deserializer());
                    }

                    public Object m8558a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(ModulesParser.m8685a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object modulesModel = new ModulesModel();
                        ((BaseModel) modulesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (modulesModel instanceof Postprocessable) {
                            return ((Postprocessable) modulesModel).a();
                        }
                        return modulesModel;
                    }
                }

                @FragmentModelWithBridge
                @JsonDeserialize(using = Deserializer.class)
                @ModelWithFlatBufferFormatHash(a = 448987674)
                @JsonSerialize(using = Serializer.class)
                /* compiled from: new_password */
                public final class EdgesModel extends BaseModel implements GraphQLVisitableModel {
                    @Nullable
                    private KeywordSearchModuleFragmentModel f7964d;

                    /* compiled from: new_password */
                    public class Deserializer extends FbJsonDeserializer {
                        static {
                            GlobalAutoGenDeserializerCache.a(EdgesModel.class, new Deserializer());
                        }

                        public Object m8559a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(EdgesParser.m8683b(jsonParser, flatBufferBuilder));
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

                    /* compiled from: new_password */
                    public class Serializer extends JsonSerializer<EdgesModel> {
                        public final void m8560a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            EdgesModel edgesModel = (EdgesModel) obj;
                            if (edgesModel.w_() == null) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(edgesModel.m8562a(flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                edgesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                            }
                            EdgesParser.m8684b(edgesModel.w_(), edgesModel.u_(), jsonGenerator, serializerProvider);
                        }

                        static {
                            FbSerializerProvider.a(EdgesModel.class, new Serializer());
                        }
                    }

                    @Nullable
                    public final /* synthetic */ KeywordSearchModuleFragmentModel m8564a() {
                        return m8561j();
                    }

                    public EdgesModel() {
                        super(1);
                    }

                    @Nullable
                    private KeywordSearchModuleFragmentModel m8561j() {
                        this.f7964d = (KeywordSearchModuleFragmentModel) super.a(this.f7964d, 0, KeywordSearchModuleFragmentModel.class);
                        return this.f7964d;
                    }

                    public final int jK_() {
                        return -974600306;
                    }

                    public final GraphQLVisitableModel m8563a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                        GraphQLVisitableModel graphQLVisitableModel = null;
                        h();
                        if (m8561j() != null) {
                            KeywordSearchModuleFragmentModel keywordSearchModuleFragmentModel = (KeywordSearchModuleFragmentModel) graphQLModelMutatingVisitor.b(m8561j());
                            if (m8561j() != keywordSearchModuleFragmentModel) {
                                graphQLVisitableModel = (EdgesModel) ModelHelper.a(null, this);
                                graphQLVisitableModel.f7964d = keywordSearchModuleFragmentModel;
                            }
                        }
                        i();
                        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                    }

                    public final int m8562a(FlatBufferBuilder flatBufferBuilder) {
                        h();
                        int a = ModelHelper.a(flatBufferBuilder, m8561j());
                        flatBufferBuilder.c(1);
                        flatBufferBuilder.b(0, a);
                        i();
                        return flatBufferBuilder.d();
                    }
                }

                /* compiled from: new_password */
                public class Serializer extends JsonSerializer<ModulesModel> {
                    public final void m8565a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        ModulesModel modulesModel = (ModulesModel) obj;
                        if (modulesModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(modulesModel.m8568a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            modulesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        ModulesParser.m8686a(modulesModel.w_(), modulesModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(ModulesModel.class, new Serializer());
                    }
                }

                @Nullable
                public final /* synthetic */ CorrectedQueryModel m8570a() {
                    return m8566j();
                }

                @Nullable
                public final /* synthetic */ DefaultPageInfoFieldsStreamingModel m8574d() {
                    return m8567k();
                }

                public ModulesModel() {
                    super(8);
                }

                @Nullable
                private CorrectedQueryModel m8566j() {
                    this.f7965d = (CorrectedQueryModel) super.a(this.f7965d, 0, CorrectedQueryModel.class);
                    return this.f7965d;
                }

                public final boolean m8572b() {
                    a(0, 2);
                    return this.f7967f;
                }

                @Nonnull
                public final ImmutableList<EdgesModel> m8573c() {
                    this.f7968g = super.a(this.f7968g, 3, EdgesModel.class);
                    return (ImmutableList) this.f7968g;
                }

                @Nullable
                private DefaultPageInfoFieldsStreamingModel m8567k() {
                    this.f7969h = (DefaultPageInfoFieldsStreamingModel) super.a(this.f7969h, 4, DefaultPageInfoFieldsStreamingModel.class);
                    return this.f7969h;
                }

                @Nullable
                public final String jB_() {
                    this.f7970i = super.a(this.f7970i, 5);
                    return this.f7970i;
                }

                @Nullable
                public final GraphQLGraphSearchSpellerConfidence m8575g() {
                    this.f7971j = (GraphQLGraphSearchSpellerConfidence) super.b(this.f7971j, 6, GraphQLGraphSearchSpellerConfidence.class, GraphQLGraphSearchSpellerConfidence.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                    return this.f7971j;
                }

                @Nullable
                public final String jC_() {
                    this.f7972k = super.a(this.f7972k, 7);
                    return this.f7972k;
                }

                public final int jK_() {
                    return -481462289;
                }

                public final GraphQLVisitableModel m8569a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m8566j() != null) {
                        CorrectedQueryModel correctedQueryModel = (CorrectedQueryModel) graphQLModelMutatingVisitor.b(m8566j());
                        if (m8566j() != correctedQueryModel) {
                            graphQLVisitableModel = (ModulesModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f7965d = correctedQueryModel;
                        }
                    }
                    if (m8573c() != null) {
                        Builder a = ModelHelper.a(m8573c(), graphQLModelMutatingVisitor);
                        if (a != null) {
                            ModulesModel modulesModel = (ModulesModel) ModelHelper.a(graphQLVisitableModel, this);
                            modulesModel.f7968g = a.b();
                            graphQLVisitableModel = modulesModel;
                        }
                    }
                    if (m8567k() != null) {
                        DefaultPageInfoFieldsStreamingModel defaultPageInfoFieldsStreamingModel = (DefaultPageInfoFieldsStreamingModel) graphQLModelMutatingVisitor.b(m8567k());
                        if (m8567k() != defaultPageInfoFieldsStreamingModel) {
                            graphQLVisitableModel = (ModulesModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f7969h = defaultPageInfoFieldsStreamingModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m8568a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m8566j());
                    int a2 = ModelHelper.a(flatBufferBuilder, m8573c());
                    int a3 = ModelHelper.a(flatBufferBuilder, m8567k());
                    int b = flatBufferBuilder.b(jB_());
                    int a4 = flatBufferBuilder.a(m8575g());
                    int b2 = flatBufferBuilder.b(jC_());
                    flatBufferBuilder.c(8);
                    flatBufferBuilder.b(0, a);
                    flatBufferBuilder.a(1, this.f7966e, 0);
                    flatBufferBuilder.a(2, this.f7967f);
                    flatBufferBuilder.b(3, a2);
                    flatBufferBuilder.b(4, a3);
                    flatBufferBuilder.b(5, b);
                    flatBufferBuilder.b(6, a4);
                    flatBufferBuilder.b(7, b2);
                    i();
                    return flatBufferBuilder.d();
                }

                public final void m8571a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                    super.a(mutableFlatBuffer, i, obj);
                    this.f7966e = mutableFlatBuffer.a(i, 1, 0);
                    this.f7967f = mutableFlatBuffer.a(i, 2);
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -1352864475)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: new_password */
            public final class QueryTitleModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private String f7973d;

                /* compiled from: new_password */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(QueryTitleModel.class, new Deserializer());
                    }

                    public Object m8576a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(FilteredQueryParser.QueryTitleParser.m8687a(jsonParser, flatBufferBuilder));
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

                /* compiled from: new_password */
                public class Serializer extends JsonSerializer<QueryTitleModel> {
                    public final void m8577a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        QueryTitleModel queryTitleModel = (QueryTitleModel) obj;
                        if (queryTitleModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(queryTitleModel.m8578a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            queryTitleModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        FilteredQueryParser.QueryTitleParser.m8688a(queryTitleModel.w_(), queryTitleModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(QueryTitleModel.class, new Serializer());
                    }
                }

                public QueryTitleModel() {
                    super(1);
                }

                @Nullable
                public final String m8580a() {
                    this.f7973d = super.a(this.f7973d, 0);
                    return this.f7973d;
                }

                public final int jK_() {
                    return -1696096378;
                }

                public final GraphQLVisitableModel m8579a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m8578a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int b = flatBufferBuilder.b(m8580a());
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, b);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: new_password */
            public class Serializer extends JsonSerializer<FilteredQueryModel> {
                public final void m8581a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    FilteredQueryModel filteredQueryModel = (FilteredQueryModel) obj;
                    if (filteredQueryModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(filteredQueryModel.m8585a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        filteredQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    FilteredQueryParser.m8690a(filteredQueryModel.w_(), filteredQueryModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(FilteredQueryModel.class, new Serializer());
                }
            }

            @Nullable
            public final /* synthetic */ ModulesModel m8589c() {
                return m8583k();
            }

            @Nullable
            public final /* synthetic */ QueryTitleModel m8591g() {
                return m8584l();
            }

            public FilteredQueryModel() {
                super(6);
            }

            @Nonnull
            public final ImmutableList<SearchResultPageFiltersFragmentModel> m8588b() {
                this.f7974d = super.a(this.f7974d, 0, SearchResultPageFiltersFragmentModel.class);
                return (ImmutableList) this.f7974d;
            }

            @Nullable
            private String m8582j() {
                this.f7975e = super.a(this.f7975e, 1);
                return this.f7975e;
            }

            @Nullable
            private ModulesModel m8583k() {
                this.f7976f = (ModulesModel) super.a(this.f7976f, 2, ModulesModel.class);
                return this.f7976f;
            }

            @Nullable
            public final String m8590d() {
                this.f7977g = super.a(this.f7977g, 3);
                return this.f7977g;
            }

            @Nullable
            public final String jA_() {
                this.f7978h = super.a(this.f7978h, 4);
                return this.f7978h;
            }

            @Nullable
            private QueryTitleModel m8584l() {
                this.f7979i = (QueryTitleModel) super.a(this.f7979i, 5, QueryTitleModel.class);
                return this.f7979i;
            }

            @Nullable
            public final String m8587a() {
                return m8582j();
            }

            public final int jK_() {
                return -466486798;
            }

            public final GraphQLVisitableModel m8586a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel;
                ModulesModel modulesModel;
                QueryTitleModel queryTitleModel;
                h();
                if (m8588b() != null) {
                    Builder a = ModelHelper.a(m8588b(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        FilteredQueryModel filteredQueryModel = (FilteredQueryModel) ModelHelper.a(null, this);
                        filteredQueryModel.f7974d = a.b();
                        graphQLVisitableModel = filteredQueryModel;
                        if (m8583k() != null) {
                            modulesModel = (ModulesModel) graphQLModelMutatingVisitor.b(m8583k());
                            if (m8583k() != modulesModel) {
                                graphQLVisitableModel = (FilteredQueryModel) ModelHelper.a(graphQLVisitableModel, this);
                                graphQLVisitableModel.f7976f = modulesModel;
                            }
                        }
                        if (m8584l() != null) {
                            queryTitleModel = (QueryTitleModel) graphQLModelMutatingVisitor.b(m8584l());
                            if (m8584l() != queryTitleModel) {
                                graphQLVisitableModel = (FilteredQueryModel) ModelHelper.a(graphQLVisitableModel, this);
                                graphQLVisitableModel.f7979i = queryTitleModel;
                            }
                        }
                        i();
                        return graphQLVisitableModel != null ? this : graphQLVisitableModel;
                    }
                }
                graphQLVisitableModel = null;
                if (m8583k() != null) {
                    modulesModel = (ModulesModel) graphQLModelMutatingVisitor.b(m8583k());
                    if (m8583k() != modulesModel) {
                        graphQLVisitableModel = (FilteredQueryModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f7976f = modulesModel;
                    }
                }
                if (m8584l() != null) {
                    queryTitleModel = (QueryTitleModel) graphQLModelMutatingVisitor.b(m8584l());
                    if (m8584l() != queryTitleModel) {
                        graphQLVisitableModel = (FilteredQueryModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f7979i = queryTitleModel;
                    }
                }
                i();
                if (graphQLVisitableModel != null) {
                }
            }

            public final int m8585a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m8588b());
                int b = flatBufferBuilder.b(m8582j());
                int a2 = ModelHelper.a(flatBufferBuilder, m8583k());
                int b2 = flatBufferBuilder.b(m8590d());
                int b3 = flatBufferBuilder.b(jA_());
                int a3 = ModelHelper.a(flatBufferBuilder, m8584l());
                flatBufferBuilder.c(6);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, b);
                flatBufferBuilder.b(2, a2);
                flatBufferBuilder.b(3, b2);
                flatBufferBuilder.b(4, b3);
                flatBufferBuilder.b(5, a3);
                i();
                return flatBufferBuilder.d();
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1527920807)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: new_password */
        public final class SearchPivotsModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<NodesModel> f7990d;

            /* compiled from: new_password */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(SearchPivotsModel.class, new Deserializer());
                }

                public Object m8592a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(SearchPivotsParser.m8699a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object searchPivotsModel = new SearchPivotsModel();
                    ((BaseModel) searchPivotsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (searchPivotsModel instanceof Postprocessable) {
                        return ((Postprocessable) searchPivotsModel).a();
                    }
                    return searchPivotsModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 1826590153)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: new_password */
            public final class NodesModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private String f7987d;
                @Nullable
                private QueryTitleModel f7988e;
                @Nullable
                private UnderlyingEntityModel f7989f;

                /* compiled from: new_password */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(NodesModel.class, new Deserializer());
                    }

                    public Object m8593a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(NodesParser.m8697b(jsonParser, flatBufferBuilder));
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

                @JsonDeserialize(using = Deserializer.class)
                @ModelWithFlatBufferFormatHash(a = -1352864475)
                @JsonSerialize(using = Serializer.class)
                @FragmentModelWithoutBridge
                /* compiled from: new_password */
                public final class QueryTitleModel extends BaseModel implements GraphQLVisitableModel {
                    @Nullable
                    private String f7980d;

                    /* compiled from: new_password */
                    public class Deserializer extends FbJsonDeserializer {
                        static {
                            GlobalAutoGenDeserializerCache.a(QueryTitleModel.class, new Deserializer());
                        }

                        public Object m8594a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(NodesParser.QueryTitleParser.m8691a(jsonParser, flatBufferBuilder));
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

                    /* compiled from: new_password */
                    public class Serializer extends JsonSerializer<QueryTitleModel> {
                        public final void m8595a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            QueryTitleModel queryTitleModel = (QueryTitleModel) obj;
                            if (queryTitleModel.w_() == null) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(queryTitleModel.m8596a(flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                queryTitleModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                            }
                            NodesParser.QueryTitleParser.m8692a(queryTitleModel.w_(), queryTitleModel.u_(), jsonGenerator);
                        }

                        static {
                            FbSerializerProvider.a(QueryTitleModel.class, new Serializer());
                        }
                    }

                    public QueryTitleModel() {
                        super(1);
                    }

                    @Nullable
                    public final String m8598a() {
                        this.f7980d = super.a(this.f7980d, 0);
                        return this.f7980d;
                    }

                    public final int jK_() {
                        return -1696096378;
                    }

                    public final GraphQLVisitableModel m8597a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                        h();
                        i();
                        return this;
                    }

                    public final int m8596a(FlatBufferBuilder flatBufferBuilder) {
                        h();
                        int b = flatBufferBuilder.b(m8598a());
                        flatBufferBuilder.c(1);
                        flatBufferBuilder.b(0, b);
                        i();
                        return flatBufferBuilder.d();
                    }
                }

                /* compiled from: new_password */
                public class Serializer extends JsonSerializer<NodesModel> {
                    public final void m8599a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        NodesModel nodesModel = (NodesModel) obj;
                        if (nodesModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(nodesModel.m8621a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            nodesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        NodesParser.m8698b(nodesModel.w_(), nodesModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(NodesModel.class, new Serializer());
                    }
                }

                @JsonDeserialize(using = Deserializer.class)
                @ModelWithFlatBufferFormatHash(a = 304566999)
                @JsonSerialize(using = Serializer.class)
                @FragmentModelWithoutBridge
                /* compiled from: new_password */
                public final class UnderlyingEntityModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
                    @Nullable
                    private GraphQLObjectType f7982d;
                    @Nullable
                    private String f7983e;
                    @Nullable
                    private DefaultImageFieldsModel f7984f;
                    @Nullable
                    private TrendingTopicDataModel f7985g;
                    @Nullable
                    private String f7986h;

                    /* compiled from: new_password */
                    public class Deserializer extends FbJsonDeserializer {
                        static {
                            GlobalAutoGenDeserializerCache.a(UnderlyingEntityModel.class, new Deserializer());
                        }

                        public Object m8600a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(UnderlyingEntityParser.m8695a(jsonParser, flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            mutableFlatBuffer.a(4, Boolean.valueOf(true));
                            MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                            Object underlyingEntityModel = new UnderlyingEntityModel();
                            ((BaseModel) underlyingEntityModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                            if (underlyingEntityModel instanceof Postprocessable) {
                                return ((Postprocessable) underlyingEntityModel).a();
                            }
                            return underlyingEntityModel;
                        }
                    }

                    /* compiled from: new_password */
                    public class Serializer extends JsonSerializer<UnderlyingEntityModel> {
                        public final void m8601a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            UnderlyingEntityModel underlyingEntityModel = (UnderlyingEntityModel) obj;
                            if (underlyingEntityModel.w_() == null) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(underlyingEntityModel.m8611a(flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                underlyingEntityModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                            }
                            UnderlyingEntityParser.m8696a(underlyingEntityModel.w_(), underlyingEntityModel.u_(), jsonGenerator, serializerProvider);
                        }

                        static {
                            FbSerializerProvider.a(UnderlyingEntityModel.class, new Serializer());
                        }
                    }

                    @JsonDeserialize(using = Deserializer.class)
                    @ModelWithFlatBufferFormatHash(a = 304570036)
                    @JsonSerialize(using = Serializer.class)
                    @FragmentModelWithoutBridge
                    /* compiled from: new_password */
                    public final class TrendingTopicDataModel extends BaseModel implements GraphQLVisitableModel {
                        @Nullable
                        private String f7981d;

                        /* compiled from: new_password */
                        public class Deserializer extends FbJsonDeserializer {
                            static {
                                GlobalAutoGenDeserializerCache.a(TrendingTopicDataModel.class, new Deserializer());
                            }

                            public Object m8602a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(TrendingTopicDataParser.m8693a(jsonParser, flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                                Object trendingTopicDataModel = new TrendingTopicDataModel();
                                ((BaseModel) trendingTopicDataModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                                if (trendingTopicDataModel instanceof Postprocessable) {
                                    return ((Postprocessable) trendingTopicDataModel).a();
                                }
                                return trendingTopicDataModel;
                            }
                        }

                        /* compiled from: new_password */
                        public class Serializer extends JsonSerializer<TrendingTopicDataModel> {
                            public final void m8603a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                                TrendingTopicDataModel trendingTopicDataModel = (TrendingTopicDataModel) obj;
                                if (trendingTopicDataModel.w_() == null) {
                                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                    flatBufferBuilder.d(trendingTopicDataModel.m8604a(flatBufferBuilder));
                                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                    wrap.position(0);
                                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                    trendingTopicDataModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                                }
                                TrendingTopicDataParser.m8694a(trendingTopicDataModel.w_(), trendingTopicDataModel.u_(), jsonGenerator);
                            }

                            static {
                                FbSerializerProvider.a(TrendingTopicDataModel.class, new Serializer());
                            }
                        }

                        public TrendingTopicDataModel() {
                            super(1);
                        }

                        @Nullable
                        public final String m8606a() {
                            this.f7981d = super.a(this.f7981d, 0);
                            return this.f7981d;
                        }

                        public final int jK_() {
                            return -1862466124;
                        }

                        public final GraphQLVisitableModel m8605a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                            h();
                            i();
                            return this;
                        }

                        public final int m8604a(FlatBufferBuilder flatBufferBuilder) {
                            h();
                            int b = flatBufferBuilder.b(m8606a());
                            flatBufferBuilder.c(1);
                            flatBufferBuilder.b(0, b);
                            i();
                            return flatBufferBuilder.d();
                        }
                    }

                    @Nullable
                    public final /* synthetic */ DefaultImageFields m8616b() {
                        return m8609l();
                    }

                    @Nullable
                    public final /* synthetic */ TrendingTopicDataModel m8617c() {
                        return m8610m();
                    }

                    public UnderlyingEntityModel() {
                        super(5);
                    }

                    public final void m8614a(String str, ConsistencyTuple consistencyTuple) {
                        consistencyTuple.a();
                    }

                    public final void m8615a(String str, Object obj, boolean z) {
                    }

                    @Nullable
                    private GraphQLObjectType m8607j() {
                        if (this.b != null && this.f7982d == null) {
                            this.f7982d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                        }
                        return this.f7982d;
                    }

                    @Nullable
                    private String m8608k() {
                        this.f7983e = super.a(this.f7983e, 1);
                        return this.f7983e;
                    }

                    @Nullable
                    private DefaultImageFieldsModel m8609l() {
                        this.f7984f = (DefaultImageFieldsModel) super.a(this.f7984f, 2, DefaultImageFieldsModel.class);
                        return this.f7984f;
                    }

                    @Nullable
                    private TrendingTopicDataModel m8610m() {
                        this.f7985g = (TrendingTopicDataModel) super.a(this.f7985g, 3, TrendingTopicDataModel.class);
                        return this.f7985g;
                    }

                    @Nullable
                    public final String m8618d() {
                        this.f7986h = super.a(this.f7986h, 4);
                        return this.f7986h;
                    }

                    @Nullable
                    public final String m8613a() {
                        return m8608k();
                    }

                    public final int jK_() {
                        return 1355227529;
                    }

                    public final GraphQLVisitableModel m8612a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                        GraphQLVisitableModel graphQLVisitableModel = null;
                        h();
                        if (m8609l() != null) {
                            DefaultImageFieldsModel defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m8609l());
                            if (m8609l() != defaultImageFieldsModel) {
                                graphQLVisitableModel = (UnderlyingEntityModel) ModelHelper.a(null, this);
                                graphQLVisitableModel.f7984f = defaultImageFieldsModel;
                            }
                        }
                        if (m8610m() != null) {
                            TrendingTopicDataModel trendingTopicDataModel = (TrendingTopicDataModel) graphQLModelMutatingVisitor.b(m8610m());
                            if (m8610m() != trendingTopicDataModel) {
                                graphQLVisitableModel = (UnderlyingEntityModel) ModelHelper.a(graphQLVisitableModel, this);
                                graphQLVisitableModel.f7985g = trendingTopicDataModel;
                            }
                        }
                        i();
                        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                    }

                    public final int m8611a(FlatBufferBuilder flatBufferBuilder) {
                        h();
                        int a = ModelHelper.a(flatBufferBuilder, m8607j());
                        int b = flatBufferBuilder.b(m8608k());
                        int a2 = ModelHelper.a(flatBufferBuilder, m8609l());
                        int a3 = ModelHelper.a(flatBufferBuilder, m8610m());
                        int b2 = flatBufferBuilder.b(m8618d());
                        flatBufferBuilder.c(5);
                        flatBufferBuilder.b(0, a);
                        flatBufferBuilder.b(1, b);
                        flatBufferBuilder.b(2, a2);
                        flatBufferBuilder.b(3, a3);
                        flatBufferBuilder.b(4, b2);
                        i();
                        return flatBufferBuilder.d();
                    }
                }

                @Nullable
                public final /* synthetic */ QueryTitleModel m8624b() {
                    return m8619j();
                }

                @Nullable
                public final /* synthetic */ UnderlyingEntityModel m8625c() {
                    return m8620k();
                }

                public NodesModel() {
                    super(3);
                }

                @Nullable
                public final String m8623a() {
                    this.f7987d = super.a(this.f7987d, 0);
                    return this.f7987d;
                }

                @Nullable
                private QueryTitleModel m8619j() {
                    this.f7988e = (QueryTitleModel) super.a(this.f7988e, 1, QueryTitleModel.class);
                    return this.f7988e;
                }

                @Nullable
                private UnderlyingEntityModel m8620k() {
                    this.f7989f = (UnderlyingEntityModel) super.a(this.f7989f, 2, UnderlyingEntityModel.class);
                    return this.f7989f;
                }

                public final int jK_() {
                    return -466486798;
                }

                public final GraphQLVisitableModel m8622a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m8619j() != null) {
                        QueryTitleModel queryTitleModel = (QueryTitleModel) graphQLModelMutatingVisitor.b(m8619j());
                        if (m8619j() != queryTitleModel) {
                            graphQLVisitableModel = (NodesModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f7988e = queryTitleModel;
                        }
                    }
                    if (m8620k() != null) {
                        UnderlyingEntityModel underlyingEntityModel = (UnderlyingEntityModel) graphQLModelMutatingVisitor.b(m8620k());
                        if (m8620k() != underlyingEntityModel) {
                            graphQLVisitableModel = (NodesModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f7989f = underlyingEntityModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m8621a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int b = flatBufferBuilder.b(m8623a());
                    int a = ModelHelper.a(flatBufferBuilder, m8619j());
                    int a2 = ModelHelper.a(flatBufferBuilder, m8620k());
                    flatBufferBuilder.c(3);
                    flatBufferBuilder.b(0, b);
                    flatBufferBuilder.b(1, a);
                    flatBufferBuilder.b(2, a2);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: new_password */
            public class Serializer extends JsonSerializer<SearchPivotsModel> {
                public final void m8626a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    SearchPivotsModel searchPivotsModel = (SearchPivotsModel) obj;
                    if (searchPivotsModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(searchPivotsModel.m8627a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        searchPivotsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    SearchPivotsParser.m8700a(searchPivotsModel.w_(), searchPivotsModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(SearchPivotsModel.class, new Serializer());
                }
            }

            public SearchPivotsModel() {
                super(1);
            }

            @Nonnull
            public final ImmutableList<NodesModel> m8629a() {
                this.f7990d = super.a(this.f7990d, 0, NodesModel.class);
                return (ImmutableList) this.f7990d;
            }

            public final int jK_() {
                return 1086522391;
            }

            public final GraphQLVisitableModel m8628a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m8629a() != null) {
                    Builder a = ModelHelper.a(m8629a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (SearchPivotsModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f7990d = a.b();
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m8627a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m8629a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: new_password */
        public class Serializer extends JsonSerializer<KeywordSearchQueryModel> {
            public final void m8630a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                KeywordSearchQueryModel keywordSearchQueryModel = (KeywordSearchQueryModel) obj;
                if (keywordSearchQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(keywordSearchQueryModel.m8633a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    keywordSearchQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = keywordSearchQueryModel.w_();
                int u_ = keywordSearchQueryModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("filtered_query");
                    FilteredQueryParser.m8690a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(u_, 1);
                if (g != 0) {
                    jsonGenerator.a("search_pivots");
                    SearchPivotsParser.m8700a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(KeywordSearchQueryModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ FilteredQueryModel m8635a() {
            return m8631j();
        }

        @Nullable
        public final /* synthetic */ SearchPivotsModel m8636b() {
            return m8632k();
        }

        public KeywordSearchQueryModel() {
            super(2);
        }

        @Nullable
        private FilteredQueryModel m8631j() {
            this.f7991d = (FilteredQueryModel) super.a(this.f7991d, 0, FilteredQueryModel.class);
            return this.f7991d;
        }

        @Nullable
        private SearchPivotsModel m8632k() {
            this.f7992e = (SearchPivotsModel) super.a(this.f7992e, 1, SearchPivotsModel.class);
            return this.f7992e;
        }

        public final int jK_() {
            return -466486798;
        }

        public final GraphQLVisitableModel m8634a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m8631j() != null) {
                FilteredQueryModel filteredQueryModel = (FilteredQueryModel) graphQLModelMutatingVisitor.b(m8631j());
                if (m8631j() != filteredQueryModel) {
                    graphQLVisitableModel = (KeywordSearchQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f7991d = filteredQueryModel;
                }
            }
            if (m8632k() != null) {
                SearchPivotsModel searchPivotsModel = (SearchPivotsModel) graphQLModelMutatingVisitor.b(m8632k());
                if (m8632k() != searchPivotsModel) {
                    graphQLVisitableModel = (KeywordSearchQueryModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f7992e = searchPivotsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m8633a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m8631j());
            int a2 = ModelHelper.a(flatBufferBuilder, m8632k());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1384081600)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: new_password */
    public final class KeywordSearchResultDecorationModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private List<String> f7995d;
        @Nullable
        private List<OrderedSnippetsModel> f7996e;
        @Nullable
        private String f7997f;

        /* compiled from: new_password */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(KeywordSearchResultDecorationModel.class, new Deserializer());
            }

            public Object m8637a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(KeywordSearchResultDecorationParser.m8706a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object keywordSearchResultDecorationModel = new KeywordSearchResultDecorationModel();
                ((BaseModel) keywordSearchResultDecorationModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (keywordSearchResultDecorationModel instanceof Postprocessable) {
                    return ((Postprocessable) keywordSearchResultDecorationModel).a();
                }
                return keywordSearchResultDecorationModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1838679464)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: new_password */
        public final class OrderedSnippetsModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private SentenceModel f7994d;

            /* compiled from: new_password */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(OrderedSnippetsModel.class, new Deserializer());
                }

                public Object m8638a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(OrderedSnippetsParser.m8704b(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object orderedSnippetsModel = new OrderedSnippetsModel();
                    ((BaseModel) orderedSnippetsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (orderedSnippetsModel instanceof Postprocessable) {
                        return ((Postprocessable) orderedSnippetsModel).a();
                    }
                    return orderedSnippetsModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -1352864475)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: new_password */
            public final class SentenceModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private String f7993d;

                /* compiled from: new_password */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(SentenceModel.class, new Deserializer());
                    }

                    public Object m8639a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(SentenceParser.m8702a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object sentenceModel = new SentenceModel();
                        ((BaseModel) sentenceModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (sentenceModel instanceof Postprocessable) {
                            return ((Postprocessable) sentenceModel).a();
                        }
                        return sentenceModel;
                    }
                }

                /* compiled from: new_password */
                public class Serializer extends JsonSerializer<SentenceModel> {
                    public final void m8640a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        SentenceModel sentenceModel = (SentenceModel) obj;
                        if (sentenceModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(sentenceModel.m8641a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            sentenceModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        SentenceParser.m8703a(sentenceModel.w_(), sentenceModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(SentenceModel.class, new Serializer());
                    }
                }

                public SentenceModel() {
                    super(1);
                }

                @Nullable
                public final String m8643a() {
                    this.f7993d = super.a(this.f7993d, 0);
                    return this.f7993d;
                }

                public final int jK_() {
                    return -1919764332;
                }

                public final GraphQLVisitableModel m8642a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m8641a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int b = flatBufferBuilder.b(m8643a());
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, b);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: new_password */
            public class Serializer extends JsonSerializer<OrderedSnippetsModel> {
                public final void m8644a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    OrderedSnippetsModel orderedSnippetsModel = (OrderedSnippetsModel) obj;
                    if (orderedSnippetsModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(orderedSnippetsModel.m8646a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        orderedSnippetsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    OrderedSnippetsParser.m8705b(orderedSnippetsModel.w_(), orderedSnippetsModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(OrderedSnippetsModel.class, new Serializer());
                }
            }

            @Nullable
            public final /* synthetic */ SentenceModel m8648a() {
                return m8645j();
            }

            public OrderedSnippetsModel() {
                super(1);
            }

            @Nullable
            private SentenceModel m8645j() {
                this.f7994d = (SentenceModel) super.a(this.f7994d, 0, SentenceModel.class);
                return this.f7994d;
            }

            public final int jK_() {
                return -38981689;
            }

            public final GraphQLVisitableModel m8647a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m8645j() != null) {
                    SentenceModel sentenceModel = (SentenceModel) graphQLModelMutatingVisitor.b(m8645j());
                    if (m8645j() != sentenceModel) {
                        graphQLVisitableModel = (OrderedSnippetsModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f7994d = sentenceModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m8646a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m8645j());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: new_password */
        public class Serializer extends JsonSerializer<KeywordSearchResultDecorationModel> {
            public final void m8649a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                KeywordSearchResultDecorationModel keywordSearchResultDecorationModel = (KeywordSearchResultDecorationModel) obj;
                if (keywordSearchResultDecorationModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(keywordSearchResultDecorationModel.m8650a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    keywordSearchResultDecorationModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                KeywordSearchResultDecorationParser.m8707a(keywordSearchResultDecorationModel.w_(), keywordSearchResultDecorationModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(KeywordSearchResultDecorationModel.class, new Serializer());
            }
        }

        public KeywordSearchResultDecorationModel() {
            super(3);
        }

        @Nonnull
        public final ImmutableList<String> m8652a() {
            this.f7995d = super.a(this.f7995d, 0);
            return (ImmutableList) this.f7995d;
        }

        @Nonnull
        public final ImmutableList<OrderedSnippetsModel> m8653b() {
            this.f7996e = super.a(this.f7996e, 1, OrderedSnippetsModel.class);
            return (ImmutableList) this.f7996e;
        }

        @Nullable
        public final String m8654c() {
            this.f7997f = super.a(this.f7997f, 2);
            return this.f7997f;
        }

        public final int jK_() {
            return 379010371;
        }

        public final GraphQLVisitableModel m8651a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m8653b() != null) {
                Builder a = ModelHelper.a(m8653b(), graphQLModelMutatingVisitor);
                if (a != null) {
                    graphQLVisitableModel = (KeywordSearchResultDecorationModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f7996e = a.b();
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m8650a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int c = flatBufferBuilder.c(m8652a());
            int a = ModelHelper.a(flatBufferBuilder, m8653b());
            int b = flatBufferBuilder.b(m8654c());
            flatBufferBuilder.c(3);
            flatBufferBuilder.b(0, c);
            flatBufferBuilder.b(1, a);
            flatBufferBuilder.b(2, b);
            i();
            return flatBufferBuilder.d();
        }
    }

    @FragmentModelWithBridge
    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 2043502719)
    @JsonSerialize(using = Serializer.class)
    /* compiled from: new_password */
    public final class ModuleResultEdgeModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private AboutInformationModel f7999d;
        @Nullable
        private String f8000e;
        @Nullable
        private GraphQLNode f8001f;
        @Nullable
        private KeywordSearchResultDecorationModel f8002g;

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1352864475)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: new_password */
        public final class AboutInformationModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private String f7998d;

            /* compiled from: new_password */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(AboutInformationModel.class, new Deserializer());
                }

                public Object m8655a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(AboutInformationParser.m8708a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object aboutInformationModel = new AboutInformationModel();
                    ((BaseModel) aboutInformationModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (aboutInformationModel instanceof Postprocessable) {
                        return ((Postprocessable) aboutInformationModel).a();
                    }
                    return aboutInformationModel;
                }
            }

            /* compiled from: new_password */
            public class Serializer extends JsonSerializer<AboutInformationModel> {
                public final void m8656a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    AboutInformationModel aboutInformationModel = (AboutInformationModel) obj;
                    if (aboutInformationModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(aboutInformationModel.m8657a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        aboutInformationModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    AboutInformationParser.m8709a(aboutInformationModel.w_(), aboutInformationModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(AboutInformationModel.class, new Serializer());
                }
            }

            public AboutInformationModel() {
                super(1);
            }

            @Nullable
            public final String m8659a() {
                this.f7998d = super.a(this.f7998d, 0);
                return this.f7998d;
            }

            public final int jK_() {
                return -1919764332;
            }

            public final GraphQLVisitableModel m8658a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m8657a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m8659a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: new_password */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(ModuleResultEdgeModel.class, new Deserializer());
            }

            public Object m8660a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(ModuleResultEdgeParser.m8710b(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object moduleResultEdgeModel = new ModuleResultEdgeModel();
                ((BaseModel) moduleResultEdgeModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (moduleResultEdgeModel instanceof Postprocessable) {
                    return ((Postprocessable) moduleResultEdgeModel).a();
                }
                return moduleResultEdgeModel;
            }
        }

        /* compiled from: new_password */
        public class Serializer extends JsonSerializer<ModuleResultEdgeModel> {
            public final void m8661a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                ModuleResultEdgeModel moduleResultEdgeModel = (ModuleResultEdgeModel) obj;
                if (moduleResultEdgeModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(moduleResultEdgeModel.m8665a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    moduleResultEdgeModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                ModuleResultEdgeParser.m8711b(moduleResultEdgeModel.w_(), moduleResultEdgeModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(ModuleResultEdgeModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ AboutInformationModel m8667a() {
            return m8662j();
        }

        @Nullable
        public final /* synthetic */ KeywordSearchResultDecorationModel m8669c() {
            return m8664l();
        }

        public ModuleResultEdgeModel() {
            super(4);
        }

        @Nullable
        private AboutInformationModel m8662j() {
            this.f7999d = (AboutInformationModel) super.a(this.f7999d, 0, AboutInformationModel.class);
            return this.f7999d;
        }

        @Nullable
        private String m8663k() {
            this.f8000e = super.a(this.f8000e, 1);
            return this.f8000e;
        }

        @Nullable
        public final GraphQLNode m8668b() {
            this.f8001f = (GraphQLNode) super.a(this.f8001f, 2, GraphQLNode.class);
            return this.f8001f;
        }

        @Nullable
        private KeywordSearchResultDecorationModel m8664l() {
            this.f8002g = (KeywordSearchResultDecorationModel) super.a(this.f8002g, 3, KeywordSearchResultDecorationModel.class);
            return this.f8002g;
        }

        public final int jK_() {
            return -2114491914;
        }

        public final GraphQLVisitableModel m8666a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m8662j() != null) {
                AboutInformationModel aboutInformationModel = (AboutInformationModel) graphQLModelMutatingVisitor.b(m8662j());
                if (m8662j() != aboutInformationModel) {
                    graphQLVisitableModel = (ModuleResultEdgeModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f7999d = aboutInformationModel;
                }
            }
            if (m8668b() != null) {
                GraphQLNode graphQLNode = (GraphQLNode) graphQLModelMutatingVisitor.b(m8668b());
                if (m8668b() != graphQLNode) {
                    graphQLVisitableModel = (ModuleResultEdgeModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f8001f = graphQLNode;
                }
            }
            if (m8664l() != null) {
                KeywordSearchResultDecorationModel keywordSearchResultDecorationModel = (KeywordSearchResultDecorationModel) graphQLModelMutatingVisitor.b(m8664l());
                if (m8664l() != keywordSearchResultDecorationModel) {
                    graphQLVisitableModel = (ModuleResultEdgeModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f8002g = keywordSearchResultDecorationModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m8665a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m8662j());
            int b = flatBufferBuilder.b(m8663k());
            int a2 = ModelHelper.a(flatBufferBuilder, m8668b());
            int a3 = ModelHelper.a(flatBufferBuilder, m8664l());
            flatBufferBuilder.c(4);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, b);
            flatBufferBuilder.b(2, a2);
            flatBufferBuilder.b(3, a3);
            i();
            return flatBufferBuilder.d();
        }
    }
}
