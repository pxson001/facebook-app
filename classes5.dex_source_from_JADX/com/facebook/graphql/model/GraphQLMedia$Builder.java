package com.facebook.graphql.model;

import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.enums.GraphQLVideoBroadcastStatus;
import com.facebook.graphql.enums.GraphQLVideoStatusType;
import com.facebook.graphql.modelutil.BaseModel.Builder;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;

/* compiled from: fb4a_profile_more */
public class GraphQLMedia$Builder extends Builder {
    @Nullable
    public GraphQLPlace f4426A;
    @Nullable
    public GraphQLPhotoFaceBoxesConnection f4427B;
    @Nullable
    public GraphQLFeedback f4428C;
    @Nullable
    public GraphQLVect2 f4429D;
    @Nullable
    public GraphQLVideoGuidedTour f4430E;
    public boolean f4431F;
    public boolean f4432G;
    public boolean f4433H;
    public int f4434I;
    public int f4435J;
    @Nullable
    public String f4436K;
    public int f4437L;
    @Nullable
    public String f4438M;
    @Nullable
    public GraphQLImage f4439N;
    @Nullable
    public GraphQLImage f4440O;
    @Nullable
    public GraphQLImage f4441P;
    @Nullable
    public GraphQLImage f4442Q;
    @Nullable
    public GraphQLImage f4443R;
    @Nullable
    public GraphQLImage f4444S;
    @Nullable
    public GraphQLImage f4445T;
    @Nullable
    public GraphQLImage f4446U;
    @Nullable
    public GraphQLImage f4447V;
    @Nullable
    public GraphQLImage f4448W;
    @Nullable
    public GraphQLImage f4449X;
    @Nullable
    public GraphQLImage f4450Y;
    @Nullable
    public GraphQLImage f4451Z;
    @Nullable
    public GraphQLImage aA;
    @Nullable
    public String aB;
    @Nullable
    public GraphQLImage aC;
    @Nullable
    public GraphQLImage aD;
    @Nullable
    public GraphQLActor aE;
    @Nullable
    public GraphQLVideo aF;
    @Nullable
    public GraphQLPlace aG;
    public ImmutableList<GraphQLPhotoEncoding> aH;
    public int aI;
    @Nullable
    public String aJ;
    @Nullable
    public String aK;
    public int aL;
    public int aM;
    @Nullable
    public String aN;
    @Nullable
    public String aO;
    @Nullable
    public GraphQLImage aP;
    public int aQ;
    @Nullable
    public String aR;
    @Nullable
    public GraphQLPrivacyScope aS;
    @Nullable
    public GraphQLImageOverlay aT;
    @Nullable
    public String aU;
    @Nullable
    public GraphQLTextWithEntities aV;
    @Nullable
    public GraphQLImage aW;
    public boolean aX;
    public boolean aY;
    public boolean aZ;
    @Nullable
    public GraphQLImage aa;
    @Nullable
    public GraphQLImage ab;
    public int ac;
    public int ad;
    public int ae;
    @Nullable
    public GraphQLInlineActivitiesConnection af;
    public boolean ag;
    public boolean ah;
    public boolean ai;
    public boolean aj;
    public boolean ak;
    public boolean al;
    public boolean am;
    public boolean an;
    public boolean ao;
    public boolean ap;
    public boolean aq;
    @Nullable
    public GraphQLImage ar;
    @Nullable
    public GraphQLImage as;
    @Nullable
    public GraphQLImage at;
    public int au;
    @Nullable
    public GraphQLPlaceSuggestionInfo av;
    public int aw;
    @Nullable
    public GraphQLImage ax;
    @Nullable
    public GraphQLTextWithEntities ay;
    @Nullable
    public String az;
    public boolean ba;
    public boolean bb;
    public boolean bc;
    public double bd;
    public double be;
    @Nullable
    public String bf;
    @Nullable
    public String bg;
    public int bh;
    @Nullable
    public GraphQLPage bi;
    @Nullable
    public GraphQLImage bj;
    @Nullable
    public GraphQLStreamingImage bk;
    @Nullable
    public GraphQLStreamingImage bl;
    public boolean bm;
    @Nullable
    public GraphQLPhotoTagsConnection bn;
    public int bo;
    public ImmutableList<String> bp;
    @Nullable
    public GraphQLVideoChannel bq;
    public int br;
    public GraphQLVideoStatusType bs = GraphQLVideoStatusType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    public int bt;
    @Nullable
    public GraphQLWithTagsConnection bu;
    @Nullable
    public GraphQLObjectType bv = null;
    @Nullable
    public String f4452d;
    @Nullable
    public GraphQLAlbum f4453e;
    @Nullable
    public GraphQLImage f4454f;
    public int f4455g;
    @Nullable
    public GraphQLApplication f4456h;
    @Nullable
    public String f4457i;
    public long f4458j;
    public int f4459k;
    public GraphQLVideoBroadcastStatus f4460l = GraphQLVideoBroadcastStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    public boolean f4461m;
    public boolean f4462n;
    public boolean f4463o;
    public boolean f4464p;
    public boolean f4465q;
    public boolean f4466r;
    public boolean f4467s;
    public boolean f4468t;
    public boolean f4469u;
    public boolean f4470v;
    @Nullable
    public String f4471w;
    @Nullable
    public GraphQLStory f4472x;
    public long f4473y;
    @Nullable
    public GraphQLStory f4474z;

