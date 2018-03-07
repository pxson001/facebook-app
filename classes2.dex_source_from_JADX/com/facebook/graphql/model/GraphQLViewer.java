package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.json.AutoGenJsonSerializer;
import com.facebook.dracula.api.FieldOffset;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.flatbuffers.MutableFlattenable;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ImmutableListHelper;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.modelutil.TypeModel;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.instagram.common.json.annotation.JsonType;
import java.util.List;
import javax.annotation.Nullable;

@AutoGenJsonDeserializer
@AutoGenJsonSerializer
@Deprecated
@JsonType
/* compiled from: root viewer object contains no edges */
public final class GraphQLViewer extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLViewer> CREATOR = new C06701();
    int f6537A;
    int f6538B;
    int f6539C;
    int f6540D;
    int f6541E;
    @Nullable
    GraphQLMediaSet f6542F;
    @Nullable
    GraphQLGroup f6543G;
    @Nullable
    GraphQLInstreamVideoAdsConnection f6544H;
    @Nullable
    String f6545I;
    @Nullable
    GraphQLEligibleClashUnitsConnection f6546J;
    @Nullable
    GraphQLUser f6547d;
    @Nullable
    GraphQLActor f6548e;
    @Deprecated
    @Nullable
    GraphQLAdditionalSuggestedPostAdItemsConnection f6549f;
    @Nullable
    GraphQLAudienceInfo f6550g;
    @Nullable
    GraphQLPrivacyOptionsComposerConnection f6551h;
    @Nullable
    GraphQLPage f6552i;
    @Nullable
    String f6553j;
    @Nullable
    GraphQLCustomizedStory f6554k;
    @Nullable
    GraphQLDebugFeedConnection f6555l;
    @Deprecated
    int f6556m;
    @Nullable
    GraphQLFriendingPossibilitiesConnection f6557n;
    @Nullable
    GraphQLPage f6558o;
    @Nullable
    GraphQLGoodwillHappyBirthdayCard f6559p;
    boolean f6560q;
    boolean f6561r;
    boolean f6562s;
    @Deprecated
    @Nullable
    GraphQLStatelessLargeImagePLAsConnection f6563t;
    @Nullable
    GraphQLMegaphone f6564u;
    @Nullable
    GraphQLNewsFeedConnection f6565v;
    @Nullable
    GraphQLGreetingCard f6566w;
    @Nullable
    String f6567x;
    @Nullable
    GraphQLSideFeedConnection f6568y;
    List<GraphQLTaggableActivity> f6569z;

    /* compiled from: root viewer object contains no edges */
    final class C06701 implements Creator<GraphQLViewer> {
        C06701() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLViewer(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLViewer[i];
        }
    }

    @FieldOffset
    @Nullable
    public final GraphQLUser m11349a() {
        this.f6547d = (GraphQLUser) super.m9947a(this.f6547d, 0, GraphQLUser.class);
        return this.f6547d;
    }

    @FieldOffset
    @Nullable
    public final GraphQLActor m11352j() {
        this.f6548e = (GraphQLActor) super.m9947a(this.f6548e, 1, GraphQLActor.class);
        return this.f6548e;
    }

    @FieldOffset
    @Nullable
    public final GraphQLAdditionalSuggestedPostAdItemsConnection m11353k() {
        this.f6549f = (GraphQLAdditionalSuggestedPostAdItemsConnection) super.m9947a(this.f6549f, 2, GraphQLAdditionalSuggestedPostAdItemsConnection.class);
        return this.f6549f;
    }

    @FieldOffset
    @Nullable
    public final GraphQLAudienceInfo m11354l() {
        this.f6550g = (GraphQLAudienceInfo) super.m9947a(this.f6550g, 3, GraphQLAudienceInfo.class);
        return this.f6550g;
    }

    @FieldOffset
    @Nullable
    public final GraphQLPrivacyOptionsComposerConnection m11355m() {
        this.f6551h = (GraphQLPrivacyOptionsComposerConnection) super.m9947a(this.f6551h, 4, GraphQLPrivacyOptionsComposerConnection.class);
        return this.f6551h;
    }

    @FieldOffset
    @Nullable
    public final GraphQLPage m11356n() {
        this.f6552i = (GraphQLPage) super.m9947a(this.f6552i, 5, GraphQLPage.class);
        return this.f6552i;
    }

    @FieldOffset
    @Nullable
    public final String m11357o() {
        this.f6553j = super.m9948a(this.f6553j, 6);
        return this.f6553j;
    }

    @FieldOffset
    @Nullable
    public final GraphQLCustomizedStory m11358p() {
        this.f6554k = (GraphQLCustomizedStory) super.m9947a(this.f6554k, 7, GraphQLCustomizedStory.class);
        return this.f6554k;
    }

    @FieldOffset
    @Nullable
    public final GraphQLDebugFeedConnection m11359q() {
        this.f6555l = (GraphQLDebugFeedConnection) super.m9947a(this.f6555l, 8, GraphQLDebugFeedConnection.class);
        return this.f6555l;
    }

    @FieldOffset
    public final int m11360r() {
        m9949a(1, 1);
        return this.f6556m;
    }

    @FieldOffset
    @Nullable
    public final GraphQLFriendingPossibilitiesConnection m11361s() {
        this.f6557n = (GraphQLFriendingPossibilitiesConnection) super.m9947a(this.f6557n, 10, GraphQLFriendingPossibilitiesConnection.class);
        return this.f6557n;
    }

    @FieldOffset
    @Nullable
    public final GraphQLPage m11362t() {
        this.f6558o = (GraphQLPage) super.m9947a(this.f6558o, 11, GraphQLPage.class);
        return this.f6558o;
    }

    @FieldOffset
    @Nullable
    public final GraphQLGoodwillHappyBirthdayCard m11363u() {
        this.f6559p = (GraphQLGoodwillHappyBirthdayCard) super.m9947a(this.f6559p, 13, GraphQLGoodwillHappyBirthdayCard.class);
        return this.f6559p;
    }

    @FieldOffset
    public final boolean m11364v() {
        m9949a(1, 6);
        return this.f6560q;
    }

    @FieldOffset
    public final boolean m11365w() {
        m9949a(1, 7);
        return this.f6561r;
    }

    @FieldOffset
    public final boolean m11366x() {
        m9949a(2, 0);
        return this.f6562s;
    }

    @FieldOffset
    @Nullable
    public final GraphQLStatelessLargeImagePLAsConnection m11367y() {
        this.f6563t = (GraphQLStatelessLargeImagePLAsConnection) super.m9947a(this.f6563t, 17, GraphQLStatelessLargeImagePLAsConnection.class);
        return this.f6563t;
    }

    @FieldOffset
    @Nullable
    public final GraphQLMegaphone m11368z() {
        this.f6564u = (GraphQLMegaphone) super.m9947a(this.f6564u, 18, GraphQLMegaphone.class);
        return this.f6564u;
    }

    @FieldOffset
    @Nullable
    public final GraphQLNewsFeedConnection m11333A() {
        this.f6565v = (GraphQLNewsFeedConnection) super.m9947a(this.f6565v, 19, GraphQLNewsFeedConnection.class);
        return this.f6565v;
    }

    @FieldOffset
    @Nullable
    public final GraphQLGreetingCard m11334B() {
        this.f6566w = (GraphQLGreetingCard) super.m9947a(this.f6566w, 21, GraphQLGreetingCard.class);
        return this.f6566w;
    }

    @FieldOffset
    @Nullable
    public final String m11335C() {
        this.f6567x = super.m9948a(this.f6567x, 22);
        return this.f6567x;
    }

    @FieldOffset
    @Nullable
    public final GraphQLSideFeedConnection m11336D() {
        this.f6568y = (GraphQLSideFeedConnection) super.m9947a(this.f6568y, 23, GraphQLSideFeedConnection.class);
        return this.f6568y;
    }

    @FieldOffset
    public final ImmutableList<GraphQLTaggableActivity> m11337E() {
        this.f6569z = super.m9944a(this.f6569z, 24, GraphQLTaggableActivity.class);
        return (ImmutableList) this.f6569z;
    }

    @FieldOffset
    public final int m11338F() {
        m9949a(3, 1);
        return this.f6537A;
    }

    @FieldOffset
    public final int m11339G() {
        m9949a(3, 2);
        return this.f6538B;
    }

    @FieldOffset
    public final int m11340H() {
        m9949a(3, 3);
        return this.f6539C;
    }

    @FieldOffset
    public final int m11341I() {
        m9949a(3, 4);
        return this.f6540D;
    }

    @FieldOffset
    public final int m11342J() {
        m9949a(3, 5);
        return this.f6541E;
    }

    @FieldOffset
    @Nullable
    public final GraphQLMediaSet m11343K() {
        this.f6542F = (GraphQLMediaSet) super.m9947a(this.f6542F, 30, GraphQLMediaSet.class);
        return this.f6542F;
    }

    @FieldOffset
    @Nullable
    public final GraphQLGroup m11344L() {
        this.f6543G = (GraphQLGroup) super.m9947a(this.f6543G, 31, GraphQLGroup.class);
        return this.f6543G;
    }

    @FieldOffset
    @Nullable
    public final GraphQLInstreamVideoAdsConnection m11345M() {
        this.f6544H = (GraphQLInstreamVideoAdsConnection) super.m9947a(this.f6544H, 33, GraphQLInstreamVideoAdsConnection.class);
        return this.f6544H;
    }

    @FieldOffset
    @Nullable
    public final String m11346N() {
        this.f6545I = super.m9948a(this.f6545I, 35);
        return this.f6545I;
    }

    @FieldOffset
    @Nullable
    public final GraphQLEligibleClashUnitsConnection m11347O() {
        this.f6546J = (GraphQLEligibleClashUnitsConnection) super.m9947a(this.f6546J, 36, GraphQLEligibleClashUnitsConnection.class);
        return this.f6546J;
    }

    public final int jK_() {
        return -1732764110;
    }

    public final GraphQLVisitableModel mo1404a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLPage graphQLPage;
        GraphQLVisitableModel graphQLVisitableModel = null;
        m9958h();
        if (m11349a() != null) {
            GraphQLUser graphQLUser = (GraphQLUser) graphQLModelMutatingVisitor.mo2928b(m11349a());
            if (m11349a() != graphQLUser) {
                graphQLVisitableModel = (GraphQLViewer) ModelHelper.m23095a(null, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f6547d = graphQLUser;
            }
        }
        if (m11352j() != null) {
            GraphQLActor graphQLActor = (GraphQLActor) graphQLModelMutatingVisitor.mo2928b(m11352j());
            if (m11352j() != graphQLActor) {
                graphQLVisitableModel = (GraphQLViewer) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f6548e = graphQLActor;
            }
        }
        if (m11353k() != null) {
            GraphQLAdditionalSuggestedPostAdItemsConnection graphQLAdditionalSuggestedPostAdItemsConnection = (GraphQLAdditionalSuggestedPostAdItemsConnection) graphQLModelMutatingVisitor.mo2928b(m11353k());
            if (m11353k() != graphQLAdditionalSuggestedPostAdItemsConnection) {
                graphQLVisitableModel = (GraphQLViewer) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f6549f = graphQLAdditionalSuggestedPostAdItemsConnection;
            }
        }
        if (m11354l() != null) {
            GraphQLAudienceInfo graphQLAudienceInfo = (GraphQLAudienceInfo) graphQLModelMutatingVisitor.mo2928b(m11354l());
            if (m11354l() != graphQLAudienceInfo) {
                graphQLVisitableModel = (GraphQLViewer) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f6550g = graphQLAudienceInfo;
            }
        }
        if (m11355m() != null) {
            GraphQLPrivacyOptionsComposerConnection graphQLPrivacyOptionsComposerConnection = (GraphQLPrivacyOptionsComposerConnection) graphQLModelMutatingVisitor.mo2928b(m11355m());
            if (m11355m() != graphQLPrivacyOptionsComposerConnection) {
                graphQLVisitableModel = (GraphQLViewer) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f6551h = graphQLPrivacyOptionsComposerConnection;
            }
        }
        if (m11356n() != null) {
            graphQLPage = (GraphQLPage) graphQLModelMutatingVisitor.mo2928b(m11356n());
            if (m11356n() != graphQLPage) {
                graphQLVisitableModel = (GraphQLViewer) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f6552i = graphQLPage;
            }
        }
        if (m11358p() != null) {
            GraphQLCustomizedStory graphQLCustomizedStory = (GraphQLCustomizedStory) graphQLModelMutatingVisitor.mo2928b(m11358p());
            if (m11358p() != graphQLCustomizedStory) {
                graphQLVisitableModel = (GraphQLViewer) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f6554k = graphQLCustomizedStory;
            }
        }
        if (m11359q() != null) {
            GraphQLDebugFeedConnection graphQLDebugFeedConnection = (GraphQLDebugFeedConnection) graphQLModelMutatingVisitor.mo2928b(m11359q());
            if (m11359q() != graphQLDebugFeedConnection) {
                graphQLVisitableModel = (GraphQLViewer) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f6555l = graphQLDebugFeedConnection;
            }
        }
        if (m11347O() != null) {
            GraphQLEligibleClashUnitsConnection graphQLEligibleClashUnitsConnection = (GraphQLEligibleClashUnitsConnection) graphQLModelMutatingVisitor.mo2928b(m11347O());
            if (m11347O() != graphQLEligibleClashUnitsConnection) {
                graphQLVisitableModel = (GraphQLViewer) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f6546J = graphQLEligibleClashUnitsConnection;
            }
        }
        if (m11361s() != null) {
            GraphQLFriendingPossibilitiesConnection graphQLFriendingPossibilitiesConnection = (GraphQLFriendingPossibilitiesConnection) graphQLModelMutatingVisitor.mo2928b(m11361s());
            if (m11361s() != graphQLFriendingPossibilitiesConnection) {
                graphQLVisitableModel = (GraphQLViewer) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f6557n = graphQLFriendingPossibilitiesConnection;
            }
        }
        if (m11362t() != null) {
            graphQLPage = (GraphQLPage) graphQLModelMutatingVisitor.mo2928b(m11362t());
            if (m11362t() != graphQLPage) {
                graphQLVisitableModel = (GraphQLViewer) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f6558o = graphQLPage;
            }
        }
        if (m11363u() != null) {
            GraphQLGoodwillHappyBirthdayCard graphQLGoodwillHappyBirthdayCard = (GraphQLGoodwillHappyBirthdayCard) graphQLModelMutatingVisitor.mo2928b(m11363u());
            if (m11363u() != graphQLGoodwillHappyBirthdayCard) {
                graphQLVisitableModel = (GraphQLViewer) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f6559p = graphQLGoodwillHappyBirthdayCard;
            }
        }
        if (m11345M() != null) {
            GraphQLInstreamVideoAdsConnection graphQLInstreamVideoAdsConnection = (GraphQLInstreamVideoAdsConnection) graphQLModelMutatingVisitor.mo2928b(m11345M());
            if (m11345M() != graphQLInstreamVideoAdsConnection) {
                graphQLVisitableModel = (GraphQLViewer) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f6544H = graphQLInstreamVideoAdsConnection;
            }
        }
        if (m11367y() != null) {
            GraphQLStatelessLargeImagePLAsConnection graphQLStatelessLargeImagePLAsConnection = (GraphQLStatelessLargeImagePLAsConnection) graphQLModelMutatingVisitor.mo2928b(m11367y());
            if (m11367y() != graphQLStatelessLargeImagePLAsConnection) {
                graphQLVisitableModel = (GraphQLViewer) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f6563t = graphQLStatelessLargeImagePLAsConnection;
            }
        }
        if (m11368z() != null) {
            GraphQLMegaphone graphQLMegaphone = (GraphQLMegaphone) graphQLModelMutatingVisitor.mo2928b(m11368z());
            if (m11368z() != graphQLMegaphone) {
                graphQLVisitableModel = (GraphQLViewer) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f6564u = graphQLMegaphone;
            }
        }
        if (m11333A() != null) {
            GraphQLNewsFeedConnection graphQLNewsFeedConnection = (GraphQLNewsFeedConnection) graphQLModelMutatingVisitor.mo2928b(m11333A());
            if (m11333A() != graphQLNewsFeedConnection) {
                graphQLVisitableModel = (GraphQLViewer) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f6565v = graphQLNewsFeedConnection;
            }
        }
        if (m11334B() != null) {
            GraphQLGreetingCard graphQLGreetingCard = (GraphQLGreetingCard) graphQLModelMutatingVisitor.mo2928b(m11334B());
            if (m11334B() != graphQLGreetingCard) {
                graphQLVisitableModel = (GraphQLViewer) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f6566w = graphQLGreetingCard;
            }
        }
        if (m11336D() != null) {
            GraphQLSideFeedConnection graphQLSideFeedConnection = (GraphQLSideFeedConnection) graphQLModelMutatingVisitor.mo2928b(m11336D());
            if (m11336D() != graphQLSideFeedConnection) {
                graphQLVisitableModel = (GraphQLViewer) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f6568y = graphQLSideFeedConnection;
            }
        }
        if (m11337E() != null) {
            Builder a = ModelHelper.m23097a(m11337E(), graphQLModelMutatingVisitor);
            if (a != null) {
                GraphQLViewer graphQLViewer = (GraphQLViewer) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLViewer.f6569z = a.m1068b();
                graphQLVisitableModel = graphQLViewer;
            }
        }
        if (m11343K() != null) {
            GraphQLMediaSet graphQLMediaSet = (GraphQLMediaSet) graphQLModelMutatingVisitor.mo2928b(m11343K());
            if (m11343K() != graphQLMediaSet) {
                graphQLVisitableModel = (GraphQLViewer) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f6542F = graphQLMediaSet;
            }
        }
        if (m11344L() != null) {
            GraphQLGroup graphQLGroup = (GraphQLGroup) graphQLModelMutatingVisitor.mo2928b(m11344L());
            if (m11344L() != graphQLGroup) {
                graphQLVisitableModel = (GraphQLViewer) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f6543G = graphQLGroup;
            }
        }
        m9959i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLViewer() {
        super(38);
    }

    public final void mo1406a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.mo1406a(mutableFlatBuffer, i, obj);
        this.f6556m = mutableFlatBuffer.m21524a(i, 9, 0);
        this.f6560q = mutableFlatBuffer.m21540a(i, 14);
        this.f6561r = mutableFlatBuffer.m21540a(i, 15);
        this.f6562s = mutableFlatBuffer.m21540a(i, 16);
        this.f6537A = mutableFlatBuffer.m21524a(i, 25, 0);
        this.f6538B = mutableFlatBuffer.m21524a(i, 26, 0);
        this.f6539C = mutableFlatBuffer.m21524a(i, 27, 0);
        this.f6540D = mutableFlatBuffer.m21524a(i, 28, 0);
        this.f6541E = mutableFlatBuffer.m21524a(i, 29, 0);
    }

    public final int mo1403a(FlatBufferBuilder flatBufferBuilder) {
        m9958h();
        int a = ModelHelper.m23093a(flatBufferBuilder, m11349a());
        int a2 = ModelHelper.m23093a(flatBufferBuilder, m11352j());
        int a3 = ModelHelper.m23093a(flatBufferBuilder, m11353k());
        int a4 = ModelHelper.m23093a(flatBufferBuilder, m11354l());
        int a5 = ModelHelper.m23093a(flatBufferBuilder, m11355m());
        int a6 = ModelHelper.m23093a(flatBufferBuilder, m11356n());
        int b = flatBufferBuilder.m21502b(m11357o());
        int a7 = ModelHelper.m23093a(flatBufferBuilder, m11358p());
        int a8 = ModelHelper.m23093a(flatBufferBuilder, m11359q());
        int a9 = ModelHelper.m23093a(flatBufferBuilder, m11361s());
        int a10 = ModelHelper.m23093a(flatBufferBuilder, m11362t());
        int a11 = ModelHelper.m23093a(flatBufferBuilder, m11363u());
        int a12 = ModelHelper.m23093a(flatBufferBuilder, m11367y());
        int a13 = ModelHelper.m23093a(flatBufferBuilder, m11368z());
        int a14 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) m11333A());
        int a15 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) m11334B());
        int b2 = flatBufferBuilder.m21502b(m11335C());
        int a16 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) m11336D());
        int a17 = ModelHelper.m23094a(flatBufferBuilder, (List) m11337E());
        int a18 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) m11343K());
        int a19 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) m11344L());
        int a20 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) m11345M());
        int b3 = flatBufferBuilder.m21502b(m11346N());
        int a21 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) m11347O());
        flatBufferBuilder.m21510c(37);
        flatBufferBuilder.m21507b(0, a);
        flatBufferBuilder.m21507b(1, a2);
        flatBufferBuilder.m21507b(2, a3);
        flatBufferBuilder.m21507b(3, a4);
        flatBufferBuilder.m21507b(4, a5);
        flatBufferBuilder.m21507b(5, a6);
        flatBufferBuilder.m21507b(6, b);
        flatBufferBuilder.m21507b(7, a7);
        flatBufferBuilder.m21507b(8, a8);
        flatBufferBuilder.m21494a(9, m11360r(), 0);
        flatBufferBuilder.m21507b(10, a9);
        flatBufferBuilder.m21507b(11, a10);
        flatBufferBuilder.m21507b(13, a11);
        flatBufferBuilder.m21498a(14, m11364v());
        flatBufferBuilder.m21498a(15, m11365w());
        flatBufferBuilder.m21498a(16, m11366x());
        flatBufferBuilder.m21507b(17, a12);
        flatBufferBuilder.m21507b(18, a13);
        flatBufferBuilder.m21507b(19, a14);
        flatBufferBuilder.m21507b(21, a15);
        flatBufferBuilder.m21507b(22, b2);
        flatBufferBuilder.m21507b(23, a16);
        flatBufferBuilder.m21507b(24, a17);
        flatBufferBuilder.m21494a(25, m11338F(), 0);
        flatBufferBuilder.m21494a(26, m11339G(), 0);
        flatBufferBuilder.m21494a(27, m11340H(), 0);
        flatBufferBuilder.m21494a(28, m11341I(), 0);
        flatBufferBuilder.m21494a(29, m11342J(), 0);
        flatBufferBuilder.m21507b(30, a18);
        flatBufferBuilder.m21507b(31, a19);
        flatBufferBuilder.m21507b(33, a20);
        flatBufferBuilder.m21507b(35, b3);
        flatBufferBuilder.m21507b(36, a21);
        m9959i();
        return flatBufferBuilder.m21511d();
    }

    public GraphQLViewer(Parcel parcel) {
        boolean z;
        boolean z2 = true;
        super(38);
        this.f6547d = (GraphQLUser) parcel.readValue(GraphQLUser.class.getClassLoader());
        this.f6548e = (GraphQLActor) parcel.readValue(GraphQLActor.class.getClassLoader());
        this.f6549f = (GraphQLAdditionalSuggestedPostAdItemsConnection) parcel.readValue(GraphQLAdditionalSuggestedPostAdItemsConnection.class.getClassLoader());
        this.f6550g = (GraphQLAudienceInfo) parcel.readValue(GraphQLAudienceInfo.class.getClassLoader());
        this.f6551h = (GraphQLPrivacyOptionsComposerConnection) parcel.readValue(GraphQLPrivacyOptionsComposerConnection.class.getClassLoader());
        this.f6552i = (GraphQLPage) parcel.readValue(GraphQLPage.class.getClassLoader());
        this.f6553j = parcel.readString();
        this.f6554k = (GraphQLCustomizedStory) parcel.readValue(GraphQLCustomizedStory.class.getClassLoader());
        this.f6555l = (GraphQLDebugFeedConnection) parcel.readValue(GraphQLDebugFeedConnection.class.getClassLoader());
        this.f6546J = (GraphQLEligibleClashUnitsConnection) parcel.readValue(GraphQLEligibleClashUnitsConnection.class.getClassLoader());
        this.f6556m = parcel.readInt();
        this.f6557n = (GraphQLFriendingPossibilitiesConnection) parcel.readValue(GraphQLFriendingPossibilitiesConnection.class.getClassLoader());
        this.f6558o = (GraphQLPage) parcel.readValue(GraphQLPage.class.getClassLoader());
        this.f6559p = (GraphQLGoodwillHappyBirthdayCard) parcel.readValue(GraphQLGoodwillHappyBirthdayCard.class.getClassLoader());
        this.f6560q = parcel.readByte() == (byte) 1;
        this.f6544H = (GraphQLInstreamVideoAdsConnection) parcel.readValue(GraphQLInstreamVideoAdsConnection.class.getClassLoader());
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.f6561r = z;
        if (parcel.readByte() != (byte) 1) {
            z2 = false;
        }
        this.f6562s = z2;
        this.f6563t = (GraphQLStatelessLargeImagePLAsConnection) parcel.readValue(GraphQLStatelessLargeImagePLAsConnection.class.getClassLoader());
        this.f6564u = (GraphQLMegaphone) parcel.readValue(GraphQLMegaphone.class.getClassLoader());
        this.f6565v = (GraphQLNewsFeedConnection) parcel.readValue(GraphQLNewsFeedConnection.class.getClassLoader());
        this.f6566w = (GraphQLGreetingCard) parcel.readValue(GraphQLGreetingCard.class.getClassLoader());
        this.f6567x = parcel.readString();
        this.f6568y = (GraphQLSideFeedConnection) parcel.readValue(GraphQLSideFeedConnection.class.getClassLoader());
        this.f6569z = ImmutableListHelper.m21625a(parcel.readArrayList(GraphQLTaggableActivity.class.getClassLoader()));
        this.f6537A = parcel.readInt();
        this.f6538B = parcel.readInt();
        this.f6539C = parcel.readInt();
        this.f6540D = parcel.readInt();
        this.f6541E = parcel.readInt();
        this.f6542F = (GraphQLMediaSet) parcel.readValue(GraphQLMediaSet.class.getClassLoader());
        this.f6543G = (GraphQLGroup) parcel.readValue(GraphQLGroup.class.getClassLoader());
        this.f6545I = parcel.readString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int i2;
        int i3 = 1;
        parcel.writeValue(m11349a());
        parcel.writeValue(m11352j());
        parcel.writeValue(m11353k());
        parcel.writeValue(m11354l());
        parcel.writeValue(m11355m());
        parcel.writeValue(m11356n());
        parcel.writeString(m11357o());
        parcel.writeValue(m11358p());
        parcel.writeValue(m11359q());
        parcel.writeValue(m11347O());
        parcel.writeInt(m11360r());
        parcel.writeValue(m11361s());
        parcel.writeValue(m11362t());
        parcel.writeValue(m11363u());
        parcel.writeByte((byte) (m11364v() ? 1 : 0));
        parcel.writeValue(m11345M());
        if (m11365w()) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        if (!m11366x()) {
            i3 = 0;
        }
        parcel.writeByte((byte) i3);
        parcel.writeValue(m11367y());
        parcel.writeValue(m11368z());
        parcel.writeValue(m11333A());
        parcel.writeValue(m11334B());
        parcel.writeString(m11335C());
        parcel.writeValue(m11336D());
        parcel.writeList(m11337E());
        parcel.writeInt(m11338F());
        parcel.writeInt(m11339G());
        parcel.writeInt(m11340H());
        parcel.writeInt(m11341I());
        parcel.writeInt(m11342J());
        parcel.writeValue(m11343K());
        parcel.writeValue(m11344L());
        parcel.writeString(m11346N());
    }
}
