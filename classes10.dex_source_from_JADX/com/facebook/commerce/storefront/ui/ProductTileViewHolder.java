package com.facebook.commerce.storefront.ui;

import android.support.v7.widget.RecyclerView.ViewHolder;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.commerce.core.analytics.CommerceAnalytics.CommerceProductSectionType;
import com.facebook.commerce.core.ui.ProductItemWithPriceOverlayView;
import com.facebook.commerce.core.util.CommerceNavigationUtil;
import com.facebook.commerce.storefront.behaviours.ProductTileOnClickListener;

/* compiled from: core_graph_show_requests_banner */
public class ProductTileViewHolder extends ViewHolder {
    public ProductItemWithPriceOverlayView f15805l;
    public ProductTileOnClickListener f15806m;

    public ProductTileViewHolder(ProductItemWithPriceOverlayView productItemWithPriceOverlayView, CommerceNavigationUtil commerceNavigationUtil, AnalyticsLogger analyticsLogger) {
        super(productItemWithPriceOverlayView);
        this.f15805l = productItemWithPriceOverlayView;
        this.f15806m = new ProductTileOnClickListener(productItemWithPriceOverlayView.getContext(), commerceNavigationUtil, analyticsLogger, CommerceProductSectionType.STOREFRONT_COLLECTION);
        this.f15805l.setOnClickListener(this.f15806m);
    }
}
