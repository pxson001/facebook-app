package com.facebook.commerce.core.ui;

import android.net.Uri;
import com.google.common.base.Objects;

/* compiled from: prefilled_tag_deleted */
public class ProductItemAtGlanceViewModel {
    public final Uri f7524a;
    public final String f7525b;
    public final String f7526c;

    public ProductItemAtGlanceViewModel(Uri uri, String str, String str2) {
        this.f7524a = uri;
        this.f7525b = str;
        this.f7526c = str2;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof ProductItemAtGlanceViewModel)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        ProductItemAtGlanceViewModel productItemAtGlanceViewModel = (ProductItemAtGlanceViewModel) obj;
        if (Objects.equal(this.f7524a, productItemAtGlanceViewModel.f7524a) && Objects.equal(this.f7525b, productItemAtGlanceViewModel.f7525b) && Objects.equal(this.f7526c, productItemAtGlanceViewModel.f7526c)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Objects.hashCode(new Object[]{this.f7524a, this.f7525b, this.f7526c});
    }
}
