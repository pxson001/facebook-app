package com.facebook.search.results.protocol;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.querybuilder.common.CommonGraphQL2Interfaces.DefaultPageInfoTailFields;
import com.facebook.graphql.querybuilder.common.CommonGraphQL2Models.DefaultPageInfoTailFieldsModel;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel;
import com.facebook.search.results.protocol.SearchResultsGraphQLParsers.SearchResultsGraphQLParser;
import com.facebook.search.results.protocol.SearchResultsGraphQLParsers.SearchResultsGraphQLParser.CombinedResultsParser;
import com.facebook.search.results.protocol.SearchResultsMetaDataInterfaces.SearchResultsMetaData;
import com.facebook.search.results.protocol.filters.SearchResultPageFilterFragmentsModels.SearchResultPageFiltersFragmentModel;
import com.facebook.search.results.protocol.filters.SearchResultPageFilterFragmentsParsers.SearchResultPageFiltersFragmentParser;
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

/* compiled from: mms_id */
public class SearchResultsGraphQLModels {

    @FragmentModelWithBridge
    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 339514615)
    @JsonSerialize(using = Serializer.class)
    /* compiled from: mms_id */
    public final class SearchResultsGraphQLModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private CombinedResultsModel f8565d;
        @Nullable
        private List<SearchResultPageFiltersFragmentModel> f8566e;

        @FragmentModelWithBridge
        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1857566213)
        @JsonSerialize(using = Serializer.class)
        /* compiled from: mms_id */
        public final class CombinedResultsModel extends BaseModel implements GraphQLVisitableModel, SearchResultsMetaData {
            @Nullable
            private List<SearchResultsEdgeModel> f8560d;
            @Nullable
            private DefaultPageInfoTailFieldsModel f8561e;
            @Nullable
            private String f8562f;
            @Nullable
            private String f8563g;
            @Nullable
            private String f8564h;

            /* compiled from: mms_id */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(CombinedResultsModel.class, new Deserializer());
                }

                public Object m9811a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(CombinedResultsParser.m9827a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object combinedResultsModel = new CombinedResultsModel();
                    ((BaseModel) combinedResultsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (combinedResultsModel instanceof Postprocessable) {
                        return ((Postprocessable) combinedResultsModel).a();
                    }
                    return combinedResultsModel;
                }
            }

            /* compiled from: mms_id */
            public class Serializer extends JsonSerializer<CombinedResultsModel> {
                public final void m9812a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    CombinedResultsModel combinedResultsModel = (CombinedResultsModel) obj;
                    if (combinedResultsModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(combinedResultsModel.m9814a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        combinedResultsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    CombinedResultsParser.m9828a(combinedResultsModel.w_(), combinedResultsModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(CombinedResultsModel.class, new Serializer());
                }
            }

            @Nullable
            public final /* synthetic */ DefaultPageInfoTailFields m9817b() {
                return m9813m();
            }

            public CombinedResultsModel() {
                super(5);
            }

            @Nonnull
            public final ImmutableList<SearchResultsEdgeModel> m9816a() {
                this.f8560d = super.a(this.f8560d, 0, SearchResultsEdgeModel.class);
                return (ImmutableList) this.f8560d;
            }

            @Nullable
            private DefaultPageInfoTailFieldsModel m9813m() {
                this.f8561e = (DefaultPageInfoTailFieldsModel) super.a(this.f8561e, 1, DefaultPageInfoTailFieldsModel.class);
                return this.f8561e;
            }

            @Nullable
            public final String mo594j() {
                this.f8562f = super.a(this.f8562f, 2);
                return this.f8562f;
            }

            @Nullable
            public final String mo595k() {
                this.f8563g = super.a(this.f8563g, 3);
                return this.f8563g;
            }

            @Nullable
            public final String mo596l() {
                this.f8564h = super.a(this.f8564h, 4);
                return this.f8564h;
            }

            public final int jK_() {
                return 565123591;
            }

            public final GraphQLVisitableModel m9815a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel;
                DefaultPageInfoTailFieldsModel defaultPageInfoTailFieldsModel;
                h();
                if (m9816a() != null) {
                    Builder a = ModelHelper.a(m9816a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        CombinedResultsModel combinedResultsModel = (CombinedResultsModel) ModelHelper.a(null, this);
                        combinedResultsModel.f8560d = a.b();
                        graphQLVisitableModel = combinedResultsModel;
                        if (m9813m() != null) {
                            defaultPageInfoTailFieldsModel = (DefaultPageInfoTailFieldsModel) graphQLModelMutatingVisitor.b(m9813m());
                            if (m9813m() != defaultPageInfoTailFieldsModel) {
                                graphQLVisitableModel = (CombinedResultsModel) ModelHelper.a(graphQLVisitableModel, this);
                                graphQLVisitableModel.f8561e = defaultPageInfoTailFieldsModel;
                            }
                        }
                        i();
                        return graphQLVisitableModel != null ? this : graphQLVisitableModel;
                    }
                }
                graphQLVisitableModel = null;
                if (m9813m() != null) {
                    defaultPageInfoTailFieldsModel = (DefaultPageInfoTailFieldsModel) graphQLModelMutatingVisitor.b(m9813m());
                    if (m9813m() != defaultPageInfoTailFieldsModel) {
                        graphQLVisitableModel = (CombinedResultsModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f8561e = defaultPageInfoTailFieldsModel;
                    }
                }
                i();
                if (graphQLVisitableModel != null) {
                }
            }

            public final int m9814a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m9816a());
                int a2 = ModelHelper.a(flatBufferBuilder, m9813m());
                int b = flatBufferBuilder.b(mo594j());
                int b2 = flatBufferBuilder.b(mo595k());
                int b3 = flatBufferBuilder.b(mo596l());
                flatBufferBuilder.c(5);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, a2);
                flatBufferBuilder.b(2, b);
                flatBufferBuilder.b(3, b2);
                flatBufferBuilder.b(4, b3);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: mms_id */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(SearchResultsGraphQLModel.class, new Deserializer());
            }

            public Object m9821a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = SearchResultsGraphQLParser.m9829a(jsonParser);
                Object searchResultsGraphQLModel = new SearchResultsGraphQLModel();
                ((BaseModel) searchResultsGraphQLModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (searchResultsGraphQLModel instanceof Postprocessable) {
                    return ((Postprocessable) searchResultsGraphQLModel).a();
                }
                return searchResultsGraphQLModel;
            }
        }

        /* compiled from: mms_id */
        public class Serializer extends JsonSerializer<SearchResultsGraphQLModel> {
            public final void m9822a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                SearchResultsGraphQLModel searchResultsGraphQLModel = (SearchResultsGraphQLModel) obj;
                if (searchResultsGraphQLModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(searchResultsGraphQLModel.m9823a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    searchResultsGraphQLModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = searchResultsGraphQLModel.w_();
                int u_ = searchResultsGraphQLModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("combined_results");
                    CombinedResultsParser.m9828a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(u_, 1);
                if (g != 0) {
                    jsonGenerator.a("filter_type_sets");
                    SearchResultPageFiltersFragmentParser.m10212a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(SearchResultsGraphQLModel.class, new Serializer());
            }
        }

        public SearchResultsGraphQLModel() {
            super(2);
        }

        @Nullable
        public final CombinedResultsModel m9825a() {
            this.f8565d = (CombinedResultsModel) super.a(this.f8565d, 0, CombinedResultsModel.class);
            return this.f8565d;
        }

        @Nonnull
        public final ImmutableList<SearchResultPageFiltersFragmentModel> m9826j() {
            this.f8566e = super.a(this.f8566e, 1, SearchResultPageFiltersFragmentModel.class);
            return (ImmutableList) this.f8566e;
        }

        public final int jK_() {
            return -466486798;
        }

        public final GraphQLVisitableModel m9824a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m9825a() != null) {
                CombinedResultsModel combinedResultsModel = (CombinedResultsModel) graphQLModelMutatingVisitor.b(m9825a());
                if (m9825a() != combinedResultsModel) {
                    graphQLVisitableModel = (SearchResultsGraphQLModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f8565d = combinedResultsModel;
                }
            }
            if (m9826j() != null) {
                Builder a = ModelHelper.a(m9826j(), graphQLModelMutatingVisitor);
                if (a != null) {
                    SearchResultsGraphQLModel searchResultsGraphQLModel = (SearchResultsGraphQLModel) ModelHelper.a(graphQLVisitableModel, this);
                    searchResultsGraphQLModel.f8566e = a.b();
                    graphQLVisitableModel = searchResultsGraphQLModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m9823a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m9825a());
            int a2 = ModelHelper.a(flatBufferBuilder, m9826j());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            i();
            return flatBufferBuilder.d();
        }
    }
}
