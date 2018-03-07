package com.facebook.feed.protocol;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.feed.protocol.FetchAggregatedStoryGraphQLParsers.AggregatedStorySubstoryQueryParser;
import com.facebook.feed.protocol.FetchAggregatedStoryGraphQLParsers.AggregatedStorySubstoryQueryParser.AllSubstoriesParser;
import com.facebook.feed.protocol.FetchAggregatedStoryGraphQLParsers.AggregatedStorySubstoryQueryParser.AllSubstoriesParser.PageInfoParser;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithBridge;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.modelutil.SerializerHelpers;
import com.facebook.graphql.visitor.ConsistencyTuple;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
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

/* compiled from: movie_title */
public class FetchAggregatedStoryGraphQLModels {

    @FragmentModelWithBridge
    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 303311927)
    @JsonSerialize(using = Serializer.class)
    /* compiled from: movie_title */
    public final class AggregatedStorySubstoryQueryModel extends BaseModel implements GraphQLVisitableConsistentModel {
        @Nullable
        private GraphQLObjectType f10183d;
        @Nullable
        private AllSubstoriesModel f10184e;

        @FragmentModelWithBridge
        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1739229980)
        @JsonSerialize(using = Serializer.class)
        /* compiled from: movie_title */
        public final class AllSubstoriesModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<GraphQLStory> f10180d;
            @Nullable
            private PageInfoModel f10181e;
            private int f10182f;

            /* compiled from: movie_title */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(AllSubstoriesModel.class, new Deserializer());
                }

                public Object m15845a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(AllSubstoriesParser.m15870a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object allSubstoriesModel = new AllSubstoriesModel();
                    ((BaseModel) allSubstoriesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (allSubstoriesModel instanceof Postprocessable) {
                        return ((Postprocessable) allSubstoriesModel).a();
                    }
                    return allSubstoriesModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -2005169142)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: movie_title */
            public final class PageInfoModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private String f10178d;
                private boolean f10179e;

                /* compiled from: movie_title */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(PageInfoModel.class, new Deserializer());
                    }

                    public Object m15846a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(PageInfoParser.m15868a(jsonParser, flatBufferBuilder));
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

                /* compiled from: movie_title */
                public class Serializer extends JsonSerializer<PageInfoModel> {
                    public final void m15847a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        PageInfoModel pageInfoModel = (PageInfoModel) obj;
                        if (pageInfoModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(pageInfoModel.m15848a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            pageInfoModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        PageInfoParser.m15869a(pageInfoModel.w_(), pageInfoModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(PageInfoModel.class, new Serializer());
                    }
                }

                public PageInfoModel() {
                    super(2);
                }

                @Nullable
                public final String m15850a() {
                    this.f10178d = super.a(this.f10178d, 0);
                    return this.f10178d;
                }

                public final boolean m15852j() {
                    a(0, 1);
                    return this.f10179e;
                }

                public final int jK_() {
                    return 923779069;
                }

                public final GraphQLVisitableModel m15849a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m15848a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int b = flatBufferBuilder.b(m15850a());
                    flatBufferBuilder.c(2);
                    flatBufferBuilder.b(0, b);
                    flatBufferBuilder.a(1, this.f10179e);
                    i();
                    return flatBufferBuilder.d();
                }

                public final void m15851a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                    super.a(mutableFlatBuffer, i, obj);
                    this.f10179e = mutableFlatBuffer.a(i, 1);
                }
            }

            /* compiled from: movie_title */
            public class Serializer extends JsonSerializer<AllSubstoriesModel> {
                public final void m15853a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    AllSubstoriesModel allSubstoriesModel = (AllSubstoriesModel) obj;
                    if (allSubstoriesModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(allSubstoriesModel.m15854a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        allSubstoriesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    AllSubstoriesParser.m15871a(allSubstoriesModel.w_(), allSubstoriesModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(AllSubstoriesModel.class, new Serializer());
                }
            }

            public AllSubstoriesModel() {
                super(3);
            }

            @Nonnull
            public final ImmutableList<GraphQLStory> m15856a() {
                this.f10180d = super.a(this.f10180d, 0, GraphQLStory.class);
                return (ImmutableList) this.f10180d;
            }

            @Nullable
            public final PageInfoModel m15858j() {
                this.f10181e = (PageInfoModel) super.a(this.f10181e, 1, PageInfoModel.class);
                return this.f10181e;
            }

            public final int m15859k() {
                a(0, 2);
                return this.f10182f;
            }

            public final int jK_() {
                return 1571057009;
            }

            public final GraphQLVisitableModel m15855a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel;
                PageInfoModel pageInfoModel;
                h();
                if (m15856a() != null) {
                    Builder a = ModelHelper.a(m15856a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        AllSubstoriesModel allSubstoriesModel = (AllSubstoriesModel) ModelHelper.a(null, this);
                        allSubstoriesModel.f10180d = a.b();
                        graphQLVisitableModel = allSubstoriesModel;
                        if (m15858j() != null) {
                            pageInfoModel = (PageInfoModel) graphQLModelMutatingVisitor.b(m15858j());
                            if (m15858j() != pageInfoModel) {
                                graphQLVisitableModel = (AllSubstoriesModel) ModelHelper.a(graphQLVisitableModel, this);
                                graphQLVisitableModel.f10181e = pageInfoModel;
                            }
                        }
                        i();
                        return graphQLVisitableModel != null ? this : graphQLVisitableModel;
                    }
                }
                graphQLVisitableModel = null;
                if (m15858j() != null) {
                    pageInfoModel = (PageInfoModel) graphQLModelMutatingVisitor.b(m15858j());
                    if (m15858j() != pageInfoModel) {
                        graphQLVisitableModel = (AllSubstoriesModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f10181e = pageInfoModel;
                    }
                }
                i();
                if (graphQLVisitableModel != null) {
                }
            }

            public final int m15854a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m15856a());
                int a2 = ModelHelper.a(flatBufferBuilder, m15858j());
                flatBufferBuilder.c(3);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, a2);
                flatBufferBuilder.a(2, this.f10182f, 0);
                i();
                return flatBufferBuilder.d();
            }

            public final void m15857a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f10182f = mutableFlatBuffer.a(i, 2, 0);
            }
        }

        /* compiled from: movie_title */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(AggregatedStorySubstoryQueryModel.class, new Deserializer());
            }

            public Object m15860a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = AggregatedStorySubstoryQueryParser.m15872a(jsonParser);
                Object aggregatedStorySubstoryQueryModel = new AggregatedStorySubstoryQueryModel();
                ((BaseModel) aggregatedStorySubstoryQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (aggregatedStorySubstoryQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) aggregatedStorySubstoryQueryModel).a();
                }
                return aggregatedStorySubstoryQueryModel;
            }
        }

        /* compiled from: movie_title */
        public class Serializer extends JsonSerializer<AggregatedStorySubstoryQueryModel> {
            public final void m15861a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                AggregatedStorySubstoryQueryModel aggregatedStorySubstoryQueryModel = (AggregatedStorySubstoryQueryModel) obj;
                if (aggregatedStorySubstoryQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(aggregatedStorySubstoryQueryModel.m15863a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    aggregatedStorySubstoryQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = aggregatedStorySubstoryQueryModel.w_();
                int u_ = aggregatedStorySubstoryQueryModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("__type__");
                    SerializerHelpers.b(mutableFlatBuffer, u_, 0, jsonGenerator);
                }
                int g = mutableFlatBuffer.g(u_, 1);
                if (g != 0) {
                    jsonGenerator.a("all_substories");
                    AllSubstoriesParser.m15871a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(AggregatedStorySubstoryQueryModel.class, new Serializer());
            }
        }

        public AggregatedStorySubstoryQueryModel() {
            super(2);
        }

        public final void m15866a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m15867a(String str, Object obj, boolean z) {
        }

        @Nullable
        private GraphQLObjectType m15862j() {
            if (this.b != null && this.f10183d == null) {
                this.f10183d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
            }
            return this.f10183d;
        }

        @Nullable
        public final AllSubstoriesModel m15864a() {
            this.f10184e = (AllSubstoriesModel) super.a(this.f10184e, 1, AllSubstoriesModel.class);
            return this.f10184e;
        }

        public final int jK_() {
            return 2433570;
        }

        public final GraphQLVisitableModel m15865a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m15864a() != null) {
                AllSubstoriesModel allSubstoriesModel = (AllSubstoriesModel) graphQLModelMutatingVisitor.b(m15864a());
                if (m15864a() != allSubstoriesModel) {
                    graphQLVisitableModel = (AggregatedStorySubstoryQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f10184e = allSubstoriesModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m15863a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m15862j());
            int a2 = ModelHelper.a(flatBufferBuilder, m15864a());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            i();
            return flatBufferBuilder.d();
        }
    }
}
