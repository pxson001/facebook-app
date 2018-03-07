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
import com.facebook.graphql.visitor.GraphQLPersistableNode;
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
/* compiled from: live_video_log_watch_time */
public final class GraphQLPhoto extends BaseModel implements TypeModel, GraphQLPersistableNode, GraphQLVisitableModel {
    public static final Creator<GraphQLPhoto> CREATOR = new C08081();
    @Nullable
    GraphQLVect2 f17262A;
    boolean f17263B;
    int f17264C;
    int f17265D;
    @Nullable
    String f17266E;
    @Nullable
    GraphQLImage f17267F;
    @Nullable
    GraphQLImage f17268G;
    @Nullable
    GraphQLImage f17269H;
    @Nullable
    GraphQLImage f17270I;
    @Nullable
    GraphQLImage f17271J;
    @Nullable
    GraphQLImage f17272K;
    @Nullable
    GraphQLImage f17273L;
    @Nullable
    GraphQLImage f17274M;
    @Nullable
    GraphQLImage f17275N;
    @Nullable
    GraphQLImage f17276O;
    @Nullable
    GraphQLImage f17277P;
    @Nullable
    GraphQLImage f17278Q;
    @Nullable
    GraphQLImage f17279R;
    @Nullable
    GraphQLImage f17280S;
    @Nullable
    GraphQLImage f17281T;
    @Nullable
    GraphQLImage f17282U;
    @Nullable
    GraphQLImage f17283V;
    @Nullable
    GraphQLImage f17284W;
    @Nullable
    GraphQLImage f17285X;
    @Nullable
    GraphQLImage f17286Y;
    @Nullable
    GraphQLImage f17287Z;
    @Nullable
    String aA;
    int aB;
    int aC;
    @Nullable
    String aD;
    @Nullable
    GraphQLImage aE;
    @Nullable
    String aF;
    @Nullable
    String aG;
    @Nullable
    GraphQLPrivacyScope aH;
    @Nullable
    GraphQLImage aI;
    @Nullable
    GraphQLImage aJ;
    @Nullable
    GraphQLImage aK;
    @Deprecated
    @Nullable
    GraphQLImageOverlay aL;
    @Nullable
    GraphQLImage aM;
    boolean aN;
    boolean aO;
    @Nullable
    GraphQLImage aP;
    @Nullable
    GraphQLPhotoTagsConnection aQ;
    @Nullable
    String aR;
    @Nullable
    GraphQLWithTagsConnection aS;
    @Nullable
    GraphQLImage aT;
    @Nullable
    GraphQLImage aU;
    boolean aV;
    int aW;
    @Nullable
    String aX;
    @Nullable
    GraphQLOpenGraphAction aY;
    @Nullable
    GraphQLPlace aa;
    @Nullable
    GraphQLInlineActivitiesConnection ab;
    @Nullable
    GraphQLImage ac;
    boolean ad;
    boolean ae;
    boolean af;
    boolean ag;
    @Nullable
    GraphQLImage ah;
    @Nullable
    GraphQLImage ai;
    @Nullable
    GraphQLImage aj;
    @Nullable
    GraphQLImage ak;
    @Nullable
    GraphQLPlaceSuggestionInfo al;
    @Nullable
    GraphQLImage am;
    @Nullable
    GraphQLImage an;
    @Nullable
    GraphQLTextWithEntities ao;
    long ap;
    @Nullable
    String aq;
    @Nullable
    GraphQLImage ar;
    @Nullable
    String as;
    @Nullable
    GraphQLImage at;
    @Nullable
    GraphQLImage au;
    @Nullable
    GraphQLActor av;
    @Nullable
    GraphQLVideo aw;
    @Nullable
    GraphQLPlace ax;
    List<GraphQLPhotoEncoding> ay;
    @Nullable
    String az;
    @Nullable
    String f17288d;
    @Deprecated
    @Nullable
    GraphQLAlbum f17289e;
    @Nullable
    GraphQLImage f17290f;
    @Nullable
    GraphQLImage f17291g;
    int f17292h;
    @Deprecated
    @Nullable
    GraphQLApplication f17293i;
    @Deprecated
    @Nullable
    String f17294j;
    int f17295k;
    boolean f17296l;
    boolean f17297m;
    boolean f17298n;
    boolean f17299o;
    boolean f17300p;
    boolean f17301q;
    boolean f17302r;
    boolean f17303s;
    boolean f17304t;
    @Nullable
    GraphQLStory f17305u;
    long f17306v;
    @Nullable
    GraphQLStory f17307w;
    @Nullable
    GraphQLPlace f17308x;
    @Nullable
    GraphQLPhotoFaceBoxesConnection f17309y;
    @Nullable
    GraphQLFeedback f17310z;

    /* compiled from: live_video_log_watch_time */
    final class C08081 implements Creator<GraphQLPhoto> {
        C08081() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLPhoto(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLPhoto[i];
        }
    }

    @FieldOffset
    @Nullable
    public final /* synthetic */ GraphQLImage m24354b() {
        return m24335L();
    }

    @FieldOffset
    @Nullable
    public final String m24355j() {
        this.f17288d = super.m9948a(this.f17288d, 0);
        return this.f17288d;
    }

