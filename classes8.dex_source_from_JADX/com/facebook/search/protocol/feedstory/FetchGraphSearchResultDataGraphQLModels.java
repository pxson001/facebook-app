package com.facebook.search.protocol.feedstory;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLEventGuestStatus;
import com.facebook.graphql.enums.GraphQLFriendshipStatus;
import com.facebook.graphql.enums.GraphQLGraphSearchResultsDisplayStyle;
import com.facebook.graphql.enums.GraphQLGraphSearchSpellerConfidence;
import com.facebook.graphql.enums.GraphQLGroupJoinState;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.modelutil.SerializerHelpers;
import com.facebook.graphql.querybuilder.common.CommonGraphQLModels.DefaultImageFieldsModel;
import com.facebook.graphql.visitor.ConsistencyTuple;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.search.protocol.feedstory.FetchGraphSearchResultDataGraphQLParsers.FBGraphSearchQueryDetailsFragmentParser;
import com.facebook.search.protocol.feedstory.FetchGraphSearchResultDataGraphQLParsers.FBGraphSearchQueryDetailsFragmentParser.ModulesParser;
import com.facebook.search.protocol.feedstory.FetchGraphSearchResultDataGraphQLParsers.FBGraphSearchQueryDetailsFragmentParser.ModulesParser.CorrectedQueryParser;
import com.facebook.search.protocol.feedstory.FetchGraphSearchResultDataGraphQLParsers.FBGraphSearchQueryDetailsFragmentParser.ModulesParser.CorrectedQueryParser.QueryTitleParser;
import com.facebook.search.protocol.feedstory.FetchGraphSearchResultDataGraphQLParsers.FBGraphSearchQueryParser;
import com.facebook.search.protocol.feedstory.FetchGraphSearchResultDataGraphQLParsers.FBGraphSearchQueryParser.FilteredQueryParser;
import com.facebook.search.protocol.feedstory.FetchGraphSearchResultDataGraphQLParsers.FBGraphSearchQueryResultFragmentParser;
import com.facebook.search.protocol.feedstory.FetchGraphSearchResultDataGraphQLParsers.FBGraphSearchQueryResultFragmentParser.EdgesParser;
import com.facebook.search.protocol.feedstory.FetchGraphSearchResultDataGraphQLParsers.FBGraphSearchQueryResultFragmentParser.EdgesParser.NodeParser;
import com.facebook.search.protocol.feedstory.FetchGraphSearchResultDataGraphQLParsers.FBGraphSearchQueryResultFragmentParser.PageInfoParser;
import com.facebook.search.results.protocol.common.SearchResultsDecorationModels.SearchResultsDecorationModel;
import com.facebook.search.results.protocol.entity.SearchResultsAppInterfaces.SearchResultsApp;
import com.facebook.search.results.protocol.entity.SearchResultsEventInterfaces.SearchResultsEvent;
import com.facebook.search.results.protocol.entity.SearchResultsEventModels.SearchResultsEventModel.EventPlaceModel;
import com.facebook.search.results.protocol.entity.SearchResultsGroupInterfaces.SearchResultsGroup;
import com.facebook.search.results.protocol.entity.SearchResultsGroupModels.SearchResultsGroupModel.GroupMembersModel;
import com.facebook.search.results.protocol.entity.SearchResultsGroupModels.SearchResultsGroupModel.SocialContextModel;
import com.facebook.search.results.protocol.entity.SearchResultsGroupModels.SearchResultsGroupModel.VisibilitySentenceModel;
import com.facebook.search.results.protocol.entity.SearchResultsPageInterfaces.SearchResultsPage;
import com.facebook.search.results.protocol.entity.SearchResultsPageModels.SearchResultsPageCTAModel;
import com.facebook.search.results.protocol.entity.SearchResultsPageModels.SearchResultsPageModel.CoverPhotoModel;
import com.facebook.search.results.protocol.entity.SearchResultsPageModels.SearchResultsPageModel.PageLikersModel;
import com.facebook.search.results.protocol.entity.SearchResultsUserInterfaces.SearchResultsUser;
import com.facebook.search.results.protocol.entity.SearchResultsUserModels.SearchResultsUserModel.BioTextModel;
import com.facebook.search.results.protocol.entity.SearchResultsUserModels.SearchResultsUserModel.MutualFriendsModel;
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

