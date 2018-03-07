package com.facebook.composer.lifeevent.protocol;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.composer.lifeevent.protocol.FetchLifeEventComposerDataGraphQLParsers.BirthDateFieldsParser;
import com.facebook.composer.lifeevent.protocol.FetchLifeEventComposerDataGraphQLParsers.BirthdayQueryParser;
import com.facebook.composer.lifeevent.protocol.FetchLifeEventComposerDataGraphQLParsers.CollegeEntitiesTypeAheadSuggestionsQueryParser;
import com.facebook.composer.lifeevent.protocol.FetchLifeEventComposerDataGraphQLParsers.CollegeEntitiesTypeAheadSuggestionsQueryParser.SearchResultsParser;
import com.facebook.composer.lifeevent.protocol.FetchLifeEventComposerDataGraphQLParsers.FBLifeEventSuggestionsAllIconsQueryParser;
import com.facebook.composer.lifeevent.protocol.FetchLifeEventComposerDataGraphQLParsers.FBLifeEventSuggestionsAllIconsQueryParser.LifeEventIconSuggestionsParser;
import com.facebook.composer.lifeevent.protocol.FetchLifeEventComposerDataGraphQLParsers.FBLifeEventSuggestionsQueryParser;
import com.facebook.composer.lifeevent.protocol.FetchLifeEventComposerDataGraphQLParsers.FBLifeEventSuggestionsQueryParser.LifeEventCategoriesParser;
import com.facebook.composer.lifeevent.protocol.FetchLifeEventComposerDataGraphQLParsers.HighSchoolEntitiesTypeAheadSuggestionsQueryParser;
import com.facebook.composer.lifeevent.protocol.FetchLifeEventComposerDataGraphQLParsers.LifeEventCategoriesFieldsParser;
import com.facebook.composer.lifeevent.protocol.FetchLifeEventComposerDataGraphQLParsers.LifeEventCategoriesFieldsParser.LifeEventTypesParser;
import com.facebook.composer.lifeevent.protocol.FetchLifeEventComposerDataGraphQLParsers.LifeEventFieldsParser;
import com.facebook.composer.lifeevent.protocol.FetchLifeEventComposerDataGraphQLParsers.LifeEventIconsFieldsParser;
import com.facebook.composer.lifeevent.protocol.FetchLifeEventComposerDataGraphQLParsers.PeopleEntitiesTypeAheadSuggestionsQueryParser;
import com.facebook.composer.lifeevent.protocol.FetchLifeEventComposerDataGraphQLParsers.TypeAheadSuggestionFieldsParser;
import com.facebook.composer.lifeevent.protocol.FetchLifeEventComposerDataGraphQLParsers.WorkEntitiesTypeAheadSuggestionsQueryParser;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLLifeEventAPIIdentifier;
import com.facebook.graphql.enums.GraphQLLifeEventEducationExperienceType;
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

