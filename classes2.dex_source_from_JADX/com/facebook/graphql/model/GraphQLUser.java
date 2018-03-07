package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.json.AutoGenJsonSerializer;
import com.facebook.dracula.api.FieldOffset;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.flatbuffers.MutableFlattenable;
import com.facebook.graphql.enums.GraphQLFriendshipStatus;
import com.facebook.graphql.enums.GraphQLGender;
import com.facebook.graphql.enums.GraphQLLiveVideoSubscriptionStatus;
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
/* compiled from: locale_last_time_synced */
public final class GraphQLUser extends BaseModel implements TypeModel, GraphQLPersistableNode, GraphQLVisitableConsistentModel {
    public static final Creator<GraphQLUser> CREATOR = new C07941();
    @Nullable
    GraphQLEventsConnection f16916A;
    @Nullable
    GraphQLImage f16917B;
    @Nullable
    GraphQLTimelineSectionsConnection f16918C;
    @Deprecated
    @Nullable
    String f16919D;
    @Nullable
    GraphQLFollowUpFeedUnitsConnection f16920E;
    @Nullable
    GraphQLFriendsConnection f16921F;
    public GraphQLFriendshipStatus f16922G;
    GraphQLGender f16923H;
    @Nullable
    GraphQLPage f16924I;
    @Nullable
    String f16925J;
    @Nullable
    GraphQLImage f16926K;
    @Deprecated
    @Nullable
    GraphQLInlineActivitiesConnection f16927L;
    boolean f16928M;
    boolean f16929N;
    boolean f16930O;
    boolean f16931P;
    boolean f16932Q;
    boolean f16933R;
    boolean f16934S;
    boolean f16935T;
    boolean f16936U;
    boolean f16937V;
    public boolean f16938W;
    boolean f16939X;
    boolean f16940Y;
    boolean f16941Z;
    @Nullable
    GraphQLImage aA;
    @Nullable
    GraphQLImage aB;
    @Nullable
    GraphQLImage aC;
    long aD;
    boolean aE;
    @Nullable
    String aF;
    long aG;
    @Nullable
    String aH;
    @Nullable
    String aI;
    public GraphQLSecondarySubscribeStatus aJ;
    @Nullable
    String aK;
    @Nullable
    GraphQLSinglePublisherVideoChannelsConnection aL;
    @Nullable
    GraphQLTextWithEntities aM;
    @Nullable
    GraphQLImage aN;
    @Nullable
    GraphQLImage aO;
    @Nullable
    GraphQLImage aP;
    @Nullable
    GraphQLStreamingImage aQ;
    @Nullable
    GraphQLName aR;
    List<GraphQLName> aS;
    public GraphQLSubscribeStatus aT;
    @Nullable
    GraphQLImage aU;
    @Nullable
    GraphQLTextWithEntities aV;
    @Nullable
    GraphQLTimelineSectionsConnection aW;
    int aX;
    @Nullable
    GraphQLUnseenStoriesConnection aY;
    @Nullable
    String aZ;
    boolean aa;
    boolean ab;
    boolean ac;
    @Nullable
    GraphQLLikedProfilesConnection ad;
    GraphQLLiveVideoSubscriptionStatus ae;
    @Nullable
    GraphQLImage af;
    @Nullable
    GraphQLContact ag;
    long ah;
    double ai;
    @Nullable
    String aj;
    @Nullable
    GraphQLMutualFriendsConnection ak;
    @Nullable
    String al;
    List<String> am;
    @Deprecated
    @Nullable
    GraphQLNewsFeedConnection an;
    @Nullable
    GraphQLPrivacyScope ao;
    @Nullable
    GraphQLImage ap;
    @Nullable
    GraphQLImage aq;
    @Nullable
    GraphQLImage ar;
    @Nullable
    GraphQLImage as;
    @Nullable
    GraphQLImage at;
    @Nullable
    GraphQLImage au;
    @Nullable
    GraphQLImage av;
    @Nullable
    GraphQLImage aw;
    @Nullable
    GraphQLProfileBadge ax;
    @Nullable
    GraphQLPhoto ay;
    @Nullable
    GraphQLImage az;
    @Nullable
    public String ba;
    boolean bb;
    boolean bc;
    @Nullable
    GraphQLProfile bd;
    boolean be;
    public boolean bf;
    public boolean bg;
    boolean bh;
    int bi;
    int bj;
    @Nullable
    GraphQLTextWithEntities bk;
    @Nullable
    GraphQLTextWithEntities bl;
    double bm;
    List<String> bn;
    double bo;
    @Nullable
    GraphQLUserWorkExperiencesConnection bp;
    long bq;
    @Nullable
    GraphQLImage br;
    @Nullable
    GraphQLImage bs;
    @Nullable
    GraphQLImage bt;
    int bu;
    @Nullable
    String bv;
    boolean bw;
    boolean bx;
    @Deprecated
    @Nullable
    GraphQLTimelineStoriesConnection by;
    @Nullable
    GraphQLProfileVideo bz;
    @Nullable
    GraphQLImage f16942d;
    @Nullable
    GraphQLStreetAddress f16943e;
    @Nullable
    GraphQLAlbumsConnection f16944f;
    @Nullable
    String f16945g;
    @Nullable
    String f16946h;
    @Nullable
    GraphQLTextWithEntities f16947i;
    @Nullable
    GraphQLFriendsConnection f16948j;
    @Nullable
    GraphQLFocusedPhoto f16949k;
    List<GraphQLBylineFragment> f16950l;
    boolean f16951m;
    boolean f16952n;
    boolean f16953o;
    public boolean f16954p;
    public boolean f16955q;
    public boolean f16956r;
    boolean f16957s;
    double f16958t;
    @Deprecated
    @Nullable
    GraphQLContact f16959u;
    @Nullable
    GraphQLFocusedPhoto f16960v;
    @Nullable
    GraphQLPage f16961w;
    @Nullable
    GraphQLUserEducationExperiencesConnection f16962x;
    List<String> f16963y;
    @Nullable
    String f16964z;

    /* compiled from: locale_last_time_synced */
    final class C07941 implements Creator<GraphQLUser> {
        C07941() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLUser(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLUser[i];
        }
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m23926j() {
        this.f16942d = (GraphQLImage) super.m9947a(this.f16942d, 0, GraphQLImage.class);
        return this.f16942d;
    }

    @FieldOffset
    @Nullable
    public final GraphQLStreetAddress m23927k() {
        this.f16943e = (GraphQLStreetAddress) super.m9947a(this.f16943e, 1, GraphQLStreetAddress.class);
        return this.f16943e;
    }

    @FieldOffset
    @Nullable
    public final GraphQLAlbumsConnection m23928l() {
        this.f16944f = (GraphQLAlbumsConnection) super.m9947a(this.f16944f, 2, GraphQLAlbumsConnection.class);
        return this.f16944f;
    }

    @FieldOffset
    @Nullable
    public final String m23929m() {
        this.f16945g = super.m9948a(this.f16945g, 4);
        return this.f16945g;
    }

