package com.facebook.pages.fb4a.data.graphql.story;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLStoryDeserializer;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.visitor.ConsistencyTuple;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.pages.fb4a.data.graphql.story.PageStoryGraphQLParsers.PageOfferPostQueryParser;
import com.facebook.pages.fb4a.data.graphql.story.PageStoryGraphQLParsers.PageOfferPostQueryParser.CouponsParser;
import com.facebook.pages.fb4a.data.graphql.story.PageStoryGraphQLParsers.PageOfferPostQueryParser.CouponsParser.NodesParser;
import com.facebook.pages.fb4a.data.graphql.story.PageStoryGraphQLParsers.PagePinnedPostQueryParser;
import com.facebook.pages.fb4a.data.graphql.story.PageStoryGraphQLParsers.PageStoryCardsQueryParser;
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

/* compiled from: pulsar is null */
public class PageStoryGraphQLModels {

    @FragmentModelWithBridge
    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1110290967)
    @JsonSerialize(using = Serializer.class)
    /* compiled from: pulsar is null */
    public final class PageOfferPostQueryModel extends BaseModel implements GraphQLVisitableConsistentModel {
        @Nullable
        private CouponsModel f2946d;

        @FragmentModelWithBridge
        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1192253320)
        @JsonSerialize(using = Serializer.class)
        /* compiled from: pulsar is null */
        public final class CouponsModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<NodesModel> f2945d;

            /* compiled from: pulsar is null */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(CouponsModel.class, new Deserializer());
                }

                public Object m3908a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(CouponsParser.m3957a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object couponsModel = new CouponsModel();
                    ((BaseModel) couponsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (couponsModel instanceof Postprocessable) {
                        return ((Postprocessable) couponsModel).a();
                    }
                    return couponsModel;
                }
            }

            @FragmentModelWithBridge
            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 518879773)
            @JsonSerialize(using = Serializer.class)
            /* compiled from: pulsar is null */
            public final class NodesModel extends BaseModel implements GraphQLVisitableConsistentModel {
                @Nullable
                private GraphQLStory f2944d;

                /* compiled from: pulsar is null */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(NodesModel.class, new Deserializer());
                    }

                    public Object m3909a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(NodesParser.m3955b(jsonParser, flatBufferBuilder));
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

                /* compiled from: pulsar is null */
                public class Serializer extends JsonSerializer<NodesModel> {
                    public final void m3910a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        NodesModel nodesModel = (NodesModel) obj;
                        if (nodesModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(nodesModel.m3912a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            nodesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        NodesParser.m3956b(nodesModel.w_(), nodesModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(NodesModel.class, new Serializer());
                    }
                }

                public NodesModel() {
                    super(1);
                }

                public final void m3914a(String str, ConsistencyTuple consistencyTuple) {
                    consistencyTuple.a();
                }

                public final void m3915a(String str, Object obj, boolean z) {
                }

                @Nullable
                private GraphQLStory m3911a() {
                    this.f2944d = (GraphQLStory) super.a(this.f2944d, 0, GraphQLStory.class);
                    return this.f2944d;
                }

                public final int jK_() {
                    return 2024260678;
                }

                public final GraphQLVisitableModel m3913a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m3911a() != null) {
                        GraphQLStory graphQLStory = (GraphQLStory) graphQLModelMutatingVisitor.b(m3911a());
                        if (m3911a() != graphQLStory) {
                            graphQLVisitableModel = (NodesModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f2944d = graphQLStory;
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m3912a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m3911a());
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, a);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: pulsar is null */
            public class Serializer extends JsonSerializer<CouponsModel> {
                public final void m3916a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    CouponsModel couponsModel = (CouponsModel) obj;
                    if (couponsModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(couponsModel.m3918a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        couponsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    CouponsParser.m3958a(couponsModel.w_(), couponsModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(CouponsModel.class, new Serializer());
                }
            }

            public CouponsModel() {
                super(1);
            }

            @Nonnull
            private ImmutableList<NodesModel> m3917a() {
                this.f2945d = super.a(this.f2945d, 0, NodesModel.class);
                return (ImmutableList) this.f2945d;
            }

            public final int jK_() {
                return -1296688932;
            }

            public final GraphQLVisitableModel m3919a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m3917a() != null) {
                    Builder a = ModelHelper.a(m3917a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (CouponsModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f2945d = a.b();
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m3918a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m3917a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: pulsar is null */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(PageOfferPostQueryModel.class, new Deserializer());
            }

            public Object m3920a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = PageOfferPostQueryParser.m3959a(jsonParser);
                Object pageOfferPostQueryModel = new PageOfferPostQueryModel();
                ((BaseModel) pageOfferPostQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (pageOfferPostQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) pageOfferPostQueryModel).a();
                }
                return pageOfferPostQueryModel;
            }
        }

        /* compiled from: pulsar is null */
        public class Serializer extends JsonSerializer<PageOfferPostQueryModel> {
            public final void m3921a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                PageOfferPostQueryModel pageOfferPostQueryModel = (PageOfferPostQueryModel) obj;
                if (pageOfferPostQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(pageOfferPostQueryModel.m3923a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    pageOfferPostQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = pageOfferPostQueryModel.w_();
                int u_ = pageOfferPostQueryModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("coupons");
                    CouponsParser.m3958a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(PageOfferPostQueryModel.class, new Serializer());
            }
        }

        public PageOfferPostQueryModel() {
            super(1);
        }

        public final void m3925a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m3926a(String str, Object obj, boolean z) {
        }

        @Nullable
        private CouponsModel m3922a() {
            this.f2946d = (CouponsModel) super.a(this.f2946d, 0, CouponsModel.class);
            return this.f2946d;
        }

        public final int jK_() {
            return 2479791;
        }

        public final GraphQLVisitableModel m3924a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m3922a() != null) {
                CouponsModel couponsModel = (CouponsModel) graphQLModelMutatingVisitor.b(m3922a());
                if (m3922a() != couponsModel) {
                    graphQLVisitableModel = (PageOfferPostQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f2946d = couponsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m3923a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m3922a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @FragmentModelWithBridge
    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -452752819)
    @JsonSerialize(using = Serializer.class)
    /* compiled from: pulsar is null */
    public final class PagePinnedPostQueryModel extends BaseModel implements GraphQLVisitableConsistentModel {
        @Nullable
        private GraphQLStory f2947d;

        /* compiled from: pulsar is null */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(PagePinnedPostQueryModel.class, new Deserializer());
            }

            public Object m3927a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = PagePinnedPostQueryParser.m3960a(jsonParser);
                Object pagePinnedPostQueryModel = new PagePinnedPostQueryModel();
                ((BaseModel) pagePinnedPostQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (pagePinnedPostQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) pagePinnedPostQueryModel).a();
                }
                return pagePinnedPostQueryModel;
            }
        }

        /* compiled from: pulsar is null */
        public class Serializer extends JsonSerializer<PagePinnedPostQueryModel> {
            public final void m3928a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                PagePinnedPostQueryModel pagePinnedPostQueryModel = (PagePinnedPostQueryModel) obj;
                if (pagePinnedPostQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(pagePinnedPostQueryModel.m3930a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    pagePinnedPostQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = pagePinnedPostQueryModel.w_();
                int u_ = pagePinnedPostQueryModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("timeline_pinned_unit");
                    GraphQLStoryDeserializer.b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(PagePinnedPostQueryModel.class, new Serializer());
            }
        }

        public PagePinnedPostQueryModel() {
            super(1);
        }

        public final void m3932a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m3933a(String str, Object obj, boolean z) {
        }

        @Nullable
        private GraphQLStory m3929a() {
            this.f2947d = (GraphQLStory) super.a(this.f2947d, 0, GraphQLStory.class);
            return this.f2947d;
        }

        public final int jK_() {
            return 2479791;
        }

        public final GraphQLVisitableModel m3931a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m3929a() != null) {
                GraphQLStory graphQLStory = (GraphQLStory) graphQLModelMutatingVisitor.b(m3929a());
                if (m3929a() != graphQLStory) {
                    graphQLVisitableModel = (PagePinnedPostQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f2947d = graphQLStory;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m3930a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m3929a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @FragmentModelWithBridge
    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1132435432)
    @JsonSerialize(using = Serializer.class)
    /* compiled from: pulsar is null */
    public final class PageStoryCardsQueryModel extends BaseModel implements GraphQLVisitableConsistentModel {
        @Nullable
        private CouponsModel f2951d;
        @Nullable
        private GraphQLStory f2952e;

        @FragmentModelWithBridge
        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1896553308)
        @JsonSerialize(using = Serializer.class)
        /* compiled from: pulsar is null */
        public final class CouponsModel extends BaseModel implements GraphQLVisitableModel {
            private int f2949d;
            @Nullable
            private List<NodesModel> f2950e;

            /* compiled from: pulsar is null */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(CouponsModel.class, new Deserializer());
                }

                public Object m3934a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(PageStoryCardsQueryParser.CouponsParser.m3963a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object couponsModel = new CouponsModel();
                    ((BaseModel) couponsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (couponsModel instanceof Postprocessable) {
                        return ((Postprocessable) couponsModel).a();
                    }
                    return couponsModel;
                }
            }

            @FragmentModelWithBridge
            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 518879773)
            @JsonSerialize(using = Serializer.class)
            /* compiled from: pulsar is null */
            public final class NodesModel extends BaseModel implements GraphQLVisitableConsistentModel {
                @Nullable
                private GraphQLStory f2948d;

                /* compiled from: pulsar is null */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(NodesModel.class, new Deserializer());
                    }

                    public Object m3935a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(PageStoryCardsQueryParser.CouponsParser.NodesParser.m3961b(jsonParser, flatBufferBuilder));
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

                /* compiled from: pulsar is null */
                public class Serializer extends JsonSerializer<NodesModel> {
                    public final void m3936a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        NodesModel nodesModel = (NodesModel) obj;
                        if (nodesModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(nodesModel.m3937a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            nodesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        PageStoryCardsQueryParser.CouponsParser.NodesParser.m3962b(nodesModel.w_(), nodesModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(NodesModel.class, new Serializer());
                    }
                }

                public NodesModel() {
                    super(1);
                }

                public final void m3940a(String str, ConsistencyTuple consistencyTuple) {
                    consistencyTuple.a();
                }

                public final void m3941a(String str, Object obj, boolean z) {
                }

                @Nullable
                public final GraphQLStory m3938a() {
                    this.f2948d = (GraphQLStory) super.a(this.f2948d, 0, GraphQLStory.class);
                    return this.f2948d;
                }

                public final int jK_() {
                    return 2024260678;
                }

                public final GraphQLVisitableModel m3939a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m3938a() != null) {
                        GraphQLStory graphQLStory = (GraphQLStory) graphQLModelMutatingVisitor.b(m3938a());
                        if (m3938a() != graphQLStory) {
                            graphQLVisitableModel = (NodesModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f2948d = graphQLStory;
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m3937a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m3938a());
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, a);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: pulsar is null */
            public class Serializer extends JsonSerializer<CouponsModel> {
                public final void m3942a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    CouponsModel couponsModel = (CouponsModel) obj;
                    if (couponsModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(couponsModel.m3943a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        couponsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    PageStoryCardsQueryParser.CouponsParser.m3964a(couponsModel.w_(), couponsModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(CouponsModel.class, new Serializer());
                }
            }

            public CouponsModel() {
                super(2);
            }

            @Nonnull
            public final ImmutableList<NodesModel> m3945a() {
                this.f2950e = super.a(this.f2950e, 1, NodesModel.class);
                return (ImmutableList) this.f2950e;
            }

            public final int jK_() {
                return -1296688932;
            }

            public final GraphQLVisitableModel m3944a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m3945a() != null) {
                    Builder a = ModelHelper.a(m3945a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (CouponsModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f2950e = a.b();
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m3943a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m3945a());
                flatBufferBuilder.c(2);
                flatBufferBuilder.a(0, this.f2949d, 0);
                flatBufferBuilder.b(1, a);
                i();
                return flatBufferBuilder.d();
            }

            public final void m3946a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f2949d = mutableFlatBuffer.a(i, 0, 0);
            }
        }

        /* compiled from: pulsar is null */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(PageStoryCardsQueryModel.class, new Deserializer());
            }

            public Object m3947a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = PageStoryCardsQueryParser.m3965a(jsonParser);
                Object pageStoryCardsQueryModel = new PageStoryCardsQueryModel();
                ((BaseModel) pageStoryCardsQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (pageStoryCardsQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) pageStoryCardsQueryModel).a();
                }
                return pageStoryCardsQueryModel;
            }
        }

        /* compiled from: pulsar is null */
        public class Serializer extends JsonSerializer<PageStoryCardsQueryModel> {
            public final void m3948a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                PageStoryCardsQueryModel pageStoryCardsQueryModel = (PageStoryCardsQueryModel) obj;
                if (pageStoryCardsQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(pageStoryCardsQueryModel.m3949a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    pageStoryCardsQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = pageStoryCardsQueryModel.w_();
                int u_ = pageStoryCardsQueryModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("coupons");
                    PageStoryCardsQueryParser.CouponsParser.m3964a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(u_, 1);
                if (g != 0) {
                    jsonGenerator.a("timeline_pinned_unit");
                    GraphQLStoryDeserializer.b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(PageStoryCardsQueryModel.class, new Serializer());
            }
        }

        public PageStoryCardsQueryModel() {
            super(2);
        }

        public final void m3952a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m3953a(String str, Object obj, boolean z) {
        }

        @Nullable
        public final CouponsModel m3951a() {
            this.f2951d = (CouponsModel) super.a(this.f2951d, 0, CouponsModel.class);
            return this.f2951d;
        }

        @Nullable
        public final GraphQLStory m3954j() {
            this.f2952e = (GraphQLStory) super.a(this.f2952e, 1, GraphQLStory.class);
            return this.f2952e;
        }

        public final int jK_() {
            return 2479791;
        }

        public final GraphQLVisitableModel m3950a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m3951a() != null) {
                CouponsModel couponsModel = (CouponsModel) graphQLModelMutatingVisitor.b(m3951a());
                if (m3951a() != couponsModel) {
                    graphQLVisitableModel = (PageStoryCardsQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f2951d = couponsModel;
                }
            }
            if (m3954j() != null) {
                GraphQLStory graphQLStory = (GraphQLStory) graphQLModelMutatingVisitor.b(m3954j());
                if (m3954j() != graphQLStory) {
                    graphQLVisitableModel = (PageStoryCardsQueryModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f2952e = graphQLStory;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m3949a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m3951a());
            int a2 = ModelHelper.a(flatBufferBuilder, m3954j());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            i();
            return flatBufferBuilder.d();
        }
    }
}
