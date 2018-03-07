package com.facebook.reviews.binder;

import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.reviews.adapter.UserReviewsListBaseFooter;
import com.facebook.reviews.adapter.UserReviewsListSeeMoreFooter;

/* compiled from: UNREAD_MESSAGES */
public class UserReviewsSeeMoreViewBinder {

    /* compiled from: UNREAD_MESSAGES */
    public class C22891 implements OnClickListener {
        final /* synthetic */ UserReviewsListSeeMoreFooter f21439a;
        final /* synthetic */ UserReviewsSeeMoreViewBinder f21440b;

        public C22891(UserReviewsSeeMoreViewBinder userReviewsSeeMoreViewBinder, UserReviewsListSeeMoreFooter userReviewsListSeeMoreFooter) {
            this.f21440b = userReviewsSeeMoreViewBinder;
            this.f21439a = userReviewsListSeeMoreFooter;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1284968660);
            UserReviewsListBaseFooter userReviewsListBaseFooter = this.f21439a;
            if (!userReviewsListBaseFooter.f21364a && userReviewsListBaseFooter.f21374b.isPresent()) {
                ((OnClickListener) userReviewsListBaseFooter.f21374b.get()).onClick(view);
            }
            Logger.a(2, EntryType.UI_INPUT_END, 793947493, a);
        }
    }
}
