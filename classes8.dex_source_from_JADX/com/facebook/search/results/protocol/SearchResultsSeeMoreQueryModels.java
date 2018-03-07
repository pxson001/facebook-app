package com.facebook.search.results.protocol;

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
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.search.results.protocol.SearchResultsSeeMoreQueryParsers.SearchResultsSeeMoreQueryParser;
import com.facebook.search.results.protocol.SearchResultsSeeMoreQueryParsers.SearchResultsSeeMoreQueryParser.QueryTitleParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.google.common.collect.ImmutableList;
import java.nio.ByteBuffer;
import java.util.List;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/* compiled from: mini_preview_generator */
public class SearchResultsSeeMoreQueryModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1257420923)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: mini_preview_generator */
    public final class SearchResultsSeeMoreQueryModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private String f8572d;
        @Nullable
        private QueryTitleModel f8573e;
        @Nullable
        private List<GraphQLGraphSearchResultsDisplayStyle> f8574f;

        /* compiled from: mini_preview_generator */
        public final class Builder {
            @Nullable
            public String f8567a;
            @Nullable
            public QueryTitleModel f8568b;
            @Nullable
            public ImmutableList<GraphQLGraphSearchResultsDisplayStyle> f8569c;

            public final SearchResultsSeeMoreQueryModel m9830a() {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int b = flatBufferBuilder.b(this.f8567a);
                int a = ModelHelper.a(flatBufferBuilder, this.f8568b);
                int d = flatBufferBuilder.d(this.f8569c);
                flatBufferBuilder.c(3);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.b(1, a);
                flatBufferBuilder.b(2, d);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new SearchResultsSeeMoreQueryModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }
        }

        /* compiled from: mini_preview_generator */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(SearchResultsSeeMoreQueryModel.class, new Deserializer());
            }

            public Object m9831a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(SearchResultsSeeMoreQueryParser.m9849a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object searchResultsSeeMoreQueryModel = new SearchResultsSeeMoreQueryModel();
                ((BaseModel) searchResultsSeeMoreQueryModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (searchResultsSeeMoreQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) searchResultsSeeMoreQueryModel).a();
                }
                return searchResultsSeeMoreQueryModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1352864475)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: mini_preview_generator */
        public final class QueryTitleModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private String f8571d;

            /* compiled from: mini_preview_generator */
            public final class Builder {
                @Nullable
                public String f8570a;

                public final QueryTitleModel m9832a() {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    int b = flatBufferBuilder.b(this.f8570a);
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, b);
                    flatBufferBuilder.d(flatBufferBuilder.d());
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    return new QueryTitleModel(new MutableFlatBuffer(wrap, null, null, true, null));
                }
            }

            /* compiled from: mini_preview_generator */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(QueryTitleModel.class, new Deserializer());
                }

                public Object m9833a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(QueryTitleParser.m9847a(jsonParser, flatBufferBuilder));
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

            /* compiled from: mini_preview_generator */
            public class Serializer extends JsonSerializer<QueryTitleModel> {
                public final void m9834a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    QueryTitleModel queryTitleModel = (QueryTitleModel) obj;
                    if (queryTitleModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(queryTitleModel.m9836a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        queryTitleModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    QueryTitleParser.m9848a(queryTitleModel.w_(), queryTitleModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(QueryTitleModel.class, new Serializer());
                }
            }

            public QueryTitleModel() {
                super(1);
            }

            public QueryTitleModel(MutableFlatBuffer mutableFlatBuffer) {
                super(1);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            @Nullable
            public final String m9838a() {
                this.f8571d = super.a(this.f8571d, 0);
                return this.f8571d;
            }

            public static QueryTitleModel m9835a(QueryTitleModel queryTitleModel) {
                if (queryTitleModel == null) {
                    return null;
                }
                if (queryTitleModel instanceof QueryTitleModel) {
                    return queryTitleModel;
                }
                Builder builder = new Builder();
                builder.f8570a = queryTitleModel.m9838a();
                return builder.m9832a();
            }

            public final int jK_() {
                return -1696096378;
            }

            public final GraphQLVisitableModel m9837a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m9836a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m9838a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: mini_preview_generator */
        public class Serializer extends JsonSerializer<SearchResultsSeeMoreQueryModel> {
            public final void m9839a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                SearchResultsSeeMoreQueryModel searchResultsSeeMoreQueryModel = (SearchResultsSeeMoreQueryModel) obj;
                if (searchResultsSeeMoreQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(searchResultsSeeMoreQueryModel.m9842a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    searchResultsSeeMoreQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                SearchResultsSeeMoreQueryParser.m9850a(searchResultsSeeMoreQueryModel.w_(), searchResultsSeeMoreQueryModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(SearchResultsSeeMoreQueryModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ QueryTitleModel m9845b() {
            return m9841j();
        }

        public SearchResultsSeeMoreQueryModel() {
            super(3);
        }

        public SearchResultsSeeMoreQueryModel(MutableFlatBuffer mutableFlatBuffer) {
            super(3);
            a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }

        @Nullable
        public final String m9844a() {
            this.f8572d = super.a(this.f8572d, 0);
            return this.f8572d;
        }

        @Nullable
        private QueryTitleModel m9841j() {
            this.f8573e = (QueryTitleModel) super.a(this.f8573e, 1, QueryTitleModel.class);
            return this.f8573e;
        }

        @Nonnull
        public final ImmutableList<GraphQLGraphSearchResultsDisplayStyle> m9846c() {
            this.f8574f = super.c(this.f8574f, 2, GraphQLGraphSearchResultsDisplayStyle.class);
            return (ImmutableList) this.f8574f;
        }

        public static SearchResultsSeeMoreQueryModel m9840a(SearchResultsSeeMoreQueryModel searchResultsSeeMoreQueryModel) {
            if (searchResultsSeeMoreQueryModel == null) {
                return null;
            }
            if (searchResultsSeeMoreQueryModel instanceof SearchResultsSeeMoreQueryModel) {
                return searchResultsSeeMoreQueryModel;
            }
            Builder builder = new Builder();
            builder.f8567a = searchResultsSeeMoreQueryModel.m9844a();
            builder.f8568b = QueryTitleModel.m9835a(searchResultsSeeMoreQueryModel.m9845b());
            com.google.common.collect.ImmutableList.Builder builder2 = ImmutableList.builder();
            for (int i = 0; i < searchResultsSeeMoreQueryModel.m9846c().size(); i++) {
                builder2.c(searchResultsSeeMoreQueryModel.m9846c().get(i));
            }
            builder.f8569c = builder2.b();
            return builder.m9830a();
        }

        public final int jK_() {
            return -466486798;
        }

        public final GraphQLVisitableModel m9843a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m9841j() != null) {
                QueryTitleModel queryTitleModel = (QueryTitleModel) graphQLModelMutatingVisitor.b(m9841j());
                if (m9841j() != queryTitleModel) {
                    graphQLVisitableModel = (SearchResultsSeeMoreQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f8573e = queryTitleModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m9842a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m9844a());
            int a = ModelHelper.a(flatBufferBuilder, m9841j());
            int d = flatBufferBuilder.d(m9846c());
            flatBufferBuilder.c(3);
            flatBufferBuilder.b(0, b);
            flatBufferBuilder.b(1, a);
            flatBufferBuilder.b(2, d);
            i();
            return flatBufferBuilder.d();
        }
    }
}
