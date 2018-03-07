package com.facebook.feedback.ui;

import android.content.Intent;
import com.facebook.auth.viewercontext.ViewerContextManager;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.content.SecureContextHelper;
import com.facebook.feedback.ui.FeedbackHeaderView.Listener;
import com.facebook.graphql.model.GraphQLFeedback;
import com.facebook.graphql.model.GraphQLHelper;
import com.facebook.inject.Assisted;
import com.facebook.intent.feed.IFeedIntentBuilder;
import com.facebook.quicklog.QuickPerformanceLogger;
import javax.inject.Inject;

/* compiled from: savedAlbumDescription */
public class FeedbackHeaderViewListener implements Listener {
    private static final String f4542a = FeedbackHeaderViewListener.class.getName();
    private final IFeedIntentBuilder f4543b;
    private final SecureContextHelper f4544c;
    private final FbFragment f4545d;
    private final QuickPerformanceLogger f4546e;
    private final ViewerContextManager f4547f;
    private final AbstractFbErrorReporter f4548g;

    @Inject
    public FeedbackHeaderViewListener(IFeedIntentBuilder iFeedIntentBuilder, SecureContextHelper secureContextHelper, QuickPerformanceLogger quickPerformanceLogger, ViewerContextManager viewerContextManager, AbstractFbErrorReporter abstractFbErrorReporter, @Assisted FbFragment fbFragment) {
        this.f4543b = iFeedIntentBuilder;
        this.f4544c = secureContextHelper;
        this.f4545d = fbFragment;
        this.f4546e = quickPerformanceLogger;
        this.f4547f = viewerContextManager;
        this.f4548g = abstractFbErrorReporter;
    }

    public final void mo228a(GraphQLFeedback graphQLFeedback) {
        if (GraphQLHelper.s(graphQLFeedback)) {
            Intent a = this.f4543b.a(graphQLFeedback, "story_feedback_flyout");
            a.putExtra("fragment_title", this.f4545d.getContext().getString(2131233292));
            if (this.f4547f.b() != null && this.f4547f.b().mIsPageContext) {
                a.putExtra("com.facebook.orca.auth.OVERRIDDEN_VIEWER_CONTEXT", this.f4547f.b());
            }
            this.f4546e.b(8519681);
            this.f4544c.a(a, this.f4545d.getContext());
            return;
        }
        this.f4548g.a(f4542a, "Reactors list init needs valid reactors count map");
    }
}
