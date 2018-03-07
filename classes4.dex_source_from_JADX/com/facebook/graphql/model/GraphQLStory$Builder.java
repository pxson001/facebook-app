package com.facebook.graphql.model;

import com.facebook.graphql.enums.GraphQLEditPostFeatureCapability;
import com.facebook.graphql.enums.GraphQLStorySeenState;
import com.facebook.graphql.enums.GraphQLStoryTimestampStyle;
import com.facebook.graphql.enums.GraphQLSubstoriesGroupingReason;
import com.facebook.graphql.modelutil.BaseModel.Builder;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;

/* compiled from: rtc_speex_artifacts_uni */
public class GraphQLStory$Builder extends Builder {
    @Nullable
    public GraphQLEditHistoryConnection f3175A;
    @Nullable
    public GraphQLPlace f3176B;
    @Nullable
    public GraphQLFeedTopicContent f3177C;
    @Nullable
    public GraphQLFeedback f3178D;
    @Nullable
    public GraphQLFeedbackContext f3179E;
    public long f3180F;
    @Nullable
    public GraphQLFollowUpFeedUnitsConnection f3181G;
    public boolean f3182H;
    @Nullable
    public String f3183I;
    @Nullable
    public GraphQLIcon f3184J;
    @Nullable
    public String f3185K;
    @Nullable
    public GraphQLPlace f3186L;
    @Nullable
    public GraphQLInlineActivitiesConnection f3187M;
    @Nullable
    public GraphQLStoryInsights f3188N;
    public boolean f3189O;
    @Nullable
    public String f3190P;
    public boolean f3191Q;
    public boolean f3192R;
    public boolean f3193S;
    public boolean f3194T;
    @Nullable
    public String f3195U;
    @Nullable
    public String f3196V;
    public int f3197W;
    @Nullable
    public GraphQLTextWithEntities f3198X;
    @Nullable
    public GraphQLTextWithEntities f3199Y;
    public ImmutableList<GraphQLStoryAttachment> f3200Z;
    @Nullable
    public GraphQLProfile aA;
    @Nullable
    public GraphQLStoryTopicsContext aB;
    @Nullable
    public String aC;
    @Nullable
    public GraphQLPostTranslatability aD;
    @Nullable
    public GraphQLTextWithEntities aE;
    @Nullable
    public GraphQLTranslationMetaData aF;
    @Nullable
    public String aG;
    @Nullable
    public GraphQLActor aH;
    public ImmutableList<GraphQLEditPostFeatureCapability> aI;
    public boolean aJ;
    @Nullable
    public GraphQLWithTagsConnection aK;
    @Nullable
    PropertyBag aL = null;
    @Nullable
    public GraphQLNegativeFeedbackActionsConnection aa;
    @Nullable
    public GraphQLPlace ab;
    @Nullable
    public GraphQLPlaceRecommendationPostInfo ac;
    @Nullable
    public GraphQLBoostedComponent ad;
    @Nullable
    public GraphQLPrivacyScope ae;
    @Nullable
    public GraphQLPagePostPromotionInfo af;
    @Nullable
    public GraphQLRedSpaceStoryInfo ag;
    @Nullable
    public GraphQLSticker ah;
    @Nullable
    public GraphQLStorySaveInfo ai;
    public ImmutableList<GraphQLActor> aj;
    public GraphQLStorySeenState ak = GraphQLStorySeenState.UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    @Nullable
    public GraphQLEntity al;
    @Nullable
    public GraphQLTextWithEntities am;
    @Nullable
    public String an;
    @Nullable
    public GraphQLSponsoredData ao;
    public ImmutableList<GraphQLStoryAttachment> ap;
    @Nullable
    public GraphQLStoryHeader aq;
    public long ar;
    public ImmutableList<GraphQLStoryTimestampStyle> as;
    public ImmutableList<GraphQLSubstoriesGroupingReason> at;
    public int au;
    @Nullable
    public GraphQLTextWithEntities av;
    @Nullable
    public GraphQLTextWithEntities aw;
    @Nullable
    public GraphQLStory ax;
    @Nullable
    public GraphQLTextWithEntities ay;
    @Nullable
    public GraphQLTextWithEntities az;
    public ImmutableList<GraphQLStoryActionLink> f3201d;
    public ImmutableList<GraphQLOpenGraphAction> f3202e;
    public ImmutableList<GraphQLActor> f3203f;
    @Nullable
    public GraphQLSubstoriesConnection f3204g;
    public ImmutableList<String> f3205h;
    @Nullable
    public GraphQLImage f3206i;
    @Nullable
    public GraphQLApplication f3207j;
    public ImmutableList<GraphQLStoryActionLink> f3208k;
    @Nullable
    public GraphQLStory f3209l;
    public ImmutableList<GraphQLStoryAttachment> f3210m;
    @Nullable
    public GraphQLBackdatedTime f3211n;
    @Nullable
    public String f3212o;
    public boolean f3213p;
    public boolean f3214q;
    public boolean f3215r;
    public boolean f3216s;
    public boolean f3217t;
    public boolean f3218u;
    @Nullable
    public String f3219v;
    @Nullable
    public GraphQLStory f3220w;
    public long f3221x;
    @Nullable
    public String f3222y;
    @Nullable
    public GraphQLTextWithEntities f3223z;

