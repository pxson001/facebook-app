package com.facebook.pages.identity.fragments.identity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import com.facebook.common.fragmentfactory.IFragmentFactory;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.pages.common.surface.calltoaction.fragment.PageCallToActionFragment;
import java.util.ArrayList;

/* compiled from: payments_fetch_payment_info_failed */
public class PageCallToActionFragmentFactory implements IFragmentFactory {
    public final Fragment m4865a(Intent intent) {
        String stringExtra = intent.getStringExtra("com.facebook.katana.profile.id");
        ArrayList arrayList = (ArrayList) FlatBufferModelHelper.b(intent, "page_call_to_action_fields_extra");
        boolean booleanExtra = intent.getBooleanExtra("page_call_to_action_isadmin_extra", true);
        String stringExtra2 = intent.getStringExtra("page_call_to_action_label_extra");
        PageCallToActionFragment pageCallToActionFragment = new PageCallToActionFragment();
        Bundle bundle = new Bundle();
        bundle.putString("arg_page_id", stringExtra);
        bundle.putBoolean("arg_can_edit_cta", booleanExtra);
        bundle.putString("arg_page_call_to_action_label", stringExtra2);
        FlatBufferModelHelper.a(bundle, "arg_page_call_to_action_fields", arrayList);
        pageCallToActionFragment.g(bundle);
        return pageCallToActionFragment;
    }
}
