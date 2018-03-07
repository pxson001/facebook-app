package com.facebook.pages.identity.fragments.identity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import com.facebook.common.fragmentfactory.IFragmentFactory;
import com.facebook.pages.common.contactinbox.fragments.PagesContactInboxListFragment;

/* compiled from: payment_method_type */
public class PageContactInboxFragmentFactory implements IFragmentFactory {
    public final Fragment m4867a(Intent intent) {
        long longExtra = intent.getLongExtra("com.facebook.katana.profile.id", -1);
        Bundle bundle = new Bundle();
        bundle.putLong("arg_page_id", longExtra);
        PagesContactInboxListFragment pagesContactInboxListFragment = new PagesContactInboxListFragment();
        pagesContactInboxListFragment.g(bundle);
        return pagesContactInboxListFragment;
    }
}
