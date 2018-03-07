package com.facebook.nearby.v2.resultlist;

import android.location.Location;
import com.facebook.nearby.v2.model.NearbyPlacesSearchData$Type;
import com.facebook.nearby.v2.model.NearbyPlacesSearchDataModel;
import com.facebook.nearby.v2.network.BrowseNearbyPlacesGraphQLModels.GeoRectangleFragmentModel;
import com.facebook.nearby.v2.resultlist.model.NearbyPlacesResultListData;
import com.facebook.nearby.v2.resultlist.model.NearbyPlacesResultListModel;
import com.facebook.nearby.v2.resultlist.model.NearbyPlacesResultListSearchType;
import com.google.common.base.Preconditions;

/* compiled from: delete_page_review */
public class FetchResultListRequestParamsFactory {

    /* compiled from: delete_page_review */
    public /* synthetic */ class C16811 {
        public static final /* synthetic */ int[] f15785a = new int[FetchResultListRequestParamsRequestType.values().length];

        static {
            f15786b = new int[NearbyPlacesSearchData$Type.values().length];
            try {
                f15786b[NearbyPlacesSearchData$Type.CURRENT_LOCATION.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f15786b[NearbyPlacesSearchData$Type.SPECIFIED_LOCATION.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f15786b[NearbyPlacesSearchData$Type.KEYWORDS_PLACES.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f15785a[FetchResultListRequestParamsRequestType.FILTER_REQUEST.ordinal()] = 1;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f15785a[FetchResultListRequestParamsRequestType.RESULT_LIST_REQUEST.ordinal()] = 2;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f15785a[FetchResultListRequestParamsRequestType.PAGINATION_REQUEST.ordinal()] = 3;
            } catch (NoSuchFieldError e6) {
            }
            try {
                f15785a[FetchResultListRequestParamsRequestType.MAP_REGION_REQUEST.ordinal()] = 4;
            } catch (NoSuchFieldError e7) {
            }
        }
    }

    /* compiled from: delete_page_review */
    public enum FetchResultListRequestParamsRequestType {
        FILTER_REQUEST,
        RESULT_LIST_REQUEST,
        PAGINATION_REQUEST,
        MAP_REGION_REQUEST
    }

    public static FetchResultListRequestParams m18617a(NearbyPlacesResultListModel nearbyPlacesResultListModel) {
        boolean z;
        boolean z2;
        boolean z3 = false;
        NearbyPlacesResultListData nearbyPlacesResultListData = nearbyPlacesResultListModel.f15863c;
        Preconditions.checkNotNull(nearbyPlacesResultListData);
        GeoRectangleFragmentModel geoRectangleFragmentModel = nearbyPlacesResultListData.f15853h;
        String str = nearbyPlacesResultListData.f15848c;
        boolean z4 = geoRectangleFragmentModel != null;
        if (str != null) {
            z = true;
        } else {
            z = false;
        }
        if (nearbyPlacesResultListData.f15847b != null || z4 || z) {
            z2 = true;
        } else {
            z2 = false;
        }
        Preconditions.checkArgument(z2);
        if (nearbyPlacesResultListData.f15847b == null || !z) {
            z2 = true;
        } else {
            z2 = false;
        }
        Preconditions.checkArgument(z2);
        if (!(z && z4)) {
            z3 = true;
        }
        Preconditions.checkArgument(z3);
        return new FetchResultListRequestParams(nearbyPlacesResultListData.f15846a, nearbyPlacesResultListData.f15847b, str, geoRectangleFragmentModel, nearbyPlacesResultListData.f15852g, nearbyPlacesResultListModel.f15862b, nearbyPlacesResultListModel.f15861a, nearbyPlacesResultListData.f15851f, 0.0f, m18618a(nearbyPlacesResultListData.f15851f), nearbyPlacesResultListData.f15856k, nearbyPlacesResultListModel.f15864d);
    }

    public static FetchResultListRequestParams m18620b(NearbyPlacesResultListModel nearbyPlacesResultListModel) {
        NearbyPlacesResultListData nearbyPlacesResultListData = nearbyPlacesResultListModel.f15863c;
        return new FetchResultListRequestParams(nearbyPlacesResultListData.f15846a, nearbyPlacesResultListData.f15847b, nearbyPlacesResultListData.f15848c, nearbyPlacesResultListData.f15853h, nearbyPlacesResultListData.f15852g, nearbyPlacesResultListData.f15849d, nearbyPlacesResultListData.f15850e, nearbyPlacesResultListData.f15851f, 0.0f, m18618a(nearbyPlacesResultListData.f15851f), nearbyPlacesResultListData.f15856k, nearbyPlacesResultListModel.f15864d);
    }

    public static FetchResultListRequestParams m18616a(NearbyPlacesSearchDataModel nearbyPlacesSearchDataModel, NearbyPlacesResultListModel nearbyPlacesResultListModel) {
        Location e;
        NearbyPlacesResultListSearchType nearbyPlacesResultListSearchType;
        String str;
        switch (nearbyPlacesSearchDataModel.m17758d()) {
            case CURRENT_LOCATION:
                Preconditions.checkNotNull(nearbyPlacesSearchDataModel.m17759e());
                e = nearbyPlacesSearchDataModel.m17759e();
                nearbyPlacesResultListSearchType = NearbyPlacesResultListSearchType.USER_CENTERED;
                str = null;
                break;
            case SPECIFIED_LOCATION:
                Preconditions.checkNotNull(nearbyPlacesSearchDataModel.m17755a());
                str = nearbyPlacesSearchDataModel.m17755a();
                nearbyPlacesResultListSearchType = NearbyPlacesResultListSearchType.CITY;
                e = null;
                break;
            default:
                nearbyPlacesResultListSearchType = NearbyPlacesResultListSearchType.NONE;
                str = null;
                e = null;
                break;
        }
        return new FetchResultListRequestParams(nearbyPlacesSearchDataModel.f15306c, e, str, null, nearbyPlacesSearchDataModel.m17757c(), nearbyPlacesResultListModel.f15862b, nearbyPlacesResultListModel.f15861a, nearbyPlacesResultListSearchType, 0.0f, m18618a(nearbyPlacesResultListSearchType), null, nearbyPlacesResultListModel.m18711b());
    }

    public static FetchResultListRequestParams m18619b(NearbyPlacesSearchDataModel nearbyPlacesSearchDataModel, NearbyPlacesResultListModel nearbyPlacesResultListModel) {
        NearbyPlacesResultListSearchType nearbyPlacesResultListSearchType = NearbyPlacesResultListSearchType.CITY_MAP_REGION;
        return new FetchResultListRequestParams(nearbyPlacesSearchDataModel.f15306c, null, null, null, nearbyPlacesSearchDataModel.m17757c(), nearbyPlacesResultListModel.f15862b, nearbyPlacesResultListModel.f15861a, nearbyPlacesResultListSearchType, 0.0f, m18618a(nearbyPlacesResultListSearchType), null, nearbyPlacesResultListModel.m18711b());
    }

    private static boolean m18618a(NearbyPlacesResultListSearchType nearbyPlacesResultListSearchType) {
        return nearbyPlacesResultListSearchType == NearbyPlacesResultListSearchType.USER_CENTERED_MAP_REGION || nearbyPlacesResultListSearchType == NearbyPlacesResultListSearchType.CITY_MAP_REGION || nearbyPlacesResultListSearchType == NearbyPlacesResultListSearchType.CITY;
    }
}
