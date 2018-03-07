package com.facebook.pages.identity.fragments.identity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import com.facebook.common.fragmentfactory.IFragmentFactory;
import com.facebook.pages.common.services.PagesServicesItemFragment;
import com.google.common.base.Strings;

/* compiled from: pages_contact_inbox_update_state_mutation_ */
public class PageSingleServiceFragmentFactory implements IFragmentFactory {
    public final Fragment m4905a(Intent intent) {
        String stringExtra = intent.getStringExtra("com.facebook.katana.profile.id");
        String stringExtra2 = intent.getStringExtra("page_service_id_extra");
        String stringExtra3 = intent.getStringExtra("profile_name");
        boolean booleanExtra = intent.getBooleanExtra("extra_service_launched_from_page", false);
        PagesServicesItemFragment pagesServicesItemFragment = new PagesServicesItemFragment();
        Bundle bundle = new Bundle();
        bundle.putString("com.facebook.katana.profile.id", stringExtra);
        bundle.putString("page_service_id_extra", stringExtra2);
        if (!Strings.isNullOrEmpty(stringExtra3)) {
            bundle.putString("profile_name", stringExtra3);
        }
        bundle.putBoolean("extra_service_launched_from_page", booleanExtra);
        pagesServicesItemFragment.g(bundle);
        return pagesServicesItemFragment;
    }
}
