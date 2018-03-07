package com.facebook.search.protocol.awareness;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLSearchAwarenessTemplatesEnum;
import com.facebook.graphql.enums.GraphQLSearchAwarenessTutorialNUXButtonStyle;
import com.facebook.graphql.enums.GraphQLSearchAwarenessTutorialNUXTemplate;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.search.protocol.awareness.SearchAwarenessInterfaces.SearchAwarenessSuggestionFieldsFragment;
import com.facebook.search.protocol.awareness.SearchAwarenessParsers.LearningNuxConfigurationParser;
import com.facebook.search.protocol.awareness.SearchAwarenessParsers.SearchAwarenessRootSuggestionFieldsFragmentParser;
import com.facebook.search.protocol.awareness.SearchAwarenessParsers.SearchAwarenessRootSuggestionFieldsFragmentParser.ChainedUnitsParser;
import com.facebook.search.protocol.awareness.SearchAwarenessParsers.SearchAwarenessSuggestionFieldsFragmentParser;
import com.facebook.search.protocol.awareness.SearchAwarenessParsers.TutorialNuxCardFieldsFragmentParser;
import com.facebook.search.protocol.awareness.SearchAwarenessParsers.TutorialNuxCarouselFieldsFragmentParser;
import com.facebook.search.protocol.awareness.SearchAwarenessParsers.TutorialNuxConfigurationParser;
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

