package com.facebook.search.results.protocol.filters;

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
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.search.results.protocol.filters.SearchResultPageFilterFragmentsInterfaces.SearchResultPageFilterValuesFragment;
import com.facebook.search.results.protocol.filters.SearchResultPageFilterFragmentsParsers.SearchResultPageFilterValueNodeFragmentParser;
import com.facebook.search.results.protocol.filters.SearchResultPageFilterFragmentsParsers.SearchResultPageFilterValuesFragmentParser;
import com.facebook.search.results.protocol.filters.SearchResultPageFilterFragmentsParsers.SearchResultPageFilterValuesFragmentParser.FilterValuesParser;
import com.facebook.search.results.protocol.filters.SearchResultPageFilterFragmentsParsers.SearchResultPageFilterValuesFragmentParser.FilterValuesParser.EdgesParser;
import com.facebook.search.results.protocol.filters.SearchResultPageFilterFragmentsParsers.SearchResultPageFiltersFragmentParser;
import com.facebook.search.results.protocol.filters.SearchResultPageFilterFragmentsParsers.SearchResultPageMainFilterFragmentParser;
import com.facebook.search.results.protocol.filters.SearchResultPageFilterFragmentsParsers.SearchResultPageMainFilterFragmentParser.MainFilterParser;
import com.facebook.search.results.protocol.filters.SearchResultPageFilterFragmentsParsers.SearchResultsPageFilterCustomPageValueParser;
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

