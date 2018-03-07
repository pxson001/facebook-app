package com.facebook.commerce.productdetails.ui.morefromshop;

import android.graphics.Rect;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.State;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.facebook.commerce.core.ui.ProductItemWithPriceOverlayView;
import com.facebook.commerce.core.util.CommerceNavigationUtil;
import com.facebook.commerce.productdetails.graphql.FetchProductGroupQueryModels.FetchProductGroupQueryModel.RecommendedProductItemsModel.NodesModel;
import com.facebook.inject.Lazy;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import javax.inject.Inject;

/* compiled from: decoded_string */
public class MoreFromShopAdapter extends Adapter<ViewHolder> {
    public final Lazy<CommerceNavigationUtil> f15276a;
    public ImmutableList<NodesModel> f15277b = RegularImmutableList.a;
    private final C21161 f15278c = new C21161(this);

    /* compiled from: decoded_string */
    public class C21161 {
        public final /* synthetic */ MoreFromShopAdapter f15269a;

        C21161(MoreFromShopAdapter moreFromShopAdapter) {
            this.f15269a = moreFromShopAdapter;
        }
    }

    /* compiled from: decoded_string */
    public class HorizontalPaddingItemDecoration extends ItemDecoration {
        private final int f15270a;

        public HorizontalPaddingItemDecoration(int i) {
            this.f15270a = i;
        }

        public final void m15913a(Rect rect, View view, RecyclerView recyclerView, State state) {
            rect.left = this.f15270a;
            if (RecyclerView.d(view) == recyclerView.o.aZ_() - 1) {
                rect.right = this.f15270a;
            }
        }
    }

    /* compiled from: decoded_string */
    public class ViewHolder extends android.support.v7.widget.RecyclerView.ViewHolder {
        final /* synthetic */ MoreFromShopAdapter f15273l;
        public final ProductItemWithPriceOverlayView f15274m;
        public final C21161 f15275n;

        public ViewHolder(final MoreFromShopAdapter moreFromShopAdapter, ProductItemWithPriceOverlayView productItemWithPriceOverlayView, C21161 c21161) {
            this.f15273l = moreFromShopAdapter;
            super(productItemWithPriceOverlayView);
            this.f15274m = productItemWithPriceOverlayView;
            this.f15275n = c21161;
            this.f15274m.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ ViewHolder f15272b;

                public void onClick(View view) {
                    int a = Logger.a(2, EntryType.UI_INPUT_START, -25773477);
                    if (this.f15272b.f15275n != null) {
                        C21161 c21161 = this.f15272b.f15275n;
                        ((CommerceNavigationUtil) c21161.f15269a.f15276a.get()).a(((NodesModel) c21161.f15269a.f15277b.get(this.f15272b.e())).m15798k());
                    }
                    Logger.a(2, EntryType.UI_INPUT_END, -729896939, a);
                }
            });
        }
    }

    public final void m15915a(android.support.v7.widget.RecyclerView.ViewHolder viewHolder, int i) {
        NodesModel nodesModel = (NodesModel) this.f15277b.get(i);
        ((ViewHolder) viewHolder).f15274m.a(Uri.parse(nodesModel.m15799l().m15792a()), nodesModel.m15797j());
    }

    @Inject
    public MoreFromShopAdapter(Lazy<CommerceNavigationUtil> lazy) {
        this.f15276a = lazy;
    }

    public final android.support.v7.widget.RecyclerView.ViewHolder m15914a(ViewGroup viewGroup, int i) {
        return new ViewHolder(this, new ProductItemWithPriceOverlayView(viewGroup.getContext()), this.f15278c);
    }

    public final int aZ_() {
        return this.f15277b.size();
    }
}
