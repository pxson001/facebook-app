package com.facebook.commerce.storefront.fragments;

import android.content.Intent;
import android.support.v4.app.Fragment;
import com.facebook.common.fragmentfactory.IFragmentFactory;

/* compiled from: create shop mutation failed */
public class AdCollectionViewFragmentFactory implements IFragmentFactory {
    public final Fragment m16155a(Intent intent) {
        return CollectionViewFragment.m16161a(Long.valueOf(intent.getLongExtra("collection_id", -1)).longValue(), true, null);
    }
}
