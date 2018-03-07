package com.facebook.commerce.publishing.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import com.facebook.commerce.publishing.constants.AdminShopConstants;
import com.facebook.common.fragmentfactory.IFragmentFactory;
import com.google.common.base.Preconditions;

/* compiled from: cymk_people_notice_accepted */
public class AdminAddShopFragmentFactory implements IFragmentFactory {
    public final Fragment m16041a(Intent intent) {
        Preconditions.checkState(intent.hasExtra(AdminShopConstants.f15509a));
        long longExtra = intent.getLongExtra(AdminShopConstants.f15509a, 0);
        Preconditions.checkState(longExtra > 0);
        AdminAddShopFragment adminAddShopFragment = new AdminAddShopFragment();
        Bundle bundle = new Bundle();
        bundle.putLong(AdminShopConstants.f15509a, longExtra);
        adminAddShopFragment.g(bundle);
        return adminAddShopFragment;
    }
}
