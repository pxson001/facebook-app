package com.facebook.pages.identity.fragments.identity;

import android.content.Intent;
import android.support.v4.app.Fragment;
import com.facebook.common.fragmentfactory.IFragmentFactory;
import com.facebook.pages.identity.fragments.moreinformation.PageInformationFragment;

/* compiled from: pages_native_timeline */
public class PageInformationFragmentFactory implements IFragmentFactory {
    public final Fragment m4900a(Intent intent) {
        return PageInformationFragment.m4930a(intent.getLongExtra("com.facebook.katana.profile.id", -1), false);
    }
}
