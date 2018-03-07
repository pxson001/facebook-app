package com.facebook.commerce.productdetails.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import com.facebook.commerce.core.analytics.CommerceAnalytics.CommerceRefType;
import com.facebook.common.fragmentfactory.IFragmentFactory;

/* compiled from: deleteMessagesOperation */
public class ProductGroupFragmentFactory implements IFragmentFactory {
    public final Fragment m15685a(Intent intent) {
        CommerceRefType commerceRefType = (CommerceRefType) intent.getSerializableExtra("product_ref_type");
        long longValue = Long.valueOf(intent.getLongExtra("product_item_id", -1)).longValue();
        Bundle bundle = new Bundle();
        bundle.putLong("product_item_id", longValue);
        bundle.putSerializable("product_ref_type", commerceRefType);
        ProductDetailsFragment productDetailsFragment = new ProductDetailsFragment();
        productDetailsFragment.g(bundle);
        return productDetailsFragment;
    }
}
