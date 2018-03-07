package com.facebook.pages.browser.fragment;

import android.content.Intent;
import android.support.v4.app.Fragment;
import com.facebook.common.fragmentfactory.IFragmentFactory;

/* compiled from: story_gallery_survey_ratings_pref_first */
public class PagesBrowserFragmentFactory implements IFragmentFactory {
    public final Fragment m1960a(Intent intent) {
        PagesBrowserFragment pagesBrowserFragment = new PagesBrowserFragment();
        pagesBrowserFragment.g(intent.getExtras());
        return pagesBrowserFragment;
    }
}
