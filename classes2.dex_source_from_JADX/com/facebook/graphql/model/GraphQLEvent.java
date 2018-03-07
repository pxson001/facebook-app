package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.json.AutoGenJsonSerializer;
import com.facebook.dracula.api.FieldOffset;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLBoostedPostStatus;
import com.facebook.graphql.enums.GraphQLConnectionStyle;
import com.facebook.graphql.enums.GraphQLEventActionStyle;
import com.facebook.graphql.enums.GraphQLEventGuestStatus;
import com.facebook.graphql.enums.GraphQLEventNotificationSubscriptionLevel;
import com.facebook.graphql.enums.GraphQLEventPrivacyType;
import com.facebook.graphql.enums.GraphQLEventType;
import com.facebook.graphql.enums.GraphQLEventVisibility;
import com.facebook.graphql.enums.GraphQLEventWatchStatus;
import com.facebook.graphql.enums.GraphQLPlaceType;
import com.facebook.graphql.enums.GraphQLSavedState;
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
/* compiled from: logVideoPlayerPauseEvent */
public final class GraphQLEvent extends BaseModel implements TypeModel, GraphQLPersistableNode, GraphQLVisitableConsistentModel {
    public static final Creator<GraphQLEvent> CREATOR = new 1();
    long f16293A;
    @Nullable
    GraphQLEventCategoryData f16294B;
    @Nullable
    GraphQLImage f16295C;
    @Nullable
    String f16296D;
    @Nullable
    String f16297E;
    @Nullable
    String f16298F;
    @Nullable
    GraphQLEventCategoryData f16299G;
    @Deprecated
    @Nullable
    GraphQLFocusedPhoto f16300H;
    @Nullable
    GraphQLActor f16301I;
    @Nullable
    GraphQLEventDeclinesConnection f16302J;
    @Nullable
    GraphQLTextWithEntities f16303K;
    @Nullable
    GraphQLEventHostsConnection f16304L;
    @Nullable
    GraphQLEventInviteesConnection f16305M;
    GraphQLEventPrivacyType f16306N;
    @Nullable
    GraphQLEventMaybesConnection f16307O;
    @Nullable
    GraphQLEventMembersConnection f16308P;
    @Nullable
    GraphQLPlace f16309Q;
    @Deprecated
    GraphQLEventPrivacyType f16310R;
    @Nullable
    String f16311S;
    @Deprecated
    GraphQLEventType f16312T;
    int f16313U;
    int f16314V;
    @Nullable
    GraphQLEventViewerCapability f16315W;
    @Deprecated
    GraphQLEventVisibility f16316X;
    @Nullable
    GraphQLEventWatchersConnection f16317Y;
    @Nullable
    GraphQLImage f16318Z;
    @Nullable
    GraphQLStoryAttachment aA;
    @Nullable
    GraphQLEventDeclinesConnection aB;
    @Nullable
    GraphQLEventInviteesConnection aC;
    @Nullable
    GraphQLEventMaybesConnection aD;
    @Nullable
    GraphQLEventMembersConnection aE;
    @Nullable
    GraphQLEventWatchersConnection aF;
    @Nullable
    GraphQLGroup aG;
    int aH;
    @Nullable
    GraphQLImage aI;
    @Nullable
    String aJ;
    GraphQLPlaceType aK;
    boolean aL;
    @Nullable
    GraphQLPrivacyScope aM;
    @Deprecated
    @Nullable
    GraphQLPrivacyScope aN;
    @Nullable
    GraphQLImage aO;
    @Nullable
    GraphQLImage aP;
    @Nullable
    GraphQLImage aQ;
    @Nullable
    GraphQLImage aR;
    @Nullable
    GraphQLImage aS;
    @Nullable
    GraphQLPhoto aT;
    @Nullable
    GraphQLImage aU;
    @Nullable
    GraphQLImage aV;
    @Nullable
    GraphQLImage aW;
    @Nullable
    GraphQLImage aX;
    boolean aY;
    @Nullable
    GraphQLTimelineAppCollection aZ;
    @Nullable
    GraphQLEventDeclinesConnection aa;
    @Nullable
    GraphQLEventInviteesConnection ab;
    @Nullable
    GraphQLEventInviteesConnection ac;
    @Nullable
    GraphQLEventMaybesConnection ad;
    @Nullable
    GraphQLEventMaybesConnection ae;
    @Nullable
    GraphQLEventMembersConnection af;
    @Nullable
    GraphQLEventMembersConnection ag;
    @Nullable
    GraphQLEventWatchersConnection ah;
    @Nullable
    GraphQLEventWatchersConnection ai;
    @Nullable
    GraphQLEventMembersConnection aj;
    @Nullable
    GraphQLEventWatchersConnection ak;
    @Nullable
    GraphQLEventInviteesConnection al;
    @Nullable
    String am;
    @Nullable
    GraphQLImage an;
    @Deprecated
    @Nullable
    GraphQLInlineActivitiesConnection ao;
    boolean ap;
    public boolean aq;
    boolean ar;
    boolean as;
    boolean at;
    @Nullable
    String au;
    @Nullable
    GraphQLLocation av;
    @Nullable
    GraphQLGeoRectangle aw;
    int ax;
    @Nullable
    public String ay;
    List<String> az;
    @Nullable
    GraphQLTextWithEntities ba;
    @Nullable
    String bb;
    long bc;
    @Nullable
    GraphQLStreamingImage bd;
    @Nullable
    GraphQLTextWithEntities be;
    boolean bf;
    @Nullable
    GraphQLImage bg;
    @Deprecated
    @Nullable
    GraphQLEventTimeRange bh;
    @Nullable
    String bi;
    @Nullable
    String bj;
    int bk;
    @Nullable
    String bl;
    @Deprecated
    @Nullable
    String bm;
    public GraphQLEventGuestStatus bn;
    public boolean bo;
    List<GraphQLActor> bp;
    public GraphQLEventNotificationSubscriptionLevel bq;
    GraphQLSavedState br;
    List<GraphQLTimelineAppCollection> bs;
    List<GraphQLTimelineAppCollection> bt;
    public GraphQLEventWatchStatus bu;
    GraphQLBoostedPostStatus bv;
    boolean bw;
    long bx;
    boolean by;
    @Nullable
    GraphQLEventTicketProvider bz;
    GraphQLEventActionStyle f16319d;
    @Nullable
    GraphQLAlbum f16320e;
    @Nullable
    GraphQLEventDeclinesConnection f16321f;
    @Nullable
    GraphQLEventMaybesConnection f16322g;
    @Nullable
    GraphQLEventMembersConnection f16323h;
    @Nullable
    GraphQLInlineActivity f16324i;
    @Nullable
    GraphQLFocusedPhoto f16325j;
    @Nullable
    GraphQLStory f16326k;
    boolean f16327l;
    boolean f16328m;
    boolean f16329n;
    boolean f16330o;
    boolean f16331p;
    boolean f16332q;
    boolean f16333r;
    @Deprecated
    boolean f16334s;
    @Nullable
    GraphQLImage f16335t;
    GraphQLConnectionStyle f16336u;
    @Nullable
    String f16337v;
    @Nullable
    GraphQLFocusedPhoto f16338w;
    @Nullable
    GraphQLGroup f16339x;
    @Nullable
    GraphQLStory f16340y;
    long f16341z;

