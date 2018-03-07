package com.facebook.commerce.storefront.ui;

import com.facebook.commerce.core.graphql.CoreCommerceQueryFragmentsModels.CommerceStoreFragmentModel.CommerceCollectionsModel;
import com.facebook.commerce.core.intent.MerchantInfoViewData;
import com.google.common.base.Absent;
import com.google.common.base.Objects;
import com.google.common.base.Optional;

/* compiled from: core_graph_accept_request */
public class StorefrontHeaderViewModel {
    public final boolean f15832a;
    public final Optional<MerchantInfoViewData> f15833b;
    public final boolean f15834c;
    public final Optional<Integer> f15835d;
    public final Optional<MerchantSubscriptionViewController> f15836e;
    public final Optional<CommerceCollectionsModel> f15837f;
    public final Optional<String> f15838g;
    public final Optional<String> f15839h;

    /* compiled from: core_graph_accept_request */
    public class Builder {
        private boolean f15824a;
        private Optional<MerchantInfoViewData> f15825b = Absent.INSTANCE;
        public boolean f15826c;
        public Optional<Integer> f15827d = Absent.INSTANCE;
        public Optional<MerchantSubscriptionViewController> f15828e = Absent.INSTANCE;
        public Optional<CommerceCollectionsModel> f15829f = Absent.INSTANCE;
        public Optional<String> f15830g = Absent.INSTANCE;
        public Optional<String> f15831h = Absent.INSTANCE;

        public final Builder m16286a(MerchantInfoViewData merchantInfoViewData) {
            this.f15825b = Optional.fromNullable(merchantInfoViewData);
            return this;
        }

        public final StorefrontHeaderViewModel m16287a() {
            return new StorefrontHeaderViewModel(this.f15824a, this.f15825b, this.f15826c, this.f15827d, this.f15828e, this.f15829f, this.f15830g, this.f15831h);
        }
    }

    private StorefrontHeaderViewModel(boolean z, Optional<MerchantInfoViewData> optional, boolean z2, Optional<Integer> optional2, Optional<MerchantSubscriptionViewController> optional3, Optional<CommerceCollectionsModel> optional4, Optional<String> optional5, Optional<String> optional6) {
        this.f15832a = z;
        this.f15833b = optional;
        this.f15834c = z2;
        this.f15835d = optional2;
        this.f15836e = optional3;
        this.f15837f = optional4;
        this.f15838g = optional5;
        this.f15839h = optional6;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof StorefrontHeaderViewModel)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        StorefrontHeaderViewModel storefrontHeaderViewModel = (StorefrontHeaderViewModel) obj;
        if (Objects.equal(Boolean.valueOf(this.f15832a), Boolean.valueOf(storefrontHeaderViewModel.f15832a)) && Objects.equal(this.f15833b, storefrontHeaderViewModel.f15833b) && Objects.equal(Boolean.valueOf(this.f15834c), Boolean.valueOf(storefrontHeaderViewModel.f15834c)) && Objects.equal(this.f15835d, storefrontHeaderViewModel.f15835d) && Objects.equal(this.f15836e, storefrontHeaderViewModel.f15836e) && Objects.equal(this.f15837f, storefrontHeaderViewModel.f15837f) && Objects.equal(this.f15838g, storefrontHeaderViewModel.f15838g) && Objects.equal(this.f15839h, storefrontHeaderViewModel.f15839h)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Objects.hashCode(new Object[]{Boolean.valueOf(this.f15832a), this.f15833b, Boolean.valueOf(this.f15834c), this.f15835d, this.f15836e, this.f15837f, this.f15838g, this.f15839h});
    }
}
