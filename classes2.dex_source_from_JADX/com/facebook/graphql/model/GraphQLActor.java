package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.json.AutoGenJsonSerializer;
import com.facebook.common.parcels.ParcelUtil;
import com.facebook.dracula.api.FieldOffset;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.flatbuffers.MutableFlattenable;
import com.facebook.graphql.enums.GraphQLFriendshipStatus;
import com.facebook.graphql.enums.GraphQLGender;
import com.facebook.graphql.enums.GraphQLLiveVideoSubscriptionStatus;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.enums.GraphQLSecondarySubscribeStatus;
import com.facebook.graphql.enums.GraphQLSubscribeStatus;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ImmutableListHelper;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.modelutil.TypeModel;
import com.facebook.graphql.visitor.ConsistencyTuple;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.google.common.collect.ImmutableList;
import com.instagram.common.json.annotation.JsonType;
import java.util.List;
import javax.annotation.Nullable;

@AutoGenJsonDeserializer
@AutoGenJsonSerializer
@Deprecated
@JsonType
/* compiled from: localsell_initial_message */
public final class GraphQLActor extends BaseModel implements TypeModel, GraphQLPersistableNode, GraphQLVisitableConsistentModel {
    public static final Creator<GraphQLActor> CREATOR = new C07831();
    GraphQLGender f16810A;
    @Nullable
    GraphQLPage f16811B;
    @Nullable
    String f16812C;
    boolean f16813D;
    boolean f16814E;
    boolean f16815F;
    boolean f16816G;
    boolean f16817H;
    boolean f16818I;
    boolean f16819J;
    boolean f16820K;
    boolean f16821L;
    boolean f16822M;
    boolean f16823N;
    boolean f16824O;
    @Nullable
    GraphQLLikedProfilesConnection f16825P;
    public GraphQLLiveVideoSubscriptionStatus f16826Q;
    long f16827R;
    double f16828S;
    @Nullable
    String f16829T;
    @Nullable
    GraphQLMutualFriendsConnection f16830U;
    @Nullable
    String f16831V;
    List<String> f16832W;
    @Deprecated
    @Nullable
    GraphQLNewsFeedConnection f16833X;
    @Nullable
    GraphQLPageLikersConnection f16834Y;
    @Nullable
    GraphQLPrivacyScope f16835Z;
    @Nullable
    GraphQLTextWithEntities aA;
    boolean aB;
    double aC;
    public boolean aD;
    boolean aE;
    @Nullable
    String aF;
    @Nullable
    GraphQLProfileVideo aG;
    boolean aH;
    @Nullable
    GraphQLImage aa;
    @Nullable
    GraphQLProfileBadge ab;
    @Nullable
    GraphQLPhoto ac;
    @Nullable
    GraphQLImage ad;
    long ae;
    boolean af;
    @Nullable
    String ag;
    @Nullable
    String ah;
    public GraphQLSecondarySubscribeStatus ai;
    @Nullable
    GraphQLSinglePublisherVideoChannelsConnection aj;
    @Nullable
    GraphQLImage ak;
    @Nullable
    GraphQLImage al;
    @Nullable
    GraphQLImage am;
    @Nullable
    GraphQLName an;
    public GraphQLSubscribeStatus ao;
    @Nullable
    GraphQLTextWithEntities ap;
    int aq;
    @Nullable
    String ar;
    @Nullable
    String as;
    boolean at;
    @Nullable
    GraphQLProfile au;
    boolean av;
    public boolean aw;
    int ax;
    int ay;
    @Nullable
    GraphQLTextWithEntities az;
    @Nullable
    GraphQLObjectType f16836d;
    @Nullable
    GraphQLPageAdminInfo f16837e;
    @Nullable
    String f16838f;
    @Nullable
    GraphQLAppStoreApplication f16839g;
    @Nullable
    GraphQLTextWithEntities f16840h;
    @Nullable
    GraphQLFriendsConnection f16841i;
    boolean f16842j;
    boolean f16843k;
    boolean f16844l;
    public boolean f16845m;
    boolean f16846n;
    boolean f16847o;
    boolean f16848p;
    List<String> f16849q;
    double f16850r;
    @Nullable
    GraphQLFocusedPhoto f16851s;
    @Nullable
    GraphQLPage f16852t;
    @Nullable
    String f16853u;
    List<String> f16854v;
    @Nullable
    String f16855w;
    @Nullable
    GraphQLEventsConnection f16856x;
    @Nullable
    GraphQLFriendsConnection f16857y;
    public GraphQLFriendshipStatus f16858z;

    /* compiled from: localsell_initial_message */
    final class C07831 implements Creator<GraphQLActor> {
        C07831() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLActor(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLActor[i];
        }
    }

    @Nullable
    public final GraphQLObjectType m23790b() {
        if (this.f5823b != null && this.f16836d == null) {
            this.f16836d = new GraphQLObjectType(this.f5823b.m21542b(this.f5824c, 0));
        }
        if (this.f16836d == null || this.f16836d.m22301g() != 0) {
            return this.f16836d;
        }
        return null;
    }

    @FieldOffset
    @Nullable
    public final GraphQLPageAdminInfo m23791j() {
        this.f16837e = (GraphQLPageAdminInfo) super.m9947a(this.f16837e, 1, GraphQLPageAdminInfo.class);
        return this.f16837e;
    }

    @FieldOffset
    @Nullable
    public final String m23792k() {
        this.f16838f = super.m9948a(this.f16838f, 3);
        return this.f16838f;
    }

