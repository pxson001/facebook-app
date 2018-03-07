package com.facebook.commerce.productdetails.ui.userinteractions;

import com.facebook.commerce.core.ui.NoticeView.NoticeLevel;
import com.facebook.commerce.productdetails.graphql.FetchProductGroupQueryModels.FetchProductGroupQueryModel;
import com.facebook.commerce.productdetails.graphql.FetchProductGroupQueryModels.FetchProductGroupQueryModel.GroupModel.ProductItemsEdgeModel.NodesModel;
import com.google.common.base.Absent;
import com.google.common.base.Objects;
import com.google.common.base.Optional;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import javax.annotation.Nullable;

/* compiled from: dbl_nux_save_account */
public class ProductGroupUserInteractionsViewModel {
    public final Optional<NoticeLevel> f15414a;
    @Nullable
    public final String f15415b;
    @Nullable
    public final String f15416c;
    @Nullable
    public final String f15417d;
    public final boolean f15418e;
    public final ImmutableList<String> f15419f;
    @Nullable
    public final String f15420g;
    public final Optional<String> f15421h;
    public final Optional<Integer> f15422i;
    public final boolean f15423j;
    public final boolean f15424k;
    public final ImmutableList<ProductVariantViewModel> f15425l;
    public final Optional<Integer> f15426m;
    public final boolean f15427n;
    public final ImmutableList<NodesModel> f15428o;
    @Nullable
    public final CheckoutType f15429p;
    @Nullable
    public final String f15430q;
    public final boolean f15431r;
    public final Optional<ProductGroupFeedbackViewModel> f15432s;
    public final FetchProductGroupQueryModel f15433t;

    /* compiled from: dbl_nux_save_account */
    public class Builder {
        public Optional<NoticeLevel> f15394a = Absent.INSTANCE;
        public String f15395b;
        public String f15396c;
        public String f15397d;
        public boolean f15398e;
        public ImmutableList<String> f15399f = RegularImmutableList.a;
        public String f15400g;
        public Optional<String> f15401h = Absent.INSTANCE;
        public Optional<Integer> f15402i = Absent.INSTANCE;
        public boolean f15403j;
        public boolean f15404k;
        public ImmutableList<ProductVariantViewModel> f15405l = RegularImmutableList.a;
        public Optional<Integer> f15406m = Absent.INSTANCE;
        public boolean f15407n;
        public ImmutableList<NodesModel> f15408o = RegularImmutableList.a;
        public CheckoutType f15409p;
        public String f15410q;
        public boolean f15411r;
        public Optional<ProductGroupFeedbackViewModel> f15412s = Absent.INSTANCE;
        public FetchProductGroupQueryModel f15413t;

        public final ProductGroupUserInteractionsViewModel m15970a() {
            return new ProductGroupUserInteractionsViewModel(this.f15394a, this.f15395b, this.f15396c, this.f15397d, this.f15398e, this.f15399f, this.f15400g, this.f15401h, this.f15402i, this.f15403j, this.f15404k, this.f15405l, this.f15406m, this.f15407n, this.f15408o, this.f15409p, this.f15410q, this.f15411r, this.f15412s, this.f15413t);
        }
    }

    /* compiled from: dbl_nux_save_account */
    public enum CheckoutType {
        CONTACT_MERCHANT,
        OFFSITE,
        ONSITE
    }

    private ProductGroupUserInteractionsViewModel(Optional<NoticeLevel> optional, @Nullable String str, @Nullable String str2, @Nullable String str3, boolean z, ImmutableList<String> immutableList, @Nullable String str4, Optional<String> optional2, Optional<Integer> optional3, boolean z2, boolean z3, ImmutableList<ProductVariantViewModel> immutableList2, Optional<Integer> optional4, boolean z4, ImmutableList<NodesModel> immutableList3, CheckoutType checkoutType, @Nullable String str5, boolean z5, Optional<ProductGroupFeedbackViewModel> optional5, FetchProductGroupQueryModel fetchProductGroupQueryModel) {
        this.f15414a = optional;
        this.f15415b = str;
        this.f15416c = str2;
        this.f15417d = str3;
        this.f15418e = z;
        this.f15419f = immutableList;
        this.f15420g = str4;
        this.f15421h = optional2;
        this.f15422i = optional3;
        this.f15423j = z2;
        this.f15424k = z3;
        this.f15425l = immutableList2;
        this.f15426m = optional4;
        this.f15427n = z4;
        this.f15428o = immutableList3;
        this.f15429p = checkoutType;
        this.f15430q = str5;
        this.f15431r = z5;
        this.f15432s = optional5;
        this.f15433t = fetchProductGroupQueryModel;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof ProductGroupUserInteractionsViewModel)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        ProductGroupUserInteractionsViewModel productGroupUserInteractionsViewModel = (ProductGroupUserInteractionsViewModel) obj;
        if (Objects.equal(this.f15414a, productGroupUserInteractionsViewModel.f15414a) && Objects.equal(this.f15415b, productGroupUserInteractionsViewModel.f15415b) && Objects.equal(this.f15416c, productGroupUserInteractionsViewModel.f15416c) && Objects.equal(this.f15417d, productGroupUserInteractionsViewModel.f15417d) && Objects.equal(Boolean.valueOf(this.f15418e), Boolean.valueOf(productGroupUserInteractionsViewModel.f15418e)) && Objects.equal(this.f15419f, productGroupUserInteractionsViewModel.f15419f) && Objects.equal(this.f15420g, productGroupUserInteractionsViewModel.f15420g) && Objects.equal(this.f15421h, productGroupUserInteractionsViewModel.f15421h) && Objects.equal(this.f15422i, productGroupUserInteractionsViewModel.f15422i) && Objects.equal(Boolean.valueOf(this.f15423j), Boolean.valueOf(productGroupUserInteractionsViewModel.f15423j)) && Objects.equal(Boolean.valueOf(this.f15424k), Boolean.valueOf(productGroupUserInteractionsViewModel.f15424k)) && Objects.equal(this.f15425l, productGroupUserInteractionsViewModel.f15425l) && Objects.equal(this.f15426m, productGroupUserInteractionsViewModel.f15426m) && Objects.equal(Boolean.valueOf(this.f15427n), Boolean.valueOf(productGroupUserInteractionsViewModel.f15427n)) && Objects.equal(this.f15428o, productGroupUserInteractionsViewModel.f15428o) && Objects.equal(this.f15429p, productGroupUserInteractionsViewModel.f15429p) && Objects.equal(this.f15430q, productGroupUserInteractionsViewModel.f15430q) && Objects.equal(Boolean.valueOf(this.f15431r), Boolean.valueOf(productGroupUserInteractionsViewModel.f15431r)) && Objects.equal(this.f15432s, productGroupUserInteractionsViewModel.f15432s) && Objects.equal(this.f15433t, productGroupUserInteractionsViewModel.f15433t)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Objects.hashCode(new Object[]{this.f15414a, this.f15415b, this.f15416c, this.f15417d, Boolean.valueOf(this.f15418e), this.f15419f, this.f15420g, this.f15421h, this.f15422i, Boolean.valueOf(this.f15423j), Boolean.valueOf(this.f15424k), this.f15425l, this.f15426m, Boolean.valueOf(this.f15427n), this.f15428o, this.f15429p, this.f15430q, Boolean.valueOf(this.f15431r), this.f15432s, this.f15433t});
    }
}
