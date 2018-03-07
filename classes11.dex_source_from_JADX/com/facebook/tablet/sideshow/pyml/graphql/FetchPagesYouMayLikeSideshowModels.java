package com.facebook.tablet.sideshow.pyml.graphql;

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
import com.facebook.graphql.visitor.ConsistencyTuple;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.tablet.sideshow.pyml.graphql.FetchPagesYouMayLikeSideshowParsers.FetchPagesYouMayLikeSideshowParser;
import com.facebook.tablet.sideshow.pyml.graphql.FetchPagesYouMayLikeSideshowParsers.FetchPagesYouMayLikeSideshowParser.PagesYouMayLikeParser;
import com.facebook.tablet.sideshow.pyml.graphql.FetchPagesYouMayLikeSideshowParsers.FetchPagesYouMayLikeSideshowParser.PagesYouMayLikeParser.NodesParser;
import com.facebook.tablet.sideshow.pyml.graphql.FetchPagesYouMayLikeSideshowParsers.FetchPagesYouMayLikeSideshowParser.PagesYouMayLikeParser.NodesParser.EntityCardSubtitleParser;
import com.facebook.tablet.sideshow.pyml.graphql.FetchPagesYouMayLikeSideshowParsers.FetchPagesYouMayLikeSideshowParser.PagesYouMayLikeParser.NodesParser.PageLikersParser;
import com.facebook.tablet.sideshow.pyml.graphql.FetchPagesYouMayLikeSideshowParsers.FetchPagesYouMayLikeSideshowParser.PagesYouMayLikeParser.NodesParser.ProfilePictureParser;
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

