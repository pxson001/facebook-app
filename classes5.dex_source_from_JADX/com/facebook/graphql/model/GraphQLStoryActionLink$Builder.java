package com.facebook.graphql.model;

import com.facebook.graphql.enums.GraphQLCallToActionStyle;
import com.facebook.graphql.enums.GraphQLCallToActionType;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.enums.GraphQLProfilePictureActionLinkType;
import com.facebook.graphql.enums.GraphQLStoryActionLinkDestinationType;
import com.facebook.graphql.modelutil.BaseModel.Builder;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;

/* compiled from: Unable to retrieve version number */
public class GraphQLStoryActionLink$Builder extends Builder {
    @Nullable
    public String f13076A;
    public ImmutableList<String> f13077B;
    @Nullable
    public String f13078C;
    @Nullable
    public String f13079D;
    @Nullable
    public GraphQLGroup f13080E;
    @Nullable
    public GraphQLGroupMessageChattableMembersConnection f13081F;
    @Nullable
    public String f13082G;
    public ImmutableList<String> f13083H;
    @Nullable
    public GraphQLOverlayCallToActionInfo f13084I;
    @Nullable
    public GraphQLInstantArticle f13085J;
    @Nullable
    public GraphQLNode f13086K;
    @Nullable
    public String f13087L;
    @Nullable
    public String f13088M;
    @Nullable
    public GraphQLLeadGenData f13089N;
    @Nullable
    public String f13090O;
    @Nullable
    public GraphQLLeadGenDeepLinkUserStatus f13091P;
    @Nullable
    public GraphQLLeadGenUserStatus f13092Q;
    @Nullable
    public String f13093R;
    @Nullable
    public String f13094S;
    @Nullable
    public GraphQLImage f13095T;
    public GraphQLCallToActionStyle f13096U = GraphQLCallToActionStyle.UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    @Nullable
    public GraphQLLinkTargetStoreData f13097V;
    @Nullable
    public String f13098W;
    public GraphQLCallToActionType f13099X = GraphQLCallToActionType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    @Nullable
    public GraphQLImage f13100Y;
    @Nullable
    public String f13101Z;
    public boolean aA;
    public boolean aB;
    @Nullable
    public String aC;
    @Nullable
    public String aD;
    @Nullable
    public String aE;
    @Nullable
    public GraphQLImageOverlay aF;
    @Nullable
    public GraphQLStory aG;
    @Nullable
    public String aH;
    @Nullable
    public GraphQLAppendPostActionLinkTaggedAndMentionedUsersConnection aI;
    @Nullable
    public GraphQLTemporalEventInfo aJ;
    @Nullable
    public String aK;
    @Nullable
    public GraphQLTopic aL;
    @Nullable
    public String aM;
    @Nullable
    public String aN;
    public ImmutableList<GraphQLVideoAnnotation> aO;
    @Nullable
    public GraphQLObjectType aP = null;
    public ImmutableList<String> aa;
    @Nullable
    public String ab;
    @Nullable
    public GraphQLTextWithEntities ac;
    @Nullable
    public String ad;
    @Nullable
    public String ae;
    @Nullable
    public GraphQLPage af;
    @Nullable
    public GraphQLPageOutcomeButton ag;
    @Nullable
    public GraphQLStory ah;
    @Nullable
    public String ai;
    @Nullable
    public String aj;
    @Nullable
    public GraphQLPrivacyScope ak;
    @Nullable
    public String al;
    @Nullable
    public GraphQLProfile am;
    @Nullable
    public String an;
    @Nullable
    public String ao;
    @Nullable
    public String ap;
    public int aq;
    @Nullable
    public GraphQLContactRecommendationField ar;
    @Nullable
    public String as;
    @Nullable
    public String at;
    @Nullable
    public String au;
    @Nullable
    public String av;
    @Nullable
    public String aw;
    @Nullable
    public String ax;
    public boolean ay;
    public boolean az;
    public GraphQLProfilePictureActionLinkType f13102d = GraphQLProfilePictureActionLinkType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    @Nullable
    public String f13103e;
    @Nullable
    public String f13104f;
    public int f13105g;
    public int f13106h;
    public boolean f13107i;
    public boolean f13108j;
    @Nullable
    public GraphQLTimelineAppCollection f13109k;
    @Nullable
    public GraphQLCoupon f13110l;
    public long f13111m;
    @Nullable
    public GraphQLTextWithEntities f13112n;
    public GraphQLStoryActionLinkDestinationType f13113o = GraphQLStoryActionLinkDestinationType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    @Nullable
    public String f13114p;
    @Nullable
    public String f13115q;
    public ImmutableList<GraphQLLeadGenErrorNode> f13116r;
    @Nullable
    public String f13117s;
    @Nullable
    public String f13118t;
    @Nullable
    public GraphQLEvent f13119u;
    @Nullable
    public String f13120v;
    @Nullable
    public String f13121w;
    @Nullable
    public GraphQLDocumentElement f13122x;
    @Nullable
    public GraphQLFeedback f13123y;
    @Nullable
    public String f13124z;

