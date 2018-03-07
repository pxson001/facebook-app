package com.facebook.nearby.places;

import com.facebook.graphql.enums.GraphQLPermanentlyClosedStatus;
import com.facebook.inject.InjectorLike;
import com.facebook.nearby.model.NearbyPlaceEdgeWrapper;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* compiled from: unknown subscribe status */
public class NearbyPlaceSorter {

    /* compiled from: unknown subscribe status */
    class C00701 implements Comparator<NearbyPlaceEdgeWrapper> {
        final /* synthetic */ NearbyPlaceSorter f470a;

        C00701(NearbyPlaceSorter nearbyPlaceSorter) {
            this.f470a = nearbyPlaceSorter;
        }

        public int compare(Object obj, Object obj2) {
            NearbyPlaceEdgeWrapper nearbyPlaceEdgeWrapper = (NearbyPlaceEdgeWrapper) obj;
            NearbyPlaceEdgeWrapper nearbyPlaceEdgeWrapper2 = (NearbyPlaceEdgeWrapper) obj2;
            double k = nearbyPlaceEdgeWrapper.m506k();
            double k2 = nearbyPlaceEdgeWrapper2.m506k();
            if (k == k2) {
                return nearbyPlaceEdgeWrapper.m504h().compareTo(nearbyPlaceEdgeWrapper2.m504h());
            }
            return Double.compare(k, k2) * -1;
        }
    }

    /* compiled from: unknown subscribe status */
    public class C00712 implements Comparator<NearbyPlaceEdgeWrapper> {
        final /* synthetic */ NearbyPlaceSorter f471a;

        public C00712(NearbyPlaceSorter nearbyPlaceSorter) {
            this.f471a = nearbyPlaceSorter;
        }

        public int compare(Object obj, Object obj2) {
            NearbyPlaceEdgeWrapper nearbyPlaceEdgeWrapper = (NearbyPlaceEdgeWrapper) obj;
            NearbyPlaceEdgeWrapper nearbyPlaceEdgeWrapper2 = (NearbyPlaceEdgeWrapper) obj2;
            boolean p = nearbyPlaceEdgeWrapper.m509p();
            if (p != nearbyPlaceEdgeWrapper2.m509p()) {
                return p ? 1 : -1;
            } else {
                double k = nearbyPlaceEdgeWrapper.m506k();
                double k2 = nearbyPlaceEdgeWrapper2.m506k();
                if (k == k2) {
                    return nearbyPlaceEdgeWrapper.m504h().compareTo(nearbyPlaceEdgeWrapper2.m504h());
                }
                return Double.compare(k, k2) * -1;
            }
        }
    }

    public static NearbyPlaceSorter m565a(InjectorLike injectorLike) {
        return new NearbyPlaceSorter();
    }

    public final List<NearbyPlaceEdgeWrapper> m567a(List<NearbyPlaceEdgeWrapper> list) {
        List<NearbyPlaceEdgeWrapper> arrayList = new ArrayList(list);
        Collections.sort(arrayList, new C00701(this));
        return arrayList;
    }

    public static List<NearbyPlaceEdgeWrapper> m566c(List<NearbyPlaceEdgeWrapper> list) {
        Collection arrayList = new ArrayList();
        List<NearbyPlaceEdgeWrapper> arrayList2 = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            NearbyPlaceEdgeWrapper nearbyPlaceEdgeWrapper = (NearbyPlaceEdgeWrapper) list.get(i);
            if (i < 3) {
                boolean ar;
                if (nearbyPlaceEdgeWrapper.f384c != null) {
                    ar = nearbyPlaceEdgeWrapper.f384c.ar();
                } else if (nearbyPlaceEdgeWrapper.f387f != null) {
                    ar = GraphQLPermanentlyClosedStatus.PERMANENTLY_CLOSED.equals(nearbyPlaceEdgeWrapper.f387f.p());
                } else {
                    ar = false;
                }
                if (ar) {
                    arrayList.add(nearbyPlaceEdgeWrapper);
                }
            }
            arrayList2.add(nearbyPlaceEdgeWrapper);
            if (arrayList2.size() == 3) {
                arrayList2.addAll(arrayList);
                arrayList.clear();
            }
        }
        if (!arrayList.isEmpty()) {
            arrayList2.addAll(arrayList);
        }
        return arrayList2;
    }
}
