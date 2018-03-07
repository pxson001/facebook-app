package com.facebook.commerce.productdetails.ui.morefromshop;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.facebook.commerce.core.util.CommerceNavigationUtil;
import com.facebook.commerce.productdetails.graphql.FetchProductGroupQueryModels.FetchProductGroupQueryModel;
import com.facebook.commerce.productdetails.graphql.FetchProductGroupQueryModels.FetchProductGroupQueryModel.RecommendedProductItemsModel;
import com.facebook.commerce.productdetails.graphql.FetchProductGroupQueryModels.FetchProductGroupQueryModel.RecommendedProductItemsModel.NodesModel;
import com.facebook.commerce.productdetails.ui.morefromshop.MoreFromShopAdapter.HorizontalPaddingItemDecoration;
import com.facebook.common.util.StringUtil;
import com.facebook.groups.staticadapter.StaticAdapter.Bindable;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedLazy;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.widget.CustomFrameLayout;
import com.facebook.widget.recyclerview.BetterLinearLayoutManager;
import com.facebook.widget.recyclerview.BetterRecyclerView;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: declined_permissions */
public class ProductGroupMoreFromShopView extends CustomFrameLayout implements Bindable<FetchProductGroupQueryModel> {
    @Inject
    public MoreFromShopAdapter f15281a;
    @Inject
    public CommerceNavigationUtil f15282b;
    public TextView f15283c = ((TextView) c(2131566290));
    public BetterRecyclerView f15284d = ((BetterRecyclerView) c(2131566291));

    /* compiled from: declined_permissions */
    final class C21192 implements Predicate<NodesModel> {
        C21192() {
        }

        public final boolean apply(@Nullable Object obj) {
            NodesModel nodesModel = (NodesModel) obj;
            if (StringUtil.a(nodesModel.m15798k()) || nodesModel.m15799l() == null || StringUtil.a(nodesModel.m15799l().m15792a())) {
                return false;
            }
            return true;
        }
    }

    public static void m15917a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ProductGroupMoreFromShopView productGroupMoreFromShopView = (ProductGroupMoreFromShopView) obj;
        MoreFromShopAdapter moreFromShopAdapter = new MoreFromShopAdapter(IdBasedLazy.a(fbInjector, 5054));
        CommerceNavigationUtil a = CommerceNavigationUtil.a(fbInjector);
        productGroupMoreFromShopView.f15281a = moreFromShopAdapter;
        productGroupMoreFromShopView.f15282b = a;
    }

    public final void mo758a(Object obj) {
        final FetchProductGroupQueryModel fetchProductGroupQueryModel = (FetchProductGroupQueryModel) obj;
        if (fetchProductGroupQueryModel.m15822t() == null || fetchProductGroupQueryModel.m15822t().m15771k() == null) {
            this.f15283c.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            this.f15283c.setOnClickListener(null);
        } else {
            this.f15283c.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ ProductGroupMoreFromShopView f15280b;

                public void onClick(View view) {
                    int a = Logger.a(2, EntryType.UI_INPUT_START, 982714581);
                    this.f15280b.f15282b.a(fetchProductGroupQueryModel.m15822t().m15772l(), null);
                    Logger.a(2, EntryType.UI_INPUT_END, 239780024, a);
                }
            });
            this.f15283c.setCompoundDrawablesWithIntrinsicBounds(0, 0, 2130838068, 0);
        }
        MoreFromShopAdapter moreFromShopAdapter = this.f15281a;
        moreFromShopAdapter.f15277b = (ImmutableList) Preconditions.checkNotNull(m15916a(fetchProductGroupQueryModel.m15824v()));
        moreFromShopAdapter.notifyDataSetChanged();
        this.f15281a.notifyDataSetChanged();
    }

    public ProductGroupMoreFromShopView(Context context) {
        super(context);
        Class cls = ProductGroupMoreFromShopView.class;
        m15917a(this, getContext());
        setContentView(2130906411);
        int dimensionPixelOffset = getContext().getResources().getDimensionPixelOffset(2131434188);
        this.f15284d.setLayoutManager(new BetterLinearLayoutManager(getContext(), 0, false));
        this.f15284d.a(new HorizontalPaddingItemDecoration(dimensionPixelOffset));
        this.f15284d.setAdapter(this.f15281a);
    }

    public static ImmutableList<NodesModel> m15916a(RecommendedProductItemsModel recommendedProductItemsModel) {
        return ImmutableList.copyOf(Iterables.c(recommendedProductItemsModel.m15803a(), new C21192()));
    }
}
