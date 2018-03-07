package com.facebook.reviews.feed;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.analytics.CurationMechanism;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.reviews.analytics.ReviewsLogger;
import com.facebook.user.model.User;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: Trying to replace a story without id */
public class ReviewsFeedInlineReviewController {
    public final Provider<User> f21554a;
    public final ReviewsFeedComposerLauncherAndHandler f21555b;
    public final ReviewsLogger f21556c;

    /* compiled from: Trying to replace a story without id */
    public class C23051 implements OnClickListener {
        final /* synthetic */ String f21550a;
        final /* synthetic */ Activity f21551b;
        final /* synthetic */ String f21552c;
        final /* synthetic */ ReviewsFeedInlineReviewController f21553d;

        public C23051(ReviewsFeedInlineReviewController reviewsFeedInlineReviewController, String str, Activity activity, String str2) {
            this.f21553d = reviewsFeedInlineReviewController;
            this.f21550a = str;
            this.f21551b = activity;
            this.f21552c = str2;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 479566455);
            this.f21553d.f21556c.b("reviews_feed", this.f21550a);
            this.f21553d.f21555b.m25113a(this.f21551b, CurationMechanism.INLINE_REVIEW, this.f21550a, this.f21552c);
            Logger.a(2, EntryType.UI_INPUT_END, -2124251837, a);
        }
    }

    @Inject
    public ReviewsFeedInlineReviewController(Provider<User> provider, ReviewsFeedComposerLauncherAndHandler reviewsFeedComposerLauncherAndHandler, ReviewsLogger reviewsLogger) {
        this.f21554a = provider;
        this.f21555b = reviewsFeedComposerLauncherAndHandler;
        this.f21556c = reviewsLogger;
    }
}