    @FieldOffset
    @Nullable
    public final GraphQLAppStoreApplication m23793l() {
        this.f16839g = (GraphQLAppStoreApplication) super.m9947a(this.f16839g, 4, GraphQLAppStoreApplication.class);
        return this.f16839g;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities m23794m() {
        this.f16840h = (GraphQLTextWithEntities) super.m9947a(this.f16840h, 5, GraphQLTextWithEntities.class);
        return this.f16840h;
    }

    @FieldOffset
    @Nullable
    public final GraphQLFriendsConnection m23795n() {
        this.f16841i = (GraphQLFriendsConnection) super.m9947a(this.f16841i, 6, GraphQLFriendsConnection.class);
        return this.f16841i;
    }

    @FieldOffset
    public final boolean m23796o() {
        m9949a(0, 7);
        return this.f16842j;
    }

    @FieldOffset
    public final boolean m23797p() {
        m9949a(1, 0);
        return this.f16843k;
    }

    @FieldOffset
    public final boolean m23798q() {
        m9949a(1, 1);
        return this.f16844l;
    }

    @FieldOffset
    public final boolean m23799r() {
        m9949a(1, 2);
        return this.f16845m;
    }

    @FieldOffset
    public final boolean m23800s() {
        m9949a(1, 3);
        return this.f16846n;
    }

    @FieldOffset
    public final boolean m23801t() {
        m9949a(1, 4);
        return this.f16847o;
    }

    @FieldOffset
    public final boolean m23802u() {
        m9949a(1, 5);
        return this.f16848p;
    }

    @FieldOffset
    public final ImmutableList<String> m23803v() {
        this.f16849q = super.m9943a(this.f16849q, 14);
        return (ImmutableList) this.f16849q;
    }

    @FieldOffset
    public final double m23804w() {
        m9949a(1, 7);
        return this.f16850r;
    }

    @FieldOffset
    @Nullable
    public final GraphQLFocusedPhoto m23805x() {
        this.f16851s = (GraphQLFocusedPhoto) super.m9947a(this.f16851s, 16, GraphQLFocusedPhoto.class);
        return this.f16851s;
    }

    @FieldOffset
    @Nullable
    public final GraphQLPage m23806y() {
        this.f16852t = (GraphQLPage) super.m9947a(this.f16852t, 17, GraphQLPage.class);
        return this.f16852t;
    }

    @FieldOffset
    @Nullable
    public final String m23807z() {
        this.f16853u = super.m9948a(this.f16853u, 18);
        return this.f16853u;
    }

    @FieldOffset
    public final ImmutableList<String> m23758A() {
        this.f16854v = super.m9943a(this.f16854v, 19);
        return (ImmutableList) this.f16854v;
    }

    @FieldOffset
    @Nullable
    public final String m23759B() {
        this.f16855w = super.m9948a(this.f16855w, 20);
        return this.f16855w;
    }

    @FieldOffset
    @Nullable
    public final GraphQLEventsConnection m23760C() {
        this.f16856x = (GraphQLEventsConnection) super.m9947a(this.f16856x, 21, GraphQLEventsConnection.class);
        return this.f16856x;
    }

    @FieldOffset
    @Nullable
    public final GraphQLFriendsConnection m23761D() {
        this.f16857y = (GraphQLFriendsConnection) super.m9947a(this.f16857y, 25, GraphQLFriendsConnection.class);
        return this.f16857y;
    }

    @FieldOffset
    public final GraphQLFriendshipStatus m23762E() {
        this.f16858z = (GraphQLFriendshipStatus) super.m9945a(this.f16858z, 26, GraphQLFriendshipStatus.class, GraphQLFriendshipStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
        return this.f16858z;
    }

    @FieldOffset
    public final GraphQLGender m23763F() {
        this.f16810A = (GraphQLGender) super.m9945a(this.f16810A, 27, GraphQLGender.class, GraphQLGender.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
        return this.f16810A;
    }

    @FieldOffset
    @Nullable
    public final GraphQLPage m23764G() {
        this.f16811B = (GraphQLPage) super.m9947a(this.f16811B, 28, GraphQLPage.class);
        return this.f16811B;
    }

    @FieldOffset
    @Nullable
    public final String m23765H() {
        this.f16812C = super.m9948a(this.f16812C, 29);
        return this.f16812C;
    }

    @FieldOffset
    public final boolean m23766I() {
        m9949a(3, 6);
        return this.f16813D;
    }

    @FieldOffset
    public final boolean m23767J() {
        m9949a(3, 7);
        return this.f16814E;
    }

    @FieldOffset
    public final boolean m23768K() {
        m9949a(4, 0);
        return this.f16815F;
    }

    @FieldOffset
    public final boolean m23769L() {
        m9949a(4, 1);
        return this.f16816G;
    }

    @FieldOffset
    public final boolean m23770M() {
        m9949a(4, 2);
        return this.f16817H;
    }

    @FieldOffset
    public final boolean m23771N() {
        m9949a(4, 3);
        return this.f16818I;
    }

    @FieldOffset
    public final boolean m23772O() {
        m9949a(4, 4);
        return this.f16819J;
    }

    @FieldOffset
    public final boolean m23773P() {
        m9949a(4, 5);
        return this.f16820K;
    }

    @FieldOffset
    public final boolean m23774Q() {
        m9949a(4, 6);
        return this.f16821L;
    }

    @FieldOffset
    public final boolean m23775R() {
        m9949a(4, 7);
        return this.f16822M;
    }

    @FieldOffset
    public final boolean m23776S() {
        m9949a(5, 0);
        return this.f16823N;
    }

    @FieldOffset
    public final boolean m23777T() {
        m9949a(5, 1);
        return this.f16824O;
    }

    @FieldOffset
    @Nullable
    public final GraphQLLikedProfilesConnection m23778U() {
        this.f16825P = (GraphQLLikedProfilesConnection) super.m9947a(this.f16825P, 42, GraphQLLikedProfilesConnection.class);
        return this.f16825P;
    }

    @FieldOffset
    public final GraphQLLiveVideoSubscriptionStatus m23779V() {
        this.f16826Q = (GraphQLLiveVideoSubscriptionStatus) super.m9945a(this.f16826Q, 43, GraphQLLiveVideoSubscriptionStatus.class, GraphQLLiveVideoSubscriptionStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
        return this.f16826Q;
    }

    @FieldOffset
    public final long m23780W() {
        m9949a(5, 4);
        return this.f16827R;
    }

    @FieldOffset
    public final double m23781X() {
        m9949a(5, 5);
        return this.f16828S;
    }

    @FieldOffset
    @Nullable
    public final String m23782Y() {
        this.f16829T = super.m9948a(this.f16829T, 46);
        return this.f16829T;
    }

    @FieldOffset
    @Nullable
    public final GraphQLMutualFriendsConnection m23783Z() {
        this.f16830U = (GraphQLMutualFriendsConnection) super.m9947a(this.f16830U, 47, GraphQLMutualFriendsConnection.class);
        return this.f16830U;
    }

    @FieldOffset
    @Nullable
    public final String aa() {
        this.f16831V = super.m9948a(this.f16831V, 48);
        return this.f16831V;
    }

    @FieldOffset
    public final ImmutableList<String> ab() {
        this.f16832W = super.m9943a(this.f16832W, 49);
        return (ImmutableList) this.f16832W;
    }

    @FieldOffset
    @Nullable
    public final GraphQLNewsFeedConnection ac() {
        this.f16833X = (GraphQLNewsFeedConnection) super.m9947a(this.f16833X, 50, GraphQLNewsFeedConnection.class);
        return this.f16833X;
    }

    @FieldOffset
    @Nullable
    public final GraphQLPageLikersConnection ad() {
        this.f16834Y = (GraphQLPageLikersConnection) super.m9947a(this.f16834Y, 52, GraphQLPageLikersConnection.class);
        return this.f16834Y;
    }

    @FieldOffset
    @Nullable
    public final GraphQLPrivacyScope ae() {
        this.f16835Z = (GraphQLPrivacyScope) super.m9947a(this.f16835Z, 53, GraphQLPrivacyScope.class);
        return this.f16835Z;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage af() {
        this.aa = (GraphQLImage) super.m9947a(this.aa, 54, GraphQLImage.class);
        return this.aa;
    }

    @FieldOffset
    @Nullable
    public final GraphQLProfileBadge ag() {
        this.ab = (GraphQLProfileBadge) super.m9947a(this.ab, 55, GraphQLProfileBadge.class);
        return this.ab;
    }

    @FieldOffset
    @Nullable
    public final GraphQLPhoto ah() {
        this.ac = (GraphQLPhoto) super.m9947a(this.ac, 56, GraphQLPhoto.class);
        return this.ac;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage ai() {
        this.ad = (GraphQLImage) super.m9947a(this.ad, 57, GraphQLImage.class);
        return this.ad;
    }

    @FieldOffset
    public final long aj() {
        m9949a(7, 2);
        return this.ae;
    }

    @FieldOffset
    public final boolean ak() {
        m9949a(7, 3);
        return this.af;
    }

    @FieldOffset
    @Nullable
    public final String al() {
        this.ag = super.m9948a(this.ag, 60);
        return this.ag;
    }

    @FieldOffset
    @Nullable
    public final String am() {
        this.ah = super.m9948a(this.ah, 61);
        return this.ah;
    }

    @FieldOffset
    public final GraphQLSecondarySubscribeStatus an() {
        this.ai = (GraphQLSecondarySubscribeStatus) super.m9945a(this.ai, 62, GraphQLSecondarySubscribeStatus.class, GraphQLSecondarySubscribeStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
        return this.ai;
    }

    @FieldOffset
    @Nullable
    public final GraphQLSinglePublisherVideoChannelsConnection ao() {
        this.aj = (GraphQLSinglePublisherVideoChannelsConnection) super.m9947a(this.aj, 63, GraphQLSinglePublisherVideoChannelsConnection.class);
        return this.aj;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage ap() {
        this.ak = (GraphQLImage) super.m9947a(this.ak, 64, GraphQLImage.class);
        return this.ak;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage aq() {
        this.al = (GraphQLImage) super.m9947a(this.al, 65, GraphQLImage.class);
        return this.al;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage ar() {
        this.am = (GraphQLImage) super.m9947a(this.am, 66, GraphQLImage.class);
        return this.am;
    }

    @FieldOffset
    @Nullable
    public final GraphQLName as() {
        this.an = (GraphQLName) super.m9947a(this.an, 67, GraphQLName.class);
        return this.an;
    }

    @FieldOffset
    public final GraphQLSubscribeStatus at() {
        this.ao = (GraphQLSubscribeStatus) super.m9945a(this.ao, 68, GraphQLSubscribeStatus.class, GraphQLSubscribeStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
        return this.ao;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities au() {
        this.ap = (GraphQLTextWithEntities) super.m9947a(this.ap, 69, GraphQLTextWithEntities.class);
        return this.ap;
    }

    @FieldOffset
    public final int av() {
        m9949a(8, 7);
        return this.aq;
    }

    @FieldOffset
    @Nullable
    public final String aw() {
        this.ar = super.m9948a(this.ar, 72);
        return this.ar;
    }

    @FieldOffset
    @Nullable
    public final String ax() {
        this.as = super.m9948a(this.as, 73);
        return this.as;
    }

    @FieldOffset
    public final boolean ay() {
        m9949a(9, 2);
        return this.at;
    }

    @FieldOffset
    @Nullable
    public final GraphQLProfile az() {
        this.au = (GraphQLProfile) super.m9947a(this.au, 75, GraphQLProfile.class);
        return this.au;
    }

    @FieldOffset
    public final boolean aA() {
        m9949a(9, 4);
        return this.av;
    }

    @FieldOffset
    public final boolean aB() {
        m9949a(9, 5);
        return this.aw;
    }

    @FieldOffset
    public final int aC() {
        m9949a(9, 6);
        return this.ax;
    }

    @FieldOffset
    public final int aD() {
        m9949a(9, 7);
        return this.ay;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities aE() {
        this.az = (GraphQLTextWithEntities) super.m9947a(this.az, 80, GraphQLTextWithEntities.class);
        return this.az;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities aF() {
        this.aA = (GraphQLTextWithEntities) super.m9947a(this.aA, 81, GraphQLTextWithEntities.class);
        return this.aA;
    }

    @FieldOffset
    public final boolean aG() {
        m9949a(10, 2);
        return this.aB;
    }

    @FieldOffset
    public final double aH() {
        m9949a(10, 3);
        return this.aC;
    }

    @FieldOffset
    public final boolean aI() {
        m9949a(10, 4);
        return this.aD;
    }

    @FieldOffset
    public final boolean aJ() {
        m9949a(10, 5);
        return this.aE;
    }

    @FieldOffset
    @Nullable
    public final String aK() {
        this.aF = super.m9948a(this.aF, 86);
        return this.aF;
    }

    @FieldOffset
    @Nullable
    public final GraphQLProfileVideo aL() {
        this.aG = (GraphQLProfileVideo) super.m9947a(this.aG, 89, GraphQLProfileVideo.class);
        return this.aG;
    }

    @FieldOffset
    public final boolean aM() {
        m9949a(11, 2);
        return this.aH;
    }

    @Nullable
    public final String mo2834a() {
        return m23765H();
    }

    public final int jK_() {
        return 63093205;
    }

    public final GraphQLVisitableModel mo1404a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLTextWithEntities graphQLTextWithEntities;
        GraphQLFriendsConnection graphQLFriendsConnection;
        GraphQLPage graphQLPage;
        GraphQLImage graphQLImage;
        GraphQLVisitableModel graphQLVisitableModel = null;
        m9958h();
        if (m23791j() != null) {
            GraphQLPageAdminInfo graphQLPageAdminInfo = (GraphQLPageAdminInfo) graphQLModelMutatingVisitor.mo2928b(m23791j());
            if (m23791j() != graphQLPageAdminInfo) {
                graphQLVisitableModel = (GraphQLActor) ModelHelper.m23095a(null, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16837e = graphQLPageAdminInfo;
            }
        }
        if (m23793l() != null) {
            GraphQLAppStoreApplication graphQLAppStoreApplication = (GraphQLAppStoreApplication) graphQLModelMutatingVisitor.mo2928b(m23793l());
            if (m23793l() != graphQLAppStoreApplication) {
                graphQLVisitableModel = (GraphQLActor) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16839g = graphQLAppStoreApplication;
            }
        }
        if (m23794m() != null) {
            graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.mo2928b(m23794m());
            if (m23794m() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLActor) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16840h = graphQLTextWithEntities;
            }
        }
        if (m23795n() != null) {
            graphQLFriendsConnection = (GraphQLFriendsConnection) graphQLModelMutatingVisitor.mo2928b(m23795n());
            if (m23795n() != graphQLFriendsConnection) {
                graphQLVisitableModel = (GraphQLActor) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16841i = graphQLFriendsConnection;
            }
        }
        if (m23805x() != null) {
            GraphQLFocusedPhoto graphQLFocusedPhoto = (GraphQLFocusedPhoto) graphQLModelMutatingVisitor.mo2928b(m23805x());
            if (m23805x() != graphQLFocusedPhoto) {
                graphQLVisitableModel = (GraphQLActor) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16851s = graphQLFocusedPhoto;
            }
        }
        if (m23806y() != null) {
            graphQLPage = (GraphQLPage) graphQLModelMutatingVisitor.mo2928b(m23806y());
            if (m23806y() != graphQLPage) {
                graphQLVisitableModel = (GraphQLActor) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16852t = graphQLPage;
            }
        }
        if (m23760C() != null) {
            GraphQLEventsConnection graphQLEventsConnection = (GraphQLEventsConnection) graphQLModelMutatingVisitor.mo2928b(m23760C());
            if (m23760C() != graphQLEventsConnection) {
                graphQLVisitableModel = (GraphQLActor) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16856x = graphQLEventsConnection;
            }
        }
        if (m23761D() != null) {
            graphQLFriendsConnection = (GraphQLFriendsConnection) graphQLModelMutatingVisitor.mo2928b(m23761D());
            if (m23761D() != graphQLFriendsConnection) {
                graphQLVisitableModel = (GraphQLActor) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16857y = graphQLFriendsConnection;
            }
        }
        if (m23764G() != null) {
            graphQLPage = (GraphQLPage) graphQLModelMutatingVisitor.mo2928b(m23764G());
            if (m23764G() != graphQLPage) {
                graphQLVisitableModel = (GraphQLActor) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16811B = graphQLPage;
            }
        }
        if (m23778U() != null) {
            GraphQLLikedProfilesConnection graphQLLikedProfilesConnection = (GraphQLLikedProfilesConnection) graphQLModelMutatingVisitor.mo2928b(m23778U());
            if (m23778U() != graphQLLikedProfilesConnection) {
                graphQLVisitableModel = (GraphQLActor) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16825P = graphQLLikedProfilesConnection;
            }
        }
        if (m23783Z() != null) {
            GraphQLMutualFriendsConnection graphQLMutualFriendsConnection = (GraphQLMutualFriendsConnection) graphQLModelMutatingVisitor.mo2928b(m23783Z());
            if (m23783Z() != graphQLMutualFriendsConnection) {
                graphQLVisitableModel = (GraphQLActor) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16830U = graphQLMutualFriendsConnection;
            }
        }
        if (ac() != null) {
            GraphQLNewsFeedConnection graphQLNewsFeedConnection = (GraphQLNewsFeedConnection) graphQLModelMutatingVisitor.mo2928b(ac());
            if (ac() != graphQLNewsFeedConnection) {
                graphQLVisitableModel = (GraphQLActor) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16833X = graphQLNewsFeedConnection;
            }
        }
        if (ad() != null) {
            GraphQLPageLikersConnection graphQLPageLikersConnection = (GraphQLPageLikersConnection) graphQLModelMutatingVisitor.mo2928b(ad());
            if (ad() != graphQLPageLikersConnection) {
                graphQLVisitableModel = (GraphQLActor) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16834Y = graphQLPageLikersConnection;
            }
        }
        if (ae() != null) {
            GraphQLPrivacyScope graphQLPrivacyScope = (GraphQLPrivacyScope) graphQLModelMutatingVisitor.mo2928b(ae());
            if (ae() != graphQLPrivacyScope) {
                graphQLVisitableModel = (GraphQLActor) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16835Z = graphQLPrivacyScope;
            }
        }
        if (af() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(af());
            if (af() != graphQLImage) {
                graphQLVisitableModel = (GraphQLActor) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.aa = graphQLImage;
            }
        }
        if (ag() != null) {
            GraphQLProfileBadge graphQLProfileBadge = (GraphQLProfileBadge) graphQLModelMutatingVisitor.mo2928b(ag());
            if (ag() != graphQLProfileBadge) {
                graphQLVisitableModel = (GraphQLActor) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.ab = graphQLProfileBadge;
            }
        }
        if (ah() != null) {
            GraphQLPhoto graphQLPhoto = (GraphQLPhoto) graphQLModelMutatingVisitor.mo2928b(ah());
            if (ah() != graphQLPhoto) {
                graphQLVisitableModel = (GraphQLActor) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.ac = graphQLPhoto;
            }
        }
        if (ai() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(ai());
            if (ai() != graphQLImage) {
                graphQLVisitableModel = (GraphQLActor) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.ad = graphQLImage;
            }
        }
        if (aL() != null) {
            GraphQLProfileVideo graphQLProfileVideo = (GraphQLProfileVideo) graphQLModelMutatingVisitor.mo2928b(aL());
            if (aL() != graphQLProfileVideo) {
                graphQLVisitableModel = (GraphQLActor) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.aG = graphQLProfileVideo;
            }
        }
        if (ao() != null) {
            GraphQLSinglePublisherVideoChannelsConnection graphQLSinglePublisherVideoChannelsConnection = (GraphQLSinglePublisherVideoChannelsConnection) graphQLModelMutatingVisitor.mo2928b(ao());
            if (ao() != graphQLSinglePublisherVideoChannelsConnection) {
                graphQLVisitableModel = (GraphQLActor) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.aj = graphQLSinglePublisherVideoChannelsConnection;
            }
        }
        if (ap() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(ap());
            if (ap() != graphQLImage) {
                graphQLVisitableModel = (GraphQLActor) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.ak = graphQLImage;
            }
        }
        if (aq() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(aq());
            if (aq() != graphQLImage) {
                graphQLVisitableModel = (GraphQLActor) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.al = graphQLImage;
            }
        }
        if (ar() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(ar());
            if (ar() != graphQLImage) {
                graphQLVisitableModel = (GraphQLActor) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.am = graphQLImage;
            }
        }
        if (as() != null) {
            GraphQLName graphQLName = (GraphQLName) graphQLModelMutatingVisitor.mo2928b(as());
            if (as() != graphQLName) {
                graphQLVisitableModel = (GraphQLActor) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.an = graphQLName;
            }
        }
        if (au() != null) {
            graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.mo2928b(au());
            if (au() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLActor) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.ap = graphQLTextWithEntities;
            }
        }
        if (az() != null) {
            GraphQLProfile graphQLProfile = (GraphQLProfile) graphQLModelMutatingVisitor.mo2928b(az());
            if (az() != graphQLProfile) {
                graphQLVisitableModel = (GraphQLActor) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.au = graphQLProfile;
            }
        }
        if (aE() != null) {
            graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.mo2928b(aE());
            if (aE() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLActor) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.az = graphQLTextWithEntities;
            }
        }
        if (aF() != null) {
            graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.mo2928b(aF());
            if (aF() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLActor) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.aA = graphQLTextWithEntities;
            }
        }
        m9959i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public final void mo2835a(String str, ConsistencyTuple consistencyTuple) {
        if ("can_viewer_message".equals(str)) {
            consistencyTuple.f18727a = Boolean.valueOf(m23799r());
            consistencyTuple.f18728b = u_();
            consistencyTuple.f18729c = 10;
        } else if ("friendship_status".equals(str)) {
            consistencyTuple.f18727a = m23762E();
            consistencyTuple.f18728b = u_();
            consistencyTuple.f18729c = 26;
        } else if ("live_video_subscription_status".equals(str)) {
            consistencyTuple.f18727a = m23779V();
            consistencyTuple.f18728b = u_();
            consistencyTuple.f18729c = 43;
        } else if ("secondary_subscribe_status".equals(str)) {
            consistencyTuple.f18727a = an();
            consistencyTuple.f18728b = u_();
            consistencyTuple.f18729c = 62;
        } else if ("subscribe_status".equals(str)) {
            consistencyTuple.f18727a = at();
            consistencyTuple.f18728b = u_();
            consistencyTuple.f18729c = 68;
        } else if ("video_channel_has_viewer_subscribed".equals(str)) {
            consistencyTuple.f18727a = Boolean.valueOf(aI());
            consistencyTuple.f18728b = u_();
            consistencyTuple.f18729c = 84;
        } else if ("video_channel_is_viewer_following".equals(str)) {
            consistencyTuple.f18727a = Boolean.valueOf(aB());
            consistencyTuple.f18728b = u_();
            consistencyTuple.f18729c = 77;
        } else {
            consistencyTuple.m26322a();
        }
    }

    public final void mo2836a(String str, Object obj, boolean z) {
        boolean booleanValue;
        if ("can_viewer_message".equals(str)) {
            booleanValue = ((Boolean) obj).booleanValue();
            this.f16845m = booleanValue;
            if (this.f5823b != null && this.f5823b.f15024d) {
                this.f5823b.m21538a(this.f5824c, 10, booleanValue);
            }
        } else if ("friendship_status".equals(str)) {
            r7 = (GraphQLFriendshipStatus) obj;
            this.f16858z = r7;
            if (this.f5823b != null && this.f5823b.f15024d) {
                this.f5823b.m21536a(this.f5824c, 26, r7);
            }
        } else if ("live_video_subscription_status".equals(str)) {
            r7 = (GraphQLLiveVideoSubscriptionStatus) obj;
            this.f16826Q = r7;
            if (this.f5823b != null && this.f5823b.f15024d) {
                this.f5823b.m21536a(this.f5824c, 43, r7);
            }
        } else if ("secondary_subscribe_status".equals(str)) {
            r7 = (GraphQLSecondarySubscribeStatus) obj;
            this.ai = r7;
            if (this.f5823b != null && this.f5823b.f15024d) {
                this.f5823b.m21536a(this.f5824c, 62, r7);
            }
        } else if ("subscribe_status".equals(str)) {
            r7 = (GraphQLSubscribeStatus) obj;
            this.ao = r7;
            if (this.f5823b != null && this.f5823b.f15024d) {
                this.f5823b.m21536a(this.f5824c, 68, r7);
            }
        } else if ("video_channel_has_viewer_subscribed".equals(str)) {
            booleanValue = ((Boolean) obj).booleanValue();
            this.aD = booleanValue;
            if (this.f5823b != null && this.f5823b.f15024d) {
                this.f5823b.m21538a(this.f5824c, 84, booleanValue);
            }
        } else if ("video_channel_is_viewer_following".equals(str)) {
            booleanValue = ((Boolean) obj).booleanValue();
            this.aw = booleanValue;
            if (this.f5823b != null && this.f5823b.f15024d) {
                this.f5823b.m21538a(this.f5824c, 77, booleanValue);
            }
        }
    }

    public GraphQLActor() {
        super(92);
    }

    public final void mo1406a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.mo1406a(mutableFlatBuffer, i, obj);
        this.f16842j = mutableFlatBuffer.m21540a(i, 7);
        this.f16843k = mutableFlatBuffer.m21540a(i, 8);
        this.f16844l = mutableFlatBuffer.m21540a(i, 9);
        this.f16845m = mutableFlatBuffer.m21540a(i, 10);
        this.f16846n = mutableFlatBuffer.m21540a(i, 11);
        this.f16847o = mutableFlatBuffer.m21540a(i, 12);
        this.f16848p = mutableFlatBuffer.m21540a(i, 13);
        this.f16850r = mutableFlatBuffer.m21523a(i, 15, 0.0d);
        this.f16813D = mutableFlatBuffer.m21540a(i, 30);
        this.f16814E = mutableFlatBuffer.m21540a(i, 31);
        this.f16815F = mutableFlatBuffer.m21540a(i, 32);
        this.f16816G = mutableFlatBuffer.m21540a(i, 33);
        this.f16817H = mutableFlatBuffer.m21540a(i, 34);
        this.f16818I = mutableFlatBuffer.m21540a(i, 35);
        this.f16819J = mutableFlatBuffer.m21540a(i, 36);
        this.f16820K = mutableFlatBuffer.m21540a(i, 37);
        this.f16821L = mutableFlatBuffer.m21540a(i, 38);
        this.f16822M = mutableFlatBuffer.m21540a(i, 39);
        this.f16823N = mutableFlatBuffer.m21540a(i, 40);
        this.f16824O = mutableFlatBuffer.m21540a(i, 41);
        this.f16827R = mutableFlatBuffer.m21525a(i, 44, 0);
        this.f16828S = mutableFlatBuffer.m21523a(i, 45, 0.0d);
        this.ae = mutableFlatBuffer.m21525a(i, 58, 0);
        this.af = mutableFlatBuffer.m21540a(i, 59);
        this.aq = mutableFlatBuffer.m21524a(i, 71, 0);
        this.at = mutableFlatBuffer.m21540a(i, 74);
        this.av = mutableFlatBuffer.m21540a(i, 76);
        this.aw = mutableFlatBuffer.m21540a(i, 77);
        this.ax = mutableFlatBuffer.m21524a(i, 78, 0);
        this.ay = mutableFlatBuffer.m21524a(i, 79, 0);
        this.aB = mutableFlatBuffer.m21540a(i, 82);
        this.aC = mutableFlatBuffer.m21523a(i, 83, 0.0d);
        this.aD = mutableFlatBuffer.m21540a(i, 84);
        this.aE = mutableFlatBuffer.m21540a(i, 85);
        this.aH = mutableFlatBuffer.m21540a(i, 90);
    }

    public final int mo1403a(FlatBufferBuilder flatBufferBuilder) {
        m9958h();
        int a = flatBufferBuilder.m21479a(m23790b() != null ? m23790b().m22299e() : null);
        int a2 = ModelHelper.m23093a(flatBufferBuilder, m23791j());
        int b = flatBufferBuilder.m21502b(m23792k());
        int a3 = ModelHelper.m23093a(flatBufferBuilder, m23793l());
        int a4 = ModelHelper.m23093a(flatBufferBuilder, m23794m());
        int a5 = ModelHelper.m23093a(flatBufferBuilder, m23795n());
        int c = flatBufferBuilder.m21509c(m23803v());
        int a6 = ModelHelper.m23093a(flatBufferBuilder, m23805x());
        int a7 = ModelHelper.m23093a(flatBufferBuilder, m23806y());
        int b2 = flatBufferBuilder.m21502b(m23807z());
        int c2 = flatBufferBuilder.m21509c(m23758A());
        int b3 = flatBufferBuilder.m21502b(m23759B());
        int a8 = ModelHelper.m23093a(flatBufferBuilder, m23760C());
        int a9 = ModelHelper.m23093a(flatBufferBuilder, m23761D());
        int a10 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) m23764G());
        int b4 = flatBufferBuilder.m21502b(m23765H());
        int a11 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) m23778U());
        int b5 = flatBufferBuilder.m21502b(m23782Y());
        int a12 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) m23783Z());
        int b6 = flatBufferBuilder.m21502b(aa());
        int c3 = flatBufferBuilder.m21509c((List) ab());
        int a13 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) ac());
        int a14 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) ad());
        int a15 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) ae());
        int a16 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) af());
        int a17 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) ag());
        int a18 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) ah());
        int a19 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) ai());
        int b7 = flatBufferBuilder.m21502b(al());
        int b8 = flatBufferBuilder.m21502b(am());
        int a20 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) ao());
        int a21 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) ap());
        int a22 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) aq());
        int a23 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) ar());
        int a24 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) as());
        int a25 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) au());
        int b9 = flatBufferBuilder.m21502b(aw());
        int b10 = flatBufferBuilder.m21502b(ax());
        int a26 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) az());
        int a27 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) aE());
        int a28 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) aF());
        int b11 = flatBufferBuilder.m21502b(aK());
        int a29 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) aL());
        flatBufferBuilder.m21510c(91);
        flatBufferBuilder.m21507b(0, a);
        flatBufferBuilder.m21507b(1, a2);
        flatBufferBuilder.m21507b(3, b);
        flatBufferBuilder.m21507b(4, a3);
        flatBufferBuilder.m21507b(5, a4);
        flatBufferBuilder.m21507b(6, a5);
        flatBufferBuilder.m21498a(7, m23796o());
        flatBufferBuilder.m21498a(8, m23797p());
        flatBufferBuilder.m21498a(9, m23798q());
        flatBufferBuilder.m21498a(10, m23799r());
        flatBufferBuilder.m21498a(11, m23800s());
        flatBufferBuilder.m21498a(12, m23801t());
        flatBufferBuilder.m21498a(13, m23802u());
        flatBufferBuilder.m21507b(14, c);
        flatBufferBuilder.m21492a(15, m23804w(), 0.0d);
        flatBufferBuilder.m21507b(16, a6);
        flatBufferBuilder.m21507b(17, a7);
        flatBufferBuilder.m21507b(18, b2);
        flatBufferBuilder.m21507b(19, c2);
        flatBufferBuilder.m21507b(20, b3);
        flatBufferBuilder.m21507b(21, a8);
        flatBufferBuilder.m21507b(25, a9);
        flatBufferBuilder.m21496a(26, m23762E() == GraphQLFriendshipStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE ? null : m23762E());
        flatBufferBuilder.m21496a(27, m23763F() == GraphQLGender.UNSET_OR_UNRECOGNIZED_ENUM_VALUE ? null : m23763F());
        flatBufferBuilder.m21507b(28, a10);
        flatBufferBuilder.m21507b(29, b4);
        flatBufferBuilder.m21498a(30, m23766I());
        flatBufferBuilder.m21498a(31, m23767J());
        flatBufferBuilder.m21498a(32, m23768K());
        flatBufferBuilder.m21498a(33, m23769L());
        flatBufferBuilder.m21498a(34, m23770M());
        flatBufferBuilder.m21498a(35, m23771N());
        flatBufferBuilder.m21498a(36, m23772O());
        flatBufferBuilder.m21498a(37, m23773P());
        flatBufferBuilder.m21498a(38, m23774Q());
        flatBufferBuilder.m21498a(39, m23775R());
        flatBufferBuilder.m21498a(40, m23776S());
        flatBufferBuilder.m21498a(41, m23777T());
        flatBufferBuilder.m21507b(42, a11);
        flatBufferBuilder.m21496a(43, m23779V() == GraphQLLiveVideoSubscriptionStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE ? null : m23779V());
        flatBufferBuilder.m21495a(44, m23780W(), 0);
        flatBufferBuilder.m21492a(45, m23781X(), 0.0d);
        flatBufferBuilder.m21507b(46, b5);
        flatBufferBuilder.m21507b(47, a12);
        flatBufferBuilder.m21507b(48, b6);
        flatBufferBuilder.m21507b(49, c3);
        flatBufferBuilder.m21507b(50, a13);
        flatBufferBuilder.m21507b(52, a14);
        flatBufferBuilder.m21507b(53, a15);
        flatBufferBuilder.m21507b(54, a16);
        flatBufferBuilder.m21507b(55, a17);
        flatBufferBuilder.m21507b(56, a18);
        flatBufferBuilder.m21507b(57, a19);
        flatBufferBuilder.m21495a(58, aj(), 0);
        flatBufferBuilder.m21498a(59, ak());
        flatBufferBuilder.m21507b(60, b7);
        flatBufferBuilder.m21507b(61, b8);
        flatBufferBuilder.m21496a(62, an() == GraphQLSecondarySubscribeStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE ? null : an());
        flatBufferBuilder.m21507b(63, a20);
        flatBufferBuilder.m21507b(64, a21);
        flatBufferBuilder.m21507b(65, a22);
        flatBufferBuilder.m21507b(66, a23);
        flatBufferBuilder.m21507b(67, a24);
        flatBufferBuilder.m21496a(68, at() == GraphQLSubscribeStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE ? null : at());
        flatBufferBuilder.m21507b(69, a25);
        flatBufferBuilder.m21494a(71, av(), 0);
        flatBufferBuilder.m21507b(72, b9);
        flatBufferBuilder.m21507b(73, b10);
        flatBufferBuilder.m21498a(74, ay());
        flatBufferBuilder.m21507b(75, a26);
        flatBufferBuilder.m21498a(76, aA());
        flatBufferBuilder.m21498a(77, aB());
        flatBufferBuilder.m21494a(78, aC(), 0);
        flatBufferBuilder.m21494a(79, aD(), 0);
        flatBufferBuilder.m21507b(80, a27);
        flatBufferBuilder.m21507b(81, a28);
        flatBufferBuilder.m21498a(82, aG());
        flatBufferBuilder.m21492a(83, aH(), 0.0d);
        flatBufferBuilder.m21498a(84, aI());
        flatBufferBuilder.m21498a(85, aJ());
        flatBufferBuilder.m21507b(86, b11);
        flatBufferBuilder.m21507b(89, a29);
        flatBufferBuilder.m21498a(90, aM());
        m9959i();
        return flatBufferBuilder.m21511d();
    }

    public GraphQLActor(Parcel parcel) {
        boolean z;
        boolean z2 = true;
        super(92);
        this.f16837e = (GraphQLPageAdminInfo) parcel.readValue(GraphQLPageAdminInfo.class.getClassLoader());
        this.f16838f = parcel.readString();
        this.f16839g = (GraphQLAppStoreApplication) parcel.readValue(GraphQLAppStoreApplication.class.getClassLoader());
        this.f16840h = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.f16841i = (GraphQLFriendsConnection) parcel.readValue(GraphQLFriendsConnection.class.getClassLoader());
        this.f16842j = parcel.readByte() == (byte) 1;
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.f16843k = z;
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.f16844l = z;
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.f16845m = z;
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.f16846n = z;
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.f16847o = z;
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.f16848p = z;
        this.f16849q = ImmutableListHelper.m21625a(parcel.readArrayList(String.class.getClassLoader()));
        this.f16850r = parcel.readDouble();
        this.f16851s = (GraphQLFocusedPhoto) parcel.readValue(GraphQLFocusedPhoto.class.getClassLoader());
        this.f16852t = (GraphQLPage) parcel.readValue(GraphQLPage.class.getClassLoader());
        this.f16853u = parcel.readString();
        this.f16854v = ImmutableListHelper.m21625a(parcel.readArrayList(String.class.getClassLoader()));
        this.f16855w = parcel.readString();
        this.f16856x = (GraphQLEventsConnection) parcel.readValue(GraphQLEventsConnection.class.getClassLoader());
        this.f16857y = (GraphQLFriendsConnection) parcel.readValue(GraphQLFriendsConnection.class.getClassLoader());
        this.f16858z = GraphQLFriendshipStatus.fromString(parcel.readString());
        this.f16810A = GraphQLGender.fromString(parcel.readString());
        this.f16811B = (GraphQLPage) parcel.readValue(GraphQLPage.class.getClassLoader());
        this.f16812C = parcel.readString();
        this.f16813D = parcel.readByte() == (byte) 1;
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.f16814E = z;
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.f16815F = z;
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.f16816G = z;
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.f16817H = z;
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.f16818I = z;
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.f16819J = z;
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.f16820K = z;
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.f16821L = z;
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.f16822M = z;
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.aH = z;
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.f16823N = z;
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.f16824O = z;
        this.f16825P = (GraphQLLikedProfilesConnection) parcel.readValue(GraphQLLikedProfilesConnection.class.getClassLoader());
        this.f16826Q = GraphQLLiveVideoSubscriptionStatus.fromString(parcel.readString());
        this.f16827R = parcel.readLong();
        this.f16828S = parcel.readDouble();
        this.f16829T = parcel.readString();
        this.f16830U = (GraphQLMutualFriendsConnection) parcel.readValue(GraphQLMutualFriendsConnection.class.getClassLoader());
        this.f16831V = parcel.readString();
        this.f16832W = ImmutableListHelper.m21625a(parcel.readArrayList(String.class.getClassLoader()));
        this.f16833X = (GraphQLNewsFeedConnection) parcel.readValue(GraphQLNewsFeedConnection.class.getClassLoader());
        this.f16834Y = (GraphQLPageLikersConnection) parcel.readValue(GraphQLPageLikersConnection.class.getClassLoader());
        this.f16835Z = (GraphQLPrivacyScope) parcel.readValue(GraphQLPrivacyScope.class.getClassLoader());
        this.aa = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.ab = (GraphQLProfileBadge) parcel.readValue(GraphQLProfileBadge.class.getClassLoader());
        this.ac = (GraphQLPhoto) parcel.readValue(GraphQLPhoto.class.getClassLoader());
        this.ad = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.ae = parcel.readLong();
        this.af = parcel.readByte() == (byte) 1;
        this.aG = (GraphQLProfileVideo) parcel.readValue(GraphQLProfileVideo.class.getClassLoader());
        this.ag = parcel.readString();
        this.ah = parcel.readString();
        this.ai = GraphQLSecondarySubscribeStatus.fromString(parcel.readString());
        this.aF = parcel.readString();
        this.aj = (GraphQLSinglePublisherVideoChannelsConnection) parcel.readValue(GraphQLSinglePublisherVideoChannelsConnection.class.getClassLoader());
        this.ak = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.al = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.am = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.an = (GraphQLName) parcel.readValue(GraphQLName.class.getClassLoader());
        this.ao = GraphQLSubscribeStatus.fromString(parcel.readString());
        this.ap = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.aq = parcel.readInt();
        this.ar = parcel.readString();
        this.as = parcel.readString();
        this.at = parcel.readByte() == (byte) 1;
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.aE = z;
        this.au = (GraphQLProfile) parcel.readValue(GraphQLProfile.class.getClassLoader());
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.av = z;
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.aD = z;
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.aw = z;
        this.ax = parcel.readInt();
        this.ay = parcel.readInt();
        this.az = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.aA = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        if (parcel.readByte() != (byte) 1) {
            z2 = false;
        }
        this.aB = z2;
        this.aC = parcel.readDouble();
        this.f16836d = (GraphQLObjectType) ParcelUtil.b(parcel, GraphQLObjectType.class);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int i2;
        int i3 = 1;
        parcel.writeValue(m23791j());
        parcel.writeString(m23792k());
        parcel.writeValue(m23793l());
        parcel.writeValue(m23794m());
        parcel.writeValue(m23795n());
        parcel.writeByte((byte) (m23796o() ? 1 : 0));
        if (m23797p()) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        if (m23798q()) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        if (m23799r()) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        if (m23800s()) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        if (m23801t()) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        if (m23802u()) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        parcel.writeList(m23803v());
        parcel.writeDouble(m23804w());
        parcel.writeValue(m23805x());
        parcel.writeValue(m23806y());
        parcel.writeString(m23807z());
        parcel.writeList(m23758A());
        parcel.writeString(m23759B());
        parcel.writeValue(m23760C());
        parcel.writeValue(m23761D());
        parcel.writeString(m23762E().name());
        parcel.writeString(m23763F().name());
        parcel.writeValue(m23764G());
        parcel.writeString(m23765H());
        parcel.writeByte((byte) (m23766I() ? 1 : 0));
        if (m23767J()) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        if (m23768K()) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        if (m23769L()) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        if (m23770M()) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        if (m23771N()) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        if (m23772O()) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        if (m23773P()) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        if (m23774Q()) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        if (m23775R()) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        if (aM()) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        if (m23776S()) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        if (m23777T()) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        parcel.writeValue(m23778U());
        parcel.writeString(m23779V().name());
        parcel.writeLong(m23780W());
        parcel.writeDouble(m23781X());
        parcel.writeString(m23782Y());
        parcel.writeValue(m23783Z());
        parcel.writeString(aa());
        parcel.writeList(ab());
        parcel.writeValue(ac());
        parcel.writeValue(ad());
        parcel.writeValue(ae());
        parcel.writeValue(af());
        parcel.writeValue(ag());
        parcel.writeValue(ah());
        parcel.writeValue(ai());
        parcel.writeLong(aj());
        parcel.writeByte((byte) (ak() ? 1 : 0));
        parcel.writeValue(aL());
        parcel.writeString(al());
        parcel.writeString(am());
        parcel.writeString(an().name());
        parcel.writeString(aK());
        parcel.writeValue(ao());
        parcel.writeValue(ap());
        parcel.writeValue(aq());
        parcel.writeValue(ar());
        parcel.writeValue(as());
        parcel.writeString(at().name());
        parcel.writeValue(au());
        parcel.writeInt(av());
        parcel.writeString(aw());
        parcel.writeString(ax());
        parcel.writeByte((byte) (ay() ? 1 : 0));
        if (aJ()) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        parcel.writeValue(az());
        if (aA()) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        if (aI()) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        if (aB()) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        parcel.writeInt(aC());
        parcel.writeInt(aD());
        parcel.writeValue(aE());
        parcel.writeValue(aF());
        if (!aG()) {
            i3 = 0;
        }
        parcel.writeByte((byte) i3);
        parcel.writeDouble(aH());
        parcel.writeParcelable(this.f16836d, i);
    }

    public GraphQLActor(Builder builder) {
        super(92);
        this.b = builder.f15736a;
        this.c = builder.f15737b;
        this.f16837e = builder.d;
        this.f16838f = builder.e;
        this.f16839g = builder.f;
        this.f16840h = builder.g;
        this.f16841i = builder.h;
        this.f16842j = builder.i;
        this.f16843k = builder.j;
        this.f16844l = builder.k;
        this.f16845m = builder.l;
        this.f16846n = builder.m;
        this.f16847o = builder.n;
        this.f16848p = builder.o;
        this.f16849q = builder.p;
        this.f16850r = builder.q;
        this.f16851s = builder.r;
        this.f16852t = builder.s;
        this.f16853u = builder.t;
        this.f16854v = builder.u;
        this.f16855w = builder.v;
        this.f16856x = builder.w;
        this.f16857y = builder.x;
        this.f16858z = builder.y;
        this.f16810A = builder.z;
        this.f16811B = builder.A;
        this.f16812C = builder.B;
        this.f16813D = builder.C;
        this.f16814E = builder.D;
        this.f16815F = builder.E;
        this.f16816G = builder.F;
        this.f16817H = builder.G;
        this.f16818I = builder.H;
        this.f16819J = builder.I;
        this.f16820K = builder.J;
        this.f16821L = builder.K;
        this.f16822M = builder.L;
        this.aH = builder.M;
        this.f16823N = builder.N;
        this.f16824O = builder.O;
        this.f16825P = builder.P;
        this.f16826Q = builder.Q;
        this.f16827R = builder.R;
        this.f16828S = builder.S;
        this.f16829T = builder.T;
        this.f16830U = builder.U;
        this.f16831V = builder.V;
        this.f16832W = builder.W;
        this.f16833X = builder.X;
        this.f16834Y = builder.Y;
        this.f16835Z = builder.Z;
        this.aa = builder.aa;
        this.ab = builder.ab;
        this.ac = builder.ac;
        this.ad = builder.ad;
        this.ae = builder.ae;
        this.af = builder.af;
        this.aG = builder.ag;
        this.ag = builder.ah;
        this.ah = builder.ai;
        this.ai = builder.aj;
        this.aF = builder.ak;
        this.aj = builder.al;
        this.ak = builder.am;
        this.al = builder.an;
        this.am = builder.ao;
        this.an = builder.ap;
        this.ao = builder.aq;
        this.ap = builder.ar;
        this.aq = builder.as;
        this.ar = builder.at;
        this.as = builder.au;
        this.at = builder.av;
        this.aE = builder.aw;
        this.au = builder.ax;
        this.av = builder.ay;
        this.aD = builder.az;
        this.aw = builder.aA;
        this.ax = builder.aB;
        this.ay = builder.aC;
        this.az = builder.aD;
        this.aA = builder.aE;
        this.aB = builder.aF;
        this.aC = builder.aG;
        this.f16836d = builder.aH;
    }
}
