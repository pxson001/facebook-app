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
import com.facebook.graphql.enums.GraphQLPageCategoryType;
import com.facebook.graphql.enums.GraphQLPageOpenHoursDisplayDecisionEnum;
import com.facebook.graphql.enums.GraphQLPageSuperCategoryType;
import com.facebook.graphql.enums.GraphQLPermanentlyClosedStatus;
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
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.instagram.common.json.annotation.JsonType;
import java.util.List;
import javax.annotation.Nullable;

@AutoGenJsonDeserializer
@AutoGenJsonSerializer
@Deprecated
@JsonType
/* compiled from: local_db_write */
public final class GraphQLPlace extends BaseModel implements TypeModel, GraphQLPersistableNode, GraphQLVisitableConsistentModel {
    public static final Creator<GraphQLPlace> CREATOR = new C09771();
    @Nullable
    GraphQLImage f17109A;
    @Nullable
    String f17110B;
    GraphQLPlaceType f17111C;
    @Nullable
    String f17112D;
    @Nullable
    GraphQLImage f17113E;
    @Nullable
    GraphQLImage f17114F;
    @Nullable
    GraphQLPhoto f17115G;
    @Nullable
    GraphQLImage f17116H;
    boolean f17117I;
    @Nullable
    GraphQLPageStarRatersConnection f17118J;
    List<GraphQLRedirectionInfo> f17119K;
    List<GraphQLPhoto> f17120L;
    @Nullable
    GraphQLTimelineAppCollection f17121M;
    List<String> f17122N;
    boolean f17123O;
    List<String> f17124P;
    GraphQLPageSuperCategoryType f17125Q;
    @Nullable
    String f17126R;
    List<String> f17127S;
    public GraphQLSavedState f17128T;
    List<String> f17129U;
    @Nullable
    GraphQLViewerVisitsConnection f17130V;
    @Nullable
    GraphQLTextWithEntities f17131W;
    GraphQLPageOpenHoursDisplayDecisionEnum f17132X;
    @Nullable
    GraphQLObjectType f17133d;
    @Nullable
    GraphQLStreetAddress f17134e;
    boolean f17135f;
    boolean f17136g;
    @Nullable
    GraphQLImage f17137h;
    List<String> f17138i;
    GraphQLPageCategoryType f17139j;
    @Nullable
    GraphQLPage f17140k;
    @Nullable
    String f17141l;
    boolean f17142m;
    boolean f17143n;
    @Nullable
    GraphQLFriendsWhoVisitedConnection f17144o;
    @Nullable
    String f17145p;
    List<GraphQLTimeRange> f17146q;
    @Nullable
    String f17147r;
    boolean f17148s;
    @Nullable
    GraphQLLocation f17149t;
    @Nullable
    GraphQLGeoRectangle f17150u;
    @Nullable
    public String f17151v;
    @Nullable
    GraphQLRating f17152w;
    @Nullable
    GraphQLPageLikersConnection f17153x;
    @Nullable
    GraphQLPageVisitsConnection f17154y;
    GraphQLPermanentlyClosedStatus f17155z;

    /* compiled from: local_db_write */
    final class C09771 implements Creator<GraphQLPlace> {
        C09771() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLPlace(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLPlace[i];
        }
    }

    @Nullable
    public final GraphQLObjectType m24157j() {
        if (this.f5823b != null && this.f17133d == null) {
            this.f17133d = new GraphQLObjectType(this.f5823b.m21542b(this.f5824c, 0));
        }
        if (this.f17133d == null || this.f17133d.m22301g() != 0) {
            return this.f17133d;
        }
        return null;
    }

    @FieldOffset
    @Nullable
    public final GraphQLStreetAddress m24158k() {
        this.f17134e = (GraphQLStreetAddress) super.m9947a(this.f17134e, 1, GraphQLStreetAddress.class);
        return this.f17134e;
    }

    @FieldOffset
    public final boolean m24159l() {
        m9949a(0, 3);
        return this.f17135f;
    }