    public GraphQLMedia$Builder() {
        Preconditions.checkState(this instanceof GraphQLMedia$Builder);
    }

    public static GraphQLMedia$Builder m9002a(GraphQLMedia graphQLMedia) {
        GraphQLMedia$Builder graphQLMedia$Builder = new GraphQLMedia$Builder();
        graphQLMedia.h();
        graphQLMedia$Builder.f4452d = graphQLMedia.k();
        graphQLMedia$Builder.f4453e = graphQLMedia.l();
        graphQLMedia$Builder.f4454f = graphQLMedia.m();
        graphQLMedia$Builder.f4455g = graphQLMedia.n();
        graphQLMedia$Builder.f4456h = graphQLMedia.o();
        graphQLMedia$Builder.f4457i = graphQLMedia.p();
        graphQLMedia$Builder.f4458j = graphQLMedia.q();
        graphQLMedia$Builder.f4459k = graphQLMedia.r();
        graphQLMedia$Builder.f4460l = graphQLMedia.br();
        graphQLMedia$Builder.f4461m = graphQLMedia.s();
        graphQLMedia$Builder.f4462n = graphQLMedia.t();
        graphQLMedia$Builder.f4463o = graphQLMedia.u();
        graphQLMedia$Builder.f4464p = graphQLMedia.v();
        graphQLMedia$Builder.f4465q = graphQLMedia.w();
        graphQLMedia$Builder.f4466r = graphQLMedia.x();
        graphQLMedia$Builder.f4467s = graphQLMedia.y();
        graphQLMedia$Builder.f4468t = graphQLMedia.z();
        graphQLMedia$Builder.f4469u = graphQLMedia.A();
        graphQLMedia$Builder.f4470v = graphQLMedia.B();
        graphQLMedia$Builder.f4471w = graphQLMedia.C();
        graphQLMedia$Builder.f4472x = graphQLMedia.D();
        graphQLMedia$Builder.f4473y = graphQLMedia.E();
        graphQLMedia$Builder.f4474z = graphQLMedia.F();
        graphQLMedia$Builder.f4426A = graphQLMedia.G();
        graphQLMedia$Builder.f4427B = graphQLMedia.H();
        graphQLMedia$Builder.f4428C = graphQLMedia.I();
        graphQLMedia$Builder.f4429D = graphQLMedia.J();
        graphQLMedia$Builder.f4430E = graphQLMedia.K();
        graphQLMedia$Builder.f4431F = graphQLMedia.L();
        graphQLMedia$Builder.f4432G = graphQLMedia.M();
        graphQLMedia$Builder.f4433H = graphQLMedia.N();
        graphQLMedia$Builder.f4434I = graphQLMedia.O();
        graphQLMedia$Builder.f4435J = graphQLMedia.P();
        graphQLMedia$Builder.f4436K = graphQLMedia.Q();
        graphQLMedia$Builder.f4437L = graphQLMedia.R();
        graphQLMedia$Builder.f4438M = graphQLMedia.b();
        graphQLMedia$Builder.f4439N = graphQLMedia.S();
        graphQLMedia$Builder.f4440O = graphQLMedia.T();
        graphQLMedia$Builder.f4441P = graphQLMedia.U();
        graphQLMedia$Builder.f4442Q = graphQLMedia.V();
        graphQLMedia$Builder.f4443R = graphQLMedia.W();
        graphQLMedia$Builder.f4444S = graphQLMedia.X();
        graphQLMedia$Builder.f4445T = graphQLMedia.Y();
        graphQLMedia$Builder.f4446U = graphQLMedia.Z();
        graphQLMedia$Builder.f4447V = graphQLMedia.bq();
        graphQLMedia$Builder.f4448W = graphQLMedia.aa();
        graphQLMedia$Builder.f4449X = graphQLMedia.ab();
        graphQLMedia$Builder.f4450Y = graphQLMedia.ac();
        graphQLMedia$Builder.f4451Z = graphQLMedia.ad();
        graphQLMedia$Builder.aa = graphQLMedia.ae();
        graphQLMedia$Builder.ab = graphQLMedia.bt();
        graphQLMedia$Builder.ac = graphQLMedia.af();
        graphQLMedia$Builder.ad = graphQLMedia.ag();
        graphQLMedia$Builder.ae = graphQLMedia.ah();
        graphQLMedia$Builder.af = graphQLMedia.ai();
        graphQLMedia$Builder.ag = graphQLMedia.aj();
        graphQLMedia$Builder.ah = graphQLMedia.bx();
        graphQLMedia$Builder.ai = graphQLMedia.ak();
        graphQLMedia$Builder.aj = graphQLMedia.by();
        graphQLMedia$Builder.ak = graphQLMedia.al();
        graphQLMedia$Builder.al = graphQLMedia.am();
        graphQLMedia$Builder.am = graphQLMedia.an();
        graphQLMedia$Builder.an = graphQLMedia.ao();
        graphQLMedia$Builder.ao = graphQLMedia.ap();
        graphQLMedia$Builder.ap = graphQLMedia.aq();
        graphQLMedia$Builder.aq = graphQLMedia.ar();
        graphQLMedia$Builder.ar = graphQLMedia.as();
        graphQLMedia$Builder.as = graphQLMedia.at();
        graphQLMedia$Builder.at = graphQLMedia.au();
        graphQLMedia$Builder.au = graphQLMedia.av();
        graphQLMedia$Builder.av = graphQLMedia.aw();
        graphQLMedia$Builder.aw = graphQLMedia.ax();
        graphQLMedia$Builder.ax = graphQLMedia.ay();
        graphQLMedia$Builder.ay = graphQLMedia.az();
        graphQLMedia$Builder.az = graphQLMedia.aA();
        graphQLMedia$Builder.aA = graphQLMedia.aB();
        graphQLMedia$Builder.aB = graphQLMedia.aC();
        graphQLMedia$Builder.aC = graphQLMedia.aD();
        graphQLMedia$Builder.aD = graphQLMedia.aE();
        graphQLMedia$Builder.aE = graphQLMedia.aF();
        graphQLMedia$Builder.aF = graphQLMedia.aG();
        graphQLMedia$Builder.aG = graphQLMedia.aH();
        graphQLMedia$Builder.aH = graphQLMedia.aI();
        graphQLMedia$Builder.aI = graphQLMedia.aJ();
        graphQLMedia$Builder.aJ = graphQLMedia.aK();
        graphQLMedia$Builder.aK = graphQLMedia.aL();
        graphQLMedia$Builder.aL = graphQLMedia.aM();
        graphQLMedia$Builder.aM = graphQLMedia.aN();
        graphQLMedia$Builder.aN = graphQLMedia.aO();
        graphQLMedia$Builder.aO = graphQLMedia.aP();
        graphQLMedia$Builder.aP = graphQLMedia.aQ();
        graphQLMedia$Builder.aQ = graphQLMedia.bz();
        graphQLMedia$Builder.aR = graphQLMedia.aR();
        graphQLMedia$Builder.aS = graphQLMedia.aS();
        graphQLMedia$Builder.aT = graphQLMedia.aT();
        graphQLMedia$Builder.aU = graphQLMedia.aU();
        graphQLMedia$Builder.aV = graphQLMedia.aV();
        graphQLMedia$Builder.aW = graphQLMedia.aW();
        graphQLMedia$Builder.aX = graphQLMedia.aX();
        graphQLMedia$Builder.aY = graphQLMedia.aY();
        graphQLMedia$Builder.aZ = graphQLMedia.aZ();
        graphQLMedia$Builder.ba = graphQLMedia.ba();
        graphQLMedia$Builder.bb = graphQLMedia.bs();
        graphQLMedia$Builder.bc = graphQLMedia.bb();
        graphQLMedia$Builder.bd = graphQLMedia.bc();
        graphQLMedia$Builder.be = graphQLMedia.bd();
        graphQLMedia$Builder.bf = graphQLMedia.be();
        graphQLMedia$Builder.bg = graphQLMedia.bf();
        graphQLMedia$Builder.bh = graphQLMedia.bg();
        graphQLMedia$Builder.bi = graphQLMedia.bw();
        graphQLMedia$Builder.bj = graphQLMedia.bh();
        graphQLMedia$Builder.bk = graphQLMedia.bi();
        graphQLMedia$Builder.bl = graphQLMedia.bj();
        graphQLMedia$Builder.bm = graphQLMedia.bv();
        graphQLMedia$Builder.bn = graphQLMedia.bk();
        graphQLMedia$Builder.bo = graphQLMedia.bA();
        graphQLMedia$Builder.bp = graphQLMedia.bl();
        graphQLMedia$Builder.bq = graphQLMedia.bm();
        graphQLMedia$Builder.br = graphQLMedia.bn();
        graphQLMedia$Builder.bs = graphQLMedia.bu();
        graphQLMedia$Builder.bt = graphQLMedia.bo();
        graphQLMedia$Builder.bu = graphQLMedia.bp();
        Builder.a(graphQLMedia$Builder, graphQLMedia);
        graphQLMedia$Builder.bv = graphQLMedia.j();
        return graphQLMedia$Builder;
    }

    public final GraphQLMedia$Builder m9004a(@Nullable GraphQLImage graphQLImage) {
        this.f4454f = graphQLImage;
        return this;
    }

    public final GraphQLMedia$Builder m9008e(int i) {
        this.f4437L = i;
        return this;
    }

    public final GraphQLMedia$Builder m9006b(@Nullable GraphQLImage graphQLImage) {
        this.f4439N = graphQLImage;
        return this;
    }

    public final GraphQLMedia$Builder m9007c(@Nullable GraphQLImage graphQLImage) {
        this.f4440O = graphQLImage;
        return this;
    }

    public final GraphQLMedia$Builder m9009i(@Nullable GraphQLImage graphQLImage) {
        this.f4446U = graphQLImage;
        return this;
    }

    public final GraphQLMedia$Builder m9010j(@Nullable String str) {
        this.aN = str;
        return this;
    }

    public final GraphQLMedia$Builder m9011r(int i) {
        this.bt = i;
        return this;
    }

    public final GraphQLMedia$Builder m9003a(@Nullable GraphQLObjectType graphQLObjectType) {
        this.bv = graphQLObjectType;
        return this;
    }

    public final GraphQLMedia m9005a() {
        return new GraphQLMedia(this);
    }
}
