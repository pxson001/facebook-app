package com.facebook.pages.common.surface.ui.metabox;

import com.facebook.graphql.enums.GraphQLPageOpenHoursDisplayDecisionEnum;
import com.google.common.base.Objects;

/* compiled from: region_east_longitude */
public class PagesMetaboxViewModel {
    public final String f2676a;
    public final MetaboxTopRowState f2677b;
    public final float f2678c;
    public final int f2679d;
    public final boolean f2680e;
    public final String f2681f;
    public final String f2682g;
    public final GraphQLPageOpenHoursDisplayDecisionEnum f2683h;
    public final boolean f2684i;

    /* compiled from: region_east_longitude */
    public enum MetaboxTopRowState {
        HIDDEN,
        RATING_ONLY,
        OPEN_HOURS_ONLY,
        RATING_AND_OPEN_HOURS
    }

    public PagesMetaboxViewModel(String str, MetaboxTopRowState metaboxTopRowState, float f, int i, boolean z, String str2, String str3, GraphQLPageOpenHoursDisplayDecisionEnum graphQLPageOpenHoursDisplayDecisionEnum, boolean z2) {
        this.f2676a = str;
        this.f2677b = metaboxTopRowState;
        this.f2678c = f;
        this.f2679d = i;
        this.f2680e = z;
        this.f2681f = str2;
        this.f2682g = str3;
        this.f2683h = graphQLPageOpenHoursDisplayDecisionEnum;
        this.f2684i = z2;
    }

    public int hashCode() {
        return Objects.hashCode(new Object[]{this.f2676a, this.f2677b, Float.valueOf(this.f2678c), Integer.valueOf(this.f2679d), Boolean.valueOf(this.f2680e), this.f2681f, this.f2682g, this.f2683h, Boolean.valueOf(this.f2684i)});
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof PagesMetaboxViewModel)) {
            return false;
        }
        PagesMetaboxViewModel pagesMetaboxViewModel = (PagesMetaboxViewModel) obj;
        if (Objects.equal(this.f2676a, pagesMetaboxViewModel.f2676a) && Objects.equal(this.f2677b, pagesMetaboxViewModel.f2677b) && ((double) Math.abs(this.f2678c - pagesMetaboxViewModel.f2678c)) < 1.0E-5d && Objects.equal(Integer.valueOf(this.f2679d), Integer.valueOf(pagesMetaboxViewModel.f2679d)) && Objects.equal(Boolean.valueOf(this.f2680e), Boolean.valueOf(pagesMetaboxViewModel.f2680e)) && Objects.equal(this.f2681f, pagesMetaboxViewModel.f2681f) && Objects.equal(this.f2682g, pagesMetaboxViewModel.f2682g) && Objects.equal(this.f2683h, pagesMetaboxViewModel.f2683h) && Objects.equal(Boolean.valueOf(this.f2684i), Boolean.valueOf(pagesMetaboxViewModel.f2684i))) {
            return true;
        }
        return false;
    }
}
