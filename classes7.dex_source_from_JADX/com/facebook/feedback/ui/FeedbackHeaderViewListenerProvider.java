package com.facebook.feedback.ui;

import com.facebook.auth.module.ViewerContextManagerProvider;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.intent.feed.DefaultFeedIntentBuilder;
import com.facebook.intent.feed.IFeedIntentBuilder;
import com.facebook.quicklog.module.QuickPerformanceLoggerMethodAutoProvider;

/* compiled from: save_to_camera_roll */
public class FeedbackHeaderViewListenerProvider extends AbstractAssistedProvider<FeedbackHeaderViewListener> {
    public final FeedbackHeaderViewListener m5103a(FbFragment fbFragment) {
        return new FeedbackHeaderViewListener((IFeedIntentBuilder) DefaultFeedIntentBuilder.a(this), (SecureContextHelper) DefaultSecureContextHelper.a(this), QuickPerformanceLoggerMethodAutoProvider.a(this), ViewerContextManagerProvider.b(this), (AbstractFbErrorReporter) FbErrorReporterImpl.a(this), fbFragment);
    }
}
