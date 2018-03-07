package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.json.AutoGenJsonSerializer;
import com.facebook.dracula.api.FieldOffset;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLSavedState;
import com.facebook.graphql.enums.GraphQLVideoBroadcastStatus;
import com.facebook.graphql.enums.GraphQLVideoStatusType;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ImmutableListHelper;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.modelutil.TypeModel;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.instagram.common.json.annotation.JsonType;
import java.util.List;
import javax.annotation.Nullable;

@AutoGenJsonDeserializer
@AutoGenJsonSerializer
@Deprecated
@JsonType
/* compiled from: local_group_did_unpin */
public final class GraphQLVideo extends BaseModel implements Feedbackable, TypeModel, GraphQLPersistableNode, GraphQLVisitableModel {
    public static final Creator<GraphQLVideo> CREATOR = new C07681();
    int f17047A;
    @Nullable
    String f17048B;
    @Nullable
    GraphQLImage f17049C;
    @Nullable
    GraphQLImage f17050D;
    @Nullable
    GraphQLImage f17051E;
    @Nullable
    GraphQLImage f17052F;
    @Nullable
    GraphQLImage f17053G;
    @Nullable
    GraphQLImage f17054H;
    @Nullable
    GraphQLImage f17055I;
    @Nullable
    GraphQLImage f17056J;
    @Nullable
    GraphQLImage f17057K;
    @Nullable
    GraphQLImage f17058L;
    @Nullable
    GraphQLImage f17059M;
    @Nullable
    GraphQLImage f17060N;
    @Nullable
    GraphQLImage f17061O;
    @Nullable
    GraphQLImage f17062P;
    int f17063Q;
    int f17064R;
    int f17065S;
    @Deprecated
    @Nullable
    GraphQLInlineActivitiesConnection f17066T;
    boolean f17067U;
    boolean f17068V;
    boolean f17069W;
    boolean f17070X;
    boolean f17071Y;
    boolean f17072Z;
    @Nullable
    GraphQLImage aA;
    @Nullable
    String aB;
    int aC;
    @Nullable
    GraphQLImage aD;
    @Nullable
    GraphQLImage aE;
    @Nullable
    GraphQLImage aF;
    @Nullable
    GraphQLImage aG;
    @Nullable
    GraphQLImage aH;
    @Nullable
    GraphQLPhoto aI;
    @Nullable
    GraphQLImage aJ;
    boolean aK;
    @Nullable
    String aL;
    @Nullable
    GraphQLTextWithEntities aM;
    @Nullable
    GraphQLImage aN;
    @Nullable
    GraphQLRating aO;
    @Nullable
    GraphQLTimelineAppCollection aP;
    boolean aQ;
    boolean aR;
    @Deprecated
    boolean aS;
    double aT;
    double aU;
    @Nullable
    String aV;
    @Nullable
    String aW;
    int aX;
    @Nullable
    GraphQLImage aY;
    @Nullable
    GraphQLStreamingImage aZ;
    boolean aa;
    boolean ab;
    @Nullable
    GraphQLImage ac;
    @Nullable
    GraphQLImage ad;
    @Nullable
    GraphQLImage ae;
    int af;
    int ag;
    int ah;
    @Nullable
    GraphQLImage ai;
    @Nullable
    GraphQLTextWithEntities aj;
    @Nullable
    String ak;
    @Nullable
    GraphQLImage al;
    @Nullable
    String am;
    @Nullable
    String an;
    @Nullable
    GraphQLImage ao;
    @Nullable
    GraphQLImage ap;
    @Nullable
    GraphQLActor aq;
    int ar;
    @Nullable
    String as;
    @Nullable
    String at;
    int au;
    int av;
    @Nullable
    String aw;
    @Nullable
    String ax;
    @Nullable
    String ay;
    @Nullable
    String az;
    @Nullable
    String bA;
    @Nullable
    String bB;
    boolean bC;
    @Nullable
    String bD;
    int bE;
    int bF;
    List<GraphQLUser> bG;
    boolean bH;
    @Nullable
    GraphQLTextWithEntities bI;
    @Nullable
    GraphQLStreamingImage ba;
    @Nullable
    GraphQLImage bb;
    @Nullable
    GraphQLTextWithEntities bc;
    @Nullable
    GraphQLTextWithEntities bd;
    @Nullable
    String be;
    @Nullable
    GraphQLImage bf;
    List<String> bg;
    @Nullable
    GraphQLVideoChannel bh;
    int bi;
    @Nullable
    GraphQLImage bj;
    GraphQLVideoStatusType bk;
    GraphQLSavedState bl;
    List<GraphQLTimelineAppCollection> bm;
    List<GraphQLTimelineAppCollection> bn;
    int bo;
    @Nullable
    GraphQLImage bp;
    @Nullable
    String bq;
    List<String> br;
    boolean bs;
    @Nullable
    String bt;
    List<Integer> bu;
    @Nullable
    String bv;
    boolean bw;
    @Nullable
    GraphQLImage bx;
    boolean by;
    @Nullable
    GraphQLPage bz;
    @Nullable
    GraphQLImage f17073d;
    @Nullable
    GraphQLImage f17074e;
    int f17075f;
    @Deprecated
    @Nullable
    GraphQLApplication f17076g;
    @Deprecated
    @Nullable
    String f17077h;
    long f17078i;
    int f17079j;
    GraphQLVideoBroadcastStatus f17080k;
    boolean f17081l;
    boolean f17082m;
    boolean f17083n;
    @Nullable
    String f17084o;
    long f17085p;
    @Nullable
    GraphQLStory f17086q;
    @Nullable
    GraphQLPlace f17087r;
    @Nullable
    GraphQLImage f17088s;
    @Nullable
    GraphQLFeedback f17089t;
    @Nullable
    GraphQLVideoGuidedTour f17090u;
    boolean f17091v;
    boolean f17092w;
    int f17093x;
    int f17094y;
    @Nullable
    String f17095z;

    /* compiled from: local_group_did_unpin */
    public class Builder extends com.facebook.graphql.modelutil.BaseModel.Builder {
        public boolean f19276A;
        public boolean f19277B;
        public int f19278C;
        public int f19279D;
        @Nullable
        public String f19280E;
        @Nullable
        public String f19281F;
        public int f19282G;
        @Nullable
        public String f19283H;
        @Nullable
        public GraphQLImage f19284I;
        @Nullable
        public GraphQLImage f19285J;
        @Nullable
        public GraphQLImage f19286K;
        @Nullable
        public GraphQLImage f19287L;
        @Nullable
        public GraphQLImage f19288M;
        @Nullable
        public GraphQLImage f19289N;
        @Nullable
        public GraphQLImage f19290O;
        @Nullable
        public GraphQLImage f19291P;
        @Nullable
        public GraphQLImage f19292Q;
        @Nullable
        public GraphQLImage f19293R;
        @Nullable
        public GraphQLImage f19294S;
        @Nullable
        public GraphQLImage f19295T;
        @Nullable
        public GraphQLImage f19296U;
        @Nullable
        public GraphQLImage f19297V;
        @Nullable
        public GraphQLImage f19298W;
        @Nullable
        public GraphQLImage f19299X;
        public int f19300Y;
        public int f19301Z;
        @Nullable
        public GraphQLImage aA;
        @Nullable
        public GraphQLActor aB;
        public int aC;
        @Nullable
        public String aD;
        @Nullable
        public String aE;
        @Nullable
        public String aF;
        public int aG;
        public int aH;
        @Nullable
        public String aI;
        @Nullable
        public String aJ;
        @Nullable
        public String aK;
        @Nullable
        public String aL;
        @Nullable
        public GraphQLImage aM;
        public int aN;
        @Nullable
        public String aO;
        public int aP;
        @Nullable
        public GraphQLImage aQ;
        @Nullable
        public GraphQLImage aR;
        @Nullable
        public GraphQLImage aS;
        @Nullable
        public GraphQLImage aT;
        @Nullable
        public GraphQLImage aU;
        @Nullable
        public GraphQLPhoto aV;
        @Nullable
        public GraphQLImage aW;
        public boolean aX;
        @Nullable
        public String aY;
        @Nullable
        public GraphQLTextWithEntities aZ;
        public int aa;
        @Nullable
        public GraphQLInlineActivitiesConnection ab;
        public boolean ac;
        public boolean ad;
        public boolean ae;
        public boolean af;
        public boolean ag;
        public boolean ah;
        public boolean ai;
        public boolean aj;
        public boolean ak;
        public boolean al;
        @Nullable
        public GraphQLImage am;
        @Nullable
        public GraphQLImage an;
        @Nullable
        public GraphQLImage ao;
        public int ap;
        public int aq;
        public int ar;
        @Nullable
        public GraphQLImage as;
        @Nullable
        public GraphQLTextWithEntities at;
        public ImmutableList<Integer> au;
        @Nullable
        public String av;
        @Nullable
        public GraphQLImage aw;
        @Nullable
        public String ax;
        @Nullable
        public String ay;
        @Nullable
        public GraphQLImage az;
        @Nullable
        public String bA;
        @Nullable
        public GraphQLVideoChannel bB;
        public int bC;
        @Nullable
        public GraphQLImage bD;
        public GraphQLVideoStatusType bE = GraphQLVideoStatusType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        public GraphQLSavedState bF = GraphQLSavedState.UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        public ImmutableList<GraphQLTimelineAppCollection> bG;
        public ImmutableList<GraphQLTimelineAppCollection> bH;
        public int bI;
        @Nullable
        public GraphQLImage ba;
        @Nullable
        public GraphQLRating bb;
        @Nullable
        public GraphQLTextWithEntities bc;
        @Nullable
        public GraphQLTimelineAppCollection bd;
        public boolean be;
        public boolean bf;
        public boolean bg;
        public boolean bh;
        public double bi;
        public double bj;
        @Nullable
        public String bk;
        @Nullable
        public String bl;
        @Nullable
        public String bm;
        public int bn;
        @Nullable
        public GraphQLPage bo;
        @Nullable
        public GraphQLImage bp;
        @Nullable
        public GraphQLStreamingImage bq;
        @Nullable
        public GraphQLStreamingImage br;
        public boolean bs;
        @Nullable
        public GraphQLImage bt;
        @Nullable
        public GraphQLTextWithEntities bu;
        @Nullable
        public GraphQLTextWithEntities bv;
        public int bw;
        @Nullable
        public String bx;
        @Nullable
        public GraphQLImage by;
        public ImmutableList<String> bz;
        public ImmutableList<GraphQLUser> f19302d;
        @Nullable
        public GraphQLImage f19303e;
        @Nullable
        public GraphQLImage f19304f;
        public int f19305g;
        @Nullable
        public GraphQLApplication f19306h;
        @Nullable
        public String f19307i;
        public long f19308j;
        public int f19309k;
        public GraphQLVideoBroadcastStatus f19310l = GraphQLVideoBroadcastStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        public boolean f19311m;
        public boolean f19312n;
        public boolean f19313o;
        public boolean f19314p;
        @Nullable
        public String f19315q;
        @Nullable
        public String f19316r;
        public ImmutableList<String> f19317s;
        public long f19318t;
        @Nullable
        public GraphQLStory f19319u;
        @Nullable
        public String f19320v;
        @Nullable
        public GraphQLPlace f19321w;
        @Nullable
        public GraphQLImage f19322x;
        @Nullable
        public GraphQLFeedback f19323y;
        @Nullable
        public GraphQLVideoGuidedTour f19324z;

        public Builder() {
            Preconditions.checkState(this instanceof Builder);
        }

        public final GraphQLVideo m26992a() {
            return new GraphQLVideo(this);
        }
    }

    /* compiled from: local_group_did_unpin */
    final class C07681 implements Creator<GraphQLVideo> {
        C07681() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLVideo(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLVideo[i];
        }
    }

    public final String mo2507g() {
        return m24097z().mo2507g();
    }

    public final int aa_() {
        return FeedbackableUtil.m29217d(this);
    }

