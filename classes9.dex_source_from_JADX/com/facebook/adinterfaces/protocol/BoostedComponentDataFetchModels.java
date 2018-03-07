package com.facebook.adinterfaces.protocol;

import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.AdCoverPhotoModel;
import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.AdminInfoModel;
import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BoostedComponentModel;
import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.PageBaseFieldsModel.AboutModel;
import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.PhoneNumberModel;
import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.PromoteProductInfoModel;
import com.facebook.adinterfaces.protocol.BoostedComponentDataFetchParsers.BoostedComponentDataQueryParser;
import com.facebook.adinterfaces.protocol.BoostedComponentDataFetchParsers.BoostedComponentDataQueryParser.AllPhonesParser;
import com.facebook.adinterfaces.protocol.BoostedComponentDataFetchParsers.BoostedComponentDataQueryParser.PageCallToActionParser;
import com.facebook.adinterfaces.protocol.BoostedComponentDataFetchParsers.BoostedComponentDataQueryParser.TimelineStoriesParser;
import com.facebook.adinterfaces.protocol.BoostedComponentDataFetchParsers.BoostedComponentDataQueryParser.TimelineStoriesParser.NodesParser;
import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithBridge;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLCallToActionType;
import com.facebook.graphql.enums.GraphQLPageCallToActionType;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.querybuilder.common.CommonGraphQLModels.DefaultAddressFieldsModel;
import com.facebook.graphql.querybuilder.common.CommonGraphQLModels.DefaultImageFieldsModel;
import com.facebook.graphql.querybuilder.common.CommonGraphQLModels.DefaultLocationFieldsModel;
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

/* compiled from: X-MSGR-Region */
public class BoostedComponentDataFetchModels {

