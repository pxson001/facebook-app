package com.facebook.commerce.storefront.adapters;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.commerce.core.graphql.CoreCommerceQueryFragmentsModels.CommerceProductItemModel;
import com.facebook.commerce.core.graphql.CoreCommerceQueryFragmentsModels.CommerceStoreFragmentModel.CommerceCollectionsModel.CollectionProductItemsModel.EdgesModel;
import com.facebook.commerce.core.graphql.CoreCommerceQueryFragmentsModels.ProductItemPriceFieldsModel;
import com.facebook.commerce.core.intent.MerchantInfoViewData;
import com.facebook.commerce.core.ui.ProductItemWithPriceOverlayView;
import com.facebook.commerce.core.util.CommerceNavigationUtil;
import com.facebook.commerce.storefront.ui.ProductTileViewHolder;
import com.facebook.commerce.storefront.ui.SeeAllProductsViewHolder;
import com.facebook.commerce.storefront.util.CollectionViewData;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.widget.text.BetterTextView;
import com.google.common.collect.ImmutableList;

/* compiled from: create_new_group_event */
public class CommerceProductAdapter extends Adapter {
    public static AnalyticsLogger f15663a;
    private static final CallerContext f15664g = CallerContext.a(CommerceProductAdapter.class, "commerce_product_adapter");
    public final CommerceNavigationUtil f15665b;
    public int f15666c;
    public SeeAllProductsViewHolder f15667d;
    public MerchantInfoViewData f15668e;
    public CollectionViewData f15669f;
    public ImmutableList<EdgesModel> f15670h;

    public CommerceProductAdapter(CommerceNavigationUtil commerceNavigationUtil, AnalyticsLogger analyticsLogger) {
        this.f15665b = commerceNavigationUtil;
        f15663a = analyticsLogger;
    }

    public final long H_(int i) {
        return (long) i;
    }

    public final int aZ_() {
        if (this.f15666c >= 10) {
            return this.f15670h.size() + 1;
        }
        return this.f15670h.size();
    }

    public final void m16124a(ViewHolder viewHolder, int i) {
        if (viewHolder instanceof ProductTileViewHolder) {
            ProductTileViewHolder productTileViewHolder = (ProductTileViewHolder) viewHolder;
            if (this.f15670h != null && this.f15670h.get(i) != null && ((EdgesModel) this.f15670h.get(i)).a() != null && ((EdgesModel) this.f15670h.get(i)).a().m() != null) {
                CommerceProductItemModel a = ((EdgesModel) this.f15670h.get(i)).a();
                Uri parse = Uri.parse(a.m().a());
                ProductItemPriceFieldsModel j = a.j();
                String l = a.l();
                productTileViewHolder.f15805l.a(parse, j);
                productTileViewHolder.f15806m.f15703a = l;
            }
        } else if (viewHolder instanceof SeeAllProductsViewHolder) {
            ((SeeAllProductsViewHolder) viewHolder).m16284a(this.f15669f, this.f15666c);
        }
    }

    public int getItemViewType(int i) {
        if (i == 0) {
            return 0;
        }
        if (i >= this.f15670h.size()) {
            return 2;
        }
        return 1;
    }

    public final ViewHolder m16123a(ViewGroup viewGroup, int i) {
        if (i != 2) {
            return new ProductTileViewHolder(new ProductItemWithPriceOverlayView(viewGroup.getContext()), this.f15665b, f15663a);
        }
        SeeAllProductsViewHolder seeAllProductsViewHolder;
        if (this.f15667d != null) {
            seeAllProductsViewHolder = this.f15667d;
        } else {
            Context context = viewGroup.getContext();
            this.f15667d = new SeeAllProductsViewHolder((BetterTextView) LayoutInflater.from(context).inflate(2130906423, viewGroup, false), context, this.f15665b, this.f15668e, f15663a);
            seeAllProductsViewHolder = this.f15667d;
        }
        return seeAllProductsViewHolder;
    }
}
