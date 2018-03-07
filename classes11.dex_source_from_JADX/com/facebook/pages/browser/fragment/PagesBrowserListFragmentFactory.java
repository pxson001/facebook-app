package com.facebook.pages.browser.fragment;

import android.content.Intent;
import android.support.v4.app.Fragment;
import com.facebook.common.fragmentfactory.IFragmentFactory;

/* compiled from: story_gallery_survey_feed_unit_start */
public class PagesBrowserListFragmentFactory implements IFragmentFactory {
    public final Fragment m1972a(Intent intent) {
        PagesBrowserListFragment pagesBrowserListFragment = new PagesBrowserListFragment();
        pagesBrowserListFragment.g(intent.getExtras());
        return pagesBrowserListFragment;
    }
}
