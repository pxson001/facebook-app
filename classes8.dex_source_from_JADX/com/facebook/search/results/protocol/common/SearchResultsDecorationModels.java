package com.facebook.search.results.protocol.common;

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
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.search.results.protocol.common.SearchResultsDecorationParsers.SearchResultsDecorationParser;
import com.facebook.search.results.protocol.common.SearchResultsDecorationParsers.SearchResultsSnippetParser;
import com.facebook.search.results.protocol.common.SearchResultsDecorationParsers.SearchResultsSnippetParser.SentenceParser;
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

/* compiled from: min_suggested_page_count */
public class SearchResultsDecorationModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1415469936)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: min_suggested_page_count */
    public final class SearchResultsDecorationModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private List<SearchResultsSnippetModel> f8581d;
        @Nullable
        private List<SearchResultsSnippetModel> f8582e;
        @Nullable
        private List<SearchResultsSnippetModel> f8583f;
        @Nullable
        private String f8584g;
        @Nullable
        private SearchResultsSnippetModel f8585h;
        @Nullable
        private SearchResultsSnippetModel f8586i;

        /* compiled from: min_suggested_page_count */
        public final class Builder {
            @Nullable
            public ImmutableList<SearchResultsSnippetModel> f8575a;
            @Nullable
            public ImmutableList<SearchResultsSnippetModel> f8576b;
            @Nullable
            public ImmutableList<SearchResultsSnippetModel> f8577c;
            @Nullable
            public String f8578d;
            @Nullable
            public SearchResultsSnippetModel f8579e;
            @Nullable
            public SearchResultsSnippetModel f8580f;

            public final SearchResultsDecorationModel m9851a() {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int a = ModelHelper.a(flatBufferBuilder, this.f8575a);
                int a2 = ModelHelper.a(flatBufferBuilder, this.f8576b);
                int a3 = ModelHelper.a(flatBufferBuilder, this.f8577c);
                int b = flatBufferBuilder.b(this.f8578d);
                int a4 = ModelHelper.a(flatBufferBuilder, this.f8579e);
                int a5 = ModelHelper.a(flatBufferBuilder, this.f8580f);
                flatBufferBuilder.c(6);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, a2);
                flatBufferBuilder.b(2, a3);
                flatBufferBuilder.b(3, b);
                flatBufferBuilder.b(4, a4);
                flatBufferBuilder.b(5, a5);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new SearchResultsDecorationModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }
        }

        /* compiled from: min_suggested_page_count */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(SearchResultsDecorationModel.class, new Deserializer());
            }

            public Object m9852a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(SearchResultsDecorationParser.m9877a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object searchResultsDecorationModel = new SearchResultsDecorationModel();
                ((BaseModel) searchResultsDecorationModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (searchResultsDecorationModel instanceof Postprocessable) {
                    return ((Postprocessable) searchResultsDecorationModel).a();
                }
                return searchResultsDecorationModel;
            }
        }

        /* compiled from: min_suggested_page_count */
        public class Serializer extends JsonSerializer<SearchResultsDecorationModel> {
            public final void m9853a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                SearchResultsDecorationModel searchResultsDecorationModel = (SearchResultsDecorationModel) obj;
                if (searchResultsDecorationModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(searchResultsDecorationModel.m9857a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    searchResultsDecorationModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                SearchResultsDecorationParser.m9878a(searchResultsDecorationModel.w_(), searchResultsDecorationModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(SearchResultsDecorationModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ SearchResultsSnippetModel m9863g() {
            return m9856k();
        }

        @Nullable
        public final /* synthetic */ SearchResultsSnippetModel jm_() {
            return m9855j();
        }

        public SearchResultsDecorationModel() {
            super(6);
        }

        public SearchResultsDecorationModel(MutableFlatBuffer mutableFlatBuffer) {
            super(6);
            a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }

        @Nonnull
        public final ImmutableList<SearchResultsSnippetModel> m9859a() {
            this.f8581d = super.a(this.f8581d, 0, SearchResultsSnippetModel.class);
            return (ImmutableList) this.f8581d;
        }

        @Nonnull
        public final ImmutableList<SearchResultsSnippetModel> m9860b() {
            this.f8582e = super.a(this.f8582e, 1, SearchResultsSnippetModel.class);
            return (ImmutableList) this.f8582e;
        }

        @Nonnull
        public final ImmutableList<SearchResultsSnippetModel> m9861c() {
            this.f8583f = super.a(this.f8583f, 2, SearchResultsSnippetModel.class);
            return (ImmutableList) this.f8583f;
        }

        @Nullable
        public final String m9862d() {
            this.f8584g = super.a(this.f8584g, 3);
            return this.f8584g;
        }

        @Nullable
        private SearchResultsSnippetModel m9855j() {
            this.f8585h = (SearchResultsSnippetModel) super.a(this.f8585h, 4, SearchResultsSnippetModel.class);
            return this.f8585h;
        }

        @Nullable
        private SearchResultsSnippetModel m9856k() {
            this.f8586i = (SearchResultsSnippetModel) super.a(this.f8586i, 5, SearchResultsSnippetModel.class);
            return this.f8586i;
        }

        public static SearchResultsDecorationModel m9854a(SearchResultsDecorationModel searchResultsDecorationModel) {
            int i = 0;
            if (searchResultsDecorationModel == null) {
                return null;
            }
            if (searchResultsDecorationModel instanceof SearchResultsDecorationModel) {
                return searchResultsDecorationModel;
            }
            int i2;
            Builder builder = new Builder();
            com.google.common.collect.ImmutableList.Builder builder2 = ImmutableList.builder();
            for (i2 = 0; i2 < searchResultsDecorationModel.m9859a().size(); i2++) {
                builder2.c(SearchResultsSnippetModel.m9872a((SearchResultsSnippetModel) searchResultsDecorationModel.m9859a().get(i2)));
            }
            builder.f8575a = builder2.b();
            builder2 = ImmutableList.builder();
            for (i2 = 0; i2 < searchResultsDecorationModel.m9860b().size(); i2++) {
                builder2.c(SearchResultsSnippetModel.m9872a((SearchResultsSnippetModel) searchResultsDecorationModel.m9860b().get(i2)));
            }
            builder.f8576b = builder2.b();
            com.google.common.collect.ImmutableList.Builder builder3 = ImmutableList.builder();
            while (i < searchResultsDecorationModel.m9861c().size()) {
                builder3.c(SearchResultsSnippetModel.m9872a((SearchResultsSnippetModel) searchResultsDecorationModel.m9861c().get(i)));
                i++;
            }
            builder.f8577c = builder3.b();
            builder.f8578d = searchResultsDecorationModel.m9862d();
            builder.f8579e = SearchResultsSnippetModel.m9872a(searchResultsDecorationModel.jm_());
            builder.f8580f = SearchResultsSnippetModel.m9872a(searchResultsDecorationModel.m9863g());
            return builder.m9851a();
        }

        public final int jK_() {
            return 379010371;
        }

        public final GraphQLVisitableModel m9858a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            com.google.common.collect.ImmutableList.Builder a;
            SearchResultsSnippetModel searchResultsSnippetModel;
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m9859a() != null) {
                a = ModelHelper.a(m9859a(), graphQLModelMutatingVisitor);
                if (a != null) {
                    graphQLVisitableModel = (SearchResultsDecorationModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f8581d = a.b();
                }
            }
            if (m9860b() != null) {
                a = ModelHelper.a(m9860b(), graphQLModelMutatingVisitor);
                if (a != null) {
                    graphQLVisitableModel = (SearchResultsDecorationModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f8582e = a.b();
                }
            }
            if (m9861c() != null) {
                a = ModelHelper.a(m9861c(), graphQLModelMutatingVisitor);
                if (a != null) {
                    graphQLVisitableModel = (SearchResultsDecorationModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f8583f = a.b();
                }
            }
            GraphQLVisitableModel graphQLVisitableModel2 = graphQLVisitableModel;
            if (m9855j() != null) {
                searchResultsSnippetModel = (SearchResultsSnippetModel) graphQLModelMutatingVisitor.b(m9855j());
                if (m9855j() != searchResultsSnippetModel) {
                    graphQLVisitableModel2 = (SearchResultsDecorationModel) ModelHelper.a(graphQLVisitableModel2, this);
                    graphQLVisitableModel2.f8585h = searchResultsSnippetModel;
                }
            }
            if (m9856k() != null) {
                searchResultsSnippetModel = (SearchResultsSnippetModel) graphQLModelMutatingVisitor.b(m9856k());
                if (m9856k() != searchResultsSnippetModel) {
                    graphQLVisitableModel2 = (SearchResultsDecorationModel) ModelHelper.a(graphQLVisitableModel2, this);
                    graphQLVisitableModel2.f8586i = searchResultsSnippetModel;
                }
            }
            i();
            return graphQLVisitableModel2 == null ? this : graphQLVisitableModel2;
        }

        public final int m9857a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m9859a());
            int a2 = ModelHelper.a(flatBufferBuilder, m9860b());
            int a3 = ModelHelper.a(flatBufferBuilder, m9861c());
            int b = flatBufferBuilder.b(m9862d());
            int a4 = ModelHelper.a(flatBufferBuilder, m9855j());
            int a5 = ModelHelper.a(flatBufferBuilder, m9856k());
            flatBufferBuilder.c(6);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            flatBufferBuilder.b(2, a3);
            flatBufferBuilder.b(3, b);
            flatBufferBuilder.b(4, a4);
            flatBufferBuilder.b(5, a5);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1999976020)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: min_suggested_page_count */
    public final class SearchResultsSnippetModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private SentenceModel f8590d;

        /* compiled from: min_suggested_page_count */
        public final class Builder {
            @Nullable
            public SentenceModel f8587a;
        }

        /* compiled from: min_suggested_page_count */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(SearchResultsSnippetModel.class, new Deserializer());
            }

            public Object m9864a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(SearchResultsSnippetParser.m9881a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object searchResultsSnippetModel = new SearchResultsSnippetModel();
                ((BaseModel) searchResultsSnippetModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (searchResultsSnippetModel instanceof Postprocessable) {
                    return ((Postprocessable) searchResultsSnippetModel).a();
                }
                return searchResultsSnippetModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1352864475)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: min_suggested_page_count */
        public final class SentenceModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private String f8589d;

            /* compiled from: min_suggested_page_count */
            public final class Builder {
                @Nullable
                public String f8588a;
            }

            /* compiled from: min_suggested_page_count */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(SentenceModel.class, new Deserializer());
                }

                public Object m9865a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(SentenceParser.m9879a(jsonParser, flatBufferBuilder));
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

            /* compiled from: min_suggested_page_count */
            public class Serializer extends JsonSerializer<SentenceModel> {
                public final void m9866a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    SentenceModel sentenceModel = (SentenceModel) obj;
                    if (sentenceModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(sentenceModel.m9868a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        sentenceModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    SentenceParser.m9880a(sentenceModel.w_(), sentenceModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(SentenceModel.class, new Serializer());
                }
            }

            public SentenceModel() {
                super(1);
            }

            public SentenceModel(MutableFlatBuffer mutableFlatBuffer) {
                super(1);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            @Nullable
            public final String m9870a() {
                this.f8589d = super.a(this.f8589d, 0);
                return this.f8589d;
            }

            public static SentenceModel m9867a(SentenceModel sentenceModel) {
                if (sentenceModel == null) {
                    return null;
                }
                if (sentenceModel instanceof SentenceModel) {
                    return sentenceModel;
                }
                Builder builder = new Builder();
                builder.f8588a = sentenceModel.m9870a();
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int b = flatBufferBuilder.b(builder.f8588a);
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new SentenceModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }

            public final int jK_() {
                return -1919764332;
            }

            public final GraphQLVisitableModel m9869a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m9868a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m9870a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: min_suggested_page_count */
        public class Serializer extends JsonSerializer<SearchResultsSnippetModel> {
            public final void m9871a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                SearchResultsSnippetModel searchResultsSnippetModel = (SearchResultsSnippetModel) obj;
                if (searchResultsSnippetModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(searchResultsSnippetModel.m9874a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    searchResultsSnippetModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                SearchResultsSnippetParser.m9884b(searchResultsSnippetModel.w_(), searchResultsSnippetModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(SearchResultsSnippetModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ SentenceModel m9876a() {
            return m9873j();
        }

        public SearchResultsSnippetModel() {
            super(1);
        }

        public SearchResultsSnippetModel(MutableFlatBuffer mutableFlatBuffer) {
            super(1);
            a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }

        @Nullable
        private SentenceModel m9873j() {
            this.f8590d = (SentenceModel) super.a(this.f8590d, 0, SentenceModel.class);
            return this.f8590d;
        }

        public static SearchResultsSnippetModel m9872a(SearchResultsSnippetModel searchResultsSnippetModel) {
            if (searchResultsSnippetModel == null) {
                return null;
            }
            if (searchResultsSnippetModel instanceof SearchResultsSnippetModel) {
                return searchResultsSnippetModel;
            }
            Builder builder = new Builder();
            builder.f8587a = SentenceModel.m9867a(searchResultsSnippetModel.m9876a());
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            int a = ModelHelper.a(flatBufferBuilder, builder.f8587a);
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.d(flatBufferBuilder.d());
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            return new SearchResultsSnippetModel(new MutableFlatBuffer(wrap, null, null, true, null));
        }

        public final int jK_() {
            return -38981689;
        }

        public final GraphQLVisitableModel m9875a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m9873j() != null) {
                SentenceModel sentenceModel = (SentenceModel) graphQLModelMutatingVisitor.b(m9873j());
                if (m9873j() != sentenceModel) {
                    graphQLVisitableModel = (SearchResultsSnippetModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f8590d = sentenceModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m9874a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m9873j());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }
}
