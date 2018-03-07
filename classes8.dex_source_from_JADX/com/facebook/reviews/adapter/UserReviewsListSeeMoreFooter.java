package com.facebook.reviews.adapter;

import android.view.View.OnClickListener;
import com.google.common.base.Optional;

/* compiled from: UPLOADED_MEDIA_SET */
public class UserReviewsListSeeMoreFooter extends UserReviewsListBaseFooter {
    public boolean f21373a = true;
    public Optional<OnClickListener> f21374b;

    public final UserReviewsListViewTypes mo1168a() {
        if (this.f21364a) {
            return UserReviewsListViewTypes.LOADING_MORE;
        }
        return this.f21373a ? UserReviewsListViewTypes.SEE_MORE : UserReviewsListViewTypes.BLANK_FOOTER;
    }
}
