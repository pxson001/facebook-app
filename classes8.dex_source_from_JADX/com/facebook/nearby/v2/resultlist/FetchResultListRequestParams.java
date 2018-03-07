package com.facebook.nearby.v2.resultlist;

import android.location.Location;
import com.facebook.nearby.v2.model.NearbyPlacesResultListQueryTopic;
import com.facebook.nearby.v2.network.BrowseNearbyPlacesGraphQLModels.GeoRectangleFragmentModel;
import com.facebook.nearby.v2.resultlist.model.NearbyPlacesResultListFilterMask;
import com.facebook.nearby.v2.resultlist.model.NearbyPlacesResultListSearchType;
import com.facebook.nearby.v2.resultlist.model.NearbyPlacesResultListSortType;

/* compiled from: delete_review_task_key */
public class FetchResultListRequestParams {
    public Location f15773a;
    public Location f15774b;
    public String f15775c;
    public GeoRectangleFragmentModel f15776d;
    public NearbyPlacesResultListQueryTopic f15777e;
    private float f15778f;
    public boolean f15779g;
    public String f15780h;
    public NearbyPlacesResultListFilterMask f15781i;
    public NearbyPlacesResultListSortType f15782j;
    public NearbyPlacesResultListSearchType f15783k;
    public boolean f15784l;

    public FetchResultListRequestParams(Location location, Location location2, String str, GeoRectangleFragmentModel geoRectangleFragmentModel, NearbyPlacesResultListQueryTopic nearbyPlacesResultListQueryTopic, NearbyPlacesResultListFilterMask nearbyPlacesResultListFilterMask, NearbyPlacesResultListSortType nearbyPlacesResultListSortType, NearbyPlacesResultListSearchType nearbyPlacesResultListSearchType, float f, boolean z, String str2, boolean z2) {
        this.f15773a = location;
        this.f15774b = location2;
        this.f15775c = str;
        this.f15776d = geoRectangleFragmentModel;
        this.f15777e = nearbyPlacesResultListQueryTopic;
        this.f15781i = nearbyPlacesResultListFilterMask;
        this.f15782j = nearbyPlacesResultListSortType;
        this.f15783k = nearbyPlacesResultListSearchType;
        this.f15778f = f;
        this.f15779g = z;
        this.f15780h = str2;
        this.f15784l = z2;
    }

    public final Location m18607a() {
        return this.f15773a;
    }

    public final Location m18608b() {
        return this.f15774b;
    }

    public final String m18609c() {
        return this.f15775c;
    }

    public final GeoRectangleFragmentModel m18610d() {
        return this.f15776d;
    }

    public final NearbyPlacesResultListQueryTopic m18611e() {
        return this.f15777e;
    }

    public final String m18612h() {
        return this.f15780h;
    }

    public final NearbyPlacesResultListFilterMask m18613i() {
        return this.f15781i;
    }

    public final NearbyPlacesResultListSortType m18614j() {
        return this.f15782j;
    }

    public final NearbyPlacesResultListSearchType m18615k() {
        return this.f15783k;
    }
}