/* compiled from: place_is_logging_enabled */
public class FetchLifeEventComposerDataGraphQLModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -293638967)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: place_is_logging_enabled */
    public final class BirthDateFieldsModel extends BaseModel implements GraphQLVisitableModel {
        private int f7862d;
        private int f7863e;
        private int f7864f;

        /* compiled from: place_is_logging_enabled */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(BirthDateFieldsModel.class, new Deserializer());
            }

            public Object m11281a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(BirthDateFieldsParser.m11396a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object birthDateFieldsModel = new BirthDateFieldsModel();
                ((BaseModel) birthDateFieldsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (birthDateFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) birthDateFieldsModel).a();
                }
                return birthDateFieldsModel;
            }
        }

        /* compiled from: place_is_logging_enabled */
        public class Serializer extends JsonSerializer<BirthDateFieldsModel> {
            public final void m11282a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                BirthDateFieldsModel birthDateFieldsModel = (BirthDateFieldsModel) obj;
                if (birthDateFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(birthDateFieldsModel.m11284a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    birthDateFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                BirthDateFieldsParser.m11397a(birthDateFieldsModel.w_(), birthDateFieldsModel.u_(), jsonGenerator);
            }

            static {
                FbSerializerProvider.a(BirthDateFieldsModel.class, new Serializer());
            }
        }

        public BirthDateFieldsModel() {
            super(3);
        }

        public final int m11283a() {
            a(0, 0);
            return this.f7862d;
        }

        public final int m11287j() {
            a(0, 1);
            return this.f7863e;
        }

        public final int m11288k() {
            a(0, 2);
            return this.f7864f;
        }

        public final int jK_() {
            return 2122702;
        }

        public final GraphQLVisitableModel m11285a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m11284a(FlatBufferBuilder flatBufferBuilder) {
            h();
            flatBufferBuilder.c(3);
            flatBufferBuilder.a(0, this.f7862d, 0);
            flatBufferBuilder.a(1, this.f7863e, 0);
            flatBufferBuilder.a(2, this.f7864f, 0);
            i();
            return flatBufferBuilder.d();
        }

        public final void m11286a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f7862d = mutableFlatBuffer.a(i, 0, 0);
            this.f7863e = mutableFlatBuffer.a(i, 1, 0);
            this.f7864f = mutableFlatBuffer.a(i, 2, 0);
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -39304602)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: place_is_logging_enabled */
    public final class BirthdayQueryModel extends BaseModel implements GraphQLVisitableConsistentModel {
        @Nullable
        private GraphQLObjectType f7865d;
        @Nullable
        private BirthDateFieldsModel f7866e;

        /* compiled from: place_is_logging_enabled */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(BirthdayQueryModel.class, new Deserializer());
            }

            public Object m11289a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = BirthdayQueryParser.m11398a(jsonParser);
                Object birthdayQueryModel = new BirthdayQueryModel();
                ((BaseModel) birthdayQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (birthdayQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) birthdayQueryModel).a();
                }
                return birthdayQueryModel;
            }
        }

        /* compiled from: place_is_logging_enabled */
        public class Serializer extends JsonSerializer<BirthdayQueryModel> {
            public final void m11290a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                BirthdayQueryModel birthdayQueryModel = (BirthdayQueryModel) obj;
                if (birthdayQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(birthdayQueryModel.m11292a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    birthdayQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = birthdayQueryModel.w_();
                int u_ = birthdayQueryModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("__type__");
                    SerializerHelpers.b(mutableFlatBuffer, u_, 0, jsonGenerator);
                }
                int g = mutableFlatBuffer.g(u_, 1);
                if (g != 0) {
                    jsonGenerator.a("birthdate");
                    BirthDateFieldsParser.m11397a(mutableFlatBuffer, g, jsonGenerator);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(BirthdayQueryModel.class, new Serializer());
            }
        }

        public BirthdayQueryModel() {
            super(2);
        }

        public final void m11295a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m11296a(String str, Object obj, boolean z) {
        }

        @Nullable
        private GraphQLObjectType m11291j() {
            if (this.b != null && this.f7865d == null) {
                this.f7865d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
            }
            return this.f7865d;
        }

        @Nullable
        public final BirthDateFieldsModel m11293a() {
            this.f7866e = (BirthDateFieldsModel) super.a(this.f7866e, 1, BirthDateFieldsModel.class);
            return this.f7866e;
        }

        public final int jK_() {
            return 2433570;
        }

        public final GraphQLVisitableModel m11294a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m11293a() != null) {
                BirthDateFieldsModel birthDateFieldsModel = (BirthDateFieldsModel) graphQLModelMutatingVisitor.b(m11293a());
                if (m11293a() != birthDateFieldsModel) {
                    graphQLVisitableModel = (BirthdayQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f7866e = birthDateFieldsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m11292a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m11291j());
            int a2 = ModelHelper.a(flatBufferBuilder, m11293a());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 182706748)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: place_is_logging_enabled */
    public final class CollegeEntitiesTypeAheadSuggestionsQueryModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private SearchResultsModel f7868d;

        /* compiled from: place_is_logging_enabled */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(CollegeEntitiesTypeAheadSuggestionsQueryModel.class, new Deserializer());
            }

            public Object m11297a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = CollegeEntitiesTypeAheadSuggestionsQueryParser.m11401a(jsonParser);
                Object collegeEntitiesTypeAheadSuggestionsQueryModel = new CollegeEntitiesTypeAheadSuggestionsQueryModel();
                ((BaseModel) collegeEntitiesTypeAheadSuggestionsQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (collegeEntitiesTypeAheadSuggestionsQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) collegeEntitiesTypeAheadSuggestionsQueryModel).a();
                }
                return collegeEntitiesTypeAheadSuggestionsQueryModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 616286506)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: place_is_logging_enabled */
        public final class SearchResultsModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<TypeAheadSuggestionFieldsModel> f7867d;

            /* compiled from: place_is_logging_enabled */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(SearchResultsModel.class, new Deserializer());
                }

                public Object m11298a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(SearchResultsParser.m11399a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object searchResultsModel = new SearchResultsModel();
                    ((BaseModel) searchResultsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (searchResultsModel instanceof Postprocessable) {
                        return ((Postprocessable) searchResultsModel).a();
                    }
                    return searchResultsModel;
                }
            }

            /* compiled from: place_is_logging_enabled */
            public class Serializer extends JsonSerializer<SearchResultsModel> {
                public final void m11299a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    SearchResultsModel searchResultsModel = (SearchResultsModel) obj;
                    if (searchResultsModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(searchResultsModel.m11300a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        searchResultsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    SearchResultsParser.m11400a(searchResultsModel.w_(), searchResultsModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(SearchResultsModel.class, new Serializer());
                }
            }

            public SearchResultsModel() {
                super(1);
            }

            @Nonnull
            public final ImmutableList<TypeAheadSuggestionFieldsModel> m11302a() {
                this.f7867d = super.a(this.f7867d, 0, TypeAheadSuggestionFieldsModel.class);
                return (ImmutableList) this.f7867d;
            }

            public final int jK_() {
                return 1843101810;
            }

            public final GraphQLVisitableModel m11301a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m11302a() != null) {
                    Builder a = ModelHelper.a(m11302a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (SearchResultsModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f7867d = a.b();
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m11300a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m11302a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: place_is_logging_enabled */
        public class Serializer extends JsonSerializer<CollegeEntitiesTypeAheadSuggestionsQueryModel> {
            public final void m11303a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                CollegeEntitiesTypeAheadSuggestionsQueryModel collegeEntitiesTypeAheadSuggestionsQueryModel = (CollegeEntitiesTypeAheadSuggestionsQueryModel) obj;
                if (collegeEntitiesTypeAheadSuggestionsQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(collegeEntitiesTypeAheadSuggestionsQueryModel.m11304a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    collegeEntitiesTypeAheadSuggestionsQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = collegeEntitiesTypeAheadSuggestionsQueryModel.w_();
                int u_ = collegeEntitiesTypeAheadSuggestionsQueryModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("search_results");
                    SearchResultsParser.m11400a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(CollegeEntitiesTypeAheadSuggestionsQueryModel.class, new Serializer());
            }
        }

        public CollegeEntitiesTypeAheadSuggestionsQueryModel() {
            super(1);
        }

        @Nullable
        public final SearchResultsModel m11305a() {
            this.f7868d = (SearchResultsModel) super.a(this.f7868d, 0, SearchResultsModel.class);
            return this.f7868d;
        }

        public final int jK_() {
            return 332244357;
        }

        public final GraphQLVisitableModel m11306a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m11305a() != null) {
                SearchResultsModel searchResultsModel = (SearchResultsModel) graphQLModelMutatingVisitor.b(m11305a());
                if (m11305a() != searchResultsModel) {
                    graphQLVisitableModel = (CollegeEntitiesTypeAheadSuggestionsQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f7868d = searchResultsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m11304a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m11305a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1272077515)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: place_is_logging_enabled */
    public final class FBLifeEventSuggestionsAllIconsQueryModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private LifeEventIconSuggestionsModel f7870d;

        /* compiled from: place_is_logging_enabled */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FBLifeEventSuggestionsAllIconsQueryModel.class, new Deserializer());
            }

            public Object m11307a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = FBLifeEventSuggestionsAllIconsQueryParser.m11404a(jsonParser);
                Object fBLifeEventSuggestionsAllIconsQueryModel = new FBLifeEventSuggestionsAllIconsQueryModel();
                ((BaseModel) fBLifeEventSuggestionsAllIconsQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (fBLifeEventSuggestionsAllIconsQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) fBLifeEventSuggestionsAllIconsQueryModel).a();
                }
                return fBLifeEventSuggestionsAllIconsQueryModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 580525668)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: place_is_logging_enabled */
        public final class LifeEventIconSuggestionsModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<LifeEventIconsFieldsModel> f7869d;

            /* compiled from: place_is_logging_enabled */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(LifeEventIconSuggestionsModel.class, new Deserializer());
                }

                public Object m11308a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(LifeEventIconSuggestionsParser.m11402a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object lifeEventIconSuggestionsModel = new LifeEventIconSuggestionsModel();
                    ((BaseModel) lifeEventIconSuggestionsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (lifeEventIconSuggestionsModel instanceof Postprocessable) {
                        return ((Postprocessable) lifeEventIconSuggestionsModel).a();
                    }
                    return lifeEventIconSuggestionsModel;
                }
            }

            /* compiled from: place_is_logging_enabled */
            public class Serializer extends JsonSerializer<LifeEventIconSuggestionsModel> {
                public final void m11309a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    LifeEventIconSuggestionsModel lifeEventIconSuggestionsModel = (LifeEventIconSuggestionsModel) obj;
                    if (lifeEventIconSuggestionsModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(lifeEventIconSuggestionsModel.m11310a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        lifeEventIconSuggestionsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    LifeEventIconSuggestionsParser.m11403a(lifeEventIconSuggestionsModel.w_(), lifeEventIconSuggestionsModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(LifeEventIconSuggestionsModel.class, new Serializer());
                }
            }

            public LifeEventIconSuggestionsModel() {
                super(1);
            }

            @Nonnull
            public final ImmutableList<LifeEventIconsFieldsModel> m11312a() {
                this.f7869d = super.a(this.f7869d, 0, LifeEventIconsFieldsModel.class);
                return (ImmutableList) this.f7869d;
            }

            public final int jK_() {
                return 1219199222;
            }

            public final GraphQLVisitableModel m11311a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m11312a() != null) {
                    Builder a = ModelHelper.a(m11312a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (LifeEventIconSuggestionsModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f7869d = a.b();
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m11310a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m11312a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: place_is_logging_enabled */
        public class Serializer extends JsonSerializer<FBLifeEventSuggestionsAllIconsQueryModel> {
            public final void m11313a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                FBLifeEventSuggestionsAllIconsQueryModel fBLifeEventSuggestionsAllIconsQueryModel = (FBLifeEventSuggestionsAllIconsQueryModel) obj;
                if (fBLifeEventSuggestionsAllIconsQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(fBLifeEventSuggestionsAllIconsQueryModel.m11314a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    fBLifeEventSuggestionsAllIconsQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = fBLifeEventSuggestionsAllIconsQueryModel.w_();
                int u_ = fBLifeEventSuggestionsAllIconsQueryModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("life_event_icon_suggestions");
                    LifeEventIconSuggestionsParser.m11403a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(FBLifeEventSuggestionsAllIconsQueryModel.class, new Serializer());
            }
        }

        public FBLifeEventSuggestionsAllIconsQueryModel() {
            super(1);
        }

        @Nullable
        public final LifeEventIconSuggestionsModel m11315a() {
            this.f7870d = (LifeEventIconSuggestionsModel) super.a(this.f7870d, 0, LifeEventIconSuggestionsModel.class);
            return this.f7870d;
        }

        public final int jK_() {
            return -1732764110;
        }

        public final GraphQLVisitableModel m11316a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m11315a() != null) {
                LifeEventIconSuggestionsModel lifeEventIconSuggestionsModel = (LifeEventIconSuggestionsModel) graphQLModelMutatingVisitor.b(m11315a());
                if (m11315a() != lifeEventIconSuggestionsModel) {
                    graphQLVisitableModel = (FBLifeEventSuggestionsAllIconsQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f7870d = lifeEventIconSuggestionsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m11314a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m11315a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1277102955)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: place_is_logging_enabled */
    public final class FBLifeEventSuggestionsQueryModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private LifeEventCategoriesModel f7874d;

        /* compiled from: place_is_logging_enabled */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FBLifeEventSuggestionsQueryModel.class, new Deserializer());
            }

            public Object m11317a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = FBLifeEventSuggestionsQueryParser.m11407a(jsonParser);
                Object fBLifeEventSuggestionsQueryModel = new FBLifeEventSuggestionsQueryModel();
                ((BaseModel) fBLifeEventSuggestionsQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (fBLifeEventSuggestionsQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) fBLifeEventSuggestionsQueryModel).a();
                }
                return fBLifeEventSuggestionsQueryModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 137876603)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: place_is_logging_enabled */
        public final class LifeEventCategoriesModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private LifeEventFieldsModel f7871d;
            @Nullable
            private List<LifeEventFieldsModel> f7872e;
            @Nullable
            private List<LifeEventCategoriesFieldsModel> f7873f;

            /* compiled from: place_is_logging_enabled */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(LifeEventCategoriesModel.class, new Deserializer());
                }

                public Object m11318a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(LifeEventCategoriesParser.m11405a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object lifeEventCategoriesModel = new LifeEventCategoriesModel();
                    ((BaseModel) lifeEventCategoriesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (lifeEventCategoriesModel instanceof Postprocessable) {
                        return ((Postprocessable) lifeEventCategoriesModel).a();
                    }
                    return lifeEventCategoriesModel;
                }
            }

            /* compiled from: place_is_logging_enabled */
            public class Serializer extends JsonSerializer<LifeEventCategoriesModel> {
                public final void m11319a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    LifeEventCategoriesModel lifeEventCategoriesModel = (LifeEventCategoriesModel) obj;
                    if (lifeEventCategoriesModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(lifeEventCategoriesModel.m11320a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        lifeEventCategoriesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    LifeEventCategoriesParser.m11406a(lifeEventCategoriesModel.w_(), lifeEventCategoriesModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(LifeEventCategoriesModel.class, new Serializer());
                }
            }

            public LifeEventCategoriesModel() {
                super(3);
            }

            @Nullable
            public final LifeEventFieldsModel m11321a() {
                this.f7871d = (LifeEventFieldsModel) super.a(this.f7871d, 0, LifeEventFieldsModel.class);
                return this.f7871d;
            }

            @Nonnull
            public final ImmutableList<LifeEventFieldsModel> m11323j() {
                this.f7872e = super.a(this.f7872e, 1, LifeEventFieldsModel.class);
                return (ImmutableList) this.f7872e;
            }

            @Nonnull
            public final ImmutableList<LifeEventCategoriesFieldsModel> m11324k() {
                this.f7873f = super.a(this.f7873f, 2, LifeEventCategoriesFieldsModel.class);
                return (ImmutableList) this.f7873f;
            }

            public final int jK_() {
                return -1653773454;
            }

            public final GraphQLVisitableModel m11322a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                Builder a;
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m11321a() != null) {
                    LifeEventFieldsModel lifeEventFieldsModel = (LifeEventFieldsModel) graphQLModelMutatingVisitor.b(m11321a());
                    if (m11321a() != lifeEventFieldsModel) {
                        graphQLVisitableModel = (LifeEventCategoriesModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f7871d = lifeEventFieldsModel;
                    }
                }
                if (m11323j() != null) {
                    a = ModelHelper.a(m11323j(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        LifeEventCategoriesModel lifeEventCategoriesModel = (LifeEventCategoriesModel) ModelHelper.a(graphQLVisitableModel, this);
                        lifeEventCategoriesModel.f7872e = a.b();
                        graphQLVisitableModel = lifeEventCategoriesModel;
                    }
                }
                if (m11324k() != null) {
                    a = ModelHelper.a(m11324k(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        lifeEventCategoriesModel = (LifeEventCategoriesModel) ModelHelper.a(graphQLVisitableModel, this);
                        lifeEventCategoriesModel.f7873f = a.b();
                        graphQLVisitableModel = lifeEventCategoriesModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m11320a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m11321a());
                int a2 = ModelHelper.a(flatBufferBuilder, m11323j());
                int a3 = ModelHelper.a(flatBufferBuilder, m11324k());
                flatBufferBuilder.c(3);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, a2);
                flatBufferBuilder.b(2, a3);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: place_is_logging_enabled */
        public class Serializer extends JsonSerializer<FBLifeEventSuggestionsQueryModel> {
            public final void m11325a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                FBLifeEventSuggestionsQueryModel fBLifeEventSuggestionsQueryModel = (FBLifeEventSuggestionsQueryModel) obj;
                if (fBLifeEventSuggestionsQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(fBLifeEventSuggestionsQueryModel.m11326a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    fBLifeEventSuggestionsQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = fBLifeEventSuggestionsQueryModel.w_();
                int u_ = fBLifeEventSuggestionsQueryModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("life_event_categories");
                    LifeEventCategoriesParser.m11406a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(FBLifeEventSuggestionsQueryModel.class, new Serializer());
            }
        }

        public FBLifeEventSuggestionsQueryModel() {
            super(1);
        }

        @Nullable
        public final LifeEventCategoriesModel m11327a() {
            this.f7874d = (LifeEventCategoriesModel) super.a(this.f7874d, 0, LifeEventCategoriesModel.class);
            return this.f7874d;
        }

        public final int jK_() {
            return -1732764110;
        }

        public final GraphQLVisitableModel m11328a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m11327a() != null) {
                LifeEventCategoriesModel lifeEventCategoriesModel = (LifeEventCategoriesModel) graphQLModelMutatingVisitor.b(m11327a());
                if (m11327a() != lifeEventCategoriesModel) {
                    graphQLVisitableModel = (FBLifeEventSuggestionsQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f7874d = lifeEventCategoriesModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m11326a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m11327a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -467448208)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: place_is_logging_enabled */
    public final class HighSchoolEntitiesTypeAheadSuggestionsQueryModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private SearchResultsModel f7876d;

        /* compiled from: place_is_logging_enabled */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(HighSchoolEntitiesTypeAheadSuggestionsQueryModel.class, new Deserializer());
            }

            public Object m11329a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = HighSchoolEntitiesTypeAheadSuggestionsQueryParser.m11410a(jsonParser);
                Object highSchoolEntitiesTypeAheadSuggestionsQueryModel = new HighSchoolEntitiesTypeAheadSuggestionsQueryModel();
                ((BaseModel) highSchoolEntitiesTypeAheadSuggestionsQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (highSchoolEntitiesTypeAheadSuggestionsQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) highSchoolEntitiesTypeAheadSuggestionsQueryModel).a();
                }
                return highSchoolEntitiesTypeAheadSuggestionsQueryModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 616286506)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: place_is_logging_enabled */
        public final class SearchResultsModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<TypeAheadSuggestionFieldsModel> f7875d;

            /* compiled from: place_is_logging_enabled */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(SearchResultsModel.class, new Deserializer());
                }

                public Object m11330a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(HighSchoolEntitiesTypeAheadSuggestionsQueryParser.SearchResultsParser.m11408a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object searchResultsModel = new SearchResultsModel();
                    ((BaseModel) searchResultsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (searchResultsModel instanceof Postprocessable) {
                        return ((Postprocessable) searchResultsModel).a();
                    }
                    return searchResultsModel;
                }
            }

            /* compiled from: place_is_logging_enabled */
            public class Serializer extends JsonSerializer<SearchResultsModel> {
                public final void m11331a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    SearchResultsModel searchResultsModel = (SearchResultsModel) obj;
                    if (searchResultsModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(searchResultsModel.m11332a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        searchResultsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    HighSchoolEntitiesTypeAheadSuggestionsQueryParser.SearchResultsParser.m11409a(searchResultsModel.w_(), searchResultsModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(SearchResultsModel.class, new Serializer());
                }
            }

            public SearchResultsModel() {
                super(1);
            }

            @Nonnull
            public final ImmutableList<TypeAheadSuggestionFieldsModel> m11334a() {
                this.f7875d = super.a(this.f7875d, 0, TypeAheadSuggestionFieldsModel.class);
                return (ImmutableList) this.f7875d;
            }

            public final int jK_() {
                return 1843101810;
            }

            public final GraphQLVisitableModel m11333a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m11334a() != null) {
                    Builder a = ModelHelper.a(m11334a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (SearchResultsModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f7875d = a.b();
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m11332a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m11334a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: place_is_logging_enabled */
        public class Serializer extends JsonSerializer<HighSchoolEntitiesTypeAheadSuggestionsQueryModel> {
            public final void m11335a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                HighSchoolEntitiesTypeAheadSuggestionsQueryModel highSchoolEntitiesTypeAheadSuggestionsQueryModel = (HighSchoolEntitiesTypeAheadSuggestionsQueryModel) obj;
                if (highSchoolEntitiesTypeAheadSuggestionsQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(highSchoolEntitiesTypeAheadSuggestionsQueryModel.m11336a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    highSchoolEntitiesTypeAheadSuggestionsQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = highSchoolEntitiesTypeAheadSuggestionsQueryModel.w_();
                int u_ = highSchoolEntitiesTypeAheadSuggestionsQueryModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("search_results");
                    HighSchoolEntitiesTypeAheadSuggestionsQueryParser.SearchResultsParser.m11409a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(HighSchoolEntitiesTypeAheadSuggestionsQueryModel.class, new Serializer());
            }
        }

        public HighSchoolEntitiesTypeAheadSuggestionsQueryModel() {
            super(1);
        }

        @Nullable
        public final SearchResultsModel m11337a() {
            this.f7876d = (SearchResultsModel) super.a(this.f7876d, 0, SearchResultsModel.class);
            return this.f7876d;
        }

        public final int jK_() {
            return 332244357;
        }

        public final GraphQLVisitableModel m11338a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m11337a() != null) {
                SearchResultsModel searchResultsModel = (SearchResultsModel) graphQLModelMutatingVisitor.b(m11337a());
                if (m11337a() != searchResultsModel) {
                    graphQLVisitableModel = (HighSchoolEntitiesTypeAheadSuggestionsQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f7876d = searchResultsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m11336a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m11337a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1195670865)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: place_is_logging_enabled */
    public final class LifeEventCategoriesFieldsModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private LifeEventTypesModel f7878d;
        @Nullable
        private String f7879e;

        /* compiled from: place_is_logging_enabled */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(LifeEventCategoriesFieldsModel.class, new Deserializer());
            }

            public Object m11339a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(LifeEventCategoriesFieldsParser.m11413b(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object lifeEventCategoriesFieldsModel = new LifeEventCategoriesFieldsModel();
                ((BaseModel) lifeEventCategoriesFieldsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (lifeEventCategoriesFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) lifeEventCategoriesFieldsModel).a();
                }
                return lifeEventCategoriesFieldsModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 959959490)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: place_is_logging_enabled */
        public final class LifeEventTypesModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<LifeEventFieldsModel> f7877d;

            /* compiled from: place_is_logging_enabled */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(LifeEventTypesModel.class, new Deserializer());
                }

                public Object m11340a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(LifeEventTypesParser.m11411a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object lifeEventTypesModel = new LifeEventTypesModel();
                    ((BaseModel) lifeEventTypesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (lifeEventTypesModel instanceof Postprocessable) {
                        return ((Postprocessable) lifeEventTypesModel).a();
                    }
                    return lifeEventTypesModel;
                }
            }

            /* compiled from: place_is_logging_enabled */
            public class Serializer extends JsonSerializer<LifeEventTypesModel> {
                public final void m11341a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    LifeEventTypesModel lifeEventTypesModel = (LifeEventTypesModel) obj;
                    if (lifeEventTypesModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(lifeEventTypesModel.m11342a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        lifeEventTypesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    LifeEventTypesParser.m11412a(lifeEventTypesModel.w_(), lifeEventTypesModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(LifeEventTypesModel.class, new Serializer());
                }
            }

            public LifeEventTypesModel() {
                super(1);
            }

            @Nonnull
            public final ImmutableList<LifeEventFieldsModel> m11344a() {
                this.f7877d = super.a(this.f7877d, 0, LifeEventFieldsModel.class);
                return (ImmutableList) this.f7877d;
            }

            public final int jK_() {
                return 1137336185;
            }

            public final GraphQLVisitableModel m11343a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m11344a() != null) {
                    Builder a = ModelHelper.a(m11344a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (LifeEventTypesModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f7877d = a.b();
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m11342a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m11344a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: place_is_logging_enabled */
        public class Serializer extends JsonSerializer<LifeEventCategoriesFieldsModel> {
            public final void m11345a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                LifeEventCategoriesFieldsModel lifeEventCategoriesFieldsModel = (LifeEventCategoriesFieldsModel) obj;
                if (lifeEventCategoriesFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(lifeEventCategoriesFieldsModel.m11346a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    lifeEventCategoriesFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                LifeEventCategoriesFieldsParser.m11414b(lifeEventCategoriesFieldsModel.w_(), lifeEventCategoriesFieldsModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(LifeEventCategoriesFieldsModel.class, new Serializer());
            }
        }

        public LifeEventCategoriesFieldsModel() {
            super(2);
        }

        @Nullable
        public final LifeEventTypesModel m11347a() {
            this.f7878d = (LifeEventTypesModel) super.a(this.f7878d, 0, LifeEventTypesModel.class);
            return this.f7878d;
        }

        @Nullable
        public final String m11349j() {
            this.f7879e = super.a(this.f7879e, 1);
            return this.f7879e;
        }

        public final int jK_() {
            return -706888106;
        }

        public final GraphQLVisitableModel m11348a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m11347a() != null) {
                LifeEventTypesModel lifeEventTypesModel = (LifeEventTypesModel) graphQLModelMutatingVisitor.b(m11347a());
                if (m11347a() != lifeEventTypesModel) {
                    graphQLVisitableModel = (LifeEventCategoriesFieldsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f7878d = lifeEventTypesModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m11346a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m11347a());
            int b = flatBufferBuilder.b(m11349j());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, b);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 637619053)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: place_is_logging_enabled */
    public final class LifeEventFieldsModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private String f7885d;
        @Nullable
        private GraphQLLifeEventEducationExperienceType f7886e;
        @Nullable
        private DefaultImageFieldsModel f7887f;
        @Nullable
        private String f7888g;
        @Nullable
        private GraphQLLifeEventAPIIdentifier f7889h;

        /* compiled from: place_is_logging_enabled */
        public final class Builder {
            @Nullable
            public String f7880a;
            @Nullable
            public GraphQLLifeEventEducationExperienceType f7881b;
            @Nullable
            public DefaultImageFieldsModel f7882c;
            @Nullable
            public String f7883d;
            @Nullable
            public GraphQLLifeEventAPIIdentifier f7884e;

            public final LifeEventFieldsModel m11350a() {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int b = flatBufferBuilder.b(this.f7880a);
                int a = flatBufferBuilder.a(this.f7881b);
                int a2 = ModelHelper.a(flatBufferBuilder, this.f7882c);
                int b2 = flatBufferBuilder.b(this.f7883d);
                int a3 = flatBufferBuilder.a(this.f7884e);
                flatBufferBuilder.c(5);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.b(1, a);
                flatBufferBuilder.b(2, a2);
                flatBufferBuilder.b(3, b2);
                flatBufferBuilder.b(4, a3);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new LifeEventFieldsModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }
        }

        /* compiled from: place_is_logging_enabled */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(LifeEventFieldsModel.class, new Deserializer());
            }

            public Object m11351a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(LifeEventFieldsParser.m11415a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object lifeEventFieldsModel = new LifeEventFieldsModel();
                ((BaseModel) lifeEventFieldsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (lifeEventFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) lifeEventFieldsModel).a();
                }
                return lifeEventFieldsModel;
            }
        }

        /* compiled from: place_is_logging_enabled */
        public class Serializer extends JsonSerializer<LifeEventFieldsModel> {
            public final void m11352a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                LifeEventFieldsModel lifeEventFieldsModel = (LifeEventFieldsModel) obj;
                if (lifeEventFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(lifeEventFieldsModel.m11353a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    lifeEventFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                LifeEventFieldsParser.m11418b(lifeEventFieldsModel.w_(), lifeEventFieldsModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(LifeEventFieldsModel.class, new Serializer());
            }
        }

        public LifeEventFieldsModel() {
            super(5);
        }

        public LifeEventFieldsModel(MutableFlatBuffer mutableFlatBuffer) {
            super(5);
            a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }

        @Nullable
        public final String m11355a() {
            this.f7885d = super.a(this.f7885d, 0);
            return this.f7885d;
        }

        @Nullable
        public final GraphQLLifeEventEducationExperienceType m11356j() {
            this.f7886e = (GraphQLLifeEventEducationExperienceType) super.b(this.f7886e, 1, GraphQLLifeEventEducationExperienceType.class, GraphQLLifeEventEducationExperienceType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f7886e;
        }

        @Nullable
        public final DefaultImageFieldsModel m11357k() {
            this.f7887f = (DefaultImageFieldsModel) super.a(this.f7887f, 2, DefaultImageFieldsModel.class);
            return this.f7887f;
        }

        @Nullable
        public final String m11358l() {
            this.f7888g = super.a(this.f7888g, 3);
            return this.f7888g;
        }

        @Nullable
        public final GraphQLLifeEventAPIIdentifier m11359m() {
            this.f7889h = (GraphQLLifeEventAPIIdentifier) super.b(this.f7889h, 4, GraphQLLifeEventAPIIdentifier.class, GraphQLLifeEventAPIIdentifier.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f7889h;
        }

        public final int jK_() {
            return -813443748;
        }

        public final GraphQLVisitableModel m11354a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m11357k() != null) {
                DefaultImageFieldsModel defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m11357k());
                if (m11357k() != defaultImageFieldsModel) {
                    graphQLVisitableModel = (LifeEventFieldsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f7887f = defaultImageFieldsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m11353a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m11355a());
            int a = flatBufferBuilder.a(m11356j());
            int a2 = ModelHelper.a(flatBufferBuilder, m11357k());
            int b2 = flatBufferBuilder.b(m11358l());
            int a3 = flatBufferBuilder.a(m11359m());
            flatBufferBuilder.c(5);
            flatBufferBuilder.b(0, b);
            flatBufferBuilder.b(1, a);
            flatBufferBuilder.b(2, a2);
            flatBufferBuilder.b(3, b2);
            flatBufferBuilder.b(4, a3);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -335526430)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: place_is_logging_enabled */
    public final class LifeEventIconsFieldsModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private String f7890d;
        @Nullable
        private DefaultImageFieldsModel f7891e;
        @Nullable
        private String f7892f;

        /* compiled from: place_is_logging_enabled */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(LifeEventIconsFieldsModel.class, new Deserializer());
            }

            public Object m11360a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(LifeEventIconsFieldsParser.m11419b(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object lifeEventIconsFieldsModel = new LifeEventIconsFieldsModel();
                ((BaseModel) lifeEventIconsFieldsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (lifeEventIconsFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) lifeEventIconsFieldsModel).a();
                }
                return lifeEventIconsFieldsModel;
            }
        }

        /* compiled from: place_is_logging_enabled */
        public class Serializer extends JsonSerializer<LifeEventIconsFieldsModel> {
            public final void m11361a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                LifeEventIconsFieldsModel lifeEventIconsFieldsModel = (LifeEventIconsFieldsModel) obj;
                if (lifeEventIconsFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(lifeEventIconsFieldsModel.m11362a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    lifeEventIconsFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                LifeEventIconsFieldsParser.m11420b(lifeEventIconsFieldsModel.w_(), lifeEventIconsFieldsModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(LifeEventIconsFieldsModel.class, new Serializer());
            }
        }

        public LifeEventIconsFieldsModel() {
            super(3);
        }

        @Nullable
        public final String m11364a() {
            this.f7890d = super.a(this.f7890d, 0);
            return this.f7890d;
        }

        @Nullable
        public final DefaultImageFieldsModel m11365j() {
            this.f7891e = (DefaultImageFieldsModel) super.a(this.f7891e, 1, DefaultImageFieldsModel.class);
            return this.f7891e;
        }

        @Nullable
        public final String m11366k() {
            this.f7892f = super.a(this.f7892f, 2);
            return this.f7892f;
        }

        public final int jK_() {
            return -804110373;
        }

        public final GraphQLVisitableModel m11363a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m11365j() != null) {
                DefaultImageFieldsModel defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m11365j());
                if (m11365j() != defaultImageFieldsModel) {
                    graphQLVisitableModel = (LifeEventIconsFieldsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f7891e = defaultImageFieldsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m11362a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m11364a());
            int a = ModelHelper.a(flatBufferBuilder, m11365j());
            int b2 = flatBufferBuilder.b(m11366k());
            flatBufferBuilder.c(3);
            flatBufferBuilder.b(0, b);
            flatBufferBuilder.b(1, a);
            flatBufferBuilder.b(2, b2);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1188701405)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: place_is_logging_enabled */
    public final class PeopleEntitiesTypeAheadSuggestionsQueryModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private SearchResultsModel f7894d;

        /* compiled from: place_is_logging_enabled */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(PeopleEntitiesTypeAheadSuggestionsQueryModel.class, new Deserializer());
            }

            public Object m11367a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = PeopleEntitiesTypeAheadSuggestionsQueryParser.m11423a(jsonParser);
                Object peopleEntitiesTypeAheadSuggestionsQueryModel = new PeopleEntitiesTypeAheadSuggestionsQueryModel();
                ((BaseModel) peopleEntitiesTypeAheadSuggestionsQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (peopleEntitiesTypeAheadSuggestionsQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) peopleEntitiesTypeAheadSuggestionsQueryModel).a();
                }
                return peopleEntitiesTypeAheadSuggestionsQueryModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 616286506)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: place_is_logging_enabled */
        public final class SearchResultsModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<TypeAheadSuggestionFieldsModel> f7893d;

            /* compiled from: place_is_logging_enabled */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(SearchResultsModel.class, new Deserializer());
                }

                public Object m11368a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(PeopleEntitiesTypeAheadSuggestionsQueryParser.SearchResultsParser.m11421a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object searchResultsModel = new SearchResultsModel();
                    ((BaseModel) searchResultsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (searchResultsModel instanceof Postprocessable) {
                        return ((Postprocessable) searchResultsModel).a();
                    }
                    return searchResultsModel;
                }
            }

            /* compiled from: place_is_logging_enabled */
            public class Serializer extends JsonSerializer<SearchResultsModel> {
                public final void m11369a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    SearchResultsModel searchResultsModel = (SearchResultsModel) obj;
                    if (searchResultsModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(searchResultsModel.m11370a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        searchResultsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    PeopleEntitiesTypeAheadSuggestionsQueryParser.SearchResultsParser.m11422a(searchResultsModel.w_(), searchResultsModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(SearchResultsModel.class, new Serializer());
                }
            }

            public SearchResultsModel() {
                super(1);
            }

            @Nonnull
            public final ImmutableList<TypeAheadSuggestionFieldsModel> m11372a() {
                this.f7893d = super.a(this.f7893d, 0, TypeAheadSuggestionFieldsModel.class);
                return (ImmutableList) this.f7893d;
            }

            public final int jK_() {
                return 1843101810;
            }

            public final GraphQLVisitableModel m11371a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m11372a() != null) {
                    Builder a = ModelHelper.a(m11372a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (SearchResultsModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f7893d = a.b();
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m11370a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m11372a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: place_is_logging_enabled */
        public class Serializer extends JsonSerializer<PeopleEntitiesTypeAheadSuggestionsQueryModel> {
            public final void m11373a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                PeopleEntitiesTypeAheadSuggestionsQueryModel peopleEntitiesTypeAheadSuggestionsQueryModel = (PeopleEntitiesTypeAheadSuggestionsQueryModel) obj;
                if (peopleEntitiesTypeAheadSuggestionsQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(peopleEntitiesTypeAheadSuggestionsQueryModel.m11374a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    peopleEntitiesTypeAheadSuggestionsQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = peopleEntitiesTypeAheadSuggestionsQueryModel.w_();
                int u_ = peopleEntitiesTypeAheadSuggestionsQueryModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("search_results");
                    PeopleEntitiesTypeAheadSuggestionsQueryParser.SearchResultsParser.m11422a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(PeopleEntitiesTypeAheadSuggestionsQueryModel.class, new Serializer());
            }
        }

        public PeopleEntitiesTypeAheadSuggestionsQueryModel() {
            super(1);
        }

        @Nullable
        public final SearchResultsModel m11375a() {
            this.f7894d = (SearchResultsModel) super.a(this.f7894d, 0, SearchResultsModel.class);
            return this.f7894d;
        }

        public final int jK_() {
            return 332244357;
        }

        public final GraphQLVisitableModel m11376a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m11375a() != null) {
                SearchResultsModel searchResultsModel = (SearchResultsModel) graphQLModelMutatingVisitor.b(m11375a());
                if (m11375a() != searchResultsModel) {
                    graphQLVisitableModel = (PeopleEntitiesTypeAheadSuggestionsQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f7894d = searchResultsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m11374a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m11375a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 289552164)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: place_is_logging_enabled */
    public final class TypeAheadSuggestionFieldsModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
        @Nullable
        private GraphQLObjectType f7895d;
        @Nullable
        private String f7896e;
        @Nullable
        private String f7897f;
        @Nullable
        private DefaultImageFieldsModel f7898g;

        /* compiled from: place_is_logging_enabled */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(TypeAheadSuggestionFieldsModel.class, new Deserializer());
            }

            public Object m11377a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(TypeAheadSuggestionFieldsParser.m11426b(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object typeAheadSuggestionFieldsModel = new TypeAheadSuggestionFieldsModel();
                ((BaseModel) typeAheadSuggestionFieldsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (typeAheadSuggestionFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) typeAheadSuggestionFieldsModel).a();
                }
                return typeAheadSuggestionFieldsModel;
            }
        }

        /* compiled from: place_is_logging_enabled */
        public class Serializer extends JsonSerializer<TypeAheadSuggestionFieldsModel> {
            public final void m11378a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                TypeAheadSuggestionFieldsModel typeAheadSuggestionFieldsModel = (TypeAheadSuggestionFieldsModel) obj;
                if (typeAheadSuggestionFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(typeAheadSuggestionFieldsModel.m11380a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    typeAheadSuggestionFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                TypeAheadSuggestionFieldsParser.m11427b(typeAheadSuggestionFieldsModel.w_(), typeAheadSuggestionFieldsModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(TypeAheadSuggestionFieldsModel.class, new Serializer());
            }
        }

        public TypeAheadSuggestionFieldsModel() {
            super(4);
        }

        @Nullable
        private GraphQLObjectType m11379m() {
            if (this.b != null && this.f7895d == null) {
                this.f7895d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
            }
            return this.f7895d;
        }

        @Nullable
        public final String m11383j() {
            this.f7896e = super.a(this.f7896e, 1);
            return this.f7896e;
        }

        @Nullable
        public final String m11384k() {
            this.f7897f = super.a(this.f7897f, 2);
            return this.f7897f;
        }

        @Nullable
        public final DefaultImageFieldsModel m11385l() {
            this.f7898g = (DefaultImageFieldsModel) super.a(this.f7898g, 3, DefaultImageFieldsModel.class);
            return this.f7898g;
        }

        @Nullable
        public final String m11382a() {
            return m11383j();
        }

        public final int jK_() {
            return 1283375906;
        }

        public final GraphQLVisitableModel m11381a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m11385l() != null) {
                DefaultImageFieldsModel defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m11385l());
                if (m11385l() != defaultImageFieldsModel) {
                    graphQLVisitableModel = (TypeAheadSuggestionFieldsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f7898g = defaultImageFieldsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m11380a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m11379m());
            int b = flatBufferBuilder.b(m11383j());
            int b2 = flatBufferBuilder.b(m11384k());
            int a2 = ModelHelper.a(flatBufferBuilder, m11385l());
            flatBufferBuilder.c(4);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, b);
            flatBufferBuilder.b(2, b2);
            flatBufferBuilder.b(3, a2);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -435318859)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: place_is_logging_enabled */
    public final class WorkEntitiesTypeAheadSuggestionsQueryModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private SearchResultsModel f7900d;

        /* compiled from: place_is_logging_enabled */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(WorkEntitiesTypeAheadSuggestionsQueryModel.class, new Deserializer());
            }

            public Object m11386a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = WorkEntitiesTypeAheadSuggestionsQueryParser.m11430a(jsonParser);
                Object workEntitiesTypeAheadSuggestionsQueryModel = new WorkEntitiesTypeAheadSuggestionsQueryModel();
                ((BaseModel) workEntitiesTypeAheadSuggestionsQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (workEntitiesTypeAheadSuggestionsQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) workEntitiesTypeAheadSuggestionsQueryModel).a();
                }
                return workEntitiesTypeAheadSuggestionsQueryModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 616286506)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: place_is_logging_enabled */
        public final class SearchResultsModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<TypeAheadSuggestionFieldsModel> f7899d;

            /* compiled from: place_is_logging_enabled */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(SearchResultsModel.class, new Deserializer());
                }

                public Object m11387a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(WorkEntitiesTypeAheadSuggestionsQueryParser.SearchResultsParser.m11428a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object searchResultsModel = new SearchResultsModel();
                    ((BaseModel) searchResultsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (searchResultsModel instanceof Postprocessable) {
                        return ((Postprocessable) searchResultsModel).a();
                    }
                    return searchResultsModel;
                }
            }

            /* compiled from: place_is_logging_enabled */
            public class Serializer extends JsonSerializer<SearchResultsModel> {
                public final void m11388a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    SearchResultsModel searchResultsModel = (SearchResultsModel) obj;
                    if (searchResultsModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(searchResultsModel.m11389a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        searchResultsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    WorkEntitiesTypeAheadSuggestionsQueryParser.SearchResultsParser.m11429a(searchResultsModel.w_(), searchResultsModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(SearchResultsModel.class, new Serializer());
                }
            }

            public SearchResultsModel() {
                super(1);
            }

            @Nonnull
            public final ImmutableList<TypeAheadSuggestionFieldsModel> m11391a() {
                this.f7899d = super.a(this.f7899d, 0, TypeAheadSuggestionFieldsModel.class);
                return (ImmutableList) this.f7899d;
            }

            public final int jK_() {
                return 1843101810;
            }

            public final GraphQLVisitableModel m11390a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m11391a() != null) {
                    Builder a = ModelHelper.a(m11391a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (SearchResultsModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f7899d = a.b();
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m11389a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m11391a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: place_is_logging_enabled */
        public class Serializer extends JsonSerializer<WorkEntitiesTypeAheadSuggestionsQueryModel> {
            public final void m11392a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                WorkEntitiesTypeAheadSuggestionsQueryModel workEntitiesTypeAheadSuggestionsQueryModel = (WorkEntitiesTypeAheadSuggestionsQueryModel) obj;
                if (workEntitiesTypeAheadSuggestionsQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(workEntitiesTypeAheadSuggestionsQueryModel.m11393a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    workEntitiesTypeAheadSuggestionsQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = workEntitiesTypeAheadSuggestionsQueryModel.w_();
                int u_ = workEntitiesTypeAheadSuggestionsQueryModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("search_results");
                    WorkEntitiesTypeAheadSuggestionsQueryParser.SearchResultsParser.m11429a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(WorkEntitiesTypeAheadSuggestionsQueryModel.class, new Serializer());
            }
        }

        public WorkEntitiesTypeAheadSuggestionsQueryModel() {
            super(1);
        }

        @Nullable
        public final SearchResultsModel m11394a() {
            this.f7900d = (SearchResultsModel) super.a(this.f7900d, 0, SearchResultsModel.class);
            return this.f7900d;
        }

        public final int jK_() {
            return 332244357;
        }

        public final GraphQLVisitableModel m11395a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m11394a() != null) {
                SearchResultsModel searchResultsModel = (SearchResultsModel) graphQLModelMutatingVisitor.b(m11394a());
                if (m11394a() != searchResultsModel) {
                    graphQLVisitableModel = (WorkEntitiesTypeAheadSuggestionsQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f7900d = searchResultsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m11393a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m11394a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }
}
