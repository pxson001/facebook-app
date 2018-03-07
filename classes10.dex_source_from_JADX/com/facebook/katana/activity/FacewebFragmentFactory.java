package com.facebook.katana.activity;

import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.Fragment;
import com.facebook.common.fragmentfactory.IFragmentFactory;
import com.facebook.katana.activity.faceweb.FacewebFragment;

/* compiled from: SEARCH_RADIUS_1 */
public class FacewebFragmentFactory implements IFragmentFactory {
    public final Fragment m25501a(Intent intent) {
        String stringExtra = intent.getStringExtra("mobile_page");
        String stringExtra2 = intent.getStringExtra("first_party_bootstrap_js");
        boolean booleanExtra = intent.getBooleanExtra("faceweb_modal", false);
        boolean booleanExtra2 = intent.getBooleanExtra("titlebar_with_modal_done", false);
        boolean booleanExtra3 = intent.getBooleanExtra("arg_is_checkpoint", false);
        boolean booleanExtra4 = intent.getBooleanExtra("arg_is_blocking_checkpoint", false);
        boolean booleanExtra5 = intent.getBooleanExtra("faceweb_nfx", false);
        String stringExtra3 = intent.getStringExtra("extra_launch_uri");
        if (stringExtra == null && stringExtra3 != null) {
            stringExtra = Uri.parse(stringExtra3).getQueryParameter("href");
        }
        return FacewebFragment.m822a(stringExtra, stringExtra2, booleanExtra, booleanExtra2, booleanExtra3, booleanExtra4, booleanExtra5, intent.getStringExtra("uri_unhandled_report_category_name"));
    }
}
