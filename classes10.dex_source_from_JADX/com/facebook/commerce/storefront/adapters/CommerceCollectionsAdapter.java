package com.facebook.commerce.storefront.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.ViewGroup;
import com.facebook.commerce.core.graphql.CoreCommerceQueryFragmentsModels.CommerceStoreFragmentModel.CommerceCollectionsModel;
import com.facebook.commerce.core.intent.MerchantInfoViewData;
import com.facebook.commerce.storefront.ui.CollectionView;
import com.facebook.commerce.storefront.ui.CollectionView.C21971;
import com.facebook.commerce.storefront.ui.CollectionViewHolder;
import java.util.ArrayList;
import java.util.List;

/* compiled from: create_shortcut_group */
public class CommerceCollectionsAdapter extends AbstractProductGroupingAdapter<CollectionViewHolder> {
    private MerchantInfoViewData f15660a;
    private Context f15661b;
    public List<CommerceCollectionsModel> f15662c = new ArrayList();

    public final void m16121a(ViewHolder viewHolder, int i) {
        ((CollectionViewHolder) viewHolder).m16258a((CommerceCollectionsModel) this.f15662c.get(i), this.f15660a);
    }

    public CommerceCollectionsAdapter(Context context, MerchantInfoViewData merchantInfoViewData) {
        this.f15661b = context;
        this.f15660a = merchantInfoViewData;
    }

    public final ViewHolder m16120a(ViewGroup viewGroup, int i) {
        CollectionView collectionView = new CollectionView(this.f15661b);
        collectionView.setLayoutParams(new LayoutParams(-1, -2));
        collectionView.setBackgroundResource(2131361920);
        collectionView.setOnClickListener(new C21971(collectionView));
        return new CollectionViewHolder(collectionView);
    }

    public final long H_(int i) {
        return (long) i;
    }

    public final int aZ_() {
        return this.f15662c.size();
    }

    public final int mo763d() {
        return 2;
    }
}
