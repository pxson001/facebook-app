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
import com.facebook.graphql.enums.GraphQLConnectionStyle;
import com.facebook.graphql.enums.GraphQLEventGuestStatus;
import com.facebook.graphql.enums.GraphQLEventPrivacyType;
import com.facebook.graphql.enums.GraphQLEventWatchStatus;
import com.facebook.graphql.enums.GraphQLEventsCalendarSubscriptionStatus;
import com.facebook.graphql.enums.GraphQLFriendshipStatus;
import com.facebook.graphql.enums.GraphQLGroupJoinState;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.enums.GraphQLSavedState;
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
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.instagram.common.json.annotation.JsonType;
import java.util.List;
import javax.annotation.Nullable;

@AutoGenJsonDeserializer
@AutoGenJsonSerializer
@Deprecated
@JsonType
/* compiled from: logging/ */
public final class GraphQLProfile extends BaseModel implements TypeModel, GraphQLPersistableNode, GraphQLVisitableConsistentModel {
    public static final Creator<GraphQLProfile> CREATOR = new C07001();
    @Nullable
    GraphQLImage f16119A;
    @Nullable
    GraphQLFeedback f16120B;
    @Nullable
    GraphQLFriendsConnection f16121C;
    public GraphQLFriendshipStatus f16122D;
    @Nullable
    GraphQLGroupMembersConnection f16123E;
    @Deprecated
    int f16124F;
    @Nullable
    String f16125G;
    boolean f16126H;
    boolean f16127I;
    boolean f16128J;
    boolean f16129K;
    boolean f16130L;
    boolean f16131M;
    @Nullable
    GraphQLLocation f16132N;
    @Nullable
    GraphQLMutualFriendsConnection f16133O;
    @Nullable
    String f16134P;
    List<String> f16135Q;
    int f16136R;
    @Nullable
    GraphQLStoryAttachment f16137S;
    @Nullable
    GraphQLPage f16138T;
    @Nullable
    GraphQLPageLikersConnection f16139U;
    @Nullable
    GraphQLPageVisitsConnection f16140V;
    @Nullable
    String f16141W;
    @Nullable
    GraphQLPrivacyScope f16142X;
    @Nullable
    GraphQLImage f16143Y;
    @Nullable
    GraphQLImage f16144Z;
    @Nullable
    GraphQLTextWithEntities aA;
    List<String> aB;
    @Nullable
    GraphQLUserWorkExperiencesConnection aC;
    @Nullable
    GraphQLExternalUrl aD;
    @Nullable
    GraphQLUser aE;
    @Nullable
    GraphQLImage aa;
    @Nullable
    GraphQLImage ab;
    @Nullable
    GraphQLImage ac;
    @Nullable
    GraphQLImage ad;
    boolean ae;
    @Nullable
    String af;
    public GraphQLSecondarySubscribeStatus ag;
    List<String> ah;
    @Nullable
    GraphQLTextWithEntities ai;
    @Nullable
    GraphQLStreamingImage aj;
    @Nullable
    GraphQLName ak;
    List<GraphQLName> al;
    public GraphQLSubscribeStatus am;
    @Nullable
    GraphQLImage an;
    @Nullable
    GraphQLTextWithEntities ao;
    @Nullable
    GraphQLTrendingTopicData ap;
    @Nullable
    String aq;
    @Nullable
    String ar;
    @Nullable
    String as;
    double at;
    public GraphQLEventGuestStatus au;
    public boolean av;
    public GraphQLGroupJoinState aw;
    @Nullable
    GraphQLContactRecommendationField ax;
    GraphQLSavedState ay;
    public GraphQLEventWatchStatus az;
    @Nullable
    GraphQLObjectType f16145d;
    @Nullable
    GraphQLStreetAddress f16146e;
    @Nullable
    String f16147f;
    @Nullable
    GraphQLTextWithEntities f16148g;
    List<GraphQLBylineFragment> f16149h;
    boolean f16150i;
    boolean f16151j;
    boolean f16152k;
    boolean f16153l;
    boolean f16154m;
    boolean f16155n;
    @Deprecated
    boolean f16156o;
    boolean f16157p;
    List<String> f16158q;
    double f16159r;
    GraphQLConnectionStyle f16160s;
    @Nullable
    GraphQLFocusedPhoto f16161t;
    public boolean f16162u;
    @Nullable
    GraphQLUserEducationExperiencesConnection f16163v;
    List<String> f16164w;
    GraphQLEventPrivacyType f16165x;
    int f16166y;
    GraphQLEventsCalendarSubscriptionStatus f16167z;

    /* compiled from: logging/ */
    final class C07001 implements Creator<GraphQLProfile> {
        C07001() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLProfile(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLProfile[i];
        }
    }

    @Nullable
    public final GraphQLObjectType m23000j() {
        if (this.f5823b != null && this.f16145d == null) {
            this.f16145d = new GraphQLObjectType(this.f5823b.m21542b(this.f5824c, 0));
        }
        if (this.f16145d == null || this.f16145d.m22301g() != 0) {
            return this.f16145d;
        }
        return null;
    }

    @FieldOffset
    @Nullable
    public final GraphQLStreetAddress m23001k() {
        this.f16146e = (GraphQLStreetAddress) super.m9947a(this.f16146e, 1, GraphQLStreetAddress.class);
        return this.f16146e;
    }

