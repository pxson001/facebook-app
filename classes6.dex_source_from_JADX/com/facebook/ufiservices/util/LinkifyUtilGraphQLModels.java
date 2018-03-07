package com.facebook.ufiservices.util;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.directinstall.util.C0589xd643bf8b;
import com.facebook.directinstall.util.DirectInstallApplicationUtilsGraphQLModels.GetNativeAppDetailsAppStoreApplicationGraphQLModel;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.linkutil.GraphQLLinkExtractorGraphQLInterfaces.GetEntityFbLinkGraphQL.Page;
import com.facebook.graphql.linkutil.GraphQLLinkExtractorGraphQLModels.GetRedirectionLinkGraphQLModel.RedirectionInfoModel;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.modelutil.SerializerHelpers;
import com.facebook.graphql.visitor.ConsistencyTuple;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.linkify.LinkifyTargetGraphQLInterfaces.LinkifyTargetGraphQL.ProfilePicture;
import com.facebook.ufiservices.util.LinkifyUtilGraphQLInterfaces.LinkableUtilApplyActorsLinksGraphQL;
import com.facebook.ufiservices.util.LinkifyUtilGraphQLInterfaces.LinkableUtilApplyActorsLinksGraphQL.Ranges;
import com.facebook.ufiservices.util.LinkifyUtilGraphQLInterfaces.LinkableUtilApplyActorsLinksGraphQL.Ranges.Entity;
import com.facebook.ufiservices.util.LinkifyUtilGraphQLInterfaces.LinkableUtilApplyClickableLinkSpanWithEntityGraphQL;
import com.facebook.ufiservices.util.LinkifyUtilGraphQLInterfaces.LinkableUtilApplyFamilyNonUserMemberLinkGraphQL;
import com.facebook.ufiservices.util.LinkifyUtilGraphQLInterfaces.LinkableUtilApplyHashtagLinkGraphQL;
import com.facebook.ufiservices.util.LinkifyUtilGraphQLInterfaces.LinkableUtilShouldFormatAsExternalLinkGraphQL;
import com.facebook.ufiservices.util.LinkifyUtilGraphQLInterfaces.StoryHeaderSectionOnClickGraphQL;
import com.facebook.ufiservices.util.LinkifyUtilGraphQLParsers.LinkableUtilAddLikeSentenceLinkGraphQLParser;
import com.facebook.ufiservices.util.LinkifyUtilGraphQLParsers.LinkableUtilAddLikeSentenceLinkGraphQLParser.AggregatedRangesParser;
import com.facebook.ufiservices.util.LinkifyUtilGraphQLParsers.LinkableUtilAddLikeSentenceLinkGraphQLParser.RangesParser;
import com.facebook.ufiservices.util.LinkifyUtilGraphQLParsers.LinkableUtilAddLikeSentenceLinkGraphQLParser.RangesParser.EntityParser;
import com.facebook.ufiservices.util.LinkifyUtilGraphQLParsers.StoryHeaderSectionOnClickGraphQLParser;
import com.facebook.ufiservices.util.LinkifyUtilGraphQLParsers.StoryHeaderSectionOnClickGraphQLParser.AppSectionParser;
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

