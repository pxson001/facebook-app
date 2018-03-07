package com.facebook.controller.connectioncontroller.common;

import com.facebook.controller.mutation.LegacyFeedUnitStoreUpdater;
import com.google.common.collect.ImmutableList;

/* compiled from: orderingList */
public class MutationControllerManager {
    public final ImmutableList<MutationController> f8604a;

    public MutationControllerManager(ImmutableList<MutationController> immutableList) {
        this.f8604a = immutableList;
    }

    public final void m12407a(ConnectionStore connectionStore) {
        int size = this.f8604a.size();
        for (int i = 0; i < size; i++) {
            ((LegacyFeedUnitStoreUpdater) this.f8604a.get(i)).a = connectionStore;
        }
    }
}
