package com.facebook.commerce.storefront.fragments;

import android.content.Intent;
import android.support.v4.app.Fragment;
import com.facebook.common.fragmentfactory.IFragmentFactory;

/* compiled from: cover_media_id */
public class StorefrontFragmentFactory implements IFragmentFactory {
    public final Fragment m16205a(Intent intent) {
        return StorefrontFragment.m16182a(Long.valueOf(intent.getLongExtra("page_id", -1)), intent.getStringExtra("arg_init_product_id"), intent.getBooleanExtra("extra_finish_on_launch_edit_shop", false), false);
    }
}
