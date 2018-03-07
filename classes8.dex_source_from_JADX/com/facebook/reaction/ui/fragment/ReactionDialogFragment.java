package com.facebook.reaction.ui.fragment;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.DialogInterface;
import android.content.DialogInterface.OnKeyListener;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import com.facebook.analytics.tagging.AnalyticsFragment;
import com.facebook.base.broadcast.BaseFbBroadcastManager;
import com.facebook.base.broadcast.BaseFbBroadcastManager.SelfRegistrableReceiverImpl;
import com.facebook.base.broadcast.FbBroadcastManager;
import com.facebook.base.broadcast.LocalBroadcast;
import com.facebook.base.broadcast.LocalFbBroadcastManager;
import com.facebook.common.appstate.AppStateManager;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.time.AwakeTimeSinceBootClockMethodAutoProvider;
import com.facebook.common.time.MonotonicClock;
import com.facebook.common.util.ContextUtils;
import com.facebook.composer.publish.ComposerPublishServiceHelper;
import com.facebook.composer.publish.common.PendingStory;
import com.facebook.composer.publish.common.PublishPostParams;
import com.facebook.content.ActionReceiver;
import com.facebook.content.BroadcastReceiverLike;
import com.facebook.debug.fps.FrameRateLogger;
import com.facebook.debug.fps.FrameRateLoggerProvider;
import com.facebook.debug.fps.FrameRateRecyclerViewScrollListener;
import com.facebook.feed.rows.MultiRowFeedLifecycleSubscribers;
import com.facebook.feed.ui.DisabledFeedStoryMenuHelper;
import com.facebook.feed.video.FullScreenVideoPlayerHost;
import com.facebook.graphql.calls.ReactionTriggerInputTriggerData.Surface;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.placetips.bootstrap.PresenceSourceType;
import com.facebook.placetips.presence.PagePresenceManager;
import com.facebook.quicklog.QuickPerformanceLogger;
import com.facebook.quicklog.module.QuickPerformanceLoggerMethodAutoProvider;
import com.facebook.reaction.ReactionSession;
import com.facebook.reaction.ReactionSessionListener;
import com.facebook.reaction.ReactionSessionManager;
import com.facebook.reaction.ReactionThemedContextHelper;
import com.facebook.reaction.analytics.ReactionAnalytics.UnitInteractionType;
import com.facebook.reaction.analytics.ReactionAnalyticsLogger;
import com.facebook.reaction.analytics.ReactionAnalyticsLogger.Event;
import com.facebook.reaction.analytics.sequence.ReactionSequences;
import com.facebook.reaction.analytics.sequence.ReactionSequences.OverlayDisplaySequence;
import com.facebook.reaction.common.ReactionCardContainer;
import com.facebook.reaction.common.ReactionCommonConstants.CardSearchType;
import com.facebook.reaction.common.ReactionInteractionTracker;
import com.facebook.reaction.common.ReactionInteractionTrackerProvider;
import com.facebook.reaction.feed.ReactionFeedListType;
import com.facebook.reaction.intent.ReactionReviewUpdateHandler;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLInterfaces.ReactionStories;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLInterfaces.ReactionUnitFragment;
import com.facebook.reaction.ui.ReactionHeaderView;
import com.facebook.reaction.ui.recyclerview.AbstractReactionRecyclerViewAdapter;
import com.facebook.reaction.ui.recyclerview.ReactionMixedRecyclerViewAdapterProvider;
import com.facebook.reaction.ui.welcomeheader.ReactionWelcomeHeaderView;
import com.facebook.reaction.util.ReactionSurfaceUtil;
import com.facebook.sequencelogger.Sequence;
import com.facebook.sequencelogger.SequenceLogger;
import com.facebook.sequencelogger.SequenceLoggerImpl;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.tools.dextr.runtime.detour.SequenceLoggerDetour;
import com.facebook.ui.dialogs.FbDialogFragment;
import com.facebook.widget.listeners.BaseAnimationListener;
import com.facebook.widget.recyclerview.BetterLinearLayoutManager;
import com.facebook.widget.recyclerview.BetterRecyclerView;
import com.google.common.base.Absent;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: UnownedLocalPagePhotosQuery */
public class ReactionDialogFragment extends FbDialogFragment implements AnalyticsFragment, ReactionSessionListener, ReactionCardContainer {
    private static final String aC = ReactionDialogFragment.class.getSimpleName();
    @Inject
    ReactionThemedContextHelper aA;
    @Inject
    SequenceLogger aB;
    public boolean aD = false;
    private boolean aE;
    private boolean aF = false;
    private boolean aG = false;
    private boolean aH = false;
    public long aI;
    public long aJ;
    private long aK;
    private long aL;
    private long aM;
    public long aN;
    private long aO = 0;
    public long aP = 0;
    public ReactionSession aQ;
    private String aR;
    private Context aS;
    private FrameRateLogger aT;
    public ReactionInteractionTracker aU;
    public SelfRegistrableReceiverImpl aV;
    public SelfRegistrableReceiverImpl aW;
    private Sequence<OverlayDisplaySequence> aX;
    public AbstractReactionRecyclerViewAdapter aY;
    public BetterLinearLayoutManager aZ;
    @Inject
    @LocalBroadcast
    public BaseFbBroadcastManager am;
    @Inject
    MonotonicClock an;
    @Inject
    DisabledFeedStoryMenuHelper ao;
    @Inject
    AbstractFbErrorReporter ap;
    @Inject
    FrameRateLoggerProvider aq;
    @Inject
    Lazy<ComposerPublishServiceHelper> ar;
    @Inject
    public Lazy<PagePresenceManager> as;
    @Inject
    Lazy<ReactionReviewUpdateHandler> at;
    @Inject
    MultiRowFeedLifecycleSubscribers au;
    @Inject
    QuickPerformanceLogger av;
    @Inject
    ReactionAnalyticsLogger aw;
    @Inject
    ReactionInteractionTrackerProvider ax;
    @Inject
    ReactionMixedRecyclerViewAdapterProvider ay;
    @Inject
    ReactionSessionManager az;
    public BetterRecyclerView ba;
    private ReactionHeaderView bb;
    private ReactionWelcomeHeaderView bc;
    private View bd;
    private ViewStub be;
    @Nullable
    private View bf = null;
    @Nullable
    private ViewGroup bg = null;

