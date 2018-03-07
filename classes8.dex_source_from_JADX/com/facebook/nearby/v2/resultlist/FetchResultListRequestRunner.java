package com.facebook.nearby.v2.resultlist;

import android.location.Location;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.graphql.querybuilder.common.GraphQlQueryDefaults;
import com.facebook.nearby.v2.model.NearbyPlacesPlaceModel;
import com.facebook.nearby.v2.model.NearbyPlacesResultListQueryTopic;
import com.facebook.nearby.v2.network.BrowseNearbyPlacesGraphQL.NearbyPlacesHugeResultsSearchQueryV2String;
import com.facebook.nearby.v2.network.BrowseNearbyPlacesGraphQLInterfaces.NearbyPlacesHugeResultCellPageInformationFragment;
import com.facebook.nearby.v2.network.BrowseNearbyPlacesGraphQLInterfaces.NearbyPlacesHugeResultsSearchQueryV2;
import com.facebook.nearby.v2.network.BrowseNearbyPlacesGraphQLModels.GeoRectangleFragmentModel;
import com.facebook.nearby.v2.network.BrowseNearbyPlacesGraphQLModels.NearbyPlacesHugeResultCellPageInformationFragmentModel;
import com.facebook.nearby.v2.network.BrowseNearbyPlacesGraphQLModels.NearbyPlacesHugeResultsSearchQueryV2Model;
import com.facebook.nearby.v2.network.BrowseNearbyPlacesGraphQLModels.NearbyPlacesNewBrowsePaginationInfoModel.PageInfoModel;
import com.facebook.nearby.v2.network.BrowseNearbyPlacesGraphQLModels.NearbyPlacesNewBrowsePlaceHugeResultsConnectionFragmentModel;
import com.facebook.nearby.v2.network.BrowseNearbyPlacesGraphQLModels.NearbyPlacesNewBrowsePlaceHugeResultsConnectionFragmentModel.EdgesModel;
import com.facebook.nearby.v2.resultlist.model.NearbyPlacesResultListData;
import com.facebook.nearby.v2.resultlist.model.NearbyPlacesResultListFilterMask;
import com.facebook.nearby.v2.resultlist.model.NearbyPlacesResultListSearchType;
import com.facebook.nearby.v2.resultlist.model.NearbyPlacesResultListSortType;
import com.facebook.places.future.SimpleExecutor;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.FutureCallback;
import java.util.ArrayList;
import javax.inject.Inject;

/* compiled from: delete_menu_option_tap */
public class FetchResultListRequestRunner {
    public SimpleExecutor f15791a;
    public GraphQLQueryExecutor f15792b;

    /* compiled from: delete_menu_option_tap */
    public class C16821 implements FutureCallback<NearbyPlacesHugeResultsSearchQueryV2> {
        final /* synthetic */ FetchResultListRequestParams f15787a;
        final /* synthetic */ FutureCallback f15788b;
        final /* synthetic */ FetchResultListRequestRunner f15789c;

        public C16821(FetchResultListRequestRunner fetchResultListRequestRunner, FetchResultListRequestParams fetchResultListRequestParams, FutureCallback futureCallback) {
            this.f15789c = fetchResultListRequestRunner;
            this.f15787a = fetchResultListRequestParams;
            this.f15788b = futureCallback;
        }

        public /* synthetic */ void onSuccess(Object obj) {
            m18621a((NearbyPlacesHugeResultsSearchQueryV2Model) obj);
        }

        private void m18621a(NearbyPlacesHugeResultsSearchQueryV2Model nearbyPlacesHugeResultsSearchQueryV2Model) {
            if (nearbyPlacesHugeResultsSearchQueryV2Model != null) {
                boolean z;
                NearbyPlacesNewBrowsePlaceHugeResultsConnectionFragmentModel a = NearbyPlacesNewBrowsePlaceHugeResultsConnectionFragmentModel.m18116a(nearbyPlacesHugeResultsSearchQueryV2Model.m18038a());
                if (a == null) {
                    m18622a(new NearbyPlacesResultListData());
                }
                GeoRectangleFragmentModel j = a.m18123j();
                PageInfoModel k = a.m18124k();
                String str = null;
                boolean z2 = false;
                if (k != null) {
                    str = k.m18045a();
                    z2 = k.m18047b();
                }
                ArrayList arrayList = new ArrayList();
                ImmutableList b = a.m18120b();
                if (b != null) {
                    for (int i = 0; i < b.size(); i++) {
                        EdgesModel edgesModel = (EdgesModel) b.get(i);
                        if (edgesModel != null) {
                            NearbyPlacesHugeResultCellPageInformationFragment j2 = edgesModel.m18114j();
                            if (j2 != null) {
                                arrayList.add(new NearbyPlacesPlaceModel(NearbyPlacesHugeResultCellPageInformationFragmentModel.m17993a(j2)));
                            }
                        }
                    }
                }
                Location a2 = this.f15787a.m18607a();
                Location b2 = this.f15787a.m18608b();
                String c = this.f15787a.m18609c();
                GeoRectangleFragmentModel d = this.f15787a.m18610d();
                NearbyPlacesResultListFilterMask i2 = this.f15787a.m18613i();
                NearbyPlacesResultListSortType j3 = this.f15787a.m18614j();
                NearbyPlacesResultListSearchType k2 = this.f15787a.m18615k();
                NearbyPlacesResultListQueryTopic e = this.f15787a.m18611e();
                if (this.f15787a.m18612h() == null) {
                    z = true;
                } else {
                    z = false;
                }
                m18622a(new NearbyPlacesResultListData(a2, b2, c, d, i2, j3, k2, e, j, arrayList, str, z, z2, a.m18122d()));
            }
        }

