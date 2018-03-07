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
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.enums.GraphQLSavedState;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.modelutil.SerializerHelpers;
import com.facebook.graphql.querybuilder.common.CommonGraphQLInterfaces.DefaultImageFields;
import com.facebook.graphql.querybuilder.common.CommonGraphQLModels.DefaultImageFieldsModel;
import com.facebook.graphql.visitor.ConsistencyTuple;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.search.protocol.FB4AGraphSearchUserWithFiltersGraphQLParsers.FB4AGraphSearchFilterInfoFragmentParser;
import com.facebook.search.protocol.FB4AGraphSearchUserWithFiltersGraphQLParsers.FB4AGraphSearchFilterInfoFragmentParser.MainFilterParser;
import com.facebook.search.protocol.FB4AGraphSearchUserWithFiltersGraphQLParsers.FB4AGraphSearchFilterQueryParser;
import com.facebook.search.protocol.FB4AGraphSearchUserWithFiltersGraphQLParsers.FB4AGraphSearchFilterQueryParser.FilterValuesParser;
import com.facebook.search.protocol.FB4AGraphSearchUserWithFiltersGraphQLParsers.FB4AGraphSearchFilterQueryParser.FilterValuesParser.EdgesParser;
import com.facebook.search.protocol.FB4AGraphSearchUserWithFiltersGraphQLParsers.FB4AGraphSearchFilterValueFragmentParser;
import com.facebook.search.protocol.FB4AGraphSearchUserWithFiltersGraphQLParsers.FB4AGraphSearchFilterValueFragmentParser.ValueObjectParser;
import com.facebook.search.protocol.FB4AGraphSearchUserWithFiltersGraphQLParsers.FB4AGraphSearchUserResultDecorationParser;
import com.facebook.search.protocol.FB4AGraphSearchUserWithFiltersGraphQLParsers.FB4AGraphSearchUserResultDecorationParser.LineageSnippetsParser;
import com.facebook.search.protocol.FB4AGraphSearchUserWithFiltersGraphQLParsers.FB4AGraphSearchUserResultDecorationParser.LineageSnippetsParser.SentenceParser;
import com.facebook.search.protocol.FB4AGraphSearchUserWithFiltersGraphQLParsers.FB4AGraphSearchUserResultDecorationParser.SocialSnippetParser;
import com.facebook.search.protocol.FB4AGraphSearchUserWithFiltersGraphQLParsers.FB4AGraphSearchUserResultDecorationParser.SummarySnippetParser;
import com.facebook.search.protocol.FB4AGraphSearchUserWithFiltersGraphQLParsers.FB4AGraphSearchUserWithFiltersQueryParser;
import com.facebook.search.protocol.FB4AGraphSearchUserWithFiltersGraphQLParsers.FB4AGraphSearchUserWithFiltersQueryParser.FilteredQueryParser;
import com.facebook.search.protocol.FB4AGraphSearchUserWithFiltersGraphQLParsers.FB4AGraphSearchUserWithFiltersQueryParser.FilteredQueryParser.ResultsParser;
import com.facebook.search.protocol.FB4AGraphSearchUserWithFiltersGraphQLParsers.FB4AGraphSearchUserWithFiltersQueryParser.FilteredQueryParser.ResultsParser.EdgesParser.NodeParser;
import com.facebook.search.protocol.FB4AGraphSearchUserWithFiltersGraphQLParsers.FB4AGraphSearchUserWithFiltersQueryParser.FilteredQueryParser.ResultsParser.EdgesParser.NodeParser.GroupIconParser;
import com.facebook.search.protocol.FB4AGraphSearchUserWithFiltersGraphQLParsers.FB4AGraphSearchUserWithFiltersQueryParser.FilteredQueryParser.ResultsParser.EdgesParser.NodeParser.GroupIconParser.DarkIconParser;
import com.facebook.search.protocol.FB4AGraphSearchUserWithFiltersGraphQLParsers.FB4AGraphSearchUserWithFiltersQueryParser.FilteredQueryParser.ResultsParser.EdgesParser.NodeParser.GroupPhotorealisticIconParser;
import com.facebook.search.protocol.FB4AGraphSearchUserWithFiltersGraphQLParsers.FB4AGraphSearchUserWithFiltersQueryParser.FilteredQueryParser.ResultsParser.PageInfoParser;
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

