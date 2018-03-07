package com.facebook.feed.fragment.controllercallbacks;

import android.content.Context;
import android.view.View;
import com.facebook.api.feed.data.collections.ListItemCollection;
import com.facebook.api.feedtype.FeedType;
import com.facebook.api.feedtype.FeedType.Name;
import com.facebook.base.fragment.FbFragment;
import com.facebook.controllercallbacks.api.BaseController;
import com.facebook.controllercallbacks.api.Holder;
import com.facebook.controllercallbacks.fragment.ViewCreatedDestroyedCallbacks;
import com.facebook.feed.fragment.NewsFeedFragment;
import com.facebook.feed.fragment.generatedenvironments.NewsFeedEnvironmentGenerated;
import com.facebook.feed.fragment.generatedenvironments.NewsFeedEnvironmentGeneratedProvider;
import com.facebook.feed.inlinecomposer.multirow.InlineComposerMultiRowInjectedFeedAdapter;
import com.facebook.feed.logging.FeedUnitHeightTrackerProvider;
import com.facebook.feed.megaphone.MegaphoneController;
import com.facebook.feed.perf.FeedPerfLogger;
import com.facebook.feed.rows.FeedAdapterFactory;
import com.facebook.feed.rows.adapter.api.HasMultiRow;
import com.facebook.feed.rows.prefetch.MultiRowImagePrefetcherWrapper;
import com.facebook.feed.topicfeeds.customization.TopicFeedsCustomizationModule.C04411;
import com.facebook.feed.ui.NewsFeedRecyclerViewAdapterWrapper;
import com.facebook.feed.ui.NewsFeedRecyclerViewProxy;
import com.facebook.feed.ui.PaddingAdapter;
import com.facebook.feed.workingrange.listeners.HideableUnitWorkingRangeListener;
import com.facebook.feed.workingrange.rows.FeedRangesController;
import com.facebook.feed.workingrange.rows.FeedRangesExperiments;
import com.facebook.feed.workingrange.rows.FeedRangesInternalListeners;
import com.facebook.feed.workingrange.rows.NewsFeedPrefixCounter;
import com.facebook.feedplugins.placetips.PlaceTipsInjectedFeedAdapter;
import com.facebook.goodwill.dailydialogue.adapter.DailyDialogueInjectedFeedAdapter;
import com.facebook.graphql.model.FeedEdge;
import com.facebook.graphql.model.GraphQLExploreFeed;
import com.facebook.inject.Assisted;
import com.facebook.perf.StartupPerfLogger;
import com.facebook.qe.api.QeAccessor;
import com.facebook.tools.dextr.runtime.detour.TracerDetour;
import com.facebook.ultralight.Inject;
import com.facebook.widget.listview.WorkingRangeScrollableImpl;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;

/* compiled from: onRebind called. action */
public class NewsFeedAdapterConfiguration extends BaseController implements ViewCreatedDestroyedCallbacks {
    private final InlineComposerMultiRowInjectedFeedAdapter f11093a;
    private final DailyDialogueInjectedFeedAdapter f11094b;
    private final MegaphoneController f11095c;
    private final C04411 f11096d;
    private final PlaceTipsInjectedFeedAdapter f11097e;
    private final GoodFriendsCustomizationHeaderController f11098f;
    private final FeedUnitHeightTrackerProvider f11099g;
    private final TailLoaderController f11100h;
    private final FeedRangesController f11101i;
    private final FeedAdapterFactory f11102j;
    private final QeAccessor f11103k;
    public final NewsFeedEnvironmentGeneratedProvider f11104l;
    public final NewsFeedViewController f11105m;
    private final StartupPerfLogger f11106n;
    private final FeedPerfLogger f11107o;
    public final MultiRowImagePrefetcherWrapper f11108p;
    private final HideableUnitWorkingRangeListener f11109q;
    public FeedType f11110r;
    public Holder<ListItemCollection<FeedEdge>> f11111s;
    public Context f11112t;
    public NewsFeedEnvironmentGenerated f11113u;
    public Holder<FbFragment> f11114v;

    /* compiled from: onRebind called. action */
    public class C05151 implements Runnable {
        final /* synthetic */ NewsFeedFragment f12256a;
        final /* synthetic */ NewsFeedAdapterConfiguration f12257b;

        public C05151(NewsFeedAdapterConfiguration newsFeedAdapterConfiguration, NewsFeedFragment newsFeedFragment) {
            this.f12257b = newsFeedAdapterConfiguration;
            this.f12256a = newsFeedFragment;
        }

        public void run() {
            this.f12256a.m13875a(true);
        }
    }

    /* compiled from: onRebind called. action */
    public class C05182 implements Runnable {
        final /* synthetic */ NewsFeedFragment f12264a;
        final /* synthetic */ NewsFeedAdapterConfiguration f12265b;

        public C05182(NewsFeedAdapterConfiguration newsFeedAdapterConfiguration, NewsFeedFragment newsFeedFragment) {
            this.f12265b = newsFeedAdapterConfiguration;
            this.f12264a = newsFeedFragment;
        }

        public void run() {
            this.f12264a.mo1901e();
        }
    }