    public GraphQLStory$Builder() {
        Preconditions.checkState(this instanceof GraphQLStory$Builder);
    }

    public static GraphQLStory$Builder m3407a(GraphQLStory graphQLStory) {
        GraphQLStory$Builder graphQLStory$Builder = new GraphQLStory$Builder();
        graphQLStory.h();
        graphQLStory$Builder.f3201d = graphQLStory.E();
        graphQLStory$Builder.f3202e = graphQLStory.F();
        graphQLStory$Builder.f3203f = graphQLStory.b();
        graphQLStory$Builder.f3204g = graphQLStory.G();
        graphQLStory$Builder.f3205h = graphQLStory.H();
        graphQLStory$Builder.f3206i = graphQLStory.I();
        graphQLStory$Builder.f3207j = graphQLStory.J();
        graphQLStory$Builder.f3208k = graphQLStory.K();
        graphQLStory$Builder.f3209l = graphQLStory.L();
        graphQLStory$Builder.f3210m = graphQLStory.M();
        graphQLStory$Builder.f3211n = graphQLStory.bc();
        graphQLStory$Builder.f3212o = graphQLStory.g();
        graphQLStory$Builder.f3213p = graphQLStory.N();
        graphQLStory$Builder.f3214q = graphQLStory.O();
        graphQLStory$Builder.f3215r = graphQLStory.P();
        graphQLStory$Builder.f3216s = graphQLStory.Q();
        graphQLStory$Builder.f3217t = graphQLStory.R();
        graphQLStory$Builder.f3218u = graphQLStory.S();
        graphQLStory$Builder.f3219v = graphQLStory.T();
        graphQLStory$Builder.f3220w = graphQLStory.U();
        graphQLStory$Builder.f3221x = graphQLStory.V();
        graphQLStory$Builder.f3222y = graphQLStory.S_();
        graphQLStory$Builder.f3223z = graphQLStory.W();
        graphQLStory$Builder.f3175A = graphQLStory.X();
        graphQLStory$Builder.f3176B = graphQLStory.Y();
        graphQLStory$Builder.f3177C = graphQLStory.Z();
        graphQLStory$Builder.f3178D = graphQLStory.l();
        graphQLStory$Builder.f3179E = graphQLStory.aa();
        graphQLStory$Builder.f3180F = graphQLStory.T_();
        graphQLStory$Builder.f3181G = graphQLStory.ab();
        graphQLStory$Builder.f3182H = graphQLStory.ac();
        graphQLStory$Builder.f3183I = graphQLStory.y();
        graphQLStory$Builder.f3184J = graphQLStory.ad();
        graphQLStory$Builder.f3185K = graphQLStory.c();
        graphQLStory$Builder.f3186L = graphQLStory.ae();
        graphQLStory$Builder.f3187M = graphQLStory.af();
        graphQLStory$Builder.f3188N = graphQLStory.ag();
        graphQLStory$Builder.f3189O = graphQLStory.ah();
        graphQLStory$Builder.f3190P = graphQLStory.ai();
        graphQLStory$Builder.f3191Q = graphQLStory.aT();
        graphQLStory$Builder.f3192R = graphQLStory.aU();
        graphQLStory$Builder.f3193S = graphQLStory.aV();
        graphQLStory$Builder.f3194T = graphQLStory.aW();
        graphQLStory$Builder.f3195U = graphQLStory.aX();
        graphQLStory$Builder.f3196V = graphQLStory.aY();
        graphQLStory$Builder.f3197W = graphQLStory.bb();
        graphQLStory$Builder.f3198X = graphQLStory.aj();
        graphQLStory$Builder.f3199Y = graphQLStory.ba();
        graphQLStory$Builder.f3200Z = graphQLStory.ak();
        graphQLStory$Builder.aa = graphQLStory.C();
        graphQLStory$Builder.ab = graphQLStory.al();
        graphQLStory$Builder.ac = graphQLStory.am();
        graphQLStory$Builder.ad = graphQLStory.an();
        graphQLStory$Builder.ae = graphQLStory.ao();
        graphQLStory$Builder.af = graphQLStory.ap();
        graphQLStory$Builder.ag = graphQLStory.aq();
        graphQLStory$Builder.ah = graphQLStory.ar();
        graphQLStory$Builder.ai = graphQLStory.as();
        graphQLStory$Builder.aj = graphQLStory.at();
        graphQLStory$Builder.ak = graphQLStory.au();
        graphQLStory$Builder.al = graphQLStory.av();
        graphQLStory$Builder.am = graphQLStory.aw();
        graphQLStory$Builder.an = graphQLStory.ax();
        graphQLStory$Builder.ao = graphQLStory.ay();
        graphQLStory$Builder.ap = graphQLStory.az();
        graphQLStory$Builder.aq = graphQLStory.aA();
        graphQLStory$Builder.ar = graphQLStory.aZ();
        graphQLStory$Builder.as = graphQLStory.aB();
        graphQLStory$Builder.at = graphQLStory.aC();
        graphQLStory$Builder.au = graphQLStory.aD();
        graphQLStory$Builder.av = graphQLStory.aE();
        graphQLStory$Builder.aw = graphQLStory.aF();
        graphQLStory$Builder.ax = graphQLStory.aG();
        graphQLStory$Builder.ay = graphQLStory.aH();
        graphQLStory$Builder.az = graphQLStory.aI();
        graphQLStory$Builder.aA = graphQLStory.aJ();
        graphQLStory$Builder.aB = graphQLStory.aK();
        graphQLStory$Builder.aC = graphQLStory.k();
        graphQLStory$Builder.aD = graphQLStory.aL();
        graphQLStory$Builder.aE = graphQLStory.aM();
        graphQLStory$Builder.aF = graphQLStory.aN();
        graphQLStory$Builder.aG = graphQLStory.aO();
        graphQLStory$Builder.aH = graphQLStory.aP();
        graphQLStory$Builder.aI = graphQLStory.aS();
        graphQLStory$Builder.aJ = graphQLStory.aQ();
        graphQLStory$Builder.aK = graphQLStory.aR();
        Builder.a(graphQLStory$Builder, graphQLStory);
        graphQLStory$Builder.aL = (PropertyBag) graphQLStory.U_().clone();
        return graphQLStory$Builder;
    }

