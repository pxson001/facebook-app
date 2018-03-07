package com.facebook.saved.fragment;

import com.facebook.base.fragment.FbFragment;

/* compiled from: inviting_user_id */
public enum SavedDashboardFragmentInfo {
    SAVED_ITEMS_LIST(SavedItemsListFragment.class, new SavedItemsListFragmentFactory());
    
    public final Class<? extends FbFragment> fragmentClass;
    public final SavedDashboardFragmentFactory<? extends FbFragment> fragmentFactory;

    private SavedDashboardFragmentInfo(Class<? extends FbFragment> cls, SavedDashboardFragmentFactory<? extends FbFragment> savedDashboardFragmentFactory) {
        this.fragmentClass = cls;
        this.fragmentFactory = savedDashboardFragmentFactory;
    }

    public final String getTag() {
        return "saved_dashboard_" + name();
    }
}
