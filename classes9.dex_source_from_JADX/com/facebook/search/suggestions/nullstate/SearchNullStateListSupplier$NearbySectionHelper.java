package com.facebook.search.suggestions.nullstate;

import com.facebook.search.model.TypeaheadUnit;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;

/* compiled from: web_csc_verified */
class SearchNullStateListSupplier$NearbySectionHelper {
    NearbyNullStateSupplier f218a;
    boolean f219b;
    int f220c;
    int f221d = 0;
    boolean f222e = false;

    public SearchNullStateListSupplier$NearbySectionHelper(NearbyNullStateSupplier nearbyNullStateSupplier) {
        this.f218a = nearbyNullStateSupplier;
        this.f219b = nearbyNullStateSupplier.a();
        this.f220c = nearbyNullStateSupplier.e();
    }

    public final void m344a(Builder<TypeaheadUnit> builder, boolean z) {
        this.f221d++;
        if (this.f219b && !this.f222e) {
            if (this.f221d == this.f220c || z) {
                ImmutableList d = this.f218a.d();
                if (!(d == null || d.isEmpty())) {
                    builder.b(d);
                }
                this.f222e = true;
                this.f221d++;
            }
        }
    }
}
