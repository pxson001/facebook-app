package com.facebook.nearby.model;

import android.content.res.Resources;
import android.location.Location;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.unicode.RangeConverter;
import com.facebook.common.unicode.UTF16Range;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.graphql.model.GraphQLEntityAtRange;
import com.facebook.graphql.model.GraphQLGraphSearchConnectedFriendsConnection;
import com.facebook.graphql.model.GraphQLGraphSearchConnectedFriendsEdge;
import com.facebook.graphql.model.GraphQLGraphSearchResultDecoration;
import com.facebook.graphql.model.GraphQLHelper;
import com.facebook.graphql.model.GraphQLImage;
import com.facebook.graphql.model.GraphQLLocation;
import com.facebook.graphql.model.GraphQLPage;
import com.facebook.graphql.model.GraphQLPlacesTileResultsEdge;
import com.facebook.graphql.model.GraphQLRating;
import com.facebook.graphql.model.GraphQLTextWithEntities;
import com.facebook.graphql.model.GraphQLUser;
import com.facebook.maps.Locations;
import com.facebook.nearby.v2.network.BrowseNearbyPlacesGraphQLModels.BrowseNearbyPlacesFullImageFragmentModel;
import com.facebook.nearby.v2.network.BrowseNearbyPlacesGraphQLModels.NearbyPagePlaceInfoFragmentModel.LocationModel;
import com.facebook.nearby.v2.network.BrowseNearbyPlacesGraphQLModels.NearbyPagePlaceInfoFragmentModel.OverallStarRatingModel;
import com.facebook.nearby.v2.network.BrowseNearbyPlacesGraphQLModels.NearbyPlacesOldBrowseOldResultConnectionFragmentModel.EdgesModel;
import com.facebook.nearby.v2.network.BrowseNearbyPlacesGraphQLModels.NearbyPlacesOldBrowseOldResultConnectionFragmentModel.EdgesModel.NodeModel;
import com.facebook.nearby.v2.network.BrowseNearbyPlacesGraphQLModels.NearbyPlacesOldFlowFriendsWhoVisitedFragmentModel.FriendsWhoVisitedModel;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;

/* compiled from: unseenMessageCount */
public class NearbyPlaceEdgeWrapper implements Parcelable {
    public static final Creator<NearbyPlaceEdgeWrapper> CREATOR = new C00531();
    private NearbyPlaceEdgeWithLayout f382a = null;
    public GraphQLPlacesTileResultsEdge f383b = null;
    public GraphQLPage f384c = null;
    public GraphQLGraphSearchConnectedFriendsConnection f385d = null;
    public EdgesModel f386e = null;
    public NodeModel f387f = null;
    public FriendsWhoVisitedModel f388g = null;
    private Location f389h = null;

    /* compiled from: unseenMessageCount */
    final class C00531 implements Creator<NearbyPlaceEdgeWrapper> {
        C00531() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new NearbyPlaceEdgeWrapper(parcel);
        }