/* compiled from: crop_profile_picture */
public class LinkifyUtilGraphQLModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 2062089222)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: crop_profile_picture */
    public final class LinkableUtilAddLikeSentenceLinkGraphQLModel extends BaseModel implements GraphQLVisitableModel, LinkableUtilApplyActorsLinksGraphQL {
        @Nullable
        private List<AggregatedRangesModel> f18330d;
        @Nullable
        private List<RangesModel> f18331e;
        @Nullable
        private String f18332f;

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 732242581)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: crop_profile_picture */
        public final class AggregatedRangesModel extends BaseModel implements GraphQLVisitableModel {
            private int f18314d;
            private int f18315e;

            /* compiled from: crop_profile_picture */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(AggregatedRangesModel.class, new Deserializer());
                }

                public Object m26841a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(AggregatedRangesParser.m26924b(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object aggregatedRangesModel = new AggregatedRangesModel();
                    ((BaseModel) aggregatedRangesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (aggregatedRangesModel instanceof Postprocessable) {
                        return ((Postprocessable) aggregatedRangesModel).a();
                    }
                    return aggregatedRangesModel;
                }
            }

            /* compiled from: crop_profile_picture */
            public class Serializer extends JsonSerializer<AggregatedRangesModel> {
                public final void m26842a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    AggregatedRangesModel aggregatedRangesModel = (AggregatedRangesModel) obj;
                    if (aggregatedRangesModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(aggregatedRangesModel.m26844a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        aggregatedRangesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    AggregatedRangesParser.m26923a(aggregatedRangesModel.w_(), aggregatedRangesModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(AggregatedRangesModel.class, new Serializer());
                }
            }

            public AggregatedRangesModel() {
                super(2);
            }

            public final int m26843a() {
                a(0, 0);
                return this.f18314d;
            }

            public final int m26847b() {
                a(0, 1);
                return this.f18315e;
            }

            public final int jK_() {
                return 1563462756;
            }

            public final GraphQLVisitableModel m26845a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m26844a(FlatBufferBuilder flatBufferBuilder) {
                h();
                flatBufferBuilder.c(2);
                flatBufferBuilder.a(0, this.f18314d, 0);
                flatBufferBuilder.a(1, this.f18315e, 0);
                i();
                return flatBufferBuilder.d();
            }

            public final void m26846a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f18314d = mutableFlatBuffer.a(i, 0, 0);
                this.f18315e = mutableFlatBuffer.a(i, 1, 0);
            }
        }

        /* compiled from: crop_profile_picture */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(LinkableUtilAddLikeSentenceLinkGraphQLModel.class, new Deserializer());
            }

            public Object m26848a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(LinkableUtilAddLikeSentenceLinkGraphQLParser.m26930a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object linkableUtilAddLikeSentenceLinkGraphQLModel = new LinkableUtilAddLikeSentenceLinkGraphQLModel();
                ((BaseModel) linkableUtilAddLikeSentenceLinkGraphQLModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (linkableUtilAddLikeSentenceLinkGraphQLModel instanceof Postprocessable) {
                    return ((Postprocessable) linkableUtilAddLikeSentenceLinkGraphQLModel).a();
                }
                return linkableUtilAddLikeSentenceLinkGraphQLModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -547840140)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: crop_profile_picture */
        public final class RangesModel extends BaseModel implements GraphQLVisitableModel, Ranges {
            @Nullable
            private EntityModel f18327d;
            private int f18328e;
            private int f18329f;

            /* compiled from: crop_profile_picture */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(RangesModel.class, new Deserializer());
                }

                public Object m26849a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(RangesParser.m26928b(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object rangesModel = new RangesModel();
                    ((BaseModel) rangesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (rangesModel instanceof Postprocessable) {
                        return ((Postprocessable) rangesModel).a();
                    }
                    return rangesModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -1671914308)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: crop_profile_picture */
            public final class EntityModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel, Entity {
                @Nullable
                private GraphQLObjectType f18316d;
                @Nullable
                private List<String> f18317e;
                @Nullable
                private AppSectionModel f18318f;
                @Nullable
                private GetNativeAppDetailsAppStoreApplicationGraphQLModel f18319g;
                @Nullable
                private String f18320h;
                @Nullable
                private String f18321i;
                @Nullable
                private PageModel f18322j;
                @Nullable
                private C1364xcfb74179 f18323k;
                @Nullable
                private List<RedirectionInfoModel> f18324l;
                @Nullable
                private String f18325m;
                @Nullable
                private String f18326n;

                /* compiled from: crop_profile_picture */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(EntityModel.class, new Deserializer());
                    }

                    public Object m26850a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(EntityParser.m26925a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object entityModel = new EntityModel();
                        ((BaseModel) entityModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (entityModel instanceof Postprocessable) {
                            return ((Postprocessable) entityModel).a();
                        }
                        return entityModel;
                    }
                }

                /* compiled from: crop_profile_picture */
                public class Serializer extends JsonSerializer<EntityModel> {
                    public final void m26851a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        EntityModel entityModel = (EntityModel) obj;
                        if (entityModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(entityModel.m26856a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            entityModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        EntityParser.m26926a(entityModel.w_(), entityModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(EntityModel.class, new Serializer());
                    }
                }

                @Nullable
                public final /* synthetic */ ProfilePicture ad_() {
                    return m26855r();
                }

                @Nullable
                public final /* synthetic */ Page m26865j() {
                    return m26854q();
                }

                @Nullable
                public final /* synthetic */ C0589xd643bf8b m26867l() {
                    return m26855r();
                }

                @Nullable
                public final /* synthetic */ GetNativeAppDetailsAppStoreApplicationGraphQLModel m26868m() {
                    return m26853p();
                }

                @Nullable
                public final /* synthetic */ Entity.Page m26869n() {
                    return m26854q();
                }

                public EntityModel() {
                    super(11);
                }

                public final void m26859a(String str, ConsistencyTuple consistencyTuple) {
                    consistencyTuple.a();
                }

                public final void m26860a(String str, Object obj, boolean z) {
                }

                @Nullable
                public final GraphQLObjectType m26861b() {
                    if (this.b != null && this.f18316d == null) {
                        this.f18316d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                    }
                    return this.f18316d;
                }

                @Nonnull
                public final ImmutableList<String> m26862c() {
                    this.f18317e = super.a(this.f18317e, 1);
                    return (ImmutableList) this.f18317e;
                }

                @Nullable
                private AppSectionModel m26852o() {
                    this.f18318f = (AppSectionModel) super.a(this.f18318f, 2, AppSectionModel.class);
                    return this.f18318f;
                }

                @Nullable
                private GetNativeAppDetailsAppStoreApplicationGraphQLModel m26853p() {
                    this.f18319g = (GetNativeAppDetailsAppStoreApplicationGraphQLModel) super.a(this.f18319g, 3, GetNativeAppDetailsAppStoreApplicationGraphQLModel.class);
                    return this.f18319g;
                }

                @Nullable
                public final String m26863d() {
                    this.f18320h = super.a(this.f18320h, 4);
                    return this.f18320h;
                }

                @Nullable
                public final String C_() {
                    this.f18321i = super.a(this.f18321i, 5);
                    return this.f18321i;
                }

                @Nullable
                private PageModel m26854q() {
                    this.f18322j = (PageModel) super.a(this.f18322j, 6, PageModel.class);
                    return this.f18322j;
                }

                @Nullable
                private C1364xcfb74179 m26855r() {
                    this.f18323k = (C1364xcfb74179) super.a(this.f18323k, 7, C1364xcfb74179.class);
                    return this.f18323k;
                }

                @Nonnull
                public final ImmutableList<RedirectionInfoModel> m26866k() {
                    this.f18324l = super.a(this.f18324l, 8, RedirectionInfoModel.class);
                    return (ImmutableList) this.f18324l;
                }

                @Nullable
                public final String m26864g() {
                    this.f18325m = super.a(this.f18325m, 9);
                    return this.f18325m;
                }

                @Nullable
                public final String D_() {
                    this.f18326n = super.a(this.f18326n, 10);
                    return this.f18326n;
                }

                @Nullable
                public final String m26858a() {
                    return m26863d();
                }

                public final int jK_() {
                    return 2080559107;
                }

                public final GraphQLVisitableModel m26857a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m26852o() != null) {
                        AppSectionModel appSectionModel = (AppSectionModel) graphQLModelMutatingVisitor.b(m26852o());
                        if (m26852o() != appSectionModel) {
                            graphQLVisitableModel = (EntityModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f18318f = appSectionModel;
                        }
                    }
                    if (m26853p() != null) {
                        GetNativeAppDetailsAppStoreApplicationGraphQLModel getNativeAppDetailsAppStoreApplicationGraphQLModel = (GetNativeAppDetailsAppStoreApplicationGraphQLModel) graphQLModelMutatingVisitor.b(m26853p());
                        if (m26853p() != getNativeAppDetailsAppStoreApplicationGraphQLModel) {
                            graphQLVisitableModel = (EntityModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f18319g = getNativeAppDetailsAppStoreApplicationGraphQLModel;
                        }
                    }
                    if (m26854q() != null) {
                        PageModel pageModel = (PageModel) graphQLModelMutatingVisitor.b(m26854q());
                        if (m26854q() != pageModel) {
                            graphQLVisitableModel = (EntityModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f18322j = pageModel;
                        }
                    }
                    if (m26855r() != null) {
                        C1364xcfb74179 c1364xcfb74179 = (C1364xcfb74179) graphQLModelMutatingVisitor.b(m26855r());
                        if (m26855r() != c1364xcfb74179) {
                            graphQLVisitableModel = (EntityModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f18323k = c1364xcfb74179;
                        }
                    }
                    if (m26866k() != null) {
                        Builder a = ModelHelper.a(m26866k(), graphQLModelMutatingVisitor);
                        if (a != null) {
                            EntityModel entityModel = (EntityModel) ModelHelper.a(graphQLVisitableModel, this);
                            entityModel.f18324l = a.b();
                            graphQLVisitableModel = entityModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m26856a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m26861b());
                    int c = flatBufferBuilder.c(m26862c());
                    int a2 = ModelHelper.a(flatBufferBuilder, m26852o());
                    int a3 = ModelHelper.a(flatBufferBuilder, m26853p());
                    int b = flatBufferBuilder.b(m26863d());
                    int b2 = flatBufferBuilder.b(C_());
                    int a4 = ModelHelper.a(flatBufferBuilder, m26854q());
                    int a5 = ModelHelper.a(flatBufferBuilder, m26855r());
                    int a6 = ModelHelper.a(flatBufferBuilder, m26866k());
                    int b3 = flatBufferBuilder.b(m26864g());
                    int b4 = flatBufferBuilder.b(D_());
                    flatBufferBuilder.c(11);
                    flatBufferBuilder.b(0, a);
                    flatBufferBuilder.b(1, c);
                    flatBufferBuilder.b(2, a2);
                    flatBufferBuilder.b(3, a3);
                    flatBufferBuilder.b(4, b);
                    flatBufferBuilder.b(5, b2);
                    flatBufferBuilder.b(6, a4);
                    flatBufferBuilder.b(7, a5);
                    flatBufferBuilder.b(8, a6);
                    flatBufferBuilder.b(9, b3);
                    flatBufferBuilder.b(10, b4);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: crop_profile_picture */
            public class Serializer extends JsonSerializer<RangesModel> {
                public final void m26870a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    RangesModel rangesModel = (RangesModel) obj;
                    if (rangesModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(rangesModel.m26872a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        rangesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    RangesParser.m26929b(rangesModel.w_(), rangesModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(RangesModel.class, new Serializer());
                }
            }

            @Nullable
            public final /* synthetic */ EntityModel m26874a() {
                return m26871j();
            }

            @Nullable
            public final /* synthetic */ Entity m26878d() {
                return m26871j();
            }

            @Nullable
            public final /* synthetic */ LinkableUtilApplyClickableLinkSpanWithEntityGraphQL.Entity dG_() {
                return m26871j();
            }

            @Nullable
            public final /* synthetic */ LinkableUtilApplyHashtagLinkGraphQL.Entity dH_() {
                return m26871j();
            }

            @Nullable
            public final /* synthetic */ LinkableUtilShouldFormatAsExternalLinkGraphQL.Entity dI_() {
                return m26871j();
            }

            @Nullable
            public final /* synthetic */ LinkableUtilApplyFamilyNonUserMemberLinkGraphQL.Entity m26879g() {
                return m26871j();
            }

            public RangesModel() {
                super(3);
            }

            @Nullable
            private EntityModel m26871j() {
                this.f18327d = (EntityModel) super.a(this.f18327d, 0, EntityModel.class);
                return this.f18327d;
            }

            public final int m26876b() {
                a(0, 1);
                return this.f18328e;
            }

            public final int m26877c() {
                a(0, 2);
                return this.f18329f;
            }

            public final int jK_() {
                return -1024511161;
            }

            public final GraphQLVisitableModel m26873a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m26871j() != null) {
                    EntityModel entityModel = (EntityModel) graphQLModelMutatingVisitor.b(m26871j());
                    if (m26871j() != entityModel) {
                        graphQLVisitableModel = (RangesModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f18327d = entityModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m26872a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m26871j());
                flatBufferBuilder.c(3);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.a(1, this.f18328e, 0);
                flatBufferBuilder.a(2, this.f18329f, 0);
                i();
                return flatBufferBuilder.d();
            }

            public final void m26875a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f18328e = mutableFlatBuffer.a(i, 1, 0);
                this.f18329f = mutableFlatBuffer.a(i, 2, 0);
            }
        }

        /* compiled from: crop_profile_picture */
        public class Serializer extends JsonSerializer<LinkableUtilAddLikeSentenceLinkGraphQLModel> {
            public final void m26880a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                int i;
                LinkableUtilAddLikeSentenceLinkGraphQLModel linkableUtilAddLikeSentenceLinkGraphQLModel = (LinkableUtilAddLikeSentenceLinkGraphQLModel) obj;
                if (linkableUtilAddLikeSentenceLinkGraphQLModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(linkableUtilAddLikeSentenceLinkGraphQLModel.m26881a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    linkableUtilAddLikeSentenceLinkGraphQLModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = linkableUtilAddLikeSentenceLinkGraphQLModel.w_();
                int u_ = linkableUtilAddLikeSentenceLinkGraphQLModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("aggregated_ranges");
                    jsonGenerator.d();
                    for (i = 0; i < mutableFlatBuffer.c(g); i++) {
                        AggregatedRangesParser.m26923a(mutableFlatBuffer, mutableFlatBuffer.m(g, i), jsonGenerator);
                    }
                    jsonGenerator.e();
                }
                g = mutableFlatBuffer.g(u_, 1);
                if (g != 0) {
                    jsonGenerator.a("ranges");
                    jsonGenerator.d();
                    for (i = 0; i < mutableFlatBuffer.c(g); i++) {
                        RangesParser.m26929b(mutableFlatBuffer, mutableFlatBuffer.m(g, i), jsonGenerator, serializerProvider);
                    }
                    jsonGenerator.e();
                }
                if (mutableFlatBuffer.g(u_, 2) != 0) {
                    jsonGenerator.a("text");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 2));
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(LinkableUtilAddLikeSentenceLinkGraphQLModel.class, new Serializer());
            }
        }

        public LinkableUtilAddLikeSentenceLinkGraphQLModel() {
            super(3);
        }

        public LinkableUtilAddLikeSentenceLinkGraphQLModel(MutableFlatBuffer mutableFlatBuffer) {
            super(3);
            a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }

        @Nonnull
        public final ImmutableList<AggregatedRangesModel> m26885c() {
            this.f18330d = super.a(this.f18330d, 0, AggregatedRangesModel.class);
            return (ImmutableList) this.f18330d;
        }

        @Nonnull
        public final ImmutableList<RangesModel> m26884b() {
            this.f18331e = super.a(this.f18331e, 1, RangesModel.class);
            return (ImmutableList) this.f18331e;
        }

        @Nullable
        public final String m26883a() {
            this.f18332f = super.a(this.f18332f, 2);
            return this.f18332f;
        }

        public final int jK_() {
            return -1919764332;
        }

        public final GraphQLVisitableModel m26882a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            Builder a;
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m26885c() != null) {
                a = ModelHelper.a(m26885c(), graphQLModelMutatingVisitor);
                if (a != null) {
                    graphQLVisitableModel = (LinkableUtilAddLikeSentenceLinkGraphQLModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f18330d = a.b();
                }
            }
            if (m26884b() != null) {
                a = ModelHelper.a(m26884b(), graphQLModelMutatingVisitor);
                if (a != null) {
                    graphQLVisitableModel = (LinkableUtilAddLikeSentenceLinkGraphQLModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f18331e = a.b();
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m26881a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m26885c());
            int a2 = ModelHelper.a(flatBufferBuilder, m26884b());
            int b = flatBufferBuilder.b(m26883a());
            flatBufferBuilder.c(3);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            flatBufferBuilder.b(2, b);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1225319955)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: crop_profile_picture */
    public final class StoryHeaderSectionOnClickGraphQLModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel, StoryHeaderSectionOnClickGraphQL {
        @Nullable
        private GraphQLObjectType f18342d;
        @Nullable
        private AppSectionModel f18343e;
        @Nullable
        private String f18344f;

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1801334754)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: crop_profile_picture */
        public final class AppSectionModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
            @Nullable
            private String f18341d;

            /* compiled from: crop_profile_picture */
            public final class Builder {
                @Nullable
                public String f18340a;
            }

            /* compiled from: crop_profile_picture */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(AppSectionModel.class, new Deserializer());
                }

                public Object m26908a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(AppSectionParser.m26951a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object appSectionModel = new AppSectionModel();
                    ((BaseModel) appSectionModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (appSectionModel instanceof Postprocessable) {
                        return ((Postprocessable) appSectionModel).a();
                    }
                    return appSectionModel;
                }
            }

            /* compiled from: crop_profile_picture */
            public class Serializer extends JsonSerializer<AppSectionModel> {
                public final void m26909a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    AppSectionModel appSectionModel = (AppSectionModel) obj;
                    if (appSectionModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(appSectionModel.m26911a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        appSectionModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    AppSectionParser.m26952a(appSectionModel.w_(), appSectionModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(AppSectionModel.class, new Serializer());
                }
            }

            public AppSectionModel() {
                super(1);
            }

            public AppSectionModel(MutableFlatBuffer mutableFlatBuffer) {
                super(1);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            @Nullable
            public final String m26914b() {
                this.f18341d = super.a(this.f18341d, 0);
                return this.f18341d;
            }

            public static AppSectionModel m26910a(AppSectionModel appSectionModel) {
                if (appSectionModel == null) {
                    return null;
                }
                if (appSectionModel instanceof AppSectionModel) {
                    return appSectionModel;
                }
                Builder builder = new Builder();
                builder.f18340a = appSectionModel.m26914b();
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int b = flatBufferBuilder.b(builder.f18340a);
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new AppSectionModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }

            @Nullable
            public final String m26913a() {
                return m26914b();
            }

            public final int jK_() {
                return 1842803909;
            }

            public final GraphQLVisitableModel m26912a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m26911a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m26914b());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: crop_profile_picture */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(StoryHeaderSectionOnClickGraphQLModel.class, new Deserializer());
            }

            public Object m26915a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = StoryHeaderSectionOnClickGraphQLParser.m26953a(jsonParser);
                Object storyHeaderSectionOnClickGraphQLModel = new StoryHeaderSectionOnClickGraphQLModel();
                ((BaseModel) storyHeaderSectionOnClickGraphQLModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (storyHeaderSectionOnClickGraphQLModel instanceof Postprocessable) {
                    return ((Postprocessable) storyHeaderSectionOnClickGraphQLModel).a();
                }
                return storyHeaderSectionOnClickGraphQLModel;
            }
        }

        /* compiled from: crop_profile_picture */
        public class Serializer extends JsonSerializer<StoryHeaderSectionOnClickGraphQLModel> {
            public final void m26916a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                StoryHeaderSectionOnClickGraphQLModel storyHeaderSectionOnClickGraphQLModel = (StoryHeaderSectionOnClickGraphQLModel) obj;
                if (storyHeaderSectionOnClickGraphQLModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(storyHeaderSectionOnClickGraphQLModel.m26920a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    storyHeaderSectionOnClickGraphQLModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = storyHeaderSectionOnClickGraphQLModel.w_();
                int u_ = storyHeaderSectionOnClickGraphQLModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("__type__");
                    SerializerHelpers.b(mutableFlatBuffer, u_, 0, jsonGenerator);
                }
                int g = mutableFlatBuffer.g(u_, 1);
                if (g != 0) {
                    jsonGenerator.a("app_section");
                    AppSectionParser.m26952a(mutableFlatBuffer, g, jsonGenerator);
                }
                if (mutableFlatBuffer.g(u_, 2) != 0) {
                    jsonGenerator.a("id");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 2));
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(StoryHeaderSectionOnClickGraphQLModel.class, new Serializer());
            }
        }

        public StoryHeaderSectionOnClickGraphQLModel() {
            super(3);
        }

        @Nullable
        private GraphQLObjectType m26917j() {
            if (this.b != null && this.f18342d == null) {
                this.f18342d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
            }
            return this.f18342d;
        }

        @Nullable
        private AppSectionModel m26918k() {
            this.f18343e = (AppSectionModel) super.a(this.f18343e, 1, AppSectionModel.class);
            return this.f18343e;
        }

        @Nullable
        private String m26919l() {
            this.f18344f = super.a(this.f18344f, 2);
            return this.f18344f;
        }

        @Nullable
        public final String m26922a() {
            return m26919l();
        }

        public final int jK_() {
            return 2080559107;
        }

        public final GraphQLVisitableModel m26921a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m26918k() != null) {
                AppSectionModel appSectionModel = (AppSectionModel) graphQLModelMutatingVisitor.b(m26918k());
                if (m26918k() != appSectionModel) {
                    graphQLVisitableModel = (StoryHeaderSectionOnClickGraphQLModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f18343e = appSectionModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m26920a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m26917j());
            int a2 = ModelHelper.a(flatBufferBuilder, m26918k());
            int b = flatBufferBuilder.b(m26919l());
            flatBufferBuilder.c(3);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            flatBufferBuilder.b(2, b);
            i();
            return flatBufferBuilder.d();
        }
    }
}
