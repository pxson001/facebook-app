package com.facebook.messaging.location.sending;

import android.net.Uri;
import com.facebook.android.maps.model.LatLng;
import com.facebook.common.util.StringUtil;
import com.facebook.messaging.location.sending.NearbyPlace.Builder;
import com.facebook.messaging.location.sending.graphql.NearbyPlacesGraphQLModels.NearbyPlacesQueryModel.PlaceResultsModel.EdgesModel;
import com.facebook.messaging.location.sending.graphql.NearbyPlacesGraphQLModels.NearbyPlacesQueryModel.PlaceResultsModel.EdgesModel.NodeModel.LocationModel;

/* compiled from: mLastFourDigits */
public class NearbyPlacesGraphQLTransformer {
    public static NearbyPlace m12055b(EdgesModel edgesModel) {
        Builder builder = new Builder();
        builder.f11438a = edgesModel.m12143j().m12135k();
        builder = builder;
        builder.f11439b = edgesModel.m12143j().m12137m();
        builder = builder;
        builder.f11440c = Uri.parse(edgesModel.m12143j().m12138n().m12125a());
        builder = builder;
        LocationModel l = edgesModel.m12143j().m12136l();
        builder.f11441d = new LatLng(l.m12116a(), l.m12120j());
        builder = builder;
        if (!StringUtil.a(edgesModel.m12142a())) {
            builder.f11442e = edgesModel.m12142a();
        }
        if (!(edgesModel.m12143j().m12134j() == null || StringUtil.a(edgesModel.m12143j().m12134j().m12111a()))) {
            builder.f11443f = edgesModel.m12143j().m12134j().m12111a();
        }
        return new NearbyPlace(builder);
    }
}
