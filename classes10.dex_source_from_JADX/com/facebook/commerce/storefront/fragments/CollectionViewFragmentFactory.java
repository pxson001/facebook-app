package com.facebook.commerce.storefront.fragments;

import android.content.Intent;
import android.support.v4.app.Fragment;
import com.facebook.common.fragmentfactory.IFragmentFactory;

/* compiled from: cpu[0-9]+ */
public class CollectionViewFragmentFactory implements IFragmentFactory {
    public final Fragment m16168a(Intent intent) {
        Long valueOf = Long.valueOf(intent.getLongExtra("collection_id", -1));
        return CollectionViewFragment.m16161a(valueOf.longValue(), false, intent.getStringExtra("merchant_page_id"));
    }
}
