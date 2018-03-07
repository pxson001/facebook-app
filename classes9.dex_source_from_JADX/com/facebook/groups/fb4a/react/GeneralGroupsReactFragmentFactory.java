package com.facebook.groups.fb4a.react;

import android.content.Intent;
import android.support.v4.app.Fragment;
import com.facebook.common.fragmentfactory.IFragmentFactory;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.fbreact.fragment.ImmersiveReactFragment;
import com.facebook.fbreact.fragment.ImmersiveReactFragment.Builder;

/* compiled from: payments_cancel_add_card */
public class GeneralGroupsReactFragmentFactory implements IFragmentFactory {
    public final Fragment m7196a(Intent intent) {
        Builder newBuilder = ImmersiveReactFragment.newBuilder();
        if (intent.getStringExtra("route") != null) {
            newBuilder.b = intent.getStringExtra("route");
        }
        String stringExtra = intent.getStringExtra("uri");
        if (stringExtra == null) {
            if (!"FBGroupsDiscoveryCategoryRoute".equals(intent.getStringExtra("route")) || intent.getStringExtra("category_id") == null) {
                stringExtra = null;
            } else {
                stringExtra = StringFormatUtil.formatStrLocaleSafe("/groups_discovery_category?category_id=%s", intent.getStringExtra("category_id"));
            }
        }
        String str = stringExtra;
        if (!StringUtil.c(str)) {
            newBuilder.a = str;
        }
        if (intent.hasExtra("show_search")) {
            newBuilder.e = intent.getBooleanExtra("show_search", false);
        }
        return GroupsReactFragment.av().m7201a(newBuilder.a()).m7200a();
    }
}
