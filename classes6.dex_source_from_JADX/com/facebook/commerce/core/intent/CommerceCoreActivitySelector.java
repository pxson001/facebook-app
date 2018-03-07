package com.facebook.commerce.core.intent;

import com.facebook.base.activity.FragmentChromeActivity;
import com.facebook.config.application.Product;
import com.facebook.pages.app.annotation.SecondaryFragmentChromeActivity;
import java.lang.annotation.Annotation;

/* compiled from: preview_text_with_entities */
public class CommerceCoreActivitySelector {
    private CommerceCoreActivitySelector() {
    }

    public static Class<? extends Annotation> m10646a(Product product) {
        return product == Product.PAA ? SecondaryFragmentChromeActivity.class : FragmentChromeActivity.class;
    }
}
