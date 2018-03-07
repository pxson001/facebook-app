package com.facebook.nearby.cluster;

import android.graphics.RectF;
import com.facebook.nearby.model.NearbyPlaceEdgeWrapper;
import com.facebook.nearby.places.NearbyPlaceSorter;
import com.facebook.nearby.places.NearbyPlaceSorter.C00712;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: user_location_known */
public class MapClusterer {
    private final NearbyPlaceSorter f299a;
    private boolean f300b;

    @Inject
    public MapClusterer(NearbyPlaceSorter nearbyPlaceSorter, Provider<Boolean> provider) {
        this.f299a = nearbyPlaceSorter;
        this.f300b = ((Boolean) provider.get()).booleanValue();
    }

    public final MapDisplayData m393a(List<NearbyPlaceEdgeWrapper> list, List<NearbyPlaceEdgeWrapper> list2, MapPinViewSizeHelper mapPinViewSizeHelper) {
        List<NearbyPlaceCluster> arrayList = new ArrayList();
        if (!this.f300b) {
            NearbyPlaceSorter nearbyPlaceSorter = this.f299a;
            List<NearbyPlaceEdgeWrapper> arrayList2 = new ArrayList(list);
            Collections.sort(arrayList2, new C00712(nearbyPlaceSorter));
            list = arrayList2;
        }
        for (NearbyPlaceEdgeWrapper nearbyPlaceEdgeWrapper : r10) {
            RectF b = mapPinViewSizeHelper.m395b(nearbyPlaceEdgeWrapper.m502f());
            NearbyPlaceCluster a = m392a(arrayList, b);
            if (a == null) {
                arrayList.add(new NearbyPlaceCluster(nearbyPlaceEdgeWrapper, b));
            } else {
                a.m396a(nearbyPlaceEdgeWrapper);
            }
        }
        List arrayList3 = new ArrayList();
        for (NearbyPlaceEdgeWrapper nearbyPlaceEdgeWrapper2 : list2) {
            a = m392a(arrayList, mapPinViewSizeHelper.m394a(nearbyPlaceEdgeWrapper2.m502f()));
            if (a == null) {
                arrayList3.add(nearbyPlaceEdgeWrapper2);
            } else {
                a.m396a(nearbyPlaceEdgeWrapper2);
            }
        }
        List arrayList4 = new ArrayList();
        List arrayList5 = new ArrayList();
        for (NearbyPlaceCluster nearbyPlaceCluster : arrayList) {
            if (nearbyPlaceCluster.m397c() == 1) {
                arrayList5.add(nearbyPlaceCluster.f308d);
            } else {
                arrayList4.add(nearbyPlaceCluster);
            }
        }
        return new MapDisplayData(arrayList4, arrayList5, arrayList3);
    }

    private static NearbyPlaceCluster m392a(List<NearbyPlaceCluster> list, RectF rectF) {
        for (NearbyPlaceCluster nearbyPlaceCluster : list) {
            if (RectF.intersects(nearbyPlaceCluster.f306b, rectF)) {
                return nearbyPlaceCluster;
            }
        }
        return null;
    }
}
