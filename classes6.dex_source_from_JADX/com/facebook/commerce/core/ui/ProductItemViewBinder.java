package com.facebook.commerce.core.ui;

import android.net.Uri;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.inject.InjectorLike;

/* compiled from: prefilled_tag_created */
public class ProductItemViewBinder {
    private static final CallerContext f7527a = CallerContext.a(ProductItemViewBinder.class);

    public static ProductItemViewBinder m10654a(InjectorLike injectorLike) {
        return new ProductItemViewBinder();
    }

    public static void m10655a(ProductItemViewHolder productItemViewHolder, ProductItemViewModel productItemViewModel) {
        if (productItemViewModel.f7548g.isPresent()) {
            productItemViewHolder.m10659a((Uri) productItemViewModel.f7548g.get(), f7527a);
        } else {
            productItemViewHolder.m10659a(null, f7527a);
        }
        productItemViewHolder.f7530n.setText(productItemViewModel.f7546e);
        if (productItemViewModel.f7543b) {
            productItemViewHolder.m10662w();
        } else if (productItemViewModel.f7544c) {
            productItemViewHolder.m10661c(productItemViewModel.f7545d);
        } else {
            productItemViewHolder.m10660a(productItemViewModel.f7545d, productItemViewModel.f7547f);
        }
        boolean z = productItemViewModel.f7542a;
        int i = z ? 128 : 255;
        productItemViewHolder.f7530n.setTextColor(productItemViewHolder.f7530n.getTextColors().withAlpha(i));
        productItemViewHolder.f7531o.setTextColor(productItemViewHolder.f7531o.getTextColors().withAlpha(i));
        if (z) {
            productItemViewHolder.f7533q.a().setVisibility(0);
        } else {
            productItemViewHolder.f7533q.c();
        }
    }
}