/* compiled from: nmor_pages_commerce */
public class FB4AGraphSearchUserWithFiltersGraphQLModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1917828201)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: nmor_pages_commerce */
    public final class FB4AGraphSearchFilterInfoFragmentModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private MainFilterModel f7879d;

        /* compiled from: nmor_pages_commerce */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FB4AGraphSearchFilterInfoFragmentModel.class, new Deserializer());
            }

            public Object m8266a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(FB4AGraphSearchFilterInfoFragmentParser.m8433b(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object fB4AGraphSearchFilterInfoFragmentModel = new FB4AGraphSearchFilterInfoFragmentModel();
                ((BaseModel) fB4AGraphSearchFilterInfoFragmentModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (fB4AGraphSearchFilterInfoFragmentModel instanceof Postprocessable) {
                    return ((Postprocessable) fB4AGraphSearchFilterInfoFragmentModel).a();
                }
                return fB4AGraphSearchFilterInfoFragmentModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 239620937)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: nmor_pages_commerce */
        public final class MainFilterModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
            @Nullable
            private FB4AGraphSearchFilterValueFragmentModel f7875d;
            @Nullable
            private String f7876e;
            @Nullable
            private String f7877f;
            @Nullable
            private String f7878g;

            /* compiled from: nmor_pages_commerce */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(MainFilterModel.class, new Deserializer());
                }

                public Object m8267a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(MainFilterParser.m8431a(jsonParser, flatBufferBuilder));
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

            /* compiled from: nmor_pages_commerce */
            public class Serializer extends JsonSerializer<MainFilterModel> {
                public final void m8268a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    MainFilterModel mainFilterModel = (MainFilterModel) obj;
                    if (mainFilterModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(mainFilterModel.m8270a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mainFilterModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    MainFilterParser.m8432a(mainFilterModel.w_(), mainFilterModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(MainFilterModel.class, new Serializer());
                }
            }

            @Nullable
            public final /* synthetic */ FB4AGraphSearchFilterValueFragmentModel m8273b() {
                return m8269j();
            }

            public MainFilterModel() {
                super(4);
            }

            @Nullable
            private FB4AGraphSearchFilterValueFragmentModel m8269j() {
                this.f7875d = (FB4AGraphSearchFilterValueFragmentModel) super.a(this.f7875d, 0, FB4AGraphSearchFilterValueFragmentModel.class);
                return this.f7875d;
            }

            @Nullable
            public final String m8274c() {
                this.f7876e = super.a(this.f7876e, 1);
                return this.f7876e;
            }

            @Nullable
            public final String m8275d() {
                this.f7877f = super.a(this.f7877f, 2);
                return this.f7877f;
            }

            @Nullable
            public final String ju_() {
                this.f7878g = super.a(this.f7878g, 3);
                return this.f7878g;
            }

            @Nullable
            public final String m8272a() {
                return m8274c();
            }

            public final int jK_() {
                return -1440418806;
            }

            public final GraphQLVisitableModel m8271a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m8269j() != null) {
                    FB4AGraphSearchFilterValueFragmentModel fB4AGraphSearchFilterValueFragmentModel = (FB4AGraphSearchFilterValueFragmentModel) graphQLModelMutatingVisitor.b(m8269j());
                    if (m8269j() != fB4AGraphSearchFilterValueFragmentModel) {
                        graphQLVisitableModel = (MainFilterModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f7875d = fB4AGraphSearchFilterValueFragmentModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m8270a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m8269j());
                int b = flatBufferBuilder.b(m8274c());
                int b2 = flatBufferBuilder.b(m8275d());
                int b3 = flatBufferBuilder.b(ju_());
                flatBufferBuilder.c(4);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, b);
                flatBufferBuilder.b(2, b2);
                flatBufferBuilder.b(3, b3);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: nmor_pages_commerce */
        public class Serializer extends JsonSerializer<FB4AGraphSearchFilterInfoFragmentModel> {
            public final void m8276a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                FB4AGraphSearchFilterInfoFragmentModel fB4AGraphSearchFilterInfoFragmentModel = (FB4AGraphSearchFilterInfoFragmentModel) obj;
                if (fB4AGraphSearchFilterInfoFragmentModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(fB4AGraphSearchFilterInfoFragmentModel.m8277a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    fB4AGraphSearchFilterInfoFragmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                FB4AGraphSearchFilterInfoFragmentParser.m8434b(fB4AGraphSearchFilterInfoFragmentModel.w_(), fB4AGraphSearchFilterInfoFragmentModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(FB4AGraphSearchFilterInfoFragmentModel.class, new Serializer());
            }
        }

        public FB4AGraphSearchFilterInfoFragmentModel() {
            super(1);
        }

        @Nullable
        public final MainFilterModel m8279a() {
            this.f7879d = (MainFilterModel) super.a(this.f7879d, 0, MainFilterModel.class);
            return this.f7879d;
        }

        public final int jK_() {
            return -2147350379;
        }

        public final GraphQLVisitableModel m8278a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m8279a() != null) {
                MainFilterModel mainFilterModel = (MainFilterModel) graphQLModelMutatingVisitor.b(m8279a());
                if (m8279a() != mainFilterModel) {
                    graphQLVisitableModel = (FB4AGraphSearchFilterInfoFragmentModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f7879d = mainFilterModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m8277a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m8279a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -2037261728)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: nmor_pages_commerce */
    public final class FB4AGraphSearchFilterQueryModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
        @Nullable
        private GraphQLObjectType f7882d;
        @Nullable
        private FilterValuesModel f7883e;
        @Nullable
        private String f7884f;

        /* compiled from: nmor_pages_commerce */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FB4AGraphSearchFilterQueryModel.class, new Deserializer());
            }

            public Object m8280a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = FB4AGraphSearchFilterQueryParser.m8439a(jsonParser);
                Object fB4AGraphSearchFilterQueryModel = new FB4AGraphSearchFilterQueryModel();
                ((BaseModel) fB4AGraphSearchFilterQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (fB4AGraphSearchFilterQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) fB4AGraphSearchFilterQueryModel).a();
                }
                return fB4AGraphSearchFilterQueryModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1713924995)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: nmor_pages_commerce */
        public final class FilterValuesModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<EdgesModel> f7881d;

            /* compiled from: nmor_pages_commerce */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(FilterValuesModel.class, new Deserializer());
                }

                public Object m8281a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(FilterValuesParser.m8437a(jsonParser, flatBufferBuilder));
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
            @ModelWithFlatBufferFormatHash(a = -1289989730)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: nmor_pages_commerce */
            public final class EdgesModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private FB4AGraphSearchFilterValueFragmentModel f7880d;

                /* compiled from: nmor_pages_commerce */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(EdgesModel.class, new Deserializer());
                    }

                    public Object m8282a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(EdgesParser.m8435b(jsonParser, flatBufferBuilder));
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

                /* compiled from: nmor_pages_commerce */
                public class Serializer extends JsonSerializer<EdgesModel> {
                    public final void m8283a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        EdgesModel edgesModel = (EdgesModel) obj;
                        if (edgesModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(edgesModel.m8284a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            edgesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        EdgesParser.m8436b(edgesModel.w_(), edgesModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(EdgesModel.class, new Serializer());
                    }
                }

                public EdgesModel() {
                    super(1);
                }

                @Nullable
                public final FB4AGraphSearchFilterValueFragmentModel m8286a() {
                    this.f7880d = (FB4AGraphSearchFilterValueFragmentModel) super.a(this.f7880d, 0, FB4AGraphSearchFilterValueFragmentModel.class);
                    return this.f7880d;
                }

                public final int jK_() {
                    return 169077161;
                }

                public final GraphQLVisitableModel m8285a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m8286a() != null) {
                        FB4AGraphSearchFilterValueFragmentModel fB4AGraphSearchFilterValueFragmentModel = (FB4AGraphSearchFilterValueFragmentModel) graphQLModelMutatingVisitor.b(m8286a());
                        if (m8286a() != fB4AGraphSearchFilterValueFragmentModel) {
                            graphQLVisitableModel = (EdgesModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f7880d = fB4AGraphSearchFilterValueFragmentModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m8284a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m8286a());
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, a);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: nmor_pages_commerce */
            public class Serializer extends JsonSerializer<FilterValuesModel> {
                public final void m8287a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    FilterValuesModel filterValuesModel = (FilterValuesModel) obj;
                    if (filterValuesModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(filterValuesModel.m8288a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        filterValuesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    FilterValuesParser.m8438a(filterValuesModel.w_(), filterValuesModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(FilterValuesModel.class, new Serializer());
                }
            }

            public FilterValuesModel() {
                super(1);
            }

            @Nonnull
            public final ImmutableList<EdgesModel> m8290a() {
                this.f7881d = super.a(this.f7881d, 0, EdgesModel.class);
                return (ImmutableList) this.f7881d;
            }

            public final int jK_() {
                return 1130322378;
            }

            public final GraphQLVisitableModel m8289a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m8290a() != null) {
                    Builder a = ModelHelper.a(m8290a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (FilterValuesModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f7881d = a.b();
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m8288a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m8290a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: nmor_pages_commerce */
        public class Serializer extends JsonSerializer<FB4AGraphSearchFilterQueryModel> {
            public final void m8291a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                FB4AGraphSearchFilterQueryModel fB4AGraphSearchFilterQueryModel = (FB4AGraphSearchFilterQueryModel) obj;
                if (fB4AGraphSearchFilterQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(fB4AGraphSearchFilterQueryModel.m8294a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    fB4AGraphSearchFilterQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = fB4AGraphSearchFilterQueryModel.w_();
                int u_ = fB4AGraphSearchFilterQueryModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("__type__");
                    SerializerHelpers.b(mutableFlatBuffer, u_, 0, jsonGenerator);
                }
                int g = mutableFlatBuffer.g(u_, 1);
                if (g != 0) {
                    jsonGenerator.a("filter_values");
                    FilterValuesParser.m8438a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                if (mutableFlatBuffer.g(u_, 2) != 0) {
                    jsonGenerator.a("id");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 2));
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(FB4AGraphSearchFilterQueryModel.class, new Serializer());
            }
        }

        public FB4AGraphSearchFilterQueryModel() {
            super(3);
        }

        public final void m8297a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m8298a(String str, Object obj, boolean z) {
        }

        @Nullable
        private GraphQLObjectType m8292k() {
            if (this.b != null && this.f7882d == null) {
                this.f7882d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
            }
            return this.f7882d;
        }

        @Nullable
        public final FilterValuesModel m8299j() {
            this.f7883e = (FilterValuesModel) super.a(this.f7883e, 1, FilterValuesModel.class);
            return this.f7883e;
        }

        @Nullable
        private String m8293l() {
            this.f7884f = super.a(this.f7884f, 2);
            return this.f7884f;
        }

        @Nullable
        public final String m8296a() {
            return m8293l();
        }

        public final int jK_() {
            return 2433570;
        }

        public final GraphQLVisitableModel m8295a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m8299j() != null) {
                FilterValuesModel filterValuesModel = (FilterValuesModel) graphQLModelMutatingVisitor.b(m8299j());
                if (m8299j() != filterValuesModel) {
                    graphQLVisitableModel = (FB4AGraphSearchFilterQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f7883e = filterValuesModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m8294a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m8292k());
            int a2 = ModelHelper.a(flatBufferBuilder, m8299j());
            int b = flatBufferBuilder.b(m8293l());
            flatBufferBuilder.c(3);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            flatBufferBuilder.b(2, b);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 861475004)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: nmor_pages_commerce */
    public final class FB4AGraphSearchFilterValueFragmentModel extends BaseModel implements GraphQLVisitableModel {
        private boolean f7888d;
        @Nullable
        private String f7889e;
        @Nullable
        private String f7890f;
        @Nullable
        private ValueObjectModel f7891g;

        /* compiled from: nmor_pages_commerce */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FB4AGraphSearchFilterValueFragmentModel.class, new Deserializer());
            }

            public Object m8300a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(FB4AGraphSearchFilterValueFragmentParser.m8442a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object fB4AGraphSearchFilterValueFragmentModel = new FB4AGraphSearchFilterValueFragmentModel();
                ((BaseModel) fB4AGraphSearchFilterValueFragmentModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (fB4AGraphSearchFilterValueFragmentModel instanceof Postprocessable) {
                    return ((Postprocessable) fB4AGraphSearchFilterValueFragmentModel).a();
                }
                return fB4AGraphSearchFilterValueFragmentModel;
            }
        }

        /* compiled from: nmor_pages_commerce */
        public class Serializer extends JsonSerializer<FB4AGraphSearchFilterValueFragmentModel> {
            public final void m8301a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                FB4AGraphSearchFilterValueFragmentModel fB4AGraphSearchFilterValueFragmentModel = (FB4AGraphSearchFilterValueFragmentModel) obj;
                if (fB4AGraphSearchFilterValueFragmentModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(fB4AGraphSearchFilterValueFragmentModel.m8313a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    fB4AGraphSearchFilterValueFragmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                FB4AGraphSearchFilterValueFragmentParser.m8443a(fB4AGraphSearchFilterValueFragmentModel.w_(), fB4AGraphSearchFilterValueFragmentModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(FB4AGraphSearchFilterValueFragmentModel.class, new Serializer());
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1478881847)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: nmor_pages_commerce */
        public final class ValueObjectModel extends BaseModel implements GraphQLVisitableConsistentModel {
            @Nullable
            private GraphQLObjectType f7885d;
            @Nullable
            private String f7886e;
            @Nullable
            private DefaultImageFieldsModel f7887f;

            /* compiled from: nmor_pages_commerce */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(ValueObjectModel.class, new Deserializer());
                }

                public Object m8302a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(ValueObjectParser.m8440a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object valueObjectModel = new ValueObjectModel();
                    ((BaseModel) valueObjectModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (valueObjectModel instanceof Postprocessable) {
                        return ((Postprocessable) valueObjectModel).a();
                    }
                    return valueObjectModel;
                }
            }

            /* compiled from: nmor_pages_commerce */
            public class Serializer extends JsonSerializer<ValueObjectModel> {
                public final void m8303a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    ValueObjectModel valueObjectModel = (ValueObjectModel) obj;
                    if (valueObjectModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(valueObjectModel.m8306a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        valueObjectModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    ValueObjectParser.m8441a(valueObjectModel.w_(), valueObjectModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(ValueObjectModel.class, new Serializer());
                }
            }

            @Nullable
            public final /* synthetic */ DefaultImageFields m8311b() {
                return m8305k();
            }

            public ValueObjectModel() {
                super(3);
            }

            public final void m8309a(String str, ConsistencyTuple consistencyTuple) {
                consistencyTuple.a();
            }

            public final void m8310a(String str, Object obj, boolean z) {
            }

            @Nullable
            private GraphQLObjectType m8304j() {
                if (this.b != null && this.f7885d == null) {
                    this.f7885d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                }
                return this.f7885d;
            }

            @Nullable
            public final String m8308a() {
                this.f7886e = super.a(this.f7886e, 1);
                return this.f7886e;
            }

            @Nullable
            private DefaultImageFieldsModel m8305k() {
                this.f7887f = (DefaultImageFieldsModel) super.a(this.f7887f, 2, DefaultImageFieldsModel.class);
                return this.f7887f;
            }

            public final int jK_() {
                return 2433570;
            }

            public final GraphQLVisitableModel m8307a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m8305k() != null) {
                    DefaultImageFieldsModel defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m8305k());
                    if (m8305k() != defaultImageFieldsModel) {
                        graphQLVisitableModel = (ValueObjectModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f7887f = defaultImageFieldsModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m8306a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m8304j());
                int b = flatBufferBuilder.b(m8308a());
                int a2 = ModelHelper.a(flatBufferBuilder, m8305k());
                flatBufferBuilder.c(3);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, b);
                flatBufferBuilder.b(2, a2);
                i();
                return flatBufferBuilder.d();
            }
        }

        @Nullable
        public final /* synthetic */ ValueObjectModel m8319d() {
            return m8312j();
        }

        public FB4AGraphSearchFilterValueFragmentModel() {
            super(4);
        }

        public final boolean m8316a() {
            a(0, 0);
            return this.f7888d;
        }

        @Nullable
        public final String m8317b() {
            this.f7889e = super.a(this.f7889e, 1);
            return this.f7889e;
        }

        @Nullable
        public final String m8318c() {
            this.f7890f = super.a(this.f7890f, 2);
            return this.f7890f;
        }

        @Nullable
        private ValueObjectModel m8312j() {
            this.f7891g = (ValueObjectModel) super.a(this.f7891g, 3, ValueObjectModel.class);
            return this.f7891g;
        }

        public final int jK_() {
            return -2134006905;
        }

        public final GraphQLVisitableModel m8314a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m8312j() != null) {
                ValueObjectModel valueObjectModel = (ValueObjectModel) graphQLModelMutatingVisitor.b(m8312j());
                if (m8312j() != valueObjectModel) {
                    graphQLVisitableModel = (FB4AGraphSearchFilterValueFragmentModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f7891g = valueObjectModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m8313a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m8317b());
            int b2 = flatBufferBuilder.b(m8318c());
            int a = ModelHelper.a(flatBufferBuilder, m8312j());
            flatBufferBuilder.c(4);
            flatBufferBuilder.a(0, this.f7888d);
            flatBufferBuilder.b(1, b);
            flatBufferBuilder.b(2, b2);
            flatBufferBuilder.b(3, a);
            i();
            return flatBufferBuilder.d();
        }

        public final void m8315a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f7888d = mutableFlatBuffer.a(i, 0);
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1168974945)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: nmor_pages_commerce */
    public final class FB4AGraphSearchUserResultDecorationModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private List<LineageSnippetsModel> f7898d;
        @Nullable
        private SocialSnippetModel f7899e;
        @Nullable
        private SummarySnippetModel f7900f;

        /* compiled from: nmor_pages_commerce */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FB4AGraphSearchUserResultDecorationModel.class, new Deserializer());
            }

            public Object m8320a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(FB4AGraphSearchUserResultDecorationParser.m8456a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object fB4AGraphSearchUserResultDecorationModel = new FB4AGraphSearchUserResultDecorationModel();
                ((BaseModel) fB4AGraphSearchUserResultDecorationModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (fB4AGraphSearchUserResultDecorationModel instanceof Postprocessable) {
                    return ((Postprocessable) fB4AGraphSearchUserResultDecorationModel).a();
                }
                return fB4AGraphSearchUserResultDecorationModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1103628312)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: nmor_pages_commerce */
        public final class LineageSnippetsModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private SentenceModel f7893d;

            /* compiled from: nmor_pages_commerce */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(LineageSnippetsModel.class, new Deserializer());
                }

                public Object m8321a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(LineageSnippetsParser.m8446b(jsonParser, flatBufferBuilder));
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
            /* compiled from: nmor_pages_commerce */
            public final class SentenceModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private String f7892d;

                /* compiled from: nmor_pages_commerce */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(SentenceModel.class, new Deserializer());
                    }

                    public Object m8322a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(SentenceParser.m8444a(jsonParser, flatBufferBuilder));
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

                /* compiled from: nmor_pages_commerce */
                public class Serializer extends JsonSerializer<SentenceModel> {
                    public final void m8323a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        SentenceModel sentenceModel = (SentenceModel) obj;
                        if (sentenceModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(sentenceModel.m8324a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            sentenceModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        SentenceParser.m8445a(sentenceModel.w_(), sentenceModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(SentenceModel.class, new Serializer());
                    }
                }

                public SentenceModel() {
                    super(1);
                }

                @Nullable
                public final String m8326a() {
                    this.f7892d = super.a(this.f7892d, 0);
                    return this.f7892d;
                }

                public final int jK_() {
                    return -1919764332;
                }

                public final GraphQLVisitableModel m8325a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m8324a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int b = flatBufferBuilder.b(m8326a());
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, b);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: nmor_pages_commerce */
            public class Serializer extends JsonSerializer<LineageSnippetsModel> {
                public final void m8327a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    LineageSnippetsModel lineageSnippetsModel = (LineageSnippetsModel) obj;
                    if (lineageSnippetsModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(lineageSnippetsModel.m8329a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        lineageSnippetsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    LineageSnippetsParser.m8447b(lineageSnippetsModel.w_(), lineageSnippetsModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(LineageSnippetsModel.class, new Serializer());
                }
            }

            @Nullable
            public final /* synthetic */ SentenceModel m8331a() {
                return m8328j();
            }

            public LineageSnippetsModel() {
                super(1);
            }

            @Nullable
            private SentenceModel m8328j() {
                this.f7893d = (SentenceModel) super.a(this.f7893d, 0, SentenceModel.class);
                return this.f7893d;
            }

            public final int jK_() {
                return -38981689;
            }

            public final GraphQLVisitableModel m8330a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m8328j() != null) {
                    SentenceModel sentenceModel = (SentenceModel) graphQLModelMutatingVisitor.b(m8328j());
                    if (m8328j() != sentenceModel) {
                        graphQLVisitableModel = (LineageSnippetsModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f7893d = sentenceModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m8329a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m8328j());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: nmor_pages_commerce */
        public class Serializer extends JsonSerializer<FB4AGraphSearchUserResultDecorationModel> {
            public final void m8332a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                FB4AGraphSearchUserResultDecorationModel fB4AGraphSearchUserResultDecorationModel = (FB4AGraphSearchUserResultDecorationModel) obj;
                if (fB4AGraphSearchUserResultDecorationModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(fB4AGraphSearchUserResultDecorationModel.m8357a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    fB4AGraphSearchUserResultDecorationModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                FB4AGraphSearchUserResultDecorationParser.m8457a(fB4AGraphSearchUserResultDecorationModel.w_(), fB4AGraphSearchUserResultDecorationModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(FB4AGraphSearchUserResultDecorationModel.class, new Serializer());
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 592913686)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: nmor_pages_commerce */
        public final class SocialSnippetModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private SentenceModel f7895d;

            /* compiled from: nmor_pages_commerce */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(SocialSnippetModel.class, new Deserializer());
                }

                public Object m8333a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(SocialSnippetParser.m8450a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object socialSnippetModel = new SocialSnippetModel();
                    ((BaseModel) socialSnippetModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (socialSnippetModel instanceof Postprocessable) {
                        return ((Postprocessable) socialSnippetModel).a();
                    }
                    return socialSnippetModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -1352864475)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: nmor_pages_commerce */
            public final class SentenceModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private String f7894d;

                /* compiled from: nmor_pages_commerce */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(SentenceModel.class, new Deserializer());
                    }

                    public Object m8334a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(SocialSnippetParser.SentenceParser.m8448a(jsonParser, flatBufferBuilder));
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

                /* compiled from: nmor_pages_commerce */
                public class Serializer extends JsonSerializer<SentenceModel> {
                    public final void m8335a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        SentenceModel sentenceModel = (SentenceModel) obj;
                        if (sentenceModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(sentenceModel.m8336a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            sentenceModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        SocialSnippetParser.SentenceParser.m8449a(sentenceModel.w_(), sentenceModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(SentenceModel.class, new Serializer());
                    }
                }

                public SentenceModel() {
                    super(1);
                }

                @Nullable
                public final String m8338a() {
                    this.f7894d = super.a(this.f7894d, 0);
                    return this.f7894d;
                }

                public final int jK_() {
                    return -1919764332;
                }

                public final GraphQLVisitableModel m8337a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m8336a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int b = flatBufferBuilder.b(m8338a());
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, b);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: nmor_pages_commerce */
            public class Serializer extends JsonSerializer<SocialSnippetModel> {
                public final void m8339a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    SocialSnippetModel socialSnippetModel = (SocialSnippetModel) obj;
                    if (socialSnippetModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(socialSnippetModel.m8341a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        socialSnippetModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    SocialSnippetParser.m8451a(socialSnippetModel.w_(), socialSnippetModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(SocialSnippetModel.class, new Serializer());
                }
            }

            @Nullable
            public final /* synthetic */ SentenceModel m8343a() {
                return m8340j();
            }

            public SocialSnippetModel() {
                super(1);
            }

            @Nullable
            private SentenceModel m8340j() {
                this.f7895d = (SentenceModel) super.a(this.f7895d, 0, SentenceModel.class);
                return this.f7895d;
            }

            public final int jK_() {
                return -38981689;
            }

            public final GraphQLVisitableModel m8342a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m8340j() != null) {
                    SentenceModel sentenceModel = (SentenceModel) graphQLModelMutatingVisitor.b(m8340j());
                    if (m8340j() != sentenceModel) {
                        graphQLVisitableModel = (SocialSnippetModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f7895d = sentenceModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m8341a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m8340j());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -518841619)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: nmor_pages_commerce */
        public final class SummarySnippetModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private SentenceModel f7897d;

            /* compiled from: nmor_pages_commerce */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(SummarySnippetModel.class, new Deserializer());
                }

                public Object m8344a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(SummarySnippetParser.m8454a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object summarySnippetModel = new SummarySnippetModel();
                    ((BaseModel) summarySnippetModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (summarySnippetModel instanceof Postprocessable) {
                        return ((Postprocessable) summarySnippetModel).a();
                    }
                    return summarySnippetModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -1352864475)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: nmor_pages_commerce */
            public final class SentenceModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private String f7896d;

                /* compiled from: nmor_pages_commerce */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(SentenceModel.class, new Deserializer());
                    }

                    public Object m8345a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(SummarySnippetParser.SentenceParser.m8452a(jsonParser, flatBufferBuilder));
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

                /* compiled from: nmor_pages_commerce */
                public class Serializer extends JsonSerializer<SentenceModel> {
                    public final void m8346a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        SentenceModel sentenceModel = (SentenceModel) obj;
                        if (sentenceModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(sentenceModel.m8347a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            sentenceModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        SummarySnippetParser.SentenceParser.m8453a(sentenceModel.w_(), sentenceModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(SentenceModel.class, new Serializer());
                    }
                }

                public SentenceModel() {
                    super(1);
                }

                @Nullable
                public final String m8349a() {
                    this.f7896d = super.a(this.f7896d, 0);
                    return this.f7896d;
                }

                public final int jK_() {
                    return -1919764332;
                }

                public final GraphQLVisitableModel m8348a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m8347a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int b = flatBufferBuilder.b(m8349a());
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, b);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: nmor_pages_commerce */
            public class Serializer extends JsonSerializer<SummarySnippetModel> {
                public final void m8350a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    SummarySnippetModel summarySnippetModel = (SummarySnippetModel) obj;
                    if (summarySnippetModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(summarySnippetModel.m8352a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        summarySnippetModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    SummarySnippetParser.m8455a(summarySnippetModel.w_(), summarySnippetModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(SummarySnippetModel.class, new Serializer());
                }
            }

            @Nullable
            public final /* synthetic */ SentenceModel m8354a() {
                return m8351j();
            }

            public SummarySnippetModel() {
                super(1);
            }

            @Nullable
            private SentenceModel m8351j() {
                this.f7897d = (SentenceModel) super.a(this.f7897d, 0, SentenceModel.class);
                return this.f7897d;
            }

            public final int jK_() {
                return -38981689;
            }

            public final GraphQLVisitableModel m8353a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m8351j() != null) {
                    SentenceModel sentenceModel = (SentenceModel) graphQLModelMutatingVisitor.b(m8351j());
                    if (m8351j() != sentenceModel) {
                        graphQLVisitableModel = (SummarySnippetModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f7897d = sentenceModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m8352a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m8351j());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        @Nullable
        public final /* synthetic */ SocialSnippetModel m8360b() {
            return m8355j();
        }

        @Nullable
        public final /* synthetic */ SummarySnippetModel m8361c() {
            return m8356k();
        }

        public FB4AGraphSearchUserResultDecorationModel() {
            super(3);
        }

        @Nonnull
        public final ImmutableList<LineageSnippetsModel> m8359a() {
            this.f7898d = super.a(this.f7898d, 0, LineageSnippetsModel.class);
            return (ImmutableList) this.f7898d;
        }

        @Nullable
        private SocialSnippetModel m8355j() {
            this.f7899e = (SocialSnippetModel) super.a(this.f7899e, 1, SocialSnippetModel.class);
            return this.f7899e;
        }

        @Nullable
        private SummarySnippetModel m8356k() {
            this.f7900f = (SummarySnippetModel) super.a(this.f7900f, 2, SummarySnippetModel.class);
            return this.f7900f;
        }

        public final int jK_() {
            return 379010371;
        }

        public final GraphQLVisitableModel m8358a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel;
            SocialSnippetModel socialSnippetModel;
            SummarySnippetModel summarySnippetModel;
            h();
            if (m8359a() != null) {
                Builder a = ModelHelper.a(m8359a(), graphQLModelMutatingVisitor);
                if (a != null) {
                    FB4AGraphSearchUserResultDecorationModel fB4AGraphSearchUserResultDecorationModel = (FB4AGraphSearchUserResultDecorationModel) ModelHelper.a(null, this);
                    fB4AGraphSearchUserResultDecorationModel.f7898d = a.b();
                    graphQLVisitableModel = fB4AGraphSearchUserResultDecorationModel;
                    if (m8355j() != null) {
                        socialSnippetModel = (SocialSnippetModel) graphQLModelMutatingVisitor.b(m8355j());
                        if (m8355j() != socialSnippetModel) {
                            graphQLVisitableModel = (FB4AGraphSearchUserResultDecorationModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f7899e = socialSnippetModel;
                        }
                    }
                    if (m8356k() != null) {
                        summarySnippetModel = (SummarySnippetModel) graphQLModelMutatingVisitor.b(m8356k());
                        if (m8356k() != summarySnippetModel) {
                            graphQLVisitableModel = (FB4AGraphSearchUserResultDecorationModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f7900f = summarySnippetModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel != null ? this : graphQLVisitableModel;
                }
            }
            graphQLVisitableModel = null;
            if (m8355j() != null) {
                socialSnippetModel = (SocialSnippetModel) graphQLModelMutatingVisitor.b(m8355j());
                if (m8355j() != socialSnippetModel) {
                    graphQLVisitableModel = (FB4AGraphSearchUserResultDecorationModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f7899e = socialSnippetModel;
                }
            }
            if (m8356k() != null) {
                summarySnippetModel = (SummarySnippetModel) graphQLModelMutatingVisitor.b(m8356k());
                if (m8356k() != summarySnippetModel) {
                    graphQLVisitableModel = (FB4AGraphSearchUserResultDecorationModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f7900f = summarySnippetModel;
                }
            }
            i();
            if (graphQLVisitableModel != null) {
            }
        }

        public final int m8357a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m8359a());
            int a2 = ModelHelper.a(flatBufferBuilder, m8355j());
            int a3 = ModelHelper.a(flatBufferBuilder, m8356k());
            flatBufferBuilder.c(3);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            flatBufferBuilder.b(2, a3);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 29497372)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: nmor_pages_commerce */
    public final class FB4AGraphSearchUserWithFiltersQueryModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private FilteredQueryModel f7924d;

        /* compiled from: nmor_pages_commerce */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FB4AGraphSearchUserWithFiltersQueryModel.class, new Deserializer());
            }

            public Object m8362a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = FB4AGraphSearchUserWithFiltersQueryParser.m8474a(jsonParser);
                Object fB4AGraphSearchUserWithFiltersQueryModel = new FB4AGraphSearchUserWithFiltersQueryModel();
                ((BaseModel) fB4AGraphSearchUserWithFiltersQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (fB4AGraphSearchUserWithFiltersQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) fB4AGraphSearchUserWithFiltersQueryModel).a();
                }
                return fB4AGraphSearchUserWithFiltersQueryModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -333054413)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: nmor_pages_commerce */
        public final class FilteredQueryModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
            @Nullable
            private String f7921d;
            @Nullable
            private List<FB4AGraphSearchFilterInfoFragmentModel> f7922e;
            @Nullable
            private ResultsModel f7923f;

            /* compiled from: nmor_pages_commerce */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(FilteredQueryModel.class, new Deserializer());
                }

                public Object m8363a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(FilteredQueryParser.m8472a(jsonParser, flatBufferBuilder));
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

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 689623146)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: nmor_pages_commerce */
            public final class ResultsModel extends BaseModel implements GraphQLVisitableModel {
                private int f7918d;
                @Nullable
                private List<EdgesModel> f7919e;
                @Nullable
                private PageInfoModel f7920f;

                /* compiled from: nmor_pages_commerce */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(ResultsModel.class, new Deserializer());
                    }

                    public Object m8364a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(ResultsParser.m8470a(jsonParser, flatBufferBuilder));
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
                @ModelWithFlatBufferFormatHash(a = -685156083)
                @JsonSerialize(using = Serializer.class)
                @FragmentModelWithoutBridge
                /* compiled from: nmor_pages_commerce */
                public final class EdgesModel extends BaseModel implements GraphQLVisitableModel {
                    @Nullable
                    private NodeModel f7912d;
                    @Nullable
                    private FB4AGraphSearchUserResultDecorationModel f7913e;

                    /* compiled from: nmor_pages_commerce */
                    public class Deserializer extends FbJsonDeserializer {
                        static {
                            GlobalAutoGenDeserializerCache.a(EdgesModel.class, new Deserializer());
                        }

                        public Object m8365a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(ResultsParser.EdgesParser.m8466b(jsonParser, flatBufferBuilder));
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
                    @ModelWithFlatBufferFormatHash(a = 731488227)
                    @JsonSerialize(using = Serializer.class)
                    @FragmentModelWithoutBridge
                    /* compiled from: nmor_pages_commerce */
                    public final class NodeModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
                        @Nullable
                        private GraphQLObjectType f7904d;
                        @Nullable
                        private GroupIconModel f7905e;
                        @Nullable
                        private GroupPhotorealisticIconModel f7906f;
                        @Nullable
                        private String f7907g;
                        private boolean f7908h;
                        @Nullable
                        private String f7909i;
                        @Nullable
                        private DefaultImageFieldsModel f7910j;
                        @Nullable
                        private GraphQLSavedState f7911k;

                        /* compiled from: nmor_pages_commerce */
                        public class Deserializer extends FbJsonDeserializer {
                            static {
                                GlobalAutoGenDeserializerCache.a(NodeModel.class, new Deserializer());
                            }

                            public Object m8366a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(NodeParser.m8464a(jsonParser, flatBufferBuilder));
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

                        @JsonDeserialize(using = Deserializer.class)
                        @ModelWithFlatBufferFormatHash(a = 662747957)
                        @JsonSerialize(using = Serializer.class)
                        @FragmentModelWithoutBridge
                        /* compiled from: nmor_pages_commerce */
                        public final class GroupIconModel extends BaseModel implements GraphQLVisitableModel {
                            @Nullable
                            private DarkIconModel f7902d;

                            @JsonDeserialize(using = Deserializer.class)
                            @ModelWithFlatBufferFormatHash(a = 842551240)
                            @JsonSerialize(using = Serializer.class)
                            @FragmentModelWithoutBridge
                            /* compiled from: nmor_pages_commerce */
                            public final class DarkIconModel extends BaseModel implements GraphQLVisitableModel {
                                @Nullable
                                private String f7901d;

                                /* compiled from: nmor_pages_commerce */
                                public class Deserializer extends FbJsonDeserializer {
                                    static {
                                        GlobalAutoGenDeserializerCache.a(DarkIconModel.class, new Deserializer());
                                    }

                                    public Object m8367a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                        flatBufferBuilder.d(DarkIconParser.m8458a(jsonParser, flatBufferBuilder));
                                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                        wrap.position(0);
                                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                                        Object darkIconModel = new DarkIconModel();
                                        ((BaseModel) darkIconModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                                        if (darkIconModel instanceof Postprocessable) {
                                            return ((Postprocessable) darkIconModel).a();
                                        }
                                        return darkIconModel;
                                    }
                                }

                                /* compiled from: nmor_pages_commerce */
                                public class Serializer extends JsonSerializer<DarkIconModel> {
                                    public final void m8368a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                                        DarkIconModel darkIconModel = (DarkIconModel) obj;
                                        if (darkIconModel.w_() == null) {
                                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                            flatBufferBuilder.d(darkIconModel.m8370a(flatBufferBuilder));
                                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                            wrap.position(0);
                                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                            darkIconModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                                        }
                                        DarkIconParser.m8459a(darkIconModel.w_(), darkIconModel.u_(), jsonGenerator);
                                    }

                                    static {
                                        FbSerializerProvider.a(DarkIconModel.class, new Serializer());
                                    }
                                }

                                public DarkIconModel() {
                                    super(1);
                                }

                                @Nullable
                                private String m8369a() {
                                    this.f7901d = super.a(this.f7901d, 0);
                                    return this.f7901d;
                                }

                                public final int jK_() {
                                    return 2273433;
                                }

                                public final GraphQLVisitableModel m8371a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                                    h();
                                    i();
                                    return this;
                                }

                                public final int m8370a(FlatBufferBuilder flatBufferBuilder) {
                                    h();
                                    int b = flatBufferBuilder.b(m8369a());
                                    flatBufferBuilder.c(1);
                                    flatBufferBuilder.b(0, b);
                                    i();
                                    return flatBufferBuilder.d();
                                }
                            }

                            /* compiled from: nmor_pages_commerce */
                            public class Deserializer extends FbJsonDeserializer {
                                static {
                                    GlobalAutoGenDeserializerCache.a(GroupIconModel.class, new Deserializer());
                                }

                                public Object m8372a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                    flatBufferBuilder.d(GroupIconParser.m8460a(jsonParser, flatBufferBuilder));
                                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                    wrap.position(0);
                                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                                    Object groupIconModel = new GroupIconModel();
                                    ((BaseModel) groupIconModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                                    if (groupIconModel instanceof Postprocessable) {
                                        return ((Postprocessable) groupIconModel).a();
                                    }
                                    return groupIconModel;
                                }
                            }

                            /* compiled from: nmor_pages_commerce */
                            public class Serializer extends JsonSerializer<GroupIconModel> {
                                public final void m8373a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                                    GroupIconModel groupIconModel = (GroupIconModel) obj;
                                    if (groupIconModel.w_() == null) {
                                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                        flatBufferBuilder.d(groupIconModel.m8375a(flatBufferBuilder));
                                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                        wrap.position(0);
                                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                        groupIconModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                                    }
                                    GroupIconParser.m8461a(groupIconModel.w_(), groupIconModel.u_(), jsonGenerator, serializerProvider);
                                }

                                static {
                                    FbSerializerProvider.a(GroupIconModel.class, new Serializer());
                                }
                            }

                            public GroupIconModel() {
                                super(1);
                            }

                            @Nullable
                            private DarkIconModel m8374a() {
                                this.f7902d = (DarkIconModel) super.a(this.f7902d, 0, DarkIconModel.class);
                                return this.f7902d;
                            }

                            public final int jK_() {
                                return -452718528;
                            }

                            public final GraphQLVisitableModel m8376a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                                GraphQLVisitableModel graphQLVisitableModel = null;
                                h();
                                if (m8374a() != null) {
                                    DarkIconModel darkIconModel = (DarkIconModel) graphQLModelMutatingVisitor.b(m8374a());
                                    if (m8374a() != darkIconModel) {
                                        graphQLVisitableModel = (GroupIconModel) ModelHelper.a(null, this);
                                        graphQLVisitableModel.f7902d = darkIconModel;
                                    }
                                }
                                i();
                                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                            }

                            public final int m8375a(FlatBufferBuilder flatBufferBuilder) {
                                h();
                                int a = ModelHelper.a(flatBufferBuilder, m8374a());
                                flatBufferBuilder.c(1);
                                flatBufferBuilder.b(0, a);
                                i();
                                return flatBufferBuilder.d();
                            }
                        }

                        @JsonDeserialize(using = Deserializer.class)
                        @ModelWithFlatBufferFormatHash(a = 842551240)
                        @JsonSerialize(using = Serializer.class)
                        @FragmentModelWithoutBridge
                        /* compiled from: nmor_pages_commerce */
                        public final class GroupPhotorealisticIconModel extends BaseModel implements GraphQLVisitableModel {
                            @Nullable
                            private String f7903d;

                            /* compiled from: nmor_pages_commerce */
                            public class Deserializer extends FbJsonDeserializer {
                                static {
                                    GlobalAutoGenDeserializerCache.a(GroupPhotorealisticIconModel.class, new Deserializer());
                                }

                                public Object m8377a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                    flatBufferBuilder.d(GroupPhotorealisticIconParser.m8462a(jsonParser, flatBufferBuilder));
                                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                    wrap.position(0);
                                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                                    Object groupPhotorealisticIconModel = new GroupPhotorealisticIconModel();
                                    ((BaseModel) groupPhotorealisticIconModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                                    if (groupPhotorealisticIconModel instanceof Postprocessable) {
                                        return ((Postprocessable) groupPhotorealisticIconModel).a();
                                    }
                                    return groupPhotorealisticIconModel;
                                }
                            }

                            /* compiled from: nmor_pages_commerce */
                            public class Serializer extends JsonSerializer<GroupPhotorealisticIconModel> {
                                public final void m8378a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                                    GroupPhotorealisticIconModel groupPhotorealisticIconModel = (GroupPhotorealisticIconModel) obj;
                                    if (groupPhotorealisticIconModel.w_() == null) {
                                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                        flatBufferBuilder.d(groupPhotorealisticIconModel.m8379a(flatBufferBuilder));
                                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                        wrap.position(0);
                                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                        groupPhotorealisticIconModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                                    }
                                    GroupPhotorealisticIconParser.m8463a(groupPhotorealisticIconModel.w_(), groupPhotorealisticIconModel.u_(), jsonGenerator);
                                }

                                static {
                                    FbSerializerProvider.a(GroupPhotorealisticIconModel.class, new Serializer());
                                }
                            }

                            public GroupPhotorealisticIconModel() {
                                super(1);
                            }

                            @Nullable
                            public final String m8381a() {
                                this.f7903d = super.a(this.f7903d, 0);
                                return this.f7903d;
                            }

                            public final int jK_() {
                                return 70760763;
                            }

                            public final GraphQLVisitableModel m8380a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                                h();
                                i();
                                return this;
                            }

                            public final int m8379a(FlatBufferBuilder flatBufferBuilder) {
                                h();
                                int b = flatBufferBuilder.b(m8381a());
                                flatBufferBuilder.c(1);
                                flatBufferBuilder.b(0, b);
                                i();
                                return flatBufferBuilder.d();
                            }
                        }

                        /* compiled from: nmor_pages_commerce */
                        public class Serializer extends JsonSerializer<NodeModel> {
                            public final void m8382a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                                NodeModel nodeModel = (NodeModel) obj;
                                if (nodeModel.w_() == null) {
                                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                    flatBufferBuilder.d(nodeModel.m8388a(flatBufferBuilder));
                                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                    wrap.position(0);
                                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                    nodeModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                                }
                                NodeParser.m8465a(nodeModel.w_(), nodeModel.u_(), jsonGenerator, serializerProvider);
                            }

                            static {
                                FbSerializerProvider.a(NodeModel.class, new Serializer());
                            }
                        }

                        @Nullable
                        public final /* synthetic */ GroupPhotorealisticIconModel m8395c() {
                            return m8385k();
                        }

                        @Nullable
                        public final /* synthetic */ DefaultImageFields jw_() {
                            return m8386l();
                        }

                        public NodeModel() {
                            super(8);
                        }

                        public final void m8392a(String str, ConsistencyTuple consistencyTuple) {
                            if ("viewer_saved_state".equals(str)) {
                                consistencyTuple.a = m8387m();
                                consistencyTuple.b = u_();
                                consistencyTuple.c = 7;
                                return;
                            }
                            consistencyTuple.a();
                        }

                        public final void m8393a(String str, Object obj, boolean z) {
                            if ("viewer_saved_state".equals(str)) {
                                m8383a((GraphQLSavedState) obj);
                            }
                        }

                        @Nullable
                        public final GraphQLObjectType m8394b() {
                            if (this.b != null && this.f7904d == null) {
                                this.f7904d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                            }
                            return this.f7904d;
                        }

                        @Nullable
                        private GroupIconModel m8384j() {
                            this.f7905e = (GroupIconModel) super.a(this.f7905e, 1, GroupIconModel.class);
                            return this.f7905e;
                        }

                        @Nullable
                        private GroupPhotorealisticIconModel m8385k() {
                            this.f7906f = (GroupPhotorealisticIconModel) super.a(this.f7906f, 2, GroupPhotorealisticIconModel.class);
                            return this.f7906f;
                        }

                        @Nullable
                        public final String m8396d() {
                            this.f7907g = super.a(this.f7907g, 3);
                            return this.f7907g;
                        }

                        public final boolean jv_() {
                            a(0, 4);
                            return this.f7908h;
                        }

                        @Nullable
                        public final String m8397g() {
                            this.f7909i = super.a(this.f7909i, 5);
                            return this.f7909i;
                        }

                        @Nullable
                        private DefaultImageFieldsModel m8386l() {
                            this.f7910j = (DefaultImageFieldsModel) super.a(this.f7910j, 6, DefaultImageFieldsModel.class);
                            return this.f7910j;
                        }

                        @Nullable
                        private GraphQLSavedState m8387m() {
                            this.f7911k = (GraphQLSavedState) super.b(this.f7911k, 7, GraphQLSavedState.class, GraphQLSavedState.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                            return this.f7911k;
                        }

                        private void m8383a(GraphQLSavedState graphQLSavedState) {
                            this.f7911k = graphQLSavedState;
                            if (this.b != null && this.b.d) {
                                this.b.a(this.c, 7, graphQLSavedState != null ? graphQLSavedState.name() : null);
                            }
                        }

                        @Nullable
                        public final String m8390a() {
                            return m8396d();
                        }

                        public final int jK_() {
                            return 2433570;
                        }

                        public final GraphQLVisitableModel m8389a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                            GraphQLVisitableModel graphQLVisitableModel = null;
                            h();
                            if (m8384j() != null) {
                                GroupIconModel groupIconModel = (GroupIconModel) graphQLModelMutatingVisitor.b(m8384j());
                                if (m8384j() != groupIconModel) {
                                    graphQLVisitableModel = (NodeModel) ModelHelper.a(null, this);
                                    graphQLVisitableModel.f7905e = groupIconModel;
                                }
                            }
                            if (m8385k() != null) {
                                GroupPhotorealisticIconModel groupPhotorealisticIconModel = (GroupPhotorealisticIconModel) graphQLModelMutatingVisitor.b(m8385k());
                                if (m8385k() != groupPhotorealisticIconModel) {
                                    graphQLVisitableModel = (NodeModel) ModelHelper.a(graphQLVisitableModel, this);
                                    graphQLVisitableModel.f7906f = groupPhotorealisticIconModel;
                                }
                            }
                            if (m8386l() != null) {
                                DefaultImageFieldsModel defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m8386l());
                                if (m8386l() != defaultImageFieldsModel) {
                                    graphQLVisitableModel = (NodeModel) ModelHelper.a(graphQLVisitableModel, this);
                                    graphQLVisitableModel.f7910j = defaultImageFieldsModel;
                                }
                            }
                            i();
                            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                        }

                        public final int m8388a(FlatBufferBuilder flatBufferBuilder) {
                            h();
                            int a = ModelHelper.a(flatBufferBuilder, m8394b());
                            int a2 = ModelHelper.a(flatBufferBuilder, m8384j());
                            int a3 = ModelHelper.a(flatBufferBuilder, m8385k());
                            int b = flatBufferBuilder.b(m8396d());
                            int b2 = flatBufferBuilder.b(m8397g());
                            int a4 = ModelHelper.a(flatBufferBuilder, m8386l());
                            int a5 = flatBufferBuilder.a(m8387m());
                            flatBufferBuilder.c(8);
                            flatBufferBuilder.b(0, a);
                            flatBufferBuilder.b(1, a2);
                            flatBufferBuilder.b(2, a3);
                            flatBufferBuilder.b(3, b);
                            flatBufferBuilder.a(4, this.f7908h);
                            flatBufferBuilder.b(5, b2);
                            flatBufferBuilder.b(6, a4);
                            flatBufferBuilder.b(7, a5);
                            i();
                            return flatBufferBuilder.d();
                        }

                        public final void m8391a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                            super.a(mutableFlatBuffer, i, obj);
                            this.f7908h = mutableFlatBuffer.a(i, 4);
                        }
                    }

                    /* compiled from: nmor_pages_commerce */
                    public class Serializer extends JsonSerializer<EdgesModel> {
                        public final void m8398a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            EdgesModel edgesModel = (EdgesModel) obj;
                            if (edgesModel.w_() == null) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(edgesModel.m8401a(flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                edgesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                            }
                            ResultsParser.EdgesParser.m8467b(edgesModel.w_(), edgesModel.u_(), jsonGenerator, serializerProvider);
                        }

                        static {
                            FbSerializerProvider.a(EdgesModel.class, new Serializer());
                        }
                    }

                    @Nullable
                    public final /* synthetic */ NodeModel m8403a() {
                        return m8399j();
                    }

                    @Nullable
                    public final /* synthetic */ FB4AGraphSearchUserResultDecorationModel m8404b() {
                        return m8400k();
                    }

                    public EdgesModel() {
                        super(2);
                    }

                    @Nullable
                    private NodeModel m8399j() {
                        this.f7912d = (NodeModel) super.a(this.f7912d, 0, NodeModel.class);
                        return this.f7912d;
                    }

                    @Nullable
                    private FB4AGraphSearchUserResultDecorationModel m8400k() {
                        this.f7913e = (FB4AGraphSearchUserResultDecorationModel) super.a(this.f7913e, 1, FB4AGraphSearchUserResultDecorationModel.class);
                        return this.f7913e;
                    }

                    public final int jK_() {
                        return -316863363;
                    }

                    public final GraphQLVisitableModel m8402a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                        GraphQLVisitableModel graphQLVisitableModel = null;
                        h();
                        if (m8399j() != null) {
                            NodeModel nodeModel = (NodeModel) graphQLModelMutatingVisitor.b(m8399j());
                            if (m8399j() != nodeModel) {
                                graphQLVisitableModel = (EdgesModel) ModelHelper.a(null, this);
                                graphQLVisitableModel.f7912d = nodeModel;
                            }
                        }
                        if (m8400k() != null) {
                            FB4AGraphSearchUserResultDecorationModel fB4AGraphSearchUserResultDecorationModel = (FB4AGraphSearchUserResultDecorationModel) graphQLModelMutatingVisitor.b(m8400k());
                            if (m8400k() != fB4AGraphSearchUserResultDecorationModel) {
                                graphQLVisitableModel = (EdgesModel) ModelHelper.a(graphQLVisitableModel, this);
                                graphQLVisitableModel.f7913e = fB4AGraphSearchUserResultDecorationModel;
                            }
                        }
                        i();
                        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                    }

                    public final int m8401a(FlatBufferBuilder flatBufferBuilder) {
                        h();
                        int a = ModelHelper.a(flatBufferBuilder, m8399j());
                        int a2 = ModelHelper.a(flatBufferBuilder, m8400k());
                        flatBufferBuilder.c(2);
                        flatBufferBuilder.b(0, a);
                        flatBufferBuilder.b(1, a2);
                        i();
                        return flatBufferBuilder.d();
                    }
                }

                @JsonDeserialize(using = Deserializer.class)
                @ModelWithFlatBufferFormatHash(a = 921619519)
                @JsonSerialize(using = Serializer.class)
                @FragmentModelWithoutBridge
                /* compiled from: nmor_pages_commerce */
                public final class PageInfoModel extends BaseModel implements GraphQLVisitableModel {
                    @Nullable
                    private String f7914d;
                    private boolean f7915e;
                    private boolean f7916f;
                    @Nullable
                    private String f7917g;

                    /* compiled from: nmor_pages_commerce */
                    public class Deserializer extends FbJsonDeserializer {
                        static {
                            GlobalAutoGenDeserializerCache.a(PageInfoModel.class, new Deserializer());
                        }

                        public Object m8405a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(PageInfoParser.m8468a(jsonParser, flatBufferBuilder));
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

                    /* compiled from: nmor_pages_commerce */
                    public class Serializer extends JsonSerializer<PageInfoModel> {
                        public final void m8406a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            PageInfoModel pageInfoModel = (PageInfoModel) obj;
                            if (pageInfoModel.w_() == null) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(pageInfoModel.m8408a(flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                pageInfoModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                            }
                            PageInfoParser.m8469a(pageInfoModel.w_(), pageInfoModel.u_(), jsonGenerator);
                        }

                        static {
                            FbSerializerProvider.a(PageInfoModel.class, new Serializer());
                        }
                    }

                    public PageInfoModel() {
                        super(4);
                    }

                    @Nullable
                    public final String m8410a() {
                        this.f7914d = super.a(this.f7914d, 0);
                        return this.f7914d;
                    }

                    public final boolean m8412j() {
                        a(0, 1);
                        return this.f7915e;
                    }

                    public final boolean m8413k() {
                        a(0, 2);
                        return this.f7916f;
                    }

                    @Nullable
                    private String m8407l() {
                        this.f7917g = super.a(this.f7917g, 3);
                        return this.f7917g;
                    }

                    public final int jK_() {
                        return 923779069;
                    }

                    public final GraphQLVisitableModel m8409a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                        h();
                        i();
                        return this;
                    }

                    public final int m8408a(FlatBufferBuilder flatBufferBuilder) {
                        h();
                        int b = flatBufferBuilder.b(m8410a());
                        int b2 = flatBufferBuilder.b(m8407l());
                        flatBufferBuilder.c(4);
                        flatBufferBuilder.b(0, b);
                        flatBufferBuilder.a(1, this.f7915e);
                        flatBufferBuilder.a(2, this.f7916f);
                        flatBufferBuilder.b(3, b2);
                        i();
                        return flatBufferBuilder.d();
                    }

                    public final void m8411a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                        super.a(mutableFlatBuffer, i, obj);
                        this.f7915e = mutableFlatBuffer.a(i, 1);
                        this.f7916f = mutableFlatBuffer.a(i, 2);
                    }
                }

                /* compiled from: nmor_pages_commerce */
                public class Serializer extends JsonSerializer<ResultsModel> {
                    public final void m8414a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        ResultsModel resultsModel = (ResultsModel) obj;
                        if (resultsModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(resultsModel.m8415a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            resultsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        ResultsParser.m8471a(resultsModel.w_(), resultsModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(ResultsModel.class, new Serializer());
                    }
                }

                public ResultsModel() {
                    super(3);
                }

                @Nonnull
                public final ImmutableList<EdgesModel> m8417a() {
                    this.f7919e = super.a(this.f7919e, 1, EdgesModel.class);
                    return (ImmutableList) this.f7919e;
                }

                @Nullable
                public final PageInfoModel m8419j() {
                    this.f7920f = (PageInfoModel) super.a(this.f7920f, 2, PageInfoModel.class);
                    return this.f7920f;
                }

                public final int jK_() {
                    return 1580207518;
                }

                public final GraphQLVisitableModel m8416a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel;
                    PageInfoModel pageInfoModel;
                    h();
                    if (m8417a() != null) {
                        Builder a = ModelHelper.a(m8417a(), graphQLModelMutatingVisitor);
                        if (a != null) {
                            ResultsModel resultsModel = (ResultsModel) ModelHelper.a(null, this);
                            resultsModel.f7919e = a.b();
                            graphQLVisitableModel = resultsModel;
                            if (m8419j() != null) {
                                pageInfoModel = (PageInfoModel) graphQLModelMutatingVisitor.b(m8419j());
                                if (m8419j() != pageInfoModel) {
                                    graphQLVisitableModel = (ResultsModel) ModelHelper.a(graphQLVisitableModel, this);
                                    graphQLVisitableModel.f7920f = pageInfoModel;
                                }
                            }
                            i();
                            return graphQLVisitableModel != null ? this : graphQLVisitableModel;
                        }
                    }
                    graphQLVisitableModel = null;
                    if (m8419j() != null) {
                        pageInfoModel = (PageInfoModel) graphQLModelMutatingVisitor.b(m8419j());
                        if (m8419j() != pageInfoModel) {
                            graphQLVisitableModel = (ResultsModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f7920f = pageInfoModel;
                        }
                    }
                    i();
                    if (graphQLVisitableModel != null) {
                    }
                }

                public final int m8415a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m8417a());
                    int a2 = ModelHelper.a(flatBufferBuilder, m8419j());
                    flatBufferBuilder.c(3);
                    flatBufferBuilder.a(0, this.f7918d, 0);
                    flatBufferBuilder.b(1, a);
                    flatBufferBuilder.b(2, a2);
                    i();
                    return flatBufferBuilder.d();
                }

                public final void m8418a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                    super.a(mutableFlatBuffer, i, obj);
                    this.f7918d = mutableFlatBuffer.a(i, 0, 0);
                }
            }

            /* compiled from: nmor_pages_commerce */
            public class Serializer extends JsonSerializer<FilteredQueryModel> {
                public final void m8420a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    FilteredQueryModel filteredQueryModel = (FilteredQueryModel) obj;
                    if (filteredQueryModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(filteredQueryModel.m8422a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        filteredQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    FilteredQueryParser.m8473a(filteredQueryModel.w_(), filteredQueryModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(FilteredQueryModel.class, new Serializer());
                }
            }

            public FilteredQueryModel() {
                super(3);
            }

            @Nullable
            private String m8421l() {
                this.f7921d = super.a(this.f7921d, 0);
                return this.f7921d;
            }

            @Nonnull
            public final ImmutableList<FB4AGraphSearchFilterInfoFragmentModel> m8425j() {
                this.f7922e = super.a(this.f7922e, 1, FB4AGraphSearchFilterInfoFragmentModel.class);
                return (ImmutableList) this.f7922e;
            }

            @Nullable
            public final ResultsModel m8426k() {
                this.f7923f = (ResultsModel) super.a(this.f7923f, 2, ResultsModel.class);
                return this.f7923f;
            }

            @Nullable
            public final String m8424a() {
                return m8421l();
            }

            public final int jK_() {
                return -466486798;
            }

            public final GraphQLVisitableModel m8423a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel;
                ResultsModel resultsModel;
                h();
                if (m8425j() != null) {
                    Builder a = ModelHelper.a(m8425j(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        FilteredQueryModel filteredQueryModel = (FilteredQueryModel) ModelHelper.a(null, this);
                        filteredQueryModel.f7922e = a.b();
                        graphQLVisitableModel = filteredQueryModel;
                        if (m8426k() != null) {
                            resultsModel = (ResultsModel) graphQLModelMutatingVisitor.b(m8426k());
                            if (m8426k() != resultsModel) {
                                graphQLVisitableModel = (FilteredQueryModel) ModelHelper.a(graphQLVisitableModel, this);
                                graphQLVisitableModel.f7923f = resultsModel;
                            }
                        }
                        i();
                        return graphQLVisitableModel != null ? this : graphQLVisitableModel;
                    }
                }
                graphQLVisitableModel = null;
                if (m8426k() != null) {
                    resultsModel = (ResultsModel) graphQLModelMutatingVisitor.b(m8426k());
                    if (m8426k() != resultsModel) {
                        graphQLVisitableModel = (FilteredQueryModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f7923f = resultsModel;
                    }
                }
                i();
                if (graphQLVisitableModel != null) {
                }
            }

            public final int m8422a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m8421l());
                int a = ModelHelper.a(flatBufferBuilder, m8425j());
                int a2 = ModelHelper.a(flatBufferBuilder, m8426k());
                flatBufferBuilder.c(3);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.b(1, a);
                flatBufferBuilder.b(2, a2);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: nmor_pages_commerce */
        public class Serializer extends JsonSerializer<FB4AGraphSearchUserWithFiltersQueryModel> {
            public final void m8427a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                FB4AGraphSearchUserWithFiltersQueryModel fB4AGraphSearchUserWithFiltersQueryModel = (FB4AGraphSearchUserWithFiltersQueryModel) obj;
                if (fB4AGraphSearchUserWithFiltersQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(fB4AGraphSearchUserWithFiltersQueryModel.m8428a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    fB4AGraphSearchUserWithFiltersQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = fB4AGraphSearchUserWithFiltersQueryModel.w_();
                int u_ = fB4AGraphSearchUserWithFiltersQueryModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("filtered_query");
                    FilteredQueryParser.m8473a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(FB4AGraphSearchUserWithFiltersQueryModel.class, new Serializer());
            }
        }

        public FB4AGraphSearchUserWithFiltersQueryModel() {
            super(1);
        }

        @Nullable
        public final FilteredQueryModel m8430a() {
            this.f7924d = (FilteredQueryModel) super.a(this.f7924d, 0, FilteredQueryModel.class);
            return this.f7924d;
        }

        public final int jK_() {
            return -466486798;
        }

        public final GraphQLVisitableModel m8429a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m8430a() != null) {
                FilteredQueryModel filteredQueryModel = (FilteredQueryModel) graphQLModelMutatingVisitor.b(m8430a());
                if (m8430a() != filteredQueryModel) {
                    graphQLVisitableModel = (FB4AGraphSearchUserWithFiltersQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f7924d = filteredQueryModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m8428a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m8430a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }
}
