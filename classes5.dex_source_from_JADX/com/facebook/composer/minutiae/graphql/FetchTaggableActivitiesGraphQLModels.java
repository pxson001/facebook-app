package com.facebook.composer.minutiae.graphql;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.composer.minutiae.graphql.FetchTaggableActivitiesGraphQLParsers.FetchRankedVerbsQueryParser;
import com.facebook.composer.minutiae.graphql.FetchTaggableActivitiesGraphQLParsers.FetchRankedVerbsQueryParser.MinutiaeSuggestionsParser;
import com.facebook.composer.minutiae.graphql.FetchTaggableActivitiesGraphQLParsers.FetchRankedVerbsQueryParser.MinutiaeSuggestionsParser.NodesParser;
import com.facebook.composer.minutiae.graphql.FetchTaggableActivitiesGraphQLParsers.FetchTaggableActivitiesQueryParser;
import com.facebook.composer.minutiae.graphql.MinutiaeDefaultsGraphQLModels.MinutiaeTaggableActivityModel;
import com.facebook.composer.minutiae.graphql.MinutiaeDefaultsGraphQLParsers.MinutiaeTaggableActivityParser;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
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

/* compiled from: ads_cta_type */
public class FetchTaggableActivitiesGraphQLModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 491985185)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: ads_cta_type */
    public final class FetchRankedVerbsQueryModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private MinutiaeSuggestionsModel f11257d;

        /* compiled from: ads_cta_type */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FetchRankedVerbsQueryModel.class, new Deserializer());
            }

            public Object m19148a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = FetchRankedVerbsQueryParser.m19173a(jsonParser);
                Object fetchRankedVerbsQueryModel = new FetchRankedVerbsQueryModel();
                ((BaseModel) fetchRankedVerbsQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (fetchRankedVerbsQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) fetchRankedVerbsQueryModel).a();
                }
                return fetchRankedVerbsQueryModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 959204049)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: ads_cta_type */
        public final class MinutiaeSuggestionsModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<NodesModel> f11256d;

            /* compiled from: ads_cta_type */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(MinutiaeSuggestionsModel.class, new Deserializer());
                }

                public Object m19149a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(MinutiaeSuggestionsParser.m19171a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object minutiaeSuggestionsModel = new MinutiaeSuggestionsModel();
                    ((BaseModel) minutiaeSuggestionsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (minutiaeSuggestionsModel instanceof Postprocessable) {
                        return ((Postprocessable) minutiaeSuggestionsModel).a();
                    }
                    return minutiaeSuggestionsModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -2108302273)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: ads_cta_type */
            public final class NodesModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private String f11254d;
                @Nullable
                private MinutiaeTaggableActivityModel f11255e;

                /* compiled from: ads_cta_type */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(NodesModel.class, new Deserializer());
                    }

                    public Object m19150a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(NodesParser.m19169b(jsonParser, flatBufferBuilder));
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

                /* compiled from: ads_cta_type */
                public class Serializer extends JsonSerializer<NodesModel> {
                    public final void m19151a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        NodesModel nodesModel = (NodesModel) obj;
                        if (nodesModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(nodesModel.m19152a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            nodesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        NodesParser.m19170b(nodesModel.w_(), nodesModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(NodesModel.class, new Serializer());
                    }
                }

                public NodesModel() {
                    super(2);
                }

                @Nullable
                public final String m19154a() {
                    this.f11254d = super.a(this.f11254d, 0);
                    return this.f11254d;
                }

                @Nullable
                public final MinutiaeTaggableActivityModel m19155j() {
                    this.f11255e = (MinutiaeTaggableActivityModel) super.a(this.f11255e, 1, MinutiaeTaggableActivityModel.class);
                    return this.f11255e;
                }

                public final int jK_() {
                    return -964766848;
                }

                public final GraphQLVisitableModel m19153a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m19155j() != null) {
                        MinutiaeTaggableActivityModel minutiaeTaggableActivityModel = (MinutiaeTaggableActivityModel) graphQLModelMutatingVisitor.b(m19155j());
                        if (m19155j() != minutiaeTaggableActivityModel) {
                            graphQLVisitableModel = (NodesModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f11255e = minutiaeTaggableActivityModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m19152a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int b = flatBufferBuilder.b(m19154a());
                    int a = ModelHelper.a(flatBufferBuilder, m19155j());
                    flatBufferBuilder.c(2);
                    flatBufferBuilder.b(0, b);
                    flatBufferBuilder.b(1, a);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: ads_cta_type */
            public class Serializer extends JsonSerializer<MinutiaeSuggestionsModel> {
                public final void m19156a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    MinutiaeSuggestionsModel minutiaeSuggestionsModel = (MinutiaeSuggestionsModel) obj;
                    if (minutiaeSuggestionsModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(minutiaeSuggestionsModel.m19157a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        minutiaeSuggestionsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    MinutiaeSuggestionsParser.m19172a(minutiaeSuggestionsModel.w_(), minutiaeSuggestionsModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(MinutiaeSuggestionsModel.class, new Serializer());
                }
            }

            public MinutiaeSuggestionsModel() {
                super(1);
            }

            @Nonnull
            public final ImmutableList<NodesModel> m19159a() {
                this.f11256d = super.a(this.f11256d, 0, NodesModel.class);
                return (ImmutableList) this.f11256d;
            }

            public final int jK_() {
                return 1312072753;
            }

            public final GraphQLVisitableModel m19158a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m19159a() != null) {
                    Builder a = ModelHelper.a(m19159a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (MinutiaeSuggestionsModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f11256d = a.b();
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m19157a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m19159a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: ads_cta_type */
        public class Serializer extends JsonSerializer<FetchRankedVerbsQueryModel> {
            public final void m19160a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                FetchRankedVerbsQueryModel fetchRankedVerbsQueryModel = (FetchRankedVerbsQueryModel) obj;
                if (fetchRankedVerbsQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(fetchRankedVerbsQueryModel.m19161a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    fetchRankedVerbsQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = fetchRankedVerbsQueryModel.w_();
                int u_ = fetchRankedVerbsQueryModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("minutiae_suggestions");
                    MinutiaeSuggestionsParser.m19172a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(FetchRankedVerbsQueryModel.class, new Serializer());
            }
        }

        public FetchRankedVerbsQueryModel() {
            super(1);
        }

        @Nullable
        public final MinutiaeSuggestionsModel m19162a() {
            this.f11257d = (MinutiaeSuggestionsModel) super.a(this.f11257d, 0, MinutiaeSuggestionsModel.class);
            return this.f11257d;
        }

        public final int jK_() {
            return -1732764110;
        }

        public final GraphQLVisitableModel m19163a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m19162a() != null) {
                MinutiaeSuggestionsModel minutiaeSuggestionsModel = (MinutiaeSuggestionsModel) graphQLModelMutatingVisitor.b(m19162a());
                if (m19162a() != minutiaeSuggestionsModel) {
                    graphQLVisitableModel = (FetchRankedVerbsQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f11257d = minutiaeSuggestionsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m19161a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m19162a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 267147158)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: ads_cta_type */
    public final class FetchTaggableActivitiesQueryModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private List<MinutiaeTaggableActivityModel> f11258d;

        /* compiled from: ads_cta_type */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FetchTaggableActivitiesQueryModel.class, new Deserializer());
            }

            public Object m19164a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(FetchTaggableActivitiesQueryParser.m19174a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object fetchTaggableActivitiesQueryModel = new FetchTaggableActivitiesQueryModel();
                ((BaseModel) fetchTaggableActivitiesQueryModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (fetchTaggableActivitiesQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) fetchTaggableActivitiesQueryModel).a();
                }
                return fetchTaggableActivitiesQueryModel;
            }
        }

        /* compiled from: ads_cta_type */
        public class Serializer extends JsonSerializer<FetchTaggableActivitiesQueryModel> {
            public final void m19165a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                FetchTaggableActivitiesQueryModel fetchTaggableActivitiesQueryModel = (FetchTaggableActivitiesQueryModel) obj;
                if (fetchTaggableActivitiesQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(fetchTaggableActivitiesQueryModel.m19166a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    fetchTaggableActivitiesQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = fetchTaggableActivitiesQueryModel.w_();
                int u_ = fetchTaggableActivitiesQueryModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("taggable_activities");
                    jsonGenerator.d();
                    for (int i = 0; i < mutableFlatBuffer.c(g); i++) {
                        MinutiaeTaggableActivityParser.m19531b(mutableFlatBuffer, mutableFlatBuffer.m(g, i), jsonGenerator, serializerProvider);
                    }
                    jsonGenerator.e();
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(FetchTaggableActivitiesQueryModel.class, new Serializer());
            }
        }

        public FetchTaggableActivitiesQueryModel() {
            super(1);
        }

        @Nonnull
        public final ImmutableList<MinutiaeTaggableActivityModel> m19168a() {
            this.f11258d = super.a(this.f11258d, 0, MinutiaeTaggableActivityModel.class);
            return (ImmutableList) this.f11258d;
        }

        public final int jK_() {
            return -1732764110;
        }

        public final GraphQLVisitableModel m19167a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m19168a() != null) {
                Builder a = ModelHelper.a(m19168a(), graphQLModelMutatingVisitor);
                if (a != null) {
                    graphQLVisitableModel = (FetchTaggableActivitiesQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f11258d = a.b();
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m19166a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m19168a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }
}