    @FieldOffset
    @Nullable
    public final GraphQLAlbum m24356k() {
        this.f17289e = (GraphQLAlbum) super.m9947a(this.f17289e, 1, GraphQLAlbum.class);
        return this.f17289e;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m24357l() {
        this.f17290f = (GraphQLImage) super.m9947a(this.f17290f, 2, GraphQLImage.class);
        return this.f17290f;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m24358m() {
        this.f17291g = (GraphQLImage) super.m9947a(this.f17291g, 3, GraphQLImage.class);
        return this.f17291g;
    }

    @FieldOffset
    public final int m24359n() {
        m9949a(0, 4);
        return this.f17292h;
    }

    @FieldOffset
    @Nullable
    public final GraphQLApplication m24360o() {
        this.f17293i = (GraphQLApplication) super.m9947a(this.f17293i, 6, GraphQLApplication.class);
        return this.f17293i;
    }

    @FieldOffset
    @Nullable
    public final String m24361p() {
        this.f17294j = super.m9948a(this.f17294j, 7);
        return this.f17294j;
    }

    @FieldOffset
    public final int m24362q() {
        m9949a(1, 0);
        return this.f17295k;
    }

    @FieldOffset
    public final boolean m24363r() {
        m9949a(1, 1);
        return this.f17296l;
    }

    @FieldOffset
    public final boolean m24364s() {
        m9949a(1, 2);
        return this.f17297m;
    }

    @FieldOffset
    public final boolean m24365t() {
        m9949a(1, 3);
        return this.f17298n;
    }

    @FieldOffset
    public final boolean m24366u() {
        m9949a(1, 4);
        return this.f17299o;
    }

    @FieldOffset
    public final boolean m24367v() {
        m9949a(1, 5);
        return this.f17300p;
    }

    @FieldOffset
    public final boolean m24368w() {
        m9949a(1, 6);
        return this.f17301q;
    }

    @FieldOffset
    public final boolean m24369x() {
        m9949a(1, 7);
        return this.f17302r;
    }

    @FieldOffset
    public final boolean m24370y() {
        m9949a(2, 1);
        return this.f17303s;
    }

    @FieldOffset
    public final boolean m24371z() {
        m9949a(2, 2);
        return this.f17304t;
    }

    @FieldOffset
    @Nullable
    public final GraphQLStory m24324A() {
        this.f17305u = (GraphQLStory) super.m9947a(this.f17305u, 19, GraphQLStory.class);
        return this.f17305u;
    }

    @FieldOffset
    public final long m24325B() {
        m9949a(2, 4);
        return this.f17306v;
    }

    @FieldOffset
    @Nullable
    public final GraphQLStory m24326C() {
        this.f17307w = (GraphQLStory) super.m9947a(this.f17307w, 21, GraphQLStory.class);
        return this.f17307w;
    }

    @FieldOffset
    @Nullable
    public final GraphQLPlace m24327D() {
        this.f17308x = (GraphQLPlace) super.m9947a(this.f17308x, 22, GraphQLPlace.class);
        return this.f17308x;
    }

    @FieldOffset
    @Nullable
    public final GraphQLPhotoFaceBoxesConnection m24328E() {
        this.f17309y = (GraphQLPhotoFaceBoxesConnection) super.m9947a(this.f17309y, 23, GraphQLPhotoFaceBoxesConnection.class);
        return this.f17309y;
    }

    @FieldOffset
    @Nullable
    public final GraphQLFeedback m24329F() {
        this.f17310z = (GraphQLFeedback) super.m9947a(this.f17310z, 27, GraphQLFeedback.class);
        return this.f17310z;
    }

    @FieldOffset
    @Nullable
    public final GraphQLVect2 m24330G() {
        this.f17262A = (GraphQLVect2) super.m9947a(this.f17262A, 28, GraphQLVect2.class);
        return this.f17262A;
    }

    @FieldOffset
    public final boolean m24331H() {
        m9949a(3, 5);
        return this.f17263B;
    }

    @FieldOffset
    public final int m24332I() {
        m9949a(3, 6);
        return this.f17264C;
    }

    @FieldOffset
    public final int m24333J() {
        m9949a(3, 7);
        return this.f17265D;
    }

    @FieldOffset
    @Nullable
    public final String m24334K() {
        this.f17266E = super.m9948a(this.f17266E, 32);
        return this.f17266E;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m24335L() {
        this.f17267F = (GraphQLImage) super.m9947a(this.f17267F, 33, GraphQLImage.class);
        return this.f17267F;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m24336M() {
        this.f17268G = (GraphQLImage) super.m9947a(this.f17268G, 34, GraphQLImage.class);
        return this.f17268G;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m24337N() {
        this.f17269H = (GraphQLImage) super.m9947a(this.f17269H, 35, GraphQLImage.class);
        return this.f17269H;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m24338O() {
        this.f17270I = (GraphQLImage) super.m9947a(this.f17270I, 36, GraphQLImage.class);
        return this.f17270I;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m24339P() {
        this.f17271J = (GraphQLImage) super.m9947a(this.f17271J, 37, GraphQLImage.class);
        return this.f17271J;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m24340Q() {
        this.f17272K = (GraphQLImage) super.m9947a(this.f17272K, 38, GraphQLImage.class);
        return this.f17272K;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m24341R() {
        this.f17273L = (GraphQLImage) super.m9947a(this.f17273L, 39, GraphQLImage.class);
        return this.f17273L;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m24342S() {
        this.f17274M = (GraphQLImage) super.m9947a(this.f17274M, 40, GraphQLImage.class);
        return this.f17274M;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m24343T() {
        this.f17275N = (GraphQLImage) super.m9947a(this.f17275N, 41, GraphQLImage.class);
        return this.f17275N;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m24344U() {
        this.f17276O = (GraphQLImage) super.m9947a(this.f17276O, 42, GraphQLImage.class);
        return this.f17276O;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m24345V() {
        this.f17277P = (GraphQLImage) super.m9947a(this.f17277P, 43, GraphQLImage.class);
        return this.f17277P;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m24346W() {
        this.f17278Q = (GraphQLImage) super.m9947a(this.f17278Q, 44, GraphQLImage.class);
        return this.f17278Q;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m24347X() {
        this.f17279R = (GraphQLImage) super.m9947a(this.f17279R, 45, GraphQLImage.class);
        return this.f17279R;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m24348Y() {
        this.f17280S = (GraphQLImage) super.m9947a(this.f17280S, 46, GraphQLImage.class);
        return this.f17280S;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m24349Z() {
        this.f17281T = (GraphQLImage) super.m9947a(this.f17281T, 47, GraphQLImage.class);
        return this.f17281T;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage aa() {
        this.f17282U = (GraphQLImage) super.m9947a(this.f17282U, 48, GraphQLImage.class);
        return this.f17282U;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage ab() {
        this.f17283V = (GraphQLImage) super.m9947a(this.f17283V, 49, GraphQLImage.class);
        return this.f17283V;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage ac() {
        this.f17284W = (GraphQLImage) super.m9947a(this.f17284W, 50, GraphQLImage.class);
        return this.f17284W;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage ad() {
        this.f17285X = (GraphQLImage) super.m9947a(this.f17285X, 51, GraphQLImage.class);
        return this.f17285X;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage ae() {
        this.f17286Y = (GraphQLImage) super.m9947a(this.f17286Y, 52, GraphQLImage.class);
        return this.f17286Y;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage af() {
        this.f17287Z = (GraphQLImage) super.m9947a(this.f17287Z, 53, GraphQLImage.class);
        return this.f17287Z;
    }

    @FieldOffset
    @Nullable
    public final GraphQLPlace ag() {
        this.aa = (GraphQLPlace) super.m9947a(this.aa, 54, GraphQLPlace.class);
        return this.aa;
    }

    @FieldOffset
    @Nullable
    public final GraphQLInlineActivitiesConnection ah() {
        this.ab = (GraphQLInlineActivitiesConnection) super.m9947a(this.ab, 55, GraphQLInlineActivitiesConnection.class);
        return this.ab;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage ai() {
        this.ac = (GraphQLImage) super.m9947a(this.ac, 56, GraphQLImage.class);
        return this.ac;
    }

    @FieldOffset
    public final boolean aj() {
        m9949a(7, 1);
        return this.ad;
    }

    @FieldOffset
    public final boolean ak() {
        m9949a(7, 2);
        return this.ae;
    }

    @FieldOffset
    public final boolean al() {
        m9949a(7, 3);
        return this.af;
    }

    @FieldOffset
    public final boolean am() {
        m9949a(7, 4);
        return this.ag;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage an() {
        this.ah = (GraphQLImage) super.m9947a(this.ah, 62, GraphQLImage.class);
        return this.ah;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage ao() {
        this.ai = (GraphQLImage) super.m9947a(this.ai, 63, GraphQLImage.class);
        return this.ai;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage ap() {
        this.aj = (GraphQLImage) super.m9947a(this.aj, 64, GraphQLImage.class);
        return this.aj;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage aq() {
        this.ak = (GraphQLImage) super.m9947a(this.ak, 65, GraphQLImage.class);
        return this.ak;
    }

    @FieldOffset
    @Nullable
    public final GraphQLPlaceSuggestionInfo ar() {
        this.al = (GraphQLPlaceSuggestionInfo) super.m9947a(this.al, 66, GraphQLPlaceSuggestionInfo.class);
        return this.al;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage as() {
        this.am = (GraphQLImage) super.m9947a(this.am, 67, GraphQLImage.class);
        return this.am;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage at() {
        this.an = (GraphQLImage) super.m9947a(this.an, 68, GraphQLImage.class);
        return this.an;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities au() {
        this.ao = (GraphQLTextWithEntities) super.m9947a(this.ao, 69, GraphQLTextWithEntities.class);
        return this.ao;
    }

    @FieldOffset
    public final long av() {
        m9949a(8, 6);
        return this.ap;
    }

    @FieldOffset
    @Nullable
    public final String aw() {
        this.aq = super.m9948a(this.aq, 71);
        return this.aq;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage ax() {
        this.ar = (GraphQLImage) super.m9947a(this.ar, 72, GraphQLImage.class);
        return this.ar;
    }

    @FieldOffset
    @Nullable
    public final String ay() {
        this.as = super.m9948a(this.as, 73);
        return this.as;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage az() {
        this.at = (GraphQLImage) super.m9947a(this.at, 74, GraphQLImage.class);
        return this.at;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage aA() {
        this.au = (GraphQLImage) super.m9947a(this.au, 75, GraphQLImage.class);
        return this.au;
    }

    @FieldOffset
    @Nullable
    public final GraphQLActor aB() {
        this.av = (GraphQLActor) super.m9947a(this.av, 76, GraphQLActor.class);
        return this.av;
    }

    @FieldOffset
    @Nullable
    public final GraphQLVideo aC() {
        this.aw = (GraphQLVideo) super.m9947a(this.aw, 77, GraphQLVideo.class);
        return this.aw;
    }

    @FieldOffset
    @Nullable
    public final GraphQLPlace aD() {
        this.ax = (GraphQLPlace) super.m9947a(this.ax, 78, GraphQLPlace.class);
        return this.ax;
    }

    @FieldOffset
    public final ImmutableList<GraphQLPhotoEncoding> aE() {
        this.ay = super.m9944a(this.ay, 79, GraphQLPhotoEncoding.class);
        return (ImmutableList) this.ay;
    }

    @FieldOffset
    @Nullable
    public final String aF() {
        this.az = super.m9948a(this.az, 80);
        return this.az;
    }

    @FieldOffset
    @Nullable
    public final String aG() {
        this.aA = super.m9948a(this.aA, 81);
        return this.aA;
    }

    @FieldOffset
    public final int aH() {
        m9949a(10, 2);
        return this.aB;
    }

    @FieldOffset
    public final int aI() {
        m9949a(10, 3);
        return this.aC;
    }

    @FieldOffset
    @Nullable
    public final String aJ() {
        this.aD = super.m9948a(this.aD, 84);
        return this.aD;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage aK() {
        this.aE = (GraphQLImage) super.m9947a(this.aE, 85, GraphQLImage.class);
        return this.aE;
    }

    @FieldOffset
    @Nullable
    public final String aL() {
        this.aF = super.m9948a(this.aF, 86);
        return this.aF;
    }

    @FieldOffset
    @Nullable
    public final String aM() {
        this.aG = super.m9948a(this.aG, 87);
        return this.aG;
    }

    @FieldOffset
    @Nullable
    public final GraphQLPrivacyScope aN() {
        this.aH = (GraphQLPrivacyScope) super.m9947a(this.aH, 88, GraphQLPrivacyScope.class);
        return this.aH;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage aO() {
        this.aI = (GraphQLImage) super.m9947a(this.aI, 89, GraphQLImage.class);
        return this.aI;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage aP() {
        this.aJ = (GraphQLImage) super.m9947a(this.aJ, 90, GraphQLImage.class);
        return this.aJ;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage aQ() {
        this.aK = (GraphQLImage) super.m9947a(this.aK, 91, GraphQLImage.class);
        return this.aK;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImageOverlay aR() {
        this.aL = (GraphQLImageOverlay) super.m9947a(this.aL, 92, GraphQLImageOverlay.class);
        return this.aL;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage aS() {
        this.aM = (GraphQLImage) super.m9947a(this.aM, 93, GraphQLImage.class);
        return this.aM;
    }

    @FieldOffset
    public final boolean aT() {
        m9949a(11, 6);
        return this.aN;
    }

    @FieldOffset
    public final boolean aU() {
        m9949a(11, 7);
        return this.aO;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage aV() {
        this.aP = (GraphQLImage) super.m9947a(this.aP, 96, GraphQLImage.class);
        return this.aP;
    }

    @FieldOffset
    @Nullable
    public final GraphQLPhotoTagsConnection aW() {
        this.aQ = (GraphQLPhotoTagsConnection) super.m9947a(this.aQ, 97, GraphQLPhotoTagsConnection.class);
        return this.aQ;
    }

    @FieldOffset
    @Nullable
    public final String aX() {
        this.aR = super.m9948a(this.aR, 98);
        return this.aR;
    }

    @FieldOffset
    @Nullable
    public final GraphQLWithTagsConnection aY() {
        this.aS = (GraphQLWithTagsConnection) super.m9947a(this.aS, 99, GraphQLWithTagsConnection.class);
        return this.aS;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage aZ() {
        this.aT = (GraphQLImage) super.m9947a(this.aT, 100, GraphQLImage.class);
        return this.aT;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage ba() {
        this.aU = (GraphQLImage) super.m9947a(this.aU, 101, GraphQLImage.class);
        return this.aU;
    }

    @FieldOffset
    public final boolean bb() {
        m9949a(13, 1);
        return this.aV;
    }

    @FieldOffset
    public final int bc() {
        m9949a(13, 2);
        return this.aW;
    }

    @FieldOffset
    @Nullable
    public final String bd() {
        this.aX = super.m9948a(this.aX, 107);
        return this.aX;
    }

    @FieldOffset
    @Nullable
    public final GraphQLOpenGraphAction be() {
        this.aY = (GraphQLOpenGraphAction) super.m9947a(this.aY, 108, GraphQLOpenGraphAction.class);
        return this.aY;
    }

    @Nullable
    public final String mo2834a() {
        return m24334K();
    }

    public final int jK_() {
        return 77090322;
    }

    public final GraphQLVisitableModel mo1404a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLImage graphQLImage;
        GraphQLStory graphQLStory;
        GraphQLPlace graphQLPlace;
        GraphQLVisitableModel graphQLVisitableModel = null;
        m9958h();
        if (m24356k() != null) {
            GraphQLAlbum graphQLAlbum = (GraphQLAlbum) graphQLModelMutatingVisitor.mo2928b(m24356k());
            if (m24356k() != graphQLAlbum) {
                graphQLVisitableModel = (GraphQLPhoto) ModelHelper.m23095a(null, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17289e = graphQLAlbum;
            }
        }
        if (m24357l() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(m24357l());
            if (m24357l() != graphQLImage) {
                graphQLVisitableModel = (GraphQLPhoto) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17290f = graphQLImage;
            }
        }
        if (m24358m() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(m24358m());
            if (m24358m() != graphQLImage) {
                graphQLVisitableModel = (GraphQLPhoto) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17291g = graphQLImage;
            }
        }
        if (m24360o() != null) {
            GraphQLApplication graphQLApplication = (GraphQLApplication) graphQLModelMutatingVisitor.mo2928b(m24360o());
            if (m24360o() != graphQLApplication) {
                graphQLVisitableModel = (GraphQLPhoto) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17293i = graphQLApplication;
            }
        }
        if (m24324A() != null) {
            graphQLStory = (GraphQLStory) graphQLModelMutatingVisitor.mo2928b(m24324A());
            if (m24324A() != graphQLStory) {
                graphQLVisitableModel = (GraphQLPhoto) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17305u = graphQLStory;
            }
        }
        if (m24326C() != null) {
            graphQLStory = (GraphQLStory) graphQLModelMutatingVisitor.mo2928b(m24326C());
            if (m24326C() != graphQLStory) {
                graphQLVisitableModel = (GraphQLPhoto) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17307w = graphQLStory;
            }
        }
        if (m24327D() != null) {
            graphQLPlace = (GraphQLPlace) graphQLModelMutatingVisitor.mo2928b(m24327D());
            if (m24327D() != graphQLPlace) {
                graphQLVisitableModel = (GraphQLPhoto) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17308x = graphQLPlace;
            }
        }
        if (m24328E() != null) {
            GraphQLPhotoFaceBoxesConnection graphQLPhotoFaceBoxesConnection = (GraphQLPhotoFaceBoxesConnection) graphQLModelMutatingVisitor.mo2928b(m24328E());
            if (m24328E() != graphQLPhotoFaceBoxesConnection) {
                graphQLVisitableModel = (GraphQLPhoto) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17309y = graphQLPhotoFaceBoxesConnection;
            }
        }
        if (m24329F() != null) {
            GraphQLFeedback graphQLFeedback = (GraphQLFeedback) graphQLModelMutatingVisitor.mo2928b(m24329F());
            if (m24329F() != graphQLFeedback) {
                graphQLVisitableModel = (GraphQLPhoto) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17310z = graphQLFeedback;
            }
        }
        if (m24330G() != null) {
            GraphQLVect2 graphQLVect2 = (GraphQLVect2) graphQLModelMutatingVisitor.mo2928b(m24330G());
            if (m24330G() != graphQLVect2) {
                graphQLVisitableModel = (GraphQLPhoto) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17262A = graphQLVect2;
            }
        }
        if (m24335L() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(m24335L());
            if (m24335L() != graphQLImage) {
                graphQLVisitableModel = (GraphQLPhoto) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17267F = graphQLImage;
            }
        }
        if (m24336M() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(m24336M());
            if (m24336M() != graphQLImage) {
                graphQLVisitableModel = (GraphQLPhoto) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17268G = graphQLImage;
            }
        }
        if (m24337N() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(m24337N());
            if (m24337N() != graphQLImage) {
                graphQLVisitableModel = (GraphQLPhoto) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17269H = graphQLImage;
            }
        }
        if (m24338O() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(m24338O());
            if (m24338O() != graphQLImage) {
                graphQLVisitableModel = (GraphQLPhoto) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17270I = graphQLImage;
            }
        }
        if (m24339P() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(m24339P());
            if (m24339P() != graphQLImage) {
                graphQLVisitableModel = (GraphQLPhoto) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17271J = graphQLImage;
            }
        }
        if (m24340Q() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(m24340Q());
            if (m24340Q() != graphQLImage) {
                graphQLVisitableModel = (GraphQLPhoto) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17272K = graphQLImage;
            }
        }
        if (m24341R() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(m24341R());
            if (m24341R() != graphQLImage) {
                graphQLVisitableModel = (GraphQLPhoto) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17273L = graphQLImage;
            }
        }
        if (m24342S() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(m24342S());
            if (m24342S() != graphQLImage) {
                graphQLVisitableModel = (GraphQLPhoto) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17274M = graphQLImage;
            }
        }
        if (m24343T() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(m24343T());
            if (m24343T() != graphQLImage) {
                graphQLVisitableModel = (GraphQLPhoto) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17275N = graphQLImage;
            }
        }
        if (m24344U() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(m24344U());
            if (m24344U() != graphQLImage) {
                graphQLVisitableModel = (GraphQLPhoto) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17276O = graphQLImage;
            }
        }
        if (m24345V() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(m24345V());
            if (m24345V() != graphQLImage) {
                graphQLVisitableModel = (GraphQLPhoto) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17277P = graphQLImage;
            }
        }
        if (m24346W() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(m24346W());
            if (m24346W() != graphQLImage) {
                graphQLVisitableModel = (GraphQLPhoto) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17278Q = graphQLImage;
            }
        }
        if (m24347X() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(m24347X());
            if (m24347X() != graphQLImage) {
                graphQLVisitableModel = (GraphQLPhoto) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17279R = graphQLImage;
            }
        }
        if (m24348Y() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(m24348Y());
            if (m24348Y() != graphQLImage) {
                graphQLVisitableModel = (GraphQLPhoto) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17280S = graphQLImage;
            }
        }
        if (m24349Z() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(m24349Z());
            if (m24349Z() != graphQLImage) {
                graphQLVisitableModel = (GraphQLPhoto) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17281T = graphQLImage;
            }
        }
        if (aZ() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(aZ());
            if (aZ() != graphQLImage) {
                graphQLVisitableModel = (GraphQLPhoto) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.aT = graphQLImage;
            }
        }
        if (aa() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(aa());
            if (aa() != graphQLImage) {
                graphQLVisitableModel = (GraphQLPhoto) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17282U = graphQLImage;
            }
        }
        if (ab() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(ab());
            if (ab() != graphQLImage) {
                graphQLVisitableModel = (GraphQLPhoto) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17283V = graphQLImage;
            }
        }
        if (ac() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(ac());
            if (ac() != graphQLImage) {
                graphQLVisitableModel = (GraphQLPhoto) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17284W = graphQLImage;
            }
        }
        if (ad() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(ad());
            if (ad() != graphQLImage) {
                graphQLVisitableModel = (GraphQLPhoto) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17285X = graphQLImage;
            }
        }
        if (ae() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(ae());
            if (ae() != graphQLImage) {
                graphQLVisitableModel = (GraphQLPhoto) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17286Y = graphQLImage;
            }
        }
        if (af() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(af());
            if (af() != graphQLImage) {
                graphQLVisitableModel = (GraphQLPhoto) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17287Z = graphQLImage;
            }
        }
        if (ba() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(ba());
            if (ba() != graphQLImage) {
                graphQLVisitableModel = (GraphQLPhoto) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.aU = graphQLImage;
            }
        }
        if (ag() != null) {
            graphQLPlace = (GraphQLPlace) graphQLModelMutatingVisitor.mo2928b(ag());
            if (ag() != graphQLPlace) {
                graphQLVisitableModel = (GraphQLPhoto) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.aa = graphQLPlace;
            }
        }
        if (ah() != null) {
            GraphQLInlineActivitiesConnection graphQLInlineActivitiesConnection = (GraphQLInlineActivitiesConnection) graphQLModelMutatingVisitor.mo2928b(ah());
            if (ah() != graphQLInlineActivitiesConnection) {
                graphQLVisitableModel = (GraphQLPhoto) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.ab = graphQLInlineActivitiesConnection;
            }
        }
        if (ai() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(ai());
            if (ai() != graphQLImage) {
                graphQLVisitableModel = (GraphQLPhoto) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.ac = graphQLImage;
            }
        }
        if (an() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(an());
            if (an() != graphQLImage) {
                graphQLVisitableModel = (GraphQLPhoto) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.ah = graphQLImage;
            }
        }
        if (ao() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(ao());
            if (ao() != graphQLImage) {
                graphQLVisitableModel = (GraphQLPhoto) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.ai = graphQLImage;
            }
        }
        if (ap() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(ap());
            if (ap() != graphQLImage) {
                graphQLVisitableModel = (GraphQLPhoto) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.aj = graphQLImage;
            }
        }
        if (aq() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(aq());
            if (aq() != graphQLImage) {
                graphQLVisitableModel = (GraphQLPhoto) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.ak = graphQLImage;
            }
        }
        if (ar() != null) {
            GraphQLPlaceSuggestionInfo graphQLPlaceSuggestionInfo = (GraphQLPlaceSuggestionInfo) graphQLModelMutatingVisitor.mo2928b(ar());
            if (ar() != graphQLPlaceSuggestionInfo) {
                graphQLVisitableModel = (GraphQLPhoto) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.al = graphQLPlaceSuggestionInfo;
            }
        }
        if (as() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(as());
            if (as() != graphQLImage) {
                graphQLVisitableModel = (GraphQLPhoto) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.am = graphQLImage;
            }
        }
        if (at() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(at());
            if (at() != graphQLImage) {
                graphQLVisitableModel = (GraphQLPhoto) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.an = graphQLImage;
            }
        }
        if (au() != null) {
            GraphQLTextWithEntities graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.mo2928b(au());
            if (au() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLPhoto) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.ao = graphQLTextWithEntities;
            }
        }
        if (ax() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(ax());
            if (ax() != graphQLImage) {
                graphQLVisitableModel = (GraphQLPhoto) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.ar = graphQLImage;
            }
        }
        if (az() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(az());
            if (az() != graphQLImage) {
                graphQLVisitableModel = (GraphQLPhoto) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.at = graphQLImage;
            }
        }
        if (aA() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(aA());
            if (aA() != graphQLImage) {
                graphQLVisitableModel = (GraphQLPhoto) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.au = graphQLImage;
            }
        }
        if (be() != null) {
            GraphQLOpenGraphAction graphQLOpenGraphAction = (GraphQLOpenGraphAction) graphQLModelMutatingVisitor.mo2928b(be());
            if (be() != graphQLOpenGraphAction) {
                graphQLVisitableModel = (GraphQLPhoto) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.aY = graphQLOpenGraphAction;
            }
        }
        if (aB() != null) {
            GraphQLActor graphQLActor = (GraphQLActor) graphQLModelMutatingVisitor.mo2928b(aB());
            if (aB() != graphQLActor) {
                graphQLVisitableModel = (GraphQLPhoto) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.av = graphQLActor;
            }
        }
        if (aC() != null) {
            GraphQLVideo graphQLVideo = (GraphQLVideo) graphQLModelMutatingVisitor.mo2928b(aC());
            if (aC() != graphQLVideo) {
                graphQLVisitableModel = (GraphQLPhoto) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.aw = graphQLVideo;
            }
        }
        if (aD() != null) {
            graphQLPlace = (GraphQLPlace) graphQLModelMutatingVisitor.mo2928b(aD());
            if (aD() != graphQLPlace) {
                graphQLVisitableModel = (GraphQLPhoto) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.ax = graphQLPlace;
            }
        }
        if (aE() != null) {
            Builder a = ModelHelper.m23097a(aE(), graphQLModelMutatingVisitor);
            if (a != null) {
                GraphQLPhoto graphQLPhoto = (GraphQLPhoto) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLPhoto.ay = a.m1068b();
                graphQLVisitableModel = graphQLPhoto;
            }
        }
        if (aK() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(aK());
            if (aK() != graphQLImage) {
                graphQLVisitableModel = (GraphQLPhoto) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.aE = graphQLImage;
            }
        }
        if (aN() != null) {
            GraphQLPrivacyScope graphQLPrivacyScope = (GraphQLPrivacyScope) graphQLModelMutatingVisitor.mo2928b(aN());
            if (aN() != graphQLPrivacyScope) {
                graphQLVisitableModel = (GraphQLPhoto) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.aH = graphQLPrivacyScope;
            }
        }
        if (aO() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(aO());
            if (aO() != graphQLImage) {
                graphQLVisitableModel = (GraphQLPhoto) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.aI = graphQLImage;
            }
        }
        if (aP() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(aP());
            if (aP() != graphQLImage) {
                graphQLVisitableModel = (GraphQLPhoto) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.aJ = graphQLImage;
            }
        }
        if (aQ() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(aQ());
            if (aQ() != graphQLImage) {
                graphQLVisitableModel = (GraphQLPhoto) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.aK = graphQLImage;
            }
        }
        if (aR() != null) {
            GraphQLImageOverlay graphQLImageOverlay = (GraphQLImageOverlay) graphQLModelMutatingVisitor.mo2928b(aR());
            if (aR() != graphQLImageOverlay) {
                graphQLVisitableModel = (GraphQLPhoto) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.aL = graphQLImageOverlay;
            }
        }
        if (aS() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(aS());
            if (aS() != graphQLImage) {
                graphQLVisitableModel = (GraphQLPhoto) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.aM = graphQLImage;
            }
        }
        if (aV() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(aV());
            if (aV() != graphQLImage) {
                graphQLVisitableModel = (GraphQLPhoto) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.aP = graphQLImage;
            }
        }
        if (aW() != null) {
            GraphQLPhotoTagsConnection graphQLPhotoTagsConnection = (GraphQLPhotoTagsConnection) graphQLModelMutatingVisitor.mo2928b(aW());
            if (aW() != graphQLPhotoTagsConnection) {
                graphQLVisitableModel = (GraphQLPhoto) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.aQ = graphQLPhotoTagsConnection;
            }
        }
        if (aY() != null) {
            GraphQLWithTagsConnection graphQLWithTagsConnection = (GraphQLWithTagsConnection) graphQLModelMutatingVisitor.mo2928b(aY());
            if (aY() != graphQLWithTagsConnection) {
                graphQLVisitableModel = (GraphQLPhoto) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.aS = graphQLWithTagsConnection;
            }
        }
        m9959i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLPhoto() {
        super(110);
    }

    public final void mo1406a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.mo1406a(mutableFlatBuffer, i, obj);
        this.f17292h = mutableFlatBuffer.m21524a(i, 4, 0);
        this.f17295k = mutableFlatBuffer.m21524a(i, 8, 0);
        this.f17296l = mutableFlatBuffer.m21540a(i, 9);
        this.f17297m = mutableFlatBuffer.m21540a(i, 10);
        this.f17298n = mutableFlatBuffer.m21540a(i, 11);
        this.f17299o = mutableFlatBuffer.m21540a(i, 12);
        this.f17300p = mutableFlatBuffer.m21540a(i, 13);
        this.f17301q = mutableFlatBuffer.m21540a(i, 14);
        this.f17302r = mutableFlatBuffer.m21540a(i, 15);
        this.f17303s = mutableFlatBuffer.m21540a(i, 17);
        this.f17304t = mutableFlatBuffer.m21540a(i, 18);
        this.f17306v = mutableFlatBuffer.m21525a(i, 20, 0);
        this.f17263B = mutableFlatBuffer.m21540a(i, 29);
        this.f17264C = mutableFlatBuffer.m21524a(i, 30, 0);
        this.f17265D = mutableFlatBuffer.m21524a(i, 31, 0);
        this.ad = mutableFlatBuffer.m21540a(i, 57);
        this.ae = mutableFlatBuffer.m21540a(i, 58);
        this.af = mutableFlatBuffer.m21540a(i, 59);
        this.ag = mutableFlatBuffer.m21540a(i, 60);
        this.ap = mutableFlatBuffer.m21525a(i, 70, 0);
        this.aB = mutableFlatBuffer.m21524a(i, 82, 0);
        this.aC = mutableFlatBuffer.m21524a(i, 83, 0);
        this.aN = mutableFlatBuffer.m21540a(i, 94);
        this.aO = mutableFlatBuffer.m21540a(i, 95);
        this.aV = mutableFlatBuffer.m21540a(i, 105);
        this.aW = mutableFlatBuffer.m21524a(i, 106, 0);
    }

    public final int mo1403a(FlatBufferBuilder flatBufferBuilder) {
        m9958h();
        int b = flatBufferBuilder.m21502b(m24355j());
        int a = ModelHelper.m23093a(flatBufferBuilder, m24356k());
        int a2 = ModelHelper.m23093a(flatBufferBuilder, m24357l());
        int a3 = ModelHelper.m23093a(flatBufferBuilder, m24358m());
        int a4 = ModelHelper.m23093a(flatBufferBuilder, m24360o());
        int b2 = flatBufferBuilder.m21502b(m24361p());
        int a5 = ModelHelper.m23093a(flatBufferBuilder, m24324A());
        int a6 = ModelHelper.m23093a(flatBufferBuilder, m24326C());
        int a7 = ModelHelper.m23093a(flatBufferBuilder, m24327D());
        int a8 = ModelHelper.m23093a(flatBufferBuilder, m24328E());
        int a9 = ModelHelper.m23093a(flatBufferBuilder, m24329F());
        int a10 = ModelHelper.m23093a(flatBufferBuilder, m24330G());
        int b3 = flatBufferBuilder.m21502b(m24334K());
        int a11 = ModelHelper.m23093a(flatBufferBuilder, m24335L());
        int a12 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) m24336M());
        int a13 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) m24337N());
        int a14 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) m24338O());
        int a15 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) m24339P());
        int a16 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) m24340Q());
        int a17 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) m24341R());
        int a18 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) m24342S());
        int a19 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) m24343T());
        int a20 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) m24344U());
        int a21 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) m24345V());
        int a22 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) m24346W());
        int a23 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) m24347X());
        int a24 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) m24348Y());
        int a25 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) m24349Z());
        int a26 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) aa());
        int a27 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) ab());
        int a28 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) ac());
        int a29 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) ad());
        int a30 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) ae());
        int a31 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) af());
        int a32 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) ag());
        int a33 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) ah());
        int a34 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) ai());
        int a35 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) an());
        int a36 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) ao());
        int a37 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) ap());
        int a38 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) aq());
        int a39 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) ar());
        int a40 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) as());
        int a41 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) at());
        int a42 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) au());
        int b4 = flatBufferBuilder.m21502b(aw());
        int a43 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) ax());
        int b5 = flatBufferBuilder.m21502b(ay());
        int a44 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) az());
        int a45 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) aA());
        int a46 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) aB());
        int a47 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) aC());
        int a48 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) aD());
        int a49 = ModelHelper.m23094a(flatBufferBuilder, (List) aE());
        int b6 = flatBufferBuilder.m21502b(aF());
        int b7 = flatBufferBuilder.m21502b(aG());
        int b8 = flatBufferBuilder.m21502b(aJ());
        int a50 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) aK());
        int b9 = flatBufferBuilder.m21502b(aL());
        int b10 = flatBufferBuilder.m21502b(aM());
        int a51 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) aN());
        int a52 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) aO());
        int a53 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) aP());
        int a54 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) aQ());
        int a55 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) aR());
        int a56 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) aS());
        int a57 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) aV());
        int a58 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) aW());
        int b11 = flatBufferBuilder.m21502b(aX());
        int a59 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) aY());
        int a60 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) aZ());
        int a61 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) ba());
        int b12 = flatBufferBuilder.m21502b(bd());
        int a62 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) be());
        flatBufferBuilder.m21510c(109);
        flatBufferBuilder.m21507b(0, b);
        flatBufferBuilder.m21507b(1, a);
        flatBufferBuilder.m21507b(2, a2);
        flatBufferBuilder.m21507b(3, a3);
        flatBufferBuilder.m21494a(4, m24359n(), 0);
        flatBufferBuilder.m21507b(6, a4);
        flatBufferBuilder.m21507b(7, b2);
        flatBufferBuilder.m21494a(8, m24362q(), 0);
        flatBufferBuilder.m21498a(9, m24363r());
        flatBufferBuilder.m21498a(10, m24364s());
        flatBufferBuilder.m21498a(11, m24365t());
        flatBufferBuilder.m21498a(12, m24366u());
        flatBufferBuilder.m21498a(13, m24367v());
        flatBufferBuilder.m21498a(14, m24368w());
        flatBufferBuilder.m21498a(15, m24369x());
        flatBufferBuilder.m21498a(17, m24370y());
        flatBufferBuilder.m21498a(18, m24371z());
        flatBufferBuilder.m21507b(19, a5);
        flatBufferBuilder.m21495a(20, m24325B(), 0);
        flatBufferBuilder.m21507b(21, a6);
        flatBufferBuilder.m21507b(22, a7);
        flatBufferBuilder.m21507b(23, a8);
        flatBufferBuilder.m21507b(27, a9);
        flatBufferBuilder.m21507b(28, a10);
        flatBufferBuilder.m21498a(29, m24331H());
        flatBufferBuilder.m21494a(30, m24332I(), 0);
        flatBufferBuilder.m21494a(31, m24333J(), 0);
        flatBufferBuilder.m21507b(32, b3);
        flatBufferBuilder.m21507b(33, a11);
        flatBufferBuilder.m21507b(34, a12);
        flatBufferBuilder.m21507b(35, a13);
        flatBufferBuilder.m21507b(36, a14);
        flatBufferBuilder.m21507b(37, a15);
        flatBufferBuilder.m21507b(38, a16);
        flatBufferBuilder.m21507b(39, a17);
        flatBufferBuilder.m21507b(40, a18);
        flatBufferBuilder.m21507b(41, a19);
        flatBufferBuilder.m21507b(42, a20);
        flatBufferBuilder.m21507b(43, a21);
        flatBufferBuilder.m21507b(44, a22);
        flatBufferBuilder.m21507b(45, a23);
        flatBufferBuilder.m21507b(46, a24);
        flatBufferBuilder.m21507b(47, a25);
        flatBufferBuilder.m21507b(48, a26);
        flatBufferBuilder.m21507b(49, a27);
        flatBufferBuilder.m21507b(50, a28);
        flatBufferBuilder.m21507b(51, a29);
        flatBufferBuilder.m21507b(52, a30);
        flatBufferBuilder.m21507b(53, a31);
        flatBufferBuilder.m21507b(54, a32);
        flatBufferBuilder.m21507b(55, a33);
        flatBufferBuilder.m21507b(56, a34);
        flatBufferBuilder.m21498a(57, aj());
        flatBufferBuilder.m21498a(58, ak());
        flatBufferBuilder.m21498a(59, al());
        flatBufferBuilder.m21498a(60, am());
        flatBufferBuilder.m21507b(62, a35);
        flatBufferBuilder.m21507b(63, a36);
        flatBufferBuilder.m21507b(64, a37);
        flatBufferBuilder.m21507b(65, a38);
        flatBufferBuilder.m21507b(66, a39);
        flatBufferBuilder.m21507b(67, a40);
        flatBufferBuilder.m21507b(68, a41);
        flatBufferBuilder.m21507b(69, a42);
        flatBufferBuilder.m21495a(70, av(), 0);
        flatBufferBuilder.m21507b(71, b4);
        flatBufferBuilder.m21507b(72, a43);
        flatBufferBuilder.m21507b(73, b5);
        flatBufferBuilder.m21507b(74, a44);
        flatBufferBuilder.m21507b(75, a45);
        flatBufferBuilder.m21507b(76, a46);
        flatBufferBuilder.m21507b(77, a47);
        flatBufferBuilder.m21507b(78, a48);
        flatBufferBuilder.m21507b(79, a49);
        flatBufferBuilder.m21507b(80, b6);
        flatBufferBuilder.m21507b(81, b7);
        flatBufferBuilder.m21494a(82, aH(), 0);
        flatBufferBuilder.m21494a(83, aI(), 0);
        flatBufferBuilder.m21507b(84, b8);
        flatBufferBuilder.m21507b(85, a50);
        flatBufferBuilder.m21507b(86, b9);
        flatBufferBuilder.m21507b(87, b10);
        flatBufferBuilder.m21507b(88, a51);
        flatBufferBuilder.m21507b(89, a52);
        flatBufferBuilder.m21507b(90, a53);
        flatBufferBuilder.m21507b(91, a54);
        flatBufferBuilder.m21507b(92, a55);
        flatBufferBuilder.m21507b(93, a56);
        flatBufferBuilder.m21498a(94, aT());
        flatBufferBuilder.m21498a(95, aU());
        flatBufferBuilder.m21507b(96, a57);
        flatBufferBuilder.m21507b(97, a58);
        flatBufferBuilder.m21507b(98, b11);
        flatBufferBuilder.m21507b(99, a59);
        flatBufferBuilder.m21507b(100, a60);
        flatBufferBuilder.m21507b(101, a61);
        flatBufferBuilder.m21498a(105, bb());
        flatBufferBuilder.m21494a(106, bc(), 0);
        flatBufferBuilder.m21507b(107, b12);
        flatBufferBuilder.m21507b(108, a62);
        m9959i();
        return flatBufferBuilder.m21511d();
    }

    public GraphQLPhoto(Parcel parcel) {
        boolean z;
        boolean z2 = true;
        super(110);
        this.f17288d = parcel.readString();
        this.f17289e = (GraphQLAlbum) parcel.readValue(GraphQLAlbum.class.getClassLoader());
        this.f17290f = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f17291g = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f17292h = parcel.readInt();
        this.f17293i = (GraphQLApplication) parcel.readValue(GraphQLApplication.class.getClassLoader());
        this.f17294j = parcel.readString();
        this.f17295k = parcel.readInt();
        this.f17296l = parcel.readByte() == (byte) 1;
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.f17297m = z;
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.f17298n = z;
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.f17299o = z;
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.f17300p = z;
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.f17301q = z;
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.f17302r = z;
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.f17303s = z;
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.f17304t = z;
        this.f17305u = (GraphQLStory) parcel.readValue(GraphQLStory.class.getClassLoader());
        this.f17306v = parcel.readLong();
        this.f17307w = (GraphQLStory) parcel.readValue(GraphQLStory.class.getClassLoader());
        this.aX = parcel.readString();
        this.f17308x = (GraphQLPlace) parcel.readValue(GraphQLPlace.class.getClassLoader());
        this.f17309y = (GraphQLPhotoFaceBoxesConnection) parcel.readValue(GraphQLPhotoFaceBoxesConnection.class.getClassLoader());
        this.f17310z = (GraphQLFeedback) parcel.readValue(GraphQLFeedback.class.getClassLoader());
        this.f17262A = (GraphQLVect2) parcel.readValue(GraphQLVect2.class.getClassLoader());
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.f17263B = z;
        this.f17264C = parcel.readInt();
        this.f17265D = parcel.readInt();
        this.f17266E = parcel.readString();
        this.f17267F = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f17268G = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f17269H = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f17270I = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f17271J = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f17272K = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f17273L = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f17274M = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f17275N = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f17276O = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f17277P = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f17278Q = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f17279R = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f17280S = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f17281T = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.aT = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f17282U = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f17283V = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f17284W = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f17285X = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f17286Y = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f17287Z = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.aU = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.aa = (GraphQLPlace) parcel.readValue(GraphQLPlace.class.getClassLoader());
        this.ab = (GraphQLInlineActivitiesConnection) parcel.readValue(GraphQLInlineActivitiesConnection.class.getClassLoader());
        this.ac = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.ad = parcel.readByte() == (byte) 1;
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
        this.ae = z;
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
        this.ag = z;
        this.ah = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.ai = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.aj = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.ak = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.al = (GraphQLPlaceSuggestionInfo) parcel.readValue(GraphQLPlaceSuggestionInfo.class.getClassLoader());
        this.am = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.an = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.ao = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.ap = parcel.readLong();
        this.aq = parcel.readString();
        this.ar = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.as = parcel.readString();
        this.at = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.au = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.aY = (GraphQLOpenGraphAction) parcel.readValue(GraphQLOpenGraphAction.class.getClassLoader());
        this.av = (GraphQLActor) parcel.readValue(GraphQLActor.class.getClassLoader());
        this.aw = (GraphQLVideo) parcel.readValue(GraphQLVideo.class.getClassLoader());
        this.ax = (GraphQLPlace) parcel.readValue(GraphQLPlace.class.getClassLoader());
        this.ay = ImmutableListHelper.m21625a(parcel.readArrayList(GraphQLPhotoEncoding.class.getClassLoader()));
        this.az = parcel.readString();
        this.aA = parcel.readString();
        this.aB = parcel.readInt();
        this.aC = parcel.readInt();
        this.aD = parcel.readString();
        this.aE = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.aF = parcel.readString();
        this.aG = parcel.readString();
        this.aH = (GraphQLPrivacyScope) parcel.readValue(GraphQLPrivacyScope.class.getClassLoader());
        this.aI = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.aJ = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.aK = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.aL = (GraphQLImageOverlay) parcel.readValue(GraphQLImageOverlay.class.getClassLoader());
        this.aM = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.aN = parcel.readByte() == (byte) 1;
        if (parcel.readByte() != (byte) 1) {
            z2 = false;
        }
        this.aO = z2;
        this.aP = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.aQ = (GraphQLPhotoTagsConnection) parcel.readValue(GraphQLPhotoTagsConnection.class.getClassLoader());
        this.aR = parcel.readString();
        this.aW = parcel.readInt();
        this.aS = (GraphQLWithTagsConnection) parcel.readValue(GraphQLWithTagsConnection.class.getClassLoader());
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int i2;
        int i3 = 1;
        parcel.writeString(m24355j());
        parcel.writeValue(m24356k());
        parcel.writeValue(m24357l());
        parcel.writeValue(m24358m());
        parcel.writeInt(m24359n());
        parcel.writeValue(m24360o());
        parcel.writeString(m24361p());
        parcel.writeInt(m24362q());
        parcel.writeByte((byte) (m24363r() ? 1 : 0));
        if (m24364s()) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        if (m24365t()) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        if (m24366u()) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        if (m24367v()) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        if (m24368w()) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        if (m24369x()) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        if (m24370y()) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        if (m24371z()) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        parcel.writeValue(m24324A());
        parcel.writeLong(m24325B());
        parcel.writeValue(m24326C());
        parcel.writeString(bd());
        parcel.writeValue(m24327D());
        parcel.writeValue(m24328E());
        parcel.writeValue(m24329F());
        parcel.writeValue(m24330G());
        if (m24331H()) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        parcel.writeInt(m24332I());
        parcel.writeInt(m24333J());
        parcel.writeString(m24334K());
        parcel.writeValue(m24335L());
        parcel.writeValue(m24336M());
        parcel.writeValue(m24337N());
        parcel.writeValue(m24338O());
        parcel.writeValue(m24339P());
        parcel.writeValue(m24340Q());
        parcel.writeValue(m24341R());
        parcel.writeValue(m24342S());
        parcel.writeValue(m24343T());
        parcel.writeValue(m24344U());
        parcel.writeValue(m24345V());
        parcel.writeValue(m24346W());
        parcel.writeValue(m24347X());
        parcel.writeValue(m24348Y());
        parcel.writeValue(m24349Z());
        parcel.writeValue(aZ());
        parcel.writeValue(aa());
        parcel.writeValue(ab());
        parcel.writeValue(ac());
        parcel.writeValue(ad());
        parcel.writeValue(ae());
        parcel.writeValue(af());
        parcel.writeValue(ba());
        parcel.writeValue(ag());
        parcel.writeValue(ah());
        parcel.writeValue(ai());
        parcel.writeByte((byte) (aj() ? 1 : 0));
        if (bb()) {
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
        parcel.writeValue(an());
        parcel.writeValue(ao());
        parcel.writeValue(ap());
        parcel.writeValue(aq());
        parcel.writeValue(ar());
        parcel.writeValue(as());
        parcel.writeValue(at());
        parcel.writeValue(au());
        parcel.writeLong(av());
        parcel.writeString(aw());
        parcel.writeValue(ax());
        parcel.writeString(ay());
        parcel.writeValue(az());
        parcel.writeValue(aA());
        parcel.writeValue(be());
        parcel.writeValue(aB());
        parcel.writeValue(aC());
        parcel.writeValue(aD());
        parcel.writeList(aE());
        parcel.writeString(aF());
        parcel.writeString(aG());
        parcel.writeInt(aH());
        parcel.writeInt(aI());
        parcel.writeString(aJ());
        parcel.writeValue(aK());
        parcel.writeString(aL());
        parcel.writeString(aM());
        parcel.writeValue(aN());
        parcel.writeValue(aO());
        parcel.writeValue(aP());
        parcel.writeValue(aQ());
        parcel.writeValue(aR());
        parcel.writeValue(aS());
        parcel.writeByte((byte) (aT() ? 1 : 0));
        if (!aU()) {
            i3 = 0;
        }
        parcel.writeByte((byte) i3);
        parcel.writeValue(aV());
        parcel.writeValue(aW());
        parcel.writeString(aX());
        parcel.writeInt(bc());
        parcel.writeValue(aY());
    }

    public GraphQLPhoto(Builder builder) {
        super(110);
        this.b = builder.f15736a;
        this.c = builder.f15737b;
        this.f17288d = builder.d;
        this.f17289e = builder.e;
        this.f17290f = builder.f;
        this.f17291g = builder.g;
        this.f17292h = builder.h;
        this.f17293i = builder.i;
        this.f17294j = builder.j;
        this.f17295k = builder.k;
        this.f17296l = builder.l;
        this.f17297m = builder.m;
        this.f17298n = builder.n;
        this.f17299o = builder.o;
        this.f17300p = builder.p;
        this.f17301q = builder.q;
        this.f17302r = builder.r;
        this.f17303s = builder.s;
        this.f17304t = builder.t;
        this.f17305u = builder.u;
        this.f17306v = builder.v;
        this.f17307w = builder.w;
        this.aX = builder.x;
        this.f17308x = builder.y;
        this.f17309y = builder.z;
        this.f17310z = builder.A;
        this.f17262A = builder.B;
        this.f17263B = builder.C;
        this.f17264C = builder.D;
        this.f17265D = builder.E;
        this.f17266E = builder.F;
        this.f17267F = builder.G;
        this.f17268G = builder.H;
        this.f17269H = builder.I;
        this.f17270I = builder.J;
        this.f17271J = builder.K;
        this.f17272K = builder.L;
        this.f17273L = builder.M;
        this.f17274M = builder.N;
        this.f17275N = builder.O;
        this.f17276O = builder.P;
        this.f17277P = builder.Q;
        this.f17278Q = builder.R;
        this.f17279R = builder.S;
        this.f17280S = builder.T;
        this.f17281T = builder.U;
        this.aT = builder.V;
        this.f17282U = builder.W;
        this.f17283V = builder.X;
        this.f17284W = builder.Y;
        this.f17285X = builder.Z;
        this.f17286Y = builder.aa;
        this.f17287Z = builder.ab;
        this.aU = builder.ac;
        this.aa = builder.ad;
        this.ab = builder.ae;
        this.ac = builder.af;
        this.ad = builder.ag;
        this.aV = builder.ah;
        this.ae = builder.ai;
        this.af = builder.aj;
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
        this.aY = builder.az;
        this.av = builder.aA;
        this.aw = builder.aB;
        this.ax = builder.aC;
        this.ay = builder.aD;
        this.az = builder.aE;
        this.aA = builder.aF;
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
        this.aM = builder.aR;
        this.aN = builder.aS;
        this.aO = builder.aT;
        this.aP = builder.aU;
        this.aQ = builder.aV;
        this.aR = builder.aW;
        this.aW = builder.aX;
        this.aS = builder.aY;
    }
}