    @FieldOffset
    @Nullable
    public final String m23930n() {
        this.f16946h = super.m9948a(this.f16946h, 5);
        return this.f16946h;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities m23931o() {
        this.f16947i = (GraphQLTextWithEntities) super.m9947a(this.f16947i, 6, GraphQLTextWithEntities.class);
        return this.f16947i;
    }

    @FieldOffset
    @Nullable
    public final GraphQLFriendsConnection m23932p() {
        this.f16948j = (GraphQLFriendsConnection) super.m9947a(this.f16948j, 7, GraphQLFriendsConnection.class);
        return this.f16948j;
    }

    @FieldOffset
    @Nullable
    public final GraphQLFocusedPhoto m23933q() {
        this.f16949k = (GraphQLFocusedPhoto) super.m9947a(this.f16949k, 8, GraphQLFocusedPhoto.class);
        return this.f16949k;
    }

    @FieldOffset
    public final ImmutableList<GraphQLBylineFragment> m23934r() {
        this.f16950l = super.m9944a(this.f16950l, 9, GraphQLBylineFragment.class);
        return (ImmutableList) this.f16950l;
    }

    @FieldOffset
    public final boolean m23935s() {
        m9949a(1, 2);
        return this.f16951m;
    }

    @FieldOffset
    public final boolean m23936t() {
        m9949a(1, 3);
        return this.f16952n;
    }

    @FieldOffset
    public final boolean m23937u() {
        m9949a(1, 4);
        return this.f16953o;
    }

    @FieldOffset
    public final boolean m23938v() {
        m9949a(1, 5);
        return this.f16954p;
    }

    @FieldOffset
    public final boolean m23939w() {
        m9949a(1, 6);
        return this.f16955q;
    }

    @FieldOffset
    public final boolean m23940x() {
        m9949a(1, 7);
        return this.f16956r;
    }

    @FieldOffset
    public final boolean m23941y() {
        m9949a(2, 0);
        return this.f16957s;
    }

    @FieldOffset
    public final double m23942z() {
        m9949a(2, 1);
        return this.f16958t;
    }

    @FieldOffset
    @Nullable
    public final GraphQLContact m23894A() {
        this.f16959u = (GraphQLContact) super.m9947a(this.f16959u, 18, GraphQLContact.class);
        return this.f16959u;
    }

    @FieldOffset
    @Nullable
    public final GraphQLFocusedPhoto m23895B() {
        this.f16960v = (GraphQLFocusedPhoto) super.m9947a(this.f16960v, 19, GraphQLFocusedPhoto.class);
        return this.f16960v;
    }

    @FieldOffset
    @Nullable
    public final GraphQLPage m23896C() {
        this.f16961w = (GraphQLPage) super.m9947a(this.f16961w, 20, GraphQLPage.class);
        return this.f16961w;
    }

    @FieldOffset
    @Nullable
    public final GraphQLUserEducationExperiencesConnection m23897D() {
        this.f16962x = (GraphQLUserEducationExperiencesConnection) super.m9947a(this.f16962x, 21, GraphQLUserEducationExperiencesConnection.class);
        return this.f16962x;
    }

    @FieldOffset
    public final ImmutableList<String> m23898E() {
        this.f16963y = super.m9943a(this.f16963y, 22);
        return (ImmutableList) this.f16963y;
    }

    @FieldOffset
    @Nullable
    public final String m23899F() {
        this.f16964z = super.m9948a(this.f16964z, 23);
        return this.f16964z;
    }

    @FieldOffset
    @Nullable
    public final GraphQLEventsConnection m23900G() {
        this.f16916A = (GraphQLEventsConnection) super.m9947a(this.f16916A, 24, GraphQLEventsConnection.class);
        return this.f16916A;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m23901H() {
        this.f16917B = (GraphQLImage) super.m9947a(this.f16917B, 26, GraphQLImage.class);
        return this.f16917B;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTimelineSectionsConnection m23902I() {
        this.f16918C = (GraphQLTimelineSectionsConnection) super.m9947a(this.f16918C, 27, GraphQLTimelineSectionsConnection.class);
        return this.f16918C;
    }

    @FieldOffset
    @Nullable
    public final String m23903J() {
        this.f16919D = super.m9948a(this.f16919D, 28);
        return this.f16919D;
    }

    @FieldOffset
    @Nullable
    public final GraphQLFollowUpFeedUnitsConnection m23904K() {
        this.f16920E = (GraphQLFollowUpFeedUnitsConnection) super.m9947a(this.f16920E, 29, GraphQLFollowUpFeedUnitsConnection.class);
        return this.f16920E;
    }

    @FieldOffset
    @Nullable
    public final GraphQLFriendsConnection m23905L() {
        this.f16921F = (GraphQLFriendsConnection) super.m9947a(this.f16921F, 30, GraphQLFriendsConnection.class);
        return this.f16921F;
    }

    @FieldOffset
    public final GraphQLFriendshipStatus m23906M() {
        this.f16922G = (GraphQLFriendshipStatus) super.m9945a(this.f16922G, 31, GraphQLFriendshipStatus.class, GraphQLFriendshipStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
        return this.f16922G;
    }

    @FieldOffset
    public final GraphQLGender m23907N() {
        this.f16923H = (GraphQLGender) super.m9945a(this.f16923H, 32, GraphQLGender.class, GraphQLGender.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
        return this.f16923H;
    }

    @FieldOffset
    @Nullable
    public final GraphQLPage m23908O() {
        this.f16924I = (GraphQLPage) super.m9947a(this.f16924I, 34, GraphQLPage.class);
        return this.f16924I;
    }

    @FieldOffset
    @Nullable
    public final String m23909P() {
        this.f16925J = super.m9948a(this.f16925J, 35);
        return this.f16925J;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m23910Q() {
        this.f16926K = (GraphQLImage) super.m9947a(this.f16926K, 36, GraphQLImage.class);
        return this.f16926K;
    }

    @FieldOffset
    @Nullable
    public final GraphQLInlineActivitiesConnection m23911R() {
        this.f16927L = (GraphQLInlineActivitiesConnection) super.m9947a(this.f16927L, 37, GraphQLInlineActivitiesConnection.class);
        return this.f16927L;
    }

    @FieldOffset
    public final boolean m23912S() {
        m9949a(4, 6);
        return this.f16928M;
    }

    @FieldOffset
    public final boolean m23913T() {
        m9949a(4, 7);
        return this.f16929N;
    }

    @FieldOffset
    public final boolean m23914U() {
        m9949a(5, 0);
        return this.f16930O;
    }

    @FieldOffset
    public final boolean m23915V() {
        m9949a(5, 1);
        return this.f16931P;
    }

    @FieldOffset
    public final boolean m23916W() {
        m9949a(5, 2);
        return this.f16932Q;
    }

    @FieldOffset
    public final boolean m23917X() {
        m9949a(5, 3);
        return this.f16933R;
    }

    @FieldOffset
    public final boolean m23918Y() {
        m9949a(5, 4);
        return this.f16934S;
    }

    @FieldOffset
    public final boolean m23919Z() {
        m9949a(5, 5);
        return this.f16935T;
    }

    @FieldOffset
    public final boolean aa() {
        m9949a(5, 6);
        return this.f16936U;
    }

    @FieldOffset
    public final boolean ab() {
        m9949a(5, 7);
        return this.f16937V;
    }

    @FieldOffset
    public final boolean ac() {
        m9949a(6, 0);
        return this.f16938W;
    }

    @FieldOffset
    public final boolean ad() {
        m9949a(6, 1);
        return this.f16939X;
    }

    @FieldOffset
    public final boolean ae() {
        m9949a(6, 2);
        return this.f16940Y;
    }

    @FieldOffset
    public final boolean af() {
        m9949a(6, 3);
        return this.f16941Z;
    }

    @FieldOffset
    public final boolean ag() {
        m9949a(6, 4);
        return this.aa;
    }

    @FieldOffset
    public final boolean ah() {
        m9949a(6, 5);
        return this.ab;
    }

    @FieldOffset
    public final boolean ai() {
        m9949a(6, 6);
        return this.ac;
    }

    @FieldOffset
    @Nullable
    public final GraphQLLikedProfilesConnection aj() {
        this.ad = (GraphQLLikedProfilesConnection) super.m9947a(this.ad, 55, GraphQLLikedProfilesConnection.class);
        return this.ad;
    }

    @FieldOffset
    public final GraphQLLiveVideoSubscriptionStatus ak() {
        this.ae = (GraphQLLiveVideoSubscriptionStatus) super.m9945a(this.ae, 56, GraphQLLiveVideoSubscriptionStatus.class, GraphQLLiveVideoSubscriptionStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
        return this.ae;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage al() {
        this.af = (GraphQLImage) super.m9947a(this.af, 57, GraphQLImage.class);
        return this.af;
    }

    @FieldOffset
    @Nullable
    public final GraphQLContact am() {
        this.ag = (GraphQLContact) super.m9947a(this.ag, 58, GraphQLContact.class);
        return this.ag;
    }

    @FieldOffset
    public final long an() {
        m9949a(7, 3);
        return this.ah;
    }

    @FieldOffset
    public final double ao() {
        m9949a(7, 4);
        return this.ai;
    }

    @FieldOffset
    @Nullable
    public final String ap() {
        this.aj = super.m9948a(this.aj, 61);
        return this.aj;
    }

    @FieldOffset
    @Nullable
    public final GraphQLMutualFriendsConnection aq() {
        this.ak = (GraphQLMutualFriendsConnection) super.m9947a(this.ak, 62, GraphQLMutualFriendsConnection.class);
        return this.ak;
    }

    @FieldOffset
    @Nullable
    public final String ar() {
        this.al = super.m9948a(this.al, 63);
        return this.al;
    }

    @FieldOffset
    public final ImmutableList<String> as() {
        this.am = super.m9943a(this.am, 64);
        return (ImmutableList) this.am;
    }

    @FieldOffset
    @Nullable
    public final GraphQLNewsFeedConnection at() {
        this.an = (GraphQLNewsFeedConnection) super.m9947a(this.an, 65, GraphQLNewsFeedConnection.class);
        return this.an;
    }

    @FieldOffset
    @Nullable
    public final GraphQLPrivacyScope au() {
        this.ao = (GraphQLPrivacyScope) super.m9947a(this.ao, 66, GraphQLPrivacyScope.class);
        return this.ao;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage av() {
        this.ap = (GraphQLImage) super.m9947a(this.ap, 67, GraphQLImage.class);
        return this.ap;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage aw() {
        this.aq = (GraphQLImage) super.m9947a(this.aq, 68, GraphQLImage.class);
        return this.aq;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage ax() {
        this.ar = (GraphQLImage) super.m9947a(this.ar, 69, GraphQLImage.class);
        return this.ar;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage ay() {
        this.as = (GraphQLImage) super.m9947a(this.as, 70, GraphQLImage.class);
        return this.as;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage az() {
        this.at = (GraphQLImage) super.m9947a(this.at, 71, GraphQLImage.class);
        return this.at;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage aA() {
        this.au = (GraphQLImage) super.m9947a(this.au, 72, GraphQLImage.class);
        return this.au;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage aB() {
        this.av = (GraphQLImage) super.m9947a(this.av, 73, GraphQLImage.class);
        return this.av;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage aC() {
        this.aw = (GraphQLImage) super.m9947a(this.aw, 74, GraphQLImage.class);
        return this.aw;
    }

    @FieldOffset
    @Nullable
    public final GraphQLProfileBadge aD() {
        this.ax = (GraphQLProfileBadge) super.m9947a(this.ax, 75, GraphQLProfileBadge.class);
        return this.ax;
    }

    @FieldOffset
    @Nullable
    public final GraphQLPhoto aE() {
        this.ay = (GraphQLPhoto) super.m9947a(this.ay, 76, GraphQLPhoto.class);
        return this.ay;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage aF() {
        this.az = (GraphQLImage) super.m9947a(this.az, 77, GraphQLImage.class);
        return this.az;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage aG() {
        this.aA = (GraphQLImage) super.m9947a(this.aA, 78, GraphQLImage.class);
        return this.aA;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage aH() {
        this.aB = (GraphQLImage) super.m9947a(this.aB, 79, GraphQLImage.class);
        return this.aB;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage aI() {
        this.aC = (GraphQLImage) super.m9947a(this.aC, 80, GraphQLImage.class);
        return this.aC;
    }

    @FieldOffset
    public final long aJ() {
        m9949a(10, 1);
        return this.aD;
    }

    @FieldOffset
    public final boolean aK() {
        m9949a(10, 2);
        return this.aE;
    }

    @FieldOffset
    @Nullable
    public final String aL() {
        this.aF = super.m9948a(this.aF, 83);
        return this.aF;
    }

    @FieldOffset
    public final long aM() {
        m9949a(10, 4);
        return this.aG;
    }

    @FieldOffset
    @Nullable
    public final String aN() {
        this.aH = super.m9948a(this.aH, 86);
        return this.aH;
    }

    @FieldOffset
    @Nullable
    public final String aO() {
        this.aI = super.m9948a(this.aI, 87);
        return this.aI;
    }

    @FieldOffset
    public final GraphQLSecondarySubscribeStatus aP() {
        this.aJ = (GraphQLSecondarySubscribeStatus) super.m9945a(this.aJ, 88, GraphQLSecondarySubscribeStatus.class, GraphQLSecondarySubscribeStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
        return this.aJ;
    }

    @FieldOffset
    @Nullable
    public final String aQ() {
        this.aK = super.m9948a(this.aK, 89);
        return this.aK;
    }

    @FieldOffset
    @Nullable
    public final GraphQLSinglePublisherVideoChannelsConnection aR() {
        this.aL = (GraphQLSinglePublisherVideoChannelsConnection) super.m9947a(this.aL, 90, GraphQLSinglePublisherVideoChannelsConnection.class);
        return this.aL;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities aS() {
        this.aM = (GraphQLTextWithEntities) super.m9947a(this.aM, 91, GraphQLTextWithEntities.class);
        return this.aM;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage aT() {
        this.aN = (GraphQLImage) super.m9947a(this.aN, 92, GraphQLImage.class);
        return this.aN;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage aU() {
        this.aO = (GraphQLImage) super.m9947a(this.aO, 93, GraphQLImage.class);
        return this.aO;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage aV() {
        this.aP = (GraphQLImage) super.m9947a(this.aP, 94, GraphQLImage.class);
        return this.aP;
    }

    @FieldOffset
    @Nullable
    public final GraphQLStreamingImage aW() {
        this.aQ = (GraphQLStreamingImage) super.m9947a(this.aQ, 95, GraphQLStreamingImage.class);
        return this.aQ;
    }

    @FieldOffset
    @Nullable
    public final GraphQLName aX() {
        this.aR = (GraphQLName) super.m9947a(this.aR, 96, GraphQLName.class);
        return this.aR;
    }

    @FieldOffset
    public final ImmutableList<GraphQLName> aY() {
        this.aS = super.m9944a(this.aS, 97, GraphQLName.class);
        return (ImmutableList) this.aS;
    }

    @FieldOffset
    public final GraphQLSubscribeStatus aZ() {
        this.aT = (GraphQLSubscribeStatus) super.m9945a(this.aT, 98, GraphQLSubscribeStatus.class, GraphQLSubscribeStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
        return this.aT;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage ba() {
        this.aU = (GraphQLImage) super.m9947a(this.aU, 99, GraphQLImage.class);
        return this.aU;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities bb() {
        this.aV = (GraphQLTextWithEntities) super.m9947a(this.aV, 100, GraphQLTextWithEntities.class);
        return this.aV;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTimelineSectionsConnection bc() {
        this.aW = (GraphQLTimelineSectionsConnection) super.m9947a(this.aW, 101, GraphQLTimelineSectionsConnection.class);
        return this.aW;
    }

    @FieldOffset
    public final int bd() {
        m9949a(12, 6);
        return this.aX;
    }

    @FieldOffset
    @Nullable
    public final GraphQLUnseenStoriesConnection be() {
        this.aY = (GraphQLUnseenStoriesConnection) super.m9947a(this.aY, 103, GraphQLUnseenStoriesConnection.class);
        return this.aY;
    }

    @FieldOffset
    @Nullable
    public final String bf() {
        this.aZ = super.m9948a(this.aZ, 104);
        return this.aZ;
    }

    @FieldOffset
    @Nullable
    public final String bg() {
        this.ba = super.m9948a(this.ba, 105);
        return this.ba;
    }

    @FieldOffset
    public final boolean bh() {
        m9949a(13, 2);
        return this.bb;
    }

    @FieldOffset
    public final boolean bi() {
        m9949a(13, 3);
        return this.bc;
    }

    @FieldOffset
    @Nullable
    public final GraphQLProfile bj() {
        this.bd = (GraphQLProfile) super.m9947a(this.bd, 108, GraphQLProfile.class);
        return this.bd;
    }

    @FieldOffset
    public final boolean bk() {
        m9949a(13, 5);
        return this.be;
    }

    @FieldOffset
    public final boolean bl() {
        m9949a(13, 6);
        return this.bf;
    }

    @FieldOffset
    public final boolean bm() {
        m9949a(13, 7);
        return this.bg;
    }

    @FieldOffset
    public final boolean bn() {
        m9949a(14, 0);
        return this.bh;
    }

    @FieldOffset
    public final int bo() {
        m9949a(14, 1);
        return this.bi;
    }

    @FieldOffset
    public final int bp() {
        m9949a(14, 2);
        return this.bj;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities bq() {
        this.bk = (GraphQLTextWithEntities) super.m9947a(this.bk, 115, GraphQLTextWithEntities.class);
        return this.bk;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities br() {
        this.bl = (GraphQLTextWithEntities) super.m9947a(this.bl, 116, GraphQLTextWithEntities.class);
        return this.bl;
    }

    @FieldOffset
    public final double bs() {
        m9949a(14, 5);
        return this.bm;
    }

    @FieldOffset
    public final ImmutableList<String> bt() {
        this.bn = super.m9943a(this.bn, 119);
        return (ImmutableList) this.bn;
    }

    @FieldOffset
    public final double bu() {
        m9949a(15, 0);
        return this.bo;
    }

    @FieldOffset
    @Nullable
    public final GraphQLUserWorkExperiencesConnection bv() {
        this.bp = (GraphQLUserWorkExperiencesConnection) super.m9947a(this.bp, 121, GraphQLUserWorkExperiencesConnection.class);
        return this.bp;
    }

    @FieldOffset
    public final long bw() {
        m9949a(15, 2);
        return this.bq;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage bx() {
        this.br = (GraphQLImage) super.m9947a(this.br, 123, GraphQLImage.class);
        return this.br;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage by() {
        this.bs = (GraphQLImage) super.m9947a(this.bs, 124, GraphQLImage.class);
        return this.bs;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage bz() {
        this.bt = (GraphQLImage) super.m9947a(this.bt, 125, GraphQLImage.class);
        return this.bt;
    }

    @FieldOffset
    public final int bA() {
        m9949a(15, 6);
        return this.bu;
    }

    @FieldOffset
    @Nullable
    public final String bB() {
        this.bv = super.m9948a(this.bv, 127);
        return this.bv;
    }

    @FieldOffset
    public final boolean bC() {
        m9949a(16, 0);
        return this.bw;
    }

    @FieldOffset
    public final boolean bD() {
        m9949a(16, 3);
        return this.bx;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTimelineStoriesConnection bE() {
        this.by = (GraphQLTimelineStoriesConnection) super.m9947a(this.by, 132, GraphQLTimelineStoriesConnection.class);
        return this.by;
    }

    @FieldOffset
    @Nullable
    public final GraphQLProfileVideo bF() {
        this.bz = (GraphQLProfileVideo) super.m9947a(this.bz, 133, GraphQLProfileVideo.class);
        return this.bz;
    }

    @Nullable
    public final String mo2834a() {
        return m23909P();
    }

    public final int jK_() {
        return 2645995;
    }

    public final GraphQLVisitableModel mo1404a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLImage graphQLImage;
        GraphQLTextWithEntities graphQLTextWithEntities;
        GraphQLFriendsConnection graphQLFriendsConnection;
        GraphQLFocusedPhoto graphQLFocusedPhoto;
        Builder a;
        GraphQLContact graphQLContact;
        GraphQLPage graphQLPage;
        GraphQLTimelineSectionsConnection graphQLTimelineSectionsConnection;
        GraphQLVisitableModel graphQLVisitableModel = null;
        m9958h();
        if (m23926j() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(m23926j());
            if (m23926j() != graphQLImage) {
                graphQLVisitableModel = (GraphQLUser) ModelHelper.m23095a(null, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16942d = graphQLImage;
            }
        }
        if (m23927k() != null) {
            GraphQLStreetAddress graphQLStreetAddress = (GraphQLStreetAddress) graphQLModelMutatingVisitor.mo2928b(m23927k());
            if (m23927k() != graphQLStreetAddress) {
                graphQLVisitableModel = (GraphQLUser) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16943e = graphQLStreetAddress;
            }
        }
        if (bx() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(bx());
            if (bx() != graphQLImage) {
                graphQLVisitableModel = (GraphQLUser) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.br = graphQLImage;
            }
        }
        if (m23928l() != null) {
            GraphQLAlbumsConnection graphQLAlbumsConnection = (GraphQLAlbumsConnection) graphQLModelMutatingVisitor.mo2928b(m23928l());
            if (m23928l() != graphQLAlbumsConnection) {
                graphQLVisitableModel = (GraphQLUser) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16944f = graphQLAlbumsConnection;
            }
        }
        if (by() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(by());
            if (by() != graphQLImage) {
                graphQLVisitableModel = (GraphQLUser) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.bs = graphQLImage;
            }
        }
        if (m23931o() != null) {
            graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.mo2928b(m23931o());
            if (m23931o() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLUser) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16947i = graphQLTextWithEntities;
            }
        }
        if (m23932p() != null) {
            graphQLFriendsConnection = (GraphQLFriendsConnection) graphQLModelMutatingVisitor.mo2928b(m23932p());
            if (m23932p() != graphQLFriendsConnection) {
                graphQLVisitableModel = (GraphQLUser) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16948j = graphQLFriendsConnection;
            }
        }
        if (m23933q() != null) {
            graphQLFocusedPhoto = (GraphQLFocusedPhoto) graphQLModelMutatingVisitor.mo2928b(m23933q());
            if (m23933q() != graphQLFocusedPhoto) {
                graphQLVisitableModel = (GraphQLUser) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16949k = graphQLFocusedPhoto;
            }
        }
        if (m23934r() != null) {
            a = ModelHelper.m23097a(m23934r(), graphQLModelMutatingVisitor);
            if (a != null) {
                GraphQLUser graphQLUser = (GraphQLUser) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLUser.f16950l = a.m1068b();
                graphQLVisitableModel = graphQLUser;
            }
        }
        if (m23894A() != null) {
            graphQLContact = (GraphQLContact) graphQLModelMutatingVisitor.mo2928b(m23894A());
            if (m23894A() != graphQLContact) {
                graphQLVisitableModel = (GraphQLUser) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16959u = graphQLContact;
            }
        }
        if (m23895B() != null) {
            graphQLFocusedPhoto = (GraphQLFocusedPhoto) graphQLModelMutatingVisitor.mo2928b(m23895B());
            if (m23895B() != graphQLFocusedPhoto) {
                graphQLVisitableModel = (GraphQLUser) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16960v = graphQLFocusedPhoto;
            }
        }
        if (m23896C() != null) {
            graphQLPage = (GraphQLPage) graphQLModelMutatingVisitor.mo2928b(m23896C());
            if (m23896C() != graphQLPage) {
                graphQLVisitableModel = (GraphQLUser) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16961w = graphQLPage;
            }
        }
        if (m23897D() != null) {
            GraphQLUserEducationExperiencesConnection graphQLUserEducationExperiencesConnection = (GraphQLUserEducationExperiencesConnection) graphQLModelMutatingVisitor.mo2928b(m23897D());
            if (m23897D() != graphQLUserEducationExperiencesConnection) {
                graphQLVisitableModel = (GraphQLUser) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16962x = graphQLUserEducationExperiencesConnection;
            }
        }
        if (m23900G() != null) {
            GraphQLEventsConnection graphQLEventsConnection = (GraphQLEventsConnection) graphQLModelMutatingVisitor.mo2928b(m23900G());
            if (m23900G() != graphQLEventsConnection) {
                graphQLVisitableModel = (GraphQLUser) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16916A = graphQLEventsConnection;
            }
        }
        if (m23901H() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(m23901H());
            if (m23901H() != graphQLImage) {
                graphQLVisitableModel = (GraphQLUser) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16917B = graphQLImage;
            }
        }
        if (m23902I() != null) {
            graphQLTimelineSectionsConnection = (GraphQLTimelineSectionsConnection) graphQLModelMutatingVisitor.mo2928b(m23902I());
            if (m23902I() != graphQLTimelineSectionsConnection) {
                graphQLVisitableModel = (GraphQLUser) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16918C = graphQLTimelineSectionsConnection;
            }
        }
        if (m23904K() != null) {
            GraphQLFollowUpFeedUnitsConnection graphQLFollowUpFeedUnitsConnection = (GraphQLFollowUpFeedUnitsConnection) graphQLModelMutatingVisitor.mo2928b(m23904K());
            if (m23904K() != graphQLFollowUpFeedUnitsConnection) {
                graphQLVisitableModel = (GraphQLUser) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16920E = graphQLFollowUpFeedUnitsConnection;
            }
        }
        if (m23905L() != null) {
            graphQLFriendsConnection = (GraphQLFriendsConnection) graphQLModelMutatingVisitor.mo2928b(m23905L());
            if (m23905L() != graphQLFriendsConnection) {
                graphQLVisitableModel = (GraphQLUser) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16921F = graphQLFriendsConnection;
            }
        }
        if (m23908O() != null) {
            graphQLPage = (GraphQLPage) graphQLModelMutatingVisitor.mo2928b(m23908O());
            if (m23908O() != graphQLPage) {
                graphQLVisitableModel = (GraphQLUser) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16924I = graphQLPage;
            }
        }
        if (m23910Q() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(m23910Q());
            if (m23910Q() != graphQLImage) {
                graphQLVisitableModel = (GraphQLUser) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16926K = graphQLImage;
            }
        }
        if (m23911R() != null) {
            GraphQLInlineActivitiesConnection graphQLInlineActivitiesConnection = (GraphQLInlineActivitiesConnection) graphQLModelMutatingVisitor.mo2928b(m23911R());
            if (m23911R() != graphQLInlineActivitiesConnection) {
                graphQLVisitableModel = (GraphQLUser) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16927L = graphQLInlineActivitiesConnection;
            }
        }
        if (aj() != null) {
            GraphQLLikedProfilesConnection graphQLLikedProfilesConnection = (GraphQLLikedProfilesConnection) graphQLModelMutatingVisitor.mo2928b(aj());
            if (aj() != graphQLLikedProfilesConnection) {
                graphQLVisitableModel = (GraphQLUser) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.ad = graphQLLikedProfilesConnection;
            }
        }
        if (al() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(al());
            if (al() != graphQLImage) {
                graphQLVisitableModel = (GraphQLUser) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.af = graphQLImage;
            }
        }
        if (am() != null) {
            graphQLContact = (GraphQLContact) graphQLModelMutatingVisitor.mo2928b(am());
            if (am() != graphQLContact) {
                graphQLVisitableModel = (GraphQLUser) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.ag = graphQLContact;
            }
        }
        if (aq() != null) {
            GraphQLMutualFriendsConnection graphQLMutualFriendsConnection = (GraphQLMutualFriendsConnection) graphQLModelMutatingVisitor.mo2928b(aq());
            if (aq() != graphQLMutualFriendsConnection) {
                graphQLVisitableModel = (GraphQLUser) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.ak = graphQLMutualFriendsConnection;
            }
        }
        if (at() != null) {
            GraphQLNewsFeedConnection graphQLNewsFeedConnection = (GraphQLNewsFeedConnection) graphQLModelMutatingVisitor.mo2928b(at());
            if (at() != graphQLNewsFeedConnection) {
                graphQLVisitableModel = (GraphQLUser) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.an = graphQLNewsFeedConnection;
            }
        }
        if (au() != null) {
            GraphQLPrivacyScope graphQLPrivacyScope = (GraphQLPrivacyScope) graphQLModelMutatingVisitor.mo2928b(au());
            if (au() != graphQLPrivacyScope) {
                graphQLVisitableModel = (GraphQLUser) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.ao = graphQLPrivacyScope;
            }
        }
        if (av() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(av());
            if (av() != graphQLImage) {
                graphQLVisitableModel = (GraphQLUser) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.ap = graphQLImage;
            }
        }
        if (aw() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(aw());
            if (aw() != graphQLImage) {
                graphQLVisitableModel = (GraphQLUser) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.aq = graphQLImage;
            }
        }
        if (ax() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(ax());
            if (ax() != graphQLImage) {
                graphQLVisitableModel = (GraphQLUser) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.ar = graphQLImage;
            }
        }
        if (ay() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(ay());
            if (ay() != graphQLImage) {
                graphQLVisitableModel = (GraphQLUser) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.as = graphQLImage;
            }
        }
        if (az() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(az());
            if (az() != graphQLImage) {
                graphQLVisitableModel = (GraphQLUser) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.at = graphQLImage;
            }
        }
        if (aA() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(aA());
            if (aA() != graphQLImage) {
                graphQLVisitableModel = (GraphQLUser) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.au = graphQLImage;
            }
        }
        if (aB() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(aB());
            if (aB() != graphQLImage) {
                graphQLVisitableModel = (GraphQLUser) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.av = graphQLImage;
            }
        }
        if (aC() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(aC());
            if (aC() != graphQLImage) {
                graphQLVisitableModel = (GraphQLUser) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.aw = graphQLImage;
            }
        }
        if (aD() != null) {
            GraphQLProfileBadge graphQLProfileBadge = (GraphQLProfileBadge) graphQLModelMutatingVisitor.mo2928b(aD());
            if (aD() != graphQLProfileBadge) {
                graphQLVisitableModel = (GraphQLUser) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.ax = graphQLProfileBadge;
            }
        }
        if (aE() != null) {
            GraphQLPhoto graphQLPhoto = (GraphQLPhoto) graphQLModelMutatingVisitor.mo2928b(aE());
            if (aE() != graphQLPhoto) {
                graphQLVisitableModel = (GraphQLUser) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.ay = graphQLPhoto;
            }
        }
        if (aF() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(aF());
            if (aF() != graphQLImage) {
                graphQLVisitableModel = (GraphQLUser) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.az = graphQLImage;
            }
        }
        if (aG() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(aG());
            if (aG() != graphQLImage) {
                graphQLVisitableModel = (GraphQLUser) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.aA = graphQLImage;
            }
        }
        if (aH() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(aH());
            if (aH() != graphQLImage) {
                graphQLVisitableModel = (GraphQLUser) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.aB = graphQLImage;
            }
        }
        if (aI() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(aI());
            if (aI() != graphQLImage) {
                graphQLVisitableModel = (GraphQLUser) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.aC = graphQLImage;
            }
        }
        if (bF() != null) {
            GraphQLProfileVideo graphQLProfileVideo = (GraphQLProfileVideo) graphQLModelMutatingVisitor.mo2928b(bF());
            if (bF() != graphQLProfileVideo) {
                graphQLVisitableModel = (GraphQLUser) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.bz = graphQLProfileVideo;
            }
        }
        if (aR() != null) {
            GraphQLSinglePublisherVideoChannelsConnection graphQLSinglePublisherVideoChannelsConnection = (GraphQLSinglePublisherVideoChannelsConnection) graphQLModelMutatingVisitor.mo2928b(aR());
            if (aR() != graphQLSinglePublisherVideoChannelsConnection) {
                graphQLVisitableModel = (GraphQLUser) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.aL = graphQLSinglePublisherVideoChannelsConnection;
            }
        }
        if (aS() != null) {
            graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.mo2928b(aS());
            if (aS() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLUser) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.aM = graphQLTextWithEntities;
            }
        }
        if (aT() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(aT());
            if (aT() != graphQLImage) {
                graphQLVisitableModel = (GraphQLUser) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.aN = graphQLImage;
            }
        }
        if (aU() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(aU());
            if (aU() != graphQLImage) {
                graphQLVisitableModel = (GraphQLUser) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.aO = graphQLImage;
            }
        }
        if (aV() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(aV());
            if (aV() != graphQLImage) {
                graphQLVisitableModel = (GraphQLUser) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.aP = graphQLImage;
            }
        }
        if (aW() != null) {
            GraphQLStreamingImage graphQLStreamingImage = (GraphQLStreamingImage) graphQLModelMutatingVisitor.mo2928b(aW());
            if (aW() != graphQLStreamingImage) {
                graphQLVisitableModel = (GraphQLUser) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.aQ = graphQLStreamingImage;
            }
        }
        if (aX() != null) {
            GraphQLName graphQLName = (GraphQLName) graphQLModelMutatingVisitor.mo2928b(aX());
            if (aX() != graphQLName) {
                graphQLVisitableModel = (GraphQLUser) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.aR = graphQLName;
            }
        }
        if (aY() != null) {
            a = ModelHelper.m23097a(aY(), graphQLModelMutatingVisitor);
            if (a != null) {
                graphQLUser = (GraphQLUser) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLUser.aS = a.m1068b();
                graphQLVisitableModel = graphQLUser;
            }
        }
        if (ba() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(ba());
            if (ba() != graphQLImage) {
                graphQLVisitableModel = (GraphQLUser) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.aU = graphQLImage;
            }
        }
        if (bb() != null) {
            graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.mo2928b(bb());
            if (bb() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLUser) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.aV = graphQLTextWithEntities;
            }
        }
        if (bc() != null) {
            graphQLTimelineSectionsConnection = (GraphQLTimelineSectionsConnection) graphQLModelMutatingVisitor.mo2928b(bc());
            if (bc() != graphQLTimelineSectionsConnection) {
                graphQLVisitableModel = (GraphQLUser) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.aW = graphQLTimelineSectionsConnection;
            }
        }
        if (bE() != null) {
            GraphQLTimelineStoriesConnection graphQLTimelineStoriesConnection = (GraphQLTimelineStoriesConnection) graphQLModelMutatingVisitor.mo2928b(bE());
            if (bE() != graphQLTimelineStoriesConnection) {
                graphQLVisitableModel = (GraphQLUser) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.by = graphQLTimelineStoriesConnection;
            }
        }
        if (bz() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(bz());
            if (bz() != graphQLImage) {
                graphQLVisitableModel = (GraphQLUser) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.bt = graphQLImage;
            }
        }
        if (be() != null) {
            GraphQLUnseenStoriesConnection graphQLUnseenStoriesConnection = (GraphQLUnseenStoriesConnection) graphQLModelMutatingVisitor.mo2928b(be());
            if (be() != graphQLUnseenStoriesConnection) {
                graphQLVisitableModel = (GraphQLUser) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.aY = graphQLUnseenStoriesConnection;
            }
        }
        if (bj() != null) {
            GraphQLProfile graphQLProfile = (GraphQLProfile) graphQLModelMutatingVisitor.mo2928b(bj());
            if (bj() != graphQLProfile) {
                graphQLVisitableModel = (GraphQLUser) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.bd = graphQLProfile;
            }
        }
        if (bq() != null) {
            graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.mo2928b(bq());
            if (bq() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLUser) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.bk = graphQLTextWithEntities;
            }
        }
        if (br() != null) {
            graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.mo2928b(br());
            if (br() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLUser) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.bl = graphQLTextWithEntities;
            }
        }
        if (bv() != null) {
            GraphQLUserWorkExperiencesConnection graphQLUserWorkExperiencesConnection = (GraphQLUserWorkExperiencesConnection) graphQLModelMutatingVisitor.mo2928b(bv());
            if (bv() != graphQLUserWorkExperiencesConnection) {
                graphQLVisitableModel = (GraphQLUser) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.bp = graphQLUserWorkExperiencesConnection;
            }
        }
        m9959i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public final void mo2835a(String str, ConsistencyTuple consistencyTuple) {
        if ("can_viewer_message".equals(str)) {
            consistencyTuple.f18727a = Boolean.valueOf(m23938v());
            consistencyTuple.f18728b = u_();
            consistencyTuple.f18729c = 13;
        } else if ("can_viewer_poke".equals(str)) {
            consistencyTuple.f18727a = Boolean.valueOf(m23939w());
            consistencyTuple.f18728b = u_();
            consistencyTuple.f18729c = 14;
        } else if ("can_viewer_post".equals(str)) {
            consistencyTuple.f18727a = Boolean.valueOf(m23940x());
            consistencyTuple.f18728b = u_();
            consistencyTuple.f18729c = 15;
        } else if ("friendship_status".equals(str)) {
            consistencyTuple.f18727a = m23906M();
            consistencyTuple.f18728b = u_();
            consistencyTuple.f18729c = 31;
        } else if ("is_pymm_hidden".equals(str)) {
            consistencyTuple.f18727a = Boolean.valueOf(ac());
            consistencyTuple.f18728b = u_();
            consistencyTuple.f18729c = 48;
        } else if ("secondary_subscribe_status".equals(str)) {
            consistencyTuple.f18727a = aP();
            consistencyTuple.f18728b = u_();
            consistencyTuple.f18729c = 88;
        } else if ("subscribe_status".equals(str)) {
            consistencyTuple.f18727a = aZ();
            consistencyTuple.f18728b = u_();
            consistencyTuple.f18729c = 98;
        } else if ("username".equals(str)) {
            consistencyTuple.f18727a = bg();
            consistencyTuple.f18728b = u_();
            consistencyTuple.f18729c = 105;
        } else if ("video_channel_has_viewer_subscribed".equals(str)) {
            consistencyTuple.f18727a = Boolean.valueOf(bl());
            consistencyTuple.f18728b = u_();
            consistencyTuple.f18729c = 110;
        } else if ("video_channel_is_viewer_following".equals(str)) {
            consistencyTuple.f18727a = Boolean.valueOf(bm());
            consistencyTuple.f18728b = u_();
            consistencyTuple.f18729c = 111;
        } else {
            consistencyTuple.m26322a();
        }
    }

    public final void mo2836a(String str, Object obj, boolean z) {
        boolean booleanValue;
        if ("can_viewer_message".equals(str)) {
            booleanValue = ((Boolean) obj).booleanValue();
            this.f16954p = booleanValue;
            if (this.f5823b != null && this.f5823b.f15024d) {
                this.f5823b.m21538a(this.f5824c, 13, booleanValue);
            }
        } else if ("can_viewer_poke".equals(str)) {
            booleanValue = ((Boolean) obj).booleanValue();
            this.f16955q = booleanValue;
            if (this.f5823b != null && this.f5823b.f15024d) {
                this.f5823b.m21538a(this.f5824c, 14, booleanValue);
            }
        } else if ("can_viewer_post".equals(str)) {
            booleanValue = ((Boolean) obj).booleanValue();
            this.f16956r = booleanValue;
            if (this.f5823b != null && this.f5823b.f15024d) {
                this.f5823b.m21538a(this.f5824c, 15, booleanValue);
            }
        } else if ("friendship_status".equals(str)) {
            r7 = (GraphQLFriendshipStatus) obj;
            this.f16922G = r7;
            if (this.f5823b != null && this.f5823b.f15024d) {
                this.f5823b.m21536a(this.f5824c, 31, r7);
            }
        } else if ("is_pymm_hidden".equals(str)) {
            booleanValue = ((Boolean) obj).booleanValue();
            this.f16938W = booleanValue;
            if (this.f5823b != null && this.f5823b.f15024d) {
                this.f5823b.m21538a(this.f5824c, 48, booleanValue);
            }
        } else if ("secondary_subscribe_status".equals(str)) {
            r7 = (GraphQLSecondarySubscribeStatus) obj;
            this.aJ = r7;
            if (this.f5823b != null && this.f5823b.f15024d) {
                this.f5823b.m21536a(this.f5824c, 88, r7);
            }
        } else if ("subscribe_status".equals(str)) {
            r7 = (GraphQLSubscribeStatus) obj;
            this.aT = r7;
            if (this.f5823b != null && this.f5823b.f15024d) {
                this.f5823b.m21536a(this.f5824c, 98, r7);
            }
        } else if ("username".equals(str)) {
            String str2 = (String) obj;
            this.ba = str2;
            if (this.f5823b != null && this.f5823b.f15024d) {
                this.f5823b.m21537a(this.f5824c, 105, str2);
            }
        } else if ("video_channel_has_viewer_subscribed".equals(str)) {
            booleanValue = ((Boolean) obj).booleanValue();
            this.bf = booleanValue;
            if (this.f5823b != null && this.f5823b.f15024d) {
                this.f5823b.m21538a(this.f5824c, 110, booleanValue);
            }
        } else if ("video_channel_is_viewer_following".equals(str)) {
            booleanValue = ((Boolean) obj).booleanValue();
            this.bg = booleanValue;
            if (this.f5823b != null && this.f5823b.f15024d) {
                this.f5823b.m21538a(this.f5824c, 111, booleanValue);
            }
        }
    }

    public GraphQLUser() {
        super(135);
    }

    public final void mo1406a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.mo1406a(mutableFlatBuffer, i, obj);
        this.f16951m = mutableFlatBuffer.m21540a(i, 10);
        this.f16952n = mutableFlatBuffer.m21540a(i, 11);
        this.f16953o = mutableFlatBuffer.m21540a(i, 12);
        this.f16954p = mutableFlatBuffer.m21540a(i, 13);
        this.f16955q = mutableFlatBuffer.m21540a(i, 14);
        this.f16956r = mutableFlatBuffer.m21540a(i, 15);
        this.f16957s = mutableFlatBuffer.m21540a(i, 16);
        this.f16958t = mutableFlatBuffer.m21523a(i, 17, 0.0d);
        this.f16928M = mutableFlatBuffer.m21540a(i, 38);
        this.f16929N = mutableFlatBuffer.m21540a(i, 39);
        this.f16930O = mutableFlatBuffer.m21540a(i, 40);
        this.f16931P = mutableFlatBuffer.m21540a(i, 41);
        this.f16932Q = mutableFlatBuffer.m21540a(i, 42);
        this.f16933R = mutableFlatBuffer.m21540a(i, 43);
        this.f16934S = mutableFlatBuffer.m21540a(i, 44);
        this.f16935T = mutableFlatBuffer.m21540a(i, 45);
        this.f16936U = mutableFlatBuffer.m21540a(i, 46);
        this.f16937V = mutableFlatBuffer.m21540a(i, 47);
        this.f16938W = mutableFlatBuffer.m21540a(i, 48);
        this.f16939X = mutableFlatBuffer.m21540a(i, 49);
        this.f16940Y = mutableFlatBuffer.m21540a(i, 50);
        this.f16941Z = mutableFlatBuffer.m21540a(i, 51);
        this.aa = mutableFlatBuffer.m21540a(i, 52);
        this.ab = mutableFlatBuffer.m21540a(i, 53);
        this.ac = mutableFlatBuffer.m21540a(i, 54);
        this.ah = mutableFlatBuffer.m21525a(i, 59, 0);
        this.ai = mutableFlatBuffer.m21523a(i, 60, 0.0d);
        this.aD = mutableFlatBuffer.m21525a(i, 81, 0);
        this.aE = mutableFlatBuffer.m21540a(i, 82);
        this.aG = mutableFlatBuffer.m21525a(i, 84, 0);
        this.aX = mutableFlatBuffer.m21524a(i, 102, 0);
        this.bb = mutableFlatBuffer.m21540a(i, 106);
        this.bc = mutableFlatBuffer.m21540a(i, 107);
        this.be = mutableFlatBuffer.m21540a(i, 109);
        this.bf = mutableFlatBuffer.m21540a(i, 110);
        this.bg = mutableFlatBuffer.m21540a(i, 111);
        this.bh = mutableFlatBuffer.m21540a(i, 112);
        this.bi = mutableFlatBuffer.m21524a(i, 113, 0);
        this.bj = mutableFlatBuffer.m21524a(i, 114, 0);
        this.bm = mutableFlatBuffer.m21523a(i, 117, 0.0d);
        this.bo = mutableFlatBuffer.m21523a(i, 120, 0.0d);
        this.bq = mutableFlatBuffer.m21525a(i, 122, 0);
        this.bu = mutableFlatBuffer.m21524a(i, 126, 0);
        this.bw = mutableFlatBuffer.m21540a(i, (int) HTTPTransportCallback.BODY_BYTES_RECEIVED);
        this.bx = mutableFlatBuffer.m21540a(i, 131);
    }

    public final int mo1403a(FlatBufferBuilder flatBufferBuilder) {
        m9958h();
        int a = ModelHelper.m23093a(flatBufferBuilder, m23926j());
        int a2 = ModelHelper.m23093a(flatBufferBuilder, m23927k());
        int a3 = ModelHelper.m23093a(flatBufferBuilder, m23928l());
        int b = flatBufferBuilder.m21502b(m23929m());
        int b2 = flatBufferBuilder.m21502b(m23930n());
        int a4 = ModelHelper.m23093a(flatBufferBuilder, m23931o());
        int a5 = ModelHelper.m23093a(flatBufferBuilder, m23932p());
        int a6 = ModelHelper.m23093a(flatBufferBuilder, m23933q());
        int a7 = ModelHelper.m23094a(flatBufferBuilder, m23934r());
        int a8 = ModelHelper.m23093a(flatBufferBuilder, m23894A());
        int a9 = ModelHelper.m23093a(flatBufferBuilder, m23895B());
        int a10 = ModelHelper.m23093a(flatBufferBuilder, m23896C());
        int a11 = ModelHelper.m23093a(flatBufferBuilder, m23897D());
        int c = flatBufferBuilder.m21509c(m23898E());
        int b3 = flatBufferBuilder.m21502b(m23899F());
        int a12 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) m23900G());
        int a13 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) m23901H());
        int a14 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) m23902I());
        int b4 = flatBufferBuilder.m21502b(m23903J());
        int a15 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) m23904K());
        int a16 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) m23905L());
        int a17 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) m23908O());
        int b5 = flatBufferBuilder.m21502b(m23909P());
        int a18 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) m23910Q());
        int a19 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) m23911R());
        int a20 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) aj());
        int a21 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) al());
        int a22 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) am());
        int b6 = flatBufferBuilder.m21502b(ap());
        int a23 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) aq());
        int b7 = flatBufferBuilder.m21502b(ar());
        int c2 = flatBufferBuilder.m21509c((List) as());
        int a24 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) at());
        int a25 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) au());
        int a26 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) av());
        int a27 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) aw());
        int a28 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) ax());
        int a29 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) ay());
        int a30 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) az());
        int a31 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) aA());
        int a32 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) aB());
        int a33 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) aC());
        int a34 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) aD());
        int a35 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) aE());
        int a36 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) aF());
        int a37 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) aG());
        int a38 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) aH());
        int a39 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) aI());
        int b8 = flatBufferBuilder.m21502b(aL());
        int b9 = flatBufferBuilder.m21502b(aN());
        int b10 = flatBufferBuilder.m21502b(aO());
        int b11 = flatBufferBuilder.m21502b(aQ());
        int a40 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) aR());
        int a41 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) aS());
        int a42 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) aT());
        int a43 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) aU());
        int a44 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) aV());
        int a45 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) aW());
        int a46 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) aX());
        int a47 = ModelHelper.m23094a(flatBufferBuilder, (List) aY());
        int a48 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) ba());
        int a49 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) bb());
        int a50 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) bc());
        int a51 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) be());
        int b12 = flatBufferBuilder.m21502b(bf());
        int b13 = flatBufferBuilder.m21502b(bg());
        int a52 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) bj());
        int a53 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) bq());
        int a54 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) br());
        int c3 = flatBufferBuilder.m21509c((List) bt());
        int a55 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) bv());
        int a56 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) bx());
        int a57 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) by());
        int a58 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) bz());
        int b14 = flatBufferBuilder.m21502b(bB());
        int a59 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) bE());
        int a60 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) bF());
        flatBufferBuilder.m21510c(134);
        flatBufferBuilder.m21507b(0, a);
        flatBufferBuilder.m21507b(1, a2);
        flatBufferBuilder.m21507b(2, a3);
        flatBufferBuilder.m21507b(4, b);
        flatBufferBuilder.m21507b(5, b2);
        flatBufferBuilder.m21507b(6, a4);
        flatBufferBuilder.m21507b(7, a5);
        flatBufferBuilder.m21507b(8, a6);
        flatBufferBuilder.m21507b(9, a7);
        flatBufferBuilder.m21498a(10, m23935s());
        flatBufferBuilder.m21498a(11, m23936t());
        flatBufferBuilder.m21498a(12, m23937u());
        flatBufferBuilder.m21498a(13, m23938v());
        flatBufferBuilder.m21498a(14, m23939w());
        flatBufferBuilder.m21498a(15, m23940x());
        flatBufferBuilder.m21498a(16, m23941y());
        flatBufferBuilder.m21492a(17, m23942z(), 0.0d);
        flatBufferBuilder.m21507b(18, a8);
        flatBufferBuilder.m21507b(19, a9);
        flatBufferBuilder.m21507b(20, a10);
        flatBufferBuilder.m21507b(21, a11);
        flatBufferBuilder.m21507b(22, c);
        flatBufferBuilder.m21507b(23, b3);
        flatBufferBuilder.m21507b(24, a12);
        flatBufferBuilder.m21507b(26, a13);
        flatBufferBuilder.m21507b(27, a14);
        flatBufferBuilder.m21507b(28, b4);
        flatBufferBuilder.m21507b(29, a15);
        flatBufferBuilder.m21507b(30, a16);
        flatBufferBuilder.m21496a(31, m23906M() == GraphQLFriendshipStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE ? null : m23906M());
        flatBufferBuilder.m21496a(32, m23907N() == GraphQLGender.UNSET_OR_UNRECOGNIZED_ENUM_VALUE ? null : m23907N());
        flatBufferBuilder.m21507b(34, a17);
        flatBufferBuilder.m21507b(35, b5);
        flatBufferBuilder.m21507b(36, a18);
        flatBufferBuilder.m21507b(37, a19);
        flatBufferBuilder.m21498a(38, m23912S());
        flatBufferBuilder.m21498a(39, m23913T());
        flatBufferBuilder.m21498a(40, m23914U());
        flatBufferBuilder.m21498a(41, m23915V());
        flatBufferBuilder.m21498a(42, m23916W());
        flatBufferBuilder.m21498a(43, m23917X());
        flatBufferBuilder.m21498a(44, m23918Y());
        flatBufferBuilder.m21498a(45, m23919Z());
        flatBufferBuilder.m21498a(46, aa());
        flatBufferBuilder.m21498a(47, ab());
        flatBufferBuilder.m21498a(48, ac());
        flatBufferBuilder.m21498a(49, ad());
        flatBufferBuilder.m21498a(50, ae());
        flatBufferBuilder.m21498a(51, af());
        flatBufferBuilder.m21498a(52, ag());
        flatBufferBuilder.m21498a(53, ah());
        flatBufferBuilder.m21498a(54, ai());
        flatBufferBuilder.m21507b(55, a20);
        flatBufferBuilder.m21496a(56, ak() == GraphQLLiveVideoSubscriptionStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE ? null : ak());
        flatBufferBuilder.m21507b(57, a21);
        flatBufferBuilder.m21507b(58, a22);
        flatBufferBuilder.m21495a(59, an(), 0);
        flatBufferBuilder.m21492a(60, ao(), 0.0d);
        flatBufferBuilder.m21507b(61, b6);
        flatBufferBuilder.m21507b(62, a23);
        flatBufferBuilder.m21507b(63, b7);
        flatBufferBuilder.m21507b(64, c2);
        flatBufferBuilder.m21507b(65, a24);
        flatBufferBuilder.m21507b(66, a25);
        flatBufferBuilder.m21507b(67, a26);
        flatBufferBuilder.m21507b(68, a27);
        flatBufferBuilder.m21507b(69, a28);
        flatBufferBuilder.m21507b(70, a29);
        flatBufferBuilder.m21507b(71, a30);
        flatBufferBuilder.m21507b(72, a31);
        flatBufferBuilder.m21507b(73, a32);
        flatBufferBuilder.m21507b(74, a33);
        flatBufferBuilder.m21507b(75, a34);
        flatBufferBuilder.m21507b(76, a35);
        flatBufferBuilder.m21507b(77, a36);
        flatBufferBuilder.m21507b(78, a37);
        flatBufferBuilder.m21507b(79, a38);
        flatBufferBuilder.m21507b(80, a39);
        flatBufferBuilder.m21495a(81, aJ(), 0);
        flatBufferBuilder.m21498a(82, aK());
        flatBufferBuilder.m21507b(83, b8);
        flatBufferBuilder.m21495a(84, aM(), 0);
        flatBufferBuilder.m21507b(86, b9);
        flatBufferBuilder.m21507b(87, b10);
        flatBufferBuilder.m21496a(88, aP() == GraphQLSecondarySubscribeStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE ? null : aP());
        flatBufferBuilder.m21507b(89, b11);
        flatBufferBuilder.m21507b(90, a40);
        flatBufferBuilder.m21507b(91, a41);
        flatBufferBuilder.m21507b(92, a42);
        flatBufferBuilder.m21507b(93, a43);
        flatBufferBuilder.m21507b(94, a44);
        flatBufferBuilder.m21507b(95, a45);
        flatBufferBuilder.m21507b(96, a46);
        flatBufferBuilder.m21507b(97, a47);
        flatBufferBuilder.m21496a(98, aZ() == GraphQLSubscribeStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE ? null : aZ());
        flatBufferBuilder.m21507b(99, a48);
        flatBufferBuilder.m21507b(100, a49);
        flatBufferBuilder.m21507b(101, a50);
        flatBufferBuilder.m21494a(102, bd(), 0);
        flatBufferBuilder.m21507b(103, a51);
        flatBufferBuilder.m21507b(104, b12);
        flatBufferBuilder.m21507b(105, b13);
        flatBufferBuilder.m21498a(106, bh());
        flatBufferBuilder.m21498a(107, bi());
        flatBufferBuilder.m21507b(108, a52);
        flatBufferBuilder.m21498a(109, bk());
        flatBufferBuilder.m21498a(110, bl());
        flatBufferBuilder.m21498a(111, bm());
        flatBufferBuilder.m21498a(112, bn());
        flatBufferBuilder.m21494a(113, bo(), 0);
        flatBufferBuilder.m21494a(114, bp(), 0);
        flatBufferBuilder.m21507b(115, a53);
        flatBufferBuilder.m21507b(116, a54);
        flatBufferBuilder.m21492a(117, bs(), 0.0d);
        flatBufferBuilder.m21507b(119, c3);
        flatBufferBuilder.m21492a(120, bu(), 0.0d);
        flatBufferBuilder.m21507b(121, a55);
        flatBufferBuilder.m21495a(122, bw(), 0);
        flatBufferBuilder.m21507b(123, a56);
        flatBufferBuilder.m21507b(124, a57);
        flatBufferBuilder.m21507b(125, a58);
        flatBufferBuilder.m21494a(126, bA(), 0);
        flatBufferBuilder.m21507b(127, b14);
        flatBufferBuilder.m21498a((int) HTTPTransportCallback.BODY_BYTES_RECEIVED, bC());
        flatBufferBuilder.m21498a(131, bD());
        flatBufferBuilder.m21507b(132, a59);
        flatBufferBuilder.m21507b(133, a60);
        m9959i();
        return flatBufferBuilder.m21511d();
    }

    public GraphQLUser(Parcel parcel) {
        boolean z;
        boolean z2 = true;
        super(135);
        this.f16942d = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f16943e = (GraphQLStreetAddress) parcel.readValue(GraphQLStreetAddress.class.getClassLoader());
        this.br = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f16944f = (GraphQLAlbumsConnection) parcel.readValue(GraphQLAlbumsConnection.class.getClassLoader());
        this.f16945g = parcel.readString();
        this.f16946h = parcel.readString();
        this.bs = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f16947i = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.f16948j = (GraphQLFriendsConnection) parcel.readValue(GraphQLFriendsConnection.class.getClassLoader());
        this.f16949k = (GraphQLFocusedPhoto) parcel.readValue(GraphQLFocusedPhoto.class.getClassLoader());
        this.f16950l = ImmutableListHelper.m21625a(parcel.readArrayList(GraphQLBylineFragment.class.getClassLoader()));
        this.f16951m = parcel.readByte() == (byte) 1;
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.f16952n = z;
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.f16953o = z;
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.f16954p = z;
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.f16955q = z;
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.f16956r = z;
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.f16957s = z;
        this.f16958t = parcel.readDouble();
        this.f16959u = (GraphQLContact) parcel.readValue(GraphQLContact.class.getClassLoader());
        this.f16960v = (GraphQLFocusedPhoto) parcel.readValue(GraphQLFocusedPhoto.class.getClassLoader());
        this.bq = parcel.readLong();
        this.f16961w = (GraphQLPage) parcel.readValue(GraphQLPage.class.getClassLoader());
        this.f16962x = (GraphQLUserEducationExperiencesConnection) parcel.readValue(GraphQLUserEducationExperiencesConnection.class.getClassLoader());
        this.f16963y = ImmutableListHelper.m21625a(parcel.readArrayList(String.class.getClassLoader()));
        this.f16964z = parcel.readString();
        this.f16916A = (GraphQLEventsConnection) parcel.readValue(GraphQLEventsConnection.class.getClassLoader());
        this.f16917B = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f16918C = (GraphQLTimelineSectionsConnection) parcel.readValue(GraphQLTimelineSectionsConnection.class.getClassLoader());
        this.f16919D = parcel.readString();
        this.f16920E = (GraphQLFollowUpFeedUnitsConnection) parcel.readValue(GraphQLFollowUpFeedUnitsConnection.class.getClassLoader());
        this.f16921F = (GraphQLFriendsConnection) parcel.readValue(GraphQLFriendsConnection.class.getClassLoader());
        this.f16922G = GraphQLFriendshipStatus.fromString(parcel.readString());
        this.f16923H = GraphQLGender.fromString(parcel.readString());
        this.bx = parcel.readByte() == (byte) 1;
        this.f16924I = (GraphQLPage) parcel.readValue(GraphQLPage.class.getClassLoader());
        this.f16925J = parcel.readString();
        this.f16926K = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f16927L = (GraphQLInlineActivitiesConnection) parcel.readValue(GraphQLInlineActivitiesConnection.class.getClassLoader());
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.f16928M = z;
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.f16929N = z;
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.f16930O = z;
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.f16931P = z;
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.f16932Q = z;
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.f16933R = z;
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
        this.f16934S = z;
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.f16935T = z;
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.f16936U = z;
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.f16937V = z;
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.f16938W = z;
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.f16939X = z;
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.f16940Y = z;
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.f16941Z = z;
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
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.ac = z;
        this.ad = (GraphQLLikedProfilesConnection) parcel.readValue(GraphQLLikedProfilesConnection.class.getClassLoader());
        this.ae = GraphQLLiveVideoSubscriptionStatus.fromString(parcel.readString());
        this.af = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.ag = (GraphQLContact) parcel.readValue(GraphQLContact.class.getClassLoader());
        this.ah = parcel.readLong();
        this.ai = parcel.readDouble();
        this.aj = parcel.readString();
        this.bu = parcel.readInt();
        this.ak = (GraphQLMutualFriendsConnection) parcel.readValue(GraphQLMutualFriendsConnection.class.getClassLoader());
        this.al = parcel.readString();
        this.am = ImmutableListHelper.m21625a(parcel.readArrayList(String.class.getClassLoader()));
        this.an = (GraphQLNewsFeedConnection) parcel.readValue(GraphQLNewsFeedConnection.class.getClassLoader());
        this.ao = (GraphQLPrivacyScope) parcel.readValue(GraphQLPrivacyScope.class.getClassLoader());
        this.ap = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.aq = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.ar = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.as = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.at = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.au = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.av = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.aw = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.ax = (GraphQLProfileBadge) parcel.readValue(GraphQLProfileBadge.class.getClassLoader());
        this.ay = (GraphQLPhoto) parcel.readValue(GraphQLPhoto.class.getClassLoader());
        this.az = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.aA = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.aB = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.aC = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.aD = parcel.readLong();
        this.aE = parcel.readByte() == (byte) 1;
        this.bz = (GraphQLProfileVideo) parcel.readValue(GraphQLProfileVideo.class.getClassLoader());
        this.aF = parcel.readString();
        this.aG = parcel.readLong();
        this.aH = parcel.readString();
        this.aI = parcel.readString();
        this.aJ = GraphQLSecondarySubscribeStatus.fromString(parcel.readString());
        this.aK = parcel.readString();
        this.bv = parcel.readString();
        this.aL = (GraphQLSinglePublisherVideoChannelsConnection) parcel.readValue(GraphQLSinglePublisherVideoChannelsConnection.class.getClassLoader());
        this.aM = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.aN = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.aO = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.aP = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.aQ = (GraphQLStreamingImage) parcel.readValue(GraphQLStreamingImage.class.getClassLoader());
        this.aR = (GraphQLName) parcel.readValue(GraphQLName.class.getClassLoader());
        this.aS = ImmutableListHelper.m21625a(parcel.readArrayList(GraphQLName.class.getClassLoader()));
        this.aT = GraphQLSubscribeStatus.fromString(parcel.readString());
        this.aU = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.aV = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.aW = (GraphQLTimelineSectionsConnection) parcel.readValue(GraphQLTimelineSectionsConnection.class.getClassLoader());
        this.by = (GraphQLTimelineStoriesConnection) parcel.readValue(GraphQLTimelineStoriesConnection.class.getClassLoader());
        this.bt = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.aX = parcel.readInt();
        this.aY = (GraphQLUnseenStoriesConnection) parcel.readValue(GraphQLUnseenStoriesConnection.class.getClassLoader());
        this.aZ = parcel.readString();
        this.ba = parcel.readString();
        this.bb = parcel.readByte() == (byte) 1;
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.bc = z;
        this.bd = (GraphQLProfile) parcel.readValue(GraphQLProfile.class.getClassLoader());
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.be = z;
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.bf = z;
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.bg = z;
        if (parcel.readByte() != (byte) 1) {
            z2 = false;
        }
        this.bh = z2;
        this.bi = parcel.readInt();
        this.bj = parcel.readInt();
        this.bk = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.bl = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.bm = parcel.readDouble();
        this.bn = ImmutableListHelper.m21625a(parcel.readArrayList(String.class.getClassLoader()));
        this.bo = parcel.readDouble();
        this.bp = (GraphQLUserWorkExperiencesConnection) parcel.readValue(GraphQLUserWorkExperiencesConnection.class.getClassLoader());
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int i2;
        int i3 = 1;
        parcel.writeValue(m23926j());
        parcel.writeValue(m23927k());
        parcel.writeValue(bx());
        parcel.writeValue(m23928l());
        parcel.writeString(m23929m());
        parcel.writeString(m23930n());
        parcel.writeValue(by());
        parcel.writeValue(m23931o());
        parcel.writeValue(m23932p());
        parcel.writeValue(m23933q());
        parcel.writeList(m23934r());
        parcel.writeByte((byte) (m23935s() ? 1 : 0));
        if (m23936t()) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        if (m23937u()) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        if (m23938v()) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        if (m23939w()) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        if (m23940x()) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        if (m23941y()) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        parcel.writeDouble(m23942z());
        parcel.writeValue(m23894A());
        parcel.writeValue(m23895B());
        parcel.writeLong(bw());
        parcel.writeValue(m23896C());
        parcel.writeValue(m23897D());
        parcel.writeList(m23898E());
        parcel.writeString(m23899F());
        parcel.writeValue(m23900G());
        parcel.writeValue(m23901H());
        parcel.writeValue(m23902I());
        parcel.writeString(m23903J());
        parcel.writeValue(m23904K());
        parcel.writeValue(m23905L());
        parcel.writeString(m23906M().name());
        parcel.writeString(m23907N().name());
        parcel.writeByte((byte) (bD() ? 1 : 0));
        parcel.writeValue(m23908O());
        parcel.writeString(m23909P());
        parcel.writeValue(m23910Q());
        parcel.writeValue(m23911R());
        if (m23912S()) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        if (m23913T()) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        if (m23914U()) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        if (m23915V()) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        if (m23916W()) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        if (m23917X()) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        if (bC()) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        if (m23918Y()) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        if (m23919Z()) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        if (aa()) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        if (ab()) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        if (ac()) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        if (ad()) {
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
        parcel.writeValue(aj());
        parcel.writeString(ak().name());
        parcel.writeValue(al());
        parcel.writeValue(am());
        parcel.writeLong(an());
        parcel.writeDouble(ao());
        parcel.writeString(ap());
        parcel.writeInt(bA());
        parcel.writeValue(aq());
        parcel.writeString(ar());
        parcel.writeList(as());
        parcel.writeValue(at());
        parcel.writeValue(au());
        parcel.writeValue(av());
        parcel.writeValue(aw());
        parcel.writeValue(ax());
        parcel.writeValue(ay());
        parcel.writeValue(az());
        parcel.writeValue(aA());
        parcel.writeValue(aB());
        parcel.writeValue(aC());
        parcel.writeValue(aD());
        parcel.writeValue(aE());
        parcel.writeValue(aF());
        parcel.writeValue(aG());
        parcel.writeValue(aH());
        parcel.writeValue(aI());
        parcel.writeLong(aJ());
        parcel.writeByte((byte) (aK() ? 1 : 0));
        parcel.writeValue(bF());
        parcel.writeString(aL());
        parcel.writeLong(aM());
        parcel.writeString(aN());
        parcel.writeString(aO());
        parcel.writeString(aP().name());
        parcel.writeString(aQ());
        parcel.writeString(bB());
        parcel.writeValue(aR());
        parcel.writeValue(aS());
        parcel.writeValue(aT());
        parcel.writeValue(aU());
        parcel.writeValue(aV());
        parcel.writeValue(aW());
        parcel.writeValue(aX());
        parcel.writeList(aY());
        parcel.writeString(aZ().name());
        parcel.writeValue(ba());
        parcel.writeValue(bb());
        parcel.writeValue(bc());
        parcel.writeValue(bE());
        parcel.writeValue(bz());
        parcel.writeInt(bd());
        parcel.writeValue(be());
        parcel.writeString(bf());
        parcel.writeString(bg());
        parcel.writeByte((byte) (bh() ? 1 : 0));
        if (bi()) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        parcel.writeValue(bj());
        if (bk()) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        if (bl()) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        if (bm()) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        if (!bn()) {
            i3 = 0;
        }
        parcel.writeByte((byte) i3);
        parcel.writeInt(bo());
        parcel.writeInt(bp());
        parcel.writeValue(bq());
        parcel.writeValue(br());
        parcel.writeDouble(bs());
        parcel.writeList(bt());
        parcel.writeDouble(bu());
        parcel.writeValue(bv());
    }

    public GraphQLUser(Builder builder) {
        super(135);
        this.b = builder.f15736a;
        this.c = builder.f15737b;
        this.f16942d = builder.d;
        this.f16943e = builder.e;
        this.br = builder.f;
        this.f16944f = builder.g;
        this.f16945g = builder.h;
        this.f16946h = builder.i;
        this.bs = builder.j;
        this.f16947i = builder.k;
        this.f16948j = builder.l;
        this.f16949k = builder.m;
        this.f16950l = builder.n;
        this.f16951m = builder.o;
        this.f16952n = builder.p;
        this.f16953o = builder.q;
        this.f16954p = builder.r;
        this.f16955q = builder.s;
        this.f16956r = builder.t;
        this.f16957s = builder.u;
        this.f16958t = builder.v;
        this.f16959u = builder.w;
        this.f16960v = builder.x;
        this.bq = builder.y;
        this.f16961w = builder.z;
        this.f16962x = builder.A;
        this.f16963y = builder.B;
        this.f16964z = builder.C;
        this.f16916A = builder.D;
        this.f16917B = builder.E;
        this.f16918C = builder.F;
        this.f16919D = builder.G;
        this.f16920E = builder.H;
        this.f16921F = builder.I;
        this.f16922G = builder.J;
        this.f16923H = builder.K;
        this.bx = builder.L;
        this.f16924I = builder.M;
        this.f16925J = builder.N;
        this.f16926K = builder.O;
        this.f16927L = builder.P;
        this.f16928M = builder.Q;
        this.f16929N = builder.R;
        this.f16930O = builder.S;
        this.f16931P = builder.T;
        this.f16932Q = builder.U;
        this.f16933R = builder.V;
        this.bw = builder.W;
        this.f16934S = builder.X;
        this.f16935T = builder.Y;
        this.f16936U = builder.Z;
        this.f16937V = builder.aa;
        this.f16938W = builder.ab;
        this.f16939X = builder.ac;
        this.f16940Y = builder.ad;
        this.f16941Z = builder.ae;
        this.aa = builder.af;
        this.ab = builder.ag;
        this.ac = builder.ah;
        this.ad = builder.ai;
        this.ae = builder.aj;
        this.af = builder.ak;
        this.ag = builder.al;
        this.ah = builder.am;
        this.ai = builder.an;
        this.aj = builder.ao;
        this.bu = builder.ap;
        this.ak = builder.aq;
        this.al = builder.ar;
        this.am = builder.as;
        this.an = builder.at;
        this.ao = builder.au;
        this.ap = builder.av;
        this.aq = builder.aw;
        this.ar = builder.ax;
        this.as = builder.ay;
        this.at = builder.az;
        this.au = builder.aA;
        this.av = builder.aB;
        this.aw = builder.aC;
        this.ax = builder.aD;
        this.ay = builder.aE;
        this.az = builder.aF;
        this.aA = builder.aG;
        this.aB = builder.aH;
        this.aC = builder.aI;
        this.aD = builder.aJ;
        this.aE = builder.aK;
        this.bz = builder.aL;
        this.aF = builder.aM;
        this.aG = builder.aN;
        this.aH = builder.aO;
        this.aI = builder.aP;
        this.aJ = builder.aQ;
        this.aK = builder.aR;
        this.bv = builder.aS;
        this.aL = builder.aT;
        this.aM = builder.aU;
        this.aN = builder.aV;
        this.aO = builder.aW;
        this.aP = builder.aX;
        this.aQ = builder.aY;
        this.aR = builder.aZ;
        this.aS = builder.ba;
        this.aT = builder.bb;
        this.aU = builder.bc;
        this.aV = builder.bd;
        this.aW = builder.be;
        this.by = builder.bf;
        this.bt = builder.bg;
        this.aX = builder.bh;
        this.aY = builder.bi;
        this.aZ = builder.bj;
        this.ba = builder.bk;
        this.bb = builder.bl;
        this.bc = builder.bm;
        this.bd = builder.bn;
        this.be = builder.bo;
        this.bf = builder.bp;
        this.bg = builder.bq;
        this.bh = builder.br;
        this.bi = builder.bs;
        this.bj = builder.bt;
        this.bk = builder.bu;
        this.bl = builder.bv;
        this.bm = builder.bw;
        this.bn = builder.bx;
        this.bo = builder.by;
        this.bp = builder.bz;
    }
}
