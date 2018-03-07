package com.facebook.ufiservices.util;

import com.facebook.directinstall.util.C0888xfe11ab0e;
import com.facebook.directinstall.util.DirectInstallApplicationUtilsGraphQLModels.GetNativeAppDetailsAppStoreApplicationGraphQLModel;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.linkutil.C0890x64054611;
import com.facebook.graphql.linkutil.GraphQLLinkExtractorGraphQLInterfaces$GetEntityFbLinkGraphQL;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.visitor.ConsistencyTuple;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.linkify.LinkifyTargetGraphQLInterfaces$LinkifyTargetGraphQL.ProfilePicture;
import com.facebook.linkify.LinkifyTargetGraphQLModels$LinkifyTargetGraphQLModel;
import com.facebook.proxygen.HTTPTransportCallback;
import com.facebook.ufiservices.util.LinkifyUtilGraphQLInterfaces$LinkableUtilApplyActorsLinksGraphQL.Ranges;
import com.facebook.ufiservices.util.LinkifyUtilGraphQLInterfaces$LinkableUtilApplyActorsLinksGraphQL.Ranges.Entity;
import com.facebook.ufiservices.util.LinkifyUtilGraphQLInterfaces$LinkableUtilApplyActorsLinksGraphQL.Ranges.Entity.Page;
import com.facebook.ufiservices.util.LinkifyUtilGraphQLModels$LinkableUtilApplyActorsLinksGraphQLModel$RangesModel.Deserializer;
import com.facebook.ufiservices.util.LinkifyUtilGraphQLModels$LinkableUtilApplyActorsLinksGraphQLModel$RangesModel.EntityModel.PageModel.Builder;
import com.facebook.ufiservices.util.LinkifyUtilGraphQLModels$LinkableUtilApplyActorsLinksGraphQLModel$RangesModel.EntityModel.ProfilePictureModel;
import com.facebook.ufiservices.util.LinkifyUtilGraphQLModels$LinkableUtilApplyActorsLinksGraphQLModel$RangesModel.Serializer;
import com.facebook.ufiservices.util.LinkifyUtilGraphQLModels.StoryHeaderSectionOnClickGraphQLModel.AppSectionModel;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.google.common.collect.ImmutableList;
import java.nio.ByteBuffer;
import java.util.List;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

@JsonDeserialize(using = Deserializer.class)
@ModelWithFlatBufferFormatHash(a = 1642454484)
@JsonSerialize(using = Serializer.class)
@FragmentModelWithoutBridge
/* compiled from: gradient */
public final class C0882xfbc399e7 extends BaseModel implements GraphQLVisitableModel, Ranges {
    @Nullable
    private EntityModel f22070d;
    private int f22071e;
    private int f22072f;

