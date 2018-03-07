package com.facebook.commerce.storefront.adapters;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.commerce.core.analytics.CommerceAnalytics.CommerceProductSectionType;
import com.facebook.commerce.core.analytics.CommerceAnalyticsEventBuilder;
import com.facebook.commerce.core.graphql.CoreCommerceQueryFragmentsModels.CommerceProductItemModel;
import com.facebook.commerce.core.ui.ProductItemViewBinder;
import com.facebook.commerce.core.ui.ProductItemViewHolder;
import com.facebook.commerce.core.ui.ProductItemViewModel.Builder;
import com.facebook.commerce.core.util.CommerceCurrencyUtil;
import com.facebook.commerce.core.util.CommerceNavigationUtil;
import com.facebook.commerce.storefront.graphql.FetchStorefrontCollectionQueryModels.FetchStorefrontCollectionQueryModel.CollectionProductItemsModel;
import com.facebook.commerce.storefront.graphql.FetchStorefrontCollectionQueryModels.FetchStorefrontCollectionQueryModel.CollectionProductItemsModel.EdgesModel;
import com.facebook.commerce.storefront.ui.StorefrontProductItemViewModelCreator;
import com.facebook.common.util.StringUtil;
import com.facebook.graphql.enums.GraphQLCommerceProductVisibility;
import com.facebook.inject.Assisted;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.google.common.base.Optional;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: create_event */
public class StorefrontSingleCollectionAdapter extends AbstractProductGroupingAdapter<ProductItemViewHolder> {
    public final CommerceNavigationUtil f15685a;
    private final StorefrontProductItemViewModelCreator f15686b;
    private final ProductItemViewBinder f15687c;
    public final AnalyticsLogger f15688d;
    private final Context f15689e;
    private final boolean f15690f;
    public CollectionProductItemsModel f15691g;
    public long f15692h;
    public int f15693i = 0;

    public final void m16141a(ViewHolder viewHolder, int i) {
        ProductItemViewHolder productItemViewHolder = (ProductItemViewHolder) viewHolder;
        CommerceProductItemModel e = m16139e(i);
        boolean z = this.f15690f;
        boolean z2 = true;
        Builder builder = new Builder();
        builder.e = e.c();
        builder.f = CommerceCurrencyUtil.a(e.ct_());
        if (z) {
            boolean z3;
            if (e.b() == GraphQLCommerceProductVisibility.PRODUCT_REJECTED) {
                z3 = true;
            } else {
                z3 = false;
            }
            builder.b = z3;
            Builder builder2 = builder;
            if (e.b() != GraphQLCommerceProductVisibility.PRODUCT_IN_REVIEW) {
                z2 = false;
            }
            builder2.c = z2;
        }
        if (!(e.d() == null || StringUtil.a(e.d().a()))) {
            builder.g = Optional.of(Uri.parse(e.d().a()));
        }
        ProductItemViewBinder.a(productItemViewHolder, builder.a());
        e = m16139e(i);
        productItemViewHolder.l.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ StorefrontSingleCollectionAdapter f15684b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -1157601385);
                this.f15684b.f15688d.a(CommerceAnalyticsEventBuilder.a(e.l(), this.f15684b.f15692h, false));
                this.f15684b.f15688d.a(CommerceAnalyticsEventBuilder.b(e.l(), Boolean.valueOf(false), CommerceProductSectionType.COLLECTION_GRID));
                this.f15684b.f15685a.a(e.l());
                Logger.a(2, EntryType.UI_INPUT_END, 1309701009, a);
            }
        });
    }

    @Inject
    public StorefrontSingleCollectionAdapter(CommerceNavigationUtil commerceNavigationUtil, StorefrontProductItemViewModelCreator storefrontProductItemViewModelCreator, ProductItemViewBinder productItemViewBinder, AnalyticsLogger analyticsLogger, @Assisted Context context, @Assisted boolean z) {
        this.f15685a = commerceNavigationUtil;
        this.f15686b = storefrontProductItemViewModelCreator;
        this.f15687c = productItemViewBinder;
        this.f15688d = analyticsLogger;
        this.f15689e = context;
        this.f15690f = z;
    }

    public final long H_(int i) {
        return (long) i;
    }

    public final int aZ_() {
        return this.f15693i;
    }

    public int getItemViewType(int i) {
        return 0;
    }

    @Nullable
    private CommerceProductItemModel m16139e(int i) {
        if (this.f15691g == null || this.f15691g.m16220a().size() <= i) {
            return null;
        }
        return ((EdgesModel) this.f15691g.m16220a().get(i)).m16214a();
    }

    public final ViewHolder m16140a(ViewGroup viewGroup, int i) {
        return new ProductItemViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(2130906418, viewGroup, false));
    }

    public final int mo763d() {
        return 1;
    }
}
