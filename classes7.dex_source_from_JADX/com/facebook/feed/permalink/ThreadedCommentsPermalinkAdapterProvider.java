package com.facebook.feed.permalink;

import com.facebook.api.ufiservices.FetchSingleCommentParams;
import com.facebook.api.ufiservices.common.FeedbackLoggingParams;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.feedback.ui.CommentDelegate;
import com.facebook.feedback.ui.CommentView.NavigationListener;
import com.facebook.inject.AbstractAssistedProvider;

/* compiled from: admin_tapped_post */
public class ThreadedCommentsPermalinkAdapterProvider extends AbstractAssistedProvider<ThreadedCommentsPermalinkAdapter> {
    public final ThreadedCommentsPermalinkAdapter m22927a(FetchSingleCommentParams fetchSingleCommentParams, NavigationListener navigationListener, FeedbackLoggingParams feedbackLoggingParams) {
        return new ThreadedCommentsPermalinkAdapter(fetchSingleCommentParams, navigationListener, feedbackLoggingParams, CommentDelegate.m4850b(this), (AbstractFbErrorReporter) FbErrorReporterImpl.a(this));
    }
}
