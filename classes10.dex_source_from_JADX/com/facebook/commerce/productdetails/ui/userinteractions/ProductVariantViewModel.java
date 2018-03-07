package com.facebook.commerce.productdetails.ui.userinteractions;

import com.google.common.base.Objects;
import com.google.common.base.Optional;
import com.google.common.collect.ImmutableList;

/* compiled from: dbl_loggedin_settings */
public class ProductVariantViewModel {
    public final String f15434a;
    public final ImmutableList<String> f15435b;
    public final ImmutableList<VariantValueState> f15436c;
    public final Optional<Integer> f15437d;

    /* compiled from: dbl_loggedin_settings */
    public enum VariantValueState {
        AVAILABLE,
        NOT_AVAILABLE,
        SOLD_OUT
    }

    public ProductVariantViewModel(String str, ImmutableList<String> immutableList, ImmutableList<VariantValueState> immutableList2, Optional<Integer> optional) {
        this.f15434a = str;
        this.f15435b = immutableList;
        this.f15436c = immutableList2;
        this.f15437d = optional;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof ProductVariantViewModel)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        ProductVariantViewModel productVariantViewModel = (ProductVariantViewModel) obj;
        if (Objects.equal(this.f15434a, productVariantViewModel.f15434a) && Objects.equal(this.f15435b, productVariantViewModel.f15435b) && Objects.equal(this.f15436c, productVariantViewModel.f15436c) && Objects.equal(this.f15437d, productVariantViewModel.f15437d)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Objects.hashCode(new Object[]{this.f15434a, this.f15435b, this.f15436c, this.f15437d});
    }
}