    @JsonDeserialize(using = EntityModel.Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1671914308)
    @JsonSerialize(using = EntityModel.Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: gradient */
    public final class EntityModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel, Entity {
        @Nullable
        private GraphQLObjectType f22073d;
        @Nullable
        private List<String> f22074e;
        @Nullable
        private AppSectionModel f22075f;
        @Nullable
        private GetNativeAppDetailsAppStoreApplicationGraphQLModel f22076g;
        @Nullable
        private String f22077h;
        @Nullable
        private String f22078i;
        @Nullable
        private PageModel f22079j;
        @Nullable
        private ProfilePictureModel f22080k;
        @Nullable
        private List<C0890x64054611> f22081l;
        @Nullable
        private String f22082m;
        @Nullable
        private String f22083n;

        @JsonDeserialize(using = PageModel.Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 723206835)
        @JsonSerialize(using = PageModel.Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: gradient */
        public final class PageModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel, Page {
            @Nullable
            private GraphQLObjectType f22088d;
            @Nullable
            private String f22089e;
            @Nullable
            private String f22090f;
            @Nullable
            private LinkifyTargetGraphQLModels$LinkifyTargetGraphQLModel.ProfilePictureModel f22091g;
            @Nullable
            private String f22092h;

            @Nullable
            public final /* synthetic */ ProfilePicture ad_() {
                return m29949j();
            }

            public PageModel() {
                super(5);
            }

            public PageModel(MutableFlatBuffer mutableFlatBuffer) {
                super(5);
                mo1412a(mutableFlatBuffer, FlatBuffer.m4026a(mutableFlatBuffer.f15021a));
            }

            public final void mo2835a(String str, ConsistencyTuple consistencyTuple) {
                consistencyTuple.m26322a();
            }

            public final void mo2836a(String str, Object obj, boolean z) {
            }

            @Nullable
            public final GraphQLObjectType mo3202b() {
                if (this.f5823b != null && this.f22088d == null) {
                    this.f22088d = (GraphQLObjectType) this.f5823b.m21551d(this.f5824c, 0, GraphQLObjectType.class);
                }
                return this.f22088d;
            }

            @Nullable
            public final String mo3203d() {
                this.f22089e = super.m9948a(this.f22089e, 1);
                return this.f22089e;
            }

            @Nullable
            public final String C_() {
                this.f22090f = super.m9948a(this.f22090f, 2);
                return this.f22090f;
            }

            @Nullable
            private LinkifyTargetGraphQLModels$LinkifyTargetGraphQLModel.ProfilePictureModel m29949j() {
                this.f22091g = (LinkifyTargetGraphQLModels$LinkifyTargetGraphQLModel.ProfilePictureModel) super.m9947a(this.f22091g, 3, LinkifyTargetGraphQLModels$LinkifyTargetGraphQLModel.ProfilePictureModel.class);
                return this.f22091g;
            }

            @Nullable
            public final String D_() {
                this.f22092h = super.m9948a(this.f22092h, 4);
                return this.f22092h;
            }

            public static PageModel m29948a(Page page) {
                if (page == null) {
                    return null;
                }
                if (page instanceof PageModel) {
                    return (PageModel) page;
                }
                Builder builder = new Builder();
                builder.a = page.mo3202b();
                builder.b = page.mo3203d();
                builder.c = page.C_();
                builder.d = LinkifyTargetGraphQLModels$LinkifyTargetGraphQLModel.ProfilePictureModel.m29540a(page.ad_());
                builder.e = page.D_();
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(HTTPTransportCallback.BODY_BYTES_RECEIVED);
                int a = ModelHelper.m23093a(flatBufferBuilder, builder.a);
                int b = flatBufferBuilder.m21502b(builder.b);
                int b2 = flatBufferBuilder.m21502b(builder.c);
                int a2 = ModelHelper.m23093a(flatBufferBuilder, builder.d);
                int b3 = flatBufferBuilder.m21502b(builder.e);
                flatBufferBuilder.m21510c(5);
                flatBufferBuilder.m21507b(0, a);
                flatBufferBuilder.m21507b(1, b);
                flatBufferBuilder.m21507b(2, b2);
                flatBufferBuilder.m21507b(3, a2);
                flatBufferBuilder.m21507b(4, b3);
                flatBufferBuilder.m21513d(flatBufferBuilder.m21511d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.m21515e());
                wrap.position(0);
                return new PageModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }

            @Nullable
            public final String mo2834a() {
                return mo3203d();
            }

            public final int jK_() {
                return 2479791;
            }

            public final GraphQLVisitableModel mo1404a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                m9958h();
                if (m29949j() != null) {
                    LinkifyTargetGraphQLModels$LinkifyTargetGraphQLModel.ProfilePictureModel profilePictureModel = (LinkifyTargetGraphQLModels$LinkifyTargetGraphQLModel.ProfilePictureModel) graphQLModelMutatingVisitor.mo2928b(m29949j());
                    if (m29949j() != profilePictureModel) {
                        graphQLVisitableModel = (PageModel) ModelHelper.m23095a(null, (GraphQLVisitableModel) this);
                        graphQLVisitableModel.f22091g = profilePictureModel;
                    }
                }
                m9959i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int mo1403a(FlatBufferBuilder flatBufferBuilder) {
                m9958h();
                int a = ModelHelper.m23093a(flatBufferBuilder, mo3202b());
                int b = flatBufferBuilder.m21502b(mo3203d());
                int b2 = flatBufferBuilder.m21502b(C_());
                int a2 = ModelHelper.m23093a(flatBufferBuilder, m29949j());
                int b3 = flatBufferBuilder.m21502b(D_());
                flatBufferBuilder.m21510c(5);
                flatBufferBuilder.m21507b(0, a);
                flatBufferBuilder.m21507b(1, b);
                flatBufferBuilder.m21507b(2, b2);
                flatBufferBuilder.m21507b(3, a2);
                flatBufferBuilder.m21507b(4, b3);
                m9959i();
                return flatBufferBuilder.m21511d();
            }
        }

        @Nullable
        public final /* synthetic */ ProfilePicture ad_() {
            return m29909r();
        }

        @Nullable
        public final /* synthetic */ GraphQLLinkExtractorGraphQLInterfaces$GetEntityFbLinkGraphQL.Page mo3235j() {
            return m29908q();
        }

        @Nullable
        public final /* synthetic */ C0888xfe11ab0e.ProfilePicture mo3237l() {
            return m29909r();
        }

        @Nullable
        public final /* synthetic */ GetNativeAppDetailsAppStoreApplicationGraphQLModel mo3238m() {
            return m29907p();
        }

        @Nullable
        public final /* synthetic */ Page mo3239n() {
            return m29908q();
        }

        public EntityModel() {
            super(11);
        }

        public final void mo2835a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.m26322a();
        }

        public final void mo2836a(String str, Object obj, boolean z) {
        }

        @Nullable
        public final GraphQLObjectType mo3202b() {
            if (this.f5823b != null && this.f22073d == null) {
                this.f22073d = (GraphQLObjectType) this.f5823b.m21551d(this.f5824c, 0, GraphQLObjectType.class);
            }
            return this.f22073d;
        }

        @Nonnull
        public final ImmutableList<String> mo3233c() {
            this.f22074e = super.m9943a(this.f22074e, 1);
            return (ImmutableList) this.f22074e;
        }

        @Nullable
        private AppSectionModel m29906o() {
            this.f22075f = (AppSectionModel) super.m9947a(this.f22075f, 2, AppSectionModel.class);
            return this.f22075f;
        }

        @Nullable
        private GetNativeAppDetailsAppStoreApplicationGraphQLModel m29907p() {
            this.f22076g = (GetNativeAppDetailsAppStoreApplicationGraphQLModel) super.m9947a(this.f22076g, 3, GetNativeAppDetailsAppStoreApplicationGraphQLModel.class);
            return this.f22076g;
        }

        @Nullable
        public final String mo3203d() {
            this.f22077h = super.m9948a(this.f22077h, 4);
            return this.f22077h;
        }

        @Nullable
        public final String C_() {
            this.f22078i = super.m9948a(this.f22078i, 5);
            return this.f22078i;
        }

        @Nullable
        private PageModel m29908q() {
            this.f22079j = (PageModel) super.m9947a(this.f22079j, 6, PageModel.class);
            return this.f22079j;
        }

        @Nullable
        private ProfilePictureModel m29909r() {
            this.f22080k = (ProfilePictureModel) super.m9947a(this.f22080k, 7, ProfilePictureModel.class);
            return this.f22080k;
        }

        @Nonnull
        public final ImmutableList<C0890x64054611> mo3236k() {
            this.f22081l = super.m9944a(this.f22081l, 8, C0890x64054611.class);
            return (ImmutableList) this.f22081l;
        }

        @Nullable
        public final String mo3234g() {
            this.f22082m = super.m9948a(this.f22082m, 9);
            return this.f22082m;
        }

        @Nullable
        public final String D_() {
            this.f22083n = super.m9948a(this.f22083n, 10);
            return this.f22083n;
        }

        @Nullable
        public final String mo2834a() {
            return mo3203d();
        }

        public final int jK_() {
            return 2080559107;
        }

        public final GraphQLVisitableModel mo1404a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            m9958h();
            if (m29906o() != null) {
                AppSectionModel appSectionModel = (AppSectionModel) graphQLModelMutatingVisitor.mo2928b(m29906o());
                if (m29906o() != appSectionModel) {
                    graphQLVisitableModel = (EntityModel) ModelHelper.m23095a(null, (GraphQLVisitableModel) this);
                    graphQLVisitableModel.f22075f = appSectionModel;
                }
            }
            if (m29907p() != null) {
                GetNativeAppDetailsAppStoreApplicationGraphQLModel getNativeAppDetailsAppStoreApplicationGraphQLModel = (GetNativeAppDetailsAppStoreApplicationGraphQLModel) graphQLModelMutatingVisitor.mo2928b(m29907p());
                if (m29907p() != getNativeAppDetailsAppStoreApplicationGraphQLModel) {
                    graphQLVisitableModel = (EntityModel) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                    graphQLVisitableModel.f22076g = getNativeAppDetailsAppStoreApplicationGraphQLModel;
                }
            }
            if (m29908q() != null) {
                PageModel pageModel = (PageModel) graphQLModelMutatingVisitor.mo2928b(m29908q());
                if (m29908q() != pageModel) {
                    graphQLVisitableModel = (EntityModel) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                    graphQLVisitableModel.f22079j = pageModel;
                }
            }
            if (m29909r() != null) {
                ProfilePictureModel profilePictureModel = (ProfilePictureModel) graphQLModelMutatingVisitor.mo2928b(m29909r());
                if (m29909r() != profilePictureModel) {
                    graphQLVisitableModel = (EntityModel) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                    graphQLVisitableModel.f22080k = profilePictureModel;
                }
            }
            if (mo3236k() != null) {
                ImmutableList.Builder a = ModelHelper.m23097a(mo3236k(), graphQLModelMutatingVisitor);
                if (a != null) {
                    EntityModel entityModel = (EntityModel) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                    entityModel.f22081l = a.m1068b();
                    graphQLVisitableModel = entityModel;
                }
            }
            m9959i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int mo1403a(FlatBufferBuilder flatBufferBuilder) {
            m9958h();
            int a = ModelHelper.m23093a(flatBufferBuilder, mo3202b());
            int c = flatBufferBuilder.m21509c(mo3233c());
            int a2 = ModelHelper.m23093a(flatBufferBuilder, m29906o());
            int a3 = ModelHelper.m23093a(flatBufferBuilder, m29907p());
            int b = flatBufferBuilder.m21502b(mo3203d());
            int b2 = flatBufferBuilder.m21502b(C_());
            int a4 = ModelHelper.m23093a(flatBufferBuilder, m29908q());
            int a5 = ModelHelper.m23093a(flatBufferBuilder, m29909r());
            int a6 = ModelHelper.m23094a(flatBufferBuilder, mo3236k());
            int b3 = flatBufferBuilder.m21502b(mo3234g());
            int b4 = flatBufferBuilder.m21502b(D_());
            flatBufferBuilder.m21510c(11);
            flatBufferBuilder.m21507b(0, a);
            flatBufferBuilder.m21507b(1, c);
            flatBufferBuilder.m21507b(2, a2);
            flatBufferBuilder.m21507b(3, a3);
            flatBufferBuilder.m21507b(4, b);
            flatBufferBuilder.m21507b(5, b2);
            flatBufferBuilder.m21507b(6, a4);
            flatBufferBuilder.m21507b(7, a5);
            flatBufferBuilder.m21507b(8, a6);
            flatBufferBuilder.m21507b(9, b3);
            flatBufferBuilder.m21507b(10, b4);
            m9959i();
            return flatBufferBuilder.m21511d();
        }
    }

    @Nullable
    public final /* synthetic */ Entity mo3228d() {
        return m29888a();
    }

    @Nullable
    public final /* synthetic */ C0883x3380bccd.Entity dG_() {
        return m29888a();
    }

    @Nullable
    public final /* synthetic */ LinkifyUtilGraphQLInterfaces$LinkableUtilApplyHashtagLinkGraphQL.Entity dH_() {
        return m29888a();
    }

    @Nullable
    public final /* synthetic */ C0885xba9ef6ad.Entity dI_() {
        return m29888a();
    }

    @Nullable
    public final /* synthetic */ C0884x53bd6f74.Entity mo3232g() {
        return m29888a();
    }

    public C0882xfbc399e7() {
        super(3);
    }

    @Nullable
    private EntityModel m29888a() {
        this.f22070d = (EntityModel) super.m9947a(this.f22070d, 0, EntityModel.class);
        return this.f22070d;
    }

    public final int mo3226b() {
        m9949a(0, 1);
        return this.f22071e;
    }

    public final int mo3227c() {
        m9949a(0, 2);
        return this.f22072f;
    }

    public final int jK_() {
        return -1024511161;
    }

    public final GraphQLVisitableModel mo1404a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        m9958h();
        if (m29888a() != null) {
            EntityModel entityModel = (EntityModel) graphQLModelMutatingVisitor.mo2928b(m29888a());
            if (m29888a() != entityModel) {
                graphQLVisitableModel = (C0882xfbc399e7) ModelHelper.m23095a(null, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f22070d = entityModel;
            }
        }
        m9959i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public final int mo1403a(FlatBufferBuilder flatBufferBuilder) {
        m9958h();
        int a = ModelHelper.m23093a(flatBufferBuilder, m29888a());
        flatBufferBuilder.m21510c(3);
        flatBufferBuilder.m21507b(0, a);
        flatBufferBuilder.m21494a(1, this.f22071e, 0);
        flatBufferBuilder.m21494a(2, this.f22072f, 0);
        m9959i();
        return flatBufferBuilder.m21511d();
    }

    public final void mo1406a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.mo1406a(mutableFlatBuffer, i, obj);
        this.f22071e = mutableFlatBuffer.m21524a(i, 1, 0);
        this.f22072f = mutableFlatBuffer.m21524a(i, 2, 0);
    }
}
