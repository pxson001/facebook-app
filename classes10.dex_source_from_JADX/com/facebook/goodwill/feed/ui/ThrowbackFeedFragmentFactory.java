package com.facebook.goodwill.feed.ui;

import android.content.Intent;
import android.support.v4.app.Fragment;
import com.facebook.common.fragmentfactory.IFragmentFactory;

/* compiled from: VIEWABLE */
public class ThrowbackFeedFragmentFactory implements IFragmentFactory {
    public final Fragment m22147a(Intent intent) {
        ThrowbackFeedFragment throwbackFeedFragment = new ThrowbackFeedFragment();
        throwbackFeedFragment.g(intent.getExtras());
        return throwbackFeedFragment;
    }
}