        public final Object[] newArray(int i) {
            return new NearbyPlaceEdgeWrapper[i];
        }
    }

    /* compiled from: unseenMessageCount */
    public enum ImageSize {
        SIZE_DEFAULT,
        SIZE_LARGE,
        SIZE_SMALL,
        SIZE_74,
        SIZE_60,
        SIZE_50,
        SIZE_32
    }

    public NearbyPlaceEdgeWrapper(NearbyPlaceEdgeWithLayout nearbyPlaceEdgeWithLayout) {
        Preconditions.checkNotNull(nearbyPlaceEdgeWithLayout);
        Preconditions.checkNotNull(nearbyPlaceEdgeWithLayout.placeEdge);
        Preconditions.checkNotNull(nearbyPlaceEdgeWithLayout.placeEdge.a());
        m495a(nearbyPlaceEdgeWithLayout, null);
    }

    public NearbyPlaceEdgeWrapper(EdgesModel edgesModel) {
        Preconditions.checkNotNull(edgesModel);
        Preconditions.checkNotNull(edgesModel.a());
        m495a(null, edgesModel);
    }

    public NearbyPlaceEdgeWrapper(Parcel parcel) {
        m495a((NearbyPlaceEdgeWithLayout) parcel.readParcelable(NearbyPlaceEdgeWithLayout.class.getClassLoader()), (EdgesModel) FlatBufferModelHelper.a(parcel));
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f382a, i);
        FlatBufferModelHelper.a(parcel, this.f386e);
    }

    private String m496b(int i) {
        if (this.f385d != null) {
            GraphQLUser a = m493a(this.f385d, i);
            if (a != null) {
                return a.ar();
            }
        } else if (this.f388g != null) {
            FriendsWhoVisitedModel.EdgesModel.NodeModel a2 = m494a(this.f388g, i);
            if (a2 != null) {
                return a2.j();
            }
        }
        return "";
    }

    public final int m498b() {
        if (this.f385d != null) {
            return this.f385d.a();
        }
        if (this.f388g != null) {
            return this.f388g.a();
        }
        return 0;
    }

    public final CharSequence m497a(Resources resources) {
        int i = 0;
        if (this.f383b != null) {
            GraphQLTextWithEntities l = this.f383b.l();
            if (l != null) {
                if (l.b() == null) {
                    return l.a();
                }
                CharSequence valueOf;
                if (TextUtils.isEmpty(l.a())) {
                    valueOf = SpannableString.valueOf("");
                } else {
                    valueOf = new SpannableString(l.a());
                }
                ImmutableList b = l.b();
                int size = b.size();
                while (i < size) {
                    UTF16Range a = RangeConverter.a(l.a(), GraphQLHelper.a((GraphQLEntityAtRange) b.get(i)));
                    valueOf.setSpan(new ForegroundColorSpan(resources.getColor(2131363240)), a.a, a.c(), 33);
                    i++;
                }
                return valueOf;
            }
        } else if (this.f386e != null) {
            int b2 = m498b();
            switch (b2) {
                case 0:
                    break;
                case 1:
                    return resources.getString(2131236697, new Object[]{m496b(0), m504h()});
                case 2:
                    return resources.getString(2131236698, new Object[]{m496b(0), m496b(1), m504h()});
                default:
                    return resources.getQuantityString(2131689657, b2 - 2, new Object[]{m496b(0), m496b(1), Integer.valueOf(b2 - 2), m504h()});
            }
        }
        return "";
    }

    public final String m499c() {
        if (this.f384c != null) {
            return this.f384c.ae();
        }
        if (this.f387f != null) {
            return this.f387f.k();
        }
        return "";
    }

    public final double m500d() {
        if (this.f384c != null) {
            GraphQLLocation az = this.f384c.az();
            if (az != null) {
                return az.a();
            }
        } else if (this.f387f != null) {
            LocationModel l = this.f387f.l();
            if (l != null) {
                return l.a();
            }
        }
        return 0.0d;
    }

    public final String m501e() {
        return this.f382a != null ? this.f382a.layout : null;
    }

    public final Location m502f() {
        if (this.f389h == null) {
            this.f389h = Locations.a(m500d(), m503g());
        } else {
            this.f389h.setLatitude(m500d());
            this.f389h.setLongitude(m503g());
        }
        return this.f389h;
    }

    public final double m503g() {
        if (this.f384c != null) {
            GraphQLLocation az = this.f384c.az();
            if (az != null) {
                return az.b();
            }
        } else if (this.f387f != null) {
            LocationModel l = this.f387f.l();
            if (l != null) {
                return l.b();
            }
        }
        return 0.0d;
    }

    public final String m504h() {
        if (this.f384c != null) {
            return this.f384c.aG();
        }
        if (this.f387f != null) {
            return this.f387f.m();
        }
        return "";
    }

    public final double m505i() {
        if (this.f384c != null) {
            GraphQLRating aM = this.f384c.aM();
            if (aM != null) {
                return aM.k();
            }
            return this.f384c.aL();
        }
        if (this.f387f != null) {
            OverallStarRatingModel n = this.f387f.n();
            if (n != null) {
                return n.c();
            }
        }
        return 0.0d;
    }

    public final double m506k() {
        if (this.f383b != null) {
            return this.f383b.k();
        }
        if (this.f386e != null) {
            return Double.MAX_VALUE;
        }
        return 0.0d;
    }

    public final ImmutableList<String> m507l() {
        ImmutableList<String> immutableList = null;
        if (this.f384c != null) {
            immutableList = this.f384c.bG();
        } else if (this.f387f != null) {
            immutableList = this.f387f.t();
        }
        if (immutableList == null) {
            return RegularImmutableList.a;
        }
        return immutableList;
    }

    public final String m508m() {
        for (ImageSize imageSize : ImageSize.values()) {
            String str;
            String str2;
            if (this.f384c != null) {
                GraphQLPage graphQLPage = this.f384c;
                GraphQLImage graphQLImage = null;
                if (graphQLPage != null) {
                    switch (imageSize) {
                        case SIZE_50:
                        case SIZE_SMALL:
                            graphQLImage = graphQLPage.bi();
                            break;
                        case SIZE_LARGE:
                        case SIZE_74:
                            graphQLImage = graphQLPage.bk();
                            break;
                        case SIZE_DEFAULT:
                            graphQLImage = graphQLPage.bs();
                            break;
                        case SIZE_60:
                            graphQLImage = graphQLPage.bj();
                            break;
                    }
                }
                if (graphQLImage == null) {
                    str2 = "";
                } else {
                    str2 = graphQLImage.b();
                }
                str = str2;
            } else if (this.f387f != null) {
                NodeModel nodeModel = this.f387f;
                BrowseNearbyPlacesFullImageFragmentModel browseNearbyPlacesFullImageFragmentModel = null;
                if (nodeModel != null) {
                    switch (imageSize) {
                        case SIZE_50:
                        case SIZE_SMALL:
                            browseNearbyPlacesFullImageFragmentModel = nodeModel.q();
                            break;
                        case SIZE_LARGE:
                        case SIZE_DEFAULT:
                        case SIZE_74:
                            browseNearbyPlacesFullImageFragmentModel = nodeModel.r();
                            break;
                    }
                }
                if (browseNearbyPlacesFullImageFragmentModel == null) {
                    str2 = "";
                } else {
                    str2 = browseNearbyPlacesFullImageFragmentModel.d();
                }
                str = str2;
            } else {
                str = "";
            }
            String str3 = str;
            if (!TextUtils.isEmpty(str3)) {
                return str3;
            }
        }
        return "";
    }

    public final boolean m509p() {
        if (this.f384c != null) {
            return this.f384c.bt();
        }
        if (this.f387f != null) {
            return this.f387f.s();
        }
        return false;
    }

    private void m495a(NearbyPlaceEdgeWithLayout nearbyPlaceEdgeWithLayout, EdgesModel edgesModel) {
        if (nearbyPlaceEdgeWithLayout != null) {
            this.f382a = nearbyPlaceEdgeWithLayout;
            this.f383b = nearbyPlaceEdgeWithLayout.placeEdge;
            this.f384c = this.f383b.a();
            GraphQLGraphSearchResultDecoration j = this.f383b.j();
            if (j != null) {
                this.f385d = j.j();
            }
        }
        if (edgesModel != null) {
            this.f386e = edgesModel;
            this.f387f = edgesModel.a();
            if (this.f387f != null) {
                this.f388g = this.f387f.j();
            }
        }
    }

    public static GraphQLUser m493a(GraphQLGraphSearchConnectedFriendsConnection graphQLGraphSearchConnectedFriendsConnection, int i) {
        if (graphQLGraphSearchConnectedFriendsConnection != null) {
            ImmutableList j = graphQLGraphSearchConnectedFriendsConnection.j();
            if (j != null && i < j.size()) {
                GraphQLGraphSearchConnectedFriendsEdge graphQLGraphSearchConnectedFriendsEdge = (GraphQLGraphSearchConnectedFriendsEdge) j.get(i);
                if (graphQLGraphSearchConnectedFriendsEdge != null) {
                    return graphQLGraphSearchConnectedFriendsEdge.a();
                }
            }
        }
        return null;
    }

    public static FriendsWhoVisitedModel.EdgesModel.NodeModel m494a(FriendsWhoVisitedModel friendsWhoVisitedModel, int i) {
        if (friendsWhoVisitedModel != null) {
            ImmutableList j = friendsWhoVisitedModel.j();
            if (i < j.size()) {
                FriendsWhoVisitedModel.EdgesModel edgesModel = (FriendsWhoVisitedModel.EdgesModel) j.get(i);
                if (edgesModel != null) {
                    return edgesModel.a();
                }
            }
        }
        return null;
    }

    public String toString() {
        double k = m506k();
        if (k < Double.MAX_VALUE) {
            return StringFormatUtil.formatStrLocaleSafe("%s [name=%s, id=%s, searchScore=%f]", super.toString(), m504h(), m499c(), Double.valueOf(k));
        }
        return StringFormatUtil.formatStrLocaleSafe("%s [name=%s, id=%s]", super.toString(), m504h(), m499c());
    }
}
