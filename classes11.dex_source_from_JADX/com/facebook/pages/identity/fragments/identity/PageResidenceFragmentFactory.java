package com.facebook.pages.identity.fragments.identity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import com.facebook.common.fragmentfactory.IFragmentFactory;
import com.facebook.pages.identity.fragments.residence.PageResidenceFragment;

/* compiled from: pages_fetch_contact_inbox_request_messages_list */
public class PageResidenceFragmentFactory implements IFragmentFactory {
    public final Fragment m4903a(Intent intent) {
        long longExtra = intent.getLongExtra("com.facebook.katana.profile.id", -1);
        PageResidenceFragment pageResidenceFragment = new PageResidenceFragment();
        Bundle bundle = new Bundle();
        bundle.putLong("com.facebook.katana.profile.id", longExtra);
        pageResidenceFragment.g(bundle);
        return pageResidenceFragment;
    }
}