/* compiled from: method/messaging.setthreadimage */
public class SearchResultPageFilterFragmentsModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1539720257)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: method/messaging.setthreadimage */
    public final class SearchResultPageFilterValueNodeFragmentModel extends BaseModel implements GraphQLVisitableModel {
        private boolean f8698d;
        @Nullable
        private String f8699e;
        @Nullable
        private String f8700f;

        /* compiled from: method/messaging.setthreadimage */
        public final class Builder {
            public boolean f8695a;
            @Nullable
            public String f8696b;
            @Nullable
            public String f8697c;

            public final SearchResultPageFilterValueNodeFragmentModel m10140a() {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int b = flatBufferBuilder.b(this.f8696b);
                int b2 = flatBufferBuilder.b(this.f8697c);
                flatBufferBuilder.c(3);
                flatBufferBuilder.a(0, this.f8695a);
                flatBufferBuilder.b(1, b);
                flatBufferBuilder.b(2, b2);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new SearchResultPageFilterValueNodeFragmentModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }
        }

        /* compiled from: method/messaging.setthreadimage */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(SearchResultPageFilterValueNodeFragmentModel.class, new Deserializer());
            }

            public Object m10141a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(SearchResultPageFilterValueNodeFragmentParser.m10204a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object searchResultPageFilterValueNodeFragmentModel = new SearchResultPageFilterValueNodeFragmentModel();
                ((BaseModel) searchResultPageFilterValueNodeFragmentModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (searchResultPageFilterValueNodeFragmentModel instanceof Postprocessable) {
                    return ((Postprocessable) searchResultPageFilterValueNodeFragmentModel).a();
                }
                return searchResultPageFilterValueNodeFragmentModel;
            }
        }

        /* compiled from: method/messaging.setthreadimage */
        public class Serializer extends JsonSerializer<SearchResultPageFilterValueNodeFragmentModel> {
            public final void m10142a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                SearchResultPageFilterValueNodeFragmentModel searchResultPageFilterValueNodeFragmentModel = (SearchResultPageFilterValueNodeFragmentModel) obj;
                if (searchResultPageFilterValueNodeFragmentModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(searchResultPageFilterValueNodeFragmentModel.m10144a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    searchResultPageFilterValueNodeFragmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                SearchResultPageFilterValueNodeFragmentParser.m10205a(searchResultPageFilterValueNodeFragmentModel.w_(), searchResultPageFilterValueNodeFragmentModel.u_(), jsonGenerator);
            }

            static {
                FbSerializerProvider.a(SearchResultPageFilterValueNodeFragmentModel.class, new Serializer());
            }
        }

        public SearchResultPageFilterValueNodeFragmentModel() {
            super(3);
        }

        public SearchResultPageFilterValueNodeFragmentModel(MutableFlatBuffer mutableFlatBuffer) {
            super(3);
            a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }

        public final boolean m10147a() {
            a(0, 0);
            return this.f8698d;
        }

        @Nullable
        public final String m10148b() {
            this.f8699e = super.a(this.f8699e, 1);
            return this.f8699e;
        }

        @Nullable
        public final String m10149c() {
            this.f8700f = super.a(this.f8700f, 2);
            return this.f8700f;
        }

        public static SearchResultPageFilterValueNodeFragmentModel m10143a(SearchResultPageFilterValueNodeFragmentModel searchResultPageFilterValueNodeFragmentModel) {
            if (searchResultPageFilterValueNodeFragmentModel == null) {
                return null;
            }
            if (searchResultPageFilterValueNodeFragmentModel instanceof SearchResultPageFilterValueNodeFragmentModel) {
                return searchResultPageFilterValueNodeFragmentModel;
            }
            Builder builder = new Builder();
            builder.f8695a = searchResultPageFilterValueNodeFragmentModel.m10147a();
            builder.f8696b = searchResultPageFilterValueNodeFragmentModel.m10148b();
            builder.f8697c = searchResultPageFilterValueNodeFragmentModel.m10149c();
            return builder.m10140a();
        }

        public final int jK_() {
            return -2134006905;
        }

        public final GraphQLVisitableModel m10145a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m10144a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m10148b());
            int b2 = flatBufferBuilder.b(m10149c());
            flatBufferBuilder.c(3);
            flatBufferBuilder.a(0, this.f8698d);
            flatBufferBuilder.b(1, b);
            flatBufferBuilder.b(2, b2);
            i();
            return flatBufferBuilder.d();
        }

        public final void m10146a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f8698d = mutableFlatBuffer.a(i, 0);
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 856548206)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: method/messaging.setthreadimage */
    public final class SearchResultPageFilterValuesFragmentModel extends BaseModel implements GraphQLVisitableModel, SearchResultPageFilterValuesFragment {
        @Nullable
        private SearchResultsPageFilterCustomPageValueModel f8705d;
        @Nullable
        private FilterValuesModel f8706e;

        /* compiled from: method/messaging.setthreadimage */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(SearchResultPageFilterValuesFragmentModel.class, new Deserializer());
            }

            public Object m10150a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = SearchResultPageFilterValuesFragmentParser.m10210a(jsonParser);
                Object searchResultPageFilterValuesFragmentModel = new SearchResultPageFilterValuesFragmentModel();
                ((BaseModel) searchResultPageFilterValuesFragmentModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (searchResultPageFilterValuesFragmentModel instanceof Postprocessable) {
                    return ((Postprocessable) searchResultPageFilterValuesFragmentModel).a();
                }
                return searchResultPageFilterValuesFragmentModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 963433659)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: method/messaging.setthreadimage */
        public final class FilterValuesModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<EdgesModel> f8704d;

            /* compiled from: method/messaging.setthreadimage */
            public final class Builder {
                @Nullable
                public ImmutableList<EdgesModel> f8701a;

                public final FilterValuesModel m10151a() {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    int a = ModelHelper.a(flatBufferBuilder, this.f8701a);
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, a);
                    flatBufferBuilder.d(flatBufferBuilder.d());
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    return new FilterValuesModel(new MutableFlatBuffer(wrap, null, null, true, null));
                }
            }

            /* compiled from: method/messaging.setthreadimage */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(FilterValuesModel.class, new Deserializer());
                }

                public Object m10152a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(FilterValuesParser.m10208a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object filterValuesModel = new FilterValuesModel();
                    ((BaseModel) filterValuesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (filterValuesModel instanceof Postprocessable) {
                        return ((Postprocessable) filterValuesModel).a();
                    }
                    return filterValuesModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 2092626926)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: method/messaging.setthreadimage */
            public final class EdgesModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private SearchResultPageFilterValueNodeFragmentModel f8703d;

                /* compiled from: method/messaging.setthreadimage */
                public final class Builder {
                    @Nullable
                    public SearchResultPageFilterValueNodeFragmentModel f8702a;

                    public final EdgesModel m10153a() {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        int a = ModelHelper.a(flatBufferBuilder, this.f8702a);
                        flatBufferBuilder.c(1);
                        flatBufferBuilder.b(0, a);
                        flatBufferBuilder.d(flatBufferBuilder.d());
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        return new EdgesModel(new MutableFlatBuffer(wrap, null, null, true, null));
                    }
                }

                /* compiled from: method/messaging.setthreadimage */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(EdgesModel.class, new Deserializer());
                    }

                    public Object m10154a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(EdgesParser.m10206b(jsonParser, flatBufferBuilder));
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

                /* compiled from: method/messaging.setthreadimage */
                public class Serializer extends JsonSerializer<EdgesModel> {
                    public final void m10155a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        EdgesModel edgesModel = (EdgesModel) obj;
                        if (edgesModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(edgesModel.m10158a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            edgesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        EdgesParser.m10207b(edgesModel.w_(), edgesModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(EdgesModel.class, new Serializer());
                    }
                }

                @Nullable
                public final /* synthetic */ SearchResultPageFilterValueNodeFragmentModel m10160a() {
                    return m10157j();
                }

                public EdgesModel() {
                    super(1);
                }

                public EdgesModel(MutableFlatBuffer mutableFlatBuffer) {
                    super(1);
                    a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }

                @Nullable
                private SearchResultPageFilterValueNodeFragmentModel m10157j() {
                    this.f8703d = (SearchResultPageFilterValueNodeFragmentModel) super.a(this.f8703d, 0, SearchResultPageFilterValueNodeFragmentModel.class);
                    return this.f8703d;
                }

                public static EdgesModel m10156a(EdgesModel edgesModel) {
                    if (edgesModel == null) {
                        return null;
                    }
                    if (edgesModel instanceof EdgesModel) {
                        return edgesModel;
                    }
                    Builder builder = new Builder();
                    builder.f8702a = SearchResultPageFilterValueNodeFragmentModel.m10143a(edgesModel.m10160a());
                    return builder.m10153a();
                }

                public final int jK_() {
                    return 169077161;
                }

                public final GraphQLVisitableModel m10159a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m10157j() != null) {
                        SearchResultPageFilterValueNodeFragmentModel searchResultPageFilterValueNodeFragmentModel = (SearchResultPageFilterValueNodeFragmentModel) graphQLModelMutatingVisitor.b(m10157j());
                        if (m10157j() != searchResultPageFilterValueNodeFragmentModel) {
                            graphQLVisitableModel = (EdgesModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f8703d = searchResultPageFilterValueNodeFragmentModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m10158a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m10157j());
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, a);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: method/messaging.setthreadimage */
            public class Serializer extends JsonSerializer<FilterValuesModel> {
                public final void m10161a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    FilterValuesModel filterValuesModel = (FilterValuesModel) obj;
                    if (filterValuesModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(filterValuesModel.m10163a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        filterValuesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    FilterValuesParser.m10209a(filterValuesModel.w_(), filterValuesModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(FilterValuesModel.class, new Serializer());
                }
            }

            public FilterValuesModel() {
                super(1);
            }

            public FilterValuesModel(MutableFlatBuffer mutableFlatBuffer) {
                super(1);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            @Nonnull
            public final ImmutableList<EdgesModel> m10165a() {
                this.f8704d = super.a(this.f8704d, 0, EdgesModel.class);
                return (ImmutableList) this.f8704d;
            }

            public static FilterValuesModel m10162a(FilterValuesModel filterValuesModel) {
                if (filterValuesModel == null) {
                    return null;
                }
                if (filterValuesModel instanceof FilterValuesModel) {
                    return filterValuesModel;
                }
                Builder builder = new Builder();
                com.google.common.collect.ImmutableList.Builder builder2 = ImmutableList.builder();
                for (int i = 0; i < filterValuesModel.m10165a().size(); i++) {
                    builder2.c(EdgesModel.m10156a((EdgesModel) filterValuesModel.m10165a().get(i)));
                }
                builder.f8701a = builder2.b();
                return builder.m10151a();
            }

            public final int jK_() {
                return 1130322378;
            }

            public final GraphQLVisitableModel m10164a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m10165a() != null) {
                    com.google.common.collect.ImmutableList.Builder a = ModelHelper.a(m10165a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (FilterValuesModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f8704d = a.b();
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m10163a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m10165a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: method/messaging.setthreadimage */
        public class Serializer extends JsonSerializer<SearchResultPageFilterValuesFragmentModel> {
            public final void m10166a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                SearchResultPageFilterValuesFragmentModel searchResultPageFilterValuesFragmentModel = (SearchResultPageFilterValuesFragmentModel) obj;
                if (searchResultPageFilterValuesFragmentModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(searchResultPageFilterValuesFragmentModel.m10169a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    searchResultPageFilterValuesFragmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = searchResultPageFilterValuesFragmentModel.w_();
                int u_ = searchResultPageFilterValuesFragmentModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("custom_value");
                    SearchResultsPageFilterCustomPageValueParser.m10220a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(u_, 1);
                if (g != 0) {
                    jsonGenerator.a("filter_values");
                    FilterValuesParser.m10209a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(SearchResultPageFilterValuesFragmentModel.class, new Serializer());
            }
        }

        public SearchResultPageFilterValuesFragmentModel() {
            super(2);
        }

        @Nullable
        private SearchResultsPageFilterCustomPageValueModel m10167a() {
            this.f8705d = (SearchResultsPageFilterCustomPageValueModel) super.a(this.f8705d, 0, SearchResultsPageFilterCustomPageValueModel.class);
            return this.f8705d;
        }

        @Nullable
        private FilterValuesModel m10168j() {
            this.f8706e = (FilterValuesModel) super.a(this.f8706e, 1, FilterValuesModel.class);
            return this.f8706e;
        }

        public final int jK_() {
            return -1440418806;
        }

        public final GraphQLVisitableModel m10170a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m10167a() != null) {
                SearchResultsPageFilterCustomPageValueModel searchResultsPageFilterCustomPageValueModel = (SearchResultsPageFilterCustomPageValueModel) graphQLModelMutatingVisitor.b(m10167a());
                if (m10167a() != searchResultsPageFilterCustomPageValueModel) {
                    graphQLVisitableModel = (SearchResultPageFilterValuesFragmentModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f8705d = searchResultsPageFilterCustomPageValueModel;
                }
            }
            if (m10168j() != null) {
                FilterValuesModel filterValuesModel = (FilterValuesModel) graphQLModelMutatingVisitor.b(m10168j());
                if (m10168j() != filterValuesModel) {
                    graphQLVisitableModel = (SearchResultPageFilterValuesFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f8706e = filterValuesModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m10169a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m10167a());
            int a2 = ModelHelper.a(flatBufferBuilder, m10168j());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -754615319)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: method/messaging.setthreadimage */
    public final class SearchResultPageFiltersFragmentModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private List<SearchResultPageMainFilterFragmentModel> f8707d;

        /* compiled from: method/messaging.setthreadimage */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(SearchResultPageFiltersFragmentModel.class, new Deserializer());
            }

            public Object m10171a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(SearchResultPageFiltersFragmentParser.m10213b(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object searchResultPageFiltersFragmentModel = new SearchResultPageFiltersFragmentModel();
                ((BaseModel) searchResultPageFiltersFragmentModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (searchResultPageFiltersFragmentModel instanceof Postprocessable) {
                    return ((Postprocessable) searchResultPageFiltersFragmentModel).a();
                }
                return searchResultPageFiltersFragmentModel;
            }
        }

        /* compiled from: method/messaging.setthreadimage */
        public class Serializer extends JsonSerializer<SearchResultPageFiltersFragmentModel> {
            public final void m10172a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                SearchResultPageFiltersFragmentModel searchResultPageFiltersFragmentModel = (SearchResultPageFiltersFragmentModel) obj;
                if (searchResultPageFiltersFragmentModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(searchResultPageFiltersFragmentModel.m10173a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    searchResultPageFiltersFragmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                SearchResultPageFiltersFragmentParser.m10214b(searchResultPageFiltersFragmentModel.w_(), searchResultPageFiltersFragmentModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(SearchResultPageFiltersFragmentModel.class, new Serializer());
            }
        }

        public SearchResultPageFiltersFragmentModel() {
            super(1);
        }

        @Nonnull
        public final ImmutableList<SearchResultPageMainFilterFragmentModel> m10175a() {
            this.f8707d = super.a(this.f8707d, 0, SearchResultPageMainFilterFragmentModel.class);
            return (ImmutableList) this.f8707d;
        }

        public final int jK_() {
            return 1129027422;
        }

        public final GraphQLVisitableModel m10174a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m10175a() != null) {
                Builder a = ModelHelper.a(m10175a(), graphQLModelMutatingVisitor);
                if (a != null) {
                    graphQLVisitableModel = (SearchResultPageFiltersFragmentModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f8707d = a.b();
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m10173a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m10175a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1214292567)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: method/messaging.setthreadimage */
    public final class SearchResultPageMainFilterFragmentModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private MainFilterModel f8724d;

        /* compiled from: method/messaging.setthreadimage */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(SearchResultPageMainFilterFragmentModel.class, new Deserializer());
            }

            public Object m10176a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(SearchResultPageMainFilterFragmentParser.m10217b(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object searchResultPageMainFilterFragmentModel = new SearchResultPageMainFilterFragmentModel();
                ((BaseModel) searchResultPageMainFilterFragmentModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (searchResultPageMainFilterFragmentModel instanceof Postprocessable) {
                    return ((Postprocessable) searchResultPageMainFilterFragmentModel).a();
                }
                return searchResultPageMainFilterFragmentModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -61961473)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: method/messaging.setthreadimage */
        public final class MainFilterModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel, SearchResultPageFilterValuesFragment {
            @Nullable
            private SearchResultsPageFilterCustomPageValueModel f8716d;
            @Nullable
            private String f8717e;
            @Nullable
            private FilterValuesModel f8718f;
            @Nullable
            private String f8719g;
            @Nullable
            private String f8720h;
            @Nullable
            private String f8721i;
            @Nullable
            private String f8722j;
            @Nullable
            private String f8723k;

            /* compiled from: method/messaging.setthreadimage */
            public final class Builder {
                @Nullable
                public SearchResultsPageFilterCustomPageValueModel f8708a;
                @Nullable
                public String f8709b;
                @Nullable
                public FilterValuesModel f8710c;
                @Nullable
                public String f8711d;
                @Nullable
                public String f8712e;
                @Nullable
                public String f8713f;
                @Nullable
                public String f8714g;
                @Nullable
                public String f8715h;

                public static Builder m10177a(MainFilterModel mainFilterModel) {
                    Builder builder = new Builder();
                    builder.f8708a = mainFilterModel.m10190k();
                    builder.f8709b = mainFilterModel.m10186c();
                    builder.f8710c = mainFilterModel.m10191l();
                    builder.f8711d = mainFilterModel.jn_();
                    builder.f8712e = mainFilterModel.m10188g();
                    builder.f8713f = mainFilterModel.jo_();
                    builder.f8714g = mainFilterModel.jp_();
                    builder.f8715h = mainFilterModel.m10189j();
                    return builder;
                }

                public final MainFilterModel m10178a() {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    int a = ModelHelper.a(flatBufferBuilder, this.f8708a);
                    int b = flatBufferBuilder.b(this.f8709b);
                    int a2 = ModelHelper.a(flatBufferBuilder, this.f8710c);
                    int b2 = flatBufferBuilder.b(this.f8711d);
                    int b3 = flatBufferBuilder.b(this.f8712e);
                    int b4 = flatBufferBuilder.b(this.f8713f);
                    int b5 = flatBufferBuilder.b(this.f8714g);
                    int b6 = flatBufferBuilder.b(this.f8715h);
                    flatBufferBuilder.c(8);
                    flatBufferBuilder.b(0, a);
                    flatBufferBuilder.b(1, b);
                    flatBufferBuilder.b(2, a2);
                    flatBufferBuilder.b(3, b2);
                    flatBufferBuilder.b(4, b3);
                    flatBufferBuilder.b(5, b4);
                    flatBufferBuilder.b(6, b5);
                    flatBufferBuilder.b(7, b6);
                    flatBufferBuilder.d(flatBufferBuilder.d());
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    return new MainFilterModel(new MutableFlatBuffer(wrap, null, null, true, null));
                }
            }

            /* compiled from: method/messaging.setthreadimage */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(MainFilterModel.class, new Deserializer());
                }

                public Object m10179a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(MainFilterParser.m10215a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object mainFilterModel = new MainFilterModel();
                    ((BaseModel) mainFilterModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (mainFilterModel instanceof Postprocessable) {
                        return ((Postprocessable) mainFilterModel).a();
                    }
                    return mainFilterModel;
                }
            }

            /* compiled from: method/messaging.setthreadimage */
            public class Serializer extends JsonSerializer<MainFilterModel> {
                public final void m10180a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    MainFilterModel mainFilterModel = (MainFilterModel) obj;
                    if (mainFilterModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(mainFilterModel.m10182a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mainFilterModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    MainFilterParser.m10216a(mainFilterModel.w_(), mainFilterModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(MainFilterModel.class, new Serializer());
                }
            }

            @Nullable
            public final /* synthetic */ SearchResultsPageFilterCustomPageValueModel m10185b() {
                return m10190k();
            }

            @Nullable
            public final /* synthetic */ FilterValuesModel m10187d() {
                return m10191l();
            }

            public MainFilterModel() {
                super(8);
            }

            public MainFilterModel(MutableFlatBuffer mutableFlatBuffer) {
                super(8);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            @Nullable
            public final SearchResultsPageFilterCustomPageValueModel m10190k() {
                this.f8716d = (SearchResultsPageFilterCustomPageValueModel) super.a(this.f8716d, 0, SearchResultsPageFilterCustomPageValueModel.class);
                return this.f8716d;
            }

            @Nullable
            public final String m10186c() {
                this.f8717e = super.a(this.f8717e, 1);
                return this.f8717e;
            }

            @Nullable
            public final FilterValuesModel m10191l() {
                this.f8718f = (FilterValuesModel) super.a(this.f8718f, 2, FilterValuesModel.class);
                return this.f8718f;
            }

            @Nullable
            public final String jn_() {
                this.f8719g = super.a(this.f8719g, 3);
                return this.f8719g;
            }

            @Nullable
            public final String m10188g() {
                this.f8720h = super.a(this.f8720h, 4);
                return this.f8720h;
            }

            @Nullable
            public final String jo_() {
                this.f8721i = super.a(this.f8721i, 5);
                return this.f8721i;
            }

            @Nullable
            public final String jp_() {
                this.f8722j = super.a(this.f8722j, 6);
                return this.f8722j;
            }

            @Nullable
            public final String m10189j() {
                this.f8723k = super.a(this.f8723k, 7);
                return this.f8723k;
            }

            public static MainFilterModel m10181a(MainFilterModel mainFilterModel) {
                if (mainFilterModel == null) {
                    return null;
                }
                if (mainFilterModel instanceof MainFilterModel) {
                    return mainFilterModel;
                }
                Builder builder = new Builder();
                builder.f8708a = SearchResultsPageFilterCustomPageValueModel.m10199a(mainFilterModel.m10185b());
                builder.f8709b = mainFilterModel.m10186c();
                builder.f8710c = FilterValuesModel.m10162a(mainFilterModel.m10187d());
                builder.f8711d = mainFilterModel.jn_();
                builder.f8712e = mainFilterModel.m10188g();
                builder.f8713f = mainFilterModel.jo_();
                builder.f8714g = mainFilterModel.jp_();
                builder.f8715h = mainFilterModel.m10189j();
                return builder.m10178a();
            }

            @Nullable
            public final String m10184a() {
                return m10188g();
            }

            public final int jK_() {
                return -1440418806;
            }

            public final GraphQLVisitableModel m10183a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m10190k() != null) {
                    SearchResultsPageFilterCustomPageValueModel searchResultsPageFilterCustomPageValueModel = (SearchResultsPageFilterCustomPageValueModel) graphQLModelMutatingVisitor.b(m10190k());
                    if (m10190k() != searchResultsPageFilterCustomPageValueModel) {
                        graphQLVisitableModel = (MainFilterModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f8716d = searchResultsPageFilterCustomPageValueModel;
                    }
                }
                if (m10191l() != null) {
                    FilterValuesModel filterValuesModel = (FilterValuesModel) graphQLModelMutatingVisitor.b(m10191l());
                    if (m10191l() != filterValuesModel) {
                        graphQLVisitableModel = (MainFilterModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f8718f = filterValuesModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m10182a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m10190k());
                int b = flatBufferBuilder.b(m10186c());
                int a2 = ModelHelper.a(flatBufferBuilder, m10191l());
                int b2 = flatBufferBuilder.b(jn_());
                int b3 = flatBufferBuilder.b(m10188g());
                int b4 = flatBufferBuilder.b(jo_());
                int b5 = flatBufferBuilder.b(jp_());
                int b6 = flatBufferBuilder.b(m10189j());
                flatBufferBuilder.c(8);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, b);
                flatBufferBuilder.b(2, a2);
                flatBufferBuilder.b(3, b2);
                flatBufferBuilder.b(4, b3);
                flatBufferBuilder.b(5, b4);
                flatBufferBuilder.b(6, b5);
                flatBufferBuilder.b(7, b6);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: method/messaging.setthreadimage */
        public class Serializer extends JsonSerializer<SearchResultPageMainFilterFragmentModel> {
            public final void m10192a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                SearchResultPageMainFilterFragmentModel searchResultPageMainFilterFragmentModel = (SearchResultPageMainFilterFragmentModel) obj;
                if (searchResultPageMainFilterFragmentModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(searchResultPageMainFilterFragmentModel.m10194a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    searchResultPageMainFilterFragmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                SearchResultPageMainFilterFragmentParser.m10218b(searchResultPageMainFilterFragmentModel.w_(), searchResultPageMainFilterFragmentModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(SearchResultPageMainFilterFragmentModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ MainFilterModel m10196a() {
            return m10193j();
        }

        public SearchResultPageMainFilterFragmentModel() {
            super(1);
        }

        @Nullable
        private MainFilterModel m10193j() {
            this.f8724d = (MainFilterModel) super.a(this.f8724d, 0, MainFilterModel.class);
            return this.f8724d;
        }

        public final int jK_() {
            return -2147350379;
        }

        public final GraphQLVisitableModel m10195a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m10193j() != null) {
                MainFilterModel mainFilterModel = (MainFilterModel) graphQLModelMutatingVisitor.b(m10193j());
                if (m10193j() != mainFilterModel) {
                    graphQLVisitableModel = (SearchResultPageMainFilterFragmentModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f8724d = mainFilterModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m10194a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m10193j());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -327699029)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: method/messaging.setthreadimage */
    public final class SearchResultsPageFilterCustomPageValueModel extends BaseModel implements GraphQLVisitableModel {
        private boolean f8726d;

        /* compiled from: method/messaging.setthreadimage */
        public final class Builder {
            public boolean f8725a;
        }

        /* compiled from: method/messaging.setthreadimage */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(SearchResultsPageFilterCustomPageValueModel.class, new Deserializer());
            }

            public Object m10197a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(SearchResultsPageFilterCustomPageValueParser.m10219a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object searchResultsPageFilterCustomPageValueModel = new SearchResultsPageFilterCustomPageValueModel();
                ((BaseModel) searchResultsPageFilterCustomPageValueModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (searchResultsPageFilterCustomPageValueModel instanceof Postprocessable) {
                    return ((Postprocessable) searchResultsPageFilterCustomPageValueModel).a();
                }
                return searchResultsPageFilterCustomPageValueModel;
            }
        }

        /* compiled from: method/messaging.setthreadimage */
        public class Serializer extends JsonSerializer<SearchResultsPageFilterCustomPageValueModel> {
            public final void m10198a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                SearchResultsPageFilterCustomPageValueModel searchResultsPageFilterCustomPageValueModel = (SearchResultsPageFilterCustomPageValueModel) obj;
                if (searchResultsPageFilterCustomPageValueModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(searchResultsPageFilterCustomPageValueModel.m10200a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    searchResultsPageFilterCustomPageValueModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                SearchResultsPageFilterCustomPageValueParser.m10220a(searchResultsPageFilterCustomPageValueModel.w_(), searchResultsPageFilterCustomPageValueModel.u_(), jsonGenerator);
            }

            static {
                FbSerializerProvider.a(SearchResultsPageFilterCustomPageValueModel.class, new Serializer());
            }
        }

        public SearchResultsPageFilterCustomPageValueModel() {
            super(1);
        }

        public SearchResultsPageFilterCustomPageValueModel(MutableFlatBuffer mutableFlatBuffer) {
            super(1);
            a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }

        public final boolean m10203a() {
            a(0, 0);
            return this.f8726d;
        }

        public static SearchResultsPageFilterCustomPageValueModel m10199a(SearchResultsPageFilterCustomPageValueModel searchResultsPageFilterCustomPageValueModel) {
            if (searchResultsPageFilterCustomPageValueModel == null) {
                return null;
            }
            if (searchResultsPageFilterCustomPageValueModel instanceof SearchResultsPageFilterCustomPageValueModel) {
                return searchResultsPageFilterCustomPageValueModel;
            }
            Builder builder = new Builder();
            builder.f8725a = searchResultsPageFilterCustomPageValueModel.m10203a();
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            flatBufferBuilder.c(1);
            flatBufferBuilder.a(0, builder.f8725a);
            flatBufferBuilder.d(flatBufferBuilder.d());
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            return new SearchResultsPageFilterCustomPageValueModel(new MutableFlatBuffer(wrap, null, null, true, null));
        }

        public final int jK_() {
            return -1095478713;
        }

        public final GraphQLVisitableModel m10201a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m10200a(FlatBufferBuilder flatBufferBuilder) {
            h();
            flatBufferBuilder.c(1);
            flatBufferBuilder.a(0, this.f8726d);
            i();
            return flatBufferBuilder.d();
        }

        public final void m10202a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f8726d = mutableFlatBuffer.a(i, 0);
        }
    }
}