/* compiled from: nearby_places_module */
public class SearchAwarenessModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1812665653)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: nearby_places_module */
    public final class LearningNuxConfigurationModel extends BaseModel implements GraphQLVisitableModel {
        private int f8116d;
        private boolean f8117e;
        @Nullable
        private SearchAwarenessRootSuggestionFieldsFragmentModel f8118f;

        /* compiled from: nearby_places_module */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(LearningNuxConfigurationModel.class, new Deserializer());
            }

            public Object m8996a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(LearningNuxConfigurationParser.m9071a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object learningNuxConfigurationModel = new LearningNuxConfigurationModel();
                ((BaseModel) learningNuxConfigurationModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (learningNuxConfigurationModel instanceof Postprocessable) {
                    return ((Postprocessable) learningNuxConfigurationModel).a();
                }
                return learningNuxConfigurationModel;
            }
        }

        /* compiled from: nearby_places_module */
        public class Serializer extends JsonSerializer<LearningNuxConfigurationModel> {
            public final void m8997a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                LearningNuxConfigurationModel learningNuxConfigurationModel = (LearningNuxConfigurationModel) obj;
                if (learningNuxConfigurationModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(learningNuxConfigurationModel.m8999a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    learningNuxConfigurationModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = learningNuxConfigurationModel.w_();
                int u_ = learningNuxConfigurationModel.u_();
                jsonGenerator.f();
                int a = mutableFlatBuffer.a(u_, 0, 0);
                if (a != 0) {
                    jsonGenerator.a("cool_down_hours");
                    jsonGenerator.b(a);
                }
                boolean a2 = mutableFlatBuffer.a(u_, 1);
                if (a2) {
                    jsonGenerator.a("has_impression_cap_reached");
                    jsonGenerator.a(a2);
                }
                a = mutableFlatBuffer.g(u_, 2);
                if (a != 0) {
                    jsonGenerator.a("suggestion");
                    SearchAwarenessRootSuggestionFieldsFragmentParser.m9075a(mutableFlatBuffer, a, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(LearningNuxConfigurationModel.class, new Serializer());
            }
        }

        public LearningNuxConfigurationModel() {
            super(3);
        }

        public final int m8998a() {
            a(0, 0);
            return this.f8116d;
        }

        public final boolean m9002j() {
            a(0, 1);
            return this.f8117e;
        }

        @Nullable
        public final SearchAwarenessRootSuggestionFieldsFragmentModel m9003k() {
            this.f8118f = (SearchAwarenessRootSuggestionFieldsFragmentModel) super.a(this.f8118f, 2, SearchAwarenessRootSuggestionFieldsFragmentModel.class);
            return this.f8118f;
        }

        public final int jK_() {
            return 111943814;
        }

        public final GraphQLVisitableModel m9000a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m9003k() != null) {
                SearchAwarenessRootSuggestionFieldsFragmentModel searchAwarenessRootSuggestionFieldsFragmentModel = (SearchAwarenessRootSuggestionFieldsFragmentModel) graphQLModelMutatingVisitor.b(m9003k());
                if (m9003k() != searchAwarenessRootSuggestionFieldsFragmentModel) {
                    graphQLVisitableModel = (LearningNuxConfigurationModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f8118f = searchAwarenessRootSuggestionFieldsFragmentModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m8999a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m9003k());
            flatBufferBuilder.c(3);
            flatBufferBuilder.a(0, this.f8116d, 0);
            flatBufferBuilder.a(1, this.f8117e);
            flatBufferBuilder.b(2, a);
            i();
            return flatBufferBuilder.d();
        }

        public final void m9001a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f8116d = mutableFlatBuffer.a(i, 0, 0);
            this.f8117e = mutableFlatBuffer.a(i, 1);
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 801461839)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: nearby_places_module */
    public final class SearchAwarenessRootSuggestionFieldsFragmentModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel, SearchAwarenessSuggestionFieldsFragment {
        @Nullable
        private ChainedUnitsModel f8120d;
        @Nullable
        private String f8121e;
        @Nullable
        private List<String> f8122f;
        @Nullable
        private String f8123g;
        @Nullable
        private GraphQLSearchAwarenessTemplatesEnum f8124h;
        @Nullable
        private String f8125i;
        @Nullable
        private String f8126j;

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -448926968)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: nearby_places_module */
        public final class ChainedUnitsModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<SearchAwarenessSuggestionFieldsFragmentModel> f8119d;

            /* compiled from: nearby_places_module */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(ChainedUnitsModel.class, new Deserializer());
                }

                public Object m9004a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(ChainedUnitsParser.m9072a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object chainedUnitsModel = new ChainedUnitsModel();
                    ((BaseModel) chainedUnitsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (chainedUnitsModel instanceof Postprocessable) {
                        return ((Postprocessable) chainedUnitsModel).a();
                    }
                    return chainedUnitsModel;
                }
            }

            /* compiled from: nearby_places_module */
            public class Serializer extends JsonSerializer<ChainedUnitsModel> {
                public final void m9005a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    ChainedUnitsModel chainedUnitsModel = (ChainedUnitsModel) obj;
                    if (chainedUnitsModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(chainedUnitsModel.m9006a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        chainedUnitsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    ChainedUnitsParser.m9073a(chainedUnitsModel.w_(), chainedUnitsModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(ChainedUnitsModel.class, new Serializer());
                }
            }

            public ChainedUnitsModel() {
                super(1);
            }

            @Nonnull
            public final ImmutableList<SearchAwarenessSuggestionFieldsFragmentModel> m9008a() {
                this.f8119d = super.a(this.f8119d, 0, SearchAwarenessSuggestionFieldsFragmentModel.class);
                return (ImmutableList) this.f8119d;
            }

            public final int jK_() {
                return 1753702873;
            }

            public final GraphQLVisitableModel m9007a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m9008a() != null) {
                    Builder a = ModelHelper.a(m9008a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (ChainedUnitsModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f8119d = a.b();
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m9006a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m9008a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: nearby_places_module */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(SearchAwarenessRootSuggestionFieldsFragmentModel.class, new Deserializer());
            }

            public Object m9009a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(SearchAwarenessRootSuggestionFieldsFragmentParser.m9074a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object searchAwarenessRootSuggestionFieldsFragmentModel = new SearchAwarenessRootSuggestionFieldsFragmentModel();
                ((BaseModel) searchAwarenessRootSuggestionFieldsFragmentModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (searchAwarenessRootSuggestionFieldsFragmentModel instanceof Postprocessable) {
                    return ((Postprocessable) searchAwarenessRootSuggestionFieldsFragmentModel).a();
                }
                return searchAwarenessRootSuggestionFieldsFragmentModel;
            }
        }

        /* compiled from: nearby_places_module */
        public class Serializer extends JsonSerializer<SearchAwarenessRootSuggestionFieldsFragmentModel> {
            public final void m9010a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                SearchAwarenessRootSuggestionFieldsFragmentModel searchAwarenessRootSuggestionFieldsFragmentModel = (SearchAwarenessRootSuggestionFieldsFragmentModel) obj;
                if (searchAwarenessRootSuggestionFieldsFragmentModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(searchAwarenessRootSuggestionFieldsFragmentModel.m9011a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    searchAwarenessRootSuggestionFieldsFragmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                SearchAwarenessRootSuggestionFieldsFragmentParser.m9075a(searchAwarenessRootSuggestionFieldsFragmentModel.w_(), searchAwarenessRootSuggestionFieldsFragmentModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(SearchAwarenessRootSuggestionFieldsFragmentModel.class, new Serializer());
            }
        }

        public SearchAwarenessRootSuggestionFieldsFragmentModel() {
            super(7);
        }

        @Nullable
        public final ChainedUnitsModel m9018j() {
            this.f8120d = (ChainedUnitsModel) super.a(this.f8120d, 0, ChainedUnitsModel.class);
            return this.f8120d;
        }

        @Nullable
        public final String mo557b() {
            this.f8121e = super.a(this.f8121e, 1);
            return this.f8121e;
        }

        @Nonnull
        public final ImmutableList<String> mo558c() {
            this.f8122f = super.a(this.f8122f, 2);
            return (ImmutableList) this.f8122f;
        }

        @Nullable
        public final String mo559d() {
            this.f8123g = super.a(this.f8123g, 3);
            return this.f8123g;
        }

        @Nullable
        public final GraphQLSearchAwarenessTemplatesEnum jF_() {
            this.f8124h = (GraphQLSearchAwarenessTemplatesEnum) super.b(this.f8124h, 4, GraphQLSearchAwarenessTemplatesEnum.class, GraphQLSearchAwarenessTemplatesEnum.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f8124h;
        }

        @Nullable
        public final String mo560g() {
            this.f8125i = super.a(this.f8125i, 5);
            return this.f8125i;
        }

        @Nullable
        public final String m9019k() {
            this.f8126j = super.a(this.f8126j, 6);
            return this.f8126j;
        }

        @Nullable
        public final String m9013a() {
            return mo557b();
        }

        public final int jK_() {
            return -1858617679;
        }

        public final GraphQLVisitableModel m9012a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m9018j() != null) {
                ChainedUnitsModel chainedUnitsModel = (ChainedUnitsModel) graphQLModelMutatingVisitor.b(m9018j());
                if (m9018j() != chainedUnitsModel) {
                    graphQLVisitableModel = (SearchAwarenessRootSuggestionFieldsFragmentModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f8120d = chainedUnitsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m9011a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m9018j());
            int b = flatBufferBuilder.b(mo557b());
            int c = flatBufferBuilder.c(mo558c());
            int b2 = flatBufferBuilder.b(mo559d());
            int a2 = flatBufferBuilder.a(jF_());
            int b3 = flatBufferBuilder.b(mo560g());
            int b4 = flatBufferBuilder.b(m9019k());
            flatBufferBuilder.c(7);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, b);
            flatBufferBuilder.b(2, c);
            flatBufferBuilder.b(3, b2);
            flatBufferBuilder.b(4, a2);
            flatBufferBuilder.b(5, b3);
            flatBufferBuilder.b(6, b4);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 350374730)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: nearby_places_module */
    public final class SearchAwarenessSuggestionFieldsFragmentModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel, SearchAwarenessSuggestionFieldsFragment {
        @Nullable
        private String f8127d;
        @Nullable
        private List<String> f8128e;
        @Nullable
        private String f8129f;
        @Nullable
        private GraphQLSearchAwarenessTemplatesEnum f8130g;
        @Nullable
        private String f8131h;

        /* compiled from: nearby_places_module */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(SearchAwarenessSuggestionFieldsFragmentModel.class, new Deserializer());
            }

            public Object m9020a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(SearchAwarenessSuggestionFieldsFragmentParser.m9077b(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object searchAwarenessSuggestionFieldsFragmentModel = new SearchAwarenessSuggestionFieldsFragmentModel();
                ((BaseModel) searchAwarenessSuggestionFieldsFragmentModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (searchAwarenessSuggestionFieldsFragmentModel instanceof Postprocessable) {
                    return ((Postprocessable) searchAwarenessSuggestionFieldsFragmentModel).a();
                }
                return searchAwarenessSuggestionFieldsFragmentModel;
            }
        }

        /* compiled from: nearby_places_module */
        public class Serializer extends JsonSerializer<SearchAwarenessSuggestionFieldsFragmentModel> {
            public final void m9021a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                SearchAwarenessSuggestionFieldsFragmentModel searchAwarenessSuggestionFieldsFragmentModel = (SearchAwarenessSuggestionFieldsFragmentModel) obj;
                if (searchAwarenessSuggestionFieldsFragmentModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(searchAwarenessSuggestionFieldsFragmentModel.m9022a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    searchAwarenessSuggestionFieldsFragmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                SearchAwarenessSuggestionFieldsFragmentParser.m9076a(searchAwarenessSuggestionFieldsFragmentModel.w_(), searchAwarenessSuggestionFieldsFragmentModel.u_(), jsonGenerator);
            }

            static {
                FbSerializerProvider.a(SearchAwarenessSuggestionFieldsFragmentModel.class, new Serializer());
            }
        }

        public SearchAwarenessSuggestionFieldsFragmentModel() {
            super(5);
        }

        @Nullable
        public final String mo557b() {
            this.f8127d = super.a(this.f8127d, 0);
            return this.f8127d;
        }

        @Nonnull
        public final ImmutableList<String> mo558c() {
            this.f8128e = super.a(this.f8128e, 1);
            return (ImmutableList) this.f8128e;
        }

        @Nullable
        public final String mo559d() {
            this.f8129f = super.a(this.f8129f, 2);
            return this.f8129f;
        }

        @Nullable
        public final GraphQLSearchAwarenessTemplatesEnum jF_() {
            this.f8130g = (GraphQLSearchAwarenessTemplatesEnum) super.b(this.f8130g, 3, GraphQLSearchAwarenessTemplatesEnum.class, GraphQLSearchAwarenessTemplatesEnum.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f8130g;
        }

        @Nullable
        public final String mo560g() {
            this.f8131h = super.a(this.f8131h, 4);
            return this.f8131h;
        }

        @Nullable
        public final String m9024a() {
            return mo557b();
        }

        public final int jK_() {
            return -1858617679;
        }

        public final GraphQLVisitableModel m9023a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m9022a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(mo557b());
            int c = flatBufferBuilder.c(mo558c());
            int b2 = flatBufferBuilder.b(mo559d());
            int a = flatBufferBuilder.a(jF_());
            int b3 = flatBufferBuilder.b(mo560g());
            flatBufferBuilder.c(5);
            flatBufferBuilder.b(0, b);
            flatBufferBuilder.b(1, c);
            flatBufferBuilder.b(2, b2);
            flatBufferBuilder.b(3, a);
            flatBufferBuilder.b(4, b3);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1815230929)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: nearby_places_module */
    public final class TutorialNuxCardFieldsFragmentModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private String f8141d;
        @Nullable
        private String f8142e;
        @Nullable
        private String f8143f;
        @Nullable
        private String f8144g;
        @Nullable
        private String f8145h;
        @Nullable
        private String f8146i;
        @Nullable
        private String f8147j;
        @Nullable
        private String f8148k;
        @Nullable
        private GraphQLSearchAwarenessTutorialNUXTemplate f8149l;

        /* compiled from: nearby_places_module */
        public final class Builder {
            @Nullable
            public String f8132a;
            @Nullable
            public String f8133b;
            @Nullable
            public String f8134c;
            @Nullable
            public String f8135d;
            @Nullable
            public String f8136e;
            @Nullable
            public String f8137f;
            @Nullable
            public String f8138g;
            @Nullable
            public String f8139h;
            @Nullable
            public GraphQLSearchAwarenessTutorialNUXTemplate f8140i;

            public final TutorialNuxCardFieldsFragmentModel m9029a() {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int b = flatBufferBuilder.b(this.f8132a);
                int b2 = flatBufferBuilder.b(this.f8133b);
                int b3 = flatBufferBuilder.b(this.f8134c);
                int b4 = flatBufferBuilder.b(this.f8135d);
                int b5 = flatBufferBuilder.b(this.f8136e);
                int b6 = flatBufferBuilder.b(this.f8137f);
                int b7 = flatBufferBuilder.b(this.f8138g);
                int b8 = flatBufferBuilder.b(this.f8139h);
                int a = flatBufferBuilder.a(this.f8140i);
                flatBufferBuilder.c(9);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.b(1, b2);
                flatBufferBuilder.b(2, b3);
                flatBufferBuilder.b(3, b4);
                flatBufferBuilder.b(4, b5);
                flatBufferBuilder.b(5, b6);
                flatBufferBuilder.b(6, b7);
                flatBufferBuilder.b(7, b8);
                flatBufferBuilder.b(8, a);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new TutorialNuxCardFieldsFragmentModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }
        }

        /* compiled from: nearby_places_module */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(TutorialNuxCardFieldsFragmentModel.class, new Deserializer());
            }

            public Object m9030a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(TutorialNuxCardFieldsFragmentParser.m9079b(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object tutorialNuxCardFieldsFragmentModel = new TutorialNuxCardFieldsFragmentModel();
                ((BaseModel) tutorialNuxCardFieldsFragmentModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (tutorialNuxCardFieldsFragmentModel instanceof Postprocessable) {
                    return ((Postprocessable) tutorialNuxCardFieldsFragmentModel).a();
                }
                return tutorialNuxCardFieldsFragmentModel;
            }
        }

        /* compiled from: nearby_places_module */
        public class Serializer extends JsonSerializer<TutorialNuxCardFieldsFragmentModel> {
            public final void m9031a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                TutorialNuxCardFieldsFragmentModel tutorialNuxCardFieldsFragmentModel = (TutorialNuxCardFieldsFragmentModel) obj;
                if (tutorialNuxCardFieldsFragmentModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(tutorialNuxCardFieldsFragmentModel.m9032a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    tutorialNuxCardFieldsFragmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                TutorialNuxCardFieldsFragmentParser.m9078a(tutorialNuxCardFieldsFragmentModel.w_(), tutorialNuxCardFieldsFragmentModel.u_(), jsonGenerator);
            }

            static {
                FbSerializerProvider.a(TutorialNuxCardFieldsFragmentModel.class, new Serializer());
            }
        }

        public TutorialNuxCardFieldsFragmentModel() {
            super(9);
        }

        public TutorialNuxCardFieldsFragmentModel(MutableFlatBuffer mutableFlatBuffer) {
            super(9);
            a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }

        @Nullable
        public final String m9034a() {
            this.f8141d = super.a(this.f8141d, 0);
            return this.f8141d;
        }

        @Nullable
        public final String m9035j() {
            this.f8142e = super.a(this.f8142e, 1);
            return this.f8142e;
        }

        @Nullable
        public final String m9036k() {
            this.f8143f = super.a(this.f8143f, 2);
            return this.f8143f;
        }

        @Nullable
        public final String m9037l() {
            this.f8144g = super.a(this.f8144g, 3);
            return this.f8144g;
        }

        @Nullable
        public final String m9038m() {
            this.f8145h = super.a(this.f8145h, 4);
            return this.f8145h;
        }

        @Nullable
        public final String m9039n() {
            this.f8146i = super.a(this.f8146i, 5);
            return this.f8146i;
        }

        @Nullable
        public final String m9040o() {
            this.f8147j = super.a(this.f8147j, 6);
            return this.f8147j;
        }

        @Nullable
        public final String m9041p() {
            this.f8148k = super.a(this.f8148k, 7);
            return this.f8148k;
        }

        @Nullable
        public final GraphQLSearchAwarenessTutorialNUXTemplate m9042q() {
            this.f8149l = (GraphQLSearchAwarenessTutorialNUXTemplate) super.b(this.f8149l, 8, GraphQLSearchAwarenessTutorialNUXTemplate.class, GraphQLSearchAwarenessTutorialNUXTemplate.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f8149l;
        }

        public final int jK_() {
            return -134751114;
        }

        public final GraphQLVisitableModel m9033a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m9032a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m9034a());
            int b2 = flatBufferBuilder.b(m9035j());
            int b3 = flatBufferBuilder.b(m9036k());
            int b4 = flatBufferBuilder.b(m9037l());
            int b5 = flatBufferBuilder.b(m9038m());
            int b6 = flatBufferBuilder.b(m9039n());
            int b7 = flatBufferBuilder.b(m9040o());
            int b8 = flatBufferBuilder.b(m9041p());
            int a = flatBufferBuilder.a(m9042q());
            flatBufferBuilder.c(9);
            flatBufferBuilder.b(0, b);
            flatBufferBuilder.b(1, b2);
            flatBufferBuilder.b(2, b3);
            flatBufferBuilder.b(3, b4);
            flatBufferBuilder.b(4, b5);
            flatBufferBuilder.b(5, b6);
            flatBufferBuilder.b(6, b7);
            flatBufferBuilder.b(7, b8);
            flatBufferBuilder.b(8, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1742801690)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: nearby_places_module */
    public final class TutorialNuxCarouselFieldsFragmentModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private GraphQLSearchAwarenessTutorialNUXButtonStyle f8161d;
        @Nullable
        private List<TutorialNuxCardFieldsFragmentModel> f8162e;
        @Nullable
        private String f8163f;
        @Nullable
        private String f8164g;
        @Nullable
        private String f8165h;
        @Nullable
        private String f8166i;
        @Nullable
        private String f8167j;
        @Nullable
        private String f8168k;
        @Nullable
        private String f8169l;
        @Nullable
        private String f8170m;
        @Nullable
        private String f8171n;

        /* compiled from: nearby_places_module */
        public final class Builder {
            @Nullable
            public GraphQLSearchAwarenessTutorialNUXButtonStyle f8150a;
            @Nullable
            public ImmutableList<TutorialNuxCardFieldsFragmentModel> f8151b;
            @Nullable
            public String f8152c;
            @Nullable
            public String f8153d;
            @Nullable
            public String f8154e;
            @Nullable
            public String f8155f;
            @Nullable
            public String f8156g;
            @Nullable
            public String f8157h;
            @Nullable
            public String f8158i;
            @Nullable
            public String f8159j;
            @Nullable
            public String f8160k;

            public final TutorialNuxCarouselFieldsFragmentModel m9043a() {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int a = flatBufferBuilder.a(this.f8150a);
                int a2 = ModelHelper.a(flatBufferBuilder, this.f8151b);
                int b = flatBufferBuilder.b(this.f8152c);
                int b2 = flatBufferBuilder.b(this.f8153d);
                int b3 = flatBufferBuilder.b(this.f8154e);
                int b4 = flatBufferBuilder.b(this.f8155f);
                int b5 = flatBufferBuilder.b(this.f8156g);
                int b6 = flatBufferBuilder.b(this.f8157h);
                int b7 = flatBufferBuilder.b(this.f8158i);
                int b8 = flatBufferBuilder.b(this.f8159j);
                int b9 = flatBufferBuilder.b(this.f8160k);
                flatBufferBuilder.c(11);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, a2);
                flatBufferBuilder.b(2, b);
                flatBufferBuilder.b(3, b2);
                flatBufferBuilder.b(4, b3);
                flatBufferBuilder.b(5, b4);
                flatBufferBuilder.b(6, b5);
                flatBufferBuilder.b(7, b6);
                flatBufferBuilder.b(8, b7);
                flatBufferBuilder.b(9, b8);
                flatBufferBuilder.b(10, b9);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new TutorialNuxCarouselFieldsFragmentModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }
        }

        /* compiled from: nearby_places_module */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(TutorialNuxCarouselFieldsFragmentModel.class, new Deserializer());
            }

            public Object m9044a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(TutorialNuxCarouselFieldsFragmentParser.m9080a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object tutorialNuxCarouselFieldsFragmentModel = new TutorialNuxCarouselFieldsFragmentModel();
                ((BaseModel) tutorialNuxCarouselFieldsFragmentModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (tutorialNuxCarouselFieldsFragmentModel instanceof Postprocessable) {
                    return ((Postprocessable) tutorialNuxCarouselFieldsFragmentModel).a();
                }
                return tutorialNuxCarouselFieldsFragmentModel;
            }
        }

        /* compiled from: nearby_places_module */
        public class Serializer extends JsonSerializer<TutorialNuxCarouselFieldsFragmentModel> {
            public final void m9045a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                TutorialNuxCarouselFieldsFragmentModel tutorialNuxCarouselFieldsFragmentModel = (TutorialNuxCarouselFieldsFragmentModel) obj;
                if (tutorialNuxCarouselFieldsFragmentModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(tutorialNuxCarouselFieldsFragmentModel.m9046a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    tutorialNuxCarouselFieldsFragmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                TutorialNuxCarouselFieldsFragmentParser.m9081a(tutorialNuxCarouselFieldsFragmentModel.w_(), tutorialNuxCarouselFieldsFragmentModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(TutorialNuxCarouselFieldsFragmentModel.class, new Serializer());
            }
        }

        public TutorialNuxCarouselFieldsFragmentModel() {
            super(11);
        }

        public TutorialNuxCarouselFieldsFragmentModel(MutableFlatBuffer mutableFlatBuffer) {
            super(11);
            a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }

        @Nullable
        public final GraphQLSearchAwarenessTutorialNUXButtonStyle m9047a() {
            this.f8161d = (GraphQLSearchAwarenessTutorialNUXButtonStyle) super.b(this.f8161d, 0, GraphQLSearchAwarenessTutorialNUXButtonStyle.class, GraphQLSearchAwarenessTutorialNUXButtonStyle.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f8161d;
        }

        @Nonnull
        public final ImmutableList<TutorialNuxCardFieldsFragmentModel> m9049j() {
            this.f8162e = super.a(this.f8162e, 1, TutorialNuxCardFieldsFragmentModel.class);
            return (ImmutableList) this.f8162e;
        }

        @Nullable
        public final String m9050k() {
            this.f8163f = super.a(this.f8163f, 2);
            return this.f8163f;
        }

        @Nullable
        public final String m9051l() {
            this.f8164g = super.a(this.f8164g, 3);
            return this.f8164g;
        }

        @Nullable
        public final String m9052m() {
            this.f8165h = super.a(this.f8165h, 4);
            return this.f8165h;
        }

        @Nullable
        public final String m9053n() {
            this.f8166i = super.a(this.f8166i, 5);
            return this.f8166i;
        }

        @Nullable
        public final String m9054o() {
            this.f8167j = super.a(this.f8167j, 6);
            return this.f8167j;
        }

        @Nullable
        public final String m9055p() {
            this.f8168k = super.a(this.f8168k, 7);
            return this.f8168k;
        }

        @Nullable
        public final String m9056q() {
            this.f8169l = super.a(this.f8169l, 8);
            return this.f8169l;
        }

        @Nullable
        public final String m9057r() {
            this.f8170m = super.a(this.f8170m, 9);
            return this.f8170m;
        }

        @Nullable
        public final String m9058s() {
            this.f8171n = super.a(this.f8171n, 10);
            return this.f8171n;
        }

        public final int jK_() {
            return 1207607238;
        }

        public final GraphQLVisitableModel m9048a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m9049j() != null) {
                com.google.common.collect.ImmutableList.Builder a = ModelHelper.a(m9049j(), graphQLModelMutatingVisitor);
                if (a != null) {
                    graphQLVisitableModel = (TutorialNuxCarouselFieldsFragmentModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f8162e = a.b();
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m9046a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = flatBufferBuilder.a(m9047a());
            int a2 = ModelHelper.a(flatBufferBuilder, m9049j());
            int b = flatBufferBuilder.b(m9050k());
            int b2 = flatBufferBuilder.b(m9051l());
            int b3 = flatBufferBuilder.b(m9052m());
            int b4 = flatBufferBuilder.b(m9053n());
            int b5 = flatBufferBuilder.b(m9054o());
            int b6 = flatBufferBuilder.b(m9055p());
            int b7 = flatBufferBuilder.b(m9056q());
            int b8 = flatBufferBuilder.b(m9057r());
            int b9 = flatBufferBuilder.b(m9058s());
            flatBufferBuilder.c(11);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            flatBufferBuilder.b(2, b);
            flatBufferBuilder.b(3, b2);
            flatBufferBuilder.b(4, b3);
            flatBufferBuilder.b(5, b4);
            flatBufferBuilder.b(6, b5);
            flatBufferBuilder.b(7, b6);
            flatBufferBuilder.b(8, b7);
            flatBufferBuilder.b(9, b8);
            flatBufferBuilder.b(10, b9);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -801907374)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: nearby_places_module */
    public final class TutorialNuxConfigurationModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private TutorialNuxCarouselFieldsFragmentModel f8176d;
        private int f8177e;
        private boolean f8178f;
        private boolean f8179g;

        /* compiled from: nearby_places_module */
        public final class Builder {
            @Nullable
            public TutorialNuxCarouselFieldsFragmentModel f8172a;
            public int f8173b;
            public boolean f8174c;
            public boolean f8175d;

            public final TutorialNuxConfigurationModel m9059a() {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int a = ModelHelper.a(flatBufferBuilder, this.f8172a);
                flatBufferBuilder.c(4);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.a(1, this.f8173b, 0);
                flatBufferBuilder.a(2, this.f8174c);
                flatBufferBuilder.a(3, this.f8175d);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new TutorialNuxConfigurationModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }
        }

        /* compiled from: nearby_places_module */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(TutorialNuxConfigurationModel.class, new Deserializer());
            }

            public Object m9060a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(TutorialNuxConfigurationParser.m9082a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object tutorialNuxConfigurationModel = new TutorialNuxConfigurationModel();
                ((BaseModel) tutorialNuxConfigurationModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (tutorialNuxConfigurationModel instanceof Postprocessable) {
                    return ((Postprocessable) tutorialNuxConfigurationModel).a();
                }
                return tutorialNuxConfigurationModel;
            }
        }

        /* compiled from: nearby_places_module */
        public class Serializer extends JsonSerializer<TutorialNuxConfigurationModel> {
            public final void m9061a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                TutorialNuxConfigurationModel tutorialNuxConfigurationModel = (TutorialNuxConfigurationModel) obj;
                if (tutorialNuxConfigurationModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(tutorialNuxConfigurationModel.m9062a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    tutorialNuxConfigurationModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = tutorialNuxConfigurationModel.w_();
                int u_ = tutorialNuxConfigurationModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("carousel");
                    TutorialNuxCarouselFieldsFragmentParser.m9081a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.a(u_, 1, 0);
                if (g != 0) {
                    jsonGenerator.a("cool_down_hours");
                    jsonGenerator.b(g);
                }
                boolean a = mutableFlatBuffer.a(u_, 2);
                if (a) {
                    jsonGenerator.a("enabled");
                    jsonGenerator.a(a);
                }
                a = mutableFlatBuffer.a(u_, 3);
                if (a) {
                    jsonGenerator.a("has_impression_cap_reached");
                    jsonGenerator.a(a);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(TutorialNuxConfigurationModel.class, new Serializer());
            }
        }

        public TutorialNuxConfigurationModel() {
            super(4);
        }

        public TutorialNuxConfigurationModel(MutableFlatBuffer mutableFlatBuffer) {
            super(4);
            a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }

        @Nullable
        public final TutorialNuxCarouselFieldsFragmentModel m9064a() {
            this.f8176d = (TutorialNuxCarouselFieldsFragmentModel) super.a(this.f8176d, 0, TutorialNuxCarouselFieldsFragmentModel.class);
            return this.f8176d;
        }

        public final int m9066j() {
            a(0, 1);
            return this.f8177e;
        }

        public final boolean m9067k() {
            a(0, 2);
            return this.f8178f;
        }

        public final boolean m9068l() {
            a(0, 3);
            return this.f8179g;
        }

        public final int jK_() {
            return -1900183482;
        }

        public final GraphQLVisitableModel m9063a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m9064a() != null) {
                TutorialNuxCarouselFieldsFragmentModel tutorialNuxCarouselFieldsFragmentModel = (TutorialNuxCarouselFieldsFragmentModel) graphQLModelMutatingVisitor.b(m9064a());
                if (m9064a() != tutorialNuxCarouselFieldsFragmentModel) {
                    graphQLVisitableModel = (TutorialNuxConfigurationModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f8176d = tutorialNuxCarouselFieldsFragmentModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m9062a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m9064a());
            flatBufferBuilder.c(4);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.a(1, this.f8177e, 0);
            flatBufferBuilder.a(2, this.f8178f);
            flatBufferBuilder.a(3, this.f8179g);
            i();
            return flatBufferBuilder.d();
        }

        public final void m9065a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f8177e = mutableFlatBuffer.a(i, 1, 0);
            this.f8178f = mutableFlatBuffer.a(i, 2);
            this.f8179g = mutableFlatBuffer.a(i, 3);
        }
    }
}
