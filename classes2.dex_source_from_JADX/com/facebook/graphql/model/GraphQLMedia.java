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
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.enums.GraphQLVideoBroadcastStatus;
import com.facebook.graphql.enums.GraphQLVideoStatusType;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ImmutableListHelper;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.modelutil.TypeModel;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.proxygen.HTTPTransportCallback;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.instagram.common.json.annotation.JsonType;
import java.util.List;
import javax.annotation.Nullable;

@AutoGenJsonDeserializer
@AutoGenJsonSerializer
@Deprecated
@JsonType
/* compiled from: listeners */
public final class GraphQLMedia extends BaseModel implements TypeModel, GraphQLPersistableNode, GraphQLVisitableModel {
    public static final Creator<GraphQLMedia> CREATOR = new C07851();
    @Nullable
    public GraphQLPlace f17344A;
    @Nullable
    public GraphQLPhotoFaceBoxesConnection f17345B;
    @Nullable
    public GraphQLFeedback f17346C;
    @Nullable
    public GraphQLVect2 f17347D;
    @Nullable
    public GraphQLVideoGuidedTour f17348E;
    public boolean f17349F;
    public boolean f17350G;
    public boolean f17351H;
    public int f17352I;
    public int f17353J;
    @Nullable
    public String f17354K;
    public int f17355L;
    @Nullable
    public String f17356M;
    @Nullable
    public GraphQLImage f17357N;
    @Nullable
    public GraphQLImage f17358O;
    @Nullable
    public GraphQLImage f17359P;
    @Nullable
    public GraphQLImage f17360Q;
    @Nullable
    public GraphQLImage f17361R;
    @Nullable
    public GraphQLImage f17362S;
    @Nullable
    public GraphQLImage f17363T;
    @Nullable
    public GraphQLImage f17364U;
    @Nullable
    public GraphQLImage f17365V;
    @Nullable
    public GraphQLImage f17366W;
    @Nullable
    public GraphQLImage f17367X;
    @Nullable
    public GraphQLImage f17368Y;
    @Nullable
    public GraphQLImage f17369Z;
    @Nullable
    public GraphQLActor aA;
    @Nullable
    public GraphQLVideo aB;
    @Nullable
    public GraphQLPlace aC;
    public List<GraphQLPhotoEncoding> aD;
    public int aE;
    @Nullable
    public String aF;
    @Nullable
    public String aG;
    public int aH;
    public int aI;
    @Nullable
    public String aJ;
    @Nullable
    public String aK;
    @Nullable
    public GraphQLImage aL;
    @Nullable
    public String aM;
    @Nullable
    public GraphQLPrivacyScope aN;
    @Deprecated
    @Nullable
    public GraphQLImageOverlay aO;
    @Nullable
    public String aP;
    @Nullable
    public GraphQLTextWithEntities aQ;
    @Nullable
    public GraphQLImage aR;
    public boolean aS;
    public boolean aT;
    public boolean aU;
    public boolean aV;
    @Deprecated
    public boolean aW;
    public double aX;
    public double aY;
    @Nullable
    public String aZ;
    public int aa;
    public int ab;
    public int ac;
    @Nullable
    public GraphQLInlineActivitiesConnection ad;
    public boolean ae;
    public boolean af;
    public boolean ag;
    public boolean ah;
    public boolean ai;
    public boolean aj;
    public boolean ak;
    public boolean al;
    public boolean am;
    @Nullable
    public GraphQLImage an;
    @Nullable
    public GraphQLImage ao;
    @Nullable
    public GraphQLImage ap;
    public int aq;
    @Nullable
    public GraphQLPlaceSuggestionInfo ar;
    public int as;
    @Nullable
    public GraphQLImage at;
    @Nullable
    public GraphQLTextWithEntities au;
    @Nullable
    public String av;
    @Nullable
    public GraphQLImage aw;
    @Nullable
    public String ax;
    @Nullable
    public GraphQLImage ay;
    @Nullable
    public GraphQLImage az;
    @Nullable
    public String ba;
    public int bb;
    @Nullable
    public GraphQLImage bc;
    @Nullable
    public GraphQLStreamingImage bd;
    @Nullable
    public GraphQLStreamingImage be;
    @Nullable
    public GraphQLPhotoTagsConnection bf;
    public List<String> bg;
    @Nullable
    public GraphQLVideoChannel bh;
    public int bi;
    public int bj;
    @Nullable
    public GraphQLWithTagsConnection bk;
    @Nullable
    public GraphQLImage bl;
    public GraphQLVideoBroadcastStatus bm;
    public boolean bn;
    @Nullable
    public GraphQLImage bo;
    public GraphQLVideoStatusType bp;
    public boolean bq;
    @Nullable
    public GraphQLPage br;
    public boolean bs;
    public boolean bt;
    public int bu;
    public int bv;
    @Nullable
    public GraphQLObjectType f17370d;
    @Nullable
    public String f17371e;
    @Deprecated
    @Nullable
    public GraphQLAlbum f17372f;
    @Nullable
    public GraphQLImage f17373g;
    public int f17374h;
    @Nullable
    public GraphQLApplication f17375i;
    @Deprecated
    @Nullable
    public String f17376j;
    public long f17377k;
    public int f17378l;
    public boolean f17379m;
    public boolean f17380n;
    public boolean f17381o;
    public boolean f17382p;
    public boolean f17383q;
    public boolean f17384r;
    public boolean f17385s;
    public boolean f17386t;
    public boolean f17387u;
    public boolean f17388v;
    @Nullable
    public String f17389w;
    @Nullable
    public GraphQLStory f17390x;
    public long f17391y;
    @Nullable
    public GraphQLStory f17392z;

    /* compiled from: listeners */
    final class C07851 implements Creator<GraphQLMedia> {
        C07851() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLMedia(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLMedia[i];
        }
    }

    @Nullable
    public final GraphQLObjectType m24453j() {
        if (this.f5823b != null && this.f17370d == null) {
            this.f17370d = new GraphQLObjectType(this.f5823b.m21542b(this.f5824c, 0));
        }
        if (this.f17370d == null || this.f17370d.m22301g() != 0) {
            return this.f17370d;
        }
        return null;
    }

    @FieldOffset
    @Nullable
    public final String m24454k() {
        this.f17371e = super.m9948a(this.f17371e, 1);
        return this.f17371e;
    }

