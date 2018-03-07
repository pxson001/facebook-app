package com.facebook.reviews.ui;

import android.content.Intent;
import android.support.v4.app.Fragment;
import com.facebook.common.fragmentfactory.IFragmentFactory;

/* compiled from: TimeToProfilePhotoComplete */
public class UserReviewsFragmentFactory implements IFragmentFactory {
    public final Fragment m25287a(Intent intent) {
        UserReviewsFragment userReviewsFragment = new UserReviewsFragment();
        userReviewsFragment.g(intent.getExtras());
        return userReviewsFragment;
    }
}
