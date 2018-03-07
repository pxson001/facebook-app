package com.facebook.commerce.storefront.ui;

import android.support.v7.widget.RecyclerView.ViewHolder;
import com.facebook.commerce.core.graphql.CoreCommerceQueryFragmentsModels.CommerceStoreFragmentModel.CommerceCollectionsModel;
import com.facebook.commerce.core.graphql.CoreCommerceQueryFragmentsModels.CommerceStoreFragmentModel.CommerceCollectionsModel.CollectionProductItemsModel;
import com.facebook.commerce.core.intent.MerchantInfoViewData;
import com.facebook.commerce.storefront.adapters.CommerceProductAdapter;
import com.facebook.commerce.storefront.util.CollectionViewData;

/* compiled from: count_friends_requested */
public class CollectionViewHolder extends ViewHolder {
    private CollectionView f15775l;

    public CollectionViewHolder(CollectionView collectionView) {
        super(collectionView);
        this.f15775l = collectionView;
    }

    public final void m16258a(CommerceCollectionsModel commerceCollectionsModel, MerchantInfoViewData merchantInfoViewData) {
        CollectionView collectionView = this.f15775l;
        collectionView.f15773g = merchantInfoViewData;
        CharSequence l = commerceCollectionsModel.l();
        int a = commerceCollectionsModel.j().a();
        collectionView.f15769c.setText(l);
        CharSequence charSequence = "";
        if (Math.floor((double) (a / 10)) > 0.0d) {
            charSequence = String.valueOf(((int) Math.floor((double) (a / 10))) * 10).concat("+");
        } else if (a > 1) {
            charSequence = String.valueOf(a);
        }
        collectionView.f15770d.setText(charSequence);
        collectionView.f15774h = new CollectionViewData(commerceCollectionsModel.k());
        collectionView.f15771e.a(0);
        CommerceProductAdapter commerceProductAdapter = collectionView.f15772f;
        CollectionViewData collectionViewData = collectionView.f15774h;
        CollectionProductItemsModel j = commerceCollectionsModel.j();
        commerceProductAdapter.f15668e = collectionView.f15773g;
        commerceProductAdapter.f15670h = j.j();
        commerceProductAdapter.f15666c = j.a();
        commerceProductAdapter.f15669f = collectionViewData;
        if (commerceProductAdapter.f15667d != null) {
            commerceProductAdapter.f15667d.m16284a(commerceProductAdapter.f15669f, commerceProductAdapter.f15666c);
        }
        collectionView.f15772f.notifyDataSetChanged();
    }
}
