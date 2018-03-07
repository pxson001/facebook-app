package com.facebook.commerce.core.ui;

import android.content.Context;
import android.net.Uri;
import com.facebook.commerce.core.graphql.CoreCommerceQueryFragmentsModels.ProductItemPriceFieldsModel;
import com.facebook.commerce.core.util.CommerceCurrencyUtil;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.widget.CustomFrameLayout;
import com.facebook.widget.text.BetterTextView;
import javax.annotation.Nullable;

/* compiled from: preferenceLink */
public class ProductItemWithPriceOverlayView extends CustomFrameLayout {
    private static final CallerContext f7549a = CallerContext.a(ProductItemWithPriceOverlayView.class);
    public FbDraweeView f7550b = ((FbDraweeView) c(2131566324));
    public BetterTextView f7551c = ((BetterTextView) c(2131566327));

    public ProductItemWithPriceOverlayView(Context context) {
        super(context);
        setContentView(2130906420);
        setBackgroundResource(2130840171);
    }

    public final void m10664a(Uri uri, @Nullable ProductItemPriceFieldsModel productItemPriceFieldsModel) {
        this.f7550b.a(uri, f7549a);
        if (productItemPriceFieldsModel != null) {
            this.f7551c.setText(CommerceCurrencyUtil.m10668a(productItemPriceFieldsModel));
        }
    }
}