    @FragmentModelWithBridge
    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1129150927)
    @JsonSerialize(using = Serializer.class)
    /* compiled from: X-MSGR-Region */
    public final class BoostedComponentDataQueryModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
        @Nullable
        private AboutModel f22288d;
        @Nullable
        private DefaultAddressFieldsModel f22289e;
        @Nullable
        private AdminInfoModel f22290f;
        @Nullable
        private List<AllPhonesModel> f22291g;
        @Nullable
        private PromoteProductInfoModel f22292h;
        @Nullable
        private AdCoverPhotoModel f22293i;
        @Nullable
        private String f22294j;
        @Nullable
        private DefaultLocationFieldsModel f22295k;
        @Nullable
        private String f22296l;
        @Nullable
        private PageCallToActionModel f22297m;
        @Nullable
        private DefaultImageFieldsModel f22298n;
        @Nullable
        private DefaultImageFieldsModel f22299o;
        @Nullable
        private TimelineStoriesModel f22300p;
        @Nullable
        private String f22301q;
        @Nullable
        private List<String> f22302r;

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1955049599)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: X-MSGR-Region */
        public final class AllPhonesModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private PhoneNumberModel f22280d;

            /* compiled from: X-MSGR-Region */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(AllPhonesModel.class, new Deserializer());
                }

                public Object m23974a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(AllPhonesParser.m24023b(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object allPhonesModel = new AllPhonesModel();
                    ((BaseModel) allPhonesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (allPhonesModel instanceof Postprocessable) {
                        return ((Postprocessable) allPhonesModel).a();
                    }
                    return allPhonesModel;
                }
            }

            /* compiled from: X-MSGR-Region */
            public class Serializer extends JsonSerializer<AllPhonesModel> {
                public final void m23975a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    AllPhonesModel allPhonesModel = (AllPhonesModel) obj;
                    if (allPhonesModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(allPhonesModel.m23976a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        allPhonesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    AllPhonesParser.m24024b(allPhonesModel.w_(), allPhonesModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(AllPhonesModel.class, new Serializer());
                }
            }

            public AllPhonesModel() {
                super(1);
            }

            @Nullable
            public final PhoneNumberModel m23977a() {
                this.f22280d = (PhoneNumberModel) super.a(this.f22280d, 0, PhoneNumberModel.class);
                return this.f22280d;
            }

            public final int jK_() {
                return 77090126;
            }

            public final GraphQLVisitableModel m23978a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m23977a() != null) {
                    PhoneNumberModel phoneNumberModel = (PhoneNumberModel) graphQLModelMutatingVisitor.b(m23977a());
                    if (m23977a() != phoneNumberModel) {
                        graphQLVisitableModel = (AllPhonesModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f22280d = phoneNumberModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m23976a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m23977a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: X-MSGR-Region */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(BoostedComponentDataQueryModel.class, new Deserializer());
            }

            public Object m23979a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(BoostedComponentDataQueryParser.m24031a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object boostedComponentDataQueryModel = new BoostedComponentDataQueryModel();
                ((BaseModel) boostedComponentDataQueryModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (boostedComponentDataQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) boostedComponentDataQueryModel).a();
                }
                return boostedComponentDataQueryModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1229560591)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: X-MSGR-Region */
        public final class PageCallToActionModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private GraphQLCallToActionType f22281d;
            @Nullable
            private GraphQLPageCallToActionType f22282e;
            @Nullable
            private String f22283f;
            @Nullable
            private String f22284g;

            /* compiled from: X-MSGR-Region */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(PageCallToActionModel.class, new Deserializer());
                }

                public Object m23980a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(PageCallToActionParser.m24025a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object pageCallToActionModel = new PageCallToActionModel();
                    ((BaseModel) pageCallToActionModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (pageCallToActionModel instanceof Postprocessable) {
                        return ((Postprocessable) pageCallToActionModel).a();
                    }
                    return pageCallToActionModel;
                }
            }

            /* compiled from: X-MSGR-Region */
            public class Serializer extends JsonSerializer<PageCallToActionModel> {
                public final void m23981a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    PageCallToActionModel pageCallToActionModel = (PageCallToActionModel) obj;
                    if (pageCallToActionModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(pageCallToActionModel.m23984a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        pageCallToActionModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    PageCallToActionParser.m24026a(pageCallToActionModel.w_(), pageCallToActionModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(PageCallToActionModel.class, new Serializer());
                }
            }

            public PageCallToActionModel() {
                super(4);
            }

            @Nullable
            public final GraphQLCallToActionType m23985a() {
                this.f22281d = (GraphQLCallToActionType) super.b(this.f22281d, 0, GraphQLCallToActionType.class, GraphQLCallToActionType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                return this.f22281d;
            }

            @Nullable
            private GraphQLPageCallToActionType m23982k() {
                this.f22282e = (GraphQLPageCallToActionType) super.b(this.f22282e, 1, GraphQLPageCallToActionType.class, GraphQLPageCallToActionType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                return this.f22282e;
            }

            @Nullable
            public final String m23987j() {
                this.f22283f = super.a(this.f22283f, 2);
                return this.f22283f;
            }

            @Nullable
            private String m23983l() {
                this.f22284g = super.a(this.f22284g, 3);
                return this.f22284g;
            }

            public final int jK_() {
                return 133279070;
            }

            public final GraphQLVisitableModel m23986a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m23984a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = flatBufferBuilder.a(m23985a());
                int a2 = flatBufferBuilder.a(m23982k());
                int b = flatBufferBuilder.b(m23987j());
                int b2 = flatBufferBuilder.b(m23983l());
                flatBufferBuilder.c(4);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, a2);
                flatBufferBuilder.b(2, b);
                flatBufferBuilder.b(3, b2);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: X-MSGR-Region */
        public class Serializer extends JsonSerializer<BoostedComponentDataQueryModel> {
            public final void m23988a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                BoostedComponentDataQueryModel boostedComponentDataQueryModel = (BoostedComponentDataQueryModel) obj;
                if (boostedComponentDataQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(boostedComponentDataQueryModel.m24003a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    boostedComponentDataQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                BoostedComponentDataQueryParser.m24032a(boostedComponentDataQueryModel.w_(), boostedComponentDataQueryModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(BoostedComponentDataQueryModel.class, new Serializer());
            }
        }

        @FragmentModelWithBridge
        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -274778454)
        @JsonSerialize(using = Serializer.class)
        /* compiled from: X-MSGR-Region */
        public final class TimelineStoriesModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<NodesModel> f22287d;

            /* compiled from: X-MSGR-Region */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(TimelineStoriesModel.class, new Deserializer());
                }

                public Object m23989a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(TimelineStoriesParser.m24029a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object timelineStoriesModel = new TimelineStoriesModel();
                    ((BaseModel) timelineStoriesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (timelineStoriesModel instanceof Postprocessable) {
                        return ((Postprocessable) timelineStoriesModel).a();
                    }
                    return timelineStoriesModel;
                }
            }

            @FragmentModelWithBridge
            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 158768377)
            @JsonSerialize(using = Serializer.class)
            /* compiled from: X-MSGR-Region */
            public final class NodesModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
                @Nullable
                private String f22285d;
                @Nullable
                private BoostedComponentModel f22286e;

                /* compiled from: X-MSGR-Region */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(NodesModel.class, new Deserializer());
                    }

                    public Object m23990a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(NodesParser.m24027b(jsonParser, flatBufferBuilder));
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

                /* compiled from: X-MSGR-Region */
                public class Serializer extends JsonSerializer<NodesModel> {
                    public final void m23991a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        NodesModel nodesModel = (NodesModel) obj;
                        if (nodesModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(nodesModel.m23992a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            nodesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        NodesParser.m24028b(nodesModel.w_(), nodesModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(NodesModel.class, new Serializer());
                    }
                }

                public NodesModel() {
                    super(2);
                }

                public final void m23995a(String str, ConsistencyTuple consistencyTuple) {
                    consistencyTuple.a();
                }

                public final void m23996a(String str, Object obj, boolean z) {
                }

                @Nullable
                public final String m23997j() {
                    this.f22285d = super.a(this.f22285d, 0);
                    return this.f22285d;
                }

                @Nullable
                public final BoostedComponentModel m23998k() {
                    this.f22286e = (BoostedComponentModel) super.a(this.f22286e, 1, BoostedComponentModel.class);
                    return this.f22286e;
                }

                @Nullable
                public final String m23994a() {
                    return m23997j();
                }

                public final int jK_() {
                    return 80218325;
                }

                public final GraphQLVisitableModel m23993a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m23998k() != null) {
                        BoostedComponentModel boostedComponentModel = (BoostedComponentModel) graphQLModelMutatingVisitor.b(m23998k());
                        if (m23998k() != boostedComponentModel) {
                            graphQLVisitableModel = (NodesModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f22286e = boostedComponentModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m23992a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int b = flatBufferBuilder.b(m23997j());
                    int a = ModelHelper.a(flatBufferBuilder, m23998k());
                    flatBufferBuilder.c(2);
                    flatBufferBuilder.b(0, b);
                    flatBufferBuilder.b(1, a);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: X-MSGR-Region */
            public class Serializer extends JsonSerializer<TimelineStoriesModel> {
                public final void m23999a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    TimelineStoriesModel timelineStoriesModel = (TimelineStoriesModel) obj;
                    if (timelineStoriesModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(timelineStoriesModel.m24000a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        timelineStoriesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    TimelineStoriesParser.m24030a(timelineStoriesModel.w_(), timelineStoriesModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(TimelineStoriesModel.class, new Serializer());
                }
            }

            public TimelineStoriesModel() {
                super(1);
            }

            @Nonnull
            public final ImmutableList<NodesModel> m24002a() {
                this.f22287d = super.a(this.f22287d, 0, NodesModel.class);
                return (ImmutableList) this.f22287d;
            }

            public final int jK_() {
                return -1790745296;
            }

            public final GraphQLVisitableModel m24001a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m24002a() != null) {
                    Builder a = ModelHelper.a(m24002a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (TimelineStoriesModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f22287d = a.b();
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m24000a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m24002a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        public BoostedComponentDataQueryModel() {
            super(15);
        }

        public final void m24006a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m24007a(String str, Object obj, boolean z) {
        }

        @Nullable
        public final AboutModel m24008j() {
            this.f22288d = (AboutModel) super.a(this.f22288d, 0, AboutModel.class);
            return this.f22288d;
        }

        @Nullable
        public final DefaultAddressFieldsModel m24009k() {
            this.f22289e = (DefaultAddressFieldsModel) super.a(this.f22289e, 1, DefaultAddressFieldsModel.class);
            return this.f22289e;
        }

        @Nullable
        public final AdminInfoModel m24010l() {
            this.f22290f = (AdminInfoModel) super.a(this.f22290f, 2, AdminInfoModel.class);
            return this.f22290f;
        }

        @Nonnull
        public final ImmutableList<AllPhonesModel> m24011m() {
            this.f22291g = super.a(this.f22291g, 3, AllPhonesModel.class);
            return (ImmutableList) this.f22291g;
        }

        @Nullable
        public final PromoteProductInfoModel m24012n() {
            this.f22292h = (PromoteProductInfoModel) super.a(this.f22292h, 4, PromoteProductInfoModel.class);
            return this.f22292h;
        }

        @Nullable
        public final AdCoverPhotoModel m24013o() {
            this.f22293i = (AdCoverPhotoModel) super.a(this.f22293i, 5, AdCoverPhotoModel.class);
            return this.f22293i;
        }

        @Nullable
        public final String m24014p() {
            this.f22294j = super.a(this.f22294j, 6);
            return this.f22294j;
        }

        @Nullable
        public final DefaultLocationFieldsModel m24015q() {
            this.f22295k = (DefaultLocationFieldsModel) super.a(this.f22295k, 7, DefaultLocationFieldsModel.class);
            return this.f22295k;
        }

        @Nullable
        public final String m24016r() {
            this.f22296l = super.a(this.f22296l, 8);
            return this.f22296l;
        }

        @Nullable
        public final PageCallToActionModel m24017s() {
            this.f22297m = (PageCallToActionModel) super.a(this.f22297m, 9, PageCallToActionModel.class);
            return this.f22297m;
        }

        @Nullable
        public final DefaultImageFieldsModel m24018t() {
            this.f22298n = (DefaultImageFieldsModel) super.a(this.f22298n, 10, DefaultImageFieldsModel.class);
            return this.f22298n;
        }

        @Nullable
        public final DefaultImageFieldsModel m24019u() {
            this.f22299o = (DefaultImageFieldsModel) super.a(this.f22299o, 11, DefaultImageFieldsModel.class);
            return this.f22299o;
        }

        @Nullable
        public final TimelineStoriesModel m24020v() {
            this.f22300p = (TimelineStoriesModel) super.a(this.f22300p, 12, TimelineStoriesModel.class);
            return this.f22300p;
        }

        @Nullable
        public final String m24021w() {
            this.f22301q = super.a(this.f22301q, 13);
            return this.f22301q;
        }

        @Nonnull
        public final ImmutableList<String> m24022x() {
            this.f22302r = super.a(this.f22302r, 14);
            return (ImmutableList) this.f22302r;
        }

        @Nullable
        public final String m24005a() {
            return m24014p();
        }

        public final int jK_() {
            return 2479791;
        }

        public final GraphQLVisitableModel m24004a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            DefaultImageFieldsModel defaultImageFieldsModel;
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m24008j() != null) {
                AboutModel aboutModel = (AboutModel) graphQLModelMutatingVisitor.b(m24008j());
                if (m24008j() != aboutModel) {
                    graphQLVisitableModel = (BoostedComponentDataQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f22288d = aboutModel;
                }
            }
            if (m24009k() != null) {
                DefaultAddressFieldsModel defaultAddressFieldsModel = (DefaultAddressFieldsModel) graphQLModelMutatingVisitor.b(m24009k());
                if (m24009k() != defaultAddressFieldsModel) {
                    graphQLVisitableModel = (BoostedComponentDataQueryModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f22289e = defaultAddressFieldsModel;
                }
            }
            if (m24010l() != null) {
                AdminInfoModel adminInfoModel = (AdminInfoModel) graphQLModelMutatingVisitor.b(m24010l());
                if (m24010l() != adminInfoModel) {
                    graphQLVisitableModel = (BoostedComponentDataQueryModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f22290f = adminInfoModel;
                }
            }
            if (m24011m() != null) {
                Builder a = ModelHelper.a(m24011m(), graphQLModelMutatingVisitor);
                if (a != null) {
                    BoostedComponentDataQueryModel boostedComponentDataQueryModel = (BoostedComponentDataQueryModel) ModelHelper.a(graphQLVisitableModel, this);
                    boostedComponentDataQueryModel.f22291g = a.b();
                    graphQLVisitableModel = boostedComponentDataQueryModel;
                }
            }
            if (m24012n() != null) {
                PromoteProductInfoModel promoteProductInfoModel = (PromoteProductInfoModel) graphQLModelMutatingVisitor.b(m24012n());
                if (m24012n() != promoteProductInfoModel) {
                    graphQLVisitableModel = (BoostedComponentDataQueryModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f22292h = promoteProductInfoModel;
                }
            }
            if (m24013o() != null) {
                AdCoverPhotoModel adCoverPhotoModel = (AdCoverPhotoModel) graphQLModelMutatingVisitor.b(m24013o());
                if (m24013o() != adCoverPhotoModel) {
                    graphQLVisitableModel = (BoostedComponentDataQueryModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f22293i = adCoverPhotoModel;
                }
            }
            if (m24015q() != null) {
                DefaultLocationFieldsModel defaultLocationFieldsModel = (DefaultLocationFieldsModel) graphQLModelMutatingVisitor.b(m24015q());
                if (m24015q() != defaultLocationFieldsModel) {
                    graphQLVisitableModel = (BoostedComponentDataQueryModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f22295k = defaultLocationFieldsModel;
                }
            }
            if (m24017s() != null) {
                PageCallToActionModel pageCallToActionModel = (PageCallToActionModel) graphQLModelMutatingVisitor.b(m24017s());
                if (m24017s() != pageCallToActionModel) {
                    graphQLVisitableModel = (BoostedComponentDataQueryModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f22297m = pageCallToActionModel;
                }
            }
            if (m24018t() != null) {
                defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m24018t());
                if (m24018t() != defaultImageFieldsModel) {
                    graphQLVisitableModel = (BoostedComponentDataQueryModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f22298n = defaultImageFieldsModel;
                }
            }
            if (m24019u() != null) {
                defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m24019u());
                if (m24019u() != defaultImageFieldsModel) {
                    graphQLVisitableModel = (BoostedComponentDataQueryModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f22299o = defaultImageFieldsModel;
                }
            }
            if (m24020v() != null) {
                TimelineStoriesModel timelineStoriesModel = (TimelineStoriesModel) graphQLModelMutatingVisitor.b(m24020v());
                if (m24020v() != timelineStoriesModel) {
                    graphQLVisitableModel = (BoostedComponentDataQueryModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f22300p = timelineStoriesModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m24003a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m24008j());
            int a2 = ModelHelper.a(flatBufferBuilder, m24009k());
            int a3 = ModelHelper.a(flatBufferBuilder, m24010l());
            int a4 = ModelHelper.a(flatBufferBuilder, m24011m());
            int a5 = ModelHelper.a(flatBufferBuilder, m24012n());
            int a6 = ModelHelper.a(flatBufferBuilder, m24013o());
            int b = flatBufferBuilder.b(m24014p());
            int a7 = ModelHelper.a(flatBufferBuilder, m24015q());
            int b2 = flatBufferBuilder.b(m24016r());
            int a8 = ModelHelper.a(flatBufferBuilder, m24017s());
            int a9 = ModelHelper.a(flatBufferBuilder, m24018t());
            int a10 = ModelHelper.a(flatBufferBuilder, m24019u());
            int a11 = ModelHelper.a(flatBufferBuilder, m24020v());
            int b3 = flatBufferBuilder.b(m24021w());
            int c = flatBufferBuilder.c(m24022x());
            flatBufferBuilder.c(15);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            flatBufferBuilder.b(2, a3);
            flatBufferBuilder.b(3, a4);
            flatBufferBuilder.b(4, a5);
            flatBufferBuilder.b(5, a6);
            flatBufferBuilder.b(6, b);
            flatBufferBuilder.b(7, a7);
            flatBufferBuilder.b(8, b2);
            flatBufferBuilder.b(9, a8);
            flatBufferBuilder.b(10, a9);
            flatBufferBuilder.b(11, a10);
            flatBufferBuilder.b(12, a11);
            flatBufferBuilder.b(13, b3);
            flatBufferBuilder.b(14, c);
            i();
            return flatBufferBuilder.d();
        }
    }
}
