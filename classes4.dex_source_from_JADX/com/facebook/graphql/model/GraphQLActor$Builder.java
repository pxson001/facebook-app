package com.facebook.graphql.model;

import com.facebook.graphql.enums.GraphQLFriendshipStatus;
import com.facebook.graphql.enums.GraphQLGender;
import com.facebook.graphql.enums.GraphQLLiveVideoSubscriptionStatus;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.enums.GraphQLSecondarySubscribeStatus;
import com.facebook.graphql.enums.GraphQLSubscribeStatus;
import com.facebook.graphql.modelutil.BaseModel.Builder;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;

/* compiled from: rtc_voicemail_prompt_url_ */
public class GraphQLActor$Builder extends Builder {
    @Nullable
    public GraphQLPage f3060A;
    @Nullable
    public String f3061B;
    public boolean f3062C;
    public boolean f3063D;
    public boolean f3064E;
    public boolean f3065F;
    public boolean f3066G;
    public boolean f3067H;
    public boolean f3068I;
    public boolean f3069J;
    public boolean f3070K;
    public boolean f3071L;
    public boolean f3072M;
    public boolean f3073N;
    public boolean f3074O;
    @Nullable
    public GraphQLLikedProfilesConnection f3075P;
    public GraphQLLiveVideoSubscriptionStatus f3076Q = GraphQLLiveVideoSubscriptionStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    public long f3077R;
    public double f3078S;
    @Nullable
    public String f3079T;
    @Nullable
    public GraphQLMutualFriendsConnection f3080U;
    @Nullable
    public String f3081V;
    public ImmutableList<String> f3082W;
    @Nullable
    public GraphQLNewsFeedConnection f3083X;
    @Nullable
    public GraphQLPageLikersConnection f3084Y;
    @Nullable
    public GraphQLPrivacyScope f3085Z;
    public boolean aA;
    public int aB;
    public int aC;
    @Nullable
    public GraphQLTextWithEntities aD;
    @Nullable
    public GraphQLTextWithEntities aE;
    public boolean aF;
    public double aG;
    @Nullable
    public GraphQLObjectType aH = null;
    @Nullable
    public GraphQLImage aa;
    @Nullable
    public GraphQLProfileBadge ab;
    @Nullable
    public GraphQLPhoto ac;
    @Nullable
    public GraphQLImage ad;
    public long ae;
    public boolean af;
    @Nullable
    public GraphQLProfileVideo ag;
    @Nullable
    public String ah;
    @Nullable
    public String ai;
    public GraphQLSecondarySubscribeStatus aj = GraphQLSecondarySubscribeStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    @Nullable
    public String ak;
    @Nullable
    public GraphQLSinglePublisherVideoChannelsConnection al;
    @Nullable
    public GraphQLImage am;
    @Nullable
    public GraphQLImage an;
    @Nullable
    public GraphQLImage ao;
    @Nullable
    public GraphQLName ap;
    public GraphQLSubscribeStatus aq = GraphQLSubscribeStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    @Nullable
    public GraphQLTextWithEntities ar;
    public int as;
    @Nullable
    public String at;
    @Nullable
    public String au;
    public boolean av;
    public boolean aw;
    @Nullable
    public GraphQLProfile ax;
    public boolean ay;
    public boolean az;
    @Nullable
    public GraphQLPageAdminInfo f3086d;
    @Nullable
    public String f3087e;
    @Nullable
    public GraphQLAppStoreApplication f3088f;
    @Nullable
    public GraphQLTextWithEntities f3089g;
    @Nullable
    public GraphQLFriendsConnection f3090h;
    public boolean f3091i;
    public boolean f3092j;
    public boolean f3093k;
    public boolean f3094l;
    public boolean f3095m;
    public boolean f3096n;
    public boolean f3097o;
    public ImmutableList<String> f3098p;
    public double f3099q;
    @Nullable
    public GraphQLFocusedPhoto f3100r;
    @Nullable
    public GraphQLPage f3101s;
    @Nullable
    public String f3102t;
    public ImmutableList<String> f3103u;
    @Nullable
    public String f3104v;
    @Nullable
    public GraphQLEventsConnection f3105w;
    @Nullable
    public GraphQLFriendsConnection f3106x;
    public GraphQLFriendshipStatus f3107y = GraphQLFriendshipStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    public GraphQLGender f3108z = GraphQLGender.UNSET_OR_UNRECOGNIZED_ENUM_VALUE;

    public GraphQLActor$Builder() {
        Preconditions.checkState(this instanceof GraphQLActor$Builder);
    }

