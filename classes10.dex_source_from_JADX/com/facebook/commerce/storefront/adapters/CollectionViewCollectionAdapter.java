package com.facebook.commerce.storefront.adapters;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.commerce.core.analytics.CommerceAnalytics.CommerceProductSectionType;
import com.facebook.commerce.core.analytics.CommerceAnalyticsEventBuilder;
import com.facebook.commerce.core.graphql.CoreCommerceQueryFragmentsModels.CommerceProductItemModel;
import com.facebook.commerce.core.intent.MerchantInfoViewData;
import com.facebook.commerce.core.ui.PageInfoView;
import com.facebook.commerce.core.ui.PageInfoViewProvider;
import com.facebook.commerce.core.util.CommerceCurrencyUtil;
import com.facebook.commerce.core.util.CommerceNavigationUtil;
import com.facebook.commerce.storefront.graphql.FetchStorefrontCollectionQueryModels.FetchStorefrontCollectionQueryModel.CollectionProductItemsModel;
import com.facebook.commerce.storefront.graphql.FetchStorefrontCollectionQueryModels.FetchStorefrontCollectionQueryModel.CollectionProductItemsModel.EdgesModel;
import com.facebook.commerce.storefront.ui.GridItemViewHolder;
import com.facebook.commerce.storefront.ui.GridProductItemView;
import com.facebook.commerce.storefront.ui.StorefrontPageInfoViewBinder;
import com.facebook.commerce.storefront.util.CollectionViewHeaderUtil;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.util.StringUtil;
import com.facebook.content.SecureContextHelper;
import com.facebook.fbui.widget.contentview.ContentView;
import com.facebook.inject.Assisted;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;
import javax.inject.Inject;

/* compiled from: createintent_isvalidfile */
public class CollectionViewCollectionAdapter extends Adapter {
    public final CommerceNavigationUtil f15649a;
    public final SecureContextHelper f15650b;
    public final AnalyticsLogger f15651c;
    public final AbstractFbErrorReporter f15652d;
    public final PageInfoViewProvider f15653e;
    public final Context f15654f;
    public final long f15655g;
    public final boolean f15656h;
    private final MerchantInfoViewData f15657i;
    public CollectionProductItemsModel f15658j;
    public int f15659k = 0;

    /* compiled from: createintent_isvalidfile */
    public class PageInfoViewHolder extends ViewHolder {
        public final PageInfoView f15648l;

        public PageInfoViewHolder(PageInfoView pageInfoView) {
            super(pageInfoView.b);
            this.f15648l = pageInfoView;
        }
    }

    @Inject
    public CollectionViewCollectionAdapter(CommerceNavigationUtil commerceNavigationUtil, SecureContextHelper secureContextHelper, AnalyticsLogger analyticsLogger, AbstractFbErrorReporter abstractFbErrorReporter, PageInfoViewProvider pageInfoViewProvider, @Assisted Context context, @Assisted long j, @Assisted boolean z, @Assisted MerchantInfoViewData merchantInfoViewData) {
        this.f15649a = commerceNavigationUtil;
        this.f15650b = secureContextHelper;
        this.f15651c = analyticsLogger;
        this.f15652d = abstractFbErrorReporter;
        this.f15653e = pageInfoViewProvider;
        this.f15654f = context;
        this.f15655g = j;
        this.f15656h = z;
        this.f15657i = merchantInfoViewData;
    }

    public final long H_(int i) {
        return (long) i;
    }

    public final int aZ_() {
        return (CollectionViewHeaderUtil.m16289a(this.f15657i) ? 1 : 0) + this.f15659k;
    }

    private CommerceProductItemModel m16116e(int i) {
        if (CollectionViewHeaderUtil.m16289a(this.f15657i)) {
            i--;
        }
        if (i >= 0 && i < this.f15658j.m16220a().size()) {
            return ((EdgesModel) this.f15658j.m16220a().get(i)).m16214a();
        }
        this.f15652d.a("grid_item_view_holder", "Trying to get an invalid product index.");
        return ((EdgesModel) this.f15658j.m16220a().get(0)).m16214a();
    }

    public final void m16118a(ViewHolder viewHolder, int i) {
        if (viewHolder instanceof GridItemViewHolder) {
            GridItemViewHolder gridItemViewHolder = (GridItemViewHolder) viewHolder;
            CommerceProductItemModel e = m16116e(i);
            GridProductItemView gridProductItemView = gridItemViewHolder.f15785l;
            gridProductItemView.f15789b.a(Uri.parse(e.m().a()), GridProductItemView.f15788a);
            gridProductItemView = gridItemViewHolder.f15785l;
            gridProductItemView.f15791d.setText(e.c());
            CharSequence a = CommerceCurrencyUtil.a(e.j());
            if (StringUtil.a(a)) {
                gridItemViewHolder.f15787n.a("grid_item_view_holder", "getHscrollItemPrice: item price is null");
            } else {
                gridItemViewHolder.f15785l.f15790c.setText(a);
            }
            e = m16116e(i);
            gridItemViewHolder.f15785l.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ CollectionViewCollectionAdapter f15647b;

                public void onClick(View view) {
                    int a = Logger.a(2, EntryType.UI_INPUT_START, -1797503629);
                    this.f15647b.f15651c.a(CommerceAnalyticsEventBuilder.a(e.l(), this.f15647b.f15655g, this.f15647b.f15656h));
                    this.f15647b.f15651c.a(CommerceAnalyticsEventBuilder.b(e.l(), Boolean.valueOf(this.f15647b.f15656h), CommerceProductSectionType.COLLECTION_GRID));
                    if (this.f15647b.f15656h) {
                        this.f15647b.f15650b.b(new Intent("android.intent.action.VIEW", Uri.parse(e.k())), this.f15647b.f15654f);
                        Logger.a(2, EntryType.UI_INPUT_END, -1236479357, a);
                        return;
                    }
                    this.f15647b.f15649a.a(e.l());
                    LogUtils.a(-769239842, a);
                }
            });
        } else if (viewHolder instanceof PageInfoViewHolder) {
            StorefrontPageInfoViewBinder.m16288a(this.f15657i, ((PageInfoViewHolder) viewHolder).f15648l);
        }
    }

    public int getItemViewType(int i) {
        if (i == 0 && CollectionViewHeaderUtil.m16289a(this.f15657i)) {
            return 1;
        }
        return 0;
    }

    public final ViewHolder m16117a(ViewGroup viewGroup, int i) {
        if (i == 1) {
            return new PageInfoViewHolder(this.f15653e.a(new ContentView(viewGroup.getContext())));
        }
        Context context = viewGroup.getContext();
        return new GridItemViewHolder(new GridProductItemView(context, this.f15656h), context, this.f15652d);
    }
}
