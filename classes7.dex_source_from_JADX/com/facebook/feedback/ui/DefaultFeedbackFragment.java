package com.facebook.feedback.ui;

import android.content.Context;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import com.facebook.api.ufiservices.common.FeedbackDisplayType;
import com.facebook.debug.fps.FrameRateLogger;
import com.facebook.debug.fps.FrameRateLoggerProvider;
import com.facebook.debug.fps.FrameRateProxyScrollListener;
import com.facebook.fbservice.service.ServiceException;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feedback.abtest.ExperimentsForFeedbackTestModule;
import com.facebook.feedback.reactions.abtest.ReactionsExperimentUtil;
import com.facebook.graphql.model.GraphQLFeedback;
import com.facebook.graphql.model.GraphQLHelper;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.ufiperf.perf.UfiPerfUtil;
import com.facebook.ufiservices.flyout.FeedbackParams;
import com.facebook.widget.OnDrawListenerSet.OnDrawListener;
import com.google.common.base.Absent;
import javax.inject.Inject;

/* compiled from: screenX */
public class DefaultFeedbackFragment extends BaseFeedbackFragment {
    @Inject
    FrameRateLoggerProvider aH;
    @Inject
    UfiPerfUtil aI;
    @Inject
    FeedbackHeaderViewListenerProvider aJ;
    @Inject
    ReactionsExperimentUtil aK;
    private FeedbackHeaderView aL;
    private FrameRateLogger aM;
    private ContextThemeWrapper aN;
    public OriginalPostButtonView aO;
    @Inject
    public OriginalPostButtonUtil aP;
    public boolean aQ;
    public boolean aR;
    private final OnDrawListener aS = new C04051(this);

    /* compiled from: screenX */
    class C04051 implements OnDrawListener {
        final /* synthetic */ DefaultFeedbackFragment f4403a;

        C04051(DefaultFeedbackFragment defaultFeedbackFragment) {
            this.f4403a = defaultFeedbackFragment;
        }

        public final boolean gD_() {
            if (this.f4403a.aQ) {
                this.f4403a.aI.F();
                this.f4403a.aQ = false;
            }
            if (!this.f4403a.aR) {
                return false;
            }
            this.f4403a.aI.G();
            this.f4403a.aR = false;
            return true;
        }
    }

    public static void m5003a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((DefaultFeedbackFragment) obj).m5002a((FrameRateLoggerProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(FrameRateLoggerProvider.class), UfiPerfUtil.a(fbInjector), (FeedbackHeaderViewListenerProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(FeedbackHeaderViewListenerProvider.class), OriginalPostButtonUtil.a(fbInjector), ReactionsExperimentUtil.a(fbInjector));
    }

    private void m5002a(FrameRateLoggerProvider frameRateLoggerProvider, UfiPerfUtil ufiPerfUtil, FeedbackHeaderViewListenerProvider feedbackHeaderViewListenerProvider, OriginalPostButtonUtil originalPostButtonUtil, ReactionsExperimentUtil reactionsExperimentUtil) {
        this.aH = frameRateLoggerProvider;
        this.aI = ufiPerfUtil;
        this.aJ = feedbackHeaderViewListenerProvider;
        this.aP = originalPostButtonUtil;
        this.aK = reactionsExperimentUtil;
    }

    public final void mo217c(Bundle bundle) {
        Class cls = DefaultFeedbackFragment.class;
        m5003a((Object) this, getContext());
        super.mo217c(bundle);
        this.aM = this.aH.a(Boolean.valueOf(false), "default_feedback_scroll_perf", Absent.INSTANCE);
    }

    protected final void av() {
        this.aI.i();
    }

    public final View m5006a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -621555615);
        this.aI.j();
        View inflate = LayoutInflater.from(ay()).inflate(2130904356, viewGroup, false);
        if (this.aB != null) {
            FeedProps feedProps = this.aB.c;
            if (this.aP.a(feedProps) && !this.ar.a(ExperimentsForFeedbackTestModule.P, false)) {
                GraphQLStory L = ((GraphQLStory) feedProps.a).L();
                this.aO = (OriginalPostButtonView) ((ViewStub) inflate.findViewById(2131562058)).inflate();
                this.aO.m5187a(L);
            }
        }
        this.aI.k();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1408454172, a);
        return inflate;
    }

    public final void mo211a(View view, Bundle bundle) {
        this.aI.l();
        this.aL = (FeedbackHeaderView) e(2131562057);
        this.aL.f4541g = this.aJ.m5103a(this);
        m4742a(this.aL);
        super.mo211a(view, bundle);
        this.aC.b(this.aS);
        this.aC.a(new FrameRateProxyScrollListener(this.aM));
    }

    protected final void aw() {
        this.aI.m();
    }

    public final void m5012d(Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1501906222);
        this.aI.n();
        super.d(bundle);
        this.aI.o();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 2139240037, a);
    }

    public final void mo209G() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 976403043);
        this.aI.p();
        this.aI.w();
        super.mo209G();
        this.aI.q();
        this.aI.r();
        this.aI.z();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1605988144, a);
    }

    public final void mo210H() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 543094422);
        this.aI.C();
        this.aM.b();
        super.mo210H();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 369232349, a);
    }

    public final void mY_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 32837398);
        super.mY_();
        if (this.aL != null) {
            this.aL.f4541g = null;
        }
        m4747b(this.aL);
        this.aL = null;
        this.aO = null;
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1227812788, a);
    }

    public final void mo218e() {
        this.aI.A();
        this.aI.x();
    }

    public final void aq() {
        super.aq();
        this.aI.y();
        this.aI.B();
    }

    public final void mo199b(GraphQLFeedback graphQLFeedback) {
        super.mo199b(graphQLFeedback);
        this.aI.h();
        this.aR = true;
        if (GraphQLHelper.f(graphQLFeedback) == 0) {
            this.aI.G();
        }
    }

    public final void mo200c(GraphQLFeedback graphQLFeedback) {
        super.mo200c(graphQLFeedback);
        this.aQ = true;
        if (graphQLFeedback == null || GraphQLHelper.e(graphQLFeedback)) {
            this.aI.f();
            return;
        }
        this.aI.e();
        this.aI.g();
        if (GraphQLHelper.f(graphQLFeedback) == 0) {
            this.aI.F();
        }
    }

    public final void mo197a(ServiceException serviceException, FeedbackParams feedbackParams) {
        super.mo197a(serviceException, feedbackParams);
        this.aI.a(serviceException);
    }

    public final String ar() {
        return "flyout_feedback_animation_perf";
    }

    protected final FeedbackDisplayType au() {
        return FeedbackDisplayType.DEFAULT_FEEDBACK;
    }

    public final String am_() {
        return "story_feedback_flyout";
    }

    protected final Context ay() {
        if (this.aN == null) {
            this.aN = new ContextThemeWrapper(getContext(), 2131625259);
        }
        return this.aN;
    }
}
