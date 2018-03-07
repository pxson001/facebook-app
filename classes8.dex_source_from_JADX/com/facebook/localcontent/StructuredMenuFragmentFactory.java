package com.facebook.localcontent;

import android.content.Intent;
import android.support.v4.app.Fragment;
import com.facebook.common.fragmentfactory.IFragmentFactory;
import com.facebook.localcontent.menus.structured.StructuredMenuTabPagerFragment;

/* compiled from: echo */
public class StructuredMenuFragmentFactory implements IFragmentFactory {
    public final Fragment m17407a(Intent intent) {
        StructuredMenuTabPagerFragment structuredMenuTabPagerFragment = new StructuredMenuTabPagerFragment();
        structuredMenuTabPagerFragment.g(intent.getExtras());
        return structuredMenuTabPagerFragment;
    }
}
