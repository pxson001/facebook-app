package com.facebook.pages.common.services;

import com.google.common.base.Objects;
import javax.annotation.Nullable;

/* compiled from: review_image_width */
public class PagesServicesModel {
    public final boolean f2415a;
    public final String f2416b;
    @Nullable
    public final String f2417c;
    @Nullable
    public final String f2418d;

    public PagesServicesModel(boolean z, String str, @Nullable String str2, @Nullable String str3) {
        this.f2415a = z;
        this.f2416b = str;
        this.f2417c = str2;
        this.f2418d = str3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        PagesServicesModel pagesServicesModel = (PagesServicesModel) obj;
        if (Objects.equal(Boolean.valueOf(this.f2415a), Boolean.valueOf(pagesServicesModel.f2415a)) && Objects.equal(this.f2416b, pagesServicesModel.f2416b) && Objects.equal(this.f2417c, pagesServicesModel.f2417c) && Objects.equal(this.f2418d, this.f2418d)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Objects.hashCode(new Object[]{Boolean.valueOf(this.f2415a), this.f2416b, this.f2417c, this.f2418d});
    }
}