    public final int mo2891n() {
        return FeedbackableUtil.m29218e(this);
    }

    public final String toString() {
        return mo2890l() == null ? "" : mo2890l().toString();
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m24082j() {
        this.f17073d = (GraphQLImage) super.m9947a(this.f17073d, 0, GraphQLImage.class);
        return this.f17073d;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m24083k() {
        this.f17074e = (GraphQLImage) super.m9947a(this.f17074e, 1, GraphQLImage.class);
        return this.f17074e;
    }

    @FieldOffset
    public final int m24086o() {
        m9949a(0, 2);
        return this.f17075f;
    }

    @FieldOffset
    @Nullable
    public final GraphQLApplication m24087p() {
        this.f17076g = (GraphQLApplication) super.m9947a(this.f17076g, 4, GraphQLApplication.class);
        return this.f17076g;
    }

    @FieldOffset
    @Nullable
    public final String m24088q() {
        this.f17077h = super.m9948a(this.f17077h, 5);
        return this.f17077h;
    }

    @FieldOffset
    public final long m24089r() {
        m9949a(0, 6);
        return this.f17078i;
    }

    @FieldOffset
    public final int m24090s() {
        m9949a(0, 7);
        return this.f17079j;
    }

    @FieldOffset
    public final GraphQLVideoBroadcastStatus m24091t() {
        this.f17080k = (GraphQLVideoBroadcastStatus) super.m9945a(this.f17080k, 8, GraphQLVideoBroadcastStatus.class, GraphQLVideoBroadcastStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
        return this.f17080k;
    }

    @FieldOffset
    public final boolean m24092u() {
        m9949a(1, 1);
        return this.f17081l;
    }

    @FieldOffset
    public final boolean m24093v() {
        m9949a(1, 2);
        return this.f17082m;
    }

    @FieldOffset
    public final boolean m24094w() {
        m9949a(1, 3);
        return this.f17083n;
    }

    @FieldOffset
    @Nullable
    public final String m24095x() {
        this.f17084o = super.m9948a(this.f17084o, 12);
        return this.f17084o;
    }

    @FieldOffset
    public final long m24096y() {
        m9949a(1, 5);
        return this.f17085p;
    }

    @FieldOffset
    @Nullable
    public final GraphQLStory m24097z() {
        this.f17086q = (GraphQLStory) super.m9947a(this.f17086q, 14, GraphQLStory.class);
        return this.f17086q;
    }

    @FieldOffset
    @Nullable
    public final GraphQLPlace m24051A() {
        this.f17087r = (GraphQLPlace) super.m9947a(this.f17087r, 15, GraphQLPlace.class);
        return this.f17087r;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m24052B() {
        this.f17088s = (GraphQLImage) super.m9947a(this.f17088s, 16, GraphQLImage.class);
        return this.f17088s;
    }

    @FieldOffset
    @Nullable
    public final GraphQLFeedback mo2890l() {
        this.f17089t = (GraphQLFeedback) super.m9947a(this.f17089t, 17, GraphQLFeedback.class);
        return this.f17089t;
    }

    @FieldOffset
    @Nullable
    public final GraphQLVideoGuidedTour m24053C() {
        this.f17090u = (GraphQLVideoGuidedTour) super.m9947a(this.f17090u, 18, GraphQLVideoGuidedTour.class);
        return this.f17090u;
    }

    @FieldOffset
    public final boolean m24054D() {
        m9949a(2, 3);
        return this.f17091v;
    }

    @FieldOffset
    public final boolean m24055E() {
        m9949a(2, 4);
        return this.f17092w;
    }

    @FieldOffset
    public final int m24056F() {
        m9949a(2, 5);
        return this.f17093x;
    }

    @FieldOffset
    public final int m24057G() {
        m9949a(2, 6);
        return this.f17094y;
    }

    @FieldOffset
    @Nullable
    public final String m24058H() {
        this.f17095z = super.m9948a(this.f17095z, 23);
        return this.f17095z;
    }

    @FieldOffset
    public final int m24059I() {
        m9949a(3, 0);
        return this.f17047A;
    }

    @FieldOffset
    @Nullable
    public final String m24060J() {
        this.f17048B = super.m9948a(this.f17048B, 25);
        return this.f17048B;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m24061K() {
        this.f17049C = (GraphQLImage) super.m9947a(this.f17049C, 26, GraphQLImage.class);
        return this.f17049C;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m24062L() {
        this.f17050D = (GraphQLImage) super.m9947a(this.f17050D, 27, GraphQLImage.class);
        return this.f17050D;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m24063M() {
        this.f17051E = (GraphQLImage) super.m9947a(this.f17051E, 28, GraphQLImage.class);
        return this.f17051E;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m24064N() {
        this.f17052F = (GraphQLImage) super.m9947a(this.f17052F, 29, GraphQLImage.class);
        return this.f17052F;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m24065O() {
        this.f17053G = (GraphQLImage) super.m9947a(this.f17053G, 30, GraphQLImage.class);
        return this.f17053G;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m24066P() {
        this.f17054H = (GraphQLImage) super.m9947a(this.f17054H, 31, GraphQLImage.class);
        return this.f17054H;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m24067Q() {
        this.f17055I = (GraphQLImage) super.m9947a(this.f17055I, 32, GraphQLImage.class);
        return this.f17055I;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m24068R() {
        this.f17056J = (GraphQLImage) super.m9947a(this.f17056J, 33, GraphQLImage.class);
        return this.f17056J;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m24069S() {
        this.f17057K = (GraphQLImage) super.m9947a(this.f17057K, 34, GraphQLImage.class);
        return this.f17057K;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m24070T() {
        this.f17058L = (GraphQLImage) super.m9947a(this.f17058L, 35, GraphQLImage.class);
        return this.f17058L;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m24071U() {
        this.f17059M = (GraphQLImage) super.m9947a(this.f17059M, 36, GraphQLImage.class);
        return this.f17059M;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m24072V() {
        this.f17060N = (GraphQLImage) super.m9947a(this.f17060N, 37, GraphQLImage.class);
        return this.f17060N;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m24073W() {
        this.f17061O = (GraphQLImage) super.m9947a(this.f17061O, 38, GraphQLImage.class);
        return this.f17061O;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m24074X() {
        this.f17062P = (GraphQLImage) super.m9947a(this.f17062P, 39, GraphQLImage.class);
        return this.f17062P;
    }

    @FieldOffset
    public final int m24075Y() {
        m9949a(5, 0);
        return this.f17063Q;
    }

    @FieldOffset
    public final int m24076Z() {
        m9949a(5, 1);
        return this.f17064R;
    }

    @FieldOffset
    public final int aa() {
        m9949a(5, 2);
        return this.f17065S;
    }

    @FieldOffset
    @Nullable
    public final GraphQLInlineActivitiesConnection ab() {
        this.f17066T = (GraphQLInlineActivitiesConnection) super.m9947a(this.f17066T, 43, GraphQLInlineActivitiesConnection.class);
        return this.f17066T;
    }

    @FieldOffset
    public final boolean ac() {
        m9949a(5, 4);
        return this.f17067U;
    }

    @FieldOffset
    public final boolean ad() {
        m9949a(5, 5);
        return this.f17068V;
    }

    @FieldOffset
    public final boolean ae() {
        m9949a(5, 6);
        return this.f17069W;
    }

    @FieldOffset
    public final boolean af() {
        m9949a(5, 7);
        return this.f17070X;
    }

    @FieldOffset
    public final boolean ag() {
        m9949a(6, 0);
        return this.f17071Y;
    }

    @FieldOffset
    public final boolean ah() {
        m9949a(6, 1);
        return this.f17072Z;
    }

    @FieldOffset
    public final boolean ai() {
        m9949a(6, 2);
        return this.aa;
    }

    @FieldOffset
    public final boolean aj() {
        m9949a(6, 3);
        return this.ab;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage ak() {
        this.ac = (GraphQLImage) super.m9947a(this.ac, 52, GraphQLImage.class);
        return this.ac;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage al() {
        this.ad = (GraphQLImage) super.m9947a(this.ad, 53, GraphQLImage.class);
        return this.ad;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage am() {
        this.ae = (GraphQLImage) super.m9947a(this.ae, 54, GraphQLImage.class);
        return this.ae;
    }

    @FieldOffset
    public final int an() {
        m9949a(6, 7);
        return this.af;
    }

    @FieldOffset
    public final int ao() {
        m9949a(7, 0);
        return this.ag;
    }

    @FieldOffset
    public final int ap() {
        m9949a(7, 1);
        return this.ah;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage aq() {
        this.ai = (GraphQLImage) super.m9947a(this.ai, 58, GraphQLImage.class);
        return this.ai;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities ar() {
        this.aj = (GraphQLTextWithEntities) super.m9947a(this.aj, 59, GraphQLTextWithEntities.class);
        return this.aj;
    }

    @FieldOffset
    @Nullable
    public final String as() {
        this.ak = super.m9948a(this.ak, 60);
        return this.ak;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage at() {
        this.al = (GraphQLImage) super.m9947a(this.al, 61, GraphQLImage.class);
        return this.al;
    }

    @FieldOffset
    @Nullable
    public final String au() {
        this.am = super.m9948a(this.am, 62);
        return this.am;
    }

    @FieldOffset
    @Nullable
    public final String av() {
        this.an = super.m9948a(this.an, 63);
        return this.an;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage aw() {
        this.ao = (GraphQLImage) super.m9947a(this.ao, 64, GraphQLImage.class);
        return this.ao;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage ax() {
        this.ap = (GraphQLImage) super.m9947a(this.ap, 65, GraphQLImage.class);
        return this.ap;
    }

    @FieldOffset
    @Nullable
    public final GraphQLActor ay() {
        this.aq = (GraphQLActor) super.m9947a(this.aq, 66, GraphQLActor.class);
        return this.aq;
    }

    @FieldOffset
    public final int az() {
        m9949a(8, 3);
        return this.ar;
    }

    @FieldOffset
    @Nullable
    public final String aA() {
        this.as = super.m9948a(this.as, 68);
        return this.as;
    }

    @FieldOffset
    @Nullable
    public final String aB() {
        this.at = super.m9948a(this.at, 69);
        return this.at;
    }

    @FieldOffset
    public final int aC() {
        m9949a(8, 6);
        return this.au;
    }

    @FieldOffset
    public final int aD() {
        m9949a(8, 7);
        return this.av;
    }

    @FieldOffset
    @Nullable
    public final String aE() {
        this.aw = super.m9948a(this.aw, 72);
        return this.aw;
    }

    @FieldOffset
    @Nullable
    public final String aF() {
        this.ax = super.m9948a(this.ax, 73);
        return this.ax;
    }

    @FieldOffset
    @Nullable
    public final String aG() {
        this.ay = super.m9948a(this.ay, 74);
        return this.ay;
    }

    @FieldOffset
    @Nullable
    public final String aH() {
        this.az = super.m9948a(this.az, 75);
        return this.az;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage aI() {
        this.aA = (GraphQLImage) super.m9947a(this.aA, 76, GraphQLImage.class);
        return this.aA;
    }

    @FieldOffset
    @Nullable
    public final String aJ() {
        this.aB = super.m9948a(this.aB, 77);
        return this.aB;
    }

    @FieldOffset
    public final int aK() {
        m9949a(9, 6);
        return this.aC;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage aL() {
        this.aD = (GraphQLImage) super.m9947a(this.aD, 79, GraphQLImage.class);
        return this.aD;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage aM() {
        this.aE = (GraphQLImage) super.m9947a(this.aE, 80, GraphQLImage.class);
        return this.aE;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage aN() {
        this.aF = (GraphQLImage) super.m9947a(this.aF, 81, GraphQLImage.class);
        return this.aF;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage aO() {
        this.aG = (GraphQLImage) super.m9947a(this.aG, 82, GraphQLImage.class);
        return this.aG;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage aP() {
        this.aH = (GraphQLImage) super.m9947a(this.aH, 83, GraphQLImage.class);
        return this.aH;
    }

    @FieldOffset
    @Nullable
    public final GraphQLPhoto aQ() {
        this.aI = (GraphQLPhoto) super.m9947a(this.aI, 84, GraphQLPhoto.class);
        return this.aI;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage aR() {
        this.aJ = (GraphQLImage) super.m9947a(this.aJ, 85, GraphQLImage.class);
        return this.aJ;
    }

    @FieldOffset
    public final boolean aS() {
        m9949a(10, 6);
        return this.aK;
    }

    @FieldOffset
    @Nullable
    public final String aT() {
        this.aL = super.m9948a(this.aL, 87);
        return this.aL;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities aU() {
        this.aM = (GraphQLTextWithEntities) super.m9947a(this.aM, 88, GraphQLTextWithEntities.class);
        return this.aM;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage aV() {
        this.aN = (GraphQLImage) super.m9947a(this.aN, 89, GraphQLImage.class);
        return this.aN;
    }

    @FieldOffset
    @Nullable
    public final GraphQLRating aW() {
        this.aO = (GraphQLRating) super.m9947a(this.aO, 90, GraphQLRating.class);
        return this.aO;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTimelineAppCollection aX() {
        this.aP = (GraphQLTimelineAppCollection) super.m9947a(this.aP, 91, GraphQLTimelineAppCollection.class);
        return this.aP;
    }

    @FieldOffset
    public final boolean aY() {
        m9949a(11, 5);
        return this.aQ;
    }

    @FieldOffset
    public final boolean aZ() {
        m9949a(11, 6);
        return this.aR;
    }

    @FieldOffset
    public final boolean ba() {
        m9949a(11, 7);
        return this.aS;
    }

    @FieldOffset
    public final double bb() {
        m9949a(12, 0);
        return this.aT;
    }

    @FieldOffset
    public final double bc() {
        m9949a(12, 1);
        return this.aU;
    }

    @FieldOffset
    @Nullable
    public final String bd() {
        this.aV = super.m9948a(this.aV, 98);
        return this.aV;
    }

    @FieldOffset
    @Nullable
    public final String be() {
        this.aW = super.m9948a(this.aW, 99);
        return this.aW;
    }

    @FieldOffset
    public final int bf() {
        m9949a(12, 4);
        return this.aX;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage bg() {
        this.aY = (GraphQLImage) super.m9947a(this.aY, 101, GraphQLImage.class);
        return this.aY;
    }

    @FieldOffset
    @Nullable
    public final GraphQLStreamingImage bh() {
        this.aZ = (GraphQLStreamingImage) super.m9947a(this.aZ, 102, GraphQLStreamingImage.class);
        return this.aZ;
    }

    @FieldOffset
    @Nullable
    public final GraphQLStreamingImage bi() {
        this.ba = (GraphQLStreamingImage) super.m9947a(this.ba, 103, GraphQLStreamingImage.class);
        return this.ba;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage bj() {
        this.bb = (GraphQLImage) super.m9947a(this.bb, 104, GraphQLImage.class);
        return this.bb;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities bk() {
        this.bc = (GraphQLTextWithEntities) super.m9947a(this.bc, 105, GraphQLTextWithEntities.class);
        return this.bc;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities bl() {
        this.bd = (GraphQLTextWithEntities) super.m9947a(this.bd, 106, GraphQLTextWithEntities.class);
        return this.bd;
    }

    @FieldOffset
    @Nullable
    public final String bm() {
        this.be = super.m9948a(this.be, 107);
        return this.be;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage bn() {
        this.bf = (GraphQLImage) super.m9947a(this.bf, 108, GraphQLImage.class);
        return this.bf;
    }

    @FieldOffset
    public final ImmutableList<String> bo() {
        this.bg = super.m9943a(this.bg, 109);
        return (ImmutableList) this.bg;
    }

    @FieldOffset
    @Nullable
    public final GraphQLVideoChannel bp() {
        this.bh = (GraphQLVideoChannel) super.m9947a(this.bh, 110, GraphQLVideoChannel.class);
        return this.bh;
    }

    @FieldOffset
    public final int bq() {
        m9949a(13, 7);
        return this.bi;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage br() {
        this.bj = (GraphQLImage) super.m9947a(this.bj, 112, GraphQLImage.class);
        return this.bj;
    }

    @FieldOffset
    public final GraphQLVideoStatusType bs() {
        this.bk = (GraphQLVideoStatusType) super.m9945a(this.bk, 113, GraphQLVideoStatusType.class, GraphQLVideoStatusType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
        return this.bk;
    }

    @FieldOffset
    public final GraphQLSavedState bt() {
        this.bl = (GraphQLSavedState) super.m9945a(this.bl, 114, GraphQLSavedState.class, GraphQLSavedState.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
        return this.bl;
    }

    @FieldOffset
    public final ImmutableList<GraphQLTimelineAppCollection> bu() {
        this.bm = super.m9944a(this.bm, 115, GraphQLTimelineAppCollection.class);
        return (ImmutableList) this.bm;
    }

    @FieldOffset
    public final ImmutableList<GraphQLTimelineAppCollection> bv() {
        this.bn = super.m9944a(this.bn, 116, GraphQLTimelineAppCollection.class);
        return (ImmutableList) this.bn;
    }

    @FieldOffset
    public final int bw() {
        m9949a(14, 5);
        return this.bo;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage bx() {
        this.bp = (GraphQLImage) super.m9947a(this.bp, 118, GraphQLImage.class);
        return this.bp;
    }

    @FieldOffset
    @Nullable
    public final String by() {
        this.bq = super.m9948a(this.bq, 119);
        return this.bq;
    }

    @FieldOffset
    public final ImmutableList<String> bz() {
        this.br = super.m9943a(this.br, 120);
        return (ImmutableList) this.br;
    }

    @FieldOffset
    public final boolean bA() {
        m9949a(15, 1);
        return this.bs;
    }

    @FieldOffset
    @Nullable
    public final String bB() {
        this.bt = super.m9948a(this.bt, 122);
        return this.bt;
    }

    @FieldOffset
    public final ImmutableList<Integer> bC() {
        this.bu = super.m9952b(this.bu, 123);
        return (ImmutableList) this.bu;
    }

    @FieldOffset
    @Nullable
    public final String bD() {
        this.bv = super.m9948a(this.bv, 124);
        return this.bv;
    }

    @FieldOffset
    public final boolean bE() {
        m9949a(15, 5);
        return this.bw;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage bF() {
        this.bx = (GraphQLImage) super.m9947a(this.bx, 126, GraphQLImage.class);
        return this.bx;
    }

    @FieldOffset
    public final boolean bG() {
        m9949a(15, 7);
        return this.by;
    }

    @FieldOffset
    @Nullable
    public final GraphQLPage bH() {
        this.bz = (GraphQLPage) super.m9947a(this.bz, 131, GraphQLPage.class);
        return this.bz;
    }

    @FieldOffset
    @Nullable
    public final String bI() {
        this.bA = super.m9948a(this.bA, 132);
        return this.bA;
    }

    @FieldOffset
    @Nullable
    public final String bJ() {
        this.bB = super.m9948a(this.bB, 133);
        return this.bB;
    }

    @FieldOffset
    public final boolean bK() {
        m9949a(16, 6);
        return this.bC;
    }

    @FieldOffset
    @Nullable
    public final String bL() {
        this.bD = super.m9948a(this.bD, 135);
        return this.bD;
    }

    @FieldOffset
    public final int bM() {
        m9949a(17, 0);
        return this.bE;
    }

    @FieldOffset
    public final int bN() {
        m9949a(17, 1);
        return this.bF;
    }

    @FieldOffset
    public final ImmutableList<GraphQLUser> bO() {
        this.bG = super.m9944a(this.bG, 138, GraphQLUser.class);
        return (ImmutableList) this.bG;
    }

    @FieldOffset
    public final boolean bP() {
        m9949a(17, 3);
        return this.bH;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities bQ() {
        this.bI = (GraphQLTextWithEntities) super.m9947a(this.bI, 140, GraphQLTextWithEntities.class);
        return this.bI;
    }

    @Nullable
    public final String mo2834a() {
        return m24060J();
    }

    public final int jK_() {
        return 82650203;
    }

    public final GraphQLVisitableModel mo1404a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVideo graphQLVideo;
        GraphQLVisitableModel graphQLVisitableModel;
        GraphQLImage graphQLImage;
        GraphQLApplication graphQLApplication;
        GraphQLStory graphQLStory;
        GraphQLPlace graphQLPlace;
        GraphQLFeedback graphQLFeedback;
        GraphQLVideoGuidedTour graphQLVideoGuidedTour;
        GraphQLInlineActivitiesConnection graphQLInlineActivitiesConnection;
        GraphQLTextWithEntities graphQLTextWithEntities;
        GraphQLActor graphQLActor;
        GraphQLPhoto graphQLPhoto;
        GraphQLRating graphQLRating;
        GraphQLTimelineAppCollection graphQLTimelineAppCollection;
        GraphQLPage graphQLPage;
        GraphQLStreamingImage graphQLStreamingImage;
        GraphQLVideoChannel graphQLVideoChannel;
        com.google.common.collect.ImmutableList.Builder a;
        m9958h();
        if (bO() != null) {
            com.google.common.collect.ImmutableList.Builder a2 = ModelHelper.m23097a(bO(), graphQLModelMutatingVisitor);
            if (a2 != null) {
                graphQLVideo = (GraphQLVideo) ModelHelper.m23095a(null, (GraphQLVisitableModel) this);
                graphQLVideo.bG = a2.m1068b();
                graphQLVisitableModel = graphQLVideo;
                if (m24082j() != null) {
                    graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(m24082j());
                    if (m24082j() != graphQLImage) {
                        graphQLVisitableModel = (GraphQLVideo) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                        graphQLVisitableModel.f17073d = graphQLImage;
                    }
                }
                if (m24083k() != null) {
                    graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(m24083k());
                    if (m24083k() != graphQLImage) {
                        graphQLVisitableModel = (GraphQLVideo) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                        graphQLVisitableModel.f17074e = graphQLImage;
                    }
                }
                if (m24087p() != null) {
                    graphQLApplication = (GraphQLApplication) graphQLModelMutatingVisitor.mo2928b(m24087p());
                    if (m24087p() != graphQLApplication) {
                        graphQLVisitableModel = (GraphQLVideo) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                        graphQLVisitableModel.f17076g = graphQLApplication;
                    }
                }
                if (m24097z() != null) {
                    graphQLStory = (GraphQLStory) graphQLModelMutatingVisitor.mo2928b(m24097z());
                    if (m24097z() != graphQLStory) {
                        graphQLVisitableModel = (GraphQLVideo) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                        graphQLVisitableModel.f17086q = graphQLStory;
                    }
                }
                if (m24051A() != null) {
                    graphQLPlace = (GraphQLPlace) graphQLModelMutatingVisitor.mo2928b(m24051A());
                    if (m24051A() != graphQLPlace) {
                        graphQLVisitableModel = (GraphQLVideo) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                        graphQLVisitableModel.f17087r = graphQLPlace;
                    }
                }
                if (m24052B() != null) {
                    graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(m24052B());
                    if (m24052B() != graphQLImage) {
                        graphQLVisitableModel = (GraphQLVideo) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                        graphQLVisitableModel.f17088s = graphQLImage;
                    }
                }
                if (mo2890l() != null) {
                    graphQLFeedback = (GraphQLFeedback) graphQLModelMutatingVisitor.mo2928b(mo2890l());
                    if (mo2890l() != graphQLFeedback) {
                        graphQLVisitableModel = (GraphQLVideo) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                        graphQLVisitableModel.f17089t = graphQLFeedback;
                    }
                }
                if (m24053C() != null) {
                    graphQLVideoGuidedTour = (GraphQLVideoGuidedTour) graphQLModelMutatingVisitor.mo2928b(m24053C());
                    if (m24053C() != graphQLVideoGuidedTour) {
                        graphQLVisitableModel = (GraphQLVideo) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                        graphQLVisitableModel.f17090u = graphQLVideoGuidedTour;
                    }
                }
                if (m24061K() != null) {
                    graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(m24061K());
                    if (m24061K() != graphQLImage) {
                        graphQLVisitableModel = (GraphQLVideo) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                        graphQLVisitableModel.f17049C = graphQLImage;
                    }
                }
                if (m24062L() != null) {
                    graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(m24062L());
                    if (m24062L() != graphQLImage) {
                        graphQLVisitableModel = (GraphQLVideo) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                        graphQLVisitableModel.f17050D = graphQLImage;
                    }
                }
                if (m24063M() != null) {
                    graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(m24063M());
                    if (m24063M() != graphQLImage) {
                        graphQLVisitableModel = (GraphQLVideo) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                        graphQLVisitableModel.f17051E = graphQLImage;
                    }
                }
                if (m24064N() != null) {
                    graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(m24064N());
                    if (m24064N() != graphQLImage) {
                        graphQLVisitableModel = (GraphQLVideo) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                        graphQLVisitableModel.f17052F = graphQLImage;
                    }
                }
                if (m24065O() != null) {
                    graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(m24065O());
                    if (m24065O() != graphQLImage) {
                        graphQLVisitableModel = (GraphQLVideo) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                        graphQLVisitableModel.f17053G = graphQLImage;
                    }
                }
                if (m24066P() != null) {
                    graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(m24066P());
                    if (m24066P() != graphQLImage) {
                        graphQLVisitableModel = (GraphQLVideo) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                        graphQLVisitableModel.f17054H = graphQLImage;
                    }
                }
                if (m24067Q() != null) {
                    graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(m24067Q());
                    if (m24067Q() != graphQLImage) {
                        graphQLVisitableModel = (GraphQLVideo) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                        graphQLVisitableModel.f17055I = graphQLImage;
                    }
                }
                if (m24068R() != null) {
                    graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(m24068R());
                    if (m24068R() != graphQLImage) {
                        graphQLVisitableModel = (GraphQLVideo) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                        graphQLVisitableModel.f17056J = graphQLImage;
                    }
                }
                if (bx() != null) {
                    graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(bx());
                    if (bx() != graphQLImage) {
                        graphQLVisitableModel = (GraphQLVideo) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                        graphQLVisitableModel.bp = graphQLImage;
                    }
                }
                if (m24069S() != null) {
                    graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(m24069S());
                    if (m24069S() != graphQLImage) {
                        graphQLVisitableModel = (GraphQLVideo) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                        graphQLVisitableModel.f17057K = graphQLImage;
                    }
                }
                if (m24070T() != null) {
                    graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(m24070T());
                    if (m24070T() != graphQLImage) {
                        graphQLVisitableModel = (GraphQLVideo) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                        graphQLVisitableModel.f17058L = graphQLImage;
                    }
                }
                if (m24071U() != null) {
                    graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(m24071U());
                    if (m24071U() != graphQLImage) {
                        graphQLVisitableModel = (GraphQLVideo) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                        graphQLVisitableModel.f17059M = graphQLImage;
                    }
                }
                if (m24072V() != null) {
                    graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(m24072V());
                    if (m24072V() != graphQLImage) {
                        graphQLVisitableModel = (GraphQLVideo) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                        graphQLVisitableModel.f17060N = graphQLImage;
                    }
                }
                if (m24073W() != null) {
                    graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(m24073W());
                    if (m24073W() != graphQLImage) {
                        graphQLVisitableModel = (GraphQLVideo) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                        graphQLVisitableModel.f17061O = graphQLImage;
                    }
                }
                if (m24074X() != null) {
                    graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(m24074X());
                    if (m24074X() != graphQLImage) {
                        graphQLVisitableModel = (GraphQLVideo) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                        graphQLVisitableModel.f17062P = graphQLImage;
                    }
                }
                if (bF() != null) {
                    graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(bF());
                    if (bF() != graphQLImage) {
                        graphQLVisitableModel = (GraphQLVideo) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                        graphQLVisitableModel.bx = graphQLImage;
                    }
                }
                if (ab() != null) {
                    graphQLInlineActivitiesConnection = (GraphQLInlineActivitiesConnection) graphQLModelMutatingVisitor.mo2928b(ab());
                    if (ab() != graphQLInlineActivitiesConnection) {
                        graphQLVisitableModel = (GraphQLVideo) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                        graphQLVisitableModel.f17066T = graphQLInlineActivitiesConnection;
                    }
                }
                if (ak() != null) {
                    graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(ak());
                    if (ak() != graphQLImage) {
                        graphQLVisitableModel = (GraphQLVideo) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                        graphQLVisitableModel.ac = graphQLImage;
                    }
                }
                if (al() != null) {
                    graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(al());
                    if (al() != graphQLImage) {
                        graphQLVisitableModel = (GraphQLVideo) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                        graphQLVisitableModel.ad = graphQLImage;
                    }
                }
                if (am() != null) {
                    graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(am());
                    if (am() != graphQLImage) {
                        graphQLVisitableModel = (GraphQLVideo) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                        graphQLVisitableModel.ae = graphQLImage;
                    }
                }
                if (aq() != null) {
                    graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(aq());
                    if (aq() != graphQLImage) {
                        graphQLVisitableModel = (GraphQLVideo) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                        graphQLVisitableModel.ai = graphQLImage;
                    }
                }
                if (ar() != null) {
                    graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.mo2928b(ar());
                    if (ar() != graphQLTextWithEntities) {
                        graphQLVisitableModel = (GraphQLVideo) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                        graphQLVisitableModel.aj = graphQLTextWithEntities;
                    }
                }
                if (at() != null) {
                    graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(at());
                    if (at() != graphQLImage) {
                        graphQLVisitableModel = (GraphQLVideo) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                        graphQLVisitableModel.al = graphQLImage;
                    }
                }
                if (aw() != null) {
                    graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(aw());
                    if (aw() != graphQLImage) {
                        graphQLVisitableModel = (GraphQLVideo) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                        graphQLVisitableModel.ao = graphQLImage;
                    }
                }
                if (ax() != null) {
                    graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(ax());
                    if (ax() != graphQLImage) {
                        graphQLVisitableModel = (GraphQLVideo) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                        graphQLVisitableModel.ap = graphQLImage;
                    }
                }
                if (ay() != null) {
                    graphQLActor = (GraphQLActor) graphQLModelMutatingVisitor.mo2928b(ay());
                    if (ay() != graphQLActor) {
                        graphQLVisitableModel = (GraphQLVideo) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                        graphQLVisitableModel.aq = graphQLActor;
                    }
                }
                if (aI() != null) {
                    graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(aI());
                    if (aI() != graphQLImage) {
                        graphQLVisitableModel = (GraphQLVideo) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                        graphQLVisitableModel.aA = graphQLImage;
                    }
                }
                if (aL() != null) {
                    graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(aL());
                    if (aL() != graphQLImage) {
                        graphQLVisitableModel = (GraphQLVideo) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                        graphQLVisitableModel.aD = graphQLImage;
                    }
                }
                if (aM() != null) {
                    graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(aM());
                    if (aM() != graphQLImage) {
                        graphQLVisitableModel = (GraphQLVideo) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                        graphQLVisitableModel.aE = graphQLImage;
                    }
                }
                if (aN() != null) {
                    graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(aN());
                    if (aN() != graphQLImage) {
                        graphQLVisitableModel = (GraphQLVideo) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                        graphQLVisitableModel.aF = graphQLImage;
                    }
                }
                if (aO() != null) {
                    graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(aO());
                    if (aO() != graphQLImage) {
                        graphQLVisitableModel = (GraphQLVideo) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                        graphQLVisitableModel.aG = graphQLImage;
                    }
                }
                if (aP() != null) {
                    graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(aP());
                    if (aP() != graphQLImage) {
                        graphQLVisitableModel = (GraphQLVideo) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                        graphQLVisitableModel.aH = graphQLImage;
                    }
                }
                if (aQ() != null) {
                    graphQLPhoto = (GraphQLPhoto) graphQLModelMutatingVisitor.mo2928b(aQ());
                    if (aQ() != graphQLPhoto) {
                        graphQLVisitableModel = (GraphQLVideo) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                        graphQLVisitableModel.aI = graphQLPhoto;
                    }
                }
                if (aR() != null) {
                    graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(aR());
                    if (aR() != graphQLImage) {
                        graphQLVisitableModel = (GraphQLVideo) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                        graphQLVisitableModel.aJ = graphQLImage;
                    }
                }
                if (aU() != null) {
                    graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.mo2928b(aU());
                    if (aU() != graphQLTextWithEntities) {
                        graphQLVisitableModel = (GraphQLVideo) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                        graphQLVisitableModel.aM = graphQLTextWithEntities;
                    }
                }
                if (aV() != null) {
                    graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(aV());
                    if (aV() != graphQLImage) {
                        graphQLVisitableModel = (GraphQLVideo) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                        graphQLVisitableModel.aN = graphQLImage;
                    }
                }
                if (aW() != null) {
                    graphQLRating = (GraphQLRating) graphQLModelMutatingVisitor.mo2928b(aW());
                    if (aW() != graphQLRating) {
                        graphQLVisitableModel = (GraphQLVideo) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                        graphQLVisitableModel.aO = graphQLRating;
                    }
                }
                if (bQ() != null) {
                    graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.mo2928b(bQ());
                    if (bQ() != graphQLTextWithEntities) {
                        graphQLVisitableModel = (GraphQLVideo) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                        graphQLVisitableModel.bI = graphQLTextWithEntities;
                    }
                }
                if (aX() != null) {
                    graphQLTimelineAppCollection = (GraphQLTimelineAppCollection) graphQLModelMutatingVisitor.mo2928b(aX());
                    if (aX() != graphQLTimelineAppCollection) {
                        graphQLVisitableModel = (GraphQLVideo) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                        graphQLVisitableModel.aP = graphQLTimelineAppCollection;
                    }
                }
                if (bH() != null) {
                    graphQLPage = (GraphQLPage) graphQLModelMutatingVisitor.mo2928b(bH());
                    if (bH() != graphQLPage) {
                        graphQLVisitableModel = (GraphQLVideo) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                        graphQLVisitableModel.bz = graphQLPage;
                    }
                }
                if (bg() != null) {
                    graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(bg());
                    if (bg() != graphQLImage) {
                        graphQLVisitableModel = (GraphQLVideo) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                        graphQLVisitableModel.aY = graphQLImage;
                    }
                }
                if (bh() != null) {
                    graphQLStreamingImage = (GraphQLStreamingImage) graphQLModelMutatingVisitor.mo2928b(bh());
                    if (bh() != graphQLStreamingImage) {
                        graphQLVisitableModel = (GraphQLVideo) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                        graphQLVisitableModel.aZ = graphQLStreamingImage;
                    }
                }
                if (bi() != null) {
                    graphQLStreamingImage = (GraphQLStreamingImage) graphQLModelMutatingVisitor.mo2928b(bi());
                    if (bi() != graphQLStreamingImage) {
                        graphQLVisitableModel = (GraphQLVideo) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                        graphQLVisitableModel.ba = graphQLStreamingImage;
                    }
                }
                if (bj() != null) {
                    graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(bj());
                    if (bj() != graphQLImage) {
                        graphQLVisitableModel = (GraphQLVideo) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                        graphQLVisitableModel.bb = graphQLImage;
                    }
                }
                if (bk() != null) {
                    graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.mo2928b(bk());
                    if (bk() != graphQLTextWithEntities) {
                        graphQLVisitableModel = (GraphQLVideo) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                        graphQLVisitableModel.bc = graphQLTextWithEntities;
                    }
                }
                if (bl() != null) {
                    graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.mo2928b(bl());
                    if (bl() != graphQLTextWithEntities) {
                        graphQLVisitableModel = (GraphQLVideo) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                        graphQLVisitableModel.bd = graphQLTextWithEntities;
                    }
                }
                if (bn() != null) {
                    graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(bn());
                    if (bn() != graphQLImage) {
                        graphQLVisitableModel = (GraphQLVideo) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                        graphQLVisitableModel.bf = graphQLImage;
                    }
                }
                if (bp() != null) {
                    graphQLVideoChannel = (GraphQLVideoChannel) graphQLModelMutatingVisitor.mo2928b(bp());
                    if (bp() != graphQLVideoChannel) {
                        graphQLVisitableModel = (GraphQLVideo) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                        graphQLVisitableModel.bh = graphQLVideoChannel;
                    }
                }
                if (br() != null) {
                    graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(br());
                    if (br() != graphQLImage) {
                        graphQLVisitableModel = (GraphQLVideo) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                        graphQLVisitableModel.bj = graphQLImage;
                    }
                }
                if (bu() != null) {
                    a = ModelHelper.m23097a(bu(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVideo = (GraphQLVideo) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                        graphQLVideo.bm = a.m1068b();
                        graphQLVisitableModel = graphQLVideo;
                    }
                }
                if (bv() != null) {
                    a = ModelHelper.m23097a(bv(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVideo = (GraphQLVideo) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                        graphQLVideo.bn = a.m1068b();
                        graphQLVisitableModel = graphQLVideo;
                    }
                }
                m9959i();
                return graphQLVisitableModel != null ? this : graphQLVisitableModel;
            }
        }
        graphQLVisitableModel = null;
        if (m24082j() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(m24082j());
            if (m24082j() != graphQLImage) {
                graphQLVisitableModel = (GraphQLVideo) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17073d = graphQLImage;
            }
        }
        if (m24083k() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(m24083k());
            if (m24083k() != graphQLImage) {
                graphQLVisitableModel = (GraphQLVideo) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17074e = graphQLImage;
            }
        }
        if (m24087p() != null) {
            graphQLApplication = (GraphQLApplication) graphQLModelMutatingVisitor.mo2928b(m24087p());
            if (m24087p() != graphQLApplication) {
                graphQLVisitableModel = (GraphQLVideo) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17076g = graphQLApplication;
            }
        }
        if (m24097z() != null) {
            graphQLStory = (GraphQLStory) graphQLModelMutatingVisitor.mo2928b(m24097z());
            if (m24097z() != graphQLStory) {
                graphQLVisitableModel = (GraphQLVideo) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17086q = graphQLStory;
            }
        }
        if (m24051A() != null) {
            graphQLPlace = (GraphQLPlace) graphQLModelMutatingVisitor.mo2928b(m24051A());
            if (m24051A() != graphQLPlace) {
                graphQLVisitableModel = (GraphQLVideo) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17087r = graphQLPlace;
            }
        }
        if (m24052B() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(m24052B());
            if (m24052B() != graphQLImage) {
                graphQLVisitableModel = (GraphQLVideo) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17088s = graphQLImage;
            }
        }
        if (mo2890l() != null) {
            graphQLFeedback = (GraphQLFeedback) graphQLModelMutatingVisitor.mo2928b(mo2890l());
            if (mo2890l() != graphQLFeedback) {
                graphQLVisitableModel = (GraphQLVideo) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17089t = graphQLFeedback;
            }
        }
        if (m24053C() != null) {
            graphQLVideoGuidedTour = (GraphQLVideoGuidedTour) graphQLModelMutatingVisitor.mo2928b(m24053C());
            if (m24053C() != graphQLVideoGuidedTour) {
                graphQLVisitableModel = (GraphQLVideo) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17090u = graphQLVideoGuidedTour;
            }
        }
        if (m24061K() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(m24061K());
            if (m24061K() != graphQLImage) {
                graphQLVisitableModel = (GraphQLVideo) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17049C = graphQLImage;
            }
        }
        if (m24062L() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(m24062L());
            if (m24062L() != graphQLImage) {
                graphQLVisitableModel = (GraphQLVideo) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17050D = graphQLImage;
            }
        }
        if (m24063M() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(m24063M());
            if (m24063M() != graphQLImage) {
                graphQLVisitableModel = (GraphQLVideo) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17051E = graphQLImage;
            }
        }
        if (m24064N() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(m24064N());
            if (m24064N() != graphQLImage) {
                graphQLVisitableModel = (GraphQLVideo) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17052F = graphQLImage;
            }
        }
        if (m24065O() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(m24065O());
            if (m24065O() != graphQLImage) {
                graphQLVisitableModel = (GraphQLVideo) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17053G = graphQLImage;
            }
        }
        if (m24066P() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(m24066P());
            if (m24066P() != graphQLImage) {
                graphQLVisitableModel = (GraphQLVideo) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17054H = graphQLImage;
            }
        }
        if (m24067Q() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(m24067Q());
            if (m24067Q() != graphQLImage) {
                graphQLVisitableModel = (GraphQLVideo) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17055I = graphQLImage;
            }
        }
        if (m24068R() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(m24068R());
            if (m24068R() != graphQLImage) {
                graphQLVisitableModel = (GraphQLVideo) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17056J = graphQLImage;
            }
        }
        if (bx() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(bx());
            if (bx() != graphQLImage) {
                graphQLVisitableModel = (GraphQLVideo) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.bp = graphQLImage;
            }
        }
        if (m24069S() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(m24069S());
            if (m24069S() != graphQLImage) {
                graphQLVisitableModel = (GraphQLVideo) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17057K = graphQLImage;
            }
        }
        if (m24070T() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(m24070T());
            if (m24070T() != graphQLImage) {
                graphQLVisitableModel = (GraphQLVideo) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17058L = graphQLImage;
            }
        }
        if (m24071U() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(m24071U());
            if (m24071U() != graphQLImage) {
                graphQLVisitableModel = (GraphQLVideo) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17059M = graphQLImage;
            }
        }
        if (m24072V() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(m24072V());
            if (m24072V() != graphQLImage) {
                graphQLVisitableModel = (GraphQLVideo) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17060N = graphQLImage;
            }
        }
        if (m24073W() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(m24073W());
            if (m24073W() != graphQLImage) {
                graphQLVisitableModel = (GraphQLVideo) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17061O = graphQLImage;
            }
        }
        if (m24074X() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(m24074X());
            if (m24074X() != graphQLImage) {
                graphQLVisitableModel = (GraphQLVideo) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17062P = graphQLImage;
            }
        }
        if (bF() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(bF());
            if (bF() != graphQLImage) {
                graphQLVisitableModel = (GraphQLVideo) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.bx = graphQLImage;
            }
        }
        if (ab() != null) {
            graphQLInlineActivitiesConnection = (GraphQLInlineActivitiesConnection) graphQLModelMutatingVisitor.mo2928b(ab());
            if (ab() != graphQLInlineActivitiesConnection) {
                graphQLVisitableModel = (GraphQLVideo) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17066T = graphQLInlineActivitiesConnection;
            }
        }
        if (ak() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(ak());
            if (ak() != graphQLImage) {
                graphQLVisitableModel = (GraphQLVideo) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.ac = graphQLImage;
            }
        }
        if (al() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(al());
            if (al() != graphQLImage) {
                graphQLVisitableModel = (GraphQLVideo) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.ad = graphQLImage;
            }
        }
        if (am() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(am());
            if (am() != graphQLImage) {
                graphQLVisitableModel = (GraphQLVideo) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.ae = graphQLImage;
            }
        }
        if (aq() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(aq());
            if (aq() != graphQLImage) {
                graphQLVisitableModel = (GraphQLVideo) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.ai = graphQLImage;
            }
        }
        if (ar() != null) {
            graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.mo2928b(ar());
            if (ar() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLVideo) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.aj = graphQLTextWithEntities;
            }
        }
        if (at() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(at());
            if (at() != graphQLImage) {
                graphQLVisitableModel = (GraphQLVideo) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.al = graphQLImage;
            }
        }
        if (aw() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(aw());
            if (aw() != graphQLImage) {
                graphQLVisitableModel = (GraphQLVideo) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.ao = graphQLImage;
            }
        }
        if (ax() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(ax());
            if (ax() != graphQLImage) {
                graphQLVisitableModel = (GraphQLVideo) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.ap = graphQLImage;
            }
        }
        if (ay() != null) {
            graphQLActor = (GraphQLActor) graphQLModelMutatingVisitor.mo2928b(ay());
            if (ay() != graphQLActor) {
                graphQLVisitableModel = (GraphQLVideo) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.aq = graphQLActor;
            }
        }
        if (aI() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(aI());
            if (aI() != graphQLImage) {
                graphQLVisitableModel = (GraphQLVideo) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.aA = graphQLImage;
            }
        }
        if (aL() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(aL());
            if (aL() != graphQLImage) {
                graphQLVisitableModel = (GraphQLVideo) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.aD = graphQLImage;
            }
        }
        if (aM() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(aM());
            if (aM() != graphQLImage) {
                graphQLVisitableModel = (GraphQLVideo) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.aE = graphQLImage;
            }
        }
        if (aN() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(aN());
            if (aN() != graphQLImage) {
                graphQLVisitableModel = (GraphQLVideo) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.aF = graphQLImage;
            }
        }
        if (aO() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(aO());
            if (aO() != graphQLImage) {
                graphQLVisitableModel = (GraphQLVideo) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.aG = graphQLImage;
            }
        }
        if (aP() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(aP());
            if (aP() != graphQLImage) {
                graphQLVisitableModel = (GraphQLVideo) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.aH = graphQLImage;
            }
        }
        if (aQ() != null) {
            graphQLPhoto = (GraphQLPhoto) graphQLModelMutatingVisitor.mo2928b(aQ());
            if (aQ() != graphQLPhoto) {
                graphQLVisitableModel = (GraphQLVideo) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.aI = graphQLPhoto;
            }
        }
        if (aR() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(aR());
            if (aR() != graphQLImage) {
                graphQLVisitableModel = (GraphQLVideo) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.aJ = graphQLImage;
            }
        }
        if (aU() != null) {
            graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.mo2928b(aU());
            if (aU() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLVideo) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.aM = graphQLTextWithEntities;
            }
        }
        if (aV() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(aV());
            if (aV() != graphQLImage) {
                graphQLVisitableModel = (GraphQLVideo) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.aN = graphQLImage;
            }
        }
        if (aW() != null) {
            graphQLRating = (GraphQLRating) graphQLModelMutatingVisitor.mo2928b(aW());
            if (aW() != graphQLRating) {
                graphQLVisitableModel = (GraphQLVideo) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.aO = graphQLRating;
            }
        }
        if (bQ() != null) {
            graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.mo2928b(bQ());
            if (bQ() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLVideo) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.bI = graphQLTextWithEntities;
            }
        }
        if (aX() != null) {
            graphQLTimelineAppCollection = (GraphQLTimelineAppCollection) graphQLModelMutatingVisitor.mo2928b(aX());
            if (aX() != graphQLTimelineAppCollection) {
                graphQLVisitableModel = (GraphQLVideo) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.aP = graphQLTimelineAppCollection;
            }
        }
        if (bH() != null) {
            graphQLPage = (GraphQLPage) graphQLModelMutatingVisitor.mo2928b(bH());
            if (bH() != graphQLPage) {
                graphQLVisitableModel = (GraphQLVideo) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.bz = graphQLPage;
            }
        }
        if (bg() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(bg());
            if (bg() != graphQLImage) {
                graphQLVisitableModel = (GraphQLVideo) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.aY = graphQLImage;
            }
        }
        if (bh() != null) {
            graphQLStreamingImage = (GraphQLStreamingImage) graphQLModelMutatingVisitor.mo2928b(bh());
            if (bh() != graphQLStreamingImage) {
                graphQLVisitableModel = (GraphQLVideo) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.aZ = graphQLStreamingImage;
            }
        }
        if (bi() != null) {
            graphQLStreamingImage = (GraphQLStreamingImage) graphQLModelMutatingVisitor.mo2928b(bi());
            if (bi() != graphQLStreamingImage) {
                graphQLVisitableModel = (GraphQLVideo) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.ba = graphQLStreamingImage;
            }
        }
        if (bj() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(bj());
            if (bj() != graphQLImage) {
                graphQLVisitableModel = (GraphQLVideo) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.bb = graphQLImage;
            }
        }
        if (bk() != null) {
            graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.mo2928b(bk());
            if (bk() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLVideo) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.bc = graphQLTextWithEntities;
            }
        }
        if (bl() != null) {
            graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.mo2928b(bl());
            if (bl() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLVideo) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.bd = graphQLTextWithEntities;
            }
        }
        if (bn() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(bn());
            if (bn() != graphQLImage) {
                graphQLVisitableModel = (GraphQLVideo) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.bf = graphQLImage;
            }
        }
        if (bp() != null) {
            graphQLVideoChannel = (GraphQLVideoChannel) graphQLModelMutatingVisitor.mo2928b(bp());
            if (bp() != graphQLVideoChannel) {
                graphQLVisitableModel = (GraphQLVideo) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.bh = graphQLVideoChannel;
            }
        }
        if (br() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(br());
            if (br() != graphQLImage) {
                graphQLVisitableModel = (GraphQLVideo) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.bj = graphQLImage;
            }
        }
        if (bu() != null) {
            a = ModelHelper.m23097a(bu(), graphQLModelMutatingVisitor);
            if (a != null) {
                graphQLVideo = (GraphQLVideo) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVideo.bm = a.m1068b();
                graphQLVisitableModel = graphQLVideo;
            }
        }
        if (bv() != null) {
            a = ModelHelper.m23097a(bv(), graphQLModelMutatingVisitor);
            if (a != null) {
                graphQLVideo = (GraphQLVideo) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVideo.bn = a.m1068b();
                graphQLVisitableModel = graphQLVideo;
            }
        }
        m9959i();
        if (graphQLVisitableModel != null) {
        }
    }

    public GraphQLVideo() {
        super(142);
    }

    public final void mo1406a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.mo1406a(mutableFlatBuffer, i, obj);
        this.f17075f = mutableFlatBuffer.m21524a(i, 2, 0);
        this.f17078i = mutableFlatBuffer.m21525a(i, 6, 0);
        this.f17079j = mutableFlatBuffer.m21524a(i, 7, 0);
        this.f17081l = mutableFlatBuffer.m21540a(i, 9);
        this.f17082m = mutableFlatBuffer.m21540a(i, 10);
        this.f17083n = mutableFlatBuffer.m21540a(i, 11);
        this.f17085p = mutableFlatBuffer.m21525a(i, 13, 0);
        this.f17091v = mutableFlatBuffer.m21540a(i, 19);
        this.f17092w = mutableFlatBuffer.m21540a(i, 20);
        this.f17093x = mutableFlatBuffer.m21524a(i, 21, 0);
        this.f17094y = mutableFlatBuffer.m21524a(i, 22, 0);
        this.f17047A = mutableFlatBuffer.m21524a(i, 24, 0);
        this.f17063Q = mutableFlatBuffer.m21524a(i, 40, 0);
        this.f17064R = mutableFlatBuffer.m21524a(i, 41, 0);
        this.f17065S = mutableFlatBuffer.m21524a(i, 42, 0);
        this.f17067U = mutableFlatBuffer.m21540a(i, 44);
        this.f17068V = mutableFlatBuffer.m21540a(i, 45);
        this.f17069W = mutableFlatBuffer.m21540a(i, 46);
        this.f17070X = mutableFlatBuffer.m21540a(i, 47);
        this.f17071Y = mutableFlatBuffer.m21540a(i, 48);
        this.f17072Z = mutableFlatBuffer.m21540a(i, 49);
        this.aa = mutableFlatBuffer.m21540a(i, 50);
        this.ab = mutableFlatBuffer.m21540a(i, 51);
        this.af = mutableFlatBuffer.m21524a(i, 55, 0);
        this.ag = mutableFlatBuffer.m21524a(i, 56, 0);
        this.ah = mutableFlatBuffer.m21524a(i, 57, 0);
        this.ar = mutableFlatBuffer.m21524a(i, 67, 0);
        this.au = mutableFlatBuffer.m21524a(i, 70, 0);
        this.av = mutableFlatBuffer.m21524a(i, 71, 0);
        this.aC = mutableFlatBuffer.m21524a(i, 78, 0);
        this.aK = mutableFlatBuffer.m21540a(i, 86);
        this.aQ = mutableFlatBuffer.m21540a(i, 93);
        this.aR = mutableFlatBuffer.m21540a(i, 94);
        this.aS = mutableFlatBuffer.m21540a(i, 95);
        this.aT = mutableFlatBuffer.m21523a(i, 96, 0.0d);
        this.aU = mutableFlatBuffer.m21523a(i, 97, 0.0d);
        this.aX = mutableFlatBuffer.m21524a(i, 100, 0);
        this.bi = mutableFlatBuffer.m21524a(i, 111, 0);
        this.bo = mutableFlatBuffer.m21524a(i, 117, 0);
        this.bs = mutableFlatBuffer.m21540a(i, 121);
        this.bw = mutableFlatBuffer.m21540a(i, 125);
        this.by = mutableFlatBuffer.m21540a(i, 127);
        this.bC = mutableFlatBuffer.m21540a(i, 134);
        this.bE = mutableFlatBuffer.m21524a(i, 136, 0);
        this.bF = mutableFlatBuffer.m21524a(i, 137, 0);
        this.bH = mutableFlatBuffer.m21540a(i, 139);
    }

    public final int mo1403a(FlatBufferBuilder flatBufferBuilder) {
        m9958h();
        int a = ModelHelper.m23093a(flatBufferBuilder, m24082j());
        int a2 = ModelHelper.m23093a(flatBufferBuilder, m24083k());
        int a3 = ModelHelper.m23093a(flatBufferBuilder, m24087p());
        int b = flatBufferBuilder.m21502b(m24088q());
        int b2 = flatBufferBuilder.m21502b(m24095x());
        int a4 = ModelHelper.m23093a(flatBufferBuilder, m24097z());
        int a5 = ModelHelper.m23093a(flatBufferBuilder, m24051A());
        int a6 = ModelHelper.m23093a(flatBufferBuilder, m24052B());
        int a7 = ModelHelper.m23093a(flatBufferBuilder, mo2890l());
        int a8 = ModelHelper.m23093a(flatBufferBuilder, m24053C());
        int b3 = flatBufferBuilder.m21502b(m24058H());
        int b4 = flatBufferBuilder.m21502b(m24060J());
        int a9 = ModelHelper.m23093a(flatBufferBuilder, m24061K());
        int a10 = ModelHelper.m23093a(flatBufferBuilder, m24062L());
        int a11 = ModelHelper.m23093a(flatBufferBuilder, m24063M());
        int a12 = ModelHelper.m23093a(flatBufferBuilder, m24064N());
        int a13 = ModelHelper.m23093a(flatBufferBuilder, m24065O());
        int a14 = ModelHelper.m23093a(flatBufferBuilder, m24066P());
        int a15 = ModelHelper.m23093a(flatBufferBuilder, m24067Q());
        int a16 = ModelHelper.m23093a(flatBufferBuilder, m24068R());
        int a17 = ModelHelper.m23093a(flatBufferBuilder, m24069S());
        int a18 = ModelHelper.m23093a(flatBufferBuilder, m24070T());
        int a19 = ModelHelper.m23093a(flatBufferBuilder, m24071U());
        int a20 = ModelHelper.m23093a(flatBufferBuilder, m24072V());
        int a21 = ModelHelper.m23093a(flatBufferBuilder, m24073W());
        int a22 = ModelHelper.m23093a(flatBufferBuilder, m24074X());
        int a23 = ModelHelper.m23093a(flatBufferBuilder, ab());
        int a24 = ModelHelper.m23093a(flatBufferBuilder, ak());
        int a25 = ModelHelper.m23093a(flatBufferBuilder, al());
        int a26 = ModelHelper.m23093a(flatBufferBuilder, am());
        int a27 = ModelHelper.m23093a(flatBufferBuilder, aq());
        int a28 = ModelHelper.m23093a(flatBufferBuilder, ar());
        int b5 = flatBufferBuilder.m21502b(as());
        int a29 = ModelHelper.m23093a(flatBufferBuilder, at());
        int b6 = flatBufferBuilder.m21502b(au());
        int b7 = flatBufferBuilder.m21502b(av());
        int a30 = ModelHelper.m23093a(flatBufferBuilder, aw());
        int a31 = ModelHelper.m23093a(flatBufferBuilder, ax());
        int a32 = ModelHelper.m23093a(flatBufferBuilder, ay());
        int b8 = flatBufferBuilder.m21502b(aA());
        int b9 = flatBufferBuilder.m21502b(aB());
        int b10 = flatBufferBuilder.m21502b(aE());
        int b11 = flatBufferBuilder.m21502b(aF());
        int b12 = flatBufferBuilder.m21502b(aG());
        int b13 = flatBufferBuilder.m21502b(aH());
        int a33 = ModelHelper.m23093a(flatBufferBuilder, aI());
        int b14 = flatBufferBuilder.m21502b(aJ());
        int a34 = ModelHelper.m23093a(flatBufferBuilder, aL());
        int a35 = ModelHelper.m23093a(flatBufferBuilder, aM());
        int a36 = ModelHelper.m23093a(flatBufferBuilder, aN());
        int a37 = ModelHelper.m23093a(flatBufferBuilder, aO());
        int a38 = ModelHelper.m23093a(flatBufferBuilder, aP());
        int a39 = ModelHelper.m23093a(flatBufferBuilder, aQ());
        int a40 = ModelHelper.m23093a(flatBufferBuilder, aR());
        int b15 = flatBufferBuilder.m21502b(aT());
        int a41 = ModelHelper.m23093a(flatBufferBuilder, aU());
        int a42 = ModelHelper.m23093a(flatBufferBuilder, aV());
        int a43 = ModelHelper.m23093a(flatBufferBuilder, aW());
        int a44 = ModelHelper.m23093a(flatBufferBuilder, aX());
        int b16 = flatBufferBuilder.m21502b(bd());
        int b17 = flatBufferBuilder.m21502b(be());
        int a45 = ModelHelper.m23093a(flatBufferBuilder, bg());
        int a46 = ModelHelper.m23093a(flatBufferBuilder, bh());
        int a47 = ModelHelper.m23093a(flatBufferBuilder, bi());
        int a48 = ModelHelper.m23093a(flatBufferBuilder, bj());
        int a49 = ModelHelper.m23093a(flatBufferBuilder, bk());
        int a50 = ModelHelper.m23093a(flatBufferBuilder, bl());
        int b18 = flatBufferBuilder.m21502b(bm());
        int a51 = ModelHelper.m23093a(flatBufferBuilder, bn());
        int c = flatBufferBuilder.m21509c(bo());
        int a52 = ModelHelper.m23093a(flatBufferBuilder, bp());
        int a53 = ModelHelper.m23093a(flatBufferBuilder, br());
        int a54 = ModelHelper.m23094a(flatBufferBuilder, bu());
        int a55 = ModelHelper.m23094a(flatBufferBuilder, bv());
        int a56 = ModelHelper.m23093a(flatBufferBuilder, bx());
        int b19 = flatBufferBuilder.m21502b(by());
        int c2 = flatBufferBuilder.m21509c(bz());
        int b20 = flatBufferBuilder.m21502b(bB());
        int a57 = flatBufferBuilder.m21481a(bC());
        int b21 = flatBufferBuilder.m21502b(bD());
        int a58 = ModelHelper.m23093a(flatBufferBuilder, bF());
        int a59 = ModelHelper.m23093a(flatBufferBuilder, bH());
        int b22 = flatBufferBuilder.m21502b(bI());
        int b23 = flatBufferBuilder.m21502b(bJ());
        int b24 = flatBufferBuilder.m21502b(bL());
        int a60 = ModelHelper.m23094a(flatBufferBuilder, bO());
        int a61 = ModelHelper.m23093a(flatBufferBuilder, bQ());
        flatBufferBuilder.m21510c(141);
        flatBufferBuilder.m21507b(0, a);
        flatBufferBuilder.m21507b(1, a2);
        flatBufferBuilder.m21494a(2, m24086o(), 0);
        flatBufferBuilder.m21507b(4, a3);
        flatBufferBuilder.m21507b(5, b);
        flatBufferBuilder.m21495a(6, m24089r(), 0);
        flatBufferBuilder.m21494a(7, m24090s(), 0);
        flatBufferBuilder.m21496a(8, m24091t() == GraphQLVideoBroadcastStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE ? null : m24091t());
        flatBufferBuilder.m21498a(9, m24092u());
        flatBufferBuilder.m21498a(10, m24093v());
        flatBufferBuilder.m21498a(11, m24094w());
        flatBufferBuilder.m21507b(12, b2);
        flatBufferBuilder.m21495a(13, m24096y(), 0);
        flatBufferBuilder.m21507b(14, a4);
        flatBufferBuilder.m21507b(15, a5);
        flatBufferBuilder.m21507b(16, a6);
        flatBufferBuilder.m21507b(17, a7);
        flatBufferBuilder.m21507b(18, a8);
        flatBufferBuilder.m21498a(19, m24054D());
        flatBufferBuilder.m21498a(20, m24055E());
        flatBufferBuilder.m21494a(21, m24056F(), 0);
        flatBufferBuilder.m21494a(22, m24057G(), 0);
        flatBufferBuilder.m21507b(23, b3);
        flatBufferBuilder.m21494a(24, m24059I(), 0);
        flatBufferBuilder.m21507b(25, b4);
        flatBufferBuilder.m21507b(26, a9);
        flatBufferBuilder.m21507b(27, a10);
        flatBufferBuilder.m21507b(28, a11);
        flatBufferBuilder.m21507b(29, a12);
        flatBufferBuilder.m21507b(30, a13);
        flatBufferBuilder.m21507b(31, a14);
        flatBufferBuilder.m21507b(32, a15);
        flatBufferBuilder.m21507b(33, a16);
        flatBufferBuilder.m21507b(34, a17);
        flatBufferBuilder.m21507b(35, a18);
        flatBufferBuilder.m21507b(36, a19);
        flatBufferBuilder.m21507b(37, a20);
        flatBufferBuilder.m21507b(38, a21);
        flatBufferBuilder.m21507b(39, a22);
        flatBufferBuilder.m21494a(40, m24075Y(), 0);
        flatBufferBuilder.m21494a(41, m24076Z(), 0);
        flatBufferBuilder.m21494a(42, aa(), 0);
        flatBufferBuilder.m21507b(43, a23);
        flatBufferBuilder.m21498a(44, ac());
        flatBufferBuilder.m21498a(45, ad());
        flatBufferBuilder.m21498a(46, ae());
        flatBufferBuilder.m21498a(47, af());
        flatBufferBuilder.m21498a(48, ag());
        flatBufferBuilder.m21498a(49, ah());
        flatBufferBuilder.m21498a(50, ai());
        flatBufferBuilder.m21498a(51, aj());
        flatBufferBuilder.m21507b(52, a24);
        flatBufferBuilder.m21507b(53, a25);
        flatBufferBuilder.m21507b(54, a26);
        flatBufferBuilder.m21494a(55, an(), 0);
        flatBufferBuilder.m21494a(56, ao(), 0);
        flatBufferBuilder.m21494a(57, ap(), 0);
        flatBufferBuilder.m21507b(58, a27);
        flatBufferBuilder.m21507b(59, a28);
        flatBufferBuilder.m21507b(60, b5);
        flatBufferBuilder.m21507b(61, a29);
        flatBufferBuilder.m21507b(62, b6);
        flatBufferBuilder.m21507b(63, b7);
        flatBufferBuilder.m21507b(64, a30);
        flatBufferBuilder.m21507b(65, a31);
        flatBufferBuilder.m21507b(66, a32);
        flatBufferBuilder.m21494a(67, az(), 0);
        flatBufferBuilder.m21507b(68, b8);
        flatBufferBuilder.m21507b(69, b9);
        flatBufferBuilder.m21494a(70, aC(), 0);
        flatBufferBuilder.m21494a(71, aD(), 0);
        flatBufferBuilder.m21507b(72, b10);
        flatBufferBuilder.m21507b(73, b11);
        flatBufferBuilder.m21507b(74, b12);
        flatBufferBuilder.m21507b(75, b13);
        flatBufferBuilder.m21507b(76, a33);
        flatBufferBuilder.m21507b(77, b14);
        flatBufferBuilder.m21494a(78, aK(), 0);
        flatBufferBuilder.m21507b(79, a34);
        flatBufferBuilder.m21507b(80, a35);
        flatBufferBuilder.m21507b(81, a36);
        flatBufferBuilder.m21507b(82, a37);
        flatBufferBuilder.m21507b(83, a38);
        flatBufferBuilder.m21507b(84, a39);
        flatBufferBuilder.m21507b(85, a40);
        flatBufferBuilder.m21498a(86, aS());
        flatBufferBuilder.m21507b(87, b15);
        flatBufferBuilder.m21507b(88, a41);
        flatBufferBuilder.m21507b(89, a42);
        flatBufferBuilder.m21507b(90, a43);
        flatBufferBuilder.m21507b(91, a44);
        flatBufferBuilder.m21498a(93, aY());
        flatBufferBuilder.m21498a(94, aZ());
        flatBufferBuilder.m21498a(95, ba());
        flatBufferBuilder.m21492a(96, bb(), 0.0d);
        flatBufferBuilder.m21492a(97, bc(), 0.0d);
        flatBufferBuilder.m21507b(98, b16);
        flatBufferBuilder.m21507b(99, b17);
        flatBufferBuilder.m21494a(100, bf(), 0);
        flatBufferBuilder.m21507b(101, a45);
        flatBufferBuilder.m21507b(102, a46);
        flatBufferBuilder.m21507b(103, a47);
        flatBufferBuilder.m21507b(104, a48);
        flatBufferBuilder.m21507b(105, a49);
        flatBufferBuilder.m21507b(106, a50);
        flatBufferBuilder.m21507b(107, b18);
        flatBufferBuilder.m21507b(108, a51);
        flatBufferBuilder.m21507b(109, c);
        flatBufferBuilder.m21507b(110, a52);
        flatBufferBuilder.m21494a(111, bq(), 0);
        flatBufferBuilder.m21507b(112, a53);
        flatBufferBuilder.m21496a(113, bs() == GraphQLVideoStatusType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE ? null : bs());
        flatBufferBuilder.m21496a(114, bt() == GraphQLSavedState.UNSET_OR_UNRECOGNIZED_ENUM_VALUE ? null : bt());
        flatBufferBuilder.m21507b(115, a54);
        flatBufferBuilder.m21507b(116, a55);
        flatBufferBuilder.m21494a(117, bw(), 0);
        flatBufferBuilder.m21507b(118, a56);
        flatBufferBuilder.m21507b(119, b19);
        flatBufferBuilder.m21507b(120, c2);
        flatBufferBuilder.m21498a(121, bA());
        flatBufferBuilder.m21507b(122, b20);
        flatBufferBuilder.m21507b(123, a57);
        flatBufferBuilder.m21507b(124, b21);
        flatBufferBuilder.m21498a(125, bE());
        flatBufferBuilder.m21507b(126, a58);
        flatBufferBuilder.m21498a(127, bG());
        flatBufferBuilder.m21507b(131, a59);
        flatBufferBuilder.m21507b(132, b22);
        flatBufferBuilder.m21507b(133, b23);
        flatBufferBuilder.m21498a(134, bK());
        flatBufferBuilder.m21507b(135, b24);
        flatBufferBuilder.m21494a(136, bM(), 0);
        flatBufferBuilder.m21494a(137, bN(), 0);
        flatBufferBuilder.m21507b(138, a60);
        flatBufferBuilder.m21498a(139, bP());
        flatBufferBuilder.m21507b(140, a61);
        m9959i();
        return flatBufferBuilder.m21511d();
    }

    public GraphQLVideo(Parcel parcel) {
        boolean z;
        boolean z2 = true;
        super(142);
        this.bG = ImmutableListHelper.m21625a(parcel.readArrayList(GraphQLUser.class.getClassLoader()));
        this.f17073d = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f17074e = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f17075f = parcel.readInt();
        this.f17076g = (GraphQLApplication) parcel.readValue(GraphQLApplication.class.getClassLoader());
        this.f17077h = parcel.readString();
        this.f17078i = parcel.readLong();
        this.f17079j = parcel.readInt();
        this.f17080k = GraphQLVideoBroadcastStatus.fromString(parcel.readString());
        this.bs = parcel.readByte() == (byte) 1;
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.f17081l = z;
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.f17082m = z;
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.f17083n = z;
        this.f17084o = parcel.readString();
        this.bq = parcel.readString();
        this.br = ImmutableListHelper.m21625a(parcel.readArrayList(String.class.getClassLoader()));
        this.f17085p = parcel.readLong();
        this.f17086q = (GraphQLStory) parcel.readValue(GraphQLStory.class.getClassLoader());
        this.bA = parcel.readString();
        this.f17087r = (GraphQLPlace) parcel.readValue(GraphQLPlace.class.getClassLoader());
        this.f17088s = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f17089t = (GraphQLFeedback) parcel.readValue(GraphQLFeedback.class.getClassLoader());
        this.f17090u = (GraphQLVideoGuidedTour) parcel.readValue(GraphQLVideoGuidedTour.class.getClassLoader());
        this.f17091v = parcel.readByte() == (byte) 1;
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.f17092w = z;
        this.f17093x = parcel.readInt();
        this.f17094y = parcel.readInt();
        this.bB = parcel.readString();
        this.f17095z = parcel.readString();
        this.f17047A = parcel.readInt();
        this.f17048B = parcel.readString();
        this.f17049C = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f17050D = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f17051E = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f17052F = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f17053G = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f17054H = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f17055I = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f17056J = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.bp = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f17057K = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f17058L = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f17059M = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f17060N = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f17061O = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f17062P = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.bx = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f17063Q = parcel.readInt();
        this.f17064R = parcel.readInt();
        this.f17065S = parcel.readInt();
        this.f17066T = (GraphQLInlineActivitiesConnection) parcel.readValue(GraphQLInlineActivitiesConnection.class.getClassLoader());
        this.f17067U = parcel.readByte() == (byte) 1;
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.f17068V = z;
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.bC = z;
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.bH = z;
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.f17069W = z;
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.f17070X = z;
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.f17071Y = z;
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.f17072Z = z;
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.aa = z;
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.ab = z;
        this.ac = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.ad = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.ae = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.af = parcel.readInt();
        this.ag = parcel.readInt();
        this.ah = parcel.readInt();
        this.ai = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.aj = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.bu = ImmutableListHelper.m21625a(parcel.readArrayList(Integer.class.getClassLoader()));
        this.ak = parcel.readString();
        this.al = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.am = parcel.readString();
        this.an = parcel.readString();
        this.ao = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.ap = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.aq = (GraphQLActor) parcel.readValue(GraphQLActor.class.getClassLoader());
        this.ar = parcel.readInt();
        this.bv = parcel.readString();
        this.as = parcel.readString();
        this.at = parcel.readString();
        this.au = parcel.readInt();
        this.av = parcel.readInt();
        this.aw = parcel.readString();
        this.ax = parcel.readString();
        this.ay = parcel.readString();
        this.az = parcel.readString();
        this.aA = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.bE = parcel.readInt();
        this.aB = parcel.readString();
        this.aC = parcel.readInt();
        this.aD = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.aE = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.aF = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.aG = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.aH = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.aI = (GraphQLPhoto) parcel.readValue(GraphQLPhoto.class.getClassLoader());
        this.aJ = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.aK = parcel.readByte() == (byte) 1;
        this.aL = parcel.readString();
        this.aM = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.aN = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.aO = (GraphQLRating) parcel.readValue(GraphQLRating.class.getClassLoader());
        this.bI = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.aP = (GraphQLTimelineAppCollection) parcel.readValue(GraphQLTimelineAppCollection.class.getClassLoader());
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.aQ = z;
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.aR = z;
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.bw = z;
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.aS = z;
        this.aT = parcel.readDouble();
        this.aU = parcel.readDouble();
        this.aV = parcel.readString();
        this.aW = parcel.readString();
        this.bD = parcel.readString();
        this.aX = parcel.readInt();
        this.bz = (GraphQLPage) parcel.readValue(GraphQLPage.class.getClassLoader());
        this.aY = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.aZ = (GraphQLStreamingImage) parcel.readValue(GraphQLStreamingImage.class.getClassLoader());
        this.ba = (GraphQLStreamingImage) parcel.readValue(GraphQLStreamingImage.class.getClassLoader());
        if (parcel.readByte() != (byte) 1) {
            z2 = false;
        }
        this.by = z2;
        this.bb = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.bc = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.bd = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.bF = parcel.readInt();
        this.be = parcel.readString();
        this.bf = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.bg = ImmutableListHelper.m21625a(parcel.readArrayList(String.class.getClassLoader()));
        this.bt = parcel.readString();
        this.bh = (GraphQLVideoChannel) parcel.readValue(GraphQLVideoChannel.class.getClassLoader());
        this.bi = parcel.readInt();
        this.bj = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.bk = GraphQLVideoStatusType.fromString(parcel.readString());
        this.bl = GraphQLSavedState.fromString(parcel.readString());
        this.bm = ImmutableListHelper.m21625a(parcel.readArrayList(GraphQLTimelineAppCollection.class.getClassLoader()));
        this.bn = ImmutableListHelper.m21625a(parcel.readArrayList(GraphQLTimelineAppCollection.class.getClassLoader()));
        this.bo = parcel.readInt();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int i2;
        int i3 = 1;
        parcel.writeList(bO());
        parcel.writeValue(m24082j());
        parcel.writeValue(m24083k());
        parcel.writeInt(m24086o());
        parcel.writeValue(m24087p());
        parcel.writeString(m24088q());
        parcel.writeLong(m24089r());
        parcel.writeInt(m24090s());
        parcel.writeString(m24091t().name());
        parcel.writeByte((byte) (bA() ? 1 : 0));
        if (m24092u()) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        if (m24093v()) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        if (m24094w()) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        parcel.writeString(m24095x());
        parcel.writeString(by());
        parcel.writeList(bz());
        parcel.writeLong(m24096y());
        parcel.writeValue(m24097z());
        parcel.writeString(bI());
        parcel.writeValue(m24051A());
        parcel.writeValue(m24052B());
        parcel.writeValue(mo2890l());
        parcel.writeValue(m24053C());
        parcel.writeByte((byte) (m24054D() ? 1 : 0));
        if (m24055E()) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        parcel.writeInt(m24056F());
        parcel.writeInt(m24057G());
        parcel.writeString(bJ());
        parcel.writeString(m24058H());
        parcel.writeInt(m24059I());
        parcel.writeString(m24060J());
        parcel.writeValue(m24061K());
        parcel.writeValue(m24062L());
        parcel.writeValue(m24063M());
        parcel.writeValue(m24064N());
        parcel.writeValue(m24065O());
        parcel.writeValue(m24066P());
        parcel.writeValue(m24067Q());
        parcel.writeValue(m24068R());
        parcel.writeValue(bx());
        parcel.writeValue(m24069S());
        parcel.writeValue(m24070T());
        parcel.writeValue(m24071U());
        parcel.writeValue(m24072V());
        parcel.writeValue(m24073W());
        parcel.writeValue(m24074X());
        parcel.writeValue(bF());
        parcel.writeInt(m24075Y());
        parcel.writeInt(m24076Z());
        parcel.writeInt(aa());
        parcel.writeValue(ab());
        parcel.writeByte((byte) (ac() ? 1 : 0));
        if (ad()) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        if (bK()) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        if (bP()) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        if (ae()) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        if (af()) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        if (ag()) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        if (ah()) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
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
        parcel.writeValue(ak());
        parcel.writeValue(al());
        parcel.writeValue(am());
        parcel.writeInt(an());
        parcel.writeInt(ao());
        parcel.writeInt(ap());
        parcel.writeValue(aq());
        parcel.writeValue(ar());
        parcel.writeList(bC());
        parcel.writeString(as());
        parcel.writeValue(at());
        parcel.writeString(au());
        parcel.writeString(av());
        parcel.writeValue(aw());
        parcel.writeValue(ax());
        parcel.writeValue(ay());
        parcel.writeInt(az());
        parcel.writeString(bD());
        parcel.writeString(aA());
        parcel.writeString(aB());
        parcel.writeInt(aC());
        parcel.writeInt(aD());
        parcel.writeString(aE());
        parcel.writeString(aF());
        parcel.writeString(aG());
        parcel.writeString(aH());
        parcel.writeValue(aI());
        parcel.writeInt(bM());
        parcel.writeString(aJ());
        parcel.writeInt(aK());
        parcel.writeValue(aL());
        parcel.writeValue(aM());
        parcel.writeValue(aN());
        parcel.writeValue(aO());
        parcel.writeValue(aP());
        parcel.writeValue(aQ());
        parcel.writeValue(aR());
        parcel.writeByte((byte) (aS() ? 1 : 0));
        parcel.writeString(aT());
        parcel.writeValue(aU());
        parcel.writeValue(aV());
        parcel.writeValue(aW());
        parcel.writeValue(bQ());
        parcel.writeValue(aX());
        if (aY()) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        if (aZ()) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        if (bE()) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        if (ba()) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        parcel.writeDouble(bb());
        parcel.writeDouble(bc());
        parcel.writeString(bd());
        parcel.writeString(be());
        parcel.writeString(bL());
        parcel.writeInt(bf());
        parcel.writeValue(bH());
        parcel.writeValue(bg());
        parcel.writeValue(bh());
        parcel.writeValue(bi());
        if (!bG()) {
            i3 = 0;
        }
        parcel.writeByte((byte) i3);
        parcel.writeValue(bj());
        parcel.writeValue(bk());
        parcel.writeValue(bl());
        parcel.writeInt(bN());
        parcel.writeString(bm());
        parcel.writeValue(bn());
        parcel.writeList(bo());
        parcel.writeString(bB());
        parcel.writeValue(bp());
        parcel.writeInt(bq());
        parcel.writeValue(br());
        parcel.writeString(bs().name());
        parcel.writeString(bt().name());
        parcel.writeList(bu());
        parcel.writeList(bv());
        parcel.writeInt(bw());
    }

    public GraphQLVideo(Builder builder) {
        super(142);
        this.b = builder.f15736a;
        this.c = builder.f15737b;
        this.bG = builder.f19302d;
        this.f17073d = builder.f19303e;
        this.f17074e = builder.f19304f;
        this.f17075f = builder.f19305g;
        this.f17076g = builder.f19306h;
        this.f17077h = builder.f19307i;
        this.f17078i = builder.f19308j;
        this.f17079j = builder.f19309k;
        this.f17080k = builder.f19310l;
        this.bs = builder.f19311m;
        this.f17081l = builder.f19312n;
        this.f17082m = builder.f19313o;
        this.f17083n = builder.f19314p;
        this.f17084o = builder.f19315q;
        this.bq = builder.f19316r;
        this.br = builder.f19317s;
        this.f17085p = builder.f19318t;
        this.f17086q = builder.f19319u;
        this.bA = builder.f19320v;
        this.f17087r = builder.f19321w;
        this.f17088s = builder.f19322x;
        this.f17089t = builder.f19323y;
        this.f17090u = builder.f19324z;
        this.f17091v = builder.f19276A;
        this.f17092w = builder.f19277B;
        this.f17093x = builder.f19278C;
        this.f17094y = builder.f19279D;
        this.bB = builder.f19280E;
        this.f17095z = builder.f19281F;
        this.f17047A = builder.f19282G;
        this.f17048B = builder.f19283H;
        this.f17049C = builder.f19284I;
        this.f17050D = builder.f19285J;
        this.f17051E = builder.f19286K;
        this.f17052F = builder.f19287L;
        this.f17053G = builder.f19288M;
        this.f17054H = builder.f19289N;
        this.f17055I = builder.f19290O;
        this.f17056J = builder.f19291P;
        this.bp = builder.f19292Q;
        this.f17057K = builder.f19293R;
        this.f17058L = builder.f19294S;
        this.f17059M = builder.f19295T;
        this.f17060N = builder.f19296U;
        this.f17061O = builder.f19297V;
        this.f17062P = builder.f19298W;
        this.bx = builder.f19299X;
        this.f17063Q = builder.f19300Y;
        this.f17064R = builder.f19301Z;
        this.f17065S = builder.aa;
        this.f17066T = builder.ab;
        this.f17067U = builder.ac;
        this.f17068V = builder.ad;
        this.bC = builder.ae;
        this.bH = builder.af;
        this.f17069W = builder.ag;
        this.f17070X = builder.ah;
        this.f17071Y = builder.ai;
        this.f17072Z = builder.aj;
        this.aa = builder.ak;
        this.ab = builder.al;
        this.ac = builder.am;
        this.ad = builder.an;
        this.ae = builder.ao;
        this.af = builder.ap;
        this.ag = builder.aq;
        this.ah = builder.ar;
        this.ai = builder.as;
        this.aj = builder.at;
        this.bu = builder.au;
        this.ak = builder.av;
        this.al = builder.aw;
        this.am = builder.ax;
        this.an = builder.ay;
        this.ao = builder.az;
        this.ap = builder.aA;
        this.aq = builder.aB;
        this.ar = builder.aC;
        this.bv = builder.aD;
        this.as = builder.aE;
        this.at = builder.aF;
        this.au = builder.aG;
        this.av = builder.aH;
        this.aw = builder.aI;
        this.ax = builder.aJ;
        this.ay = builder.aK;
        this.az = builder.aL;
        this.aA = builder.aM;
        this.bE = builder.aN;
        this.aB = builder.aO;
        this.aC = builder.aP;
        this.aD = builder.aQ;
        this.aE = builder.aR;
        this.aF = builder.aS;
        this.aG = builder.aT;
        this.aH = builder.aU;
        this.aI = builder.aV;
        this.aJ = builder.aW;
        this.aK = builder.aX;
        this.aL = builder.aY;
        this.aM = builder.aZ;
        this.aN = builder.ba;
        this.aO = builder.bb;
        this.bI = builder.bc;
        this.aP = builder.bd;
        this.aQ = builder.be;
        this.aR = builder.bf;
        this.bw = builder.bg;
        this.aS = builder.bh;
        this.aT = builder.bi;
        this.aU = builder.bj;
        this.aV = builder.bk;
        this.aW = builder.bl;
        this.bD = builder.bm;
        this.aX = builder.bn;
        this.bz = builder.bo;
        this.aY = builder.bp;
        this.aZ = builder.bq;
        this.ba = builder.br;
        this.by = builder.bs;
        this.bb = builder.bt;
        this.bc = builder.bu;
        this.bd = builder.bv;
        this.bF = builder.bw;
        this.be = builder.bx;
        this.bf = builder.by;
        this.bg = builder.bz;
        this.bt = builder.bA;
        this.bh = builder.bB;
        this.bi = builder.bC;
        this.bj = builder.bD;
        this.bk = builder.bE;
        this.bl = builder.bF;
        this.bm = builder.bG;
        this.bn = builder.bH;
        this.bo = builder.bI;
    }
}