    @FieldOffset
    @Nullable
    public final String m23002l() {
        this.f16147f = super.m9948a(this.f16147f, 3);
        return this.f16147f;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities m23003m() {
        this.f16148g = (GraphQLTextWithEntities) super.m9947a(this.f16148g, 4, GraphQLTextWithEntities.class);
        return this.f16148g;
    }

    @FieldOffset
    public final ImmutableList<GraphQLBylineFragment> m23004n() {
        this.f16149h = super.m9944a(this.f16149h, 5, GraphQLBylineFragment.class);
        return (ImmutableList) this.f16149h;
    }

    @FieldOffset
    public final boolean m23005o() {
        m9949a(0, 6);
        return this.f16150i;
    }

    @FieldOffset
    public final boolean m23006p() {
        m9949a(0, 7);
        return this.f16151j;
    }

    @FieldOffset
    public final boolean m23007q() {
        m9949a(1, 0);
        return this.f16152k;
    }

    @FieldOffset
    public final boolean m23008r() {
        m9949a(1, 1);
        return this.f16153l;
    }

    @FieldOffset
    public final boolean m23009s() {
        m9949a(1, 2);
        return this.f16154m;
    }

    @FieldOffset
    public final boolean m23010t() {
        m9949a(1, 3);
        return this.f16155n;
    }

    @FieldOffset
    public final boolean m23011u() {
        m9949a(1, 4);
        return this.f16156o;
    }

    @FieldOffset
    public final boolean m23012v() {
        m9949a(1, 5);
        return this.f16157p;
    }

    @FieldOffset
    public final ImmutableList<String> m23013w() {
        this.f16158q = super.m9943a(this.f16158q, 14);
        return (ImmutableList) this.f16158q;
    }

    @FieldOffset
    public final double m23014x() {
        m9949a(1, 7);
        return this.f16159r;
    }

    @FieldOffset
    public final GraphQLConnectionStyle m23015y() {
        this.f16160s = (GraphQLConnectionStyle) super.m9945a(this.f16160s, 16, GraphQLConnectionStyle.class, GraphQLConnectionStyle.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
        return this.f16160s;
    }

    @FieldOffset
    @Nullable
    public final GraphQLFocusedPhoto m23016z() {
        this.f16161t = (GraphQLFocusedPhoto) super.m9947a(this.f16161t, 17, GraphQLFocusedPhoto.class);
        return this.f16161t;
    }

    @FieldOffset
    public final boolean m22967A() {
        m9949a(2, 2);
        return this.f16162u;
    }

    @FieldOffset
    @Nullable
    public final GraphQLUserEducationExperiencesConnection m22968B() {
        this.f16163v = (GraphQLUserEducationExperiencesConnection) super.m9947a(this.f16163v, 19, GraphQLUserEducationExperiencesConnection.class);
        return this.f16163v;
    }

    @FieldOffset
    public final ImmutableList<String> m22969C() {
        this.f16164w = super.m9943a(this.f16164w, 20);
        return (ImmutableList) this.f16164w;
    }

    @FieldOffset
    public final GraphQLEventPrivacyType m22970D() {
        this.f16165x = (GraphQLEventPrivacyType) super.m9945a(this.f16165x, 21, GraphQLEventPrivacyType.class, GraphQLEventPrivacyType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
        return this.f16165x;
    }

    @FieldOffset
    public final int m22971E() {
        m9949a(2, 7);
        return this.f16166y;
    }

    @FieldOffset
    public final GraphQLEventsCalendarSubscriptionStatus m22972F() {
        this.f16167z = (GraphQLEventsCalendarSubscriptionStatus) super.m9945a(this.f16167z, 24, GraphQLEventsCalendarSubscriptionStatus.class, GraphQLEventsCalendarSubscriptionStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
        return this.f16167z;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m22973G() {
        this.f16119A = (GraphQLImage) super.m9947a(this.f16119A, 25, GraphQLImage.class);
        return this.f16119A;
    }

    @FieldOffset
    @Nullable
    public final GraphQLFeedback m22974H() {
        this.f16120B = (GraphQLFeedback) super.m9947a(this.f16120B, 26, GraphQLFeedback.class);
        return this.f16120B;
    }

    @FieldOffset
    @Nullable
    public final GraphQLFriendsConnection m22975I() {
        this.f16121C = (GraphQLFriendsConnection) super.m9947a(this.f16121C, 27, GraphQLFriendsConnection.class);
        return this.f16121C;
    }

    @FieldOffset
    public final GraphQLFriendshipStatus m22976J() {
        this.f16122D = (GraphQLFriendshipStatus) super.m9945a(this.f16122D, 28, GraphQLFriendshipStatus.class, GraphQLFriendshipStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
        return this.f16122D;
    }

    @FieldOffset
    @Nullable
    public final GraphQLGroupMembersConnection m22977K() {
        this.f16123E = (GraphQLGroupMembersConnection) super.m9947a(this.f16123E, 29, GraphQLGroupMembersConnection.class);
        return this.f16123E;
    }

    @FieldOffset
    public final int m22978L() {
        m9949a(3, 6);
        return this.f16124F;
    }

    @FieldOffset
    @Nullable
    public final String m22999b() {
        this.f16125G = super.m9948a(this.f16125G, 31);
        return this.f16125G;
    }

    @FieldOffset
    public final boolean m22979M() {
        m9949a(4, 1);
        return this.f16126H;
    }

    @FieldOffset
    public final boolean m22980N() {
        m9949a(4, 2);
        return this.f16127I;
    }

    @FieldOffset
    public final boolean m22981O() {
        m9949a(4, 3);
        return this.f16128J;
    }

    @FieldOffset
    public final boolean m22982P() {
        m9949a(4, 4);
        return this.f16129K;
    }

    @FieldOffset
    public final boolean m22983Q() {
        m9949a(4, 5);
        return this.f16130L;
    }

    @FieldOffset
    public final boolean m22984R() {
        m9949a(4, 6);
        return this.f16131M;
    }

    @FieldOffset
    @Nullable
    public final GraphQLLocation m22985S() {
        this.f16132N = (GraphQLLocation) super.m9947a(this.f16132N, 39, GraphQLLocation.class);
        return this.f16132N;
    }

    @FieldOffset
    @Nullable
    public final GraphQLMutualFriendsConnection m22986T() {
        this.f16133O = (GraphQLMutualFriendsConnection) super.m9947a(this.f16133O, 40, GraphQLMutualFriendsConnection.class);
        return this.f16133O;
    }

    @FieldOffset
    @Nullable
    public final String m22987U() {
        this.f16134P = super.m9948a(this.f16134P, 41);
        return this.f16134P;
    }

    @FieldOffset
    public final ImmutableList<String> m22988V() {
        this.f16135Q = super.m9943a(this.f16135Q, 42);
        return (ImmutableList) this.f16135Q;
    }

    @FieldOffset
    public final int m22989W() {
        m9949a(5, 3);
        return this.f16136R;
    }

    @FieldOffset
    @Nullable
    public final GraphQLStoryAttachment m22990X() {
        this.f16137S = (GraphQLStoryAttachment) super.m9947a(this.f16137S, 44, GraphQLStoryAttachment.class);
        return this.f16137S;
    }

    @FieldOffset
    @Nullable
    public final GraphQLPage m22991Y() {
        this.f16138T = (GraphQLPage) super.m9947a(this.f16138T, 45, GraphQLPage.class);
        return this.f16138T;
    }

    @FieldOffset
    @Nullable
    public final GraphQLPageLikersConnection m22992Z() {
        this.f16139U = (GraphQLPageLikersConnection) super.m9947a(this.f16139U, 46, GraphQLPageLikersConnection.class);
        return this.f16139U;
    }

    @FieldOffset
    @Nullable
    public final GraphQLPageVisitsConnection aa() {
        this.f16140V = (GraphQLPageVisitsConnection) super.m9947a(this.f16140V, 47, GraphQLPageVisitsConnection.class);
        return this.f16140V;
    }

    @FieldOffset
    @Nullable
    public final String ab() {
        this.f16141W = super.m9948a(this.f16141W, 48);
        return this.f16141W;
    }

    @FieldOffset
    @Nullable
    public final GraphQLPrivacyScope ac() {
        this.f16142X = (GraphQLPrivacyScope) super.m9947a(this.f16142X, 49, GraphQLPrivacyScope.class);
        return this.f16142X;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage ad() {
        this.f16143Y = (GraphQLImage) super.m9947a(this.f16143Y, 50, GraphQLImage.class);
        return this.f16143Y;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage ae() {
        this.f16144Z = (GraphQLImage) super.m9947a(this.f16144Z, 51, GraphQLImage.class);
        return this.f16144Z;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage af() {
        this.aa = (GraphQLImage) super.m9947a(this.aa, 52, GraphQLImage.class);
        return this.aa;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage ag() {
        this.ab = (GraphQLImage) super.m9947a(this.ab, 53, GraphQLImage.class);
        return this.ab;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage ah() {
        this.ac = (GraphQLImage) super.m9947a(this.ac, 54, GraphQLImage.class);
        return this.ac;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage ai() {
        this.ad = (GraphQLImage) super.m9947a(this.ad, 55, GraphQLImage.class);
        return this.ad;
    }

    @FieldOffset
    public final boolean aj() {
        m9949a(7, 0);
        return this.ae;
    }

    @FieldOffset
    @Nullable
    public final String ak() {
        this.af = super.m9948a(this.af, 57);
        return this.af;
    }

    @FieldOffset
    public final GraphQLSecondarySubscribeStatus al() {
        this.ag = (GraphQLSecondarySubscribeStatus) super.m9945a(this.ag, 58, GraphQLSecondarySubscribeStatus.class, GraphQLSecondarySubscribeStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
        return this.ag;
    }

    @FieldOffset
    public final ImmutableList<String> am() {
        this.ah = super.m9943a(this.ah, 59);
        return (ImmutableList) this.ah;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities an() {
        this.ai = (GraphQLTextWithEntities) super.m9947a(this.ai, 60, GraphQLTextWithEntities.class);
        return this.ai;
    }

    @FieldOffset
    @Nullable
    public final GraphQLStreamingImage ao() {
        this.aj = (GraphQLStreamingImage) super.m9947a(this.aj, 61, GraphQLStreamingImage.class);
        return this.aj;
    }

    @FieldOffset
    @Nullable
    public final GraphQLName ap() {
        this.ak = (GraphQLName) super.m9947a(this.ak, 62, GraphQLName.class);
        return this.ak;
    }

    @FieldOffset
    public final ImmutableList<GraphQLName> aq() {
        this.al = super.m9944a(this.al, 63, GraphQLName.class);
        return (ImmutableList) this.al;
    }

    @FieldOffset
    public final GraphQLSubscribeStatus ar() {
        this.am = (GraphQLSubscribeStatus) super.m9945a(this.am, 64, GraphQLSubscribeStatus.class, GraphQLSubscribeStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
        return this.am;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage as() {
        this.an = (GraphQLImage) super.m9947a(this.an, 65, GraphQLImage.class);
        return this.an;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities at() {
        this.ao = (GraphQLTextWithEntities) super.m9947a(this.ao, 66, GraphQLTextWithEntities.class);
        return this.ao;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTrendingTopicData au() {
        this.ap = (GraphQLTrendingTopicData) super.m9947a(this.ap, 68, GraphQLTrendingTopicData.class);
        return this.ap;
    }

    @FieldOffset
    @Nullable
    public final String av() {
        this.aq = super.m9948a(this.aq, 69);
        return this.aq;
    }

    @FieldOffset
    @Nullable
    public final String aw() {
        this.ar = super.m9948a(this.ar, 70);
        return this.ar;
    }

    @FieldOffset
    @Nullable
    public final String ax() {
        this.as = super.m9948a(this.as, 71);
        return this.as;
    }

    @FieldOffset
    public final double ay() {
        m9949a(9, 0);
        return this.at;
    }

    @FieldOffset
    public final GraphQLEventGuestStatus az() {
        this.au = (GraphQLEventGuestStatus) super.m9945a(this.au, 73, GraphQLEventGuestStatus.class, GraphQLEventGuestStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
        return this.au;
    }

    @FieldOffset
    public final boolean aA() {
        m9949a(9, 2);
        return this.av;
    }

    @FieldOffset
    public final GraphQLGroupJoinState aB() {
        this.aw = (GraphQLGroupJoinState) super.m9945a(this.aw, 75, GraphQLGroupJoinState.class, GraphQLGroupJoinState.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
        return this.aw;
    }

    @FieldOffset
    @Nullable
    public final GraphQLContactRecommendationField aC() {
        this.ax = (GraphQLContactRecommendationField) super.m9947a(this.ax, 76, GraphQLContactRecommendationField.class);
        return this.ax;
    }

    @FieldOffset
    public final GraphQLSavedState aD() {
        this.ay = (GraphQLSavedState) super.m9945a(this.ay, 77, GraphQLSavedState.class, GraphQLSavedState.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
        return this.ay;
    }

    @FieldOffset
    public final GraphQLEventWatchStatus aE() {
        this.az = (GraphQLEventWatchStatus) super.m9945a(this.az, 78, GraphQLEventWatchStatus.class, GraphQLEventWatchStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
        return this.az;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities aF() {
        this.aA = (GraphQLTextWithEntities) super.m9947a(this.aA, 79, GraphQLTextWithEntities.class);
        return this.aA;
    }

    @FieldOffset
    public final ImmutableList<String> aG() {
        this.aB = super.m9943a(this.aB, 80);
        return (ImmutableList) this.aB;
    }

    @FieldOffset
    @Nullable
    public final GraphQLUserWorkExperiencesConnection aH() {
        this.aC = (GraphQLUserWorkExperiencesConnection) super.m9947a(this.aC, 81, GraphQLUserWorkExperiencesConnection.class);
        return this.aC;
    }

    @FieldOffset
    @Nullable
    public final GraphQLExternalUrl aI() {
        this.aD = (GraphQLExternalUrl) super.m9947a(this.aD, 82, GraphQLExternalUrl.class);
        return this.aD;
    }

    @FieldOffset
    @Nullable
    public final GraphQLUser aJ() {
        this.aE = (GraphQLUser) super.m9947a(this.aE, 83, GraphQLUser.class);
        return this.aE;
    }

    @Nullable
    public final String mo2834a() {
        return m22999b();
    }

    public final int jK_() {
        return 1355227529;
    }

    public final GraphQLVisitableModel mo1404a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLTextWithEntities graphQLTextWithEntities;
        Builder a;
        GraphQLImage graphQLImage;
        GraphQLVisitableModel graphQLVisitableModel = null;
        m9958h();
        if (m23001k() != null) {
            GraphQLStreetAddress graphQLStreetAddress = (GraphQLStreetAddress) graphQLModelMutatingVisitor.mo2928b(m23001k());
            if (m23001k() != graphQLStreetAddress) {
                graphQLVisitableModel = (GraphQLProfile) ModelHelper.m23095a(null, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16146e = graphQLStreetAddress;
            }
        }
        if (m23003m() != null) {
            graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.mo2928b(m23003m());
            if (m23003m() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLProfile) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16148g = graphQLTextWithEntities;
            }
        }
        if (m23004n() != null) {
            a = ModelHelper.m23097a(m23004n(), graphQLModelMutatingVisitor);
            if (a != null) {
                GraphQLProfile graphQLProfile = (GraphQLProfile) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLProfile.f16149h = a.m1068b();
                graphQLVisitableModel = graphQLProfile;
            }
        }
        if (m23016z() != null) {
            GraphQLFocusedPhoto graphQLFocusedPhoto = (GraphQLFocusedPhoto) graphQLModelMutatingVisitor.mo2928b(m23016z());
            if (m23016z() != graphQLFocusedPhoto) {
                graphQLVisitableModel = (GraphQLProfile) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16161t = graphQLFocusedPhoto;
            }
        }
        if (m22968B() != null) {
            GraphQLUserEducationExperiencesConnection graphQLUserEducationExperiencesConnection = (GraphQLUserEducationExperiencesConnection) graphQLModelMutatingVisitor.mo2928b(m22968B());
            if (m22968B() != graphQLUserEducationExperiencesConnection) {
                graphQLVisitableModel = (GraphQLProfile) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16163v = graphQLUserEducationExperiencesConnection;
            }
        }
        if (m22973G() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(m22973G());
            if (m22973G() != graphQLImage) {
                graphQLVisitableModel = (GraphQLProfile) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16119A = graphQLImage;
            }
        }
        if (m22974H() != null) {
            GraphQLFeedback graphQLFeedback = (GraphQLFeedback) graphQLModelMutatingVisitor.mo2928b(m22974H());
            if (m22974H() != graphQLFeedback) {
                graphQLVisitableModel = (GraphQLProfile) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16120B = graphQLFeedback;
            }
        }
        if (m22975I() != null) {
            GraphQLFriendsConnection graphQLFriendsConnection = (GraphQLFriendsConnection) graphQLModelMutatingVisitor.mo2928b(m22975I());
            if (m22975I() != graphQLFriendsConnection) {
                graphQLVisitableModel = (GraphQLProfile) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16121C = graphQLFriendsConnection;
            }
        }
        if (aI() != null) {
            GraphQLExternalUrl graphQLExternalUrl = (GraphQLExternalUrl) graphQLModelMutatingVisitor.mo2928b(aI());
            if (aI() != graphQLExternalUrl) {
                graphQLVisitableModel = (GraphQLProfile) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.aD = graphQLExternalUrl;
            }
        }
        if (m22977K() != null) {
            GraphQLGroupMembersConnection graphQLGroupMembersConnection = (GraphQLGroupMembersConnection) graphQLModelMutatingVisitor.mo2928b(m22977K());
            if (m22977K() != graphQLGroupMembersConnection) {
                graphQLVisitableModel = (GraphQLProfile) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16123E = graphQLGroupMembersConnection;
            }
        }
        if (aJ() != null) {
            GraphQLUser graphQLUser = (GraphQLUser) graphQLModelMutatingVisitor.mo2928b(aJ());
            if (aJ() != graphQLUser) {
                graphQLVisitableModel = (GraphQLProfile) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.aE = graphQLUser;
            }
        }
        if (m22985S() != null) {
            GraphQLLocation graphQLLocation = (GraphQLLocation) graphQLModelMutatingVisitor.mo2928b(m22985S());
            if (m22985S() != graphQLLocation) {
                graphQLVisitableModel = (GraphQLProfile) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16132N = graphQLLocation;
            }
        }
        if (m22986T() != null) {
            GraphQLMutualFriendsConnection graphQLMutualFriendsConnection = (GraphQLMutualFriendsConnection) graphQLModelMutatingVisitor.mo2928b(m22986T());
            if (m22986T() != graphQLMutualFriendsConnection) {
                graphQLVisitableModel = (GraphQLProfile) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16133O = graphQLMutualFriendsConnection;
            }
        }
        if (m22990X() != null) {
            GraphQLStoryAttachment graphQLStoryAttachment = (GraphQLStoryAttachment) graphQLModelMutatingVisitor.mo2928b(m22990X());
            if (m22990X() != graphQLStoryAttachment) {
                graphQLVisitableModel = (GraphQLProfile) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16137S = graphQLStoryAttachment;
            }
        }
        if (m22991Y() != null) {
            GraphQLPage graphQLPage = (GraphQLPage) graphQLModelMutatingVisitor.mo2928b(m22991Y());
            if (m22991Y() != graphQLPage) {
                graphQLVisitableModel = (GraphQLProfile) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16138T = graphQLPage;
            }
        }
        if (m22992Z() != null) {
            GraphQLPageLikersConnection graphQLPageLikersConnection = (GraphQLPageLikersConnection) graphQLModelMutatingVisitor.mo2928b(m22992Z());
            if (m22992Z() != graphQLPageLikersConnection) {
                graphQLVisitableModel = (GraphQLProfile) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16139U = graphQLPageLikersConnection;
            }
        }
        if (aa() != null) {
            GraphQLPageVisitsConnection graphQLPageVisitsConnection = (GraphQLPageVisitsConnection) graphQLModelMutatingVisitor.mo2928b(aa());
            if (aa() != graphQLPageVisitsConnection) {
                graphQLVisitableModel = (GraphQLProfile) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16140V = graphQLPageVisitsConnection;
            }
        }
        if (ac() != null) {
            GraphQLPrivacyScope graphQLPrivacyScope = (GraphQLPrivacyScope) graphQLModelMutatingVisitor.mo2928b(ac());
            if (ac() != graphQLPrivacyScope) {
                graphQLVisitableModel = (GraphQLProfile) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16142X = graphQLPrivacyScope;
            }
        }
        if (ad() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(ad());
            if (ad() != graphQLImage) {
                graphQLVisitableModel = (GraphQLProfile) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16143Y = graphQLImage;
            }
        }
        if (ae() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(ae());
            if (ae() != graphQLImage) {
                graphQLVisitableModel = (GraphQLProfile) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16144Z = graphQLImage;
            }
        }
        if (af() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(af());
            if (af() != graphQLImage) {
                graphQLVisitableModel = (GraphQLProfile) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.aa = graphQLImage;
            }
        }
        if (ag() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(ag());
            if (ag() != graphQLImage) {
                graphQLVisitableModel = (GraphQLProfile) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.ab = graphQLImage;
            }
        }
        if (ah() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(ah());
            if (ah() != graphQLImage) {
                graphQLVisitableModel = (GraphQLProfile) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.ac = graphQLImage;
            }
        }
        if (ai() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(ai());
            if (ai() != graphQLImage) {
                graphQLVisitableModel = (GraphQLProfile) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.ad = graphQLImage;
            }
        }
        if (an() != null) {
            graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.mo2928b(an());
            if (an() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLProfile) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.ai = graphQLTextWithEntities;
            }
        }
        if (ao() != null) {
            GraphQLStreamingImage graphQLStreamingImage = (GraphQLStreamingImage) graphQLModelMutatingVisitor.mo2928b(ao());
            if (ao() != graphQLStreamingImage) {
                graphQLVisitableModel = (GraphQLProfile) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.aj = graphQLStreamingImage;
            }
        }
        if (ap() != null) {
            GraphQLName graphQLName = (GraphQLName) graphQLModelMutatingVisitor.mo2928b(ap());
            if (ap() != graphQLName) {
                graphQLVisitableModel = (GraphQLProfile) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.ak = graphQLName;
            }
        }
        if (aq() != null) {
            a = ModelHelper.m23097a(aq(), graphQLModelMutatingVisitor);
            if (a != null) {
                graphQLProfile = (GraphQLProfile) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLProfile.al = a.m1068b();
                graphQLVisitableModel = graphQLProfile;
            }
        }
        if (as() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(as());
            if (as() != graphQLImage) {
                graphQLVisitableModel = (GraphQLProfile) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.an = graphQLImage;
            }
        }
        if (at() != null) {
            graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.mo2928b(at());
            if (at() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLProfile) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.ao = graphQLTextWithEntities;
            }
        }
        if (au() != null) {
            GraphQLTrendingTopicData graphQLTrendingTopicData = (GraphQLTrendingTopicData) graphQLModelMutatingVisitor.mo2928b(au());
            if (au() != graphQLTrendingTopicData) {
                graphQLVisitableModel = (GraphQLProfile) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.ap = graphQLTrendingTopicData;
            }
        }
        if (aC() != null) {
            GraphQLContactRecommendationField graphQLContactRecommendationField = (GraphQLContactRecommendationField) graphQLModelMutatingVisitor.mo2928b(aC());
            if (aC() != graphQLContactRecommendationField) {
                graphQLVisitableModel = (GraphQLProfile) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.ax = graphQLContactRecommendationField;
            }
        }
        if (aF() != null) {
            graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.mo2928b(aF());
            if (aF() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLProfile) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.aA = graphQLTextWithEntities;
            }
        }
        if (aH() != null) {
            GraphQLUserWorkExperiencesConnection graphQLUserWorkExperiencesConnection = (GraphQLUserWorkExperiencesConnection) graphQLModelMutatingVisitor.mo2928b(aH());
            if (aH() != graphQLUserWorkExperiencesConnection) {
                graphQLVisitableModel = (GraphQLProfile) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.aC = graphQLUserWorkExperiencesConnection;
            }
        }
        m9959i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public final void mo2835a(String str, ConsistencyTuple consistencyTuple) {
        if ("does_viewer_like".equals(str)) {
            consistencyTuple.f18727a = Boolean.valueOf(m22967A());
            consistencyTuple.f18728b = u_();
            consistencyTuple.f18729c = 18;
        } else if ("friendship_status".equals(str)) {
            consistencyTuple.f18727a = m22976J();
            consistencyTuple.f18728b = u_();
            consistencyTuple.f18729c = 28;
        } else if ("secondary_subscribe_status".equals(str)) {
            consistencyTuple.f18727a = al();
            consistencyTuple.f18728b = u_();
            consistencyTuple.f18729c = 58;
        } else if ("subscribe_status".equals(str)) {
            consistencyTuple.f18727a = ar();
            consistencyTuple.f18728b = u_();
            consistencyTuple.f18729c = 64;
        } else if ("viewer_guest_status".equals(str)) {
            consistencyTuple.f18727a = az();
            consistencyTuple.f18728b = u_();
            consistencyTuple.f18729c = 73;
        } else if ("viewer_has_pending_invite".equals(str)) {
            consistencyTuple.f18727a = Boolean.valueOf(aA());
            consistencyTuple.f18728b = u_();
            consistencyTuple.f18729c = 74;
        } else if ("viewer_join_state".equals(str)) {
            consistencyTuple.f18727a = aB();
            consistencyTuple.f18728b = u_();
            consistencyTuple.f18729c = 75;
        } else if ("viewer_watch_status".equals(str)) {
            consistencyTuple.f18727a = aE();
            consistencyTuple.f18728b = u_();
            consistencyTuple.f18729c = 78;
        } else {
            consistencyTuple.m26322a();
        }
    }

    public final void mo2836a(String str, Object obj, boolean z) {
        boolean booleanValue;
        if ("does_viewer_like".equals(str)) {
            booleanValue = ((Boolean) obj).booleanValue();
            this.f16162u = booleanValue;
            if (this.f5823b != null && this.f5823b.f15024d) {
                this.f5823b.m21538a(this.f5824c, 18, booleanValue);
            }
        } else if ("friendship_status".equals(str)) {
            r7 = (GraphQLFriendshipStatus) obj;
            this.f16122D = r7;
            if (this.f5823b != null && this.f5823b.f15024d) {
                this.f5823b.m21536a(this.f5824c, 28, r7);
            }
        } else if ("secondary_subscribe_status".equals(str)) {
            r7 = (GraphQLSecondarySubscribeStatus) obj;
            this.ag = r7;
            if (this.f5823b != null && this.f5823b.f15024d) {
                this.f5823b.m21536a(this.f5824c, 58, r7);
            }
        } else if ("subscribe_status".equals(str)) {
            r7 = (GraphQLSubscribeStatus) obj;
            this.am = r7;
            if (this.f5823b != null && this.f5823b.f15024d) {
                this.f5823b.m21536a(this.f5824c, 64, r7);
            }
        } else if ("viewer_guest_status".equals(str)) {
            r7 = (GraphQLEventGuestStatus) obj;
            this.au = r7;
            if (this.f5823b != null && this.f5823b.f15024d) {
                this.f5823b.m21536a(this.f5824c, 73, r7);
            }
        } else if ("viewer_has_pending_invite".equals(str)) {
            booleanValue = ((Boolean) obj).booleanValue();
            this.av = booleanValue;
            if (this.f5823b != null && this.f5823b.f15024d) {
                this.f5823b.m21538a(this.f5824c, 74, booleanValue);
            }
        } else if ("viewer_join_state".equals(str)) {
            r7 = (GraphQLGroupJoinState) obj;
            this.aw = r7;
            if (this.f5823b != null && this.f5823b.f15024d) {
                this.f5823b.m21536a(this.f5824c, 75, r7);
            }
        } else if ("viewer_watch_status".equals(str)) {
            r7 = (GraphQLEventWatchStatus) obj;
            this.az = r7;
            if (this.f5823b != null && this.f5823b.f15024d) {
                this.f5823b.m21536a(this.f5824c, 78, r7);
            }
        }
    }

    public GraphQLProfile() {
        super(86);
    }

    public final void mo1406a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.mo1406a(mutableFlatBuffer, i, obj);
        this.f16150i = mutableFlatBuffer.m21540a(i, 6);
        this.f16151j = mutableFlatBuffer.m21540a(i, 7);
        this.f16152k = mutableFlatBuffer.m21540a(i, 8);
        this.f16153l = mutableFlatBuffer.m21540a(i, 9);
        this.f16154m = mutableFlatBuffer.m21540a(i, 10);
        this.f16155n = mutableFlatBuffer.m21540a(i, 11);
        this.f16156o = mutableFlatBuffer.m21540a(i, 12);
        this.f16157p = mutableFlatBuffer.m21540a(i, 13);
        this.f16159r = mutableFlatBuffer.m21523a(i, 15, 0.0d);
        this.f16162u = mutableFlatBuffer.m21540a(i, 18);
        this.f16166y = mutableFlatBuffer.m21524a(i, 23, 0);
        this.f16124F = mutableFlatBuffer.m21524a(i, 30, 0);
        this.f16126H = mutableFlatBuffer.m21540a(i, 33);
        this.f16127I = mutableFlatBuffer.m21540a(i, 34);
        this.f16128J = mutableFlatBuffer.m21540a(i, 35);
        this.f16129K = mutableFlatBuffer.m21540a(i, 36);
        this.f16130L = mutableFlatBuffer.m21540a(i, 37);
        this.f16131M = mutableFlatBuffer.m21540a(i, 38);
        this.f16136R = mutableFlatBuffer.m21524a(i, 43, 0);
        this.ae = mutableFlatBuffer.m21540a(i, 56);
        this.at = mutableFlatBuffer.m21523a(i, 72, 0.0d);
        this.av = mutableFlatBuffer.m21540a(i, 74);
    }

    public final int mo1403a(FlatBufferBuilder flatBufferBuilder) {
        m9958h();
        int a = flatBufferBuilder.m21479a(m23000j() != null ? m23000j().m22299e() : null);
        int a2 = ModelHelper.m23093a(flatBufferBuilder, m23001k());
        int b = flatBufferBuilder.m21502b(m23002l());
        int a3 = ModelHelper.m23093a(flatBufferBuilder, m23003m());
        int a4 = ModelHelper.m23094a(flatBufferBuilder, m23004n());
        int c = flatBufferBuilder.m21509c(m23013w());
        int a5 = ModelHelper.m23093a(flatBufferBuilder, m23016z());
        int a6 = ModelHelper.m23093a(flatBufferBuilder, m22968B());
        int c2 = flatBufferBuilder.m21509c(m22969C());
        int a7 = ModelHelper.m23093a(flatBufferBuilder, m22973G());
        int a8 = ModelHelper.m23093a(flatBufferBuilder, m22974H());
        int a9 = ModelHelper.m23093a(flatBufferBuilder, m22975I());
        int a10 = ModelHelper.m23093a(flatBufferBuilder, m22977K());
        int b2 = flatBufferBuilder.m21502b(m22999b());
        int a11 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) m22985S());
        int a12 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) m22986T());
        int b3 = flatBufferBuilder.m21502b(m22987U());
        int c3 = flatBufferBuilder.m21509c((List) m22988V());
        int a13 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) m22990X());
        int a14 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) m22991Y());
        int a15 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) m22992Z());
        int a16 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) aa());
        int b4 = flatBufferBuilder.m21502b(ab());
        int a17 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) ac());
        int a18 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) ad());
        int a19 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) ae());
        int a20 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) af());
        int a21 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) ag());
        int a22 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) ah());
        int a23 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) ai());
        int b5 = flatBufferBuilder.m21502b(ak());
        int c4 = flatBufferBuilder.m21509c((List) am());
        int a24 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) an());
        int a25 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) ao());
        int a26 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) ap());
        int a27 = ModelHelper.m23094a(flatBufferBuilder, (List) aq());
        int a28 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) as());
        int a29 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) at());
        int a30 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) au());
        int b6 = flatBufferBuilder.m21502b(av());
        int b7 = flatBufferBuilder.m21502b(aw());
        int b8 = flatBufferBuilder.m21502b(ax());
        int a31 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) aC());
        int a32 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) aF());
        int c5 = flatBufferBuilder.m21509c((List) aG());
        int a33 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) aH());
        int a34 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) aI());
        int a35 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) aJ());
        flatBufferBuilder.m21510c(85);
        flatBufferBuilder.m21507b(0, a);
        flatBufferBuilder.m21507b(1, a2);
        flatBufferBuilder.m21507b(3, b);
        flatBufferBuilder.m21507b(4, a3);
        flatBufferBuilder.m21507b(5, a4);
        flatBufferBuilder.m21498a(6, m23005o());
        flatBufferBuilder.m21498a(7, m23006p());
        flatBufferBuilder.m21498a(8, m23007q());
        flatBufferBuilder.m21498a(9, m23008r());
        flatBufferBuilder.m21498a(10, m23009s());
        flatBufferBuilder.m21498a(11, m23010t());
        flatBufferBuilder.m21498a(12, m23011u());
        flatBufferBuilder.m21498a(13, m23012v());
        flatBufferBuilder.m21507b(14, c);
        flatBufferBuilder.m21492a(15, m23014x(), 0.0d);
        flatBufferBuilder.m21496a(16, m23015y() == GraphQLConnectionStyle.UNSET_OR_UNRECOGNIZED_ENUM_VALUE ? null : m23015y());
        flatBufferBuilder.m21507b(17, a5);
        flatBufferBuilder.m21498a(18, m22967A());
        flatBufferBuilder.m21507b(19, a6);
        flatBufferBuilder.m21507b(20, c2);
        flatBufferBuilder.m21496a(21, m22970D() == GraphQLEventPrivacyType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE ? null : m22970D());
        flatBufferBuilder.m21494a(23, m22971E(), 0);
        flatBufferBuilder.m21496a(24, m22972F() == GraphQLEventsCalendarSubscriptionStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE ? null : m22972F());
        flatBufferBuilder.m21507b(25, a7);
        flatBufferBuilder.m21507b(26, a8);
        flatBufferBuilder.m21507b(27, a9);
        flatBufferBuilder.m21496a(28, m22976J() == GraphQLFriendshipStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE ? null : m22976J());
        flatBufferBuilder.m21507b(29, a10);
        flatBufferBuilder.m21494a(30, m22978L(), 0);
        flatBufferBuilder.m21507b(31, b2);
        flatBufferBuilder.m21498a(33, m22979M());
        flatBufferBuilder.m21498a(34, m22980N());
        flatBufferBuilder.m21498a(35, m22981O());
        flatBufferBuilder.m21498a(36, m22982P());
        flatBufferBuilder.m21498a(37, m22983Q());
        flatBufferBuilder.m21498a(38, m22984R());
        flatBufferBuilder.m21507b(39, a11);
        flatBufferBuilder.m21507b(40, a12);
        flatBufferBuilder.m21507b(41, b3);
        flatBufferBuilder.m21507b(42, c3);
        flatBufferBuilder.m21494a(43, m22989W(), 0);
        flatBufferBuilder.m21507b(44, a13);
        flatBufferBuilder.m21507b(45, a14);
        flatBufferBuilder.m21507b(46, a15);
        flatBufferBuilder.m21507b(47, a16);
        flatBufferBuilder.m21507b(48, b4);
        flatBufferBuilder.m21507b(49, a17);
        flatBufferBuilder.m21507b(50, a18);
        flatBufferBuilder.m21507b(51, a19);
        flatBufferBuilder.m21507b(52, a20);
        flatBufferBuilder.m21507b(53, a21);
        flatBufferBuilder.m21507b(54, a22);
        flatBufferBuilder.m21507b(55, a23);
        flatBufferBuilder.m21498a(56, aj());
        flatBufferBuilder.m21507b(57, b5);
        flatBufferBuilder.m21496a(58, al() == GraphQLSecondarySubscribeStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE ? null : al());
        flatBufferBuilder.m21507b(59, c4);
        flatBufferBuilder.m21507b(60, a24);
        flatBufferBuilder.m21507b(61, a25);
        flatBufferBuilder.m21507b(62, a26);
        flatBufferBuilder.m21507b(63, a27);
        flatBufferBuilder.m21496a(64, ar() == GraphQLSubscribeStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE ? null : ar());
        flatBufferBuilder.m21507b(65, a28);
        flatBufferBuilder.m21507b(66, a29);
        flatBufferBuilder.m21507b(68, a30);
        flatBufferBuilder.m21507b(69, b6);
        flatBufferBuilder.m21507b(70, b7);
        flatBufferBuilder.m21507b(71, b8);
        flatBufferBuilder.m21492a(72, ay(), 0.0d);
        flatBufferBuilder.m21496a(73, az() == GraphQLEventGuestStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE ? null : az());
        flatBufferBuilder.m21498a(74, aA());
        flatBufferBuilder.m21496a(75, aB() == GraphQLGroupJoinState.UNSET_OR_UNRECOGNIZED_ENUM_VALUE ? null : aB());
        flatBufferBuilder.m21507b(76, a31);
        flatBufferBuilder.m21496a(77, aD() == GraphQLSavedState.UNSET_OR_UNRECOGNIZED_ENUM_VALUE ? null : aD());
        flatBufferBuilder.m21496a(78, aE() == GraphQLEventWatchStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE ? null : aE());
        flatBufferBuilder.m21507b(79, a32);
        flatBufferBuilder.m21507b(80, c5);
        flatBufferBuilder.m21507b(81, a33);
        flatBufferBuilder.m21507b(82, a34);
        flatBufferBuilder.m21507b(83, a35);
        m9959i();
        return flatBufferBuilder.m21511d();
    }

    public GraphQLProfile(Parcel parcel) {
        boolean z;
        boolean z2 = true;
        super(86);
        this.f16146e = (GraphQLStreetAddress) parcel.readValue(GraphQLStreetAddress.class.getClassLoader());
        this.f16147f = parcel.readString();
        this.f16148g = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.f16149h = ImmutableListHelper.m21625a(parcel.readArrayList(GraphQLBylineFragment.class.getClassLoader()));
        this.f16150i = parcel.readByte() == (byte) 1;
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.f16151j = z;
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.f16152k = z;
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.f16153l = z;
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.f16154m = z;
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.f16155n = z;
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.f16156o = z;
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.f16157p = z;
        this.f16158q = ImmutableListHelper.m21625a(parcel.readArrayList(String.class.getClassLoader()));
        this.f16159r = parcel.readDouble();
        this.f16160s = GraphQLConnectionStyle.fromString(parcel.readString());
        this.f16161t = (GraphQLFocusedPhoto) parcel.readValue(GraphQLFocusedPhoto.class.getClassLoader());
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.f16162u = z;
        this.f16163v = (GraphQLUserEducationExperiencesConnection) parcel.readValue(GraphQLUserEducationExperiencesConnection.class.getClassLoader());
        this.f16164w = ImmutableListHelper.m21625a(parcel.readArrayList(String.class.getClassLoader()));
        this.f16165x = GraphQLEventPrivacyType.fromString(parcel.readString());
        this.f16166y = parcel.readInt();
        this.f16167z = GraphQLEventsCalendarSubscriptionStatus.fromString(parcel.readString());
        this.f16119A = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f16120B = (GraphQLFeedback) parcel.readValue(GraphQLFeedback.class.getClassLoader());
        this.f16121C = (GraphQLFriendsConnection) parcel.readValue(GraphQLFriendsConnection.class.getClassLoader());
        this.f16122D = GraphQLFriendshipStatus.fromString(parcel.readString());
        this.aD = (GraphQLExternalUrl) parcel.readValue(GraphQLExternalUrl.class.getClassLoader());
        this.f16123E = (GraphQLGroupMembersConnection) parcel.readValue(GraphQLGroupMembersConnection.class.getClassLoader());
        this.f16124F = parcel.readInt();
        this.f16125G = parcel.readString();
        this.aE = (GraphQLUser) parcel.readValue(GraphQLUser.class.getClassLoader());
        this.f16126H = parcel.readByte() == (byte) 1;
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.f16127I = z;
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.f16128J = z;
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.f16129K = z;
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.f16130L = z;
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.f16131M = z;
        this.f16132N = (GraphQLLocation) parcel.readValue(GraphQLLocation.class.getClassLoader());
        this.f16133O = (GraphQLMutualFriendsConnection) parcel.readValue(GraphQLMutualFriendsConnection.class.getClassLoader());
        this.f16134P = parcel.readString();
        this.f16135Q = ImmutableListHelper.m21625a(parcel.readArrayList(String.class.getClassLoader()));
        this.f16136R = parcel.readInt();
        this.f16137S = (GraphQLStoryAttachment) parcel.readValue(GraphQLStoryAttachment.class.getClassLoader());
        this.f16138T = (GraphQLPage) parcel.readValue(GraphQLPage.class.getClassLoader());
        this.f16139U = (GraphQLPageLikersConnection) parcel.readValue(GraphQLPageLikersConnection.class.getClassLoader());
        this.f16140V = (GraphQLPageVisitsConnection) parcel.readValue(GraphQLPageVisitsConnection.class.getClassLoader());
        this.f16141W = parcel.readString();
        this.f16142X = (GraphQLPrivacyScope) parcel.readValue(GraphQLPrivacyScope.class.getClassLoader());
        this.f16143Y = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f16144Z = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.aa = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.ab = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.ac = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.ad = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.ae = parcel.readByte() == (byte) 1;
        this.af = parcel.readString();
        this.ag = GraphQLSecondarySubscribeStatus.fromString(parcel.readString());
        this.ah = ImmutableListHelper.m21625a(parcel.readArrayList(String.class.getClassLoader()));
        this.ai = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.aj = (GraphQLStreamingImage) parcel.readValue(GraphQLStreamingImage.class.getClassLoader());
        this.ak = (GraphQLName) parcel.readValue(GraphQLName.class.getClassLoader());
        this.al = ImmutableListHelper.m21625a(parcel.readArrayList(GraphQLName.class.getClassLoader()));
        this.am = GraphQLSubscribeStatus.fromString(parcel.readString());
        this.an = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.ao = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.ap = (GraphQLTrendingTopicData) parcel.readValue(GraphQLTrendingTopicData.class.getClassLoader());
        this.aq = parcel.readString();
        this.ar = parcel.readString();
        this.as = parcel.readString();
        this.at = parcel.readDouble();
        this.au = GraphQLEventGuestStatus.fromString(parcel.readString());
        if (parcel.readByte() != (byte) 1) {
            z2 = false;
        }
        this.av = z2;
        this.aw = GraphQLGroupJoinState.fromString(parcel.readString());
        this.ax = (GraphQLContactRecommendationField) parcel.readValue(GraphQLContactRecommendationField.class.getClassLoader());
        this.ay = GraphQLSavedState.fromString(parcel.readString());
        this.az = GraphQLEventWatchStatus.fromString(parcel.readString());
        this.aA = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.aB = ImmutableListHelper.m21625a(parcel.readArrayList(String.class.getClassLoader()));
        this.aC = (GraphQLUserWorkExperiencesConnection) parcel.readValue(GraphQLUserWorkExperiencesConnection.class.getClassLoader());
        this.f16145d = (GraphQLObjectType) ParcelUtil.b(parcel, GraphQLObjectType.class);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int i2;
        int i3 = 1;
        parcel.writeValue(m23001k());
        parcel.writeString(m23002l());
        parcel.writeValue(m23003m());
        parcel.writeList(m23004n());
        parcel.writeByte((byte) (m23005o() ? 1 : 0));
        if (m23006p()) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        if (m23007q()) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        if (m23008r()) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        if (m23009s()) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        if (m23010t()) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        if (m23011u()) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        if (m23012v()) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        parcel.writeList(m23013w());
        parcel.writeDouble(m23014x());
        parcel.writeString(m23015y().name());
        parcel.writeValue(m23016z());
        if (m22967A()) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        parcel.writeValue(m22968B());
        parcel.writeList(m22969C());
        parcel.writeString(m22970D().name());
        parcel.writeInt(m22971E());
        parcel.writeString(m22972F().name());
        parcel.writeValue(m22973G());
        parcel.writeValue(m22974H());
        parcel.writeValue(m22975I());
        parcel.writeString(m22976J().name());
        parcel.writeValue(aI());
        parcel.writeValue(m22977K());
        parcel.writeInt(m22978L());
        parcel.writeString(m22999b());
        parcel.writeValue(aJ());
        parcel.writeByte((byte) (m22979M() ? 1 : 0));
        if (m22980N()) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        if (m22981O()) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        if (m22982P()) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        if (m22983Q()) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        if (m22984R()) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        parcel.writeValue(m22985S());
        parcel.writeValue(m22986T());
        parcel.writeString(m22987U());
        parcel.writeList(m22988V());
        parcel.writeInt(m22989W());
        parcel.writeValue(m22990X());
        parcel.writeValue(m22991Y());
        parcel.writeValue(m22992Z());
        parcel.writeValue(aa());
        parcel.writeString(ab());
        parcel.writeValue(ac());
        parcel.writeValue(ad());
        parcel.writeValue(ae());
        parcel.writeValue(af());
        parcel.writeValue(ag());
        parcel.writeValue(ah());
        parcel.writeValue(ai());
        parcel.writeByte((byte) (aj() ? 1 : 0));
        parcel.writeString(ak());
        parcel.writeString(al().name());
        parcel.writeList(am());
        parcel.writeValue(an());
        parcel.writeValue(ao());
        parcel.writeValue(ap());
        parcel.writeList(aq());
        parcel.writeString(ar().name());
        parcel.writeValue(as());
        parcel.writeValue(at());
        parcel.writeValue(au());
        parcel.writeString(av());
        parcel.writeString(aw());
        parcel.writeString(ax());
        parcel.writeDouble(ay());
        parcel.writeString(az().name());
        if (!aA()) {
            i3 = 0;
        }
        parcel.writeByte((byte) i3);
        parcel.writeString(aB().name());
        parcel.writeValue(aC());
        parcel.writeString(aD().name());
        parcel.writeString(aE().name());
        parcel.writeValue(aF());
        parcel.writeList(aG());
        parcel.writeValue(aH());
        parcel.writeParcelable(this.f16145d, i);
    }

    public GraphQLProfile(Builder builder) {
        super(86);
        this.b = builder.f15736a;
        this.c = builder.f15737b;
        this.f16146e = builder.d;
        this.f16147f = builder.e;
        this.f16148g = builder.f;
        this.f16149h = builder.g;
        this.f16150i = builder.h;
        this.f16151j = builder.i;
        this.f16152k = builder.j;
        this.f16153l = builder.k;
        this.f16154m = builder.l;
        this.f16155n = builder.m;
        this.f16156o = builder.n;
        this.f16157p = builder.o;
        this.f16158q = builder.p;
        this.f16159r = builder.q;
        this.f16160s = builder.r;
        this.f16161t = builder.s;
        this.f16162u = builder.t;
        this.f16163v = builder.u;
        this.f16164w = builder.v;
        this.f16165x = builder.w;
        this.f16166y = builder.x;
        this.f16167z = builder.y;
        this.f16119A = builder.z;
        this.f16120B = builder.A;
        this.f16121C = builder.B;
        this.f16122D = builder.C;
        this.aD = builder.D;
        this.f16123E = builder.E;
        this.f16124F = builder.F;
        this.f16125G = builder.G;
        this.aE = builder.H;
        this.f16126H = builder.I;
        this.f16127I = builder.J;
        this.f16128J = builder.K;
        this.f16129K = builder.L;
        this.f16130L = builder.M;
        this.f16131M = builder.N;
        this.f16132N = builder.O;
        this.f16133O = builder.P;
        this.f16134P = builder.Q;
        this.f16135Q = builder.R;
        this.f16136R = builder.S;
        this.f16137S = builder.T;
        this.f16138T = builder.U;
        this.f16139U = builder.V;
        this.f16140V = builder.W;
        this.f16141W = builder.X;
        this.f16142X = builder.Y;
        this.f16143Y = builder.Z;
        this.f16144Z = builder.aa;
        this.aa = builder.ab;
        this.ab = builder.ac;
        this.ac = builder.ad;
        this.ad = builder.ae;
        this.ae = builder.af;
        this.af = builder.ag;
        this.ag = builder.ah;
        this.ah = builder.ai;
        this.ai = builder.aj;
        this.aj = builder.ak;
        this.ak = builder.al;
        this.al = builder.am;
        this.am = builder.an;
        this.an = builder.ao;
        this.ao = builder.ap;
        this.ap = builder.aq;
        this.aq = builder.ar;
        this.ar = builder.as;
        this.as = builder.at;
        this.at = builder.au;
        this.au = builder.av;
        this.av = builder.aw;
        this.aw = builder.ax;
        this.ax = builder.ay;
        this.ay = builder.az;
        this.az = builder.aA;
        this.aA = builder.aB;
        this.aB = builder.aC;
        this.aC = builder.aD;
        this.f16145d = builder.aE;
    }
}
