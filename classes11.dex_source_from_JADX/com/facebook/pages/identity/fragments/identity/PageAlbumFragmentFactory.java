package com.facebook.pages.identity.fragments.identity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import com.facebook.common.fragmentfactory.IFragmentFactory;
import com.facebook.pages.identity.fragments.photo.PageIdentityPhotosFragment;
import java.util.ArrayList;

/* compiled from: payments_select_payment_method_view_shown */
public class PageAlbumFragmentFactory implements IFragmentFactory {
    public final Fragment m4864a(Intent intent) {
        String stringExtra = intent.getStringExtra("owner_id");
        ArrayList stringArrayListExtra = intent.getStringArrayListExtra("extra_pages_admin_permissions");
        String stringExtra2 = intent.getStringExtra("page_admin_profile_pic_url_extra");
        String stringExtra3 = intent.getStringExtra("profile_name");
        PageIdentityPhotosFragment pageIdentityPhotosFragment = new PageIdentityPhotosFragment();
        Bundle bundle = new Bundle();
        bundle.putString("com.facebook.katana.profile.id", stringExtra);
        if (stringArrayListExtra != null) {
            bundle.putStringArrayList("extra_pages_admin_permissions", stringArrayListExtra);
        }
        if (stringExtra2 != null) {
            bundle.putString("page_admin_profile_pic_url_extra", stringExtra2);
        }
        if (stringExtra3 != null) {
            bundle.putString("profile_name", stringExtra3);
        }
        pageIdentityPhotosFragment.g(bundle);
        return pageIdentityPhotosFragment;
    }
}
