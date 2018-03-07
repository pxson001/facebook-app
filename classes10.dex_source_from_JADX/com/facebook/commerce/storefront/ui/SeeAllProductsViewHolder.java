package com.facebook.commerce.storefront.ui;

import android.content.Context;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.commerce.core.analytics.CommerceAnalytics.CommerceProductSectionType;
import com.facebook.commerce.core.analytics.CommerceAnalyticsEventBuilder;
import com.facebook.commerce.core.intent.MerchantInfoViewData;
import com.facebook.commerce.core.util.CommerceNavigationUtil;
import com.facebook.commerce.storefront.util.CollectionViewData;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.widget.text.BetterTextView;

/* compiled from: core_graph_ignore_request */
public class SeeAllProductsViewHolder extends ViewHolder {
    private static AnalyticsLogger f15813l;
    private Context f15814m;
    private MerchantInfoViewData f15815n;
    private BetterTextView f15816o;
    private SeeAllOnClickListener f15817p;

    /* compiled from: core_graph_ignore_request */
    public class SeeAllOnClickListener implements OnClickListener {
        private final Context f15807a;
        private final CommerceNavigationUtil f15808b;
        private final CommerceProductSectionType f15809c;
        private final AnalyticsLogger f15810d;
        public MerchantInfoViewData f15811e;
        public CollectionViewData f15812f;

        public SeeAllOnClickListener(Context context, CommerceNavigationUtil commerceNavigationUtil, CommerceProductSectionType commerceProductSectionType, AnalyticsLogger analyticsLogger) {
            this.f15807a = context;
            this.f15808b = commerceNavigationUtil;
            this.f15809c = commerceProductSectionType;
            this.f15810d = analyticsLogger;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 142875435);
            if (this.f15812f != null) {
                Object obj;
                if (this.f15812f.f15844a != null) {
                    obj = 1;
                } else {
                    obj = null;
                }
                if (obj != null) {
                    this.f15810d.a(CommerceAnalyticsEventBuilder.a(this.f15812f.f15844a, Boolean.valueOf(false), this.f15809c));
                    this.f15808b.a(this.f15812f.f15844a, this.f15811e.e, null);
                    LogUtils.a(1048529197, a);
                    return;
                }
            }
            Logger.a(2, EntryType.UI_INPUT_END, -1756494791, a);
        }
    }

    public SeeAllProductsViewHolder(BetterTextView betterTextView, Context context, CommerceNavigationUtil commerceNavigationUtil, MerchantInfoViewData merchantInfoViewData, AnalyticsLogger analyticsLogger) {
        super(betterTextView);
        f15813l = analyticsLogger;
        this.f15814m = context;
        this.f15815n = merchantInfoViewData;
        this.f15816o = (BetterTextView) betterTextView.findViewById(2131566331);
        this.f15817p = new SeeAllOnClickListener(this.f15814m, commerceNavigationUtil, CommerceProductSectionType.STOREFRONT_COLLECTION, f15813l);
        this.f15816o.setOnClickListener(this.f15817p);
    }

    public final void m16284a(CollectionViewData collectionViewData, int i) {
        SeeAllOnClickListener seeAllOnClickListener = this.f15817p;
        MerchantInfoViewData merchantInfoViewData = this.f15815n;
        seeAllOnClickListener.f15812f = collectionViewData;
        seeAllOnClickListener.f15811e = merchantInfoViewData;
        int floor = ((int) Math.floor((double) (i / 10))) * 10;
        this.f15816o.setText(this.f15814m.getResources().getQuantityString(2131689603, floor, new Object[]{Integer.valueOf(floor)}));
    }
}
