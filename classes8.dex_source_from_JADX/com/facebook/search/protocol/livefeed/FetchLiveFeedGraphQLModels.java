package com.facebook.search.protocol.livefeed;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.querybuilder.common.CommonGraphQL2Interfaces.DefaultPageInfoFields;
import com.facebook.graphql.querybuilder.common.CommonGraphQL2Models.DefaultPageInfoFieldsModel;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.search.protocol.livefeed.FetchLiveFeedGraphQLParsers.FetchLiveFeedStoriesGraphQLParser;
import com.facebook.search.protocol.livefeed.FetchLiveFeedGraphQLParsers.LiveFeedNodeParser;
import com.facebook.search.protocol.livefeed.FetchLiveFeedGraphQLParsers.LiveFeedQueryParser;
import com.facebook.search.protocol.livefeed.FetchLiveFeedGraphQLParsers.LiveFeedQueryParser.ResultsParser;
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

/* compiled from: muted */
public class FetchLiveFeedGraphQLModels {

    @FragmentModelWithBridge
    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 538289616)
    @JsonSerialize(using = Serializer.class)
    /* compiled from: muted */
    public final class FetchLiveFeedStoriesGraphQLModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private LiveFeedQueryModel f8279d;

        /* compiled from: muted */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FetchLiveFeedStoriesGraphQLModel.class, new Deserializer());
            }

            public Object m9393a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = FetchLiveFeedStoriesGraphQLParser.m9419a(jsonParser);
                Object fetchLiveFeedStoriesGraphQLModel = new FetchLiveFeedStoriesGraphQLModel();
                ((BaseModel) fetchLiveFeedStoriesGraphQLModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (fetchLiveFeedStoriesGraphQLModel instanceof Postprocessable) {
                    return ((Postprocessable) fetchLiveFeedStoriesGraphQLModel).a();
                }
                return fetchLiveFeedStoriesGraphQLModel;
            }
        }

        /* compiled from: muted */
        public class Serializer extends JsonSerializer<FetchLiveFeedStoriesGraphQLModel> {
            public final void m9394a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                FetchLiveFeedStoriesGraphQLModel fetchLiveFeedStoriesGraphQLModel = (FetchLiveFeedStoriesGraphQLModel) obj;
                if (fetchLiveFeedStoriesGraphQLModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(fetchLiveFeedStoriesGraphQLModel.m9395a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    fetchLiveFeedStoriesGraphQLModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = fetchLiveFeedStoriesGraphQLModel.w_();
                int u_ = fetchLiveFeedStoriesGraphQLModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("filtered_query");
                    LiveFeedQueryParser.m9425a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(FetchLiveFeedStoriesGraphQLModel.class, new Serializer());
            }
        }

        public FetchLiveFeedStoriesGraphQLModel() {
            super(1);
        }

        @Nullable
        public final LiveFeedQueryModel m9397a() {
            this.f8279d = (LiveFeedQueryModel) super.a(this.f8279d, 0, LiveFeedQueryModel.class);
            return this.f8279d;
        }

        public final int jK_() {
            return -466486798;
        }

        public final GraphQLVisitableModel m9396a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m9397a() != null) {
                LiveFeedQueryModel liveFeedQueryModel = (LiveFeedQueryModel) graphQLModelMutatingVisitor.b(m9397a());
                if (m9397a() != liveFeedQueryModel) {
                    graphQLVisitableModel = (FetchLiveFeedStoriesGraphQLModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f8279d = liveFeedQueryModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m9395a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m9397a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @FragmentModelWithBridge
    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1328370499)
    @JsonSerialize(using = Serializer.class)
    /* compiled from: muted */
    public final class LiveFeedNodeModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private GraphQLStory f8280d;

        /* compiled from: muted */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(LiveFeedNodeModel.class, new Deserializer());
            }

            public Object m9398a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(LiveFeedNodeParser.m9420b(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object liveFeedNodeModel = new LiveFeedNodeModel();
                ((BaseModel) liveFeedNodeModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (liveFeedNodeModel instanceof Postprocessable) {
                    return ((Postprocessable) liveFeedNodeModel).a();
                }
                return liveFeedNodeModel;
            }
        }

        /* compiled from: muted */
        public class Serializer extends JsonSerializer<LiveFeedNodeModel> {
            public final void m9399a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                LiveFeedNodeModel liveFeedNodeModel = (LiveFeedNodeModel) obj;
                if (liveFeedNodeModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(liveFeedNodeModel.m9400a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    liveFeedNodeModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                LiveFeedNodeParser.m9421b(liveFeedNodeModel.w_(), liveFeedNodeModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(LiveFeedNodeModel.class, new Serializer());
            }
        }

        public LiveFeedNodeModel() {
            super(1);
        }

        @Nullable
        public final GraphQLStory m9401a() {
            this.f8280d = (GraphQLStory) super.a(this.f8280d, 0, GraphQLStory.class);
            return this.f8280d;
        }

        public final int jK_() {
            return -316863363;
        }

        public final GraphQLVisitableModel m9402a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m9401a() != null) {
                GraphQLStory graphQLStory = (GraphQLStory) graphQLModelMutatingVisitor.b(m9401a());
                if (m9401a() != graphQLStory) {
                    graphQLVisitableModel = (LiveFeedNodeModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f8280d = graphQLStory;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m9400a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m9401a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @FragmentModelWithBridge
    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1694118594)
    @JsonSerialize(using = Serializer.class)
    /* compiled from: muted */
    public final class LiveFeedQueryModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private String f8283d;
        @Nullable
        private ResultsModel f8284e;
        @Nullable
        private String f8285f;
        @Nullable
        private String f8286g;

        /* compiled from: muted */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(LiveFeedQueryModel.class, new Deserializer());
            }

            public Object m9403a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(LiveFeedQueryParser.m9424a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object liveFeedQueryModel = new LiveFeedQueryModel();
                ((BaseModel) liveFeedQueryModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (liveFeedQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) liveFeedQueryModel).a();
                }
                return liveFeedQueryModel;
            }
        }

        @FragmentModelWithBridge
        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 492076314)
        @JsonSerialize(using = Serializer.class)
        /* compiled from: muted */
        public final class ResultsModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<LiveFeedNodeModel> f8281d;
            @Nullable
            private DefaultPageInfoFieldsModel f8282e;

            /* compiled from: muted */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(ResultsModel.class, new Deserializer());
                }

                public Object m9404a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(ResultsParser.m9422a(jsonParser, flatBufferBuilder));
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

            /* compiled from: muted */
            public class Serializer extends JsonSerializer<ResultsModel> {
                public final void m9405a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    ResultsModel resultsModel = (ResultsModel) obj;
                    if (resultsModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(resultsModel.m9407a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        resultsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    ResultsParser.m9423a(resultsModel.w_(), resultsModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(ResultsModel.class, new Serializer());
                }
            }

            @Nullable
            public final /* synthetic */ DefaultPageInfoFields m9410b() {
                return m9406j();
            }

            public ResultsModel() {
                super(2);
            }

            @Nonnull
            public final ImmutableList<LiveFeedNodeModel> m9409a() {
                this.f8281d = super.a(this.f8281d, 0, LiveFeedNodeModel.class);
                return (ImmutableList) this.f8281d;
            }

            @Nullable
            private DefaultPageInfoFieldsModel m9406j() {
                this.f8282e = (DefaultPageInfoFieldsModel) super.a(this.f8282e, 1, DefaultPageInfoFieldsModel.class);
                return this.f8282e;
            }

            public final int jK_() {
                return 1580207518;
            }

            public final GraphQLVisitableModel m9408a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel;
                DefaultPageInfoFieldsModel defaultPageInfoFieldsModel;
                h();
                if (m9409a() != null) {
                    Builder a = ModelHelper.a(m9409a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        ResultsModel resultsModel = (ResultsModel) ModelHelper.a(null, this);
                        resultsModel.f8281d = a.b();
                        graphQLVisitableModel = resultsModel;
                        if (m9406j() != null) {
                            defaultPageInfoFieldsModel = (DefaultPageInfoFieldsModel) graphQLModelMutatingVisitor.b(m9406j());
                            if (m9406j() != defaultPageInfoFieldsModel) {
                                graphQLVisitableModel = (ResultsModel) ModelHelper.a(graphQLVisitableModel, this);
                                graphQLVisitableModel.f8282e = defaultPageInfoFieldsModel;
                            }
                        }
                        i();
                        return graphQLVisitableModel != null ? this : graphQLVisitableModel;
                    }
                }
                graphQLVisitableModel = null;
                if (m9406j() != null) {
                    defaultPageInfoFieldsModel = (DefaultPageInfoFieldsModel) graphQLModelMutatingVisitor.b(m9406j());
                    if (m9406j() != defaultPageInfoFieldsModel) {
                        graphQLVisitableModel = (ResultsModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f8282e = defaultPageInfoFieldsModel;
                    }
                }
                i();
                if (graphQLVisitableModel != null) {
                }
            }

            public final int m9407a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m9409a());
                int a2 = ModelHelper.a(flatBufferBuilder, m9406j());
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, a2);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: muted */
        public class Serializer extends JsonSerializer<LiveFeedQueryModel> {
            public final void m9411a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                LiveFeedQueryModel liveFeedQueryModel = (LiveFeedQueryModel) obj;
                if (liveFeedQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(liveFeedQueryModel.m9413a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    liveFeedQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                LiveFeedQueryParser.m9425a(liveFeedQueryModel.w_(), liveFeedQueryModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(LiveFeedQueryModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ ResultsModel m9416b() {
            return m9412j();
        }

        public LiveFeedQueryModel() {
            super(4);
        }

        @Nullable
        public final String m9415a() {
            this.f8283d = super.a(this.f8283d, 0);
            return this.f8283d;
        }

        @Nullable
        private ResultsModel m9412j() {
            this.f8284e = (ResultsModel) super.a(this.f8284e, 1, ResultsModel.class);
            return this.f8284e;
        }

        @Nullable
        public final String m9417c() {
            this.f8285f = super.a(this.f8285f, 2);
            return this.f8285f;
        }

        @Nullable
        public final String m9418d() {
            this.f8286g = super.a(this.f8286g, 3);
            return this.f8286g;
        }

        public final int jK_() {
            return -466486798;
        }

        public final GraphQLVisitableModel m9414a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m9412j() != null) {
                ResultsModel resultsModel = (ResultsModel) graphQLModelMutatingVisitor.b(m9412j());
                if (m9412j() != resultsModel) {
                    graphQLVisitableModel = (LiveFeedQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f8284e = resultsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m9413a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m9415a());
            int a = ModelHelper.a(flatBufferBuilder, m9412j());
            int b2 = flatBufferBuilder.b(m9417c());
            int b3 = flatBufferBuilder.b(m9418d());
            flatBufferBuilder.c(4);
            flatBufferBuilder.b(0, b);
            flatBufferBuilder.b(1, a);
            flatBufferBuilder.b(2, b2);
            flatBufferBuilder.b(3, b3);
            i();
            return flatBufferBuilder.d();
        }
    }
}
