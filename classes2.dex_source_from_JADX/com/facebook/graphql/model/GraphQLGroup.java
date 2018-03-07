package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.json.AutoGenJsonSerializer;
import com.facebook.dracula.api.FieldOffset;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.flatbuffers.MutableFlattenable;
import com.facebook.graphql.enums.GraphQLGroupAdminType;
import com.facebook.graphql.enums.GraphQLGroupCategory;
import com.facebook.graphql.enums.GraphQLGroupContentRestrictionReason;
import com.facebook.graphql.enums.GraphQLGroupJoinApprovalSetting;
import com.facebook.graphql.enums.GraphQLGroupJoinState;
import com.facebook.graphql.enums.GraphQLGroupPostPermissionSetting;
import com.facebook.graphql.enums.GraphQLGroupPostStatus;
import com.facebook.graphql.enums.GraphQLGroupPushSubscriptionLevel;
import com.facebook.graphql.enums.GraphQLGroupRequestToJoinSubscriptionLevel;
import com.facebook.graphql.enums.GraphQLGroupSubscriptionLevel;
import com.facebook.graphql.enums.GraphQLGroupVisibility;
import com.facebook.graphql.enums.GraphQLLeavingGroupScenario;
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
import com.google.common.collect.ImmutableList.Builder;
import com.instagram.common.json.annotation.JsonType;
import java.util.List;
import javax.annotation.Nullable;

@AutoGenJsonDeserializer
@AutoGenJsonSerializer
@Deprecated
@JsonType
/* compiled from: logVideoCompleteEvent */
public final class GraphQLGroup extends BaseModel implements TypeModel, GraphQLPersistableNode, GraphQLVisitableConsistentModel {
    public static final Creator<GraphQLGroup> CREATOR = new 1();
    public boolean f16415A;
    boolean f16416B;
    @Nullable
    String f16417C;
    @Nullable
    GraphQLImage f16418D;
    @Deprecated
    @Nullable
    GraphQLInlineActivitiesConnection f16419E;
    boolean f16420F;
    boolean f16421G;
    public GraphQLGroupJoinApprovalSetting f16422H;
    long f16423I;
    @Nullable
    public String f16424J;
    List<String> f16425K;
    @Nullable
    GraphQLGroup f16426L;
    @Nullable
    GraphQLFocusedPhoto f16427M;
    public GraphQLGroupPostPermissionSetting f16428N;
    @Nullable
    GraphQLPrivacyScope f16429O;
    GraphQLGroupVisibility f16430P;
    int f16431Q;
    @Nullable
    GraphQLImage f16432R;
    @Nullable
    GraphQLImage f16433S;
    @Nullable
    GraphQLImage f16434T;
    @Nullable
    GraphQLImage f16435U;
    @Nullable
    GraphQLImage f16436V;
    @Nullable
    GraphQLPhoto f16437W;
    @Nullable
    GraphQLImage f16438X;
    @Nullable
    GraphQLImage f16439Y;
    @Nullable
    GraphQLImage f16440Z;
    @Nullable
    GraphQLTextWithEntities aA;
    List<GraphQLGroupContentRestrictionReason> aB;
    public GraphQLGroupJoinState aC;
    long aD;
    GraphQLLeavingGroupScenario aE;
    GraphQLGroupPostStatus aF;
    public GraphQLGroupPushSubscriptionLevel aG;
    GraphQLGroupRequestToJoinSubscriptionLevel aH;
    public GraphQLGroupSubscriptionLevel aI;
    public GraphQLGroupVisibility aJ;
    @Nullable
    GraphQLTextWithEntities aK;
    @Nullable
    GraphQLImage aL;
    GraphQLGroupAdminType aM;
    @Nullable
    GraphQLGroupConfigurationsConnection aN;
    @Nullable
    GraphQLAYMTChannel aO;
    boolean aP;
    List<GraphQLPage> aQ;
    @Nullable
    GraphQLImage aa;
    boolean ab;
    public boolean ac;
    public boolean ad;
    boolean ae;
    @Nullable
    GraphQLFocusedPhoto af;
    boolean ag;
    @Nullable
    GraphQLTextWithEntities ah;
    @Nullable
    GraphQLStreamingImage ai;
    public GraphQLSubscribeStatus aj;
    @Nullable
    GraphQLImage ak;
    @Nullable
    GraphQLGroupMembersConnection al;
    @Nullable
    GraphQLFocusedPhoto am;
    int an;
    @Nullable
    String ao;
    @Deprecated
    @Nullable
    String ap;
    boolean aq;
    boolean ar;
    @Nullable
    GraphQLProfile as;
    boolean at;
    public boolean au;
    public boolean av;
    boolean aw;
    int ax;
    int ay;
    @Nullable
    GraphQLTextWithEntities az;
    @Nullable
    GraphQLGroup f16441d;
    @Nullable
    GraphQLFocusedPhoto f16442e;
    @Nullable
    GraphQLImage f16443f;
    boolean f16444g;
    boolean f16445h;
    public boolean f16446i;
    boolean f16447j;
    @Deprecated
    boolean f16448k;
    GraphQLGroupCategory f16449l;
    @Nullable
    GraphQLFocusedPhoto f16450m;
    @Nullable
    String f16451n;
    @Nullable
    public String f16452o;
    long f16453p;
    @Nullable
    GraphQLImage f16454q;
    @Nullable
    String f16455r;
    @Nullable
    GraphQLFocusedPhoto f16456s;
    @Deprecated
    @Nullable
    GraphQLFocusedPhoto f16457t;
    @Nullable
    GraphQLImage f16458u;
    @Nullable
    GraphQLMediaSet f16459v;
    @Nullable
    GraphQLGroupMembersConnection f16460w;
    @Deprecated
    int f16461x;
    @Nullable
    GraphQLGroupOwnerAuthoredStoriesConnection f16462y;
    @Nullable
    GraphQLImage f16463z;

    @FieldOffset
    @Nullable
    public final GraphQLGroup m23299j() {
        this.f16441d = (GraphQLGroup) super.m9947a(this.f16441d, 0, GraphQLGroup.class);
        return this.f16441d;
    }

