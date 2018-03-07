package com.facebook.localcontent;

import android.content.Intent;
import android.support.v4.app.Fragment;
import com.facebook.common.fragmentfactory.IFragmentFactory;
import com.facebook.localcontent.menus.admin.manager.PageMenuManagementFragment;

/* compiled from: edgeType */
public class PageMenuManagementFragmentFactory implements IFragmentFactory {
    public final Fragment m17403a(Intent intent) {
        PageMenuManagementFragment pageMenuManagementFragment = new PageMenuManagementFragment();
        pageMenuManagementFragment.g(intent.getExtras());
        return pageMenuManagementFragment;
    }
}