        public void onFailure(Throwable th) {
            if (this.f15788b != null) {
                this.f15788b.onFailure(th);
            }
        }

        private void m18622a(NearbyPlacesResultListData nearbyPlacesResultListData) {
            if (this.f15788b != null) {
                this.f15788b.onSuccess(nearbyPlacesResultListData);
            }
        }
    }

    @Inject
    public FetchResultListRequestRunner(SimpleExecutor simpleExecutor, GraphQLQueryExecutor graphQLQueryExecutor) {
        this.f15791a = simpleExecutor;
        this.f15792b = graphQLQueryExecutor;
    }

    public static NearbyPlacesHugeResultsSearchQueryV2String m18623a(FetchResultListRequestParams fetchResultListRequestParams) {
        if (fetchResultListRequestParams == null) {
            return null;
        }
        String str;
        int i = 50;
        if (fetchResultListRequestParams.f15783k == NearbyPlacesResultListSearchType.USER_CENTERED || fetchResultListRequestParams.f15783k == NearbyPlacesResultListSearchType.CITY) {
            i = 10;
        }
        NearbyPlacesResultListFilterMask nearbyPlacesResultListFilterMask = fetchResultListRequestParams.f15781i;
        String str2 = (nearbyPlacesResultListFilterMask == null || (nearbyPlacesResultListFilterMask.f15860a & 1) == 0) ? "false" : "true";
        NearbyPlacesHugeResultsSearchQueryV2String nearbyPlacesHugeResultsSearchQueryV2String = new NearbyPlacesHugeResultsSearchQueryV2String();
        String str3 = "search_query";
        if (fetchResultListRequestParams.f15777e == null || fetchResultListRequestParams.f15777e.f15303b == null) {
            str = "";
        } else {
            str = fetchResultListRequestParams.f15777e.f15303b;
        }
        GraphQlQueryString a = nearbyPlacesHugeResultsSearchQueryV2String.a(str3, str).a("restrict_region", Boolean.valueOf(fetchResultListRequestParams.f15779g));
        str3 = "orderby";
        switch (fetchResultListRequestParams.f15782j) {
            case POPULARITY:
                str = "popularity";
                break;
            case RATING:
                str = "overall_rating";
                break;
            case RELEVANCE:
                str = "relevance";
                break;
            case DISTANCE:
                str = "distance";
                break;
            default:
                str = null;
                break;
        }
        GraphQlQueryString a2 = a.a(str3, str).a("open_now", str2).a("cursor_token", fetchResultListRequestParams.f15780h).a("limit", Integer.valueOf(i)).a("friends_who_visited_count", Integer.valueOf(3)).a("friendRecommendationsCount", Integer.valueOf(1)).a("fetch_place_photos", Boolean.valueOf(fetchResultListRequestParams.f15784l));
        GeoRectangleFragmentModel geoRectangleFragmentModel = fetchResultListRequestParams.f15776d;
        if (geoRectangleFragmentModel != null) {
            a2 = a2.a("north", Double.valueOf(geoRectangleFragmentModel.m17829b())).a("west", Double.valueOf(geoRectangleFragmentModel.m17831d())).a("south", Double.valueOf(geoRectangleFragmentModel.m17830c())).a("east", Double.valueOf(geoRectangleFragmentModel.m17825a()));
        }
        if (fetchResultListRequestParams.f15775c != null) {
            a2 = a2.a("location_id", fetchResultListRequestParams.f15775c);
        }
        Location location = fetchResultListRequestParams.f15774b;
        if (location != null) {
            a2 = a2.a("latitude", Double.valueOf(location.getLatitude())).a("longitude", Double.valueOf(location.getLongitude()));
        }
        location = fetchResultListRequestParams.f15773a;
        if (location != null) {
            a2 = a2.a("user_latitude", Double.valueOf(location.getLatitude())).a("user_longitude", Double.valueOf(location.getLongitude()));
        }
        a2 = a2.a("scale", GraphQlQueryDefaults.a());
        if (a2 != null) {
            return (NearbyPlacesHugeResultsSearchQueryV2String) a2;
        }
        return null;
    }
}