    @FieldOffset
    public final boolean m24160m() {
        m9949a(0, 4);
        return this.f17136g;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m24161n() {
        this.f17137h = (GraphQLImage) super.m9947a(this.f17137h, 5, GraphQLImage.class);
        return this.f17137h;
    }

    @FieldOffset
    public final ImmutableList<String> m24162o() {
        this.f17138i = super.m9943a(this.f17138i, 6);
        return (ImmutableList) this.f17138i;
    }

    @FieldOffset
    public final GraphQLPageCategoryType m24163p() {
        this.f17139j = (GraphQLPageCategoryType) super.m9945a(this.f17139j, 7, GraphQLPageCategoryType.class, GraphQLPageCategoryType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
        return this.f17139j;
    }

    @FieldOffset
    @Nullable
    public final GraphQLPage m24164q() {
        this.f17140k = (GraphQLPage) super.m9947a(this.f17140k, 8, GraphQLPage.class);
        return this.f17140k;
    }

    @FieldOffset
    @Nullable
    public final String m24165r() {
        this.f17141l = super.m9948a(this.f17141l, 9);
        return this.f17141l;
    }

    @FieldOffset
    public final boolean m24166s() {
        m9949a(1, 2);
        return this.f17142m;
    }

    @FieldOffset
    public final boolean m24167t() {
        m9949a(1, 3);
        return this.f17143n;
    }

    @FieldOffset
    @Nullable
    public final GraphQLFriendsWhoVisitedConnection m24168u() {
        this.f17144o = (GraphQLFriendsWhoVisitedConnection) super.m9947a(this.f17144o, 12, GraphQLFriendsWhoVisitedConnection.class);
        return this.f17144o;
    }

    @FieldOffset
    @Nullable
    public final String m24169v() {
        this.f17145p = super.m9948a(this.f17145p, 13);
        return this.f17145p;
    }

    @FieldOffset
    public final ImmutableList<GraphQLTimeRange> m24170w() {
        this.f17146q = super.m9944a(this.f17146q, 14, GraphQLTimeRange.class);
        return (ImmutableList) this.f17146q;
    }

    @FieldOffset
    @Nullable
    public final String m24171x() {
        this.f17147r = super.m9948a(this.f17147r, 15);
        return this.f17147r;
    }

    @FieldOffset
    public final boolean m24172y() {
        m9949a(2, 0);
        return this.f17148s;
    }

    @FieldOffset
    @Nullable
    public final GraphQLLocation m24173z() {
        this.f17149t = (GraphQLLocation) super.m9947a(this.f17149t, 17, GraphQLLocation.class);
        return this.f17149t;
    }

    @FieldOffset
    @Nullable
    public final GraphQLGeoRectangle m24125A() {
        this.f17150u = (GraphQLGeoRectangle) super.m9947a(this.f17150u, 18, GraphQLGeoRectangle.class);
        return this.f17150u;
    }

    @FieldOffset
    @Nullable
    public final String m24126B() {
        this.f17151v = super.m9948a(this.f17151v, 19);
        return this.f17151v;
    }

    @FieldOffset
    @Nullable
    public final GraphQLRating m24127C() {
        this.f17152w = (GraphQLRating) super.m9947a(this.f17152w, 20, GraphQLRating.class);
        return this.f17152w;
    }

    @FieldOffset
    @Nullable
    public final GraphQLPageLikersConnection m24128D() {
        this.f17153x = (GraphQLPageLikersConnection) super.m9947a(this.f17153x, 21, GraphQLPageLikersConnection.class);
        return this.f17153x;
    }

    @FieldOffset
    @Nullable
    public final GraphQLPageVisitsConnection m24129E() {
        this.f17154y = (GraphQLPageVisitsConnection) super.m9947a(this.f17154y, 22, GraphQLPageVisitsConnection.class);
        return this.f17154y;
    }

    @FieldOffset
    public final GraphQLPermanentlyClosedStatus m24130F() {
        this.f17155z = (GraphQLPermanentlyClosedStatus) super.m9945a(this.f17155z, 23, GraphQLPermanentlyClosedStatus.class, GraphQLPermanentlyClosedStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
        return this.f17155z;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m24131G() {
        this.f17109A = (GraphQLImage) super.m9947a(this.f17109A, 24, GraphQLImage.class);
        return this.f17109A;
    }

    @FieldOffset
    @Nullable
    public final String m24132H() {
        this.f17110B = super.m9948a(this.f17110B, 25);
        return this.f17110B;
    }

    @FieldOffset
    public final GraphQLPlaceType m24133I() {
        this.f17111C = (GraphQLPlaceType) super.m9945a(this.f17111C, 26, GraphQLPlaceType.class, GraphQLPlaceType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
        return this.f17111C;
    }

    @FieldOffset
    @Nullable
    public final String m24134J() {
        this.f17112D = super.m9948a(this.f17112D, 27);
        return this.f17112D;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m24135K() {
        this.f17113E = (GraphQLImage) super.m9947a(this.f17113E, 28, GraphQLImage.class);
        return this.f17113E;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m24136L() {
        this.f17114F = (GraphQLImage) super.m9947a(this.f17114F, 29, GraphQLImage.class);
        return this.f17114F;
    }

    @FieldOffset
    @Nullable
    public final GraphQLPhoto m24137M() {
        this.f17115G = (GraphQLPhoto) super.m9947a(this.f17115G, 30, GraphQLPhoto.class);
        return this.f17115G;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m24138N() {
        this.f17116H = (GraphQLImage) super.m9947a(this.f17116H, 31, GraphQLImage.class);
        return this.f17116H;
    }

    @FieldOffset
    public final boolean m24139O() {
        m9949a(4, 0);
        return this.f17117I;
    }

    @FieldOffset
    @Nullable
    public final GraphQLPageStarRatersConnection m24140P() {
        this.f17118J = (GraphQLPageStarRatersConnection) super.m9947a(this.f17118J, 33, GraphQLPageStarRatersConnection.class);
        return this.f17118J;
    }

    @FieldOffset
    public final ImmutableList<GraphQLRedirectionInfo> m24141Q() {
        this.f17119K = super.m9944a(this.f17119K, 34, GraphQLRedirectionInfo.class);
        return (ImmutableList) this.f17119K;
    }

    @FieldOffset
    public final ImmutableList<GraphQLPhoto> m24142R() {
        this.f17120L = super.m9944a(this.f17120L, 35, GraphQLPhoto.class);
        return (ImmutableList) this.f17120L;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTimelineAppCollection m24143S() {
        this.f17121M = (GraphQLTimelineAppCollection) super.m9947a(this.f17121M, 36, GraphQLTimelineAppCollection.class);
        return this.f17121M;
    }

    @FieldOffset
    public final ImmutableList<String> m24144T() {
        this.f17122N = super.m9943a(this.f17122N, 37);
        return (ImmutableList) this.f17122N;
    }

    @FieldOffset
    public final boolean m24145U() {
        m9949a(4, 6);
        return this.f17123O;
    }

    @FieldOffset
    public final ImmutableList<String> m24146V() {
        this.f17124P = super.m9943a(this.f17124P, 39);
        return (ImmutableList) this.f17124P;
    }

    @FieldOffset
    public final GraphQLPageSuperCategoryType m24147W() {
        this.f17125Q = (GraphQLPageSuperCategoryType) super.m9945a(this.f17125Q, 40, GraphQLPageSuperCategoryType.class, GraphQLPageSuperCategoryType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
        return this.f17125Q;
    }

    @FieldOffset
    @Nullable
    public final String m24148X() {
        this.f17126R = super.m9948a(this.f17126R, 41);
        return this.f17126R;
    }

    @FieldOffset
    public final ImmutableList<String> m24149Y() {
        this.f17127S = super.m9943a(this.f17127S, 42);
        return (ImmutableList) this.f17127S;
    }

    @FieldOffset
    public final GraphQLSavedState m24150Z() {
        this.f17128T = (GraphQLSavedState) super.m9945a(this.f17128T, 43, GraphQLSavedState.class, GraphQLSavedState.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
        return this.f17128T;
    }

    @FieldOffset
    public final ImmutableList<String> aa() {
        this.f17129U = super.m9943a(this.f17129U, 44);
        return (ImmutableList) this.f17129U;
    }

    @FieldOffset
    @Nullable
    public final GraphQLViewerVisitsConnection ab() {
        this.f17130V = (GraphQLViewerVisitsConnection) super.m9947a(this.f17130V, 45, GraphQLViewerVisitsConnection.class);
        return this.f17130V;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities ac() {
        this.f17131W = (GraphQLTextWithEntities) super.m9947a(this.f17131W, 46, GraphQLTextWithEntities.class);
        return this.f17131W;
    }

    @FieldOffset
    public final GraphQLPageOpenHoursDisplayDecisionEnum ad() {
        this.f17132X = (GraphQLPageOpenHoursDisplayDecisionEnum) super.m9945a(this.f17132X, 47, GraphQLPageOpenHoursDisplayDecisionEnum.class, GraphQLPageOpenHoursDisplayDecisionEnum.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
        return this.f17132X;
    }

    @Nullable
    public final String mo2834a() {
        return m24171x();
    }

    public final int jK_() {
        return 77195495;
    }

    public final GraphQLVisitableModel mo1404a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLImage graphQLImage;
        Builder a;
        GraphQLVisitableModel graphQLVisitableModel = null;
        m9958h();
        if (m24158k() != null) {
            GraphQLStreetAddress graphQLStreetAddress = (GraphQLStreetAddress) graphQLModelMutatingVisitor.mo2928b(m24158k());
            if (m24158k() != graphQLStreetAddress) {
                graphQLVisitableModel = (GraphQLPlace) ModelHelper.m23095a(null, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17134e = graphQLStreetAddress;
            }
        }
        if (m24161n() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(m24161n());
            if (m24161n() != graphQLImage) {
                graphQLVisitableModel = (GraphQLPlace) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17137h = graphQLImage;
            }
        }
        if (m24164q() != null) {
            GraphQLPage graphQLPage = (GraphQLPage) graphQLModelMutatingVisitor.mo2928b(m24164q());
            if (m24164q() != graphQLPage) {
                graphQLVisitableModel = (GraphQLPlace) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17140k = graphQLPage;
            }
        }
        if (m24168u() != null) {
            GraphQLFriendsWhoVisitedConnection graphQLFriendsWhoVisitedConnection = (GraphQLFriendsWhoVisitedConnection) graphQLModelMutatingVisitor.mo2928b(m24168u());
            if (m24168u() != graphQLFriendsWhoVisitedConnection) {
                graphQLVisitableModel = (GraphQLPlace) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17144o = graphQLFriendsWhoVisitedConnection;
            }
        }
        if (m24170w() != null) {
            a = ModelHelper.m23097a(m24170w(), graphQLModelMutatingVisitor);
            if (a != null) {
                GraphQLPlace graphQLPlace = (GraphQLPlace) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLPlace.f17146q = a.m1068b();
                graphQLVisitableModel = graphQLPlace;
            }
        }
        if (m24173z() != null) {
            GraphQLLocation graphQLLocation = (GraphQLLocation) graphQLModelMutatingVisitor.mo2928b(m24173z());
            if (m24173z() != graphQLLocation) {
                graphQLVisitableModel = (GraphQLPlace) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17149t = graphQLLocation;
            }
        }
        if (m24125A() != null) {
            GraphQLGeoRectangle graphQLGeoRectangle = (GraphQLGeoRectangle) graphQLModelMutatingVisitor.mo2928b(m24125A());
            if (m24125A() != graphQLGeoRectangle) {
                graphQLVisitableModel = (GraphQLPlace) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17150u = graphQLGeoRectangle;
            }
        }
        if (m24127C() != null) {
            GraphQLRating graphQLRating = (GraphQLRating) graphQLModelMutatingVisitor.mo2928b(m24127C());
            if (m24127C() != graphQLRating) {
                graphQLVisitableModel = (GraphQLPlace) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17152w = graphQLRating;
            }
        }
        if (m24128D() != null) {
            GraphQLPageLikersConnection graphQLPageLikersConnection = (GraphQLPageLikersConnection) graphQLModelMutatingVisitor.mo2928b(m24128D());
            if (m24128D() != graphQLPageLikersConnection) {
                graphQLVisitableModel = (GraphQLPlace) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17153x = graphQLPageLikersConnection;
            }
        }
        if (m24129E() != null) {
            GraphQLPageVisitsConnection graphQLPageVisitsConnection = (GraphQLPageVisitsConnection) graphQLModelMutatingVisitor.mo2928b(m24129E());
            if (m24129E() != graphQLPageVisitsConnection) {
                graphQLVisitableModel = (GraphQLPlace) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17154y = graphQLPageVisitsConnection;
            }
        }
        if (m24131G() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(m24131G());
            if (m24131G() != graphQLImage) {
                graphQLVisitableModel = (GraphQLPlace) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17109A = graphQLImage;
            }
        }
        if (ac() != null) {
            GraphQLTextWithEntities graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.mo2928b(ac());
            if (ac() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLPlace) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17131W = graphQLTextWithEntities;
            }
        }
        if (m24135K() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(m24135K());
            if (m24135K() != graphQLImage) {
                graphQLVisitableModel = (GraphQLPlace) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17113E = graphQLImage;
            }
        }
        if (m24136L() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(m24136L());
            if (m24136L() != graphQLImage) {
                graphQLVisitableModel = (GraphQLPlace) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17114F = graphQLImage;
            }
        }
        if (m24137M() != null) {
            GraphQLPhoto graphQLPhoto = (GraphQLPhoto) graphQLModelMutatingVisitor.mo2928b(m24137M());
            if (m24137M() != graphQLPhoto) {
                graphQLVisitableModel = (GraphQLPlace) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17115G = graphQLPhoto;
            }
        }
        if (m24138N() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(m24138N());
            if (m24138N() != graphQLImage) {
                graphQLVisitableModel = (GraphQLPlace) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17116H = graphQLImage;
            }
        }
        if (m24140P() != null) {
            GraphQLPageStarRatersConnection graphQLPageStarRatersConnection = (GraphQLPageStarRatersConnection) graphQLModelMutatingVisitor.mo2928b(m24140P());
            if (m24140P() != graphQLPageStarRatersConnection) {
                graphQLVisitableModel = (GraphQLPlace) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17118J = graphQLPageStarRatersConnection;
            }
        }
        if (m24141Q() != null) {
            a = ModelHelper.m23097a(m24141Q(), graphQLModelMutatingVisitor);
            if (a != null) {
                graphQLPlace = (GraphQLPlace) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLPlace.f17119K = a.m1068b();
                graphQLVisitableModel = graphQLPlace;
            }
        }
        if (m24142R() != null) {
            a = ModelHelper.m23097a(m24142R(), graphQLModelMutatingVisitor);
            if (a != null) {
                graphQLPlace = (GraphQLPlace) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLPlace.f17120L = a.m1068b();
                graphQLVisitableModel = graphQLPlace;
            }
        }
        if (m24143S() != null) {
            GraphQLTimelineAppCollection graphQLTimelineAppCollection = (GraphQLTimelineAppCollection) graphQLModelMutatingVisitor.mo2928b(m24143S());
            if (m24143S() != graphQLTimelineAppCollection) {
                graphQLVisitableModel = (GraphQLPlace) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17121M = graphQLTimelineAppCollection;
            }
        }
        if (ab() != null) {
            GraphQLViewerVisitsConnection graphQLViewerVisitsConnection = (GraphQLViewerVisitsConnection) graphQLModelMutatingVisitor.mo2928b(ab());
            if (ab() != graphQLViewerVisitsConnection) {
                graphQLVisitableModel = (GraphQLPlace) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17130V = graphQLViewerVisitsConnection;
            }
        }
        m9959i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public final void mo2835a(String str, ConsistencyTuple consistencyTuple) {
        if ("address.full_address".equals(str)) {
            BaseModel k = m24158k();
            if (k != null) {
                consistencyTuple.f18727a = k.m23815m();
                consistencyTuple.f18728b = k.u_();
                consistencyTuple.f18729c = 4;
                return;
            }
        } else if ("name".equals(str)) {
            consistencyTuple.f18727a = m24126B();
            consistencyTuple.f18728b = u_();
            consistencyTuple.f18729c = 19;
            return;
        } else if ("viewer_saved_state".equals(str)) {
            consistencyTuple.f18727a = m24150Z();
            consistencyTuple.f18728b = u_();
            consistencyTuple.f18729c = 43;
            return;
        }
        consistencyTuple.m26322a();
    }

    public final void mo2836a(String str, Object obj, boolean z) {
        if ("address.full_address".equals(str)) {
            BaseModel k = m24158k();
            if (k == null) {
                return;
            }
            if (z) {
                GraphQLStreetAddress graphQLStreetAddress = (GraphQLStreetAddress) k.clone();
                graphQLStreetAddress.m23811a((String) obj);
                this.f17134e = graphQLStreetAddress;
                return;
            }
            k.m23811a((String) obj);
        } else if ("name".equals(str)) {
            String str2 = (String) obj;
            this.f17151v = str2;
            if (this.f5823b != null && this.f5823b.f15024d) {
                this.f5823b.m21537a(this.f5824c, 19, str2);
            }
        } else if ("viewer_saved_state".equals(str)) {
            Enum enumR = (GraphQLSavedState) obj;
            this.f17128T = enumR;
            if (this.f5823b != null && this.f5823b.f15024d) {
                this.f5823b.m21536a(this.f5824c, 43, enumR);
            }
        }
    }

    public GraphQLPlace() {
        super(49);
    }

    public final void mo1406a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.mo1406a(mutableFlatBuffer, i, obj);
        this.f17135f = mutableFlatBuffer.m21540a(i, 3);
        this.f17136g = mutableFlatBuffer.m21540a(i, 4);
        this.f17142m = mutableFlatBuffer.m21540a(i, 10);
        this.f17143n = mutableFlatBuffer.m21540a(i, 11);
        this.f17148s = mutableFlatBuffer.m21540a(i, 16);
        this.f17117I = mutableFlatBuffer.m21540a(i, 32);
        this.f17123O = mutableFlatBuffer.m21540a(i, 38);
    }

    public final int mo1403a(FlatBufferBuilder flatBufferBuilder) {
        m9958h();
        int a = flatBufferBuilder.m21479a(m24157j() != null ? m24157j().m22299e() : null);
        int a2 = ModelHelper.m23093a(flatBufferBuilder, m24158k());
        int a3 = ModelHelper.m23093a(flatBufferBuilder, m24161n());
        int c = flatBufferBuilder.m21509c(m24162o());
        int a4 = ModelHelper.m23093a(flatBufferBuilder, m24164q());
        int b = flatBufferBuilder.m21502b(m24165r());
        int a5 = ModelHelper.m23093a(flatBufferBuilder, m24168u());
        int b2 = flatBufferBuilder.m21502b(m24169v());
        int a6 = ModelHelper.m23094a(flatBufferBuilder, m24170w());
        int b3 = flatBufferBuilder.m21502b(m24171x());
        int a7 = ModelHelper.m23093a(flatBufferBuilder, m24173z());
        int a8 = ModelHelper.m23093a(flatBufferBuilder, m24125A());
        int b4 = flatBufferBuilder.m21502b(m24126B());
        int a9 = ModelHelper.m23093a(flatBufferBuilder, m24127C());
        int a10 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) m24128D());
        int a11 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) m24129E());
        int a12 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) m24131G());
        int b5 = flatBufferBuilder.m21502b(m24132H());
        int b6 = flatBufferBuilder.m21502b(m24134J());
        int a13 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) m24135K());
        int a14 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) m24136L());
        int a15 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) m24137M());
        int a16 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) m24138N());
        int a17 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) m24140P());
        int a18 = ModelHelper.m23094a(flatBufferBuilder, (List) m24141Q());
        int a19 = ModelHelper.m23094a(flatBufferBuilder, (List) m24142R());
        int a20 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) m24143S());
        int c2 = flatBufferBuilder.m21509c((List) m24144T());
        int c3 = flatBufferBuilder.m21509c((List) m24146V());
        int b7 = flatBufferBuilder.m21502b(m24148X());
        int c4 = flatBufferBuilder.m21509c((List) m24149Y());
        int c5 = flatBufferBuilder.m21509c((List) aa());
        int a21 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) ab());
        int a22 = ModelHelper.m23093a(flatBufferBuilder, (MutableFlattenable) ac());
        flatBufferBuilder.m21510c(48);
        flatBufferBuilder.m21507b(0, a);
        flatBufferBuilder.m21507b(1, a2);
        flatBufferBuilder.m21498a(3, m24159l());
        flatBufferBuilder.m21498a(4, m24160m());
        flatBufferBuilder.m21507b(5, a3);
        flatBufferBuilder.m21507b(6, c);
        flatBufferBuilder.m21496a(7, m24163p() == GraphQLPageCategoryType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE ? null : m24163p());
        flatBufferBuilder.m21507b(8, a4);
        flatBufferBuilder.m21507b(9, b);
        flatBufferBuilder.m21498a(10, m24166s());
        flatBufferBuilder.m21498a(11, m24167t());
        flatBufferBuilder.m21507b(12, a5);
        flatBufferBuilder.m21507b(13, b2);
        flatBufferBuilder.m21507b(14, a6);
        flatBufferBuilder.m21507b(15, b3);
        flatBufferBuilder.m21498a(16, m24172y());
        flatBufferBuilder.m21507b(17, a7);
        flatBufferBuilder.m21507b(18, a8);
        flatBufferBuilder.m21507b(19, b4);
        flatBufferBuilder.m21507b(20, a9);
        flatBufferBuilder.m21507b(21, a10);
        flatBufferBuilder.m21507b(22, a11);
        flatBufferBuilder.m21496a(23, m24130F() == GraphQLPermanentlyClosedStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE ? null : m24130F());
        flatBufferBuilder.m21507b(24, a12);
        flatBufferBuilder.m21507b(25, b5);
        flatBufferBuilder.m21496a(26, m24133I() == GraphQLPlaceType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE ? null : m24133I());
        flatBufferBuilder.m21507b(27, b6);
        flatBufferBuilder.m21507b(28, a13);
        flatBufferBuilder.m21507b(29, a14);
        flatBufferBuilder.m21507b(30, a15);
        flatBufferBuilder.m21507b(31, a16);
        flatBufferBuilder.m21498a(32, m24139O());
        flatBufferBuilder.m21507b(33, a17);
        flatBufferBuilder.m21507b(34, a18);
        flatBufferBuilder.m21507b(35, a19);
        flatBufferBuilder.m21507b(36, a20);
        flatBufferBuilder.m21507b(37, c2);
        flatBufferBuilder.m21498a(38, m24145U());
        flatBufferBuilder.m21507b(39, c3);
        flatBufferBuilder.m21496a(40, m24147W() == GraphQLPageSuperCategoryType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE ? null : m24147W());
        flatBufferBuilder.m21507b(41, b7);
        flatBufferBuilder.m21507b(42, c4);
        flatBufferBuilder.m21496a(43, m24150Z() == GraphQLSavedState.UNSET_OR_UNRECOGNIZED_ENUM_VALUE ? null : m24150Z());
        flatBufferBuilder.m21507b(44, c5);
        flatBufferBuilder.m21507b(45, a21);
        flatBufferBuilder.m21507b(46, a22);
        flatBufferBuilder.m21496a(47, ad() == GraphQLPageOpenHoursDisplayDecisionEnum.UNSET_OR_UNRECOGNIZED_ENUM_VALUE ? null : ad());
        m9959i();
        return flatBufferBuilder.m21511d();
    }

    public GraphQLPlace(Parcel parcel) {
        boolean z;
        boolean z2 = true;
        super(49);
        this.f17134e = (GraphQLStreetAddress) parcel.readValue(GraphQLStreetAddress.class.getClassLoader());
        this.f17135f = parcel.readByte() == (byte) 1;
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.f17136g = z;
        this.f17137h = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f17138i = ImmutableListHelper.m21625a(parcel.readArrayList(String.class.getClassLoader()));
        this.f17139j = GraphQLPageCategoryType.fromString(parcel.readString());
        this.f17140k = (GraphQLPage) parcel.readValue(GraphQLPage.class.getClassLoader());
        this.f17141l = parcel.readString();
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.f17142m = z;
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.f17143n = z;
        this.f17144o = (GraphQLFriendsWhoVisitedConnection) parcel.readValue(GraphQLFriendsWhoVisitedConnection.class.getClassLoader());
        this.f17145p = parcel.readString();
        this.f17146q = ImmutableListHelper.m21625a(parcel.readArrayList(GraphQLTimeRange.class.getClassLoader()));
        this.f17147r = parcel.readString();
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.f17148s = z;
        this.f17149t = (GraphQLLocation) parcel.readValue(GraphQLLocation.class.getClassLoader());
        this.f17150u = (GraphQLGeoRectangle) parcel.readValue(GraphQLGeoRectangle.class.getClassLoader());
        this.f17151v = parcel.readString();
        this.f17152w = (GraphQLRating) parcel.readValue(GraphQLRating.class.getClassLoader());
        this.f17153x = (GraphQLPageLikersConnection) parcel.readValue(GraphQLPageLikersConnection.class.getClassLoader());
        this.f17154y = (GraphQLPageVisitsConnection) parcel.readValue(GraphQLPageVisitsConnection.class.getClassLoader());
        this.f17155z = GraphQLPermanentlyClosedStatus.fromString(parcel.readString());
        this.f17109A = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f17131W = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.f17132X = GraphQLPageOpenHoursDisplayDecisionEnum.fromString(parcel.readString());
        this.f17110B = parcel.readString();
        this.f17111C = GraphQLPlaceType.fromString(parcel.readString());
        this.f17112D = parcel.readString();
        this.f17113E = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f17114F = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f17115G = (GraphQLPhoto) parcel.readValue(GraphQLPhoto.class.getClassLoader());
        this.f17116H = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f17117I = parcel.readByte() == (byte) 1;
        this.f17118J = (GraphQLPageStarRatersConnection) parcel.readValue(GraphQLPageStarRatersConnection.class.getClassLoader());
        this.f17119K = ImmutableListHelper.m21625a(parcel.readArrayList(GraphQLRedirectionInfo.class.getClassLoader()));
        this.f17120L = ImmutableListHelper.m21625a(parcel.readArrayList(GraphQLPhoto.class.getClassLoader()));
        this.f17121M = (GraphQLTimelineAppCollection) parcel.readValue(GraphQLTimelineAppCollection.class.getClassLoader());
        this.f17122N = ImmutableListHelper.m21625a(parcel.readArrayList(String.class.getClassLoader()));
        if (parcel.readByte() != (byte) 1) {
            z2 = false;
        }
        this.f17123O = z2;
        this.f17124P = ImmutableListHelper.m21625a(parcel.readArrayList(String.class.getClassLoader()));
        this.f17125Q = GraphQLPageSuperCategoryType.fromString(parcel.readString());
        this.f17126R = parcel.readString();
        this.f17127S = ImmutableListHelper.m21625a(parcel.readArrayList(String.class.getClassLoader()));
        this.f17128T = GraphQLSavedState.fromString(parcel.readString());
        this.f17130V = (GraphQLViewerVisitsConnection) parcel.readValue(GraphQLViewerVisitsConnection.class.getClassLoader());
        this.f17129U = ImmutableListHelper.m21625a(parcel.readArrayList(String.class.getClassLoader()));
        this.f17133d = (GraphQLObjectType) ParcelUtil.b(parcel, GraphQLObjectType.class);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int i2;
        int i3 = 1;
        parcel.writeValue(m24158k());
        parcel.writeByte((byte) (m24159l() ? 1 : 0));
        if (m24160m()) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        parcel.writeValue(m24161n());
        parcel.writeList(m24162o());
        parcel.writeString(m24163p().name());
        parcel.writeValue(m24164q());
        parcel.writeString(m24165r());
        if (m24166s()) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        if (m24167t()) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        parcel.writeValue(m24168u());
        parcel.writeString(m24169v());
        parcel.writeList(m24170w());
        parcel.writeString(m24171x());
        if (m24172y()) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        parcel.writeValue(m24173z());
        parcel.writeValue(m24125A());
        parcel.writeString(m24126B());
        parcel.writeValue(m24127C());
        parcel.writeValue(m24128D());
        parcel.writeValue(m24129E());
        parcel.writeString(m24130F().name());
        parcel.writeValue(m24131G());
        parcel.writeValue(ac());
        parcel.writeString(ad().name());
        parcel.writeString(m24132H());
        parcel.writeString(m24133I().name());
        parcel.writeString(m24134J());
        parcel.writeValue(m24135K());
        parcel.writeValue(m24136L());
        parcel.writeValue(m24137M());
        parcel.writeValue(m24138N());
        parcel.writeByte((byte) (m24139O() ? 1 : 0));
        parcel.writeValue(m24140P());
        parcel.writeList(m24141Q());
        parcel.writeList(m24142R());
        parcel.writeValue(m24143S());
        parcel.writeList(m24144T());
        if (!m24145U()) {
            i3 = 0;
        }
        parcel.writeByte((byte) i3);
        parcel.writeList(m24146V());
        parcel.writeString(m24147W().name());
        parcel.writeString(m24148X());
        parcel.writeList(m24149Y());
        parcel.writeString(m24150Z().name());
        parcel.writeValue(ab());
        parcel.writeList(aa());
        parcel.writeParcelable(this.f17133d, i);
    }

    public GraphQLPlace(Builder builder) {
        super(49);
        this.b = builder.f15736a;
        this.c = builder.f15737b;
        this.f17134e = builder.d;
        this.f17135f = builder.e;
        this.f17136g = builder.f;
        this.f17137h = builder.g;
        this.f17138i = builder.h;
        this.f17139j = builder.i;
        this.f17140k = builder.j;
        this.f17141l = builder.k;
        this.f17142m = builder.l;
        this.f17143n = builder.m;
        this.f17144o = builder.n;
        this.f17145p = builder.o;
        this.f17146q = builder.p;
        this.f17147r = builder.q;
        this.f17148s = builder.r;
        this.f17149t = builder.s;
        this.f17150u = builder.t;
        this.f17151v = builder.u;
        this.f17152w = builder.v;
        this.f17153x = builder.w;
        this.f17154y = builder.x;
        this.f17155z = builder.y;
        this.f17109A = builder.z;
        this.f17131W = builder.A;
        this.f17132X = builder.B;
        this.f17110B = builder.C;
        this.f17111C = builder.D;
        this.f17112D = builder.E;
        this.f17113E = builder.F;
        this.f17114F = builder.G;
        this.f17115G = builder.H;
        this.f17116H = builder.I;
        this.f17117I = builder.J;
        this.f17118J = builder.K;
        this.f17119K = builder.L;
        this.f17120L = builder.M;
        this.f17121M = builder.N;
        this.f17122N = builder.O;
        this.f17123O = builder.P;
        this.f17124P = builder.Q;
        this.f17125Q = builder.R;
        this.f17126R = builder.S;
        this.f17127S = builder.T;
        this.f17128T = builder.U;
        this.f17130V = builder.V;
        this.f17129U = builder.W;
        this.f17133d = builder.X;
    }
}
