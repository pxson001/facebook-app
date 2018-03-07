package com.facebook.feedback.ui;

import android.content.Context;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.facebook.api.ufiservices.common.FeedbackDisplayType;
import com.facebook.common.uri.UriIntentMapper;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.feed.rows.core.events.EventsStream;
import com.facebook.feedback.abtest.InlineReplyExpansionExperimentUtil;
import com.facebook.feedback.events.FeedbackEvents.UpdateThreadedFeedbackEvent;
import com.facebook.inject.FbInjector;
import com.facebook.katana.urimap.Fb4aUriIntentMapper;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.ufiservices.flyout.FeedbackParams;
import com.facebook.ufiservices.flyout.PopoverFragmentContainer;
import com.facebook.ufiservices.flyout.UFIPopoverLauncher;
import javax.inject.Inject;

/* compiled from: rootTag */
public class ThreadedCommentsFeedbackFragment extends BaseFeedbackFragment {
    @Inject
    public EventsStream aH;
    @Inject
    public FeedbackThreadedCommentNavigationDelegateProvider aI;
    @Inject
    public InlineReplyExpansionExperimentUtil aJ;
    private View aK;
    private View aL;
    private FeedbackThreadedCommentNavigationDelegate aM;
    private ContextThemeWrapper aN;

    /* compiled from: rootTag */
    class C04681 implements OnClickListener {
        final /* synthetic */ ThreadedCommentsFeedbackFragment f4775a;

        C04681(ThreadedCommentsFeedbackFragment threadedCommentsFeedbackFragment) {
            this.f4775a = threadedCommentsFeedbackFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 601124276);
            this.f4775a.kO_().d();
            this.f4775a.m4746b(this.f4775a.aD.f());
            Logger.a(2, EntryType.UI_INPUT_END, -1433693006, a);
        }
    }

    public static void m5304a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ThreadedCommentsFeedbackFragment threadedCommentsFeedbackFragment = (ThreadedCommentsFeedbackFragment) obj;
        EventsStream a = EventsStream.a(fbInjector);
        FeedbackThreadedCommentNavigationDelegateProvider feedbackThreadedCommentNavigationDelegateProvider = (FeedbackThreadedCommentNavigationDelegateProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(FeedbackThreadedCommentNavigationDelegateProvider.class);
        InlineReplyExpansionExperimentUtil a2 = InlineReplyExpansionExperimentUtil.a(fbInjector);
        threadedCommentsFeedbackFragment.aH = a;
        threadedCommentsFeedbackFragment.aI = feedbackThreadedCommentNavigationDelegateProvider;
        threadedCommentsFeedbackFragment.aJ = a2;
    }

    public final void mo217c(Bundle bundle) {
        Class cls = ThreadedCommentsFeedbackFragment.class;
        m5304a((Object) this, getContext());
        super.mo217c(bundle);
        if (this.aM != null) {
            this.aM.f4574a = this.aG;
        }
    }

    public final View m5306a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1678028630);
        View inflate = LayoutInflater.from(ay()).inflate(2130907398, viewGroup, false);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -449700877, a);
        return inflate;
    }

    public final void mo211a(View view, Bundle bundle) {
        this.aK = e(2131567857);
        this.aL = e(2131567858);
        OnClickListener c04681 = new C04681(this);
        this.aK.setOnClickListener(c04681);
        this.aL.setOnClickListener(c04681);
        super.mo211a(view, bundle);
    }

    public final void mY_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1949666008);
        super.mY_();
        this.aK.setOnClickListener(null);
        this.aL.setOnClickListener(null);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1054767526, a);
    }

    public final void mo264I() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -133019765);
        super.mo264I();
        if (!this.aJ.a()) {
            this.aH.a(new UpdateThreadedFeedbackEvent(this.aE, this.aB.f));
        }
        this.aD = null;
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1031428909, a);
    }

    public final String ar() {
        return "flyout_threaded_comments_feedback_animation_perf";
    }

    protected final FeedbackDisplayType au() {
        return FeedbackDisplayType.THREADED_FEEDBACK;
    }

    public final String am_() {
        return "story_feedback_flyout";
    }

    protected final Context ay() {
        if (this.aN == null) {
            this.aN = new ContextThemeWrapper(getContext(), 2131625260);
        }
        return this.aN;
    }

    protected final BaseCommentNavigationDelegate mo265a(PopoverFragmentContainer popoverFragmentContainer, FeedbackParams feedbackParams) {
        FeedbackThreadedCommentNavigationDelegateProvider feedbackThreadedCommentNavigationDelegateProvider = this.aI;
        this.aM = new FeedbackThreadedCommentNavigationDelegate(popoverFragmentContainer, feedbackParams, (SecureContextHelper) DefaultSecureContextHelper.a(feedbackThreadedCommentNavigationDelegateProvider), (UriIntentMapper) Fb4aUriIntentMapper.a(feedbackThreadedCommentNavigationDelegateProvider), UFIPopoverLauncher.b(feedbackThreadedCommentNavigationDelegateProvider));
        return this.aM;
    }
}