    public final GraphQLStory$Builder m3426c(ImmutableList<GraphQLActor> immutableList) {
        this.f3203f = immutableList;
        return this;
    }

    public final GraphQLStory$Builder m3422b(@Nullable GraphQLStory graphQLStory) {
        this.f3209l = graphQLStory;
        return this;
    }

    public final GraphQLStory$Builder m3430f(ImmutableList<GraphQLStoryAttachment> immutableList) {
        this.f3210m = immutableList;
        return this;
    }

    public final GraphQLStory$Builder m3425b(boolean z) {
        this.f3214q = z;
        return this;
    }

    public final GraphQLStory$Builder m3427c(boolean z) {
        this.f3215r = z;
        return this;
    }

    public final GraphQLStory$Builder m3424b(@Nullable String str) {
        this.f3219v = str;
        return this;
    }

    public final GraphQLStory$Builder m3409a(long j) {
        this.f3221x = j;
        return this;
    }

    public final GraphQLStory$Builder m3414a(@Nullable GraphQLPlace graphQLPlace) {
        this.f3176B = graphQLPlace;
        return this;
    }

    public final GraphQLStory$Builder m3412a(@Nullable GraphQLFeedTopicContent graphQLFeedTopicContent) {
        this.f3177C = graphQLFeedTopicContent;
        return this;
    }

