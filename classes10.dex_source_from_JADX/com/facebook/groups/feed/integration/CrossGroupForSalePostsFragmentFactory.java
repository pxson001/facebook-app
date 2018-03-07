package com.facebook.groups.feed.integration;

import android.content.Intent;
import android.support.v4.app.Fragment;
import com.facebook.common.fragmentfactory.IFragmentFactory;
import com.facebook.groups.feed.ui.CrossGroupForSalePostsFragment;

/* compiled from: TimelineSelfFirstUnits */
public class CrossGroupForSalePostsFragmentFactory implements IFragmentFactory {
    public final Fragment m23110a(Intent intent) {
        CrossGroupForSalePostsFragment crossGroupForSalePostsFragment = new CrossGroupForSalePostsFragment();
        crossGroupForSalePostsFragment.g(intent.getExtras());
        return crossGroupForSalePostsFragment;
    }
}
