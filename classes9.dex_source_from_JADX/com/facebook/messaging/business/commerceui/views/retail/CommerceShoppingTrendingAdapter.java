package com.facebook.messaging.business.commerceui.views.retail;

import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.messaging.business.attachments.model.PlatformGenericAttachmentItem;
import com.facebook.messaging.business.commerceui.views.retail.CommerceShoppingTrendingItemView.C09691;
import com.google.common.collect.ImmutableList;

/* compiled from: null content-type */
public class CommerceShoppingTrendingAdapter extends Adapter<TrendingItemViewHolder> {
    public ImmutableList<PlatformGenericAttachmentItem> f8487a;
    public String f8488b;

    /* compiled from: null content-type */
    public class TrendingItemViewHolder extends ViewHolder {
        public final CommerceShoppingTrendingItemView f8486l;

        public TrendingItemViewHolder(View view) {
            super(view);
            this.f8486l = (CommerceShoppingTrendingItemView) view;
        }
    }

    public final void m8736a(ViewHolder viewHolder, int i) {
        TrendingItemViewHolder trendingItemViewHolder = (TrendingItemViewHolder) viewHolder;
        PlatformGenericAttachmentItem platformGenericAttachmentItem = (PlatformGenericAttachmentItem) this.f8487a.get(i);
        String str = this.f8488b;
        CommerceShoppingTrendingItemView commerceShoppingTrendingItemView = trendingItemViewHolder.f8486l;
        commerceShoppingTrendingItemView.f8504c.a(platformGenericAttachmentItem.d, CallerContext.a(commerceShoppingTrendingItemView.getClass()));
        commerceShoppingTrendingItemView.f8505d.setText(platformGenericAttachmentItem.b);
        commerceShoppingTrendingItemView.f8506e.setText(platformGenericAttachmentItem.e);
        commerceShoppingTrendingItemView.setOnClickListener(new C09691(commerceShoppingTrendingItemView, str, platformGenericAttachmentItem));
    }

    public final ViewHolder m8735a(ViewGroup viewGroup, int i) {
        return new TrendingItemViewHolder(new CommerceShoppingTrendingItemView(viewGroup.getContext()));
    }

    public final int aZ_() {
        return this.f8487a == null ? 0 : this.f8487a.size();
    }
}