    @FieldOffset
    @Nullable
    public final GraphQLAlbum m24455l() {
        this.f17372f = (GraphQLAlbum) super.m9947a(this.f17372f, 2, GraphQLAlbum.class);
        return this.f17372f;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m24456m() {
        this.f17373g = (GraphQLImage) super.m9947a(this.f17373g, 3, GraphQLImage.class);
        return this.f17373g;
    }

    @FieldOffset
    public final int m24457n() {
        m9949a(0, 4);
        return this.f17374h;
    }

    @FieldOffset
    @Nullable
    public final GraphQLApplication m24458o() {
        this.f17375i = (GraphQLApplication) super.m9947a(this.f17375i, 6, GraphQLApplication.class);
        return this.f17375i;
    }

    @FieldOffset
    @Nullable
    public final String m24459p() {
        this.f17376j = super.m9948a(this.f17376j, 7);
        return this.f17376j;
    }

    @FieldOffset
    public final long m24460q() {
        m9949a(1, 0);
        return this.f17377k;
    }

    @FieldOffset
    public final int m24461r() {
        m9949a(1, 1);
        return this.f17378l;
    }

    @FieldOffset
    public final boolean m24462s() {
        m9949a(1, 2);
        return this.f17379m;
    }

    @FieldOffset
    public final boolean m24463t() {
        m9949a(1, 3);
        return this.f17380n;
    }

    @FieldOffset
    public final boolean m24464u() {
        m9949a(1, 4);
        return this.f17381o;
    }

    @FieldOffset
    public final boolean m24465v() {
        m9949a(1, 5);
        return this.f17382p;
    }

    @FieldOffset
    public final boolean m24466w() {
        m9949a(1, 6);
        return this.f17383q;
    }

    @FieldOffset
    public final boolean m24467x() {
        m9949a(1, 7);
        return this.f17384r;
    }

    @FieldOffset
    public final boolean m24468y() {
        m9949a(2, 0);
        return this.f17385s;
    }

    @FieldOffset
    public final boolean m24469z() {
        m9949a(2, 1);
        return this.f17386t;
    }

    @FieldOffset
    public final boolean m24422A() {
        m9949a(2, 2);
        return this.f17387u;
    }

    @FieldOffset
    public final boolean m24423B() {
        m9949a(2, 3);
        return this.f17388v;
    }

    @FieldOffset
    @Nullable
    public final String m24424C() {
        this.f17389w = super.m9948a(this.f17389w, 20);
        return this.f17389w;
    }

    @FieldOffset
    @Nullable
    public final GraphQLStory m24425D() {
        this.f17390x = (GraphQLStory) super.m9947a(this.f17390x, 21, GraphQLStory.class);
        return this.f17390x;
    }

    @FieldOffset
    public final long m24426E() {
        m9949a(2, 6);
        return this.f17391y;
    }

    @FieldOffset
    @Nullable
    public final GraphQLStory m24427F() {
        this.f17392z = (GraphQLStory) super.m9947a(this.f17392z, 23, GraphQLStory.class);
        return this.f17392z;
    }

    @FieldOffset
    @Nullable
    public final GraphQLPlace m24428G() {
        this.f17344A = (GraphQLPlace) super.m9947a(this.f17344A, 24, GraphQLPlace.class);
        return this.f17344A;
    }

    @FieldOffset
    @Nullable
    public final GraphQLPhotoFaceBoxesConnection m24429H() {
        this.f17345B = (GraphQLPhotoFaceBoxesConnection) super.m9947a(this.f17345B, 25, GraphQLPhotoFaceBoxesConnection.class);
        return this.f17345B;
    }

    @FieldOffset
    @Nullable
    public final GraphQLFeedback m24430I() {
        this.f17346C = (GraphQLFeedback) super.m9947a(this.f17346C, 26, GraphQLFeedback.class);
        return this.f17346C;
    }

    @FieldOffset
    @Nullable
    public final GraphQLVect2 m24431J() {
        this.f17347D = (GraphQLVect2) super.m9947a(this.f17347D, 27, GraphQLVect2.class);
        return this.f17347D;
    }

    @FieldOffset
    @Nullable
    public final GraphQLVideoGuidedTour m24432K() {
        this.f17348E = (GraphQLVideoGuidedTour) super.m9947a(this.f17348E, 28, GraphQLVideoGuidedTour.class);
        return this.f17348E;
    }

    @FieldOffset
    public final boolean m24433L() {
        m9949a(3, 5);
        return this.f17349F;
    }

    @FieldOffset
    public final boolean m24434M() {
        m9949a(3, 6);
        return this.f17350G;
    }

    @FieldOffset
    public final boolean m24435N() {
        m9949a(3, 7);
        return this.f17351H;
    }

    @FieldOffset
    public final int m24436O() {
        m9949a(4, 0);
        return this.f17352I;
    }

    @FieldOffset
    public final int m24437P() {
        m9949a(4, 1);
        return this.f17353J;
    }

    @FieldOffset
    @Nullable
    public final String m24438Q() {
        this.f17354K = super.m9948a(this.f17354K, 34);
        return this.f17354K;
    }

    @FieldOffset
    public final int m24439R() {
        m9949a(4, 3);
        return this.f17355L;
    }

    @FieldOffset
    @Nullable
    public final String m24452b() {
        this.f17356M = super.m9948a(this.f17356M, 36);
        return this.f17356M;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m24440S() {
        this.f17357N = (GraphQLImage) super.m9947a(this.f17357N, 37, GraphQLImage.class);
        return this.f17357N;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m24441T() {
        this.f17358O = (GraphQLImage) super.m9947a(this.f17358O, 38, GraphQLImage.class);
        return this.f17358O;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m24442U() {
        this.f17359P = (GraphQLImage) super.m9947a(this.f17359P, 39, GraphQLImage.class);
        return this.f17359P;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m24443V() {
        this.f17360Q = (GraphQLImage) super.m9947a(this.f17360Q, 40, GraphQLImage.class);
        return this.f17360Q;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m24444W() {
        this.f17361R = (GraphQLImage) super.m9947a(this.f17361R, 41, GraphQLImage.class);
        return this.f17361R;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m24445X() {
        this.f17362S = (GraphQLImage) super.m9947a(this.f17362S, 42, GraphQLImage.class);
        return this.f17362S;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m24446Y() {
        this.f17363T = (GraphQLImage) super.m9947a(this.f17363T, 43, GraphQLImage.class);
        return this.f17363T;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m24447Z() {
        this.f17364U = (GraphQLImage) super.m9947a(this.f17364U, 44, GraphQLImage.class);
        return this.f17364U;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage aa() {
        this.f17365V = (GraphQLImage) super.m9947a(this.f17365V, 45, GraphQLImage.class);
        return this.f17365V;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage ab() {
        this.f17366W = (GraphQLImage) super.m9947a(this.f17366W, 46, GraphQLImage.class);
        return this.f17366W;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage ac() {
        this.f17367X = (GraphQLImage) super.m9947a(this.f17367X, 47, GraphQLImage.class);
        return this.f17367X;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage ad() {
        this.f17368Y = (GraphQLImage) super.m9947a(this.f17368Y, 48, GraphQLImage.class);
        return this.f17368Y;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage ae() {
        this.f17369Z = (GraphQLImage) super.m9947a(this.f17369Z, 49, GraphQLImage.class);
        return this.f17369Z;
    }

    @FieldOffset
    public final int af() {
        m9949a(6, 2);
        return this.aa;
    }

    @FieldOffset
    public final int ag() {
        m9949a(6, 3);
        return this.ab;
    }

    @FieldOffset
    public final int ah() {
        m9949a(6, 4);
        return this.ac;
    }

    @FieldOffset
    @Nullable
    public final GraphQLInlineActivitiesConnection ai() {
        this.ad = (GraphQLInlineActivitiesConnection) super.m9947a(this.ad, 53, GraphQLInlineActivitiesConnection.class);
        return this.ad;
    }

    @FieldOffset
    public final boolean aj() {
        m9949a(6, 6);
        return this.ae;
    }

    @FieldOffset
    public final boolean ak() {
        m9949a(6, 7);
        return this.af;
    }

    @FieldOffset
    public final boolean al() {
        m9949a(7, 0);
        return this.ag;
    }

    @FieldOffset
    public final boolean am() {
        m9949a(7, 1);
        return this.ah;
    }

    @FieldOffset
    public final boolean an() {
        m9949a(7, 2);
        return this.ai;
    }

    @FieldOffset
    public final boolean ao() {
        m9949a(7, 3);
        return this.aj;
    }

    @FieldOffset
    public final boolean ap() {
        m9949a(7, 4);
        return this.ak;
    }

    @FieldOffset
    public final boolean aq() {
        m9949a(7, 5);
        return this.al;
    }

    @FieldOffset
    public final boolean ar() {
        m9949a(7, 6);
        return this.am;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage as() {
        this.an = (GraphQLImage) super.m9947a(this.an, 63, GraphQLImage.class);
        return this.an;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage at() {
        this.ao = (GraphQLImage) super.m9947a(this.ao, 64, GraphQLImage.class);
        return this.ao;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage au() {
        this.ap = (GraphQLImage) super.m9947a(this.ap, 65, GraphQLImage.class);
        return this.ap;
    }

    @FieldOffset
    public final int av() {
        m9949a(8, 2);
        return this.aq;
    }

    @FieldOffset
    @Nullable
    public final GraphQLPlaceSuggestionInfo aw() {
        this.ar = (GraphQLPlaceSuggestionInfo) super.m9947a(this.ar, 67, GraphQLPlaceSuggestionInfo.class);
        return this.ar;
    }

    @FieldOffset
    public final int ax() {
        m9949a(8, 4);
        return this.as;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage ay() {
        this.at = (GraphQLImage) super.m9947a(this.at, 69, GraphQLImage.class);
        return this.at;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities az() {
        this.au = (GraphQLTextWithEntities) super.m9947a(this.au, 70, GraphQLTextWithEntities.class);
        return this.au;
    }

    @FieldOffset
    @Nullable
    public final String aA() {
        this.av = super.m9948a(this.av, 71);
        return this.av;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage aB() {
        this.aw = (GraphQLImage) super.m9947a(this.aw, 72, GraphQLImage.class);
        return this.aw;
    }

    @FieldOffset
    @Nullable
    public final String aC() {
        this.ax = super.m9948a(this.ax, 73);
        return this.ax;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage aD() {
        this.ay = (GraphQLImage) super.m9947a(this.ay, 74, GraphQLImage.class);
        return this.ay;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage aE() {
        this.az = (GraphQLImage) super.m9947a(this.az, 75, GraphQLImage.class);
        return this.az;
    }

    @FieldOffset
    @Nullable
    public final GraphQLActor aF() {
        this.aA = (GraphQLActor) super.m9947a(this.aA, 76, GraphQLActor.class);
        return this.aA;
    }

    @FieldOffset
    @Nullable
    public final GraphQLVideo aG() {
        this.aB = (GraphQLVideo) super.m9947a(this.aB, 77, GraphQLVideo.class);
        return this.aB;
    }

    @FieldOffset
    @Nullable
    public final GraphQLPlace aH() {
        this.aC = (GraphQLPlace) super.m9947a(this.aC, 78, GraphQLPlace.class);
        return this.aC;
    }

    @FieldOffset
    public final ImmutableList<GraphQLPhotoEncoding> aI() {
        this.aD = super.m9944a(this.aD, 79, GraphQLPhotoEncoding.class);
        return (ImmutableList) this.aD;
    }

    @FieldOffset
    public final int aJ() {
        m9949a(10, 0);
        return this.aE;
    }

    @FieldOffset
    @Nullable
    public final String aK() {
        this.aF = super.m9948a(this.aF, 81);
        return this.aF;
    }

    @FieldOffset
    @Nullable
    public final String aL() {
        this.aG = super.m9948a(this.aG, 82);
        return this.aG;
    }

    @FieldOffset
    public final int aM() {
        m9949a(10, 3);
        return this.aH;
    }

    @FieldOffset
    public final int aN() {
        m9949a(10, 4);
        return this.aI;
    }

    @FieldOffset
    @Nullable
    public final String aO() {
        this.aJ = super.m9948a(this.aJ, 85);
        return this.aJ;
    }

    @FieldOffset
    @Nullable
    public final String aP() {
        this.aK = super.m9948a(this.aK, 86);
        return this.aK;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage aQ() {
        this.aL = (GraphQLImage) super.m9947a(this.aL, 87, GraphQLImage.class);
        return this.aL;
    }

    @FieldOffset
    @Nullable
    public final String aR() {
        this.aM = super.m9948a(this.aM, 88);
        return this.aM;
    }

    @FieldOffset
    @Nullable
    public final GraphQLPrivacyScope aS() {
        this.aN = (GraphQLPrivacyScope) super.m9947a(this.aN, 89, GraphQLPrivacyScope.class);
        return this.aN;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImageOverlay aT() {
        this.aO = (GraphQLImageOverlay) super.m9947a(this.aO, 90, GraphQLImageOverlay.class);
        return this.aO;
    }

    @FieldOffset
    @Nullable
    public final String aU() {
        this.aP = super.m9948a(this.aP, 91);
        return this.aP;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities aV() {
        this.aQ = (GraphQLTextWithEntities) super.m9947a(this.aQ, 92, GraphQLTextWithEntities.class);
        return this.aQ;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage aW() {
        this.aR = (GraphQLImage) super.m9947a(this.aR, 93, GraphQLImage.class);
        return this.aR;
    }

    @FieldOffset
    public final boolean aX() {
        m9949a(11, 6);
        return this.aS;
    }

    @FieldOffset
    public final boolean aY() {
        m9949a(11, 7);
        return this.aT;
    }

    @FieldOffset
    public final boolean aZ() {
        m9949a(12, 0);
        return this.aU;
    }

    @FieldOffset
    public final boolean ba() {
        m9949a(12, 1);
        return this.aV;
    }

    @FieldOffset
    public final boolean bb() {
        m9949a(12, 2);
        return this.aW;
    }

    @FieldOffset
    public final double bc() {
        m9949a(12, 3);
        return this.aX;
    }

    @FieldOffset
    public final double bd() {
        m9949a(12, 4);
        return this.aY;
    }

    @FieldOffset
    @Nullable
    public final String be() {
        this.aZ = super.m9948a(this.aZ, 101);
        return this.aZ;
    }

    @FieldOffset
    @Nullable
    public final String bf() {
        this.ba = super.m9948a(this.ba, 102);
        return this.ba;
    }

    @FieldOffset
    public final int bg() {
        m9949a(12, 7);
        return this.bb;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage bh() {
        this.bc = (GraphQLImage) super.m9947a(this.bc, 104, GraphQLImage.class);
        return this.bc;
    }

    @FieldOffset
    @Nullable
    public final GraphQLStreamingImage bi() {
        this.bd = (GraphQLStreamingImage) super.m9947a(this.bd, 105, GraphQLStreamingImage.class);
        return this.bd;
    }

    @FieldOffset
    @Nullable
    public final GraphQLStreamingImage bj() {
        this.be = (GraphQLStreamingImage) super.m9947a(this.be, 106, GraphQLStreamingImage.class);
        return this.be;
    }

    @FieldOffset
    @Nullable
    public final GraphQLPhotoTagsConnection bk() {
        this.bf = (GraphQLPhotoTagsConnection) super.m9947a(this.bf, 107, GraphQLPhotoTagsConnection.class);
        return this.bf;
    }

    @FieldOffset
    public final ImmutableList<String> bl() {
        this.bg = super.m9943a(this.bg, 108);
        return (ImmutableList) this.bg;
    }

    @FieldOffset
    @Nullable
    public final GraphQLVideoChannel bm() {
        this.bh = (GraphQLVideoChannel) super.m9947a(this.bh, 109, GraphQLVideoChannel.class);
        return this.bh;
    }

    @FieldOffset
    public final int bn() {
        m9949a(13, 6);
        return this.bi;
    }

    @FieldOffset
    public final int bo() {
        m9949a(13, 7);
        return this.bj;
    }

    @FieldOffset
    @Nullable
    public final GraphQLWithTagsConnection bp() {
        this.bk = (GraphQLWithTagsConnection) super.m9947a(this.bk, 112, GraphQLWithTagsConnection.class);
        return this.bk;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage bq() {
        this.bl = (GraphQLImage) super.m9947a(this.bl, 113, GraphQLImage.class);
        return this.bl;
    }

    @FieldOffset
    public final GraphQLVideoBroadcastStatus br() {
        this.bm = (GraphQLVideoBroadcastStatus) super.m9945a(this.bm, 114, GraphQLVideoBroadcastStatus.class, GraphQLVideoBroadcastStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
        return this.bm;
    }

    @FieldOffset
    public final boolean bs() {
        m9949a(14, 3);
        return this.bn;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage bt() {
        this.bo = (GraphQLImage) super.m9947a(this.bo, 116, GraphQLImage.class);
        return this.bo;
    }

    @FieldOffset
    public final GraphQLVideoStatusType bu() {
        this.bp = (GraphQLVideoStatusType) super.m9945a(this.bp, 117, GraphQLVideoStatusType.class, GraphQLVideoStatusType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
        return this.bp;
    }

    @FieldOffset
    public final boolean bv() {
        m9949a(14, 6);
        return this.bq;
    }

    @FieldOffset
    @Nullable
    public final GraphQLPage bw() {
        this.br = (GraphQLPage) super.m9947a(this.br, 122, GraphQLPage.class);
        return this.br;
    }

    @FieldOffset
    public final boolean bx() {
        m9949a(15, 3);
        return this.bs;
    }

    @FieldOffset
    public final boolean by() {
        m9949a(15, 4);
        return this.bt;
    }

    @FieldOffset
    public final int bz() {
        m9949a(15, 5);
        return this.bu;
    }

    @FieldOffset
    public final int bA() {
        m9949a(15, 6);
        return this.bv;
    }

    @Nullable
    public final String mo2834a() {
        return m24452b();
    }

    public final int jK_() {
        return 74219460;
    }

    public final GraphQLVisitableModel mo1404a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLImage graphQLImage;
        GraphQLStory graphQLStory;
        GraphQLPlace graphQLPlace;
        GraphQLTextWithEntities graphQLTextWithEntities;
        GraphQLStreamingImage graphQLStreamingImage;
        GraphQLVisitableModel graphQLVisitableModel = null;
        m9958h();
        if (m24455l() != null) {
            GraphQLAlbum graphQLAlbum = (GraphQLAlbum) graphQLModelMutatingVisitor.mo2928b(m24455l());
            if (m24455l() != graphQLAlbum) {
                graphQLVisitableModel = (GraphQLMedia) ModelHelper.m23095a(null, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17372f = graphQLAlbum;
            }
        }
        if (m24456m() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(m24456m());
            if (m24456m() != graphQLImage) {
                graphQLVisitableModel = (GraphQLMedia) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17373g = graphQLImage;
            }
        }
        if (m24458o() != null) {
            GraphQLApplication graphQLApplication = (GraphQLApplication) graphQLModelMutatingVisitor.mo2928b(m24458o());
            if (m24458o() != graphQLApplication) {
                graphQLVisitableModel = (GraphQLMedia) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17375i = graphQLApplication;
            }
        }
        if (m24425D() != null) {
            graphQLStory = (GraphQLStory) graphQLModelMutatingVisitor.mo2928b(m24425D());
            if (m24425D() != graphQLStory) {
                graphQLVisitableModel = (GraphQLMedia) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17390x = graphQLStory;
            }
        }
        if (m24427F() != null) {
            graphQLStory = (GraphQLStory) graphQLModelMutatingVisitor.mo2928b(m24427F());
            if (m24427F() != graphQLStory) {
                graphQLVisitableModel = (GraphQLMedia) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17392z = graphQLStory;
            }
        }
        if (m24428G() != null) {
            graphQLPlace = (GraphQLPlace) graphQLModelMutatingVisitor.mo2928b(m24428G());
            if (m24428G() != graphQLPlace) {
                graphQLVisitableModel = (GraphQLMedia) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17344A = graphQLPlace;
            }
        }
        if (m24429H() != null) {
            GraphQLPhotoFaceBoxesConnection graphQLPhotoFaceBoxesConnection = (GraphQLPhotoFaceBoxesConnection) graphQLModelMutatingVisitor.mo2928b(m24429H());
            if (m24429H() != graphQLPhotoFaceBoxesConnection) {
                graphQLVisitableModel = (GraphQLMedia) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17345B = graphQLPhotoFaceBoxesConnection;
            }
        }
        if (m24430I() != null) {
            GraphQLFeedback graphQLFeedback = (GraphQLFeedback) graphQLModelMutatingVisitor.mo2928b(m24430I());
            if (m24430I() != graphQLFeedback) {
                graphQLVisitableModel = (GraphQLMedia) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17346C = graphQLFeedback;
            }
        }
        if (m24431J() != null) {
            GraphQLVect2 graphQLVect2 = (GraphQLVect2) graphQLModelMutatingVisitor.mo2928b(m24431J());
            if (m24431J() != graphQLVect2) {
                graphQLVisitableModel = (GraphQLMedia) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17347D = graphQLVect2;
            }
        }
        if (m24432K() != null) {
            GraphQLVideoGuidedTour graphQLVideoGuidedTour = (GraphQLVideoGuidedTour) graphQLModelMutatingVisitor.mo2928b(m24432K());
            if (m24432K() != graphQLVideoGuidedTour) {
                graphQLVisitableModel = (GraphQLMedia) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17348E = graphQLVideoGuidedTour;
            }
        }
        if (m24440S() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(m24440S());
            if (m24440S() != graphQLImage) {
                graphQLVisitableModel = (GraphQLMedia) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17357N = graphQLImage;
            }
        }
        if (m24441T() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(m24441T());
            if (m24441T() != graphQLImage) {
                graphQLVisitableModel = (GraphQLMedia) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17358O = graphQLImage;
            }
        }
        if (m24442U() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(m24442U());
            if (m24442U() != graphQLImage) {
                graphQLVisitableModel = (GraphQLMedia) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17359P = graphQLImage;
            }
        }
        if (m24443V() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(m24443V());
            if (m24443V() != graphQLImage) {
                graphQLVisitableModel = (GraphQLMedia) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17360Q = graphQLImage;
            }
        }
        if (m24444W() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(m24444W());
            if (m24444W() != graphQLImage) {
                graphQLVisitableModel = (GraphQLMedia) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17361R = graphQLImage;
            }
        }
        if (m24445X() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(m24445X());
            if (m24445X() != graphQLImage) {
                graphQLVisitableModel = (GraphQLMedia) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17362S = graphQLImage;
            }
        }
        if (m24446Y() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(m24446Y());
            if (m24446Y() != graphQLImage) {
                graphQLVisitableModel = (GraphQLMedia) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17363T = graphQLImage;
            }
        }
        if (m24447Z() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(m24447Z());
            if (m24447Z() != graphQLImage) {
                graphQLVisitableModel = (GraphQLMedia) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17364U = graphQLImage;
            }
        }
        if (bq() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(bq());
            if (bq() != graphQLImage) {
                graphQLVisitableModel = (GraphQLMedia) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.bl = graphQLImage;
            }
        }
        if (aa() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(aa());
            if (aa() != graphQLImage) {
                graphQLVisitableModel = (GraphQLMedia) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17365V = graphQLImage;
            }
        }
        if (ab() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(ab());
            if (ab() != graphQLImage) {
                graphQLVisitableModel = (GraphQLMedia) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17366W = graphQLImage;
            }
        }
        if (ac() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(ac());
            if (ac() != graphQLImage) {
                graphQLVisitableModel = (GraphQLMedia) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17367X = graphQLImage;
            }
        }
        if (ad() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(ad());
            if (ad() != graphQLImage) {
                graphQLVisitableModel = (GraphQLMedia) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17368Y = graphQLImage;
            }
        }
        if (ae() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(ae());
            if (ae() != graphQLImage) {
                graphQLVisitableModel = (GraphQLMedia) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17369Z = graphQLImage;
            }
        }
        if (bt() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(bt());
            if (bt() != graphQLImage) {
                graphQLVisitableModel = (GraphQLMedia) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.bo = graphQLImage;
            }
        }
        if (ai() != null) {
            GraphQLInlineActivitiesConnection graphQLInlineActivitiesConnection = (GraphQLInlineActivitiesConnection) graphQLModelMutatingVisitor.mo2928b(ai());
            if (ai() != graphQLInlineActivitiesConnection) {
                graphQLVisitableModel = (GraphQLMedia) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.ad = graphQLInlineActivitiesConnection;
            }
        }
        if (as() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(as());
            if (as() != graphQLImage) {
                graphQLVisitableModel = (GraphQLMedia) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.an = graphQLImage;
            }
        }
        if (at() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(at());
            if (at() != graphQLImage) {
                graphQLVisitableModel = (GraphQLMedia) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.ao = graphQLImage;
            }
        }
        if (au() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(au());
            if (au() != graphQLImage) {
                graphQLVisitableModel = (GraphQLMedia) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.ap = graphQLImage;
            }
        }
        if (aw() != null) {
            GraphQLPlaceSuggestionInfo graphQLPlaceSuggestionInfo = (GraphQLPlaceSuggestionInfo) graphQLModelMutatingVisitor.mo2928b(aw());
            if (aw() != graphQLPlaceSuggestionInfo) {
                graphQLVisitableModel = (GraphQLMedia) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.ar = graphQLPlaceSuggestionInfo;
            }
        }
        if (ay() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(ay());
            if (ay() != graphQLImage) {
                graphQLVisitableModel = (GraphQLMedia) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.at = graphQLImage;
            }
        }
        if (az() != null) {
            graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.mo2928b(az());
            if (az() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLMedia) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.au = graphQLTextWithEntities;
            }
        }
        if (aB() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(aB());
            if (aB() != graphQLImage) {
                graphQLVisitableModel = (GraphQLMedia) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.aw = graphQLImage;
            }
        }
        if (aD() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(aD());
            if (aD() != graphQLImage) {
                graphQLVisitableModel = (GraphQLMedia) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.ay = graphQLImage;
            }
        }
        if (aE() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(aE());
            if (aE() != graphQLImage) {
                graphQLVisitableModel = (GraphQLMedia) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.az = graphQLImage;
            }
        }
        if (aF() != null) {
            GraphQLActor graphQLActor = (GraphQLActor) graphQLModelMutatingVisitor.mo2928b(aF());
            if (aF() != graphQLActor) {
                graphQLVisitableModel = (GraphQLMedia) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.aA = graphQLActor;
            }
        }
        if (aG() != null) {
            GraphQLVideo graphQLVideo = (GraphQLVideo) graphQLModelMutatingVisitor.mo2928b(aG());
            if (aG() != graphQLVideo) {
                graphQLVisitableModel = (GraphQLMedia) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.aB = graphQLVideo;
            }
        }
        if (aH() != null) {
            graphQLPlace = (GraphQLPlace) graphQLModelMutatingVisitor.mo2928b(aH());
            if (aH() != graphQLPlace) {
                graphQLVisitableModel = (GraphQLMedia) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.aC = graphQLPlace;
            }
        }
        if (aI() != null) {
            Builder a = ModelHelper.m23097a(aI(), graphQLModelMutatingVisitor);
            if (a != null) {
                GraphQLMedia graphQLMedia = (GraphQLMedia) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLMedia.aD = a.m1068b();
                graphQLVisitableModel = graphQLMedia;
            }
        }
        if (aQ() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(aQ());
            if (aQ() != graphQLImage) {
                graphQLVisitableModel = (GraphQLMedia) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.aL = graphQLImage;
            }
        }
        if (aS() != null) {
            GraphQLPrivacyScope graphQLPrivacyScope = (GraphQLPrivacyScope) graphQLModelMutatingVisitor.mo2928b(aS());
            if (aS() != graphQLPrivacyScope) {
                graphQLVisitableModel = (GraphQLMedia) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.aN = graphQLPrivacyScope;
            }
        }
        if (aT() != null) {
            GraphQLImageOverlay graphQLImageOverlay = (GraphQLImageOverlay) graphQLModelMutatingVisitor.mo2928b(aT());
            if (aT() != graphQLImageOverlay) {
                graphQLVisitableModel = (GraphQLMedia) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.aO = graphQLImageOverlay;
            }
        }
        if (aV() != null) {
            graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.mo2928b(aV());
            if (aV() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLMedia) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.aQ = graphQLTextWithEntities;
            }
        }
        if (aW() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(aW());
            if (aW() != graphQLImage) {
                graphQLVisitableModel = (GraphQLMedia) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.aR = graphQLImage;
            }
        }
        if (bw() != null) {
            GraphQLPage graphQLPage = (GraphQLPage) graphQLModelMutatingVisitor.mo2928b(bw());
            if (bw() != graphQLPage) {
                graphQLVisitableModel = (GraphQLMedia) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.br = graphQLPage;
            }
        }
        if (bh() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(bh());
            if (bh() != graphQLImage) {
                graphQLVisitableModel = (GraphQLMedia) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.bc = graphQLImage;
            }
        }
        if (bi() != null) {
            graphQLStreamingImage = (GraphQLStreamingImage) graphQLModelMutatingVisitor.mo2928b(bi());
            if (bi() != graphQLStreamingImage) {
                graphQLVisitableModel = (GraphQLMedia) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.bd = graphQLStreamingImage;
            }
        }
        if (bj() != null) {
            graphQLStreamingImage = (GraphQLStreamingImage) graphQLModelMutatingVisitor.mo2928b(bj());
            if (bj() != graphQLStreamingImage) {
                graphQLVisitableModel = (GraphQLMedia) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.be = graphQLStreamingImage;
            }
        }
        if (bk() != null) {
            GraphQLPhotoTagsConnection graphQLPhotoTagsConnection = (GraphQLPhotoTagsConnection) graphQLModelMutatingVisitor.mo2928b(bk());
            if (bk() != graphQLPhotoTagsConnection) {
                graphQLVisitableModel = (GraphQLMedia) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.bf = graphQLPhotoTagsConnection;
            }
        }
        if (bm() != null) {
            GraphQLVideoChannel graphQLVideoChannel = (GraphQLVideoChannel) graphQLModelMutatingVisitor.mo2928b(bm());
            if (bm() != graphQLVideoChannel) {
                graphQLVisitableModel = (GraphQLMedia) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.bh = graphQLVideoChannel;
            }
        }
        if (bp() != null) {
            GraphQLWithTagsConnection graphQLWithTagsConnection = (GraphQLWithTagsConnection) graphQLModelMutatingVisitor.mo2928b(bp());
            if (bp() != graphQLWithTagsConnection) {
                graphQLVisitableModel = (GraphQLMedia) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.bk = graphQLWithTagsConnection;
            }
        }
        m9959i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLMedia() {
        super(HTTPTransportCallback.BODY_BYTES_RECEIVED);
    }

    public final void mo1406a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.mo1406a(mutableFlatBuffer, i, obj);
        this.f17374h = mutableFlatBuffer.m21524a(i, 4, 0);
        this.f17377k = mutableFlatBuffer.m21525a(i, 8, 0);
        this.f17378l = mutableFlatBuffer.m21524a(i, 9, 0);
        this.f17379m = mutableFlatBuffer.m21540a(i, 10);
        this.f17380n = mutableFlatBuffer.m21540a(i, 11);
        this.f17381o = mutableFlatBuffer.m21540a(i, 12);
        this.f17382p = mutableFlatBuffer.m21540a(i, 13);
        this.f17383q = mutableFlatBuffer.m21540a(i, 14);
        this.f17384r = mutableFlatBuffer.m21540a(i, 15);
        this.f17385s = mutableFlatBuffer.m21540a(i, 16);
        this.f17386t = mutableFlatBuffer.m21540a(i, 17);
        this.f17387u = mutableFlatBuffer.m21540a(i, 18);
        this.f17388v = mutableFlatBuffer.m21540a(i, 19);
        this.f17391y = mutableFlatBuffer.m21525a(i, 22, 0);
        this.f17349F = mutableFlatBuffer.m21540a(i, 29);
        this.f17350G = mutableFlatBuffer.m21540a(i, 30);
        this.f17351H = mutableFlatBuffer.m21540a(i, 31);
        this.f17352I = mutableFlatBuffer.m21524a(i, 32, 0);
        this.f17353J = mutableFlatBuffer.m21524a(i, 33, 0);
        this.f17355L = mutableFlatBuffer.m21524a(i, 35, 0);
        this.aa = mutableFlatBuffer.m21524a(i, 50, 0);
        this.ab = mutableFlatBuffer.m21524a(i, 51, 0);
        this.ac = mutableFlatBuffer.m21524a(i, 52, 0);
        this.ae = mutableFlatBuffer.m21540a(i, 54);
        this.af = mutableFlatBuffer.m21540a(i, 55);
        this.ag = mutableFlatBuffer.m21540a(i, 56);
        this.ah = mutableFlatBuffer.m21540a(i, 57);
        this.ai = mutableFlatBuffer.m21540a(i, 58);
        this.aj = mutableFlatBuffer.m21540a(i, 59);
        this.ak = mutableFlatBuffer.m21540a(i, 60);
        this.al = mutableFlatBuffer.m21540a(i, 61);
        this.am = mutableFlatBuffer.m21540a(i, 62);
        this.aq = mutableFlatBuffer.m21524a(i, 66, 0);
        this.as = mutableFlatBuffer.m21524a(i, 68, 0);
        this.aE = mutableFlatBuffer.m21524a(i, 80, 0);
        this.aH = mutableFlatBuffer.m21524a(i, 83, 0);
        this.aI = mutableFlatBuffer.m21524a(i, 84, 0);
        this.aS = mutableFlatBuffer.m21540a(i, 94);
        this.aT = mutableFlatBuffer.m21540a(i, 95);
        this.aU = mutableFlatBuffer.m21540a(i, 96);
        this.aV = mutableFlatBuffer.m21540a(i, 97);
        this.aW = mutableFlatBuffer.m21540a(i, 98);
        this.aX = mutableFlatBuffer.m21523a(i, 99, 0.0d);
        this.aY = mutableFlatBuffer.m21523a(i, 100, 0.0d);
        this.bb = mutableFlatBuffer.m21524a(i, 103, 0);
        this.bi = mutableFlatBuffer.m21524a(i, 110, 0);
        this.bj = mutableFlatBuffer.m21524a(i, 111, 0);
        this.bn = mutableFlatBuffer.m21540a(i, 115);
        this.bq = mutableFlatBuffer.m21540a(i, 118);
        this.bs = mutableFlatBuffer.m21540a(i, 123);
        this.bt = mutableFlatBuffer.m21540a(i, 124);
        this.bu = mutableFlatBuffer.m21524a(i, 125, 0);
        this.bv = mutableFlatBuffer.m21524a(i, 126, 0);
    }

    public final int mo1403a(FlatBufferBuilder flatBufferBuilder) {
        m9958h();
        int a = flatBufferBuilder.m21479a(m24453j() != null ? m24453j().m22299e() : null);
        int b = flatBufferBuilder.m21502b(m24454k());
        int a2 = ModelHelper.m23093a(flatBufferBuilder, m24455l());
        int a3 = ModelHelper.m23093a(flatBufferBuilder, m24456m());
        int a4 = ModelHelper.m23093a(flatBufferBuilder, m24458o());
        int b2 = flatBufferBuilder.m21502b(m24459p());
        int b3 = flatBufferBuilder.m21502b(m24424C());
        int a5 = ModelHelper.m23093a(flatBufferBuilder, m24425D());
        int a6 = ModelHelper.m23093a(flatBufferBuilder, m24427F());
        int a7 = ModelHelper.m23093a(flatBufferBuilder, m24428G());
        int a8 = ModelHelper.m23093a(flatBufferBuilder, m24429H());
        int a9 = ModelHelper.m23093a(flatBufferBuilder, m24430I());
        int a10 = ModelHelper.m23093a(flatBufferBuilder, m24431J());
        int a11 = ModelHelper.m23093a(flatBufferBuilder, m24432K());
        int b4 = flatBufferBuilder.m21502b(m24438Q());
        int b5 = flatBufferBuilder.m21502b(m24452b());
        int a12 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) m24440S());
        int a13 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) m24441T());
        int a14 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) m24442U());
        int a15 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) m24443V());
        int a16 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) m24444W());
        int a17 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) m24445X());
        int a18 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) m24446Y());
        int a19 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) m24447Z());
        int a20 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) aa());
        int a21 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) ab());
        int a22 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) ac());
        int a23 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) ad());
        int a24 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) ae());
        int a25 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) ai());
        int a26 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) as());
        int a27 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) at());
        int a28 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) au());
        int a29 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) aw());
        int a30 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) ay());
        int a31 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) az());
        int b6 = flatBufferBuilder.m21502b(aA());
        int a32 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) aB());
        int b7 = flatBufferBuilder.m21502b(aC());
        int a33 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) aD());
        int a34 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) aE());
        int a35 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) aF());
        int a36 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) aG());
        int a37 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) aH());
        int a38 = ModelHelper.m23094a(flatBufferBuilder, (List) aI());
        int b8 = flatBufferBuilder.m21502b(aK());
        int b9 = flatBufferBuilder.m21502b(aL());
        int b10 = flatBufferBuilder.m21502b(aO());
        int b11 = flatBufferBuilder.m21502b(aP());
        int a39 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) aQ());
        int b12 = flatBufferBuilder.m21502b(aR());
        int a40 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) aS());
        int a41 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) aT());
        int b13 = flatBufferBuilder.m21502b(aU());
        int a42 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) aV());
        int a43 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) aW());
        int b14 = flatBufferBuilder.m21502b(be());
        int b15 = flatBufferBuilder.m21502b(bf());
        int a44 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) bh());
        int a45 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) bi());
        int a46 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) bj());
        int a47 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) bk());
        int c = flatBufferBuilder.m21509c((List) bl());
        int a48 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) bm());
        int a49 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) bp());
        int a50 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) bq());
        int a51 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) bt());
        int a52 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) bw());
        flatBufferBuilder.m21510c(127);
        flatBufferBuilder.m21507b(0, a);
        flatBufferBuilder.m21507b(1, b);
        flatBufferBuilder.m21507b(2, a2);
        flatBufferBuilder.m21507b(3, a3);
        flatBufferBuilder.m21494a(4, m24457n(), 0);
        flatBufferBuilder.m21507b(6, a4);
        flatBufferBuilder.m21507b(7, b2);
        flatBufferBuilder.m21495a(8, m24460q(), 0);
        flatBufferBuilder.m21494a(9, m24461r(), 0);
        flatBufferBuilder.m21498a(10, m24462s());
        flatBufferBuilder.m21498a(11, m24463t());
        flatBufferBuilder.m21498a(12, m24464u());
        flatBufferBuilder.m21498a(13, m24465v());
        flatBufferBuilder.m21498a(14, m24466w());
        flatBufferBuilder.m21498a(15, m24467x());
        flatBufferBuilder.m21498a(16, m24468y());
        flatBufferBuilder.m21498a(17, m24469z());
        flatBufferBuilder.m21498a(18, m24422A());
        flatBufferBuilder.m21498a(19, m24423B());
        flatBufferBuilder.m21507b(20, b3);
        flatBufferBuilder.m21507b(21, a5);
        flatBufferBuilder.m21495a(22, m24426E(), 0);
        flatBufferBuilder.m21507b(23, a6);
        flatBufferBuilder.m21507b(24, a7);
        flatBufferBuilder.m21507b(25, a8);
        flatBufferBuilder.m21507b(26, a9);
        flatBufferBuilder.m21507b(27, a10);
        flatBufferBuilder.m21507b(28, a11);
        flatBufferBuilder.m21498a(29, m24433L());
        flatBufferBuilder.m21498a(30, m24434M());
        flatBufferBuilder.m21498a(31, m24435N());
        flatBufferBuilder.m21494a(32, m24436O(), 0);
        flatBufferBuilder.m21494a(33, m24437P(), 0);
        flatBufferBuilder.m21507b(34, b4);
        flatBufferBuilder.m21494a(35, m24439R(), 0);
        flatBufferBuilder.m21507b(36, b5);
        flatBufferBuilder.m21507b(37, a12);
        flatBufferBuilder.m21507b(38, a13);
        flatBufferBuilder.m21507b(39, a14);
        flatBufferBuilder.m21507b(40, a15);
        flatBufferBuilder.m21507b(41, a16);
        flatBufferBuilder.m21507b(42, a17);
        flatBufferBuilder.m21507b(43, a18);
        flatBufferBuilder.m21507b(44, a19);
        flatBufferBuilder.m21507b(45, a20);
        flatBufferBuilder.m21507b(46, a21);
        flatBufferBuilder.m21507b(47, a22);
        flatBufferBuilder.m21507b(48, a23);
        flatBufferBuilder.m21507b(49, a24);
        flatBufferBuilder.m21494a(50, af(), 0);
        flatBufferBuilder.m21494a(51, ag(), 0);
        flatBufferBuilder.m21494a(52, ah(), 0);
        flatBufferBuilder.m21507b(53, a25);
        flatBufferBuilder.m21498a(54, aj());
        flatBufferBuilder.m21498a(55, ak());
        flatBufferBuilder.m21498a(56, al());
        flatBufferBuilder.m21498a(57, am());
        flatBufferBuilder.m21498a(58, an());
        flatBufferBuilder.m21498a(59, ao());
        flatBufferBuilder.m21498a(60, ap());
        flatBufferBuilder.m21498a(61, aq());
        flatBufferBuilder.m21498a(62, ar());
        flatBufferBuilder.m21507b(63, a26);
        flatBufferBuilder.m21507b(64, a27);
        flatBufferBuilder.m21507b(65, a28);
        flatBufferBuilder.m21494a(66, av(), 0);
        flatBufferBuilder.m21507b(67, a29);
        flatBufferBuilder.m21494a(68, ax(), 0);
        flatBufferBuilder.m21507b(69, a30);
        flatBufferBuilder.m21507b(70, a31);
        flatBufferBuilder.m21507b(71, b6);
        flatBufferBuilder.m21507b(72, a32);
        flatBufferBuilder.m21507b(73, b7);
        flatBufferBuilder.m21507b(74, a33);
        flatBufferBuilder.m21507b(75, a34);
        flatBufferBuilder.m21507b(76, a35);
        flatBufferBuilder.m21507b(77, a36);
        flatBufferBuilder.m21507b(78, a37);
        flatBufferBuilder.m21507b(79, a38);
        flatBufferBuilder.m21494a(80, aJ(), 0);
        flatBufferBuilder.m21507b(81, b8);
        flatBufferBuilder.m21507b(82, b9);
        flatBufferBuilder.m21494a(83, aM(), 0);
        flatBufferBuilder.m21494a(84, aN(), 0);
        flatBufferBuilder.m21507b(85, b10);
        flatBufferBuilder.m21507b(86, b11);
        flatBufferBuilder.m21507b(87, a39);
        flatBufferBuilder.m21507b(88, b12);
        flatBufferBuilder.m21507b(89, a40);
        flatBufferBuilder.m21507b(90, a41);
        flatBufferBuilder.m21507b(91, b13);
        flatBufferBuilder.m21507b(92, a42);
        flatBufferBuilder.m21507b(93, a43);
        flatBufferBuilder.m21498a(94, aX());
        flatBufferBuilder.m21498a(95, aY());
        flatBufferBuilder.m21498a(96, aZ());
        flatBufferBuilder.m21498a(97, ba());
        flatBufferBuilder.m21498a(98, bb());
        flatBufferBuilder.m21492a(99, bc(), 0.0d);
        flatBufferBuilder.m21492a(100, bd(), 0.0d);
        flatBufferBuilder.m21507b(101, b14);
        flatBufferBuilder.m21507b(102, b15);
        flatBufferBuilder.m21494a(103, bg(), 0);
        flatBufferBuilder.m21507b(104, a44);
        flatBufferBuilder.m21507b(105, a45);
        flatBufferBuilder.m21507b(106, a46);
        flatBufferBuilder.m21507b(107, a47);
        flatBufferBuilder.m21507b(108, c);
        flatBufferBuilder.m21507b(109, a48);
        flatBufferBuilder.m21494a(110, bn(), 0);
        flatBufferBuilder.m21494a(111, bo(), 0);
        flatBufferBuilder.m21507b(112, a49);
        flatBufferBuilder.m21507b(113, a50);
        flatBufferBuilder.m21496a(114, br() == GraphQLVideoBroadcastStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE ? null : br());
        flatBufferBuilder.m21498a(115, bs());
        flatBufferBuilder.m21507b(116, a51);
        flatBufferBuilder.m21496a(117, bu() == GraphQLVideoStatusType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE ? null : bu());
        flatBufferBuilder.m21498a(118, bv());
        flatBufferBuilder.m21507b(122, a52);
        flatBufferBuilder.m21498a(123, bx());
        flatBufferBuilder.m21498a(124, by());
        flatBufferBuilder.m21494a(125, bz(), 0);
        flatBufferBuilder.m21494a(126, bA(), 0);
        m9959i();
        return flatBufferBuilder.m21511d();
    }

    public GraphQLMedia(Parcel parcel) {
        boolean z;
        boolean z2 = true;
        super(HTTPTransportCallback.BODY_BYTES_RECEIVED);
        this.f17371e = parcel.readString();
        this.f17372f = (GraphQLAlbum) parcel.readValue(GraphQLAlbum.class.getClassLoader());
        this.f17373g = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f17374h = parcel.readInt();
        this.f17375i = (GraphQLApplication) parcel.readValue(GraphQLApplication.class.getClassLoader());
        this.f17376j = parcel.readString();
        this.f17377k = parcel.readLong();
        this.f17378l = parcel.readInt();
        this.bm = GraphQLVideoBroadcastStatus.fromString(parcel.readString());
        this.f17379m = parcel.readByte() == (byte) 1;
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.f17380n = z;
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.f17381o = z;
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.f17382p = z;
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.f17383q = z;
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.f17384r = z;
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.f17385s = z;
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.f17386t = z;
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.f17387u = z;
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.f17388v = z;
        this.f17389w = parcel.readString();
        this.f17390x = (GraphQLStory) parcel.readValue(GraphQLStory.class.getClassLoader());
        this.f17391y = parcel.readLong();
        this.f17392z = (GraphQLStory) parcel.readValue(GraphQLStory.class.getClassLoader());
        this.f17344A = (GraphQLPlace) parcel.readValue(GraphQLPlace.class.getClassLoader());
        this.f17345B = (GraphQLPhotoFaceBoxesConnection) parcel.readValue(GraphQLPhotoFaceBoxesConnection.class.getClassLoader());
        this.f17346C = (GraphQLFeedback) parcel.readValue(GraphQLFeedback.class.getClassLoader());
        this.f17347D = (GraphQLVect2) parcel.readValue(GraphQLVect2.class.getClassLoader());
        this.f17348E = (GraphQLVideoGuidedTour) parcel.readValue(GraphQLVideoGuidedTour.class.getClassLoader());
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.f17349F = z;
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.f17350G = z;
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.f17351H = z;
        this.f17352I = parcel.readInt();
        this.f17353J = parcel.readInt();
        this.f17354K = parcel.readString();
        this.f17355L = parcel.readInt();
        this.f17356M = parcel.readString();
        this.f17357N = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f17358O = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f17359P = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f17360Q = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f17361R = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f17362S = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f17363T = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f17364U = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.bl = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f17365V = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f17366W = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f17367X = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f17368Y = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f17369Z = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.bo = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.aa = parcel.readInt();
        this.ab = parcel.readInt();
        this.ac = parcel.readInt();
        this.ad = (GraphQLInlineActivitiesConnection) parcel.readValue(GraphQLInlineActivitiesConnection.class.getClassLoader());
        this.ae = parcel.readByte() == (byte) 1;
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.bs = z;
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.af = z;
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.bt = z;
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.ag = z;
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.ah = z;
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.ai = z;
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.aj = z;
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.ak = z;
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.al = z;
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.am = z;
        this.an = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.ao = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.ap = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.aq = parcel.readInt();
        this.ar = (GraphQLPlaceSuggestionInfo) parcel.readValue(GraphQLPlaceSuggestionInfo.class.getClassLoader());
        this.as = parcel.readInt();
        this.at = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.au = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.av = parcel.readString();
        this.aw = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.ax = parcel.readString();
        this.ay = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.az = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.aA = (GraphQLActor) parcel.readValue(GraphQLActor.class.getClassLoader());
        this.aB = (GraphQLVideo) parcel.readValue(GraphQLVideo.class.getClassLoader());
        this.aC = (GraphQLPlace) parcel.readValue(GraphQLPlace.class.getClassLoader());
        this.aD = ImmutableListHelper.m21625a(parcel.readArrayList(GraphQLPhotoEncoding.class.getClassLoader()));
        this.aE = parcel.readInt();
        this.aF = parcel.readString();
        this.aG = parcel.readString();
        this.aH = parcel.readInt();
        this.aI = parcel.readInt();
        this.aJ = parcel.readString();
        this.aK = parcel.readString();
        this.aL = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.bu = parcel.readInt();
        this.aM = parcel.readString();
        this.aN = (GraphQLPrivacyScope) parcel.readValue(GraphQLPrivacyScope.class.getClassLoader());
        this.aO = (GraphQLImageOverlay) parcel.readValue(GraphQLImageOverlay.class.getClassLoader());
        this.aP = parcel.readString();
        this.aQ = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.aR = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.aS = parcel.readByte() == (byte) 1;
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.aT = z;
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.aU = z;
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.aV = z;
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.bn = z;
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.aW = z;
        this.aX = parcel.readDouble();
        this.aY = parcel.readDouble();
        this.aZ = parcel.readString();
        this.ba = parcel.readString();
        this.bb = parcel.readInt();
        this.br = (GraphQLPage) parcel.readValue(GraphQLPage.class.getClassLoader());
        this.bc = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.bd = (GraphQLStreamingImage) parcel.readValue(GraphQLStreamingImage.class.getClassLoader());
        this.be = (GraphQLStreamingImage) parcel.readValue(GraphQLStreamingImage.class.getClassLoader());
        if (parcel.readByte() != (byte) 1) {
            z2 = false;
        }
        this.bq = z2;
        this.bf = (GraphQLPhotoTagsConnection) parcel.readValue(GraphQLPhotoTagsConnection.class.getClassLoader());
        this.bv = parcel.readInt();
        this.bg = ImmutableListHelper.m21625a(parcel.readArrayList(String.class.getClassLoader()));
        this.bh = (GraphQLVideoChannel) parcel.readValue(GraphQLVideoChannel.class.getClassLoader());
        this.bi = parcel.readInt();
        this.bp = GraphQLVideoStatusType.fromString(parcel.readString());
        this.bj = parcel.readInt();
        this.bk = (GraphQLWithTagsConnection) parcel.readValue(GraphQLWithTagsConnection.class.getClassLoader());
        this.f17370d = (GraphQLObjectType) ParcelUtil.b(parcel, GraphQLObjectType.class);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int i2;
        int i3 = 1;
        parcel.writeString(m24454k());
        parcel.writeValue(m24455l());
        parcel.writeValue(m24456m());
        parcel.writeInt(m24457n());
        parcel.writeValue(m24458o());
        parcel.writeString(m24459p());
        parcel.writeLong(m24460q());
        parcel.writeInt(m24461r());
        parcel.writeString(br().name());
        parcel.writeByte((byte) (m24462s() ? 1 : 0));
        if (m24463t()) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        if (m24464u()) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        if (m24465v()) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        if (m24466w()) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        if (m24467x()) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        if (m24468y()) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        if (m24469z()) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        if (m24422A()) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        if (m24423B()) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        parcel.writeString(m24424C());
        parcel.writeValue(m24425D());
        parcel.writeLong(m24426E());
        parcel.writeValue(m24427F());
        parcel.writeValue(m24428G());
        parcel.writeValue(m24429H());
        parcel.writeValue(m24430I());
        parcel.writeValue(m24431J());
        parcel.writeValue(m24432K());
        if (m24433L()) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        if (m24434M()) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        if (m24435N()) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        parcel.writeInt(m24436O());
        parcel.writeInt(m24437P());
        parcel.writeString(m24438Q());
        parcel.writeInt(m24439R());
        parcel.writeString(m24452b());
        parcel.writeValue(m24440S());
        parcel.writeValue(m24441T());
        parcel.writeValue(m24442U());
        parcel.writeValue(m24443V());
        parcel.writeValue(m24444W());
        parcel.writeValue(m24445X());
        parcel.writeValue(m24446Y());
        parcel.writeValue(m24447Z());
        parcel.writeValue(bq());
        parcel.writeValue(aa());
        parcel.writeValue(ab());
        parcel.writeValue(ac());
        parcel.writeValue(ad());
        parcel.writeValue(ae());
        parcel.writeValue(bt());
        parcel.writeInt(af());
        parcel.writeInt(ag());
        parcel.writeInt(ah());
        parcel.writeValue(ai());
        parcel.writeByte((byte) (aj() ? 1 : 0));
        if (bx()) {
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
        if (by()) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        if (al()) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        if (am()) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        if (an()) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        if (ao()) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        if (ap()) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        if (aq()) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        if (ar()) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        parcel.writeValue(as());
        parcel.writeValue(at());
        parcel.writeValue(au());
        parcel.writeInt(av());
        parcel.writeValue(aw());
        parcel.writeInt(ax());
        parcel.writeValue(ay());
        parcel.writeValue(az());
        parcel.writeString(aA());
        parcel.writeValue(aB());
        parcel.writeString(aC());
        parcel.writeValue(aD());
        parcel.writeValue(aE());
        parcel.writeValue(aF());
        parcel.writeValue(aG());
        parcel.writeValue(aH());
        parcel.writeList(aI());
        parcel.writeInt(aJ());
        parcel.writeString(aK());
        parcel.writeString(aL());
        parcel.writeInt(aM());
        parcel.writeInt(aN());
        parcel.writeString(aO());
        parcel.writeString(aP());
        parcel.writeValue(aQ());
        parcel.writeInt(bz());
        parcel.writeString(aR());
        parcel.writeValue(aS());
        parcel.writeValue(aT());
        parcel.writeString(aU());
        parcel.writeValue(aV());
        parcel.writeValue(aW());
        parcel.writeByte((byte) (aX() ? 1 : 0));
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
        if (ba()) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        if (bs()) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        if (bb()) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        parcel.writeDouble(bc());
        parcel.writeDouble(bd());
        parcel.writeString(be());
        parcel.writeString(bf());
        parcel.writeInt(bg());
        parcel.writeValue(bw());
        parcel.writeValue(bh());
        parcel.writeValue(bi());
        parcel.writeValue(bj());
        if (!bv()) {
            i3 = 0;
        }
        parcel.writeByte((byte) i3);
        parcel.writeValue(bk());
        parcel.writeInt(bA());
        parcel.writeList(bl());
        parcel.writeValue(bm());
        parcel.writeInt(bn());
        parcel.writeString(bu().name());
        parcel.writeInt(bo());
        parcel.writeValue(bp());
        parcel.writeParcelable(this.f17370d, i);
    }

    public GraphQLMedia(Builder builder) {
        super(HTTPTransportCallback.BODY_BYTES_RECEIVED);
        this.b = builder.f15736a;
        this.c = builder.f15737b;
        this.f17371e = builder.d;
        this.f17372f = builder.e;
        this.f17373g = builder.f;
        this.f17374h = builder.g;
        this.f17375i = builder.h;
        this.f17376j = builder.i;
        this.f17377k = builder.j;
        this.f17378l = builder.k;
        this.bm = builder.l;
        this.f17379m = builder.m;
        this.f17380n = builder.n;
        this.f17381o = builder.o;
        this.f17382p = builder.p;
        this.f17383q = builder.q;
        this.f17384r = builder.r;
        this.f17385s = builder.s;
        this.f17386t = builder.t;
        this.f17387u = builder.u;
        this.f17388v = builder.v;
        this.f17389w = builder.w;
        this.f17390x = builder.x;
        this.f17391y = builder.y;
        this.f17392z = builder.z;
        this.f17344A = builder.A;
        this.f17345B = builder.B;
        this.f17346C = builder.C;
        this.f17347D = builder.D;
        this.f17348E = builder.E;
        this.f17349F = builder.F;
        this.f17350G = builder.G;
        this.f17351H = builder.H;
        this.f17352I = builder.I;
        this.f17353J = builder.J;
        this.f17354K = builder.K;
        this.f17355L = builder.L;
        this.f17356M = builder.M;
        this.f17357N = builder.N;
        this.f17358O = builder.O;
        this.f17359P = builder.P;
        this.f17360Q = builder.Q;
        this.f17361R = builder.R;
        this.f17362S = builder.S;
        this.f17363T = builder.T;
        this.f17364U = builder.U;
        this.bl = builder.V;
        this.f17365V = builder.W;
        this.f17366W = builder.X;
        this.f17367X = builder.Y;
        this.f17368Y = builder.Z;
        this.f17369Z = builder.aa;
        this.bo = builder.ab;
        this.aa = builder.ac;
        this.ab = builder.ad;
        this.ac = builder.ae;
        this.ad = builder.af;
        this.ae = builder.ag;
        this.bs = builder.ah;
        this.af = builder.ai;
        this.bt = builder.aj;
        this.ag = builder.ak;
        this.ah = builder.al;
        this.ai = builder.am;
        this.aj = builder.an;
        this.ak = builder.ao;
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
        this.aB = builder.aF;
        this.aC = builder.aG;
        this.aD = builder.aH;
        this.aE = builder.aI;
        this.aF = builder.aJ;
        this.aG = builder.aK;
        this.aH = builder.aL;
        this.aI = builder.aM;
        this.aJ = builder.aN;
        this.aK = builder.aO;
        this.aL = builder.aP;
        this.bu = builder.aQ;
        this.aM = builder.aR;
        this.aN = builder.aS;
        this.aO = builder.aT;
        this.aP = builder.aU;
        this.aQ = builder.aV;
        this.aR = builder.aW;
        this.aS = builder.aX;
        this.aT = builder.aY;
        this.aU = builder.aZ;
        this.aV = builder.ba;
        this.bn = builder.bb;
        this.aW = builder.bc;
        this.aX = builder.bd;
        this.aY = builder.be;
        this.aZ = builder.bf;
        this.ba = builder.bg;
        this.bb = builder.bh;
        this.br = builder.bi;
        this.bc = builder.bj;
        this.bd = builder.bk;
        this.be = builder.bl;
        this.bq = builder.bm;
        this.bf = builder.bn;
        this.bv = builder.bo;
        this.bg = builder.bp;
        this.bh = builder.bq;
        this.bi = builder.br;
        this.bp = builder.bs;
        this.bj = builder.bt;
        this.bk = builder.bu;
        this.f17370d = builder.bv;
    }
}