    @FieldOffset
    @Nullable
    public final GraphQLFocusedPhoto m23300k() {
        this.f16442e = (GraphQLFocusedPhoto) super.m9947a(this.f16442e, 1, GraphQLFocusedPhoto.class);
        return this.f16442e;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m23301l() {
        this.f16443f = (GraphQLImage) super.m9947a(this.f16443f, 2, GraphQLImage.class);
        return this.f16443f;
    }

    @FieldOffset
    public final boolean m23302m() {
        m9949a(0, 3);
        return this.f16444g;
    }

    @FieldOffset
    public final boolean m23303n() {
        m9949a(0, 4);
        return this.f16445h;
    }

    @FieldOffset
    public final boolean m23304o() {
        m9949a(0, 5);
        return this.f16446i;
    }

    @FieldOffset
    public final boolean m23305p() {
        m9949a(0, 6);
        return this.f16447j;
    }

    @FieldOffset
    public final boolean m23306q() {
        m9949a(0, 7);
        return this.f16448k;
    }

    @FieldOffset
    public final GraphQLGroupCategory m23307r() {
        this.f16449l = (GraphQLGroupCategory) super.m9945a(this.f16449l, 8, GraphQLGroupCategory.class, GraphQLGroupCategory.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
        return this.f16449l;
    }

    @FieldOffset
    @Nullable
    public final GraphQLFocusedPhoto m23308s() {
        this.f16450m = (GraphQLFocusedPhoto) super.m9947a(this.f16450m, 9, GraphQLFocusedPhoto.class);
        return this.f16450m;
    }

    @FieldOffset
    @Nullable
    public final String m23309t() {
        this.f16451n = super.m9948a(this.f16451n, 10);
        return this.f16451n;
    }

    @FieldOffset
    @Nullable
    public final String m23310u() {
        this.f16452o = super.m9948a(this.f16452o, 11);
        return this.f16452o;
    }

    @FieldOffset
    public final long m23311v() {
        m9949a(1, 4);
        return this.f16453p;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m23312w() {
        this.f16454q = (GraphQLImage) super.m9947a(this.f16454q, 13, GraphQLImage.class);
        return this.f16454q;
    }

    @FieldOffset
    @Nullable
    public final String m23313x() {
        this.f16455r = super.m9948a(this.f16455r, 14);
        return this.f16455r;
    }

    @FieldOffset
    @Nullable
    public final GraphQLFocusedPhoto m23314y() {
        this.f16456s = (GraphQLFocusedPhoto) super.m9947a(this.f16456s, 15, GraphQLFocusedPhoto.class);
        return this.f16456s;
    }

    @FieldOffset
    @Nullable
    public final GraphQLFocusedPhoto m23315z() {
        this.f16457t = (GraphQLFocusedPhoto) super.m9947a(this.f16457t, 16, GraphQLFocusedPhoto.class);
        return this.f16457t;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m23267A() {
        this.f16458u = (GraphQLImage) super.m9947a(this.f16458u, 17, GraphQLImage.class);
        return this.f16458u;
    }

    @FieldOffset
    @Nullable
    public final GraphQLMediaSet m23268B() {
        this.f16459v = (GraphQLMediaSet) super.m9947a(this.f16459v, 18, GraphQLMediaSet.class);
        return this.f16459v;
    }

    @FieldOffset
    @Nullable
    public final GraphQLGroupMembersConnection m23269C() {
        this.f16460w = (GraphQLGroupMembersConnection) super.m9947a(this.f16460w, 19, GraphQLGroupMembersConnection.class);
        return this.f16460w;
    }

    @FieldOffset
    public final int m23270D() {
        m9949a(2, 4);
        return this.f16461x;
    }

    @FieldOffset
    @Nullable
    public final GraphQLGroupOwnerAuthoredStoriesConnection m23271E() {
        this.f16462y = (GraphQLGroupOwnerAuthoredStoriesConnection) super.m9947a(this.f16462y, 21, GraphQLGroupOwnerAuthoredStoriesConnection.class);
        return this.f16462y;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m23272F() {
        this.f16463z = (GraphQLImage) super.m9947a(this.f16463z, 22, GraphQLImage.class);
        return this.f16463z;
    }

    @FieldOffset
    public final boolean m23273G() {
        m9949a(2, 7);
        return this.f16415A;
    }

    @FieldOffset
    public final boolean m23274H() {
        m9949a(3, 0);
        return this.f16416B;
    }

    @FieldOffset
    @Nullable
    public final String m23275I() {
        this.f16417C = super.m9948a(this.f16417C, 25);
        return this.f16417C;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m23276J() {
        this.f16418D = (GraphQLImage) super.m9947a(this.f16418D, 26, GraphQLImage.class);
        return this.f16418D;
    }

    @FieldOffset
    @Nullable
    public final GraphQLInlineActivitiesConnection m23277K() {
        this.f16419E = (GraphQLInlineActivitiesConnection) super.m9947a(this.f16419E, 27, GraphQLInlineActivitiesConnection.class);
        return this.f16419E;
    }

    @FieldOffset
    public final boolean m23278L() {
        m9949a(3, 4);
        return this.f16420F;
    }

    @FieldOffset
    public final boolean m23279M() {
        m9949a(3, 6);
        return this.f16421G;
    }

    @FieldOffset
    public final GraphQLGroupJoinApprovalSetting m23280N() {
        this.f16422H = (GraphQLGroupJoinApprovalSetting) super.m9945a(this.f16422H, 31, GraphQLGroupJoinApprovalSetting.class, GraphQLGroupJoinApprovalSetting.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
        return this.f16422H;
    }

    @FieldOffset
    public final long m23281O() {
        m9949a(4, 0);
        return this.f16423I;
    }

    @FieldOffset
    @Nullable
    public final String m23282P() {
        this.f16424J = super.m9948a(this.f16424J, 33);
        return this.f16424J;
    }

    @FieldOffset
    public final ImmutableList<String> m23283Q() {
        this.f16425K = super.m9943a(this.f16425K, 34);
        return (ImmutableList) this.f16425K;
    }

    @FieldOffset
    @Nullable
    public final GraphQLGroup m23284R() {
        this.f16426L = (GraphQLGroup) super.m9947a(this.f16426L, 35, GraphQLGroup.class);
        return this.f16426L;
    }

    @FieldOffset
    @Nullable
    public final GraphQLFocusedPhoto m23285S() {
        this.f16427M = (GraphQLFocusedPhoto) super.m9947a(this.f16427M, 36, GraphQLFocusedPhoto.class);
        return this.f16427M;
    }

    @FieldOffset
    public final GraphQLGroupPostPermissionSetting m23286T() {
        this.f16428N = (GraphQLGroupPostPermissionSetting) super.m9945a(this.f16428N, 38, GraphQLGroupPostPermissionSetting.class, GraphQLGroupPostPermissionSetting.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
        return this.f16428N;
    }

    @FieldOffset
    @Nullable
    public final GraphQLPrivacyScope m23287U() {
        this.f16429O = (GraphQLPrivacyScope) super.m9947a(this.f16429O, 39, GraphQLPrivacyScope.class);
        return this.f16429O;
    }

    @FieldOffset
    public final GraphQLGroupVisibility m23288V() {
        this.f16430P = (GraphQLGroupVisibility) super.m9945a(this.f16430P, 40, GraphQLGroupVisibility.class, GraphQLGroupVisibility.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
        return this.f16430P;
    }

    @FieldOffset
    public final int m23289W() {
        m9949a(5, 1);
        return this.f16431Q;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m23290X() {
        this.f16432R = (GraphQLImage) super.m9947a(this.f16432R, 42, GraphQLImage.class);
        return this.f16432R;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m23291Y() {
        this.f16433S = (GraphQLImage) super.m9947a(this.f16433S, 43, GraphQLImage.class);
        return this.f16433S;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m23292Z() {
        this.f16434T = (GraphQLImage) super.m9947a(this.f16434T, 44, GraphQLImage.class);
        return this.f16434T;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage aa() {
        this.f16435U = (GraphQLImage) super.m9947a(this.f16435U, 45, GraphQLImage.class);
        return this.f16435U;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage ab() {
        this.f16436V = (GraphQLImage) super.m9947a(this.f16436V, 46, GraphQLImage.class);
        return this.f16436V;
    }

    @FieldOffset
    @Nullable
    public final GraphQLPhoto ac() {
        this.f16437W = (GraphQLPhoto) super.m9947a(this.f16437W, 47, GraphQLPhoto.class);
        return this.f16437W;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage ad() {
        this.f16438X = (GraphQLImage) super.m9947a(this.f16438X, 48, GraphQLImage.class);
        return this.f16438X;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage ae() {
        this.f16439Y = (GraphQLImage) super.m9947a(this.f16439Y, 49, GraphQLImage.class);
        return this.f16439Y;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage af() {
        this.f16440Z = (GraphQLImage) super.m9947a(this.f16440Z, 50, GraphQLImage.class);
        return this.f16440Z;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage ag() {
        this.aa = (GraphQLImage) super.m9947a(this.aa, 51, GraphQLImage.class);
        return this.aa;
    }

    @FieldOffset
    public final boolean ah() {
        m9949a(6, 4);
        return this.ab;
    }

    @FieldOffset
    public final boolean ai() {
        m9949a(6, 5);
        return this.ac;
    }

    @FieldOffset
    public final boolean aj() {
        m9949a(6, 6);
        return this.ad;
    }

    @FieldOffset
    public final boolean ak() {
        m9949a(6, 7);
        return this.ae;
    }

    @FieldOffset
    @Nullable
    public final GraphQLFocusedPhoto al() {
        this.af = (GraphQLFocusedPhoto) super.m9947a(this.af, 56, GraphQLFocusedPhoto.class);
        return this.af;
    }

    @FieldOffset
    public final boolean am() {
        m9949a(7, 1);
        return this.ag;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities an() {
        this.ah = (GraphQLTextWithEntities) super.m9947a(this.ah, 58, GraphQLTextWithEntities.class);
        return this.ah;
    }

    @FieldOffset
    @Nullable
    public final GraphQLStreamingImage ao() {
        this.ai = (GraphQLStreamingImage) super.m9947a(this.ai, 59, GraphQLStreamingImage.class);
        return this.ai;
    }

    @FieldOffset
    public final GraphQLSubscribeStatus ap() {
        this.aj = (GraphQLSubscribeStatus) super.m9945a(this.aj, 60, GraphQLSubscribeStatus.class, GraphQLSubscribeStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
        return this.aj;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage aq() {
        this.ak = (GraphQLImage) super.m9947a(this.ak, 62, GraphQLImage.class);
        return this.ak;
    }

    @FieldOffset
    @Nullable
    public final GraphQLGroupMembersConnection ar() {
        this.al = (GraphQLGroupMembersConnection) super.m9947a(this.al, 63, GraphQLGroupMembersConnection.class);
        return this.al;
    }

    @FieldOffset
    @Nullable
    public final GraphQLFocusedPhoto as() {
        this.am = (GraphQLFocusedPhoto) super.m9947a(this.am, 64, GraphQLFocusedPhoto.class);
        return this.am;
    }

    @FieldOffset
    public final int at() {
        m9949a(8, 1);
        return this.an;
    }

    @FieldOffset
    @Nullable
    public final String au() {
        this.ao = super.m9948a(this.ao, 66);
        return this.ao;
    }

    @FieldOffset
    @Nullable
    public final String av() {
        this.ap = super.m9948a(this.ap, 67);
        return this.ap;
    }

    @FieldOffset
    public final boolean aw() {
        m9949a(8, 4);
        return this.aq;
    }

    @FieldOffset
    public final boolean ax() {
        m9949a(8, 5);
        return this.ar;
    }

    @FieldOffset
    @Nullable
    public final GraphQLProfile ay() {
        this.as = (GraphQLProfile) super.m9947a(this.as, 70, GraphQLProfile.class);
        return this.as;
    }

    @FieldOffset
    public final boolean az() {
        m9949a(8, 7);
        return this.at;
    }

    @FieldOffset
    public final boolean aA() {
        m9949a(9, 0);
        return this.au;
    }

    @FieldOffset
    public final boolean aB() {
        m9949a(9, 1);
        return this.av;
    }

    @FieldOffset
    public final boolean aC() {
        m9949a(9, 2);
        return this.aw;
    }

    @FieldOffset
    public final int aD() {
        m9949a(9, 3);
        return this.ax;
    }

    @FieldOffset
    public final int aE() {
        m9949a(9, 4);
        return this.ay;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities aF() {
        this.az = (GraphQLTextWithEntities) super.m9947a(this.az, 77, GraphQLTextWithEntities.class);
        return this.az;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities aG() {
        this.aA = (GraphQLTextWithEntities) super.m9947a(this.aA, 78, GraphQLTextWithEntities.class);
        return this.aA;
    }

    @FieldOffset
    public final ImmutableList<GraphQLGroupContentRestrictionReason> aH() {
        this.aB = super.m9953b(this.aB, 79, GraphQLGroupContentRestrictionReason.class);
        return (ImmutableList) this.aB;
    }

    @FieldOffset
    public final GraphQLGroupJoinState aI() {
        this.aC = (GraphQLGroupJoinState) super.m9945a(this.aC, 80, GraphQLGroupJoinState.class, GraphQLGroupJoinState.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
        return this.aC;
    }

    @FieldOffset
    public final long aJ() {
        m9949a(10, 1);
        return this.aD;
    }

    @FieldOffset
    public final GraphQLLeavingGroupScenario aK() {
        this.aE = (GraphQLLeavingGroupScenario) super.m9945a(this.aE, 82, GraphQLLeavingGroupScenario.class, GraphQLLeavingGroupScenario.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
        return this.aE;
    }

    @FieldOffset
    public final GraphQLGroupPostStatus aL() {
        this.aF = (GraphQLGroupPostStatus) super.m9945a(this.aF, 83, GraphQLGroupPostStatus.class, GraphQLGroupPostStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
        return this.aF;
    }

    @FieldOffset
    public final GraphQLGroupPushSubscriptionLevel aM() {
        this.aG = (GraphQLGroupPushSubscriptionLevel) super.m9945a(this.aG, 84, GraphQLGroupPushSubscriptionLevel.class, GraphQLGroupPushSubscriptionLevel.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
        return this.aG;
    }

    @FieldOffset
    public final GraphQLGroupRequestToJoinSubscriptionLevel aN() {
        this.aH = (GraphQLGroupRequestToJoinSubscriptionLevel) super.m9945a(this.aH, 85, GraphQLGroupRequestToJoinSubscriptionLevel.class, GraphQLGroupRequestToJoinSubscriptionLevel.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
        return this.aH;
    }

    @FieldOffset
    public final GraphQLGroupSubscriptionLevel aO() {
        this.aI = (GraphQLGroupSubscriptionLevel) super.m9945a(this.aI, 86, GraphQLGroupSubscriptionLevel.class, GraphQLGroupSubscriptionLevel.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
        return this.aI;
    }

    @FieldOffset
    public final GraphQLGroupVisibility aP() {
        this.aJ = (GraphQLGroupVisibility) super.m9945a(this.aJ, 87, GraphQLGroupVisibility.class, GraphQLGroupVisibility.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
        return this.aJ;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities aQ() {
        this.aK = (GraphQLTextWithEntities) super.m9947a(this.aK, 88, GraphQLTextWithEntities.class);
        return this.aK;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage aR() {
        this.aL = (GraphQLImage) super.m9947a(this.aL, 89, GraphQLImage.class);
        return this.aL;
    }

    @FieldOffset
    public final GraphQLGroupAdminType aS() {
        this.aM = (GraphQLGroupAdminType) super.m9945a(this.aM, 90, GraphQLGroupAdminType.class, GraphQLGroupAdminType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
        return this.aM;
    }

    @FieldOffset
    @Nullable
    public final GraphQLGroupConfigurationsConnection aT() {
        this.aN = (GraphQLGroupConfigurationsConnection) super.m9947a(this.aN, 91, GraphQLGroupConfigurationsConnection.class);
        return this.aN;
    }

    @FieldOffset
    @Nullable
    public final GraphQLAYMTChannel aU() {
        this.aO = (GraphQLAYMTChannel) super.m9947a(this.aO, 92, GraphQLAYMTChannel.class);
        return this.aO;
    }

    @FieldOffset
    public final boolean aV() {
        m9949a(11, 5);
        return this.aP;
    }

    @FieldOffset
    public final ImmutableList<GraphQLPage> aW() {
        this.aQ = super.m9944a(this.aQ, 94, GraphQLPage.class);
        return (ImmutableList) this.aQ;
    }

    @Nullable
    public final String mo2834a() {
        return m23275I();
    }

    public final int jK_() {
        return 69076575;
    }

    public final GraphQLVisitableModel mo1404a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLGroup graphQLGroup;
        GraphQLFocusedPhoto graphQLFocusedPhoto;
        GraphQLImage graphQLImage;
        GraphQLGroupMembersConnection graphQLGroupMembersConnection;
        GraphQLTextWithEntities graphQLTextWithEntities;
        GraphQLVisitableModel graphQLVisitableModel = null;
        m9958h();
        if (m23299j() != null) {
            graphQLGroup = (GraphQLGroup) graphQLModelMutatingVisitor.mo2928b(m23299j());
            if (m23299j() != graphQLGroup) {
                graphQLVisitableModel = (GraphQLGroup) ModelHelper.m23095a(null, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16441d = graphQLGroup;
            }
        }
        if (m23300k() != null) {
            graphQLFocusedPhoto = (GraphQLFocusedPhoto) graphQLModelMutatingVisitor.mo2928b(m23300k());
            if (m23300k() != graphQLFocusedPhoto) {
                graphQLVisitableModel = (GraphQLGroup) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16442e = graphQLFocusedPhoto;
            }
        }
        if (m23301l() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(m23301l());
            if (m23301l() != graphQLImage) {
                graphQLVisitableModel = (GraphQLGroup) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16443f = graphQLImage;
            }
        }
        if (m23308s() != null) {
            graphQLFocusedPhoto = (GraphQLFocusedPhoto) graphQLModelMutatingVisitor.mo2928b(m23308s());
            if (m23308s() != graphQLFocusedPhoto) {
                graphQLVisitableModel = (GraphQLGroup) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16450m = graphQLFocusedPhoto;
            }
        }
        if (m23312w() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(m23312w());
            if (m23312w() != graphQLImage) {
                graphQLVisitableModel = (GraphQLGroup) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16454q = graphQLImage;
            }
        }
        if (m23314y() != null) {
            graphQLFocusedPhoto = (GraphQLFocusedPhoto) graphQLModelMutatingVisitor.mo2928b(m23314y());
            if (m23314y() != graphQLFocusedPhoto) {
                graphQLVisitableModel = (GraphQLGroup) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16456s = graphQLFocusedPhoto;
            }
        }
        if (aT() != null) {
            GraphQLGroupConfigurationsConnection graphQLGroupConfigurationsConnection = (GraphQLGroupConfigurationsConnection) graphQLModelMutatingVisitor.mo2928b(aT());
            if (aT() != graphQLGroupConfigurationsConnection) {
                graphQLVisitableModel = (GraphQLGroup) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.aN = graphQLGroupConfigurationsConnection;
            }
        }
        if (m23315z() != null) {
            graphQLFocusedPhoto = (GraphQLFocusedPhoto) graphQLModelMutatingVisitor.mo2928b(m23315z());
            if (m23315z() != graphQLFocusedPhoto) {
                graphQLVisitableModel = (GraphQLGroup) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16457t = graphQLFocusedPhoto;
            }
        }
        if (m23267A() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(m23267A());
            if (m23267A() != graphQLImage) {
                graphQLVisitableModel = (GraphQLGroup) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16458u = graphQLImage;
            }
        }
        if (m23268B() != null) {
            GraphQLMediaSet graphQLMediaSet = (GraphQLMediaSet) graphQLModelMutatingVisitor.mo2928b(m23268B());
            if (m23268B() != graphQLMediaSet) {
                graphQLVisitableModel = (GraphQLGroup) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16459v = graphQLMediaSet;
            }
        }
        if (m23269C() != null) {
            graphQLGroupMembersConnection = (GraphQLGroupMembersConnection) graphQLModelMutatingVisitor.mo2928b(m23269C());
            if (m23269C() != graphQLGroupMembersConnection) {
                graphQLVisitableModel = (GraphQLGroup) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16460w = graphQLGroupMembersConnection;
            }
        }
        if (m23271E() != null) {
            GraphQLGroupOwnerAuthoredStoriesConnection graphQLGroupOwnerAuthoredStoriesConnection = (GraphQLGroupOwnerAuthoredStoriesConnection) graphQLModelMutatingVisitor.mo2928b(m23271E());
            if (m23271E() != graphQLGroupOwnerAuthoredStoriesConnection) {
                graphQLVisitableModel = (GraphQLGroup) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16462y = graphQLGroupOwnerAuthoredStoriesConnection;
            }
        }
        if (m23272F() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(m23272F());
            if (m23272F() != graphQLImage) {
                graphQLVisitableModel = (GraphQLGroup) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16463z = graphQLImage;
            }
        }
        if (aW() != null) {
            Builder a = ModelHelper.m23097a(aW(), graphQLModelMutatingVisitor);
            if (a != null) {
                graphQLGroup = (GraphQLGroup) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLGroup.aQ = a.m1068b();
                graphQLVisitableModel = graphQLGroup;
            }
        }
        if (m23276J() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(m23276J());
            if (m23276J() != graphQLImage) {
                graphQLVisitableModel = (GraphQLGroup) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16418D = graphQLImage;
            }
        }
        if (m23277K() != null) {
            GraphQLInlineActivitiesConnection graphQLInlineActivitiesConnection = (GraphQLInlineActivitiesConnection) graphQLModelMutatingVisitor.mo2928b(m23277K());
            if (m23277K() != graphQLInlineActivitiesConnection) {
                graphQLVisitableModel = (GraphQLGroup) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16419E = graphQLInlineActivitiesConnection;
            }
        }
        if (m23284R() != null) {
            graphQLGroup = (GraphQLGroup) graphQLModelMutatingVisitor.mo2928b(m23284R());
            if (m23284R() != graphQLGroup) {
                graphQLVisitableModel = (GraphQLGroup) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16426L = graphQLGroup;
            }
        }
        if (m23285S() != null) {
            graphQLFocusedPhoto = (GraphQLFocusedPhoto) graphQLModelMutatingVisitor.mo2928b(m23285S());
            if (m23285S() != graphQLFocusedPhoto) {
                graphQLVisitableModel = (GraphQLGroup) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16427M = graphQLFocusedPhoto;
            }
        }
        if (m23287U() != null) {
            GraphQLPrivacyScope graphQLPrivacyScope = (GraphQLPrivacyScope) graphQLModelMutatingVisitor.mo2928b(m23287U());
            if (m23287U() != graphQLPrivacyScope) {
                graphQLVisitableModel = (GraphQLGroup) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16429O = graphQLPrivacyScope;
            }
        }
        if (m23290X() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(m23290X());
            if (m23290X() != graphQLImage) {
                graphQLVisitableModel = (GraphQLGroup) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16432R = graphQLImage;
            }
        }
        if (m23291Y() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(m23291Y());
            if (m23291Y() != graphQLImage) {
                graphQLVisitableModel = (GraphQLGroup) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16433S = graphQLImage;
            }
        }
        if (m23292Z() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(m23292Z());
            if (m23292Z() != graphQLImage) {
                graphQLVisitableModel = (GraphQLGroup) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16434T = graphQLImage;
            }
        }
        if (aa() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(aa());
            if (aa() != graphQLImage) {
                graphQLVisitableModel = (GraphQLGroup) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16435U = graphQLImage;
            }
        }
        if (ab() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(ab());
            if (ab() != graphQLImage) {
                graphQLVisitableModel = (GraphQLGroup) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16436V = graphQLImage;
            }
        }
        if (ac() != null) {
            GraphQLPhoto graphQLPhoto = (GraphQLPhoto) graphQLModelMutatingVisitor.mo2928b(ac());
            if (ac() != graphQLPhoto) {
                graphQLVisitableModel = (GraphQLGroup) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16437W = graphQLPhoto;
            }
        }
        if (ad() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(ad());
            if (ad() != graphQLImage) {
                graphQLVisitableModel = (GraphQLGroup) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16438X = graphQLImage;
            }
        }
        if (ae() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(ae());
            if (ae() != graphQLImage) {
                graphQLVisitableModel = (GraphQLGroup) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16439Y = graphQLImage;
            }
        }
        if (af() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(af());
            if (af() != graphQLImage) {
                graphQLVisitableModel = (GraphQLGroup) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16440Z = graphQLImage;
            }
        }
        if (ag() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(ag());
            if (ag() != graphQLImage) {
                graphQLVisitableModel = (GraphQLGroup) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.aa = graphQLImage;
            }
        }
        if (al() != null) {
            graphQLFocusedPhoto = (GraphQLFocusedPhoto) graphQLModelMutatingVisitor.mo2928b(al());
            if (al() != graphQLFocusedPhoto) {
                graphQLVisitableModel = (GraphQLGroup) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.af = graphQLFocusedPhoto;
            }
        }
        if (an() != null) {
            graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.mo2928b(an());
            if (an() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLGroup) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.ah = graphQLTextWithEntities;
            }
        }
        if (ao() != null) {
            GraphQLStreamingImage graphQLStreamingImage = (GraphQLStreamingImage) graphQLModelMutatingVisitor.mo2928b(ao());
            if (ao() != graphQLStreamingImage) {
                graphQLVisitableModel = (GraphQLGroup) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.ai = graphQLStreamingImage;
            }
        }
        if (aq() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(aq());
            if (aq() != graphQLImage) {
                graphQLVisitableModel = (GraphQLGroup) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.ak = graphQLImage;
            }
        }
        if (aU() != null) {
            GraphQLAYMTChannel graphQLAYMTChannel = (GraphQLAYMTChannel) graphQLModelMutatingVisitor.mo2928b(aU());
            if (aU() != graphQLAYMTChannel) {
                graphQLVisitableModel = (GraphQLGroup) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.aO = graphQLAYMTChannel;
            }
        }
        if (ar() != null) {
            graphQLGroupMembersConnection = (GraphQLGroupMembersConnection) graphQLModelMutatingVisitor.mo2928b(ar());
            if (ar() != graphQLGroupMembersConnection) {
                graphQLVisitableModel = (GraphQLGroup) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.al = graphQLGroupMembersConnection;
            }
        }
        if (as() != null) {
            graphQLFocusedPhoto = (GraphQLFocusedPhoto) graphQLModelMutatingVisitor.mo2928b(as());
            if (as() != graphQLFocusedPhoto) {
                graphQLVisitableModel = (GraphQLGroup) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.am = graphQLFocusedPhoto;
            }
        }
        if (ay() != null) {
            GraphQLProfile graphQLProfile = (GraphQLProfile) graphQLModelMutatingVisitor.mo2928b(ay());
            if (ay() != graphQLProfile) {
                graphQLVisitableModel = (GraphQLGroup) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.as = graphQLProfile;
            }
        }
        if (aF() != null) {
            graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.mo2928b(aF());
            if (aF() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLGroup) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.az = graphQLTextWithEntities;
            }
        }
        if (aG() != null) {
            graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.mo2928b(aG());
            if (aG() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLGroup) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.aA = graphQLTextWithEntities;
            }
        }
        if (aQ() != null) {
            graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.mo2928b(aQ());
            if (aQ() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLGroup) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.aK = graphQLTextWithEntities;
            }
        }
        if (aR() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(aR());
            if (aR() != graphQLImage) {
                graphQLVisitableModel = (GraphQLGroup) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.aL = graphQLImage;
            }
        }
        m9959i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public final void mo2835a(String str, ConsistencyTuple consistencyTuple) {
        if ("can_viewer_claim_adminship".equals(str)) {
            consistencyTuple.f18727a = Boolean.valueOf(m23304o());
            consistencyTuple.f18728b = u_();
            consistencyTuple.f18729c = 5;
        } else if ("description".equals(str)) {
            consistencyTuple.f18727a = m23310u();
            consistencyTuple.f18728b = u_();
            consistencyTuple.f18729c = 11;
        } else {
            BaseModel E;
            if ("group_owner_authored_stories.available_for_sale_count".equals(str)) {
                E = m23271E();
                if (E != null) {
                    consistencyTuple.f18727a = Integer.valueOf(E.m24312a());
                    consistencyTuple.f18728b = E.u_();
                    consistencyTuple.f18729c = 0;
                    return;
                }
            } else if ("group_owner_authored_stories.total_for_sale_count".equals(str)) {
                E = m23271E();
                if (E != null) {
                    consistencyTuple.f18727a = Integer.valueOf(E.m24320l());
                    consistencyTuple.f18728b = E.u_();
                    consistencyTuple.f18729c = 3;
                    return;
                }
            } else if ("has_viewer_favorited".equals(str)) {
                consistencyTuple.f18727a = Boolean.valueOf(m23273G());
                consistencyTuple.f18728b = u_();
                consistencyTuple.f18729c = 23;
                return;
            } else if ("join_approval_setting".equals(str)) {
                consistencyTuple.f18727a = m23280N();
                consistencyTuple.f18728b = u_();
                consistencyTuple.f18729c = 31;
                return;
            } else if ("name".equals(str)) {
                consistencyTuple.f18727a = m23282P();
                consistencyTuple.f18728b = u_();
                consistencyTuple.f18729c = 33;
                return;
            } else if ("post_permission_setting".equals(str)) {
                consistencyTuple.f18727a = m23286T();
                consistencyTuple.f18728b = u_();
                consistencyTuple.f18729c = 38;
                return;
            } else if ("requires_admin_membership_approval".equals(str)) {
                consistencyTuple.f18727a = Boolean.valueOf(ai());
                consistencyTuple.f18728b = u_();
                consistencyTuple.f18729c = 53;
                return;
            } else if ("requires_post_approval".equals(str)) {
                consistencyTuple.f18727a = Boolean.valueOf(aj());
                consistencyTuple.f18728b = u_();
                consistencyTuple.f18729c = 54;
                return;
            } else if ("subscribe_status".equals(str)) {
                consistencyTuple.f18727a = ap();
                consistencyTuple.f18728b = u_();
                consistencyTuple.f18729c = 60;
                return;
            } else if ("video_channel_has_viewer_subscribed".equals(str)) {
                consistencyTuple.f18727a = Boolean.valueOf(aA());
                consistencyTuple.f18728b = u_();
                consistencyTuple.f18729c = 72;
                return;
            } else if ("video_channel_is_viewer_following".equals(str)) {
                consistencyTuple.f18727a = Boolean.valueOf(aB());
                consistencyTuple.f18728b = u_();
                consistencyTuple.f18729c = 73;
                return;
            } else if ("viewer_join_state".equals(str)) {
                consistencyTuple.f18727a = aI();
                consistencyTuple.f18728b = u_();
                consistencyTuple.f18729c = 80;
                return;
            } else if ("viewer_push_subscription_level".equals(str)) {
                consistencyTuple.f18727a = aM();
                consistencyTuple.f18728b = u_();
                consistencyTuple.f18729c = 84;
                return;
            } else if ("viewer_subscription_level".equals(str)) {
                consistencyTuple.f18727a = aO();
                consistencyTuple.f18728b = u_();
                consistencyTuple.f18729c = 86;
                return;
            } else if ("visibility".equals(str)) {
                consistencyTuple.f18727a = aP();
                consistencyTuple.f18728b = u_();
                consistencyTuple.f18729c = 87;
                return;
            }
            consistencyTuple.m26322a();
        }
    }

    public final void mo2836a(String str, Object obj, boolean z) {
        boolean booleanValue;
        if ("can_viewer_claim_adminship".equals(str)) {
            booleanValue = ((Boolean) obj).booleanValue();
            this.f16446i = booleanValue;
            if (this.f5823b != null && this.f5823b.f15024d) {
                this.f5823b.m21538a(this.f5824c, 5, booleanValue);
            }
        } else if ("description".equals(str)) {
            r8 = (String) obj;
            this.f16452o = r8;
            if (this.f5823b != null && this.f5823b.f15024d) {
                this.f5823b.m21537a(this.f5824c, 11, r8);
            }
        } else if ("group_owner_authored_stories.available_for_sale_count".equals(str)) {
            r0 = m23271E();
            if (r0 == null) {
                return;
            }
            if (z) {
                r0 = (GraphQLGroupOwnerAuthoredStoriesConnection) r0.clone();
                r0.mo2908a(((Integer) obj).intValue());
                this.f16462y = r0;
                return;
            }
            r0.mo2908a(((Integer) obj).intValue());
        } else if ("group_owner_authored_stories.total_for_sale_count".equals(str)) {
            r0 = m23271E();
            if (r0 == null) {
                return;
            }
            if (z) {
                r0 = (GraphQLGroupOwnerAuthoredStoriesConnection) r0.clone();
                r0.m24317b(((Integer) obj).intValue());
                this.f16462y = r0;
                return;
            }
            r0.m24317b(((Integer) obj).intValue());
        } else if ("has_viewer_favorited".equals(str)) {
            booleanValue = ((Boolean) obj).booleanValue();
            this.f16415A = booleanValue;
            if (this.f5823b != null && this.f5823b.f15024d) {
                this.f5823b.m21538a(this.f5824c, 23, booleanValue);
            }
        } else if ("join_approval_setting".equals(str)) {
            r8 = (GraphQLGroupJoinApprovalSetting) obj;
            this.f16422H = r8;
            if (this.f5823b != null && this.f5823b.f15024d) {
                this.f5823b.m21536a(this.f5824c, 31, r8);
            }
        } else if ("name".equals(str)) {
            r8 = (String) obj;
            this.f16424J = r8;
            if (this.f5823b != null && this.f5823b.f15024d) {
                this.f5823b.m21537a(this.f5824c, 33, r8);
            }
        } else if ("post_permission_setting".equals(str)) {
            r8 = (GraphQLGroupPostPermissionSetting) obj;
            this.f16428N = r8;
            if (this.f5823b != null && this.f5823b.f15024d) {
                this.f5823b.m21536a(this.f5824c, 38, r8);
            }
        } else if ("requires_admin_membership_approval".equals(str)) {
            booleanValue = ((Boolean) obj).booleanValue();
            this.ac = booleanValue;
            if (this.f5823b != null && this.f5823b.f15024d) {
                this.f5823b.m21538a(this.f5824c, 53, booleanValue);
            }
        } else if ("requires_post_approval".equals(str)) {
            booleanValue = ((Boolean) obj).booleanValue();
            this.ad = booleanValue;
            if (this.f5823b != null && this.f5823b.f15024d) {
                this.f5823b.m21538a(this.f5824c, 54, booleanValue);
            }
        } else if ("subscribe_status".equals(str)) {
            r8 = (GraphQLSubscribeStatus) obj;
            this.aj = r8;
            if (this.f5823b != null && this.f5823b.f15024d) {
                this.f5823b.m21536a(this.f5824c, 60, r8);
            }
        } else if ("video_channel_has_viewer_subscribed".equals(str)) {
            booleanValue = ((Boolean) obj).booleanValue();
            this.au = booleanValue;
            if (this.f5823b != null && this.f5823b.f15024d) {
                this.f5823b.m21538a(this.f5824c, 72, booleanValue);
            }
        } else if ("video_channel_is_viewer_following".equals(str)) {
            booleanValue = ((Boolean) obj).booleanValue();
            this.av = booleanValue;
            if (this.f5823b != null && this.f5823b.f15024d) {
                this.f5823b.m21538a(this.f5824c, 73, booleanValue);
            }
        } else if ("viewer_join_state".equals(str)) {
            r8 = (GraphQLGroupJoinState) obj;
            this.aC = r8;
            if (this.f5823b != null && this.f5823b.f15024d) {
                this.f5823b.m21536a(this.f5824c, 80, r8);
            }
        } else if ("viewer_push_subscription_level".equals(str)) {
            r8 = (GraphQLGroupPushSubscriptionLevel) obj;
            this.aG = r8;
            if (this.f5823b != null && this.f5823b.f15024d) {
                this.f5823b.m21536a(this.f5824c, 84, r8);
            }
        } else if ("viewer_subscription_level".equals(str)) {
            r8 = (GraphQLGroupSubscriptionLevel) obj;
            this.aI = r8;
            if (this.f5823b != null && this.f5823b.f15024d) {
                this.f5823b.m21536a(this.f5824c, 86, r8);
            }
        } else if ("visibility".equals(str)) {
            r8 = (GraphQLGroupVisibility) obj;
            this.aJ = r8;
            if (this.f5823b != null && this.f5823b.f15024d) {
                this.f5823b.m21536a(this.f5824c, 87, r8);
            }
        }
    }

    public GraphQLGroup() {
        super(96);
    }

    public final void mo1406a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.mo1406a(mutableFlatBuffer, i, obj);
        this.f16444g = mutableFlatBuffer.m21540a(i, 3);
        this.f16445h = mutableFlatBuffer.m21540a(i, 4);
        this.f16446i = mutableFlatBuffer.m21540a(i, 5);
        this.f16447j = mutableFlatBuffer.m21540a(i, 6);
        this.f16448k = mutableFlatBuffer.m21540a(i, 7);
        this.f16453p = mutableFlatBuffer.m21525a(i, 12, 0);
        this.f16461x = mutableFlatBuffer.m21524a(i, 20, 0);
        this.f16415A = mutableFlatBuffer.m21540a(i, 23);
        this.f16416B = mutableFlatBuffer.m21540a(i, 24);
        this.f16420F = mutableFlatBuffer.m21540a(i, 28);
        this.f16421G = mutableFlatBuffer.m21540a(i, 30);
        this.f16423I = mutableFlatBuffer.m21525a(i, 32, 0);
        this.f16431Q = mutableFlatBuffer.m21524a(i, 41, 0);
        this.ab = mutableFlatBuffer.m21540a(i, 52);
        this.ac = mutableFlatBuffer.m21540a(i, 53);
        this.ad = mutableFlatBuffer.m21540a(i, 54);
        this.ae = mutableFlatBuffer.m21540a(i, 55);
        this.ag = mutableFlatBuffer.m21540a(i, 57);
        this.an = mutableFlatBuffer.m21524a(i, 65, 0);
        this.aq = mutableFlatBuffer.m21540a(i, 68);
        this.ar = mutableFlatBuffer.m21540a(i, 69);
        this.at = mutableFlatBuffer.m21540a(i, 71);
        this.au = mutableFlatBuffer.m21540a(i, 72);
        this.av = mutableFlatBuffer.m21540a(i, 73);
        this.aw = mutableFlatBuffer.m21540a(i, 74);
        this.ax = mutableFlatBuffer.m21524a(i, 75, 0);
        this.ay = mutableFlatBuffer.m21524a(i, 76, 0);
        this.aD = mutableFlatBuffer.m21525a(i, 81, 0);
        this.aP = mutableFlatBuffer.m21540a(i, 93);
    }

    public final int mo1403a(FlatBufferBuilder flatBufferBuilder) {
        m9958h();
        int a = ModelHelper.m23093a(flatBufferBuilder, m23299j());
        int a2 = ModelHelper.m23093a(flatBufferBuilder, m23300k());
        int a3 = ModelHelper.m23093a(flatBufferBuilder, m23301l());
        int a4 = ModelHelper.m23093a(flatBufferBuilder, m23308s());
        int b = flatBufferBuilder.m21502b(m23309t());
        int b2 = flatBufferBuilder.m21502b(m23310u());
        int a5 = ModelHelper.m23093a(flatBufferBuilder, m23312w());
        int b3 = flatBufferBuilder.m21502b(m23313x());
        int a6 = ModelHelper.m23093a(flatBufferBuilder, m23314y());
        int a7 = ModelHelper.m23093a(flatBufferBuilder, m23315z());
        int a8 = ModelHelper.m23093a(flatBufferBuilder, m23267A());
        int a9 = ModelHelper.m23093a(flatBufferBuilder, m23268B());
        int a10 = ModelHelper.m23093a(flatBufferBuilder, m23269C());
        int a11 = ModelHelper.m23093a(flatBufferBuilder, m23271E());
        int a12 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) m23272F());
        int b4 = flatBufferBuilder.m21502b(m23275I());
        int a13 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) m23276J());
        int a14 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) m23277K());
        int b5 = flatBufferBuilder.m21502b(m23282P());
        int c = flatBufferBuilder.m21509c((List) m23283Q());
        int a15 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) m23284R());
        int a16 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) m23285S());
        int a17 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) m23287U());
        int a18 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) m23290X());
        int a19 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) m23291Y());
        int a20 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) m23292Z());
        int a21 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) aa());
        int a22 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) ab());
        int a23 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) ac());
        int a24 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) ad());
        int a25 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) ae());
        int a26 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) af());
        int a27 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) ag());
        int a28 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) al());
        int a29 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) an());
        int a30 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) ao());
        int a31 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) aq());
        int a32 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) ar());
        int a33 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) as());
        int b6 = flatBufferBuilder.m21502b(au());
        int b7 = flatBufferBuilder.m21502b(av());
        int a34 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) ay());
        int a35 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) aF());
        int a36 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) aG());
        int e = flatBufferBuilder.m21514e((List) aH());
        int a37 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) aQ());
        int a38 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) aR());
        int a39 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) aT());
        int a40 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) aU());
        int a41 = ModelHelper.m23094a(flatBufferBuilder, (List) aW());
        flatBufferBuilder.m21510c(95);
        flatBufferBuilder.m21507b(0, a);
        flatBufferBuilder.m21507b(1, a2);
        flatBufferBuilder.m21507b(2, a3);
        flatBufferBuilder.m21498a(3, m23302m());
        flatBufferBuilder.m21498a(4, m23303n());
        flatBufferBuilder.m21498a(5, m23304o());
        flatBufferBuilder.m21498a(6, m23305p());
        flatBufferBuilder.m21498a(7, m23306q());
        flatBufferBuilder.m21496a(8, m23307r() == GraphQLGroupCategory.UNSET_OR_UNRECOGNIZED_ENUM_VALUE ? null : m23307r());
        flatBufferBuilder.m21507b(9, a4);
        flatBufferBuilder.m21507b(10, b);
        flatBufferBuilder.m21507b(11, b2);
        flatBufferBuilder.m21495a(12, m23311v(), 0);
        flatBufferBuilder.m21507b(13, a5);
        flatBufferBuilder.m21507b(14, b3);
        flatBufferBuilder.m21507b(15, a6);
        flatBufferBuilder.m21507b(16, a7);
        flatBufferBuilder.m21507b(17, a8);
        flatBufferBuilder.m21507b(18, a9);
        flatBufferBuilder.m21507b(19, a10);
        flatBufferBuilder.m21494a(20, m23270D(), 0);
        flatBufferBuilder.m21507b(21, a11);
        flatBufferBuilder.m21507b(22, a12);
        flatBufferBuilder.m21498a(23, m23273G());
        flatBufferBuilder.m21498a(24, m23274H());
        flatBufferBuilder.m21507b(25, b4);
        flatBufferBuilder.m21507b(26, a13);
        flatBufferBuilder.m21507b(27, a14);
        flatBufferBuilder.m21498a(28, m23278L());
        flatBufferBuilder.m21498a(30, m23279M());
        flatBufferBuilder.m21496a(31, m23280N() == GraphQLGroupJoinApprovalSetting.UNSET_OR_UNRECOGNIZED_ENUM_VALUE ? null : m23280N());
        flatBufferBuilder.m21495a(32, m23281O(), 0);
        flatBufferBuilder.m21507b(33, b5);
        flatBufferBuilder.m21507b(34, c);
        flatBufferBuilder.m21507b(35, a15);
        flatBufferBuilder.m21507b(36, a16);
        flatBufferBuilder.m21496a(38, m23286T() == GraphQLGroupPostPermissionSetting.UNSET_OR_UNRECOGNIZED_ENUM_VALUE ? null : m23286T());
        flatBufferBuilder.m21507b(39, a17);
        flatBufferBuilder.m21496a(40, m23288V() == GraphQLGroupVisibility.UNSET_OR_UNRECOGNIZED_ENUM_VALUE ? null : m23288V());
        flatBufferBuilder.m21494a(41, m23289W(), 0);
        flatBufferBuilder.m21507b(42, a18);
        flatBufferBuilder.m21507b(43, a19);
        flatBufferBuilder.m21507b(44, a20);
        flatBufferBuilder.m21507b(45, a21);
        flatBufferBuilder.m21507b(46, a22);
        flatBufferBuilder.m21507b(47, a23);
        flatBufferBuilder.m21507b(48, a24);
        flatBufferBuilder.m21507b(49, a25);
        flatBufferBuilder.m21507b(50, a26);
        flatBufferBuilder.m21507b(51, a27);
        flatBufferBuilder.m21498a(52, ah());
        flatBufferBuilder.m21498a(53, ai());
        flatBufferBuilder.m21498a(54, aj());
        flatBufferBuilder.m21498a(55, ak());
        flatBufferBuilder.m21507b(56, a28);
        flatBufferBuilder.m21498a(57, am());
        flatBufferBuilder.m21507b(58, a29);
        flatBufferBuilder.m21507b(59, a30);
        flatBufferBuilder.m21496a(60, ap() == GraphQLSubscribeStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE ? null : ap());
        flatBufferBuilder.m21507b(62, a31);
        flatBufferBuilder.m21507b(63, a32);
        flatBufferBuilder.m21507b(64, a33);
        flatBufferBuilder.m21494a(65, at(), 0);
        flatBufferBuilder.m21507b(66, b6);
        flatBufferBuilder.m21507b(67, b7);
        flatBufferBuilder.m21498a(68, aw());
        flatBufferBuilder.m21498a(69, ax());
        flatBufferBuilder.m21507b(70, a34);
        flatBufferBuilder.m21498a(71, az());
        flatBufferBuilder.m21498a(72, aA());
        flatBufferBuilder.m21498a(73, aB());
        flatBufferBuilder.m21498a(74, aC());
        flatBufferBuilder.m21494a(75, aD(), 0);
        flatBufferBuilder.m21494a(76, aE(), 0);
        flatBufferBuilder.m21507b(77, a35);
        flatBufferBuilder.m21507b(78, a36);
        flatBufferBuilder.m21507b(79, e);
        flatBufferBuilder.m21496a(80, aI() == GraphQLGroupJoinState.UNSET_OR_UNRECOGNIZED_ENUM_VALUE ? null : aI());
        flatBufferBuilder.m21495a(81, aJ(), 0);
        flatBufferBuilder.m21496a(82, aK() == GraphQLLeavingGroupScenario.UNSET_OR_UNRECOGNIZED_ENUM_VALUE ? null : aK());
        flatBufferBuilder.m21496a(83, aL() == GraphQLGroupPostStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE ? null : aL());
        flatBufferBuilder.m21496a(84, aM() == GraphQLGroupPushSubscriptionLevel.UNSET_OR_UNRECOGNIZED_ENUM_VALUE ? null : aM());
        flatBufferBuilder.m21496a(85, aN() == GraphQLGroupRequestToJoinSubscriptionLevel.UNSET_OR_UNRECOGNIZED_ENUM_VALUE ? null : aN());
        flatBufferBuilder.m21496a(86, aO() == GraphQLGroupSubscriptionLevel.UNSET_OR_UNRECOGNIZED_ENUM_VALUE ? null : aO());
        flatBufferBuilder.m21496a(87, aP() == GraphQLGroupVisibility.UNSET_OR_UNRECOGNIZED_ENUM_VALUE ? null : aP());
        flatBufferBuilder.m21507b(88, a37);
        flatBufferBuilder.m21507b(89, a38);
        flatBufferBuilder.m21496a(90, aS() == GraphQLGroupAdminType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE ? null : aS());
        flatBufferBuilder.m21507b(91, a39);
        flatBufferBuilder.m21507b(92, a40);
        flatBufferBuilder.m21498a(93, aV());
        flatBufferBuilder.m21507b(94, a41);
        m9959i();
        return flatBufferBuilder.m21511d();
    }

    public GraphQLGroup(Parcel parcel) {
        boolean z;
        boolean z2 = true;
        super(96);
        this.f16441d = (GraphQLGroup) parcel.readValue(GraphQLGroup.class.getClassLoader());
        this.f16442e = (GraphQLFocusedPhoto) parcel.readValue(GraphQLFocusedPhoto.class.getClassLoader());
        this.f16443f = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f16444g = parcel.readByte() == (byte) 1;
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.f16445h = z;
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.f16446i = z;
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.f16447j = z;
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.f16448k = z;
        this.f16449l = GraphQLGroupCategory.fromString(parcel.readString());
        this.f16450m = (GraphQLFocusedPhoto) parcel.readValue(GraphQLFocusedPhoto.class.getClassLoader());
        this.f16451n = parcel.readString();
        this.f16452o = parcel.readString();
        this.f16453p = parcel.readLong();
        this.f16454q = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f16455r = parcel.readString();
        this.f16456s = (GraphQLFocusedPhoto) parcel.readValue(GraphQLFocusedPhoto.class.getClassLoader());
        this.aN = (GraphQLGroupConfigurationsConnection) parcel.readValue(GraphQLGroupConfigurationsConnection.class.getClassLoader());
        this.f16457t = (GraphQLFocusedPhoto) parcel.readValue(GraphQLFocusedPhoto.class.getClassLoader());
        this.f16458u = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f16459v = (GraphQLMediaSet) parcel.readValue(GraphQLMediaSet.class.getClassLoader());
        this.f16460w = (GraphQLGroupMembersConnection) parcel.readValue(GraphQLGroupMembersConnection.class.getClassLoader());
        this.f16461x = parcel.readInt();
        this.f16462y = (GraphQLGroupOwnerAuthoredStoriesConnection) parcel.readValue(GraphQLGroupOwnerAuthoredStoriesConnection.class.getClassLoader());
        this.f16463z = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.aQ = ImmutableListHelper.m21625a(parcel.readArrayList(GraphQLPage.class.getClassLoader()));
        this.f16415A = parcel.readByte() == (byte) 1;
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.f16416B = z;
        this.f16417C = parcel.readString();
        this.f16418D = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f16419E = (GraphQLInlineActivitiesConnection) parcel.readValue(GraphQLInlineActivitiesConnection.class.getClassLoader());
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.f16420F = z;
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.aP = z;
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.f16421G = z;
        this.f16422H = GraphQLGroupJoinApprovalSetting.fromString(parcel.readString());
        this.f16423I = parcel.readLong();
        this.f16424J = parcel.readString();
        this.f16425K = ImmutableListHelper.m21625a(parcel.readArrayList(String.class.getClassLoader()));
        this.f16426L = (GraphQLGroup) parcel.readValue(GraphQLGroup.class.getClassLoader());
        this.f16427M = (GraphQLFocusedPhoto) parcel.readValue(GraphQLFocusedPhoto.class.getClassLoader());
        this.f16428N = GraphQLGroupPostPermissionSetting.fromString(parcel.readString());
        this.f16429O = (GraphQLPrivacyScope) parcel.readValue(GraphQLPrivacyScope.class.getClassLoader());
        this.f16430P = GraphQLGroupVisibility.fromString(parcel.readString());
        this.f16431Q = parcel.readInt();
        this.f16432R = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f16433S = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f16434T = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f16435U = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f16436V = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f16437W = (GraphQLPhoto) parcel.readValue(GraphQLPhoto.class.getClassLoader());
        this.f16438X = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f16439Y = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f16440Z = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.aa = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.ab = parcel.readByte() == (byte) 1;
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.ac = z;
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.ad = z;
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.ae = z;
        this.af = (GraphQLFocusedPhoto) parcel.readValue(GraphQLFocusedPhoto.class.getClassLoader());
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.ag = z;
        this.ah = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.ai = (GraphQLStreamingImage) parcel.readValue(GraphQLStreamingImage.class.getClassLoader());
        this.aj = GraphQLSubscribeStatus.fromString(parcel.readString());
        this.ak = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.aO = (GraphQLAYMTChannel) parcel.readValue(GraphQLAYMTChannel.class.getClassLoader());
        this.al = (GraphQLGroupMembersConnection) parcel.readValue(GraphQLGroupMembersConnection.class.getClassLoader());
        this.am = (GraphQLFocusedPhoto) parcel.readValue(GraphQLFocusedPhoto.class.getClassLoader());
        this.an = parcel.readInt();
        this.ao = parcel.readString();
        this.ap = parcel.readString();
        this.aq = parcel.readByte() == (byte) 1;
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.ar = z;
        this.as = (GraphQLProfile) parcel.readValue(GraphQLProfile.class.getClassLoader());
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.at = z;
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.au = z;
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.av = z;
        if (parcel.readByte() != (byte) 1) {
            z2 = false;
        }
        this.aw = z2;
        this.ax = parcel.readInt();
        this.ay = parcel.readInt();
        this.az = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.aA = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.aM = GraphQLGroupAdminType.fromString(parcel.readString());
        this.aB = ImmutableListHelper.m21625a(parcel.readArrayList(GraphQLGroupContentRestrictionReason.class.getClassLoader()));
        this.aC = GraphQLGroupJoinState.fromString(parcel.readString());
        this.aD = parcel.readLong();
        this.aE = GraphQLLeavingGroupScenario.fromString(parcel.readString());
        this.aF = GraphQLGroupPostStatus.fromString(parcel.readString());
        this.aG = GraphQLGroupPushSubscriptionLevel.fromString(parcel.readString());
        this.aH = GraphQLGroupRequestToJoinSubscriptionLevel.fromString(parcel.readString());
        this.aI = GraphQLGroupSubscriptionLevel.fromString(parcel.readString());
        this.aJ = GraphQLGroupVisibility.fromString(parcel.readString());
        this.aK = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.aL = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int i2;
        int i3 = 1;
        parcel.writeValue(m23299j());
        parcel.writeValue(m23300k());
        parcel.writeValue(m23301l());
        parcel.writeByte((byte) (m23302m() ? 1 : 0));
        if (m23303n()) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        if (m23304o()) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        if (m23305p()) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        if (m23306q()) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        parcel.writeString(m23307r().name());
        parcel.writeValue(m23308s());
        parcel.writeString(m23309t());
        parcel.writeString(m23310u());
        parcel.writeLong(m23311v());
        parcel.writeValue(m23312w());
        parcel.writeString(m23313x());
        parcel.writeValue(m23314y());
        parcel.writeValue(aT());
        parcel.writeValue(m23315z());
        parcel.writeValue(m23267A());
        parcel.writeValue(m23268B());
        parcel.writeValue(m23269C());
        parcel.writeInt(m23270D());
        parcel.writeValue(m23271E());
        parcel.writeValue(m23272F());
        parcel.writeList(aW());
        parcel.writeByte((byte) (m23273G() ? 1 : 0));
        if (m23274H()) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        parcel.writeString(m23275I());
        parcel.writeValue(m23276J());
        parcel.writeValue(m23277K());
        if (m23278L()) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        if (aV()) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        if (m23279M()) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        parcel.writeString(m23280N().name());
        parcel.writeLong(m23281O());
        parcel.writeString(m23282P());
        parcel.writeList(m23283Q());
        parcel.writeValue(m23284R());
        parcel.writeValue(m23285S());
        parcel.writeString(m23286T().name());
        parcel.writeValue(m23287U());
        parcel.writeString(m23288V().name());
        parcel.writeInt(m23289W());
        parcel.writeValue(m23290X());
        parcel.writeValue(m23291Y());
        parcel.writeValue(m23292Z());
        parcel.writeValue(aa());
        parcel.writeValue(ab());
        parcel.writeValue(ac());
        parcel.writeValue(ad());
        parcel.writeValue(ae());
        parcel.writeValue(af());
        parcel.writeValue(ag());
        parcel.writeByte((byte) (ah() ? 1 : 0));
        if (ai()) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        if (aj()) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        if (ak()) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        parcel.writeValue(al());
        if (am()) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        parcel.writeValue(an());
        parcel.writeValue(ao());
        parcel.writeString(ap().name());
        parcel.writeValue(aq());
        parcel.writeValue(aU());
        parcel.writeValue(ar());
        parcel.writeValue(as());
        parcel.writeInt(at());
        parcel.writeString(au());
        parcel.writeString(av());
        parcel.writeByte((byte) (aw() ? 1 : 0));
        if (ax()) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        parcel.writeValue(ay());
        if (az()) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        if (aA()) {
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
        if (!aC()) {
            i3 = 0;
        }
        parcel.writeByte((byte) i3);
        parcel.writeInt(aD());
        parcel.writeInt(aE());
        parcel.writeValue(aF());
        parcel.writeValue(aG());
        parcel.writeString(aS().name());
        parcel.writeList(aH());
        parcel.writeString(aI().name());
        parcel.writeLong(aJ());
        parcel.writeString(aK().name());
        parcel.writeString(aL().name());
        parcel.writeString(aM().name());
        parcel.writeString(aN().name());
        parcel.writeString(aO().name());
        parcel.writeString(aP().name());
        parcel.writeValue(aQ());
        parcel.writeValue(aR());
    }

    public GraphQLGroup(Builder builder) {
        super(96);
        this.b = builder.f15736a;
        this.c = builder.f15737b;
        this.f16441d = builder.d;
        this.f16442e = builder.e;
        this.f16443f = builder.f;
        this.f16444g = builder.g;
        this.f16445h = builder.h;
        this.f16446i = builder.i;
        this.f16447j = builder.j;
        this.f16448k = builder.k;
        this.f16449l = builder.l;
        this.f16450m = builder.m;
        this.f16451n = builder.n;
        this.f16452o = builder.o;
        this.f16453p = builder.p;
        this.f16454q = builder.q;
        this.f16455r = builder.r;
        this.f16456s = builder.s;
        this.aN = builder.t;
        this.f16457t = builder.u;
        this.f16458u = builder.v;
        this.f16459v = builder.w;
        this.f16460w = builder.x;
        this.f16461x = builder.y;
        this.f16462y = builder.z;
        this.f16463z = builder.A;
        this.aQ = builder.B;
        this.f16415A = builder.C;
        this.f16416B = builder.D;
        this.f16417C = builder.E;
        this.f16418D = builder.F;
        this.f16419E = builder.G;
        this.f16420F = builder.H;
        this.aP = builder.I;
        this.f16421G = builder.J;
        this.f16422H = builder.K;
        this.f16423I = builder.L;
        this.f16424J = builder.M;
        this.f16425K = builder.N;
        this.f16426L = builder.O;
        this.f16427M = builder.P;
        this.f16428N = builder.Q;
        this.f16429O = builder.R;
        this.f16430P = builder.S;
        this.f16431Q = builder.T;
        this.f16432R = builder.U;
        this.f16433S = builder.V;
        this.f16434T = builder.W;
        this.f16435U = builder.X;
        this.f16436V = builder.Y;
        this.f16437W = builder.Z;
        this.f16438X = builder.aa;
        this.f16439Y = builder.ab;
        this.f16440Z = builder.ac;
        this.aa = builder.ad;
        this.ab = builder.ae;
        this.ac = builder.af;
        this.ad = builder.ag;
        this.ae = builder.ah;
        this.af = builder.ai;
        this.ag = builder.aj;
        this.ah = builder.ak;
        this.ai = builder.al;
        this.aj = builder.am;
        this.ak = builder.an;
        this.aO = builder.ao;
        this.al = builder.ap;
        this.am = builder.aq;
        this.an = builder.ar;
        this.ao = builder.as;
        this.ap = builder.at;
        this.aq = builder.au;
        this.ar = builder.av;
        this.as = builder.aw;
        this.at = builder.ax;
        this.au = builder.ay;
        this.av = builder.az;
        this.aw = builder.aA;
        this.ax = builder.aB;
        this.ay = builder.aC;
        this.az = builder.aD;
        this.aA = builder.aE;
        this.aM = builder.aF;
        this.aB = builder.aG;
        this.aC = builder.aH;
        this.aD = builder.aI;
        this.aE = builder.aJ;
        this.aF = builder.aK;
        this.aG = builder.aL;
        this.aH = builder.aM;
        this.aI = builder.aN;
        this.aJ = builder.aO;
        this.aK = builder.aP;
        this.aL = builder.aQ;
    }
}