    public static GraphQLActor$Builder m3387a(GraphQLActor graphQLActor) {
        GraphQLActor$Builder graphQLActor$Builder = new GraphQLActor$Builder();
        graphQLActor.h();
        graphQLActor$Builder.f3086d = graphQLActor.j();
        graphQLActor$Builder.f3087e = graphQLActor.k();
        graphQLActor$Builder.f3088f = graphQLActor.l();
        graphQLActor$Builder.f3089g = graphQLActor.m();
        graphQLActor$Builder.f3090h = graphQLActor.n();
        graphQLActor$Builder.f3091i = graphQLActor.o();
        graphQLActor$Builder.f3092j = graphQLActor.p();
        graphQLActor$Builder.f3093k = graphQLActor.q();
        graphQLActor$Builder.f3094l = graphQLActor.r();
        graphQLActor$Builder.f3095m = graphQLActor.s();
        graphQLActor$Builder.f3096n = graphQLActor.t();
        graphQLActor$Builder.f3097o = graphQLActor.u();
        graphQLActor$Builder.f3098p = graphQLActor.v();
        graphQLActor$Builder.f3099q = graphQLActor.w();
        graphQLActor$Builder.f3100r = graphQLActor.x();
        graphQLActor$Builder.f3101s = graphQLActor.y();
        graphQLActor$Builder.f3102t = graphQLActor.z();
        graphQLActor$Builder.f3103u = graphQLActor.A();
        graphQLActor$Builder.f3104v = graphQLActor.B();
        graphQLActor$Builder.f3105w = graphQLActor.C();
        graphQLActor$Builder.f3106x = graphQLActor.D();
        graphQLActor$Builder.f3107y = graphQLActor.E();
        graphQLActor$Builder.f3108z = graphQLActor.F();
        graphQLActor$Builder.f3060A = graphQLActor.G();
        graphQLActor$Builder.f3061B = graphQLActor.H();
        graphQLActor$Builder.f3062C = graphQLActor.I();
        graphQLActor$Builder.f3063D = graphQLActor.J();
        graphQLActor$Builder.f3064E = graphQLActor.K();
        graphQLActor$Builder.f3065F = graphQLActor.L();
        graphQLActor$Builder.f3066G = graphQLActor.M();
        graphQLActor$Builder.f3067H = graphQLActor.N();
        graphQLActor$Builder.f3068I = graphQLActor.O();
        graphQLActor$Builder.f3069J = graphQLActor.P();
        graphQLActor$Builder.f3070K = graphQLActor.Q();
        graphQLActor$Builder.f3071L = graphQLActor.R();
        graphQLActor$Builder.f3072M = graphQLActor.aM();
        graphQLActor$Builder.f3073N = graphQLActor.S();
        graphQLActor$Builder.f3074O = graphQLActor.T();
        graphQLActor$Builder.f3075P = graphQLActor.U();
        graphQLActor$Builder.f3076Q = graphQLActor.V();
        graphQLActor$Builder.f3077R = graphQLActor.W();
        graphQLActor$Builder.f3078S = graphQLActor.X();
        graphQLActor$Builder.f3079T = graphQLActor.Y();
        graphQLActor$Builder.f3080U = graphQLActor.Z();
        graphQLActor$Builder.f3081V = graphQLActor.aa();
        graphQLActor$Builder.f3082W = graphQLActor.ab();
        graphQLActor$Builder.f3083X = graphQLActor.ac();
        graphQLActor$Builder.f3084Y = graphQLActor.ad();
        graphQLActor$Builder.f3085Z = graphQLActor.ae();
        graphQLActor$Builder.aa = graphQLActor.af();
        graphQLActor$Builder.ab = graphQLActor.ag();
        graphQLActor$Builder.ac = graphQLActor.ah();
        graphQLActor$Builder.ad = graphQLActor.ai();
        graphQLActor$Builder.ae = graphQLActor.aj();
        graphQLActor$Builder.af = graphQLActor.ak();
        graphQLActor$Builder.ag = graphQLActor.aL();
        graphQLActor$Builder.ah = graphQLActor.al();
        graphQLActor$Builder.ai = graphQLActor.am();
        graphQLActor$Builder.aj = graphQLActor.an();
        graphQLActor$Builder.ak = graphQLActor.aK();
        graphQLActor$Builder.al = graphQLActor.ao();
        graphQLActor$Builder.am = graphQLActor.ap();
        graphQLActor$Builder.an = graphQLActor.aq();
        graphQLActor$Builder.ao = graphQLActor.ar();
        graphQLActor$Builder.ap = graphQLActor.as();
        graphQLActor$Builder.aq = graphQLActor.at();
        graphQLActor$Builder.ar = graphQLActor.au();
        graphQLActor$Builder.as = graphQLActor.av();
        graphQLActor$Builder.at = graphQLActor.aw();
        graphQLActor$Builder.au = graphQLActor.ax();
        graphQLActor$Builder.av = graphQLActor.ay();
        graphQLActor$Builder.aw = graphQLActor.aJ();
        graphQLActor$Builder.ax = graphQLActor.az();
        graphQLActor$Builder.ay = graphQLActor.aA();
        graphQLActor$Builder.az = graphQLActor.aI();
        graphQLActor$Builder.aA = graphQLActor.aB();
        graphQLActor$Builder.aB = graphQLActor.aC();
        graphQLActor$Builder.aC = graphQLActor.aD();
        graphQLActor$Builder.aD = graphQLActor.aE();
        graphQLActor$Builder.aE = graphQLActor.aF();
        graphQLActor$Builder.aF = graphQLActor.aG();
        graphQLActor$Builder.aG = graphQLActor.aH();
        Builder.a(graphQLActor$Builder, graphQLActor);
        graphQLActor$Builder.aH = graphQLActor.b();
        return graphQLActor$Builder;
    }

    public final GraphQLActor$Builder m3388a(GraphQLFriendshipStatus graphQLFriendshipStatus) {
        this.f3107y = graphQLFriendshipStatus;
        if (this.a != null && this.a.d) {
            this.a.a(this.b, 26, graphQLFriendshipStatus);
        }
        return this;
    }

    public final GraphQLActor m3389a() {
        return new GraphQLActor(this);
    }
}
