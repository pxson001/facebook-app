package com.facebook.nearby.maps;

import android.graphics.RectF;
import com.facebook.graphql.model.GraphQLGeoRectangle;
import com.facebook.graphql.model.GraphQLHelper;
import com.facebook.nearby.cluster.MapPinViewSizeHelper;
import com.facebook.nearby.cluster.NearbyPlaceCluster;
import com.facebook.nearby.model.NearbyPlaceEdgeWrapper;
import java.util.HashSet;
import java.util.Set;

/* compiled from: upsell_text */
public class MapCoordinateHelper {
    public static GraphQLGeoRectangle m440a(RectF rectF) {
        if (rectF == null) {
            return null;
        }
        return GraphQLHelper.a(rectF.top, rectF.left, rectF.bottom, rectF.right);
    }

    public static RectF m443b(RectF rectF) {
        return new RectF(rectF.left + ((rectF.right - rectF.left) * 0.25f), rectF.top - ((rectF.top - rectF.bottom) * 0.25f), rectF.right - ((rectF.right - rectF.left) * 0.25f), rectF.bottom + ((rectF.top - rectF.bottom) * 0.25f));
    }

    public static Set<NearbyPlaceEdgeWrapper> m442a(MapPinViewSizeHelper mapPinViewSizeHelper, RectF rectF, Set<NearbyPlaceEdgeWrapper> set, Set<NearbyPlaceEdgeWrapper> set2) {
        Set<NearbyPlaceEdgeWrapper> hashSet = new HashSet();
        for (NearbyPlaceEdgeWrapper nearbyPlaceEdgeWrapper : set) {
            RectF b = mapPinViewSizeHelper.m395b(nearbyPlaceEdgeWrapper.m502f());
            if (b != null && RectF.intersects(rectF, b)) {
                hashSet.add(nearbyPlaceEdgeWrapper);
            }
        }
        for (NearbyPlaceEdgeWrapper nearbyPlaceEdgeWrapper2 : set2) {
            if (RectF.intersects(rectF, mapPinViewSizeHelper.m394a(nearbyPlaceEdgeWrapper2.m502f()))) {
                hashSet.add(nearbyPlaceEdgeWrapper2);
            }
        }
        return hashSet;
    }

    public static Set<NearbyPlaceCluster> m441a(MapPinViewSizeHelper mapPinViewSizeHelper, RectF rectF, Set<NearbyPlaceCluster> set) {
        Set<NearbyPlaceCluster> hashSet = new HashSet();
        for (NearbyPlaceCluster nearbyPlaceCluster : set) {
            if (RectF.intersects(rectF, mapPinViewSizeHelper.m395b(nearbyPlaceCluster.f308d.m502f()))) {
                hashSet.add(nearbyPlaceCluster);
            }
        }
        return hashSet;
    }
}
