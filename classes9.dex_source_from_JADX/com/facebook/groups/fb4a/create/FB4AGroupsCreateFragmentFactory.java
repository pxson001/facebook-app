package com.facebook.groups.fb4a.create;

import android.content.Intent;
import android.support.v4.app.Fragment;
import com.facebook.common.fragmentfactory.IFragmentFactory;

/* compiled from: payments_flow_context_key */
public class FB4AGroupsCreateFragmentFactory implements IFragmentFactory {
    public final Fragment m7144a(Intent intent) {
        FB4AGroupsCreateFragment fB4AGroupsCreateFragment = new FB4AGroupsCreateFragment();
        fB4AGroupsCreateFragment.g(intent.getExtras());
        return fB4AGroupsCreateFragment;
    }
}