    public GraphQLStoryActionLink$Builder() {
        Preconditions.checkState(this instanceof GraphQLStoryActionLink$Builder);
    }

    public static GraphQLStoryActionLink$Builder m21841a(GraphQLStoryActionLink graphQLStoryActionLink) {
        GraphQLStoryActionLink$Builder graphQLStoryActionLink$Builder = new GraphQLStoryActionLink$Builder();
        graphQLStoryActionLink.h();
        graphQLStoryActionLink$Builder.f13102d = graphQLStoryActionLink.j();
        graphQLStoryActionLink$Builder.f13103e = graphQLStoryActionLink.k();
        graphQLStoryActionLink$Builder.f13104f = graphQLStoryActionLink.l();
        graphQLStoryActionLink$Builder.f13105g = graphQLStoryActionLink.m();
        graphQLStoryActionLink$Builder.f13106h = graphQLStoryActionLink.n();
        graphQLStoryActionLink$Builder.f13107i = graphQLStoryActionLink.o();
        graphQLStoryActionLink$Builder.f13108j = graphQLStoryActionLink.p();
        graphQLStoryActionLink$Builder.f13109k = graphQLStoryActionLink.q();
        graphQLStoryActionLink$Builder.f13110l = graphQLStoryActionLink.r();
        graphQLStoryActionLink$Builder.f13111m = graphQLStoryActionLink.s();
        graphQLStoryActionLink$Builder.f13112n = graphQLStoryActionLink.t();
        graphQLStoryActionLink$Builder.f13113o = graphQLStoryActionLink.u();
        graphQLStoryActionLink$Builder.f13114p = graphQLStoryActionLink.v();
        graphQLStoryActionLink$Builder.f13115q = graphQLStoryActionLink.w();
        graphQLStoryActionLink$Builder.f13116r = graphQLStoryActionLink.x();
        graphQLStoryActionLink$Builder.f13117s = graphQLStoryActionLink.y();
        graphQLStoryActionLink$Builder.f13118t = graphQLStoryActionLink.z();
        graphQLStoryActionLink$Builder.f13119u = graphQLStoryActionLink.A();
        graphQLStoryActionLink$Builder.f13120v = graphQLStoryActionLink.B();
        graphQLStoryActionLink$Builder.f13121w = graphQLStoryActionLink.C();
        graphQLStoryActionLink$Builder.f13122x = graphQLStoryActionLink.aP();
        graphQLStoryActionLink$Builder.f13123y = graphQLStoryActionLink.D();
        graphQLStoryActionLink$Builder.f13124z = graphQLStoryActionLink.E();
        graphQLStoryActionLink$Builder.f13076A = graphQLStoryActionLink.F();
        graphQLStoryActionLink$Builder.f13077B = graphQLStoryActionLink.aL();
        graphQLStoryActionLink$Builder.f13078C = graphQLStoryActionLink.aM();
        graphQLStoryActionLink$Builder.f13079D = graphQLStoryActionLink.aH();
        graphQLStoryActionLink$Builder.f13080E = graphQLStoryActionLink.G();
        graphQLStoryActionLink$Builder.f13081F = graphQLStoryActionLink.H();
        graphQLStoryActionLink$Builder.f13082G = graphQLStoryActionLink.aR();
        graphQLStoryActionLink$Builder.f13083H = graphQLStoryActionLink.aK();
        graphQLStoryActionLink$Builder.f13084I = graphQLStoryActionLink.I();
        graphQLStoryActionLink$Builder.f13085J = graphQLStoryActionLink.aQ();
        graphQLStoryActionLink$Builder.f13086K = graphQLStoryActionLink.J();
        graphQLStoryActionLink$Builder.f13087L = graphQLStoryActionLink.K();
        graphQLStoryActionLink$Builder.f13088M = graphQLStoryActionLink.L();
        graphQLStoryActionLink$Builder.f13089N = graphQLStoryActionLink.M();
        graphQLStoryActionLink$Builder.f13090O = graphQLStoryActionLink.N();
        graphQLStoryActionLink$Builder.f13091P = graphQLStoryActionLink.O();
        graphQLStoryActionLink$Builder.f13092Q = graphQLStoryActionLink.P();
        graphQLStoryActionLink$Builder.f13093R = graphQLStoryActionLink.Q();
        graphQLStoryActionLink$Builder.f13094S = graphQLStoryActionLink.R();
        graphQLStoryActionLink$Builder.f13095T = graphQLStoryActionLink.S();
        graphQLStoryActionLink$Builder.f13096U = graphQLStoryActionLink.T();
        graphQLStoryActionLink$Builder.f13097V = graphQLStoryActionLink.U();
        graphQLStoryActionLink$Builder.f13098W = graphQLStoryActionLink.V();
        graphQLStoryActionLink$Builder.f13099X = graphQLStoryActionLink.W();
        graphQLStoryActionLink$Builder.f13100Y = graphQLStoryActionLink.X();
        graphQLStoryActionLink$Builder.f13101Z = graphQLStoryActionLink.aS();
        graphQLStoryActionLink$Builder.aa = graphQLStoryActionLink.aN();
        graphQLStoryActionLink$Builder.ab = graphQLStoryActionLink.aO();
        graphQLStoryActionLink$Builder.ac = graphQLStoryActionLink.Y();
        graphQLStoryActionLink$Builder.ad = graphQLStoryActionLink.Z();
        graphQLStoryActionLink$Builder.ae = graphQLStoryActionLink.aa();
        graphQLStoryActionLink$Builder.af = graphQLStoryActionLink.ab();
        graphQLStoryActionLink$Builder.ag = graphQLStoryActionLink.aG();
        graphQLStoryActionLink$Builder.ah = graphQLStoryActionLink.ac();
        graphQLStoryActionLink$Builder.ai = graphQLStoryActionLink.ad();
        graphQLStoryActionLink$Builder.aj = graphQLStoryActionLink.ae();
        graphQLStoryActionLink$Builder.ak = graphQLStoryActionLink.af();
        graphQLStoryActionLink$Builder.al = graphQLStoryActionLink.ag();
        graphQLStoryActionLink$Builder.am = graphQLStoryActionLink.ah();
        graphQLStoryActionLink$Builder.an = graphQLStoryActionLink.ai();
        graphQLStoryActionLink$Builder.ao = graphQLStoryActionLink.aj();
        graphQLStoryActionLink$Builder.ap = graphQLStoryActionLink.aF();
        graphQLStoryActionLink$Builder.aq = graphQLStoryActionLink.aT();
        graphQLStoryActionLink$Builder.ar = graphQLStoryActionLink.ak();
        graphQLStoryActionLink$Builder.as = graphQLStoryActionLink.al();
        graphQLStoryActionLink$Builder.at = graphQLStoryActionLink.am();
        graphQLStoryActionLink$Builder.au = graphQLStoryActionLink.an();
        graphQLStoryActionLink$Builder.av = graphQLStoryActionLink.ao();
        graphQLStoryActionLink$Builder.aw = graphQLStoryActionLink.ap();
        graphQLStoryActionLink$Builder.ax = graphQLStoryActionLink.aq();
        graphQLStoryActionLink$Builder.ay = graphQLStoryActionLink.b();
        graphQLStoryActionLink$Builder.az = graphQLStoryActionLink.ar();
        graphQLStoryActionLink$Builder.aA = graphQLStoryActionLink.as();
        graphQLStoryActionLink$Builder.aB = graphQLStoryActionLink.at();
        graphQLStoryActionLink$Builder.aC = graphQLStoryActionLink.au();
        graphQLStoryActionLink$Builder.aD = graphQLStoryActionLink.av();
        graphQLStoryActionLink$Builder.aE = graphQLStoryActionLink.aw();
        graphQLStoryActionLink$Builder.aF = graphQLStoryActionLink.ax();
        graphQLStoryActionLink$Builder.aG = graphQLStoryActionLink.aJ();
        graphQLStoryActionLink$Builder.aH = graphQLStoryActionLink.ay();
        graphQLStoryActionLink$Builder.aI = graphQLStoryActionLink.az();
        graphQLStoryActionLink$Builder.aJ = graphQLStoryActionLink.aA();
        graphQLStoryActionLink$Builder.aK = graphQLStoryActionLink.aB();
        graphQLStoryActionLink$Builder.aL = graphQLStoryActionLink.aC();
        graphQLStoryActionLink$Builder.aM = graphQLStoryActionLink.aD();
        graphQLStoryActionLink$Builder.aN = graphQLStoryActionLink.aE();
        graphQLStoryActionLink$Builder.aO = graphQLStoryActionLink.aI();
        Builder.a(graphQLStoryActionLink$Builder, graphQLStoryActionLink);
        graphQLStoryActionLink$Builder.aP = graphQLStoryActionLink.a();
        return graphQLStoryActionLink$Builder;
    }

    public final GraphQLStoryActionLink m21842a() {
        return new GraphQLStoryActionLink(this);
    }
}