/* compiled from: on will retry */
public class FetchPagesYouMayLikeSideshowModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -2004723950)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: on will retry */
    public final class FetchPagesYouMayLikeSideshowModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private PagesYouMayLikeModel f4834d;

        /* compiled from: on will retry */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FetchPagesYouMayLikeSideshowModel.class, new Deserializer());
            }

            public Object m5999a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = FetchPagesYouMayLikeSideshowParser.m6052a(jsonParser);
                Object fetchPagesYouMayLikeSideshowModel = new FetchPagesYouMayLikeSideshowModel();
                ((BaseModel) fetchPagesYouMayLikeSideshowModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (fetchPagesYouMayLikeSideshowModel instanceof Postprocessable) {
                    return ((Postprocessable) fetchPagesYouMayLikeSideshowModel).a();
                }
                return fetchPagesYouMayLikeSideshowModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 685476481)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: on will retry */
        public final class PagesYouMayLikeModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<NodesModel> f4833d;

            /* compiled from: on will retry */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(PagesYouMayLikeModel.class, new Deserializer());
                }

                public Object m6000a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(PagesYouMayLikeParser.m6050a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object pagesYouMayLikeModel = new PagesYouMayLikeModel();
                    ((BaseModel) pagesYouMayLikeModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (pagesYouMayLikeModel instanceof Postprocessable) {
                        return ((Postprocessable) pagesYouMayLikeModel).a();
                    }
                    return pagesYouMayLikeModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 57822237)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: on will retry */
            public final class NodesModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
                private boolean f4825d;
                @Nullable
                private String f4826e;
                private boolean f4827f;
                @Nullable
                private EntityCardSubtitleModel f4828g;
                @Nullable
                private String f4829h;
                @Nullable
                private String f4830i;
                @Nullable
                private PageLikersModel f4831j;
                @Nullable
                private ProfilePictureModel f4832k;

                /* compiled from: on will retry */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(NodesModel.class, new Deserializer());
                    }

                    public Object m6001a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(NodesParser.m6048b(jsonParser, flatBufferBuilder));
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

                @JsonDeserialize(using = Deserializer.class)
                @ModelWithFlatBufferFormatHash(a = -1352864475)
                @JsonSerialize(using = Serializer.class)
                @FragmentModelWithoutBridge
                /* compiled from: on will retry */
                public final class EntityCardSubtitleModel extends BaseModel implements GraphQLVisitableModel {
                    @Nullable
                    private String f4822d;

                    /* compiled from: on will retry */
                    public class Deserializer extends FbJsonDeserializer {
                        static {
                            GlobalAutoGenDeserializerCache.a(EntityCardSubtitleModel.class, new Deserializer());
                        }

                        public Object m6002a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(EntityCardSubtitleParser.m6042a(jsonParser, flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            mutableFlatBuffer.a(4, Boolean.valueOf(true));
                            MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                            Object entityCardSubtitleModel = new EntityCardSubtitleModel();
                            ((BaseModel) entityCardSubtitleModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                            if (entityCardSubtitleModel instanceof Postprocessable) {
                                return ((Postprocessable) entityCardSubtitleModel).a();
                            }
                            return entityCardSubtitleModel;
                        }
                    }

                    /* compiled from: on will retry */
                    public class Serializer extends JsonSerializer<EntityCardSubtitleModel> {
                        public final void m6003a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            EntityCardSubtitleModel entityCardSubtitleModel = (EntityCardSubtitleModel) obj;
                            if (entityCardSubtitleModel.w_() == null) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(entityCardSubtitleModel.m6004a(flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                entityCardSubtitleModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                            }
                            EntityCardSubtitleParser.m6043a(entityCardSubtitleModel.w_(), entityCardSubtitleModel.u_(), jsonGenerator);
                        }

                        static {
                            FbSerializerProvider.a(EntityCardSubtitleModel.class, new Serializer());
                        }
                    }

                    public EntityCardSubtitleModel() {
                        super(1);
                    }

                    @Nullable
                    public final String m6006a() {
                        this.f4822d = super.a(this.f4822d, 0);
                        return this.f4822d;
                    }

                    public final int jK_() {
                        return -1919764332;
                    }

                    public final GraphQLVisitableModel m6005a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                        h();
                        i();
                        return this;
                    }

                    public final int m6004a(FlatBufferBuilder flatBufferBuilder) {
                        h();
                        int b = flatBufferBuilder.b(m6006a());
                        flatBufferBuilder.c(1);
                        flatBufferBuilder.b(0, b);
                        i();
                        return flatBufferBuilder.d();
                    }
                }

                @JsonDeserialize(using = Deserializer.class)
                @ModelWithFlatBufferFormatHash(a = -1723990064)
                @JsonSerialize(using = Serializer.class)
                @FragmentModelWithoutBridge
                /* compiled from: on will retry */
                public final class PageLikersModel extends BaseModel implements GraphQLVisitableModel {
                    private int f4823d;

                    /* compiled from: on will retry */
                    public class Deserializer extends FbJsonDeserializer {
                        static {
                            GlobalAutoGenDeserializerCache.a(PageLikersModel.class, new Deserializer());
                        }

                        public Object m6007a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(PageLikersParser.m6044a(jsonParser, flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            mutableFlatBuffer.a(4, Boolean.valueOf(true));
                            MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                            Object pageLikersModel = new PageLikersModel();
                            ((BaseModel) pageLikersModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                            if (pageLikersModel instanceof Postprocessable) {
                                return ((Postprocessable) pageLikersModel).a();
                            }
                            return pageLikersModel;
                        }
                    }

                    /* compiled from: on will retry */
                    public class Serializer extends JsonSerializer<PageLikersModel> {
                        public final void m6008a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            PageLikersModel pageLikersModel = (PageLikersModel) obj;
                            if (pageLikersModel.w_() == null) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(pageLikersModel.m6010a(flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                pageLikersModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                            }
                            PageLikersParser.m6045a(pageLikersModel.w_(), pageLikersModel.u_(), jsonGenerator);
                        }

                        static {
                            FbSerializerProvider.a(PageLikersModel.class, new Serializer());
                        }
                    }

                    public PageLikersModel() {
                        super(1);
                    }

                    public final int m6009a() {
                        a(0, 0);
                        return this.f4823d;
                    }

                    public final int jK_() {
                        return 637021669;
                    }

                    public final GraphQLVisitableModel m6011a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                        h();
                        i();
                        return this;
                    }

                    public final int m6010a(FlatBufferBuilder flatBufferBuilder) {
                        h();
                        flatBufferBuilder.c(1);
                        flatBufferBuilder.a(0, this.f4823d, 0);
                        i();
                        return flatBufferBuilder.d();
                    }

                    public final void m6012a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                        super.a(mutableFlatBuffer, i, obj);
                        this.f4823d = mutableFlatBuffer.a(i, 0, 0);
                    }
                }

                @JsonDeserialize(using = Deserializer.class)
                @ModelWithFlatBufferFormatHash(a = 842551240)
                @JsonSerialize(using = Serializer.class)
                @FragmentModelWithoutBridge
                /* compiled from: on will retry */
                public final class ProfilePictureModel extends BaseModel implements GraphQLVisitableModel {
                    @Nullable
                    private String f4824d;

                    /* compiled from: on will retry */
                    public class Deserializer extends FbJsonDeserializer {
                        static {
                            GlobalAutoGenDeserializerCache.a(ProfilePictureModel.class, new Deserializer());
                        }

                        public Object m6013a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(ProfilePictureParser.m6046a(jsonParser, flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            mutableFlatBuffer.a(4, Boolean.valueOf(true));
                            MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                            Object profilePictureModel = new ProfilePictureModel();
                            ((BaseModel) profilePictureModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                            if (profilePictureModel instanceof Postprocessable) {
                                return ((Postprocessable) profilePictureModel).a();
                            }
                            return profilePictureModel;
                        }
                    }

                    /* compiled from: on will retry */
                    public class Serializer extends JsonSerializer<ProfilePictureModel> {
                        public final void m6014a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            ProfilePictureModel profilePictureModel = (ProfilePictureModel) obj;
                            if (profilePictureModel.w_() == null) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(profilePictureModel.m6015a(flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                profilePictureModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                            }
                            ProfilePictureParser.m6047a(profilePictureModel.w_(), profilePictureModel.u_(), jsonGenerator);
                        }

                        static {
                            FbSerializerProvider.a(ProfilePictureModel.class, new Serializer());
                        }
                    }

                    public ProfilePictureModel() {
                        super(1);
                    }

                    @Nullable
                    public final String m6017a() {
                        this.f4824d = super.a(this.f4824d, 0);
                        return this.f4824d;
                    }

                    public final int jK_() {
                        return 70760763;
                    }

                    public final GraphQLVisitableModel m6016a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                        h();
                        i();
                        return this;
                    }

                    public final int m6015a(FlatBufferBuilder flatBufferBuilder) {
                        h();
                        int b = flatBufferBuilder.b(m6017a());
                        flatBufferBuilder.c(1);
                        flatBufferBuilder.b(0, b);
                        i();
                        return flatBufferBuilder.d();
                    }
                }

                /* compiled from: on will retry */
                public class Serializer extends JsonSerializer<NodesModel> {
                    public final void m6018a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        NodesModel nodesModel = (NodesModel) obj;
                        if (nodesModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(nodesModel.m6020a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            nodesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        NodesParser.m6049b(nodesModel.w_(), nodesModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(NodesModel.class, new Serializer());
                    }
                }

                public NodesModel() {
                    super(8);
                }

                public final void m6024a(String str, ConsistencyTuple consistencyTuple) {
                    if ("does_viewer_like".equals(str)) {
                        consistencyTuple.a = Boolean.valueOf(m6028l());
                        consistencyTuple.b = u_();
                        consistencyTuple.c = 2;
                        return;
                    }
                    consistencyTuple.a();
                }

                public final void m6025a(String str, Object obj, boolean z) {
                    if ("does_viewer_like".equals(str)) {
                        m6019a(((Boolean) obj).booleanValue());
                    }
                }

                public final boolean m6026j() {
                    a(0, 0);
                    return this.f4825d;
                }

                @Nullable
                public final String m6027k() {
                    this.f4826e = super.a(this.f4826e, 1);
                    return this.f4826e;
                }

                public final boolean m6028l() {
                    a(0, 2);
                    return this.f4827f;
                }

                private void m6019a(boolean z) {
                    this.f4827f = z;
                    if (this.b != null && this.b.d) {
                        this.b.a(this.c, 2, z);
                    }
                }

                @Nullable
                public final EntityCardSubtitleModel m6029m() {
                    this.f4828g = (EntityCardSubtitleModel) super.a(this.f4828g, 3, EntityCardSubtitleModel.class);
                    return this.f4828g;
                }

                @Nullable
                public final String m6030n() {
                    this.f4829h = super.a(this.f4829h, 4);
                    return this.f4829h;
                }

                @Nullable
                public final String m6031o() {
                    this.f4830i = super.a(this.f4830i, 5);
                    return this.f4830i;
                }

                @Nullable
                public final PageLikersModel m6032p() {
                    this.f4831j = (PageLikersModel) super.a(this.f4831j, 6, PageLikersModel.class);
                    return this.f4831j;
                }

                @Nullable
                public final ProfilePictureModel m6033q() {
                    this.f4832k = (ProfilePictureModel) super.a(this.f4832k, 7, ProfilePictureModel.class);
                    return this.f4832k;
                }

                @Nullable
                public final String m6022a() {
                    return m6030n();
                }

                public final int jK_() {
                    return 2479791;
                }

                public final GraphQLVisitableModel m6021a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m6029m() != null) {
                        EntityCardSubtitleModel entityCardSubtitleModel = (EntityCardSubtitleModel) graphQLModelMutatingVisitor.b(m6029m());
                        if (m6029m() != entityCardSubtitleModel) {
                            graphQLVisitableModel = (NodesModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f4828g = entityCardSubtitleModel;
                        }
                    }
                    if (m6032p() != null) {
                        PageLikersModel pageLikersModel = (PageLikersModel) graphQLModelMutatingVisitor.b(m6032p());
                        if (m6032p() != pageLikersModel) {
                            graphQLVisitableModel = (NodesModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f4831j = pageLikersModel;
                        }
                    }
                    if (m6033q() != null) {
                        ProfilePictureModel profilePictureModel = (ProfilePictureModel) graphQLModelMutatingVisitor.b(m6033q());
                        if (m6033q() != profilePictureModel) {
                            graphQLVisitableModel = (NodesModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f4832k = profilePictureModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m6020a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int b = flatBufferBuilder.b(m6027k());
                    int a = ModelHelper.a(flatBufferBuilder, m6029m());
                    int b2 = flatBufferBuilder.b(m6030n());
                    int b3 = flatBufferBuilder.b(m6031o());
                    int a2 = ModelHelper.a(flatBufferBuilder, m6032p());
                    int a3 = ModelHelper.a(flatBufferBuilder, m6033q());
                    flatBufferBuilder.c(8);
                    flatBufferBuilder.a(0, this.f4825d);
                    flatBufferBuilder.b(1, b);
                    flatBufferBuilder.a(2, this.f4827f);
                    flatBufferBuilder.b(3, a);
                    flatBufferBuilder.b(4, b2);
                    flatBufferBuilder.b(5, b3);
                    flatBufferBuilder.b(6, a2);
                    flatBufferBuilder.b(7, a3);
                    i();
                    return flatBufferBuilder.d();
                }

                public final void m6023a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                    super.a(mutableFlatBuffer, i, obj);
                    this.f4825d = mutableFlatBuffer.a(i, 0);
                    this.f4827f = mutableFlatBuffer.a(i, 2);
                }
            }

            /* compiled from: on will retry */
            public class Serializer extends JsonSerializer<PagesYouMayLikeModel> {
                public final void m6034a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    PagesYouMayLikeModel pagesYouMayLikeModel = (PagesYouMayLikeModel) obj;
                    if (pagesYouMayLikeModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(pagesYouMayLikeModel.m6035a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        pagesYouMayLikeModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    PagesYouMayLikeParser.m6051a(pagesYouMayLikeModel.w_(), pagesYouMayLikeModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(PagesYouMayLikeModel.class, new Serializer());
                }
            }

            public PagesYouMayLikeModel() {
                super(1);
            }

            @Nonnull
            public final ImmutableList<NodesModel> m6037a() {
                this.f4833d = super.a(this.f4833d, 0, NodesModel.class);
                return (ImmutableList) this.f4833d;
            }

            public final int jK_() {
                return 1067818495;
            }

            public final GraphQLVisitableModel m6036a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m6037a() != null) {
                    Builder a = ModelHelper.a(m6037a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (PagesYouMayLikeModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f4833d = a.b();
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m6035a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m6037a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: on will retry */
        public class Serializer extends JsonSerializer<FetchPagesYouMayLikeSideshowModel> {
            public final void m6038a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                FetchPagesYouMayLikeSideshowModel fetchPagesYouMayLikeSideshowModel = (FetchPagesYouMayLikeSideshowModel) obj;
                if (fetchPagesYouMayLikeSideshowModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(fetchPagesYouMayLikeSideshowModel.m6039a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    fetchPagesYouMayLikeSideshowModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = fetchPagesYouMayLikeSideshowModel.w_();
                int u_ = fetchPagesYouMayLikeSideshowModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("pages_you_may_like");
                    PagesYouMayLikeParser.m6051a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(FetchPagesYouMayLikeSideshowModel.class, new Serializer());
            }
        }

        public FetchPagesYouMayLikeSideshowModel() {
            super(1);
        }

        @Nullable
        public final PagesYouMayLikeModel m6041a() {
            this.f4834d = (PagesYouMayLikeModel) super.a(this.f4834d, 0, PagesYouMayLikeModel.class);
            return this.f4834d;
        }

        public final int jK_() {
            return -1732764110;
        }

        public final GraphQLVisitableModel m6040a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m6041a() != null) {
                PagesYouMayLikeModel pagesYouMayLikeModel = (PagesYouMayLikeModel) graphQLModelMutatingVisitor.b(m6041a());
                if (m6041a() != pagesYouMayLikeModel) {
                    graphQLVisitableModel = (FetchPagesYouMayLikeSideshowModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f4834d = pagesYouMayLikeModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m6039a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m6041a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }
}
