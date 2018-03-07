package com.facebook.localcontent;

import android.content.Intent;
import android.support.v4.app.Fragment;
import com.facebook.common.fragmentfactory.IFragmentFactory;
import com.facebook.localcontent.menus.admin.manager.PageLinkMenuFragment;

/* compiled from: edgeColor */
public class PageMenuManagementLinkMenuFragmentFactory implements IFragmentFactory {
    public final Fragment m17404a(Intent intent) {
        PageLinkMenuFragment pageLinkMenuFragment = new PageLinkMenuFragment();
        pageLinkMenuFragment.g(intent.getExtras());
        return pageLinkMenuFragment;
    }
}
