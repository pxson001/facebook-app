package com.facebook.commerce.productdetails.ui.userinteractions;

import com.facebook.commerce.productdetails.graphql.FetchProductGroupQueryModels.ProductGroupFeedbackModel;
import com.google.common.base.Objects;
import com.google.common.base.Optional;
import javax.annotation.Nullable;

/* compiled from: dc2b644f50036e07c3bc14190b6ad159 */
public class ProductGroupFeedbackViewModel {
    public final boolean f15309a;
    public final boolean f15310b;
    public final boolean f15311c;
    public final Optional<Integer> f15312d;
    public final Optional<Integer> f15313e;
    @Nullable
    public final ProductGroupFeedbackModel f15314f;

    public ProductGroupFeedbackViewModel(boolean z, boolean z2, boolean z3, Optional<Integer> optional, Optional<Integer> optional2, ProductGroupFeedbackModel productGroupFeedbackModel) {
        this.f15309a = z;
        this.f15310b = z2;
        this.f15311c = z3;
        this.f15312d = optional;
        this.f15313e = optional2;
        this.f15314f = productGroupFeedbackModel;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof ProductVariantViewModel)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        ProductGroupFeedbackViewModel productGroupFeedbackViewModel = (ProductGroupFeedbackViewModel) obj;
        if (Objects.equal(Boolean.valueOf(this.f15309a), Boolean.valueOf(productGroupFeedbackViewModel.f15309a)) && Objects.equal(Boolean.valueOf(this.f15310b), Boolean.valueOf(productGroupFeedbackViewModel.f15310b)) && Objects.equal(Boolean.valueOf(this.f15311c), Boolean.valueOf(productGroupFeedbackViewModel.f15311c)) && Objects.equal(this.f15312d, productGroupFeedbackViewModel.f15312d) && Objects.equal(this.f15313e, productGroupFeedbackViewModel.f15313e) && Objects.equal(this.f15314f, productGroupFeedbackViewModel.f15314f)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Objects.hashCode(new Object[]{Boolean.valueOf(this.f15309a), Boolean.valueOf(this.f15310b), Boolean.valueOf(this.f15311c), this.f15312d, this.f15313e, this.f15314f});
    }
}