    public final GraphQLStory$Builder m3420b(long j) {
        this.f3180F = j;
        return this;
    }

    public final GraphQLStory$Builder m3429e(@Nullable String str) {
        this.f3185K = str;
        return this;
    }

    public final GraphQLStory$Builder m3421b(@Nullable GraphQLPlace graphQLPlace) {
        this.f3186L = graphQLPlace;
        return this;
    }

    public final GraphQLStory$Builder m3413a(@Nullable GraphQLInlineActivitiesConnection graphQLInlineActivitiesConnection) {
        this.f3187M = graphQLInlineActivitiesConnection;
        return this;
    }

    public final GraphQLStory$Builder m3431f(@Nullable String str) {
        this.f3190P = str;
        return this;
    }

    public final GraphQLStory$Builder m3433g(@Nullable String str) {
        this.f3196V = str;
        if (this.a != null && this.a.d) {
            this.a.a(this.b, 86, str);
        }
        return this;
    }

    public final GraphQLStory$Builder m3408a(int i) {
        this.f3197W = i;
        if (this.a != null && this.a.d) {
            this.a.b(this.b, 89, i);
        }
        return this;
    }

    public final GraphQLStory$Builder m3423b(@Nullable GraphQLTextWithEntities graphQLTextWithEntities) {
        this.f3198X = graphQLTextWithEntities;
        return this;
    }

    public final GraphQLStory$Builder m3415a(@Nullable GraphQLPrivacyScope graphQLPrivacyScope) {
        this.ae = graphQLPrivacyScope;
        return this;
    }

    public final GraphQLStory$Builder m3417a(@Nullable GraphQLRedSpaceStoryInfo graphQLRedSpaceStoryInfo) {
        this.ag = graphQLRedSpaceStoryInfo;
        return this;
    }

    public final GraphQLStory$Builder m3410a(GraphQLStorySeenState graphQLStorySeenState) {
        this.ak = graphQLStorySeenState;
        if (this.a != null && this.a.d) {
            this.a.a(this.b, 53, graphQLStorySeenState);
        }
        return this;
    }

    public final GraphQLStory$Builder m3411a(@Nullable GraphQLEntity graphQLEntity) {
        this.al = graphQLEntity;
        return this;
    }

    public final GraphQLStory$Builder m3428e(@Nullable GraphQLTextWithEntities graphQLTextWithEntities) {
        this.av = graphQLTextWithEntities;
        return this;
    }

    public final GraphQLStory$Builder m3432g(@Nullable GraphQLTextWithEntities graphQLTextWithEntities) {
        this.ay = graphQLTextWithEntities;
        return this;
    }

    public final GraphQLStory$Builder m3416a(@Nullable GraphQLProfile graphQLProfile) {
        this.aA = graphQLProfile;
        return this;
    }

    public final GraphQLStory$Builder m3418a(@Nullable GraphQLWithTagsConnection graphQLWithTagsConnection) {
        this.aK = graphQLWithTagsConnection;
        return this;
    }

    public final GraphQLStory m3419a() {
        return new GraphQLStory(this);
    }
}
