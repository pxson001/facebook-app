package com.facebook.reviews.ui;

import android.content.Intent;
import android.support.v4.app.Fragment;
import com.facebook.common.fragmentfactory.IFragmentFactory;

/* compiled from: TimeToSurfaceTabFragmentViewCreated */
public class PageReviewsFragmentFactory implements IFragmentFactory {
    public final Fragment m25254a(Intent intent) {
        PageReviewsFeedFullscreenFragment pageReviewsFeedFullscreenFragment = new PageReviewsFeedFullscreenFragment();
        pageReviewsFeedFullscreenFragment.g(intent.getExtras());
        return pageReviewsFeedFullscreenFragment;
    }
}