    /* compiled from: UnownedLocalPagePhotosQuery */
    class C22341 implements OnKeyListener {
        final /* synthetic */ ReactionDialogFragment f21124a;

        C22341(ReactionDialogFragment reactionDialogFragment) {
            this.f21124a = reactionDialogFragment;
        }

        public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
            return keyEvent.getAction() == 1 && i == 4 && this.f21124a.O_();
        }
    }

    /* compiled from: UnownedLocalPagePhotosQuery */
    public class C22352 extends BaseAnimationListener {
        final /* synthetic */ ReactionDialogFragment f21125a;

        public C22352(ReactionDialogFragment reactionDialogFragment) {
            this.f21125a = reactionDialogFragment;
        }

        public void onAnimationEnd(Animation animation) {
            this.f21125a.aD = true;
            if (this.f21125a.y) {
                ReactionDialogFragment.aB(this.f21125a);
            }
        }

        public void onAnimationStart(Animation animation) {
            this.f21125a.aI = this.f21125a.an.now();
            if (ReactionSurfaceUtil.m4780g(this.f21125a.aQ.f18660c)) {
                ReactionDialogFragment.aw(this.f21125a);
            }
        }
    }

    /* compiled from: UnownedLocalPagePhotosQuery */
    public class C22363 implements ActionReceiver {
        final /* synthetic */ ReactionDialogFragment f21126a;

        public C22363(ReactionDialogFragment reactionDialogFragment) {
            this.f21126a = reactionDialogFragment;
        }

        public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
            int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, -1817097022);
            if (this.f21126a.aN > 0) {
                ReactionDialogFragment.m24747b(this.f21126a, this.f21126a.an.now() - this.f21126a.aN);
            }
            this.f21126a.aN = 0;
            Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, 1403092491, a);
        }
    }

    /* compiled from: UnownedLocalPagePhotosQuery */
    public class C22374 implements ActionReceiver {
        final /* synthetic */ ReactionDialogFragment f21127a;

        public C22374(ReactionDialogFragment reactionDialogFragment) {
            this.f21127a = reactionDialogFragment;
        }

        public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
            int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, -801601695);
            this.f21127a.aN = this.f21127a.an.now();
            Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, -1261154304, a);
        }
    }

    /* compiled from: UnownedLocalPagePhotosQuery */
    class CloseButtonClickListener implements OnClickListener {
        final /* synthetic */ ReactionDialogFragment f21130a;

        public CloseButtonClickListener(ReactionDialogFragment reactionDialogFragment) {
            this.f21130a = reactionDialogFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1789102579);
            this.f21130a.a();
            Logger.a(2, EntryType.UI_INPUT_END, -1108417907, a);
        }
    }

    /* compiled from: UnownedLocalPagePhotosQuery */
    class RetryButtonClickListener implements OnClickListener {
        final /* synthetic */ ReactionDialogFragment f21131a;

        public RetryButtonClickListener(ReactionDialogFragment reactionDialogFragment) {
            this.f21131a = reactionDialogFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -429491649);
            this.f21131a.az.m22618f(this.f21131a.aQ.f18658a);
            ReactionDialogFragment.m24755i(this.f21131a, false);
            ReactionDialogFragment.m24754h(this.f21131a, true);
            Logger.a(2, EntryType.UI_INPUT_END, -88128519, a);
        }
    }

    public static void m24745a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((ReactionDialogFragment) obj).m24743a((BaseFbBroadcastManager) LocalFbBroadcastManager.a(injectorLike), (MonotonicClock) AwakeTimeSinceBootClockMethodAutoProvider.a(injectorLike), DisabledFeedStoryMenuHelper.a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), (FrameRateLoggerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(FrameRateLoggerProvider.class), IdBasedLazy.a(injectorLike, 5272), IdBasedSingletonScopeProvider.b(injectorLike, 3009), IdBasedSingletonScopeProvider.b(injectorLike, 10087), MultiRowFeedLifecycleSubscribers.a(injectorLike), QuickPerformanceLoggerMethodAutoProvider.a(injectorLike), ReactionAnalyticsLogger.m22814a(injectorLike), (ReactionInteractionTrackerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(ReactionInteractionTrackerProvider.class), (ReactionMixedRecyclerViewAdapterProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(ReactionMixedRecyclerViewAdapterProvider.class), ReactionSessionManager.m22590a(injectorLike), ReactionThemedContextHelper.m22628a(injectorLike), (SequenceLogger) SequenceLoggerImpl.a(injectorLike));
    }

    private void m24743a(FbBroadcastManager fbBroadcastManager, MonotonicClock monotonicClock, DisabledFeedStoryMenuHelper disabledFeedStoryMenuHelper, FbErrorReporter fbErrorReporter, FrameRateLoggerProvider frameRateLoggerProvider, Lazy<ComposerPublishServiceHelper> lazy, Lazy<PagePresenceManager> lazy2, Lazy<ReactionReviewUpdateHandler> lazy3, MultiRowFeedLifecycleSubscribers multiRowFeedLifecycleSubscribers, QuickPerformanceLogger quickPerformanceLogger, ReactionAnalyticsLogger reactionAnalyticsLogger, ReactionInteractionTrackerProvider reactionInteractionTrackerProvider, ReactionMixedRecyclerViewAdapterProvider reactionMixedRecyclerViewAdapterProvider, ReactionSessionManager reactionSessionManager, ReactionThemedContextHelper reactionThemedContextHelper, SequenceLogger sequenceLogger) {
        this.am = fbBroadcastManager;
        this.an = monotonicClock;
        this.ao = disabledFeedStoryMenuHelper;
        this.ap = fbErrorReporter;
        this.aq = frameRateLoggerProvider;
        this.ar = lazy;
        this.as = lazy2;
        this.at = lazy3;
        this.au = multiRowFeedLifecycleSubscribers;
        this.av = quickPerformanceLogger;
        this.aw = reactionAnalyticsLogger;
        this.ax = reactionInteractionTrackerProvider;
        this.ay = reactionMixedRecyclerViewAdapterProvider;
        this.az = reactionSessionManager;
        this.aA = reactionThemedContextHelper;
        this.aB = sequenceLogger;
    }

    static /* synthetic */ long m24747b(ReactionDialogFragment reactionDialogFragment, long j) {
        long j2 = reactionDialogFragment.aO + j;
        reactionDialogFragment.aO = j2;
        return j2;
    }

    public final String am_() {
        return "reaction_dialog";
    }

    @Nullable
    public ViewGroup getCardViewGroup() {
        return this.ba;
    }

    public Fragment getFragment() {
        return this;
    }

    @Nullable
    public ReactionInteractionTracker getInteractionTracker() {
        return this.aU;
    }

    @Nonnull
    public String getSessionId() {
        return this.aQ == null ? "NO_SESSION_ID" : this.aQ.f18658a;
    }

    @Nullable
    public Surface getSurface() {
        if (this.aQ == null) {
            return null;
        }
        return this.aQ.f18660c;
    }

    public final void m24763a(Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 462218721);
        super.a(bundle);
        Class cls = ReactionDialogFragment.class;
        m24745a((Object) this, getContext());
        this.aT = this.aq.a(Boolean.valueOf(false), "reaction_dialog_scroll_perf", Absent.INSTANCE);
        this.aM = this.an.now();
        String string = this.s.getString("reaction_session_id");
        if (string == null) {
            m24750b("NO_SESSION_ID");
            Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1684317823, a);
            return;
        }
        this.aQ = this.az.m22614b(string);
        if (this.aQ == null) {
            m24750b("NO_SESSION");
            LogUtils.f(363652182, a);
            return;
        }
        this.aX = this.aB.a(ReactionSequences.f18808a);
        this.aS = ReactionThemedContextHelper.m22627a(getContext(), this.aQ.f18660c);
        this.aY = this.ay.m24812a(this.aS, ReactionFeedListType.f18943a, this.ao, this);
        if (ReactionSurfaceUtil.m4779e(this.aQ.f18660c)) {
            a(2, 2131625813);
            this.aD = true;
        } else {
            a(2, 2131625814);
        }
        this.aV = this.am.a().a(AppStateManager.b, new C22363(this)).a();
        this.aV.b();
        this.aW = this.am.a().a(AppStateManager.c, new C22374(this)).a();
        this.aW.b();
        LogUtils.f(2127033836, a);
    }

    public final Dialog m24768c(Bundle bundle) {
        Dialog c = super.c(bundle);
        c.setOnKeyListener(new C22341(this));
        return c;
    }

    public final boolean O_() {
        super.O_();
        FullScreenVideoPlayerHost fullScreenVideoPlayerHost = (FullScreenVideoPlayerHost) ContextUtils.a(getContext(), FullScreenVideoPlayerHost.class);
        return fullScreenVideoPlayerHost != null && fullScreenVideoPlayerHost.o();
    }

    public final View m24759a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 335026122);
        if (this.aQ == null || this.aS == null) {
            Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1910357505, a);
            return null;
        }
        LayoutInflater from = LayoutInflater.from(this.aS);
        SequenceLoggerDetour.a(this.aX, OverlayDisplaySequence.f18804d, this.aQ.f18658a, null, 1583395253);
        View inflate = from.inflate(2130906692, viewGroup, false);
        SequenceLoggerDetour.b(this.aX, OverlayDisplaySequence.f18804d, this.aQ.f18658a, null, -1625747162);
        SequenceLoggerDetour.a(this.aX, OverlayDisplaySequence.f18803c, this.aQ.f18658a, null, 1880747891);
        this.bd = inflate.findViewById(2131566751);
        this.bb = (ReactionHeaderView) inflate.findViewById(2131566753);
        this.bb.m24414a(this.aQ, (Fragment) this);
        this.be = (ViewStub) inflate.findViewById(2131566748);
        boolean g = ReactionSurfaceUtil.m4780g(this.aQ.f18660c);
        if (g) {
            ViewGroup viewGroup2 = (ViewGroup) ((ViewStub) inflate.findViewById(2131566750)).inflate();
            this.bf = viewGroup2.findViewById(2131566715);
            this.bg = (ViewGroup) viewGroup2.findViewById(2131566756);
            inflate.findViewById(2131566757).setOnClickListener(new RetryButtonClickListener(this));
        }
        inflate.findViewById(2131566754).setOnClickListener(new CloseButtonClickListener(this));
        SequenceLoggerDetour.b(this.aX, OverlayDisplaySequence.f18803c, this.aQ.f18658a, null, -361767338);
        SequenceLoggerDetour.a(this.aX, OverlayDisplaySequence.f18806f, this.aQ.f18658a, null, -2118277758);
        this.ba = (BetterRecyclerView) inflate.findViewById(2131566669);
        this.aZ = new BetterLinearLayoutManager(getContext());
        this.ba.setLayoutManager(this.aZ);
        as();
        this.az.m22610a(this.aQ.f18658a, (ReactionSessionListener) this);
        if (this.aE) {
            SequenceLoggerDetour.b(this.aX, OverlayDisplaySequence.f18806f, this.aQ.f18658a, null, 1441857288);
            aA();
            m24754h(this, false);
            this.aL = this.an.now() - this.aM;
            LogUtils.f(-15651859, a);
            return inflate;
        } else if (g) {
            this.aB.d(ReactionSequences.f18808a);
            this.aR = null;
            aA();
            this.aH = true;
            LogUtils.f(-721367718, a);
            return inflate;
        } else {
            this.aB.d(ReactionSequences.f18808a);
            LogUtils.f(116114497, a);
            return null;
        }
    }

    public final void m24756G() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1698803288);
        super.G();
        this.aJ = this.an.now();
        if (!this.aH || this.aE) {
            aq();
            LogUtils.f(567477774, a);
            return;
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 427726336, a);
    }

    private void aq() {
        long j = 0;
        if (this.aQ == null || !this.aE) {
            long j2;
            ReactionInteractionTracker reactionInteractionTracker = this.aU;
            String str = this.aR;
            if (this.aQ == null) {
                j2 = 0;
            } else {
                j2 = this.aQ.f18665h;
            }
            long j3 = this.aL;
            if (this.aQ != null) {
                j = this.aQ.m22572s();
            }
            reactionInteractionTracker.m18935a(str, j2, j3, j);
            a();
            return;
        }
        if (this.aF) {
            this.aU.m18951e(this.an.now());
        } else {
            if (!ReactionSurfaceUtil.m4780g(this.aQ.f18660c)) {
                aw(this);
            }
            this.aF = true;
            this.aK = this.aJ;
            if (this.aD) {
                aB(this);
            }
        }
        if (this.au != null) {
            this.au.a();
        }
        this.aY.mo722m();
    }

    public final void m24757H() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1673506962);
        if (this.aE) {
            this.aP += this.an.now() - this.aJ;
            this.aY.mo721l();
        }
        super.H();
        this.aU.m18949d(this.an.now());
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1253297197, a);
    }

    public final void mY_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -843512664);
        super.mY_();
        ReactionReviewUpdateHandler reactionReviewUpdateHandler = (ReactionReviewUpdateHandler) this.at.get();
        reactionReviewUpdateHandler.f20739f.b(reactionReviewUpdateHandler.f20738e);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 139089053, a);
    }

    public final void m24758I() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 291796335);
        if (this.aQ != null) {
            this.az.m22619g(this.aQ.f18658a);
            this.aQ = null;
        }
        if (this.aY != null) {
            this.aY.mo723n();
            this.aY.jc_();
        }
        super.I();
        if (this.aE) {
            this.aU.m18926a((this.an.now() - this.aK) - this.aO, this.aP);
            this.aB.b(ReactionSequences.f18808a);
        }
        if (this.aV != null) {
            this.aV.c();
        }
        if (this.aW != null) {
            this.aW.c();
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1960570807, a);
    }

    public final void m24762a(int i, int i2, Intent intent) {
        if (i == UnitInteractionType.WRITE_REVIEW_TAP.ordinal() && i2 == -1) {
            String stringExtra = intent.getStringExtra("reaction_unit_id");
            if (stringExtra == null || this.aQ == null || this.aQ.f18681x == null || this.aQ.f18681x.getString("place_id") == null || TextUtils.isEmpty(this.aQ.f18681x.getString("place_id"))) {
                this.ap.b(aC, "WRITE_REVIEW_TAP should have value for EXTRA_REACTION_UNIT_ID and PLACE_ID in the return intent");
                return;
            }
            ((ReactionReviewUpdateHandler) this.at.get()).m24390a(i2, intent, am_(), stringExtra, this, Long.valueOf(Long.parseLong(this.aQ.f18681x.getString("place_id"))), null);
        } else if (i == UnitInteractionType.PLACE_TIPS_HIDE_TAP.ordinal()) {
            if (intent == null || !intent.getBooleanExtra("gravity_undo_hide_place_tips", false)) {
                ((PagePresenceManager) this.as.get()).a(PresenceSourceType.FORCE_OFF);
                a();
            }
        } else if (i == 1756 && i2 == -1 && intent != null) {
            PublishPostParams publishPostParams = (PublishPostParams) intent.getParcelableExtra("publishPostParams");
            if (!(publishPostParams == null || Strings.isNullOrEmpty(publishPostParams.composerSessionId))) {
                this.az.m22611a(publishPostParams.composerSessionId, getSessionId());
            }
            if (this.s.getBoolean("handle_composer_publish", false)) {
                if (!(publishPostParams == null || Strings.isNullOrEmpty(publishPostParams.composerSessionId))) {
                    this.az.m22608a(publishPostParams.composerSessionId);
                }
                ((ComposerPublishServiceHelper) this.ar.get()).c(intent);
            }
        }
    }

    public final boolean kq_() {
        return this.aH;
    }

    public final void kp_() {
        m24755i(this, true);
        m24754h(this, false);
    }

    public final void mo727a(String str, Optional<PendingStory> optional) {
        this.bb.m24415a(str, (Optional) optional);
    }

    public final void mo726a(ReactionStories reactionStories) {
        m24749b(reactionStories);
        if (this.ba.o == null) {
            as();
            if (this.y) {
                aq();
                return;
            }
            return;
        }
        this.aY.mo710a(reactionStories);
    }

    public void onConfigurationChanged(Configuration configuration) {
        this.aY.mo708a(configuration);
    }

    public final void kr_() {
        this.aY.notifyDataSetChanged();
        ReactionInteractionTracker reactionInteractionTracker = this.aU;
        reactionInteractionTracker.f16105j.c(1966084, reactionInteractionTracker.f16107l.f18658a);
        ReactionAnalyticsLogger reactionAnalyticsLogger = reactionInteractionTracker.f16102g;
        String str = reactionInteractionTracker.f16107l.f18658a;
        Surface surface = reactionInteractionTracker.f16107l.f18660c;
        int i = reactionInteractionTracker.f16104i;
        reactionAnalyticsLogger.f18800a.c(ReactionAnalyticsLogger.m22811a(Event.REACTION_PAGE_ERROR, str, "reaction_overlay", surface).a("page_number", i).b("error", reactionInteractionTracker.f16107l.f18663f));
    }

    public final void kQ_() {
        this.aH = false;
        as();
        if (this.y) {
            aq();
        }
    }

    public final void m24761a() {
        Activity an = this.s.getBoolean("close_activity_after_finish", false) ? an() : null;
        super.a();
        if (an != null) {
            an.finish();
        }
    }

    public final boolean mo728a(ReactionUnitFragment reactionUnitFragment, String str, CardSearchType cardSearchType) {
        return this.aY.mo712a(reactionUnitFragment, str, cardSearchType);
    }

    public final boolean mo729a(String str, CardSearchType cardSearchType) {
        return this.aY.mo713a(str, cardSearchType);
    }

    @Nullable
    public final ReactionUnitFragment mo725a(String str) {
        return null;
    }

    private void m24750b(@Nullable String str) {
        this.aU = this.ax.m22880a(this.aQ, this.aZ);
        if (!"SUCCESS".equals(str)) {
            this.aR = str;
        }
    }

    private void as() {
        this.aE = false;
        if (this.aQ == null) {
            m24750b("NO_SESSION");
            return;
        }
        Object obj;
        Surface surface = this.aQ.f18660c;
        if (ReactionSurfaceUtil.m4789u(surface) || ReactionSurfaceUtil.m4780g(surface) || surface == Surface.ANDROID_APP_INSTALL) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj != null) {
            boolean z = m24746a(this.aQ) && this.aY.mo711a(this.aQ);
            this.aE = z;
        } else {
            at();
        }
        if (this.aE) {
            if (!(this.aQ.f18676s == null || this.aQ.f18676s.c() == null)) {
                this.bb.m24413a(this.aQ.f18660c, this.aQ.f18676s.c().k());
            }
            if (ReactionWelcomeHeaderView.m24854a(this.aQ.f18676s)) {
                SequenceLoggerDetour.a(this.aX, OverlayDisplaySequence.f18805e, this.aQ.f18658a, null, 424971192);
                if (this.bc == null) {
                    this.bc = (ReactionWelcomeHeaderView) this.be.inflate();
                }
                this.aY.m12312a(this.bc, getContext());
                AbstractReactionRecyclerViewAdapter abstractReactionRecyclerViewAdapter = this.aY;
                abstractReactionRecyclerViewAdapter.f10464j.f21177a = abstractReactionRecyclerViewAdapter.m12308a(getContext());
                this.bc.m24800a();
                this.bc.m24871a(this, this.aU, this.aQ.f18660c, this.aQ.f18676s);
                this.ba.setPadding(this.ba.getPaddingLeft(), 0, this.ba.getPaddingRight(), this.ba.getPaddingBottom());
                SequenceLoggerDetour.b(this.aX, OverlayDisplaySequence.f18805e, this.aQ.f18658a, null, 387893984);
                LayoutParams layoutParams = this.bd.getLayoutParams();
                layoutParams.height = jW_().getDimensionPixelSize(2131431393);
                this.bd.setLayoutParams(layoutParams);
                this.bd.setBackgroundResource(2131363367);
                this.aG = this.bc.f21243e;
                aC();
            }
            this.ba.setAdapter(this.aY);
            m24755i(this, false);
            m24754h(this, false);
            if (ReactionSurfaceUtil.m4779e(this.aQ.f18660c) || m24751b(getContext())) {
                this.aD = true;
            } else {
                this.ba.setLayoutAnimation(new LayoutAnimationController(AnimationUtils.loadAnimation(getContext(), 2130968717)));
                this.ba.setLayoutAnimationListener(new C22352(this));
            }
        } else if (this.aR == null) {
            this.aR = "NO_VALID_ADAPTERS";
        }
    }

    private boolean m24746a(ReactionSession reactionSession) {
        if (reactionSession == null || !reactionSession.m22577z()) {
            m24750b("ERROR_INVALID_RESPONSE");
            return false;
        }
        m24749b(reactionSession.m22564h());
        if (reactionSession.m22546A()) {
            m24750b("SUCCESS");
            return true;
        }
        m24750b("NO_UNITS_RETURNED");
        return false;
    }

    private void at() {
        m24750b("UNSUPPORTED_SURFACE");
    }

    private void m24749b(@Nullable ReactionStories reactionStories) {
        Preconditions.checkNotNull(this.aQ);
        String d = reactionStories == null ? null : reactionStories.d();
        if (!this.aQ.f18658a.equals(d)) {
            ReactionAnalyticsLogger reactionAnalyticsLogger = this.aw;
            Surface surface = this.aQ.f18660c;
            String str = this.aQ.f18658a;
            reactionAnalyticsLogger.f18800a.c(ReactionAnalyticsLogger.m22811a(Event.REACTION_OVERLAY_ERROR, str, "reaction_overlay", surface).b("error", "SESSION_ID_MISMATCH").b("error_message", "Expected: " + str + " Actual: " + d));
        }
    }

    public static boolean m24751b(Context context) {
        return context == null || ((context instanceof ContextWrapper) && ((ContextWrapper) context).getBaseContext() == null);
    }

    private long av() {
        if (!ReactionSurfaceUtil.m4780g(this.aQ.f18660c)) {
            return this.aJ;
        }
        if (this.aI > 0) {
            return this.aI;
        }
        aw(this);
        return this.an.now();
    }

    public static void aw(ReactionDialogFragment reactionDialogFragment) {
        if (reactionDialogFragment.aQ != null && !Strings.isNullOrEmpty(reactionDialogFragment.aQ.f18658a)) {
            reactionDialogFragment.av.b(1966082, reactionDialogFragment.aQ.f18658a.hashCode(), (short) 2);
        }
    }

    private void aA() {
        final float dimension = jW_().getDimension(2131431444);
        aC();
        m24748b(1.0f);
        this.ba.setOnScrollListener(new FrameRateRecyclerViewScrollListener(this, this.aT) {
            final /* synthetic */ ReactionDialogFragment f21129b;

            public final void m24740a(RecyclerView recyclerView, int i, int i2) {
                long now = this.f21129b.an.now();
                if (i2 > 0 && this.f21129b.aU.f16108m) {
                    this.f21129b.aU.m18948c((now - this.f21129b.aJ) + this.f21129b.aP);
                }
                this.f21129b.aU.m18924a(now);
                ReactionDialogFragment.m24744a(this.f21129b, dimension);
                ReactionDialogFragment reactionDialogFragment = this.f21129b;
                if (reactionDialogFragment.aY.mo718f(reactionDialogFragment.aZ.n() - reactionDialogFragment.aY.m12321f()) >= reactionDialogFragment.aY.mo718f(reactionDialogFragment.aY.mo715d()) - 5) {
                    reactionDialogFragment.aY.m12324h();
                }
            }
        });
    }

    public static void m24744a(ReactionDialogFragment reactionDialogFragment, float f) {
        if (reactionDialogFragment.bc != null) {
            reactionDialogFragment.m24753d(f);
        } else {
            reactionDialogFragment.m24752c(f);
        }
    }

    public static void aB(ReactionDialogFragment reactionDialogFragment) {
        reactionDialogFragment.aU.m18927a(reactionDialogFragment.aQ.m22566k(), reactionDialogFragment.aL, reactionDialogFragment.aQ.m22572s(), reactionDialogFragment.aQ.m22571r(), reactionDialogFragment.an.now(), reactionDialogFragment.av() - reactionDialogFragment.aQ.m22576x());
    }

    public static void m24754h(ReactionDialogFragment reactionDialogFragment, boolean z) {
        m24742a(reactionDialogFragment.bf, z);
    }

    public static void m24755i(ReactionDialogFragment reactionDialogFragment, boolean z) {
        m24742a(reactionDialogFragment.bg, z);
    }

    private void aC() {
        if (this.bd != null && this.bd.getVisibility() != 8) {
            this.bd.setAlpha(this.aG ? 1.0f : 0.0f);
        }
    }

    private static void m24742a(@Nullable View view, boolean z) {
        if (view != null) {
            view.setVisibility(z ? 0 : 8);
        }
    }

    private void m24748b(float f) {
        if (this.bc != null) {
            this.bc.setAlpha(f);
        }
    }

    private void m24741a(int i, boolean z, float f) {
        float f2 = 1.0f;
        View f3 = this.aZ.f(i);
        if (z && f3 != null) {
            f2 = Math.min(Math.max((f - ((float) f3.getTop())) / f, 0.0f), 1.0f);
        }
        if (!this.aG) {
            this.bd.setAlpha(f2);
        }
        this.bb.setPlaceNameTitleAlpha(f2);
    }

    private void m24752c(float f) {
        boolean z;
        if (this.aY.mo718f(this.aZ.l()) == 0) {
            z = true;
        } else {
            z = false;
        }
        m24741a(0, z, f);
    }

    private void m24753d(float f) {
        boolean z = false;
        int l = this.aZ.l();
        int i = this.aY.m12325i();
        View f2 = this.aZ.f(0);
        if (l < i) {
            z = true;
        }
        if (!z || f2 == null) {
            m24748b(0.0f);
        } else {
            m24748b(1.0f);
            this.bc.m24870a((float) f2.getTop());
        }
        m24741a(i, z, f);
    }
}
