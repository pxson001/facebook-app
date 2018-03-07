package com.facebook.places.pagetopics.stores;

import com.facebook.places.pagetopics.PlaceCategoryPickerFragment.C09491;
import com.facebook.places.pagetopics.graphql.PlaceCategoryPickerGraphQLModels.PlaceCategoryRowModel;
import com.facebook.places.pagetopics.graphql.PlaceCategoryPickerGraphQLModels.PlaceCategoryRowModel.ChildCategoriesModel.EdgesModel;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.Sets;
import java.util.Set;

/* compiled from: flow_icon */
public abstract class PlaceCategoriesListenableStore {
    private final Set<Listener> f14781a = Sets.a();

    public final void m22431a(C09491 c09491) {
        c09491.m22307a();
        this.f14781a.add(c09491);
    }

    public final void m22433b(C09491 c09491) {
        this.f14781a.remove(c09491);
    }

    protected final void m22432b() {
        for (C09491 a : this.f14781a) {
            a.m22307a();
        }
    }

    protected static PlacePickerCategory m22430a(PlaceCategoryRowModel placeCategoryRowModel) {
        Builder builder = ImmutableList.builder();
        ImmutableList a = placeCategoryRowModel.m22391j().m22385a();
        int size = a.size();
        for (int i = 0; i < size; i++) {
            builder.c(((EdgesModel) a.get(i)).m22381a().m22377a());
        }
        return new PlacePickerCategory(placeCategoryRowModel.m22393l(), Long.parseLong(placeCategoryRowModel.m22392k()), placeCategoryRowModel.m22394m(), builder.b());
    }
}