/* compiled from: native_article_close */
public class FetchGraphSearchResultDataGraphQLModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1655581415)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: native_article_close */
    public final class FBGraphSearchQueryDetailsFragmentModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
        @Nullable
        private String f8235d;
        @Nullable
        private ModulesModel f8236e;
        @Nullable
        private String f8237f;
        @Nullable
        private QueryTitleModel f8238g;
        @Nullable
        private List<GraphQLGraphSearchResultsDisplayStyle> f8239h;

        /* compiled from: native_article_close */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FBGraphSearchQueryDetailsFragmentModel.class, new Deserializer());
            }

            public Object m9266a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = FBGraphSearchQueryDetailsFragmentParser.m9375a(jsonParser);
                Object fBGraphSearchQueryDetailsFragmentModel = new FBGraphSearchQueryDetailsFragmentModel();
                ((BaseModel) fBGraphSearchQueryDetailsFragmentModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (fBGraphSearchQueryDetailsFragmentModel instanceof Postprocessable) {
                    return ((Postprocessable) fBGraphSearchQueryDetailsFragmentModel).a();
                }
                return fBGraphSearchQueryDetailsFragmentModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1705630139)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: native_article_close */
        public final class ModulesModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private CorrectedQueryModel f8230d;
            @Nullable
            private String f8231e;
            @Nullable
            private GraphQLGraphSearchSpellerConfidence f8232f;
            @Nullable
            private String f8233g;

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -2018463519)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: native_article_close */
            public final class CorrectedQueryModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private String f8228d;
                @Nullable
                private QueryTitleModel f8229e;

                /* compiled from: native_article_close */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(CorrectedQueryModel.class, new Deserializer());
                    }

                    public Object m9267a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(CorrectedQueryParser.m9369a(jsonParser, flatBufferBuilder));
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
                /* compiled from: native_article_close */
                public final class QueryTitleModel extends BaseModel implements GraphQLVisitableModel {
                    @Nullable
                    private String f8227d;

                    /* compiled from: native_article_close */
                    public class Deserializer extends FbJsonDeserializer {
                        static {
                            GlobalAutoGenDeserializerCache.a(QueryTitleModel.class, new Deserializer());
                        }

                        public Object m9268a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(QueryTitleParser.m9367a(jsonParser, flatBufferBuilder));
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

                    /* compiled from: native_article_close */
                    public class Serializer extends JsonSerializer<QueryTitleModel> {
                        public final void m9269a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            QueryTitleModel queryTitleModel = (QueryTitleModel) obj;
                            if (queryTitleModel.w_() == null) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(queryTitleModel.m9271a(flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                queryTitleModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                            }
                            QueryTitleParser.m9368a(queryTitleModel.w_(), queryTitleModel.u_(), jsonGenerator);
                        }

                        static {
                            FbSerializerProvider.a(QueryTitleModel.class, new Serializer());
                        }
                    }

                    public QueryTitleModel() {
                        super(1);
                    }

                    @Nullable
                    private String m9270a() {
                        this.f8227d = super.a(this.f8227d, 0);
                        return this.f8227d;
                    }

                    public final int jK_() {
                        return -1696096378;
                    }

                    public final GraphQLVisitableModel m9272a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                        h();
                        i();
                        return this;
                    }

                    public final int m9271a(FlatBufferBuilder flatBufferBuilder) {
                        h();
                        int b = flatBufferBuilder.b(m9270a());
                        flatBufferBuilder.c(1);
                        flatBufferBuilder.b(0, b);
                        i();
                        return flatBufferBuilder.d();
                    }
                }

                /* compiled from: native_article_close */
                public class Serializer extends JsonSerializer<CorrectedQueryModel> {
                    public final void m9273a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        CorrectedQueryModel correctedQueryModel = (CorrectedQueryModel) obj;
                        if (correctedQueryModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(correctedQueryModel.m9276a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            correctedQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        CorrectedQueryParser.m9370a(correctedQueryModel.w_(), correctedQueryModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(CorrectedQueryModel.class, new Serializer());
                    }
                }

                public CorrectedQueryModel() {
                    super(2);
                }

                @Nullable
                private String m9274a() {
                    this.f8228d = super.a(this.f8228d, 0);
                    return this.f8228d;
                }

                @Nullable
                private QueryTitleModel m9275j() {
                    this.f8229e = (QueryTitleModel) super.a(this.f8229e, 1, QueryTitleModel.class);
                    return this.f8229e;
                }

                public final int jK_() {
                    return -466486798;
                }

                public final GraphQLVisitableModel m9277a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m9275j() != null) {
                        QueryTitleModel queryTitleModel = (QueryTitleModel) graphQLModelMutatingVisitor.b(m9275j());
                        if (m9275j() != queryTitleModel) {
                            graphQLVisitableModel = (CorrectedQueryModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f8229e = queryTitleModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m9276a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int b = flatBufferBuilder.b(m9274a());
                    int a = ModelHelper.a(flatBufferBuilder, m9275j());
                    flatBufferBuilder.c(2);
                    flatBufferBuilder.b(0, b);
                    flatBufferBuilder.b(1, a);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: native_article_close */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(ModulesModel.class, new Deserializer());
                }

                public Object m9278a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(ModulesParser.m9371a(jsonParser, flatBufferBuilder));
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

            /* compiled from: native_article_close */
            public class Serializer extends JsonSerializer<ModulesModel> {
                public final void m9279a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    ModulesModel modulesModel = (ModulesModel) obj;
                    if (modulesModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(modulesModel.m9284a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        modulesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    ModulesParser.m9372a(modulesModel.w_(), modulesModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(ModulesModel.class, new Serializer());
                }
            }

            public ModulesModel() {
                super(4);
            }

            @Nullable
            private CorrectedQueryModel m9280a() {
                this.f8230d = (CorrectedQueryModel) super.a(this.f8230d, 0, CorrectedQueryModel.class);
                return this.f8230d;
            }

            @Nullable
            private String m9281j() {
                this.f8231e = super.a(this.f8231e, 1);
                return this.f8231e;
            }

            @Nullable
            private GraphQLGraphSearchSpellerConfidence m9282k() {
                this.f8232f = (GraphQLGraphSearchSpellerConfidence) super.b(this.f8232f, 2, GraphQLGraphSearchSpellerConfidence.class, GraphQLGraphSearchSpellerConfidence.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                return this.f8232f;
            }

            @Nullable
            private String m9283l() {
                this.f8233g = super.a(this.f8233g, 3);
                return this.f8233g;
            }

            public final int jK_() {
                return -481462289;
            }

            public final GraphQLVisitableModel m9285a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m9280a() != null) {
                    CorrectedQueryModel correctedQueryModel = (CorrectedQueryModel) graphQLModelMutatingVisitor.b(m9280a());
                    if (m9280a() != correctedQueryModel) {
                        graphQLVisitableModel = (ModulesModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f8230d = correctedQueryModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m9284a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m9280a());
                int b = flatBufferBuilder.b(m9281j());
                int a2 = flatBufferBuilder.a(m9282k());
                int b2 = flatBufferBuilder.b(m9283l());
                flatBufferBuilder.c(4);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, b);
                flatBufferBuilder.b(2, a2);
                flatBufferBuilder.b(3, b2);
                i();
                return flatBufferBuilder.d();
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1352864475)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: native_article_close */
        public final class QueryTitleModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private String f8234d;

            /* compiled from: native_article_close */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(QueryTitleModel.class, new Deserializer());
                }

                public Object m9286a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(FBGraphSearchQueryDetailsFragmentParser.QueryTitleParser.m9373a(jsonParser, flatBufferBuilder));
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

            /* compiled from: native_article_close */
            public class Serializer extends JsonSerializer<QueryTitleModel> {
                public final void m9287a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    QueryTitleModel queryTitleModel = (QueryTitleModel) obj;
                    if (queryTitleModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(queryTitleModel.m9289a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        queryTitleModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    FBGraphSearchQueryDetailsFragmentParser.QueryTitleParser.m9374a(queryTitleModel.w_(), queryTitleModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(QueryTitleModel.class, new Serializer());
                }
            }

            public QueryTitleModel() {
                super(1);
            }

            @Nullable
            private String m9288a() {
                this.f8234d = super.a(this.f8234d, 0);
                return this.f8234d;
            }

            public final int jK_() {
                return -1696096378;
            }

            public final GraphQLVisitableModel m9290a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m9289a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m9288a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: native_article_close */
        public class Serializer extends JsonSerializer<FBGraphSearchQueryDetailsFragmentModel> {
            public final void m9291a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                FBGraphSearchQueryDetailsFragmentModel fBGraphSearchQueryDetailsFragmentModel = (FBGraphSearchQueryDetailsFragmentModel) obj;
                if (fBGraphSearchQueryDetailsFragmentModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(fBGraphSearchQueryDetailsFragmentModel.m9297a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    fBGraphSearchQueryDetailsFragmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = fBGraphSearchQueryDetailsFragmentModel.w_();
                int u_ = fBGraphSearchQueryDetailsFragmentModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("id");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 0));
                }
                int g = mutableFlatBuffer.g(u_, 1);
                if (g != 0) {
                    jsonGenerator.a("modules");
                    ModulesParser.m9372a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                if (mutableFlatBuffer.g(u_, 2) != 0) {
                    jsonGenerator.a("query_function");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 2));
                }
                g = mutableFlatBuffer.g(u_, 3);
                if (g != 0) {
                    jsonGenerator.a("query_title");
                    FBGraphSearchQueryDetailsFragmentParser.QueryTitleParser.m9374a(mutableFlatBuffer, g, jsonGenerator);
                }
                if (mutableFlatBuffer.g(u_, 4) != 0) {
                    jsonGenerator.a("search_result_style_list");
                    SerializerHelpers.a(mutableFlatBuffer.f(u_, 4), jsonGenerator);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(FBGraphSearchQueryDetailsFragmentModel.class, new Serializer());
            }
        }

        public FBGraphSearchQueryDetailsFragmentModel() {
            super(5);
        }

        @Nullable
        private String m9292j() {
            this.f8235d = super.a(this.f8235d, 0);
            return this.f8235d;
        }

        @Nullable
        private ModulesModel m9293k() {
            this.f8236e = (ModulesModel) super.a(this.f8236e, 1, ModulesModel.class);
            return this.f8236e;
        }

        @Nullable
        private String m9294l() {
            this.f8237f = super.a(this.f8237f, 2);
            return this.f8237f;
        }

        @Nullable
        private QueryTitleModel m9295m() {
            this.f8238g = (QueryTitleModel) super.a(this.f8238g, 3, QueryTitleModel.class);
            return this.f8238g;
        }

        @Nonnull
        private ImmutableList<GraphQLGraphSearchResultsDisplayStyle> m9296n() {
            this.f8239h = super.c(this.f8239h, 4, GraphQLGraphSearchResultsDisplayStyle.class);
            return (ImmutableList) this.f8239h;
        }

        @Nullable
        public final String m9299a() {
            return m9292j();
        }

        public final int jK_() {
            return -466486798;
        }

        public final GraphQLVisitableModel m9298a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m9293k() != null) {
                ModulesModel modulesModel = (ModulesModel) graphQLModelMutatingVisitor.b(m9293k());
                if (m9293k() != modulesModel) {
                    graphQLVisitableModel = (FBGraphSearchQueryDetailsFragmentModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f8236e = modulesModel;
                }
            }
            if (m9295m() != null) {
                QueryTitleModel queryTitleModel = (QueryTitleModel) graphQLModelMutatingVisitor.b(m9295m());
                if (m9295m() != queryTitleModel) {
                    graphQLVisitableModel = (FBGraphSearchQueryDetailsFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f8238g = queryTitleModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m9297a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m9292j());
            int a = ModelHelper.a(flatBufferBuilder, m9293k());
            int b2 = flatBufferBuilder.b(m9294l());
            int a2 = ModelHelper.a(flatBufferBuilder, m9295m());
            int d = flatBufferBuilder.d(m9296n());
            flatBufferBuilder.c(5);
            flatBufferBuilder.b(0, b);
            flatBufferBuilder.b(1, a);
            flatBufferBuilder.b(2, b2);
            flatBufferBuilder.b(3, a2);
            flatBufferBuilder.b(4, d);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1813710878)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: native_article_close */
    public final class FBGraphSearchQueryModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private FilteredQueryModel f8246d;

        /* compiled from: native_article_close */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FBGraphSearchQueryModel.class, new Deserializer());
            }

            public Object m9300a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = FBGraphSearchQueryParser.m9378a(jsonParser);
                Object fBGraphSearchQueryModel = new FBGraphSearchQueryModel();
                ((BaseModel) fBGraphSearchQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (fBGraphSearchQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) fBGraphSearchQueryModel).a();
                }
                return fBGraphSearchQueryModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 383100979)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: native_article_close */
        public final class FilteredQueryModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
            @Nullable
            private String f8240d;
            @Nullable
            private ModulesModel f8241e;
            @Nullable
            private String f8242f;
            @Nullable
            private QueryTitleModel f8243g;
            @Nullable
            private FBGraphSearchQueryResultFragmentModel f8244h;
            @Nullable
            private List<GraphQLGraphSearchResultsDisplayStyle> f8245i;

            /* compiled from: native_article_close */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(FilteredQueryModel.class, new Deserializer());
                }

                public Object m9301a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(FilteredQueryParser.m9376a(jsonParser, flatBufferBuilder));
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

            /* compiled from: native_article_close */
            public class Serializer extends JsonSerializer<FilteredQueryModel> {
                public final void m9302a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    FilteredQueryModel filteredQueryModel = (FilteredQueryModel) obj;
                    if (filteredQueryModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(filteredQueryModel.m9309a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        filteredQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    FilteredQueryParser.m9377a(filteredQueryModel.w_(), filteredQueryModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(FilteredQueryModel.class, new Serializer());
                }
            }

            public FilteredQueryModel() {
                super(6);
            }

            @Nullable
            private String m9303j() {
                this.f8240d = super.a(this.f8240d, 0);
                return this.f8240d;
            }

            @Nullable
            private ModulesModel m9304k() {
                this.f8241e = (ModulesModel) super.a(this.f8241e, 1, ModulesModel.class);
                return this.f8241e;
            }

            @Nullable
            private String m9305l() {
                this.f8242f = super.a(this.f8242f, 2);
                return this.f8242f;
            }

            @Nullable
            private QueryTitleModel m9306m() {
                this.f8243g = (QueryTitleModel) super.a(this.f8243g, 3, QueryTitleModel.class);
                return this.f8243g;
            }

            @Nullable
            private FBGraphSearchQueryResultFragmentModel m9307n() {
                this.f8244h = (FBGraphSearchQueryResultFragmentModel) super.a(this.f8244h, 4, FBGraphSearchQueryResultFragmentModel.class);
                return this.f8244h;
            }

            @Nonnull
            private ImmutableList<GraphQLGraphSearchResultsDisplayStyle> m9308o() {
                this.f8245i = super.c(this.f8245i, 5, GraphQLGraphSearchResultsDisplayStyle.class);
                return (ImmutableList) this.f8245i;
            }

            @Nullable
            public final String m9311a() {
                return m9303j();
            }

            public final int jK_() {
                return -466486798;
            }

            public final GraphQLVisitableModel m9310a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m9304k() != null) {
                    ModulesModel modulesModel = (ModulesModel) graphQLModelMutatingVisitor.b(m9304k());
                    if (m9304k() != modulesModel) {
                        graphQLVisitableModel = (FilteredQueryModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f8241e = modulesModel;
                    }
                }
                if (m9306m() != null) {
                    QueryTitleModel queryTitleModel = (QueryTitleModel) graphQLModelMutatingVisitor.b(m9306m());
                    if (m9306m() != queryTitleModel) {
                        graphQLVisitableModel = (FilteredQueryModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f8243g = queryTitleModel;
                    }
                }
                if (m9307n() != null) {
                    FBGraphSearchQueryResultFragmentModel fBGraphSearchQueryResultFragmentModel = (FBGraphSearchQueryResultFragmentModel) graphQLModelMutatingVisitor.b(m9307n());
                    if (m9307n() != fBGraphSearchQueryResultFragmentModel) {
                        graphQLVisitableModel = (FilteredQueryModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f8244h = fBGraphSearchQueryResultFragmentModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m9309a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m9303j());
                int a = ModelHelper.a(flatBufferBuilder, m9304k());
                int b2 = flatBufferBuilder.b(m9305l());
                int a2 = ModelHelper.a(flatBufferBuilder, m9306m());
                int a3 = ModelHelper.a(flatBufferBuilder, m9307n());
                int d = flatBufferBuilder.d(m9308o());
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

        /* compiled from: native_article_close */
        public class Serializer extends JsonSerializer<FBGraphSearchQueryModel> {
            public final void m9312a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                FBGraphSearchQueryModel fBGraphSearchQueryModel = (FBGraphSearchQueryModel) obj;
                if (fBGraphSearchQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(fBGraphSearchQueryModel.m9314a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    fBGraphSearchQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = fBGraphSearchQueryModel.w_();
                int u_ = fBGraphSearchQueryModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("filtered_query");
                    FilteredQueryParser.m9377a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(FBGraphSearchQueryModel.class, new Serializer());
            }
        }

        public FBGraphSearchQueryModel() {
            super(1);
        }

        @Nullable
        private FilteredQueryModel m9313a() {
            this.f8246d = (FilteredQueryModel) super.a(this.f8246d, 0, FilteredQueryModel.class);
            return this.f8246d;
        }

        public final int jK_() {
            return -466486798;
        }

        public final GraphQLVisitableModel m9315a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m9313a() != null) {
                FilteredQueryModel filteredQueryModel = (FilteredQueryModel) graphQLModelMutatingVisitor.b(m9313a());
                if (m9313a() != filteredQueryModel) {
                    graphQLVisitableModel = (FBGraphSearchQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f8246d = filteredQueryModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m9314a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m9313a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 792062371)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: native_article_close */
    public final class FBGraphSearchQueryResultFragmentModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private List<EdgesModel> f8276d;
        @Nullable
        private PageInfoModel f8277e;

        /* compiled from: native_article_close */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FBGraphSearchQueryResultFragmentModel.class, new Deserializer());
            }

            public Object m9316a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(FBGraphSearchQueryResultFragmentParser.m9385a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object fBGraphSearchQueryResultFragmentModel = new FBGraphSearchQueryResultFragmentModel();
                ((BaseModel) fBGraphSearchQueryResultFragmentModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (fBGraphSearchQueryResultFragmentModel instanceof Postprocessable) {
                    return ((Postprocessable) fBGraphSearchQueryResultFragmentModel).a();
                }
                return fBGraphSearchQueryResultFragmentModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 60413165)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: native_article_close */
        public final class EdgesModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private NodeModel f8272d;
            @Nullable
            private SearchResultsDecorationModel f8273e;

            /* compiled from: native_article_close */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(EdgesModel.class, new Deserializer());
                }

                public Object m9317a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(EdgesParser.m9381b(jsonParser, flatBufferBuilder));
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
            @ModelWithFlatBufferFormatHash(a = 333155254)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: native_article_close */
            public final class NodeModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel, SearchResultsApp, SearchResultsEvent, SearchResultsGroup, SearchResultsPage, SearchResultsUser {
                @Nullable
                private GraphQLGroupJoinState f8247A;
                @Nullable
                private VisibilitySentenceModel f8248B;
                @Nullable
                private GraphQLObjectType f8249d;
                @Nullable
                private List<String> f8250e;
                @Nullable
                private BioTextModel f8251f;
                private boolean f8252g;
                private boolean f8253h;
                @Nullable
                private List<String> f8254i;
                @Nullable
                private CoverPhotoModel f8255j;
                private boolean f8256k;
                @Nullable
                private EventPlaceModel f8257l;
                @Nullable
                private GraphQLFriendshipStatus f8258m;
                @Nullable
                private GroupMembersModel f8259n;
                @Nullable
                private String f8260o;
                @Nullable
                private DefaultImageFieldsModel f8261p;
                @Nullable
                private DefaultImageFieldsModel f8262q;
                private boolean f8263r;
                @Nullable
                private MutualFriendsModel f8264s;
                @Nullable
                private String f8265t;
                @Nullable
                private SearchResultsPageCTAModel f8266u;
                @Nullable
                private PageLikersModel f8267v;
                @Nullable
                private DefaultImageFieldsModel f8268w;
                @Nullable
                private SocialContextModel f8269x;
                @Nullable
                private String f8270y;
                @Nullable
                private GraphQLEventGuestStatus f8271z;

                /* compiled from: native_article_close */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(NodeModel.class, new Deserializer());
                    }

                    public Object m9318a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(NodeParser.m9379a(jsonParser, flatBufferBuilder));
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

                /* compiled from: native_article_close */
                public class Serializer extends JsonSerializer<NodeModel> {
                    public final void m9319a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        NodeModel nodeModel = (NodeModel) obj;
                        if (nodeModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(nodeModel.m9343a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            nodeModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        NodeParser.m9380a(nodeModel.w_(), nodeModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(NodeModel.class, new Serializer());
                    }
                }

                public NodeModel() {
                    super(25);
                }

                public final void m9347a(String str, ConsistencyTuple consistencyTuple) {
                    if ("friendship_status".equals(str)) {
                        consistencyTuple.a = m9334r();
                        consistencyTuple.b = u_();
                        consistencyTuple.c = 9;
                    } else if ("viewer_guest_status".equals(str)) {
                        consistencyTuple.a = m9322C();
                        consistencyTuple.b = u_();
                        consistencyTuple.c = 22;
                    } else if ("viewer_join_state".equals(str)) {
                        consistencyTuple.a = m9323D();
                        consistencyTuple.b = u_();
                        consistencyTuple.c = 23;
                    } else {
                        consistencyTuple.a();
                    }
                }

                public final void m9348a(String str, Object obj, boolean z) {
                    if ("friendship_status".equals(str)) {
                        m9326a((GraphQLFriendshipStatus) obj);
                    } else if ("viewer_guest_status".equals(str)) {
                        m9325a((GraphQLEventGuestStatus) obj);
                    } else if ("viewer_join_state".equals(str)) {
                        m9327a((GraphQLGroupJoinState) obj);
                    }
                }

                @Nullable
                private GraphQLObjectType m9328l() {
                    if (this.b != null && this.f8249d == null) {
                        this.f8249d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                    }
                    return this.f8249d;
                }

                @Nonnull
                private ImmutableList<String> m9329m() {
                    this.f8250e = super.a(this.f8250e, 1);
                    return (ImmutableList) this.f8250e;
                }

                @Nullable
                private BioTextModel m9330n() {
                    this.f8251f = (BioTextModel) super.a(this.f8251f, 2, BioTextModel.class);
                    return this.f8251f;
                }

                @Nonnull
                private ImmutableList<String> m9331o() {
                    this.f8254i = super.a(this.f8254i, 5);
                    return (ImmutableList) this.f8254i;
                }

                @Nullable
                private CoverPhotoModel m9332p() {
                    this.f8255j = (CoverPhotoModel) super.a(this.f8255j, 6, CoverPhotoModel.class);
                    return this.f8255j;
                }

                @Nullable
                private EventPlaceModel m9333q() {
                    this.f8257l = (EventPlaceModel) super.a(this.f8257l, 8, EventPlaceModel.class);
                    return this.f8257l;
                }

                @Nullable
                private GraphQLFriendshipStatus m9334r() {
                    this.f8258m = (GraphQLFriendshipStatus) super.b(this.f8258m, 9, GraphQLFriendshipStatus.class, GraphQLFriendshipStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                    return this.f8258m;
                }

                private void m9326a(GraphQLFriendshipStatus graphQLFriendshipStatus) {
                    this.f8258m = graphQLFriendshipStatus;
                    if (this.b != null && this.b.d) {
                        this.b.a(this.c, 9, graphQLFriendshipStatus != null ? graphQLFriendshipStatus.name() : null);
                    }
                }

                @Nullable
                private GroupMembersModel m9335s() {
                    this.f8259n = (GroupMembersModel) super.a(this.f8259n, 10, GroupMembersModel.class);
                    return this.f8259n;
                }

                @Nullable
                private String m9336t() {
                    this.f8260o = super.a(this.f8260o, 11);
                    return this.f8260o;
                }

                @Nullable
                private DefaultImageFieldsModel m9337u() {
                    this.f8261p = (DefaultImageFieldsModel) super.a(this.f8261p, 12, DefaultImageFieldsModel.class);
                    return this.f8261p;
                }

                @Nullable
                private DefaultImageFieldsModel m9338v() {
                    this.f8262q = (DefaultImageFieldsModel) super.a(this.f8262q, 13, DefaultImageFieldsModel.class);
                    return this.f8262q;
                }

                public final boolean mo562j() {
                    a(1, 6);
                    return this.f8263r;
                }

                @Nullable
                private MutualFriendsModel m9339w() {
                    this.f8264s = (MutualFriendsModel) super.a(this.f8264s, 15, MutualFriendsModel.class);
                    return this.f8264s;
                }

                @Nullable
                public final String mo563k() {
                    this.f8265t = super.a(this.f8265t, 16);
                    return this.f8265t;
                }

                @Nullable
                private SearchResultsPageCTAModel m9340x() {
                    this.f8266u = (SearchResultsPageCTAModel) super.a(this.f8266u, 17, SearchResultsPageCTAModel.class);
                    return this.f8266u;
                }

                @Nullable
                private PageLikersModel m9341y() {
                    this.f8267v = (PageLikersModel) super.a(this.f8267v, 18, PageLikersModel.class);
                    return this.f8267v;
                }

                @Nullable
                private DefaultImageFieldsModel m9342z() {
                    this.f8268w = (DefaultImageFieldsModel) super.a(this.f8268w, 19, DefaultImageFieldsModel.class);
                    return this.f8268w;
                }

                @Nullable
                private SocialContextModel m9320A() {
                    this.f8269x = (SocialContextModel) super.a(this.f8269x, 20, SocialContextModel.class);
                    return this.f8269x;
                }

                @Nullable
                private String m9321B() {
                    this.f8270y = super.a(this.f8270y, 21);
                    return this.f8270y;
                }

                @Nullable
                private GraphQLEventGuestStatus m9322C() {
                    this.f8271z = (GraphQLEventGuestStatus) super.b(this.f8271z, 22, GraphQLEventGuestStatus.class, GraphQLEventGuestStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                    return this.f8271z;
                }

                private void m9325a(GraphQLEventGuestStatus graphQLEventGuestStatus) {
                    this.f8271z = graphQLEventGuestStatus;
                    if (this.b != null && this.b.d) {
                        this.b.a(this.c, 22, graphQLEventGuestStatus != null ? graphQLEventGuestStatus.name() : null);
                    }
                }

                @Nullable
                private GraphQLGroupJoinState m9323D() {
                    this.f8247A = (GraphQLGroupJoinState) super.b(this.f8247A, 23, GraphQLGroupJoinState.class, GraphQLGroupJoinState.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                    return this.f8247A;
                }

                private void m9327a(GraphQLGroupJoinState graphQLGroupJoinState) {
                    this.f8247A = graphQLGroupJoinState;
                    if (this.b != null && this.b.d) {
                        this.b.a(this.c, 23, graphQLGroupJoinState != null ? graphQLGroupJoinState.name() : null);
                    }
                }

                @Nullable
                private VisibilitySentenceModel m9324E() {
                    this.f8248B = (VisibilitySentenceModel) super.a(this.f8248B, 24, VisibilitySentenceModel.class);
                    return this.f8248B;
                }

                @Nullable
                public final String m9345a() {
                    return m9336t();
                }

                public final int jK_() {
                    return 2433570;
                }

                public final GraphQLVisitableModel m9344a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    DefaultImageFieldsModel defaultImageFieldsModel;
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m9330n() != null) {
                        BioTextModel bioTextModel = (BioTextModel) graphQLModelMutatingVisitor.b(m9330n());
                        if (m9330n() != bioTextModel) {
                            graphQLVisitableModel = (NodeModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f8251f = bioTextModel;
                        }
                    }
                    if (m9332p() != null) {
                        CoverPhotoModel coverPhotoModel = (CoverPhotoModel) graphQLModelMutatingVisitor.b(m9332p());
                        if (m9332p() != coverPhotoModel) {
                            graphQLVisitableModel = (NodeModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f8255j = coverPhotoModel;
                        }
                    }
                    if (m9333q() != null) {
                        EventPlaceModel eventPlaceModel = (EventPlaceModel) graphQLModelMutatingVisitor.b(m9333q());
                        if (m9333q() != eventPlaceModel) {
                            graphQLVisitableModel = (NodeModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f8257l = eventPlaceModel;
                        }
                    }
                    if (m9335s() != null) {
                        GroupMembersModel groupMembersModel = (GroupMembersModel) graphQLModelMutatingVisitor.b(m9335s());
                        if (m9335s() != groupMembersModel) {
                            graphQLVisitableModel = (NodeModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f8259n = groupMembersModel;
                        }
                    }
                    if (m9337u() != null) {
                        defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m9337u());
                        if (m9337u() != defaultImageFieldsModel) {
                            graphQLVisitableModel = (NodeModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f8261p = defaultImageFieldsModel;
                        }
                    }
                    if (m9338v() != null) {
                        defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m9338v());
                        if (m9338v() != defaultImageFieldsModel) {
                            graphQLVisitableModel = (NodeModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f8262q = defaultImageFieldsModel;
                        }
                    }
                    if (m9339w() != null) {
                        MutualFriendsModel mutualFriendsModel = (MutualFriendsModel) graphQLModelMutatingVisitor.b(m9339w());
                        if (m9339w() != mutualFriendsModel) {
                            graphQLVisitableModel = (NodeModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f8264s = mutualFriendsModel;
                        }
                    }
                    if (m9340x() != null) {
                        SearchResultsPageCTAModel searchResultsPageCTAModel = (SearchResultsPageCTAModel) graphQLModelMutatingVisitor.b(m9340x());
                        if (m9340x() != searchResultsPageCTAModel) {
                            graphQLVisitableModel = (NodeModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f8266u = searchResultsPageCTAModel;
                        }
                    }
                    if (m9341y() != null) {
                        PageLikersModel pageLikersModel = (PageLikersModel) graphQLModelMutatingVisitor.b(m9341y());
                        if (m9341y() != pageLikersModel) {
                            graphQLVisitableModel = (NodeModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f8267v = pageLikersModel;
                        }
                    }
                    if (m9342z() != null) {
                        defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m9342z());
                        if (m9342z() != defaultImageFieldsModel) {
                            graphQLVisitableModel = (NodeModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f8268w = defaultImageFieldsModel;
                        }
                    }
                    if (m9320A() != null) {
                        SocialContextModel socialContextModel = (SocialContextModel) graphQLModelMutatingVisitor.b(m9320A());
                        if (m9320A() != socialContextModel) {
                            graphQLVisitableModel = (NodeModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f8269x = socialContextModel;
                        }
                    }
                    if (m9324E() != null) {
                        VisibilitySentenceModel visibilitySentenceModel = (VisibilitySentenceModel) graphQLModelMutatingVisitor.b(m9324E());
                        if (m9324E() != visibilitySentenceModel) {
                            graphQLVisitableModel = (NodeModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f8248B = visibilitySentenceModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m9343a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m9328l());
                    int c = flatBufferBuilder.c(m9329m());
                    int a2 = ModelHelper.a(flatBufferBuilder, m9330n());
                    int c2 = flatBufferBuilder.c(m9331o());
                    int a3 = ModelHelper.a(flatBufferBuilder, m9332p());
                    int a4 = ModelHelper.a(flatBufferBuilder, m9333q());
                    int a5 = flatBufferBuilder.a(m9334r());
                    int a6 = ModelHelper.a(flatBufferBuilder, m9335s());
                    int b = flatBufferBuilder.b(m9336t());
                    int a7 = ModelHelper.a(flatBufferBuilder, m9337u());
                    int a8 = ModelHelper.a(flatBufferBuilder, m9338v());
                    int a9 = ModelHelper.a(flatBufferBuilder, m9339w());
                    int b2 = flatBufferBuilder.b(mo563k());
                    int a10 = ModelHelper.a(flatBufferBuilder, m9340x());
                    int a11 = ModelHelper.a(flatBufferBuilder, m9341y());
                    int a12 = ModelHelper.a(flatBufferBuilder, m9342z());
                    int a13 = ModelHelper.a(flatBufferBuilder, m9320A());
                    int b3 = flatBufferBuilder.b(m9321B());
                    int a14 = flatBufferBuilder.a(m9322C());
                    int a15 = flatBufferBuilder.a(m9323D());
                    int a16 = ModelHelper.a(flatBufferBuilder, m9324E());
                    flatBufferBuilder.c(25);
                    flatBufferBuilder.b(0, a);
                    flatBufferBuilder.b(1, c);
                    flatBufferBuilder.b(2, a2);
                    flatBufferBuilder.a(3, this.f8252g);
                    flatBufferBuilder.a(4, this.f8253h);
                    flatBufferBuilder.b(5, c2);
                    flatBufferBuilder.b(6, a3);
                    flatBufferBuilder.a(7, this.f8256k);
                    flatBufferBuilder.b(8, a4);
                    flatBufferBuilder.b(9, a5);
                    flatBufferBuilder.b(10, a6);
                    flatBufferBuilder.b(11, b);
                    flatBufferBuilder.b(12, a7);
                    flatBufferBuilder.b(13, a8);
                    flatBufferBuilder.a(14, this.f8263r);
                    flatBufferBuilder.b(15, a9);
                    flatBufferBuilder.b(16, b2);
                    flatBufferBuilder.b(17, a10);
                    flatBufferBuilder.b(18, a11);
                    flatBufferBuilder.b(19, a12);
                    flatBufferBuilder.b(20, a13);
                    flatBufferBuilder.b(21, b3);
                    flatBufferBuilder.b(22, a14);
                    flatBufferBuilder.b(23, a15);
                    flatBufferBuilder.b(24, a16);
                    i();
                    return flatBufferBuilder.d();
                }

                public final void m9346a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                    super.a(mutableFlatBuffer, i, obj);
                    this.f8252g = mutableFlatBuffer.a(i, 3);
                    this.f8253h = mutableFlatBuffer.a(i, 4);
                    this.f8256k = mutableFlatBuffer.a(i, 7);
                    this.f8263r = mutableFlatBuffer.a(i, 14);
                }
            }

            /* compiled from: native_article_close */
            public class Serializer extends JsonSerializer<EdgesModel> {
                public final void m9351a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    EdgesModel edgesModel = (EdgesModel) obj;
                    if (edgesModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(edgesModel.m9354a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        edgesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    EdgesParser.m9382b(edgesModel.w_(), edgesModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(EdgesModel.class, new Serializer());
                }
            }

            public EdgesModel() {
                super(2);
            }

            @Nullable
            private NodeModel m9352a() {
                this.f8272d = (NodeModel) super.a(this.f8272d, 0, NodeModel.class);
                return this.f8272d;
            }

            @Nullable
            private SearchResultsDecorationModel m9353j() {
                this.f8273e = (SearchResultsDecorationModel) super.a(this.f8273e, 1, SearchResultsDecorationModel.class);
                return this.f8273e;
            }

            public final int jK_() {
                return -316863363;
            }

            public final GraphQLVisitableModel m9355a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m9352a() != null) {
                    NodeModel nodeModel = (NodeModel) graphQLModelMutatingVisitor.b(m9352a());
                    if (m9352a() != nodeModel) {
                        graphQLVisitableModel = (EdgesModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f8272d = nodeModel;
                    }
                }
                if (m9353j() != null) {
                    SearchResultsDecorationModel searchResultsDecorationModel = (SearchResultsDecorationModel) graphQLModelMutatingVisitor.b(m9353j());
                    if (m9353j() != searchResultsDecorationModel) {
                        graphQLVisitableModel = (EdgesModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f8273e = searchResultsDecorationModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m9354a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m9352a());
                int a2 = ModelHelper.a(flatBufferBuilder, m9353j());
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, a2);
                i();
                return flatBufferBuilder.d();
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -2005169142)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: native_article_close */
        public final class PageInfoModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private String f8274d;
            private boolean f8275e;

            /* compiled from: native_article_close */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(PageInfoModel.class, new Deserializer());
                }

                public Object m9356a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(PageInfoParser.m9383a(jsonParser, flatBufferBuilder));
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

            /* compiled from: native_article_close */
            public class Serializer extends JsonSerializer<PageInfoModel> {
                public final void m9357a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    PageInfoModel pageInfoModel = (PageInfoModel) obj;
                    if (pageInfoModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(pageInfoModel.m9359a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        pageInfoModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    PageInfoParser.m9384a(pageInfoModel.w_(), pageInfoModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(PageInfoModel.class, new Serializer());
                }
            }

            public PageInfoModel() {
                super(2);
            }

            @Nullable
            private String m9358a() {
                this.f8274d = super.a(this.f8274d, 0);
                return this.f8274d;
            }

            public final int jK_() {
                return 923779069;
            }

            public final GraphQLVisitableModel m9360a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m9359a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m9358a());
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.a(1, this.f8275e);
                i();
                return flatBufferBuilder.d();
            }

            public final void m9361a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f8275e = mutableFlatBuffer.a(i, 1);
            }
        }

        /* compiled from: native_article_close */
        public class Serializer extends JsonSerializer<FBGraphSearchQueryResultFragmentModel> {
            public final void m9362a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                FBGraphSearchQueryResultFragmentModel fBGraphSearchQueryResultFragmentModel = (FBGraphSearchQueryResultFragmentModel) obj;
                if (fBGraphSearchQueryResultFragmentModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(fBGraphSearchQueryResultFragmentModel.m9365a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    fBGraphSearchQueryResultFragmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                FBGraphSearchQueryResultFragmentParser.m9386a(fBGraphSearchQueryResultFragmentModel.w_(), fBGraphSearchQueryResultFragmentModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(FBGraphSearchQueryResultFragmentModel.class, new Serializer());
            }
        }

        public FBGraphSearchQueryResultFragmentModel() {
            super(2);
        }

        @Nonnull
        private ImmutableList<EdgesModel> m9363a() {
            this.f8276d = super.a(this.f8276d, 0, EdgesModel.class);
            return (ImmutableList) this.f8276d;
        }

        @Nullable
        private PageInfoModel m9364j() {
            this.f8277e = (PageInfoModel) super.a(this.f8277e, 1, PageInfoModel.class);
            return this.f8277e;
        }

        public final int jK_() {
            return 1580207518;
        }

        public final GraphQLVisitableModel m9366a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel;
            PageInfoModel pageInfoModel;
            h();
            if (m9363a() != null) {
                Builder a = ModelHelper.a(m9363a(), graphQLModelMutatingVisitor);
                if (a != null) {
                    FBGraphSearchQueryResultFragmentModel fBGraphSearchQueryResultFragmentModel = (FBGraphSearchQueryResultFragmentModel) ModelHelper.a(null, this);
                    fBGraphSearchQueryResultFragmentModel.f8276d = a.b();
                    graphQLVisitableModel = fBGraphSearchQueryResultFragmentModel;
                    if (m9364j() != null) {
                        pageInfoModel = (PageInfoModel) graphQLModelMutatingVisitor.b(m9364j());
                        if (m9364j() != pageInfoModel) {
                            graphQLVisitableModel = (FBGraphSearchQueryResultFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f8277e = pageInfoModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel != null ? this : graphQLVisitableModel;
                }
            }
            graphQLVisitableModel = null;
            if (m9364j() != null) {
                pageInfoModel = (PageInfoModel) graphQLModelMutatingVisitor.b(m9364j());
                if (m9364j() != pageInfoModel) {
                    graphQLVisitableModel = (FBGraphSearchQueryResultFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f8277e = pageInfoModel;
                }
            }
            i();
            if (graphQLVisitableModel != null) {
            }
        }

        public final int m9365a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m9363a());
            int a2 = ModelHelper.a(flatBufferBuilder, m9364j());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            i();
            return flatBufferBuilder.d();
        }
    }
}
