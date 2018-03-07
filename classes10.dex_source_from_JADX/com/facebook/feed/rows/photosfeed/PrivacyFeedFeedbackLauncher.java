package com.facebook.feed.rows.photosfeed;

import com.facebook.feedback.ui.FeedbackPopoverLauncher;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;

/* compiled from: androidid */
public class PrivacyFeedFeedbackLauncher {
    public final FeedbackPopoverLauncher f19646a;

    public static PrivacyFeedFeedbackLauncher m19926b(InjectorLike injectorLike) {
        return new PrivacyFeedFeedbackLauncher(FeedbackPopoverLauncher.a(injectorLike));
    }

    @Inject
    public PrivacyFeedFeedbackLauncher(FeedbackPopoverLauncher feedbackPopoverLauncher) {
        this.f19646a = feedbackPopoverLauncher;
    }
}
