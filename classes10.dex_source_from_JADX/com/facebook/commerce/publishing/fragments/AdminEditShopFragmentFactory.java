package com.facebook.commerce.publishing.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import com.facebook.commerce.publishing.constants.AdminShopConstants;
import com.facebook.common.fragmentfactory.IFragmentFactory;
import com.google.common.base.Preconditions;

/* compiled from: cymk_notice_declined */
public class AdminEditShopFragmentFactory implements IFragmentFactory {
    public final Fragment m16060a(Intent intent) {
        Preconditions.checkState(intent.hasExtra(AdminShopConstants.f15509a));
        long longExtra = intent.getLongExtra(AdminShopConstants.f15509a, 0);
        boolean booleanExtra = intent.getBooleanExtra("extra_finish_on_launch_view_shop", false);
        Preconditions.checkState(longExtra > 0);
        AdminEditShopFragment adminEditShopFragment = new AdminEditShopFragment();
        Bundle bundle = new Bundle();
        bundle.putLong(AdminShopConstants.f15509a, longExtra);
        bundle.putBoolean("extra_finish_on_launch_view_shop", booleanExtra);
        adminEditShopFragment.g(bundle);
        return adminEditShopFragment;
    }
}
