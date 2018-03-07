package com.facebook.pages.identity.fragments.identity;

import android.content.Intent;
import android.support.v4.app.Fragment;
import com.facebook.common.fragmentfactory.IFragmentFactory;
import com.facebook.pages.common.services.PagesServicesFragment;

/* compiled from: pages_fetch_contact_inbox_more_request_messages */
public class PageServiceFragmentFactory implements IFragmentFactory {
    public final Fragment m4904a(Intent intent) {
        return PagesServicesFragment.m3315a(intent.getStringExtra("com.facebook.katana.profile.id"), intent.getStringExtra("profile_name"), intent.getBooleanExtra("can_viewer_create_content_extra", false), intent.getStringExtra("page_clicked_item_id_extra"), false);
    }
}