    public final HasMultiRow m16444a() {
        TracerDetour.a("NewsFeedAdapterConfiguration.createAdapter", -745045319);
        try {
            NewsFeedRecyclerViewProxy b = this.f11105m.m15491b();
            this.f11106n.m3458h(this.f11107o.m3360d(this.f11110r), this.f11107o.m3344a("FeedAdapterInit", this.f11110r));
            Name c = this.f11110r.m8963c();
            Builder builder = ImmutableList.builder();
            if (this.f11110r.m8963c().equals(Name.f5056k)) {
                builder.m1069c(this.f11096d.m15470a((GraphQLExploreFeed) this.f11110r.m8962b()));
            }
            if (c.equals(Name.f5048c)) {
                builder.m1069c(this.f11098f.m15475b());
            }
            if (c.equals(Name.f5046a)) {
                builder.m1069c(this.f11095c.m15350c());
            }
            builder.m1069c(new PaddingAdapter());
            if (c.equals(Name.f5046a) || c.equals(Name.f5056k) || c.equals(Name.f5048c)) {
                builder.m1069c(this.f11093a.m15270b());
            }
            if (c.equals(Name.f5046a)) {
                builder.m1069c(this.f11097e.m15472a());
                builder.m1069c(this.f11094b.m15332c(b));
            }
            NewsFeedRecyclerViewAdapterWrapper a = NewsFeedRecyclerViewAdapterWrapper.m20008a(builder.m1068b(), this.f11102j.m16449a((ListItemCollection) this.f11111s.m15526b(), b, this.f11113u, FeedRangesExperiments.m19960a(this.f11103k) ? this.f11101i : null), ImmutableList.of(this.f11100h.m15477c()), b, this.f11099g);
            m16443a(a);
            a.notifyDataSetChanged();
            this.f11106n.m3459i(this.f11107o.m3360d(this.f11110r), this.f11107o.m3344a("FeedAdapterInit", this.f11110r));
            b.m18037a(a);
            return a;
        } finally {
            TracerDetour.a(1609003668);
        }
    }

    @Inject
    public NewsFeedAdapterConfiguration(NewsFeedEnvironmentGeneratedProvider newsFeedEnvironmentGeneratedProvider, QeAccessor qeAccessor, FeedAdapterFactory feedAdapterFactory, FeedRangesController feedRangesController, FeedUnitHeightTrackerProvider feedUnitHeightTrackerProvider, StartupPerfLogger startupPerfLogger, FeedPerfLogger feedPerfLogger, HideableUnitWorkingRangeListener hideableUnitWorkingRangeListener, @Assisted InlineComposerMultiRowInjectedFeedAdapter inlineComposerMultiRowInjectedFeedAdapter, @Assisted DailyDialogueInjectedFeedAdapter dailyDialogueInjectedFeedAdapter, @Assisted MegaphoneController megaphoneController, @Assisted C04411 c04411, @Assisted PlaceTipsInjectedFeedAdapter placeTipsInjectedFeedAdapter, @Assisted GoodFriendsCustomizationHeaderController goodFriendsCustomizationHeaderController, @Assisted TailLoaderController tailLoaderController, @Assisted NewsFeedViewController newsFeedViewController, @Assisted MultiRowImagePrefetcherWrapper multiRowImagePrefetcherWrapper) {
        this.f11106n = startupPerfLogger;
        this.f11107o = feedPerfLogger;
        this.f11103k = qeAccessor;
        this.f11104l = newsFeedEnvironmentGeneratedProvider;
        this.f11102j = feedAdapterFactory;
        this.f11101i = feedRangesController;
        this.f11099g = feedUnitHeightTrackerProvider;
        this.f11096d = c04411;
        this.f11100h = tailLoaderController;
        this.f11093a = inlineComposerMultiRowInjectedFeedAdapter;
        this.f11094b = dailyDialogueInjectedFeedAdapter;
        this.f11095c = megaphoneController;
        this.f11097e = placeTipsInjectedFeedAdapter;
        this.f11098f = goodFriendsCustomizationHeaderController;
        this.f11105m = newsFeedViewController;
        this.f11109q = hideableUnitWorkingRangeListener;
        this.f11108p = multiRowImagePrefetcherWrapper;
    }

    private void m16443a(NewsFeedRecyclerViewAdapterWrapper newsFeedRecyclerViewAdapterWrapper) {
        if (FeedRangesExperiments.m19960a(this.f11103k)) {
            this.f11101i.f11131k = new NewsFeedPrefixCounter(newsFeedRecyclerViewAdapterWrapper);
            if (FeedRangesExperiments.m19961b(this.f11103k)) {
                FeedRangesController feedRangesController = this.f11101i;
                feedRangesController.f11125e.f11134b.put(this.f11109q, Boolean.TRUE);
            }
        }
    }

    public final void mo1886a(View view) {
    }

    public final void kG_() {
        if (FeedRangesExperiments.m19960a(this.f11103k)) {
            FeedRangesController feedRangesController = this.f11101i;
            Preconditions.checkState(feedRangesController.f11129i, "Must have registered listeners before calling unregisterListeners");
            FeedRangesInternalListeners feedRangesInternalListeners = feedRangesController.f11130j;
            WorkingRangeScrollableImpl workingRangeScrollableImpl = feedRangesInternalListeners.a;
            workingRangeScrollableImpl.b.remove(feedRangesInternalListeners.e);
            if (feedRangesInternalListeners.c) {
                feedRangesInternalListeners.b.mo2641b(feedRangesInternalListeners.g);
            } else {
                feedRangesInternalListeners.b.mo2227b(feedRangesInternalListeners.f);
            }
        }
    }
}