    @FieldOffset
    public final GraphQLEventActionStyle m23161j() {
        this.f16319d = (GraphQLEventActionStyle) super.m9945a(this.f16319d, 0, GraphQLEventActionStyle.class, GraphQLEventActionStyle.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
        return this.f16319d;
    }

    @FieldOffset
    @Nullable
    public final GraphQLAlbum m23162k() {
        this.f16320e = (GraphQLAlbum) super.m9947a(this.f16320e, 1, GraphQLAlbum.class);
        return this.f16320e;
    }

    @FieldOffset
    @Nullable
    public final GraphQLEventDeclinesConnection m23163l() {
        this.f16321f = (GraphQLEventDeclinesConnection) super.m9947a(this.f16321f, 2, GraphQLEventDeclinesConnection.class);
        return this.f16321f;
    }

    @FieldOffset
    @Nullable
    public final GraphQLEventMaybesConnection m23164m() {
        this.f16322g = (GraphQLEventMaybesConnection) super.m9947a(this.f16322g, 3, GraphQLEventMaybesConnection.class);
        return this.f16322g;
    }

    @FieldOffset
    @Nullable
    public final GraphQLEventMembersConnection m23165n() {
        this.f16323h = (GraphQLEventMembersConnection) super.m9947a(this.f16323h, 4, GraphQLEventMembersConnection.class);
        return this.f16323h;
    }

    @FieldOffset
    @Nullable
    public final GraphQLInlineActivity m23166o() {
        this.f16324i = (GraphQLInlineActivity) super.m9947a(this.f16324i, 5, GraphQLInlineActivity.class);
        return this.f16324i;
    }

    @FieldOffset
    @Nullable
    public final GraphQLFocusedPhoto m23167p() {
        this.f16325j = (GraphQLFocusedPhoto) super.m9947a(this.f16325j, 6, GraphQLFocusedPhoto.class);
        return this.f16325j;
    }

    @FieldOffset
    @Nullable
    public final GraphQLStory m23168q() {
        this.f16326k = (GraphQLStory) super.m9947a(this.f16326k, 7, GraphQLStory.class);
        return this.f16326k;
    }

    @FieldOffset
    public final boolean m23169r() {
        m9949a(1, 0);
        return this.f16327l;
    }

    @FieldOffset
    public final boolean m23170s() {
        m9949a(1, 1);
        return this.f16328m;
    }

    @FieldOffset
    public final boolean m23171t() {
        m9949a(1, 2);
        return this.f16329n;
    }

    @FieldOffset
    public final boolean m23172u() {
        m9949a(1, 3);
        return this.f16330o;
    }

    @FieldOffset
    public final boolean m23173v() {
        m9949a(1, 4);
        return this.f16331p;
    }

    @FieldOffset
    public final boolean m23174w() {
        m9949a(1, 5);
        return this.f16332q;
    }

    @FieldOffset
    public final boolean m23175x() {
        m9949a(1, 6);
        return this.f16333r;
    }

    @FieldOffset
    public final boolean m23176y() {
        m9949a(1, 7);
        return this.f16334s;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m23177z() {
        this.f16335t = (GraphQLImage) super.m9947a(this.f16335t, 16, GraphQLImage.class);
        return this.f16335t;
    }

    @FieldOffset
    public final GraphQLConnectionStyle m23129A() {
        this.f16336u = (GraphQLConnectionStyle) super.m9945a(this.f16336u, 17, GraphQLConnectionStyle.class, GraphQLConnectionStyle.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
        return this.f16336u;
    }

    @FieldOffset
    @Nullable
    public final String m23130B() {
        this.f16337v = super.m9948a(this.f16337v, 18);
        return this.f16337v;
    }

    @FieldOffset
    @Nullable
    public final GraphQLFocusedPhoto m23131C() {
        this.f16338w = (GraphQLFocusedPhoto) super.m9947a(this.f16338w, 19, GraphQLFocusedPhoto.class);
        return this.f16338w;
    }

    @FieldOffset
    @Nullable
    public final GraphQLGroup m23132D() {
        this.f16339x = (GraphQLGroup) super.m9947a(this.f16339x, 20, GraphQLGroup.class);
        return this.f16339x;
    }

    @FieldOffset
    @Nullable
    public final GraphQLStory m23133E() {
        this.f16340y = (GraphQLStory) super.m9947a(this.f16340y, 21, GraphQLStory.class);
        return this.f16340y;
    }

    @FieldOffset
    public final long m23134F() {
        m9949a(2, 6);
        return this.f16341z;
    }

    @FieldOffset
    public final long m23135G() {
        m9949a(2, 7);
        return this.f16293A;
    }

    @FieldOffset
    @Nullable
    public final GraphQLEventCategoryData m23136H() {
        this.f16294B = (GraphQLEventCategoryData) super.m9947a(this.f16294B, 24, GraphQLEventCategoryData.class);
        return this.f16294B;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m23137I() {
        this.f16295C = (GraphQLImage) super.m9947a(this.f16295C, 25, GraphQLImage.class);
        return this.f16295C;
    }

    @FieldOffset
    @Nullable
    public final String m23138J() {
        this.f16296D = super.m9948a(this.f16296D, 26);
        return this.f16296D;
    }

    @FieldOffset
    @Nullable
    public final String m23139K() {
        this.f16297E = super.m9948a(this.f16297E, 27);
        return this.f16297E;
    }

    @FieldOffset
    @Nullable
    public final String m23140L() {
        this.f16298F = super.m9948a(this.f16298F, 28);
        return this.f16298F;
    }

    @FieldOffset
    @Nullable
    public final GraphQLEventCategoryData m23141M() {
        this.f16299G = (GraphQLEventCategoryData) super.m9947a(this.f16299G, 29, GraphQLEventCategoryData.class);
        return this.f16299G;
    }

    @FieldOffset
    @Nullable
    public final GraphQLFocusedPhoto m23142N() {
        this.f16300H = (GraphQLFocusedPhoto) super.m9947a(this.f16300H, 30, GraphQLFocusedPhoto.class);
        return this.f16300H;
    }

    @FieldOffset
    @Nullable
    public final GraphQLActor m23143O() {
        this.f16301I = (GraphQLActor) super.m9947a(this.f16301I, 31, GraphQLActor.class);
        return this.f16301I;
    }

    @FieldOffset
    @Nullable
    public final GraphQLEventDeclinesConnection m23144P() {
        this.f16302J = (GraphQLEventDeclinesConnection) super.m9947a(this.f16302J, 32, GraphQLEventDeclinesConnection.class);
        return this.f16302J;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities m23145Q() {
        this.f16303K = (GraphQLTextWithEntities) super.m9947a(this.f16303K, 33, GraphQLTextWithEntities.class);
        return this.f16303K;
    }

    @FieldOffset
    @Nullable
    public final GraphQLEventHostsConnection m23146R() {
        this.f16304L = (GraphQLEventHostsConnection) super.m9947a(this.f16304L, 34, GraphQLEventHostsConnection.class);
        return this.f16304L;
    }

    @FieldOffset
    @Nullable
    public final GraphQLEventInviteesConnection m23147S() {
        this.f16305M = (GraphQLEventInviteesConnection) super.m9947a(this.f16305M, 35, GraphQLEventInviteesConnection.class);
        return this.f16305M;
    }

    @FieldOffset
    public final GraphQLEventPrivacyType m23148T() {
        this.f16306N = (GraphQLEventPrivacyType) super.m9945a(this.f16306N, 36, GraphQLEventPrivacyType.class, GraphQLEventPrivacyType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
        return this.f16306N;
    }

    @FieldOffset
    @Nullable
    public final GraphQLEventMaybesConnection m23149U() {
        this.f16307O = (GraphQLEventMaybesConnection) super.m9947a(this.f16307O, 37, GraphQLEventMaybesConnection.class);
        return this.f16307O;
    }

    @FieldOffset
    @Nullable
    public final GraphQLEventMembersConnection m23150V() {
        this.f16308P = (GraphQLEventMembersConnection) super.m9947a(this.f16308P, 38, GraphQLEventMembersConnection.class);
        return this.f16308P;
    }

    @FieldOffset
    @Nullable
    public final GraphQLPlace m23151W() {
        this.f16309Q = (GraphQLPlace) super.m9947a(this.f16309Q, 39, GraphQLPlace.class);
        return this.f16309Q;
    }

    @FieldOffset
    public final GraphQLEventPrivacyType m23152X() {
        this.f16310R = (GraphQLEventPrivacyType) super.m9945a(this.f16310R, 40, GraphQLEventPrivacyType.class, GraphQLEventPrivacyType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
        return this.f16310R;
    }

    @FieldOffset
    @Nullable
    public final String m23153Y() {
        this.f16311S = super.m9948a(this.f16311S, 41);
        return this.f16311S;
    }

    @FieldOffset
    public final GraphQLEventType m23154Z() {
        this.f16312T = (GraphQLEventType) super.m9945a(this.f16312T, 42, GraphQLEventType.class, GraphQLEventType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
        return this.f16312T;
    }

    @FieldOffset
    public final int aa() {
        m9949a(5, 3);
        return this.f16313U;
    }

    @FieldOffset
    public final int ab() {
        m9949a(5, 4);
        return this.f16314V;
    }

    @FieldOffset
    @Nullable
    public final GraphQLEventViewerCapability ac() {
        this.f16315W = (GraphQLEventViewerCapability) super.m9947a(this.f16315W, 45, GraphQLEventViewerCapability.class);
        return this.f16315W;
    }

    @FieldOffset
    public final GraphQLEventVisibility ad() {
        this.f16316X = (GraphQLEventVisibility) super.m9945a(this.f16316X, 46, GraphQLEventVisibility.class, GraphQLEventVisibility.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
        return this.f16316X;
    }

    @FieldOffset
    @Nullable
    public final GraphQLEventWatchersConnection ae() {
        this.f16317Y = (GraphQLEventWatchersConnection) super.m9947a(this.f16317Y, 47, GraphQLEventWatchersConnection.class);
        return this.f16317Y;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage af() {
        this.f16318Z = (GraphQLImage) super.m9947a(this.f16318Z, 48, GraphQLImage.class);
        return this.f16318Z;
    }

    @FieldOffset
    @Nullable
    public final GraphQLEventDeclinesConnection ag() {
        this.aa = (GraphQLEventDeclinesConnection) super.m9947a(this.aa, 49, GraphQLEventDeclinesConnection.class);
        return this.aa;
    }

    @FieldOffset
    @Nullable
    public final GraphQLEventInviteesConnection ah() {
        this.ab = (GraphQLEventInviteesConnection) super.m9947a(this.ab, 50, GraphQLEventInviteesConnection.class);
        return this.ab;
    }

    @FieldOffset
    @Nullable
    public final GraphQLEventInviteesConnection ai() {
        this.ac = (GraphQLEventInviteesConnection) super.m9947a(this.ac, 51, GraphQLEventInviteesConnection.class);
        return this.ac;
    }

    @FieldOffset
    @Nullable
    public final GraphQLEventMaybesConnection aj() {
        this.ad = (GraphQLEventMaybesConnection) super.m9947a(this.ad, 52, GraphQLEventMaybesConnection.class);
        return this.ad;
    }

    @FieldOffset
    @Nullable
    public final GraphQLEventMaybesConnection ak() {
        this.ae = (GraphQLEventMaybesConnection) super.m9947a(this.ae, 53, GraphQLEventMaybesConnection.class);
        return this.ae;
    }

    @FieldOffset
    @Nullable
    public final GraphQLEventMembersConnection al() {
        this.af = (GraphQLEventMembersConnection) super.m9947a(this.af, 54, GraphQLEventMembersConnection.class);
        return this.af;
    }

    @FieldOffset
    @Nullable
    public final GraphQLEventMembersConnection am() {
        this.ag = (GraphQLEventMembersConnection) super.m9947a(this.ag, 55, GraphQLEventMembersConnection.class);
        return this.ag;
    }

    @FieldOffset
    @Nullable
    public final GraphQLEventWatchersConnection an() {
        this.ah = (GraphQLEventWatchersConnection) super.m9947a(this.ah, 56, GraphQLEventWatchersConnection.class);
        return this.ah;
    }

    @FieldOffset
    @Nullable
    public final GraphQLEventWatchersConnection ao() {
        this.ai = (GraphQLEventWatchersConnection) super.m9947a(this.ai, 57, GraphQLEventWatchersConnection.class);
        return this.ai;
    }

    @FieldOffset
    @Nullable
    public final GraphQLEventMembersConnection ap() {
        this.aj = (GraphQLEventMembersConnection) super.m9947a(this.aj, 58, GraphQLEventMembersConnection.class);
        return this.aj;
    }

    @FieldOffset
    @Nullable
    public final GraphQLEventWatchersConnection aq() {
        this.ak = (GraphQLEventWatchersConnection) super.m9947a(this.ak, 59, GraphQLEventWatchersConnection.class);
        return this.ak;
    }

    @FieldOffset
    @Nullable
    public final GraphQLEventInviteesConnection ar() {
        this.al = (GraphQLEventInviteesConnection) super.m9947a(this.al, 60, GraphQLEventInviteesConnection.class);
        return this.al;
    }

    @FieldOffset
    @Nullable
    public final String as() {
        this.am = super.m9948a(this.am, 62);
        return this.am;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage at() {
        this.an = (GraphQLImage) super.m9947a(this.an, 63, GraphQLImage.class);
        return this.an;
    }

    @FieldOffset
    @Nullable
    public final GraphQLInlineActivitiesConnection au() {
        this.ao = (GraphQLInlineActivitiesConnection) super.m9947a(this.ao, 64, GraphQLInlineActivitiesConnection.class);
        return this.ao;
    }

    @FieldOffset
    public final boolean av() {
        m9949a(8, 1);
        return this.ap;
    }

    @FieldOffset
    public final boolean aw() {
        m9949a(8, 2);
        return this.aq;
    }

    @FieldOffset
    public final boolean ax() {
        m9949a(8, 3);
        return this.ar;
    }

    @FieldOffset
    public final boolean ay() {
        m9949a(8, 4);
        return this.as;
    }

    @FieldOffset
    public final boolean az() {
        m9949a(8, 5);
        return this.at;
    }

    @FieldOffset
    @Nullable
    public final String aA() {
        this.au = super.m9948a(this.au, 71);
        return this.au;
    }

    @FieldOffset
    @Nullable
    public final GraphQLLocation aB() {
        this.av = (GraphQLLocation) super.m9947a(this.av, 72, GraphQLLocation.class);
        return this.av;
    }

    @FieldOffset
    @Nullable
    public final GraphQLGeoRectangle aC() {
        this.aw = (GraphQLGeoRectangle) super.m9947a(this.aw, 73, GraphQLGeoRectangle.class);
        return this.aw;
    }

    @FieldOffset
    public final int aD() {
        m9949a(9, 2);
        return this.ax;
    }

    @FieldOffset
    @Nullable
    public final String aE() {
        this.ay = super.m9948a(this.ay, 75);
        return this.ay;
    }

    @FieldOffset
    public final ImmutableList<String> aF() {
        this.az = super.m9943a(this.az, 76);
        return (ImmutableList) this.az;
    }

    @FieldOffset
    @Nullable
    public final GraphQLStoryAttachment aG() {
        this.aA = (GraphQLStoryAttachment) super.m9947a(this.aA, 77, GraphQLStoryAttachment.class);
        return this.aA;
    }

    @FieldOffset
    @Nullable
    public final GraphQLEventDeclinesConnection aH() {
        this.aB = (GraphQLEventDeclinesConnection) super.m9947a(this.aB, 78, GraphQLEventDeclinesConnection.class);
        return this.aB;
    }

    @FieldOffset
    @Nullable
    public final GraphQLEventInviteesConnection aI() {
        this.aC = (GraphQLEventInviteesConnection) super.m9947a(this.aC, 79, GraphQLEventInviteesConnection.class);
        return this.aC;
    }

    @FieldOffset
    @Nullable
    public final GraphQLEventMaybesConnection aJ() {
        this.aD = (GraphQLEventMaybesConnection) super.m9947a(this.aD, 80, GraphQLEventMaybesConnection.class);
        return this.aD;
    }

    @FieldOffset
    @Nullable
    public final GraphQLEventMembersConnection aK() {
        this.aE = (GraphQLEventMembersConnection) super.m9947a(this.aE, 81, GraphQLEventMembersConnection.class);
        return this.aE;
    }

    @FieldOffset
    @Nullable
    public final GraphQLEventWatchersConnection aL() {
        this.aF = (GraphQLEventWatchersConnection) super.m9947a(this.aF, 82, GraphQLEventWatchersConnection.class);
        return this.aF;
    }

    @FieldOffset
    @Nullable
    public final GraphQLGroup aM() {
        this.aG = (GraphQLGroup) super.m9947a(this.aG, 83, GraphQLGroup.class);
        return this.aG;
    }

    @FieldOffset
    public final int aN() {
        m9949a(10, 4);
        return this.aH;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage aO() {
        this.aI = (GraphQLImage) super.m9947a(this.aI, 85, GraphQLImage.class);
        return this.aI;
    }

    @FieldOffset
    @Nullable
    public final String aP() {
        this.aJ = super.m9948a(this.aJ, 86);
        return this.aJ;
    }

    @FieldOffset
    public final GraphQLPlaceType aQ() {
        this.aK = (GraphQLPlaceType) super.m9945a(this.aK, 87, GraphQLPlaceType.class, GraphQLPlaceType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
        return this.aK;
    }

    @FieldOffset
    public final boolean aR() {
        m9949a(11, 0);
        return this.aL;
    }

    @FieldOffset
    @Nullable
    public final GraphQLPrivacyScope aS() {
        this.aM = (GraphQLPrivacyScope) super.m9947a(this.aM, 89, GraphQLPrivacyScope.class);
        return this.aM;
    }

    @FieldOffset
    @Nullable
    public final GraphQLPrivacyScope aT() {
        this.aN = (GraphQLPrivacyScope) super.m9947a(this.aN, 90, GraphQLPrivacyScope.class);
        return this.aN;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage aU() {
        this.aO = (GraphQLImage) super.m9947a(this.aO, 91, GraphQLImage.class);
        return this.aO;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage aV() {
        this.aP = (GraphQLImage) super.m9947a(this.aP, 92, GraphQLImage.class);
        return this.aP;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage aW() {
        this.aQ = (GraphQLImage) super.m9947a(this.aQ, 93, GraphQLImage.class);
        return this.aQ;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage aX() {
        this.aR = (GraphQLImage) super.m9947a(this.aR, 94, GraphQLImage.class);
        return this.aR;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage aY() {
        this.aS = (GraphQLImage) super.m9947a(this.aS, 95, GraphQLImage.class);
        return this.aS;
    }

    @FieldOffset
    @Nullable
    public final GraphQLPhoto aZ() {
        this.aT = (GraphQLPhoto) super.m9947a(this.aT, 96, GraphQLPhoto.class);
        return this.aT;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage ba() {
        this.aU = (GraphQLImage) super.m9947a(this.aU, 97, GraphQLImage.class);
        return this.aU;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage bb() {
        this.aV = (GraphQLImage) super.m9947a(this.aV, 98, GraphQLImage.class);
        return this.aV;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage bc() {
        this.aW = (GraphQLImage) super.m9947a(this.aW, 99, GraphQLImage.class);
        return this.aW;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage bd() {
        this.aX = (GraphQLImage) super.m9947a(this.aX, 100, GraphQLImage.class);
        return this.aX;
    }

    @FieldOffset
    public final boolean be() {
        m9949a(12, 5);
        return this.aY;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTimelineAppCollection bf() {
        this.aZ = (GraphQLTimelineAppCollection) super.m9947a(this.aZ, 102, GraphQLTimelineAppCollection.class);
        return this.aZ;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities bg() {
        this.ba = (GraphQLTextWithEntities) super.m9947a(this.ba, 103, GraphQLTextWithEntities.class);
        return this.ba;
    }

    @FieldOffset
    @Nullable
    public final String bh() {
        this.bb = super.m9948a(this.bb, 104);
        return this.bb;
    }

    @FieldOffset
    public final long bi() {
        m9949a(13, 1);
        return this.bc;
    }

    @FieldOffset
    @Nullable
    public final GraphQLStreamingImage bj() {
        this.bd = (GraphQLStreamingImage) super.m9947a(this.bd, 106, GraphQLStreamingImage.class);
        return this.bd;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities bk() {
        this.be = (GraphQLTextWithEntities) super.m9947a(this.be, 107, GraphQLTextWithEntities.class);
        return this.be;
    }

    @FieldOffset
    public final boolean bl() {
        m9949a(13, 4);
        return this.bf;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage bm() {
        this.bg = (GraphQLImage) super.m9947a(this.bg, 109, GraphQLImage.class);
        return this.bg;
    }

    @FieldOffset
    @Nullable
    public final GraphQLEventTimeRange bn() {
        this.bh = (GraphQLEventTimeRange) super.m9947a(this.bh, 110, GraphQLEventTimeRange.class);
        return this.bh;
    }

    @FieldOffset
    @Nullable
    public final String bo() {
        this.bi = super.m9948a(this.bi, 111);
        return this.bi;
    }

    @FieldOffset
    @Nullable
    public final String bp() {
        this.bj = super.m9948a(this.bj, 112);
        return this.bj;
    }

    @FieldOffset
    public final int bq() {
        m9949a(14, 1);
        return this.bk;
    }

    @FieldOffset
    @Nullable
    public final String br() {
        this.bl = super.m9948a(this.bl, 114);
        return this.bl;
    }

    @FieldOffset
    @Nullable
    public final String bs() {
        this.bm = super.m9948a(this.bm, 115);
        return this.bm;
    }

    @FieldOffset
    public final GraphQLEventGuestStatus bt() {
        this.bn = (GraphQLEventGuestStatus) super.m9945a(this.bn, 116, GraphQLEventGuestStatus.class, GraphQLEventGuestStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
        return this.bn;
    }

    @FieldOffset
    public final boolean bu() {
        m9949a(14, 5);
        return this.bo;
    }

    @FieldOffset
    public final ImmutableList<GraphQLActor> bv() {
        this.bp = super.m9944a(this.bp, 118, GraphQLActor.class);
        return (ImmutableList) this.bp;
    }

    @FieldOffset
    public final GraphQLEventNotificationSubscriptionLevel bw() {
        this.bq = (GraphQLEventNotificationSubscriptionLevel) super.m9945a(this.bq, 119, GraphQLEventNotificationSubscriptionLevel.class, GraphQLEventNotificationSubscriptionLevel.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
        return this.bq;
    }

    @FieldOffset
    public final GraphQLSavedState bx() {
        this.br = (GraphQLSavedState) super.m9945a(this.br, 120, GraphQLSavedState.class, GraphQLSavedState.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
        return this.br;
    }

    @FieldOffset
    public final ImmutableList<GraphQLTimelineAppCollection> by() {
        this.bs = super.m9944a(this.bs, 121, GraphQLTimelineAppCollection.class);
        return (ImmutableList) this.bs;
    }

    @FieldOffset
    public final ImmutableList<GraphQLTimelineAppCollection> bz() {
        this.bt = super.m9944a(this.bt, 122, GraphQLTimelineAppCollection.class);
        return (ImmutableList) this.bt;
    }

    @FieldOffset
    public final GraphQLEventWatchStatus bA() {
        this.bu = (GraphQLEventWatchStatus) super.m9945a(this.bu, 123, GraphQLEventWatchStatus.class, GraphQLEventWatchStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
        return this.bu;
    }

    @FieldOffset
    public final GraphQLBoostedPostStatus bB() {
        this.bv = (GraphQLBoostedPostStatus) super.m9945a(this.bv, 124, GraphQLBoostedPostStatus.class, GraphQLBoostedPostStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
        return this.bv;
    }

    @FieldOffset
    public final boolean bC() {
        m9949a(15, 5);
        return this.bw;
    }

    @FieldOffset
    public final long bD() {
        m9949a(15, 7);
        return this.bx;
    }

    @FieldOffset
    public final boolean bE() {
        m9949a(16, 0);
        return this.by;
    }

    @FieldOffset
    @Nullable
    public final GraphQLEventTicketProvider bF() {
        this.bz = (GraphQLEventTicketProvider) super.m9947a(this.bz, 129, GraphQLEventTicketProvider.class);
        return this.bz;
    }

    @Nullable
    public final String mo2834a() {
        return as();
    }

    public final int jK_() {
        return 67338874;
    }

    public final GraphQLVisitableModel mo1404a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLEventDeclinesConnection graphQLEventDeclinesConnection;
        GraphQLEventMaybesConnection graphQLEventMaybesConnection;
        GraphQLEventMembersConnection graphQLEventMembersConnection;
        GraphQLFocusedPhoto graphQLFocusedPhoto;
        GraphQLStory graphQLStory;
        GraphQLImage graphQLImage;
        GraphQLGroup graphQLGroup;
        GraphQLEventCategoryData graphQLEventCategoryData;
        GraphQLTextWithEntities graphQLTextWithEntities;
        GraphQLEventInviteesConnection graphQLEventInviteesConnection;
        GraphQLEventWatchersConnection graphQLEventWatchersConnection;
        GraphQLPrivacyScope graphQLPrivacyScope;
        Builder a;
        GraphQLVisitableModel graphQLVisitableModel = null;
        m9958h();
        if (m23162k() != null) {
            GraphQLAlbum graphQLAlbum = (GraphQLAlbum) graphQLModelMutatingVisitor.mo2928b(m23162k());
            if (m23162k() != graphQLAlbum) {
                graphQLVisitableModel = (GraphQLEvent) ModelHelper.m23095a(null, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16320e = graphQLAlbum;
            }
        }
        if (m23163l() != null) {
            graphQLEventDeclinesConnection = (GraphQLEventDeclinesConnection) graphQLModelMutatingVisitor.mo2928b(m23163l());
            if (m23163l() != graphQLEventDeclinesConnection) {
                graphQLVisitableModel = (GraphQLEvent) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16321f = graphQLEventDeclinesConnection;
            }
        }
        if (m23164m() != null) {
            graphQLEventMaybesConnection = (GraphQLEventMaybesConnection) graphQLModelMutatingVisitor.mo2928b(m23164m());
            if (m23164m() != graphQLEventMaybesConnection) {
                graphQLVisitableModel = (GraphQLEvent) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16322g = graphQLEventMaybesConnection;
            }
        }
        if (m23165n() != null) {
            graphQLEventMembersConnection = (GraphQLEventMembersConnection) graphQLModelMutatingVisitor.mo2928b(m23165n());
            if (m23165n() != graphQLEventMembersConnection) {
                graphQLVisitableModel = (GraphQLEvent) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16323h = graphQLEventMembersConnection;
            }
        }
        if (m23166o() != null) {
            GraphQLInlineActivity graphQLInlineActivity = (GraphQLInlineActivity) graphQLModelMutatingVisitor.mo2928b(m23166o());
            if (m23166o() != graphQLInlineActivity) {
                graphQLVisitableModel = (GraphQLEvent) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16324i = graphQLInlineActivity;
            }
        }
        if (m23167p() != null) {
            graphQLFocusedPhoto = (GraphQLFocusedPhoto) graphQLModelMutatingVisitor.mo2928b(m23167p());
            if (m23167p() != graphQLFocusedPhoto) {
                graphQLVisitableModel = (GraphQLEvent) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16325j = graphQLFocusedPhoto;
            }
        }
        if (m23168q() != null) {
            graphQLStory = (GraphQLStory) graphQLModelMutatingVisitor.mo2928b(m23168q());
            if (m23168q() != graphQLStory) {
                graphQLVisitableModel = (GraphQLEvent) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16326k = graphQLStory;
            }
        }
        if (m23177z() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(m23177z());
            if (m23177z() != graphQLImage) {
                graphQLVisitableModel = (GraphQLEvent) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16335t = graphQLImage;
            }
        }
        if (m23131C() != null) {
            graphQLFocusedPhoto = (GraphQLFocusedPhoto) graphQLModelMutatingVisitor.mo2928b(m23131C());
            if (m23131C() != graphQLFocusedPhoto) {
                graphQLVisitableModel = (GraphQLEvent) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16338w = graphQLFocusedPhoto;
            }
        }
        if (m23132D() != null) {
            graphQLGroup = (GraphQLGroup) graphQLModelMutatingVisitor.mo2928b(m23132D());
            if (m23132D() != graphQLGroup) {
                graphQLVisitableModel = (GraphQLEvent) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16339x = graphQLGroup;
            }
        }
        if (m23133E() != null) {
            graphQLStory = (GraphQLStory) graphQLModelMutatingVisitor.mo2928b(m23133E());
            if (m23133E() != graphQLStory) {
                graphQLVisitableModel = (GraphQLEvent) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16340y = graphQLStory;
            }
        }
        if (m23136H() != null) {
            graphQLEventCategoryData = (GraphQLEventCategoryData) graphQLModelMutatingVisitor.mo2928b(m23136H());
            if (m23136H() != graphQLEventCategoryData) {
                graphQLVisitableModel = (GraphQLEvent) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16294B = graphQLEventCategoryData;
            }
        }
        if (m23137I() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(m23137I());
            if (m23137I() != graphQLImage) {
                graphQLVisitableModel = (GraphQLEvent) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16295C = graphQLImage;
            }
        }
        if (m23141M() != null) {
            graphQLEventCategoryData = (GraphQLEventCategoryData) graphQLModelMutatingVisitor.mo2928b(m23141M());
            if (m23141M() != graphQLEventCategoryData) {
                graphQLVisitableModel = (GraphQLEvent) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16299G = graphQLEventCategoryData;
            }
        }
        if (m23142N() != null) {
            graphQLFocusedPhoto = (GraphQLFocusedPhoto) graphQLModelMutatingVisitor.mo2928b(m23142N());
            if (m23142N() != graphQLFocusedPhoto) {
                graphQLVisitableModel = (GraphQLEvent) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16300H = graphQLFocusedPhoto;
            }
        }
        if (m23143O() != null) {
            GraphQLActor graphQLActor = (GraphQLActor) graphQLModelMutatingVisitor.mo2928b(m23143O());
            if (m23143O() != graphQLActor) {
                graphQLVisitableModel = (GraphQLEvent) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16301I = graphQLActor;
            }
        }
        if (m23144P() != null) {
            graphQLEventDeclinesConnection = (GraphQLEventDeclinesConnection) graphQLModelMutatingVisitor.mo2928b(m23144P());
            if (m23144P() != graphQLEventDeclinesConnection) {
                graphQLVisitableModel = (GraphQLEvent) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16302J = graphQLEventDeclinesConnection;
            }
        }
        if (m23145Q() != null) {
            graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.mo2928b(m23145Q());
            if (m23145Q() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLEvent) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16303K = graphQLTextWithEntities;
            }
        }
        if (m23146R() != null) {
            GraphQLEventHostsConnection graphQLEventHostsConnection = (GraphQLEventHostsConnection) graphQLModelMutatingVisitor.mo2928b(m23146R());
            if (m23146R() != graphQLEventHostsConnection) {
                graphQLVisitableModel = (GraphQLEvent) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16304L = graphQLEventHostsConnection;
            }
        }
        if (m23147S() != null) {
            graphQLEventInviteesConnection = (GraphQLEventInviteesConnection) graphQLModelMutatingVisitor.mo2928b(m23147S());
            if (m23147S() != graphQLEventInviteesConnection) {
                graphQLVisitableModel = (GraphQLEvent) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16305M = graphQLEventInviteesConnection;
            }
        }
        if (m23149U() != null) {
            graphQLEventMaybesConnection = (GraphQLEventMaybesConnection) graphQLModelMutatingVisitor.mo2928b(m23149U());
            if (m23149U() != graphQLEventMaybesConnection) {
                graphQLVisitableModel = (GraphQLEvent) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16307O = graphQLEventMaybesConnection;
            }
        }
        if (m23150V() != null) {
            graphQLEventMembersConnection = (GraphQLEventMembersConnection) graphQLModelMutatingVisitor.mo2928b(m23150V());
            if (m23150V() != graphQLEventMembersConnection) {
                graphQLVisitableModel = (GraphQLEvent) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16308P = graphQLEventMembersConnection;
            }
        }
        if (m23151W() != null) {
            GraphQLPlace graphQLPlace = (GraphQLPlace) graphQLModelMutatingVisitor.mo2928b(m23151W());
            if (m23151W() != graphQLPlace) {
                graphQLVisitableModel = (GraphQLEvent) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16309Q = graphQLPlace;
            }
        }
        if (bF() != null) {
            GraphQLEventTicketProvider graphQLEventTicketProvider = (GraphQLEventTicketProvider) graphQLModelMutatingVisitor.mo2928b(bF());
            if (bF() != graphQLEventTicketProvider) {
                graphQLVisitableModel = (GraphQLEvent) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.bz = graphQLEventTicketProvider;
            }
        }
        if (ac() != null) {
            GraphQLEventViewerCapability graphQLEventViewerCapability = (GraphQLEventViewerCapability) graphQLModelMutatingVisitor.mo2928b(ac());
            if (ac() != graphQLEventViewerCapability) {
                graphQLVisitableModel = (GraphQLEvent) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16315W = graphQLEventViewerCapability;
            }
        }
        if (ae() != null) {
            graphQLEventWatchersConnection = (GraphQLEventWatchersConnection) graphQLModelMutatingVisitor.mo2928b(ae());
            if (ae() != graphQLEventWatchersConnection) {
                graphQLVisitableModel = (GraphQLEvent) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16317Y = graphQLEventWatchersConnection;
            }
        }
        if (af() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(af());
            if (af() != graphQLImage) {
                graphQLVisitableModel = (GraphQLEvent) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16318Z = graphQLImage;
            }
        }
        if (ag() != null) {
            graphQLEventDeclinesConnection = (GraphQLEventDeclinesConnection) graphQLModelMutatingVisitor.mo2928b(ag());
            if (ag() != graphQLEventDeclinesConnection) {
                graphQLVisitableModel = (GraphQLEvent) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.aa = graphQLEventDeclinesConnection;
            }
        }
        if (ah() != null) {
            graphQLEventInviteesConnection = (GraphQLEventInviteesConnection) graphQLModelMutatingVisitor.mo2928b(ah());
            if (ah() != graphQLEventInviteesConnection) {
                graphQLVisitableModel = (GraphQLEvent) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.ab = graphQLEventInviteesConnection;
            }
        }
        if (ai() != null) {
            graphQLEventInviteesConnection = (GraphQLEventInviteesConnection) graphQLModelMutatingVisitor.mo2928b(ai());
            if (ai() != graphQLEventInviteesConnection) {
                graphQLVisitableModel = (GraphQLEvent) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.ac = graphQLEventInviteesConnection;
            }
        }
        if (aj() != null) {
            graphQLEventMaybesConnection = (GraphQLEventMaybesConnection) graphQLModelMutatingVisitor.mo2928b(aj());
            if (aj() != graphQLEventMaybesConnection) {
                graphQLVisitableModel = (GraphQLEvent) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.ad = graphQLEventMaybesConnection;
            }
        }
        if (ak() != null) {
            graphQLEventMaybesConnection = (GraphQLEventMaybesConnection) graphQLModelMutatingVisitor.mo2928b(ak());
            if (ak() != graphQLEventMaybesConnection) {
                graphQLVisitableModel = (GraphQLEvent) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.ae = graphQLEventMaybesConnection;
            }
        }
        if (al() != null) {
            graphQLEventMembersConnection = (GraphQLEventMembersConnection) graphQLModelMutatingVisitor.mo2928b(al());
            if (al() != graphQLEventMembersConnection) {
                graphQLVisitableModel = (GraphQLEvent) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.af = graphQLEventMembersConnection;
            }
        }
        if (am() != null) {
            graphQLEventMembersConnection = (GraphQLEventMembersConnection) graphQLModelMutatingVisitor.mo2928b(am());
            if (am() != graphQLEventMembersConnection) {
                graphQLVisitableModel = (GraphQLEvent) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.ag = graphQLEventMembersConnection;
            }
        }
        if (an() != null) {
            graphQLEventWatchersConnection = (GraphQLEventWatchersConnection) graphQLModelMutatingVisitor.mo2928b(an());
            if (an() != graphQLEventWatchersConnection) {
                graphQLVisitableModel = (GraphQLEvent) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.ah = graphQLEventWatchersConnection;
            }
        }
        if (ao() != null) {
            graphQLEventWatchersConnection = (GraphQLEventWatchersConnection) graphQLModelMutatingVisitor.mo2928b(ao());
            if (ao() != graphQLEventWatchersConnection) {
                graphQLVisitableModel = (GraphQLEvent) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.ai = graphQLEventWatchersConnection;
            }
        }
        if (ap() != null) {
            graphQLEventMembersConnection = (GraphQLEventMembersConnection) graphQLModelMutatingVisitor.mo2928b(ap());
            if (ap() != graphQLEventMembersConnection) {
                graphQLVisitableModel = (GraphQLEvent) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.aj = graphQLEventMembersConnection;
            }
        }
        if (aq() != null) {
            graphQLEventWatchersConnection = (GraphQLEventWatchersConnection) graphQLModelMutatingVisitor.mo2928b(aq());
            if (aq() != graphQLEventWatchersConnection) {
                graphQLVisitableModel = (GraphQLEvent) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.ak = graphQLEventWatchersConnection;
            }
        }
        if (ar() != null) {
            graphQLEventInviteesConnection = (GraphQLEventInviteesConnection) graphQLModelMutatingVisitor.mo2928b(ar());
            if (ar() != graphQLEventInviteesConnection) {
                graphQLVisitableModel = (GraphQLEvent) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.al = graphQLEventInviteesConnection;
            }
        }
        if (at() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(at());
            if (at() != graphQLImage) {
                graphQLVisitableModel = (GraphQLEvent) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.an = graphQLImage;
            }
        }
        if (au() != null) {
            GraphQLInlineActivitiesConnection graphQLInlineActivitiesConnection = (GraphQLInlineActivitiesConnection) graphQLModelMutatingVisitor.mo2928b(au());
            if (au() != graphQLInlineActivitiesConnection) {
                graphQLVisitableModel = (GraphQLEvent) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.ao = graphQLInlineActivitiesConnection;
            }
        }
        if (aB() != null) {
            GraphQLLocation graphQLLocation = (GraphQLLocation) graphQLModelMutatingVisitor.mo2928b(aB());
            if (aB() != graphQLLocation) {
                graphQLVisitableModel = (GraphQLEvent) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.av = graphQLLocation;
            }
        }
        if (aC() != null) {
            GraphQLGeoRectangle graphQLGeoRectangle = (GraphQLGeoRectangle) graphQLModelMutatingVisitor.mo2928b(aC());
            if (aC() != graphQLGeoRectangle) {
                graphQLVisitableModel = (GraphQLEvent) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.aw = graphQLGeoRectangle;
            }
        }
        if (aG() != null) {
            GraphQLStoryAttachment graphQLStoryAttachment = (GraphQLStoryAttachment) graphQLModelMutatingVisitor.mo2928b(aG());
            if (aG() != graphQLStoryAttachment) {
                graphQLVisitableModel = (GraphQLEvent) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.aA = graphQLStoryAttachment;
            }
        }
        if (aH() != null) {
            graphQLEventDeclinesConnection = (GraphQLEventDeclinesConnection) graphQLModelMutatingVisitor.mo2928b(aH());
            if (aH() != graphQLEventDeclinesConnection) {
                graphQLVisitableModel = (GraphQLEvent) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.aB = graphQLEventDeclinesConnection;
            }
        }
        if (aI() != null) {
            graphQLEventInviteesConnection = (GraphQLEventInviteesConnection) graphQLModelMutatingVisitor.mo2928b(aI());
            if (aI() != graphQLEventInviteesConnection) {
                graphQLVisitableModel = (GraphQLEvent) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.aC = graphQLEventInviteesConnection;
            }
        }
        if (aJ() != null) {
            graphQLEventMaybesConnection = (GraphQLEventMaybesConnection) graphQLModelMutatingVisitor.mo2928b(aJ());
            if (aJ() != graphQLEventMaybesConnection) {
                graphQLVisitableModel = (GraphQLEvent) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.aD = graphQLEventMaybesConnection;
            }
        }
        if (aK() != null) {
            graphQLEventMembersConnection = (GraphQLEventMembersConnection) graphQLModelMutatingVisitor.mo2928b(aK());
            if (aK() != graphQLEventMembersConnection) {
                graphQLVisitableModel = (GraphQLEvent) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.aE = graphQLEventMembersConnection;
            }
        }
        if (aL() != null) {
            graphQLEventWatchersConnection = (GraphQLEventWatchersConnection) graphQLModelMutatingVisitor.mo2928b(aL());
            if (aL() != graphQLEventWatchersConnection) {
                graphQLVisitableModel = (GraphQLEvent) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.aF = graphQLEventWatchersConnection;
            }
        }
        if (aM() != null) {
            graphQLGroup = (GraphQLGroup) graphQLModelMutatingVisitor.mo2928b(aM());
            if (aM() != graphQLGroup) {
                graphQLVisitableModel = (GraphQLEvent) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.aG = graphQLGroup;
            }
        }
        if (aO() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(aO());
            if (aO() != graphQLImage) {
                graphQLVisitableModel = (GraphQLEvent) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.aI = graphQLImage;
            }
        }
        if (aS() != null) {
            graphQLPrivacyScope = (GraphQLPrivacyScope) graphQLModelMutatingVisitor.mo2928b(aS());
            if (aS() != graphQLPrivacyScope) {
                graphQLVisitableModel = (GraphQLEvent) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.aM = graphQLPrivacyScope;
            }
        }
        if (aT() != null) {
            graphQLPrivacyScope = (GraphQLPrivacyScope) graphQLModelMutatingVisitor.mo2928b(aT());
            if (aT() != graphQLPrivacyScope) {
                graphQLVisitableModel = (GraphQLEvent) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.aN = graphQLPrivacyScope;
            }
        }
        if (aU() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(aU());
            if (aU() != graphQLImage) {
                graphQLVisitableModel = (GraphQLEvent) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.aO = graphQLImage;
            }
        }
        if (aV() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(aV());
            if (aV() != graphQLImage) {
                graphQLVisitableModel = (GraphQLEvent) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.aP = graphQLImage;
            }
        }
        if (aW() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(aW());
            if (aW() != graphQLImage) {
                graphQLVisitableModel = (GraphQLEvent) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.aQ = graphQLImage;
            }
        }
        if (aX() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(aX());
            if (aX() != graphQLImage) {
                graphQLVisitableModel = (GraphQLEvent) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.aR = graphQLImage;
            }
        }
        if (aY() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(aY());
            if (aY() != graphQLImage) {
                graphQLVisitableModel = (GraphQLEvent) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.aS = graphQLImage;
            }
        }
        if (aZ() != null) {
            GraphQLPhoto graphQLPhoto = (GraphQLPhoto) graphQLModelMutatingVisitor.mo2928b(aZ());
            if (aZ() != graphQLPhoto) {
                graphQLVisitableModel = (GraphQLEvent) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.aT = graphQLPhoto;
            }
        }
        if (ba() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(ba());
            if (ba() != graphQLImage) {
                graphQLVisitableModel = (GraphQLEvent) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.aU = graphQLImage;
            }
        }
        if (bb() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(bb());
            if (bb() != graphQLImage) {
                graphQLVisitableModel = (GraphQLEvent) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.aV = graphQLImage;
            }
        }
        if (bc() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(bc());
            if (bc() != graphQLImage) {
                graphQLVisitableModel = (GraphQLEvent) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.aW = graphQLImage;
            }
        }
        if (bd() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(bd());
            if (bd() != graphQLImage) {
                graphQLVisitableModel = (GraphQLEvent) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.aX = graphQLImage;
            }
        }
        if (bf() != null) {
            GraphQLTimelineAppCollection graphQLTimelineAppCollection = (GraphQLTimelineAppCollection) graphQLModelMutatingVisitor.mo2928b(bf());
            if (bf() != graphQLTimelineAppCollection) {
                graphQLVisitableModel = (GraphQLEvent) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.aZ = graphQLTimelineAppCollection;
            }
        }
        if (bg() != null) {
            graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.mo2928b(bg());
            if (bg() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLEvent) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.ba = graphQLTextWithEntities;
            }
        }
        if (bj() != null) {
            GraphQLStreamingImage graphQLStreamingImage = (GraphQLStreamingImage) graphQLModelMutatingVisitor.mo2928b(bj());
            if (bj() != graphQLStreamingImage) {
                graphQLVisitableModel = (GraphQLEvent) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.bd = graphQLStreamingImage;
            }
        }
        if (bk() != null) {
            graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.mo2928b(bk());
            if (bk() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLEvent) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.be = graphQLTextWithEntities;
            }
        }
        if (bm() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(bm());
            if (bm() != graphQLImage) {
                graphQLVisitableModel = (GraphQLEvent) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.bg = graphQLImage;
            }
        }
        if (bn() != null) {
            GraphQLEventTimeRange graphQLEventTimeRange = (GraphQLEventTimeRange) graphQLModelMutatingVisitor.mo2928b(bn());
            if (bn() != graphQLEventTimeRange) {
                graphQLVisitableModel = (GraphQLEvent) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.bh = graphQLEventTimeRange;
            }
        }
        if (bv() != null) {
            a = ModelHelper.m23097a(bv(), graphQLModelMutatingVisitor);
            if (a != null) {
                GraphQLEvent graphQLEvent = (GraphQLEvent) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLEvent.bp = a.m1068b();
                graphQLVisitableModel = graphQLEvent;
            }
        }
        if (by() != null) {
            a = ModelHelper.m23097a(by(), graphQLModelMutatingVisitor);
            if (a != null) {
                graphQLEvent = (GraphQLEvent) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLEvent.bs = a.m1068b();
                graphQLVisitableModel = graphQLEvent;
            }
        }
        if (bz() != null) {
            a = ModelHelper.m23097a(bz(), graphQLModelMutatingVisitor);
            if (a != null) {
                graphQLEvent = (GraphQLEvent) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLEvent.bt = a.m1068b();
                graphQLVisitableModel = graphQLEvent;
            }
        }
        m9959i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public final void mo2835a(String str, ConsistencyTuple consistencyTuple) {
        if ("event_declines.count".equals(str)) {
            GraphQLEventDeclinesConnection P = m23144P();
            if (P != null) {
                consistencyTuple.f18727a = Integer.valueOf(P.a());
                consistencyTuple.f18728b = P.u_();
                consistencyTuple.f18729c = 0;
                return;
            }
        } else if ("event_invitees.count".equals(str)) {
            GraphQLEventInviteesConnection S = m23147S();
            if (S != null) {
                consistencyTuple.f18727a = Integer.valueOf(S.a());
                consistencyTuple.f18728b = S.u_();
                consistencyTuple.f18729c = 0;
                return;
            }
        } else if ("event_maybes.count".equals(str)) {
            r0 = m23149U();
            if (r0 != null) {
                consistencyTuple.f18727a = Integer.valueOf(r0.m24215a());
                consistencyTuple.f18728b = r0.u_();
                consistencyTuple.f18729c = 0;
                return;
            }
        } else if ("event_members.count".equals(str)) {
            r0 = m23150V();
            if (r0 != null) {
                consistencyTuple.f18727a = Integer.valueOf(r0.m24115a());
                consistencyTuple.f18728b = r0.u_();
                consistencyTuple.f18729c = 0;
                return;
            }
        } else if ("event_watchers.count".equals(str)) {
            r0 = ae();
            if (r0 != null) {
                consistencyTuple.f18727a = Integer.valueOf(r0.m24224a());
                consistencyTuple.f18728b = r0.u_();
                consistencyTuple.f18729c = 0;
                return;
            }
        } else if ("is_canceled".equals(str)) {
            consistencyTuple.f18727a = Boolean.valueOf(aw());
            consistencyTuple.f18728b = u_();
            consistencyTuple.f18729c = 66;
            return;
        } else if ("name".equals(str)) {
            consistencyTuple.f18727a = aE();
            consistencyTuple.f18728b = u_();
            consistencyTuple.f18729c = 75;
            return;
        } else if ("time_range.end".equals(str)) {
            r0 = bn();
            if (r0 != null) {
                consistencyTuple.f18727a = r0.m24891a();
                consistencyTuple.f18728b = r0.u_();
                consistencyTuple.f18729c = 0;
                return;
            }
        } else if ("time_range.start".equals(str)) {
            r0 = bn();
            if (r0 != null) {
                consistencyTuple.f18727a = r0.m24895j();
                consistencyTuple.f18728b = r0.u_();
                consistencyTuple.f18729c = 1;
                return;
            }
        } else if ("time_range.timezone".equals(str)) {
            r0 = bn();
            if (r0 != null) {
                consistencyTuple.f18727a = r0.m24896k();
                consistencyTuple.f18728b = r0.u_();
                consistencyTuple.f18729c = 2;
                return;
            }
        } else if ("viewer_guest_status".equals(str)) {
            consistencyTuple.f18727a = bt();
            consistencyTuple.f18728b = u_();
            consistencyTuple.f18729c = 116;
            return;
        } else if ("viewer_has_pending_invite".equals(str)) {
            consistencyTuple.f18727a = Boolean.valueOf(bu());
            consistencyTuple.f18728b = u_();
            consistencyTuple.f18729c = 117;
            return;
        } else if ("viewer_notification_subscription_level".equals(str)) {
            consistencyTuple.f18727a = bw();
            consistencyTuple.f18728b = u_();
            consistencyTuple.f18729c = 119;
            return;
        } else if ("viewer_watch_status".equals(str)) {
            consistencyTuple.f18727a = bA();
            consistencyTuple.f18728b = u_();
            consistencyTuple.f18729c = 123;
            return;
        }
        consistencyTuple.m26322a();
    }

    public final void mo2836a(String str, Object obj, boolean z) {
        if ("event_declines.count".equals(str)) {
            GraphQLEventDeclinesConnection P = m23144P();
            if (P == null) {
                return;
            }
            if (z) {
                P = (GraphQLEventDeclinesConnection) P.clone();
                P.a(((Integer) obj).intValue());
                this.f16302J = P;
                return;
            }
            P.a(((Integer) obj).intValue());
        } else if ("event_invitees.count".equals(str)) {
            GraphQLEventInviteesConnection S = m23147S();
            if (S == null) {
                return;
            }
            if (z) {
                S = (GraphQLEventInviteesConnection) S.clone();
                S.a(((Integer) obj).intValue());
                this.f16305M = S;
                return;
            }
            S.a(((Integer) obj).intValue());
        } else if ("event_maybes.count".equals(str)) {
            r0 = m23149U();
            if (r0 == null) {
                return;
            }
            if (z) {
                GraphQLEventMaybesConnection graphQLEventMaybesConnection = (GraphQLEventMaybesConnection) r0.clone();
                graphQLEventMaybesConnection.mo2908a(((Integer) obj).intValue());
                this.f16307O = graphQLEventMaybesConnection;
                return;
            }
            r0.mo2908a(((Integer) obj).intValue());
        } else if ("event_members.count".equals(str)) {
            r0 = m23150V();
            if (r0 == null) {
                return;
            }
            if (z) {
                GraphQLEventMembersConnection graphQLEventMembersConnection = (GraphQLEventMembersConnection) r0.clone();
                graphQLEventMembersConnection.mo2908a(((Integer) obj).intValue());
                this.f16308P = graphQLEventMembersConnection;
                return;
            }
            r0.mo2908a(((Integer) obj).intValue());
        } else if ("event_watchers.count".equals(str)) {
            r0 = ae();
            if (r0 == null) {
                return;
            }
            if (z) {
                GraphQLEventWatchersConnection graphQLEventWatchersConnection = (GraphQLEventWatchersConnection) r0.clone();
                graphQLEventWatchersConnection.mo2908a(((Integer) obj).intValue());
                this.f16317Y = graphQLEventWatchersConnection;
                return;
            }
            r0.mo2908a(((Integer) obj).intValue());
        } else if ("is_canceled".equals(str)) {
            r0 = ((Boolean) obj).booleanValue();
            this.aq = r0;
            if (this.f5823b != null && this.f5823b.f15024d) {
                this.f5823b.m21538a(this.f5824c, 66, r0);
            }
        } else if ("name".equals(str)) {
            String str2 = (String) obj;
            this.ay = str2;
            if (this.f5823b != null && this.f5823b.f15024d) {
                this.f5823b.m21537a(this.f5824c, 75, str2);
            }
        } else if ("time_range.end".equals(str)) {
            r0 = bn();
            if (r0 == null) {
                return;
            }
            if (z) {
                r0 = (GraphQLEventTimeRange) r0.clone();
                r0.m24892a((String) obj);
                this.bh = r0;
                return;
            }
            r0.m24892a((String) obj);
        } else if ("time_range.start".equals(str)) {
            r0 = bn();
            if (r0 == null) {
                return;
            }
            if (z) {
                r0 = (GraphQLEventTimeRange) r0.clone();
                r0.m24893b((String) obj);
                this.bh = r0;
                return;
            }
            r0.m24893b((String) obj);
        } else if ("time_range.timezone".equals(str)) {
            r0 = bn();
            if (r0 == null) {
                return;
            }
            if (z) {
                r0 = (GraphQLEventTimeRange) r0.clone();
                r0.m24894c((String) obj);
                this.bh = r0;
                return;
            }
            r0.m24894c((String) obj);
        } else if ("viewer_guest_status".equals(str)) {
            r8 = (GraphQLEventGuestStatus) obj;
            this.bn = r8;
            if (this.f5823b != null && this.f5823b.f15024d) {
                this.f5823b.m21536a(this.f5824c, 116, r8);
            }
        } else if ("viewer_has_pending_invite".equals(str)) {
            r0 = ((Boolean) obj).booleanValue();
            this.bo = r0;
            if (this.f5823b != null && this.f5823b.f15024d) {
                this.f5823b.m21538a(this.f5824c, 117, r0);
            }
        } else if ("viewer_notification_subscription_level".equals(str)) {
            r8 = (GraphQLEventNotificationSubscriptionLevel) obj;
            this.bq = r8;
            if (this.f5823b != null && this.f5823b.f15024d) {
                this.f5823b.m21536a(this.f5824c, 119, r8);
            }
        } else if ("viewer_watch_status".equals(str)) {
            r8 = (GraphQLEventWatchStatus) obj;
            this.bu = r8;
            if (this.f5823b != null && this.f5823b.f15024d) {
                this.f5823b.m21536a(this.f5824c, 123, r8);
            }
        }
    }

    public GraphQLEvent() {
        super(131);
    }

    public final void mo1406a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.mo1406a(mutableFlatBuffer, i, obj);
        this.f16327l = mutableFlatBuffer.m21540a(i, 8);
        this.f16328m = mutableFlatBuffer.m21540a(i, 9);
        this.f16329n = mutableFlatBuffer.m21540a(i, 10);
        this.f16330o = mutableFlatBuffer.m21540a(i, 11);
        this.f16331p = mutableFlatBuffer.m21540a(i, 12);
        this.f16332q = mutableFlatBuffer.m21540a(i, 13);
        this.f16333r = mutableFlatBuffer.m21540a(i, 14);
        this.f16334s = mutableFlatBuffer.m21540a(i, 15);
        this.f16341z = mutableFlatBuffer.m21525a(i, 22, 0);
        this.f16293A = mutableFlatBuffer.m21525a(i, 23, 0);
        this.f16313U = mutableFlatBuffer.m21524a(i, 43, 0);
        this.f16314V = mutableFlatBuffer.m21524a(i, 44, 0);
        this.ap = mutableFlatBuffer.m21540a(i, 65);
        this.aq = mutableFlatBuffer.m21540a(i, 66);
        this.ar = mutableFlatBuffer.m21540a(i, 67);
        this.as = mutableFlatBuffer.m21540a(i, 68);
        this.at = mutableFlatBuffer.m21540a(i, 69);
        this.ax = mutableFlatBuffer.m21524a(i, 74, 0);
        this.aH = mutableFlatBuffer.m21524a(i, 84, 0);
        this.aL = mutableFlatBuffer.m21540a(i, 88);
        this.aY = mutableFlatBuffer.m21540a(i, 101);
        this.bc = mutableFlatBuffer.m21525a(i, 105, 0);
        this.bf = mutableFlatBuffer.m21540a(i, 108);
        this.bk = mutableFlatBuffer.m21524a(i, 113, 0);
        this.bo = mutableFlatBuffer.m21540a(i, 117);
        this.bw = mutableFlatBuffer.m21540a(i, 125);
        this.bx = mutableFlatBuffer.m21525a(i, 127, 0);
        this.by = mutableFlatBuffer.m21540a(i, (int) HTTPTransportCallback.BODY_BYTES_RECEIVED);
    }

    public final int mo1403a(FlatBufferBuilder flatBufferBuilder) {
        m9958h();
        int a = ModelHelper.m23093a(flatBufferBuilder, m23162k());
        int a2 = ModelHelper.m23093a(flatBufferBuilder, m23163l());
        int a3 = ModelHelper.m23093a(flatBufferBuilder, m23164m());
        int a4 = ModelHelper.m23093a(flatBufferBuilder, m23165n());
        int a5 = ModelHelper.m23093a(flatBufferBuilder, m23166o());
        int a6 = ModelHelper.m23093a(flatBufferBuilder, m23167p());
        int a7 = ModelHelper.m23093a(flatBufferBuilder, m23168q());
        int a8 = ModelHelper.m23093a(flatBufferBuilder, m23177z());
        int b = flatBufferBuilder.m21502b(m23130B());
        int a9 = ModelHelper.m23093a(flatBufferBuilder, m23131C());
        int a10 = ModelHelper.m23093a(flatBufferBuilder, m23132D());
        int a11 = ModelHelper.m23093a(flatBufferBuilder, m23133E());
        int a12 = ModelHelper.m23093a(flatBufferBuilder, m23136H());
        int a13 = ModelHelper.m23093a(flatBufferBuilder, m23137I());
        int b2 = flatBufferBuilder.m21502b(m23138J());
        int b3 = flatBufferBuilder.m21502b(m23139K());
        int b4 = flatBufferBuilder.m21502b(m23140L());
        int a14 = ModelHelper.m23093a(flatBufferBuilder, m23141M());
        int a15 = ModelHelper.m23093a(flatBufferBuilder, m23142N());
        int a16 = ModelHelper.m23093a(flatBufferBuilder, m23143O());
        int a17 = ModelHelper.m23093a(flatBufferBuilder, m23144P());
        int a18 = ModelHelper.m23093a(flatBufferBuilder, m23145Q());
        int a19 = ModelHelper.m23093a(flatBufferBuilder, m23146R());
        int a20 = ModelHelper.m23093a(flatBufferBuilder, m23147S());
        int a21 = ModelHelper.m23093a(flatBufferBuilder, m23149U());
        int a22 = ModelHelper.m23093a(flatBufferBuilder, m23150V());
        int a23 = ModelHelper.m23093a(flatBufferBuilder, m23151W());
        int b5 = flatBufferBuilder.m21502b(m23153Y());
        int a24 = ModelHelper.m23093a(flatBufferBuilder, ac());
        int a25 = ModelHelper.m23093a(flatBufferBuilder, ae());
        int a26 = ModelHelper.m23093a(flatBufferBuilder, af());
        int a27 = ModelHelper.m23093a(flatBufferBuilder, ag());
        int a28 = ModelHelper.m23093a(flatBufferBuilder, ah());
        int a29 = ModelHelper.m23093a(flatBufferBuilder, ai());
        int a30 = ModelHelper.m23093a(flatBufferBuilder, aj());
        int a31 = ModelHelper.m23093a(flatBufferBuilder, ak());
        int a32 = ModelHelper.m23093a(flatBufferBuilder, al());
        int a33 = ModelHelper.m23093a(flatBufferBuilder, am());
        int a34 = ModelHelper.m23093a(flatBufferBuilder, an());
        int a35 = ModelHelper.m23093a(flatBufferBuilder, ao());
        int a36 = ModelHelper.m23093a(flatBufferBuilder, ap());
        int a37 = ModelHelper.m23093a(flatBufferBuilder, aq());
        int a38 = ModelHelper.m23093a(flatBufferBuilder, ar());
        int b6 = flatBufferBuilder.m21502b(as());
        int a39 = ModelHelper.m23093a(flatBufferBuilder, at());
        int a40 = ModelHelper.m23093a(flatBufferBuilder, au());
        int b7 = flatBufferBuilder.m21502b(aA());
        int a41 = ModelHelper.m23093a(flatBufferBuilder, aB());
        int a42 = ModelHelper.m23093a(flatBufferBuilder, aC());
        int b8 = flatBufferBuilder.m21502b(aE());
        int c = flatBufferBuilder.m21509c(aF());
        int a43 = ModelHelper.m23093a(flatBufferBuilder, aG());
        int a44 = ModelHelper.m23093a(flatBufferBuilder, aH());
        int a45 = ModelHelper.m23093a(flatBufferBuilder, aI());
        int a46 = ModelHelper.m23093a(flatBufferBuilder, aJ());
        int a47 = ModelHelper.m23093a(flatBufferBuilder, aK());
        int a48 = ModelHelper.m23093a(flatBufferBuilder, aL());
        int a49 = ModelHelper.m23093a(flatBufferBuilder, aM());
        int a50 = ModelHelper.m23093a(flatBufferBuilder, aO());
        int b9 = flatBufferBuilder.m21502b(aP());
        int a51 = ModelHelper.m23093a(flatBufferBuilder, aS());
        int a52 = ModelHelper.m23093a(flatBufferBuilder, aT());
        int a53 = ModelHelper.m23093a(flatBufferBuilder, aU());
        int a54 = ModelHelper.m23093a(flatBufferBuilder, aV());
        int a55 = ModelHelper.m23093a(flatBufferBuilder, aW());
        int a56 = ModelHelper.m23093a(flatBufferBuilder, aX());
        int a57 = ModelHelper.m23093a(flatBufferBuilder, aY());
        int a58 = ModelHelper.m23093a(flatBufferBuilder, aZ());
        int a59 = ModelHelper.m23093a(flatBufferBuilder, ba());
        int a60 = ModelHelper.m23093a(flatBufferBuilder, bb());
        int a61 = ModelHelper.m23093a(flatBufferBuilder, bc());
        int a62 = ModelHelper.m23093a(flatBufferBuilder, bd());
        int a63 = ModelHelper.m23093a(flatBufferBuilder, bf());
        int a64 = ModelHelper.m23093a(flatBufferBuilder, bg());
        int b10 = flatBufferBuilder.m21502b(bh());
        int a65 = ModelHelper.m23093a(flatBufferBuilder, bj());
        int a66 = ModelHelper.m23093a(flatBufferBuilder, bk());
        int a67 = ModelHelper.m23093a(flatBufferBuilder, bm());
        int a68 = ModelHelper.m23093a(flatBufferBuilder, bn());
        int b11 = flatBufferBuilder.m21502b(bo());
        int b12 = flatBufferBuilder.m21502b(bp());
        int b13 = flatBufferBuilder.m21502b(br());
        int b14 = flatBufferBuilder.m21502b(bs());
        int a69 = ModelHelper.m23094a(flatBufferBuilder, bv());
        int a70 = ModelHelper.m23094a(flatBufferBuilder, by());
        int a71 = ModelHelper.m23094a(flatBufferBuilder, bz());
        int a72 = ModelHelper.m23093a(flatBufferBuilder, bF());
        flatBufferBuilder.m21510c(130);
        flatBufferBuilder.m21496a(0, m23161j() == GraphQLEventActionStyle.UNSET_OR_UNRECOGNIZED_ENUM_VALUE ? null : m23161j());
        flatBufferBuilder.m21507b(1, a);
        flatBufferBuilder.m21507b(2, a2);
        flatBufferBuilder.m21507b(3, a3);
        flatBufferBuilder.m21507b(4, a4);
        flatBufferBuilder.m21507b(5, a5);
        flatBufferBuilder.m21507b(6, a6);
        flatBufferBuilder.m21507b(7, a7);
        flatBufferBuilder.m21498a(8, m23169r());
        flatBufferBuilder.m21498a(9, m23170s());
        flatBufferBuilder.m21498a(10, m23171t());
        flatBufferBuilder.m21498a(11, m23172u());
        flatBufferBuilder.m21498a(12, m23173v());
        flatBufferBuilder.m21498a(13, m23174w());
        flatBufferBuilder.m21498a(14, m23175x());
        flatBufferBuilder.m21498a(15, m23176y());
        flatBufferBuilder.m21507b(16, a8);
        flatBufferBuilder.m21496a(17, m23129A() == GraphQLConnectionStyle.UNSET_OR_UNRECOGNIZED_ENUM_VALUE ? null : m23129A());
        flatBufferBuilder.m21507b(18, b);
        flatBufferBuilder.m21507b(19, a9);
        flatBufferBuilder.m21507b(20, a10);
        flatBufferBuilder.m21507b(21, a11);
        flatBufferBuilder.m21495a(22, m23134F(), 0);
        flatBufferBuilder.m21495a(23, m23135G(), 0);
        flatBufferBuilder.m21507b(24, a12);
        flatBufferBuilder.m21507b(25, a13);
        flatBufferBuilder.m21507b(26, b2);
        flatBufferBuilder.m21507b(27, b3);
        flatBufferBuilder.m21507b(28, b4);
        flatBufferBuilder.m21507b(29, a14);
        flatBufferBuilder.m21507b(30, a15);
        flatBufferBuilder.m21507b(31, a16);
        flatBufferBuilder.m21507b(32, a17);
        flatBufferBuilder.m21507b(33, a18);
        flatBufferBuilder.m21507b(34, a19);
        flatBufferBuilder.m21507b(35, a20);
        flatBufferBuilder.m21496a(36, m23148T() == GraphQLEventPrivacyType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE ? null : m23148T());
        flatBufferBuilder.m21507b(37, a21);
        flatBufferBuilder.m21507b(38, a22);
        flatBufferBuilder.m21507b(39, a23);
        flatBufferBuilder.m21496a(40, m23152X() == GraphQLEventPrivacyType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE ? null : m23152X());
        flatBufferBuilder.m21507b(41, b5);
        flatBufferBuilder.m21496a(42, m23154Z() == GraphQLEventType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE ? null : m23154Z());
        flatBufferBuilder.m21494a(43, aa(), 0);
        flatBufferBuilder.m21494a(44, ab(), 0);
        flatBufferBuilder.m21507b(45, a24);
        flatBufferBuilder.m21496a(46, ad() == GraphQLEventVisibility.UNSET_OR_UNRECOGNIZED_ENUM_VALUE ? null : ad());
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
        flatBufferBuilder.m21507b(57, a35);
        flatBufferBuilder.m21507b(58, a36);
        flatBufferBuilder.m21507b(59, a37);
        flatBufferBuilder.m21507b(60, a38);
        flatBufferBuilder.m21507b(62, b6);
        flatBufferBuilder.m21507b(63, a39);
        flatBufferBuilder.m21507b(64, a40);
        flatBufferBuilder.m21498a(65, av());
        flatBufferBuilder.m21498a(66, aw());
        flatBufferBuilder.m21498a(67, ax());
        flatBufferBuilder.m21498a(68, ay());
        flatBufferBuilder.m21498a(69, az());
        flatBufferBuilder.m21507b(71, b7);
        flatBufferBuilder.m21507b(72, a41);
        flatBufferBuilder.m21507b(73, a42);
        flatBufferBuilder.m21494a(74, aD(), 0);
        flatBufferBuilder.m21507b(75, b8);
        flatBufferBuilder.m21507b(76, c);
        flatBufferBuilder.m21507b(77, a43);
        flatBufferBuilder.m21507b(78, a44);
        flatBufferBuilder.m21507b(79, a45);
        flatBufferBuilder.m21507b(80, a46);
        flatBufferBuilder.m21507b(81, a47);
        flatBufferBuilder.m21507b(82, a48);
        flatBufferBuilder.m21507b(83, a49);
        flatBufferBuilder.m21494a(84, aN(), 0);
        flatBufferBuilder.m21507b(85, a50);
        flatBufferBuilder.m21507b(86, b9);
        flatBufferBuilder.m21496a(87, aQ() == GraphQLPlaceType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE ? null : aQ());
        flatBufferBuilder.m21498a(88, aR());
        flatBufferBuilder.m21507b(89, a51);
        flatBufferBuilder.m21507b(90, a52);
        flatBufferBuilder.m21507b(91, a53);
        flatBufferBuilder.m21507b(92, a54);
        flatBufferBuilder.m21507b(93, a55);
        flatBufferBuilder.m21507b(94, a56);
        flatBufferBuilder.m21507b(95, a57);
        flatBufferBuilder.m21507b(96, a58);
        flatBufferBuilder.m21507b(97, a59);
        flatBufferBuilder.m21507b(98, a60);
        flatBufferBuilder.m21507b(99, a61);
        flatBufferBuilder.m21507b(100, a62);
        flatBufferBuilder.m21498a(101, be());
        flatBufferBuilder.m21507b(102, a63);
        flatBufferBuilder.m21507b(103, a64);
        flatBufferBuilder.m21507b(104, b10);
        flatBufferBuilder.m21495a(105, bi(), 0);
        flatBufferBuilder.m21507b(106, a65);
        flatBufferBuilder.m21507b(107, a66);
        flatBufferBuilder.m21498a(108, bl());
        flatBufferBuilder.m21507b(109, a67);
        flatBufferBuilder.m21507b(110, a68);
        flatBufferBuilder.m21507b(111, b11);
        flatBufferBuilder.m21507b(112, b12);
        flatBufferBuilder.m21494a(113, bq(), 0);
        flatBufferBuilder.m21507b(114, b13);
        flatBufferBuilder.m21507b(115, b14);
        flatBufferBuilder.m21496a(116, bt() == GraphQLEventGuestStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE ? null : bt());
        flatBufferBuilder.m21498a(117, bu());
        flatBufferBuilder.m21507b(118, a69);
        flatBufferBuilder.m21496a(119, bw() == GraphQLEventNotificationSubscriptionLevel.UNSET_OR_UNRECOGNIZED_ENUM_VALUE ? null : bw());
        flatBufferBuilder.m21496a(120, bx() == GraphQLSavedState.UNSET_OR_UNRECOGNIZED_ENUM_VALUE ? null : bx());
        flatBufferBuilder.m21507b(121, a70);
        flatBufferBuilder.m21507b(122, a71);
        flatBufferBuilder.m21496a(123, bA() == GraphQLEventWatchStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE ? null : bA());
        flatBufferBuilder.m21496a(124, bB() == GraphQLBoostedPostStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE ? null : bB());
        flatBufferBuilder.m21498a(125, bC());
        flatBufferBuilder.m21495a(127, bD(), 0);
        flatBufferBuilder.m21498a((int) HTTPTransportCallback.BODY_BYTES_RECEIVED, bE());
        flatBufferBuilder.m21507b(129, a72);
        m9959i();
        return flatBufferBuilder.m21511d();
    }

    public GraphQLEvent(Parcel parcel) {
        boolean z;
        boolean z2 = true;
        super(131);
        this.f16319d = GraphQLEventActionStyle.fromString(parcel.readString());
        this.f16320e = (GraphQLAlbum) parcel.readValue(GraphQLAlbum.class.getClassLoader());
        this.f16321f = (GraphQLEventDeclinesConnection) parcel.readValue(GraphQLEventDeclinesConnection.class.getClassLoader());
        this.f16322g = (GraphQLEventMaybesConnection) parcel.readValue(GraphQLEventMaybesConnection.class.getClassLoader());
        this.f16323h = (GraphQLEventMembersConnection) parcel.readValue(GraphQLEventMembersConnection.class.getClassLoader());
        this.f16324i = (GraphQLInlineActivity) parcel.readValue(GraphQLInlineActivity.class.getClassLoader());
        this.f16325j = (GraphQLFocusedPhoto) parcel.readValue(GraphQLFocusedPhoto.class.getClassLoader());
        this.f16326k = (GraphQLStory) parcel.readValue(GraphQLStory.class.getClassLoader());
        this.f16327l = parcel.readByte() == (byte) 1;
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.f16328m = z;
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.f16329n = z;
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.f16330o = z;
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.f16331p = z;
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.f16332q = z;
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.f16333r = z;
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.f16334s = z;
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.by = z;
        this.f16335t = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f16336u = GraphQLConnectionStyle.fromString(parcel.readString());
        this.f16337v = parcel.readString();
        this.f16338w = (GraphQLFocusedPhoto) parcel.readValue(GraphQLFocusedPhoto.class.getClassLoader());
        this.f16339x = (GraphQLGroup) parcel.readValue(GraphQLGroup.class.getClassLoader());
        this.f16340y = (GraphQLStory) parcel.readValue(GraphQLStory.class.getClassLoader());
        this.f16341z = parcel.readLong();
        this.f16293A = parcel.readLong();
        this.f16294B = (GraphQLEventCategoryData) parcel.readValue(GraphQLEventCategoryData.class.getClassLoader());
        this.f16295C = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f16296D = parcel.readString();
        this.f16297E = parcel.readString();
        this.f16298F = parcel.readString();
        this.f16299G = (GraphQLEventCategoryData) parcel.readValue(GraphQLEventCategoryData.class.getClassLoader());
        this.f16300H = (GraphQLFocusedPhoto) parcel.readValue(GraphQLFocusedPhoto.class.getClassLoader());
        this.f16301I = (GraphQLActor) parcel.readValue(GraphQLActor.class.getClassLoader());
        this.f16302J = (GraphQLEventDeclinesConnection) parcel.readValue(GraphQLEventDeclinesConnection.class.getClassLoader());
        this.f16303K = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.f16304L = (GraphQLEventHostsConnection) parcel.readValue(GraphQLEventHostsConnection.class.getClassLoader());
        this.f16305M = (GraphQLEventInviteesConnection) parcel.readValue(GraphQLEventInviteesConnection.class.getClassLoader());
        this.f16306N = GraphQLEventPrivacyType.fromString(parcel.readString());
        this.f16307O = (GraphQLEventMaybesConnection) parcel.readValue(GraphQLEventMaybesConnection.class.getClassLoader());
        this.f16308P = (GraphQLEventMembersConnection) parcel.readValue(GraphQLEventMembersConnection.class.getClassLoader());
        this.f16309Q = (GraphQLPlace) parcel.readValue(GraphQLPlace.class.getClassLoader());
        this.f16310R = GraphQLEventPrivacyType.fromString(parcel.readString());
        this.bv = GraphQLBoostedPostStatus.fromString(parcel.readString());
        this.bz = (GraphQLEventTicketProvider) parcel.readValue(GraphQLEventTicketProvider.class.getClassLoader());
        this.f16311S = parcel.readString();
        this.f16312T = GraphQLEventType.fromString(parcel.readString());
        this.f16313U = parcel.readInt();
        this.f16314V = parcel.readInt();
        this.f16315W = (GraphQLEventViewerCapability) parcel.readValue(GraphQLEventViewerCapability.class.getClassLoader());
        this.f16316X = GraphQLEventVisibility.fromString(parcel.readString());
        this.f16317Y = (GraphQLEventWatchersConnection) parcel.readValue(GraphQLEventWatchersConnection.class.getClassLoader());
        this.f16318Z = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.aa = (GraphQLEventDeclinesConnection) parcel.readValue(GraphQLEventDeclinesConnection.class.getClassLoader());
        this.ab = (GraphQLEventInviteesConnection) parcel.readValue(GraphQLEventInviteesConnection.class.getClassLoader());
        this.ac = (GraphQLEventInviteesConnection) parcel.readValue(GraphQLEventInviteesConnection.class.getClassLoader());
        this.ad = (GraphQLEventMaybesConnection) parcel.readValue(GraphQLEventMaybesConnection.class.getClassLoader());
        this.ae = (GraphQLEventMaybesConnection) parcel.readValue(GraphQLEventMaybesConnection.class.getClassLoader());
        this.af = (GraphQLEventMembersConnection) parcel.readValue(GraphQLEventMembersConnection.class.getClassLoader());
        this.ag = (GraphQLEventMembersConnection) parcel.readValue(GraphQLEventMembersConnection.class.getClassLoader());
        this.ah = (GraphQLEventWatchersConnection) parcel.readValue(GraphQLEventWatchersConnection.class.getClassLoader());
        this.ai = (GraphQLEventWatchersConnection) parcel.readValue(GraphQLEventWatchersConnection.class.getClassLoader());
        this.aj = (GraphQLEventMembersConnection) parcel.readValue(GraphQLEventMembersConnection.class.getClassLoader());
        this.ak = (GraphQLEventWatchersConnection) parcel.readValue(GraphQLEventWatchersConnection.class.getClassLoader());
        this.al = (GraphQLEventInviteesConnection) parcel.readValue(GraphQLEventInviteesConnection.class.getClassLoader());
        this.am = parcel.readString();
        this.an = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.ao = (GraphQLInlineActivitiesConnection) parcel.readValue(GraphQLInlineActivitiesConnection.class.getClassLoader());
        this.ap = parcel.readByte() == (byte) 1;
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.aq = z;
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.ar = z;
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.as = z;
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
        this.at = z;
        this.au = parcel.readString();
        this.av = (GraphQLLocation) parcel.readValue(GraphQLLocation.class.getClassLoader());
        this.aw = (GraphQLGeoRectangle) parcel.readValue(GraphQLGeoRectangle.class.getClassLoader());
        this.ax = parcel.readInt();
        this.ay = parcel.readString();
        this.az = ImmutableListHelper.m21625a(parcel.readArrayList(String.class.getClassLoader()));
        this.aA = (GraphQLStoryAttachment) parcel.readValue(GraphQLStoryAttachment.class.getClassLoader());
        this.aB = (GraphQLEventDeclinesConnection) parcel.readValue(GraphQLEventDeclinesConnection.class.getClassLoader());
        this.aC = (GraphQLEventInviteesConnection) parcel.readValue(GraphQLEventInviteesConnection.class.getClassLoader());
        this.aD = (GraphQLEventMaybesConnection) parcel.readValue(GraphQLEventMaybesConnection.class.getClassLoader());
        this.aE = (GraphQLEventMembersConnection) parcel.readValue(GraphQLEventMembersConnection.class.getClassLoader());
        this.aF = (GraphQLEventWatchersConnection) parcel.readValue(GraphQLEventWatchersConnection.class.getClassLoader());
        this.aG = (GraphQLGroup) parcel.readValue(GraphQLGroup.class.getClassLoader());
        this.aH = parcel.readInt();
        this.aI = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.aJ = parcel.readString();
        this.aK = GraphQLPlaceType.fromString(parcel.readString());
        this.aL = parcel.readByte() == (byte) 1;
        this.aM = (GraphQLPrivacyScope) parcel.readValue(GraphQLPrivacyScope.class.getClassLoader());
        this.aN = (GraphQLPrivacyScope) parcel.readValue(GraphQLPrivacyScope.class.getClassLoader());
        this.aO = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.aP = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.aQ = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.aR = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.aS = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.aT = (GraphQLPhoto) parcel.readValue(GraphQLPhoto.class.getClassLoader());
        this.aU = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.aV = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.aW = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.aX = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.aY = parcel.readByte() == (byte) 1;
        this.aZ = (GraphQLTimelineAppCollection) parcel.readValue(GraphQLTimelineAppCollection.class.getClassLoader());
        this.bx = parcel.readLong();
        this.ba = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.bb = parcel.readString();
        this.bc = parcel.readLong();
        this.bd = (GraphQLStreamingImage) parcel.readValue(GraphQLStreamingImage.class.getClassLoader());
        this.be = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.bf = z;
        this.bg = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.bh = (GraphQLEventTimeRange) parcel.readValue(GraphQLEventTimeRange.class.getClassLoader());
        this.bi = parcel.readString();
        this.bj = parcel.readString();
        this.bk = parcel.readInt();
        this.bl = parcel.readString();
        this.bm = parcel.readString();
        this.bn = GraphQLEventGuestStatus.fromString(parcel.readString());
        if (parcel.readByte() != (byte) 1) {
            z2 = false;
        }
        this.bo = z2;
        this.bp = ImmutableListHelper.m21625a(parcel.readArrayList(GraphQLActor.class.getClassLoader()));
        this.bq = GraphQLEventNotificationSubscriptionLevel.fromString(parcel.readString());
        this.br = GraphQLSavedState.fromString(parcel.readString());
        this.bs = ImmutableListHelper.m21625a(parcel.readArrayList(GraphQLTimelineAppCollection.class.getClassLoader()));
        this.bt = ImmutableListHelper.m21625a(parcel.readArrayList(GraphQLTimelineAppCollection.class.getClassLoader()));
        this.bu = GraphQLEventWatchStatus.fromString(parcel.readString());
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int i2;
        int i3 = 1;
        parcel.writeString(m23161j().name());
        parcel.writeValue(m23162k());
        parcel.writeValue(m23163l());
        parcel.writeValue(m23164m());
        parcel.writeValue(m23165n());
        parcel.writeValue(m23166o());
        parcel.writeValue(m23167p());
        parcel.writeValue(m23168q());
        parcel.writeByte((byte) (m23169r() ? 1 : 0));
        if (m23170s()) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        if (m23171t()) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        if (m23172u()) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        if (m23173v()) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        if (m23174w()) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        if (m23175x()) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        if (m23176y()) {
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
        parcel.writeValue(m23177z());
        parcel.writeString(m23129A().name());
        parcel.writeString(m23130B());
        parcel.writeValue(m23131C());
        parcel.writeValue(m23132D());
        parcel.writeValue(m23133E());
        parcel.writeLong(m23134F());
        parcel.writeLong(m23135G());
        parcel.writeValue(m23136H());
        parcel.writeValue(m23137I());
        parcel.writeString(m23138J());
        parcel.writeString(m23139K());
        parcel.writeString(m23140L());
        parcel.writeValue(m23141M());
        parcel.writeValue(m23142N());
        parcel.writeValue(m23143O());
        parcel.writeValue(m23144P());
        parcel.writeValue(m23145Q());
        parcel.writeValue(m23146R());
        parcel.writeValue(m23147S());
        parcel.writeString(m23148T().name());
        parcel.writeValue(m23149U());
        parcel.writeValue(m23150V());
        parcel.writeValue(m23151W());
        parcel.writeString(m23152X().name());
        parcel.writeString(bB().name());
        parcel.writeValue(bF());
        parcel.writeString(m23153Y());
        parcel.writeString(m23154Z().name());
        parcel.writeInt(aa());
        parcel.writeInt(ab());
        parcel.writeValue(ac());
        parcel.writeString(ad().name());
        parcel.writeValue(ae());
        parcel.writeValue(af());
        parcel.writeValue(ag());
        parcel.writeValue(ah());
        parcel.writeValue(ai());
        parcel.writeValue(aj());
        parcel.writeValue(ak());
        parcel.writeValue(al());
        parcel.writeValue(am());
        parcel.writeValue(an());
        parcel.writeValue(ao());
        parcel.writeValue(ap());
        parcel.writeValue(aq());
        parcel.writeValue(ar());
        parcel.writeString(as());
        parcel.writeValue(at());
        parcel.writeValue(au());
        parcel.writeByte((byte) (av() ? 1 : 0));
        if (aw()) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        if (ax()) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        if (ay()) {
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
        if (az()) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        parcel.writeString(aA());
        parcel.writeValue(aB());
        parcel.writeValue(aC());
        parcel.writeInt(aD());
        parcel.writeString(aE());
        parcel.writeList(aF());
        parcel.writeValue(aG());
        parcel.writeValue(aH());
        parcel.writeValue(aI());
        parcel.writeValue(aJ());
        parcel.writeValue(aK());
        parcel.writeValue(aL());
        parcel.writeValue(aM());
        parcel.writeInt(aN());
        parcel.writeValue(aO());
        parcel.writeString(aP());
        parcel.writeString(aQ().name());
        parcel.writeByte((byte) (aR() ? 1 : 0));
        parcel.writeValue(aS());
        parcel.writeValue(aT());
        parcel.writeValue(aU());
        parcel.writeValue(aV());
        parcel.writeValue(aW());
        parcel.writeValue(aX());
        parcel.writeValue(aY());
        parcel.writeValue(aZ());
        parcel.writeValue(ba());
        parcel.writeValue(bb());
        parcel.writeValue(bc());
        parcel.writeValue(bd());
        parcel.writeByte((byte) (be() ? 1 : 0));
        parcel.writeValue(bf());
        parcel.writeLong(bD());
        parcel.writeValue(bg());
        parcel.writeString(bh());
        parcel.writeLong(bi());
        parcel.writeValue(bj());
        parcel.writeValue(bk());
        if (bl()) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        parcel.writeValue(bm());
        parcel.writeValue(bn());
        parcel.writeString(bo());
        parcel.writeString(bp());
        parcel.writeInt(bq());
        parcel.writeString(br());
        parcel.writeString(bs());
        parcel.writeString(bt().name());
        if (!bu()) {
            i3 = 0;
        }
        parcel.writeByte((byte) i3);
        parcel.writeList(bv());
        parcel.writeString(bw().name());
        parcel.writeString(bx().name());
        parcel.writeList(by());
        parcel.writeList(bz());
        parcel.writeString(bA().name());
    }

    public GraphQLEvent(Builder builder) {
        super(131);
        this.b = builder.f15736a;
        this.c = builder.f15737b;
        this.f16319d = builder.d;
        this.f16320e = builder.e;
        this.f16321f = builder.f;
        this.f16322g = builder.g;
        this.f16323h = builder.h;
        this.f16324i = builder.i;
        this.f16325j = builder.j;
        this.f16326k = builder.k;
        this.f16327l = builder.l;
        this.f16328m = builder.m;
        this.f16329n = builder.n;
        this.f16330o = builder.o;
        this.f16331p = builder.p;
        this.f16332q = builder.q;
        this.f16333r = builder.r;
        this.f16334s = builder.s;
        this.by = builder.t;
        this.f16335t = builder.u;
        this.f16336u = builder.v;
        this.f16337v = builder.w;
        this.f16338w = builder.x;
        this.f16339x = builder.y;
        this.f16340y = builder.z;
        this.f16341z = builder.A;
        this.f16293A = builder.B;
        this.f16294B = builder.C;
        this.f16295C = builder.D;
        this.f16296D = builder.E;
        this.f16297E = builder.F;
        this.f16298F = builder.G;
        this.f16299G = builder.H;
        this.f16300H = builder.I;
        this.f16301I = builder.J;
        this.f16302J = builder.K;
        this.f16303K = builder.L;
        this.f16304L = builder.M;
        this.f16305M = builder.N;
        this.f16306N = builder.O;
        this.f16307O = builder.P;
        this.f16308P = builder.Q;
        this.f16309Q = builder.R;
        this.f16310R = builder.S;
        this.bv = builder.T;
        this.bz = builder.U;
        this.f16311S = builder.V;
        this.f16312T = builder.W;
        this.f16313U = builder.X;
        this.f16314V = builder.Y;
        this.f16315W = builder.Z;
        this.f16316X = builder.aa;
        this.f16317Y = builder.ab;
        this.f16318Z = builder.ac;
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
        this.al = builder.ao;
        this.am = builder.ap;
        this.an = builder.aq;
        this.ao = builder.ar;
        this.ap = builder.as;
        this.aq = builder.at;
        this.ar = builder.au;
        this.as = builder.av;
        this.bw = builder.aw;
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
        this.aM = builder.aQ;
        this.aN = builder.aR;
        this.aO = builder.aS;
        this.aP = builder.aT;
        this.aQ = builder.aU;
        this.aR = builder.aV;
        this.aS = builder.aW;
        this.aT = builder.aX;
        this.aU = builder.aY;
        this.aV = builder.aZ;
        this.aW = builder.ba;
        this.aX = builder.bb;
        this.aY = builder.bc;
        this.aZ = builder.bd;
        this.bx = builder.be;
        this.ba = builder.bf;
        this.bb = builder.bg;
        this.bc = builder.bh;
        this.bd = builder.bi;
        this.be = builder.bj;
        this.bf = builder.bk;
        this.bg = builder.bl;
        this.bh = builder.bm;
        this.bi = builder.bn;
        this.bj = builder.bo;
        this.bk = builder.bp;
        this.bl = builder.bq;
        this.bm = builder.br;
        this.bn = builder.bs;
        this.bo = builder.bt;
        this.bp = builder.bu;
        this.bq = builder.bv;
        this.br = builder.bw;
        this.bs = builder.bx;
        this.bt = builder.by;
        this.bu = builder.bz;
    }
}
