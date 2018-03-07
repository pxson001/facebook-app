package com.facebook.nearby.data;

import com.facebook.nearby.cluster.NearbyPlaceCluster;
import com.facebook.nearby.model.NearbyPlaceEdgeWrapper;
import com.google.common.collect.ImmutableSet;
import java.util.Set;

/* compiled from: user_heading */
public class MapPinTransition {
    public final ImmutableSet<NearbyPlaceCluster> f309a;
    public final ImmutableSet<NearbyPlaceCluster> f310b;
    public final ImmutableSet<NearbyPlaceEdgeWrapper> f311c;
    public final ImmutableSet<NearbyPlaceEdgeWrapper> f312d;
    public final ImmutableSet<NearbyPlaceEdgeWrapper> f313e;
    public final ImmutableSet<NearbyPlaceEdgeWrapper> f314f;

    public MapPinTransition(Set<NearbyPlaceCluster> set, Set<NearbyPlaceCluster> set2, Set<NearbyPlaceEdgeWrapper> set3, Set<NearbyPlaceEdgeWrapper> set4, Set<NearbyPlaceEdgeWrapper> set5, Set<NearbyPlaceEdgeWrapper> set6) {
        this.f309a = ImmutableSet.copyOf(set);
        this.f310b = ImmutableSet.copyOf(set2);
        this.f311c = ImmutableSet.copyOf(set3);
        this.f312d = ImmutableSet.copyOf(set4);
        this.f313e = ImmutableSet.copyOf(set5);
        this.f314f = ImmutableSet.copyOf(set6);
    }
}
