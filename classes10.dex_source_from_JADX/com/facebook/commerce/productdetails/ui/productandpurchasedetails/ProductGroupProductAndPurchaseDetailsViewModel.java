package com.facebook.commerce.productdetails.ui.productandpurchasedetails;

import com.google.common.base.Objects;
import com.google.common.base.Optional;

/* compiled from: debug_menu */
public class ProductGroupProductAndPurchaseDetailsViewModel {
    public final Optional<String> f15302a;
    public final Optional<String> f15303b;

    public ProductGroupProductAndPurchaseDetailsViewModel(Optional<String> optional, Optional<String> optional2) {
        this.f15302a = optional;
        this.f15303b = optional2;
    }

    public final Optional<String> m15926a() {
        return this.f15302a;
    }

    public final Optional<String> m15927b() {
        return this.f15303b;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof ProductGroupProductAndPurchaseDetailsViewModel)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        ProductGroupProductAndPurchaseDetailsViewModel productGroupProductAndPurchaseDetailsViewModel = (ProductGroupProductAndPurchaseDetailsViewModel) obj;
        if (Objects.equal(this.f15302a, productGroupProductAndPurchaseDetailsViewModel.f15302a) && Objects.equal(this.f15303b, productGroupProductAndPurchaseDetailsViewModel.f15303b)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Objects.hashCode(new Object[]{this.f15302a, this.f15303b});
    }
}
