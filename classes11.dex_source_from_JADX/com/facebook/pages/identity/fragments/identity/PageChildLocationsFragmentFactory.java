package com.facebook.pages.identity.fragments.identity;

import android.content.Intent;
import android.support.v4.app.Fragment;
import com.facebook.common.fragmentfactory.IFragmentFactory;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.pages.common.childlocations.PageChildLocationsListFragment;
import java.util.ArrayList;

/* compiled from: payment_methods_model */
public class PageChildLocationsFragmentFactory implements IFragmentFactory {
    public final Fragment m4866a(Intent intent) {
        return PageChildLocationsListFragment.m2005a((ArrayList) FlatBufferModelHelper.a(intent, "extra_child_locations"), null, String.valueOf(intent.getLongExtra("com.facebook.katana.profile.id", -1)), intent.getStringExtra("extra_page_name"), false);
    }
}
