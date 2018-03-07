package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.json.AutoGenJsonSerializer;
import com.facebook.common.parcels.ParcelUtil;
import com.facebook.dracula.api.FieldOffset;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLCallToActionStyle;
import com.facebook.graphql.enums.GraphQLCallToActionType;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.enums.GraphQLProfilePictureActionLinkType;
import com.facebook.graphql.enums.GraphQLStoryActionLinkDestinationType;
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
/* compiled from: logging_id */
public final class GraphQLStoryActionLink extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLStoryActionLink> CREATOR = new C06951();
    @Nullable
    public String f16046A;
    @Nullable
    public GraphQLGroup f16047B;
    @Nullable
    public GraphQLGroupMessageChattableMembersConnection f16048C;
    @Nullable
    public GraphQLOverlayCallToActionInfo f16049D;
    @Nullable
    public GraphQLNode f16050E;
    @Nullable
    public String f16051F;
    @Nullable
    public String f16052G;
    @Nullable
    public GraphQLLeadGenData f16053H;
    @Nullable
    public String f16054I;
    @Nullable
    public GraphQLLeadGenDeepLinkUserStatus f16055J;
    @Nullable
    public GraphQLLeadGenUserStatus f16056K;
    @Nullable
    public String f16057L;
    @Nullable
    public String f16058M;
    @Nullable
    public GraphQLImage f16059N;
    public GraphQLCallToActionStyle f16060O;
    @Nullable
    public GraphQLLinkTargetStoreData f16061P;
    @Nullable
    public String f16062Q;
    public GraphQLCallToActionType f16063R;
    @Nullable
    public GraphQLImage f16064S;
    @Nullable
    public GraphQLTextWithEntities f16065T;
    @Deprecated
    @Nullable
    public String f16066U;
    @Deprecated
    @Nullable
    public String f16067V;
    @Nullable
    public GraphQLPage f16068W;
    @Nullable
    public GraphQLStory f16069X;
    @Nullable
    public String f16070Y;
    @Deprecated
    @Nullable
    public String f16071Z;
    @Nullable
    public String aA;
    @Nullable
    public String aB;
    @Nullable
    public GraphQLPageOutcomeButton aC;
    @Nullable
    public String aD;
    public List<GraphQLVideoAnnotation> aE;
    @Nullable
    public GraphQLStory aF;
    public List<String> aG;
    public List<String> aH;
    @Nullable
    public String aI;
    public List<String> aJ;
    @Nullable
    public String aK;
    @Nullable
    public GraphQLDocumentElement aL;
    @Nullable
    public GraphQLInstantArticle aM;
    @Nullable
    public String aN;
    @Nullable
    public String aO;
    public int aP;
    @Nullable
    public GraphQLPrivacyScope aa;
    @Nullable
    public String ab;
    @Nullable
    public GraphQLProfile ac;
    @Nullable
    public String ad;
    @Nullable
    public String ae;
    @Nullable
    public GraphQLContactRecommendationField af;
    @Nullable
    public String ag;
    @Nullable
    public String ah;
    @Nullable
    public String ai;
    @Nullable
    public String aj;
    @Nullable
    public String ak;
    @Nullable
    public String al;
    public boolean am;
    public boolean an;
    public boolean ao;
    public boolean ap;
    @Nullable
    public String aq;
    @Nullable
    public String ar;
    @Nullable
    public String as;
    @Nullable
    public GraphQLImageOverlay at;
    @Nullable
    public String au;
    @Nullable
    public GraphQLAppendPostActionLinkTaggedAndMentionedUsersConnection av;
    @Nullable
    public GraphQLTemporalEventInfo aw;
    @Nullable
    public String ax;
    @Nullable
    public GraphQLTopic ay;
    @Nullable
    public String az;
    @Nullable
    public GraphQLObjectType f16072d;
    public GraphQLProfilePictureActionLinkType f16073e;
    @Nullable
    public String f16074f;
    @Nullable
    public String f16075g;
    @Deprecated
    public int f16076h;
    public int f16077i;
    public boolean f16078j;
    public boolean f16079k;
    @Nullable
    public GraphQLTimelineAppCollection f16080l;
    @Nullable
    public GraphQLCoupon f16081m;
    public long f16082n;
    @Nullable
    public GraphQLTextWithEntities f16083o;
    public GraphQLStoryActionLinkDestinationType f16084p;
    @Nullable
    public String f16085q;
    @Nullable
    public String f16086r;
    public List<GraphQLLeadGenErrorNode> f16087s;
    @Nullable
    public String f16088t;
    @Nullable
    public String f16089u;
    @Nullable
    public GraphQLEvent f16090v;
    @Nullable
    public String f16091w;
    @Nullable
    public String f16092x;
    @Nullable
    public GraphQLFeedback f16093y;
    @Nullable
    public String f16094z;

    /* compiled from: logging_id */
    final class C06951 implements Creator<GraphQLStoryActionLink> {
        C06951() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLStoryActionLink(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLStoryActionLink[i];
        }
    }

    @Nullable
    public final GraphQLObjectType m22901a() {
        if (this.f5823b != null && this.f16072d == null) {
            this.f16072d = new GraphQLObjectType(this.f5823b.m21542b(this.f5824c, 0));
        }
        if (this.f16072d == null || this.f16072d.m22301g() != 0) {
            return this.f16072d;
        }
        return null;
    }

    @FieldOffset
    public final GraphQLProfilePictureActionLinkType m22905j() {
        this.f16073e = (GraphQLProfilePictureActionLinkType) super.m9945a(this.f16073e, 1, GraphQLProfilePictureActionLinkType.class, GraphQLProfilePictureActionLinkType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
        return this.f16073e;
    }

    @FieldOffset
    @Nullable
    public final String m22906k() {
        this.f16074f = super.m9948a(this.f16074f, 2);
        return this.f16074f;
    }

    @FieldOffset
    @Nullable
    public final String m22907l() {
        this.f16075g = super.m9948a(this.f16075g, 3);
        return this.f16075g;
    }

    @FieldOffset
    public final int m22908m() {
        m9949a(0, 4);
        return this.f16076h;
    }

    @FieldOffset
    public final int m22909n() {
        m9949a(0, 5);
        return this.f16077i;
    }

    @FieldOffset
    public final boolean m22910o() {
        m9949a(0, 6);
        return this.f16078j;
    }

    @FieldOffset
    public final boolean m22911p() {
        m9949a(0, 7);
        return this.f16079k;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTimelineAppCollection m22912q() {
        this.f16080l = (GraphQLTimelineAppCollection) super.m9947a(this.f16080l, 8, GraphQLTimelineAppCollection.class);
        return this.f16080l;
    }

    @FieldOffset
    @Nullable
    public final GraphQLCoupon m22913r() {
        this.f16081m = (GraphQLCoupon) super.m9947a(this.f16081m, 9, GraphQLCoupon.class);
        return this.f16081m;
    }

    @FieldOffset
    public final long m22914s() {
        m9949a(1, 2);
        return this.f16082n;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities m22915t() {
        this.f16083o = (GraphQLTextWithEntities) super.m9947a(this.f16083o, 11, GraphQLTextWithEntities.class);
        return this.f16083o;
    }

    @FieldOffset
    public final GraphQLStoryActionLinkDestinationType m22916u() {
        this.f16084p = (GraphQLStoryActionLinkDestinationType) super.m9945a(this.f16084p, 12, GraphQLStoryActionLinkDestinationType.class, GraphQLStoryActionLinkDestinationType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
        return this.f16084p;
    }

    @FieldOffset
    @Nullable
    public final String m22917v() {
        this.f16085q = super.m9948a(this.f16085q, 13);
        return this.f16085q;
    }

    @FieldOffset
    @Nullable
    public final String m22918w() {
        this.f16086r = super.m9948a(this.f16086r, 14);
        return this.f16086r;
    }

    @FieldOffset
    public final ImmutableList<GraphQLLeadGenErrorNode> m22919x() {
        this.f16087s = super.m9944a(this.f16087s, 15, GraphQLLeadGenErrorNode.class);
        return (ImmutableList) this.f16087s;
    }

    @FieldOffset
    @Nullable
    public final String m22920y() {
        this.f16088t = super.m9948a(this.f16088t, 16);
        return this.f16088t;
    }

    @FieldOffset
    @Nullable
    public final String m22921z() {
        this.f16089u = super.m9948a(this.f16089u, 17);
        return this.f16089u;
    }

    @FieldOffset
    @Nullable
    public final GraphQLEvent m22874A() {
        this.f16090v = (GraphQLEvent) super.m9947a(this.f16090v, 18, GraphQLEvent.class);
        return this.f16090v;
    }

    @FieldOffset
    @Nullable
    public final String m22875B() {
        this.f16091w = super.m9948a(this.f16091w, 19);
        return this.f16091w;
    }

    @FieldOffset
    @Nullable
    public final String m22876C() {
        this.f16092x = super.m9948a(this.f16092x, 20);
        return this.f16092x;
    }

    @FieldOffset
    @Nullable
    public final GraphQLFeedback m22877D() {
        this.f16093y = (GraphQLFeedback) super.m9947a(this.f16093y, 21, GraphQLFeedback.class);
        return this.f16093y;
    }

    @FieldOffset
    @Nullable
    public final String m22878E() {
        this.f16094z = super.m9948a(this.f16094z, 22);
        return this.f16094z;
    }

    @FieldOffset
    @Nullable
    public final String m22879F() {
        this.f16046A = super.m9948a(this.f16046A, 23);
        return this.f16046A;
    }

    @FieldOffset
    @Nullable
    public final GraphQLGroup m22880G() {
        this.f16047B = (GraphQLGroup) super.m9947a(this.f16047B, 24, GraphQLGroup.class);
        return this.f16047B;
    }

    @FieldOffset
    @Nullable
    public final GraphQLGroupMessageChattableMembersConnection m22881H() {
        this.f16048C = (GraphQLGroupMessageChattableMembersConnection) super.m9947a(this.f16048C, 25, GraphQLGroupMessageChattableMembersConnection.class);
        return this.f16048C;
    }

    @FieldOffset
    @Nullable
    public final GraphQLOverlayCallToActionInfo m22882I() {
        this.f16049D = (GraphQLOverlayCallToActionInfo) super.m9947a(this.f16049D, 26, GraphQLOverlayCallToActionInfo.class);
        return this.f16049D;
    }

    @FieldOffset
    @Nullable
    public final GraphQLNode m22883J() {
        this.f16050E = (GraphQLNode) super.m9947a(this.f16050E, 27, GraphQLNode.class);
        return this.f16050E;
    }

    @FieldOffset
    @Nullable
    public final String m22884K() {
        this.f16051F = super.m9948a(this.f16051F, 28);
        return this.f16051F;
    }

    @FieldOffset
    @Nullable
    public final String m22885L() {
        this.f16052G = super.m9948a(this.f16052G, 29);
        return this.f16052G;
    }

    @FieldOffset
    @Nullable
    public final GraphQLLeadGenData m22886M() {
        this.f16053H = (GraphQLLeadGenData) super.m9947a(this.f16053H, 30, GraphQLLeadGenData.class);
        return this.f16053H;
    }

    @FieldOffset
    @Nullable
    public final String m22887N() {
        this.f16054I = super.m9948a(this.f16054I, 31);
        return this.f16054I;
    }

    @FieldOffset
    @Nullable
    public final GraphQLLeadGenDeepLinkUserStatus m22888O() {
        this.f16055J = (GraphQLLeadGenDeepLinkUserStatus) super.m9947a(this.f16055J, 32, GraphQLLeadGenDeepLinkUserStatus.class);
        return this.f16055J;
    }

    @FieldOffset
    @Nullable
    public final GraphQLLeadGenUserStatus m22889P() {
        this.f16056K = (GraphQLLeadGenUserStatus) super.m9947a(this.f16056K, 33, GraphQLLeadGenUserStatus.class);
        return this.f16056K;
    }

    @FieldOffset
    @Nullable
    public final String m22890Q() {
        this.f16057L = super.m9948a(this.f16057L, 34);
        return this.f16057L;
    }

    @FieldOffset
    @Nullable
    public final String m22891R() {
        this.f16058M = super.m9948a(this.f16058M, 35);
        return this.f16058M;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m22892S() {
        this.f16059N = (GraphQLImage) super.m9947a(this.f16059N, 36, GraphQLImage.class);
        return this.f16059N;
    }

    @FieldOffset
    public final GraphQLCallToActionStyle m22893T() {
        this.f16060O = (GraphQLCallToActionStyle) super.m9945a(this.f16060O, 37, GraphQLCallToActionStyle.class, GraphQLCallToActionStyle.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
        return this.f16060O;
    }

    @FieldOffset
    @Nullable
    public final GraphQLLinkTargetStoreData m22894U() {
        this.f16061P = (GraphQLLinkTargetStoreData) super.m9947a(this.f16061P, 38, GraphQLLinkTargetStoreData.class);
        return this.f16061P;
    }

    @FieldOffset
    @Nullable
    public final String m22895V() {
        this.f16062Q = super.m9948a(this.f16062Q, 39);
        return this.f16062Q;
    }

    @FieldOffset
    public final GraphQLCallToActionType m22896W() {
        this.f16063R = (GraphQLCallToActionType) super.m9945a(this.f16063R, 40, GraphQLCallToActionType.class, GraphQLCallToActionType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
        return this.f16063R;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m22897X() {
        this.f16064S = (GraphQLImage) super.m9947a(this.f16064S, 41, GraphQLImage.class);
        return this.f16064S;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities m22898Y() {
        this.f16065T = (GraphQLTextWithEntities) super.m9947a(this.f16065T, 42, GraphQLTextWithEntities.class);
        return this.f16065T;
    }

    @FieldOffset
    @Nullable
    public final String m22899Z() {
        this.f16066U = super.m9948a(this.f16066U, 43);
        return this.f16066U;
    }

    @FieldOffset
    @Nullable
    public final String aa() {
        this.f16067V = super.m9948a(this.f16067V, 44);
        return this.f16067V;
    }

    @FieldOffset
    @Nullable
    public final GraphQLPage ab() {
        this.f16068W = (GraphQLPage) super.m9947a(this.f16068W, 45, GraphQLPage.class);
        return this.f16068W;
    }

    @FieldOffset
    @Nullable
    public final GraphQLStory ac() {
        this.f16069X = (GraphQLStory) super.m9947a(this.f16069X, 46, GraphQLStory.class);
        return this.f16069X;
    }

    @FieldOffset
    @Nullable
    public final String ad() {
        this.f16070Y = super.m9948a(this.f16070Y, 47);
        return this.f16070Y;
    }

    @FieldOffset
    @Nullable
    public final String ae() {
        this.f16071Z = super.m9948a(this.f16071Z, 48);
        return this.f16071Z;
    }

    @FieldOffset
    @Nullable
    public final GraphQLPrivacyScope af() {
        this.aa = (GraphQLPrivacyScope) super.m9947a(this.aa, 49, GraphQLPrivacyScope.class);
        return this.aa;
    }

    @FieldOffset
    @Nullable
    public final String ag() {
        this.ab = super.m9948a(this.ab, 50);
        return this.ab;
    }

    @FieldOffset
    @Nullable
    public final GraphQLProfile ah() {
        this.ac = (GraphQLProfile) super.m9947a(this.ac, 51, GraphQLProfile.class);
        return this.ac;
    }

    @FieldOffset
    @Nullable
    public final String ai() {
        this.ad = super.m9948a(this.ad, 52);
        return this.ad;
    }

    @FieldOffset
    @Nullable
    public final String aj() {
        this.ae = super.m9948a(this.ae, 53);
        return this.ae;
    }

    @FieldOffset
    @Nullable
    public final GraphQLContactRecommendationField ak() {
        this.af = (GraphQLContactRecommendationField) super.m9947a(this.af, 54, GraphQLContactRecommendationField.class);
        return this.af;
    }

    @FieldOffset
    @Nullable
    public final String al() {
        this.ag = super.m9948a(this.ag, 55);
        return this.ag;
    }

    @FieldOffset
    @Nullable
    public final String am() {
        this.ah = super.m9948a(this.ah, 56);
        return this.ah;
    }

    @FieldOffset
    @Nullable
    public final String an() {
        this.ai = super.m9948a(this.ai, 57);
        return this.ai;
    }

    @FieldOffset
    @Nullable
    public final String ao() {
        this.aj = super.m9948a(this.aj, 58);
        return this.aj;
    }

    @FieldOffset
    @Nullable
    public final String ap() {
        this.ak = super.m9948a(this.ak, 59);
        return this.ak;
    }

    @FieldOffset
    @Nullable
    public final String aq() {
        this.al = super.m9948a(this.al, 60);
        return this.al;
    }

    @FieldOffset
    public final boolean m22904b() {
        m9949a(7, 5);
        return this.am;
    }

    @FieldOffset
    public final boolean ar() {
        m9949a(7, 6);
        return this.an;
    }

    @FieldOffset
    public final boolean as() {
        m9949a(7, 7);
        return this.ao;
    }

    @FieldOffset
    public final boolean at() {
        m9949a(8, 0);
        return this.ap;
    }

    @FieldOffset
    @Nullable
    public final String au() {
        this.aq = super.m9948a(this.aq, 65);
        return this.aq;
    }

    @FieldOffset
    @Nullable
    public final String av() {
        this.ar = super.m9948a(this.ar, 66);
        return this.ar;
    }

    @FieldOffset
    @Nullable
    public final String aw() {
        this.as = super.m9948a(this.as, 67);
        return this.as;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImageOverlay ax() {
        this.at = (GraphQLImageOverlay) super.m9947a(this.at, 68, GraphQLImageOverlay.class);
        return this.at;
    }

    @FieldOffset
    @Nullable
    public final String ay() {
        this.au = super.m9948a(this.au, 69);
        return this.au;
    }

    @FieldOffset
    @Nullable
    public final GraphQLAppendPostActionLinkTaggedAndMentionedUsersConnection az() {
        this.av = (GraphQLAppendPostActionLinkTaggedAndMentionedUsersConnection) super.m9947a(this.av, 70, GraphQLAppendPostActionLinkTaggedAndMentionedUsersConnection.class);
        return this.av;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTemporalEventInfo aA() {
        this.aw = (GraphQLTemporalEventInfo) super.m9947a(this.aw, 71, GraphQLTemporalEventInfo.class);
        return this.aw;
    }

    @FieldOffset
    @Nullable
    public final String aB() {
        this.ax = super.m9948a(this.ax, 72);
        return this.ax;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTopic aC() {
        this.ay = (GraphQLTopic) super.m9947a(this.ay, 73, GraphQLTopic.class);
        return this.ay;
    }

    @FieldOffset
    @Nullable
    public final String aD() {
        this.az = super.m9948a(this.az, 74);
        return this.az;
    }

    @FieldOffset
    @Nullable
    public final String aE() {
        this.aA = super.m9948a(this.aA, 75);
        return this.aA;
    }

    @FieldOffset
    @Nullable
    public final String aF() {
        this.aB = super.m9948a(this.aB, 76);
        return this.aB;
    }

    @FieldOffset
    @Nullable
    public final GraphQLPageOutcomeButton aG() {
        this.aC = (GraphQLPageOutcomeButton) super.m9947a(this.aC, 77, GraphQLPageOutcomeButton.class);
        return this.aC;
    }

    @FieldOffset
    @Nullable
    public final String aH() {
        this.aD = super.m9948a(this.aD, 78);
        return this.aD;
    }

    @FieldOffset
    public final ImmutableList<GraphQLVideoAnnotation> aI() {
        this.aE = super.m9944a(this.aE, 79, GraphQLVideoAnnotation.class);
        return (ImmutableList) this.aE;
    }

    @FieldOffset
    @Nullable
    public final GraphQLStory aJ() {
        this.aF = (GraphQLStory) super.m9947a(this.aF, 80, GraphQLStory.class);
        return this.aF;
    }

    @FieldOffset
    public final ImmutableList<String> aK() {
        this.aG = super.m9943a(this.aG, 81);
        return (ImmutableList) this.aG;
    }

    @FieldOffset
    public final ImmutableList<String> aL() {
        this.aH = super.m9943a(this.aH, 82);
        return (ImmutableList) this.aH;
    }

    @FieldOffset
    @Nullable
    public final String aM() {
        this.aI = super.m9948a(this.aI, 83);
        return this.aI;
    }

    @FieldOffset
    public final ImmutableList<String> aN() {
        this.aJ = super.m9943a(this.aJ, 84);
        return (ImmutableList) this.aJ;
    }

    @FieldOffset
    @Nullable
    public final String aO() {
        this.aK = super.m9948a(this.aK, 85);
        return this.aK;
    }

    @FieldOffset
    @Nullable
    public final GraphQLDocumentElement aP() {
        this.aL = (GraphQLDocumentElement) super.m9947a(this.aL, 86, GraphQLDocumentElement.class);
        return this.aL;
    }

    @FieldOffset
    @Nullable
    public final GraphQLInstantArticle aQ() {
        this.aM = (GraphQLInstantArticle) super.m9947a(this.aM, 87, GraphQLInstantArticle.class);
        return this.aM;
    }

    @FieldOffset
    @Nullable
    public final String aR() {
        this.aN = super.m9948a(this.aN, 88);
        return this.aN;
    }

    @FieldOffset
    @Nullable
    public final String aS() {
        this.aO = super.m9948a(this.aO, 89);
        return this.aO;
    }

    @FieldOffset
    public final int aT() {
        m9949a(11, 2);
        return this.aP;
    }

    public final int jK_() {
        return -1747569147;
    }

    public final GraphQLVisitableModel mo1404a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLTextWithEntities graphQLTextWithEntities;
        Builder a;
        GraphQLImage graphQLImage;
        GraphQLStory graphQLStory;
        GraphQLVisitableModel graphQLVisitableModel = null;
        m9958h();
        if (m22912q() != null) {
            GraphQLTimelineAppCollection graphQLTimelineAppCollection = (GraphQLTimelineAppCollection) graphQLModelMutatingVisitor.mo2928b(m22912q());
            if (m22912q() != graphQLTimelineAppCollection) {
                graphQLVisitableModel = (GraphQLStoryActionLink) ModelHelper.m23095a(null, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16080l = graphQLTimelineAppCollection;
            }
        }
        if (m22913r() != null) {
            GraphQLCoupon graphQLCoupon = (GraphQLCoupon) graphQLModelMutatingVisitor.mo2928b(m22913r());
            if (m22913r() != graphQLCoupon) {
                graphQLVisitableModel = (GraphQLStoryActionLink) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16081m = graphQLCoupon;
            }
        }
        if (m22915t() != null) {
            graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.mo2928b(m22915t());
            if (m22915t() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLStoryActionLink) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16083o = graphQLTextWithEntities;
            }
        }
        if (m22919x() != null) {
            a = ModelHelper.m23097a(m22919x(), graphQLModelMutatingVisitor);
            if (a != null) {
                GraphQLStoryActionLink graphQLStoryActionLink = (GraphQLStoryActionLink) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLStoryActionLink.f16087s = a.m1068b();
                graphQLVisitableModel = graphQLStoryActionLink;
            }
        }
        if (m22874A() != null) {
            GraphQLEvent graphQLEvent = (GraphQLEvent) graphQLModelMutatingVisitor.mo2928b(m22874A());
            if (m22874A() != graphQLEvent) {
                graphQLVisitableModel = (GraphQLStoryActionLink) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16090v = graphQLEvent;
            }
        }
        if (aP() != null) {
            GraphQLDocumentElement graphQLDocumentElement = (GraphQLDocumentElement) graphQLModelMutatingVisitor.mo2928b(aP());
            if (aP() != graphQLDocumentElement) {
                graphQLVisitableModel = (GraphQLStoryActionLink) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.aL = graphQLDocumentElement;
            }
        }
        if (m22877D() != null) {
            GraphQLFeedback graphQLFeedback = (GraphQLFeedback) graphQLModelMutatingVisitor.mo2928b(m22877D());
            if (m22877D() != graphQLFeedback) {
                graphQLVisitableModel = (GraphQLStoryActionLink) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16093y = graphQLFeedback;
            }
        }
        if (m22880G() != null) {
            GraphQLGroup graphQLGroup = (GraphQLGroup) graphQLModelMutatingVisitor.mo2928b(m22880G());
            if (m22880G() != graphQLGroup) {
                graphQLVisitableModel = (GraphQLStoryActionLink) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16047B = graphQLGroup;
            }
        }
        if (m22881H() != null) {
            GraphQLGroupMessageChattableMembersConnection graphQLGroupMessageChattableMembersConnection = (GraphQLGroupMessageChattableMembersConnection) graphQLModelMutatingVisitor.mo2928b(m22881H());
            if (m22881H() != graphQLGroupMessageChattableMembersConnection) {
                graphQLVisitableModel = (GraphQLStoryActionLink) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16048C = graphQLGroupMessageChattableMembersConnection;
            }
        }
        if (m22882I() != null) {
            GraphQLOverlayCallToActionInfo graphQLOverlayCallToActionInfo = (GraphQLOverlayCallToActionInfo) graphQLModelMutatingVisitor.mo2928b(m22882I());
            if (m22882I() != graphQLOverlayCallToActionInfo) {
                graphQLVisitableModel = (GraphQLStoryActionLink) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16049D = graphQLOverlayCallToActionInfo;
            }
        }
        if (aQ() != null) {
            GraphQLInstantArticle graphQLInstantArticle = (GraphQLInstantArticle) graphQLModelMutatingVisitor.mo2928b(aQ());
            if (aQ() != graphQLInstantArticle) {
                graphQLVisitableModel = (GraphQLStoryActionLink) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.aM = graphQLInstantArticle;
            }
        }
        if (m22883J() != null) {
            GraphQLNode graphQLNode = (GraphQLNode) graphQLModelMutatingVisitor.mo2928b(m22883J());
            if (m22883J() != graphQLNode) {
                graphQLVisitableModel = (GraphQLStoryActionLink) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16050E = graphQLNode;
            }
        }
        if (m22886M() != null) {
            GraphQLLeadGenData graphQLLeadGenData = (GraphQLLeadGenData) graphQLModelMutatingVisitor.mo2928b(m22886M());
            if (m22886M() != graphQLLeadGenData) {
                graphQLVisitableModel = (GraphQLStoryActionLink) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16053H = graphQLLeadGenData;
            }
        }
        if (m22888O() != null) {
            GraphQLLeadGenDeepLinkUserStatus graphQLLeadGenDeepLinkUserStatus = (GraphQLLeadGenDeepLinkUserStatus) graphQLModelMutatingVisitor.mo2928b(m22888O());
            if (m22888O() != graphQLLeadGenDeepLinkUserStatus) {
                graphQLVisitableModel = (GraphQLStoryActionLink) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16055J = graphQLLeadGenDeepLinkUserStatus;
            }
        }
        if (m22889P() != null) {
            GraphQLLeadGenUserStatus graphQLLeadGenUserStatus = (GraphQLLeadGenUserStatus) graphQLModelMutatingVisitor.mo2928b(m22889P());
            if (m22889P() != graphQLLeadGenUserStatus) {
                graphQLVisitableModel = (GraphQLStoryActionLink) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16056K = graphQLLeadGenUserStatus;
            }
        }
        if (m22892S() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(m22892S());
            if (m22892S() != graphQLImage) {
                graphQLVisitableModel = (GraphQLStoryActionLink) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16059N = graphQLImage;
            }
        }
        if (m22894U() != null) {
            GraphQLLinkTargetStoreData graphQLLinkTargetStoreData = (GraphQLLinkTargetStoreData) graphQLModelMutatingVisitor.mo2928b(m22894U());
            if (m22894U() != graphQLLinkTargetStoreData) {
                graphQLVisitableModel = (GraphQLStoryActionLink) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16061P = graphQLLinkTargetStoreData;
            }
        }
        if (m22897X() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(m22897X());
            if (m22897X() != graphQLImage) {
                graphQLVisitableModel = (GraphQLStoryActionLink) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16064S = graphQLImage;
            }
        }
        if (m22898Y() != null) {
            graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.mo2928b(m22898Y());
            if (m22898Y() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLStoryActionLink) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16065T = graphQLTextWithEntities;
            }
        }
        if (ab() != null) {
            GraphQLPage graphQLPage = (GraphQLPage) graphQLModelMutatingVisitor.mo2928b(ab());
            if (ab() != graphQLPage) {
                graphQLVisitableModel = (GraphQLStoryActionLink) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16068W = graphQLPage;
            }
        }
        if (aG() != null) {
            GraphQLPageOutcomeButton graphQLPageOutcomeButton = (GraphQLPageOutcomeButton) graphQLModelMutatingVisitor.mo2928b(aG());
            if (aG() != graphQLPageOutcomeButton) {
                graphQLVisitableModel = (GraphQLStoryActionLink) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.aC = graphQLPageOutcomeButton;
            }
        }
        if (ac() != null) {
            graphQLStory = (GraphQLStory) graphQLModelMutatingVisitor.mo2928b(ac());
            if (ac() != graphQLStory) {
                graphQLVisitableModel = (GraphQLStoryActionLink) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16069X = graphQLStory;
            }
        }
        if (af() != null) {
            GraphQLPrivacyScope graphQLPrivacyScope = (GraphQLPrivacyScope) graphQLModelMutatingVisitor.mo2928b(af());
            if (af() != graphQLPrivacyScope) {
                graphQLVisitableModel = (GraphQLStoryActionLink) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.aa = graphQLPrivacyScope;
            }
        }
        if (ah() != null) {
            GraphQLProfile graphQLProfile = (GraphQLProfile) graphQLModelMutatingVisitor.mo2928b(ah());
            if (ah() != graphQLProfile) {
                graphQLVisitableModel = (GraphQLStoryActionLink) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.ac = graphQLProfile;
            }
        }
        if (ak() != null) {
            GraphQLContactRecommendationField graphQLContactRecommendationField = (GraphQLContactRecommendationField) graphQLModelMutatingVisitor.mo2928b(ak());
            if (ak() != graphQLContactRecommendationField) {
                graphQLVisitableModel = (GraphQLStoryActionLink) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.af = graphQLContactRecommendationField;
            }
        }
        if (ax() != null) {
            GraphQLImageOverlay graphQLImageOverlay = (GraphQLImageOverlay) graphQLModelMutatingVisitor.mo2928b(ax());
            if (ax() != graphQLImageOverlay) {
                graphQLVisitableModel = (GraphQLStoryActionLink) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.at = graphQLImageOverlay;
            }
        }
        if (aJ() != null) {
            graphQLStory = (GraphQLStory) graphQLModelMutatingVisitor.mo2928b(aJ());
            if (aJ() != graphQLStory) {
                graphQLVisitableModel = (GraphQLStoryActionLink) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.aF = graphQLStory;
            }
        }
        if (az() != null) {
            GraphQLAppendPostActionLinkTaggedAndMentionedUsersConnection graphQLAppendPostActionLinkTaggedAndMentionedUsersConnection = (GraphQLAppendPostActionLinkTaggedAndMentionedUsersConnection) graphQLModelMutatingVisitor.mo2928b(az());
            if (az() != graphQLAppendPostActionLinkTaggedAndMentionedUsersConnection) {
                graphQLVisitableModel = (GraphQLStoryActionLink) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.av = graphQLAppendPostActionLinkTaggedAndMentionedUsersConnection;
            }
        }
        if (aA() != null) {
            GraphQLTemporalEventInfo graphQLTemporalEventInfo = (GraphQLTemporalEventInfo) graphQLModelMutatingVisitor.mo2928b(aA());
            if (aA() != graphQLTemporalEventInfo) {
                graphQLVisitableModel = (GraphQLStoryActionLink) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.aw = graphQLTemporalEventInfo;
            }
        }
        if (aC() != null) {
            GraphQLTopic graphQLTopic = (GraphQLTopic) graphQLModelMutatingVisitor.mo2928b(aC());
            if (aC() != graphQLTopic) {
                graphQLVisitableModel = (GraphQLStoryActionLink) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.ay = graphQLTopic;
            }
        }
        if (aI() != null) {
            a = ModelHelper.m23097a(aI(), graphQLModelMutatingVisitor);
            if (a != null) {
                graphQLStoryActionLink = (GraphQLStoryActionLink) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLStoryActionLink.aE = a.m1068b();
                graphQLVisitableModel = graphQLStoryActionLink;
            }
        }
        m9959i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLStoryActionLink() {
        super(92);
    }

    public final void mo1406a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.mo1406a(mutableFlatBuffer, i, obj);
        this.f16076h = mutableFlatBuffer.m21524a(i, 4, 0);
        this.f16077i = mutableFlatBuffer.m21524a(i, 5, 0);
        this.f16078j = mutableFlatBuffer.m21540a(i, 6);
        this.f16079k = mutableFlatBuffer.m21540a(i, 7);
        this.f16082n = mutableFlatBuffer.m21525a(i, 10, 0);
        this.am = mutableFlatBuffer.m21540a(i, 61);
        this.an = mutableFlatBuffer.m21540a(i, 62);
        this.ao = mutableFlatBuffer.m21540a(i, 63);
        this.ap = mutableFlatBuffer.m21540a(i, 64);
        this.aP = mutableFlatBuffer.m21524a(i, 90, 0);
    }

    public final int mo1403a(FlatBufferBuilder flatBufferBuilder) {
        m9958h();
        int a = flatBufferBuilder.m21479a(m22901a() != null ? m22901a().m22299e() : null);
        int b = flatBufferBuilder.m21502b(m22906k());
        int b2 = flatBufferBuilder.m21502b(m22907l());
        int a2 = ModelHelper.m23093a(flatBufferBuilder, m22912q());
        int a3 = ModelHelper.m23093a(flatBufferBuilder, m22913r());
        int a4 = ModelHelper.m23093a(flatBufferBuilder, m22915t());
        int b3 = flatBufferBuilder.m21502b(m22917v());
        int b4 = flatBufferBuilder.m21502b(m22918w());
        int a5 = ModelHelper.m23094a(flatBufferBuilder, m22919x());
        int b5 = flatBufferBuilder.m21502b(m22920y());
        int b6 = flatBufferBuilder.m21502b(m22921z());
        int a6 = ModelHelper.m23093a(flatBufferBuilder, m22874A());
        int b7 = flatBufferBuilder.m21502b(m22875B());
        int b8 = flatBufferBuilder.m21502b(m22876C());
        int a7 = ModelHelper.m23093a(flatBufferBuilder, m22877D());
        int b9 = flatBufferBuilder.m21502b(m22878E());
        int b10 = flatBufferBuilder.m21502b(m22879F());
        int a8 = ModelHelper.m23093a(flatBufferBuilder, m22880G());
        int a9 = ModelHelper.m23093a(flatBufferBuilder, m22881H());
        int a10 = ModelHelper.m23093a(flatBufferBuilder, m22882I());
        int a11 = ModelHelper.m23093a(flatBufferBuilder, m22883J());
        int b11 = flatBufferBuilder.m21502b(m22884K());
        int b12 = flatBufferBuilder.m21502b(m22885L());
        int a12 = ModelHelper.m23093a(flatBufferBuilder, m22886M());
        int b13 = flatBufferBuilder.m21502b(m22887N());
        int a13 = ModelHelper.m23093a(flatBufferBuilder, m22888O());
        int a14 = ModelHelper.m23093a(flatBufferBuilder, m22889P());
        int b14 = flatBufferBuilder.m21502b(m22890Q());
        int b15 = flatBufferBuilder.m21502b(m22891R());
        int a15 = ModelHelper.m23093a(flatBufferBuilder, m22892S());
        int a16 = ModelHelper.m23093a(flatBufferBuilder, m22894U());
        int b16 = flatBufferBuilder.m21502b(m22895V());
        int a17 = ModelHelper.m23093a(flatBufferBuilder, m22897X());
        int a18 = ModelHelper.m23093a(flatBufferBuilder, m22898Y());
        int b17 = flatBufferBuilder.m21502b(m22899Z());
        int b18 = flatBufferBuilder.m21502b(aa());
        int a19 = ModelHelper.m23093a(flatBufferBuilder, ab());
        int a20 = ModelHelper.m23093a(flatBufferBuilder, ac());
        int b19 = flatBufferBuilder.m21502b(ad());
        int b20 = flatBufferBuilder.m21502b(ae());
        int a21 = ModelHelper.m23093a(flatBufferBuilder, af());
        int b21 = flatBufferBuilder.m21502b(ag());
        int a22 = ModelHelper.m23093a(flatBufferBuilder, ah());
        int b22 = flatBufferBuilder.m21502b(ai());
        int b23 = flatBufferBuilder.m21502b(aj());
        int a23 = ModelHelper.m23093a(flatBufferBuilder, ak());
        int b24 = flatBufferBuilder.m21502b(al());
        int b25 = flatBufferBuilder.m21502b(am());
        int b26 = flatBufferBuilder.m21502b(an());
        int b27 = flatBufferBuilder.m21502b(ao());
        int b28 = flatBufferBuilder.m21502b(ap());
        int b29 = flatBufferBuilder.m21502b(aq());
        int b30 = flatBufferBuilder.m21502b(au());
        int b31 = flatBufferBuilder.m21502b(av());
        int b32 = flatBufferBuilder.m21502b(aw());
        int a24 = ModelHelper.m23093a(flatBufferBuilder, ax());
        int b33 = flatBufferBuilder.m21502b(ay());
        int a25 = ModelHelper.m23093a(flatBufferBuilder, az());
        int a26 = ModelHelper.m23093a(flatBufferBuilder, aA());
        int b34 = flatBufferBuilder.m21502b(aB());
        int a27 = ModelHelper.m23093a(flatBufferBuilder, aC());
        int b35 = flatBufferBuilder.m21502b(aD());
        int b36 = flatBufferBuilder.m21502b(aE());
        int b37 = flatBufferBuilder.m21502b(aF());
        int a28 = ModelHelper.m23093a(flatBufferBuilder, aG());
        int b38 = flatBufferBuilder.m21502b(aH());
        int a29 = ModelHelper.m23094a(flatBufferBuilder, aI());
        int a30 = ModelHelper.m23093a(flatBufferBuilder, aJ());
        int c = flatBufferBuilder.m21509c(aK());
        int c2 = flatBufferBuilder.m21509c(aL());
        int b39 = flatBufferBuilder.m21502b(aM());
        int c3 = flatBufferBuilder.m21509c(aN());
        int b40 = flatBufferBuilder.m21502b(aO());
        int a31 = ModelHelper.m23093a(flatBufferBuilder, aP());
        int a32 = ModelHelper.m23093a(flatBufferBuilder, aQ());
        int b41 = flatBufferBuilder.m21502b(aR());
        int b42 = flatBufferBuilder.m21502b(aS());
        flatBufferBuilder.m21510c(91);
        flatBufferBuilder.m21507b(0, a);
        flatBufferBuilder.m21496a(1, m22905j() == GraphQLProfilePictureActionLinkType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE ? null : m22905j());
        flatBufferBuilder.m21507b(2, b);
        flatBufferBuilder.m21507b(3, b2);
        flatBufferBuilder.m21494a(4, m22908m(), 0);
        flatBufferBuilder.m21494a(5, m22909n(), 0);
        flatBufferBuilder.m21498a(6, m22910o());
        flatBufferBuilder.m21498a(7, m22911p());
        flatBufferBuilder.m21507b(8, a2);
        flatBufferBuilder.m21507b(9, a3);
        flatBufferBuilder.m21495a(10, m22914s(), 0);
        flatBufferBuilder.m21507b(11, a4);
        flatBufferBuilder.m21496a(12, m22916u() == GraphQLStoryActionLinkDestinationType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE ? null : m22916u());
        flatBufferBuilder.m21507b(13, b3);
        flatBufferBuilder.m21507b(14, b4);
        flatBufferBuilder.m21507b(15, a5);
        flatBufferBuilder.m21507b(16, b5);
        flatBufferBuilder.m21507b(17, b6);
        flatBufferBuilder.m21507b(18, a6);
        flatBufferBuilder.m21507b(19, b7);
        flatBufferBuilder.m21507b(20, b8);
        flatBufferBuilder.m21507b(21, a7);
        flatBufferBuilder.m21507b(22, b9);
        flatBufferBuilder.m21507b(23, b10);
        flatBufferBuilder.m21507b(24, a8);
        flatBufferBuilder.m21507b(25, a9);
        flatBufferBuilder.m21507b(26, a10);
        flatBufferBuilder.m21507b(27, a11);
        flatBufferBuilder.m21507b(28, b11);
        flatBufferBuilder.m21507b(29, b12);
        flatBufferBuilder.m21507b(30, a12);
        flatBufferBuilder.m21507b(31, b13);
        flatBufferBuilder.m21507b(32, a13);
        flatBufferBuilder.m21507b(33, a14);
        flatBufferBuilder.m21507b(34, b14);
        flatBufferBuilder.m21507b(35, b15);
        flatBufferBuilder.m21507b(36, a15);
        flatBufferBuilder.m21496a(37, m22893T() == GraphQLCallToActionStyle.UNSET_OR_UNRECOGNIZED_ENUM_VALUE ? null : m22893T());
        flatBufferBuilder.m21507b(38, a16);
        flatBufferBuilder.m21507b(39, b16);
        flatBufferBuilder.m21496a(40, m22896W() == GraphQLCallToActionType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE ? null : m22896W());
        flatBufferBuilder.m21507b(41, a17);
        flatBufferBuilder.m21507b(42, a18);
        flatBufferBuilder.m21507b(43, b17);
        flatBufferBuilder.m21507b(44, b18);
        flatBufferBuilder.m21507b(45, a19);
        flatBufferBuilder.m21507b(46, a20);
        flatBufferBuilder.m21507b(47, b19);
        flatBufferBuilder.m21507b(48, b20);
        flatBufferBuilder.m21507b(49, a21);
        flatBufferBuilder.m21507b(50, b21);
        flatBufferBuilder.m21507b(51, a22);
        flatBufferBuilder.m21507b(52, b22);
        flatBufferBuilder.m21507b(53, b23);
        flatBufferBuilder.m21507b(54, a23);
        flatBufferBuilder.m21507b(55, b24);
        flatBufferBuilder.m21507b(56, b25);
        flatBufferBuilder.m21507b(57, b26);
        flatBufferBuilder.m21507b(58, b27);
        flatBufferBuilder.m21507b(59, b28);
        flatBufferBuilder.m21507b(60, b29);
        flatBufferBuilder.m21498a(61, m22904b());
        flatBufferBuilder.m21498a(62, ar());
        flatBufferBuilder.m21498a(63, as());
        flatBufferBuilder.m21498a(64, at());
        flatBufferBuilder.m21507b(65, b30);
        flatBufferBuilder.m21507b(66, b31);
        flatBufferBuilder.m21507b(67, b32);
        flatBufferBuilder.m21507b(68, a24);
        flatBufferBuilder.m21507b(69, b33);
        flatBufferBuilder.m21507b(70, a25);
        flatBufferBuilder.m21507b(71, a26);
        flatBufferBuilder.m21507b(72, b34);
        flatBufferBuilder.m21507b(73, a27);
        flatBufferBuilder.m21507b(74, b35);
        flatBufferBuilder.m21507b(75, b36);
        flatBufferBuilder.m21507b(76, b37);
        flatBufferBuilder.m21507b(77, a28);
        flatBufferBuilder.m21507b(78, b38);
        flatBufferBuilder.m21507b(79, a29);
        flatBufferBuilder.m21507b(80, a30);
        flatBufferBuilder.m21507b(81, c);
        flatBufferBuilder.m21507b(82, c2);
        flatBufferBuilder.m21507b(83, b39);
        flatBufferBuilder.m21507b(84, c3);
        flatBufferBuilder.m21507b(85, b40);
        flatBufferBuilder.m21507b(86, a31);
        flatBufferBuilder.m21507b(87, a32);
        flatBufferBuilder.m21507b(88, b41);
        flatBufferBuilder.m21507b(89, b42);
        flatBufferBuilder.m21494a(90, aT(), 0);
        m9959i();
        return flatBufferBuilder.m21511d();
    }

    public GraphQLStoryActionLink(Parcel parcel) {
        boolean z;
        boolean z2 = true;
        super(92);
        this.f16073e = GraphQLProfilePictureActionLinkType.fromString(parcel.readString());
        this.f16074f = parcel.readString();
        this.f16075g = parcel.readString();
        this.f16076h = parcel.readInt();
        this.f16077i = parcel.readInt();
        this.f16078j = parcel.readByte() == (byte) 1;
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.f16079k = z;
        this.f16080l = (GraphQLTimelineAppCollection) parcel.readValue(GraphQLTimelineAppCollection.class.getClassLoader());
        this.f16081m = (GraphQLCoupon) parcel.readValue(GraphQLCoupon.class.getClassLoader());
        this.f16082n = parcel.readLong();
        this.f16083o = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.f16084p = GraphQLStoryActionLinkDestinationType.fromString(parcel.readString());
        this.f16085q = parcel.readString();
        this.f16086r = parcel.readString();
        this.f16087s = ImmutableListHelper.m21625a(parcel.readArrayList(GraphQLLeadGenErrorNode.class.getClassLoader()));
        this.f16088t = parcel.readString();
        this.f16089u = parcel.readString();
        this.f16090v = (GraphQLEvent) parcel.readValue(GraphQLEvent.class.getClassLoader());
        this.f16091w = parcel.readString();
        this.f16092x = parcel.readString();
        this.aL = (GraphQLDocumentElement) parcel.readValue(GraphQLDocumentElement.class.getClassLoader());
        this.f16093y = (GraphQLFeedback) parcel.readValue(GraphQLFeedback.class.getClassLoader());
        this.f16094z = parcel.readString();
        this.f16046A = parcel.readString();
        this.aH = ImmutableListHelper.m21625a(parcel.readArrayList(String.class.getClassLoader()));
        this.aI = parcel.readString();
        this.aD = parcel.readString();
        this.f16047B = (GraphQLGroup) parcel.readValue(GraphQLGroup.class.getClassLoader());
        this.f16048C = (GraphQLGroupMessageChattableMembersConnection) parcel.readValue(GraphQLGroupMessageChattableMembersConnection.class.getClassLoader());
        this.aN = parcel.readString();
        this.aG = ImmutableListHelper.m21625a(parcel.readArrayList(String.class.getClassLoader()));
        this.f16049D = (GraphQLOverlayCallToActionInfo) parcel.readValue(GraphQLOverlayCallToActionInfo.class.getClassLoader());
        this.aM = (GraphQLInstantArticle) parcel.readValue(GraphQLInstantArticle.class.getClassLoader());
        this.f16050E = (GraphQLNode) parcel.readValue(GraphQLNode.class.getClassLoader());
        this.f16051F = parcel.readString();
        this.f16052G = parcel.readString();
        this.f16053H = (GraphQLLeadGenData) parcel.readValue(GraphQLLeadGenData.class.getClassLoader());
        this.f16054I = parcel.readString();
        this.f16055J = (GraphQLLeadGenDeepLinkUserStatus) parcel.readValue(GraphQLLeadGenDeepLinkUserStatus.class.getClassLoader());
        this.f16056K = (GraphQLLeadGenUserStatus) parcel.readValue(GraphQLLeadGenUserStatus.class.getClassLoader());
        this.f16057L = parcel.readString();
        this.f16058M = parcel.readString();
        this.f16059N = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f16060O = GraphQLCallToActionStyle.fromString(parcel.readString());
        this.f16061P = (GraphQLLinkTargetStoreData) parcel.readValue(GraphQLLinkTargetStoreData.class.getClassLoader());
        this.f16062Q = parcel.readString();
        this.f16063R = GraphQLCallToActionType.fromString(parcel.readString());
        this.f16064S = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.aO = parcel.readString();
        this.aJ = ImmutableListHelper.m21625a(parcel.readArrayList(String.class.getClassLoader()));
        this.aK = parcel.readString();
        this.f16065T = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.f16066U = parcel.readString();
        this.f16067V = parcel.readString();
        this.f16068W = (GraphQLPage) parcel.readValue(GraphQLPage.class.getClassLoader());
        this.aC = (GraphQLPageOutcomeButton) parcel.readValue(GraphQLPageOutcomeButton.class.getClassLoader());
        this.f16069X = (GraphQLStory) parcel.readValue(GraphQLStory.class.getClassLoader());
        this.f16070Y = parcel.readString();
        this.f16071Z = parcel.readString();
        this.aa = (GraphQLPrivacyScope) parcel.readValue(GraphQLPrivacyScope.class.getClassLoader());
        this.ab = parcel.readString();
        this.ac = (GraphQLProfile) parcel.readValue(GraphQLProfile.class.getClassLoader());
        this.ad = parcel.readString();
        this.ae = parcel.readString();
        this.aB = parcel.readString();
        this.aP = parcel.readInt();
        this.af = (GraphQLContactRecommendationField) parcel.readValue(GraphQLContactRecommendationField.class.getClassLoader());
        this.ag = parcel.readString();
        this.ah = parcel.readString();
        this.ai = parcel.readString();
        this.aj = parcel.readString();
        this.ak = parcel.readString();
        this.al = parcel.readString();
        this.am = parcel.readByte() == (byte) 1;
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.an = z;
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.ao = z;
        if (parcel.readByte() != (byte) 1) {
            z2 = false;
        }
        this.ap = z2;
        this.aq = parcel.readString();
        this.ar = parcel.readString();
        this.as = parcel.readString();
        this.at = (GraphQLImageOverlay) parcel.readValue(GraphQLImageOverlay.class.getClassLoader());
        this.aF = (GraphQLStory) parcel.readValue(GraphQLStory.class.getClassLoader());
        this.au = parcel.readString();
        this.av = (GraphQLAppendPostActionLinkTaggedAndMentionedUsersConnection) parcel.readValue(GraphQLAppendPostActionLinkTaggedAndMentionedUsersConnection.class.getClassLoader());
        this.aw = (GraphQLTemporalEventInfo) parcel.readValue(GraphQLTemporalEventInfo.class.getClassLoader());
        this.ax = parcel.readString();
        this.ay = (GraphQLTopic) parcel.readValue(GraphQLTopic.class.getClassLoader());
        this.az = parcel.readString();
        this.aA = parcel.readString();
        this.aE = ImmutableListHelper.m21625a(parcel.readArrayList(GraphQLVideoAnnotation.class.getClassLoader()));
        this.f16072d = (GraphQLObjectType) ParcelUtil.b(parcel, GraphQLObjectType.class);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int i2;
        int i3 = 1;
        parcel.writeString(m22905j().name());
        parcel.writeString(m22906k());
        parcel.writeString(m22907l());
        parcel.writeInt(m22908m());
        parcel.writeInt(m22909n());
        parcel.writeByte((byte) (m22910o() ? 1 : 0));
        if (m22911p()) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        parcel.writeValue(m22912q());
        parcel.writeValue(m22913r());
        parcel.writeLong(m22914s());
        parcel.writeValue(m22915t());
        parcel.writeString(m22916u().name());
        parcel.writeString(m22917v());
        parcel.writeString(m22918w());
        parcel.writeList(m22919x());
        parcel.writeString(m22920y());
        parcel.writeString(m22921z());
        parcel.writeValue(m22874A());
        parcel.writeString(m22875B());
        parcel.writeString(m22876C());
        parcel.writeValue(aP());
        parcel.writeValue(m22877D());
        parcel.writeString(m22878E());
        parcel.writeString(m22879F());
        parcel.writeList(aL());
        parcel.writeString(aM());
        parcel.writeString(aH());
        parcel.writeValue(m22880G());
        parcel.writeValue(m22881H());
        parcel.writeString(aR());
        parcel.writeList(aK());
        parcel.writeValue(m22882I());
        parcel.writeValue(aQ());
        parcel.writeValue(m22883J());
        parcel.writeString(m22884K());
        parcel.writeString(m22885L());
        parcel.writeValue(m22886M());
        parcel.writeString(m22887N());
        parcel.writeValue(m22888O());
        parcel.writeValue(m22889P());
        parcel.writeString(m22890Q());
        parcel.writeString(m22891R());
        parcel.writeValue(m22892S());
        parcel.writeString(m22893T().name());
        parcel.writeValue(m22894U());
        parcel.writeString(m22895V());
        parcel.writeString(m22896W().name());
        parcel.writeValue(m22897X());
        parcel.writeString(aS());
        parcel.writeList(aN());
        parcel.writeString(aO());
        parcel.writeValue(m22898Y());
        parcel.writeString(m22899Z());
        parcel.writeString(aa());
        parcel.writeValue(ab());
        parcel.writeValue(aG());
        parcel.writeValue(ac());
        parcel.writeString(ad());
        parcel.writeString(ae());
        parcel.writeValue(af());
        parcel.writeString(ag());
        parcel.writeValue(ah());
        parcel.writeString(ai());
        parcel.writeString(aj());
        parcel.writeString(aF());
        parcel.writeInt(aT());
        parcel.writeValue(ak());
        parcel.writeString(al());
        parcel.writeString(am());
        parcel.writeString(an());
        parcel.writeString(ao());
        parcel.writeString(ap());
        parcel.writeString(aq());
        parcel.writeByte((byte) (m22904b() ? 1 : 0));
        if (ar()) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        if (as()) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        if (!at()) {
            i3 = 0;
        }
        parcel.writeByte((byte) i3);
        parcel.writeString(au());
        parcel.writeString(av());
        parcel.writeString(aw());
        parcel.writeValue(ax());
        parcel.writeValue(aJ());
        parcel.writeString(ay());
        parcel.writeValue(az());
        parcel.writeValue(aA());
        parcel.writeString(aB());
        parcel.writeValue(aC());
        parcel.writeString(aD());
        parcel.writeString(aE());
        parcel.writeList(aI());
        parcel.writeParcelable(this.f16072d, i);
    }

    public GraphQLStoryActionLink(Builder builder) {
        super(92);
        this.b = builder.f15736a;
        this.c = builder.f15737b;
        this.f16073e = builder.d;
        this.f16074f = builder.e;
        this.f16075g = builder.f;
        this.f16076h = builder.g;
        this.f16077i = builder.h;
        this.f16078j = builder.i;
        this.f16079k = builder.j;
        this.f16080l = builder.k;
        this.f16081m = builder.l;
        this.f16082n = builder.m;
        this.f16083o = builder.n;
        this.f16084p = builder.o;
        this.f16085q = builder.p;
        this.f16086r = builder.q;
        this.f16087s = builder.r;
        this.f16088t = builder.s;
        this.f16089u = builder.t;
        this.f16090v = builder.u;
        this.f16091w = builder.v;
        this.f16092x = builder.w;
        this.aL = builder.x;
        this.f16093y = builder.y;
        this.f16094z = builder.z;
        this.f16046A = builder.A;
        this.aH = builder.B;
        this.aI = builder.C;
        this.aD = builder.D;
        this.f16047B = builder.E;
        this.f16048C = builder.F;
        this.aN = builder.G;
        this.aG = builder.H;
        this.f16049D = builder.I;
        this.aM = builder.J;
        this.f16050E = builder.K;
        this.f16051F = builder.L;
        this.f16052G = builder.M;
        this.f16053H = builder.N;
        this.f16054I = builder.O;
        this.f16055J = builder.P;
        this.f16056K = builder.Q;
        this.f16057L = builder.R;
        this.f16058M = builder.S;
        this.f16059N = builder.T;
        this.f16060O = builder.U;
        this.f16061P = builder.V;
        this.f16062Q = builder.W;
        this.f16063R = builder.X;
        this.f16064S = builder.Y;
        this.aO = builder.Z;
        this.aJ = builder.aa;
        this.aK = builder.ab;
        this.f16065T = builder.ac;
        this.f16066U = builder.ad;
        this.f16067V = builder.ae;
        this.f16068W = builder.af;
        this.aC = builder.ag;
        this.f16069X = builder.ah;
        this.f16070Y = builder.ai;
        this.f16071Z = builder.aj;
        this.aa = builder.ak;
        this.ab = builder.al;
        this.ac = builder.am;
        this.ad = builder.an;
        this.ae = builder.ao;
        this.aB = builder.ap;
        this.aP = builder.aq;
        this.af = builder.ar;
        this.ag = builder.as;
        this.ah = builder.at;
        this.ai = builder.au;
        this.aj = builder.av;
        this.ak = builder.aw;
        this.al = builder.ax;
        this.am = builder.ay;
        this.an = builder.az;
        this.ao = builder.aA;
        this.ap = builder.aB;
        this.aq = builder.aC;
        this.ar = builder.aD;
        this.as = builder.aE;
        this.at = builder.aF;
        this.aF = builder.aG;
        this.au = builder.aH;
        this.av = builder.aI;
        this.aw = builder.aJ;
        this.ax = builder.aK;
        this.ay = builder.aL;
        this.az = builder.aM;
        this.aA = builder.aN;
        this.aE = builder.aO;
        this.f16072d = builder.aP;
    }
}
