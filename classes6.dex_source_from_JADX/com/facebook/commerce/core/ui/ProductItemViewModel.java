package com.facebook.commerce.core.ui;

import android.net.Uri;
import com.google.common.base.Absent;
import com.google.common.base.Objects;
import com.google.common.base.Optional;

/* compiled from: preference_link */
public class ProductItemViewModel {
    public final boolean f7542a;
    public final boolean f7543b;
    public final boolean f7544c;
    public final boolean f7545d;
    public final String f7546e;
    public final String f7547f;
    public final Optional<Uri> f7548g;

    /* compiled from: preference_link */
    public class Builder {
        public boolean f7535a;
        public boolean f7536b;
        public boolean f7537c;
        public boolean f7538d;
        public String f7539e;
        public String f7540f;
        public Optional<Uri> f7541g = Absent.INSTANCE;

        public final ProductItemViewModel m10663a() {
            return new ProductItemViewModel(this.f7535a, this.f7536b, this.f7537c, this.f7538d, this.f7539e, this.f7540f, this.f7541g);
        }
    }

    private ProductItemViewModel(boolean z, boolean z2, boolean z3, boolean z4, String str, String str2, Optional<Uri> optional) {
        this.f7542a = z;
        this.f7543b = z2;
        this.f7544c = z3;
        this.f7545d = z4;
        this.f7546e = str;
        this.f7547f = str2;
        this.f7548g = optional;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof ProductItemViewModel)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        ProductItemViewModel productItemViewModel = (ProductItemViewModel) obj;
        if (Objects.equal(Boolean.valueOf(this.f7542a), Boolean.valueOf(productItemViewModel.f7542a)) && Objects.equal(Boolean.valueOf(this.f7543b), Boolean.valueOf(productItemViewModel.f7543b)) && Objects.equal(Boolean.valueOf(this.f7544c), Boolean.valueOf(productItemViewModel.f7544c)) && Objects.equal(Boolean.valueOf(this.f7545d), Boolean.valueOf(productItemViewModel.f7545d)) && Objects.equal(this.f7546e, productItemViewModel.f7546e) && Objects.equal(this.f7547f, productItemViewModel.f7547f) && Objects.equal(this.f7548g, productItemViewModel.f7548g)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Objects.hashCode(new Object[]{Boolean.valueOf(this.f7542a), Boolean.valueOf(this.f7543b), Boolean.valueOf(this.f7544c), Boolean.valueOf(this.f7545d), this.f7546e, this.f7547f, this.f7548g});
    }
}
